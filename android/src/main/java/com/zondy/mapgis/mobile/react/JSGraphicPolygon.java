package com.zondy.mapgis.mobile.react;

import android.util.Log;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.mobile.react.utils.ConvertUtil;
import com.zondy.mapgis.android.graphic.GraphicPolygon;
import com.zondy.mapgis.core.geometry.Dots;
import com.zondy.mapgis.core.object.IntList;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * @author fjl 2019-6-30 下午2:52:36
 * @content 区图形对象Native组件
 */
public class JSGraphicPolygon extends JSGraphicMultiPoint {
    public static final String REACT_CLASS = "JSGraphicPolygon";
    public static Map<String, GraphicPolygon> mGraphicPolygonList = new HashMap<String, GraphicPolygon>();


    public JSGraphicPolygon(ReactApplicationContext context) {
        super(context);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public static GraphicPolygon getObjFromList(String id) {
        return mGraphicPolygonList.get(id);
    }


    public static String registerId(GraphicPolygon obj) {
        for (Map.Entry entry : mGraphicPolygonList.entrySet()) {
            if (obj.equals(entry.getValue())) {
                String id = (String) entry.getKey();
                mGraphicPolygonList.put(id, obj);
                return (String) entry.getKey();
            }
        }

        Calendar calendar = Calendar.getInstance();
        String id = Long.toString(calendar.getTimeInMillis());
        mGraphicPolygonList.put(id, obj);
        return id;
    }

    @ReactMethod
    public void createObj(Promise promise) {
        try {
            GraphicPolygon GraphicPolygon = new GraphicPolygon();
            String GraphicPolygonId = registerId(GraphicPolygon);

            WritableMap map = Arguments.createMap();
            map.putString("GraphicPolygonId", GraphicPolygonId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getArea(String GraphicPolygonId, Promise promise) {
        try {
            GraphicPolygon graphicPolygon = getObjFromList(GraphicPolygonId);
            double area = graphicPolygon.getArea();

            promise.resolve(area);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setPoints(String GraphicPolygonId, ReadableArray pointArray, ReadableArray circlesArray, Promise promise) {
        try {
            GraphicPolygon graphicPolygon = getObjFromList(GraphicPolygonId);
            Dots dotLst = new Dots();
            IntList intList = new IntList();
            if (graphicPolygon != null) {
                for (int i = 0; i < pointArray.size(); i++) {
                    ReadableMap readable = pointArray.getMap(i);
                    String keyStr = readable.getString("_MGDotId");
                    dotLst.append(JSDot.getObjFromList(keyStr));
                    Log.e("dotLst:", "" + JSDot.getObjFromList(keyStr).x);
                }
                if (circlesArray != null) {
                    for (int j = 0; j < circlesArray.size(); j++) {
                        intList.append(circlesArray.getInt(j));
                    }
                } else {
                    intList.append(dotLst.size());
                }
            }

            Log.e("graphicPolygon:", "" + graphicPolygon);
            Log.e("GraphicPolygonId:", "" + GraphicPolygonId);
            Log.e("circlesArray:", "" + circlesArray);

            graphicPolygon.setPoints(dotLst, intList);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getCirclesToList(String GraphicPolygonId, Promise promise) {
        try {
            GraphicPolygon GraphicPolygon = getObjFromList(GraphicPolygonId);
            IntList intLst = GraphicPolygon.getCirclesToList();
            WritableArray circlesArray = Arguments.createArray();
            for (int i = 0; i < intLst.size(); i++) {
                circlesArray.pushInt(intLst.get(i));
            }

            WritableMap map = Arguments.createMap();
            map.putArray("circlesArray", circlesArray);

            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getBorderlineWidth(String GraphicPolygonId, Promise promise) {
        try {
            GraphicPolygon graphicPolygon = getObjFromList(GraphicPolygonId);
            float borderlineWidth = graphicPolygon.getBorderlineWidth();

            promise.resolve(borderlineWidth);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setBorderlineWidth(String GraphicPolygonId, float width, Promise promise) {
        try {
            GraphicPolygon graphicPolygon = getObjFromList(GraphicPolygonId);
            graphicPolygon.setBorderlineWidth(width);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    public void setBorderlineColor(String GraphicPolygonId, String color, Promise promise) {
        try {
            GraphicPolygon graphicPolygon = getObjFromList(GraphicPolygonId);
            graphicPolygon.setBorderlineColor(ConvertUtil.ColorRGBAToInt(color));
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getBorderlineColor(String GraphicPolygonId, Promise promise) {
        try {
            GraphicPolygon graphicPolygon = getObjFromList(GraphicPolygonId);


            int color = graphicPolygon.getBorderlineColor();
            String borderlineColor = ConvertUtil.ColorIntToRGBA(color);

            WritableMap map = Arguments.createMap();
            map.putString("borderlineColor", borderlineColor);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }


}
