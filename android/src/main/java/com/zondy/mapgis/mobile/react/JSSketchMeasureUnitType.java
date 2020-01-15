package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.zondy.mapgis.core.object.Enumeration;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nullable;

/**
 * Created by xiaoying on 2020/1/13.
 */
public class JSSketchMeasureUnitType extends ReactContextBaseJavaModule {
    private static final String REACT_CLASS = "JSSketchMeasureUnitType";

    public JSSketchMeasureUnitType(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Nullable
    @Override
    public Map<String, Object> getConstants() {
        Map<String, Object> constants = new HashMap<>();
        // 距离单位
        constants.put("MM", "毫米*1000");
        constants.put("CM", "厘米*100");
        constants.put("DM", "分米*10");
        constants.put("M", "米*1");
        constants.put("KM", "千米*0.001");
        constants.put("GongLi", "公里*0.001");
        constants.put("Li", "里*0.002");
        constants.put("Sea_Mile", "海里*0.00053996");
        constants.put("Land_Mile", "英里*0.00062137");
        // 面积单位
        constants.put("Sqrt_MM", "平方毫米*1000000");
        constants.put("Sqrt_CM", "平方厘米*10000");
        constants.put("Sqrt_DM", "平方分米*100");
        constants.put("Sqrt_M", "平方米*1");
        constants.put("Sqrt_KM", "平方千米*0.000001");
        constants.put("Sqrt_GongLi", "平方公里*0.000001");
        constants.put("GongQing", "公顷*0.0001");
        constants.put("Mu", "亩*0.0015");
        constants.put("GongMu", "公亩*0.01");
        return constants;
    }


}
