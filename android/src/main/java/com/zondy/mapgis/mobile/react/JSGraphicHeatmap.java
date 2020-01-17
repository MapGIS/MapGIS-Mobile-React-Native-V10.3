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

import java.util.ArrayList;
import java.util.List;


/**
 *
 */
public class JSGraphicHeatmap extends JSGraphic {
    private static final String REACT_CLASS = "JSGraphicHeatmap";

    public JSGraphicHeatmap(ReactApplicationContext context) {
        super(context);
    }
    @Override
    public String getName() {
        return REACT_CLASS;
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
            GraphicHeatmap graphicHeatmap = (GraphicHeatmap) getObjFromList(GraphicHeatmapId);
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

    @ReactMethod
    public void getHeatmapPoints(String GraphicHeatmapId, Promise promise)
    {
        try {
            GraphicHeatmap graphicHeatmap = (GraphicHeatmap) getObjFromList(GraphicHeatmapId);
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

    @ReactMethod
    public void setVisualMap(String GraphicHeatmapId, String visualMapId, Promise promise)
    {
        try {
            GraphicHeatmap graphicHeatmap = (GraphicHeatmap) getObjFromList(GraphicHeatmapId);
            VisualMap  visualMap = JSVisualMap.getObjFromList(visualMapId);
            if (visualMap != null) {
                graphicHeatmap.setVisualMap(visualMap);
            }
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getVisualMap(String GraphicHeatmapId, Promise promise)
    {
        try {
            GraphicHeatmap graphicHeatmap = (GraphicHeatmap) getObjFromList(GraphicHeatmapId);
            VisualMap visualMap = graphicHeatmap.getVisualMap();

            String strVisualMapId = JSVisualMap.registerId(visualMap);
            WritableMap map = Arguments.createMap();
            map.putString("VisualMapId", strVisualMapId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setPointSize(String GraphicHeatmapId, int size, Promise promise)
    {
        try {
            GraphicHeatmap graphicHeatmap = (GraphicHeatmap) getObjFromList(GraphicHeatmapId);
            graphicHeatmap.setPointSize(size);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getPointSize(String GraphicHeatmapId, Promise promise)
    {
        try {
            GraphicHeatmap graphicHeatmap = (GraphicHeatmap) getObjFromList(GraphicHeatmapId);
            int size = graphicHeatmap.getPointSize();
            promise.resolve(size);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setMinAlpha(String GraphicHeatmapId, double minAlpha, Promise promise)
    {
        try {
            GraphicHeatmap graphicHeatmap = (GraphicHeatmap) getObjFromList(GraphicHeatmapId);
            graphicHeatmap.setMinAlpha(minAlpha);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getMinAlpha(String GraphicHeatmapId, Promise promise)
    {
        try {
            GraphicHeatmap graphicHeatmap = (GraphicHeatmap) getObjFromList(GraphicHeatmapId);
            double minAlpha = graphicHeatmap.getMinAlpha();
            promise.resolve(minAlpha);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setMaxAlpha(String GraphicHeatmapId, double maxAlpha, Promise promise)
    {
        try {
            GraphicHeatmap graphicHeatmap = (GraphicHeatmap) getObjFromList(GraphicHeatmapId);
            graphicHeatmap.setMaxAlpha(maxAlpha);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }
    
    @ReactMethod
    public void getMaxAlpha(String GraphicHeatmapId, Promise promise)
    {
        try {
            GraphicHeatmap graphicHeatmap = (GraphicHeatmap) getObjFromList(GraphicHeatmapId);
            double maxAlpha = graphicHeatmap.getMaxAlpha();
            promise.resolve(maxAlpha);
        } catch (Exception e) {
            promise.reject(e);
        }
    }
}