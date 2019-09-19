package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.core.attr.Fields;
import com.zondy.mapgis.core.geodatabase.QueryDef;
import com.zondy.mapgis.core.geodatabase.SpaQueryMode;
import com.zondy.mapgis.core.geometry.Dot;
import com.zondy.mapgis.core.geometry.GeoPolygon;
import com.zondy.mapgis.core.geometry.Rect;
import com.zondy.mapgis.core.object.Enumeration;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class JSQueryDef extends ReactContextBaseJavaModule {
    public static final String REACT_CLASS = "JSQueryDef";
    public static Map<String, QueryDef> mQueryDefList = new HashMap<String, QueryDef>();


    public JSQueryDef(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public static QueryDef getObjFromList(String id) {
        return mQueryDefList.get(id);
    }

    public static String registerId(QueryDef obj) {
        for (Map.Entry entry : mQueryDefList.entrySet()) {
            if (obj.equals(entry.getValue())) {
                return (String) entry.getKey();
            }
        }
        Calendar calendar = Calendar.getInstance();
        String id = Long.toString(calendar.getTimeInMillis());
        mQueryDefList.put(id, obj);
        return id;
    }

    @ReactMethod
    public void createObj(Promise promise) {
        try {
            QueryDef queryDef = new QueryDef();
            String queryDefId = registerId(queryDef);
            WritableMap map = Arguments.createMap();
            map.putString("QueryDefId", queryDefId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setFilter(String queryDefId, String whereClause, Promise promise)
    {
        try {
            QueryDef queryDef = getObjFromList(queryDefId);
            long lVal = queryDef.setFilter(whereClause);
            promise.resolve(lVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setSubFields(String queryDefId, String fldsId, Promise promise)
    {
        try {
            QueryDef queryDef = getObjFromList(queryDefId);
            Fields flds = JSFields.getObjFromList(fldsId);
            long lVal = queryDef.setSubFields(flds);
            promise.resolve(lVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setRect(String queryDefId, String rectId, int queryMode, Promise promise)
    {
        try {
            QueryDef queryDef = getObjFromList(queryDefId);
            Rect rect = JSRect.getObjFromList(rectId);
            SpaQueryMode mode = (SpaQueryMode) Enumeration.parse(SpaQueryMode.class, queryMode);
            long lVal = queryDef.setRect(rect, mode);
            promise.resolve(lVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setSpatial(String queryDefId, String polygonId, int queryMode, Promise promise)
    {
        try {
            QueryDef queryDef = getObjFromList(queryDefId);
            GeoPolygon polygon = JSGeoPolygon.getObjFromList(polygonId);
            SpaQueryMode mode = (SpaQueryMode) Enumeration.parse(SpaQueryMode.class, queryMode);
            long lVal = queryDef.setSpatial(polygon, mode);
            promise.resolve(lVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setNear(String queryDefId, String dotId, double xmax, double xmin, Promise promise)
    {
        try {
            QueryDef queryDef = getObjFromList(queryDefId);
            Dot dot = JSDot.getObjFromList(dotId);
            long lVal = queryDef.setNear(dot, xmax, xmin);
            promise.resolve(lVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }
}
