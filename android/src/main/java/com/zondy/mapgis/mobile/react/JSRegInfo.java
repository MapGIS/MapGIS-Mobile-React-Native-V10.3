package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.core.geometry.GeomType;
import com.zondy.mapgis.core.info.GeomInfo;
import com.zondy.mapgis.core.info.RegInfo;
import com.zondy.mapgis.core.object.Enumeration;
import com.zondy.mapgis.mobile.react.utils.ConvertUtil;

public class JSRegInfo extends JSGeomInfo{

    private static final String REACT_CLASS = "JSRegInfo";

    public JSRegInfo(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @ReactMethod
    public void createObj(Promise promise){
        try{
            RegInfo regInfo = new RegInfo();
            String regInfoId = registerId(regInfo);

            WritableMap map = Arguments.createMap();
            map.putString("RegInfoId",regInfoId);
            promise.resolve(map);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void createObj(double ang, String endClr, String fillClr, int fillMode, int fullPatFlg, int libId, double outPenW, boolean ovprnt, String patCls, int patId,
                   double patHeight, double patWidth, Promise promise)
    {
        try{
            RegInfo regInfo = new RegInfo(ang, ConvertUtil.ColorRGBAToInt(endClr), ConvertUtil.ColorRGBAToInt(fillClr), (short)fillMode, (short)fullPatFlg, (short)libId, outPenW, ovprnt, ConvertUtil.ColorRGBAToInt(patCls), patId, patHeight, patWidth);
            String regInfoId = registerId(regInfo);

            WritableMap map = Arguments.createMap();
            map.putString("RegInfoId",regInfoId);
            promise.resolve(map);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getLibID(String regInfoId, Promise promise)
    {
        try {
            RegInfo regInfo = (RegInfo)getObjFromList(regInfoId);
            int libID = regInfo.getLibID();
            promise.resolve(libID);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setLibID(String regInfoId, int newVal, Promise promise)
    {
        try {
            RegInfo regInfo = (RegInfo)getObjFromList(regInfoId);
            regInfo.setLibID(newVal);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getOvprnt(String regInfoId, Promise promise)
    {
        try {
            RegInfo regInfo = (RegInfo)getObjFromList(regInfoId);
            boolean isOvprnt = regInfo.getOvprnt();
            promise.resolve(isOvprnt);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getPatID(String regInfoId, Promise promise)
    {
        try {
            RegInfo regInfo = (RegInfo)getObjFromList(regInfoId);
            int patID = regInfo.getPatID();
            promise.resolve(patID);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setPatID(String regInfoId, int newVal, Promise promise)
    {
        try {
            RegInfo regInfo = (RegInfo)getObjFromList(regInfoId);
            regInfo.setPatID(newVal);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

   @ReactMethod
    public void getFillMode(String regInfoId, Promise promise)
    {
        try {
            RegInfo regInfo = (RegInfo)getObjFromList(regInfoId);
            int fillMode = regInfo.getFillMode();
            promise.resolve(fillMode);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setFillMode(String regInfoId, int newVal, Promise promise)
    {
        try {
            RegInfo regInfo = (RegInfo)getObjFromList(regInfoId);
            regInfo.setFillMode((short)newVal);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

   @ReactMethod
    public void getFillClr(String regInfoId, Promise promise)
    {
        try {
            RegInfo regInfo = (RegInfo)getObjFromList(regInfoId);
            int fillClr = regInfo.getFillClr();

            promise.resolve(fillClr);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setFillClr(String regInfoId, int color, Promise promise)
    {
        try {
            RegInfo regInfo = (RegInfo)getObjFromList(regInfoId);
            regInfo.setFillClr(color);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

   @ReactMethod
    public void getEndClr(String regInfoId, Promise promise)
    {
        try {
            RegInfo regInfo = (RegInfo)getObjFromList(regInfoId);
            int endClr = regInfo.getEndClr();

            promise.resolve(endClr);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setEndClr(String regInfoId, int color, Promise promise)
    {
        try {
            RegInfo regInfo = (RegInfo)getObjFromList(regInfoId);
            regInfo.setEndClr(color);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getPatHeight(String regInfoId, Promise promise)
    {
        try {
            RegInfo regInfo = (RegInfo)getObjFromList(regInfoId);
            double patHeight = regInfo.getPatHeight();
            promise.resolve(patHeight);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setPatHeight(String regInfoId, double newVal, Promise promise)
    {
        try {
            RegInfo regInfo = (RegInfo)getObjFromList(regInfoId);
            regInfo.setPatHeight(newVal);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

   @ReactMethod
    public void getPatWidth(String regInfoId, Promise promise)
    {
        try {
            RegInfo regInfo = (RegInfo)getObjFromList(regInfoId);
            double patWidth = regInfo.getPatWidth();
            promise.resolve(patWidth);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setPatWidth(String regInfoId, double newVal, Promise promise)
    {
        try {
            RegInfo regInfo = (RegInfo)getObjFromList(regInfoId);
            regInfo.setPatWidth(newVal);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

   @ReactMethod
    public void getAngle(String regInfoId, Promise promise)
    {
        try {
            RegInfo regInfo = (RegInfo)getObjFromList(regInfoId);
            double angle = regInfo.getAngle();
            promise.resolve(angle);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setAngle(String regInfoId, double newVal, Promise promise)
    {
        try {
            RegInfo regInfo = (RegInfo)getObjFromList(regInfoId);
            regInfo.setAngle(newVal);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getPatClr(String regInfoId, Promise promise)
    {
        try {
            RegInfo regInfo = (RegInfo)getObjFromList(regInfoId);
            int patClr = regInfo.getPatClr();

            promise.resolve(patClr);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

   @ReactMethod
    public void setPatClr(String regInfoId, int color, Promise promise)
    {
        try {
            RegInfo regInfo = (RegInfo)getObjFromList(regInfoId);
            regInfo.setPatClr(color);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getOutPenW(String regInfoId, Promise promise)
    {
        try {
            RegInfo regInfo = (RegInfo)getObjFromList(regInfoId);
            double outPenW = regInfo.getOutPenW();
            promise.resolve(outPenW);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

   @ReactMethod
    public void setOutPenW(String regInfoId, double newVal, Promise promise)
    {
        try {
            RegInfo regInfo = (RegInfo)getObjFromList(regInfoId);
            regInfo.setOutPenW(newVal);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getFullPatFlg(String regInfoId, Promise promise)
    {
        try {
            RegInfo regInfo = (RegInfo)getObjFromList(regInfoId);
            int fullPatFlg = regInfo.getFullPatFlg();
            promise.resolve(fullPatFlg);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setFullPatFlg(String regInfoId, int newVal, Promise promise)
    {
        try {
            RegInfo regInfo = (RegInfo)getObjFromList(regInfoId);
            regInfo.setFullPatFlg((short)newVal);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

   @ReactMethod
    public void getGeomType(String regInfoId, Promise promise) {
        try {
            RegInfo regInfo = (RegInfo)getObjFromList(regInfoId);
            GeomType geomType = regInfo.getGeomType();
            int type = Enumeration.getValueByName(GeomType.class, geomType.name());
            promise.resolve(type);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

   @ReactMethod
    public void setOvprnt(String regInfoId, boolean newVal, Promise promise) {
        try {
            RegInfo regInfo = (RegInfo)getObjFromList(regInfoId);
            regInfo.setOvprnt(newVal);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

   @ReactMethod
    public void Clone(String regInfoId, Promise promise) {
        try {
            RegInfo regInfo = (RegInfo)getObjFromList(regInfoId);
            GeomInfo geomInfo = regInfo.Clone();
            String  geomInfoId = registerId(geomInfo);
            WritableMap map = Arguments.createMap();
            map.putString("GeomInfoId", geomInfoId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }
}
