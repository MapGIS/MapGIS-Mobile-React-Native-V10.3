package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.core.geometry.Dot3D;
import com.zondy.mapgis.core.geometry.Dots3D;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class JSDots3D extends ReactContextBaseJavaModule {
    private static final String REACT_CLASS = "JSDots3D";
    private static Map<String, Dots3D> mDots3DList = new HashMap<String, Dots3D>();

    public JSDots3D(ReactApplicationContext context) {
        super(context);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public static Dots3D getObjFromList(String id) {
        return mDots3DList.get(id);
    }


    public static String registerId(Dots3D obj) {
        for (Map.Entry entry : mDots3DList.entrySet()) {
            if (obj.equals(entry.getValue())) {
                return (String) entry.getKey();
            }
        }
        String id = UUID.randomUUID().toString().substring(24);
        mDots3DList.put(id, obj);
        return id;
    }

    @ReactMethod
    public void createObj(Promise promise) {
        try {
            Dots3D dots3D = new Dots3D();
            String dotsId = registerId(dots3D);
            WritableMap map = Arguments.createMap();
            map.putString("Dots3DId", dotsId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void size(String strDots3DId, Promise promise)
    {
        try
        {
            Dots3D dots3D = getObjFromList(strDots3DId);
            int val = dots3D.size();
            promise.resolve(val);
        }
        catch (Exception e)
        {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void append(String dots3DId, String dot3DId, Promise promise)
    {
        try
        {
            Dots3D dots3D = getObjFromList(dots3DId);
            Dot3D dot3D = JSDot3D.getObjFromList(dot3DId);
            int val = dots3D.append(dot3D);
            promise.resolve(val);
        }
        catch (Exception e)
        {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void appendDots3D(String dots3DId, String ds3DId, Promise promise)
    {
        try
        {
            Dots3D dots3D = getObjFromList(dots3DId);
            Dots3D ds3D = JSDots3D.getObjFromList(ds3DId);
            int val = dots3D.append(ds3D);
            promise.resolve(val);
        }
        catch (Exception e)
        {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void remove(String dots3DId, int index, Promise promise)
    {
        try
        {
            Dots3D dots3D = getObjFromList(dots3DId);
            int val = dots3D.remove(index);
            promise.resolve(val);
        }
        catch (Exception e)
        {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void clear(String dots3DId, Promise promise)
    {
        try
        {
            Dots3D dots3D = getObjFromList(dots3DId);
            int val = dots3D.clear();
            promise.resolve(val);
        }
        catch (Exception e)
        {
            promise.reject(e);
        }
    }

   @ReactMethod
    public void get(String dots3DId, int index, Promise promise)
    {
        try
        {
            Dots3D dots3D = getObjFromList(dots3DId);
            Dot3D dot3D = dots3D.get(index);
            String dot3DId = JSDot3D.registerId(dot3D);
            WritableMap map = Arguments.createMap();
            map.putString("Dot3DId", dot3DId);
            promise.resolve(map);
        }
        catch (Exception e)
        {
            promise.reject(e);
        }
    }
}
