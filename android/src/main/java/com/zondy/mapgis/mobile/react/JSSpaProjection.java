package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.core.geometry.Dot;
import com.zondy.mapgis.core.spatial.SpaProjection;
import com.zondy.mapgis.core.srs.ElpTransParam;
import com.zondy.mapgis.core.srs.SRefData;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class JSSpaProjection extends ReactContextBaseJavaModule {

    public static final String REACT_CLASS = "JSSpaProjection";
    public static Map<String, SpaProjection> mSpaProjectionList = new HashMap<String, SpaProjection>();

    public JSSpaProjection(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public static SpaProjection getObjFromList(String id) {
        return mSpaProjectionList.get(id);
    }

    public static String registerId(SpaProjection obj) {
        for (Map.Entry entry : mSpaProjectionList.entrySet()) {
            if (obj.equals(entry.getValue())) {
                return (String) entry.getKey();
            }
        }
        Calendar calendar = Calendar.getInstance();
        String id = Long.toString(calendar.getTimeInMillis());
        mSpaProjectionList.put(id, obj);
        return id;
    }

    @ReactMethod
    public void createObj(Promise promise) {
        try {
            SpaProjection spaProjection = new SpaProjection();
            String spaProjectionId = registerId(spaProjection);
            WritableMap map = Arguments.createMap();
            map.putString("SpaProjectionId", spaProjectionId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setSourcePara(String spaProjectionId, String sRefId, Promise promise)
    {
        try {
            SpaProjection spaProjection = getObjFromList(spaProjectionId);
            SRefData sRef = JSSRefData.getObjFromList(sRefId);
            int iVal = spaProjection.setSourcePara(sRef);
            promise.resolve(iVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

   @ReactMethod
    public void getSourcePara(String spaProjectionId, Promise promise)
    {
        try {
            SpaProjection spaProjection = getObjFromList(spaProjectionId);
            SRefData sRef = spaProjection.getSourcePara();
            String sRefId = JSSRefData.registerId(sRef);
            WritableMap map = Arguments.createMap();
            map.putString("SRefDataId", sRefId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setDestinationPara(String spaProjectionId, String sRefId, Promise promise)
    {
        try {
            SpaProjection spaProjection = getObjFromList(spaProjectionId);
            SRefData sRef = JSSRefData.getObjFromList(sRefId);
            int iVal = spaProjection.setDestinationPara(sRef);
            promise.resolve(iVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getDestinationPara(String spaProjectionId, Promise promise)
    {
        try {
            SpaProjection spaProjection = getObjFromList(spaProjectionId);
            SRefData sRefData = spaProjection.getDestinationPara();
            String sRefId = JSSRefData.registerId(sRefData);
            WritableMap map = Arguments.createMap();
            map.putString("SRefDataId", sRefId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setEllipTransId(String spaProjectionId, int transID, Promise promise)
    {
        try {
            SpaProjection spaProjection = getObjFromList(spaProjectionId);
            int iVal = spaProjection.setEllipTransId((short)transID);
            promise.resolve(iVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setEllipTransParam(String spaProjectionId, String paramId, Promise promise)
    {
        try {
            SpaProjection spaProjection = getObjFromList(spaProjectionId);
            ElpTransParam param = JSElpTransParam.getObjFromList(paramId);
            int iVal = spaProjection.setEllipTransParam(param);
            promise.resolve(iVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getEllipTransId(String spaProjectionId, Promise promise)
    {
        try {
            SpaProjection spaProjection = getObjFromList(spaProjectionId);
            int iVal = spaProjection.getEllipTransId();
            promise.resolve(iVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void projTrans(String spaProjectionId, String xyId, Promise promise)
    {
        try {
            SpaProjection spaProjection = getObjFromList(spaProjectionId);
            Dot xy = JSDot.getObjFromList(xyId);
            int iVal = spaProjection.projTrans(xy);
            promise.resolve(iVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public static void lonLat2Mercator(String dotId, Promise promise)
    {
        try {
            Dot dot = JSDot.getObjFromList(dotId);
            SpaProjection.lonLat2Mercator(dot);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public static void mercator2LonLat(String dotId, Promise promise)
    {
        try {
            Dot dot = JSDot.getObjFromList(dotId);
            SpaProjection.mercator2LonLat(dot);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }
}
