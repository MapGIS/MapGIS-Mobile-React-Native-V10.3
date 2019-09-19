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

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class JSGeoPoints extends JSGeometryExp{

    public static final String REACT_CLASS = "JSGeoPoints";
    //public static Map<String, GeoPoints> mGeoPointsList = new HashMap<String, GeoPoints>();
    GeoPoints m_GeoPoints;
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
        Calendar calendar = Calendar.getInstance();
        String id = Long.toString(calendar.getTimeInMillis());
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
            long lVal = geoPoints.append(dot3D);
            promise.resolve(lVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void del(String geoPointsId, long iIndex, Promise promise)
    {
        try {
            GeoPoints geoPoints = getObjFromList(geoPointsId);
            long lVal = geoPoints.del(iIndex);
            promise.resolve(lVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void get(String geoPointsId, long iIndex, Promise promise)
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
            long num = geoPoints.getDotNum();
            promise.resolve(num);
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
            long lVal = geoPoints.setDots(dots);
            promise.resolve(lVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }
}
