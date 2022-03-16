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
import com.zondy.mapgis.core.featureservice.FeatureQuery3D;
import com.zondy.mapgis.core.geometry.Dot3D;
import com.zondy.mapgis.mobile.react.JSDot3D;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @auther LiaoLiang on 20-8-5
 * @content
 */
public class JSQueryBound3D extends ReactContextBaseJavaModule {
    private static final String REACT_CLASS = "JSQueryBound3D";
    private static String Tag = "JSQueryBound3D";
    private static Map<String, FeatureQuery3D.QueryBound3D> queryBound3DList = new HashMap<>();

    @NonNull
    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public JSQueryBound3D(@NonNull ReactApplicationContext reactContext) {
        super(reactContext);
    }

    /**
     * 在native层注册一个QueryBound3D的id,并返回该id供JS层调用。
     * 注册前先判断该QueryBound3D是否已经存在，如果存在，返回已经存在的ID，如果不存在，创建新的ID以返回。
     * @param queryBound3D
     * @return
     */
    public static String registerId(FeatureQuery3D.QueryBound3D queryBound3D) {
        for (Map.Entry entry : queryBound3DList.entrySet()) {
            if (queryBound3D.equals(entry.getValue())) {
                return (String) entry.getKey();
            }
        }
        String id = UUID.randomUUID().toString().substring(24);
        queryBound3DList.put(id,queryBound3D);
        Log.i(Tag,"id:"+id);
        return id;
    }

    /**
     * 根据id获取QueryBound3D实例
     * @param id
     * @return
     */
    public static FeatureQuery3D.QueryBound3D getObjById(String id) {
        return queryBound3DList.get(id);
    }

    /**
     * 构造一个新的QueryBound3D对象
     * @param pointId Dot3D的id
     * @param promise
     */
    @ReactMethod
    public void createObj(String pointId, Promise promise) {
        try {
            Dot3D dot3D = JSDot3D.getObjFromList(pointId);
            FeatureQuery3D.QueryBound3D queryBound3D = new FeatureQuery3D.QueryBound3D(dot3D);
            String queryBound3DId = registerId(queryBound3D);

            WritableMap map = Arguments.createMap();
            map.putString("queryBound3DId", queryBound3DId);
            promise.resolve(map);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取查询范围外包点序列
     * @param queryBound3DId
     * @param promise
     */
    @ReactMethod
    public void getBoundPoints(String queryBound3DId, Promise promise) {
        try {
            FeatureQuery3D.QueryBound3D queryBound3D = getObjById(queryBound3DId);
            Dot3D[] dot3DS = queryBound3D.getBoundPoints();
            WritableArray array = Arguments.createArray();
            for (Dot3D dot3D : dot3DS) {
                String dot3DId = JSDot3D.registerId(dot3D);
                array.pushString(dot3DId);
            }
            promise.resolve(array);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取查询范围类型
     * @param queryBound3DId
     * @param promise
     */
    @ReactMethod
    public void getBoundType(String queryBound3DId, Promise promise) {
        try {
            FeatureQuery3D.QueryBound3D queryBound3D = getObjById(queryBound3DId);
            int boundType = queryBound3D.getBoundType();

            promise.resolve(boundType);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * @param queryBound3DId
     * @param promise
     */
    @ReactMethod
    public void getDotOffDx(String queryBound3DId, Promise promise) {
        try {
            FeatureQuery3D.QueryBound3D queryBound3D = getObjById(queryBound3DId);
            double dotOffDx = queryBound3D.getDotOffDx();

            promise.resolve(dotOffDx);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * @param queryBound3DId
     * @param promise
     */
    @ReactMethod
    public void getDotOffDy(String queryBound3DId, Promise promise) {
        try {
            FeatureQuery3D.QueryBound3D queryBound3D = getObjById(queryBound3DId);
            double dotOffDy = queryBound3D.getDotOffDy();

            promise.resolve(dotOffDy);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * @param queryBound3DId
     * @param promise
     */
    @ReactMethod
    public void getDotOffDz(String queryBound3DId, Promise promise) {
        try {
            FeatureQuery3D.QueryBound3D queryBound3D = getObjById(queryBound3DId);
            double dotOffDz = queryBound3D.getDotOffDz();

            promise.resolve(dotOffDz);
        }catch (Exception e) {
            promise.reject(e);
        }
    }
}
