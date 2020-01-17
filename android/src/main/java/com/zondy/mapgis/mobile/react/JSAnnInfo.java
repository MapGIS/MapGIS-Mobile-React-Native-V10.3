package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.ReactApplicationContext;

public class JSAnnInfo extends JSGeomInfo{

    private static final String REACT_CLASS = "JSAnnInfo";

    public JSAnnInfo(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

}
