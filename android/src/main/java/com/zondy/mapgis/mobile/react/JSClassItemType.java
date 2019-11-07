package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.zondy.mapgis.core.map.ClassItemType;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nullable;

public class JSClassItemType extends ReactContextBaseJavaModule {
    private static final String REACT_CLASS = "JSClassItemType";
    private static final String UNIQUETYPE = "UniqueType";  // 唯一值
    private static final String RANGETYPE = "RangeType";    // 范围

    public JSClassItemType(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Nullable
    @Override
    public Map<String, Object> getConstants() {
        Map<String,Object> constants = new HashMap<>();
        constants.put(UNIQUETYPE, ClassItemType.UniqueType.value());
        constants.put(RANGETYPE,ClassItemType.RangeType.value());
        return constants;
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }
}
