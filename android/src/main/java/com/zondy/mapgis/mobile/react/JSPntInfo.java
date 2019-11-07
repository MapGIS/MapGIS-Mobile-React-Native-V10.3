package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.core.geometry.GeomType;
import com.zondy.mapgis.core.info.GeomInfo;
import com.zondy.mapgis.core.info.PntInfo;
import com.zondy.mapgis.core.object.Enumeration;
import com.zondy.mapgis.mobile.react.utils.ConvertUtil;

public class JSPntInfo extends JSGeomInfo{

    public static final String REACT_CLASS = "JSPntInfo";

    public JSPntInfo(ReactApplicationContext reactContext) {
        super(reactContext);
    }
    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @ReactMethod
    public void createObj(Promise promise){
        try{
            PntInfo pntInfo = new PntInfo();
            String pntInfoId = registerId(pntInfo);

            WritableMap map = Arguments.createMap();
            map.putString("PntInfoId",pntInfoId);
            promise.resolve(map);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void createObjByParam(double ang, String backClr, double backExp, int fillFlg, double height, int libId, String outClr1, String outClr2, String outClr3, double outPenW1,
                   double outPenW2, double outPenW3, boolean ovprnt, int symId, double width, Promise promise)
    {
        try{
            PntInfo pntInfo = new PntInfo(ang,ConvertUtil.ColorRGBAToInt(backClr),backExp,(short)fillFlg,height,(short)libId,ConvertUtil.ColorRGBAToInt(outClr1),ConvertUtil.ColorRGBAToInt(outClr2),ConvertUtil.ColorRGBAToInt(outClr3),outPenW1,outPenW2,outPenW3,ovprnt,symId,width);
            String pntInfoId = registerId(pntInfo);

            WritableMap map = Arguments.createMap();
            map.putString("PntInfoId",pntInfoId);
            promise.resolve(map);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getLibID(String pntInfoId, Promise promise)
    {
        try {
            PntInfo pntInfo = (PntInfo)getObjFromList(pntInfoId);
            int libID = pntInfo.getLibID();
            promise.resolve(libID);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getOvprnt(String pntInfoId, Promise promise)
    {
        try {
            PntInfo pntInfo = (PntInfo)getObjFromList(pntInfoId);
            boolean isOvprnt = pntInfo.getOvprnt();
            promise.resolve(isOvprnt);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setOvprnt(String pntInfoId, boolean newVal, Promise promise)
    {
        try {
            PntInfo pntInfo = (PntInfo)getObjFromList(pntInfoId);
            pntInfo.setOvprnt(newVal);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getSymID(String pntInfoId, Promise promise)
    {
        try {
            PntInfo pntInfo = (PntInfo)getObjFromList(pntInfoId);
            int symID = pntInfo.getSymID();
            promise.resolve(symID);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setSymID(String pntInfoId, int newVal, Promise promise)
    {
        try {
            PntInfo pntInfo = (PntInfo)getObjFromList(pntInfoId);
            pntInfo.setSymID(newVal);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getHeight(String pntInfoId, Promise promise)
    {
        try {
            PntInfo pntInfo = (PntInfo)getObjFromList(pntInfoId);
            double height = pntInfo.getHeight();
            promise.resolve(height);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

   @ReactMethod
    public void setHeight(String pntInfoId, double newVal, Promise promise)
    {
        try {
            PntInfo pntInfo = (PntInfo)getObjFromList(pntInfoId);
            pntInfo.setHeight(newVal);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getWidth(String pntInfoId, Promise promise)
    {
        try {
            PntInfo pntInfo = (PntInfo)getObjFromList(pntInfoId);
            double width = pntInfo.getWidth();
            promise.resolve(width);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setWidth(String pntInfoId, double newVal, Promise promise)
    {
        try {
            PntInfo pntInfo = (PntInfo)getObjFromList(pntInfoId);
            pntInfo.setWidth(newVal);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getAngle(String pntInfoId, Promise promise)
    {
        try {
            PntInfo pntInfo = (PntInfo)getObjFromList(pntInfoId);
            double angle = pntInfo.getAngle();
            promise.resolve(angle);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setAngle(String pntInfoId, double newVal, Promise promise)
    {
        try {
            PntInfo pntInfo = (PntInfo)getObjFromList(pntInfoId);
            pntInfo.setAngle(newVal);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getOutPenW1(String pntInfoId, Promise promise)
    {
        try {
            PntInfo pntInfo = (PntInfo)getObjFromList(pntInfoId);
            double outPenW1 = pntInfo.getOutPenW1();
            promise.resolve(outPenW1);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setOutPenW1(String pntInfoId, double newVal, Promise promise)
    {
        try {
            PntInfo pntInfo = (PntInfo)getObjFromList(pntInfoId);
            pntInfo.setOutPenW1(newVal);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getOutPenW2(String pntInfoId, Promise promise)
    {
        try {
            PntInfo pntInfo = (PntInfo)getObjFromList(pntInfoId);
            double outPenW2 = pntInfo.getOutPenW2();
            promise.resolve(outPenW2);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setOutPenW2(String pntInfoId, double newVal, Promise promise)
    {
        try {
            PntInfo pntInfo = (PntInfo)getObjFromList(pntInfoId);
            pntInfo.setOutPenW2(newVal);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getOutPenW3(String pntInfoId, Promise promise)
    {
        try {
            PntInfo pntInfo = (PntInfo)getObjFromList(pntInfoId);
            double outPenW3 = pntInfo.getOutPenW3();
            promise.resolve(outPenW3);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setOutPenW3(String pntInfoId, double newVal, Promise promise)
    {
        try {
            PntInfo pntInfo = (PntInfo)getObjFromList(pntInfoId);
            pntInfo.setOutPenW3(newVal);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getOutClr1(String pntInfoId, Promise promise)
    {
        try {
            PntInfo pntInfo = (PntInfo)getObjFromList(pntInfoId);
            int outClr1 = pntInfo.getOutClr1();
            String strColor = ConvertUtil.ColorIntToRGBA(outClr1);

            WritableMap map = Arguments.createMap();
            map.putString("color", strColor);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

   @ReactMethod
    public void setOutClr1(String pntInfoId, String color, Promise promise)
    {
        try {
            PntInfo pntInfo = (PntInfo)getObjFromList(pntInfoId);
            pntInfo.setOutClr1(ConvertUtil.ColorRGBAToInt(color));
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getOutClr2(String pntInfoId, Promise promise)
    {
        try {
            PntInfo pntInfo = (PntInfo)getObjFromList(pntInfoId);
            int outClr2 = pntInfo.getOutClr2();
            String strColor = ConvertUtil.ColorIntToRGBA(outClr2);

            WritableMap map = Arguments.createMap();
            map.putString("color", strColor);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

   @ReactMethod
    public void setOutClr2(String pntInfoId, String color, Promise promise)
    {
        try {
            PntInfo pntInfo = (PntInfo)getObjFromList(pntInfoId);
            pntInfo.setOutClr2(ConvertUtil.ColorRGBAToInt(color));
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

   @ReactMethod
    public void getOutClr3(String pntInfoId, Promise promise)
    {
        try {
            PntInfo pntInfo = (PntInfo)getObjFromList(pntInfoId);
            int outClr3 = pntInfo.getOutClr3();
            String strColor = ConvertUtil.ColorIntToRGBA(outClr3);

            WritableMap map = Arguments.createMap();
            map.putString("color", strColor);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setOutClr3(String pntInfoId, String color, Promise promise)
    {
        try {
            PntInfo pntInfo = (PntInfo)getObjFromList(pntInfoId);
            pntInfo.setOutClr3(ConvertUtil.ColorRGBAToInt(color));
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getFillFlg(String pntInfoId, Promise promise)
    {
        try {
            PntInfo pntInfo = (PntInfo)getObjFromList(pntInfoId);
            int fillFlg = pntInfo.getFillFlg();
            promise.resolve(fillFlg);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setFillFlg(String pntInfoId, int newVal, Promise promise)
    {
        try {
            PntInfo pntInfo = (PntInfo)getObjFromList(pntInfoId);
            pntInfo.setFillFlg((short)newVal);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

   @ReactMethod
    public void getBackExp(String pntInfoId, Promise promise)
    {
        try {
            PntInfo pntInfo = (PntInfo)getObjFromList(pntInfoId);
            double backExp = pntInfo.getBackExp();
            promise.resolve(backExp);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setBackExp(String pntInfoId, double newVal, Promise promise)
    {
        try {
            PntInfo pntInfo = (PntInfo)getObjFromList(pntInfoId);
            pntInfo.setBackExp(newVal);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getBackClr(String pntInfoId, Promise promise)
    {
        try {
            PntInfo pntInfo = (PntInfo)getObjFromList(pntInfoId);
            int backClr = pntInfo.getBackClr();
            String strColor = ConvertUtil.ColorIntToRGBA(backClr);

            WritableMap map = Arguments.createMap();
            map.putString("color", strColor);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setBackClr(String pntInfoId, String color, Promise promise)
    {
        try {
            PntInfo pntInfo = (PntInfo)getObjFromList(pntInfoId);
            pntInfo.setBackClr(ConvertUtil.ColorRGBAToInt(color));
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getGeomType(String pntInfoId, Promise promise) {
        try {
            PntInfo pntInfo = (PntInfo)getObjFromList(pntInfoId);
            GeomType geomType = pntInfo.getGeomType();
            int type = Enumeration.getValueByName(GeomType.class, geomType.name());
            promise.resolve(type);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setLibID(String pntInfoId, int newVal, Promise promise) {
        try {
            PntInfo pntInfo = (PntInfo)getObjFromList(pntInfoId);
            pntInfo.setLibID(newVal);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

   @ReactMethod
    public void Clone(String pntInfoId, Promise promise){
       try {
           PntInfo pntInfo = (PntInfo)getObjFromList(pntInfoId);
           GeomInfo geomInfo = pntInfo.Clone();
           String geomInfoId = registerId(geomInfo);
           WritableMap map = Arguments.createMap();
           map.putString("GeomInfoId", geomInfoId);
           promise.resolve(map);
       } catch (Exception e) {
           promise.reject(e);
       }
    }
}
