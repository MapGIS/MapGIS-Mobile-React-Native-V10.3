package com.zondy.mapgis.mobile.react.scene;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.zondy.mapgis.android.graphic.GraphicState;

import java.util.HashMap;
import java.util.Map;

/**
 * @auther LiaoLiang on 20-8-13
 * @content 图形是否可见枚举
 */
public class JSGraphicState extends ReactContextBaseJavaModule {
    private static final String REACT_CLASS = "JSGraphicState";

    private static final String stateUnVisibleGraphic = "stateUnVisibleGraphic"; //图层不可见
    private static final String stateVisibleGraphic = "stateVisibleGraphic"; //图层可见

    @NonNull
    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public JSGraphicState(@NonNull ReactApplicationContext reactContext) {
        super(reactContext);
    }

    /*public JSGraphicState() {
        super();
    }*/

    @Nullable
    @Override
    public Map<String, Object> getConstants() {
        Map<String,Object> constants = new HashMap<>();
        constants.put(stateUnVisibleGraphic, GraphicState.stateUnVisibleGraphic.value());
        constants.put(stateVisibleGraphic,GraphicState.stateVisibleGraphic.value());

        return constants;
    }

    public GraphicState getGraphicStateByValue(int value) {
        Map<String,Object> constants = new HashMap<>();
        constants.put(stateUnVisibleGraphic, GraphicState.stateUnVisibleGraphic.value());
        constants.put(stateVisibleGraphic,GraphicState.stateVisibleGraphic.value());

        for (Map.Entry entry : constants.entrySet()) {
            if (entry.getValue().equals(value)) {
                GraphicState graphicState = new GraphicState(value){};
                return graphicState;
            }
        }
        return null;
    }
}
