package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.android.tool.sketcheditor.SnappingOption;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * 捕捉选项Native功能组件
 * Created by xiaoying on 2019/9/10.
 */
public class JSSnappingOption extends ReactContextBaseJavaModule {
    private static final String REACT_CLASS = "JSSnappingOption";
    public static Map<String, SnappingOption> mSnappingOptionList = new HashMap<>();

    public JSSnappingOption(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public static SnappingOption getObjFromList(String id){
        return mSnappingOptionList.get(id);
    }

    public static String registerId(SnappingOption obj){
        for(Map.Entry entry : mSnappingOptionList.entrySet()){
            if(obj.equals(entry.getValue())){
                String id = (String) entry.getKey();
                return id;
            }
        }
        Calendar calendar = Calendar.getInstance();
        String id = Long.toString(calendar.getTimeInMillis());
        mSnappingOptionList.put(id,obj);
        return id;
    }

    @ReactMethod
    public void createObj(Promise promise){
        try {
            SnappingOption snappingOption = new SnappingOption();
            String snappingOptionId = registerId(snappingOption);

            WritableMap writableMap = Arguments.createMap();
            writableMap.putString("SnappingOptionId", snappingOptionId);
            promise.resolve(writableMap);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getPixelsTolerance(String snappingOptionId, Promise promise){
        try {
            SnappingOption snappingOption = getObjFromList(snappingOptionId);
            int pixelTolerance = snappingOption.getPixelsTolerance();

            promise.resolve(pixelTolerance);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setPixelsTolerance(String snappingOptionId, int pixelsTolerance, Promise promise){
        try {
            SnappingOption snappingOption = getObjFromList(snappingOptionId);
            snappingOption.setPixelsTolerance(pixelsTolerance);

            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void isSnappingVertex(String snappingOptionId, Promise promise){
        try {
            SnappingOption snappingOption = getObjFromList(snappingOptionId);
            boolean isSnappingVertex = snappingOption.isSnappingVertex();

            promise.resolve(isSnappingVertex);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setSnappingVertex(String snappingOptionId, boolean isSnappingVertex, Promise promise){
        try {
            SnappingOption snappingOption = getObjFromList(snappingOptionId);
            snappingOption.setSnappingVertex(isSnappingVertex);

            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void isSnappingMidVertex(String snappingOptionId, Promise promise){
        try {
            SnappingOption snappingOption = getObjFromList(snappingOptionId);
            boolean isSnappingMidVertex = snappingOption.isSnappingMidVertex();

            promise.resolve(isSnappingMidVertex);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setSnappingMidVertex(String snappingOptionId, boolean isSnappingMidVertex, Promise promise){
        try {
            SnappingOption snappingOption = getObjFromList(snappingOptionId);
            snappingOption.setSnappingMidVertex(isSnappingMidVertex);

            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void isSnappingPedal(String snappingOptionId, Promise promise){
        try {
            SnappingOption snappingOption = getObjFromList(snappingOptionId);
            boolean isSnappingPedal = snappingOption.isSnappingPedal();

            promise.resolve(isSnappingPedal);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setSnappingPedal(String snappingOptionId, boolean isSnappingPedal, Promise promise){
        try {
            SnappingOption snappingOption = getObjFromList(snappingOptionId);
            snappingOption.setSnappingPedal(isSnappingPedal);

            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void isSnappingNormalIntersection(String snappingOptionId, Promise promise){
        try {
            SnappingOption snappingOption = getObjFromList(snappingOptionId);
            boolean isSnappingNormalIntersection = snappingOption.isSnappingNormalIntersection();

            promise.resolve(isSnappingNormalIntersection);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setSnappingNormalIntersection(String snappingOptionId, boolean isSnappingNormalIntersection, Promise promise){
        try {
            SnappingOption snappingOption = getObjFromList(snappingOptionId);
            snappingOption.setSnappingNormalIntersection(isSnappingNormalIntersection);

            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void isSnappingHorizontalIntersection(String snappingOptionId, Promise promise){
        try {
            SnappingOption snappingOption = getObjFromList(snappingOptionId);
            boolean isSnappingHorizontalIntersection = snappingOption.isSnappingHorizontalIntersection();

            promise.resolve(isSnappingHorizontalIntersection);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setSnappingHorizontalIntersection(String snappingOptionId, boolean isSnappingHorizontalIntersection, Promise promise){
        try {
            SnappingOption snappingOption = getObjFromList(snappingOptionId);
            snappingOption.setSnappingHorizontalIntersection(isSnappingHorizontalIntersection);

            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void isSnappingVerticalIntersection(String snappingOptionId, Promise promise){
        try {
            SnappingOption snappingOption = getObjFromList(snappingOptionId);
            boolean isSnappingVerticalIntersection = snappingOption.isSnappingVerticalIntersection();

            promise.resolve(isSnappingVerticalIntersection);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setSnappingVerticalIntersection(String snappingOptionId, boolean isSnappingVerticalIntersection, Promise promise){
        try {
            SnappingOption snappingOption = getObjFromList(snappingOptionId);
            snappingOption.setSnappingVerticalIntersection(isSnappingVerticalIntersection);

            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }
}
