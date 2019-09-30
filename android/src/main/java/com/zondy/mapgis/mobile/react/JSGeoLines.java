package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.core.geometry.DistanceType;
import com.zondy.mapgis.core.geometry.GeoLine;
import com.zondy.mapgis.core.geometry.GeoLines;
import com.zondy.mapgis.core.geometry.GeoPolygon;
import com.zondy.mapgis.core.geometry.Geometry;
import com.zondy.mapgis.core.geometry.GeometryDimension;
import com.zondy.mapgis.core.geometry.GeometryType;
import com.zondy.mapgis.core.object.Enumeration;
import com.zondy.mapgis.core.srs.SRefData;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class JSGeoLines extends JSGeometryExp{
    public static final String REACT_CLASS = "JSGeoLines";
   // public static Map<String, GeoLines> mGeoLinesList = new HashMap<String, GeoLines>();
    GeoLines m_GeoLines;
    public JSGeoLines(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public static GeoLines getObjFromList(String id) {
        return (GeoLines)mGeometryList.get(id);
    }

    public static String registerId(GeoLines obj) {
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
            GeoLines geoLines = new GeoLines();
            String geoLinesId = registerId(geoLines);

            WritableMap map = Arguments.createMap();
            map.putString("GeoLinesId", geoLinesId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getType(String geoLinesId, Promise promise)
    {
        try {
            GeoLines geoLines = getObjFromList(geoLinesId);
            GeometryType geometryType = geoLines.getType();
            int type = Enumeration.getValueByName(GeometryType.class, geometryType.name());
            promise.resolve(type);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getDimension(String geoLinesId, Promise promise)
    {
        try {
            GeoLines geoLines = getObjFromList(geoLinesId);
            GeometryDimension dimension = geoLines.getDimension();
            int geoDimension = Enumeration.getValueByName(GeometryDimension.class, dimension.name());
            promise.resolve(geoDimension);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

   @ReactMethod
    public void distance(String geoLinesId, int distanceType, String destGeomId, Promise promise)
    {
        try {
            GeoLines geoLines = getObjFromList(geoLinesId);
            Geometry destGeometry = JSGeometry.getObjFromList(destGeomId);
            DistanceType type = (DistanceType) Enumeration.parse(DistanceType.class, distanceType);
            double dVal = geoLines.distance(type, destGeometry);
            promise.resolve(dVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void del(String geoLinesId, int index, Promise promise)
    {
        try {
            GeoLines geoLines = getObjFromList(geoLinesId);
            int iVal = (int)geoLines.del(index);
            promise.resolve(index);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getNum(String geoLinesId, Promise promise)
    {
        try {
            GeoLines geoLines = getObjFromList(geoLinesId);
            int iNum = (int)geoLines.getNum();
            promise.resolve(iNum);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void append(String geoLinesId, String geoLineId, Promise promise)
    {
        try {
            GeoLines geoLines = getObjFromList(geoLinesId);
            GeoLine geoLine = JSGeoLine.getObjFromList(geoLineId);
            int iVal = (int)geoLines.append(geoLine);
            promise.resolve(iVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void update(String geoLinesId, int index, String geoLineId, Promise promise)
    {
        try {
            GeoLines geoLines = getObjFromList(geoLinesId);
            GeoLine geoLine = JSGeoLine.getObjFromList(geoLineId);
            int iVal = (int)geoLines.update(index, geoLine);
            promise.resolve(iVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getLineType(String geoLinesId, int index, Promise promise)
    {
        try {
            GeoLines geoLines = getObjFromList(geoLinesId);
            GeometryType geometryType = geoLines.getLineType(index);
            int type = Enumeration.getValueByName(GeometryType.class, geometryType.name());
            promise.resolve(type);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

   @ReactMethod
    public void getLine(String geoLinesId, int index, Promise promise)
    {
        try {
            GeoLines geoLines = getObjFromList(geoLinesId);
            GeoLine geoLine = geoLines.getLine(index);
            String geoLineId = JSGeoLine.registerId(geoLine);
            WritableMap map = Arguments.createMap();
            map.putString("GeoLineId", geoLineId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void calLengthOfSRef(String geoLinesId, String sRefId, Promise promise)
    {
        try {
            GeoLines geoLines = getObjFromList(geoLinesId);
            SRefData sRef = JSSRefData.getObjFromList(sRefId);
            double length = geoLines.calLength(sRef);
            promise.resolve(length);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void calLength(String geoLinesId, Promise promise)
    {
        try {
            GeoLines geoLines = getObjFromList(geoLinesId);
            double length = geoLines.calLength();
            promise.resolve(length);
        } catch (Exception e) {
            promise.reject(e);
        }
    }
}
