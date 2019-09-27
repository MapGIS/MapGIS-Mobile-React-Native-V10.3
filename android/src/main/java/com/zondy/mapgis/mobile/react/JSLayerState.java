package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.zondy.mapgis.core.map.LayerState;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nullable;

/**
 * 图层状态对象Native功能组件
 * Created by xiaoying on 2019/9/2.
 */
public class JSLayerState extends ReactContextBaseJavaModule {
    private static final String REACT_CLASS = "JSLayerState";
    private static final String UNVISIBLE = "UnVisible";  // 不可见
    private static final String VISIBLE = "Visible";      // 可见
    private static final String EDITABLE = "Editable";    // 可编辑
    private static final String ACTIVE = "Active";        // 当前编辑

    public JSLayerState(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Nullable
    @Override
    public Map<String, Object> getConstants() {
        Map<String, Object> constants = new HashMap<>();
        constants.put(UNVISIBLE, LayerState.UnVisible.value());
        constants.put(VISIBLE, LayerState.Visible.value());
        constants.put(EDITABLE, LayerState.Editable.value());
        constants.put(ACTIVE, LayerState.Active.value());
        return constants;
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }
}
