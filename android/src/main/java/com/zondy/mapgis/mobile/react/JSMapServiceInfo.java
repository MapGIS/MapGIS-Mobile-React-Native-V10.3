package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.android.mapview.MapView;
import com.zondy.mapgis.core.featureservice.FeatureSync;
import com.zondy.mapgis.core.featureservice.MapServiceInfo;
import com.zondy.mapgis.core.featureservice.MapServiceLayerInfo;
import com.zondy.mapgis.core.map.MapLayer;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JSMapServiceInfo extends ReactContextBaseJavaModule {

    private static final String REACT_CLASS = "JSMapServiceInfo";
    public static Map<String, MapServiceInfo> mMapServiceInfoList = new HashMap<String, MapServiceInfo>();

    public JSMapServiceInfo(ReactApplicationContext reactContext) {
        super(reactContext);
    }
    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public static MapServiceInfo getObjFromList(String id) {
        return mMapServiceInfoList.get(id);
    }

    public static String registerId(MapServiceInfo obj) {
        for (Map.Entry entry : mMapServiceInfoList.entrySet()) {
            if (obj.equals(entry.getValue())) {
                String id = (String) entry.getKey();
                return id;
            }
        }

        Calendar calendar = Calendar.getInstance();
        String id = Long.toString(calendar.getTimeInMillis());
        mMapServiceInfoList.put(id, obj);
        return id;
    }

    @ReactMethod
    public void getLayerInfos(String MapServiceInfoId, Promise promise)
    {
        try {
            MapServiceInfo mapServiceInfo = getObjFromList(MapServiceInfoId);
            List<MapServiceLayerInfo> mapServiceLayerInfoList = mapServiceInfo.getLayerInfos();
            String MapServiceLayerInfoId = "";
            WritableArray arr = Arguments.createArray();
            if (mapServiceLayerInfoList.size() > 0) {
                for (int i = 0; i < mapServiceLayerInfoList.size(); i++) {
                    MapServiceLayerInfoId = JSMapServiceLayerInfo.registerId(mapServiceLayerInfoList.get(i));
                    arr.pushString(MapServiceLayerInfoId);
                }
            }
            WritableMap map = Arguments.createMap();
            map.putArray("MapServiceLayerInfoArr", arr);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }
}
