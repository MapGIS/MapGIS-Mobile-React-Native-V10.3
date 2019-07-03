package com.mapgis_mobile_reactnative;

import android.graphics.Color;
import android.util.Log;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.mapgis_mobile_reactnative.utils.ConvertUtil;
import com.zondy.mapgis.android.graphic.Graphic;
import com.zondy.mapgis.android.graphic.GraphicCircle;
import com.zondy.mapgis.android.graphic.GraphicImage;
import com.zondy.mapgis.android.graphic.GraphicMultiPoint;
import com.zondy.mapgis.android.graphic.GraphicPoint;
import com.zondy.mapgis.android.graphic.GraphicPolygon;
import com.zondy.mapgis.android.graphic.GraphicPolylin;
import com.zondy.mapgis.android.graphic.GraphicStippleLine;
import com.zondy.mapgis.android.graphic.GraphicType;
import com.zondy.mapgis.android.graphic.GraphicsOverlay;
import com.zondy.mapgis.android.mapview.MapView;
import com.zondy.mapgis.core.geometry.Dot;
import com.zondy.mapgis.core.geometry.Rect;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @content 图形对象Native组件
 * @author fjl 2019-6-18 下午2:52:36
 */
public class JSGraphic extends ReactContextBaseJavaModule {
    public static final String REACT_CLASS = "JSGraphic";
    public static Map<String, Graphic> mGraphicList = new HashMap<String, Graphic>();


