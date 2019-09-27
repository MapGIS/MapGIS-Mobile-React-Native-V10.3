package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.core.map.AllOtherDataItemInfoSource;
import com.zondy.mapgis.core.map.ThemeInfo;
import com.zondy.mapgis.core.map.UniqueTheme;
import com.zondy.mapgis.core.map.UniqueThemeInfo;
import com.zondy.mapgis.core.object.Enumeration;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * 唯一值专题图Native功能组件
 * Created by xiaoying on 2019/9/4.
 */
public class JSUniqueTheme extends JSVectorTheme {
    private static final String REACT_CLASS = "JSUniqueTheme";
    public static Map<String, UniqueTheme> mUniqueThemeList = new HashMap<>();
    public JSUniqueTheme(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @ReactMethod
    public void createObj(Promise promise){
        try {
            UniqueTheme uniqueTheme = new UniqueTheme();
            String uniqueThemeId = registerId(uniqueTheme);

            WritableMap writableMap = Arguments.createMap();
            writableMap.putString("UniqueThemeId", uniqueThemeId);
            promise.resolve(writableMap);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getDefaultInfo(String uniqueThemeId, Promise promise){
        try {
            UniqueTheme uniqueTheme = (UniqueTheme) getObjFromList(uniqueThemeId);
            ThemeInfo themeInfo = uniqueTheme.getDefaultInfo();
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
    public void setDefaultInfo(String uniqueThemeId, String themeInfoId, Promise promise){
        try {
            UniqueTheme uniqueTheme = (UniqueTheme) getObjFromList(uniqueThemeId);
            ThemeInfo themeInfo = JSThemeInfo.getObjFromList(themeInfoId);
            uniqueTheme.setDefaultInfo(themeInfo);

            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getExpression(String uniqueThemeId, Promise promise){
        try {
            UniqueTheme uniqueTheme = (UniqueTheme) getObjFromList(uniqueThemeId);
            String expression = uniqueTheme.getExpression();

            promise.resolve(expression);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setExpression(String uniqueThemeId, String expression, Promise promise){
        try {
            UniqueTheme uniqueTheme = (UniqueTheme) getObjFromList(uniqueThemeId);
            uniqueTheme.setExpression(expression);

            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getCount(String uniqueThemeId, Promise promise){
        try {
            UniqueTheme uniqueTheme = (UniqueTheme) getObjFromList(uniqueThemeId);
            int count = (int) uniqueTheme.getCount();

            promise.resolve(count);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getAllOtherDataItemInfoSource(String uniqueThemeId, Promise promise){
        try {
            UniqueTheme uniqueTheme = (UniqueTheme) getObjFromList(uniqueThemeId);
            AllOtherDataItemInfoSource allOtherDataItemInfoSource = uniqueTheme.getAllOtherDataItemInfoSource();

            promise.resolve(allOtherDataItemInfoSource.value());
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setAllOtherDataItemInfoSource(String uniqueThemeId, int allOtherDataItemInfoSource, Promise promise){
        try {
            UniqueTheme uniqueTheme = (UniqueTheme) getObjFromList(uniqueThemeId);
            AllOtherDataItemInfoSource allOtherDataItemInfoSource1 = (AllOtherDataItemInfoSource) Enumeration.parse(AllOtherDataItemInfoSource.class, allOtherDataItemInfoSource);
            uniqueTheme.setAllOtherDataItemInfoSource(allOtherDataItemInfoSource1);

            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void append(String uniqueThemeId, String uniqueThemeInfoId, Promise promise){
        try {
            UniqueTheme uniqueTheme = (UniqueTheme) getObjFromList(uniqueThemeId);
            UniqueThemeInfo uniqueThemeInfo = (UniqueThemeInfo) JSUniqueThemeInfo.getObjFromList(uniqueThemeInfoId);
            int index = (int) uniqueTheme.append(uniqueThemeInfo);

            promise.resolve(index);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void removeByIndex(String uniqueThemeId, int index, Promise promise){
        try {
            UniqueTheme uniqueTheme = (UniqueTheme) getObjFromList(uniqueThemeId);
            boolean result = uniqueTheme.remove(index);

            promise.resolve(result);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void removeByValue(String uniqueThemeId, String value, Promise promise){
        try {
            UniqueTheme uniqueTheme = (UniqueTheme) getObjFromList(uniqueThemeId);
            boolean result = uniqueTheme.remove(value);

            promise.resolve(result);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void indexOf(String uniqueThemeId, String value, Promise promise){
        try {
            UniqueTheme uniqueTheme = (UniqueTheme) getObjFromList(uniqueThemeId);
            int index = (int) uniqueTheme.indexOf(value);

            promise.resolve(index);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void clear(String uniqueThemeId, Promise promise){
        try {
            UniqueTheme uniqueTheme = (UniqueTheme) getObjFromList(uniqueThemeId);
            boolean result = uniqueTheme.clear();

            promise.resolve(result);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setItem(String uniqueThemeId, int index, String uniqueThemeInfoId, Promise promise){
        try {
            UniqueTheme uniqueTheme = (UniqueTheme) getObjFromList(uniqueThemeId);
            UniqueThemeInfo uniqueThemeInfo = (UniqueThemeInfo) JSUniqueThemeInfo.getObjFromList(uniqueThemeInfoId);
            boolean result = uniqueTheme.setItem(index, uniqueThemeInfo);

            promise.resolve(result);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getItem(String uniqueThemeId, int index, Promise promise){
        try {
            UniqueTheme uniqueTheme = (UniqueTheme) getObjFromList(uniqueThemeId);
            UniqueThemeInfo uniqueThemeInfo = uniqueTheme.getItem(index);
            String uniqueThemeInfoId = null;
            if(uniqueThemeInfo != null){
                uniqueThemeInfoId = JSUniqueThemeInfo.registerId(uniqueThemeInfo);
            }
            WritableMap writableMap = Arguments.createMap();
            writableMap.putString("UniqueThemeInfoId", uniqueThemeInfoId);

            promise.resolve(writableMap);
        }catch (Exception e){
            promise.reject(e);
        }
    }

}
