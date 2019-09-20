package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.android.graphic.GraphicPoint;
import com.zondy.mapgis.core.geometry.Dot;
import com.zondy.mapgis.core.geometry.GeoAnno;
import com.zondy.mapgis.core.geometry.Geometry;
import com.zondy.mapgis.core.geometry.GeometryDimension;
import com.zondy.mapgis.core.geometry.Rect;
import com.zondy.mapgis.core.object.Enumeration;
import com.zondy.mapgis.core.srs.ElpTransParam;
import com.zondy.mapgis.core.srs.SRefData;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class JSGeoAnno extends JSGeometry{

    public static final String REACT_CLASS = "JSGeoAnno";
   // public static Map<String, GeoAnno> mGeoAnnoList = new HashMap<String, GeoAnno>();
    GeoAnno m_GeoAnno;

    public JSGeoAnno(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public static GeoAnno getObjFromList(String id) {
        return (GeoAnno)mGeometryList.get(id);
    }


    public static String registerId(GeoAnno obj) {
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
    public void clone(String geoAnnoId, String geometryId, Promise promise)
    {
        try {
            GeoAnno geoAnno = getObjFromList(geoAnnoId);
            Geometry geometry = JSGeometry.getObjFromList(geometryId);
            int val = (int)geoAnno.clone(geometry);
            promise.resolve(val);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void empty(String geoAnnoId, Promise promise)
    {
        try {
            GeoAnno geoAnno = getObjFromList(geoAnnoId);
            int val = (int)geoAnno.empty();
            promise.resolve(val);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void calRect(String geoAnnoId, Promise promise)
    {
        try {
            GeoAnno geoAnno = getObjFromList(geoAnnoId);
            Rect rect = geoAnno.calRect();
            String  rectId = JSRect.registerId(rect);
            WritableMap map = Arguments.createMap();
            map.putString("RectId", rectId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void isInRect(String geoAnnoId, String rectId, Promise promise)
    {
        try {
            GeoAnno geoAnno = getObjFromList(geoAnnoId);
            Rect rect = JSRect.getObjFromList(rectId);
            int val = (int)geoAnno.isInRect(rect);
            promise.resolve(val);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void isInterRect(String geoAnnoId, String rectId, Promise promise)
    {
        try {
            GeoAnno geoAnno = getObjFromList(geoAnnoId);
            Rect rect = JSRect.getObjFromList(rectId);
            int val = (int)geoAnno.isInterRect(rect);
            promise.resolve(val);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getDimension(String geoAnnoId, Promise promise)
    {
        try {
            GeoAnno geoAnno = getObjFromList(geoAnnoId);
            GeometryDimension dimension = geoAnno.getDimension();
            int geoDimension = Enumeration.getValueByName(GeometryDimension.class, dimension.name());
            promise.resolve(geoDimension);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void transSRS(String geoAnnoId, String origSRefId, String destSRefId, Promise promise)
    {
        try {
            GeoAnno geoAnno = getObjFromList(geoAnnoId);
            SRefData origSRef = JSSRefData.getObjFromList(origSRefId);
            SRefData destSRef = JSSRefData.getObjFromList(destSRefId);
            Geometry geometry = geoAnno.transSRS(origSRef, destSRef);
            String   geometryId = JSGeometry.registerId(geometry);
            WritableMap map = Arguments.createMap();
            map.putString("GeometryId", geometryId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void transSRS(String geoAnnoId, String origSRefId, String destSRefId, String paramId, Promise promise)
    {
        try {
            GeoAnno geoAnno = getObjFromList(geoAnnoId);
            SRefData origSRef = JSSRefData.getObjFromList(origSRefId);
            SRefData destSRef = JSSRefData.getObjFromList(destSRefId);
            ElpTransParam param = JSElpTransParam.getObjFromList(paramId);
            Geometry geometry = geoAnno.transSRS(origSRef, destSRef, param);
            String   geometryId = JSGeometry.registerId(geometry);
            WritableMap map = Arguments.createMap();
            map.putString("GeometryId", geometryId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getAnchorDot(String geoAnnoId, Promise promise)
    {
        try {
            GeoAnno geoAnno = getObjFromList(geoAnnoId);
            Dot dot = geoAnno.getAnchorDot();
            String   dotId = JSDot.registerId(dot);
            WritableMap map = Arguments.createMap();
            map.putString("point2DId", dotId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setAnchorDot(String geoAnnoId, String dotId, Promise promise)
    {
        try {
            GeoAnno geoAnno = getObjFromList(geoAnnoId);
            Dot dot = JSDot.getObjFromList(dotId);
            geoAnno.setAnchorDot(dot);;
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }
}
