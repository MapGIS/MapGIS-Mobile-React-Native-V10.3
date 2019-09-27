package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.core.map.LinePlaceInfo;
import com.zondy.mapgis.core.map.LinePlaceType;
import com.zondy.mapgis.core.map.LineRepeatType;
import com.zondy.mapgis.core.map.LineRestrictType;
import com.zondy.mapgis.core.map.LineSpreadType;
import com.zondy.mapgis.core.object.Enumeration;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaoying on 2019/9/2.
 */
public class JSLinePlaceInfo extends ReactContextBaseJavaModule {
    private static final String REACT_CLASS = "JSLinePlaceInfo";
    public static Map<String, LinePlaceInfo> mLinePlaceInfoList = new HashMap<>();

    public JSLinePlaceInfo(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public static LinePlaceInfo getObjFromList(String id){
        return mLinePlaceInfoList.get(id);
    }

    public static String registerId(LinePlaceInfo obj){
        for(Map.Entry entry : mLinePlaceInfoList.entrySet()){
            if(obj.equals(entry.getValue())){
                String id = (String) entry.getKey();
                return id;
            }
        }
        Calendar calendar = Calendar.getInstance();
        String id = Long.toString(calendar.getTimeInMillis());
        mLinePlaceInfoList.put(id,obj);
        return id;
    }

    @ReactMethod
    public void createObj(Promise promise){
        try {
            LinePlaceInfo linePlaceInfo = new LinePlaceInfo();
            String LinePlaceInfoId = registerId(linePlaceInfo);

            WritableMap writableMap = Arguments.createMap();
            writableMap.putString("LinePlaceInfoId", LinePlaceInfoId);
            promise.resolve(writableMap);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getType(String linePlaceInfoId, Promise promise){
        try {
            LinePlaceInfo linePlaceInfo = getObjFromList(linePlaceInfoId);
            int type = linePlaceInfo.getType().value();
            promise.resolve(type);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setType(String linePlaceInfoId, int linePlaceType, Promise promise){
        try {
            LinePlaceInfo linePlaceInfo = getObjFromList(linePlaceInfoId);
            LinePlaceType linePlaceType1 = (LinePlaceType) Enumeration.parse(LinePlaceType.class,linePlaceType);
            linePlaceInfo.setType(linePlaceType1);
            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getOffset(String linePlaceInfoId, Promise promise){
        try {
            LinePlaceInfo linePlaceInfo = getObjFromList(linePlaceInfoId);
            double offset = linePlaceInfo.getOffset();
            promise.resolve(offset);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setOffset(String linePlaceInfoId, double offset, Promise promise){
        try {
            LinePlaceInfo linePlaceInfo = getObjFromList(linePlaceInfoId);
            linePlaceInfo.setOffset(offset);
            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getRestrictType(String linePlaceInfoId, Promise promise){
        try {
            LinePlaceInfo linePlaceInfo = getObjFromList(linePlaceInfoId);
            int restrictType = linePlaceInfo.getRestrictType().value();
            promise.resolve(restrictType);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setRestrictType(String linePlaceInfoId, int restrictType, Promise promise){
        try {
            LinePlaceInfo linePlaceInfo = getObjFromList(linePlaceInfoId);
            LineRestrictType lineRestrictType = (LineRestrictType) Enumeration.parse(LineRestrictType.class, restrictType);
            linePlaceInfo.setRestrictType(lineRestrictType);
            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getSpreadType(String linePlaceInfoId, Promise promise){
        try {
            LinePlaceInfo linePlaceInfo = getObjFromList(linePlaceInfoId);
            int spreadType = linePlaceInfo.getSpreadType().value();
            promise.resolve(spreadType);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setSpreadType(String linePlaceInfoId, int spreadType, Promise promise){
        try {
            LinePlaceInfo linePlaceInfo = getObjFromList(linePlaceInfoId);
            LineSpreadType lineSpreadType = (LineSpreadType) Enumeration.parse(LineSpreadType.class, spreadType);
            linePlaceInfo.setSpreadType(lineSpreadType);
            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getRepeatType(String linePlaceInfoId, Promise promise){
        try {
            LinePlaceInfo linePlaceInfo = getObjFromList(linePlaceInfoId);
            int repeatType = linePlaceInfo.getRepeatType().value();
            promise.resolve(repeatType);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setRepeatType(String linePlaceInfoId, int repeatType, Promise promise){
        try {
            LinePlaceInfo linePlaceInfo = getObjFromList(linePlaceInfoId);
            LineRepeatType lineRepeatType = (LineRepeatType) Enumeration.parse(LineRepeatType.class, repeatType);
            linePlaceInfo.setRepeatType(lineRepeatType);
            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getInterval(String linePlaceInfoId, Promise promise){
        try {
            LinePlaceInfo linePlaceInfo = getObjFromList(linePlaceInfoId);
            double interval = linePlaceInfo.getInterval();
            promise.resolve(interval);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setInterval(String linePlaceInfoId, double interval, Promise promise){
        try{
            LinePlaceInfo linePlaceInfo = getObjFromList(linePlaceInfoId);
            linePlaceInfo.setInterval(interval);
            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }
}
