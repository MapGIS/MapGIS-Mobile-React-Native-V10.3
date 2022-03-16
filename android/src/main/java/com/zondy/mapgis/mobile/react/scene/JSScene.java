package com.zondy.mapgis.mobile.react.scene;

import android.util.Log;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.core.map.DocItemType;
import com.zondy.mapgis.core.scene.Layer3D;
import com.zondy.mapgis.core.scene.Layer3DEnum;
import com.zondy.mapgis.core.scene.Scene;
import com.zondy.mapgis.jni.core.scene.NativeScene;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @auther LiaoLiang on 20-6-24
 * @content 三维场景类，用于管理场景中的图层
 */
public class JSScene extends ReactContextBaseJavaModule {
    private static final String REACT_CLASS = "JSScene";
    private static String Tag = "JSScene";
    private static Map<String, Scene> sceneList = new HashMap<>();

    @NonNull
    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public JSScene(@NonNull ReactApplicationContext reactContext) {
        super(reactContext);
    }

    /**
     * 在native层注册一个Scene的id,并返回该id供JS层调用。
     * 注册前先判断该Scene是否已经存在，如果存在，返回已经存在的ID，如果不存在，创建新的ID以返回。
     * @param scene
     * @return
     */
    public static String registerId(Scene scene) {
        for (Map.Entry entry : sceneList.entrySet()) {
            if (scene.equals(entry.getValue())) {
                return (String) entry.getKey();
            }
        }
        String id = UUID.randomUUID().toString().substring(24);
        sceneList.put(id,scene);
        Log.i(Tag,"id:"+id);
        return id;
    }

    /**
     * 根据id获取Scene实例
     * @param id
     * @return
     */
    public static Scene getObjById(String id) {
        return sceneList.get(id);
    }

