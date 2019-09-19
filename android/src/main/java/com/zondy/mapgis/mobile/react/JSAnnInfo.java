package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.ReactApplicationContext;
import com.zondy.mapgis.core.info.GeomInfo;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class JSAnnInfo extends JSGeomInfo{

    public static final String REACT_CLASS = "JSAnnInfo";

    public JSAnnInfo(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

}
