package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.core.srs.ElpParam;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class JSElpParam extends ReactContextBaseJavaModule {
    public static final String REACT_CLASS = "JSElpParam";
    public static Map<String, ElpParam> mElpParamList = new HashMap<String, ElpParam>();

    public JSElpParam(ReactApplicationContext context) {
        super(context);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public static ElpParam getObjFromList(String id) {
        return mElpParamList.get(id);
    }


    public static String registerId(ElpParam obj) {
        for (Map.Entry entry : mElpParamList.entrySet()) {
            if (obj.equals(entry.getValue())) {
                return (String) entry.getKey();
            }
        }
        Calendar calendar = Calendar.getInstance();
        String id = Long.toString(calendar.getTimeInMillis());
        mElpParamList.put(id, obj);
        return id;
    }

    @ReactMethod
    public void createObj(Promise promise) {
        try {
            ElpParam elpParam = new ElpParam();
            String strElpParamId = registerId(elpParam);

            WritableMap map = Arguments.createMap();
            map.putString("ElpParamId", strElpParamId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }
}
