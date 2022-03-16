package com.zondy.mapgis.mobile.react.scene;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.zondy.mapgis.core.scene.Layer3DType;

import java.util.HashMap;
import java.util.Map;

/**
 * @auther LiaoLiang on 20-7-7
 * @content 三维图层类型
 */
public class JSLayer3DType extends ReactContextBaseJavaModule {
    private static final String REACT_CLASS = "JSLayer3DType";

    private static final String Cache = "Cache"; //缓存图层
    private static final String Cloud = "Cloud"; //云层图层
    private static final String Group = "Group"; //三维组图层
    private static final String Label = "Label"; //标注图层
    private static final String MapRef = "MapRef"; //二维地图图层
    private static final String Model = "Model"; //模型图层
    private static final String None = "None"; //未知类型
    private static final String Panorama = "Panorama"; //三维街景图层
    private static final String Server = "Server"; //三维服务图层
    private static final String Terrain = "Terrain"; //地形图层
    private static final String Vector = "Vector"; //矢量图层

    public JSLayer3DType(@NonNull ReactApplicationContext reactContext) {
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
        constants.put(Cache, Layer3DType.Cache.value());
        constants.put(Cloud, Layer3DType.Cloud.value());
        constants.put(Group, Layer3DType.Group.value());
        constants.put(Label, Layer3DType.Label.value());
        constants.put(MapRef, Layer3DType.MapRef.value());
        constants.put(Model, Layer3DType.Model.value());
        constants.put(None, Layer3DType.None.value());
        constants.put(Panorama, Layer3DType.Panorama.value());
        constants.put(Server, Layer3DType.Server.value());
        constants.put(Terrain, Layer3DType.Terrain.value());
        constants.put(Vector, Layer3DType.Vector.value());
        return constants;
    }
}
