package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.zondy.mapgis.core.map.LineRestrictType;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nullable;

/**
 * 偏移约束类型对象Native功能组件
 * Created by xiaoying on 2019/9/2.
 */
public class JSLineRestrictType extends ReactContextBaseJavaModule {
    private static final String REACT_CLASS = "JSLineRestrictType";
    private static final String ON_LINE = "OnLine";                       // 压线
    private static final String ABOVE_LINE = "AboveLine";                 // 在线上边(左侧)
    private static final String BELOW_LINE = "BelowLine";                 // 在线下边(右侧)
    private static final String LINE_HEAD = "LineHead";                   // 线头
    private static final String LINE_TAIL = "LineTail";                   // 线尾
    private static final String LINE_HEAD_AND_TAIL = "LineHeadAndTail";   // 线头线尾

    public JSLineRestrictType(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Nullable
    @Override
    public Map<String, Object> getConstants() {
        Map<String, Object> constants = new HashMap<>();
        constants.put(ON_LINE, LineRestrictType.OnLine.value());
        constants.put(ABOVE_LINE, LineRestrictType.AboveLine.value());
        constants.put(BELOW_LINE, LineRestrictType.BelowLine.value());
        constants.put(LINE_HEAD, LineRestrictType.LineHead.value());
        constants.put(LINE_TAIL, LineRestrictType.LineTail.value());
        constants.put(LINE_HEAD_AND_TAIL, LineRestrictType.LineHeadAndTail.value());

        return constants;
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }
}
