package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.core.featureservice.MapServiceLayerInfo;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class JSMapServiceLayerInfo extends ReactContextBaseJavaModule {

    public static final String REACT_CLASS = "JSMapServiceLayerInfo";
    public static Map<String, MapServiceLayerInfo> mMapServiceLayerInfoList = new HashMap<String, MapServiceLayerInfo>();

    public JSMapServiceLayerInfo(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public static MapServiceLayerInfo getObjFromList(String id) {
        return mMapServiceLayerInfoList.get(id);
    }


    public static String registerId(MapServiceLayerInfo obj) {
        for (Map.Entry entry : mMapServiceLayerInfoList.entrySet()) {
            if (obj.equals(entry.getValue())) {
                return (String) entry.getKey();
            }
        }
        Calendar calendar = Calendar.getInstance();
        String id = Long.toString(calendar.getTimeInMillis());
        mMapServiceLayerInfoList.put(id, obj);
        return id;
    }

    @ReactMethod
    public void createObj(String strName, int layerId, double dMinScale, double dMaxScale, String strStyle, Promise promise) {
        try {
            MapServiceLayerInfo layerInfo = new MapServiceLayerInfo(strName, layerId, dMinScale, dMaxScale, strStyle);
            String layerInfoId = registerId(layerInfo);

            WritableMap map = Arguments.createMap();
            map.putString("MapServiceLayerInfoId", layerInfoId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getLayerId(String layerInfoId, Promise promise)
    {
        try {
            MapServiceLayerInfo layerInfo = getObjFromList(layerInfoId);
            int layerId = layerInfo.getLayerId();
            promise.resolve(layerId);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setLayerId(String layerInfoId, int layerId, Promise promise)
    {
        try {
            MapServiceLayerInfo layerInfo = getObjFromList(layerInfoId);
            layerInfo.setLayerId(layerId);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getName(String layerInfoId, Promise promise)
    {
        try {
            MapServiceLayerInfo layerInfo = getObjFromList(layerInfoId);
            String name = layerInfo.getName();
            promise.resolve(name);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setName(String layerInfoId, String StrName, Promise promise)
    {
        try {
            MapServiceLayerInfo layerInfo = getObjFromList(layerInfoId);
            layerInfo.setName(StrName);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getMaxScale(String layerInfoId, Promise promise)
    {
        try {
            MapServiceLayerInfo layerInfo = getObjFromList(layerInfoId);
            double maxScale = layerInfo.getMaxScale();
            promise.resolve(maxScale);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setMaxScale(String layerInfoId, double maxScale, Promise promise)
    {
        try {
            MapServiceLayerInfo layerInfo = getObjFromList(layerInfoId);
            layerInfo.setMaxScale(maxScale);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getMinScale(String layerInfoId, Promise promise)
    {
        try {
            MapServiceLayerInfo layerInfo = getObjFromList(layerInfoId);
            double minScale = layerInfo.getMinScale();
            promise.resolve(minScale);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setMinScale(String layerInfoId, double minScale, Promise promise)
    {
        try {
            MapServiceLayerInfo layerInfo = getObjFromList(layerInfoId);
            layerInfo.setMinScale(minScale);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getStyle(String layerInfoId, Promise promise)
    {
        try {
            MapServiceLayerInfo layerInfo = getObjFromList(layerInfoId);
            String style = layerInfo.getStyle();
            promise.resolve(style);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setStyle(String layerInfoId, String strStyle, Promise promise)
    {
        try {
            MapServiceLayerInfo layerInfo = getObjFromList(layerInfoId);
            layerInfo.setStyle(strStyle);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }
}
