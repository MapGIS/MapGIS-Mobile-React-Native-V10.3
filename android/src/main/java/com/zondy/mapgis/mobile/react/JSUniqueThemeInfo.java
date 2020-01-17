package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.core.map.UniqueThemeInfo;

/**
 * 唯一值专题图项Native功能组件
 * Created by xiaoying on 2019/9/4.
 */
public class JSUniqueThemeInfo extends JSThemeInfo {
    private static final String REACT_CLASS = "JSUniqueThemeInfo";

    public JSUniqueThemeInfo(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @ReactMethod
    public void createObj(Promise promise){
        try {
            UniqueThemeInfo uniqueThemeInfo = new UniqueThemeInfo();
            String uniqueThemeInfoId = registerId(uniqueThemeInfo);

            WritableMap writableMap = Arguments.createMap();
            writableMap.putString("UniqueThemeInfoId", uniqueThemeInfoId);
            promise.resolve(writableMap);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getValue(String uniqueThemeInfoId, Promise promise){
        try {
            UniqueThemeInfo uniqueThemeInfo = (UniqueThemeInfo) getObjFromList(uniqueThemeInfoId);
            String value = uniqueThemeInfo.getValue();

            promise.resolve(value);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setValue(String uniqueThemeInfoId, String value, Promise promise){
        try {
            UniqueThemeInfo uniqueThemeInfo = (UniqueThemeInfo) getObjFromList(uniqueThemeInfoId);
            uniqueThemeInfo.setValue(value);

            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }
}
