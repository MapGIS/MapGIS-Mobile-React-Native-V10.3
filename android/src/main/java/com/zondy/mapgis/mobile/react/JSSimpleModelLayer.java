package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.core.map.SimpleModelLayer;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * 简单模型图层Native功能组件
 * Created by xiaoying on 2019/9/3.
 */
public class JSSimpleModelLayer extends JSMapLayer {
    private static final String REACT_CLASS = "JSSimpleModelLayer";

    public JSSimpleModelLayer(ReactApplicationContext context) {
        super(context);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @ReactMethod
    public void createObj(Promise promise){
        try {
            SimpleModelLayer simpleModelLayer = new SimpleModelLayer();
            String simpleModelLayerId = registerId(simpleModelLayer);

            WritableMap writableMap = Arguments.createMap();
            writableMap.putString("SimpleModelLayerId", simpleModelLayerId);
            promise.resolve(writableMap);
        }catch (Exception e){
            promise.reject(e);
        }
    }

}
