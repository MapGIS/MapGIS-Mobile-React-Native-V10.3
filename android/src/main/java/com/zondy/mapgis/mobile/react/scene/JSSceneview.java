package com.zondy.mapgis.mobile.react.scene;

import android.util.Log;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.android.graphic.Graphic3DsOverlay;
import com.zondy.mapgis.android.sceneview.FlyManager;
import com.zondy.mapgis.android.sceneview.IdentifyLayerResult;
import com.zondy.mapgis.android.sceneview.SceneView;
import com.zondy.mapgis.android.sceneview.SunLightingMode;
import com.zondy.mapgis.core.geometry.Dot;
import com.zondy.mapgis.core.object.Enumeration;
import com.zondy.mapgis.core.scene.Layer3D;
import com.zondy.mapgis.core.scene.Scene;
import com.zondy.mapgis.core.viewpoint.Viewpoint;
import com.zondy.mapgis.mobile.react.JSDot;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @auther LiaoLiang on 20-6-23
 * @content 三维视图组件
 */
public class JSSceneview extends ReactContextBaseJavaModule {
    private static final String REACT_CLASS = "JSSceneview";
    private static String Tag = "JSSceneview";
    private static Map<String, SceneView> sceneViewList = new HashMap<>();
    private static ReactApplicationContext context;

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public JSSceneview(ReactApplicationContext reactContext) {
        super(reactContext);
        context = reactContext;
    }

    /**
     * 在native层注册一个SceneView的id,并返回该id供JS层调用。
     * 注册前先判断该SceneView是否已经存在，如果存在，返回已经存在的ID，如果不存在，创建新的ID以返回。
     *
     * @param sceneView
     * @return
     */
    public static String registerId(SceneView sceneView) {
        for (Map.Entry entry : sceneViewList.entrySet()) {
            if (sceneView.equals(entry.getValue())) {
                return (String) entry.getKey();
            }
        }
        String id = UUID.randomUUID().toString().substring(24);
        sceneViewList.put(id, sceneView);
        Log.i(Tag, "id:" + id);
        return id;
    }

    /**
     * 根据id获取SceneView实例
     *
     * @param id
     * @return
     */
    public static SceneView getObjById(String id) {
        return sceneViewList.get(id);
    }

