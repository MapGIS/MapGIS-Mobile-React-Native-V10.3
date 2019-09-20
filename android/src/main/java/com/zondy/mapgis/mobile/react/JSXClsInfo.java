package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.zondy.mapgis.core.geodatabase.IXClsInfo;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class JSXClsInfo extends ReactContextBaseJavaModule {

    public static final String REACT_CLASS = "JSXClsInfo";
    public static Map<String, IXClsInfo> mXClsInfoList = new HashMap<String, IXClsInfo>();

    public JSXClsInfo(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public static IXClsInfo getObjFromList(String id) {
        return mXClsInfoList.get(id);
    }

    public static String registerId(IXClsInfo obj) {
        for (Map.Entry entry : mXClsInfoList.entrySet()) {
            if (obj.equals(entry.getValue())) {
                return (String) entry.getKey();
            }
        }
        Calendar calendar = Calendar.getInstance();
        String id = Long.toString(calendar.getTimeInMillis());
        mXClsInfoList.put(id, obj);
        return id;
    }




}
