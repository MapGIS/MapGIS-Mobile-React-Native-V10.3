package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.core.geometry.Rect;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * @author fjl 2019-6-18 下午2:52:36
 * @content 矩形对象Native组件
 */
public class JSRect extends ReactContextBaseJavaModule {
    public static final String REACT_CLASS = "JSRect";
    public static Map<String, Rect> mRectList = new HashMap<String, Rect>();


    public JSRect(ReactApplicationContext context) {
        super(context);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public static Rect getObjFromList(String id) {
        return mRectList.get(id);
    }


    public static String registerId(Rect obj) {
        for (Map.Entry entry : mRectList.entrySet()) {
            if (obj.equals(entry.getValue())) {
                return (String) entry.getKey();
            }
        }
        Calendar calendar = Calendar.getInstance();
        String id = Long.toString(calendar.getTimeInMillis());
        mRectList.put(id, obj);
        return id;
    }

    @ReactMethod
    public void createObj(Promise promise) {
        try {
            Rect rect = new Rect();
            String RectId = registerId(rect);

            WritableMap map = Arguments.createMap();
            map.putString("RectId", RectId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void createObjByXY(Double xMin, Double yMin, Double xMax, Double yMax, Promise promise) {
        try {
            Rect rect = new Rect(xMin, yMin, xMax, yMax);
            String RectId = registerId(rect);

            WritableMap map = Arguments.createMap();
            map.putString("RectId", RectId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getXMin(String rectID, Promise promise) {
        try {
            Rect rect = getObjFromList(rectID);
            double xMin = rect.getXMin();

            promise.resolve(xMin);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getYMin(String rectID, Promise promise) {
        try {
            Rect rect = getObjFromList(rectID);
            double yMin = rect.getYMin();
            promise.resolve(yMin);

        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getXMax(String rectID, Promise promise) {
        try {
            Rect rect = getObjFromList(rectID);
            double xMax = rect.getXMax();
            promise.resolve(xMax);

        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getYMax(String rectID, Promise promise) {
        try {
            Rect rect = getObjFromList(rectID);
            double yMax = rect.getYMax();
            promise.resolve(yMax);

        } catch (Exception e) {
            promise.reject(e);
        }
    }
}
