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
import com.zondy.mapgis.android.graphic.Graphic3D;
import com.zondy.mapgis.android.graphic.Graphic3DsOverlay;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @auther LiaoLiang on 20-8-10
 * @content 场景覆盖物
 */
public class JSGraphic3DsOverlay extends ReactContextBaseJavaModule {
    private static final String REACT_CLASS = "JSGraphic3DsOverlay";
    private static String Tag = "JSGraphic3DsOverlay";
    private static Map<String, Graphic3DsOverlay> graphic3DsOverlayList = new HashMap<>();

    @NonNull
    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public JSGraphic3DsOverlay(@NonNull ReactApplicationContext reactContext) {
        super(reactContext);
    }

    /**
     * 在native层注册一个Graphic3DsOverlay的id,并返回该id供JS层调用。
     * 注册前先判断该Graphic3DsOverlay是否已经存在，如果存在，返回已经存在的ID，如果不存在，创建新的ID以返回。
     * @param graphic3DsOverlay
     * @return
     */
    public static String registerId(Graphic3DsOverlay graphic3DsOverlay) {
        for (Map.Entry entry : graphic3DsOverlayList.entrySet()) {
            if (graphic3DsOverlay.equals(entry.getValue())) {
                return (String) entry.getKey();
            }
        }
        String id = UUID.randomUUID().toString().substring(24);
        graphic3DsOverlayList.put(id,graphic3DsOverlay);
        Log.i(Tag,"id:"+id);
        return id;
    }

    /**
     * 根据id获取Graphic3DsOverlay实例
     * @param id
     * @return
     */
    public static Graphic3DsOverlay getObjById(String id) {
        return graphic3DsOverlayList.get(id);
    }

