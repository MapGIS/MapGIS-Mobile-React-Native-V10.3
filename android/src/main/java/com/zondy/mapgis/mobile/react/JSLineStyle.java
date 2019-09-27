package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.android.tool.sketcheditor.LineStyle;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * 线样式（实线）Native功能组件
 *
 * Created by xiaoying on 2019/9/10.
 */
public class JSLineStyle extends ReactContextBaseJavaModule {
    private static final String REACT_CLASS = "JSLineStyle";
    public static Map<String, LineStyle> mLineStyleList = new HashMap<>();

    public JSLineStyle(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public static LineStyle getObjFromList(String id){
        return mLineStyleList.get(id);
    }

    public static String registerId(LineStyle obj){
        for(Map.Entry entry : mLineStyleList.entrySet()){
            if(obj.equals(entry.getValue())){
                String id = (String) entry.getKey();
                return id;
            }
        }
        Calendar calendar = Calendar.getInstance();
        String id = Long.toString(calendar.getTimeInMillis());
        mLineStyleList.put(id,obj);
        return id;
    }

    @ReactMethod
    public void createObj(Promise promise){
        try {
            LineStyle lineStyle = new LineStyle();
            String lineStyleId = registerId(lineStyle);
            WritableMap writableMap = Arguments.createMap();
            writableMap.putString("LineStyleId", lineStyleId);

            promise.resolve(writableMap);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void createObjByCW(int color, float width, Promise promise){
        try {
            LineStyle lineStyle = new LineStyle(color, width);
            String lineStyleId = registerId(lineStyle);
            WritableMap writableMap = Arguments.createMap();
            writableMap.putString("LineStyleId", lineStyleId);

            promise.resolve(writableMap);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getColor(String lineStyleId, Promise promise){
        try {
            LineStyle lineStyle = getObjFromList(lineStyleId);
            int color = lineStyle.getColor();

            promise.resolve(color);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setColor(String lineStyleId, int color, Promise promise){
        try {
            LineStyle lineStyle = getObjFromList(lineStyleId);
            lineStyle.setColor(color);

            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getWidth(String lineStyleId, Promise promise){
        try {
            LineStyle lineStyle = getObjFromList(lineStyleId);
            float width = lineStyle.getWidth();

            promise.resolve(width);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setWidth(String lineStyleId, float width, Promise promise){
        try {
            LineStyle lineStyle = getObjFromList(lineStyleId);
            lineStyle.setWidth(width);

            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }
}
