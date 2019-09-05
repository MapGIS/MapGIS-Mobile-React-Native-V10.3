package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.zondy.mapgis.core.map.LabelType;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nullable;

/**
 * Created by xiaoying on 2019/9/2.
 */
public class JSLabelType extends ReactContextBaseJavaModule {
    private static final String REACT_CLASS = "JSLabelType";
    private static final String SIMPLE_LABEL = "SimpleLabel"; // 简单标注

    public JSLabelType(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Nullable
    @Override
    public Map<String, Object> getConstants() {
        Map<String,Object> constants = new HashMap<>();
        constants.put(SIMPLE_LABEL, LabelType.SimpleLabel.value());
        return constants;
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }
}
