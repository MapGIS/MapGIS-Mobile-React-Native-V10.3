package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.core.geometry.Dot;
import com.zondy.mapgis.core.spatial.CrossData;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class JSCrossData extends ReactContextBaseJavaModule {

    public static final String REACT_CLASS = "JSCrossData";
    public static Map<String, CrossData> mCrossDataList = new HashMap<String, CrossData>();

    public JSCrossData(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public static CrossData getObjFromList(String id) {
        return mCrossDataList.get(id);
    }

    public static String registerId(CrossData obj) {
        for (Map.Entry entry : mCrossDataList.entrySet()) {
            if (obj.equals(entry.getValue())) {
                return (String) entry.getKey();
            }
        }
        Calendar calendar = Calendar.getInstance();
        String id = Long.toString(calendar.getTimeInMillis());
        mCrossDataList.put(id, obj);
        return id;
    }

    @ReactMethod
    public void createObj(Promise promise){
        try {
            CrossData crossData = new CrossData();
            String crossDataId = registerId(crossData);

            WritableMap writableMap = Arguments.createMap();
            writableMap.putString("CrossDataId", crossDataId);
            promise.resolve(writableMap);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getCross(String crossDataId, Promise promise)
    {
        try {
            CrossData crossData = getObjFromList(crossDataId);
            Dot dot = crossData.getCross();
            String dotID = JSDot.registerId(dot);
            WritableMap map = Arguments.createMap();
            map.putString("point2DId", dotID);
            map.putDouble("x", dot.getX());
            map.putDouble("y", dot.getY());
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getDoteA(String crossDataId, Promise promise)
    {
        try {
            CrossData crossData = getObjFromList(crossDataId);
            int iVal = crossData.getDoteA();
            promise.resolve(iVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getDoteB(String crossDataId, Promise promise)
    {
        try {
            CrossData crossData = getObjFromList(crossDataId);
            int iVal = crossData.getDoteB();
            promise.resolve(iVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getDotAxy(String crossDataId, Promise promise)
    {
        try {
            CrossData crossData = getObjFromList(crossDataId);
            Dot dot = crossData.getDotAxy();
            String dotID = JSDot.registerId(dot);
            WritableMap map = Arguments.createMap();
            map.putString("point2DId", dotID);
            map.putDouble("x", dot.getX());
            map.putDouble("y", dot.getY());
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getDotBxy(String crossDataId, Promise promise)
    {
        try {
            CrossData crossData = getObjFromList(crossDataId);
            Dot dot = crossData.getDotBxy();
            String dotID = JSDot.registerId(dot);
            WritableMap map = Arguments.createMap();
            map.putString("point2DId", dotID);
            map.putDouble("x", dot.getX());
            map.putDouble("y", dot.getY());
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getlineAno(String crossDataId, Promise promise)
    {
        try {
            CrossData crossData = getObjFromList(crossDataId);
            int iVal = crossData.getlineAno();
            promise.resolve(iVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getlineBno(String crossDataId, Promise promise)
    {
        try {
            CrossData crossData = getObjFromList(crossDataId);
            int iVal = crossData.getlineBno();
            promise.resolve(iVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }
}
