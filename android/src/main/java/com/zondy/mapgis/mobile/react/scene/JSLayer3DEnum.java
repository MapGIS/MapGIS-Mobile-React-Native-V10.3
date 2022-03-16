package com.zondy.mapgis.mobile.react.scene;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.core.scene.Layer3D;
import com.zondy.mapgis.core.scene.Layer3DEnum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @auther LiaoLiang on 20-7-2
 * @content 三维组图层的图层枚举
 */
public class JSLayer3DEnum extends ReactContextBaseJavaModule {
    private static final String REACT_CLASS = "JSLayer3DEnum";
    private static String Tag = "JSLayer3DEnum";
    private static Map<String, Layer3DEnum> mLayer3DEnumList = new HashMap<>();

    public JSLayer3DEnum(@NonNull ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @NonNull
    @Override
    public String getName() {
        return REACT_CLASS;
    }

    /**
     * 在native层注册一个Layer3DEnum的id,并返回该id供JS层调用。
     * 注册前先判断该Layer3DEnum是否已经存在，如果存在，返回已经存在的ID，如果不存在，创建新的ID以返回。
     * @param layer3DEnum
     * @return
     */
    public static String registerId(Layer3DEnum layer3DEnum) {
        for (Map.Entry entry : mLayer3DEnumList.entrySet()) {
            if (layer3DEnum.equals(entry.getValue())) {
                return (String) entry.getKey();
            }
        }
        String id = UUID.randomUUID().toString().substring(24);
        mLayer3DEnumList.put(id,layer3DEnum);
        return id;
    }

    /**
     * 根据id获取Layer3DEnum实例
     * @param layer3DEnumId
     * @return
     */
    public static Layer3DEnum getObjById(String layer3DEnumId) {
        return mLayer3DEnumList.get(layer3DEnumId);
    }

    /**
     * 构造一个新的Layer3DEnum对象
     * @param promise
     */
    @ReactMethod
    public void createObj(Promise promise){
        try {
            Layer3DEnum layer3DEnum = new Layer3DEnum();
            String layer3DEnumId = registerId(layer3DEnum);

            WritableMap map = Arguments.createMap();
            map.putString("layer3DEnumId",layer3DEnumId);
            promise.resolve(map);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    /**
     * 初始化
     * @param layer3DEnumId
     * @param layer3DsArray
     * @param promise
     */
    @ReactMethod
    public void init(String layer3DEnumId, ReadableArray layer3DsArray, Promise promise) {
        try {
            Layer3DEnum layer3DEnum = getObjById(layer3DEnumId);
            List<Layer3D> layer3DS = new ArrayList<>();
            if (layer3DEnum != null) {
                for (int i = 0; i < layer3DsArray.size(); i++) {
                    ReadableMap readableMap = layer3DsArray.getMap(i);
                    String keyStr = readableMap.getString("_MGLayer3DId");
                    layer3DS.add(JSLayer3D.getObjById(keyStr));
                }
            }
            boolean result = layer3DEnum.init(layer3DS);

            promise.resolve(result);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 光标置前
     * @param layer3DEnumId
     * @param promise
     */
    @ReactMethod
    public void moveToFirst(String layer3DEnumId, Promise promise) {
        try {
            Layer3DEnum layer3DEnum = getObjById(layer3DEnumId);
            boolean result = layer3DEnum.moveToFirst();

            promise.resolve(result);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 光标置后
     * @param layer3DEnumId
     * @param promise
     */
    @ReactMethod
    public void moveToLast(String layer3DEnumId, Promise promise) {
        try {
            Layer3DEnum layer3DEnum = getObjById(layer3DEnumId);
            boolean result = layer3DEnum.moveToLast();

            promise.resolve(result);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取下一个图层
     * @param layer3DEnumId
     * @param promise
     */
    @ReactMethod
    public void next(String layer3DEnumId, Promise promise) {
        try {
            Layer3DEnum layer3DEnum = getObjById(layer3DEnumId);
            Layer3D layer3D = layer3DEnum.next();
            String layer3DId = null;
            if (layer3D != null) {
                layer3DId = JSLayer3D.registerId(layer3D);
            }

            WritableMap writableMap = Arguments.createMap();
            writableMap.putString("layer3DId",layer3DId);
            promise.resolve(writableMap);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取上一个图层
     * @param layer3DEnumId
     * @param promise
     */
    @ReactMethod
    public void prev(String layer3DEnumId, Promise promise) {
        try {
            Layer3DEnum layer3DEnum = getObjById(layer3DEnumId);
            Layer3D layer3D = layer3DEnum.prev();
            String layer3DId = null;
            if (layer3D != null) {
                layer3DId = JSLayer3D.registerId(layer3D);
            }

            WritableMap writableMap = Arguments.createMap();
            writableMap.putString("layer3DId",layer3DId);
            promise.resolve(writableMap);
        }catch (Exception e) {
            promise.reject(e);
        }
    }
}
