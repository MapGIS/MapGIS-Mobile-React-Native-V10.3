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
import com.zondy.mapgis.android.sceneview.GeoElement;
import com.zondy.mapgis.android.sceneview.IdentifyLayerResult;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @auther LiaoLiang on 20-8-4
 * @content
 */
public class JSIdentifyLayerResult extends ReactContextBaseJavaModule {
    private static final String REACT_CLASS = "JSIdentifyLayerResult";
    private static String Tag = "JSIdentifyLayerResult";
    private static Map<String, IdentifyLayerResult> identifyLayerResultList = new HashMap<>();

    @NonNull
    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public JSIdentifyLayerResult(@NonNull ReactApplicationContext reactContext) {
        super(reactContext);
    }

    /**
     * 在native层注册一个IdentifyLayerResult的id,并返回该id供JS层调用。
     * 注册前先判断该IdentifyLayerResult是否已经存在，如果存在，返回已经存在的ID，如果不存在，创建新的ID以返回。
     * @param identifyLayerResult
     * @return
     */
    public static String registerId(IdentifyLayerResult identifyLayerResult) {
        for (Map.Entry entry : identifyLayerResultList.entrySet()) {
            if (identifyLayerResult.equals(entry.getValue())) {
                return (String) entry.getKey();
            }
        }
        String id = UUID.randomUUID().toString().substring(24);
        identifyLayerResultList.put(id,identifyLayerResult);
        Log.i(Tag,"id:"+id);
        return id;
    }

    /**
     * 根据id获取IdentifyLayerResult实例
     * @param id
     * @return
     */
    public static IdentifyLayerResult getObjById(String id) {
        return identifyLayerResultList.get(id);
    }

    /**
     * 构造一个新的IdentifyLayerResult对象
     * @param promise
     */
    @ReactMethod
    public void createObj(Promise promise) {
        try {
            IdentifyLayerResult identifyLayerResult = new IdentifyLayerResult();
            String identifyLayerResultId = registerId(identifyLayerResult);

            WritableMap map = Arguments.createMap();
            map.putString("identifyLayerResultId", identifyLayerResultId);
            promise.resolve(map);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取拾取到的要素
     * @param identifyLayerResultId
     * @param promise
     */
    @ReactMethod
    public void getElements(String identifyLayerResultId, Promise promise) {
        try {
            IdentifyLayerResult identifyLayerResult = getObjById(identifyLayerResultId);
            List<GeoElement> geoElements = identifyLayerResult.getElements();
            WritableArray array = Arguments.createArray();
            for (GeoElement geoElement : geoElements) {
                String geoElementId = JSGeoElement.registerId(geoElement);
                array.pushString(geoElementId);
            }

            promise.resolve(array);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 返回错误信息
     * @param identifyLayerResultId
     * @param promise
     */
    @ReactMethod
    public void getError(String identifyLayerResultId, Promise promise) {
        try {
            IdentifyLayerResult identifyLayerResult = getObjById(identifyLayerResultId);
            String error = identifyLayerResult.getError();

            promise.resolve(error);
        }catch (Exception e) {
            promise.reject(e);
        }
    }
}
