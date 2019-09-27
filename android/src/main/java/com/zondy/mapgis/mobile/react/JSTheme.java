package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.zondy.mapgis.core.map.Theme;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * 专题图Native功能组件
 * Created by xiaoying on 2019/9/4.
 */
public class JSTheme extends ReactContextBaseJavaModule {
    private static final String REACT_CLASS = "JSTheme";
    public static Map<String, Theme> mThemeList = new HashMap<>();

    public JSTheme(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public static Theme getObjFromList(String id){
        return mThemeList.get(id);
    }

    public static String registerId(Theme obj){
        for (Map.Entry entry : mThemeList.entrySet()) {
            if (obj.equals(entry.getValue())) {
                String id = (String) entry.getKey();
                return id;
            }
        }

        Calendar calendar = Calendar.getInstance();
        String id = Long.toString(calendar.getTimeInMillis());
        mThemeList.put(id, obj);
        return id;
    }

    @ReactMethod
    public void getType(String themeId, Promise promise){
        try {
            Theme theme = getObjFromList(themeId);
            int type = theme.getType().value();

            promise.resolve(type);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setName(String themeId, String strThemeName, Promise promise){
        try {
            Theme theme = getObjFromList(themeId);
            int result = (int) theme.setName(strThemeName);

            promise.resolve(result);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getName(String themeId, Promise promise){
        try {
            Theme theme = getObjFromList(themeId);
            String name = theme.getName();

            promise.resolve(name);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getVisible(String themeId, Promise promise){
        try {
            Theme theme = getObjFromList(themeId);
            boolean result = theme.getVisible();

            promise.resolve(result);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setVisible(String themeId, boolean bVisible, Promise promise){
        try {
            Theme theme = getObjFromList(themeId);
            int result = (int) theme.setVisible(bVisible);

            promise.resolve(result);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getIsBaseTheme(String themeId, Promise promise){
        try {
            Theme theme = getObjFromList(themeId);
            boolean result = theme.getIsBaseTheme();

            promise.resolve(result);
        }catch (Exception e){
            promise.reject(e);
        }
    }
}
