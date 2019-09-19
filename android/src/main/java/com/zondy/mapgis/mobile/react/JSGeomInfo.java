package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.zondy.mapgis.core.info.GeomInfo;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class JSGeomInfo extends ReactContextBaseJavaModule {
    public static final String REACT_CLASS = "JSGeomInfo";
    public static Map<String, GeomInfo> mGeomInfoList = new HashMap<String, GeomInfo>();
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
        Calendar calendar = Calendar.getInstance();
        String id = Long.toString(calendar.getTimeInMillis());
        mGeomInfoList.put(id, obj);
        return id;
    }
}
