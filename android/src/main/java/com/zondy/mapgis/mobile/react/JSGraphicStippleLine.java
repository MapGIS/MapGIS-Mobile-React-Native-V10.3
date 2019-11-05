package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.android.graphic.GraphicStippleLine;
import com.zondy.mapgis.core.geometry.Dot;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * @author fjl 2019-6-18 下午2:52:36
 * @content 虚线图形对象Native组件
 */
public class JSGraphicStippleLine extends JSGraphic {
    public static final String REACT_CLASS = "JSGraphicStippleLine";
    public static Map<String, GraphicStippleLine> mGraphicStippleLineList = new HashMap<String, GraphicStippleLine>();


    public JSGraphicStippleLine(ReactApplicationContext context) {
        super(context);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public static GraphicStippleLine getObjFromList(String id) {
        return mGraphicStippleLineList.get(id);
    }

    public static String registerId(GraphicStippleLine obj) {
        for (Map.Entry entry : mGraphicStippleLineList.entrySet()) {
            if (obj.equals(entry.getValue())) {
                return (String) entry.getKey();
            }
        }
        Calendar calendar = Calendar.getInstance();
        String id = Long.toString(calendar.getTimeInMillis());
        mGraphicStippleLineList.put(id, obj);
        return id;
    }

    @ReactMethod
    public void createObj(String startPointID, String endPointID, Promise promise) {
        try {
            Dot startPoint = JSDot.getObjFromList(startPointID);
            Dot endPoint = JSDot.getObjFromList(endPointID);
            GraphicStippleLine graphicStippleLine = new GraphicStippleLine(startPoint, endPoint);
            String GraphicStippleLineId = registerId(graphicStippleLine);

            WritableMap map = Arguments.createMap();
            map.putString("GraphicStippleLineId", GraphicStippleLineId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setStartPoint(String GraphicStippleLineId, String dotID, Promise promise) {
        try {
            GraphicStippleLine graphicStippleLine = getObjFromList(GraphicStippleLineId);
            Dot dot = JSDot.getObjFromList(dotID);
            graphicStippleLine.setStartPoint(dot);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setEndPoint(String GraphicStippleLineId, String dotID, Promise promise) {
        try {
            GraphicStippleLine graphicStippleLine = getObjFromList(GraphicStippleLineId);
            Dot dot = JSDot.getObjFromList(dotID);
            graphicStippleLine.setEndPoint(dot);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setLineWidth(String GraphicStippleLineId, float width, Promise promise) {
        try {
            GraphicStippleLine graphicStippleLine = getObjFromList(GraphicStippleLineId);
            graphicStippleLine.setLineWidth(width);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setSegLength(String GraphicStippleLineId, int len, Promise promise) {
        try {
            GraphicStippleLine graphicStippleLine = getObjFromList(GraphicStippleLineId);
            graphicStippleLine.setSegLength(len);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setIntervalLength(String GraphicStippleLineId, int len, Promise promise) {
        try {
            GraphicStippleLine graphicStippleLine = getObjFromList(GraphicStippleLineId);
            graphicStippleLine.setIntervalLength(len);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getStartPoint(String GraphicStippleLineId, Promise promise) {
        try {
            GraphicStippleLine graphicStippleLine = getObjFromList(GraphicStippleLineId);
            Dot dot = graphicStippleLine.getStartPoint();

            String dotID = JSDot.registerId(dot);
            WritableMap map = Arguments.createMap();
            map.putString("DotId", dotID);

            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getEndPoint(String GraphicStippleLineId, Promise promise) {
        try {
            GraphicStippleLine graphicStippleLine = getObjFromList(GraphicStippleLineId);
            Dot dot = graphicStippleLine.GetEndPoint();

            String dotID = JSDot.registerId(dot);
            WritableMap map = Arguments.createMap();
            map.putString("DotId", dotID);

            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getLineWidth(String GraphicStippleLineId, Promise promise) {
        try {
            GraphicStippleLine graphicStippleLine = getObjFromList(GraphicStippleLineId);
            double lineWidth = graphicStippleLine.getLineWidth();

            promise.resolve(lineWidth);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getSegLength(String GraphicStippleLineId, Promise promise) {
        try {
            GraphicStippleLine graphicStippleLine = getObjFromList(GraphicStippleLineId);
            int SegLength = (int)graphicStippleLine.getSegLength();

            promise.resolve(SegLength);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getIntervalLength(String GraphicStippleLineId, Promise promise) {
        try {
            GraphicStippleLine graphicStippleLine = getObjFromList(GraphicStippleLineId);
            int intervalLength = (int)graphicStippleLine.getIntervalLength();

            promise.resolve(intervalLength);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getLength(String GraphicStippleLineId, Promise promise) {
        try {
            GraphicStippleLine graphicStippleLine = getObjFromList(GraphicStippleLineId);
            double length = graphicStippleLine.getLength();

            promise.resolve(length);
        } catch (Exception e) {
            promise.reject(e);
        }
    }
}
