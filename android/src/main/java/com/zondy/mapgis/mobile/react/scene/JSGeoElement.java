package com.zondy.mapgis.mobile.react.scene;

import android.util.Log;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.android.sceneview.GeoElement;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @auther LiaoLiang on 20-8-4
 * @content
 */
public class JSGeoElement extends ReactContextBaseJavaModule {
    private static final String REACT_CLASS = "JSGeoElement";
    private static String Tag = "JSGeoElement";
    private static Map<String, GeoElement> geoElementList = new HashMap<>();

    @NonNull
    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public JSGeoElement(@NonNull ReactApplicationContext reactContext) {
        super(reactContext);
    }

    /**
     * 在native层注册一个GeoElement的id,并返回该id供JS层调用。
     * 注册前先判断该GeoElement是否已经存在，如果存在，返回已经存在的ID，如果不存在，创建新的ID以返回。
     * @param geoElement
     * @return
     */
    public static String registerId(GeoElement geoElement) {
        for (Map.Entry entry : geoElementList.entrySet()) {
            if (geoElement.equals(entry.getValue())) {
                return (String) entry.getKey();
            }
        }
        String id = UUID.randomUUID().toString().substring(24);
        geoElementList.put(id,geoElement);
        Log.i(Tag,"id:"+id);
        return id;
    }

    /**
     * 根据id获取GeoElement实例
     * @param id
     * @return
     */
    public static GeoElement getObjById(String id) {
        return geoElementList.get(id);
    }

    /**
     * 构造一个新的GeoElement对象
     * @param promise
     */
    @ReactMethod
    public void createObj(Promise promise) {
        try {
            GeoElement geoElement = new GeoElement();
            String geoElementId = registerId(geoElement);

            WritableMap map = Arguments.createMap();
            map.putString("geoElementId", geoElementId);
            promise.resolve(map);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取属性
     * @param geoElementId
     * @param promise
     */
    @ReactMethod
    public void getAttributes(String geoElementId, Promise promise) {
        try {
            GeoElement geoElement = getObjById(geoElementId);
            Map<String,String> attributes = geoElement.getAttributes();
            WritableMap map = Arguments.createMap();
            for (Map.Entry entry : attributes.entrySet()) {
                map.putString(entry.getKey().toString(),entry.getValue().toString());
            }
            promise.resolve(map);
        }catch (Exception e) {
            promise.reject(e);
        }
    }
}
