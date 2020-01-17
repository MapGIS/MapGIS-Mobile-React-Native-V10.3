package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.zondy.mapgis.core.object.Enumeration;
import com.zondy.mapgis.core.srs.SpheroidType;

import java.util.HashMap;
import java.util.Map;

public class JSSpheroidType extends ReactContextBaseJavaModule {
    private static final String REACT_CLASS="JSSpheroidType";

    public JSSpheroidType(ReactApplicationContext context){
        super(context);
    }

    @Override
    public String getName(){return REACT_CLASS;}

    @Override
    public Map<String, Object> getConstants() {
        final Map<String, Object> constants = new HashMap<>();

        String[] names = Enumeration.getNames(SpheroidType.class);
        for (int i = 0; i < names.length; i++) {
            int value = Enumeration.getValueByName(SpheroidType.class, names[i]);
            constants.put(names[i], value);
        }
        return constants;
    }
}