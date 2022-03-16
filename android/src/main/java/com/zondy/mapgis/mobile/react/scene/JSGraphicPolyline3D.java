package com.zondy.mapgis.mobile.react.scene;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.android.graphic.GraphicPolyline3D;

/**
 * @auther LiaoLiang on 20-8-15
 * @content 场景线图形
 */
public class JSGraphicPolyline3D extends JSGraphicMultiPoint3D {
    private static final String REACT_CLASS = "JSGraphicPolyline3D";

    @NonNull
    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public JSGraphicPolyline3D(@NonNull ReactApplicationContext reactContext) {
        super(reactContext);
    }

    /**
     * 构造一个新的 GraphicPolyline3D 对象
     * @param promise
     */
    @ReactMethod
    public void createObj(Promise promise) {
        try {
            GraphicPolyline3D graphicPolyline3D = new GraphicPolyline3D();
            String graphicPolyline3DId = registerId(graphicPolyline3D);

            WritableMap map = Arguments.createMap();
            map.putString("graphicPolyline3DId", graphicPolyline3DId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取线的长度
     * @param graphicPolyline3DId
     * @param promise
     */
    @ReactMethod
    public void getLength(String graphicPolyline3DId, Promise promise) {
        try {
            GraphicPolyline3D graphicPolyline3D = (GraphicPolyline3D) getObjById(graphicPolyline3DId);
            double length = graphicPolyline3D.getLength();
            promise.resolve(length);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取线宽
     * @param graphicPolyline3DId
     * @param promise
     */
    @ReactMethod
    public void getLineWidth(String graphicPolyline3DId, Promise promise) {
        try {
            GraphicPolyline3D graphicPolyline3D = (GraphicPolyline3D) getObjById(graphicPolyline3DId);
            double lineWidth = graphicPolyline3D.getLineWidth();

            promise.resolve(lineWidth);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 设置线宽
     * @param graphicPolyline3DId
     * @param lineWidth
     * @param promise
     */
    @ReactMethod
    public void setLineWidth(String graphicPolyline3DId, double lineWidth, Promise promise) {
        try {
            GraphicPolyline3D graphicPolyline3D = (GraphicPolyline3D) getObjById(graphicPolyline3DId);
            graphicPolyline3D.setLineWidth(lineWidth);

            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

}
