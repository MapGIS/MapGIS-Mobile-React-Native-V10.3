package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.zondy.mapgis.core.geodatabase.IBasCls;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class JSBasCls extends ReactContextBaseJavaModule {

    public static final String REACT_CLASS = "JSBasCls";
    public static Map<String, IBasCls> mBasClsList = new HashMap<String, IBasCls>();

    public JSBasCls(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public static IBasCls getObjFromList(String id) {
        return mBasClsList.get(id);
    }

    public static String registerId(IBasCls obj) {
        for (Map.Entry entry : mBasClsList.entrySet()) {
            if (obj.equals(entry.getValue())) {
                return (String) entry.getKey();
            }
        }
        Calendar calendar = Calendar.getInstance();
        String id = Long.toString(calendar.getTimeInMillis());
        mBasClsList.put(id, obj);
        return id;
    }
}
