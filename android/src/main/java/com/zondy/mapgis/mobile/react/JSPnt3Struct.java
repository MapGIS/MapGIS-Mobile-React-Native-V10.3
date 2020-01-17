package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.core.srs.Pnt3Struct;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class JSPnt3Struct extends ReactContextBaseJavaModule {
    private static final String REACT_CLASS = "JSPnt3Struct";
    private static Map<String, Pnt3Struct> mPnt3StructList = new HashMap<String, Pnt3Struct>();

    public JSPnt3Struct(ReactApplicationContext context) {
        super(context);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public static Pnt3Struct getObjFromList(String id) {
        return mPnt3StructList.get(id);
    }


    public static String registerId(Pnt3Struct obj) {
        for (Map.Entry entry : mPnt3StructList.entrySet()) {
            if (obj.equals(entry.getValue())) {
                return (String) entry.getKey();
            }
        }
        String id = UUID.randomUUID().toString().substring(24);
        mPnt3StructList.put(id, obj);
        return id;
    }

    @ReactMethod
    public void createObj(Promise promise) {
        try {
            Pnt3Struct pnt3Struct = new Pnt3Struct();
            String strPnt3StructId = registerId(pnt3Struct);

            WritableMap map = Arguments.createMap();
            map.putString("Pnt3StructId", strPnt3StructId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }
}
