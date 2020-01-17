package com.zondy.mapgis.mobile.react;

import android.graphics.PointF;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author fjl 2019-6-18 下午2:52:36
 * @content 视图对象Native组件
 */
public class JSPointF extends ReactContextBaseJavaModule {
    private static final String REACT_CLASS = "JSPointF";
    private static Map<String, PointF> mPointfList = new HashMap<String, PointF>();

    public JSPointF(ReactApplicationContext context) {
        super(context);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public static PointF getObjFromList(String id) {
        return mPointfList.get(id);
    }


    public static String registerId(PointF obj) {
        for (Map.Entry entry : mPointfList.entrySet()) {
            if (obj.equals(entry.getValue())) {
                return (String) entry.getKey();
            }
        }

        String id = UUID.randomUUID().toString().substring(24);
        mPointfList.put(id, obj);

        return id;
    }

    @ReactMethod
    public void createObj(Promise promise) {
        try {
            PointF pointF = new PointF();
            String pointFId = registerId(pointF);

            WritableMap map = Arguments.createMap();
            map.putString("PointFId", pointFId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void createObjByXY(Float x, Float y, Promise promise) {
        try {
            PointF pointF = new PointF(x, y);
            String pointFId = registerId(pointF);

            WritableMap map = Arguments.createMap();
            map.putString("PointFId", pointFId);
            promise.resolve(map);

        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getX(String pointFId, Promise promise) {
        try {
            PointF point2D = getObjFromList(pointFId);
            float x = point2D.x;
            promise.resolve(x);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public double getY(String pointFId, Promise promise) {
        try {
            PointF point2D = getObjFromList(pointFId);
            float y = point2D.y;
            promise.resolve(y);
            return y;
        } catch (Exception e) {
            promise.reject(e);
        }
        return 0.0;
    }
}
