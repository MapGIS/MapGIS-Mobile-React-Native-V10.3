package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.zondy.mapgis.android.utils.CoordinateType;
import com.zondy.mapgis.core.srs.SRefData;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nullable;

/**
 * 坐标转换类型枚举类的Native功能组件
 * Created by xiaoying on 2019/9/11.
 */
public class JSCoordinateType extends ReactContextBaseJavaModule {
    private static final String REACT_CLASS = "JSCoordinateType";

    public JSCoordinateType(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Nullable
    @Override
    public Map<String, Object> getConstants() {
        Map<String, Object> constants = new HashMap<>();
        constants.put("BAIDU_LngLat", CoordinateType.BAIDU_LngLat.getValue());
        constants.put("GPS_LngLat", CoordinateType.GPS_LngLat.getValue());
        constants.put("AMAP_LngLat", CoordinateType.AMAP_LngLat.getValue());
        constants.put("NAVINFO_LngLat", CoordinateType.NAVINFO_LngLat.getValue());
        constants.put("GCJ02_LngLat", CoordinateType.GCJ02_LngLat.getValue());

        return constants;
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }
}
