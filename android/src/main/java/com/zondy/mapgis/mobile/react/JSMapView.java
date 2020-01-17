package com.zondy.mapgis.mobile.react;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.net.Uri;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.ThemedReactContext;
import com.zondy.mapgis.android.annotation.AnnotationsOverlay;
import com.zondy.mapgis.android.graphic.Graphic;
import com.zondy.mapgis.android.graphic.GraphicsOverlay;
import com.zondy.mapgis.android.graphic.GraphicsOverlays;
import com.zondy.mapgis.android.mapview.MagnifierOption;
import com.zondy.mapgis.android.mapview.MapPosition;
import com.zondy.mapgis.android.mapview.MapView;
import com.zondy.mapgis.android.mapview.MapView.MapViewAnimationCallback;
import com.zondy.mapgis.android.model.Model;
import com.zondy.mapgis.android.model.ModelsOverlay;
import com.zondy.mapgis.core.geometry.Dot;
import com.zondy.mapgis.core.geometry.Dots;
import com.zondy.mapgis.core.geometry.Rect;
import com.zondy.mapgis.core.map.Document;
import com.zondy.mapgis.core.map.MapLayer;
import com.zondy.mapgis.core.map.SimpleModelLayer;
import com.zondy.mapgis.mobile.react.utils.ConvertUtil;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author fjl 2019-6-16 下午2:52:36
 * @content 地图视图组件
 */
public class JSMapView extends ReactContextBaseJavaModule {
    private static MapView              curMapView = null;
    private static Map<String, MapView> mapViewList = new HashMap<String, MapView>();
    Context                             m_Context = null;
    MapView                             m_mapView;
    ReactContext                        mReactContext;
    /**
     * 手机sdcard路径
     **/
    private static final String TEMP_FILE_PREFIX = "MapViewImage";

    @Override
    public String getName() {
        return "JSMapView";
    }

    public JSMapView(ReactApplicationContext reactContext) {
        super(reactContext);
        m_Context = reactContext.getApplicationContext();
        mReactContext = reactContext;
    }

    /**
     * 提供给MapView视图组件用于创建MapView实例的方法。
     *
     * @param reactContext
     * @return {object} MapView
     */
    public static MapView createInstance(ThemedReactContext reactContext) {
        curMapView = new MapView(reactContext.getBaseContext());
        return curMapView;
    }

    /**
     * 在native层注册一个MapView的Id，并返回该ID供JS层调用；
     * 注册前先判断该MapView是否已经存在，如果存在，返回已经存在的ID，如果不存在，创建新的ID以返回。
     *
     * @param mapView
     * @return {}
     */
    public static String registerId(MapView mapView) {
        for (Map.Entry entry : mapViewList.entrySet()) {
            if (mapView.equals(entry.getValue())) {
                return (String) entry.getKey();
            }
        }
        String id = UUID.randomUUID().toString().substring(24);
        mapViewList.put(id, mapView);
        System.out.print(id);
        return id;
    }

    /**
     * 根据ID获得MapView实例
     *
     * @param id
     * @return
     */
    public static MapView getObjById(String id) {
        return mapViewList.get(id);
    }

