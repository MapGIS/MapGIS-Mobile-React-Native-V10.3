package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.core.featureservice.SyncDataBaseParmeters;
import com.zondy.mapgis.core.featureservice.SyncLayerOption;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class JSSyncDataBaseParmeters extends ReactContextBaseJavaModule {

    private static final String REACT_CLASS = "JSSyncDataBaseParmeters";
    private static Map<String, SyncDataBaseParmeters> mSyncDataBaseParmetersList = new HashMap<String, SyncDataBaseParmeters>();

    public JSSyncDataBaseParmeters(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public static SyncDataBaseParmeters getObjFromList(String id) {
        return mSyncDataBaseParmetersList.get(id);
    }

    public static String registerId(SyncDataBaseParmeters obj) {
        for (Map.Entry entry : mSyncDataBaseParmetersList.entrySet()) {
            if (obj.equals(entry.getValue())) {
                return (String) entry.getKey();
            }
        }
        String id = UUID.randomUUID().toString().substring(24);
        mSyncDataBaseParmetersList.put(id, obj);
        return id;
    }

    @ReactMethod
    public void createObj(Promise promise) {
        try {
            SyncDataBaseParmeters parmeters = new SyncDataBaseParmeters();
            String parmetersId = registerId(parmeters);

            WritableMap map = Arguments.createMap();
            map.putString("SyncDataBaseParmetersId", parmetersId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void removeLayer(String parmetersId, String strLayerID, Promise promise)
    {
        try {
            SyncDataBaseParmeters parmeters = getObjFromList(parmetersId);
            parmeters.removeLayer(strLayerID);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

   @ReactMethod
    public void getLayerOptions(String parmetersId, Promise promise)
    {
        try {
            SyncDataBaseParmeters parmeters = getObjFromList(parmetersId);
            List<SyncLayerOption> syncLayerOptionList = parmeters.getLayerOptions();
            String SyncLayerOptionId = "";
            WritableArray arr = Arguments.createArray();
            if (syncLayerOptionList.size() > 0) {
                for (int i = 0; i < syncLayerOptionList.size(); i++) {
                    SyncLayerOptionId = JSSyncLayerOption.registerId(syncLayerOptionList.get(i));
                    arr.pushString(SyncLayerOptionId);
                }
            }
            WritableMap map = Arguments.createMap();
            map.putArray("SyncLayerOptionArr", arr);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }
}
