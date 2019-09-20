package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.core.geometry.DistanceType;
import com.zondy.mapgis.core.geometry.GeoPolygon;
import com.zondy.mapgis.core.geometry.GeoPolygons;
import com.zondy.mapgis.core.geometry.Geometry;
import com.zondy.mapgis.core.geometry.GeometryDimension;
import com.zondy.mapgis.core.geometry.GeometryType;
import com.zondy.mapgis.core.object.Enumeration;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class JSGeoPolygons extends JSGeometryExp{

    public static final String REACT_CLASS = "JSGeoPolygons";
   // public static Map<String, GeoPolygons> mGeoPolygonsList = new HashMap<String, GeoPolygons>();
    GeoPolygons m_GeoPolygons;
    public JSGeoPolygons(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public static GeoPolygons getObjFromList(String id) {
        return (GeoPolygons)mGeometryList.get(id);
    }

    public static String registerId(GeoPolygons obj) {
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
    public void createObj(Promise promise) {
        try {
            GeoPolygons geoPolygons = new GeoPolygons();
            String geoPolygonsId = registerId(geoPolygons);

            WritableMap map = Arguments.createMap();
            map.putString("GeoPolygonsId", geoPolygonsId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getType(String geoPolygonsId, Promise promise)
    {
        try {
            GeoPolygons geoPolygons = getObjFromList(geoPolygonsId);
            GeometryType geometryType = geoPolygons.getType();
            int type = Enumeration.getValueByName(GeometryType.class, geometryType.name());
            promise.resolve(type);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getDimension(String geoPolygonsId, Promise promise)
    {
        try {
            GeoPolygons geoPolygons = getObjFromList(geoPolygonsId);
            GeometryDimension dimension = geoPolygons.getDimension();
            int geoDimension = Enumeration.getValueByName(GeometryDimension.class, dimension.name());
            promise.resolve(geoDimension);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void distance(String geoPolygonsId, int distanceType, String destGeomId, Promise promise)
    {
        try {
            GeoPolygons geoPolygons = getObjFromList(geoPolygonsId);
            Geometry destGeometry = JSGeometry.getObjFromList(destGeomId);
            DistanceType type = (DistanceType) Enumeration.parse(DistanceType.class, distanceType);
            double dVal = geoPolygons.distance(type, destGeometry);
            promise.resolve(dVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void del(String geoPolygonsId, int iIndex, Promise promise)
    {
        try {
            GeoPolygons geoPolygons = getObjFromList(geoPolygonsId);
            int iVal = (int)geoPolygons.del(iIndex);
            promise.resolve(iVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getNum(String geoPolygonsId, Promise promise)
    {
        try {
            GeoPolygons geoPolygons = getObjFromList(geoPolygonsId);
            int iNum = (int)geoPolygons.getNum();
            promise.resolve(iNum);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

   @ReactMethod
    public void append(String geoPolygonsId, String regId, Promise promise)
    {
        try {
            GeoPolygons geoPolygons = getObjFromList(geoPolygonsId);
            GeoPolygon reg = JSGeoPolygon.getObjFromList(regId);
            int iVal = (int)geoPolygons.append(reg);
            promise.resolve(iVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getPolygon(String geoPolygonsId, int index, Promise promise)
    {
        try {
            GeoPolygons geoPolygons = getObjFromList(geoPolygonsId);
            GeoPolygon reg = geoPolygons.getPolygon(index);
            String geoPolygonId = JSGeoPolygon.registerId(reg);
            WritableMap map = Arguments.createMap();
            map.putString("GeoPolygonId", geoPolygonId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }
}
