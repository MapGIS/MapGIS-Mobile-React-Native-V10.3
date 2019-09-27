package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.core.geometry.GeomType;
import com.zondy.mapgis.core.info.GeomInfo;
import com.zondy.mapgis.core.map.ClassItemValue;
import com.zondy.mapgis.core.map.MultiClassThemeInfo;
import com.zondy.mapgis.core.object.Enumeration;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nullable;

/**
 * 多表达式分段专题图项Native功能组件
 * Created by xiaoying on 2019/9/2.
 */
public class JSMultiClassThemeInfo extends ReactContextBaseJavaModule {
    private static final String REACT_CLASS = "JSMultiClassThemeInfo";
    public static Map<String, MultiClassThemeInfo> mMultiClassThemeInfoList = new HashMap<>();

    public JSMultiClassThemeInfo(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public static MultiClassThemeInfo getObjFromList(String id) {
        return mMultiClassThemeInfoList.get(id);
    }

    public static String registerId(MultiClassThemeInfo obj) {
        for (Map.Entry entry : mMultiClassThemeInfoList.entrySet()) {
            if (obj.equals(entry.getValue())) {
                String id = (String) entry.getKey();
                return id;
            }
        }
        Calendar calendar = Calendar.getInstance();
        String id = Long.toString(calendar.getTimeInMillis());
        mMultiClassThemeInfoList.put(id, obj);
        return id;
    }

    @ReactMethod
    public void createObj(Promise promise) {
        try {
            MultiClassThemeInfo multiClassThemeInfo = new MultiClassThemeInfo();
            String multiClassThemeInfoId = registerId(multiClassThemeInfo);

            WritableMap writableMap = Arguments.createMap();
            writableMap.putString("MultiClassThemeInfoId", multiClassThemeInfoId);
            promise.resolve(writableMap);

        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getCount(String multiClassThemeInfoId, Promise promise) {
        try {
            MultiClassThemeInfo multiClassThemeInfo = getObjFromList(multiClassThemeInfoId);
            int count = (int) multiClassThemeInfo.getCount();
            promise.resolve(count);

        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getValues(String multiClassThemeInfoId, Promise promise) {
        try {
            MultiClassThemeInfo multiClassThemeInfo = getObjFromList(multiClassThemeInfoId);
            ClassItemValue[] classItemValues = multiClassThemeInfo.getValues(); // 1、获取ClassItemValues

            WritableArray writableArray = Arguments.createArray();             // 2、生成WritableArray，用于存储ClassItemValue对应的Id

            for(int i = 0; i < classItemValues.length; i++){                   // 3、遍历classtemValues,并生成每个ClassItemValue对应的ClassItemValueId
                String classItemValueId = JSClassItemValue.registerId(classItemValues[i]);
                writableArray.pushString(classItemValueId);
            }

            promise.resolve(writableArray);                                   // 4、返回writeableArray

        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getCaption(String multiClassThemeInfoId, Promise promise){
        try {
            MultiClassThemeInfo multiClassThemeInfo = getObjFromList(multiClassThemeInfoId);
            String caption = multiClassThemeInfo.getCaption();
            promise.resolve(caption);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setCaption(String multiClassThemeInfoId, String caption, Promise promise){
        try {
            MultiClassThemeInfo multiClassThemeInfo = getObjFromList(multiClassThemeInfoId);
            multiClassThemeInfo.setCaption(caption);
            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getVisible(String multiClassThemeInfoId, Promise promise){
        try {
            MultiClassThemeInfo multiClassThemeInfo = getObjFromList(multiClassThemeInfoId);
            boolean visible = multiClassThemeInfo.getVisible();
            promise.resolve(visible);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setVisible(String multiClassThemeInfoId, boolean visible, Promise promise){
        try {
            MultiClassThemeInfo multiClassThemeInfo = getObjFromList(multiClassThemeInfoId);
            multiClassThemeInfo.setVisible(visible);
            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getMinScale(String multiClassThemeInfoId, Promise promise){
        try {
            MultiClassThemeInfo multiClassThemeInfo = getObjFromList(multiClassThemeInfoId);
            double minScale = multiClassThemeInfo.getMinScale();
            promise.resolve(minScale);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setMinScale(String multiClassThemeInfoId, double minScale, Promise promise){
        try {
            MultiClassThemeInfo multiClassThemeInfo = getObjFromList(multiClassThemeInfoId);
            multiClassThemeInfo.setMinScale(minScale);
            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getMaxScale(String multiClassThemeInfoId, Promise promise){
        try {
            MultiClassThemeInfo multiClassThemeInfo = getObjFromList(multiClassThemeInfoId);
            double maxScale = multiClassThemeInfo.getMaxScale();
            promise.resolve(maxScale);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setMaxScale(String multiClassThemeInfoId, double maxScale, Promise promise){
        try {
            MultiClassThemeInfo multiClassThemeInfo = getObjFromList(multiClassThemeInfoId);
            multiClassThemeInfo.setMaxScale(maxScale);
            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void copy(String multiClassThemeInfoId, String srcMultiClassThemeInfoId, Promise promise)
    {
        try {
            MultiClassThemeInfo multiClassThemeInfo = getObjFromList(multiClassThemeInfoId);
            MultiClassThemeInfo srcMultiClassThemeInfo = getObjFromList(srcMultiClassThemeInfoId);
            boolean result = multiClassThemeInfo.copy(srcMultiClassThemeInfo);
            promise.resolve(result);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setValue(String multiClassThemeInfoId, int index, String classItemValueId, Promise promise){
        try {
            MultiClassThemeInfo multiClassThemeInfo = getObjFromList(multiClassThemeInfoId);
            ClassItemValue classItemValue = JSClassItemValue.getObjFromList(classItemValueId);
            boolean result = multiClassThemeInfo.setValue(index, classItemValue);
            promise.resolve(result);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getValue(String multiClassThemeInfoId, int index, Promise promise){
        try {
            MultiClassThemeInfo multiClassThemeInfo = getObjFromList(multiClassThemeInfoId);
            ClassItemValue classItemValue = multiClassThemeInfo.getValue(index);

            String classItemValueId = JSClassItemValue.registerId(classItemValue);

            WritableMap writableMap = Arguments.createMap();
            writableMap.putString("ClassItemValueId",classItemValueId);
            promise.resolve(writableMap);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getGeoInfo(String multiClassThemeInfoId, int geomType, Promise promise){
        try {
            MultiClassThemeInfo multiClassThemeInfo = getObjFromList(multiClassThemeInfoId);
            GeomType geomType1 = (GeomType) Enumeration.parse(GeomType.class, geomType);
            GeomInfo geomInfo = multiClassThemeInfo.getGeoInfo(geomType1);
            String geomInfoId = null;
            if (geomInfo != null){
                geomInfoId = JSGeomInfo.registerId(geomInfo);
            }
            WritableMap writableMap = Arguments.createMap();
            writableMap.putString("GeomInfoId", geomInfoId);
            promise.resolve(writableMap);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setGeoInfo(String multiClassThemeInfoId, String geomInfoId, int geomType, Promise promise){
        try {
            MultiClassThemeInfo multiClassThemeInfo = getObjFromList(multiClassThemeInfoId);
            GeomInfo geomInfo = JSGeomInfo.getObjFromList(geomInfoId);
            GeomType geomType1 = (GeomType) Enumeration.parse(GeomType.class, geomType);
            boolean result = multiClassThemeInfo.setGeoInfo(geomInfo, geomType1);

            promise.resolve(result);
        }catch (Exception e){
            promise.reject(e);
        }
    }
}
