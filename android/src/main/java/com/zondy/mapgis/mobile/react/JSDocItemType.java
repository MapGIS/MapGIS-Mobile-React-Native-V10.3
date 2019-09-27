package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.zondy.mapgis.core.map.DocItemType;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nullable;

/**
 * 文档项类型
 */
public class JSDocItemType extends ReactContextBaseJavaModule {
    private static final String REACT_CLASS = "JSDocItemType";
    private static final String UNKNOWN = "Unknown";            // 未知类型
    private static final String LAYER = "Layer";                // 2D图层
    private static final String MAP = "Map";                    // 地图
    private static final String DOCUMENT = "Document";          // 文档
    private static final String SCENE = "Scene";                // 场景
    private static final String LAYER3D = "Layer3D";            // 3D图层
    private static final String GRAPHICSDATA = "GraphicsData";  //制图数据

    public JSDocItemType(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Nullable
    @Override
    public Map<String, Object> getConstants() {
        Map<String,Object> constants = new HashMap<>();
        constants.put(UNKNOWN, DocItemType.Unknown.value());
        constants.put(LAYER, DocItemType.Layer.value());
        constants.put(MAP, DocItemType.Map.value());
        constants.put(DOCUMENT, DocItemType.Document.value());
        constants.put(SCENE, DocItemType.Scene.value());
        constants.put(LAYER3D, DocItemType.Layer3D.value());
        constants.put(GRAPHICSDATA, DocItemType.GraphicsData.value());

        return constants;
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }
}
