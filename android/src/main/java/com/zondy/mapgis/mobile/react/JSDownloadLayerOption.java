package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.core.featureservice.DownloadLayerOption;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class JSDownloadLayerOption extends ReactContextBaseJavaModule {

    public static final String REACT_CLASS = "JSDownloadLayerOption";
    public static Map<String, DownloadLayerOption> mDownloadLayerOptionList = new HashMap<String, DownloadLayerOption>();

    public JSDownloadLayerOption(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public static DownloadLayerOption getObjFromList(String id) {
        return mDownloadLayerOptionList.get(id);
    }

    public static String registerId(DownloadLayerOption obj) {
        for (Map.Entry entry : mDownloadLayerOptionList.entrySet()) {
            if (obj.equals(entry.getValue())) {
                return (String) entry.getKey();
            }
        }
        Calendar calendar = Calendar.getInstance();
        String id = Long.toString(calendar.getTimeInMillis());
        mDownloadLayerOptionList.put(id, obj);
        return id;
    }

    @ReactMethod
    public void createObj(String strWhereClause, int layerId, String strLayerName, int iLayerType, Promise promise) {
        try {
            DownloadLayerOption option = new DownloadLayerOption(strWhereClause, layerId, strLayerName, iLayerType);
            String optionId = registerId(option);

            WritableMap map = Arguments.createMap();
            map.putString("DownloadLayerOptionId", optionId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getWhereClause(String optionId, Promise promise)
    {
        try {
            DownloadLayerOption option = getObjFromList(optionId);
            String whereClause = option.getWhereClause();
            promise.resolve(whereClause);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setWhereClause(String optionId, String whereClause, Promise promise)
    {
        try {
            DownloadLayerOption option = getObjFromList(optionId);
            option.setWhereClause(whereClause);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getLayerId(String optionId, Promise promise)
    {
        try {
            DownloadLayerOption option = getObjFromList(optionId);
            int layerId = option.getLayerId();
            promise.resolve(layerId);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setLayerId(String optionId, int layerId, Promise promise)
    {
        try {
            DownloadLayerOption option = getObjFromList(optionId);
            option.setLayerId(layerId);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getName(String optionId, Promise promise)
    {
        try {
            DownloadLayerOption option = getObjFromList(optionId);
            String name = option.getName();
            promise.resolve(name);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setName(String optionId, String strLayerName, Promise promise)
    {
        try {
            DownloadLayerOption option = getObjFromList(optionId);
            option.setName(strLayerName);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getType(String optionId, Promise promise)
    {
        try {
            DownloadLayerOption option = getObjFromList(optionId);
            int type = option.getType();
            promise.resolve(type);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setType(String optionId, int iLayerType, Promise promise)
    {
        try {
            DownloadLayerOption option = getObjFromList(optionId);
            option.setType(iLayerType);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }
}
