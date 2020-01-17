package com.zondy.mapgis.mobile.react;

import android.util.Log;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.core.geometry.Dot;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author fjl 2019-6-18 下午2:52:36
 * @content 点对象Native组件
 */
public class JSDot extends ReactContextBaseJavaModule {
    private static final String REACT_CLASS = "JSDot";
    private static Map<String, Dot> m_Point2DList = new HashMap<String, Dot>();

    public JSDot(ReactApplicationContext context) {
        super(context);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public static Dot getObjFromList(String id) {
        return m_Point2DList.get(id);
    }


    public static String registerId(Dot obj) {
        for (Map.Entry entry : m_Point2DList.entrySet()) {
            if (obj.equals(entry.getValue())) {
                return (String) entry.getKey();
            }
        }

        String id = UUID.randomUUID().toString().substring(24);
        m_Point2DList.put(id, obj);

        return id;
    }

    @ReactMethod
    public void createObj(Promise promise) {
        try {
            Dot point2D = new Dot();
            String point2DId = registerId(point2D);

            WritableMap map = Arguments.createMap();
            map.putString("point2DId", point2DId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void createObjByXY(Double x, Double y, Promise promise) {
        try {
            Dot point2D = new Dot(x, y);
            String point2DId = registerId(point2D);

            WritableMap map = Arguments.createMap();
            map.putString("point2DId", point2DId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getX(String point2DId, Promise promise) {
        try {
            Dot point2D = getObjFromList(point2DId);
            double x = point2D.getX();
            promise.resolve(x);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public double getY(String point2DId, Promise promise) {
        try {
            Dot point2D = getObjFromList(point2DId);
            double y = point2D.getY();
            promise.resolve(y);
            return y;
        } catch (Exception e) {
            promise.reject(e);
        }
        return 0.0;
    }
}

