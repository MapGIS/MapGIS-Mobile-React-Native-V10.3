package com.mapgis_mobile_reactnative;

import android.util.Log;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.core.geometry.Dot;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class JSDot extends ReactContextBaseJavaModule {
    public static final String REACT_CLASS = "JSDot";
    public static Map<String, Dot> m_Point2DList = new HashMap<String, Dot>();
    Dot m_Point2D;

    public JSDot(ReactApplicationContext context) {
        super(context);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public static Dot getObjFromList(String id){
        return m_Point2DList.get(id);
    }


    public static String registerId(Dot obj) {
        for (Map.Entry entry : m_Point2DList.entrySet()) {
            if (obj.equals(entry.getValue())) {
                String id = (String) entry.getKey();
                m_Point2DList.put(id, obj);
                return (String) entry.getKey();
            }
        }

        Calendar calendar = Calendar.getInstance();
        String id = Long.toString(calendar.getTimeInMillis());
        m_Point2DList.put(id, obj);
        return id;
    }

    @ReactMethod
    public void createObj(Promise promise){
        try{
            Dot point2D = new Dot();
            String point2DId = registerId(point2D);

            WritableMap map = Arguments.createMap();
            map.putString("point2DId",point2DId);
            promise.resolve(map);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void createObjByXY(Double x,Double y,Promise promise){
        try{
            Dot point2D = new Dot(x,y);
            String point2DId = registerId(point2D);

            WritableMap map = Arguments.createMap();
            map.putString("point2DId",point2DId);
            promise.resolve(map);
            Log.e("createObjByXY","createObjByXY() run!!!");
            Log.e("getX:",""+x);
            Log.e("point2DId:",point2DId);

        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getX(String point2DId,Promise promise){
        try{
            Dot point2D = getObjFromList(point2DId);
            double x = point2D.getX();
            Log.e("","getX() run!!!");
            Log.e("getX():",""+x);
            promise.resolve(x);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public double getY(String point2DId,Promise promise){
        try{
            Dot point2D = getObjFromList(point2DId);
            double y = point2D.getY();
            Log.e("getY:","getY() run!!!");
            Log.e("getY():",""+y);
            promise.resolve(y);
            return y;
        }catch (Exception e){
            promise.reject(e);
        }
        return 0.0;
    }
}

