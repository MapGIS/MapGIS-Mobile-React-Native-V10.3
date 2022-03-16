package com.zondy.mapgis.mobile.react.scene;

import android.util.Log;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.core.scene.SelectionProperties;
import com.zondy.mapgis.core.scene.SelectionStyle;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @auther LiaoLiang on 20-7-20
 * @content
 */
public class JSSelectionProperties extends ReactContextBaseJavaModule {
    private static final String REACT_CLASS = "JSSelectionProperties";
    private static final String Tag = "JSSelectionProperties";
    private static Map<String, SelectionProperties> selectionPropertiesList = new HashMap<>();
    @NonNull
    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public JSSelectionProperties(@NonNull ReactApplicationContext reactContext) {
        super(reactContext);
    }

    /**
     * 在native层注册一个SelectionProperties的id,并返回该id供JS层调用。
     * 注册前先判断该SelectionProperties是否已经存在，如果存在，返回已经存在的ID，如果不存在，创建新的ID以返回。
     * @param selectionProperties
     * @return
     */
    public static String registerId(SelectionProperties selectionProperties) {
        for (Map.Entry entry : selectionPropertiesList.entrySet()) {
            if (selectionProperties.equals(entry.getValue())) {
                return (String) entry.getKey();
            }
        }
        String id = UUID.randomUUID().toString().substring(24);
        selectionPropertiesList.put(id,selectionProperties);
        Log.i(Tag,"id:"+id);
        return id;
    }

    /**
     * 根据id获取SelectionProperties实例
     * @param id
     * @return
     */
    public static SelectionProperties getObjById(String id) {
        return selectionPropertiesList.get(id);
    }

    /**
     * 构造一个新的SelectionProperties对象
     * @param promise
     */
    @ReactMethod
    public void createObj(Promise promise) {
        try {
            SelectionProperties selectionProperties = new SelectionProperties();
            String selectionPropertiesId = registerId(selectionProperties);

            WritableMap writableMap = Arguments.createMap();
            writableMap.putString("selectionPropertiesId",selectionPropertiesId);
            promise.resolve(writableMap);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取选中要素的样式
     * @param selectionPropertiesId
     * @param promise
     */
    @ReactMethod
    public void getSelectionStyle(String selectionPropertiesId, Promise promise) {
        try {
            SelectionProperties selectionProperties = getObjById(selectionPropertiesId);
            SelectionStyle selectionStyle = selectionProperties.getSelectionStyle();
            String selectionStyleId = JSSelectionStyle.registerId(selectionStyle);

            promise.resolve(selectionStyleId);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取没有选中要素的样式
     * @param selectionPropertiesId
     * @param promise
     */
    @ReactMethod
    public void getUnSelectionStyle(String selectionPropertiesId, Promise promise) {
        try {
            SelectionProperties selectionProperties = getObjById(selectionPropertiesId);
            SelectionStyle selectionStyle = selectionProperties.getUnSelectionStyle();
            String selectionStyleId = JSSelectionStyle.registerId(selectionStyle);

            promise.resolve(selectionStyleId);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     *设置选中要素的样式
     * @param selectionPropertiesId
     * @param selectionStyleId
     * @param promise
     */
    @ReactMethod
    public void setSelectionStyle(String selectionPropertiesId, String selectionStyleId, Promise promise) {
        try {
            SelectionProperties selectionProperties = getObjById(selectionPropertiesId);
            SelectionStyle selectionStyle = JSSelectionStyle.getObjById(selectionStyleId);
            selectionProperties.setSelectionStyle(selectionStyle);

            promise.resolve(true);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     *设置没有选中要素的样式
     * @param selectionPropertiesId
     * @param selectionStyleId
     * @param promise
     */
    @ReactMethod
    public void setUnSelectionStyle(String selectionPropertiesId, String selectionStyleId, Promise promise) {
        try {
            SelectionProperties selectionProperties = getObjById(selectionPropertiesId);
            SelectionStyle selectionStyle = JSSelectionStyle.getObjById(selectionStyleId);
            selectionProperties.setUnSelectionStyle(selectionStyle);

            promise.resolve(true);
        }catch (Exception e) {
            promise.reject(e);
        }
    }
}
