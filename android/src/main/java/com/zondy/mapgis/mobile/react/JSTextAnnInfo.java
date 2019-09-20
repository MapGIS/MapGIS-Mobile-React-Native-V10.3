package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.core.geometry.AnnType;
import com.zondy.mapgis.core.geometry.GeomType;
import com.zondy.mapgis.core.info.TextAnnInfo;
import com.zondy.mapgis.core.object.Enumeration;

public class JSTextAnnInfo extends JSAnnInfo{

    public static final String REACT_CLASS = "JSTextAnnInfo";

    public JSTextAnnInfo(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @ReactMethod
    public void createObj(Promise promise){
        try{
            TextAnnInfo textAnnInfo = new TextAnnInfo();
            String textAnnInfoId = registerId(textAnnInfo);

            WritableMap map = Arguments.createMap();
            map.putString("TextAnnInfoId",textAnnInfoId);
            promise.resolve(map);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getHeight(String textAnnInfoId, Promise promise)
    {
        try {
            TextAnnInfo textAnnInfo = (TextAnnInfo)getObjFromList(textAnnInfoId);
            double height = textAnnInfo.getHeight();
            promise.resolve(height);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setHeight(String textAnnInfoId, double newVal, Promise promise)
    {
        try {
            TextAnnInfo textAnnInfo = (TextAnnInfo)getObjFromList(textAnnInfoId);
            textAnnInfo.setHeight(newVal);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getWidth(String textAnnInfoId, Promise promise)
    {
        try {
            TextAnnInfo textAnnInfo = (TextAnnInfo)getObjFromList(textAnnInfoId);
            double width = textAnnInfo.getWidth();
            promise.resolve(width);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setWidth(String textAnnInfoId, double newVal, Promise promise)
    {
        try {
            TextAnnInfo textAnnInfo = (TextAnnInfo)getObjFromList(textAnnInfoId);
            textAnnInfo.setWidth(newVal);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getSpace(String textAnnInfoId, Promise promise)
    {
        try {
            TextAnnInfo textAnnInfo = (TextAnnInfo)getObjFromList(textAnnInfoId);
            double space = textAnnInfo.getSpace();
            promise.resolve(space);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setSpace(String textAnnInfoId, double newVal, Promise promise)
    {
        try {
            TextAnnInfo textAnnInfo = (TextAnnInfo)getObjFromList(textAnnInfoId);
            textAnnInfo.setSpace(newVal);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getFontAngle(String textAnnInfoId, Promise promise)
    {
        try {
            TextAnnInfo textAnnInfo = (TextAnnInfo)getObjFromList(textAnnInfoId);
            double angle = textAnnInfo.getFontAngle();
            promise.resolve(angle);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setFontAngle(String textAnnInfoId, double newVal, Promise promise)
    {
        try {
            TextAnnInfo textAnnInfo = (TextAnnInfo)getObjFromList(textAnnInfoId);
            textAnnInfo.setFontAngle(newVal);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getAngle(String textAnnInfoId, Promise promise)
    {
        try {
            TextAnnInfo textAnnInfo = (TextAnnInfo)getObjFromList(textAnnInfoId);
            double angle = textAnnInfo.getAngle();
            promise.resolve(angle);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setAngle(String textAnnInfoId, double newVal, Promise promise)
    {
        try {
            TextAnnInfo textAnnInfo = (TextAnnInfo)getObjFromList(textAnnInfoId);
            textAnnInfo.setAngle(newVal);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getIfnt(String textAnnInfoId, Promise promise)
    {
        try {
            TextAnnInfo textAnnInfo = (TextAnnInfo)getObjFromList(textAnnInfoId);
            short ifnt = textAnnInfo.getIfnt();
            promise.resolve(ifnt);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setIfnt(String textAnnInfoId, short newVal, Promise promise)
    {
        try {
            TextAnnInfo textAnnInfo = (TextAnnInfo)getObjFromList(textAnnInfoId);
            textAnnInfo.setIfnt(newVal);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getChnt(String textAnnInfoId, Promise promise)
    {
        try {
            TextAnnInfo textAnnInfo = (TextAnnInfo)getObjFromList(textAnnInfoId);
            short chnt = textAnnInfo.getChnt();
            promise.resolve(chnt);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setChnt(String textAnnInfoId, short newVal, Promise promise)
    {
        try {
            TextAnnInfo textAnnInfo = (TextAnnInfo)getObjFromList(textAnnInfoId);
            textAnnInfo.setChnt(newVal);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getIfnx(String textAnnInfoId, Promise promise)
    {
        try {
            TextAnnInfo textAnnInfo = (TextAnnInfo)getObjFromList(textAnnInfoId);
            short ifnx = textAnnInfo.getIfnx();
            promise.resolve(ifnx);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setIfnx(String textAnnInfoId, short newVal, Promise promise)
    {
        try {
            TextAnnInfo textAnnInfo = (TextAnnInfo)getObjFromList(textAnnInfoId);
            textAnnInfo.setIfnx(newVal);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getIsHzpl(String textAnnInfoId, Promise promise)
    {
        try {
            TextAnnInfo textAnnInfo = (TextAnnInfo)getObjFromList(textAnnInfoId);
            boolean isHzpl = textAnnInfo.getIsHzpl();
            promise.resolve(isHzpl);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setIsHzpl(String textAnnInfoId, boolean newVal, Promise promise)
    {
        try {
            TextAnnInfo textAnnInfo = (TextAnnInfo)getObjFromList(textAnnInfoId);
            textAnnInfo.setIsHzpl(newVal);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getColor(String textAnnInfoId, Promise promise)
    {
        try {
            TextAnnInfo textAnnInfo = (TextAnnInfo)getObjFromList(textAnnInfoId);
            int color = (int)textAnnInfo.getColor();
            promise.resolve(color);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setColor(String textAnnInfoId, int newVal, Promise promise)
    {
        try {
            TextAnnInfo textAnnInfo = (TextAnnInfo)getObjFromList(textAnnInfoId);
            textAnnInfo.setColor(newVal);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getIsOvprnt(String textAnnInfoId, Promise promise)
    {
        try {
            TextAnnInfo textAnnInfo = (TextAnnInfo)getObjFromList(textAnnInfoId);
            boolean isOvprnt = textAnnInfo.getIsOvprnt();
            promise.resolve(isOvprnt);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

   @ReactMethod
    public void setIsOvprnt(String textAnnInfoId, boolean newVal, Promise promise)
    {
        try {
            TextAnnInfo textAnnInfo = (TextAnnInfo)getObjFromList(textAnnInfoId);
            textAnnInfo.setIsOvprnt(newVal);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getIsFilled(String textAnnInfoId, Promise promise)
    {
        try {
            TextAnnInfo textAnnInfo = (TextAnnInfo)getObjFromList(textAnnInfoId);
            boolean isFilled = textAnnInfo.getIsFilled();
            promise.resolve(isFilled);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setIsFilled(String textAnnInfoId, boolean newVal, Promise promise)
    {
        try {
            TextAnnInfo textAnnInfo = (TextAnnInfo)getObjFromList(textAnnInfoId);
            textAnnInfo.setIsFilled(newVal);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getBackExp(String textAnnInfoId, Promise promise)
    {
        try {
            TextAnnInfo textAnnInfo = (TextAnnInfo)getObjFromList(textAnnInfoId);
            double backExp = textAnnInfo.getBackExp();
            promise.resolve(backExp);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setBackExp(String textAnnInfoId, double newVal, Promise promise)
    {
        try {
            TextAnnInfo textAnnInfo = (TextAnnInfo)getObjFromList(textAnnInfoId);
            textAnnInfo.setBackExp(newVal);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getBackClr(String textAnnInfoId, Promise promise)
    {
        try {
            TextAnnInfo textAnnInfo = (TextAnnInfo)getObjFromList(textAnnInfoId);
            int backClr = (int)textAnnInfo.getBackClr();
            promise.resolve(backClr);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setBackClr(String textAnnInfoId, int newVal, Promise promise)
    {
        try {
            TextAnnInfo textAnnInfo = (TextAnnInfo)getObjFromList(textAnnInfoId);
            textAnnInfo.setBackClr(newVal);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getOffsetX(String textAnnInfoId, Promise promise)
    {
        try {
            TextAnnInfo textAnnInfo = (TextAnnInfo)getObjFromList(textAnnInfoId);
            double offsetX = textAnnInfo.getOffsetX();
            promise.resolve(offsetX);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setOffsetX(String textAnnInfoId, double newVal, Promise promise)
    {
        try {
            TextAnnInfo textAnnInfo = (TextAnnInfo)getObjFromList(textAnnInfoId);
            textAnnInfo.setOffsetX(newVal);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getOffsetY(String textAnnInfoId, Promise promise)
    {
        try {
            TextAnnInfo textAnnInfo = (TextAnnInfo)getObjFromList(textAnnInfoId);
            double offsetY = textAnnInfo.getOffsetY();
            promise.resolve(offsetY);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setOffsetY(String textAnnInfoId, double newVal, Promise promise)
    {
        try {
            TextAnnInfo textAnnInfo = (TextAnnInfo)getObjFromList(textAnnInfoId);
            textAnnInfo.setOffsetY(newVal);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getAnnType(String textAnnInfoId, Promise promise) {
        try {
            TextAnnInfo textAnnInfo = (TextAnnInfo)getObjFromList(textAnnInfoId);
            AnnType annType = textAnnInfo.getAnnType();
            int type = Enumeration.getValueByName(AnnType.class, annType.name());
            promise.resolve(type);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

   @ReactMethod
    public void getGeomType(String textAnnInfoId, Promise promise) {
        try {
            TextAnnInfo textAnnInfo = (TextAnnInfo)getObjFromList(textAnnInfoId);
            GeomType geomType = textAnnInfo.getGeomType();
            int type = Enumeration.getValueByName(GeomType.class, geomType.name());
            promise.resolve(type);
        } catch (Exception e) {
            promise.reject(e);
        }
    }
}