    @ReactMethod
    public void setBackGroundColor(String mapViewId, String color, Promise promise) {
        try {
            MapView mapView = mapViewList.get(mapViewId);
            mapView.setBackGroundColor(ConvertUtil.ColorRGBAToInt(color));
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getBackGroundColor(String mapViewId, Promise promise) {
        try {
            m_mapView = mapViewList.get(mapViewId);
            int color = m_mapView.getBackGroundColor();
            String strColor = ConvertUtil.ColorIntToRGBA(color);

            WritableMap map = Arguments.createMap();
            map.putString("color", strColor);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setBackGroundImage(String mapViewId, String imageId, Promise promise) {
        try {
            m_mapView = mapViewList.get(mapViewId);
            Bitmap imageBitmap = null;
            if (imageId != null) {
                imageBitmap = JSImage.getObjFromList(imageId);
            }
            m_mapView.setBackGroundImage(imageBitmap);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    class BackGroundImageThread implements Runnable {

        private String mapViewId;
        private int width;
        private int height;
        private int quality;
        private String type;
        private Promise promise;

        public BackGroundImageThread(String mapViewId, int width, int height, int quality, String type, Promise promise) {
            this.mapViewId = mapViewId;
            this.width = width;
            this.height = height;
            this.quality = quality;
            this.type = type;
            this.promise = promise;
        }

        @Override
        public void run() {
            try {
                m_mapView = mapViewList.get(mapViewId);
                int imgHeight = height;
                int imgWidth = width;

                if (!mapViewId.equals("")) {
                    imgHeight = m_mapView.getHeight();
                    imgWidth = m_mapView.getWidth();
                }
                Bitmap bitmap = Bitmap.createBitmap(imgWidth, imgHeight, Bitmap.Config.ARGB_8888);
                m_mapView.setBackGroundImage(bitmap);
                File externalCacheDir = getReactApplicationContext().getExternalCacheDir();
                File internalCacheDir = getReactApplicationContext().getCacheDir();
                File cacheDir;
                if (externalCacheDir == null && internalCacheDir == null) {
                    throw new IOException("No cache directory available");
                }
                if (externalCacheDir == null) {
                    cacheDir = internalCacheDir;
                } else if (internalCacheDir == null) {
                    cacheDir = externalCacheDir;
                } else {
                    cacheDir = externalCacheDir.getFreeSpace() > internalCacheDir.getFreeSpace() ?
                            externalCacheDir : internalCacheDir;
                }
                String suffix = ".png";
                File bitmapFile = File.createTempFile(TEMP_FILE_PREFIX, suffix, cacheDir);

                Bitmap.CompressFormat compressFormat;
                switch (type) {
                    case "jpeg":
                    case "jpg":
                        compressFormat = Bitmap.CompressFormat.JPEG;
                        break;
                    case "webp":
                        compressFormat = Bitmap.CompressFormat.WEBP;
                        break;
                    case "png":
                    default:
                        compressFormat = Bitmap.CompressFormat.PNG;
                        break;
                }
                FileOutputStream fos = new FileOutputStream(bitmapFile);
                bitmap.compress(compressFormat, quality, fos);
                fos.flush();
                fos.close();
                String uri = Uri.fromFile(bitmapFile).toString();

                WritableMap map = Arguments.createMap();
                map.putString("uri", uri);
                promise.resolve(map);
            } catch (Exception e) {
                promise.reject(e);
            }
        }
    }

    /**
     * 加载地图
     *
     * @param mapViewId
     * @param strMapPath
     * @param promise
     */
    @ReactMethod
    public void loadFromFile(String mapViewId, String strMapPath, Promise promise) {
        try {
            m_mapView = mapViewList.get(mapViewId);
//            com.zondy.mapgis.android.environment.Environment.requestAuthorization(m_mapView.getContext(),new com.zondy.mapgis.android.environment.Environment.AuthorizeCallback()
//            {
//                @Override
//                public void onComplete() {
//                }
//            });
            int result = (int) m_mapView.loadFromFile(strMapPath);
            promise.resolve(result);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void loadFromFileAsync(String mapViewId, String strMapPath, Promise promise)
    {
        try {
            m_mapView = mapViewList.get(mapViewId);

            m_mapView.loadFromFileAsync(strMapPath);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void loadFromDocument(String mapViewId, String docId, int indexOfMap, Promise promise)
    {
        try {
            m_mapView = mapViewList.get(mapViewId);
            Document doc = JSDocument.getObjFromList(docId);
            m_mapView.loadFromDocument(doc, indexOfMap);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void loadFromDocumentAsync(String mapViewId, String docId, int indexOfMap, final Promise promise)
    {
        try {
            m_mapView = mapViewList.get(mapViewId);
            Document doc = JSDocument.getObjFromList(docId);
            m_mapView.loadFromDocumentAsync(doc, indexOfMap, new MapView.MapViewFinishCallback()
            {
                @Override
                public void onDidFinish(boolean b) {
                    promise.resolve(b);
                }
            });
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setMap(String mapViewId, String mapId, Promise promise)
    {
        try {
            m_mapView = mapViewList.get(mapViewId);
            com.zondy.mapgis.core.map.Map map = JSMap.getObjFromList(mapId);
            m_mapView.setMap(map);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setMapAsync(String mapViewId, String mapId, final Promise promise)
    {
        try {
            m_mapView = mapViewList.get(mapViewId);
            com.zondy.mapgis.core.map.Map map = JSMap.getObjFromList(mapId);
            m_mapView.setMapAsync(map, new MapView.MapViewFinishCallback() {
                @Override
                public void onDidFinish(boolean b) {
                    promise.resolve(b);
                }
            });
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getMap(String mapViewId, Promise promise) {
        try {
            m_mapView = mapViewList.get(mapViewId);
            int color = m_mapView.getBackGroundColor();
            String strColor = ConvertUtil.ColorIntToRGBA(color);

            com.zondy.mapgis.core.map.Map Map = m_mapView.getMap();
            String mapID = JSMap.registerId(Map);
            WritableMap map = Arguments.createMap();

            map.putString("mapID", mapID);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void refresh(String mapViewId, Promise promise) {
        try {
            m_mapView = mapViewList.get(mapViewId);
            m_mapView.refresh();
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void forceRefresh(String mapViewId, Promise promise) {
        try {
            m_mapView = mapViewList.get(mapViewId);
            m_mapView.forceRefresh();
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void stopCurRequest(String mapViewId, final Promise promise)
    {
        try {
            m_mapView = mapViewList.get(mapViewId);
            m_mapView.stopCurRequest(new MapView.MapViewStopCurRequestCallback() {
                @Override
                public void onDidStopCurRequest() {
                    promise.resolve(true);
                }
            });
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void mapPointToViewPoint(String mapViewId, String dotID, Promise promise) {
        try {
            m_mapView = mapViewList.get(mapViewId);
            Dot dot = JSDot.getObjFromList(dotID);
            PointF pointf = m_mapView.mapPointToViewPoint(dot);

            String pointFId = JSPointF.registerId(pointf);
            WritableMap map = Arguments.createMap();
            map.putString("pointFId", pointFId);
            map.putDouble("x", pointf.x);
            map.putDouble("y", pointf.y);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void viewPointToMapPoint(String mapViewId, String pointFID, Promise promise) {
        try {
            m_mapView = mapViewList.get(mapViewId);
            PointF pointf = JSPointF.getObjFromList(pointFID);
            Dot dot = m_mapView.viewPointToMapPoint(pointf);

            String dotID = JSDot.registerId(dot);
            WritableMap map = Arguments.createMap();
            map.putString("dotID", dotID);
            map.putDouble("x", dot.getX());
            map.putDouble("y", dot.getY());
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void mapPointToGLPoint(String mapViewId, String pointID, Promise promise)
    {
        try {
            m_mapView = mapViewList.get(mapViewId);
            Dot pointf = JSDot.getObjFromList(pointID);
            Dot glPoint = m_mapView.mapPointToGLPoint(pointf);

            String dotID = JSDot.registerId(glPoint);
            WritableMap map = Arguments.createMap();
            map.putString("dotID", dotID);
            map.putDouble("x", glPoint.getX());
            map.putDouble("y", glPoint.getY());
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getResolution(String mapViewId, Promise promise) {
        try {
            m_mapView = mapViewList.get(mapViewId);
            double resolution = m_mapView.getResolution();

            WritableMap map = Arguments.createMap();
            map.putDouble("resolution", resolution);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getMaxResolution(String mapViewId, Promise promise) {
        try {
            m_mapView = mapViewList.get(mapViewId);
            double maxResolution = m_mapView.getMaxResolution();

            WritableMap map = Arguments.createMap();
            map.putDouble("maxResolution", maxResolution);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getMinResolution(String mapViewId, Promise promise)
    {
        try {
            m_mapView = mapViewList.get(mapViewId);
            double minResolution = m_mapView.getMinResolution();

            WritableMap map = Arguments.createMap();
            map.putDouble("minResolution", minResolution);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取地图的中心点
     *
     * @param mapViewId
     * @param promise
     */
    @ReactMethod
    public void getCenterPoint(String mapViewId, Promise promise) {
        try {
            MapView mapView = mapViewList.get(mapViewId);
            Dot centerDot = mapView.getCenterPoint();

            String dotId = JSDot.registerId(centerDot);
            WritableMap map = Arguments.createMap();
            map.putString("dotID", dotId);
            map.putDouble("x", centerDot.getX());
            map.putDouble("y", centerDot.getY());
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getDispRange(String mapViewId, Promise promise) {
        try {
            MapView mapView = mapViewList.get(mapViewId);
            Rect rect = mapView.getDispRange();

            String rectId = JSRect.registerId(rect);
            WritableMap map = Arguments.createMap();
            map.putString("rectId", rectId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }
    /**
     * 设置地图中心点
     *
     * @param mapViewId
     * @param mapCenterID
     * @param animated
     * @param promise
     */
    @ReactMethod
    public void panToCenter(String mapViewId, String mapCenterID, boolean animated, Promise promise) {
        try {
            MapView mapView = mapViewList.get(mapViewId);
            Dot point2D = JSDot.getObjFromList(mapCenterID);
            mapView.panToCenter(point2D, animated);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 设置地图中心点
     *
     * @param mapViewId
     * @param mapCenterID
     * @param viewCenterID
     * @param animated
     * @param promise
     */
    @ReactMethod
    public void panToCenterWithView(String mapViewId, String mapCenterID, String viewCenterID, boolean animated, Promise promise) {
        try {
            MapView mapView = mapViewList.get(mapViewId);
            Dot mapPoint2D = JSDot.getObjFromList(mapCenterID);
            PointF viewPoint2D = JSPointF.getObjFromList(viewCenterID);
            mapView.panToCenter(mapPoint2D, viewPoint2D, animated);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void moveMap(String mapViewId, float mx, float my, boolean animated, Promise promise) {
        try {
            MapView mapView = mapViewList.get(mapViewId);
            mapView.moveMap(mx, my, animated);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void zoomToCenter(String mapViewId, String mapCenterID, double resolution, boolean animated, Promise promise) {
        try {
            MapView mapView = mapViewList.get(mapViewId);
            Dot mapPoint2D = JSDot.getObjFromList(mapCenterID);
            mapView.zoomToCenter(mapPoint2D, resolution, animated);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void zoomToCenterWithView(String mapViewId, String mapCenterID, String viewCenterID, double resolution, boolean animated, Promise promise) {
        try {
            MapView mapView = mapViewList.get(mapViewId);
            Dot mapPoint2D = JSDot.getObjFromList(mapCenterID);
            PointF viewPoint2D = JSPointF.getObjFromList(viewCenterID);
            mapView.zoomToCenter(mapPoint2D, viewPoint2D, resolution, animated);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void zoomToRange(String mapViewId, String dispRange, boolean animated, Promise promise) {
        try {
            MapView mapView = mapViewList.get(mapViewId);
            Rect rect = JSRect.getObjFromList(dispRange);
            mapView.zoomToRange(rect, animated);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void zoomIn(String mapViewId, boolean animated, Promise promise) {
        try {
            MapView mapView = mapViewList.get(mapViewId);
            mapView.zoomIn(animated);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void zoomOut(String mapViewId, boolean animated, Promise promise) {
        try {
            MapView mapView = mapViewList.get(mapViewId);
            mapView.zoomOut(animated);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void restore(String mapViewId, boolean animated, Promise promise) {
        try {
            MapView mapView = mapViewList.get(mapViewId);
            mapView.restore(animated);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setRotateCenterAndAngle(String mapViewId, String rotateCenter, float rotateAngle, boolean animated, Promise promise) {
        try {
            MapView mapView = mapViewList.get(mapViewId);
            Dot dot = JSDot.getObjFromList(rotateCenter);
            mapView.setRotateCenterAndAngle(dot, rotateAngle, animated);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }
    @ReactMethod
    public void setRotateCenter(String mapViewId, String rotateCenter, Promise promise)
    {
        try {
            MapView mapView = mapViewList.get(mapViewId);
            Dot dot = JSDot.getObjFromList(rotateCenter);
            mapView.setRotateCenter(dot);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setRotateAngle(String mapViewId, float rotateAngle, boolean animated, Promise promise) {
        try {
            MapView mapView = mapViewList.get(mapViewId);
            mapView.setRotateAngle(rotateAngle, animated);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void rotate(String mapViewId, float rotation, float pivotX, float pivotY, boolean animated, Promise promise) {
        try {
            MapView mapView = mapViewList.get(mapViewId);
            mapView.rotate(rotation, pivotX, pivotY, animated);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getRotateCenter(String mapViewId, Promise promise) {
        try {
            MapView mapView = mapViewList.get(mapViewId);
            Dot centerDot = mapView.getRotateCenter();

            String dotId = JSDot.registerId(centerDot);
            WritableMap map = Arguments.createMap();
            map.putString("dotID", dotId);
            map.putDouble("x", centerDot.getX());
            map.putDouble("y", centerDot.getY());
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getRotateAngle(String mapViewId, Promise promise) {
        try {
            m_mapView = mapViewList.get(mapViewId);
            double rotateAngle = m_mapView.getRotateAngle();

            WritableMap map = Arguments.createMap();
            map.putDouble("rotateAngle", rotateAngle);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setSlopeAngle(String mapViewId, float slopeAngle, Boolean animated, Promise promise) {
        try {
            MapView mapView = mapViewList.get(mapViewId);
            mapView.setSlopeAngle(slopeAngle, animated);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getSlopeAngle(String mapViewId, Promise promise) {
        try {
            m_mapView = mapViewList.get(mapViewId);
            double slopeAngle = m_mapView.getSlopeAngle();

            WritableMap map = Arguments.createMap();
            map.putDouble("slopeAngle", slopeAngle);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void updatePosition(String mapViewId,String postionID,Boolean animated, Promise promise) {
        try {
            m_mapView = mapViewList.get(mapViewId);
            MapPosition mapPosition = JSMapPosition.getObjFromList(postionID);
            m_mapView.updatePosition(mapPosition,animated);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void updatePosition(String mapViewId, String postionID, String viewCenterPointID, Boolean animated, Promise promise)
    {
        try {
            m_mapView = mapViewList.get(mapViewId);
            MapPosition mapPosition = JSMapPosition.getObjFromList(postionID);
            PointF      viewCenterPoint = JSPointF.getObjFromList(viewCenterPointID);
            m_mapView.updatePosition(mapPosition,viewCenterPoint,animated);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void animatePosition(String mapViewId, String postionID, int duration, final Promise promise)
    {
        try {
            m_mapView = mapViewList.get(mapViewId);
            MapPosition mapPosition = JSMapPosition.getObjFromList(postionID);
            m_mapView.animatePosition(mapPosition, duration, new MapViewAnimationCallback() {

                @Override
                public void onAnimationFinish(boolean b) {
                    promise.resolve(b);
                }
            });
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void animatePositionByViewPoint(String mapViewId, String postionID, String viewCenterPointID, int duration, final Promise promise)
    {
        try {
            m_mapView = mapViewList.get(mapViewId);
            MapPosition mapPosition = JSMapPosition.getObjFromList(postionID);
            PointF      viewCenterPoint = JSPointF.getObjFromList(viewCenterPointID);
            m_mapView.animatePosition(mapPosition, viewCenterPoint, duration, new MapViewAnimationCallback() {
                @Override
                public void onAnimationFinish(boolean b) {
                    promise.resolve(b);
                }
            });
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void stopAnimation(String mapViewId, Promise promise) {
        try {
            m_mapView = mapViewList.get(mapViewId);
            m_mapView.stopAnimation();
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getPosition(String mapViewId, Promise promise) {
        try {
            MapView mapView = mapViewList.get(mapViewId);
            MapPosition mapPosition = mapView.getPosition();

            String dotId = JSMapPosition.registerId(mapPosition);
            WritableMap map = Arguments.createMap();
            map.putString("dotID", dotId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getAnnotationsOverlay(String mapViewId, Promise promise)
    {
        try {
            MapView mapView = mapViewList.get(mapViewId);
            AnnotationsOverlay graphicsOverlay = mapView.getAnnotationsOverlay();

            String AnnotationsOverlayId = JSAnnotationsOverlay.registerId(graphicsOverlay);
            WritableMap map = Arguments.createMap();
            map.putString("AnnotationsOverlayId", AnnotationsOverlayId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getGraphicsOverlay(String mapViewId, Promise promise) {
        try {
            MapView mapView = mapViewList.get(mapViewId);
            GraphicsOverlay graphicsOverlay = mapView.getGraphicsOverlay();

            String GraphicsOverlayId = JSGraphicsOverlay.registerId(graphicsOverlay);
            WritableMap map = Arguments.createMap();
            map.putString("GraphicsOverlayId", GraphicsOverlayId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getGraphicsOverlays(String mapViewId, Promise promise) {
        try {
            MapView mapView = mapViewList.get(mapViewId);
            GraphicsOverlays graphicsOverlays = mapView.getGraphicsOverlays();

            String GraphicsOverlaysId = JSGraphicsOverlays.registerId(graphicsOverlays);
            WritableMap map = Arguments.createMap();
            map.putString("GraphicsOverlaysId", GraphicsOverlaysId);

            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void graphicsOverlayHitTest(String mapViewId, String graphicsOverlayId, String viewPointId, Promise promise)
    {
         try {
            MapView mapView = mapViewList.get(mapViewId);
            GraphicsOverlay graphicsOverlay = JSGraphicsOverlay.getObjFromList(graphicsOverlayId);
            PointF          viewPoint = JSPointF.getObjFromList(viewPointId);
            Graphic graphic = mapView.graphicsOverlayHitTest(graphicsOverlay,viewPoint);

             String   strGraphicID = JSGraphic.registerId(graphic);
             WritableMap map = Arguments.createMap();
             map.putString("_MGGraphicId", strGraphicID);
             promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void graphicHitTest(String mapViewId, String graphicId, String viewPointId, Promise promise)
    {
        try {
            MapView mapView = mapViewList.get(mapViewId);
            Graphic graphic = JSGraphic.getObjFromList(graphicId);
            PointF          viewPoint = JSPointF.getObjFromList(viewPointId);
            Boolean isHit = mapView.graphicHitTest(graphic,viewPoint);
            promise.resolve(isHit);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getModelsOverlay(String mapViewId, Promise promise)
    {
        try {
            MapView mapView = mapViewList.get(mapViewId);
            ModelsOverlay modelsOverlay = mapView.getModelsOverlay();
            String   strModelsOverlayID = JSModelsOverlay.registerId(modelsOverlay);
            WritableMap map = Arguments.createMap();
            map.putString("ModelsOverlayId", strModelsOverlayID);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void modelsOverlayHitTest(String mapViewId, String viewPointId, Promise promise)
    {
        try {
            MapView mapView = mapViewList.get(mapViewId);
            PointF          viewPoint = JSPointF.getObjFromList(viewPointId);
            Model model = mapView.modelsOverlayHitTest(viewPoint);
            String   strModelID = JSModel.registerId(model);
            WritableMap map = Arguments.createMap();
            map.putString("ModelId", strModelID);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void modelLayerHitTest(String mapViewId, String modelLayerId, String viewPointId, Promise promise)
    {
        try {
            MapView mapView = mapViewList.get(mapViewId);
            MapLayer mapLayer = JSMapLayer.getObjFromList(modelLayerId);
            if (mapLayer instanceof SimpleModelLayer)
            {
                PointF          viewPoint = JSPointF.getObjFromList(viewPointId);
                Model model = mapView.modelLayerHitTest((SimpleModelLayer)mapLayer,viewPoint);
                String   strModelID = JSModel.registerId(model);
                WritableMap map = Arguments.createMap();
                map.putString("ModelId", strModelID);
                promise.resolve(map);
            }
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setMaxTextureCacheSize(String mapViewId, int size, Promise promise) {
        try {
            MapView mapView = mapViewList.get(mapViewId);
            mapView.setMaxTextureCacheSize(size);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getMaxTextureCacheSize(String mapViewId, Promise promise) {
        try {
            m_mapView = mapViewList.get(mapViewId);
            int MaxTextureCacheSize = m_mapView.getMaxTextureCacheSize();

            WritableMap map = Arguments.createMap();
            map.putInt("MaxTextureCacheSize", MaxTextureCacheSize);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void clearTextureCache(String mapViewId, Promise promise) {
        try {
            m_mapView = mapViewList.get(mapViewId);
            m_mapView.clearTextureCache();
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setSupportTransparency(String mapViewId, boolean support, Promise promise) {
        try {
            MapView mapView = mapViewList.get(mapViewId);
            mapView.setSupportTransparency(support);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void isSupportTransparency(String mapViewId, Promise promise) {
        try {
            m_mapView = mapViewList.get(mapViewId);
            boolean isSupportTransparency = m_mapView.isSupportTransparency();

            WritableMap map = Arguments.createMap();
            map.putBoolean("isSupportTransparency", isSupportTransparency);

            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    ///////////////////////////////////////////
    //MapTool如何处理？
    @ReactMethod
    public void setMapTool(String mapViewId, Promise promise)
    {
        try {
            m_mapView = mapViewList.get(mapViewId);
            MapViewMapTool mapTool = new MapViewMapTool(m_mapView, mReactContext);
            m_mapView.setMapTool(mapTool);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    // 获取测量宽度
    @ReactMethod
    public void getMeasuredWidth(String mapViewId, Promise promise){
        try {
            m_mapView = mapViewList.get(mapViewId);
            int measuredWidth = m_mapView.getMeasuredWidth();
            promise.resolve(measuredWidth);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    // 获取测量高度
    @ReactMethod
    public void getMeasuredHeight(String mapViewId, Promise promise){
        try {
            m_mapView = mapViewList.get(mapViewId);
            int height = m_mapView.getMeasuredHeight();
            promise.resolve(height);
        }catch (Exception e){
            promise.reject(e);
        }
    }
    // 获取视图宽度
    @ReactMethod
    public void getWidth(String mapViewId, Promise promise) {
        try {
            m_mapView = mapViewList.get(mapViewId);
            int width = m_mapView.getWidth();
            promise.resolve(width);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    // 获取视图高度
    @ReactMethod
    public void getHeight(String mapViewId, Promise promise){
        try {
            m_mapView = mapViewList.get(mapViewId);
            int height = m_mapView.getHeight();
            promise.resolve(height);
        } catch (Exception e){
            promise.reject(e);
        }
    }
    ////////////////////////////////
    @ReactMethod
    public void getScreenSnapshot(String mapViewId, final String path, final Promise promise)
    {
        try {
            m_mapView = mapViewList.get(mapViewId);
            m_mapView.getScreenSnapshot(new MapView.MapViewScreenSnapshotCallback() {
                @Override
                public void onScreenSnapshot(Bitmap bitmap) {
                   String bitmapPath = outputBitmapToLocal(path, "png", bitmap);

                    promise.resolve(bitmapPath);
                }

                @Override
                public void onScreenSnapshot(int left, int top, int width, int height, Bitmap bitmap) {
                }
            });
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getScreenSnapshotByParam(String mapViewId, final String path, int left, int top, int width, int height, final Promise promise)
    {
        try {
            m_mapView = mapViewList.get(mapViewId);
            m_mapView.getScreenSnapshot(left, top, width, height, new MapView.MapViewScreenSnapshotCallback() {
                @Override
                public void onScreenSnapshot(Bitmap bitmap)
                {
                }

                @Override
                public void onScreenSnapshot(int left, int top, int width, int height, Bitmap bitmap) {
                    String bitmapPath = outputBitmapToLocal(path, "png", bitmap);

                    WritableMap map = Arguments.createMap();
                    map.putInt("left", left);
                    map.putInt("top", top);
                    map.putInt("width", width);
                    map.putInt("height", height);
                    map.putString("bitmapPath", bitmapPath);
                    promise.resolve(map);
                }
            });
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getBitmap(String mapViewId, String dispRangeId, String path, int width, int height, String type, Promise promise)
    {
        try {
            Rect   dispRange = JSRect.getObjFromList(dispRangeId);

            Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            int  result = (int)m_mapView.getBitmap(dispRange, bitmap);

            String bitmapPath = "";
            if(result > 0){
                bitmapPath = outputBitmapToLocal(path, type, bitmap);
            }

            promise.resolve(bitmapPath);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     *  将Bitmap输出为File
     * @param path Bitmap存储的文件夹路径
     * @param type 图片类型
     * @param bitmap 输出的Bitmap
     * @return Bitmap保存的完整路径
     */
    private String outputBitmapToLocal(String path, String type, Bitmap bitmap){
        String bitmapPath = "";
        try {
            if(bitmap != null){
                String fileSuffix = "." + type;
                File dirFile = new File(path);
                if(!dirFile.exists()){
                    dirFile.mkdirs();
                }
                File bitmapFile = File.createTempFile(TEMP_FILE_PREFIX, fileSuffix.trim(), dirFile);
                FileOutputStream fos = new FileOutputStream(bitmapFile);
                BufferedOutputStream bos = new BufferedOutputStream(fos);
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, bos); // 不压缩
                bos.flush();
                fos.close();
                bos.close();

                bitmapPath = Uri.fromFile(bitmapFile).toString();
            }

            return bitmapPath;
        }catch (Exception e) {
            e.printStackTrace();
            return bitmapPath;
        }
    }

    @ReactMethod
    public void getCrossBitmap(String mapViewId, ReadableArray seg1Array, ReadableArray seg2Array, ReadableArray seg3Array, int width, int height, int quality, String type, Promise promise)
    {
        try {
            getCurrentActivity().runOnUiThread(new CrossBitmapThread(mapViewId, seg1Array, seg2Array, seg3Array, width, height, quality, type, promise));
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    class CrossBitmapThread implements Runnable {

        private String mapViewId;
        private ReadableArray seg1Array;
        private ReadableArray seg2Array;
        private ReadableArray seg3Array;
        private int width;
        private int height;
        private int quality;
        private String type;
        private Promise promise;

        public CrossBitmapThread(String mapViewId, ReadableArray seg1Array, ReadableArray seg2Array, ReadableArray seg3Array, int width, int height, int quality, String type, Promise promise) {
            this.mapViewId = mapViewId;
            this.seg1Array = seg1Array;
            this.seg2Array = seg2Array;
            this.seg3Array = seg3Array;
            this.width = width;
            this.height = height;
            this.quality = quality;
            this.type = type;
            this.promise = promise;
        }

        @Override
        public void run() {
            try {
                int imgHeight = height;
                int imgWidth = width;

                if (!mapViewId.equals("")) {
                    m_mapView = mapViewList.get(mapViewId);
                    imgHeight = m_mapView.getHeight();
                    imgWidth = m_mapView.getWidth();
                }
                Dot[] seg1 = null;
                Dot[] seg2 = null;
                Dot[] seg3 = null;
                if(seg1Array.size() > 0 && seg2Array.size() > 0 && seg3Array.size() > 0)
                {
                    seg1 = new Dot[seg1Array.size()];
                    seg2 = new Dot[seg2Array.size()];
                    seg3 = new Dot[seg3Array.size()];

                    for (int i = 0; i < seg1Array.size(); i++) {
                        ReadableMap readable = seg1Array.getMap(i);
                        String keyStr = readable.getString("point2DId");
                        seg1[i] = JSDot.getObjFromList(keyStr);
                    }

                    for (int j = 0; j < seg2Array.size(); j++) {
                        ReadableMap readable = seg1Array.getMap(j);
                        String keyStr = readable.getString("point2DId");
                        seg2[j] = JSDot.getObjFromList(keyStr);
                    }

                    for (int k = 0; k < seg3Array.size(); k++) {
                        ReadableMap readable = seg1Array.getMap(k);
                        String keyStr = readable.getString("point2DId");
                        seg3[k] = JSDot.getObjFromList(keyStr);
                    }
                }
                Bitmap bitmap = Bitmap.createBitmap(imgWidth, imgHeight, Bitmap.Config.ARGB_8888);

                int  result = (int)m_mapView.getCrossBitmap(seg1, seg2, seg3, bitmap);
                File externalCacheDir = getReactApplicationContext().getExternalCacheDir();
                File internalCacheDir = getReactApplicationContext().getCacheDir();
                File cacheDir;
                if (externalCacheDir == null && internalCacheDir == null) {
                    throw new IOException("No cache directory available");
                }
                if (externalCacheDir == null) {
                    cacheDir = internalCacheDir;
                } else if (internalCacheDir == null) {
                    cacheDir = externalCacheDir;
                } else {
                    cacheDir = externalCacheDir.getFreeSpace() > internalCacheDir.getFreeSpace() ?
                            externalCacheDir : internalCacheDir;
                }
                String suffix = ".png";
                File bitmapFile = File.createTempFile(TEMP_FILE_PREFIX, suffix, cacheDir);

                Bitmap.CompressFormat compressFormat;
                switch (type) {
                    case "jpeg":
                    case "jpg":
                        compressFormat = Bitmap.CompressFormat.JPEG;
                        break;
                    case "webp":
                        compressFormat = Bitmap.CompressFormat.WEBP;
                        break;
                    case "png":
                    default:
                        compressFormat = Bitmap.CompressFormat.PNG;
                        break;
                }
                FileOutputStream fos = new FileOutputStream(bitmapFile);
                bitmap.compress(compressFormat, quality, fos);
                fos.flush();
                fos.close();
                String uri = Uri.fromFile(bitmapFile).toString();

                WritableMap map = Arguments.createMap();

                map.putInt("result", result);
                map.putString("uri", uri);
                promise.resolve(map);
            } catch (Exception e) {
                promise.reject(e);
            }
        }
    }

    @ReactMethod
    public void showMagnifier(String mapViewId, String viewPointFId, String optionId, Promise promise)
    {
        try {
            m_mapView = mapViewList.get(mapViewId);
            PointF    viewPointF = JSPointF.getObjFromList(viewPointFId);
            MagnifierOption  option = JSMagnifierOption.getObjFromList(optionId);
            m_mapView.showMagnifier(viewPointF, option);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void hideMagnifier(String mapViewId, Promise promise)
    {
        try {
            m_mapView = mapViewList.get(mapViewId);
            m_mapView.hideMagnifier();
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void turnOnMagnifier(String mapViewId, String magnifierOptionId, Promise promise)
    {
        try {
            m_mapView = mapViewList.get(mapViewId);
            MagnifierOption option = JSMagnifierOption.getObjFromList(magnifierOptionId);
            m_mapView.turnOnMagnifier(option);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void turnOffMagnifier(String mapViewId, Promise promise)
    {
        try {
            m_mapView = mapViewList.get(mapViewId);
            m_mapView.turnOffMagnifier();
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setShowNorthArrow(String mapViewId, boolean show, Promise promise) {
        try {
            MapView mapView = mapViewList.get(mapViewId);
            mapView.setShowNorthArrow(show);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void isShowNorthArrow(String mapViewId, Promise promise) {
        try {
            m_mapView = mapViewList.get(mapViewId);
            boolean isShowNorthArrow = m_mapView.isShowNorthArrow();

            WritableMap map = Arguments.createMap();
            map.putBoolean("isShowNorthArrow", isShowNorthArrow);

            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setNorthArrowPosition(String mapViewId, String pointFID, Promise promise) {
        try {
            m_mapView = mapViewList.get(mapViewId);
            PointF pointf = JSPointF.getObjFromList(pointFID);
            m_mapView.setNorthArrowPosition(pointf);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getNorthArrowPosition(String mapViewId, Promise promise) {
        try {
            m_mapView = mapViewList.get(mapViewId);

            PointF pointf = m_mapView.getNorthArrowPosition();

            String pointFId = JSPointF.registerId(pointf);
            WritableMap map = Arguments.createMap();
            map.putString("pointFId", pointFId);
            map.putDouble("x", pointf.x);
            map.putDouble("y", pointf.y);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setNorthArrowImage(String mapViewId, String bitmapID, Promise promise) {
        try {
            m_mapView = mapViewList.get(mapViewId);
            Bitmap bitmap = JSImage.getObjFromList(bitmapID);
            m_mapView.setNorthArrowImage(bitmap);
//            Bitmap mBitmap = BitmapFactory.decodeResource(mReactContext.getResources(), android.R.drawable.alert_dark_frame);
//            m_mapView.setNorthArrowImage(mBitmap);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setShowLogo(String mapViewId, boolean show, Promise promise) {
        try {
            MapView mapView = mapViewList.get(mapViewId);
            mapView.setShowLogo(show);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void isShowLogo(String mapViewId, Promise promise) {
        try {
            m_mapView = mapViewList.get(mapViewId);
            boolean isShowLogo = m_mapView.isShowLogo();

            WritableMap map = Arguments.createMap();
            map.putBoolean("isShowLogo", isShowLogo);

            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setLogoPoistion(String mapViewId, int position, Promise promise) {
        try {
            MapView mapView = mapViewList.get(mapViewId);
            mapView.setLogoPoistion(position);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getLogoPoistion(String mapViewId, Promise promise) {
        try {
            m_mapView = mapViewList.get(mapViewId);
            int LogoPoistion = m_mapView.getLogoPoistion();

            WritableMap map = Arguments.createMap();
            map.putInt("LogoPoistion", LogoPoistion);

            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setShowScaleBar(String mapViewId, boolean show, Promise promise) {
        try {
            MapView mapView = mapViewList.get(mapViewId);
            mapView.setShowScaleBar(show);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void isShowScaleBar(String mapViewId, Promise promise) {
        try {
            m_mapView = mapViewList.get(mapViewId);
            boolean isShowScaleBar = m_mapView.isShowScaleBar();

            WritableMap map = Arguments.createMap();
            map.putBoolean("isShowScaleBar", isShowScaleBar);

            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setScaleBarPoistion(String mapViewId, String pointFID, Promise promise) {
        try {
            m_mapView = mapViewList.get(mapViewId);
            PointF pointf = JSPointF.getObjFromList(pointFID);
            m_mapView.setScaleBarPoistion(pointf);
            promise.resolve(true);

        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getScaleBarPoistion(String mapViewId, Promise promise) {
        try {
            m_mapView = mapViewList.get(mapViewId);

            PointF pointf = m_mapView.getScaleBarPoistion();

            String pointFId = JSPointF.registerId(pointf);
            WritableMap map = Arguments.createMap();
            map.putString("pointFId", pointFId);
            map.putDouble("x", pointf.x);
            map.putDouble("y", pointf.y);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setSkyImage(String mapViewId, String bitmapID, Promise promise) {
        try {
            m_mapView = mapViewList.get(mapViewId);
            Bitmap bitmap = JSImage.getObjFromList(bitmapID);
            m_mapView.setSkyImage(bitmap);
            promise.resolve(true);

        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setSkySceneEnabled(String mapViewId, boolean enabled, Promise promise) {
        try {
            MapView mapView = mapViewList.get(mapViewId);
            mapView.setSkySceneEnabled(enabled);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void isSkySceneEnabled(String mapViewId, Promise promise) {
        try {
            m_mapView = mapViewList.get(mapViewId);
            boolean isSkySceneEnabled = m_mapView.isSkySceneEnabled();

            WritableMap map = Arguments.createMap();
            map.putBoolean("isSkySceneEnabled", isSkySceneEnabled);

            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setZoomControlsEnabled(final String mapViewId, final boolean enabled, final Promise promise) {
        getCurrentActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                try {
                    MapView mapView = mapViewList.get(mapViewId);
                    mapView.setZoomControlsEnabled(enabled);
                    promise.resolve(true);
                } catch (Exception e) {
                    promise.reject(e);
                }
            }
        });
    }

    @ReactMethod
    public void setZoomControlPosition(String mapViewId, String pointFId, Promise promise){
        try {
            m_mapView = mapViewList.get(mapViewId);
            PointF pointF = JSPointF.getObjFromList(pointFId);
            m_mapView.setZoomControlPosition(pointF);

            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getZoomControlPosition(String mapViewId, Promise promise){
        try {
            m_mapView = mapViewList.get(mapViewId);
            PointF pointF = m_mapView.getZoomControlPosition();
            String pointFId = null;
            if(pointF != null){
                pointFId = JSPointF.registerId(pointF);
            }

            promise.resolve(pointFId);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void isZoomControlsEnabled(String mapViewId, Promise promise) {
        try {
            m_mapView = mapViewList.get(mapViewId);
            boolean isZoomControlsEnabled = m_mapView.isZoomControlsEnabled();

            WritableMap map = Arguments.createMap();
            map.putBoolean("isZoomControlsEnabled", isZoomControlsEnabled);

            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setMapPanGesturesEnabled(String mapViewId, boolean enabled, Promise promise) {
        try {
            MapView mapView = mapViewList.get(mapViewId);
            mapView.setMapPanGesturesEnabled(enabled);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void isMapPanGesturesEnabled(String mapViewId, Promise promise) {
        try {
            m_mapView = mapViewList.get(mapViewId);
            boolean isMapPanGesturesEnabled = m_mapView.isMapPanGesturesEnabled();

            WritableMap map = Arguments.createMap();
            map.putBoolean("isMapPanGesturesEnabled", isMapPanGesturesEnabled);

            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setMapZoomGesturesEnabled(String mapViewId, boolean enabled, Promise promise) {
        try {
            MapView mapView = mapViewList.get(mapViewId);
            mapView.setMapZoomGesturesEnabled(enabled);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void isMapZoomGesturesEnabled(String mapViewId, Promise promise) {
        try {
            m_mapView = mapViewList.get(mapViewId);
            boolean isMapZoomGesturesEnabled = m_mapView.isMapZoomGesturesEnabled();

            WritableMap map = Arguments.createMap();
            map.putBoolean("isMapZoomGesturesEnabled", isMapZoomGesturesEnabled);

            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setMapRotateGesturesEnabled(String mapViewId, boolean enabled, Promise promise) {
        try {
            MapView mapView = mapViewList.get(mapViewId);
            mapView.setMapRotateGesturesEnabled(enabled);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void isMapRotateGesturesEnabled(String mapViewId, Promise promise) {
        try {
            m_mapView = mapViewList.get(mapViewId);
            boolean isMapRotateGesturesEnabled = m_mapView.isMapRotateGesturesEnabled();

            WritableMap map = Arguments.createMap();
            map.putBoolean("isMapRotateGesturesEnabled", isMapRotateGesturesEnabled);

            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setMapSlopeGesturesEnabled(String mapViewId, boolean enabled, Promise promise) {
        try {
            MapView mapView = mapViewList.get(mapViewId);
            mapView.setMapSlopeGesturesEnabled(enabled);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void isMapSlopeGesturesEnabled(String mapViewId, Promise promise) {
        try {
            m_mapView = mapViewList.get(mapViewId);
            boolean isMapSlopeGesturesEnabled = m_mapView.isMapSlopeGesturesEnabled();

            WritableMap map = Arguments.createMap();
            map.putBoolean("isMapSlopeGesturesEnabled", isMapSlopeGesturesEnabled);

            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setDoubleTapZooming(String mapViewId, boolean enabled, Promise promise) {
        try {
            MapView mapView = mapViewList.get(mapViewId);
            mapView.setDoubleTapZooming(enabled);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void isDoubleTapZooming(String mapViewId, Promise promise) {
        try {
            m_mapView = mapViewList.get(mapViewId);
            boolean isDoubleTapZooming = m_mapView.isDoubleTapZooming();

            WritableMap map = Arguments.createMap();
            map.putBoolean("isDoubleTapZooming", isDoubleTapZooming);

            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setTwoFingerTapZooming(String mapViewId, boolean enabled, Promise promise) {
        try {
            MapView mapView = mapViewList.get(mapViewId);
            mapView.setTwoFingerTapZooming(enabled);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void isTwoFingerTapZooming(String mapViewId, Promise promise) {
        try {
            m_mapView = mapViewList.get(mapViewId);
            boolean isTwoFingerTapZooming = m_mapView.isTwoFingerTapZooming();

            WritableMap map = Arguments.createMap();
            map.putBoolean("isTwoFingerTapZooming", isTwoFingerTapZooming);

            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setPanEndAnimating(String mapViewId, boolean enabled, Promise promise) {
        try {
            MapView mapView = mapViewList.get(mapViewId);
            mapView.setPanEndAnimating(enabled);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void isPanEndAnimating(String mapViewId, Promise promise) {
        try {
            m_mapView = mapViewList.get(mapViewId);
            boolean isPanEndAnimating = m_mapView.isPanEndAnimating();

            WritableMap map = Arguments.createMap();
            map.putBoolean("isPanEndAnimating", isPanEndAnimating);

            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setLabelRenderAnimating(String mapViewId, boolean enabled, Promise promise) {
        try {
            MapView mapView = mapViewList.get(mapViewId);
            mapView.setLabelRenderAnimating(enabled);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void isLabelRenderAnimating(String mapViewId, Promise promise) {
        try {
            m_mapView = mapViewList.get(mapViewId);
            boolean isLabelRenderAnimating = m_mapView.isLabelRenderAnimating();

            WritableMap map = Arguments.createMap();
            map.putBoolean("isLabelRenderAnimating", isLabelRenderAnimating);

            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void registerTapListener(String mapViewId, Promise promise) {
        try {
            m_mapView = mapViewList.get(mapViewId);
            MapListener mapListener = new MapListener(m_mapView, mReactContext);
            m_mapView.setTapListener(mapListener);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void unregisterTapListener(String mapViewId, Promise promise) {
        try {
            m_mapView = mapViewList.get(mapViewId);
            m_mapView.setTapListener(null);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void registerLongTapListener(String mapViewId, Promise promise) {
        try {
            m_mapView = mapViewList.get(mapViewId);
            MapListener mapListener = new MapListener(m_mapView, mReactContext);
            m_mapView.setLongTapListener(mapListener);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void unregisterLongTapListener(String mapViewId, Promise promise) {
        try {
            m_mapView = mapViewList.get(mapViewId);
            m_mapView.setLongTapListener(null);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void registerDoubleTapListener(String mapViewId, Promise promise) {
        try {
            m_mapView = mapViewList.get(mapViewId);
            MapListener mapListener = new MapListener(m_mapView, mReactContext);
            m_mapView.setDoubleTapListener(mapListener);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void unregisterDoubleTapListener(String mapViewId, Promise promise) {
        try {
            m_mapView = mapViewList.get(mapViewId);
            m_mapView.setDoubleTapListener(null);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void registerTouchListener(String mapViewId, Promise promise) {
        try {
            m_mapView = mapViewList.get(mapViewId);
            MapListener mapListener = new MapListener(m_mapView, mReactContext);
            m_mapView.setTouchListener(mapListener);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void unregisterTouchListener(String mapViewId, Promise promise) {
        try {
            m_mapView = mapViewList.get(mapViewId);
            m_mapView.setTouchListener(null);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void registerZoomChangedListener(String mapViewId, Promise promise) {
        try {
            m_mapView = mapViewList.get(mapViewId);
            MapListener mapListener = new MapListener(m_mapView, mReactContext);
            m_mapView.setZoomChangedListener(mapListener);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void unregisterZoomChangedListener(String mapViewId, Promise promise) {
        try {
            m_mapView = mapViewList.get(mapViewId);
            m_mapView.setZoomChangedListener(null);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void registerCenterChangedListener(String mapViewId, Promise promise) {
        try {
            m_mapView = mapViewList.get(mapViewId);
            MapListener mapListener = new MapListener(m_mapView, mReactContext);
            m_mapView.setCenterChangedListener(mapListener);
            promise.resolve(true);

        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void unregisterCenterChangedListener(String mapViewId, Promise promise) {
        try {
            m_mapView = mapViewList.get(mapViewId);
            m_mapView.setCenterChangedListener(null);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void registerRotateChangedListener(String mapViewId, Promise promise) {
        try {
            m_mapView = mapViewList.get(mapViewId);
            MapListener mapListener = new MapListener(m_mapView, mReactContext);
            m_mapView.setRotateChangedListener(mapListener);
            promise.resolve(true);

        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void unregisterRotateChangedListener(String mapViewId, Promise promise) {
        try {
            m_mapView = mapViewList.get(mapViewId);
            m_mapView.setRotateChangedListener(null);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void registerPositionChangedListener(String mapViewId, Promise promise)
    {
        try {
            m_mapView = mapViewList.get(mapViewId);
            MapListener mapListener = new MapListener(m_mapView, mReactContext);
            m_mapView.setPositionChangedListener(mapListener);
            promise.resolve(true);

        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void unregisterPositionChangedListener(String mapViewId, Promise promise)
    {
        try {
            m_mapView = mapViewList.get(mapViewId);
            m_mapView.setPositionChangedListener(null);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void registerAnimationListener(String mapViewId, Promise promise) {
        try {
            m_mapView = mapViewList.get(mapViewId);
            MapListener mapListener = new MapListener(m_mapView, mReactContext);
            m_mapView.setAnimationListener(mapListener);
            promise.resolve(true);

        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void unregisterAnimationListener(String mapViewId, Promise promise) {
        try {
            m_mapView = mapViewList.get(mapViewId);
            m_mapView.setAnimationListener(null);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void registerRefreshListener(String mapViewId, Promise promise) {
        try {
            m_mapView = mapViewList.get(mapViewId);
            MapListener mapListener = new MapListener(m_mapView, mReactContext);
            m_mapView.setRefreshListener(mapListener);
            promise.resolve(true);

        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void unregisterRefreshListener(String mapViewId, Promise promise) {
        try {
            m_mapView = mapViewList.get(mapViewId);
            m_mapView.setRefreshListener(null);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void registerMapLoadListener(String mapViewId, Promise promise) {
        try {

            m_mapView = mapViewList.get(mapViewId);
            MapListener mapListener = new MapListener(m_mapView, mReactContext);
            m_mapView.setMapLoadListener(mapListener);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void unregisterMapLoadListener(String mapViewId, Promise promise) {
        try {
            m_mapView = mapViewList.get(mapViewId);
            m_mapView.setMapLoadListener(null);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void registerAnnotationListener(String mapViewId, Promise promise)
    {
        try {
            m_mapView = mapViewList.get(mapViewId);
            MapListener mapListener = new MapListener(m_mapView, mReactContext);
            m_mapView.setAnnotationListener(mapListener);
            promise.resolve(true);

        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void unregisterAnnotationListener(String mapViewId, Promise promise)
    {
        try {
            m_mapView = mapViewList.get(mapViewId);
            m_mapView.setAnnotationListener(null);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void swipe(String mapViewId, String swipeLayerId, String swipeRegionDotsId, Promise promise)
    {
        try {
            m_mapView = mapViewList.get(mapViewId);
            MapLayer mapLayer = JSMapLayer.getObjFromList(swipeLayerId);
            Dots   swipeRegionDots = JSDots.getObjFromList(swipeRegionDotsId);
            int iSwip = m_mapView.swipe(mapLayer,swipeRegionDots);
            promise.resolve(iSwip);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

}
