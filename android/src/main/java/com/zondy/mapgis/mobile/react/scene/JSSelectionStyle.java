package com.zondy.mapgis.mobile.react.scene;

import android.util.Log;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.core.scene.SelectionStyle;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @auther LiaoLiang on 20-7-20
 * @content
 */
public class JSSelectionStyle extends ReactContextBaseJavaModule {
    private static final String REACT_CLASS = "JSSelectionStyle";
    private static final String Tag = "JSSelectionStyle";
    private static Map<String, SelectionStyle> selectionStyleList = new HashMap<>();

    @NonNull
    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public JSSelectionStyle(@NonNull ReactApplicationContext reactContext) {
        super(reactContext);
    }

    /**
     * 在native层注册一个SelectionStyle的id,并返回该id供JS层调用。
     * 注册前先判断该SelectionStyle是否已经存在，如果存在，返回已经存在的ID，如果不存在，创建新的ID以返回。
     * @param selectionStyle
     * @return
     */
    public static String registerId(SelectionStyle selectionStyle) {
        for (Map.Entry entry : selectionStyleList.entrySet()) {
            if (selectionStyle.equals(entry.getValue())) {
                return (String) entry.getKey();
            }
        }
        String id = UUID.randomUUID().toString().substring(24);
        selectionStyleList.put(id,selectionStyle);
        Log.i(Tag,"id:"+id);
        return id;
    }

    /**
     * 根据id获取SelectionStyle实例
     * @param id
     * @return
     */
    public static SelectionStyle getObjById(String id) {
        return selectionStyleList.get(id);
    }

    /**
     * 构造一个新的SelectionStyle对象
     * @param promise
     */
    @ReactMethod
    public void createObj(Promise promise) {
        try {
            SelectionStyle selectionStyle = new SelectionStyle();
            String selectionStyleId = registerId(selectionStyle);

            WritableMap writableMap = Arguments.createMap();
            writableMap.putString("selectionStyleId",selectionStyleId);
            promise.resolve(writableMap);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取填充色
     * @param selectionStyleId
     * @param promise
     */
    @ReactMethod
    public void getFillColor(String selectionStyleId, Promise promise) {
        try {
            SelectionStyle selectionStyle = getObjById(selectionStyleId);
            int fillColor = selectionStyle.getFillColor();

            promise.resolve(fillColor);
        }catch (Exception e) {
            promise.reject(e);
        }
    }


    /**
     * 设置填充色
     * @param selectionStyleId
     * @param color
     * @param promise
     */
    @ReactMethod
    public void setFillColor(String selectionStyleId, int color, Promise promise) {
        try {
            SelectionStyle selectionStyle = getObjById(selectionStyleId);
            selectionStyle.setFillColor(color);

            promise.resolve(true);
        }catch (Exception e) {
            promise.reject(e);
        }
    }
}

