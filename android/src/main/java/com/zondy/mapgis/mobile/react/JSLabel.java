package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.zondy.mapgis.core.map.Label;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 标签Native功能组件
 * Created by xiaoying on 2019/9/2.
 */
public class JSLabel extends ReactContextBaseJavaModule {
    private static final String REACT_CLASS = "JSLabel";
    public static Map<String, Label> mLabelList = new HashMap<>();

    public JSLabel(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public static Label getObjFromList(String id){
        return mLabelList.get(id);
    }

    public static String registerId(Label obj){
        for(Map.Entry entry : mLabelList.entrySet()){
            if(obj.equals(entry.getValue())){
                String id = (String) entry.getKey();
                return id;
            }
        }
        Calendar calendar = Calendar.getInstance();
        String id = Long.toString(calendar.getTimeInMillis());
        mLabelList.put(id,obj);
        return id;
    }

    @ReactMethod
    public void getType(String labelId, Promise promise){
        try {
            Label label = getObjFromList(labelId);
            int labelType = label.getType().value();
            promise.resolve(labelType);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getVisible(String labelId, Promise promise){
        try {
            Label label = getObjFromList(labelId);
            boolean visible = label.getVisible();
            promise.resolve(visible);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setVisible(String labelId, boolean visible, Promise promise){
        try {
            Label label = getObjFromList(labelId);
            label.setVisible(visible);
            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getName(String labelId, Promise promise){
        try {
            Label label = getObjFromList(labelId);
            String name = label.getName();
            promise.resolve(name);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setName(String labelId, String name, Promise promise){
        try {
            Label label = getObjFromList(labelId);
            label.setName(name);
            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

}
