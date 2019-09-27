package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.zondy.mapgis.core.object.Enumeration;
import com.zondy.mapgis.core.srs.LenUnitType;

import java.util.HashMap;
import java.util.Map;

public class JSLenUnitType extends ReactContextBaseJavaModule {
    public static final String REACT_CLASS="JSLenUnitType";

    public JSLenUnitType(ReactApplicationContext context){
        super(context);
    }

    @Override
    public String getName(){return REACT_CLASS;}

    @Override
    public Map<String, Object> getConstants() {
        final Map<String, Object> constants = new HashMap<>();

        String[] names = Enumeration.getNames(LenUnitType.class);
        for (int i = 0; i < names.length; i++) {
            int value = Enumeration.getValueByName(LenUnitType.class, names[i]);
            constants.put(names[i], value);
        }
        return constants;
    }
}
