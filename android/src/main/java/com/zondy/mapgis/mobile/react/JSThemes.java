package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.core.map.Theme;
import com.zondy.mapgis.core.map.Themes;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * 专题图集合Native功能组件
 * Created by xiaoying on 2019/9/3.
 */
public class JSThemes extends ReactContextBaseJavaModule {
    private static final String REACT_CLASS = "JSThemes";
    public static Map<String, Themes> mThemesList = new HashMap<>();

    public JSThemes(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public static Themes getObjFromList(String id){
        return mThemesList.get(id);
    }

    public static String registerId(Themes obj){
        for(Map.Entry entry : mThemesList.entrySet()){
            if(obj.equals(entry.getValue())){
                String id = (String) entry.getKey();
                return id;
            }
        }
        Calendar calendar = Calendar.getInstance();
        String id = Long.toString(calendar.getTimeInMillis());
        mThemesList.put(id,obj);
        return id;
    }

    @ReactMethod
    public void createObj(Promise promise){
        try {
            Themes themes = new Themes();
            String themesId = registerId(themes);

            WritableMap writableMap = Arguments.createMap();
            writableMap.putString("ThemesId", themesId);
            promise.resolve(writableMap);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getCount(String themesId, Promise promise){
        try {
            Themes themes = getObjFromList(themesId);
            int count = (int) themes.getCount();

            promise.resolve(count);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getVisibleBaseTheme(String themesId, Promise promise){
        try {
            Themes themes = getObjFromList(themesId);
            Theme theme = themes.getVisibleBaseTheme();
            String themeId = null;
            if(theme != null){
                themeId = JSTheme.registerId(theme);

            }
            WritableMap writableMap = Arguments.createMap();
            writableMap.putString("ThemeId", themeId);
            promise.resolve(writableMap);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getVisibleSurfaceTheme(String themesId, Promise promise){
        try {
            Themes themes = getObjFromList(themesId);
            Theme theme = themes.getVisibleSurfaceTheme();
            String themeId = null;
            if(theme!=null){
               themeId = JSTheme.registerId(theme);

            }

            WritableMap writableMap = Arguments.createMap();
            writableMap.putString("ThemeId", themeId);
            promise.resolve(writableMap);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void append(String themesId, String themeId, Promise promise){
        try {
            Themes themes = getObjFromList(themesId);
            Theme theme = JSTheme.getObjFromList(themeId);
            boolean result = themes.append(theme);

            promise.resolve(result);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void remove(String themesId, int index, Promise promise){
        try {
            Themes themes = getObjFromList(themesId);
            boolean result = themes.remove(index);

            promise.resolve(result);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void clear(String themesId, Promise promise){
        try {
            Themes themes = getObjFromList(themesId);
            boolean result = themes.clear();

            promise.resolve(result);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getThemeByIndex(String themesId, int index, Promise promise){
        try {
            Themes themes = getObjFromList(themesId);
            Theme theme = themes.getTheme(index);
            String themeId = null;
            if(theme!=null){
                themeId = JSTheme.registerId(theme);
            }

            WritableMap writableMap = Arguments.createMap();
            writableMap.putString("ThemeId", themeId);
            promise.resolve(writableMap);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getThemeByName(String themesId, String name, int index, Promise promise){
        try {
            Themes themes = getObjFromList(themesId);
            Theme theme = themes.getTheme(name, index);
            String themeId = null;
            if(theme!=null){
                themeId = JSTheme.registerId(theme);
            }

            WritableMap writableMap = Arguments.createMap();
            writableMap.putString("ThemeId", themeId);
            promise.resolve(writableMap);
        }catch (Exception e){
            promise.reject(e);
        }
    }

}
