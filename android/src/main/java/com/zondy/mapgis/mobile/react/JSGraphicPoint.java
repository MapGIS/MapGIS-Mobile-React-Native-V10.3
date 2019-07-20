package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.android.graphic.GraphicPoint;
import com.zondy.mapgis.core.geometry.Dot;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * @content 点图形对象Native组件
 * @authorfjl 2019-6-30 下午2:52:36
 */
public class JSGraphicPoint extends JSGraphic {
    public static final String REACT_CLASS = "JSGraphicPoint";
    public static Map<String, GraphicPoint> mGraphicPointList = new HashMap<String, GraphicPoint>();


    public JSGraphicPoint(ReactApplicationContext context) {
        super(context);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public static GraphicPoint getObjFromList(String id) {
        return mGraphicPointList.get(id);
    }


    public static String registerId(GraphicPoint obj) {
        for (Map.Entry entry : mGraphicPointList.entrySet()) {
            if (obj.equals(entry.getValue())) {
                String id = (String) entry.getKey();
                mGraphicPointList.put(id, obj);
                return (String) entry.getKey();
            }
        }

        Calendar calendar = Calendar.getInstance();
        String id = Long.toString(calendar.getTimeInMillis());
        mGraphicPointList.put(id, obj);
        return id;
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

    @ReactMethod
    public void setPoint(String GraphicPointId, String dotID, Promise promise) {
        try {
            GraphicPoint graphicPoint = getObjFromList(GraphicPointId);
            Dot dot = JSDot.getObjFromList(dotID);
            graphicPoint.setPoint(dot);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getPoint(String GraphicPointId, Promise promise) {
        try {
            GraphicPoint graphicPoint = getObjFromList(GraphicPointId);
            Dot dot = graphicPoint.getPoint();

            String pointID = JSDot.registerId(dot);
            WritableMap map = Arguments.createMap();
            map.putString("pointID", pointID);

            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getSize(String GraphicPointId, Promise promise) {
        try {
            GraphicPoint graphicPoint = getObjFromList(GraphicPointId);
            float pointSize = graphicPoint.getSize();

            promise.resolve(pointSize);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setSize(String GraphicPointId, float size, Promise promise) {
        try {
            GraphicPoint graphicPoint = getObjFromList(GraphicPointId);
            graphicPoint.setSize(size);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }
}
