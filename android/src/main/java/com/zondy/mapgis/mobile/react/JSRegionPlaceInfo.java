package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.core.map.DuplicateType;
import com.zondy.mapgis.core.map.RegPlaceType;
import com.zondy.mapgis.core.map.RegionPlaceInfo;
import com.zondy.mapgis.core.object.Enumeration;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * 区标注Native功能组件
 * Created by xiaoying on 2019/9/3.
 */
public class JSRegionPlaceInfo extends ReactContextBaseJavaModule {
    private static final String REACT_CLASS = "JSRegionPlaceInfo";
    public static Map<String, RegionPlaceInfo> mRegionPlaceInfoList = new HashMap<>();

    public JSRegionPlaceInfo(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public static RegionPlaceInfo getObjFromList(String id){
        return mRegionPlaceInfoList.get(id);
    }

    public static String registerId(RegionPlaceInfo obj){
        for(Map.Entry entry : mRegionPlaceInfoList.entrySet()){
            if(obj.equals(entry.getValue())){
                String id = (String) entry.getKey();
                return id;
            }
        }
        Calendar calendar = Calendar.getInstance();
        String id = Long.toString(calendar.getTimeInMillis());
        mRegionPlaceInfoList.put(id,obj);
        return id;
    }

    @ReactMethod
    public void createObj(Promise promise){
        try {
            RegionPlaceInfo regionPlaceInfo = new RegionPlaceInfo();
            String regionPlaceInfoId = registerId(regionPlaceInfo);

            WritableMap writableMap = Arguments.createMap();
            writableMap.putString("RegionPlaceInfoId", regionPlaceInfoId);
            promise.resolve(writableMap);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getType(String regionPlaceInfoId, Promise promise){
        try {
            RegionPlaceInfo regionPlaceInfo = getObjFromList(regionPlaceInfoId);
            int regPlaceType = regionPlaceInfo.getType().value();

            promise.resolve(regPlaceType);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setType(String regionPlaceInfoId, int regPlaceType, Promise promise){
        try {
            RegionPlaceInfo regionPlaceInfo = getObjFromList(regionPlaceInfoId);

            RegPlaceType regPlaceType1 = (RegPlaceType) Enumeration.parse(RegPlaceType.class, regPlaceType);
            regionPlaceInfo.setType(regPlaceType1);

            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getTryLabelOutside(String regionPlaceInfoId, Promise promise){
        try {
            RegionPlaceInfo regionPlaceInfo = getObjFromList(regionPlaceInfoId);
            boolean tryLabelOutside = regionPlaceInfo.getTryLabelOutside();

            promise.resolve(tryLabelOutside);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setTryLabelOutside(String regionPlaceInfoId, boolean tryLabelOutside, Promise promise){
        try {
            RegionPlaceInfo regionPlaceInfo = getObjFromList(regionPlaceInfoId);
            regionPlaceInfo.setTryLabelOutside(tryLabelOutside);

            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getLimitLabelSmallRegion(String regionPlaceInfoId, Promise promise){
        try {
            RegionPlaceInfo regionPlaceInfo = getObjFromList(regionPlaceInfoId);
            boolean limitLabelSmallRegion = regionPlaceInfo.getLimitLabelSmallRegion();

            promise.resolve(limitLabelSmallRegion);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setLimitLabelSmallRegion(String regionPlaceInfoId, boolean limitLabelSmallRegion, Promise promise){
        try {
            RegionPlaceInfo regionPlaceInfo = getObjFromList(regionPlaceInfoId);
            regionPlaceInfo.setLimitLabelSmallRegion(limitLabelSmallRegion);

            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getSmallRegionMaxArea(String regionPlaceInfoId, Promise promise){
        try {
            RegionPlaceInfo regionPlaceInfo = getObjFromList(regionPlaceInfoId);
            double smallRegionMaxArea = regionPlaceInfo.getSmallRegionMaxArea();

            promise.resolve(smallRegionMaxArea);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setSmallRegionMaxArea(String regionPlaceInfoId, double smallRegionMaxArea, Promise promise){
        try {
            RegionPlaceInfo regionPlaceInfo = getObjFromList(regionPlaceInfoId);
            regionPlaceInfo.setSmallRegionMaxArea(smallRegionMaxArea);

            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getDuplicateType(String regionPlaceInfoId, Promise promise){
        try {
            RegionPlaceInfo regionPlaceInfo = getObjFromList(regionPlaceInfoId);
            DuplicateType duplicateType = regionPlaceInfo.getDuplicateType();

            promise.resolve(duplicateType.value());
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setDuplicateType(String regionPlaceInfoId, int duplicateType, Promise promise){
        try {
            RegionPlaceInfo regionPlaceInfo = getObjFromList(regionPlaceInfoId);
            DuplicateType duplicateType1 = (DuplicateType) Enumeration.parse(DuplicateType.class, duplicateType);
            regionPlaceInfo.DuplicateType(duplicateType1);

            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

}
