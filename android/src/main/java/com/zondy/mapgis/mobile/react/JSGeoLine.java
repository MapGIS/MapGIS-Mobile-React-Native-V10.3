package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.core.geometry.Dots;
import com.zondy.mapgis.core.geometry.Dots3D;
import com.zondy.mapgis.core.geometry.GeoLine;
import com.zondy.mapgis.core.srs.SRefData;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class JSGeoLine extends JSGeometryExp{

    public static final String REACT_CLASS = "JSGeoLine";
    //public static Map<String, GeoLine> mGeoLineList = new HashMap<String, GeoLine>();
    GeoLine m_GeoLine;
    public JSGeoLine(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public static GeoLine getObjFromList(String id) {
        return (GeoLine)mGeometryList.get(id);
    }

    public static String registerId(GeoLine obj) {
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
    public void get2Dots(String geoLineId, Promise promise)
    {
        try {
            GeoLine geoLine = getObjFromList(geoLineId);
            Dots dots = geoLine.get2Dots();
            String dotsId = JSDots.registerId(dots);
            WritableMap map = Arguments.createMap();
            map.putString("DotsId", dotsId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void get3Dots(String geoLineId, Promise promise)
    {
        try {
            GeoLine geoLine = getObjFromList(geoLineId);
            Dots3D dots3D = geoLine.get3Dots();
            String dots3DId = JSDots3D.registerId(dots3D);
            WritableMap map = Arguments.createMap();
            map.putString("Dots3DId", dots3DId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void calLength(String geoLineId, String sRefId, Promise promise)
    {
        try {
            GeoLine geoLine = getObjFromList(geoLineId);
            SRefData sRef = JSSRefData.getObjFromList(sRefId);
            double length = geoLine.calLength(sRef);
            promise.resolve(length);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void calLength(String geoLineId, Promise promise)
    {
        try {
            GeoLine geoLine = getObjFromList(geoLineId);
            double length = geoLine.calLength();
            promise.resolve(length);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

   @ReactMethod
    public void disperseToDots(String geoLineId, double dStep, Promise promise)
    {
        try {
            GeoLine geoLine = getObjFromList(geoLineId);
            int iVal = (int)geoLine.disperseToDots(dStep);
            promise.resolve(iVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }
}
