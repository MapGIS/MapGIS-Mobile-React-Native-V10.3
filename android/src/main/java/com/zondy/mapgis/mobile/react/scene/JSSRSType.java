package com.zondy.mapgis.mobile.react.scene;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.zondy.mapgis.core.scene.SRSType;

import java.util.HashMap;
import java.util.Map;

/**
 * @auther LiaoLiang on 20-6-29
 * @content 空间参考系类型
 */
public class JSSRSType extends ReactContextBaseJavaModule {
    private static final String REACT_CLASS = "JSSRSType";

    private static final String SRS_Type_Global = "SRS_Type_Global"; //全球,WGS84,经纬度
    private static final String SRS_Type_Global_MERCATOR = "SRS_Type_Global_MERCATOR"; //全球,WGS84,WEB墨卡托

    public JSSRSType(@NonNull ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @NonNull
    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Nullable
    @Override
    public Map<String, Object> getConstants() {
        Map<String,Object> constants = new HashMap<>();
        constants.put(SRS_Type_Global, SRSType.SRS_Type_Global);
        constants.put(SRS_Type_Global_MERCATOR,SRSType.SRS_Type_Global_MERCATOR);

        return constants;
    }
}
