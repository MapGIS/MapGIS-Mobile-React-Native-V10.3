package com.zondy.mapgis.mobile.react.scene;

import android.util.Log;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.core.geometry.Dot3D;
import com.zondy.mapgis.core.spatial.DistanceMeasurement;
import com.zondy.mapgis.mobile.react.JSDot3D;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @auther LiaoLiang on 20-8-21
 * @content 三维距离量算类。用于量算三维空间中两个点之间的直接距离、水平距离、垂直距离。
 */
public class JSDistanceMeasurement extends ReactContextBaseJavaModule {
    private static final String REACT_CLASS = "JSDistanceMeasurement";
    private static String Tag = "JSDistanceMeasurement";
    private static Map<String, DistanceMeasurement> distanceMeasurementList = new HashMap<>();
    ReactContext mReactContext;

    @NonNull
    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public JSDistanceMeasurement(@NonNull ReactApplicationContext reactContext) {
        super(reactContext);
        mReactContext = reactContext;
    }

    /**
     * 在native层注册一个 DistanceMeasurement 的id,并返回该id供JS层调用。
     * 注册前先判断该 DistanceMeasurement 是否已经存在，如果存在，返回已经存在的ID，如果不存在，创建新的ID以返回。
     * @param distanceMeasurement
     * @return
     */
    public static String registerId(DistanceMeasurement distanceMeasurement) {
        for (Map.Entry entry : distanceMeasurementList.entrySet()) {
            if (distanceMeasurement.equals(entry.getValue())) {
                return (String) entry.getKey();
            }
        }
        String id = UUID.randomUUID().toString().substring(24);
        distanceMeasurementList.put(id,distanceMeasurement);
        Log.i(Tag,"id:"+id);
        return id;
    }

    /**
     * 根据id获取 DistanceMeasurement 实例
     * @param id
     * @return
     */
    public static DistanceMeasurement getObjById(String id) {
        return distanceMeasurementList.get(id);
    }

    /**
     * 构造一个新的 DistanceMeasurement 对象
     * @param promise
     */
    @ReactMethod
    public void createObj(Promise promise) {
        try {
            DistanceMeasurement distanceMeasurement = new DistanceMeasurement();
            String distanceMeasurementId = registerId(distanceMeasurement);

            WritableMap writableMap = Arguments.createMap();
            writableMap.putString("distanceMeasurementId",distanceMeasurementId);
            promise.resolve(writableMap);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取直接距离，即起点和终点之间的直线距离
     * @param distanceMeasurementId
     * @param promise
     */
    @ReactMethod
    public void getDirectDistance(String distanceMeasurementId, Promise promise) {
        try {
            DistanceMeasurement distanceMeasurement = getObjById(distanceMeasurementId);
            double directDistance = distanceMeasurement.getDirectDistance();

            promise.resolve(directDistance);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取算量终点位置Dot3D的id
     * @param distanceMeasurementId
     * @param promise
     */
    @ReactMethod
    public void getEndLocation(String distanceMeasurementId, Promise promise) {
        try {
            DistanceMeasurement distanceMeasurement = getObjById(distanceMeasurementId);
            Dot3D endLocation = distanceMeasurement.getEndLocation();
            String endLocationId = JSDot3D.registerId(endLocation);

            promise.resolve(endLocationId);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取水平距离，即将起点和终点投影到地表之后，两点之间的距离。
     * @param distanceMeasurementId
     * @param promise
     */
    @ReactMethod
    public void getHorizontalDistance(String distanceMeasurementId, Promise promise) {
        try {
            DistanceMeasurement distanceMeasurement = getObjById(distanceMeasurementId);
            double horizontalDistance = distanceMeasurement.getHorizontalDistance();

            promise.resolve(horizontalDistance);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取算量起点位置Dot3D的id
     * @param distanceMeasurementId
     * @param promise
     */
    @ReactMethod
    public void getStartLocation(String distanceMeasurementId, Promise promise) {
        try {
            DistanceMeasurement distanceMeasurement = getObjById(distanceMeasurementId);
            Dot3D startLocation = distanceMeasurement.getStartLocation();
            String startLocationId = JSDot3D.registerId(startLocation);

            promise.resolve(startLocationId);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取垂直距离，即起点和终点在高度（z）上的差值。
     * @param distanceMeasurementId
     * @param promise
     */
    @ReactMethod
    public void getVerticalDistance(String distanceMeasurementId, Promise promise) {
        try {
            DistanceMeasurement distanceMeasurement = getObjById(distanceMeasurementId);
            double verticalDistance = distanceMeasurement.getVerticalDistance();

            promise.resolve(verticalDistance);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 设置算量终点位置，坐标类型为经纬度。
     * @param distanceMeasurementId
     * @param endLocationId
     * @param promise
     */
    @ReactMethod
    public void setEndLocation(String distanceMeasurementId, String endLocationId, Promise promise) {
        try {
            DistanceMeasurement distanceMeasurement = getObjById(distanceMeasurementId);
            Dot3D dot3D = JSDot3D.getObjFromList(endLocationId);
            distanceMeasurement.setEndLocation(dot3D);

            promise.resolve(true);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 设置算量起点位置，坐标类型为经纬度。
     * @param distanceMeasurementId
     * @param startLocationId
     * @param promise
     */
    @ReactMethod
    public void setStartLocation(String distanceMeasurementId, String startLocationId, Promise promise) {
        try {
            DistanceMeasurement distanceMeasurement = getObjById(distanceMeasurementId);
            Dot3D dot3D = JSDot3D.getObjFromList(startLocationId);
            distanceMeasurement.setStartLocation(dot3D);

            promise.resolve(true);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void registerMeasurementChangedListener(String distanceMeasurementId, Promise promise) {
        try {
            DistanceMeasurement distanceMeasurement = getObjById(distanceMeasurementId);
            DistanceMeasurement.DistanceMeasureChangedListener distanceMeasureChangedListener = new DistanceMeasurementListener(distanceMeasurement, mReactContext);
            distanceMeasurement.addMeasurementChangedListener(distanceMeasureChangedListener);

            promise.resolve(true);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void unregisterMeasurementChangedListener(String distanceMeasurementId, Promise promise) {
        try {
            DistanceMeasurement distanceMeasurement = getObjById(distanceMeasurementId);
            distanceMeasurement.addMeasurementChangedListener(null);

            promise.resolve(true);
        }catch (Exception e) {
            promise.reject(e);
        }
    }
}
