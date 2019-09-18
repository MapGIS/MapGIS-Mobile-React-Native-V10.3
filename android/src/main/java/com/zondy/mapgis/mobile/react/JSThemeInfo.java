package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.core.map.ThemeInfo;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * 专题图Native功能组件
 * Created by xiaoying on 2019/9/3.
 */
public class JSThemeInfo extends ReactContextBaseJavaModule {
    private static final String REACT_CLASS = "JSThemeInfo";
    public static Map<String, ThemeInfo> mThemeInfoList = new HashMap<>();

    public JSThemeInfo(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public static ThemeInfo getObjFromList(String id){
        return mThemeInfoList.get(id);
    }

    public static String registerId(ThemeInfo obj){
        for(Map.Entry entry : mThemeInfoList.entrySet()){
            if(obj.equals(entry.getValue())){
                String id = (String) entry.getKey();
                return id;
            }
        }
        Calendar calendar = Calendar.getInstance();
        String id = Long.toString(calendar.getTimeInMillis());
        mThemeInfoList.put(id,obj);
        return id;
    }

    @ReactMethod
    public void createObj(Promise promise){
        try {
            ThemeInfo themeInfo = new ThemeInfo();
            String themeInfoId = registerId(themeInfo);

            WritableMap writableMap = Arguments.createMap();
            writableMap.putString("ThemeInfoId", themeInfoId);
            promise.resolve(writableMap);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getCaption(String themeInfoId, Promise promise){
        try {
            ThemeInfo themeInfo = getObjFromList(themeInfoId);
            String caption = themeInfo.getCaption();
            promise.resolve(caption);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setCaption(String themeInfoId, String caption, Promise promise){
        try {
            ThemeInfo themeInfo = getObjFromList(themeInfoId);
            themeInfo.setCaption(caption);
            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getIsVisible(String themeInfoId, Promise promise){
        try {
            ThemeInfo themeInfo = getObjFromList(themeInfoId);
            boolean isVisible = themeInfo.getIsVisible();
            promise.resolve(isVisible);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setIsVisible(String themeInfoId, boolean isVisible, Promise promise){
        try {
            ThemeInfo themeInfo = getObjFromList(themeInfoId);
            themeInfo.setIsVisible(isVisible);
            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getMinScale(String themeInfoId, Promise promise){
        try {
            ThemeInfo themeInfo = getObjFromList(themeInfoId);
            double minScale = themeInfo.getMinScale();
            promise.resolve(minScale);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setMinScale(String themeInfoId, double minScale, Promise promise){
        try {
            ThemeInfo themeInfo = getObjFromList(themeInfoId);
            themeInfo.setMinScale(minScale);
            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getMaxScale(String themeInfoId, Promise promise){
        try {
            ThemeInfo themeInfo = getObjFromList(themeInfoId);
            double maxScale = themeInfo.getMaxScale();
            promise.resolve(maxScale);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setMaxScale(String themeInfoId, double maxScale, Promise promise){
        try {
            ThemeInfo themeInfo = getObjFromList(themeInfoId);
            themeInfo.setMaxScale(maxScale);
            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getGeoInfo(String themeInfoId, int type, Promise promise){
        try {
            ThemeInfo themeInfo = getObjFromList(themeInfoId);

        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setGeoInfo(String themeInfoId,  Promise promise){
        try {
            ThemeInfo themeInfo = getObjFromList(themeInfoId);

        }catch (Exception e){
            promise.reject(e);
        }
    }


}
