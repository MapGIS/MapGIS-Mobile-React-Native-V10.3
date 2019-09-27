package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.zondy.mapgis.core.object.Enumeration;
import com.zondy.mapgis.core.srs.LevelType;

import java.util.HashMap;
import java.util.Map;

public class JSLevelType extends ReactContextBaseJavaModule {
    public static final String REACT_CLASS="JSLevelType";

    public JSLevelType(ReactApplicationContext context){
        super(context);
    }

    @Override
    public String getName(){return REACT_CLASS;}

    @Override
    public Map<String, Object> getConstants() {
        final Map<String, Object> constants = new HashMap<>();

        String[] names = Enumeration.getNames(LevelType.class);
        for (int i = 0; i < names.length; i++) {
            int value = Enumeration.getValueByName(LevelType.class, names[i]);
            constants.put(names[i], value);
        }
        return constants;
    }
}
