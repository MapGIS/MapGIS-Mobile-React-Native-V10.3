package com.zondy.mapgis.mobile.react.scene;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.zondy.mapgis.android.graphic.GraphicText3DAlignmentMode;

import java.util.HashMap;
import java.util.Map;

/**
 * @auther LiaoLiang on 20-8-20
 * @content 场景文本对齐模式
 */
public class JSGraphicText3DAlignmentMode extends ReactContextBaseJavaModule {
    private static final String REACT_CLASS = "JSGraphicText3DAlignmentMode";

    private static final String BASELINE = "BASELINE"; //以底部线性对齐
    private static final String CENTERBASELINE = "CENTERBASELINE"; //居中线性对齐
    private static final String CENTERBOTTOM = "CENTERBOTTOM"; //靠下居中对齐
    private static final String CENTERBOTTOMBASELINE = "CENTERBOTTOMBASELINE"; //底部居中线性对齐
    private static final String CENTERCENTER = "CENTERCENTER"; //居中对齐
    private static final String CENTERTOP = "CENTERTOP"; //靠上居中对齐
    private static final String LEFTBOTTOM = "LEFTBOTTOM"; //靠左下对齐
    private static final String LEFTBOTTOMBASELINE = "LEFTBOTTOMBASELINE"; //左下线性对齐
    private static final String LEFTCENTER = "LEFTCENTER"; //靠左居中对齐
    private static final String LEFTTOP = "LEFTTOP"; //左上对齐
    private static final String RIGHTBASELINE = "RIGHTBASELINE"; //靠右线性对齐
    private static final String RIGHTBOTTOM = "RIGHTBOTTOM"; //靠右下对齐
    private static final String RIGHTBOTTOMBASELINE = "RIGHTBOTTOMBASELINE"; //右下线性对齐
    private static final String RIGHTCENTER = "RIGHTCENTER"; //靠右居中对齐
    private static final String RIGHTTOP = "RIGHTTOP"; //靠右上对齐

    @NonNull
    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public JSGraphicText3DAlignmentMode(@NonNull ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Nullable
    @Override
    public Map<String, Object> getConstants() {
        Map<String,Object> constants = new HashMap<>();
        constants.put(BASELINE, GraphicText3DAlignmentMode.BASELINE.value());
        constants.put(CENTERBASELINE, GraphicText3DAlignmentMode.CENTERBASELINE.value());
        constants.put(CENTERBOTTOM, GraphicText3DAlignmentMode.CENTERBOTTOM.value());
        constants.put(CENTERBOTTOMBASELINE, GraphicText3DAlignmentMode.CENTERBOTTOMBASELINE.value());
        constants.put(CENTERCENTER, GraphicText3DAlignmentMode.CENTERCENTER.value());
        constants.put(CENTERTOP, GraphicText3DAlignmentMode.CENTERTOP.value());
        constants.put(LEFTBOTTOM, GraphicText3DAlignmentMode.LEFTBOTTOM.value());
        constants.put(LEFTBOTTOMBASELINE, GraphicText3DAlignmentMode.LEFTBOTTOMBASELINE.value());
        constants.put(LEFTCENTER, GraphicText3DAlignmentMode.LEFTCENTER.value());
        constants.put(LEFTTOP, GraphicText3DAlignmentMode.LEFTTOP.value());
        constants.put(RIGHTBASELINE, GraphicText3DAlignmentMode.RIGHTBASELINE.value());
        constants.put(RIGHTBOTTOM, GraphicText3DAlignmentMode.RIGHTBOTTOM.value());
        constants.put(RIGHTBOTTOMBASELINE, GraphicText3DAlignmentMode.RIGHTBOTTOMBASELINE.value());
        constants.put(RIGHTCENTER, GraphicText3DAlignmentMode.RIGHTCENTER.value());
        constants.put(RIGHTTOP, GraphicText3DAlignmentMode.RIGHTTOP.value());

        return constants;
    }

    public static GraphicText3DAlignmentMode getGraphicText3DAlignmentModeValue(int value) {
        Map<String,Object> constants = new HashMap<>();
        constants.put(BASELINE, GraphicText3DAlignmentMode.BASELINE.value());
        constants.put(CENTERBASELINE, GraphicText3DAlignmentMode.CENTERBASELINE.value());
        constants.put(CENTERBOTTOM, GraphicText3DAlignmentMode.CENTERBOTTOM.value());
        constants.put(CENTERBOTTOMBASELINE, GraphicText3DAlignmentMode.CENTERBOTTOMBASELINE.value());
        constants.put(CENTERCENTER, GraphicText3DAlignmentMode.CENTERCENTER.value());
        constants.put(CENTERTOP, GraphicText3DAlignmentMode.CENTERTOP.value());
        constants.put(LEFTBOTTOM, GraphicText3DAlignmentMode.LEFTBOTTOM.value());
        constants.put(LEFTBOTTOMBASELINE, GraphicText3DAlignmentMode.LEFTBOTTOMBASELINE.value());
        constants.put(LEFTCENTER, GraphicText3DAlignmentMode.LEFTCENTER.value());
        constants.put(LEFTTOP, GraphicText3DAlignmentMode.LEFTTOP.value());
        constants.put(RIGHTBASELINE, GraphicText3DAlignmentMode.RIGHTBASELINE.value());
        constants.put(RIGHTBOTTOM, GraphicText3DAlignmentMode.RIGHTBOTTOM.value());
        constants.put(RIGHTBOTTOMBASELINE, GraphicText3DAlignmentMode.RIGHTBOTTOMBASELINE.value());
        constants.put(RIGHTCENTER, GraphicText3DAlignmentMode.RIGHTCENTER.value());
        constants.put(RIGHTTOP, GraphicText3DAlignmentMode.RIGHTTOP.value());

        for (Map.Entry entry : constants.entrySet()) {
            if (entry.getValue().equals(value)) {
                GraphicText3DAlignmentMode graphicText3DAlignmentMode = new GraphicText3DAlignmentMode(value){};
                return graphicText3DAlignmentMode;
            }
        }
        return null;
    }
}
