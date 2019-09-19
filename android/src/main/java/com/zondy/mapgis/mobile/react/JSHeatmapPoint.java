package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.android.graphic.HeatmapPoint;
import com.zondy.mapgis.core.geometry.Dot;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class JSHeatmapPoint extends ReactContextBaseJavaModule {

    public static final String REACT_CLASS = "JSHeatmapPoint";
    public static Map<String, HeatmapPoint> mHeatmapPointList = new HashMap<String, HeatmapPoint>();

    public JSHeatmapPoint(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public static HeatmapPoint getObjFromList(String id) {
        return mHeatmapPointList.get(id);
    }

    public static String registerId(HeatmapPoint obj) {
        for (Map.Entry entry : mHeatmapPointList.entrySet()) {
            if (obj.equals(entry.getValue())) {
                return (String) entry.getKey();
            }
        }
        Calendar calendar = Calendar.getInstance();
        String id = Long.toString(calendar.getTimeInMillis());
        mHeatmapPointList.put(id, obj);
        return id;
    }

    @ReactMethod
    public void createObj(Promise promise) {
        try {
            HeatmapPoint heatmapPoint = new HeatmapPoint();
            String strHeatmapPointId = registerId(heatmapPoint);

            WritableMap map = Arguments.createMap();
            map.putString("HeatmapPointId", strHeatmapPointId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void createObj(String pointId, double value, Promise promise) {
        try {
            Dot point = JSDot.getObjFromList(pointId);
            HeatmapPoint heatmapPoint = new HeatmapPoint(point, value);
            String strHeatmapPointId = registerId(heatmapPoint);

            WritableMap map = Arguments.createMap();
            map.putString("HeatmapPointId", strHeatmapPointId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setPoint(String heatMapPointId, String dotID, Promise promise) {
        try {
            HeatmapPoint heatmapPoint = getObjFromList(heatMapPointId);
            Dot point = JSDot.getObjFromList(dotID);
            heatmapPoint.setPoint(point);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getPoint(String heatMapPointId, Promise promise) {
        try {
            HeatmapPoint heatmapPoint = getObjFromList(heatMapPointId);
            Dot dot = heatmapPoint.getPoint();

            String pointID = JSDot.registerId(dot);
            WritableMap map = Arguments.createMap();
            map.putString("pointID", pointID);

            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public  void  setValue(String heatMapPointId, double value, Promise promise)
    {
       try {
           HeatmapPoint heatmapPoint = getObjFromList(heatMapPointId);
           heatmapPoint.setValue(value);
           promise.resolve(true);
       } catch (Exception e) {
           promise.reject(e);
       }
    }

    @ReactMethod
    public  void  getValue(String heatMapPointId, Promise promise)
    {
        try {
            HeatmapPoint heatmapPoint = getObjFromList(heatMapPointId);
            double value = heatmapPoint.getValue();

            promise.resolve(value);
        } catch (Exception e) {
            promise.reject(e);
        }
    }
}
