package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.zondy.mapgis.core.map.MapServerBrowseType;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nullable;

/**
 * 地图服务类型Native功能组件
 *
 * Created by xiaoying on 2019/9/2.
 */
public class JSMapServerBrowseType extends ReactContextBaseJavaModule {
    private static final String REACT_CLASS = "JSMapServerBrowseType";
    private static final String MAPTILE = "MapTile";               //  瓦片大小
    private static final String MAPVECTOR = "MapVector";           //  任意大小
    private static final String MAPVECTORTILE = "MapVectorTile";   //  矢量瓦片大小

    public JSMapServerBrowseType(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Nullable
    @Override
    public Map<String, Object> getConstants() {
        Map<String, Object> constants = new HashMap<>();
        constants.put(MAPTILE, MapServerBrowseType.MapTile.value());
        constants.put(MAPVECTOR, MapServerBrowseType.MapVector.value());
        constants.put(MAPVECTORTILE, MapServerBrowseType.MapVectorTile.value());

        return constants;
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }
}
