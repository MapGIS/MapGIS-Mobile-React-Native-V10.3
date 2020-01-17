package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.android.tool.sketcheditor.MeasureOption;
import com.zondy.mapgis.android.tool.sketcheditor.MeasureResultContentWillChangeListener;

import java.util.HashMap;
import java.util.UUID;

/**
 * 量算参数选项类
 *
 * Created by xiaoying on 2019/12/28.
 */
public class JSMeasureOption extends ReactContextBaseJavaModule {
    private static final String REACT_CLASS = "JSMeasureOption";
    private static HashMap<String, MeasureOption> mMeasureOptionList = new HashMap<>();

    private String mFormatDigit = "###0.00";
    private boolean mIsShowDistanceUnit = true; // 是否显示长度单位
    private boolean mIsShowAreaUnit = true; // 是否显示面积单位
    private boolean mIsAutoChangeDistanceUnit = true; // 是否自动改变长度单位
    private boolean mIsAutoChangeAreaUnit = true; // 是否自动改变面积单位

    private String mJSMeasureContentWillChangeListenerId = null; // 最初的自动改变单位的监听

    public JSMeasureOption(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    public static String registerId(MeasureOption obj){
        for (java.util.Map.Entry entry : mMeasureOptionList.entrySet()) {
            if (obj.equals(entry.getValue())) {
                String id = (String) entry.getKey();
                return id;
            }
        }
        String id = UUID.randomUUID().toString().substring(24);
        mMeasureOptionList.put(id, obj);
        return id;
    }

    public static MeasureOption getObjFromList(String id) {
        return mMeasureOptionList.get(id);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @ReactMethod
    public void createObj(Promise promise){
        try {
            MeasureOption measureOption = new MeasureOption();
            String measureOptionId = registerId(measureOption);

            WritableMap writableMap = Arguments.createMap();
            writableMap.putString("MeasureOptionId", measureOptionId);
            promise.resolve(writableMap);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getIsShowTotalLength(String measureOptionId, Promise promise){
        try {
            MeasureOption measureOption = getObjFromList(measureOptionId);
            boolean isShowTotalLength = measureOption.getIsShowTotalLength();

            promise.resolve(isShowTotalLength);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setIsShowTotalLength(String measureOptionId, boolean isShowTotalLength, Promise promise){
        try {
            MeasureOption measureOption = getObjFromList(measureOptionId);
            measureOption.setIsShowTotalLength(isShowTotalLength);

            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setContentWillChangeListener(String measureOptionId, String contentWillChangeListenerId, Promise promise){
        try {
            MeasureOption measureOption = getObjFromList(measureOptionId);
            mJSMeasureContentWillChangeListenerId = contentWillChangeListenerId;

            JSMeasureContentWillChangeListener jsMeasureContentWillChangeListener = JSMeasureContentWillChangeListener.getObjFromList(contentWillChangeListenerId);
            MeasureResultContentWillChangeListener measureResultContentWillChangeListener = jsMeasureContentWillChangeListener.getMeasureResultContentWillChangeListener();

            measureOption.setContentWillChangeListener(measureResultContentWillChangeListener);
            promise.resolve(true);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getMeasureContentWillChangeListener(String measureOptionId, Promise promise){
        try {
            MeasureOption measureOption = getObjFromList(measureOptionId);

            promise.resolve(mJSMeasureContentWillChangeListenerId);
        }catch (Exception e){
            promise.reject(e);
        }
    }


}
