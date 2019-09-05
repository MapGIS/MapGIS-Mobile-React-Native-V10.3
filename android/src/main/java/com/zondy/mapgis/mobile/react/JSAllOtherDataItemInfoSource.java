package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.zondy.mapgis.core.map.AllOtherDataItemInfoSource;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nullable;

public class JSAllOtherDataItemInfoSource extends ReactContextBaseJavaModule {
    private static final String REACT_CLASS = "JSAllOtherDataItemInfoSource";
    private static final String DEFAULT_THEME_INFO = "DefaultThemeInfo";              // 缺省的专题图信息
    private static final String DATAIITEM_INSTRINSIC_INFO = "DataItemIntrinsicInfo";  // 数据项的固有图形信息

    public JSAllOtherDataItemInfoSource(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Nullable
    @Override
    public Map<String, Object> getConstants() {
        Map<String,Object> constants = new HashMap<>();
        constants.put(DEFAULT_THEME_INFO, AllOtherDataItemInfoSource.DefaultThemeInfo.value());
        constants.put(DATAIITEM_INSTRINSIC_INFO,AllOtherDataItemInfoSource.DataItemIntrinsicInfo.value());
        return constants;
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }
}
