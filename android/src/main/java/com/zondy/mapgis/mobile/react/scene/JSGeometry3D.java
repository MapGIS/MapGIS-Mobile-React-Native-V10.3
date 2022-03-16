package com.zondy.mapgis.mobile.react.scene;

import android.util.Log;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.core.geometry.Geometry3D;
import com.zondy.mapgis.core.geometry.Rect3D;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @auther LiaoLiang on 20-8-4
 * @content
 */
public class JSGeometry3D extends ReactContextBaseJavaModule {
    private static final String REACT_CLASS = "JSGeometry3D";
    private static String Tag = "JSGeometry3D";
    private static Map<String, Geometry3D> geometry3DList = new HashMap<>();

    @NonNull
    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public JSGeometry3D(@NonNull ReactApplicationContext reactContext) {
        super(reactContext);
    }

    /**
     * 在native层注册一个Geometry3D的id,并返回该id供JS层调用。
     * 注册前先判断该Geometry3D是否已经存在，如果存在，返回已经存在的ID，如果不存在，创建新的ID以返回。
     * @param geometry3D
     * @return
     */
    public static String registerId(Geometry3D geometry3D) {
        for (Map.Entry entry : geometry3DList.entrySet()) {
            if (geometry3D.equals(entry.getValue())) {
                return (String) entry.getKey();
            }
        }
        String id = UUID.randomUUID().toString().substring(24);
        geometry3DList.put(id,geometry3D);
        Log.i(Tag,"id:"+id);
        return id;
    }

    /**
     * 根据id获取Geometry3D实例
     * @param id
     * @return
     */
    public static Geometry3D getObjById(String id) {
        return geometry3DList.get(id);
    }

    /**
     * 构造一个新的Geometry3D对象
     * @param promise
     */
    @ReactMethod
    public void createObj(Promise promise) {
        try {
            Geometry3D geometry3D = new Geometry3D();
            String geometry3DId = registerId(geometry3D);

            WritableMap map = Arguments.createMap();
            map.putString("geometry3DId", geometry3DId);
            promise.resolve(map);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 计算外包围盒
     * @param geometry3DId
     * @param promise
     */
    @ReactMethod
    public void calRect3D(String geometry3DId, Promise promise) {
        try {
            Geometry3D geometry3D = getObjById(geometry3DId);
            Rect3D rect3D = geometry3D.calRect3D();
            String rect3DId = JSRect3D.registerId(rect3D);

            promise.resolve(rect3DId);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取几何对象的类型的值
     * @param geometry3DId
     * @param promise
     */
    @ReactMethod
    public void getType(String geometry3DId, Promise promise) {
        try {
            Geometry3D geometry3D = getObjById(geometry3DId);
            int typeValue = geometry3D.getType().value();

            promise.resolve(typeValue);
        }catch (Exception e) {
            promise.reject(e);
        }
    }
}