    /**
     * 构造一个新的Graphic3DsOverlay对象
     * @param promise
     */
    @ReactMethod
    public void createObj(Promise promise) {
        try {
            Graphic3DsOverlay graphic3DsOverlay = new Graphic3DsOverlay();
            String graphic3DsOverlayId = registerId(graphic3DsOverlay);

            WritableMap writableMap = Arguments.createMap();
            writableMap.putString("graphic3DsOverlayId",graphic3DsOverlayId);
            promise.resolve(writableMap);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 添加一个图形
     * @param graphic3DsOverlayId
     * @param graphic3DId 图形id
     * @param promise
     */
    @ReactMethod
    public void addGraphic(String graphic3DsOverlayId, String graphic3DId, Promise promise) {
        try {
            Graphic3DsOverlay graphic3DsOverlay = getObjById(graphic3DsOverlayId);
            Graphic3D graphic3D = JSGraphic3D.getObjById(graphic3DId);

            int result = graphic3DsOverlay.addGraphic(graphic3D);
            promise.resolve(result);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     *
     * @param graphic3DsOverlayId
     * @param graphicHandle
     * @param promise
     */
    @ReactMethod
    public void createGraphic(String graphic3DsOverlayId, String graphicHandle, Promise promise) {
        try {
            Graphic3DsOverlay graphic3DsOverlay = getObjById(graphic3DsOverlayId);
            Graphic3D graphic3D = graphic3DsOverlay.createGraphic(Long.parseLong(graphicHandle));
            String graphic3DId = JSGraphic3D.registerId(graphic3D);

            promise.resolve(graphic3DId);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 返回所有图形的id
     * @param graphic3DsOverlayId
     * @param promise
     */
    @ReactMethod
    public void getAllGraphics3D(String graphic3DsOverlayId, Promise promise) {
        try {
            Graphic3DsOverlay graphic3DsOverlay = getObjById(graphic3DsOverlayId);
            List<Graphic3D> graphic3DS = graphic3DsOverlay.getAllGraphics3D();
            WritableArray graphic3DIds = Arguments.createArray();
            for (Graphic3D graphic3D : graphic3DS) {
                graphic3DIds.pushString(JSGraphic3D.registerId(graphic3D));
            }

            promise.resolve(graphic3DIds);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取指定索引的图形
     * @param graphic3DsOverlayId
     * @param index
     * @param promise
     */
    @ReactMethod
    public void getGraphic(String graphic3DsOverlayId, int index, Promise promise) {
        try {
            Graphic3DsOverlay graphic3DsOverlay = getObjById(graphic3DsOverlayId);
            Graphic3D graphic3D = graphic3DsOverlay.getGraphic(index);
            String graphic3DId = JSGraphic3D.registerId(graphic3D);

            promise.resolve(graphic3DId);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 返回所有图形的数目
     * @param graphic3DsOverlayId
     * @param promise
     */
    @ReactMethod
    public void getGraphicCount(String graphic3DsOverlayId, Promise promise) {
        try {
            Graphic3DsOverlay graphic3DsOverlay = getObjById(graphic3DsOverlayId);
            int graphicCount = graphic3DsOverlay.getGraphicCount();

            promise.resolve(graphicCount);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取指定属性的图形的id
     * @param graphic3DsOverlayId
     * @param name
     * @param value
     * @param promise
     */
    @ReactMethod
    public void getGraphicsByAttribute(String graphic3DsOverlayId, String name, String value, Promise promise) {
        try {
            Graphic3DsOverlay graphic3DsOverlay = getObjById(graphic3DsOverlayId);
            List<Graphic3D> graphic3DS = graphic3DsOverlay.getGraphicsByAttribute(name, value);
            WritableArray graphic3DIds = Arguments.createArray();
            for (Graphic3D graphic3D : graphic3DS) {
                graphic3DIds.pushString(JSGraphic3D.registerId(graphic3D));
            }

            promise.resolve(graphic3DIds);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取层名称
     * @param graphic3DsOverlayId
     * @param promise
     */
    @ReactMethod
    public void getName(String graphic3DsOverlayId, Promise promise) {
        try {
            Graphic3DsOverlay graphic3DsOverlay = getObjById(graphic3DsOverlayId);
            String name = graphic3DsOverlay.getName();

            promise.resolve(name);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取图形层的可见状态,返回层的状态 STATE_VISIBLE STATE_UNVISIBLE
     * @param graphic3DsOverlayId
     * @param promise
     */
    @ReactMethod
    public void getState(String graphic3DsOverlayId, Promise promise) {
        try {
            Graphic3DsOverlay graphic3DsOverlay = getObjById(graphic3DsOverlayId);
            int state = graphic3DsOverlay.getState();

            promise.resolve(state);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取指定图形的索引
     * @param graphic3DsOverlayId
     * @param graphic3DId 指定图形的id
     * @param promise
     */
    @ReactMethod
    public void indexOf(String graphic3DsOverlayId, String graphic3DId, Promise promise) {
        try {
            Graphic3DsOverlay graphic3DsOverlay = getObjById(graphic3DsOverlayId);
            Graphic3D graphic3D = JSGraphic3D.getObjById(graphic3DId);
            int index = graphic3DsOverlay.indexOf(graphic3D);

            promise.resolve(index);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 插入一个图形
     * @param graphic3DsOverlayId
     * @param index 图形索引
     * @param graphic3DId 图形id
     * @param promise
     */
    @ReactMethod
    public void insertGraphic(String graphic3DsOverlayId, int index, String graphic3DId, Promise promise) {
        try {
            Graphic3DsOverlay graphic3DsOverlay = getObjById(graphic3DsOverlayId);
            Graphic3D graphic3D = JSGraphic3D.getObjById(graphic3DId);
            int result = graphic3DsOverlay.insertGraphic(index,graphic3D);

            promise.resolve(result);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 移动一个图形
     * @param graphic3DsOverlayId
     * @param fromIndex
     * @param toIndex
     * @param promise
     */
    @ReactMethod
    public void moveGraphic(String graphic3DsOverlayId, int fromIndex, int toIndex, Promise promise) {
        try {
            Graphic3DsOverlay graphic3DsOverlay = getObjById(graphic3DsOverlayId);
            graphic3DsOverlay.moveGraphic(fromIndex, toIndex);

            promise.resolve(true);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 删除一组图形
     * @param graphic3DsOverlayId
     * @param promise
     */
    @ReactMethod
    public void removeAllGraphics(String graphic3DsOverlayId, Promise promise) {
        try {
            Graphic3DsOverlay graphic3DsOverlay = getObjById(graphic3DsOverlayId);
            graphic3DsOverlay.removeAllGraphics();

            promise.resolve(true);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 移除一个图形
     * @param graphic3DsOverlayId
     * @param graphic3DId
     * @param promise
     */
    @ReactMethod
    public void removeGraphic(String graphic3DsOverlayId, String graphic3DId, Promise promise) {
        try {
            Graphic3DsOverlay graphic3DsOverlay = getObjById(graphic3DsOverlayId);
            Graphic3D graphic3D = JSGraphic3D.getObjById(graphic3DId);
            graphic3DsOverlay.removeGraphic(graphic3D);

            promise.resolve(true);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 移除指定索引的图形
     * @param graphic3DsOverlayId
     * @param index
     * @param promise
     */
    @ReactMethod
    public void removeGraphicByIndex(String graphic3DsOverlayId, int index, Promise promise) {
        try {
            Graphic3DsOverlay graphic3DsOverlay = getObjById(graphic3DsOverlayId);
            graphic3DsOverlay.removeGraphic(index);

            promise.resolve(true);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 删除指定属性的图形
     * @param graphic3DsOverlayId
     * @param name
     * @param value
     * @param promise
     */
    @ReactMethod
    public void removeGraphicByAttribute(String graphic3DsOverlayId, String name, String value, Promise promise) {
        try {
            Graphic3DsOverlay graphic3DsOverlay = getObjById(graphic3DsOverlayId);
            graphic3DsOverlay.removeGraphicByAttribute(name, value);

            promise.resolve(true);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 设置层名称
     * @param graphic3DsOverlayId
     * @param name
     * @param promise
     */
    @ReactMethod
    public void setName(String graphic3DsOverlayId, String name, Promise promise) {
        try {
            Graphic3DsOverlay graphic3DsOverlay = getObjById(graphic3DsOverlayId);
            graphic3DsOverlay.setName(name);

            promise.resolve(true);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 设置图形层的可见状态
     * @param graphic3DsOverlayId
     * @param state
     * @param promise
     */
    @ReactMethod
    public void setState(String graphic3DsOverlayId, int state, Promise promise) {
        try {
            Graphic3DsOverlay graphic3DsOverlay = getObjById(graphic3DsOverlayId);
            graphic3DsOverlay.setState(state);

            promise.resolve(true);
        }catch (Exception e) {
            promise.reject(e);
        }
    }
}
