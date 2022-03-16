package com.zondy.mapgis.mobile.react.scene;

import android.util.Log;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.core.spatial.DistanceMeasurement;
import com.zondy.mapgis.core.spatial.MeasurementChangedEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @auther LiaoLiang on 20-8-20
 * @content
 */
public class JSMeasurementChangedEvent extends ReactContextBaseJavaModule {
    private static final String REACT_CLASS = "JSMeasurementChangedEvent";
    private static String Tag = "JSMeasurementChangedEvent";
    private static Map<String, MeasurementChangedEvent> measurementChangedEventList = new HashMap<>();

    @NonNull
    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public JSMeasurementChangedEvent(@NonNull ReactApplicationContext reactContext) {
        super(reactContext);
    }

    /**
     * 在native层注册一个 MeasurementChangedEvent 的id,并返回该id供JS层调用。
     * 注册前先判断该 MeasurementChangedEvent 是否已经存在，如果存在，返回已经存在的ID，如果不存在，创建新的ID以返回。
     * @param measurementChangedEvent
     * @return
     */
    public static String registerId(MeasurementChangedEvent measurementChangedEvent) {
        for (Map.Entry entry : measurementChangedEventList.entrySet()) {
            if (measurementChangedEvent.equals(entry.getValue())) {
                return (String) entry.getKey();
            }
        }
        String id = UUID.randomUUID().toString().substring(24);
        measurementChangedEventList.put(id,measurementChangedEvent);
        Log.i(Tag,"id:"+id);
        return id;
    }

    /**
     * 根据id获取 MeasurementChangedEvent 实例
     * @param id
     * @return
     */
    public static MeasurementChangedEvent getObjById(String id) {
        return measurementChangedEventList.get(id);
    }

    /**
     * 构造一个新的 MeasurementChangedEvent 对象
     * @param promise
     */
    @ReactMethod
    public void createObj(String handle, Promise promise) {
        try {
            MeasurementChangedEvent measurementChangedEvent = new MeasurementChangedEvent(Long.parseLong(handle));
            String measurementChangedEventId = registerId(measurementChangedEvent);

            WritableMap writableMap = Arguments.createMap();
            writableMap.putString("measurementChangedEventId",measurementChangedEventId);
            promise.resolve(writableMap);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取直接距离，即起点和终点之间的直线距离
     * @param measurementChangedEventId
     * @param promise
     */
    @ReactMethod
    public void getDirectDistance(String measurementChangedEventId, Promise promise) {
        try {
            MeasurementChangedEvent measurementChangedEvent = getObjById(measurementChangedEventId);
            double directDistance = measurementChangedEvent.getDirectDistance();

            promise.resolve(directDistance);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取水平距离，即将起点和终点投影到地表之后，两点之间的距离。
     * @param measurementChangedEventId
     * @param promise
     */
    @ReactMethod
    public void getHorizontalDistance(String measurementChangedEventId, Promise promise) {
        try {
            MeasurementChangedEvent measurementChangedEvent = getObjById(measurementChangedEventId);
            double horizontalDistance = measurementChangedEvent.getHorizontalDistance();

            promise.resolve(horizontalDistance);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取垂直距离，即起点和终点在高度（z）上的差值。
     * @param measurementChangedEventId
     * @param promise
     */
    @ReactMethod
    public void getVerticalDistance(String measurementChangedEventId, Promise promise) {
        try {
            MeasurementChangedEvent measurementChangedEvent = getObjById(measurementChangedEventId);
            double verticalDistance = measurementChangedEvent.getVerticalDistance();

            promise.resolve(verticalDistance);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * @param measurementChangedEventId
     * @param promise
     */
    @ReactMethod
    public void getSource(String measurementChangedEventId, Promise promise) {
        try {
            MeasurementChangedEvent measurementChangedEvent = getObjById(measurementChangedEventId);
            DistanceMeasurement distanceMeasurement = measurementChangedEvent.getSource();
            String distanceMeasurementId = JSDistanceMeasurement.registerId(distanceMeasurement);

            promise.resolve(distanceMeasurementId);
        }catch (Exception e) {
            promise.reject(e);
        }
    }
}
