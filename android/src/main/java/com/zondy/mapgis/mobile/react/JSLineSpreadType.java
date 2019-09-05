package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.zondy.mapgis.core.map.LineSpreadType;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nullable;

/**
 *  线标注散布类型对象Native功能组件
 * Created by xiaoying on 2019/9/2.
 */
public class JSLineSpreadType extends ReactContextBaseJavaModule {
    private static final String REACT_CLASS = "JSLineSpreadType";
    private static final String AUTO_SPREAD = "AutoSpread";
    private static final String CENTRALIZATION_SPREAD = "CentralizationSpread";
    private static final String DECENTRALIZE_SPREAD = "DecentralizeSpread";

    public JSLineSpreadType(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Nullable
    @Override
    public Map<String, Object> getConstants() {
        Map<String, Object> constants = new HashMap<>();
        constants.put(AUTO_SPREAD, LineSpreadType.AutoSpread.value());
        constants.put(CENTRALIZATION_SPREAD, LineSpreadType.CentralizationSpread.value());
        constants.put(DECENTRALIZE_SPREAD, LineSpreadType.DecentralizeSpread.value());
        return constants;
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }
}
