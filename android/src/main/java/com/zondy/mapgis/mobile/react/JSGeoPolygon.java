package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.core.geometry.DistanceType;
import com.zondy.mapgis.core.geometry.Dot;
import com.zondy.mapgis.core.geometry.Dots;
import com.zondy.mapgis.core.geometry.GeoLines;
import com.zondy.mapgis.core.geometry.GeoPolygon;
import com.zondy.mapgis.core.geometry.Geometry;
import com.zondy.mapgis.core.geometry.GeometryDimension;
import com.zondy.mapgis.core.geometry.GeometryType;
import com.zondy.mapgis.core.object.Enumeration;
import com.zondy.mapgis.core.object.IntList;
import com.zondy.mapgis.core.srs.SRefData;

import java.util.Map;
import java.util.UUID;

public class JSGeoPolygon extends JSGeometryExp{
    private static final String REACT_CLASS = "JSGeoPolygon";

    public JSGeoPolygon(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public static GeoPolygon getObjFromList(String id) {
        return (GeoPolygon)mGeometryList.get(id);
    }

    public static String registerId(GeoPolygon obj) {
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
            GeoPolygon geoPolygon = new GeoPolygon();
            String geoPolygonId = registerId(geoPolygon);

            WritableMap map = Arguments.createMap();
            map.putString("GeoPolygonId", geoPolygonId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

   @ReactMethod
    public void getType(String geoPolygonId, Promise promise)
    {
        try {
            GeoPolygon geoPolygon = getObjFromList(geoPolygonId);
            GeometryType geometryType = geoPolygon.getType();
            int type = Enumeration.getValueByName(GeometryType.class, geometryType.name());
            promise.resolve(type);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getDimension(String geoPolygonId, Promise promise)
    {
        try {
            GeoPolygon geoPolygon = getObjFromList(geoPolygonId);
            GeometryDimension dimension = geoPolygon.getDimension();
            int geoDimension = Enumeration.getValueByName(GeometryDimension.class, dimension.name());
            promise.resolve(geoDimension);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

   @ReactMethod
    public void distance(String geoPolygonId, int distanceType, String destGeomId, Promise promise)
    {
        try {
            GeoPolygon geoPolygon = getObjFromList(geoPolygonId);
            Geometry destGeometry = JSGeometry.getObjFromList(destGeomId);
            DistanceType type = (DistanceType) Enumeration.parse(DistanceType.class, distanceType);
            double dVal = geoPolygon.distance(type, destGeometry);
            promise.resolve(dVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void del(String geoPolygonId, int iIndex, Promise promise)
    {
        try {
            GeoPolygon geoPolygon = getObjFromList(geoPolygonId);
            int iVal = (int)geoPolygon.del(iIndex);
            promise.resolve(iVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getCircleNum(String geoPolygonId, Promise promise)
    {
        try {
            GeoPolygon geoPolygon = getObjFromList(geoPolygonId);
            int iNum = (int)geoPolygon.getCircleNum();
            promise.resolve(iNum);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void append(String geoPolygonId, String geoLinesId, Promise promise)
    {
        try {
            GeoPolygon geoPolygon = getObjFromList(geoPolygonId);
            GeoLines geoLines = JSGeoLines.getObjFromList(geoLinesId);
            int iVal = (int)geoPolygon.append(geoLines);
            promise.resolve(iVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

   @ReactMethod
    public void get(String geoPolygonId, int index, Promise promise)
    {
        try {
            GeoPolygon geoPolygon = getObjFromList(geoPolygonId);
            GeoLines geoLines = geoPolygon.get(index);
            String geoLinesId = JSGeoLines.registerId(geoLines);
            WritableMap map = Arguments.createMap();
            map.putString("GeoLinesId", geoLinesId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setDots(String geoPolygonId, String dotsId, ReadableArray numArray, Promise promise)
    {
        try {
            GeoPolygon geoPolygon = getObjFromList(geoPolygonId);
            Dots dots = JSDots.getObjFromList(dotsId);
            IntList iNumList = new IntList();
            for (int i = 0;i < numArray.size(); i++)
            {
                iNumList.append(numArray.getInt(i));
            }
            int iVal = (int)geoPolygon.setDots(dots,iNumList);
            promise.resolve(iVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

   @ReactMethod
    public void getDots(String geoPolygonId, int index, Promise promise)
    {
        try {
            GeoPolygon geoPolygon = getObjFromList(geoPolygonId);
            Dots dots = geoPolygon.getDots(index);
            String dotsId = JSDots.registerId(dots);
            WritableMap map = Arguments.createMap();
            map.putString("DotsID",dotsId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void calAreaOfSRef(String geoPolygonId, String sRefId, Promise promise)
    {
        try {
            GeoPolygon geoPolygon = getObjFromList(geoPolygonId);
            SRefData sRef = JSSRefData.getObjFromList(sRefId);
            double area = geoPolygon.calArea(sRef);
            promise.resolve(area);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void calArea(String geoPolygonId, Promise promise)
    {
        try {
            GeoPolygon geoPolygon = getObjFromList(geoPolygonId);
            double area = geoPolygon.calArea();
            promise.resolve(area);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void calPerimeter(String geoPolygonId, String sRefId, Promise promise)
    {
        try {
            GeoPolygon geoPolygon = getObjFromList(geoPolygonId);
            SRefData sRef = JSSRefData.getObjFromList(sRefId);
            double dVal = geoPolygon.calPerimeter(sRef);
            promise.resolve(dVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void calPerimeter(String geoPolygonId, Promise promise)
    {
        try {
            GeoPolygon geoPolygon = getObjFromList(geoPolygonId);
            double dVal = geoPolygon.calPerimeter();
            promise.resolve(dVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void calLabel(String geoPolygonId, String labelDotId, Promise promise)
    {
        try {
            GeoPolygon geoPolygon = getObjFromList(geoPolygonId);
            Dot label = JSDot.getObjFromList(labelDotId);
            int iVal = geoPolygon.calLabel(label);
            promise.resolve(iVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }
}
