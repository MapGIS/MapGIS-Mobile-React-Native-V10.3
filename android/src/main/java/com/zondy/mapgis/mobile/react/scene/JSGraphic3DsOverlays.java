package com.zondy.mapgis.mobile.react.scene;

import android.util.Log;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.android.graphic.Graphic3DsOverlay;
import com.zondy.mapgis.android.graphic.Graphic3DsOverlays;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @auther LiaoLiang on 20-8-15
 * @content 图形覆盖物层列表
 */
public class JSGraphic3DsOverlays extends ReactContextBaseJavaModule {
    private static final String REACT_CLASS = "JSGraphic3DsOverlays";
    private static String Tag = "JSGraphic3DsOverlays";
    private static Map<String, Graphic3DsOverlays> graphic3DsOverlaysList = new HashMap<>();

    @NonNull
    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public JSGraphic3DsOverlays(@NonNull ReactApplicationContext reactContext) {
        super(reactContext);
    }

    /**
     * 在native层注册一个Graphic3DsOverlays的id,并返回该id供JS层调用。
     * 注册前先判断该Graphic3DsOverlays是否已经存在，如果存在，返回已经存在的ID，如果不存在，创建新的ID以返回。
     * @param graphic3DsOverlays
     * @return
     */
    public static String registerId(Graphic3DsOverlays graphic3DsOverlays) {
        for (Map.Entry entry : graphic3DsOverlaysList.entrySet()) {
            if (graphic3DsOverlays.equals(entry.getValue())) {
                return (String) entry.getKey();
            }
        }
        String id = UUID.randomUUID().toString().substring(24);
        graphic3DsOverlaysList.put(id,graphic3DsOverlays);
        Log.i(Tag,"id:"+id);
        return id;
    }

    /**
     * 根据id获取Graphic3DsOverlays实例
     * @param id
     * @return
     */
    public static Graphic3DsOverlays getObjById(String id) {
        return graphic3DsOverlaysList.get(id);
    }

