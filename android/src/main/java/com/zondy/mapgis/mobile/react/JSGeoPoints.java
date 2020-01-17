package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.core.geometry.DistanceType;
import com.zondy.mapgis.core.geometry.Dot3D;
import com.zondy.mapgis.core.geometry.Dots3D;
import com.zondy.mapgis.core.geometry.GeoPoints;
import com.zondy.mapgis.core.geometry.Geometry;
import com.zondy.mapgis.core.geometry.GeometryDimension;
import com.zondy.mapgis.core.geometry.GeometryType;
import com.zondy.mapgis.core.object.Enumeration;

import java.util.Map;
import java.util.UUID;

public class JSGeoPoints extends JSGeometryExp{
    private static final String REACT_CLASS = "JSGeoPoints";

    public JSGeoPoints(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public static GeoPoints getObjFromList(String id) {
        return (GeoPoints)mGeometryList.get(id);
    }

    public static String registerId(GeoPoints obj) {
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
    public void createObj(Promise promise) {
        try {
            GeoPoints geoPoints = new GeoPoints();
            String geoPointsId = registerId(geoPoints);

            WritableMap map = Arguments.createMap();
            map.putString("GeoPointsId", geoPointsId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getType(String geoPointsId, Promise promise)
    {
        try {
            GeoPoints geoPoints = getObjFromList(geoPointsId);
            GeometryType geometryType = geoPoints.getType();
            int type = Enumeration.getValueByName(GeometryType.class, geometryType.name());
            promise.resolve(type);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getDimension(String geoPointsId, Promise promise)
    {
        try {
            GeoPoints geoPoints = getObjFromList(geoPointsId);
            GeometryDimension dimension = geoPoints.getDimension();
            int geoDimension = Enumeration.getValueByName(GeometryDimension.class, dimension.name());
            promise.resolve(geoDimension);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

   @ReactMethod
    public void distance(String geoPointsId, int distanceType, String destGeomId, Promise promise)
    {
        try {
            GeoPoints geoPoints = getObjFromList(geoPointsId);
            Geometry destGeometry = JSGeometry.getObjFromList(destGeomId);
            DistanceType type = (DistanceType) Enumeration.parse(DistanceType.class, distanceType);
            double dVal = geoPoints.distance(type,destGeometry);
            promise.resolve(dVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void append(String geoPointsId, String dot3DId, Promise promise)
    {
        try {
            GeoPoints geoPoints = getObjFromList(geoPointsId);
            Dot3D dot3D = JSDot3D.getObjFromList(dot3DId);
            int iVal = (int)geoPoints.append(dot3D);
            promise.resolve(iVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void del(String geoPointsId, int iIndex, Promise promise)
    {
        try {
            GeoPoints geoPoints = getObjFromList(geoPointsId);
            int iVal = (int)geoPoints.del(iIndex);
            promise.resolve(iVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void get(String geoPointsId, int iIndex, Promise promise)
    {
        try {
            GeoPoints geoPoints = getObjFromList(geoPointsId);
            Dot3D dot3D = geoPoints.get(iIndex);
            String dot3DId = JSDot3D.registerId(dot3D);
            WritableMap map = Arguments.createMap();
            map.putString("Dot3DId", dot3DId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getDotNum(String geoPointsId, Promise promise)
    {
        try {
            GeoPoints geoPoints = getObjFromList(geoPointsId);
            int iNum = (int)geoPoints.getDotNum();
            promise.resolve(iNum);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getDots(String geoPointsId, Promise promise)
    {
        try {
            GeoPoints geoPoints = getObjFromList(geoPointsId);
            Dots3D dots3D = geoPoints.getDots();
            String dots3DId = JSDots3D.registerId(dots3D);
            WritableMap map = Arguments.createMap();
            map.putString("Dots3DId", dots3DId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setDots(String geoPointsId, String dots3DId, Promise promise)
    {
        try {
            GeoPoints geoPoints = getObjFromList(geoPointsId);
            Dots3D dots = JSDots3D.getObjFromList(dots3DId);
            int iVal = (int)geoPoints.setDots(dots);
            promise.resolve(iVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }
}
