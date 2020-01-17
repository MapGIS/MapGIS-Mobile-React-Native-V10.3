package com.zondy.mapgis.mobile.react;

import android.graphics.Bitmap;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.core.geometry.Dot;
import com.zondy.mapgis.core.geometry.Rect;
import com.zondy.mapgis.core.map.LayerEnum;
import com.zondy.mapgis.core.map.Map;
import com.zondy.mapgis.core.map.MapLayer;
import com.zondy.mapgis.core.srs.SRefData;
import com.zondy.mapgis.jni.core.map.NativeMap;

import java.util.UUID;


/**
 * @author fjl 2019-6-24 下午2:52:36
 * @content 地图对象Native组件
 */
public class JSMap extends ReactContextBaseJavaModule {
    private static final String REACT_CLASS = "JSMap";
    private static java.util.Map<String, Map> mMapList = new java.util.HashMap<String, Map>();

    public JSMap(ReactApplicationContext context) {
        super(context);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public static Map getObjFromList(String id) {
        return mMapList.get(id);
    }

    public static String registerId(Map obj) {
        for (java.util.Map.Entry entry : mMapList.entrySet()) {
            if (obj.equals(entry.getValue())) {
                String id = (String) entry.getKey();
                return id;
            }
        }
        String id = UUID.randomUUID().toString().substring(24);
        mMapList.put(id, obj);
        return id;
    }

    @ReactMethod
    public static void getLayerTypeByID(String mapLayerId,  Promise promise){
             try {
                        MapLayer mapLayer = JSMapLayer.getObjFromList(mapLayerId);
                        int type = NativeMap.jni_GetLayerType(mapLayer.getHandle());
                        WritableMap map = Arguments.createMap();
                        map.putInt("MapLayerType", type);
                        promise.resolve(map);
              } catch (Exception e) {
                  promise.reject(e);
              }
    }

    @ReactMethod
    public void createObj(Promise promise) {
        try {
            Map Map = new Map();
            String MapId = registerId(Map);

            WritableMap map = Arguments.createMap();
            map.putString("MapId", MapId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setName(String MapLayerId, String name, Promise promise) {
        try {
            Map map = getObjFromList(MapLayerId);
            map.setName(name);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setDescription(String MapLayerId, String Description, Promise promise) {
        try {
            Map map = getObjFromList(MapLayerId);
            map.setDescription(Description);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setEntireRange(String MapLayerId, String rectID, Promise promise) {
        try {
            Map map = getObjFromList(MapLayerId);
            Rect rect = JSRect.getObjFromList(rectID);
            map.setEntireRange(rect);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setMinScale(String MapLayerId, double MinScale, Promise promise) {
        try {
            Map map = getObjFromList(MapLayerId);
            map.setMinScale(MinScale);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setMaxScale(String MapLayerId, double MaxScale, Promise promise) {
        try {
            Map map = getObjFromList(MapLayerId);
            map.setMaxScale(MaxScale);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setIsFixedScalesDisplay(String MapLayerId, boolean IsFixedScalesDisplay, Promise promise){
        try {
            Map map = getObjFromList(MapLayerId);
            map.setIsFixedScalesDisplay(IsFixedScalesDisplay);
            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setFixedScalesCount(String MapLayerId, int FixedScalesCount, Promise promise) {
        try {
            Map map = getObjFromList(MapLayerId);
            map.setFixedScalesCount(FixedScalesCount);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setFixedScale(String MapLayerId, int index, double scale, Promise promise) {
        try {
            Map map = getObjFromList(MapLayerId);
            map.setFixedScale(index, scale);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setIsCustomEntireRange(String MapLayerId, boolean IsCustomEntireRange, Promise promise) {
        try {
            Map map = getObjFromList(MapLayerId);
            map.setIsCustomEntireRange(IsCustomEntireRange);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getName(String MapId, Promise promise) {
        try {
            Map map = getObjFromList(MapId);
            String name = map.getName();

            promise.resolve(name);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getDescription(String MapId, Promise promise) {
        try {
            Map map = getObjFromList(MapId);
            String description = map.getDescription();

            promise.resolve(description);
        } catch (Exception e) {
            promise.reject(e);
        }

    }

    @ReactMethod
    public void getEntireRange(String MapId, Promise promise) {
        try {
            Map Map = getObjFromList(MapId);
            Rect rect = Map.getEntireRange();
            String rectId = null;
            if(rect != null){
                rectId = JSRect.registerId(rect);
            }

            WritableMap map = Arguments.createMap();
            map.putString("rectId", rectId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getMinScale(String MapId, Promise promise) {
        try {
            Map map = getObjFromList(MapId);
            double minScale = map.getMinScale();

            promise.resolve(minScale);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getMaxScale(String MapId, Promise promise) {
        try {
            Map map = getObjFromList(MapId);
            double maxScale = map.getMaxScale();

            promise.resolve(maxScale);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getIsFixedScalesDisplay(String MapId, Promise promise){
        try{
            Map map = getObjFromList(MapId);
            boolean isFixedScaleDisplay = map.getIsFixedScalesDisplay();
            promise.resolve(isFixedScaleDisplay);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getFixedScalesCount(String MapId, Promise promise){
        try {
            Map map = getObjFromList(MapId);
            int fixedScalesCount = map.getFixedScalesCount();
            promise.resolve(fixedScalesCount);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getFixedScale(String MapId, int index, Promise promise){
        try {
            Map map = getObjFromList(MapId);
            double fixedScale = map.getFixedScale(index);
            promise.resolve(fixedScale);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getSRSInfo(String MapId, Promise promise){
        try {
            Map map = getObjFromList(MapId);
            SRefData sRefData = map.getSRSInfo();
            String SRefDataId = null;
            if(sRefData != null){
                SRefDataId = JSSRefData.registerId(sRefData);
            }

            WritableMap writableMap = Arguments.createMap();
            writableMap.putString("SRefDataId",SRefDataId);
            promise.resolve(writableMap);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getLayerCount(String MapId, Promise promise) {
        try {
            Map map = getObjFromList(MapId);
            int layerCount = map.getLayerCount();

            promise.resolve(layerCount);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getLayerEnum(String MapId, Promise promise){
        try {
            Map map = getObjFromList(MapId);
            LayerEnum layerEnum = map.getLayerEnum();
            String layerEnumId = null;
            if(layerEnum != null){
                layerEnumId = JSLayerEnum.registerId(layerEnum);
            }

            WritableMap writableMap = Arguments.createMap();
            writableMap.putString("LayerEnumId",layerEnumId);
            promise.resolve(writableMap);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getIsCustomEntireRange(String MapId, Promise promise){
        try {
            Map map = getObjFromList(MapId);
            boolean isCustomEntireRange = map.getIsCustomEntireRange();
            promise.resolve(isCustomEntireRange);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getRange(String MapId, Promise promise){
        try {
            Map map = getObjFromList(MapId);
            Rect rect = map.getRange();
            String RectId = null;
            if(rect != null){
                RectId = JSRect.registerId(rect);
            }

            WritableMap writableMap = Arguments.createMap();
            writableMap.putString("RectId",RectId);
            promise.resolve(writableMap);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getSymbolScale(String MapId, Promise promise){
        try {
            Map map = getObjFromList(MapId);
            double symbolScale = map.getSymbolScale();
            promise.resolve(symbolScale);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getLayer(String MapId, int index, Promise promise) {
        try {
            Map Map = getObjFromList(MapId);
            MapLayer mapLayer = Map.getLayer(index);
            String MapLayerId = null;
            if(mapLayer != null){
                MapLayerId = JSMapLayer.registerId(mapLayer);
            }

            WritableMap map = Arguments.createMap();
            map.putString("MapLayerId", MapLayerId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getIsDirty(String MapId, Promise promise) {
        try {
            Map map = getObjFromList(MapId);
            boolean IsDirty = map.getIsDirty();

            promise.resolve(IsDirty);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void append(String MapId, String layerID, Promise promise) {
        try {
            Map map = getObjFromList(MapId);
            MapLayer mapLayer = JSMapLayer.getObjFromList(layerID);
            int result = map.append(mapLayer);
            promise.resolve(result);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void insert(String MapId, int index, String layerID, Promise promise) {
        try {
            Map map = getObjFromList(MapId);
            MapLayer mapLayer = JSMapLayer.getObjFromList(layerID);
            int result = map.insert(index, mapLayer);
            promise.resolve(result);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void removeByLayer(String MapId, String layerID, Promise promise) {
        try {
            Map map = getObjFromList(MapId);
            MapLayer mapLayer = JSMapLayer.getObjFromList(layerID);
            boolean result = map.remove(mapLayer);
            promise.resolve(result);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void remove(String MapId, int fromIndex, int count, Promise promise) {
        try {
            Map map = getObjFromList(MapId);
            boolean removeResult = map.remove(fromIndex, count);
            promise.resolve(removeResult);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void removeByIndex(String MapId, int index, Promise promise) {
        try {
            Map map = getObjFromList(MapId);
            boolean result = map.remove(index);
            promise.resolve(result);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void removeAll(String MapId, Promise promise) {
        try {
            Map map = getObjFromList(MapId);
            boolean result = map.removeAll();
            promise.resolve(result);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void dragOut(String MapId, String layerID, Promise promise) {
        try {
            Map map = getObjFromList(MapId);
            MapLayer mapLayer = JSMapLayer.getObjFromList(layerID);
            int result = map.dragOut(mapLayer);
            promise.resolve(result);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void dragIn(String MapId, int index, String layerID, Promise promise) {
        try {
            Map map = getObjFromList(MapId);
            MapLayer mapLayer = JSMapLayer.getObjFromList(layerID);
            int result = map.dragIn(index, mapLayer);
            promise.resolve(result);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void indexOfByName(String MapId, String name, Promise promise) {
        try {
            Map map = getObjFromList(MapId);
            int result = map.indexOf(name);

            promise.resolve(result);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void indexOfByLayer(String MapId, String layerId, Promise promise){
        try {
            Map map = getObjFromList(MapId);
            MapLayer mapLayer = JSMapLayer.getObjFromList(layerId);
            int index = map.indexOf(mapLayer);
            promise.resolve(index);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void moveToBottom(String MapId, int index, Promise promise) {
        try {
            Map map = getObjFromList(MapId);

            boolean result = map.moveToBottom(index);
            promise.resolve(result);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void moveToTop(String MapId, int index, Promise promise) {
        try {
            Map map = getObjFromList(MapId);
            boolean result = map.moveToTop(index);

            promise.resolve(result);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void moveToDown(String MapId, int index, Promise promise) {
        try {
            Map map = getObjFromList(MapId);

            boolean result = map.moveToDown(index);

            promise.resolve(result);

        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void moveToUp(String MapId, int index, Promise promise) {
        try {
            Map map = getObjFromList(MapId);
            boolean result = map.moveToUp(index);

            promise.resolve(result);

        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void move(String MapId, int fromIndex, int toIndex, Promise promise) {
        try {
            Map map = getObjFromList(MapId);
            boolean result = map.move(fromIndex, toIndex);

            promise.resolve(result);

        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void toXML(String MapId, boolean onlyStyle, Promise promise){
        try {
            Map map = getObjFromList(MapId);
            String s = map.toXML(onlyStyle);
            promise.resolve(s);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void fromXML(String MapId, String strXML, boolean onlyStyle, Promise promise){
        try {
            Map map = getObjFromList(MapId);
            int fromXML = (int) map.fromXML(strXML,onlyStyle);

            promise.resolve(fromXML);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void clearDirty(String MapId, Promise promise){
        try {
            Map map = getObjFromList(MapId);
            boolean clearDirty = map.clearDirty();
            promise.resolve(clearDirty);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void SetRotateCenter(String MapId, String centerID, Promise promise) {
        try {
            Map map = getObjFromList(MapId);
            Dot point2D = JSDot.getObjFromList(centerID);
            long result = map.SetRotateCenter(point2D);

            promise.resolve(result);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void GetRotateCenter(String MapId, Promise promise) {
        try {
            Map Map = getObjFromList(MapId);
            Dot centerDot = Map.GetRotateCenter();

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
    public void SetRotateAngle(String MapLayerId, double angle, Promise promise) {
        try {
            Map map = getObjFromList(MapLayerId);
            long result = map.SetRotateAngle(angle);
            promise.resolve(result);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void GetRotateAngle(String MapId, Promise promise) {
        try {
            Map map = getObjFromList(MapId);
            double rotateAngle = map.GetRotateAngle();

            promise.resolve(rotateAngle);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void outputToBitmap(String MapId, String rectId, String imageID, Promise promise){
        try {
            Map map = getObjFromList(MapId);
            Rect rect = JSRect.getObjFromList(rectId);
            Bitmap bitmap = JSImage.getObjFromList(imageID);
            int outputToBitmap = (int) map.outputToBitmap(rect,bitmap);

            promise.resolve(outputToBitmap);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setViewRange(String MapLayerId, String rectID, Promise promise) {
        try {
            Map map = getObjFromList(MapLayerId);
            Rect rect = JSRect.getObjFromList(rectID);
            map.setViewRange(rect);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getViewRange(String MapId, Promise promise) {
        try {
            Map Map = getObjFromList(MapId);
            Rect rect = Map.getViewRange();

            String rectId = JSRect.registerId(rect);
            WritableMap map = Arguments.createMap();
            map.putString("rectId", rectId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }
}