    /**
     * 构造一个新的Graphic3DsOverlays对象
     * @param promise
     */
    @ReactMethod
    public void createObj(Promise promise) {
        try {
            Graphic3DsOverlays graphic3DsOverlays = new Graphic3DsOverlays();
            String graphic3DsOverlaysId = registerId(graphic3DsOverlays);

            WritableMap writableMap = Arguments.createMap();
            writableMap.putString("graphic3DsOverlaysId",graphic3DsOverlaysId);
            promise.resolve(writableMap);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     *添加一个覆盖物图层
     * @param graphic3DsOverlaysId
     * @param graphic3DsOverlayId 覆盖物图层id
     * @param promise
     */
    @ReactMethod
    public void add(String graphic3DsOverlaysId, String graphic3DsOverlayId, Promise promise) {
        try {
            Graphic3DsOverlays graphic3DsOverlays = getObjById(graphic3DsOverlaysId);
            Graphic3DsOverlay graphic3DsOverlay = JSGraphic3DsOverlay.getObjById(graphic3DsOverlayId);
            int result = graphic3DsOverlays.add(graphic3DsOverlay); //成功返回 1 ,失败返回0

            promise.resolve(result);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取图层覆盖物id列表
     * @param graphic3DsOverlaysId
     * @param promise
     */
    @ReactMethod
    public void getAllGraphicsOverlays(String graphic3DsOverlaysId, Promise promise) {
        try {
            Graphic3DsOverlays graphic3DsOverlays = getObjById(graphic3DsOverlaysId);
            List<Graphic3DsOverlay> graphic3DsOverlayList = graphic3DsOverlays.getAllGraphicsOverlays();
            WritableArray writableArray = Arguments.createArray();
            for (Graphic3DsOverlay graphic3DsOverlay : graphic3DsOverlayList) {
                writableArray.pushString(JSGraphic3DsOverlay.registerId(graphic3DsOverlay));
            }

            promise.resolve(writableArray);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取覆盖物图层的个数
     * @param graphic3DsOverlaysId
     * @param promise
     */
    @ReactMethod
    public void getCount(String graphic3DsOverlaysId, Promise promise) {
        try {
            Graphic3DsOverlays graphic3DsOverlays = getObjById(graphic3DsOverlaysId);
            int countNum = graphic3DsOverlays.getCount();

            promise.resolve(countNum);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取覆盖物图形id
     * @param graphic3DsOverlaysId
     * @param index 覆盖物图形索引
     * @param promise
     */
    @ReactMethod
    public void getGraphicsOverlay(String graphic3DsOverlaysId, int index, Promise promise) {
        try {
            Graphic3DsOverlays graphic3DsOverlays = getObjById(graphic3DsOverlaysId);
            Graphic3DsOverlay graphic3DsOverlay = graphic3DsOverlays.getGraphicsOverlay(index);
            String graphic3DsOverlayId = JSGraphic3DsOverlay.registerId(graphic3DsOverlay);

            promise.resolve(graphic3DsOverlayId);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 覆盖物图层的索引
     * @param graphic3DsOverlaysId
     * @param graphic3DsOverlayId
     * @param promise
     */
    @ReactMethod
    public void indexOf(String graphic3DsOverlaysId, String graphic3DsOverlayId, Promise promise) {
        try {
            Graphic3DsOverlays graphic3DsOverlays = getObjById(graphic3DsOverlaysId);
            Graphic3DsOverlay graphic3DsOverlay = JSGraphic3DsOverlay.getObjById(graphic3DsOverlayId);
            int index = graphic3DsOverlays.indexOf(graphic3DsOverlay);

            promise.resolve(index);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 通过名称获取覆盖物图层的索引
     * @param graphic3DsOverlaysId
     * @param graphicLayerName
     * @param promise
     */
    @ReactMethod
    public void indexOfByName(String graphic3DsOverlaysId, String graphicLayerName, Promise promise) {
        try {
            Graphic3DsOverlays graphic3DsOverlays = getObjById(graphic3DsOverlaysId);
            int index = graphic3DsOverlays.indexOf(graphicLayerName);

            promise.resolve(index);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 插入一个覆盖物图层
     * @param graphic3DsOverlaysId
     * @param index 图层索引
     * @param graphic3DsOverlayId 覆盖物图层id
     * @param promise
     */
    @ReactMethod
    public void insert(String graphic3DsOverlaysId, int index, String graphic3DsOverlayId, Promise promise) {
        try {
            Graphic3DsOverlays graphic3DsOverlays = getObjById(graphic3DsOverlaysId);
            Graphic3DsOverlay graphic3DsOverlay = JSGraphic3DsOverlay.getObjById(graphic3DsOverlayId);
            int result = graphic3DsOverlays.insert(index,graphic3DsOverlay); //成功返回 1 ,失败返回0

            promise.resolve(result);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 移除覆盖物图层
     * @param graphic3DsOverlaysId
     * @param graphic3DsOverlayId
     * @param promise
     */
    @ReactMethod
    public void remove(String graphic3DsOverlaysId, String graphic3DsOverlayId, Promise promise) {
        try {
            Graphic3DsOverlays graphic3DsOverlays = getObjById(graphic3DsOverlaysId);
            Graphic3DsOverlay graphic3DsOverlay = JSGraphic3DsOverlay.getObjById(graphic3DsOverlayId);
            graphic3DsOverlays.remove(graphic3DsOverlay);

            promise.resolve(true);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 移动覆盖物图层
     * @param graphic3DsOverlaysId
     * @param fromIndex
     * @param toIndex
     * @param promise
     */
    @ReactMethod
    public void move(String graphic3DsOverlaysId, int fromIndex, int toIndex, Promise promise) {
        try {
            Graphic3DsOverlays graphic3DsOverlays = getObjById(graphic3DsOverlaysId);
            graphic3DsOverlays.move(fromIndex, toIndex);

            promise.resolve(true);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     *通过索引移除覆盖物图层
     * @param graphic3DsOverlaysId
     * @param index 覆盖物图层列表索引
     * @param promise
     */
    @ReactMethod
    public void removeByIndex(String graphic3DsOverlaysId, int index, Promise promise) {
        try {
            Graphic3DsOverlays graphic3DsOverlays = getObjById(graphic3DsOverlaysId);
            graphic3DsOverlays.remove(index);

            promise.resolve(true);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 移除所有覆盖物图层
     * @param graphic3DsOverlaysId
     * @param promise
     */
    @ReactMethod
    public void removeAll(String graphic3DsOverlaysId, Promise promise) {
        try {
            Graphic3DsOverlays graphic3DsOverlays = getObjById(graphic3DsOverlaysId);
            graphic3DsOverlays.removeAll();

            promise.resolve(true);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

}
