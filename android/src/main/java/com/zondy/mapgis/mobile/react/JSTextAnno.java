package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.core.geometry.AnnType;
import com.zondy.mapgis.core.geometry.GeoPoints;
import com.zondy.mapgis.core.geometry.GeometryType;
import com.zondy.mapgis.core.geometry.TextAnno;
import com.zondy.mapgis.core.info.TextAnnInfo;
import com.zondy.mapgis.core.object.Enumeration;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class JSTextAnno extends JSGeoAnno{

    public static final String REACT_CLASS = "JSTextAnno";
   // public static Map<String, TextAnno> mGeoAnnoList = new HashMap<String, TextAnno>();
    TextAnno m_TextAnno;

    public JSTextAnno(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public static TextAnno getObjFromList(String id) {
        return (TextAnno)mGeometryList.get(id);
    }

    public static String registerId(TextAnno obj) {
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
            TextAnno textAnno = new TextAnno();
            String textAnnoId = registerId(textAnno);

            WritableMap map = Arguments.createMap();
            map.putString("TextAnnoId", textAnnoId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }
   @ReactMethod
    public void getType(String textAnnoId, Promise promise)
    {
        try {
            TextAnno textAnno = getObjFromList(textAnnoId);
            GeometryType geometryType = textAnno.getType();
            int type = Enumeration.getValueByName(GeometryType.class, geometryType.name());
            promise.resolve(type);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getAnnType(String textAnnoId, Promise promise)
    {
        try {
            TextAnno textAnno = getObjFromList(textAnnoId);
            AnnType annType = textAnno.getAnnType();
            int type = Enumeration.getValueByName(AnnType.class, annType.name());
            promise.resolve(type);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void isEmpty(String textAnnoId, Promise promise)
    {
        try {
            TextAnno textAnno = getObjFromList(textAnnoId);
            boolean  bIsEmpty = textAnno.isEmpty();
            promise.resolve(bIsEmpty);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getText(String textAnnoId, Promise promise)
    {
        try {
            TextAnno textAnno = getObjFromList(textAnnoId);
            String  text = textAnno.getText();
            promise.resolve(text);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setText(String textAnnoId, String text, Promise promise)
    {
        try {
            TextAnno textAnno = getObjFromList(textAnnoId);
            textAnno.setText(text);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getTextAnnInfo(String textAnnoId, Promise promise)
    {
        try {
            TextAnno textAnno = getObjFromList(textAnnoId);
            TextAnnInfo annInfo = textAnno.getTextAnnInfo();
           // String  annInfoId = JSTextAnnInfo.re
           // promise.resolve(text);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setTextAnnInfo(String textAnnoId, String textInfoId, Promise promise)
    {
        try {
            TextAnno textAnno = getObjFromList(textAnnoId);
           // TextAnnInfo textInfo;
           // String  text = textAnno.setTextAnnInfo();
           // promise.resolve(text);
        } catch (Exception e) {
            promise.reject(e);
        }
    }
}
