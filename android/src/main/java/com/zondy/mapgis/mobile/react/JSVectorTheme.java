package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.zondy.mapgis.core.map.ThemeType;
import com.zondy.mapgis.core.map.VectorTheme;

/**
 * 矢量专题图
 * Created by xiaoying on 2019/9/4.
 */
public class JSVectorTheme extends JSTheme {
    private static final String REACT_CLASS = "JSVectorTheme";

    public JSVectorTheme(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @ReactMethod
    public void getType(String vectorThemeId, Promise promise){
        try {
            VectorTheme vectorTheme = (VectorTheme) getObjFromList(vectorThemeId);
            ThemeType themeType = vectorTheme.getType();

            promise.resolve(themeType.value());
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getVisible(String vectorThemeId, Promise promise){
        try {
            VectorTheme vectorTheme = (VectorTheme) getObjFromList(vectorThemeId);
            boolean result = vectorTheme.getVisible();

            promise.resolve(result);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setVisible(String vectorThemeId, boolean isVisible, Promise promise){
        try {
            VectorTheme vectorTheme = (VectorTheme) getObjFromList(vectorThemeId);
            int result = (int) vectorTheme.setVisible(isVisible);

            promise.resolve(result);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getName(String vectorThemeId, Promise promise){
        try {
            VectorTheme vectorTheme = (VectorTheme) getObjFromList(vectorThemeId);
            String name = vectorTheme.getName();

            promise.resolve(name);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setName(String vectorThemeId, String name, Promise promise){
        try {
            VectorTheme vectorTheme = (VectorTheme) getObjFromList(vectorThemeId);
            int result = (int) vectorTheme.setName(name);

            promise.resolve(result);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getIsBaseTheme(String vectorThemeId, Promise promise){
        try {
            VectorTheme vectorTheme = (VectorTheme) getObjFromList(vectorThemeId);
            boolean result = vectorTheme.getIsBaseTheme();

            promise.resolve(result);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void toXML(String vectorThemeId, boolean onlyStyle, Promise promise){
        try {
            VectorTheme vectorTheme = (VectorTheme) getObjFromList(vectorThemeId);
            String xml = vectorTheme.toXML(onlyStyle);

            promise.resolve(xml);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void fromXML(String vectorThemeId, String strXML, boolean onlyStyle, Promise promise){
        try {
            VectorTheme vectorTheme = (VectorTheme) getObjFromList(vectorThemeId);
           boolean result = vectorTheme.fromXML(strXML, onlyStyle);

           promise.resolve(result);
        }catch (Exception e){
            promise.reject(e);
        }
    }
}
