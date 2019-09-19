package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.zondy.mapgis.android.tool.sketcheditor.SketchDataType;
import com.zondy.mapgis.core.object.Enumeration;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nullable;

/**
 * 草图数据类型Native功能组件
 * Created by xiaoying on 2019/9/10.
 */
public class JSSketchDataType extends ReactContextBaseJavaModule {
    private static final  String REACT_CLASS = "JSSketchDataType";

    public JSSketchDataType(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Nullable
    @Override
    public Map<String, Object> getConstants() {
        Map<String, Object> constants = new HashMap<>();

        String[] names = Enumeration.getNames(SketchDataType.class);
        for (int i = 0; i < names.length; i++) {
            int value = Enumeration.getValueByName(SketchDataType.class, names[i]);
            constants.put(names[i], value);
        }

        return constants;
    }
}
