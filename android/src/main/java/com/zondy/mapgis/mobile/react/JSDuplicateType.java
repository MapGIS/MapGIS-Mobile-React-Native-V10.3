package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.zondy.mapgis.core.map.DuplicateType;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nullable;

/**
 * 面标注分布类型
 */
public class JSDuplicateType extends ReactContextBaseJavaModule {
    private static final String REACT_CLASS = "JSDuplicateType";
    private static final String ONELABEL_PREFEATURE_PART = "OneLabelPreFeaturePart"; // 每个要素部分一个标注（随意标注）
    private static final String ONELABEL_PREFEATURE = "OneLabelPreFeature"; // 每个要素一个标注（要素部分间不重复）
    private static final String REMOVE_DUPLICATES_LABELS = "RemoveDuplicatesLabels"; // 消除所有重复标注（要素间不重复）

    public JSDuplicateType(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Nullable
    @Override
    public Map<String, Object> getConstants() {
        Map<String,Object> constants = new HashMap<>();
        constants.put(ONELABEL_PREFEATURE_PART, DuplicateType.OneLabelPreFeaturePart.value());
        constants.put(ONELABEL_PREFEATURE, DuplicateType.OneLabelPreFeature.value());
        constants.put(REMOVE_DUPLICATES_LABELS, DuplicateType.RemoveDuplicatesLabels.value());

        return constants;
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }
}
