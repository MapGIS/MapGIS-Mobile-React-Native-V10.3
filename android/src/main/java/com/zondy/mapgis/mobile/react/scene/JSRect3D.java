package com.zondy.mapgis.mobile.react.scene;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.core.geometry.Rect3D;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @auther LiaoLiang on 20-7-7
 * @content 三维矩形对象Native组件
 */
public class JSRect3D extends ReactContextBaseJavaModule {
    private static final String REACT_CLASS = "JSRect3D";
    private static final String Tag = "JSRect3D";
    private static Map<String, Rect3D> mRect3DList = new HashMap<String, Rect3D>();

    public JSRect3D(@NonNull ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @NonNull
    @Override
    public String getName() {
        return REACT_CLASS;
    }

    /**
     * 在native层注册一个Rect3D的id,并返回该id供JS层调用。
     * 注册前先判断该Rect3D是否已经存在，如果存在，返回已经存在的ID，如果不存在，创建新的ID以返回。
     * @param rect3D
     * @return
     */
    public static String registerId(Rect3D rect3D) {
        for (Map.Entry entry : mRect3DList.entrySet()) {
            if (rect3D.equals(entry.getValue())) {
                return (String) entry.getKey();
            }
        }
        String id = UUID.randomUUID().toString().substring(24);
        mRect3DList.put(id, rect3D);
        return id;
    }

    /**
     * 根据id获取Rect3D实例
     * @param id
     * @return
     */
    public static Rect3D getObjById(String id) {
        return mRect3DList.get(id);
    }

    /**
     * 构造一个新的Rect3D对象
     * @param promise
     */
    @ReactMethod
    public void createObj(Promise promise) {
        try {
            Rect3D rect3D = new Rect3D();
            String rect3DId = registerId(rect3D);

            WritableMap map = Arguments.createMap();
            map.putString("rect3DId", rect3DId);
            promise.resolve(map);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 带参构造一个新的Rect3D对象
     * @param xMin
     * @param yMin
     * @param zMin
     * @param xMax
     * @param yMax
     * @param zMax
     * @param promise
     */
    @ReactMethod
    public void createObjByXYZ(double xMin, double yMin, double zMin, double xMax, double yMax, double zMax, Promise promise) {
        try {
            Rect3D rect3D = new Rect3D(xMin, yMin, zMin, xMax, yMax, zMax);
            String rect3DId = registerId(rect3D);

            WritableMap map = Arguments.createMap();
            map.putString("rect3DId", rect3DId);
            promise.resolve(map);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 拷贝三维包围盒
     * @param rect3DId
     * @param promise
     */
    @ReactMethod
    public void clone(String rect3DId,Promise promise) {
        try {
            Rect3D rect3D = getObjById(rect3DId);
            Rect3D cloneObj = rect3D.clone();
            String cloneObjId = registerId(cloneObj);

            WritableMap map = Arguments.createMap();
            map.putString("rect3DId", cloneObjId);
            promise.resolve(map);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取x最大值
     * @param rect3DId
     * @param promise
     */
    @ReactMethod
    public void getXMax(String rect3DId,Promise promise) {
        try {
            Rect3D rect3D = getObjById(rect3DId);
            double xMax = rect3D.getXMax();

            promise.resolve(xMax);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取y最大值
     * @param rect3DId
     * @param promise
     */
    @ReactMethod
    public void getYMax(String rect3DId,Promise promise) {
        try {
            Rect3D rect3D = getObjById(rect3DId);
            double yMax = rect3D.getYMax();

            promise.resolve(yMax);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取z最大值
     * @param rect3DId
     * @param promise
     */
    @ReactMethod
    public void getZMax(String rect3DId,Promise promise) {
        try {
            Rect3D rect3D = getObjById(rect3DId);
            double zMax = rect3D.getZMax();

            promise.resolve(zMax);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取x最小值
     * @param rect3DId
     * @param promise
     */
    @ReactMethod
    public void getXMin(String rect3DId,Promise promise) {
        try {
            Rect3D rect3D = getObjById(rect3DId);
            double xMin = rect3D.getXMin();

            promise.resolve(xMin);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取y最小值
     * @param rect3DId
     * @param promise
     */
    @ReactMethod
    public void getYMin(String rect3DId,Promise promise) {
        try {
            Rect3D rect3D = getObjById(rect3DId);
            double yMin = rect3D.getYMin();

            promise.resolve(yMin);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取z最小值
     * @param rect3DId
     * @param promise
     */
    @ReactMethod
    public void getZMin(String rect3DId,Promise promise) {
        try {
            Rect3D rect3D = getObjById(rect3DId);
            double zMin = rect3D.getZMin();

            promise.resolve(zMin);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 设置x最大值
     * @param rect3DId
     * @param xMax
     * @param promise
     */
    @ReactMethod
    public void setXMax(String rect3DId, double xMax,Promise promise) {
        try {
            Rect3D rect3D = getObjById(rect3DId);
            rect3D.setXMax(xMax);

            promise.resolve(true);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 设置y最大值
     * @param rect3DId
     * @param yMax
     * @param promise
     */
    @ReactMethod
    public void setYMax(String rect3DId, double yMax,Promise promise) {
        try {
            Rect3D rect3D = getObjById(rect3DId);
            rect3D.setYMax(yMax);

            promise.resolve(true);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 设置z最大值
     * @param rect3DId
     * @param zMax
     * @param promise
     */
    @ReactMethod
    public void setZMax(String rect3DId, double zMax,Promise promise) {
        try {
            Rect3D rect3D = getObjById(rect3DId);
            rect3D.setXMax(zMax);

            promise.resolve(true);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 设置x最小值
     * @param rect3DId
     * @param xMin
     * @param promise
     */
    @ReactMethod
    public void setXMin(String rect3DId, double xMin,Promise promise) {
        try {
            Rect3D rect3D = getObjById(rect3DId);
            rect3D.setXMin(xMin);

            promise.resolve(true);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 设置y最小值
     * @param rect3DId
     * @param yMin
     * @param promise
     */
    @ReactMethod
    public void setYMin(String rect3DId, double yMin,Promise promise) {
        try {
            Rect3D rect3D = getObjById(rect3DId);
            rect3D.setYMin(yMin);

            promise.resolve(true);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 设置z最小值
     * @param rect3DId
     * @param zMin
     * @param promise
     */
    @ReactMethod
    public void setZMin(String rect3DId, double zMin,Promise promise) {
        try {
            Rect3D rect3D = getObjById(rect3DId);
            rect3D.setZMin(zMin);

            promise.resolve(true);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 将三维包围盒转换为字符串
     * @param rect3DId
     * @param promise
     */
    @ReactMethod
    public void toString(String rect3DId, Promise promise) {
        try {
            Rect3D rect3D = getObjById(rect3DId);
            String str = rect3D.toString();

            promise.resolve(str);
        }catch (Exception e) {
            promise.reject(e);
        }
    }


}
