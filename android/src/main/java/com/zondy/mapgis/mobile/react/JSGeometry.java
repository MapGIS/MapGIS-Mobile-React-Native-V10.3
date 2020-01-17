package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.core.geometry.Geometry;
import com.zondy.mapgis.core.geometry.GeometryDimension;
import com.zondy.mapgis.core.geometry.Rect;
import com.zondy.mapgis.core.object.Enumeration;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class JSGeometry extends ReactContextBaseJavaModule {
    private static final String REACT_CLASS = "JSGeometry";
    protected static Map<String, Geometry> mGeometryList = new HashMap<String, Geometry>();

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
        String id = UUID.randomUUID().toString().substring(24);
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
            map.putString("RectId", rectId);
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
