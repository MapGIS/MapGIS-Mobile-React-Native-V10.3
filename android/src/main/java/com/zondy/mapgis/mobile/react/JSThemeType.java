package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.zondy.mapgis.core.map.ThemeType;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nullable;

/**
 * 专题图类型Native功能组件
 * Created by xiaoying on 2019/9/3.
 */
public class JSThemeType extends ReactContextBaseJavaModule {
    private static final String REACT_CLASS = "JSThemeType";
    private static final String UNKNOWN = "Unknown";             // 未知类型
    private static final String SIMPLE_THEME = "SimpleTheme";         // 简单专题图
    private static final String UNIQUE_THEME = "UniqueTheme";         //  唯一值专题图
    private static final String RANGE_THEME = "RangeTheme";          // 范围专题图
    private static final String MULTIEXP_CLASS_THEME = "MultiExpClassTheme";  // 多表达式分段专题图
    private static final String SIMPLE_LABEL = "SimpleLabel";         // 简单标注

    public JSThemeType(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Nullable
    @Override
    public Map<String, Object> getConstants() {
        Map<String, Object> constants = new HashMap<>();
        constants.put(UNKNOWN, ThemeType.Unknown.value());
        constants.put(SIMPLE_THEME, ThemeType.SimpleTheme.value());
        constants.put(UNIQUE_THEME, ThemeType.UniqueTheme.value());
        constants.put(RANGE_THEME, ThemeType.RangeTheme.value());
        constants.put(MULTIEXP_CLASS_THEME, ThemeType.MultiExpClassTheme.value());
        constants.put(SIMPLE_LABEL, ThemeType.SimpleLabel.value());

        return constants;
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }
}
