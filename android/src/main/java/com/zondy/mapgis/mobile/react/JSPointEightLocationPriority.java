package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.zondy.mapgis.core.map.PointEightLocationPriority;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nullable;

/**
 * 点注记八方位优先级Native功能组件
 *
 * Created by xiaoying on 2019/9/3.
 */
public class JSPointEightLocationPriority extends ReactContextBaseJavaModule {
    private static final String REACT_CLASS = "JSPointEightLocationPriority";
    private static final String EAST = "East";                  // 东
    private static final String NORTH_EAST = "NorthEast";       // 东北
    private static final String WEST = "West";                  // 西
    private static final String NORTH = "North";                // 北
    private static final String SOUTH = "South";                // 南
    private static final String NORTH_WEST = "NorthWest";       // 西北
    private static final String SOUTH_WEST = "SouthWest";       // 西南
    private static final String SOUTH_EAST = "SouthEast";       // 东南

    public JSPointEightLocationPriority(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Nullable
    @Override
    public Map<String, Object> getConstants() {
        Map<String, Object> constants = new HashMap<>();
        constants.put(EAST, PointEightLocationPriority.East.value());
        constants.put(NORTH_EAST, PointEightLocationPriority.NorthEast.value());
        constants.put(WEST, PointEightLocationPriority.West.value());
        constants.put(NORTH, PointEightLocationPriority.North.value());
        constants.put(SOUTH, PointEightLocationPriority.South.value());
        constants.put(NORTH_WEST, PointEightLocationPriority.NorthWest.value());
        constants.put(SOUTH_WEST, PointEightLocationPriority.SouthWest.value());
        constants.put(SOUTH_EAST, PointEightLocationPriority.SouthEast.value());

        return constants;
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }
}
