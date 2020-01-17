package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.core.map.RangeThemeInfo;

/**
 * 范围专题图项Native功能组件
 * Created by xiaoying on 2019/9/3.
 */
public class JSRangeThemeInfo extends JSThemeInfo {
    private static final String REACT_CLASS = "JSRangeThemeInfo";

    public JSRangeThemeInfo(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @ReactMethod
    public void createObj(Promise promise){
        try {
            RangeThemeInfo rangeThemeInfo = new RangeThemeInfo();
            String rangeThemeInfoId = registerId(rangeThemeInfo);

            WritableMap writableMap = Arguments.createMap();
            writableMap.putString("RangeThemeInfoId", rangeThemeInfoId);
            promise.resolve(writableMap);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getStartValue(String rangeThemeInfoId, Promise promise){
        try {
            RangeThemeInfo rangeThemeInfo = (RangeThemeInfo) getObjFromList(rangeThemeInfoId);
            String startValue = rangeThemeInfo.getStartValue();

            promise.resolve(startValue);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setStartValue(String rangeThemeInfoId, String startValue, Promise promise){
        try {
            RangeThemeInfo rangeThemeInfo = (RangeThemeInfo) getObjFromList(rangeThemeInfoId);
            rangeThemeInfo.setStartValue(startValue);

            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getEndValue(String rangeThemeInfoId, Promise promise){
        try {
            RangeThemeInfo rangeThemeInfo = (RangeThemeInfo) getObjFromList(rangeThemeInfoId);
            String endValue = rangeThemeInfo.getEndValue();

            promise.resolve(endValue);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setEndValue(String rangeThemeInfoId, String endValue, Promise promise){
        try {
            RangeThemeInfo rangeThemeInfo = (RangeThemeInfo) getObjFromList(rangeThemeInfoId);
            rangeThemeInfo.setEndValue(endValue);

            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

}
