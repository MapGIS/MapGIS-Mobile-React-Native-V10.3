package com.zondy.mapgis.mobile.react.scene;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.android.graphic.GraphicPolygon3D;
import com.zondy.mapgis.core.geometry.Dot3D;
import com.zondy.mapgis.mobile.react.JSDot3D;

/**
 * @auther LiaoLiang on 20-8-16
 * @content 场景区图形
 */
public class JSGraphicPolygon3D extends JSGraphicMultiPoint3D {
    private static final String REACT_CLASS = "JSGraphicPolygon3D";

    @NonNull
    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public JSGraphicPolygon3D(@NonNull ReactApplicationContext reactContext) {
        super(reactContext);
    }

    /**
     * 构造一个新的 GraphicPolygon3D 对象
     * @param promise
     */
    @ReactMethod
    public void createObj(Promise promise) {
        try {
            GraphicPolygon3D graphicPolygon3D = new GraphicPolygon3D();
            String graphicPolygon3DId = registerId(graphicPolygon3D);

            WritableMap map = Arguments.createMap();
            map.putString("graphicPolygon3DId", graphicPolygon3DId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 追加点(只针对第一圈操作)
     * @param graphicPolygon3DId
     * @param dot3DId
     * @param promise
     */
    @ReactMethod
    public void appendPoint(String graphicPolygon3DId, String dot3DId, Promise promise) {
        try {
            GraphicPolygon3D graphicPolygon3D = (GraphicPolygon3D) getObjById(graphicPolygon3DId);
            Dot3D dot3D = JSDot3D.getObjFromList(dot3DId);
            int result = graphicPolygon3D.appendPoint(dot3D);

            promise.resolve(result);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 追加一组点(只针对第一圈操作)
     * @param graphicPolygon3DId
     * @param dot3DIds
     * @param promise
     */
    @ReactMethod
    public void appendPoints(String graphicPolygon3DId, ReadableArray dot3DIds, Promise promise) {
        try {
            GraphicPolygon3D graphicPolygon3D = (GraphicPolygon3D) getObjById(graphicPolygon3DId);
            Dot3D[] dot3Ds = new Dot3D[dot3DIds.size()];
            for (int i = 0; i < dot3DIds.size(); i++) {
                dot3Ds[i] = JSDot3D.getObjFromList(dot3DIds.getString(i));
            }
            graphicPolygon3D.appendPoints(dot3Ds);

            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取面积
     * @param graphicPolygon3DId
     * @param promise
     */
    @ReactMethod
    public void getArea(String graphicPolygon3DId, Promise promise) {
        try {
            GraphicPolygon3D graphicPolygon3D = (GraphicPolygon3D) getObjById(graphicPolygon3DId);
            double area = graphicPolygon3D.getArea();

            promise.resolve(area);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取边界线的宽度
     * @param graphicPolygon3DId
     * @param promise
     */
    @ReactMethod
    public void getBorderlineWidth(String graphicPolygon3DId, Promise promise) {
        try {
            GraphicPolygon3D graphicPolygon3D = (GraphicPolygon3D) getObjById(graphicPolygon3DId);
            double borderlineWidth = graphicPolygon3D.getBorderlineWidth();

            promise.resolve(borderlineWidth);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取圈序列长度
     * @param graphicPolygon3DId
     * @param promise
     */
    @ReactMethod
    public void getCirclesSize(String graphicPolygon3DId, Promise promise) {
        try {
            GraphicPolygon3D graphicPolygon3D = (GraphicPolygon3D) getObjById(graphicPolygon3DId);
            int circlesSize = graphicPolygon3D.getCirclesSize();

            promise.resolve(circlesSize);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取图形伸出的高度
     * @param graphicPolygon3DId
     * @param promise
     */
    @ReactMethod
    public void getExtrusionHeight(String graphicPolygon3DId, Promise promise) {
        try {
            GraphicPolygon3D graphicPolygon3D = (GraphicPolygon3D) getObjById(graphicPolygon3DId);
            double extrusionHeight = graphicPolygon3D.getExtrusionHeight();

            promise.resolve(extrusionHeight);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 在指定索引处插入点
     * @param graphicPolygon3DId
     * @param index 索引
     * @param dot3DId 场景地理坐标的id
     * @param promise
     */
    @ReactMethod
    public void insertPoint(String graphicPolygon3DId, int index, String dot3DId, Promise promise) {
        try {
            GraphicPolygon3D graphicPolygon3D = (GraphicPolygon3D) getObjById(graphicPolygon3DId);
            Dot3D dot3D = JSDot3D.getObjFromList(dot3DId);
            int result = graphicPolygon3D.insertPoint(index, dot3D); //成功返回1 ,失败返回0

            promise.resolve(result);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 移除指定索引的点
     * @param graphicPolygon3DId
     * @param index
     * @param promise
     */
    @ReactMethod
    public void removePoint(String graphicPolygon3DId, int index, Promise promise) {
        try {
            GraphicPolygon3D graphicPolygon3D = (GraphicPolygon3D) getObjById(graphicPolygon3DId);
            graphicPolygon3D.removePoint(index);

            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 移除所有点
     * @param graphicPolygon3DId
     * @param promise
     */
    @ReactMethod
    public void removeAllPoints(String graphicPolygon3DId, Promise promise) {
        try {
            GraphicPolygon3D graphicPolygon3D = (GraphicPolygon3D) getObjById(graphicPolygon3DId);
            graphicPolygon3D.removeAllPoints();

            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 设置边界线的颜色
     * @param graphicPolygon3DId
     * @param color
     * @param promise
     */
    @ReactMethod
    public void setBorderlineColor(String graphicPolygon3DId, int color, Promise promise) {
        try {
            GraphicPolygon3D graphicPolygon3D = (GraphicPolygon3D) getObjById(graphicPolygon3DId);
            graphicPolygon3D.setBorderlineColor(color);

            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 设置边界线的宽度
     * @param graphicPolygon3DId
     * @param width
     * @param promise
     */
    @ReactMethod
    public void setBorderlineWidth(String graphicPolygon3DId, double width, Promise promise) {
        try {
            GraphicPolygon3D graphicPolygon3D = (GraphicPolygon3D) getObjById(graphicPolygon3DId);
            graphicPolygon3D.setBorderlineWidth(width);

            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 设置覆盖物伸出的高度
     * @param graphicPolygon3DId
     * @param extrusionHeight
     * @param promise
     */
    @ReactMethod
    public void setExtrusionHeight(String graphicPolygon3DId, double extrusionHeight, Promise promise) {
        try {
            GraphicPolygon3D graphicPolygon3D = (GraphicPolygon3D) getObjById(graphicPolygon3DId);
            graphicPolygon3D.setExtrusionHeight(extrusionHeight);

            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 设置坐标点
     * @param graphicPolygon3DId
     * @param dot3DIds
     * @param promise
     */
    @ReactMethod
    public void setPoints(String graphicPolygon3DId, ReadableArray dot3DIds, Promise promise) {
        try {
            GraphicPolygon3D graphicPolygon3D = (GraphicPolygon3D) getObjById(graphicPolygon3DId);
            Dot3D[] dot3Ds = new Dot3D[dot3DIds.size()];
            for (int i = 0; i < dot3DIds.size(); i++) {
                dot3Ds[i] = JSDot3D.getObjFromList(dot3DIds.getString(i));
            }
            graphicPolygon3D.setPoints(dot3Ds);

            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

}
