package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.zondy.mapgis.core.map.PointPlaceType;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nullable;

/**
 * 点标注分布类型Native功能组件
 *
 * Created by xiaoying on 2019/9/3.
 */
public class JSPointPlaceType extends ReactContextBaseJavaModule {
    private static final String REACT_CLASS = "JSPointPlaceType";
    private static final String EIGHT_LOCATION_PLACE = "EightLocationPlace";      // 八方位
    private static final String ANY_LOCATION_PLACE = "AnyLocationPlace";        // 任意角度
    private static final String ONPOINT_SYMBOL_PLACE = "OnPointSymbolPlace";      // 压点

    public JSPointPlaceType(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Nullable
    @Override
    public Map<String, Object> getConstants() {
        Map<String, Object> constants = new HashMap<>();
        constants.put(EIGHT_LOCATION_PLACE, PointPlaceType.EightLocationPlace.value());
        constants.put(ANY_LOCATION_PLACE, PointPlaceType.AnyLocationPlace.value());
        constants.put(ONPOINT_SYMBOL_PLACE, PointPlaceType.OnPointSymbolPlace.value());

        return constants;
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }
}
