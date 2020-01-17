package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.core.geodatabase.FClsInfo;
import com.zondy.mapgis.core.geodatabase.XClsType;
import com.zondy.mapgis.core.geometry.GeomType;
import com.zondy.mapgis.core.object.Enumeration;

public class JSFClsInfo extends JSXClsInfo{

    private static final String REACT_CLASS = "JSFClsInfo";

    public JSFClsInfo(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @ReactMethod
    public void createObj(Promise promise){
        try{
            FClsInfo fClsInfo = new FClsInfo();
            String fClsInfoId = registerId(fClsInfo);
            WritableMap map = Arguments.createMap();
            map.putString("FClsInfoId", fClsInfoId);
            promise.resolve(map);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getID(String fClsInfoId, Promise promise)
    {
        try {
            FClsInfo fClsInfo = (FClsInfo)getObjFromList(fClsInfoId);
            int id = fClsInfo.getID();
            promise.resolve(id);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

   @ReactMethod
    public void getType(String fClsInfoId, Promise promise)
    {
        try {
            FClsInfo fClsInfo = (FClsInfo)getObjFromList(fClsInfoId);
            XClsType clsType = fClsInfo.getType();
            int type = Enumeration.getValueByName(XClsType.class, clsType.name());
            promise.resolve(type);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

   @ReactMethod
    public void getURL(String fClsInfoId, Promise promise) {
        try {
            FClsInfo fClsInfo = (FClsInfo)getObjFromList(fClsInfoId);
            String strUrl = fClsInfo.getURL();
            promise.resolve(strUrl);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getName(String fClsInfoId, Promise promise)
    {
        try {
            FClsInfo fClsInfo = (FClsInfo)getObjFromList(fClsInfoId);
            String strName = fClsInfo.getName();
            promise.resolve(strName);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setName(String fClsInfoId, String newVal, Promise promise)
    {
        try {
            FClsInfo fClsInfo = (FClsInfo)getObjFromList(fClsInfoId);
            int iVal = (int)fClsInfo.setName(newVal);
            promise.resolve(iVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getGeomType(String fClsInfoId, Promise promise)
    {
        try {
            FClsInfo fClsInfo = (FClsInfo)getObjFromList(fClsInfoId);
            GeomType geomType = fClsInfo.getGeomType();
            int type = Enumeration.getValueByName(GeomType.class, geomType.name());
            promise.resolve(type);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getScalex(String fClsInfoId, Promise promise)
    {
        try {
            FClsInfo fClsInfo = (FClsInfo)getObjFromList(fClsInfoId);
            double dX = fClsInfo.getScalex();
            promise.resolve(dX);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

   @ReactMethod
    public void getScaley(String fClsInfoId, Promise promise)
    {
        try {
            FClsInfo fClsInfo = (FClsInfo)getObjFromList(fClsInfoId);
            double dY = fClsInfo.getScaley();
            promise.resolve(dY);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setScaleXY(String fClsInfoId, double newXVal,double newYVal, Promise promise)
    {
        try {
            FClsInfo fClsInfo = (FClsInfo)getObjFromList(fClsInfoId);
            int iVal = (int)fClsInfo.setScaleXY(newXVal, newYVal);
            promise.resolve(iVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }
}