    /**
     * 构造一个新的Scene对象
     * @param promise
     */
    @ReactMethod
    public void createObj(Promise promise) {
        try {
            Scene scene = new Scene();
            String sceneId = registerId(scene);

            WritableMap map = Arguments.createMap();
            map.putString("sceneId", sceneId);
            promise.resolve(map);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 从场景中清空图层
     * @param sceneId
     * @param promise
     */
    @ReactMethod
    public void clearLayers(String sceneId, Promise promise) {
        try {
            Scene scene = getObjById(sceneId);
            int result = scene.clearLayers(); //成功返回1,失败返回0

            promise.resolve(result);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     *获取场景描述信息
     * @param sceneId
     * @param promise
     */
    @ReactMethod
    public void getDescription(String sceneId, Promise promise) {
        try {
            Scene scene = getObjById(sceneId);
            String description = scene.getDescription();

            promise.resolve(description);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取图层总数
     * @param sceneId
     * @param promise
     */
    @ReactMethod
    public void getLayerCount(String sceneId, Promise promise) {
        try {
            Scene scene = getObjById(sceneId);
            int layerCount = scene.getLayerCount();

            promise.resolve(layerCount);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取场景名称
     * @param sceneId
     * @param promise
     */
    @ReactMethod
    public void getNameOfScene(String sceneId, Promise promise) {
        try {
            Scene scene = getObjById(sceneId);
            String name = scene.getName();

            promise.resolve(name);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取地形的高程偏移
     * @param sceneId
     * @param promise
     */
    @ReactMethod
    public void getVerticalOffset(String sceneId, Promise promise) {
        try {
            Scene scene = getObjById(sceneId);
            Double verticalOffset = scene.getVerticalOffset();

            promise.resolve(verticalOffset);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     *移除三维图层
     * @param sceneId
     * @param fromIndex 从fromIndex开始
     * @param nCount 移除nCount个图层
     * @param promise
     */
    @ReactMethod
    public void removeLayer(String sceneId, int fromIndex, int nCount, Promise promise) {
        try {
            Scene scene = getObjById(sceneId);
            int result = scene.removeLayer(fromIndex,nCount); //成功返回大于0；失败返回0

            promise.resolve(result);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 移除指定索引的三维图层
     * @param sceneId
     * @param layerIndex 移除索引为layerIndex的图层
     * @param promise
     */
    @ReactMethod
    public void removeLayerAt(String sceneId, int layerIndex, Promise promise) {
        try {
            Scene scene = getObjById(sceneId);
            int result = scene.removeLayerAt(layerIndex); //成功返回大于0；失败返回-1

            promise.resolve(result);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 设置场景描述信息
     * @param sceneId
     * @param strDescription
     * @param promise
     */
    @ReactMethod
    public void setDescription(String sceneId, String strDescription, Promise promise) {
        try {
            Scene scene = getObjById(sceneId);
            int result = scene.setDescription(strDescription); //成功返回1，失败返回0

            promise.resolve(result);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 设置场景名称
     * @param sceneId
     * @param strName
     * @param promise
     */
    @ReactMethod
    public void setNameOfScene(String sceneId, String strName, Promise promise) {
        try {
            Scene scene = getObjById(sceneId);
            int result = scene.setName(strName); //成功返回1，失败返回0

            promise.resolve(result);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 设置地形的高程偏移
     * @param sceneId
     * @param dVerticalOff
     * @param promise
     */
    @ReactMethod
    public void setVerticalOffset(String sceneId, Double dVerticalOff, Promise promise) {
        try {
            Scene scene = getObjById(sceneId);
            int result = scene.setVerticalOffset(dVerticalOff);

            promise.resolve(result);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 在场景中添加三维图层
     * @param sceneId
     * @param layer3DId
     * @param promise
     */
    @ReactMethod
    public void addLayer(String sceneId, String layer3DId, Promise promise) {
        try {
            Scene scene = getObjById(sceneId);
            Layer3D layer3D = JSLayer3D.getObjById(layer3DId);
            int result = scene.addLayer(layer3D); //成功返回图层索引（从0开始）；失败返回<0

            promise.resolve(result);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取加载的图层数据类型
     * @param sceneId
     * @param promise
     */
    @ReactMethod
    public void getDocItemType(String sceneId, Promise promise) {
        try {
            Scene scene = getObjById(sceneId);
            DocItemType docItemType = scene.getDocItemType();
            int docItemTypeValue = docItemType.value();

            promise.resolve(docItemTypeValue);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 根据索引获取图层，从0开始
     * @param sceneId
     * @param index 图层索引（大于等于0），其中这里的索引并不是图层的唯一标识，而是图层在当场景的位置索引
     * @param promise
     */
    @ReactMethod
    public void getLayer(String sceneId, int index, Promise promise) {
        try {
            Scene scene = getObjById(sceneId);
            Layer3D layer3D = scene.getLayer(index);
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
     * 图层枚举
     * @param sceneId
     * @param layer3DEnumId
     * @param promise
     */
    @ReactMethod
    public void getLayerEnum(String sceneId, String layer3DEnumId, Promise promise) {
        try {
            Scene scene = getObjById(sceneId);
            Layer3DEnum layer3DEnum = JSLayer3DEnum.getObjById(layer3DEnumId);
            int result = scene.getLayerEnum(layer3DEnum); //1-成功；0-失败

            promise.resolve(result);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取三维图层的图层索引
     * @param sceneId
     * @param layer3DId
     * @param promise
     */
    @ReactMethod
    public void indexOfLayer(String sceneId, String layer3DId, Promise promise) {
        try {
            Scene scene = getObjById(sceneId);
            Layer3D layer3D = JSLayer3D.getObjById(layer3DId);
            int index = scene.indexOfLayer(layer3D); //成功返回图层索引号；失败返回-1

            promise.resolve(index);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 在场景中根据指定索引插入三维图层
     * @param sceneId
     * @param layer3DId 三维图层id
     * @param index 图层索引
     * @param promise
     */
    @ReactMethod
    public void insertLayer(String sceneId, String layer3DId, int index, Promise promise) {
        try {
            Scene scene = getObjById(sceneId);
            Layer3D layer3D = JSLayer3D.getObjById(layer3DId);
            int result = scene.insertLayer(layer3D,index);

            promise.resolve(result);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 从场景中移除三维图层
     * @param sceneId
     * @param layer3DId
     * @param promise
     */
    @ReactMethod
    public void removeLayerById(String sceneId, String layer3DId, Promise promise) {
        try {
            Scene scene = getObjById(sceneId);
            Layer3D layer3D = JSLayer3D.getObjById(layer3DId);
            int result = scene.removeLayer(layer3D); //成功返回1，失败返回0

            promise.resolve(result);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取Layer3D的type的对应值
     * @param layer3DId
     * @param promise
     */
    @ReactMethod
    public void getLayer3DTypeByID(String layer3DId, Promise promise) {
        try {
            Layer3D layer3D = JSLayer3D.getObjById(layer3DId);
            int type = NativeScene.jni_GetLayerType(layer3D.getHandle());

            WritableMap writableMap = Arguments.createMap();
            writableMap.putInt("Layer3DType", type);
            promise.resolve(writableMap);
        }catch (Exception e) {
            promise.reject(e);
        }
    }
}
