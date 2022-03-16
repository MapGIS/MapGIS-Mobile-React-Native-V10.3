package com.zondy.mapgis.mobile.react.scene;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.zondy.mapgis.android.graphic.AltitudeMode;

import java.util.HashMap;
import java.util.Map;

/**
 * @auther LiaoLiang on 20-8-12
 * @content 高程模式类
 */
public class JSAltitudeMode extends ReactContextBaseJavaModule {
    private static final String REACT_CLASS = "JSAltitudeMode";

    private static final String CLAMPTOTERRAIN = "CLAMPTOTERRAIN"; //贴地形模式
    private static final String NONE = "NONE"; //绝对高程模式
    private static final String RELATIVETOTERRAIN = "RELATIVETOTERRAIN"; //相对地形高程模式
    @NonNull
    @Override
    public String getName() {
        return REACT_CLASS;
    }

    /*public JSAltitudeMode() {
        super();
    }*/

    public JSAltitudeMode(@NonNull ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Nullable
    @Override
    public Map<String, Object> getConstants() {
        Map<String,Object> constants = new HashMap<>();
        constants.put(CLAMPTOTERRAIN, AltitudeMode.CLAMPTOTERRAIN.value());
        constants.put(NONE, AltitudeMode.NONE.value());
        constants.put(RELATIVETOTERRAIN, AltitudeMode.RELATIVETOTERRAIN.value());

        return constants;
    }

    public AltitudeMode getAltitudeModeByValue(int value) {
        Map<String,Object> constants = new HashMap<>();
        constants.put(CLAMPTOTERRAIN, AltitudeMode.CLAMPTOTERRAIN.value());
        constants.put(NONE, AltitudeMode.NONE.value());
        constants.put(RELATIVETOTERRAIN, AltitudeMode.RELATIVETOTERRAIN.value());

        for (Map.Entry entry : constants.entrySet()) {
            if (entry.getValue().equals(value)) {
                AltitudeMode altitudeMode = new AltitudeMode(value){};
                return altitudeMode;
            }
        }
        return null;
    }
}
