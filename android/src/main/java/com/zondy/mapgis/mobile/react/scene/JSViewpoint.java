package com.zondy.mapgis.mobile.react.scene;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.core.geometry.Dot3D;
import com.zondy.mapgis.core.viewpoint.Viewpoint;
import com.zondy.mapgis.mobile.react.JSDot3D;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @auther LiaoLiang on 20-7-27
 * @content
 */
public class JSViewpoint extends ReactContextBaseJavaModule {
    private static final String REACT_CLASS = "JSViewpoint";
    private static String Tag = "JSLayer3DEnum";
    private static Map<String, Viewpoint> mViewpointList = new HashMap<>();

    public JSViewpoint(@NonNull ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @NonNull
    @Override
    public String getName() {
        return REACT_CLASS;
    }

    /**
     * 在native层注册一个Viewpoint的id,并返回该id供JS层调用。
     * 注册前先判断该Viewpoint是否已经存在，如果存在，返回已经存在的ID，如果不存在，创建新的ID以返回。
     * @param viewpoint
     * @return
     */
    public static String registerId(Viewpoint viewpoint) {
        for (Map.Entry entry : mViewpointList.entrySet()) {
            if (viewpoint.equals(entry.getValue())) {
                return (String) entry.getKey();
            }
        }
        String id = UUID.randomUUID().toString().substring(24);
        mViewpointList.put(id,viewpoint);
        return id;
    }

    /**
     * 根据id获取Viewpoint实例
     * @param viewpointId
     * @return
     */
    public static Viewpoint getObjById(String viewpointId) {
        return mViewpointList.get(viewpointId);
    }

    /**
     * 构造一个新的Viewpoint对象
     * @param promise
     */
    @ReactMethod
    public void createObj(Promise promise){
        try {
            Viewpoint viewpoint = new Viewpoint();
            String viewpointId = registerId(viewpoint);

            WritableMap map = Arguments.createMap();
            map.putString("viewpointId",viewpointId);
            promise.resolve(map);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    /**
     * 获取相机的焦点,返回焦点Dot3D的id
     * @param viewpointId
     * @param promise
     */
    @ReactMethod
    public void getFocalPoint(String viewpointId, Promise promise) {
        try {
            Viewpoint viewpoint = getObjById(viewpointId);
            Dot3D focalPoint = viewpoint.getFocalPoint();
            String focalPointId = JSDot3D.registerId(focalPoint);

            promise.resolve(focalPointId);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取相机的航向角，单位为度，顺时针为正
     * @param viewpointId
     * @param promise
     */
    @ReactMethod
    public void getHeadingDeg(String viewpointId, Promise promise) {
        try {
            Viewpoint viewpoint = getObjById(viewpointId);
            double headingDeg = viewpoint.getHeadingDeg();

            promise.resolve(headingDeg);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取相机的俯仰角，范围（-90 ~ -10）单位为度
     * @param viewpointId
     * @param promise
     */
    @ReactMethod
    public void getPitchDeg(String viewpointId, Promise promise) {
        try {
            Viewpoint viewpoint = getObjById(viewpointId);
            double pitchDeg = viewpoint.getPitchDeg();

            promise.resolve(pitchDeg);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取相机到相机焦点的距离
     * @param viewpointId
     * @param promise
     */
    @ReactMethod
    public void getRange(String viewpointId, Promise promise) {
        try {
            Viewpoint viewpoint = getObjById(viewpointId);
            double range = viewpoint.getRange();

            promise.resolve(range);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 设置相机的焦点
     * @param viewpointId
     * @param focalPointId
     * @param promise
     */
    @ReactMethod
    public void setFocalPoint(String viewpointId, String focalPointId, Promise promise) {
        try {
            Viewpoint viewpoint = getObjById(viewpointId);
            Dot3D focalPoint = JSDot3D.getObjFromList(focalPointId);
            viewpoint.setFocalPoint(focalPoint);

            promise.resolve(true);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 设置相机的航向角，单位为度，顺时针为正
     * @param viewpointId
     * @param headingDeg
     * @param promise
     */
    @ReactMethod
    public void setHeadingDeg(String viewpointId, double headingDeg, Promise promise) {
        try {
            Viewpoint viewpoint = getObjById(viewpointId);
            viewpoint.setHeadingDeg(headingDeg);

            promise.resolve(true);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 设置相机的俯仰角，范围（-90 ~ -10）单位为度
     * @param viewpointId
     * @param pitchDeg
     * @param promise
     */
    @ReactMethod
    public void setPitchDeg(String viewpointId, double pitchDeg, Promise promise) {
        try {
            Viewpoint viewpoint = getObjById(viewpointId);
            viewpoint.setPitchDeg(pitchDeg);

            promise.resolve(true);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 设置相机到相机焦点的距离
     * @param viewpointId
     * @param range
     * @param promise
     */
    @ReactMethod
    public void setRange(String viewpointId, double range, Promise promise) {
        try {
            Viewpoint viewpoint = getObjById(viewpointId);
            viewpoint.setRange(range);

            promise.resolve(true);
        }catch (Exception e) {
            promise.reject(e);
        }
    }
}
