package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.zondy.mapgis.core.geometry.GeomType;
import com.zondy.mapgis.core.object.Enumeration;
import com.zondy.mapgis.core.srs.CoordType;

import java.util.HashMap;
import java.util.Map;

public class JSGeomType extends ReactContextBaseJavaModule {
    public static final String REACT_CLASS="JSGeomType";

    public JSGeomType(ReactApplicationContext context){
        super(context);
    }

    @Override
    public String getName(){return REACT_CLASS;}

    @Override
    public Map<String, Object> getConstants() {
        final Map<String, Object> constants = new HashMap<>();

        String[] names = Enumeration.getNames(GeomType.class);
        for (int i = 0; i < names.length; i++) {
            int value = Enumeration.getValueByName(GeomType.class, names[i]);
            constants.put(names[i], value);
        }
        return constants;
    }
}
