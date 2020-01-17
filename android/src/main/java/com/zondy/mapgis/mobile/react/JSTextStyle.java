package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.android.tool.sketcheditor.TextStyle;
import com.zondy.mapgis.mobile.react.utils.ConvertUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 文本样式Native功能组件
 * Created by xiaoying on 2019/9/10.
 */
public class JSTextStyle extends ReactContextBaseJavaModule {
    private static final String REACT_CLASS = "JSTextStyle";
    private static Map<String, TextStyle> mTextStyleList = new HashMap<>();

    public JSTextStyle(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public static TextStyle getObjFromList(String id){
        return mTextStyleList.get(id);
    }

    public static String registerId(TextStyle obj){
        for(Map.Entry entry : mTextStyleList.entrySet()){
            if(obj.equals(entry.getValue())){
                String id = (String) entry.getKey();
                return id;
            }
        }
        String id = UUID.randomUUID().toString().substring(24);
        mTextStyleList.put(id,obj);
        return id;
    }

    @ReactMethod
    public void createObj(Promise promise){
        try {
            TextStyle textStyle = new TextStyle();
            String textStyleId = registerId(textStyle);
            WritableMap writableMap = Arguments.createMap();
            writableMap.putString("TextStyleId", textStyleId);

            promise.resolve(writableMap);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void createObjByCS(String color, float size, Promise promise){
        try {
            int textColor = ConvertUtil.ColorRGBAToInt(color);
            TextStyle textStyle = new TextStyle(textColor, size);
            String textStyleId = registerId(textStyle);
            WritableMap writableMap = Arguments.createMap();
            writableMap.putString("TextStyleId", textStyleId);

            promise.resolve(writableMap);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getColor(String textStyleId, Promise promise){
        try {
            TextStyle textStyle = getObjFromList(textStyleId);
            int color = textStyle.getColor();
            String strColor = ConvertUtil.ColorIntToRGBA(color);

            promise.resolve(strColor);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setColor(String textStyleId, String color, Promise promise){
        try {
            TextStyle textStyle = getObjFromList(textStyleId);
            int textColor = ConvertUtil.ColorRGBAToInt(color);
            textStyle.setColor(textColor);

            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getSize(String textStyleId, Promise promise){
        try {
            TextStyle textStyle = getObjFromList(textStyleId);
            float size = textStyle.getSize();

            promise.resolve(size);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setSize(String textStyleId, float size, Promise promise){
        try {
            TextStyle textStyle = getObjFromList(textStyleId);
            textStyle.setSize(size);

            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }
}
