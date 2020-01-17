package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.core.info.GeomInfo;
import com.zondy.mapgis.core.map.GeneralVectorLabel;
import com.zondy.mapgis.core.map.LabelBackType;
import com.zondy.mapgis.core.object.Enumeration;

/**
 * Created by xiaoying on 2019/8/28.
 */
public class JSGeneralVectorLabel extends JSVectorLabel {
    private static final String REACT_CLASS = "JSGeneralVectorLabel";

    public JSGeneralVectorLabel(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @ReactMethod
    public void getLabelExpression(String generalVectorLabelId, Promise promise){
        try {
            GeneralVectorLabel generalVectorLabel = (GeneralVectorLabel) getObjFromList(generalVectorLabelId);
            String labelExpression = generalVectorLabel.getLabelExpression();
            promise.resolve(labelExpression);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setLabelExpression(String generalVectorLabelId, String lableExpression, Promise promise){
        try {
            GeneralVectorLabel generalVectorLabel = (GeneralVectorLabel) getObjFromList(generalVectorLabelId);
            generalVectorLabel.setLabelExpression(lableExpression);
            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getLabelBackType(String generalVectorLabelId, Promise promise){
        try {
            GeneralVectorLabel generalVectorLabel = (GeneralVectorLabel) getObjFromList(generalVectorLabelId);
            int labelBackType = generalVectorLabel.getLabelBackType().value();
            promise.resolve(labelBackType);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setLabelBackType(String generalVectorLabelId, int labelBackType, Promise promise){
        try {
            GeneralVectorLabel generalVectorLabel = (GeneralVectorLabel) getObjFromList(generalVectorLabelId);
            LabelBackType labelBackType1 = (LabelBackType) Enumeration.parse(LabelBackType.class,labelBackType);
            generalVectorLabel.setLabelBackType(labelBackType1);
            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    /**
     * 此方法SDK中目前只返回线
     * @param generalVectorLabelId
     * @param promise
     */
    @ReactMethod
    public void getBackGeoInfo(String generalVectorLabelId, Promise promise){
        try {
            GeneralVectorLabel generalVectorLabel = (GeneralVectorLabel) getObjFromList(generalVectorLabelId);
            GeomInfo geomInfo = generalVectorLabel.getBackGeoInfo();
            String geomInfoId = null;
            if(geomInfo != null){
                geomInfoId = JSGeomInfo.registerId(geomInfo);
            }
            WritableMap writableMap = Arguments.createMap();
            writableMap.putString("geomInfoId", geomInfoId);
            promise.resolve(writableMap);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setBackGeoInfo(String generalVectorLabelId, String geomInfoId, Promise promise){
        try {
            GeneralVectorLabel generalVectorLabel = (GeneralVectorLabel) getObjFromList(generalVectorLabelId);
            GeomInfo geomInfo = JSGeomInfo.getObjFromList(geomInfoId);
            generalVectorLabel.setBackGeoInfo(geomInfo);

            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getNumericPrecision(String generalVectorLabelId, Promise promise){
        try {
            GeneralVectorLabel generalVectorLabel = (GeneralVectorLabel) getObjFromList(generalVectorLabelId);
            int numericPrecision = generalVectorLabel.getNumericPrecision();
            promise.resolve(numericPrecision);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setNumericPrecision(String generalVectorLabelId, int numericPrecision, Promise promise){
        try {
            GeneralVectorLabel generalVectorLabel = (GeneralVectorLabel) getObjFromList(generalVectorLabelId);
            generalVectorLabel.setNumericPrecision((short) numericPrecision);
            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getNewLineToLabel(String generalVectorLabelId, Promise promise){
        try {
            GeneralVectorLabel generalVectorLabel = (GeneralVectorLabel) getObjFromList(generalVectorLabelId);
            boolean newLineToLabel = generalVectorLabel.getNewLineToLabel();
            promise.resolve(newLineToLabel);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setNewLineToLabel(String generalVectorLabelId, boolean newLineToLabel, Promise promise){
        try {
            GeneralVectorLabel generalVectorLabel = (GeneralVectorLabel) getObjFromList(generalVectorLabelId);
            generalVectorLabel.setNewLineToLabel(newLineToLabel);
            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getMaxLengthPreLine(String generalVectorLabelId, Promise promise){
        try {
            GeneralVectorLabel generalVectorLabel = (GeneralVectorLabel) getObjFromList(generalVectorLabelId);
            int maxLengthPreLine = generalVectorLabel.getMaxLengthPreLine();

            promise.resolve(maxLengthPreLine);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setMaxLengthPreLine(String generalVectorLabelId, int maxLengthPreLine, Promise promise){
        try {
            GeneralVectorLabel generalVectorLabel = (GeneralVectorLabel) getObjFromList(generalVectorLabelId);
            generalVectorLabel.setMaxLengthPreLine((short) maxLengthPreLine);

            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }


}
