package com.zondy.mapgis.mobile.react.scene;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.android.graphic.GraphicPoint3D;
import com.zondy.mapgis.core.geometry.Dot3D;
import com.zondy.mapgis.mobile.react.JSDot3D;

/**
 * @auther LiaoLiang on 20-8-15
 * @content 场景点图形
 */
public class JSGraphicPoint3D extends JSGraphic3D {
    private static final String REACT_CLASS = "JSGraphicPoint3D";

    @NonNull
    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public JSGraphicPoint3D(@NonNull ReactApplicationContext reactContext) {
        super(reactContext);
    }

    /**
     * 构造一个新的 GraphicPoint3D 对象
     * @param promise
     */
    @ReactMethod
    public void createObj(Promise promise) {
        try {
            GraphicPoint3D graphicPoint3D = new GraphicPoint3D();
            String graphicPoint3DId = registerId(graphicPoint3D);

            WritableMap map = Arguments.createMap();
            map.putString("graphicPoint3DId", graphicPoint3DId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取点的位置的id
     * @param graphicPoint3DId
     * @param promise
     */
    @ReactMethod
    public void getPoint(String graphicPoint3DId, Promise promise) {
        try {
            GraphicPoint3D graphicPoint3D = (GraphicPoint3D) getObjById(graphicPoint3DId);
            Dot3D dot3D = graphicPoint3D.getPoint();
            String pointId = JSDot3D.registerId(dot3D);

            promise.resolve(pointId);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取点的大小
     * @param graphicPoint3DId
     * @param promise
     */
    @ReactMethod
    public void getSize(String graphicPoint3DId, Promise promise) {
        try {
            GraphicPoint3D graphicPoint3D = (GraphicPoint3D) getObjById(graphicPoint3DId);
            double size = graphicPoint3D.getSize();

            promise.resolve(size);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 设置点的位置
     * @param graphicPoint3DId
     * @param pointId
     * @param promise
     */
    @ReactMethod
    public void setPoint(String graphicPoint3DId, String pointId, Promise promise) {
        try {
            GraphicPoint3D graphicPoint3D = (GraphicPoint3D) getObjById(graphicPoint3DId);
            Dot3D point = JSDot3D.getObjFromList(pointId);
            graphicPoint3D.setPoint(point);

            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 设置点的位置及大小
     * @param graphicPoint3DId
     * @param pointId
     * @param size
     * @param promise
     */
    @ReactMethod
    public void setPointAndSize(String graphicPoint3DId, String pointId, double size, Promise promise) {
        try {
            GraphicPoint3D graphicPoint3D = (GraphicPoint3D) getObjById(graphicPoint3DId);
            Dot3D point = JSDot3D.getObjFromList(pointId);
            graphicPoint3D.setPointAndSize(point, size);

            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     *设置点的大小
     * @param graphicPoint3DId
     * @param size
     * @param promise
     */
    @ReactMethod
    public void setSize(String graphicPoint3DId, double size, Promise promise) {
        try {
            GraphicPoint3D graphicPoint3D = (GraphicPoint3D) getObjById(graphicPoint3DId);
            graphicPoint3D.setSize(size);

            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }
}
