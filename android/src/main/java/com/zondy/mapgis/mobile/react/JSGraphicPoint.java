package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.android.graphic.GraphicPoint;
import com.zondy.mapgis.core.geometry.Dot;

/**
 * @content 点图形对象Native组件
 * @authorfjl 2019-6-30 下午2:52:36
 */
public class JSGraphicPoint extends JSGraphic {
    public static final String REACT_CLASS = "JSGraphicPoint";

    public JSGraphicPoint(ReactApplicationContext context) {
        super(context);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @ReactMethod
    public void createObj(Promise promise) {
        try {
            GraphicPoint GraphicPoint = new GraphicPoint();
            String GraphicPointId = registerId(GraphicPoint);

            WritableMap map = Arguments.createMap();
            map.putString("GraphicPointId", GraphicPointId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 设置点的位置
     * @param GraphicPointId
     * @param dotID     点的位置
     * @param promise
     */
    @ReactMethod
    public void setPoint(String GraphicPointId, String dotID, Promise promise) {
        try {
            GraphicPoint graphicPoint = (GraphicPoint) getObjFromList(GraphicPointId);
            Dot dot = JSDot.getObjFromList(dotID);
            graphicPoint.setPoint(dot);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取点的位置
     * @param GraphicPointId
     * @param promise
     */
    @ReactMethod
    public void getPoint(String GraphicPointId, Promise promise) {
        try {
            GraphicPoint graphicPoint = (GraphicPoint) getObjFromList(GraphicPointId);
            Dot dot = graphicPoint.getPoint();

            String pointID = JSDot.registerId(dot);
            WritableMap map = Arguments.createMap();
            map.putString("pointID", pointID);

            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取点的大小
     * @param GraphicPointId
     * @param promise
     */
    @ReactMethod
    public void getSize(String GraphicPointId, Promise promise) {
        try {
            GraphicPoint graphicPoint = (GraphicPoint) getObjFromList(GraphicPointId);
            float pointSize = graphicPoint.getSize();

            promise.resolve(pointSize);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 设置点的大小
     * @param GraphicPointId
     * @param size      点的大小
     * @param promise
     */
    @ReactMethod
    public void setSize(String GraphicPointId, float size, Promise promise) {
        try {
            GraphicPoint graphicPoint = (GraphicPoint) getObjFromList(GraphicPointId);
            graphicPoint.setSize(size);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 设置点的位置、大小
     * @param GraphicPointId
     * @param dotID     点的位置
     * @param size      点的大小
     * @param promise
     */
    @ReactMethod
    public void setPointAndSize(String GraphicPointId, String dotID, float size, Promise promise)
    {
        try {
            GraphicPoint graphicPoint = (GraphicPoint) getObjFromList(GraphicPointId);
            Dot dot = JSDot.getObjFromList(dotID);
            graphicPoint.setPointAndSize(dot,size);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }
}
