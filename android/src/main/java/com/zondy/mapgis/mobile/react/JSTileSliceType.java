package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.zondy.mapgis.core.map.TileSliceType;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nullable;

/**
 * 瓦片切片类型Native功能组件
 * Created by xiaoying on 2019/9/3.
 */
public class JSTileSliceType extends ReactContextBaseJavaModule {
    private static final String REACT_CLASS = "JSTileSliceType";
    private static final String SLICE_WMTS= "SliceWMTS";  // 瓦片大小
    private static final String SLICE_TMS = "SliceTMS";   // 任意大小

    public JSTileSliceType(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Nullable
    @Override
    public Map<String, Object> getConstants() {
        Map<String, Object> constants = new HashMap<>();
        constants.put(SLICE_WMTS, TileSliceType.SliceWMTS.value());
        constants.put(SLICE_TMS, TileSliceType.SliceTMS.value());

        return constants;
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }
}
