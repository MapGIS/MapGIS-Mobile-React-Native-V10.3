package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.core.geometry.GeoLine;
import com.zondy.mapgis.core.geometry.GeoPolygon;
import com.zondy.mapgis.core.geometry.GeoPolygons;
import com.zondy.mapgis.core.geometry.Geometry;
import com.zondy.mapgis.core.spatial.SpaAnalysis;
import com.zondy.mapgis.core.srs.SRefData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;


public class JSSpaAnalysis extends ReactContextBaseJavaModule {

    private static final String REACT_CLASS = "JSSpaAnalysis";
    private static Map<String, SpaAnalysis> mSpaAnalysisList = new HashMap<String, SpaAnalysis>();

    public JSSpaAnalysis(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public static SpaAnalysis getObjFromList(String id) {
        return mSpaAnalysisList.get(id);
    }

    public static String registerId(SpaAnalysis obj) {
        for (Map.Entry entry : mSpaAnalysisList.entrySet()) {
            if (obj.equals(entry.getValue())) {
                return (String) entry.getKey();
            }
        }
        String id = UUID.randomUUID().toString().substring(24);
        mSpaAnalysisList.put(id, obj);
        return id;
    }

    @ReactMethod
    public void createObj(Promise promise) {
        try {
            SpaAnalysis spaAnalysis = new SpaAnalysis();
            String spaAnalysisId = registerId(spaAnalysis);
            WritableMap map = Arguments.createMap();
            map.putString("SpaAnalysisId", spaAnalysisId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getTolerance(String spaAnalysisId, Promise promise)
    {
        try {
            SpaAnalysis spaAnalysis = getObjFromList(spaAnalysisId);
            double tolerance = spaAnalysis.getTolerance();
            promise.resolve(tolerance);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setTolerance(String spaAnalysisId, double tolerance, Promise promise)
    {
        try {
            SpaAnalysis spaAnalysis = getObjFromList(spaAnalysisId);
            spaAnalysis.setTolerance(tolerance);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

   @ReactMethod
    public void buffer(String spaAnalysisId, String geomId, double leftDis, double rightDis, int endCapStyle, String sRefSrcId, Promise promise)
    {
        try {
            SpaAnalysis spaAnalysis = getObjFromList(spaAnalysisId);
            Geometry geom = JSGeometry.getObjFromList(geomId);
            SRefData sRefSrc = JSSRefData.getObjFromList(sRefSrcId);
            GeoPolygons geoPolygons = spaAnalysis.buffer(geom, leftDis, rightDis, (short)endCapStyle, sRefSrc);
            String geoPolygonsId = JSGeoPolygons.registerId(geoPolygons);
            WritableMap map = Arguments.createMap();
            map.putString("GeoPolygonsId", geoPolygonsId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void buffer(String spaAnalysisId, String geomId, double leftDis, double rightDis, String sRefSrcId, Promise promise)
    {
        try {
            SpaAnalysis spaAnalysis = getObjFromList(spaAnalysisId);
            Geometry geom = JSGeometry.getObjFromList(geomId);
            SRefData sRefSrc = null;
            if(sRefSrcId != null)
            {
                sRefSrc = JSSRefData.getObjFromList(sRefSrcId);
            }
            GeoPolygons geoPolygons = spaAnalysis.buffer(geom, leftDis, rightDis, sRefSrc);
            String geoPolygonsId = JSGeoPolygons.registerId(geoPolygons);
            WritableMap map = Arguments.createMap();
            map.putString("GeoPolygonsId", geoPolygonsId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void clipWithType(String spaAnalysisId, String geomId, String clipPolyId, int flag, Promise promise)
    {
        try {
            SpaAnalysis spaAnalysis = getObjFromList(spaAnalysisId);
            Geometry geom = JSGeometry.getObjFromList(geomId);
            GeoPolygon clipPoly = JSGeoPolygon.getObjFromList(clipPolyId);
            Geometry geometry = spaAnalysis.clip(geom, clipPoly, (char)flag);
            String geometryId = JSGeometry.registerId(geometry);
            WritableMap map = Arguments.createMap();
            map.putString("GeometryId", geometryId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void clip(String spaAnalysisId, String geomId, String clipPolyId, Promise promise)
    {
        try {
            SpaAnalysis spaAnalysis = getObjFromList(spaAnalysisId);
            Geometry geom = JSGeometry.getObjFromList(geomId);
            GeoPolygon clipPoly = JSGeoPolygon.getObjFromList(clipPolyId);
            Geometry geometry = spaAnalysis.clip(geom, clipPoly);
            String geometryId = JSGeometry.registerId(geometry);
            WritableMap map = Arguments.createMap();
            map.putString("GeometryId", geometryId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void convexHull(String spaAnalysisId, String geomId, Promise promise)
    {
        try {
            SpaAnalysis spaAnalysis = getObjFromList(spaAnalysisId);
            Geometry geom = JSGeometry.getObjFromList(geomId);
            GeoPolygon geoPolygon = spaAnalysis.convexHull(geom);
            String geoPolygonId = JSGeoPolygon.registerId(geoPolygon);
            WritableMap map = Arguments.createMap();
            map.putString("GeoPolygonId", geoPolygonId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void difference(String spaAnalysisId, String inputGeomId, String differenceGeomId, Promise promise)
    {
        try {
            SpaAnalysis spaAnalysis = getObjFromList(spaAnalysisId);
            Geometry inputGeom = JSGeometry.getObjFromList(inputGeomId);
            Geometry differenceGeom = JSGeometry.getObjFromList(differenceGeomId);
            Geometry geometry = spaAnalysis.difference(inputGeom, differenceGeom);
            String geometryId = JSGeometry.registerId(geometry);
            WritableMap map = Arguments.createMap();
            map.putString("GeometryId", geometryId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void intersection(String spaAnalysisId, String inputGeomId, String intersectGeomId, Promise promise)
    {
        try {
            SpaAnalysis spaAnalysis = getObjFromList(spaAnalysisId);
            Geometry inputGeom = JSGeometry.getObjFromList(inputGeomId);
            Geometry intersectGeom = JSGeometry.getObjFromList(intersectGeomId);
            Geometry geometry = spaAnalysis.intersection(inputGeom, intersectGeom);
            String geometryId = JSGeometry.registerId(geometry);
            WritableMap map = Arguments.createMap();
            map.putString("GeometryId", geometryId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void symmetricDifference(String spaAnalysisId, String inputGeomId, String intersectGeomId, Promise promise)
    {
        try {
            SpaAnalysis spaAnalysis = getObjFromList(spaAnalysisId);
            Geometry inputGeom = JSGeometry.getObjFromList(inputGeomId);
            Geometry intersectGeom = JSGeometry.getObjFromList(intersectGeomId);
            Geometry geometry = spaAnalysis.symmetricDifference(inputGeom, intersectGeom);
            String geometryId = JSGeometry.registerId(geometry);
            WritableMap map = Arguments.createMap();
            map.putString("GeometryId", geometryId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void merge(String spaAnalysisId, ReadableArray geoPolyArray, Promise promise)
    {
        try {
            SpaAnalysis spaAnalysis = getObjFromList(spaAnalysisId);
            List<GeoPolygon> geoPolyList = new ArrayList();
            if (spaAnalysis != null) {
                for (int i = 0; i < geoPolyArray.size(); i++) {
                    ReadableMap readable = geoPolyArray.getMap(i);
                    String keyStr = readable.getString("GeoPolygonId");
                    geoPolyList.add(JSGeoPolygon.getObjFromList(keyStr));
                }
            }
            Geometry geometry = spaAnalysis.merge(geoPolyList);
            String geometryId = JSGeometry.registerId(geometry);
            WritableMap map = Arguments.createMap();
            map.putString("GeometryId", geometryId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void merge(String spaAnalysisId, String inputGeomId, String mergeGeomId, Promise promise)
    {
        try {
            SpaAnalysis spaAnalysis = getObjFromList(spaAnalysisId);
            Geometry inputGeom = JSGeometry.getObjFromList(inputGeomId);
            Geometry mergeGeom = JSGeometry.getObjFromList(mergeGeomId);
            Geometry geometry = spaAnalysis.merge(inputGeom, mergeGeom);
            String geometryId = JSGeometry.registerId(geometry);
            WritableMap map = Arguments.createMap();
            map.putString("GeometryId", geometryId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

   @ReactMethod
    public void union(String spaAnalysisId, String inputGeomId, String unionGeomId, Promise promise)
    {
        try {
            SpaAnalysis spaAnalysis = getObjFromList(spaAnalysisId);
            Geometry inputGeom = JSGeometry.getObjFromList(inputGeomId);
            Geometry unionGeom = JSGeometry.getObjFromList(unionGeomId);
            Geometry geometry = spaAnalysis.union(inputGeom, unionGeom);
            String geometryId = JSGeometry.registerId(geometry);
            WritableMap map = Arguments.createMap();
            map.putString("GeometryId", geometryId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void split(String spaAnalysisId, String geomId, String lineId, Promise promise)
    {
        try {
            SpaAnalysis spaAnalysis = getObjFromList(spaAnalysisId);
            Geometry geom = JSGeometry.getObjFromList(geomId);
            GeoLine line = JSGeoLine.getObjFromList(lineId);
            Geometry geometry = spaAnalysis.split(geom, line);
            String geometryId = JSGeometry.registerId(geometry);
            WritableMap map = Arguments.createMap();
            map.putString("GeometryId", geometryId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void boundary(String spaAnalysisId, String geomId, Promise promise)
    {
        try {
            SpaAnalysis spaAnalysis = getObjFromList(spaAnalysisId);
            Geometry geom = JSGeometry.getObjFromList(geomId);
            Geometry geometry = spaAnalysis.boundary(geom);
            String geometryId = JSGeometry.registerId(geometry);
            WritableMap map = Arguments.createMap();
            map.putString("GeometryId", geometryId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }
}
