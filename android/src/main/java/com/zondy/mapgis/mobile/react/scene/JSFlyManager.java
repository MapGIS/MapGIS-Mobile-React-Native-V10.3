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
import com.zondy.mapgis.android.sceneview.FlyManager;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @auther LiaoLiang on 20-7-28
 * @content 场景飞行管理类
 */
public class JSFlyManager extends ReactContextBaseJavaModule {
    private static final String REACT_CLASS = "JSFlyManager";
    private static final String Tag = "JSFlyManager";
    private static Map<String, FlyManager> flyManagerList = new HashMap<>();
    ReactContext mReactContext;

    public JSFlyManager(@NonNull ReactApplicationContext reactContext) {
        super(reactContext);
        mReactContext = reactContext;
    }

    @NonNull
    @Override
    public String getName() {
        return REACT_CLASS;
    }

    /**
     * 在native层注册一个FlyManager的id,并返回该id供JS层调用。
     * 注册前先判断该FlyManager是否已经存在，如果存在，返回已经存在的ID，如果不存在，创建新的ID以返回。
     * @param flyManager
     * @return
     */
    public static String registerId(FlyManager flyManager) {
        for (Map.Entry entry : flyManagerList.entrySet()) {
            if (flyManager.equals(entry.getValue())) {
                return (String) entry.getKey();
            }
        }
        String id = UUID.randomUUID().toString().substring(24);
        flyManagerList.put(id,flyManager);
        Log.i(Tag,"id:"+id);
        return id;
    }

    /**
     * 根据id获取FlyManager实例
     * @param id
     * @return
     */
    public static FlyManager getObjById(String id) {
        return flyManagerList.get(id);
    }

    /**
     * 构造一个新的Scene对象
     * @param promise
     */
    @ReactMethod
    public void createObj(Promise promise) {
        try {
            FlyManager flyManager = new FlyManager();
            String flyManagerId = registerId(flyManager);

            WritableMap map = Arguments.createMap();
            map.putString("flyManagerId", flyManagerId);
            promise.resolve(map);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 返回本次飞行（即当前整个路线）需要的总时间，单位为秒
     * @param flyManagerId
     * @param promise
     */
    @ReactMethod
    public void getDuration(String flyManagerId, Promise promise) {
        try {
            FlyManager flyManager = getObjById(flyManagerId);
            double duration = flyManager.getDuration();

            promise.resolve(duration);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取对象是否被释放
     * @param flyManagerId
     * @param promise
     */
    @ReactMethod
    public void getIsLoop(String flyManagerId, Promise promise) {
        try {
            FlyManager flyManager = getObjById(flyManagerId);
            boolean isLoop = flyManager.getIsLoop();

            promise.resolve(isLoop);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 返回本次飞行的当前进度，单位为秒
     * @param flyManagerId
     * @param promise
     */
    @ReactMethod
    public void getProgress(String flyManagerId, Promise promise) {
        try {
            FlyManager flyManager = getObjById(flyManagerId);
            double progress = flyManager.getProgress();

            promise.resolve(progress);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 加载文件路径
     * @param flyManagerId
     * @param strPath
     * @param promise
     */
    @ReactMethod
    public void loadAnimationsFromPat(String flyManagerId, String strPath, Promise promise) {
        try {
            FlyManager flyManager = getObjById(flyManagerId);
            flyManager.loadAnimationsFromPat(strPath);

            promise.resolve(true);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 暂停当前漫游，下次将从当前停止处漫游
     * @param flyManagerId
     * @param promise
     */
    @ReactMethod
    public void pause(String flyManagerId, Promise promise) {
        try {
            FlyManager flyManager = getObjById(flyManagerId);
            int result = flyManager.pause(); //成功返回1 ,失败返回0

            promise.resolve(result);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 重新开始漫游
     * @param flyManagerId
     * @param promise
     */
    @ReactMethod
    public void reStart(String flyManagerId, Promise promise) {
        try {
            FlyManager flyManager = getObjById(flyManagerId);
            int result = flyManager.reStart(); //成功返回1 ,失败返回0

            promise.resolve(result);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 继续漫游
     * @param flyManagerId
     * @param promise
     */
    @ReactMethod
    public void resume(String flyManagerId, Promise promise) {
        try {
            FlyManager flyManager = getObjById(flyManagerId);
            int result = flyManager.resume(); //成功返回1 ,失败返回0

            promise.resolve(result);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 释放对象所占用的资源
     * @param flyManagerId
     * @param isLoop
     * @param promise
     */
    @ReactMethod
    public void setIsLoop(String flyManagerId, boolean isLoop, Promise promise) {
        try {
            FlyManager flyManager = getObjById(flyManagerId);
            flyManager.setIsLoop(isLoop);

            promise.resolve(true);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 低速漫游
     * @param flyManagerId
     * @param promise
     */
    @ReactMethod
    public void slowDown(String flyManagerId, Promise promise) {
        try {
            FlyManager flyManager = getObjById(flyManagerId);
            int result = flyManager.slowDown(); //成功返回1 ,失败返回0

            promise.resolve(result);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 高速漫游
     * @param flyManagerId
     * @param promise
     */
    @ReactMethod
    public void speedUp(String flyManagerId, Promise promise) {
        try {
            FlyManager flyManager = getObjById(flyManagerId);
            int result = flyManager.speedUp(); //成功返回1 ,失败返回0

            promise.resolve(result);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 开始漫游，或继续进行中断的漫游
     * @param flyManagerId
     * @param promise
     */
    @ReactMethod
    public void start(String flyManagerId, Promise promise) {
        try {
            FlyManager flyManager = getObjById(flyManagerId);
            int result = flyManager.start(); //成功返回1 ,失败返回0

            promise.resolve(result);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 停止当前漫游，下次将从路线起始处漫游
     * @param flyManagerId
     * @param promise
     */
    @ReactMethod
    public void stop(String flyManagerId, Promise promise) {
        try {
            FlyManager flyManager = getObjById(flyManagerId);
            int result = flyManager.stop(); //成功返回1 ,失败返回0

            promise.resolve(result);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void registerStatusChangedListener(String flyManagerId, Promise promise) {
        try {
            FlyManager flyManager = getObjById(flyManagerId);
            FlyManagerListener sceneListener = new FlyManagerListener(flyManager, mReactContext);
            flyManager.setStatusChangedListener(sceneListener);

            promise.resolve(true);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void unregisterStatusChangedListener(String flyManagerId, Promise promise) {
        try {
            FlyManager flyManager = getObjById(flyManagerId);
            flyManager.setStatusChangedListener(null);

            promise.resolve(true);
        }catch (Exception e) {
            promise.reject(e);
        }
    }
}
