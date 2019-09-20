package com.zondy.mapgis.mobile.react;

import android.graphics.Bitmap;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;;
import com.zondy.mapgis.core.geometry.Dot;
import com.zondy.mapgis.core.geometry.Geometry;
import com.zondy.mapgis.core.geometry.GeometryDimension;
import com.zondy.mapgis.core.geometry.GeometryType;
import com.zondy.mapgis.core.geometry.Rect;
import com.zondy.mapgis.core.object.Enumeration;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class JSGeometry extends ReactContextBaseJavaModule {
    public static final String REACT_CLASS = "JSGeometry";
    public static Map<String, Geometry> mGeometryList = new HashMap<String, Geometry>();
    public JSGeometry(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public static Geometry getObjFromList(String id) {
        return mGeometryList.get(id);
    }

    public static String registerId(Geometry obj) {
        for (Map.Entry entry : mGeometryList.entrySet()) {
            if (obj.equals(entry.getValue())) {
                return (String) entry.getKey();
            }
        }
        Calendar calendar = Calendar.getInstance();
        String id = Long.toString(calendar.getTimeInMillis());
        mGeometryList.put(id, obj);
        return id;
    }

    @ReactMethod
    public void calRect(String geometryId, Promise promise)
    {
        try {
            Geometry geometry = getObjFromList(geometryId);
            Rect  rect = geometry.calRect();
            String rectId = JSRect.registerId(rect);
            WritableMap map = Arguments.createMap();
            map.putString("rectId", rectId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void isInRect(String geometryId, String rectId, Promise promise)
    {
        try {
            Geometry geometry = getObjFromList(geometryId);
            Rect rect = JSRect.getObjFromList(rectId);
            int  iVal = (int)geometry.isInRect(rect);
            promise.resolve(iVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void isInterRect(String geometryId, String rectId, Promise promise)
    {
        try {
            Geometry geometry = getObjFromList(geometryId);
            Rect rect = JSRect.getObjFromList(rectId);
            int  iVal = (int)geometry.isInterRect(rect);
            promise.resolve(iVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getDimension(String geometryId, Promise promise)
    {
        try {
            Geometry geometry = getObjFromList(geometryId);
            GeometryDimension dimension = geometry.getDimension();
            int geoDimension = Enumeration.getValueByName(GeometryDimension.class, dimension.name());
            promise.resolve(geoDimension);
        } catch (Exception e) {
            promise.reject(e);
        }
    }
}
