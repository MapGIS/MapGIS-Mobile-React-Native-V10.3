package com.zondy.mapgis.mobile.react.scene;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.zondy.mapgis.android.sceneview.SunLightingMode;

import java.util.HashMap;
import java.util.Map;

/**
 * @auther LiaoLiang on 20-6-24
 * @content 光照类型
 */
public class JSSunLightingMode extends ReactContextBaseJavaModule {
    private static final String REACT_CLASS = "JSSunLightingMode";
    private static final String LIGHT = "LIGHT"; //有光照模式
    private static final String NONE = "NONE"; //无光照模式

    public JSSunLightingMode(@NonNull ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @NonNull
    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Nullable
    @Override
    public Map<String, Object> getConstants() {
        Map<String,Object> constants = new HashMap<>();
        constants.put(LIGHT, SunLightingMode.LIGHT.value());
        constants.put(NONE,SunLightingMode.NONE.value());
        return constants;
    }
}
