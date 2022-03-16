package com.zondy.mapgis.mobile.react.scene;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.android.graphic.GraphicMultiPoint3D;
import com.zondy.mapgis.core.geometry.Dot3D;
import com.zondy.mapgis.mobile.react.JSDot3D;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther LiaoLiang on 20-8-15
 * @content 场景点图形
 */
public class JSGraphicMultiPoint3D extends JSGraphic3D {
    private static final String REACT_CLASS = "JSGraphicMultiPoint3D";

    @NonNull
    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public JSGraphicMultiPoint3D(@NonNull ReactApplicationContext reactContext) {
        super(reactContext);
    }

    /**
     * 构造一个新的 GraphicMultiPoint3D 对象
     * @param promise
     */
    @ReactMethod
    public void createObj(Promise promise) {
        try {
            GraphicMultiPoint3D graphicMultiPoint3D = new GraphicMultiPoint3D();
            String graphicMultiPoint3DId = registerId(graphicMultiPoint3D);

            WritableMap map = Arguments.createMap();
            map.putString("graphicMultiPoint3DId", graphicMultiPoint3DId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     *追加点
     * @param graphicMultiPoint3DId
     * @param point3DId 场景地理坐标的id
     * @param promise
     */
    @ReactMethod
    public void appendPoint(String graphicMultiPoint3DId, String point3DId, Promise promise) {
        try {
            GraphicMultiPoint3D graphicMultiPoint3D = (GraphicMultiPoint3D) getObjById(graphicMultiPoint3DId);
            Dot3D dot3D = JSDot3D.getObjFromList(point3DId);
            int result = graphicMultiPoint3D.appendPoint(dot3D);

            promise.resolve(result);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 追加一组点
     * @param graphicMultiPoint3DId
     * @param points3DId 一组场景地理坐标的id
     * @param promise
     */
    @ReactMethod
    public void appendPoints(String graphicMultiPoint3DId, ReadableArray points3DId, Promise promise) {
        try {
            GraphicMultiPoint3D graphicMultiPoint3D = (GraphicMultiPoint3D) getObjById(graphicMultiPoint3DId);
            List<Dot3D> dot3DS = null;
            for (int i = 0; i < points3DId.size(); i++) {
                dot3DS.add(JSDot3D.getObjFromList(points3DId.getString(i)));
            }
            Dot3D[] dot3DSArray = new Dot3D[dot3DS.size()];
            graphicMultiPoint3D.appendPoints(dot3DS.toArray(dot3DSArray));

            promise.resolve(true);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取地理坐标点的id
     * @param graphicMultiPoint3DId
     * @param index
     * @param promise
     */
    @ReactMethod
    public void getPoint(String graphicMultiPoint3DId, int index, Promise promise) {
        try {
            GraphicMultiPoint3D graphicMultiPoint3D = (GraphicMultiPoint3D) getObjById(graphicMultiPoint3DId);
            Dot3D point = graphicMultiPoint3D.getPoint(index);
            String pointId = JSDot3D.registerId(point);

            promise.resolve(pointId);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取坐标点数目
     * @param graphicMultiPoint3DId
     * @param promise
     */
    @ReactMethod
    public void getPointCount(String graphicMultiPoint3DId, Promise promise) {
        try {
            GraphicMultiPoint3D graphicMultiPoint3D = (GraphicMultiPoint3D) getObjById(graphicMultiPoint3DId);
            int countNum = graphicMultiPoint3D.getPointCount();

            promise.resolve(countNum);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取一组坐标的id
     * @param graphicMultiPoint3DId
     * @param promise
     */
    @ReactMethod
    public void getPoints(String graphicMultiPoint3DId, Promise promise) {
        try {
            GraphicMultiPoint3D graphicMultiPoint3D = (GraphicMultiPoint3D) getObjById(graphicMultiPoint3DId);
            Dot3D[] dot3DS = graphicMultiPoint3D.getPoints();
            WritableArray array = Arguments.createArray();
            for (Dot3D dot3D : dot3DS) {
                array.pushString(JSDot3D.registerId(dot3D));
            }

            promise.resolve(array);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取点的大小
     * @param graphicMultiPoint3DId
     * @param promise
     */
    @ReactMethod
    public void getPointSize(String graphicMultiPoint3DId, Promise promise) {
        try {
            GraphicMultiPoint3D graphicMultiPoint3D = (GraphicMultiPoint3D) getObjById(graphicMultiPoint3DId);
            double pointSize = graphicMultiPoint3D.getPointSize();

            promise.resolve(pointSize);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 插入一个点
     * @param graphicMultiPoint3DId
     * @param index
     * @param point3DId 场景地理坐标的id
     * @param promise
     */
    @ReactMethod
    public void insertPoint(String graphicMultiPoint3DId, int index, String point3DId, Promise promise) {
        try {
            GraphicMultiPoint3D graphicMultiPoint3D = (GraphicMultiPoint3D) getObjById(graphicMultiPoint3DId);
            Dot3D dot3D = JSDot3D.getObjFromList(point3DId);
            int result = graphicMultiPoint3D.insertPoint(index, dot3D); //成功返回1 ,失败返回0

            promise.resolve(result);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 移除所有点
     * @param graphicMultiPoint3DId
     * @param promise
     */
    @ReactMethod
    public void removeAllPoints(String graphicMultiPoint3DId, Promise promise) {
        try {
            GraphicMultiPoint3D graphicMultiPoint3D = (GraphicMultiPoint3D) getObjById(graphicMultiPoint3DId);
            graphicMultiPoint3D.removeAllPoints();

            promise.resolve(true);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 移除一个点
     * @param graphicMultiPoint3DId
     * @param index
     * @param promise
     */
    @ReactMethod
    public void removePoint(String graphicMultiPoint3DId, int index, Promise promise) {
        try {
            GraphicMultiPoint3D graphicMultiPoint3D = (GraphicMultiPoint3D) getObjById(graphicMultiPoint3DId);
            graphicMultiPoint3D.removePoint(index);

            promise.resolve(true);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 设置一组坐标
     * @param graphicMultiPoint3DId
     * @param points3DId
     * @param promise
     */
    @ReactMethod
    public void setPoints(String graphicMultiPoint3DId, ReadableArray points3DId, Promise promise) {
        try {
            GraphicMultiPoint3D graphicMultiPoint3D = (GraphicMultiPoint3D) getObjById(graphicMultiPoint3DId);
            List<Dot3D> dot3DS = new ArrayList<>();
            for (int i = 0; i < points3DId.size(); i++) {
                dot3DS.add(JSDot3D.getObjFromList(points3DId.getString(i)));
            }
            graphicMultiPoint3D.setPoints(dot3DS);

            promise.resolve(true);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 设置点的大小
     * @param graphicMultiPoint3DId
     * @param size
     * @param promise
     */
    @ReactMethod
    public void setPointSize(String graphicMultiPoint3DId, double size, Promise promise) {
        try {
            GraphicMultiPoint3D graphicMultiPoint3D = (GraphicMultiPoint3D) getObjById(graphicMultiPoint3DId);
            graphicMultiPoint3D.setPointSize(size);

            promise.resolve(true);
        }catch (Exception e) {
            promise.reject(e);
        }
    }
}
