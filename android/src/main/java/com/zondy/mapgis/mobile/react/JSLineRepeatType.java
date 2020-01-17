package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.zondy.mapgis.core.map.LineRepeatType;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nullable;

/**
 * 线标注重复类型对象Native功能组件
 * Created by xiaoying on 2019/9/2.
 */
public class JSLineRepeatType extends ReactContextBaseJavaModule {
    private static final String REACT_CLASS = "JSLineRepeatType";
    private static final String AUTO_REPEAT = "AutoRepeat";        //  自动重复
    private static final String NEVER_REPEAT = "NeverRepeat";      //  重不重复
    private static final String REPEAT_BY_STEP = "RepeatByStep";   //  按步长重复

    public JSLineRepeatType(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Nullable
    @Override
    public Map<String, Object> getConstants() {
        Map<String, Object> constants = new HashMap<>();
        constants.put(AUTO_REPEAT, LineRepeatType.AutoRepeat.value());
        constants.put(NEVER_REPEAT, LineRepeatType.NeverRepeat.value());
        constants.put(REPEAT_BY_STEP, LineRepeatType.RepeatByStep.value());
        return constants;
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }
}
