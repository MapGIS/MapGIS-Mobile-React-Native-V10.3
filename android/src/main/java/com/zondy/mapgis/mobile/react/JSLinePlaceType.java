package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.zondy.mapgis.core.map.LinePlaceType;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nullable;

/**
 *  线标注分布类型对象Native功能组件
 * Created by xiaoying on 2019/9/2.
 */
public class JSLinePlaceType extends ReactContextBaseJavaModule {
    private static final String REACT_CLASS = "JSLinePlaceType";
    private static final String HORIZATION_PLACE = "HorizationPlace";         // 水平
    private static final String PERPENDICULAR_PLACE = "PerpendicularPlace";   // 垂直
    private static final String STRAIGHT_PLACE = "StraightPlace";             // 笔直
    private static final String CURVED_PLACE = "CurvedPlace";                 // 弯曲

    public JSLinePlaceType(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Nullable
    @Override
    public Map<String, Object> getConstants() {
        Map<String,Object> constants = new HashMap<>();
        constants.put(HORIZATION_PLACE, LinePlaceType.HorizationPlace.value());
        constants.put(PERPENDICULAR_PLACE, LinePlaceType.PerpendicularPlace.value());
        constants.put(STRAIGHT_PLACE, LinePlaceType.StraightPlace.value());
        constants.put(CURVED_PLACE, LinePlaceType.CurvedPlace.value());
        return constants;
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }
}
