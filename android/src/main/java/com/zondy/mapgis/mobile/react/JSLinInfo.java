package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.core.geometry.GeomType;
import com.zondy.mapgis.core.info.GeomInfo;
import com.zondy.mapgis.core.info.LinInfo;
import com.zondy.mapgis.core.object.Enumeration;
import com.zondy.mapgis.mobile.react.utils.ConvertUtil;

public class JSLinInfo extends JSGeomInfo{

    public static final String REACT_CLASS = "JSLinInfo";

    public JSLinInfo(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @ReactMethod
    public void createObj(Promise promise){
        try{
            LinInfo linInfo = new LinInfo();
            String linInfoId = registerId(linInfo);

            WritableMap map = Arguments.createMap();
            map.putString("LinInfoId",linInfoId);
            promise.resolve(map);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void createObjByParam(int adjustFlg, int headType, int joinType, int libId, int linStyId, int makeMethod, String outClr1, String outClr2, String outClr3,
                   double outPenW1, double outPenW2, double outPenW3, boolean ovprnt, double xScale, double yScale, Promise promise)
    {
        try{
            LinInfo linInfo = new LinInfo((short)adjustFlg, (short)headType, (short)joinType, (short)libId, linStyId, (short)makeMethod, ConvertUtil.ColorRGBAToInt(outClr1), ConvertUtil.ColorRGBAToInt(outClr2), ConvertUtil.ColorRGBAToInt(outClr3), outPenW1, outPenW2, outPenW3, ovprnt, xScale, yScale);
            String linInfoId = registerId(linInfo);

            WritableMap map = Arguments.createMap();
            map.putString("LinInfoId",linInfoId);
            promise.resolve(map);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getLibID(String linInfoId, Promise promise)
    {
        try {
            LinInfo linInfo = (LinInfo)getObjFromList(linInfoId);
            int libID = linInfo.getLibID();
            promise.resolve(libID);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setLibID(String linInfoId, int newVal, Promise promise)
    {
        try {
            LinInfo linInfo = (LinInfo)getObjFromList(linInfoId);
            linInfo.setLibID(newVal);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

   @ReactMethod
    public void getOvprnt(String linInfoId, Promise promise)
    {
        try {
            LinInfo linInfo = (LinInfo)getObjFromList(linInfoId);
            boolean isOvprnt = linInfo.getOvprnt();
            promise.resolve(isOvprnt);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getLinStyID(String linInfoId, Promise promise)
    {
        try {
            LinInfo linInfo = (LinInfo)getObjFromList(linInfoId);
            int linStyID = linInfo.getLinStyID();
            promise.resolve(linStyID);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setLinStyID(String linInfoId, int newVal, Promise promise)
    {
        try {
            LinInfo linInfo = (LinInfo)getObjFromList(linInfoId);
            linInfo.setLinStyID(newVal);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getOutPenW1(String linInfoId, Promise promise)
    {
        try {
            LinInfo linInfo = (LinInfo)getObjFromList(linInfoId);
            double outPenW1 = linInfo.getOutPenW1();
            promise.resolve(outPenW1);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setOutPenW1(String linInfoId, double newVal, Promise promise)
    {
        try {
            LinInfo linInfo = (LinInfo)getObjFromList(linInfoId);
            linInfo.setOutPenW1(newVal);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getOutPenW2(String linInfoId, Promise promise)
    {
        try {
            LinInfo linInfo = (LinInfo)getObjFromList(linInfoId);
            double outPenW2 = linInfo.getOutPenW2();
            promise.resolve(outPenW2);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

   @ReactMethod
    public void setOutPenW2(String linInfoId, double newVal, Promise promise)
    {
        try {
            LinInfo linInfo = (LinInfo)getObjFromList(linInfoId);
            linInfo.setOutPenW2(newVal);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getOutPenW3(String linInfoId, Promise promise)
    {
        try {
            LinInfo linInfo = (LinInfo)getObjFromList(linInfoId);
            double outPenW3 = linInfo.getOutPenW3();
            promise.resolve(outPenW3);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

   @ReactMethod
    public void setOutPenW3(String linInfoId, double newVal, Promise promise)
    {
        try {
            LinInfo linInfo = (LinInfo)getObjFromList(linInfoId);
            linInfo.setOutPenW3(newVal);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

   @ReactMethod
    public void getOutClr1(String linInfoId, Promise promise)
    {
        try {
            LinInfo linInfo = (LinInfo)getObjFromList(linInfoId);
            int outClr1 = linInfo.getOutClr1();

            promise.resolve(outClr1);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setOutClr1(String linInfoId, int color, Promise promise)
    {
        try {
            LinInfo linInfo = (LinInfo)getObjFromList(linInfoId);
            linInfo.setOutClr1(color);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getOutClr2(String linInfoId, Promise promise)
    {
        try {
            LinInfo linInfo = (LinInfo)getObjFromList(linInfoId);
            int outClr2 = linInfo.getOutClr2();

            promise.resolve(outClr2);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setOutClr2(String linInfoId, int color, Promise promise)
    {
        try {
            LinInfo linInfo = (LinInfo)getObjFromList(linInfoId);
            linInfo.setOutClr2(color);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getOutClr3(String linInfoId, Promise promise)
    {
        try {
            LinInfo linInfo = (LinInfo)getObjFromList(linInfoId);
            int outClr3 = linInfo.getOutClr3();

            promise.resolve(outClr3);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setOutClr3(String linInfoId, int color, Promise promise)
    {
        try {
            LinInfo linInfo = (LinInfo)getObjFromList(linInfoId);
            linInfo.setOutClr3(color);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getHeadType(String linInfoId, Promise promise)
    {
        try {
            LinInfo linInfo = (LinInfo)getObjFromList(linInfoId);
            int type = linInfo.getHeadType();
            promise.resolve(type);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

   @ReactMethod
    public void setHeadType(String linInfoId, int newVal, Promise promise)
    {
        try {
            LinInfo linInfo = (LinInfo)getObjFromList(linInfoId);
            linInfo.setHeadType((short)newVal);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getJoinType(String linInfoId, Promise promise)
    {
        try {
            LinInfo linInfo = (LinInfo)getObjFromList(linInfoId);
            int type = linInfo.getJoinType();
            promise.resolve(type);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

   @ReactMethod
    public void setJoinType(String linInfoId, int newVal, Promise promise)
    {
        try {
            LinInfo linInfo = (LinInfo)getObjFromList(linInfoId);
            linInfo.setJoinType((short)newVal);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getAdjustFlg(String linInfoId, Promise promise)
    {
        try {
            LinInfo linInfo = (LinInfo)getObjFromList(linInfoId);
            int adjustFlg = linInfo.getAdjustFlg();
            promise.resolve(adjustFlg);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setAdjustFlg(String linInfoId, int newVal, Promise promise)
    {
        try {
            LinInfo linInfo = (LinInfo)getObjFromList(linInfoId);
            linInfo.setAdjustFlg((short)newVal);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

   @ReactMethod
    public void getMakeMethod(String linInfoId, Promise promise)
    {
        try {
            LinInfo linInfo = (LinInfo)getObjFromList(linInfoId);
            int makeMethod = linInfo.getMakeMethod();
            promise.resolve(makeMethod);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setMakeMethod(String linInfoId, int newVal, Promise promise)
    {
        try {
            LinInfo linInfo = (LinInfo)getObjFromList(linInfoId);
            linInfo.setMakeMethod((short)newVal);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getXScale(String linInfoId, Promise promise)
    {
        try {
            LinInfo linInfo = (LinInfo)getObjFromList(linInfoId);
            double xScale = linInfo.getXScale();
            promise.resolve(xScale);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setXScale(String linInfoId, double newVal, Promise promise)
    {
        try {
            LinInfo linInfo = (LinInfo)getObjFromList(linInfoId);
            linInfo.setXScale(newVal);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

   @ReactMethod
    public void getYScale(String linInfoId, Promise promise)
    {
        try {
            LinInfo linInfo = (LinInfo)getObjFromList(linInfoId);
            double yScale = linInfo.getYScale();
            promise.resolve(yScale);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setYScale(String linInfoId, double newVal, Promise promise)
    {
        try {
            LinInfo linInfo = (LinInfo)getObjFromList(linInfoId);
            linInfo.setYScale(newVal);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

   @ReactMethod
    public void getGeomType(String linInfoId, Promise promise) {
        try {
            LinInfo linInfo = (LinInfo)getObjFromList(linInfoId);
            GeomType geomType = linInfo.getGeomType();
            int type = Enumeration.getValueByName(GeomType.class, geomType.name());
            promise.resolve(type);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setOvprnt(String linInfoId, boolean newVal, Promise promise) {
        try {
            LinInfo linInfo = (LinInfo)getObjFromList(linInfoId);
            linInfo.setOvprnt(newVal);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

   @ReactMethod
    public void Clone(String linInfoId, Promise promise) {
        try {
            LinInfo linInfo = (LinInfo)getObjFromList(linInfoId);
            GeomInfo geomInfo = linInfo.Clone();
            String geomInfoId = registerId(geomInfo);
            WritableMap map = Arguments.createMap();
            map.putString("GeomInfoId", geomInfoId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }
}
