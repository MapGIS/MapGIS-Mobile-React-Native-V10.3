package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.core.geometry.IntUser;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 整数对象Native功能组件
 * Created by xiaoying on 2019/9/4.
 */
public class JSIntUser extends ReactContextBaseJavaModule {
    private static final String REACT_CLASS = "JSIntUser";
    private static Map<String, IntUser> mIntUserList = new HashMap<>();

    public JSIntUser(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public static IntUser getObjFromList(String id){
        return mIntUserList.get(id);
    }

    public static String registerId(IntUser obj){
        for (Map.Entry entry : mIntUserList.entrySet()) {
            if (obj.equals(entry.getValue())) {
                String id = (String) entry.getKey();
                return id;
            }
        }

        String id = UUID.randomUUID().toString().substring(24);
        mIntUserList.put(id, obj);
        return id;
    }

    @ReactMethod
    public void createObj(Promise promise){
        try {
            IntUser intUser = new IntUser();
            String intUserId = registerId(intUser);

            WritableMap writableMap = Arguments.createMap();
            writableMap.putString("IntUserId", intUserId);
            promise.resolve(writableMap);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void createObj(int value, Promise promise){
        try {
            IntUser intUser = new IntUser(value);
            String intUserId = registerId(intUser);

            WritableMap writableMap = Arguments.createMap();
            writableMap.putString("IntUserId", intUserId);
            promise.resolve(writableMap);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setValue(String intUserId, int value, Promise promise){
        try {
            IntUser intUser = getObjFromList(intUserId);
            intUser.setValue(value);

            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getValue(String intUserId, Promise promise){
        try {
            IntUser intUser = getObjFromList(intUserId);
            int value = intUser.getValue();

            promise.resolve(value);
        }catch (Exception e){
            promise.reject(e);
        }
    }
}
