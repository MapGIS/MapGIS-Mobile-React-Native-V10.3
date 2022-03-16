package com.zondy.mapgis.mobile.react.scene;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.zondy.mapgis.android.sceneview.FlyManager;
import com.zondy.mapgis.android.sceneview.FlyStatus;
import com.zondy.mapgis.android.sceneview.SceneView;

/**
 * @auther LiaoLiang on 20-7-28
 * @content 飞行监听
 */
public class FlyManagerListener implements FlyManager.StatusChangedListener {

    private ReactContext reactContext;
    private FlyManager flyManager;

    private static final String STATUSCHANGED_EVENT = "com.mapgis.RN.FlyManager.statuschanged_event";

    public FlyManagerListener(FlyManager flyManager, ReactContext reactContext) {
        this.reactContext = reactContext;
        this.flyManager = flyManager;
    }

    private void sendEvent(FlyManager flyManager, String eventName, WritableMap params) {

        reactContext
                .getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
                .emit(eventName, params);

    }
    @Override
    public void onStatusChanged(FlyStatus flyStatus) {
        WritableMap writableMap = Arguments.createMap();
        writableMap.putInt("flyStatus",flyStatus.value());
        sendEvent(flyManager,STATUSCHANGED_EVENT,writableMap);
    }
}
