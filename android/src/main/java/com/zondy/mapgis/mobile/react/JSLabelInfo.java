package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.core.info.TextAnnInfo;
import com.zondy.mapgis.core.map.LabelInfo;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by xiaoying on 2019/9/2.
 */
public class JSLabelInfo extends ReactContextBaseJavaModule {
    private  static final String REACT_CLASS = "JSLabelInfo";
    private static Map<String, LabelInfo> mLableInfoList = new HashMap<>();

    public JSLabelInfo(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public static LabelInfo getObjFromList(String id){
        return mLableInfoList.get(id);
    }

    public static String registerId(LabelInfo obj){
        for(Map.Entry entry : mLableInfoList.entrySet()){
            if(obj.equals(entry.getValue())){
                String id = (String) entry.getKey();
                return id;
            }
        }
        String id = UUID.randomUUID().toString().substring(24);
        mLableInfoList.put(id,obj);
        return id;
    }

    @ReactMethod
    public void createObj(Promise promise){
        try {
            LabelInfo labelInfo = new LabelInfo();
            String LabelInfoId = registerId(labelInfo);

            WritableMap writableMap = Arguments.createMap();
            writableMap.putString("LabelInfoId",LabelInfoId);
            promise.resolve(writableMap);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getCaption(String labelInfoId, Promise promise){
        try {
            LabelInfo labelInfo = getObjFromList(labelInfoId);
            String caption = labelInfo.getCaption();
            promise.resolve(caption);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setCaption(String labelInfoId, String caption, Promise promise){
        try {
            LabelInfo labelInfo = getObjFromList(labelInfoId);
            labelInfo.setCaption(caption);
            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getIsVisible(String labelInfoId, Promise promise){
        try {
            LabelInfo labelInfo = getObjFromList(labelInfoId);
            boolean isVisible = labelInfo.getIsVisible();
            promise.resolve(isVisible);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setIsVisible(String labelInfoId, boolean isVisible, Promise promise){
        try {
            LabelInfo labelInfo = getObjFromList(labelInfoId);
            labelInfo.setIsVisible(isVisible);
            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getMinScale(String labelInfoId, Promise promise){
        try {
            LabelInfo labelInfo = getObjFromList(labelInfoId);
            double minScale = labelInfo.getMinScale();
            promise.resolve(minScale);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setMinScale(String labelInfoId, double minScale, Promise promise){
        try {
            LabelInfo labelInfo = getObjFromList(labelInfoId);
            labelInfo.setMinScale(minScale);
            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getMaxScale(String labelInfoId, Promise promise){
        try {
            LabelInfo labelInfo = getObjFromList(labelInfoId);
            double maxScale = labelInfo.getMaxScale();
            promise.resolve(maxScale);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setMaxScale(String labelInfoId, double maxScale, Promise promise){
        try {
            LabelInfo labelInfo = getObjFromList(labelInfoId);
            labelInfo.setMaxScale(maxScale);
            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getAnnInfo(String labelInfoId, Promise promise){
        try {
            LabelInfo labelInfo = getObjFromList(labelInfoId);
            TextAnnInfo textAnnInfo = labelInfo.getAnnInfo();
            String textAnnInfoId = null;
            if(textAnnInfo != null){
                textAnnInfoId = JSTextAnnInfo.registerId(textAnnInfo);
            }

            WritableMap writableMap = Arguments.createMap();
            writableMap.putString("TextAnnInfoId", textAnnInfoId);
            promise.resolve(writableMap);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setAnnInfo(String labelInfoId, String textAnnInfoId, Promise promise){
        try {
            LabelInfo labelInfo = getObjFromList(labelInfoId);
            TextAnnInfo textAnnInfo = (TextAnnInfo) JSTextAnnInfo.getObjFromList(textAnnInfoId);
            labelInfo.setAnnInfo(textAnnInfo);

            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

}
