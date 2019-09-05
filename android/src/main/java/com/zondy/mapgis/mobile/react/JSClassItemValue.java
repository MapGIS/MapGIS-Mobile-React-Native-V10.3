package com.zondy.mapgis.mobile.react;

import android.util.Log;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.core.map.ClassItemType;
import com.zondy.mapgis.core.map.ClassItemValue;
import com.zondy.mapgis.core.object.Enumeration;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.RegEx;

public class JSClassItemValue extends ReactContextBaseJavaModule {
    private static final String REACT_CLASS = "JSClassItemValue";
    public static Map<String, ClassItemValue> mClassItemValueList = new HashMap<>();

    public JSClassItemValue(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public static ClassItemValue getObjFromList(String id){
        return mClassItemValueList.get(id);
    }

    public static String registerId(ClassItemValue obj){
        for(Map.Entry entry : mClassItemValueList.entrySet()){
            if(obj.equals(entry.getValue())){
                String id = (String) entry.getKey();
                return id;
            }
        }
        Calendar calendar = Calendar.getInstance();
        String id = Long.toString(calendar.getTimeInMillis());
        mClassItemValueList.put(id,obj);
        return id;
    }

    @ReactMethod
    public void createObj(Promise promise){
        try {
            ClassItemValue classItemValue = new ClassItemValue();
            String classItemValueId = registerId(classItemValue);

            WritableMap map = Arguments.createMap();
            map.putString("ClassItemValueId",classItemValueId);
            promise.resolve(map);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getType(String classItemValueId, Promise promise){
        try {
            ClassItemValue classItemValue = getObjFromList(classItemValueId);
            ClassItemType classItemType = classItemValue.getType();
            int type = classItemType.value();
            promise.resolve(type);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setType(String classItemValueId, int type, Promise promise){
        try {
            ClassItemValue classItemValue = getObjFromList(classItemValueId);
            ClassItemType classItemType = (ClassItemType) Enumeration.parse(ClassItemType.class,type);
            classItemValue.setType(classItemType);

            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getStartValue(String classItemValueId, Promise promise){
        try {
            ClassItemValue classItemValue = getObjFromList(classItemValueId);
            String startValue = classItemValue.getStartValue();

            promise.resolve(startValue);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
   public void setStartValue(String classItemValueId, String startValue, Promise promise){
        try {
            ClassItemValue classItemValue = getObjFromList(classItemValueId);
            classItemValue.setStartValue(startValue);
            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
   }

   @ReactMethod
   public void getEndValue(String classItemValueId, Promise promise){
        try {
            ClassItemValue classItemValue = getObjFromList(classItemValueId);
            String endValue = classItemValue.getEndValue();
            promise.resolve(endValue);
        }catch (Exception e){
            promise.reject(e);
        }
   }

   @ReactMethod
   public void setEndValue(String classItemValueId, String endValue, Promise promise){
        try {
            ClassItemValue classItemValue = getObjFromList(classItemValueId);
            classItemValue.setEndValue(endValue);

            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
   }
}
