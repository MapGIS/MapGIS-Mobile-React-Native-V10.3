package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.core.map.SimpleTheme;
import com.zondy.mapgis.core.map.ThemeInfo;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * 简单专题图Native功能组件
 * Created by xiaoying on 2019/9/3.
 */
public class JSSimpleTheme extends JSVectorTheme {
    private  static final String REACT_CLASS = "JSSimpleTheme";
    public static Map<String, SimpleTheme> mSimpleThemeList = new HashMap<>();

    public JSSimpleTheme(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @ReactMethod
    public void createObj(Promise promise){
        try {
            SimpleTheme simpleTheme = new SimpleTheme();
            String simpleThemeId = registerId(simpleTheme);

            WritableMap writableMap = Arguments.createMap();
            writableMap.putString("SimpleThemeId", simpleThemeId);
            promise.resolve(writableMap);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getThemeInfo(String simpleThemeId, Promise promise){
        try {
            SimpleTheme simpleTheme = (SimpleTheme) getObjFromList(simpleThemeId);
            ThemeInfo themeInfo = simpleTheme.getThemeInfo();
            String themeInfoId = null;
            if(themeInfo != null){
                themeInfoId = JSThemeInfo.registerId(themeInfo);
            }

            WritableMap writableMap = Arguments.createMap();
            writableMap.putString("ThemeInfoId", themeInfoId);
            promise.resolve(writableMap);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setThemeInfo(String simpleThemeId, String themeInfoId, Promise promise){
        try {
            SimpleTheme simpleTheme = (SimpleTheme) getObjFromList(simpleThemeId);
            ThemeInfo themeInfo = JSThemeInfo.getObjFromList(themeInfoId);
            simpleTheme.setThemeInfo(themeInfo);

            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }
}
