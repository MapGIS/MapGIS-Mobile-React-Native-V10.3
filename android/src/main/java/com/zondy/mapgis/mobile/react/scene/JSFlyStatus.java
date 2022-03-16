package com.zondy.mapgis.mobile.react.scene;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.zondy.mapgis.android.sceneview.FlyStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * @auther LiaoLiang on 20-7-28
 * @content 飞行状态类 该类包含了三种飞行状态，每一种状态表示一种当前的飞行行为
 */
public class JSFlyStatus extends ReactContextBaseJavaModule {
    private static final String REACT_CLASS = "JSFlyStatus";

    private static final String PAUSE = "PAUSE"; //当前飞行暂停了，设置Play可以按照当前的所有设置继续飞行
    private static final String PLAY = "PLAY"; //当前正在飞行中
    private static final String STOP = "STOP"; //当前飞行已经停止了

    public JSFlyStatus(@NonNull ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @NonNull
    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Nullable
    @Override
    public Map<String, Object> getConstants() {
        Map<String,Object> constants = new HashMap<>();
        constants.put(PAUSE, FlyStatus.PAUSE.value());
        constants.put(PLAY, FlyStatus.PLAY.value());
        constants.put(STOP, FlyStatus.STOP.value());
        return constants;
    }
}
