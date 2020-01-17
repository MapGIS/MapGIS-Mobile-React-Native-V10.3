package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.core.map.PointEightLocationPriority;
import com.zondy.mapgis.core.map.PointPlaceInfo;
import com.zondy.mapgis.core.map.PointPlaceType;
import com.zondy.mapgis.core.object.Enumeration;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 点标注信息Native功能组件
 * Created by xiaoying on 2019/9/3.
 */
public class JSPointPlaceInfo extends ReactContextBaseJavaModule {
    private static final String REACT_CLASS = "JSPointPlaceInfo";
    private static Map<String, PointPlaceInfo> mPointPlaceInfoList = new HashMap<>();

    public JSPointPlaceInfo(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public static PointPlaceInfo getObjFromList(String id){
        return mPointPlaceInfoList.get(id);
    }

    public static String registerId(PointPlaceInfo obj){
        for(Map.Entry entry : mPointPlaceInfoList.entrySet()){
            if(obj.equals(entry.getValue())){
                String id = (String) entry.getKey();
                return id;
            }
        }
        String id = UUID.randomUUID().toString().substring(24);
        mPointPlaceInfoList.put(id,obj);
        return id;
    }

    @ReactMethod
    public void createObj(Promise promise){
        try {
            PointPlaceInfo pointPlaceInfo = new PointPlaceInfo();
            String pointPlaceInfoId = registerId(pointPlaceInfo);

            WritableMap writableMap = Arguments.createMap();
            writableMap.putString("PointPlaceInfoId", pointPlaceInfoId);
            promise.resolve(writableMap);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getType(String pointPlaceInfoId, Promise promise){
        try {
            PointPlaceInfo pointPlaceInfo = getObjFromList(pointPlaceInfoId);
            PointPlaceType pointPlaceType = pointPlaceInfo.getType();

            promise.resolve(pointPlaceType.value());
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setType(String pointPlaceInfoId, int pointPlaceType, Promise promise)
    {
        try {
            PointPlaceInfo pointPlaceInfo = getObjFromList(pointPlaceInfoId);
            PointPlaceType pointPlaceType1 = (PointPlaceType) Enumeration.parse(PointPlaceType.class, pointPlaceType);
            pointPlaceInfo.setType(pointPlaceType1);

            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getOffset(String pointPlaceInfoId, Promise promise)
    {
        try {
            PointPlaceInfo pointPlaceInfo = getObjFromList(pointPlaceInfoId);
            double offset = pointPlaceInfo.getOffset();

            promise.resolve(offset);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setOffset(String pointPlaceInfoId, double offset, Promise promise)
    {
        try {
            PointPlaceInfo pointPlaceInfo = getObjFromList(pointPlaceInfoId);
            pointPlaceInfo.setOffset(offset);

            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getEightLocationPrioritys(String pointPlaceInfoId, Promise promise){
        try {
            PointPlaceInfo pointPlaceInfo = getObjFromList(pointPlaceInfoId);
            PointEightLocationPriority[] pointEightLocationPriorities = pointPlaceInfo.getEightLocationPrioritys();

            WritableArray writableArray = Arguments.createArray();

            for (int i = 0; i < pointEightLocationPriorities.length; i++){
                writableArray.pushInt(pointEightLocationPriorities[i].value());
            }

            promise.resolve(writableArray);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setEightLocationPrioritys(String pointPlaceInfoId, ReadableArray readableArray, Promise promise){
        try {
            PointPlaceInfo pointPlaceInfo = getObjFromList(pointPlaceInfoId);
            PointEightLocationPriority[] pointEightLocationPriorities = new PointEightLocationPriority[readableArray.size()];

            // 遍历readableArray，生成PointEightLocationPriority[]
            for (int i = 0; i < readableArray.size(); i++){
                int index = readableArray.getInt(i);
                PointEightLocationPriority pointEightLocationPriority = (PointEightLocationPriority) Enumeration.parse(PointEightLocationPriority.class, index);
                pointEightLocationPriorities[i] = pointEightLocationPriority;
            }
            pointPlaceInfo.setEightLocationPrioritys(pointEightLocationPriorities);

            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getLocationPrioritys(String pointPlaceInfoId, Promise promise){
        try {
            PointPlaceInfo pointPlaceInfo = getObjFromList(pointPlaceInfoId);
            double[] locationPriorities = pointPlaceInfo.getLocationPrioritys();

            WritableArray writableArray = Arguments.createArray();
            for (int i = 0; i < locationPriorities.length; i++){
                writableArray.pushDouble(locationPriorities[i]);
            }

            promise.resolve(writableArray);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setLocationPrioritys(String pointPlaceInfoId, ReadableArray readableArray, Promise promise) {
        try {
            PointPlaceInfo pointPlaceInfo = getObjFromList(pointPlaceInfoId);
            double[] priorities = new double[readableArray.size()];

            for (int i = 0; i < readableArray.size(); i++){
                priorities[i] = readableArray.getDouble(i);
            }
            pointPlaceInfo.setLocationPrioritys(priorities);

            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getAvoidPointSymbol(String pointPlaceInfoId, Promise promise) {
        try {
            PointPlaceInfo pointPlaceInfo = getObjFromList(pointPlaceInfoId);
            boolean result = pointPlaceInfo.getAvoidPointSymbol();

            promise.resolve(result);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setAvoidPointSymbol(String pointPlaceInfoId, boolean avoidPointSymbol, Promise promise){
        try {
            PointPlaceInfo pointPlaceInfo = getObjFromList(pointPlaceInfoId);
            pointPlaceInfo.setAvoidPointSymbol(avoidPointSymbol);

            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getFollowPointSymbolBorder(String pointPlaceInfoId, Promise promise) {
        try {
            PointPlaceInfo pointPlaceInfo = getObjFromList(pointPlaceInfoId);
            boolean result = pointPlaceInfo.getFollowPointSymbolBorder();

            promise.resolve(result);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setFollowPointSymbolBorder(String pointPlaceInfoId, boolean followPointSymbolBorder, Promise promise){
        try {
            PointPlaceInfo pointPlaceInfo = getObjFromList(pointPlaceInfoId);
            pointPlaceInfo.setFollowPointSymbolBorder(followPointSymbolBorder);

            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }
}
