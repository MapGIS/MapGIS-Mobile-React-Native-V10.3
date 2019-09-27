package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.android.graphic.GraphicHeatmap;
import com.zondy.mapgis.android.graphic.HeatmapPoint;
import com.zondy.mapgis.android.graphic.VisualMap;
import com.zondy.mapgis.mobile.react.utils.ConvertUtil;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
public class JSGraphicHeatmap extends JSGraphic {
    public static final String REACT_CLASS = "JSGraphicHeatmap";
    public static Map<String, GraphicHeatmap> mGraphicHeatmapList = new HashMap<String, GraphicHeatmap>();

    public JSGraphicHeatmap(ReactApplicationContext context) {
        super(context);
    }
    @Override
    public String getName() {
        return REACT_CLASS;
    }
    public static GraphicHeatmap getObjFromList(String id) {
        return mGraphicHeatmapList.get(id);
    }

    public static String registerId(GraphicHeatmap obj) {
        for (Map.Entry entry : mGraphicHeatmapList.entrySet()) {
            if (obj.equals(entry.getValue())) {
                return (String) entry.getKey();
            }
        }
        Calendar calendar = Calendar.getInstance();
        String id = Long.toString(calendar.getTimeInMillis());
        mGraphicHeatmapList.put(id, obj);
        return id;
    }

    @ReactMethod
    public void createObj(Promise promise) {
        try {
            GraphicHeatmap graphicHeatmap = new GraphicHeatmap();
            String strGraphicHeatmapId = registerId(graphicHeatmap);

            WritableMap map = Arguments.createMap();
            map.putString("GraphicHeatmapId", strGraphicHeatmapId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }
    @ReactMethod
    public void setHeatmapPoints(String GraphicHeatmapId, ReadableArray heatmapPointArray, Promise promise)
    {
        try {
            GraphicHeatmap graphicHeatmap = getObjFromList(GraphicHeatmapId);
            ArrayList<HeatmapPoint> heatmapPointLst = new ArrayList();
            if (graphicHeatmap != null) {
                for (int i = 0; i < heatmapPointArray.size(); i++) {
                    ReadableMap readable = heatmapPointArray.getMap(i);
                    String keyStr = readable.getString("HeatmapPointId");
                    heatmapPointLst.add(JSHeatmapPoint.getObjFromList(keyStr));
                }
            }
            graphicHeatmap.setHeatmapPoints(heatmapPointLst,heatmapPointLst.size());
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * @param GraphicHeatmapId
     * @param promise
     */
    @ReactMethod
    public void getHeatmapPoints(String GraphicHeatmapId, Promise promise)
    {
        try {
            GraphicHeatmap graphicHeatmap = getObjFromList(GraphicHeatmapId);
            List<HeatmapPoint> heatmapPointList = graphicHeatmap.getHeatmapPoints();
            String strHeatmapPointId = "";
            WritableArray arr = Arguments.createArray();
            if (heatmapPointList.size() > 0) {
                for (int i = 0; i < heatmapPointList.size(); i++) {
                    strHeatmapPointId = JSHeatmapPoint.registerId(heatmapPointList.get(i));
                    arr.pushString(strHeatmapPointId);
                }
            }
            WritableMap map = Arguments.createMap();
            map.putArray("HeatmapPointArr", arr);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 设置视觉映射
     * @param GraphicHeatmapId
     * @param visualMapId
     * @param promise
     */
    @ReactMethod
    public void setVisualMap(String GraphicHeatmapId, String visualMapId, Promise promise)
    {
        try {
            GraphicHeatmap graphicHeatmap = getObjFromList(GraphicHeatmapId);
            VisualMap  visualMap = JSVisualMap.getObjFromList(visualMapId);
            if (visualMap != null) {
                graphicHeatmap.setVisualMap(visualMap);
            }
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取视觉映射
     * @param GraphicHeatmapId
     * @param promise
     */
    @ReactMethod
    public void getVisualMap(String GraphicHeatmapId, Promise promise)
    {
        try {
            GraphicHeatmap graphicHeatmap = getObjFromList(GraphicHeatmapId);
            VisualMap visualMap = graphicHeatmap.getVisualMap();

            String strVisualMapId = JSVisualMap.registerId(visualMap);
            WritableMap map = Arguments.createMap();
            map.putString("VisualMapId", strVisualMapId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 设置热力点大小
     * @param GraphicHeatmapId
     * @param size
     * @param promise
     */
    @ReactMethod
    public void setPointSize(String GraphicHeatmapId, int size, Promise promise)
    {
        try {
            GraphicHeatmap graphicHeatmap = getObjFromList(GraphicHeatmapId);
            graphicHeatmap.setPointSize(size);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取热力点大小
     * @param GraphicHeatmapId
     * @param promise
     */
    @ReactMethod
    public void getPointSize(String GraphicHeatmapId, Promise promise)
    {
        try {
            GraphicHeatmap graphicHeatmap = getObjFromList(GraphicHeatmapId);
            int size = graphicHeatmap.getPointSize();
            promise.resolve(size);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 设置热力点透明度的最小值,默认为0:不透明
     * @param GraphicHeatmapId
     * @param minAlpha
     * @param promise
     */
    @ReactMethod
    public void setMinAlpha(String GraphicHeatmapId, double minAlpha, Promise promise)
    {
        try {
            GraphicHeatmap graphicHeatmap = getObjFromList(GraphicHeatmapId);
            graphicHeatmap.setMinAlpha(minAlpha);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取热力点最小透明度,默认值为0:不透明
     * @param GraphicHeatmapId
     * @param promise
     */
    @ReactMethod
    public void getMinAlpha(String GraphicHeatmapId, Promise promise)
    {
        try {
            GraphicHeatmap graphicHeatmap = getObjFromList(GraphicHeatmapId);
            double minAlpha = graphicHeatmap.getMinAlpha();
            promise.resolve(minAlpha);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 设置热力点透明度的最大值,默认为100:全透明
     * @param GraphicHeatmapId
     * @param maxAlpha
     * @param promise
     */
    @ReactMethod
    public void setMaxAlpha(String GraphicHeatmapId, double maxAlpha, Promise promise)
    {
        try {
            GraphicHeatmap graphicHeatmap = getObjFromList(GraphicHeatmapId);
            graphicHeatmap.setMaxAlpha(maxAlpha);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取热力点最大透明度,默认值为100:全透明
     * @param GraphicHeatmapId
     * @param promise
     */
    @ReactMethod
    public void getMaxAlpha(String GraphicHeatmapId, Promise promise)
    {
        try {
            GraphicHeatmap graphicHeatmap = getObjFromList(GraphicHeatmapId);
            double maxAlpha = graphicHeatmap.getMaxAlpha();
            promise.resolve(maxAlpha);
        } catch (Exception e) {
            promise.reject(e);
        }
    }
}