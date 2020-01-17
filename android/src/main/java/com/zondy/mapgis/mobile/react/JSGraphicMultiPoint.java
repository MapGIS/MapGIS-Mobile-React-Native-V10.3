package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.android.graphic.GraphicMultiPoint;
import com.zondy.mapgis.core.geometry.Dot;
import com.zondy.mapgis.core.geometry.Dots;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


/**
 * @author fjl 2019-6-30 下午2:52:36
 * @content 多点图形对象Native组件
 */
public class JSGraphicMultiPoint extends JSGraphic {
    private static final String REACT_CLASS = "JSGraphicMultiPoint";

    public JSGraphicMultiPoint(ReactApplicationContext context) {
        super(context);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @ReactMethod
    public void createObj(Promise promise) {
        try {
            GraphicMultiPoint GraphicMultiPoint = new GraphicMultiPoint();
            String GraphicMultiPointId = registerId(GraphicMultiPoint);
            WritableMap map = Arguments.createMap();
            map.putString("GraphicMultiPointId", GraphicMultiPointId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setPoints(String GraphicMultiPointId, String json, Promise promise) {
        try {
            GraphicMultiPoint graphicMultiPoint = (GraphicMultiPoint) getObjFromList(GraphicMultiPointId);
            if(json != null && !json.isEmpty()){
                List<Dot> dotLst = convertJsonToDotList(json);
                graphicMultiPoint.setPoints(dotLst);
                promise.resolve(true);
            }else {
                promise.resolve(false);
            }
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setPointsByDots(String GraphicMultiPointId, String dotsId, Promise promise) {
        try {
            GraphicMultiPoint graphicMultiPoint = (GraphicMultiPoint) getObjFromList(GraphicMultiPointId);
            Dots dots = JSDots.getObjFromList(dotsId);
            graphicMultiPoint.setPoints(dots);

            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getPoints(String GraphicMultiPointId, Promise promise) {
        try {
            GraphicMultiPoint GraphicMultiPoint = (GraphicMultiPoint) getObjFromList(GraphicMultiPointId);
            Dot[] dotLst = GraphicMultiPoint.getPoints();
            String dotID = "";
            WritableArray dotsArr = Arguments.createArray();
            if (dotLst.length > 0) {
                for (int i = 0; i < dotLst.length; i++) {
                    dotID = JSDot.registerId(dotLst[i]);
                    dotsArr.pushString(dotID);
                }
            }
            promise.resolve(dotsArr);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getPointsToDots(String GraphicMultiPointId, Promise promise){
        try {
            GraphicMultiPoint graphicMultiPoint = (GraphicMultiPoint) getObjFromList(GraphicMultiPointId);
            Dots dots = graphicMultiPoint.getPointsToDots();
            String dotsId = null;
            if(dots != null){
                dotsId = JSDots.registerId(dots);
            }

            promise.resolve(dotsId);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getPointCount(String GraphicMultiPointId, Promise promise) {
        try {
            GraphicMultiPoint GraphicMultiPoint = (GraphicMultiPoint) getObjFromList(GraphicMultiPointId);
            int pointCount = GraphicMultiPoint.getPointCount();

            promise.resolve(pointCount);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getPoint(String GraphicMultiPointId, int index, Promise promise) {
        try {
            GraphicMultiPoint GraphicMultiPoint = (GraphicMultiPoint) getObjFromList(GraphicMultiPointId);
            Dot dot = GraphicMultiPoint.getPoint(index);

            String dotID = JSDot.registerId(dot);

            WritableMap map = Arguments.createMap();
            map.putString("dotID", dotID);
            promise.resolve(map);

        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setPointSize(String GraphicMultiPointId, double size, Promise promise) {
        try {
            GraphicMultiPoint GraphicMultiPoint = (GraphicMultiPoint) getObjFromList(GraphicMultiPointId);
            GraphicMultiPoint.setPointSize(size);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getPointSize(String GraphicMultiPointId, Promise promise) {
        try {
            GraphicMultiPoint GraphicMultiPoint = (GraphicMultiPoint) getObjFromList(GraphicMultiPointId);
            double pointSize = GraphicMultiPoint.getPointSize();

            promise.resolve(pointSize);
        } catch (Exception e) {
            promise.reject(e);
        }
    }


    @ReactMethod
    public void appendPoint(String GraphicMultiPointId, String dotID, Promise promise) {
        try {
            GraphicMultiPoint GraphicMultiPoint = (GraphicMultiPoint) getObjFromList(GraphicMultiPointId);
            Dot dot = JSDot.getObjFromList(dotID);
            int result = GraphicMultiPoint.appendPoint(dot);
            promise.resolve(result);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void appendPoints(String GraphicMultiPointId, ReadableArray pointArray, Promise promise) {
        try {
            GraphicMultiPoint GraphicMultiPoint = (GraphicMultiPoint) getObjFromList(GraphicMultiPointId);

            if (GraphicMultiPoint != null) {
                Dot[] dotLst = new Dot[pointArray.size()];
                for (int i = 0; i < pointArray.size(); i++) {
                    ReadableMap readable = pointArray.getMap(i);
                    String keyStr = readable.getString("_MGDotId");
                    dotLst[i] = JSDot.getObjFromList(keyStr);
                }
                GraphicMultiPoint.appendPoints(dotLst);
            }
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void updatePoint(String GraphicMultiPointId, int index, String dotID, Promise promise) {
        try {
            GraphicMultiPoint GraphicMultiPoint = (GraphicMultiPoint) getObjFromList(GraphicMultiPointId);
            Dot dot = JSDot.getObjFromList(dotID);
            int result = GraphicMultiPoint.updatePoint(index, dot);
            promise.resolve(result);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void removePoint(String GraphicMultiPointId, int index, Promise promise) {
        try {
            GraphicMultiPoint GraphicMultiPoint = (GraphicMultiPoint) getObjFromList(GraphicMultiPointId);
            GraphicMultiPoint.removePoint(index);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void removeAllPoints(String GraphicMultiPointId, Promise promise) {
        try {
            GraphicMultiPoint GraphicMultiPoint = (GraphicMultiPoint) getObjFromList(GraphicMultiPointId);
            GraphicMultiPoint.removeAllPoints();
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void insertPoint(String GraphicMultiPointId, int index, String dotID, Promise promise) {
        try {
            GraphicMultiPoint GraphicMultiPoint = (GraphicMultiPoint) getObjFromList(GraphicMultiPointId);
            Dot dot = JSDot.getObjFromList(dotID);
            int result = GraphicMultiPoint.insertPoint(index, dot);
            promise.resolve(result);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    public List<Dot> convertJsonToDotList(String json){
        List<Dot> dotList = new ArrayList<>();

        try {
            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0; i < jsonArray.length(); i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String dotId = jsonObject.getString("_MGDotId");
                Dot dot = JSDot.getObjFromList(dotId);
                dotList.add(dot);
            }

        }catch (JSONException e){
            e.printStackTrace();
        }
        return dotList;
    }
}
