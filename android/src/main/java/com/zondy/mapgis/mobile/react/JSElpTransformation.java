package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.core.srs.ElpParam;
import com.zondy.mapgis.core.srs.ElpTransParam;
import com.zondy.mapgis.core.srs.ElpTransformation;
import com.zondy.mapgis.core.srs.Pnt3Struct;

public class JSElpTransformation extends ReactContextBaseJavaModule {

    private static final String REACT_CLASS = "JSElpTransformation";

    public JSElpTransformation(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @ReactMethod
    public void getElpParamCount(Promise promise)
    {
        try {
            int count = ElpTransformation.getElpParamCount();
            promise.resolve(count);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getElpParam(int index, Promise promise)
    {
        try {
            ElpParam elpParam = ElpTransformation.getElpParam(index);
            String paramId = JSElpParam.registerId(elpParam);
            WritableMap map = Arguments.createMap();
            map.putString("ElpParamId", paramId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

   @ReactMethod
    public void getElpParam(String name, Promise promise)
    {
        try {
            ElpParam elpParam = ElpTransformation.getElpParam(name);
            String paramId = JSElpParam.registerId(elpParam);
            WritableMap map = Arguments.createMap();
            map.putString("ElpParamId", paramId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setElpParam(int index, String paramId, Promise promise)
    {
        try {
            ElpParam param = JSElpParam.getObjFromList(paramId);
            ElpTransformation.setElpParam(index, param);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getElpTransParamCount(Promise promise)
    {
        try {
            int count = ElpTransformation.getElpTransParamCount();
            promise.resolve(count);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getElpTransParam(int index, Promise promise)
    {
        try {
            ElpTransParam elpTransParam = ElpTransformation.getElpTransParam(index);
            String elpTransParamId = JSElpTransParam.registerId(elpTransParam);
            WritableMap map = Arguments.createMap();
            map.putString("ElpTransParamId", elpTransParamId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getElpTransParam(String name, Promise promise)
    {
        try {
            ElpTransParam elpTransParam = ElpTransformation.getElpTransParam(name);
            String elpTransParamId = JSElpTransParam.registerId(elpTransParam);
            WritableMap map = Arguments.createMap();
            map.putString("ElpTransParamId", elpTransParamId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setElpTransParam(int index, String elpTransParamId, Promise promise)
    {
        try {
            ElpTransParam elpTransParam = JSElpTransParam.getObjFromList(elpTransParamId);
            boolean bIsTrans = ElpTransformation.setElpTransParam(index, elpTransParam);
            promise.resolve(bIsTrans);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

   @ReactMethod
    public void setElpTransParam(String name, String elpTransParamId, Promise promise)
    {
        try {
            ElpTransParam elpTransParam = JSElpTransParam.getObjFromList(elpTransParamId);
            boolean bIsTrans = ElpTransformation.setElpTransParam(name, elpTransParam);
            promise.resolve(bIsTrans);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void addElpTransParam(String elpTransParamId, Promise promise)
    {
        try {
            ElpTransParam elpTransParam = JSElpTransParam.getObjFromList(elpTransParamId);
            int iIndex = ElpTransformation.addElpTransParam(elpTransParam);
            promise.resolve(iIndex);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

   @ReactMethod
    public void delElpTransParam(int index, Promise promise)
    {
        try {
            boolean isDel = ElpTransformation.delElpTransParam(index);
            promise.resolve(isDel);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void delElpTransParam(String name, Promise promise)
    {
        try {
            boolean isDel = ElpTransformation.delElpTransParam(name);
            promise.resolve(isDel);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void clearElpTransParam(Promise promise)
    {
        try {
            boolean isClear = ElpTransformation.clearElpTransParam();
            promise.resolve(isClear);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void loadElpTransParam(String strFile, Promise promise)
    {
        try {
            boolean isLoad = ElpTransformation.loadElpTransParam(strFile);
            promise.resolve(isLoad);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void loadElpTransParam0(String strFile, Promise promise)
    {
        try {
            ElpTransParam[] elpTransParams = ElpTransformation.loadElpTransParam0(strFile);
            String strElpTransParamId = "";
            WritableArray arr = Arguments.createArray();
            if (elpTransParams.length > 0) {
                for (int i = 0; i < elpTransParams.length; i++) {
                    strElpTransParamId = JSElpTransParam.registerId(elpTransParams[i]);
                    arr.pushString(strElpTransParamId);
                }
            }
            WritableMap map = Arguments.createMap();
            map.putArray("ElpTransParamArr", arr);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void saveElpTransParam(String strFile, Promise promise)
    {
        try {
            boolean isSave = ElpTransformation.saveElpTransParam(strFile);
            promise.resolve(isSave);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void countCoeByPntList(int transType, ReadableArray pntsArray, int sourceSpheroid, int sourceAngUnit, int spheroid, int angUnit, Promise promise)
    {
        try {
            Pnt3Struct[] pnts = null;
            if (pntsArray.size() > 0)
            {
                pnts = new Pnt3Struct[pntsArray.size()];
                for (int i = 0; i < pntsArray.size(); i++) {
                    ReadableMap readable = pntsArray.getMap(i);
                    String keyStr = readable.getString("_Pnt3StructId");
                    pnts[i] = JSPnt3Struct.getObjFromList(keyStr);
                }
            }
            ElpTransParam elpTransParam = ElpTransformation.countCoeByPntList(transType, pnts, sourceSpheroid, sourceAngUnit, spheroid, angUnit);
            String elpTransParamId = JSElpTransParam.registerId(elpTransParam);
            WritableMap map = Arguments.createMap();
            map.putString("ElpTransParamId", elpTransParamId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

}
