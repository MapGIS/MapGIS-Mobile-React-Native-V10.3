package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.zondy.mapgis.core.map.VectorLayerType;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nullable;

/**
 * 矢量图层类型Native功能组件
 * Created by xiaoying on 2019/9/4.
 */
public class JSVectorLayerType extends ReactContextBaseJavaModule {
    private static final String REACT_CLASS = "JSVectorLayerType";
    private static final String UNKNOWN_LAYER = "UnknownLayer";      // 未知类型
    private static final String SFCLS_LAYER = "SFclsLayer";        // 简单要素类图层
    private static final String ANNOTATION_LAYER = "AnnotationLayer";   // 注记类要素类图层

    public JSVectorLayerType(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Nullable
    @Override
    public Map<String, Object> getConstants() {
        Map<String, Object> constants = new HashMap<>();
        constants.put(UNKNOWN_LAYER, VectorLayerType.UnknownLayer.value());
        constants.put(SFCLS_LAYER, VectorLayerType.SFclsLayer.value());
        constants.put(ANNOTATION_LAYER, VectorLayerType.AnnotationLayer.value());

        return constants;
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }
}
