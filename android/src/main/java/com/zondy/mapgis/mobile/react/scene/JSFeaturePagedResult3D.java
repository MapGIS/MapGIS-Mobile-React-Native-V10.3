package com.zondy.mapgis.mobile.react.scene;

import android.util.Log;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.core.featureservice.Feature;
import com.zondy.mapgis.core.featureservice.FeaturePagedResult3D;
import com.zondy.mapgis.mobile.react.JSFeature;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @auther LiaoLiang on 20-8-4
 * @content
 */
public class JSFeaturePagedResult3D extends ReactContextBaseJavaModule {
    private static final String REACT_CLASS = "JSFeaturePagedResult3D";
    private static String Tag = "JSFeaturePagedResult3D";
    private static Map<String, FeaturePagedResult3D> featurePagedResult3DList = new HashMap<>();
    @NonNull
    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public JSFeaturePagedResult3D(@NonNull ReactApplicationContext reactContext) {
        super(reactContext);
    }

    /**
     * 在native层注册一个FeaturePagedResult3D的id,并返回该id供JS层调用。
     * 注册前先判断该FeaturePagedResult3D是否已经存在，如果存在，返回已经存在的ID，如果不存在，创建新的ID以返回。
     * @param featurePagedResult3D
     * @return
     */
    public static String registerId(FeaturePagedResult3D featurePagedResult3D) {
        for (Map.Entry entry : featurePagedResult3DList.entrySet()) {
            if (featurePagedResult3D.equals(entry.getValue())) {
                return (String) entry.getKey();
            }
        }
        String id = UUID.randomUUID().toString().substring(24);
        featurePagedResult3DList.put(id,featurePagedResult3D);
        Log.i(Tag,"id:"+id);
        return id;
    }

    /**
     * 根据id获取FeaturePagedResult3D实例
     * @param id
     * @return
     */
    public static FeaturePagedResult3D getObjById(String id) {
        return featurePagedResult3DList.get(id);
    }

    /**
     * 构造一个新的FeaturePagedResult3D对象
     * @param promise
     */
    @ReactMethod
    public void createObj(Promise promise) {
        try {
            FeaturePagedResult3D featurePagedResult3D = new FeaturePagedResult3D();
            String featurePagedResult3DId = registerId(featurePagedResult3D);

            WritableMap map = Arguments.createMap();
            map.putString("featurePagedResult3DId", featurePagedResult3DId);
            promise.resolve(map);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 返回页码对应的结果，页码从1开始计数
     * @param featurePagedResult3DId
     * @param pageNumber 页码
     * @param promise
     */
    @ReactMethod
    public void getPage(String featurePagedResult3DId, int pageNumber, Promise promise) {
        try {
            FeaturePagedResult3D featurePagedResult3D = getObjById(featurePagedResult3DId);
            List<Feature> features = featurePagedResult3D.getPage(pageNumber);
            WritableArray array = Arguments.createArray();
            for (Feature feature : features) {
                String featureId = JSFeature.registerId(feature);
                array.pushString(featureId);
            }

            promise.resolve(array);
        }catch (Exception e) {
            promise.reject(e);
        }
    }
}
