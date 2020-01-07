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
import com.zondy.mapgis.core.geometry.Dot;
import com.zondy.mapgis.mobile.react.utils.ConvertUtil;
import com.zondy.mapgis.android.graphic.GraphicPolygon;
import com.zondy.mapgis.core.geometry.Dots;
import com.zondy.mapgis.core.object.IntList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * @author fjl 2019-6-30 下午2:52:36
 * @content 区图形对象Native组件
 */
public class JSGraphicPolygon extends JSGraphicMultiPoint {
    public static final String REACT_CLASS = "JSGraphicPolygon";

    public JSGraphicPolygon(ReactApplicationContext context) {
        super(context);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
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
            GraphicPolygon graphicPolygon = (GraphicPolygon) getObjFromList(GraphicPolygonId);
            double area = graphicPolygon.getArea();

            promise.resolve(area);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setPoints(String GraphicPolygonId, String pointArrayJson, String circlesArrayJson, Promise promise) {
        try {
            GraphicPolygon graphicPolygon = (GraphicPolygon) getObjFromList(GraphicPolygonId);
            if(graphicPolygon != null){
                List<Dot> dotList = convertJsonToDotList(pointArrayJson);
                IntList intList = convertJsonToIntList(circlesArrayJson);
                int[] circles = null;
                if (intList != null && intList.size() > 0){
                    for (int i =0; i < intList.size(); i++){
                        circles = new int[intList.size()];
                        circles[i] = intList.get(i);
                    }
                }else{
                    circles = new int[1];
                    circles[0] = dotList.size();
                }

                graphicPolygon.setPoints(dotList, circles);
                promise.resolve(true);
            }else {
                promise.reject("0", "GraphicPolygon is null");
            }

        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setPointsByDots(String GraphicPolygonId, String dotsId, String circlesArray, Promise promise) {
        try {
            GraphicPolygon graphicPolygon = (GraphicPolygon) getObjFromList(GraphicPolygonId);

            Dots dots = JSDots.getObjFromList(dotsId);

            IntList  intList = convertJsonToIntList(circlesArray);
            if(intList == null){
                intList = new IntList();
                intList.append(dots.size());
            }
            graphicPolygon.setPoints(dots, intList);

            promise.resolve(true);

        } catch (Exception e) {
            promise.reject(e);
        }
    }

    private IntList convertJsonToIntList(String circlesArrayJson){
        IntList intList = null;
        try {
            if(circlesArrayJson != null && !circlesArrayJson.isEmpty()) {
                intList = new IntList();
                JSONArray jsonArray = new JSONArray(circlesArrayJson);
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    int cInt = jsonObject.getInt("c");
                    Log.e("cInt", cInt + "");
                    intList.append(cInt);
                }
            }
        }catch (JSONException e){
            e.printStackTrace();
        }

        return intList;
    }

    @ReactMethod
    public void getCirclesToList(String GraphicPolygonId, Promise promise) {
        try {
            GraphicPolygon GraphicPolygon = (GraphicPolygon) getObjFromList(GraphicPolygonId);
            IntList intLst = GraphicPolygon.getCirclesToList();
            WritableArray circlesArray = Arguments.createArray();
            for (int i = 0; i < intLst.size(); i++) {
                circlesArray.pushInt(intLst.get(i));
            }
            promise.resolve(circlesArray);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getBorderlineWidth(String GraphicPolygonId, Promise promise) {
        try {
            GraphicPolygon graphicPolygon = (GraphicPolygon) getObjFromList(GraphicPolygonId);
            float borderlineWidth = graphicPolygon.getBorderlineWidth();

            promise.resolve(borderlineWidth);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setBorderlineWidth(String GraphicPolygonId, Float width, Promise promise) {
        try {
            GraphicPolygon graphicPolygon = (GraphicPolygon) getObjFromList(GraphicPolygonId);
            graphicPolygon.setBorderlineWidth((float)width);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }
    @ReactMethod
    public void setBorderlineColor(String GraphicPolygonId, String color, Promise promise) {
        try {
            GraphicPolygon graphicPolygon = (GraphicPolygon) getObjFromList(GraphicPolygonId);
            graphicPolygon.setBorderlineColor(ConvertUtil.ColorRGBAToInt(color));
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getBorderlineColor(String GraphicPolygonId, Promise promise) {
        try {
            GraphicPolygon graphicPolygon = (GraphicPolygon) getObjFromList(GraphicPolygonId);


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
