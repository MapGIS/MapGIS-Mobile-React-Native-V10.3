package com.zondy.mapgis.mobile.react;

import android.view.Display;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.android.model.Model;
import com.zondy.mapgis.core.geometry.Dot3D;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nullable;

/**
 * 模型Native功能组件
 * Created by xiaoying on 2019/9/4.
 */
public class JSModel extends ReactContextBaseJavaModule {
    private static final String REACT_CLASS = "JSModel";
    public static Map<String, Model> mModelList = new HashMap<>();

    public JSModel(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public static Model getObjFromList(String id){
        return mModelList.get(id);
    }

    public static String registerId(Model obj){
        for (Map.Entry entry : mModelList.entrySet()) {
            if (obj.equals(entry.getValue())) {
                String id = (String) entry.getKey();
                return id;
            }
        }

        Calendar calendar = Calendar.getInstance();
        String id = Long.toString(calendar.getTimeInMillis());
        mModelList.put(id, obj);
        return id;
    }

    @ReactMethod
    public void createObj(Promise promise){
        try {
            Model model = new Model();
            String modelId = registerId(model);

            WritableMap writableMap = Arguments.createMap();
            writableMap.putString("ModelId", modelId);
            promise.resolve(writableMap);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setState(String modelId, int state, Promise promise){
        try {
            Model model = getObjFromList(modelId);
            model.setState(state);

            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getState(String modelId, Promise promise){
        try {
            Model model = getObjFromList(modelId);
            int state = model.getState();

            promise.resolve(state);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setName(String modelId, String name, Promise promise){
        try {
            Model model = getObjFromList(modelId);
            model.setName(name);

            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getName(String modelId, Promise promise){
        try {
            Model model = getObjFromList(modelId);
            String name = model.getName();

            promise.resolve(name);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setPosition(String modelId, Promise promise){
        try {

        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getPosition(String modelId, Promise promise){
        try {
            Model model = getObjFromList(modelId);
            Dot3D dot3D = model.getPosition();

        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setScaleX(String modelId, double scale, Promise promise){
        try {
            Model model = getObjFromList(modelId);
            model.setScaleX(scale);

            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getScaleX(String modelId, Promise promise){
        try {
            Model model = getObjFromList(modelId);
            double scaleX = model.getScaleX();

            promise.resolve(scaleX);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setScaleY(String modelId, double scale, Promise promise){
        try {
            Model model = getObjFromList(modelId);
            model.setScaleY(scale);

            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getScaleY(String modelId, Promise promise){
        try {
            Model model = getObjFromList(modelId);
            double scaleY = model.getScaleY();

            promise.resolve(scaleY);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setScaleZ(String modelId, double scale, Promise promise){
        try {
            Model model = getObjFromList(modelId);
            model.setScaleZ(scale);

            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getScaleZ(String modelId, Promise promise){
        try {
            Model model = getObjFromList(modelId);
            double scaleZ = model.getScaleZ();

            promise.resolve(scaleZ);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setAngleAroundX(String modelId, float angle, Promise promise){
        try {
            Model model = getObjFromList(modelId);
            model.setAngleAroundX(angle);

            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getAngleAroundX(String modelId, Promise promise){
        try {
            Model model = getObjFromList(modelId);
            float angleAroundX = model.getAngleAroundX();

            promise.resolve(angleAroundX);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setAngleAroundY(String modelId, float angle, Promise promise){
        try {
            Model model = getObjFromList(modelId);
            model.setAngleAroundY(angle);

            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getAngleAroundY(String modelId, Promise promise){
        try {
            Model model = getObjFromList(modelId);
            float angleAroundY = model.getAngleAroundY();

            promise.resolve(angleAroundY);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setAngleAroundZ(String modelId, float angle, Promise promise){
        try {
            Model model = getObjFromList(modelId);
            model.setAngleAroundZ(angle);

            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getAngleAroundZ(String modelId, Promise promise){
        try {
            Model model = getObjFromList(modelId);
            float angleAroundZ = model.getAngleAroundZ();

            promise.resolve(angleAroundZ);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setShowBoundingBox(String modelId, boolean show, Promise promise){
        try {
            Model model = getObjFromList(modelId);
            model.setShowBoundingBox(show);

            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void isShowBoundingBox(String modelId, Promise promise){
        try {
            Model model = getObjFromList(modelId);
            boolean result = model.isShowBoundingBox();

            promise.resolve(result);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void loadDataFromFile(String modelId, String strModelFile, Promise promise){
        try {
            Model model = getObjFromList(modelId);
            boolean result = model.loadDataFromFile(strModelFile);

            promise.resolve(result);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void saveDataToFile(String modelId, String strModelFile, Promise promise){
        try {
            Model model = getObjFromList(modelId);
            boolean result = model.saveDataToFile(strModelFile);

            promise.resolve(result);
        }catch (Exception e){
            promise.reject(e);
        }
    }
}
