package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.zondy.mapgis.core.map.LabelGeomType;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nullable;

/**
 * 标注几何类型Native功能组件
 * Created by xiaoying on 2019/9/2.
 */
public class JSLabelGeomType extends ReactContextBaseJavaModule {
    private static final String REACT_CLASS = "JSLabelGeomType";
    private static final String UNKNOWN = "Unknown";         // 未知类型
    private static final String POINT_GEOM = "PointGeom";    // 点类型
    private static final String LINE_GEOM = "LineGeom";      // 线类型
    private static final String REGION_GEOM = "RegionGeom";  // 区类型

    public JSLabelGeomType(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Nullable
    @Override
    public Map<String, Object> getConstants() {
        Map<String,Object> constants = new HashMap<>();
        constants.put(UNKNOWN, LabelGeomType.Unknown.value());
        constants.put(POINT_GEOM, LabelGeomType.PointGeom.value());
        constants.put(LINE_GEOM, LabelGeomType.LineGeom.value());
        constants.put(REGION_GEOM, LabelGeomType.RegionGeom.value());
        return constants;
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }
}
