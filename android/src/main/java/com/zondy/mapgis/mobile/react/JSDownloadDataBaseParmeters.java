package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.core.featureservice.DownloadDataBaseParmeters;
import com.zondy.mapgis.core.featureservice.DownloadLayerOption;
import com.zondy.mapgis.core.geometry.Rect;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JSDownloadDataBaseParmeters extends ReactContextBaseJavaModule {

    public static final String REACT_CLASS = "JSDownloadDataBaseParmeters";
    public static Map<String, DownloadDataBaseParmeters> mDownloadDataBaseParmetersList = new HashMap<String, DownloadDataBaseParmeters>();

    public JSDownloadDataBaseParmeters(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public static DownloadDataBaseParmeters getObjFromList(String id) {
        return mDownloadDataBaseParmetersList.get(id);
    }

    public static String registerId(DownloadDataBaseParmeters obj) {
        for (Map.Entry entry : mDownloadDataBaseParmetersList.entrySet()) {
            if (obj.equals(entry.getValue())) {
                return (String) entry.getKey();
            }
        }
        Calendar calendar = Calendar.getInstance();
        String id = Long.toString(calendar.getTimeInMillis());
        mDownloadDataBaseParmetersList.put(id, obj);
        return id;
    }

    @ReactMethod
    public void createObj(Promise promise) {
        try {
            DownloadDataBaseParmeters parmeters = new DownloadDataBaseParmeters();
            String parmetersId = registerId(parmeters);

            WritableMap map = Arguments.createMap();
            map.putString("DownloadDataBaseParmetersId", parmetersId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setExtent(String parmetersId, String extentId, Promise promise)
    {
        try {
            DownloadDataBaseParmeters parmeters = getObjFromList(parmetersId);
            Rect extent = JSRect.getObjFromList(extentId);
            parmeters.setExtent(extent);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

   @ReactMethod
    public void removeLayer(String parmetersId, int layerID, Promise promise)
    {
        try {
            DownloadDataBaseParmeters parmeters = getObjFromList(parmetersId);
            parmeters.removeLayer(layerID);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getLayerOptions(String parmetersId, Promise promise)
    {
        try {
            DownloadDataBaseParmeters parmeters = getObjFromList(parmetersId);
            List<DownloadLayerOption> downloadLayerOptionList = parmeters.getLayerOptions();
            String DownloadLayerOptionId = "";
            WritableArray arr = Arguments.createArray();
            if (downloadLayerOptionList.size() > 0) {
                for (int i = 0; i < downloadLayerOptionList.size(); i++) {
                    DownloadLayerOptionId = JSDownloadLayerOption.registerId(downloadLayerOptionList.get(i));
                    arr.pushString(DownloadLayerOptionId);
                }
            }
            WritableMap map = Arguments.createMap();
            map.putArray("DownloadLayerOptionArr", arr);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }
}