    /**
     * 构造一个新的SceneView对象
     *
     * @param promise
     */
    @ReactMethod
    public void createObj(Promise promise) {
        try {
            SceneView sceneView = new SceneView(context);
            String sceneViewId = registerId(sceneView);

            WritableMap map = Arguments.createMap();
            map.putString("sceneViewId", sceneViewId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void reset(String sceneViewId, Promise promise) {
        try {
            SceneView sceneView = getObjById(sceneViewId);
            sceneView.reset();
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getFlyManager(String sceneViewID, Promise promise) {
        try {
            SceneView sceneView = getObjById(sceneViewID);
            FlyManager flyManager = sceneView.getFlyManager();
            String flyManagerID = JSFlyManager.registerId(flyManager);
            WritableMap map = Arguments.createMap();
            map.putString("flyManagerId", flyManagerID);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }


    /**
     * 设置光照模式
     * 成功返回1,失败返回0
     *
     * @param sceneViewId
     * @param sunLightingMode
     * @param promise
     */
    @ReactMethod
    public void setSunLightingMode(String sceneViewId, int sunLightingMode, Promise promise) {
        try {
            SceneView sceneView = getObjById(sceneViewId);
            int result = sceneView.setSunLightingMode((SunLightingMode) Enumeration.parse(SunLightingMode.class, sunLightingMode));
            promise.resolve(result);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取光照模式
     *
     * @param sceneViewId
     * @param promise
     */
    @ReactMethod
    public void getSunLightingMode(String sceneViewId, Promise promise) {
        try {
            SceneView sceneView = getObjById(sceneViewId);
            SunLightingMode sunLightingMode = sceneView.getSunLightingMode();
            int sunLightingModeValue = sunLightingMode.value();

            promise.resolve(sunLightingModeValue);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 设置场景 ，异步方法
     *
     * @param sceneViewId
     * @param sceneId
     * @param promise
     */
    @ReactMethod
    public void setSceneAsync(String sceneViewId, String sceneId, final Promise promise) {
        try {
            SceneView sceneView = getObjById(sceneViewId);
            Scene scene = JSScene.getObjById(sceneId);
            sceneView.setSceneAsync(scene, new SceneView.SceneFinishCallback() {
                @Override
                public void onDidFinish(boolean b) {
                    if (b) {
                        Log.i(Tag, "为场景视图设置场景成功");
                    } else {
                        Log.i(Tag, "为场景视图设置场景失败");
                    }
                    promise.resolve(b);
                }
            });
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 设置是否开启自动裁剪
     *
     * @param sceneViewId
     * @param enableAutoClipPlane
     * @param promise
     */
    @ReactMethod
    public void setAutoClipPlaneEnabled(String sceneViewId, boolean enableAutoClipPlane, Promise promise) {
        try {
            SceneView sceneView = getObjById(sceneViewId);
            sceneView.setAutoClipPlaneEnabled(enableAutoClipPlane);

            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 跳转到指定视点
     *
     * @param sceneViewId
     * @param viewPointId 要跳转到的视点id
     * @param durationSec 持续时间，单位秒
     * @param promise
     */
    @ReactMethod
    public void jumptoViewPoint(String sceneViewId, String viewPointId, double durationSec, Promise promise) {
        try {
            SceneView sceneView = getObjById(sceneViewId);
            Viewpoint viewpoint = JSViewpoint.getObjById(viewPointId);
            int result = sceneView.jumptoViewPoint(viewpoint, durationSec); //成功返回1,失败返回0

            promise.resolve(result);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 返回拾取结果的id
     *
     * @param sceneViewId
     * @param layer3DId     需要拾取的图层的id
     * @param screenPointId 屏幕坐标
     * @param tolerance     容差
     * @param maxResult     最大结果返回数
     * @param promise
     */
    @ReactMethod
    public void identifyLayer(String sceneViewId, String layer3DId, String screenPointId,
                              double tolerance, int maxResult, Promise promise) {
        try {
            SceneView sceneView = getObjById(sceneViewId);
            Layer3D layer3D = JSLayer3D.getObjById(layer3DId);
            Dot screenPoint = JSDot.getObjFromList(screenPointId);
            IdentifyLayerResult identifyLayerResult = sceneView.identifyLayer(layer3D, screenPoint, tolerance, maxResult);
            String identifyLayerResultId = JSIdentifyLayerResult.registerId(identifyLayerResult);

            promise.resolve(identifyLayerResultId);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void registerTapListener(String sceneViewId, Promise promise) {
        try {
            SceneView sceneView = getObjById(sceneViewId);
            SceneViewListener sceneViewListener = new SceneViewListener(sceneView, context);
            sceneView.setTapListener(sceneViewListener);

            promise.resolve(true);
        } catch (Exception e) {
            promise.resolve(e);
        }
    }

    @ReactMethod
    public void unregisterTapListener(String sceneViewId, Promise promise) {
        try {
            SceneView sceneView = getObjById(sceneViewId);
            sceneView.setTapListener(null);

            promise.resolve(true);
        } catch (Exception e) {
            promise.resolve(e);
        }
    }

    @ReactMethod
    public void getDefaultGraphics3DOverlay(String sceneViewID, Promise promise) {
        try {
            SceneView sceneView = getObjById(sceneViewID);
            Graphic3DsOverlay graphic3DsOverlay = sceneView.getDefaultGraphics3DOverlay();
            String id = JSGraphic3DsOverlay.registerId(graphic3DsOverlay);
            promise.resolve(id);
        } catch (Exception e) {
            promise.reject(e);
        }
    }


}