    public JSGraphic(ReactApplicationContext context) {
        super(context);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public static Graphic getObjFromList(String id){
        return mGraphicList.get(id);
    }


    public static String registerId(Graphic obj) {
        for (Map.Entry entry : mGraphicList.entrySet()) {
            if (obj.equals(entry.getValue())) {
                String id = (String) entry.getKey();
                mGraphicList.put(id, obj);
                return (String) entry.getKey();
            }
        }

        Calendar calendar = Calendar.getInstance();
        String id = Long.toString(calendar.getTimeInMillis());
        mGraphicList.put(id, obj);
        return id;
    }

    @ReactMethod
    public void createObj(Promise promise){
        try{
            Graphic Graphic = new Graphic();
            String GraphicId = registerId(Graphic);

            WritableMap map = Arguments.createMap();
            map.putString("GraphicId",GraphicId);
            promise.resolve(map);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getState(String GraphicId,Promise promise){
        try{
            Graphic graphic = getObjFromList(GraphicId);
            int state = graphic.getState();

            promise.resolve(state);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setState(String GraphicId,int state,Promise promise){
        try{
            Graphic Graphic = getObjFromList(GraphicId);
            Graphic.setState(state);
            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setColor(String GraphicId,String color,Promise promise)
    {
        try {
//            Graphic Graphic = getObjFromList(GraphicId);
            Graphic graphic = getGraphicByID(GraphicId);
            Log.d("color:", "--" + color);
            graphic.setColor(-ConvertUtil.ColorRGBAToInt(color));

            promise.resolve(true);
        }
        catch (Exception e)
        {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getColor(String GraphicId,Promise promise) {
        try{
            Graphic graphic = getObjFromList(GraphicId);
            int color = graphic.getColor();
            String strColor = ConvertUtil.ColorIntToRGBA(color);

            WritableMap map= Arguments.createMap();
            map.putString("color",strColor);
            promise.resolve(map);
        }catch (Exception e){
            promise.reject(e);
        }
    }


    @ReactMethod
    public void getCenterPoint(String GraphicId,int index,Promise promise){
        try{
            Graphic Graphic = getObjFromList(GraphicId);
            Dot centerDot = Graphic.getCenterPoint();

            String point2DId = JSDot.registerId(centerDot);
            WritableMap map= Arguments.createMap();
            map.putString("point2DId",point2DId);
            map.putDouble("x",centerDot.getX());
            map.putDouble("y",centerDot.getY());
            promise.resolve(map);

        }catch (Exception e){
            promise.reject(e);
        }
    }


    @ReactMethod
    public void getBoundingRect(String GraphicId,Promise promise)
    {
        try {
            Graphic Graphic = getObjFromList(GraphicId);
            Rect rect = Graphic.getBoundingRect();

            String rectId = JSRect.registerId(rect);
            WritableMap map = Arguments.createMap();
            map.putString("rectId",rectId);
            promise.resolve(map);
        }
        catch (Exception e)
        {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getGraphicType(String GraphicId,Promise promise){
        try{
            Graphic graphic = getObjFromList(GraphicId);
            GraphicType graphicType = graphic.getGraphicType();
            int type = graphicType.value();

            promise.resolve(type);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setPointByPixel(String GraphicId,boolean pixel,Promise promise){
        try{
            Graphic Graphic = getObjFromList(GraphicId);
            Graphic.setPointByPixel(pixel);
            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void isPointByPixel(String GraphicId,Promise promise){
        try{
            Graphic graphic = getObjFromList(GraphicId);
            boolean isPointByPixel = graphic.isPointByPixel();

            promise.resolve(isPointByPixel);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setAttributeValue(String GraphicId,String name ,String value,Promise promise){
        try{
            Graphic Graphic = getObjFromList(GraphicId);
            Graphic.setAttributeValue(name,value);
            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getAttributeNum(String GraphicId,Promise promise){
        try{
            Graphic graphic = getObjFromList(GraphicId);
            long attributeNum = graphic.getAttributeNum();

            promise.resolve(attributeNum);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getAttributeName(String GraphicId,int index,Promise promise){
        try{
            Graphic graphic = getObjFromList(GraphicId);
            String  attributeName = graphic.getAttributeName(index);

            promise.resolve(attributeName);
        }catch (Exception e){
            promise.reject(e);
        }
    }
    @ReactMethod
    public void getAttributeValue(String GraphicId,String name,Promise promise){
        try{
            Graphic graphic = getObjFromList(GraphicId);
            String  attributeValue = graphic.getAttributeValue(name);

            promise.resolve(attributeValue);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void removeAttribute(String GraphicId,String name,Promise promise){
        try{
            Graphic graphic = getObjFromList(GraphicId);
            graphic.removeAttribute(name);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void removeAllAttributes(String GraphicId,Promise promise){
        try{
            Graphic graphic = getObjFromList(GraphicId);
            graphic.removeAllAttributes();
        }catch (Exception e){
            promise.reject(e);
        }
    }
    public Graphic getGraphicByID(String graphicID) {
        Graphic graphic = JSGraphic.mGraphicList.get(graphicID);
        Log.e("graphic:", "" + graphic);
        Log.e("graphicID:", "" + graphicID);
        if (graphic != null) {
            return graphic;

        }
        GraphicImage graphicImage = JSGraphicImage.mGraphicImageList.get(graphicID);
        if (graphicImage != null) {
            return graphicImage;
        }
        GraphicCircle graphicCircle = JSGraphicCircle.mGraphicCircleList.get(graphicID);
        if (graphicCircle != null) {
            return graphicCircle;
        }
        GraphicMultiPoint graphicMultiPoint = JSGraphicMultiPoint.mGraphicMultiPointList.get(graphicID);
        if (graphicMultiPoint != null) {
            return graphicMultiPoint;
        }
        GraphicPoint graphicPoint = JSGraphicPoint.mGraphicPointList.get(graphicID);
        if (graphicPoint != null) {
            return graphicPoint;
        }
        GraphicPolygon graphicPolygon = JSGraphicPolygon.mGraphicPolygonList.get(graphicID);
        if (graphicPolygon != null) {
            return graphicPolygon;
        }
        GraphicPolylin graphicPolylin = JSGraphicPolylin.mGraphicPolylinList.get(graphicID);
        if (graphicPolylin != null) {
            return graphicPolylin;
        }
        GraphicStippleLine graphicStippleLine = JSGraphicStippleLine.mGraphicStippleLineList.get(graphicID);
        if (graphicStippleLine != null) {
            return graphicStippleLine;
        }
        return graphic;
    }
}
