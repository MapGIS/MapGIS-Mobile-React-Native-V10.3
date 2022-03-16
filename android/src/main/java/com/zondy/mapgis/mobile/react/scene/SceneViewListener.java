package com.zondy.mapgis.mobile.react.scene;

import android.graphics.PointF;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.zondy.mapgis.android.mapview.MapView;
import com.zondy.mapgis.android.sceneview.SceneView;
import com.zondy.mapgis.core.geometry.Dot;
import com.zondy.mapgis.core.geometry.Dot3D;

/**
 * @auther LiaoLiang on 20-8-4
 * @content 场景视图监听
 */
public class SceneViewListener implements SceneView.SceneViewTapListener {
    private ReactContext reactContext;
    private SceneView mSceneView;

    private static final String SINGLE_TAP_EVENT = "com.mapgis.RN.Sceneview.single_tap_event";

    public SceneViewListener(SceneView mSceneView, ReactContext reactContext) {
        this.reactContext = reactContext;
        this.mSceneView = mSceneView;
    }

    private void sendEvent(SceneView sceneView, String eventName, WritableMap params) {

        reactContext
                .getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
                .emit(eventName, params);

    }

    @Override
    public void sceneViewTap(PointF pointF) {
        MapView mapView = new MapView(reactContext);
        Dot screenPoint = mapView.viewPointToMapPoint(pointF);
        Dot3D dot3D =  mSceneView.screenToLocation(screenPoint);
        WritableMap writableMap = Arguments.createMap();
        writableMap.putDouble("x",dot3D.x);
        writableMap.putDouble("y",dot3D.y);
        writableMap.putDouble("z",dot3D.z);

        sendEvent(mSceneView,SINGLE_TAP_EVENT,writableMap);
    }
}
