package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.android.tool.sketcheditor.FillStyle;
import com.zondy.mapgis.android.tool.sketcheditor.LineStyle;
import com.zondy.mapgis.mobile.react.utils.ConvertUtil;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.PropertyResourceBundle;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 区样式（纯色填充）Native功能组件
 * Created by xiaoying on 2019/9/10.
 */
public class JSFillStyle extends ReactContextBaseJavaModule {
    private static final String REACT_CLASS = "JSFillStyle";
    public static Map<String, FillStyle> mFillStyleList = new HashMap<>();

    public JSFillStyle(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public static FillStyle getObjFromList(String id){
        return mFillStyleList.get(id);
    }

    public static String registerId(FillStyle obj){
        for(Map.Entry entry : mFillStyleList.entrySet()){
            if(obj.equals(entry.getValue())){
                String id = (String) entry.getKey();
                return id;
            }
        }
        Calendar calendar = Calendar.getInstance();
        String id = Long.toString(calendar.getTimeInMillis());
        mFillStyleList.put(id,obj);
        return id;
    }

    @ReactMethod
    public void createObj(Promise promise){
        try {
            FillStyle fillStyle = new FillStyle();
            String fillStyleId = registerId(fillStyle);
            WritableMap writableMap = Arguments.createMap();
            writableMap.putString("FillStyleId", fillStyleId);
            promise.resolve(writableMap);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void createObjCL(String color, String lineStyleId, Promise promise){
        try {
            LineStyle lineStyle = JSLineStyle.getObjFromList(lineStyleId);
            int fillColor = ConvertUtil.ColorRGBAToInt(color);

            FillStyle fillStyle = new FillStyle(fillColor, lineStyle);
            String fillStyleId = registerId(fillStyle);
            WritableMap writableMap = Arguments.createMap();
            writableMap.putString("FillStyleId", fillStyleId);

            promise.resolve(writableMap);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getColor(String fillStyleId, Promise promise){
        try {
            FillStyle fillStyle = getObjFromList(fillStyleId);
            int color = fillStyle.getColor();
            String strColor = ConvertUtil.ColorIntToRGBA(color);

            promise.resolve(strColor);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setColor(String fillStyleId, String color, Promise promise){
        try {
            FillStyle fillStyle = getObjFromList(fillStyleId);
            int fillColor = ConvertUtil.ColorRGBAToInt(color);
            fillStyle.setColor(fillColor);

            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getLineStyle(String fillStyleId, Promise promise){
        try {
            FillStyle fillStyle = getObjFromList(fillStyleId);
            LineStyle lineStyle = fillStyle.getLineStyle();
            String lineStyleId = JSLineStyle.registerId(lineStyle);
            WritableMap writableMap = Arguments.createMap();
            writableMap.putString("LineStyleId", lineStyleId);

            promise.resolve(writableMap);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setLineStyle(String fillStyleId, String lineStyleId, Promise promise){
        try {
            FillStyle fillStyle = getObjFromList(fillStyleId);
            LineStyle lineStyle = JSLineStyle.getObjFromList(lineStyleId);
            fillStyle.setLineStyle(lineStyle);

            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }
}
