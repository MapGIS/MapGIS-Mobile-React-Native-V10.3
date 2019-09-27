package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.core.featureservice.SyncLayerOption;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class JSSyncLayerOption extends ReactContextBaseJavaModule {

    public static final String REACT_CLASS = "JSSyncLayerOption";
    public static Map<String, SyncLayerOption> mSyncLayerOptionList = new HashMap<String, SyncLayerOption>();

    public JSSyncLayerOption(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public static SyncLayerOption getObjFromList(String id) {
        return mSyncLayerOptionList.get(id);
    }


    public static String registerId(SyncLayerOption obj) {
        for (Map.Entry entry : mSyncLayerOptionList.entrySet()) {
            if (obj.equals(entry.getValue())) {
                return (String) entry.getKey();
            }
        }
        Calendar calendar = Calendar.getInstance();
        String id = Long.toString(calendar.getTimeInMillis());
        mSyncLayerOptionList.put(id, obj);
        return id;
    }

    @ReactMethod
    public void createObj(String strLayerId, Promise promise) {
        try {
            SyncLayerOption option = new SyncLayerOption(strLayerId);
            String optionId = registerId(option);

            WritableMap map = Arguments.createMap();
            map.putString("SyncLayerOptionId", optionId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getLayerId(String optionId, Promise promise)
    {
        try {
            SyncLayerOption option = getObjFromList(optionId);
            String layerId = option.getLayerId();
            promise.resolve(layerId);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setLayerId(String optionId, String strLayerId, Promise promise)
    {
        try {
            SyncLayerOption option = getObjFromList(optionId);
            option.setLayerId(strLayerId);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }
}
