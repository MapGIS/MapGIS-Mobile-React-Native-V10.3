package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.core.geodatabase.AnnClsInfo;
import com.zondy.mapgis.core.geodatabase.XClsType;
import com.zondy.mapgis.core.geometry.AnnType;
import com.zondy.mapgis.core.object.Enumeration;
import com.zondy.mapgis.core.object.TimeStamp;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class JSAnnClsInfo extends JSXClsInfo {
    public static final String REACT_CLASS = "JSAnnClsInfo";

    public JSAnnClsInfo(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @ReactMethod
    public void createObj(Promise promise) {
        try {
            AnnClsInfo annClsInfo = new AnnClsInfo();
            String annClsInfoId = registerId(annClsInfo);
            WritableMap map = Arguments.createMap();
            map.putString("AnnClsInfoId", annClsInfoId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getID(String annClsInfoId, Promise promise) {
        try {
            AnnClsInfo annClsInfo = (AnnClsInfo)getObjFromList(annClsInfoId);
            int id = annClsInfo.getID();
            promise.resolve(id);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getType(String annClsInfoId, Promise promise) {
        try {
            AnnClsInfo annClsInfo = (AnnClsInfo)getObjFromList(annClsInfoId);
            XClsType clsType = annClsInfo.getType();
            int type = Enumeration.getValueByName(XClsType.class, clsType.name());
            promise.resolve(type);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getURL(String annClsInfoId, Promise promise) {
        try {
            AnnClsInfo annClsInfo = (AnnClsInfo)getObjFromList(annClsInfoId);
            String strUrl = annClsInfo.getURL();
            promise.resolve(strUrl);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getClsName(String annClsInfoId, Promise promise) {
        try {
            AnnClsInfo annClsInfo = (AnnClsInfo)getObjFromList(annClsInfoId);
            String strName = annClsInfo.getName();
            promise.resolve(strName);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setName(String annClsInfoId, String newVal, Promise promise) {
        try {
            AnnClsInfo annClsInfo = (AnnClsInfo)getObjFromList(annClsInfoId);
            int val = (int)annClsInfo.setName(newVal);
            promise.resolve(val);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getAnnType(String annClsInfoId, Promise promise)
    {
        try {
            AnnClsInfo annClsInfo = (AnnClsInfo)getObjFromList(annClsInfoId);
            AnnType annType = annClsInfo.getAnnType();
            int type = Enumeration.getValueByName(AnnType.class, annType.name());
            promise.resolve(type);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

   @ReactMethod
    public void getScalex(String annClsInfoId, Promise promise)
    {
        try {
            AnnClsInfo annClsInfo = (AnnClsInfo)getObjFromList(annClsInfoId);
            double dX = annClsInfo.getScalex();
            promise.resolve(dX);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getScaley(String annClsInfoId, Promise promise)
    {
        try {
            AnnClsInfo annClsInfo = (AnnClsInfo)getObjFromList(annClsInfoId);
            double dY = annClsInfo.getScaley();
            promise.resolve(dY);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setScaleXY(String annClsInfoId, double newXVal, double newYVal, Promise promise)
    {
        try {
            AnnClsInfo annClsInfo = (AnnClsInfo)getObjFromList(annClsInfoId);
            int val = (int)annClsInfo.setScaleXY(newXVal, newYVal);
            promise.resolve(val);
        } catch (Exception e) {
            promise.reject(e);
        }
    }
}
