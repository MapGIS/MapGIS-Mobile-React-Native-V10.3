package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.zondy.mapgis.core.map.LabelBackType;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nullable;

/**
 * 标注背景类型Native组件
 * Created by xiaoying on 2019/8/28.
 */
public class JSLabelBackType extends ReactContextBaseJavaModule {
    private static final String REACT_CLASS = "JSLabelBackType";
    private static final String RECT = "Rect";                               // 矩形
    private static final String ROUND_RECT = "RoundRect";                    // 圆角矩形
    private static final String ELLIPSE = "Ellipse";                         // 椭圆形
    private static final String FASTENER = "Fastener";                       // 纽扣形
    private static final String DIAMOND = "Diamond";                         // 菱形
    private static final String TRIANGLE = "Triangle";                       // 三角形
    private static final String EIGHT_EDGE = "EightEdge";                    // 八边形
    private static final String SHARP_CORNER_RECT = "SharpCornerRect";       // 尖角矩形
    private static final String SECOND_HALF_ELLIPSE = "SecondHalfEllipse";   // 下半椭圆形
    private static final String BORDER_RECT = "BorderRect";                  // 边框矩形

    public JSLabelBackType(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Nullable
    @Override
    public Map<String, Object> getConstants() {
        Map<String,Object> constants = new HashMap<>();
        constants.put(RECT, LabelBackType.Rect.value());
        constants.put(ROUND_RECT,LabelBackType.RoundRect.value());
        constants.put(ELLIPSE,LabelBackType.Ellipse.value());
        constants.put(FASTENER,LabelBackType.Fastener.value());
        constants.put(DIAMOND,LabelBackType.Diamond.value());
        constants.put(TRIANGLE,LabelBackType.Triangle.value());
        constants.put(EIGHT_EDGE,LabelBackType.EightEdge.value());
        constants.put(SHARP_CORNER_RECT,LabelBackType.SharpCornerRect.value());
        constants.put(SECOND_HALF_ELLIPSE,LabelBackType.SecondHalfEllipse.value());
        constants.put(BORDER_RECT,LabelBackType.BorderRect.value());
        return constants;
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }
}
