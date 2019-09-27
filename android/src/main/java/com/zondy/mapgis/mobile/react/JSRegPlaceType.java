package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.zondy.mapgis.core.map.RegPlaceType;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nullable;

/**
 * 面标注分布类型Native功能组件
 * Created by xiaoying on 2019/9/3.
 */
public class JSRegPlaceType extends ReactContextBaseJavaModule {
    private static final String REACT_CLASS = "JSRegPlaceType";
    private static final String HORIZONTAL_PLACE  = "HorizationPlace";  // 水平
    private static final String STRAIGHT_PLACE = "StraightPlace";  // 笔直
    private static final String CURVED_PLACE = "CurvedPlace";  // 弯曲
    private static final String BOUNDRAY_PLACE = "BoundrayPlace";  // 底部边线
    private static final String OUTSIDE_PLACE = "OutsidePlace";  // 区域外面

    public JSRegPlaceType(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Nullable
    @Override
    public Map<String, Object> getConstants() {
        Map<String, Object> constants = new HashMap<>();
        constants.put(HORIZONTAL_PLACE, RegPlaceType.HorizationPlace.value());
        constants.put(STRAIGHT_PLACE, RegPlaceType.StraightPlace.value());
        constants.put(CURVED_PLACE, RegPlaceType.CurvedPlace.value());
        constants.put(BOUNDRAY_PLACE, RegPlaceType.BoundrayPlace.value());
        constants.put(OUTSIDE_PLACE, RegPlaceType.OutsidePlace.value());

        return constants;
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }
}
