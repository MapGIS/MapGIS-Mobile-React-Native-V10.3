package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.core.geometry.Dot;
import com.zondy.mapgis.core.geometry.Dot3D;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class JSDot3D extends ReactContextBaseJavaModule {
    public static final String REACT_CLASS = "JSDot3D";
    public static Map<String, Dot3D> m_Dot3DList = new HashMap<String, Dot3D>();
    Dot m_Point2D;

    public JSDot3D(ReactApplicationContext context) {
        super(context);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public static Dot3D getObjFromList(String id) {
        return m_Dot3DList.get(id);
    }


    public static String registerId(Dot3D obj) {
        for (Map.Entry entry : m_Dot3DList.entrySet()) {
            if (obj.equals(entry.getValue())) {
                return (String) entry.getKey();
            }
        }
        Calendar calendar = Calendar.getInstance();
        String id = Long.toString(calendar.getTimeInMillis());
        m_Dot3DList.put(id, obj);
        return id;
    }

    @ReactMethod
    public void createObj(Promise promise) {
        try {
            Dot3D point3D = new Dot3D();
            String point3DId = registerId(point3D);
            WritableMap map = Arguments.createMap();
            map.putString("Dot3DId", point3DId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void createObjByXYZ(Double x, Double y, Double z, Promise promise) {
        try {
            Dot3D point3D = new Dot3D(x, y, z);
            String point3DId = registerId(point3D);
            WritableMap map = Arguments.createMap();
            map.putString("Dot3DId", point3DId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }
    @ReactMethod
    public void getX(String strDot3DId, Promise promise)
    {
        try {
            Dot3D point3D = JSDot3D.getObjFromList(strDot3DId);
            double dX = point3D.getX();
            promise.resolve(dX);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getY(String strDot3DId, Promise promise)
    {
        try {
            Dot3D point3D = JSDot3D.getObjFromList(strDot3DId);
            double dY = point3D.getY();
            promise.resolve(dY);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getZ(String strDot3DId, Promise promise)
    {
        try {
            Dot3D point3D = JSDot3D.getObjFromList(strDot3DId);
            double dZ = point3D.getZ();
            promise.resolve(dZ);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

   @ReactMethod
    public void setX(String strDot3DId, double x, Promise promise)
    {
        try {
            Dot3D point3D = JSDot3D.getObjFromList(strDot3DId);
            point3D.setX(x);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setY(String strDot3DId, double y, Promise promise)
    {
        try {
            Dot3D point3D = JSDot3D.getObjFromList(strDot3DId);
            point3D.setY(y);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setZ(String strDot3DId, double z, Promise promise)
    {
        try {
            Dot3D point3D = JSDot3D.getObjFromList(strDot3DId);
            point3D.setZ(z);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }
}
