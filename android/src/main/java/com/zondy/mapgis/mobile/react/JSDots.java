package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.core.geometry.Dot;
import com.zondy.mapgis.core.geometry.Dots;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class JSDots extends ReactContextBaseJavaModule {
    public static final String REACT_CLASS = "JSDots";
    public static Map<String, Dots> mDotsList = new HashMap<String, Dots>();


    public JSDots(ReactApplicationContext context) {
        super(context);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public static Dots getObjFromList(String id) {
        return mDotsList.get(id);
    }


    public static String registerId(Dots obj) {
        for (Map.Entry entry : mDotsList.entrySet()) {
            if (obj.equals(entry.getValue())) {
                return (String) entry.getKey();
            }
        }
        Calendar calendar = Calendar.getInstance();
        String id = Long.toString(calendar.getTimeInMillis());
        mDotsList.put(id, obj);
        return id;
    }

    @ReactMethod
    public void createObj(Promise promise) {
        try {
            Dots dots = new Dots();
            String dotsId = registerId(dots);

            WritableMap map = Arguments.createMap();
            map.putString("DotsId", dotsId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void size(String strDotsId, Promise promise)
    {
        try {
            Dots dots = getObjFromList(strDotsId);
            int size = dots.size();
            promise.resolve(size);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void append(String strDotsId, String strDotId, Promise promise)
    {
        try {
            Dots dots = getObjFromList(strDotsId);
            Dot dot = JSDot.getObjFromList(strDotId);
            int val = dots.append(dot);
            promise.resolve(val);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void appendDots(String strDotsId, String strDotLstId, Promise promise)
    {
        try {
            Dots dots = getObjFromList(strDotsId);
            Dots dotLst = JSDots.getObjFromList(strDotLstId);
            int val = dots.append(dotLst);
            promise.resolve(val);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void remove(String strDotsId, int index, Promise promise)
    {
        try {
            Dots dots = getObjFromList(strDotsId);
            int val = dots.remove(index);
            promise.resolve(val);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void clear(String strDotsId, Promise promise)
    {
        try {
            Dots dots = getObjFromList(strDotsId);
            int val = dots.clear();
            promise.resolve(val);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void get(String strDotsId, int index, Promise promise)
    {
        try {
            Dots dots = getObjFromList(strDotsId);
            Dot d = dots.get(index);
            String dotId = JSDot.registerId(d);
            WritableMap map = Arguments.createMap();
            map.putString("point2DId", dotId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }
}
