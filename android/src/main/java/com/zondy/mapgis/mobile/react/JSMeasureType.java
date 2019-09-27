package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.zondy.mapgis.android.tool.sketcheditor.MeasureType;
import com.zondy.mapgis.core.object.Enumeration;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nullable;

/**
 * 计算类型Native 功能组件
 * Created by xiaoying on 2019/9/10.
 */
public class JSMeasureType extends ReactContextBaseJavaModule {
    private static final String REACT_CLASS = "JSMeasureType";

    public JSMeasureType(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Nullable
    @Override
    public Map<String, Object> getConstants() {
        Map<String, Object> constants = new HashMap<>();

        String[] names = Enumeration.getNames(MeasureType.class);
        for (int i = 0; i < names.length; i++) {
            int value = Enumeration.getValueByName(MeasureType.class, names[i]);
            constants.put(names[i], value);
        }

        return constants;
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }
}
