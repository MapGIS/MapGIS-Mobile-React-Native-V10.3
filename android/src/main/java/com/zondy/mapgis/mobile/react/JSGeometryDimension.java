package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.zondy.mapgis.core.geometry.GeometryDimension;
import com.zondy.mapgis.core.object.Enumeration;

import java.util.HashMap;
import java.util.Map;

public class JSGeometryDimension extends ReactContextBaseJavaModule {
    private static final String REACT_CLASS="JSGeometryDimension";

    public JSGeometryDimension(ReactApplicationContext context){
        super(context);
    }

    @Override
    public String getName(){return REACT_CLASS;}

    @Override
    public Map<String, Object> getConstants() {
        final Map<String, Object> constants = new HashMap<>();

        String[] names = Enumeration.getNames(GeometryDimension.class);
        for (int i = 0; i < names.length; i++) {
            int value = Enumeration.getValueByName(GeometryDimension.class, names[i]);
            constants.put(names[i], value);
        }
        return constants;
    }
}
