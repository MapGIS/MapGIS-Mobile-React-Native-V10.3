package com.zondy.mapgis.mobile.react.scene;

import android.util.Log;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.core.featureservice.Feature3D;
import com.zondy.mapgis.core.geometry.Geometry3D;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @auther LiaoLiang on 20-8-4
 * @content
 */
public class JSFeature3D extends ReactContextBaseJavaModule {
    private static final String REACT_CLASS = "JSFeature3D";
    private static String Tag = "JSFeature3D";
    private static Map<String, Feature3D> feature3DList = new HashMap<>();

    @NonNull
    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public JSFeature3D(@NonNull ReactApplicationContext reactContext) {
        super(reactContext);
    }

    /**
     * 在native层注册一个Feature3D的id,并返回该id供JS层调用。
     * 注册前先判断该Feature3D是否已经存在，如果存在，返回已经存在的ID，如果不存在，创建新的ID以返回。
     * @param feature3D
     * @return
     */
    public static String registerId(Feature3D feature3D) {
        for (Map.Entry entry : feature3DList.entrySet()) {
            if (feature3D.equals(entry.getValue())) {
                return (String) entry.getKey();
            }
        }
        String id = UUID.randomUUID().toString().substring(24);
        feature3DList.put(id,feature3D);
        Log.i(Tag,"id:"+id);
        return id;
    }

    /**
     * 根据id获取Feature3D实例
     * @param id
     * @return
     */
    public static Feature3D getObjById(String id) {
        return feature3DList.get(id);
    }

    /**
     * 构造一个新的Feature3D对象
     * @param promise
     */
    @ReactMethod
    public void createObj(String handle,Promise promise) {
        try {
            Feature3D feature3D = new Feature3D(Long.parseLong(handle));
            String feature3DId = registerId(feature3D);

            WritableMap map = Arguments.createMap();
            map.putString("feature3DId", feature3DId);
            promise.resolve(map);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取几何数据
     * @param feature3DId
     * @param promise
     */
    @ReactMethod
    public void getGeometry(String feature3DId,Promise promise) {
        try {
            Feature3D feature3D = getObjById(feature3DId);
            Geometry3D geometry3D = feature3D.getGeometry();
            String geometry3DId = JSGeometry3D.registerId(geometry3D);

            promise.resolve(geometry3DId);
        }catch (Exception e){
            promise.reject(e);
        }
    }
}
