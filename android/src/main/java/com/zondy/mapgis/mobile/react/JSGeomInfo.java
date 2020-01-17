package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.zondy.mapgis.core.info.GeomInfo;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class JSGeomInfo extends ReactContextBaseJavaModule {
    private static final String REACT_CLASS = "JSGeomInfo";
    private static Map<String, GeomInfo> mGeomInfoList = new HashMap<String, GeomInfo>();

    public JSGeomInfo(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public static GeomInfo getObjFromList(String id) {
        return mGeomInfoList.get(id);
    }

    public static String registerId(GeomInfo obj) {
        for (Map.Entry entry : mGeomInfoList.entrySet()) {
            if (obj.equals(entry.getValue())) {
                return (String) entry.getKey();
            }
        }
        String id = UUID.randomUUID().toString().substring(24);
        mGeomInfoList.put(id, obj);
        return id;
    }
}
