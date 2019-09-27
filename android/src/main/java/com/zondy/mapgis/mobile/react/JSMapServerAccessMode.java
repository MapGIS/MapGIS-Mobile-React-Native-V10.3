package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.zondy.mapgis.core.map.MapServerAccessMode;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nullable;

/**
 * 地图服务访问模式Native功能组件
 * Created by xiaoying on 2019/9/2.
 */
public class JSMapServerAccessMode extends ReactContextBaseJavaModule {
    private static final String REACT_CLASS = "JSMapServerAccessMode";
    private static final String SERVER_AND_CACHE = "ServerAndCache";   // 服务器和缓存
    private static final String SERVER_ONLY = "ServerOnly";            // 只从服务器访问
    private static final String CACHE_ONLY = "CacheOnly";              // 只从缓存访问
    private static final String UNKNOWN = "Unknown";                   // 未知模式

    public JSMapServerAccessMode(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Nullable
    @Override
    public Map<String, Object> getConstants() {
        Map<String,Object> constants = new HashMap<>();
        constants.put(SERVER_AND_CACHE, MapServerAccessMode.ServerAndCache.value());
        constants.put(SERVER_ONLY, MapServerAccessMode.ServerOnly.value());
        constants.put(CACHE_ONLY, MapServerAccessMode.CacheOnly.value());
        constants.put(UNKNOWN, MapServerAccessMode.Unknown.value());
        return constants;
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }
}
