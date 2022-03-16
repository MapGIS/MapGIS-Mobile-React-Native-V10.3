package com.zondy.mapgis.mobile.react.scene;

import android.util.Log;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.core.geometry.Dot3D;
import com.zondy.mapgis.core.geometry.Rect3D;
import com.zondy.mapgis.core.scene.Layer3D;
import com.zondy.mapgis.mobile.react.JSDot3D;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @auther LiaoLiang on 20-6-30
 * @content 三维图层类的基类
 */
public class JSLayer3D extends ReactContextBaseJavaModule {
    private static final String REACT_CLASS = "JSLayer3D";
    private static String Tag = "JSLayer3D";
    private static Map<String, Layer3D> layer3DList = new HashMap<>();

    public JSLayer3D(@NonNull ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @NonNull
    @Override
    public String getName() {
        return REACT_CLASS;
    }

    /**
     * 在native层注册一个Layer3D的id,并返回该id供JS层调用。
     * 注册前先判断该Layer3D是否已经存在，如果存在，返回已经存在的ID，如果不存在，创建新的ID以返回。
     * @param layer3D
     * @return
     */
    public static String registerId(Layer3D layer3D) {
        for (Map.Entry entry : layer3DList.entrySet()) {
            if (layer3D.equals(entry.getValue())) {
                return (String) entry.getKey();
            }
        }
        String id = UUID.randomUUID().toString().substring(24);
        layer3DList.put(id,layer3D);
        Log.i(Tag,"id:"+id);
        return id;
    }

    /**
     * 根据id获取Layer3D实例
     * @param id
     * @return
     */
    public static Layer3D getObjById(String id) {
        return layer3DList.get(id);
    }

    /**
     * 构造一个新的Layer3D对象
     * @param promise
     */
    @ReactMethod
    public void createObj(Promise promise) {
        try {
            Layer3D layer3D = new Layer3D();
            String layer3DId = registerId(layer3D);

            WritableMap writableMap = Arguments.createMap();
            writableMap.putString("layer3DId",layer3DId);
            promise.resolve(writableMap);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取图层驱动类型
     * @param layer3DId
     * @param promise
     */
    @ReactMethod
    public void getDriverType(String layer3DId, Promise promise) {
        try {
            Layer3D layer3D = getObjById(layer3DId);
            String driverType = layer3D.getDriverType();
            promise.resolve(driverType);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获得图层标识（整型数字）
     * @param layer3DId
     * @param promise
     */
    @ReactMethod
    public void getLayerRenderIndex(String layer3DId, Promise promise) {
        try {
            Layer3D layer3D = getObjById(layer3DId);
            int layerRenderIndex = layer3D.getLayerRenderIndex();

            promise.resolve(layerRenderIndex);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取起止LOD级别
     * @param layer3DId
     * @param lBeginLevel 起始级别
     * @param lEndLevel 终止级别
     * @param promise
     */
    @ReactMethod
    public void getLODLevel(String layer3DId, int lBeginLevel, int lEndLevel, Promise promise) {
        try {
            Layer3D layer3D = getObjById(layer3DId);
            int result = layer3D.getLODLevel(lBeginLevel,lEndLevel); //成功返回1，失败返回0

            promise.resolve(result);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取图层参考系
     * @param layer3DId
     * @param promise
     */
    @ReactMethod
    public void getSRSString(String layer3DId, Promise promise) {
        try {
            Layer3D layer3D = getObjById(layer3DId);
            String SRSString = layer3D.getSRSString();

            promise.resolve(SRSString);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 设置图层驱动类型
     * @param layer3DId
     * @param strDriverType 驱动类型字符串,DriverType
     * @param promise
     */
    @ReactMethod
    public void setDriverType(String layer3DId, String strDriverType, Promise promise) {
        try {
            Layer3D layer3D = getObjById(layer3DId);
            int result = layer3D.setDriverType(strDriverType); //成功返回1，失败返回0

            promise.resolve(result);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 设置图层标识
     * @param layer3DId
     * @param renderIndex 图层标识（整型数字）
     * @param promise
     */
    @ReactMethod
    public void setLayerRenderIndex(String layer3DId, int renderIndex, Promise promise) {
        try {
            Layer3D layer3D = getObjById(layer3DId);
            int result = layer3D.setLayerRenderIndex(renderIndex); //成功返回1，失败返回0

            promise.resolve(result);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     *设置起止LOD级别
     * @param layer3DId
     * @param lBeginLevel 起始级别
     * @param lEndLevel 终止级别
     * @param promise
     */
    @ReactMethod
    public void setLODLevel(String layer3DId, int lBeginLevel, int lEndLevel, Promise promise){
        try {
            Layer3D layer3D = getObjById(layer3DId);
            int result = layer3D.setLODLevel(lBeginLevel,lEndLevel); //成功返回1，失败返回0

            promise.resolve(result);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 通过字符串设置图层参考系
     * @param layer3DId
     * @param strSRSType 参考系类型字符串，SRSType
     * @param promise
     */
    @ReactMethod
    public void setSRSByString(String layer3DId, String strSRSType, Promise promise) {
        try {
            Layer3D layer3D = getObjById(layer3DId);
            int result = layer3D.setSRSByString(strSRSType); //成功返回1，失败返回0

            promise.resolve(result);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取图层三维范围
     * @param layer3DId
     * @param rect3DId
     * @param promise
     */
    @ReactMethod
    public void getExtent(String layer3DId, String rect3DId, Promise promise) {
        try {
            Layer3D layer3D = getObjById(layer3DId);
            Rect3D rect3D = JSRect3D.getObjById(rect3DId);
            int extent = layer3D.getExtent(rect3D); //1-成功；0-失败

            promise.resolve(extent);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取三维显示比
     * @param layer3DId
     * @param dot3DId
     * @param promise
     */
    @ReactMethod
    public void getScale(String layer3DId, String dot3DId, Promise promise) {
        try {
            Layer3D layer3D = getObjById(layer3DId);
            Dot3D dot3D = JSDot3D.getObjFromList(dot3DId);
            int scale = layer3D.getScale(dot3D); //1-成功；0-失败

            promise.resolve(scale);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取图层类型的值
     * @param layer3DId
     * @param promise
     */
    @ReactMethod
    public void getType(String layer3DId, Promise promise) {
        try {
            Layer3D layer3D = getObjById(layer3DId);
            int typeValue = layer3D.getType().value();

            promise.resolve(typeValue);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 设置图层三维范围
     * @param layer3DId
     * @param rect3DId
     * @param promise
     */
    @ReactMethod
    public void setExtent(String layer3DId, String rect3DId, Promise promise) {
        try {
            Layer3D layer3D = getObjById(layer3DId);
            Rect3D rect3D = JSRect3D.getObjById(rect3DId);
            int result = layer3D.setExtent(rect3D); //1-成功；0-失败

            promise.resolve(result);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 设置三维显示比
     * @param layer3DId
     * @param dot3DId
     * @param promise
     */
    @ReactMethod
    public void setScale(String layer3DId, String dot3DId, Promise promise) {
        try {
            Layer3D layer3D = getObjById(layer3DId);
            Dot3D dot3D = JSDot3D.getObjFromList(dot3DId);
            int result = layer3D.setScale(dot3D); //1-成功；0-失败

            promise.resolve(result);
        }catch (Exception e) {
            promise.reject(e);
        }
    }
}
