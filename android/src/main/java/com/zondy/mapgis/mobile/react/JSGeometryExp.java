package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.core.geometry.Geometry;
import com.zondy.mapgis.core.geometry.GeometryExp;
import com.zondy.mapgis.core.srs.ElpTransParam;
import com.zondy.mapgis.core.srs.SRefData;

import java.util.Map;
import java.util.UUID;

public class JSGeometryExp extends  JSGeometry{
    private static final String REACT_CLASS = "JSGeometryExp";

    public JSGeometryExp(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public static GeometryExp getObjFromList(String id) {
        return (GeometryExp)mGeometryList.get(id);
    }

    public static String registerId(GeometryExp obj) {
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
    public void transSRS(String geometryExpId, String origSRefId, String destSRefId, Promise promise)
    {
        try {
            GeometryExp geometryExp = getObjFromList(geometryExpId);
            SRefData origSRef = JSSRefData.getObjFromList(origSRefId);
            SRefData destSRef = JSSRefData.getObjFromList(destSRefId);
            Geometry geometry = geometryExp.transSRS(origSRef, destSRef);
            String   geometryId = JSGeometry.registerId(geometry);
            WritableMap map = Arguments.createMap();
            map.putString("GeometryId", geometryId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void transSRS(String geometryExpId, String origSRefId, String destSRefId, String paramId, Promise promise)
    {
        try {
            GeometryExp geometryExp = getObjFromList(geometryExpId);
            SRefData origSRef = JSSRefData.getObjFromList(origSRefId);
            SRefData destSRef = JSSRefData.getObjFromList(destSRefId);
            ElpTransParam param = JSElpTransParam.getObjFromList(paramId);
            Geometry geometry = geometryExp.transSRS(origSRef, destSRef, param);
            String   geometryId = JSGeometry.registerId(geometry);
            WritableMap map = Arguments.createMap();
            map.putString("GeometryId", geometryId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }
}
