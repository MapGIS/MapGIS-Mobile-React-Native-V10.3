package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.core.map.LabelGeomType;
import com.zondy.mapgis.core.map.LinePlaceInfo;
import com.zondy.mapgis.core.map.PointPlaceInfo;
import com.zondy.mapgis.core.map.RegionPlaceInfo;
import com.zondy.mapgis.core.map.VectorLabel;
import com.zondy.mapgis.core.object.Enumeration;

/**
 * 矢量标注Native功能组件
 * Created by xiaoying on 2019/9/4.
 */
public class JSVectorLabel extends JSLabel {
    private static final String REACT_CLASS = "JSVectorLabel";

    public JSVectorLabel(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @ReactMethod
    public void getMinScale(String vectorLabelId, Promise promise){
        try {
            VectorLabel vectorLabel = (VectorLabel) getObjFromList(vectorLabelId);
            double minScale = vectorLabel.getMinScale();

            promise.resolve(minScale);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setMinScale(String vectorLabelId, double minScale, Promise promise){
        try {
            VectorLabel vectorLabel = (VectorLabel) getObjFromList(vectorLabelId);
            vectorLabel.setMinScale(minScale);

            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getMaxScale(String vectorLabelId, Promise promise){
        try {
            VectorLabel vectorLabel = (VectorLabel) getObjFromList(vectorLabelId);
            double maxScale = vectorLabel.getMaxScale();

            promise.resolve(maxScale);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setMaxScale(String vectorLabelId, double maxScale, Promise promise){
        try {
            VectorLabel vectorLabel = (VectorLabel) getObjFromList(vectorLabelId);
            vectorLabel.setMaxScale(maxScale);

            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getLabelGeomType(String vectorLabelId, Promise promise){
        try {
            VectorLabel vectorLabel = (VectorLabel) getObjFromList(vectorLabelId);
            int labelGeomType = vectorLabel.getLabelGeomType().value();

            promise.resolve(labelGeomType);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setLabelGeomType(String vectorLabelId, int labelGeomType, Promise promise){
        try {
            VectorLabel vectorLabel = (VectorLabel) getObjFromList(vectorLabelId);
            LabelGeomType labelGeomType1 = (LabelGeomType) Enumeration.parse(LabelGeomType.class, labelGeomType);
            vectorLabel.setLabelGeomType(labelGeomType1);

            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getPntPlaceInfo(String vectorLabelId, Promise promise){
        try {
            VectorLabel vectorLabel = (VectorLabel) getObjFromList(vectorLabelId);
            PointPlaceInfo pointPlaceInfo = vectorLabel.getPntPlaceInfo();
            String id = JSPointPlaceInfo.registerId(pointPlaceInfo);

            WritableMap writableMap = Arguments.createMap();
            writableMap.putString("PointPlaceInfoId", id);
            promise.resolve(writableMap);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setPntPlaceInfo(String vectorLabelId, String pntPlaceInfoId, Promise promise){
        try {
            VectorLabel vectorLabel = (VectorLabel) getObjFromList(vectorLabelId);
            PointPlaceInfo pointPlaceInfo = JSPointPlaceInfo.getObjFromList(pntPlaceInfoId);
            vectorLabel.setPntPlaceInfo(pointPlaceInfo);

            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getLinPlaceInfo(String vectorLabelId, Promise promise){
        try {
            VectorLabel vectorLabel = (VectorLabel) getObjFromList(vectorLabelId);
            LinePlaceInfo linePlaceInfo = vectorLabel.getLinPlaceInfo();
            String id = JSLinePlaceInfo.registerId(linePlaceInfo);

            WritableMap writableMap = Arguments.createMap();
            writableMap.putString("LinePlaceInfoId", id);
            promise.resolve(writableMap);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setLinPlaceInfo(String vectorLabelId, String linePlaceInfoId, Promise promise){
        try {
            VectorLabel vectorLabel = (VectorLabel) getObjFromList(vectorLabelId);
            LinePlaceInfo linePlaceInfo = JSLinePlaceInfo.getObjFromList(linePlaceInfoId);
            vectorLabel.setLinPlaceInfo(linePlaceInfo);

            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getRegPlaceInfo(String vectorLabelId, Promise promise){
        try {
            VectorLabel vectorLabel = (VectorLabel) getObjFromList(vectorLabelId);
            RegionPlaceInfo regionPlaceInfo = vectorLabel.getRegPlaceInfo();
            String regionPlaceInfoId = JSRegionPlaceInfo.registerId(regionPlaceInfo);

            WritableMap writableMap = Arguments.createMap();
            writableMap.putString("RegionPlaceInfoId", regionPlaceInfoId);
            promise.resolve(writableMap);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setRegPlaceInfo(String vectorLabelId, String regionPlaceInfoId, Promise promise){
        try {
            VectorLabel vectorLabel = (VectorLabel) getObjFromList(vectorLabelId);
            RegionPlaceInfo regionPlaceInfo = JSRegionPlaceInfo.getObjFromList(regionPlaceInfoId);
            vectorLabel.setRegPlaceInfo(regionPlaceInfo);

            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getLabelClientOutSide(String vectorLabelId, Promise promise){
        try {
            VectorLabel vectorLabel = (VectorLabel) getObjFromList(vectorLabelId);
            boolean result = vectorLabel.getLabelClientOutSide();

            promise.resolve(result);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setLabelClientOutSide(String vectorLabelId, boolean newVal, Promise promise){
        try {
            VectorLabel vectorLabel = (VectorLabel) getObjFromList(vectorLabelId);
            vectorLabel.setLabelClientOutSide(newVal);

            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void toXML(String vectorLabelId, Promise promise){
        try {
            VectorLabel vectorLabel = (VectorLabel) getObjFromList(vectorLabelId);
            String xml = vectorLabel.toXML();

            promise.resolve(xml);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void fromXML(String vectorLabelId, String strXML, Promise promise){
        try {
            VectorLabel vectorLabel = (VectorLabel) getObjFromList(vectorLabelId);
            boolean result = vectorLabel.fromXML(strXML);

            promise.resolve(result);
        }catch (Exception e){
            promise.reject(e);
        }
    }
}
