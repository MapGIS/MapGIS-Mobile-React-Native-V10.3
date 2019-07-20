package com.zondy.mapgis.mobile.react;

import android.util.Log;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.android.graphic.Graphic;
import com.zondy.mapgis.android.graphic.GraphicCircle;
import com.zondy.mapgis.android.graphic.GraphicImage;
import com.zondy.mapgis.android.graphic.GraphicMultiPoint;
import com.zondy.mapgis.android.graphic.GraphicPoint;
import com.zondy.mapgis.android.graphic.GraphicPolygon;
import com.zondy.mapgis.android.graphic.GraphicPolylin;
import com.zondy.mapgis.android.graphic.GraphicStippleLine;
import com.zondy.mapgis.android.graphic.GraphicsOverlay;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * @author fjl 2019-6-18 下午2:52:36
 * @content 覆盖物对象Native组件
 */
public class JSGraphicsOverlay extends ReactContextBaseJavaModule {
    public static final String REACT_CLASS = "JSGraphicsOverlay";
    public static Map<String, GraphicsOverlay> mGraphicsOverlayList = new HashMap<String, GraphicsOverlay>();


    public JSGraphicsOverlay(ReactApplicationContext context) {
        super(context);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public static GraphicsOverlay getObjFromList(String id) {
        return mGraphicsOverlayList.get(id);
    }


    public static String registerId(GraphicsOverlay obj) {
        for (Map.Entry entry : mGraphicsOverlayList.entrySet()) {
            if (obj.equals(entry.getValue())) {
                String id = (String) entry.getKey();
                mGraphicsOverlayList.put(id, obj);
                return (String) entry.getKey();
            }
        }

        Calendar calendar = Calendar.getInstance();
        String id = Long.toString(calendar.getTimeInMillis());
        mGraphicsOverlayList.put(id, obj);
        return id;
    }

    @ReactMethod
    public void createObj(Promise promise) {
        try {
            GraphicsOverlay GraphicsOverlay = new GraphicsOverlay();
            String GraphicsOverlayId = registerId(GraphicsOverlay);

            WritableMap map = Arguments.createMap();
            map.putString("GraphicsOverlayId", GraphicsOverlayId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }


    @ReactMethod
    public void setName(String GraphicsOverlayId, String name, Promise promise) {
        try {
            GraphicsOverlay graphicsOverlay = getObjFromList(GraphicsOverlayId);
            graphicsOverlay.setName(name);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }


    @ReactMethod
    public void getName(String GraphicsOverlayId, Promise promise) {
        try {
            GraphicsOverlay graphicsOverlay = getObjFromList(GraphicsOverlayId);
            String name = graphicsOverlay.getName();

            promise.resolve(name);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getState(String GraphicsOverlayId, Promise promise) {
        try {
            GraphicsOverlay graphicsOverlay = getObjFromList(GraphicsOverlayId);
            int state = graphicsOverlay.getState();

            promise.resolve(state);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setState(String GraphicsOverlayId, int state, Promise promise) {
        try {
            GraphicsOverlay graphicsOverlay = getObjFromList(GraphicsOverlayId);
            graphicsOverlay.setState(state);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void addGraphic(String GraphicsOverlayId, String graphicID, Promise promise) {
        try {
            GraphicsOverlay graphicsOverlay = getObjFromList(GraphicsOverlayId);
            Graphic graphic = JSGraphic.mGraphicList.get(graphicID);
            Log.e("graphic:", "" + graphic);
            Log.e("getGraphicByID:", "" + getGraphicByID(graphicID));
            if (graphic != null) {
                graphicsOverlay.addGraphic(graphic);
            }
            GraphicImage graphicImage = JSGraphicImage.mGraphicImageList.get(graphicID);
            if (graphicImage != null) {
                graphicsOverlay.addGraphic(graphicImage);
            }
            GraphicCircle GraphicCircle = JSGraphicCircle.mGraphicCircleList.get(graphicID);
            if (GraphicCircle != null) {
                graphicsOverlay.addGraphic(GraphicCircle);
            }
            GraphicMultiPoint GraphicMultiPoint = JSGraphicMultiPoint.mGraphicMultiPointList.get(graphicID);
            if (GraphicMultiPoint != null) {
                graphicsOverlay.addGraphic(GraphicMultiPoint);
            }
            GraphicPoint GraphicPoint = JSGraphicPoint.mGraphicPointList.get(graphicID);
            if (GraphicPoint != null) {
                graphicsOverlay.addGraphic(GraphicPoint);
            }
            GraphicPolygon GraphicPolygon = JSGraphicPolygon.mGraphicPolygonList.get(graphicID);
            if (GraphicPolygon != null) {
                graphicsOverlay.addGraphic(GraphicPolygon);
            }
            GraphicPolylin GraphicPolylin = JSGraphicPolylin.mGraphicPolylinList.get(graphicID);
            if (GraphicPolylin != null) {
                graphicsOverlay.addGraphic(GraphicPolylin);
            }
            GraphicStippleLine GraphicStippleLine = JSGraphicStippleLine.mGraphicStippleLineList.get(graphicID);
            if (GraphicStippleLine != null) {
                graphicsOverlay.addGraphic(GraphicStippleLine);
            }
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void addGraphics(String GraphicsOverlayId, ReadableArray graphiceArray, Promise promise) {
        try {
            GraphicsOverlay graphicsOverlay = getObjFromList(GraphicsOverlayId);
            ArrayList<Graphic> graphicLst = new ArrayList();
            if (graphicsOverlay != null) {
                for (int i = 0; i < graphiceArray.size(); i++) {
                    ReadableMap innerMap = graphiceArray.getMap(i);
                    String keyStr = innerMap.getString("_MGGraphicId");
                    Graphic graphic = JSGraphic.getObjFromList(keyStr);
                    graphicLst.add(graphic);
                }
            }

            graphicsOverlay.addGraphics(graphicLst);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void removeGraphic(String GraphicsOverlayId, String graphicID, Promise promise) {
        try {
            GraphicsOverlay graphicsOverlay = getObjFromList(GraphicsOverlayId);
            Graphic graphic = JSGraphic.getObjFromList(graphicID);
            graphicsOverlay.removeGraphic(graphic);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void removeGraphics(String GraphicsOverlayId, ReadableArray graphiceArray, Promise promise) {
        try {
            GraphicsOverlay graphicsOverlay = getObjFromList(GraphicsOverlayId);
            ArrayList<Graphic> graphicLst = new ArrayList();
            if (graphicsOverlay != null) {
                for (int i = 0; i < graphiceArray.size(); i++) {
                    ReadableMap innerMap = graphiceArray.getMap(i);
                    String keyStr = innerMap.getString("_MGGraphicId");
//                    Graphic graphic = JSGraphic.getObjFromList(keyStr);
                    Graphic graphic = getGraphicByID(keyStr);

                    if (graphic != null) {
                        graphicLst.add(graphic);
                    }
                }
            }
            graphicsOverlay.removeGraphics(graphicLst);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    public Graphic getGraphicByID(String graphicID) {
        Graphic graphic = JSGraphic.mGraphicList.get(graphicID);
        Log.e("graphic:", "" + graphic);
        if (graphic != null) {
            return graphic;

        }
        GraphicImage graphicImage = JSGraphicImage.mGraphicImageList.get(graphicID);
        if (graphicImage != null) {
            return graphicImage;
        }
        GraphicCircle graphicCircle = JSGraphicCircle.mGraphicCircleList.get(graphicID);
        if (graphicCircle != null) {
            return graphicCircle;
        }
        GraphicMultiPoint graphicMultiPoint = JSGraphicMultiPoint.mGraphicMultiPointList.get(graphicID);
        if (graphicMultiPoint != null) {
            return graphicMultiPoint;
        }
        GraphicPoint graphicPoint = JSGraphicPoint.mGraphicPointList.get(graphicID);
        if (graphicPoint != null) {
            return graphicPoint;
        }
        GraphicPolygon graphicPolygon = JSGraphicPolygon.mGraphicPolygonList.get(graphicID);
        if (graphicPolygon != null) {
            return graphicPolygon;
        }
        GraphicPolylin graphicPolylin = JSGraphicPolylin.mGraphicPolylinList.get(graphicID);
        if (graphicPolylin != null) {
            return graphicPolylin;
        }
        GraphicStippleLine graphicStippleLine = JSGraphicStippleLine.mGraphicStippleLineList.get(graphicID);
        if (graphicStippleLine != null) {
            return graphicStippleLine;
        }
        return graphic;
    }
}
