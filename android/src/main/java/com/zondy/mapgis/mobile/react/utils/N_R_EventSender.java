package com.zondy.mapgis.mobile.react.utils;

import androidx.annotation.Nullable;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fjl 2019-6-16 下午2:52:36
 * @content 事件发送类
 */
public class N_R_EventSender {
    Map<String, String> stringMap;
    Map<String, Double> doubleMap;

    public N_R_EventSender() {
        stringMap = new HashMap<String, String>();
        doubleMap = new HashMap<String, Double>();
    }

    public void putString(String key, String value) {
        stringMap.put(key, value);
    }


    public WritableMap createSender() {
        WritableMap idSet = Arguments.createMap();
        if (!stringMap.isEmpty()) {
            for (Map.Entry entry : stringMap.entrySet()) {
                idSet.putString(entry.getKey().toString(), entry.getValue().toString());
            }
        }
        return idSet;
    }

    public static void sendEvent(ReactContext reactContext,
                                 String eventName,
                                 @Nullable WritableMap params) {
        reactContext
                .getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
                .emit(eventName, params);
    }

    public static void sendEvent(ReactContext reactContext,
                                 String eventName,
                                 @Nullable WritableArray params) {
        reactContext
                .getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
                .emit(eventName, params);
    }
}
