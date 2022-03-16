package com.zondy.mapgis.mobile.react.scene;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.core.geometry.Rect;
import com.zondy.mapgis.core.scene.TerrainLayer3D;
import com.zondy.mapgis.mobile.react.JSRect;

/**
 * @auther LiaoLiang on 20-7-20
 * @content 三维地形类，通过该类可以向场景中添加地形高程图层
 */
public class JSTerrainLayer3D extends JSLayer3D {
    private static final String REACT_CLASS = "JSTerrainLayer3D";

    @NonNull
    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public JSTerrainLayer3D(@NonNull ReactApplicationContext reactContext) {
        super(reactContext);
    }

    /**
     * 构造一个新的 TerrainLayer3D 对象
     * @param promise
     */
    @ReactMethod
    public void createObj(Promise promise) {
        try {
            TerrainLayer3D terrainLayer3D = new TerrainLayer3D();
            String terrainLayer3DId = registerId(terrainLayer3D);

            WritableMap map = Arguments.createMap();
            map.putString("terrainLayer3DId", terrainLayer3DId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     *获取图层范围
     * @param terrainLayer3DId
     * @param rectId 二维范围，Rect类型的id
     * @param promise
     */
    @ReactMethod
    public void getExtent(String terrainLayer3DId, String rectId, Promise promise) {
        try {
            TerrainLayer3D terrainLayer3D = (TerrainLayer3D) getObjById(terrainLayer3DId);
            Rect rect = JSRect.getObjFromList(rectId);
            int result = terrainLayer3D.getExtent(rect); //1-成功；0-失败

            promise.resolve(result);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取图层类型的值
     * @param terrainLayer3DId
     * @param promise
     */
    @ReactMethod
    public void getType(String terrainLayer3DId, Promise promise) {
        try {
            TerrainLayer3D terrainLayer3D = (TerrainLayer3D) getObjById(terrainLayer3DId);
            int typeValue = terrainLayer3D.getType().value();

            promise.resolve(typeValue);
        }catch (Exception e) {
            promise.reject(e);
        }
    }
}
