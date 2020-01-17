package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.android.tool.sketcheditor.FillStyle;
import com.zondy.mapgis.android.tool.sketcheditor.LineStyle;
import com.zondy.mapgis.android.tool.sketcheditor.MeasureType;
import com.zondy.mapgis.android.tool.sketcheditor.PointStyle;
import com.zondy.mapgis.android.tool.sketcheditor.SketchStyle;
import com.zondy.mapgis.android.tool.sketcheditor.TextStyle;
import com.zondy.mapgis.core.object.Enumeration;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 草图显示样式（进行编辑的几何或新采集的几何的外观表现）Native功能组件
 * Created by xiaoying on 2019/9/10.
 */
public class JSSketchStyle extends ReactContextBaseJavaModule {
    private static final String REACT_CLASS = "JSSketchStyle";
    private static Map<String, SketchStyle> mSketchStyleList = new HashMap<>();
    public JSSketchStyle(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public static SketchStyle getObjFromList(String id){
        return mSketchStyleList.get(id);
    }

    public static String registerId(SketchStyle obj){
        for(Map.Entry entry : mSketchStyleList.entrySet()){
            if(obj.equals(entry.getValue())){
                String id = (String) entry.getKey();
                return id;
            }
        }
        String id = UUID.randomUUID().toString().substring(24);
        mSketchStyleList.put(id,obj);
        return id;
    }

    @ReactMethod
    public void createObj(Promise promise){
        try {
            SketchStyle sketchStyle = new SketchStyle();
            String sketchStyleId = registerId(sketchStyle);

            WritableMap writableMap = Arguments.createMap();
            writableMap.putString("SketchStyleId", sketchStyleId);
            promise.resolve(writableMap);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getVertexStyle(String sketchStyleId, Promise promise){
        try {
            SketchStyle sketchStyle = getObjFromList(sketchStyleId);
            PointStyle pointStyle = sketchStyle.getVertexStyle();
            String pointStyleId = JSPointStyle.registerId(pointStyle);

            promise.resolve(pointStyleId);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setVertexStyle(String sketchStyleId, String pointStyleId, Promise promise){
        try {
            SketchStyle sketchStyle = getObjFromList(sketchStyleId);
            PointStyle pointStyle = JSPointStyle.getObjFromList(pointStyleId);
            sketchStyle.setVertexStyle(pointStyle);

            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getMidVertexStyle(String sketchStyleId, Promise promise){
        try {
            SketchStyle sketchStyle = getObjFromList(sketchStyleId);
            PointStyle pointStyle = sketchStyle.getMidVertexStyle();
            String pointStyleId = JSPointStyle.registerId(pointStyle);

            promise.resolve(pointStyleId);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setMidVertexStyle(String sketchStyleId, String pointStyleId, Promise promise){
        try {
            SketchStyle sketchStyle = getObjFromList(sketchStyleId);
            PointStyle pointStyle = JSPointStyle.getObjFromList(pointStyleId);
            sketchStyle.setMidVertexStyle(pointStyle);

            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getReferenceVertexStyle(String sketchStyleId, Promise promise){
        try {
            SketchStyle sketchStyle = getObjFromList(sketchStyleId);
            PointStyle pointStyle = sketchStyle.getReferenceVertexStyle();
            String pointStyleId = JSPointStyle.registerId(pointStyle);

            promise.resolve(pointStyleId);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setReferenceVertexStyle(String sketchStyleId, String pointStyleId, Promise promise){
        try {
            SketchStyle sketchStyle = getObjFromList(sketchStyleId);
            PointStyle pointStyle = JSPointStyle.getObjFromList(pointStyleId);
            sketchStyle.setReferenceVertexStyle(pointStyle);

            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getLineStyle(String sketchStyleId, Promise promise){
        try {
            SketchStyle sketchStyle = getObjFromList(sketchStyleId);
            LineStyle lineStyle = sketchStyle.getLineStyle();
            String lineStyleId = JSLineStyle.registerId(lineStyle);

            promise.resolve(lineStyleId);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setLineStyle(String sketchStyleId, String lineStyleId, Promise promise){
        try {
            SketchStyle sketchStyle = getObjFromList(sketchStyleId);
            LineStyle lineStyle = JSLineStyle.getObjFromList(lineStyleId);
            sketchStyle.setLineStyle(lineStyle);

            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getReferenceLineStyle(String sketchStyleId, Promise promise){
        try {
            SketchStyle sketchStyle = getObjFromList(sketchStyleId);
            LineStyle lineStyle = sketchStyle.getReferenceLineStyle();
            String lineStyleId = JSLineStyle.registerId(lineStyle);

            promise.resolve(lineStyleId);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setReferenceLineStyle(String sketchStyleId, String lineStyleId, Promise promise){
        try {
            SketchStyle sketchStyle = getObjFromList(sketchStyleId);
            LineStyle lineStyle = JSLineStyle.getObjFromList(lineStyleId);
            sketchStyle.setReferenceLineStyle(lineStyle);

            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getFillStyle(String sketchStyleId, Promise promise){
        try {
            SketchStyle sketchStyle = getObjFromList(sketchStyleId);
            FillStyle fillStyle = sketchStyle.getFillStyle();
            String fillStyleId = JSFillStyle.registerId(fillStyle);

            promise.resolve(fillStyleId);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setFillStyle(String sketchStyleId, String fillStyleId, Promise promise){
        try {
            SketchStyle sketchStyle = getObjFromList(sketchStyleId);
            FillStyle fillStyle = JSFillStyle.getObjFromList(fillStyleId);
            sketchStyle.setFillStyle(fillStyle);

            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getSelectedVertexStyle(String sketchStyleId, Promise promise){
        try {
            SketchStyle sketchStyle = getObjFromList(sketchStyleId);
            PointStyle pointStyle = sketchStyle.getSelectedVertexStyle();
            String pointStyleId = JSPointStyle.registerId(pointStyle);

            promise.resolve(pointStyleId);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setSelectedVertexStyle(String sketchStyleId, String pointStyleId, Promise promise){
        try {
            SketchStyle sketchStyle = getObjFromList(sketchStyleId);
            PointStyle pointStyle = JSPointStyle.getObjFromList(pointStyleId);
            sketchStyle.setSelectedVertexStyle(pointStyle);

            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getSelectedMidVertexStyle(String sketchStyleId, Promise promise){
        try {
            SketchStyle sketchStyle = getObjFromList(sketchStyleId);
            PointStyle pointStyle = sketchStyle.getSelectedMidVertexStyle();
            String pointStyleId = JSPointStyle.registerId(pointStyle);

            promise.resolve(pointStyleId);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setSelectedMidVertexStyle(String sketchStyleId, String pointStyleId, Promise promise){
        try {
            SketchStyle sketchStyle = getObjFromList(sketchStyleId);
            PointStyle pointStyle = JSPointStyle.getObjFromList(pointStyleId);
            sketchStyle.setSelectedMidVertexStyle(pointStyle);

            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getTextStyle(String sketchStyleId, Promise promise){
        try {
            SketchStyle sketchStyle = getObjFromList(sketchStyleId);
            TextStyle textStyle = sketchStyle.getTextStyle();
            String textStyleId = JSTextStyle.registerId(textStyle);

            promise.resolve(textStyleId);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setTextStyle(String sketchStyleId, String textStyleId, Promise promise){
        try {
            SketchStyle sketchStyle = getObjFromList(sketchStyleId);
            TextStyle textStyle = JSTextStyle.getObjFromList(textStyleId);
            sketchStyle.setTextStyle(textStyle);

            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void isShowVertexCoord(String sketchStyleId, Promise promise){
        try {
            SketchStyle sketchStyle = getObjFromList(sketchStyleId);
            boolean isShowVertexCoord = sketchStyle.isShowVertexCoord();

            promise.resolve(isShowVertexCoord);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setShowVertexCoord(String sketchStyleId, boolean isShowVertexCoord, Promise promise){
        try {
            SketchStyle sketchStyle = getObjFromList(sketchStyleId);
            sketchStyle.setShowVertexCoord(isShowVertexCoord);

            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void isShowSegmentLength(String sketchStyleId, Promise promise){
        try {
            SketchStyle sketchStyle = getObjFromList(sketchStyleId);
            boolean isShowSegmentLength = sketchStyle.isShowSegmentLength();

            promise.resolve(isShowSegmentLength);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setShowSegmentLength(String sketchStyleId, boolean isShowSegmentLength, Promise promise){
        try {
            SketchStyle sketchStyle = getObjFromList(sketchStyleId);
            sketchStyle.setShowSegmentLength(isShowSegmentLength);

            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void isShowArea(String sketchStyleId, Promise promise){
        try {
            SketchStyle sketchStyle = getObjFromList(sketchStyleId);
            boolean isShowArea = sketchStyle.isShowArea();

            promise.resolve(isShowArea);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setShowArea(String sketchStyleId, boolean isShowArea, Promise promise){
        try {
            SketchStyle sketchStyle = getObjFromList(sketchStyleId);
            sketchStyle.setShowArea(isShowArea);

            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void isVibrationEnabled(String sketchStyleId, Promise promise){
        try {
            SketchStyle sketchStyle = getObjFromList(sketchStyleId);
            boolean isVibrationEnabled = sketchStyle.isVibrationEnabled();

            promise.resolve(isVibrationEnabled);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setVibrationEnabled(String sketchStyleId, boolean isVibrationEnabled, Promise promise){
        try {
            SketchStyle sketchStyle = getObjFromList(sketchStyleId);
            sketchStyle.setVibrationEnabled(isVibrationEnabled);

            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getMeasureType(String sketchStyleId, Promise promise){
        try {
            SketchStyle sketchStyle = getObjFromList(sketchStyleId);
            int measureType = sketchStyle.getMeasureType().value();

            promise.resolve(measureType);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setMeasureType(String sketchStyleId, int measureType, Promise promise){
        try {
            SketchStyle sketchStyle = getObjFromList(sketchStyleId);
            MeasureType measureType1 = (MeasureType) Enumeration.parse(MeasureType.class, measureType);
            sketchStyle.setMeasureType(measureType1);

            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }
}
