package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.core.srs.ElpTransParam;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class JSElpTransParam extends ReactContextBaseJavaModule {
    public static final String REACT_CLASS = "JSElpTransParam";
    public static Map<String, ElpTransParam> mElpTransParamList = new HashMap<String, ElpTransParam>();

    public JSElpTransParam(ReactApplicationContext context) {
        super(context);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public static ElpTransParam getObjFromList(String id) {
        return mElpTransParamList.get(id);
    }


    public static String registerId(ElpTransParam obj) {
        for (Map.Entry entry : mElpTransParamList.entrySet()) {
            if (obj.equals(entry.getValue())) {
                return (String) entry.getKey();
            }
        }
        Calendar calendar = Calendar.getInstance();
        String id = Long.toString(calendar.getTimeInMillis());
        mElpTransParamList.put(id, obj);
        return id;
    }

    @ReactMethod
    public void createObj(Promise promise) {
        try {
            ElpTransParam elpTransParam = new ElpTransParam();
            String strElpTransParamId = registerId(elpTransParam);

            WritableMap map = Arguments.createMap();
            map.putString("ElpTransParamId", strElpTransParamId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }
}
