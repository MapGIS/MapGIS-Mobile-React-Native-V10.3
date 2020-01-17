package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.ReactApplicationContext;

public class JSVectorCls extends JSBasCls{

    private static final String REACT_CLASS = "JSVectorCls";

    public JSVectorCls(ReactApplicationContext reactContext) {
        super(reactContext);
    }
    @Override
    public String getName() {
        return REACT_CLASS;
    }

}
