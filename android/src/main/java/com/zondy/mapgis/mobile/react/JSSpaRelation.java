package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.core.geometry.Dot;
import com.zondy.mapgis.core.geometry.GeoPolygon;
import com.zondy.mapgis.core.geometry.GeoVarLine;
import com.zondy.mapgis.core.geometry.Geometry;
import com.zondy.mapgis.core.geometry.Rect;
import com.zondy.mapgis.core.spatial.SpaRelation;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class JSSpaRelation extends ReactContextBaseJavaModule {

    public static final String REACT_CLASS = "JSSpaRelation";
    public static Map<String, SpaRelation> mSpaRelationList = new HashMap<String, SpaRelation>();

    public JSSpaRelation(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public static SpaRelation getObjFromList(String id) {
        return mSpaRelationList.get(id);
    }

    public static String registerId(SpaRelation obj) {
        for (Map.Entry entry : mSpaRelationList.entrySet()) {
            if (obj.equals(entry.getValue())) {
                return (String) entry.getKey();
            }
        }
        Calendar calendar = Calendar.getInstance();
        String id = Long.toString(calendar.getTimeInMillis());
        mSpaRelationList.put(id, obj);
        return id;
    }

    @ReactMethod
    public void createObj(Promise promise) {
        try {
            SpaRelation spaRelation = new SpaRelation();
            String spaRelationId = registerId(spaRelation);
            WritableMap map = Arguments.createMap();
            map.putString("SpaRelationId", spaRelationId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getTolerance(String spaRelationId, Promise promise)
    {
        try {
            SpaRelation spaRelation = getObjFromList(spaRelationId);
            double tolerance = spaRelation.getTolerance();
            promise.resolve(tolerance);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setTolerance(String spaRelationId, double tolerance, Promise promise)
    {
        try {
            SpaRelation spaRelation = getObjFromList(spaRelationId);
            spaRelation.setTolerance(tolerance);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public static void isDotInRect(String pntId, String rcId, Promise promise)
    {
        try {
            Dot pnt = JSDot.getObjFromList(pntId);
            Rect rc = JSRect.getObjFromList(rcId);
            int iVal = SpaRelation.isDotInRect(pnt, rc);
            promise.resolve(iVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public static void isDotInLin(String pntId, String linId, Promise promise)
    {
        try {
            Dot pnt = JSDot.getObjFromList(pntId);
            GeoVarLine lin = JSGeoVarLine.getObjFromList(linId);
            int iVal = SpaRelation.isDotInLin(pnt, lin);
            promise.resolve(iVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public static void isDotInReg(String pntId, String regId, int flg, double esp, Promise promise)
    {
        try {
            Dot pnt = JSDot.getObjFromList(pntId);
            GeoPolygon reg = JSGeoPolygon.getObjFromList(regId);
            int iVal = SpaRelation.isDotInReg(pnt, reg, (short)flg, esp);
            promise.resolve(iVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public static void isRectInReg(String rcId, String regId, double esp, Promise promise)
    {
        try {
            Rect rc = JSRect.getObjFromList(rcId);
            GeoPolygon reg = JSGeoPolygon.getObjFromList(regId);
            int iVal = SpaRelation.isRectInReg(rc, reg, esp);
            promise.resolve(iVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public static void isLinInReg(String linId, String regId, double esp, Promise promise)
    {
        try {
            GeoVarLine lin = JSGeoVarLine.getObjFromList(linId);
            GeoPolygon reg = JSGeoPolygon.getObjFromList(regId);
            int iVal = SpaRelation.isLinInReg(lin, reg, esp);
            promise.resolve(iVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public static void isRegInReg(String reg0Id, String reg1Id, double esp, Promise promise)
    {
        try {
            GeoPolygon reg0 = JSGeoPolygon.getObjFromList(reg0Id);
            GeoPolygon reg1 = JSGeoPolygon.getObjFromList(reg1Id);
            int iVal = SpaRelation.isRegInReg(reg0, reg1, esp);
            promise.resolve(iVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public static void isRectInterLin(String rcId, String linId, Promise promise)
    {
        try {
            Rect rc = JSRect.getObjFromList(rcId);
            GeoVarLine lin = JSGeoVarLine.getObjFromList(linId);
            int iVal = SpaRelation.isRectInterLin(rc, lin);
            promise.resolve(iVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public static void isLinInterReg(String linId, String regId, Promise promise)
    {
        try {
            GeoVarLine lin = JSGeoVarLine.getObjFromList(linId);
            GeoPolygon reg = JSGeoPolygon.getObjFromList(regId);
            int iVal = SpaRelation.isLinInterReg(lin, reg);
            promise.resolve(iVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

   @ReactMethod
    public static void isRegInterReg(String reg0Id, String reg1Id, Promise promise)
    {
        try {
            GeoPolygon reg0 = JSGeoPolygon.getObjFromList(reg0Id);
            GeoPolygon reg1 = JSGeoPolygon.getObjFromList(reg1Id);
            int iVal = SpaRelation.isRegInterReg(reg0, reg1);
            promise.resolve(iVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void isContains(String spaRelationId, String geom0Id, String geom1Id, Promise promise)
    {
        try {
            SpaRelation spaRelation = getObjFromList(spaRelationId);
            Geometry geom0 = JSGeometry.getObjFromList(geom0Id);
            Geometry geom1 = JSGeometry.getObjFromList(geom1Id);
            boolean  isContains = spaRelation.isContains(geom0, geom1);
            promise.resolve(isContains);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void isCrosses(String spaRelationId, String geom0Id, String geom1Id, Promise promise)
    {
        try {
            SpaRelation spaRelation = getObjFromList(spaRelationId);
            Geometry geom0 = JSGeometry.getObjFromList(geom0Id);
            Geometry geom1 = JSGeometry.getObjFromList(geom1Id);
            boolean  isCrosses = spaRelation.isCrosses(geom0, geom1);
            promise.resolve(isCrosses);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void isDisjoint(String spaRelationId, String geom0Id, String geom1Id, Promise promise)
    {
        try {
            SpaRelation spaRelation = getObjFromList(spaRelationId);
            Geometry geom0 = JSGeometry.getObjFromList(geom0Id);
            Geometry geom1 = JSGeometry.getObjFromList(geom1Id);
            boolean  isDisjoint = spaRelation.isDisjoint(geom0, geom1);
            promise.resolve(isDisjoint);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void isEquals(String spaRelationId, String geom0Id, String geom1Id, Promise promise)
    {
        try {
            SpaRelation spaRelation = getObjFromList(spaRelationId);
            Geometry geom0 = JSGeometry.getObjFromList(geom0Id);
            Geometry geom1 = JSGeometry.getObjFromList(geom1Id);
            boolean  isEquals = spaRelation.isEquals(geom0, geom1);
            promise.resolve(isEquals);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void isOverlaps(String spaRelationId, String geom0Id, String geom1Id, Promise promise)
    {
        try {
            SpaRelation spaRelation = getObjFromList(spaRelationId);
            Geometry geom0 = JSGeometry.getObjFromList(geom0Id);
            Geometry geom1 = JSGeometry.getObjFromList(geom1Id);
            boolean  isOverlaps = spaRelation.isOverlaps(geom0, geom1);
            promise.resolve(isOverlaps);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void isTouches(String spaRelationId, String geom0Id, String geom1Id, Promise promise)
    {
        try {
            SpaRelation spaRelation = getObjFromList(spaRelationId);
            Geometry geom0 = JSGeometry.getObjFromList(geom0Id);
            Geometry geom1 = JSGeometry.getObjFromList(geom1Id);
            boolean  isTouches = spaRelation.isTouches(geom0, geom1);
            promise.resolve(isTouches);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

   @ReactMethod
    public void isWithin(String spaRelationId, String geom0Id, String geom1Id, Promise promise)
    {
        try {
            SpaRelation spaRelation = getObjFromList(spaRelationId);
            Geometry geom0 = JSGeometry.getObjFromList(geom0Id);
            Geometry geom1 = JSGeometry.getObjFromList(geom1Id);
            boolean  isWithin = spaRelation.isWithin(geom0, geom1);
            promise.resolve(isWithin);
        } catch (Exception e) {
            promise.reject(e);
        }
    }
}
