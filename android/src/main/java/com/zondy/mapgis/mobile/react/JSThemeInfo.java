package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.core.geometry.GeomType;
import com.zondy.mapgis.core.info.GeomInfo;
import com.zondy.mapgis.core.map.ThemeInfo;
import com.zondy.mapgis.core.object.Enumeration;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 专题图Native功能组件
 * Created by xiaoying on 2019/9/3.
 */
public class JSThemeInfo extends ReactContextBaseJavaModule {
    private static final String REACT_CLASS = "JSThemeInfo";
    private static Map<String, ThemeInfo> mThemeInfoList = new HashMap<>();

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
        String id = UUID.randomUUID().toString().substring(24);
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
            GeomType geomType = (GeomType) Enumeration.parse(GeomType.class, type);
            GeomInfo geomInfo = themeInfo.getGeoInfo(geomType);
            String geomInfoId = null;
            if (geomInfo != null){
                geomInfoId = JSGeomInfo.registerId(geomInfo);
            }
            WritableMap writableMap = Arguments.createMap();
            writableMap.putString("GeomInfoId", geomInfoId);
            promise.resolve(writableMap);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setGeoInfo(String themeInfoId,  String geomInfoId, Promise promise){
        try {
            ThemeInfo themeInfo = getObjFromList(themeInfoId);
            GeomInfo geomInfo = JSGeomInfo.getObjFromList(geomInfoId);
            themeInfo.setGeoInfo(geomInfo);

            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }


}
