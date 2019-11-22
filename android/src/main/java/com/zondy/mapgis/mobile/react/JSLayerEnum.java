package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.core.map.LayerEnum;
import com.zondy.mapgis.core.map.MapLayer;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JSLayerEnum extends ReactContextBaseJavaModule {
    private static final String REACT_CLASS = "JSLayerEnum";
    public static Map<String, LayerEnum> mLayerEnumList = new HashMap<>();
    public JSLayerEnum(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public static LayerEnum getObjFromList(String id){
        return mLayerEnumList.get(id);
    }

    public static String registerId(LayerEnum obj){
        for (Map.Entry entry : mLayerEnumList.entrySet()){
            if(obj.equals(entry.getValue())){
                String id = (String) entry.getKey();
                return id;
            }
        }
        Calendar calendar = Calendar.getInstance();
        String id = Long.toString(calendar.getTimeInMillis());
        mLayerEnumList.put(id,obj);
        return id;
    }

    @ReactMethod
    public void createObj(Promise promise){
        try {
            LayerEnum layerEnum = new LayerEnum();
            String layerEnumId = registerId(layerEnum);

            WritableMap map = Arguments.createMap();
            map.putString("LayerEnumId",layerEnumId);
            promise.resolve(map);

        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void init(String layerEnumId, ReadableArray layersArray, Promise promise){
        try {
            LayerEnum layerEnum = getObjFromList(layerEnumId);
            List<MapLayer> layers = new ArrayList<>();
            if(layerEnum != null){
                for (int i = 0; i < layersArray.size(); i++){
                    ReadableMap readableMap = layersArray.getMap(i);
                    String keyStr = readableMap.getString("_MGMapLayerId"); // 通过id获取MapLayer对象
                    layers.add(JSMapLayer.getObjFromList(keyStr));
                }
            }
            boolean initResult = layerEnum.init(layers);
            promise.resolve(initResult);
        }catch (Exception e){
            promise.reject(e);
        }
    }
    @ReactMethod
    public void moveToFirst(String layerEnumId, Promise promise){
        try {
            LayerEnum layerEnum = getObjFromList(layerEnumId);
            boolean moveToFirstResult = layerEnum.moveToFirst();
            promise.resolve(moveToFirstResult);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void moveToLast(String layerEnumId, Promise promise){
        try {
            LayerEnum layerEnum = getObjFromList(layerEnumId);
            boolean moveToLastResult = layerEnum.moveToLast();
            promise.resolve(moveToLastResult);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void next(String layerEnumId, Promise promise){
        try {
            LayerEnum layerEnum = getObjFromList(layerEnumId);
            MapLayer mapLayer = layerEnum.next();

            String mapLayerId = null;
            if(mapLayer != null){
                mapLayerId = JSMapLayer.registerId(mapLayer);
            }

            WritableMap map = Arguments.createMap();
            map.putString("MapLayerId",mapLayerId);
            promise.resolve(map);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void prev(String layerEnumId, Promise promise){
        try {
            LayerEnum layerEnum = getObjFromList(layerEnumId);
            MapLayer mapLayer = layerEnum.prev();

            String mapLayerId = null;
            if(mapLayer != null){
                mapLayerId = JSMapLayer.registerId(mapLayer);
            }

            WritableMap map = Arguments.createMap();
            map.putString("MapLayerId",mapLayerId);
            promise.resolve(map);
        }catch (Exception e){
            promise.reject(e);
        }
    }

}
