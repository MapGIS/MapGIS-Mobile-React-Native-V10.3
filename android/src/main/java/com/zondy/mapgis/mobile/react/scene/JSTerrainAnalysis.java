package com.zondy.mapgis.mobile.react.scene;

import android.util.Log;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.core.geometry.GeoVarLine;
import com.zondy.mapgis.core.scene.Scene;
import com.zondy.mapgis.core.spatial.TerrainAnalysis;
import com.zondy.mapgis.mobile.react.JSGeoVarLine;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @auther LiaoLiang on 20-8-19
 * @content 地形分析类,可以实现地形表面距离量算
 */
public class JSTerrainAnalysis extends ReactContextBaseJavaModule {
    private static final String REACT_CLASS = "JSTerrainAnalysis";
    private static String Tag = "JSTerrainAnalysis";
    private static Map<String, TerrainAnalysis> terrainAnalysisList = new HashMap<>();

    @NonNull
    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public JSTerrainAnalysis(@NonNull ReactApplicationContext reactContext) {
        super(reactContext);
    }

    /**
     * 在native层注册一个 TerrainAnalysis 的id,并返回该id供JS层调用。
     * 注册前先判断该 TerrainAnalysis 是否已经存在，如果存在，返回已经存在的ID，如果不存在，创建新的ID以返回。
     * @param terrainAnalysis
     * @return
     */
    public static String registerId(TerrainAnalysis terrainAnalysis) {
        for (Map.Entry entry : terrainAnalysisList.entrySet()) {
            if (terrainAnalysis.equals(entry.getValue())) {
                return (String) entry.getKey();
            }
        }
        String id = UUID.randomUUID().toString().substring(24);
        terrainAnalysisList.put(id,terrainAnalysis);
        Log.i(Tag,"id:"+id);
        return id;
    }

    /**
     * 根据id获取 TerrainAnalysis 实例
     * @param id
     * @return
     */
    public static TerrainAnalysis getObjById(String id) {
        return terrainAnalysisList.get(id);
    }

    /**
     * 构造一个新的 TerrainAnalysis 对象
     * @param promise
     */
    @ReactMethod
    public void createObj(Promise promise) {
        try {
            TerrainAnalysis terrainAnalysis = new TerrainAnalysis();
            String terrainAnalysisId = registerId(terrainAnalysis);

            WritableMap writableMap = Arguments.createMap();
            writableMap.putString("terrainAnalysisId",terrainAnalysisId);
            promise.resolve(writableMap);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 地形表面距离量算
     * @param terrainAnalysisId
     * @param sceneId 三维场景的id
     * @param geoVarLineId 待量算的路线的id
     * @param promise
     */
    @ReactMethod
    public void calculateSurfaceDistance(String terrainAnalysisId, String sceneId, String geoVarLineId, Promise promise) {
        try {
            TerrainAnalysis terrainAnalysis = getObjById(terrainAnalysisId);
            Scene scene = JSScene.getObjById(sceneId);
            GeoVarLine geoVarLine = JSGeoVarLine.getObjFromList(geoVarLineId);
            double surfaceDistance = terrainAnalysis.calculateSurfaceDistance(scene,geoVarLine);

            promise.resolve(surfaceDistance);
        }catch (Exception e) {
            promise.reject(e);
        }
    }
}
