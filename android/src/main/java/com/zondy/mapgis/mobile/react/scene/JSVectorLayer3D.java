package com.zondy.mapgis.mobile.react.scene;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.core.geometry.Rect;
import com.zondy.mapgis.core.scene.VectorLayer3D;
import com.zondy.mapgis.mobile.react.JSRect;


/**
 * @auther LiaoLiang on 20-7-8
 * @content 三维矢量图层类，通过该类可以向场景中添加矢量图层
 */
public class JSVectorLayer3D extends JSLayer3D {
    private static final String REACT_CLASS = "JSVectorLayer3D";
    @NonNull
    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public JSVectorLayer3D(@NonNull ReactApplicationContext reactContext) {
        super(reactContext);
    }

    /**
     * 构造一个新的VectorLayer3D对象
     * @param promise
     */
    @ReactMethod
    public void createObj(Promise promise) {
        try {
            VectorLayer3D vectorLayer3D = new VectorLayer3D();
            String vectorLayer3DId = registerId(vectorLayer3D);

            WritableMap map = Arguments.createMap();
            map.putString("vectorLayer3DId", vectorLayer3DId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取图层样式文档路径
     * @param vectorLayer3DId
     * @param promise
     */
    @ReactMethod
    public void getConfigFile(String vectorLayer3DId, Promise promise){
        try {
            VectorLayer3D vectorLayer3D = (VectorLayer3D) getObjById(vectorLayer3DId);
            String configFilePath = vectorLayer3D.getConfigFile();

            promise.resolve(configFilePath);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取图层范围
     * @param vectorLayer3DId
     * @param rectId
     * @param promise
     */
    @ReactMethod
    public void getExtent(String vectorLayer3DId, String rectId, Promise promise) {
        try {
            VectorLayer3D vectorLayer3D = (VectorLayer3D) getObjById(vectorLayer3DId);
            Rect rect = JSRect.getObjFromList(rectId);
            int result = vectorLayer3D.getExtent(rect); //1-成功；0-失败

            promise.resolve(result);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     *获取图层显示的透明度
     * @param vectorLayer3DId
     * @param sAlpha 透明度，值为0-100，其中0为不透明
     * @param promise
     */
    @ReactMethod
    public void getTransparency(String vectorLayer3DId, int sAlpha, Promise promise) {
        try {
            VectorLayer3D vectorLayer3D = (VectorLayer3D) getObjById(vectorLayer3DId);
            int result = vectorLayer3D.getTransparency((short) sAlpha); //1-成功；0-失败

            promise.resolve(result);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取图层类型的值
     * @param vectorLayer3DId
     * @param promise
     */
    @ReactMethod
    public void getType(String vectorLayer3DId, Promise promise) {
        try {
            VectorLayer3D vectorLayer3D = (VectorLayer3D) getObjById(vectorLayer3DId);
            int typeValue = vectorLayer3D.getType().value();

            promise.resolve(typeValue);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取图层是否应用光照
     * @param vectorLayer3DId
     * @param promise
     */
    @ReactMethod
    public void	isLightingEnabled(String vectorLayer3DId, Promise promise) {
        try {
            VectorLayer3D vectorLayer3D = (VectorLayer3D) getObjById(vectorLayer3DId);
            boolean isLightingEnabledResult = vectorLayer3D.isLightingEnabled(); //true: 开启光照，false：关闭光照

            promise.resolve(isLightingEnabledResult);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 设置图层样式文档路径
     * @param vectorLayer3DId
     * @param configFilePath 文档路径
     * @param promise
     */
    @ReactMethod
    public  void  setConfigFile(String vectorLayer3DId, String configFilePath, Promise promise) {
        try {
            VectorLayer3D vectorLayer3D = (VectorLayer3D) getObjById(vectorLayer3DId);
            vectorLayer3D.setConfigFile(configFilePath);

            promise.resolve(true);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 设置图层是否应用光照(该图层的光照开启与否将不再受SetSunLightingMode函数的影响)
     * @param vectorLayer3DId
     * @param value
     * @param promise
     */
    @ReactMethod
    public void setLightingEnabled(String vectorLayer3DId, boolean value, Promise promise) {
        try {
            VectorLayer3D vectorLayer3D = (VectorLayer3D) getObjById(vectorLayer3DId);
            vectorLayer3D.setLightingEnabled(value);

            promise.resolve(true);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 设置图层显示的透明度
     * @param vectorLayer3DId
     * @param sAlpha
     * @param promise
     */
    @ReactMethod
    public void setTransparency(String vectorLayer3DId, int sAlpha, Promise promise) {
        try {
            VectorLayer3D vectorLayer3D = (VectorLayer3D) getObjById(vectorLayer3DId);
            int result = vectorLayer3D.setTransparency((short) sAlpha); //1-成功；0-失败

            promise.resolve(result);
        }catch (Exception e) {
            promise.reject(e);
        }
    }
}
