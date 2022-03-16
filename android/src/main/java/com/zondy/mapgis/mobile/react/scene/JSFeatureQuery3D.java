package com.zondy.mapgis.mobile.react.scene;

import android.util.Log;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.core.featureservice.FeaturePagedResult3D;
import com.zondy.mapgis.core.featureservice.FeatureQuery3D;
import com.zondy.mapgis.mobile.react.JSQueryBound;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @auther LiaoLiang on 20-8-4
 * @content
 */
public class JSFeatureQuery3D extends ReactContextBaseJavaModule {
    private static final String REACT_CLASS = "JSFeatureQuery3D";
    private static String Tag = "JSFeatureQuery3D";
    private static Map<String, FeatureQuery3D> featureQuery3DList = new HashMap<>();

    @NonNull
    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public JSFeatureQuery3D(@NonNull ReactApplicationContext reactContext) {
        super(reactContext);
    }

    /**
     * 在native层注册一个FeatureQuery3D的id,并返回该id供JS层调用。
     * 注册前先判断该FeatureQuery3D是否已经存在，如果存在，返回已经存在的ID，如果不存在，创建新的ID以返回。
     * @param featureQuery3D
     * @return
     */
    public static String registerId(FeatureQuery3D featureQuery3D) {
        for (Map.Entry entry : featureQuery3DList.entrySet()) {
            if (featureQuery3D.equals(entry.getValue())) {
                return (String) entry.getKey();
            }
        }
        String id = UUID.randomUUID().toString().substring(24);
        featureQuery3DList.put(id,featureQuery3D);
        Log.i(Tag,"id:"+id);
        return id;
    }

    /**
     * 根据id获取FeatureQuery3D实例
     * @param id
     * @return
     */
    public static FeatureQuery3D getObjById(String id) {
        return featureQuery3DList.get(id);
    }

    /**
     * 构造一个新的FeatureQuery3D对象
     * @param strIGServerBaseURL
     * @param strDataURL
     * @param promise
     */
    @ReactMethod
    public void createObj(String strIGServerBaseURL,String strDataURL,Promise promise) {
        try {
            FeatureQuery3D featureQuery3D = new FeatureQuery3D(strIGServerBaseURL,strDataURL);
            String featureQuery3DId = registerId(featureQuery3D);

            WritableMap map = Arguments.createMap();
            map.putString("featureQuery3DId", featureQuery3DId);
            promise.resolve(map);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 查询
     * @param featureQuery3DId
     * @param promise
     */
    @ReactMethod
    public void query(String featureQuery3DId,Promise promise) {
        try {
            FeatureQuery3D featureQuery3D = getObjById(featureQuery3DId);
            FeaturePagedResult3D featurePagedResult3D = featureQuery3D.query();
            String featurePagedResult3DId = JSFeaturePagedResult3D.registerId(featurePagedResult3D);

            promise.resolve(featurePagedResult3DId);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取查询范围
     * @param featureQuery3DId
     * @param promise
     */
    @ReactMethod
    public void getQueryBound3D(String featureQuery3DId,Promise promise) {
        try {
            FeatureQuery3D featureQuery3D = getObjById(featureQuery3DId);
            FeatureQuery3D.QueryBound3D queryBound3D = featureQuery3D.getQueryBound3D();
            String queryBound3DId = JSQueryBound3D.registerId(queryBound3D);

            promise.resolve(queryBound3DId);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 设置查询范围
     * @param featureQuery3DId
     * @param queryBoundId
     * @param promise
     */
    @ReactMethod
    public void setQueryBound3D(String featureQuery3DId,String queryBoundId,Promise promise) {
        try {
            FeatureQuery3D featureQuery3D = getObjById(featureQuery3DId);
            FeatureQuery3D.QueryBound3D queryBound3D = JSQueryBound3D.getObjById(queryBoundId);
            FeatureQuery3D resultFeatureQuery3D = featureQuery3D.setQueryBound3D(queryBound3D);
            String resultFeatureQuery3DId = registerId(resultFeatureQuery3D);

            promise.resolve(resultFeatureQuery3DId);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

}
