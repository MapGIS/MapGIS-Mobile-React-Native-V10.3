package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.core.map.LabelInfo;
import com.zondy.mapgis.core.map.SimpleLabel;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * 简单标注Native功能组件
 * Created by xiaoying on 2019/9/3.
 */
public class JSSimpleLabel extends JSGeneralVectorLabel {
    private static final String REACT_CLASS = "JSSimpleLabel";

    public JSSimpleLabel(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @ReactMethod
    public void createObj(Promise promise){
        try {
            SimpleLabel simpleLabel = new SimpleLabel();
            String simpleLabelId = registerId(simpleLabel);

            WritableMap writableMap = Arguments.createMap();
            writableMap.putString("SimpleLabelId", simpleLabelId);
            promise.resolve(writableMap);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getInfo(String simpleLabelId, Promise promise){
        try {
            SimpleLabel simpleLabel = (SimpleLabel) getObjFromList(simpleLabelId);
            LabelInfo labelInfo = simpleLabel.getInfo();

            String labelInfoId = JSLabelInfo.registerId(labelInfo);

            WritableMap writableMap = Arguments.createMap();
            writableMap.putString("LabelInfoId", labelInfoId);
            promise.resolve(writableMap);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setInfo(String simpleLabelId, String labelInfoId, Promise promise){
        try {
            SimpleLabel simpleLabel = (SimpleLabel) getObjFromList(simpleLabelId);
            LabelInfo labelInfo = JSLabelInfo.getObjFromList(labelInfoId);

            simpleLabel.setInfo(labelInfo);
            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

}
