package com.zondy.mapgis.mobile.react.scene;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.zondy.mapgis.android.graphic.GraphicImage3DAlignmentMode;

import java.util.HashMap;
import java.util.Map;

/**
 * @auther LiaoLiang on 20-8-20
 * @content 场景图形对齐模式
 */
public class JSGraphicImage3DAlignmentMode extends ReactContextBaseJavaModule {
    private static final String REACT_CLASS = "JSGraphicImage3DAlignmentMode";

    private static final String CENTERBOTTOM = "CENTERBOTTOM"; //靠下居中对齐
    private static final String CENTERCENTER = "CENTERCENTER"; //居中对齐
    private static final String CENTERTOP = "CENTERTOP"; //靠上居中对齐
    private static final String LEFTBOTTOM = "LEFTBOTTOM"; //靠左下对齐
    private static final String LEFTCENTER = "LEFTCENTER"; //靠左居中对齐
    private static final String LEFTTOP = "LEFTTOP"; //左上对齐
    private static final String RIGHTBOTTOM = "RIGHTBOTTOM"; //靠右下对齐
    private static final String RIGHTCENTER = "RIGHTCENTER"; //靠右居中对齐
    private static final String RIGHTTOP = "RIGHTTOP"; //靠右上对齐

    @NonNull
    @Override
    public String getName() {
        return REACT_CLASS;
    }


    public JSGraphicImage3DAlignmentMode(@NonNull ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Nullable
    @Override
    public Map<String, Object> getConstants() {
        Map<String,Object> constants = new HashMap<>();
        constants.put(CENTERBOTTOM, GraphicImage3DAlignmentMode.CENTERBOTTOM.value());
        constants.put(CENTERCENTER, GraphicImage3DAlignmentMode.CENTERCENTER.value());
        constants.put(CENTERTOP, GraphicImage3DAlignmentMode.CENTERTOP.value());
        constants.put(LEFTBOTTOM, GraphicImage3DAlignmentMode.LEFTBOTTOM.value());
        constants.put(LEFTCENTER, GraphicImage3DAlignmentMode.LEFTCENTER.value());
        constants.put(LEFTTOP, GraphicImage3DAlignmentMode.LEFTTOP.value());
        constants.put(RIGHTBOTTOM, GraphicImage3DAlignmentMode.RIGHTBOTTOM.value());
        constants.put(RIGHTCENTER, GraphicImage3DAlignmentMode.RIGHTCENTER.value());
        constants.put(RIGHTTOP, GraphicImage3DAlignmentMode.RIGHTTOP.value());

        return constants;
    }

    public static GraphicImage3DAlignmentMode getGraphicImage3DAlignmentModeValue(int value) {
        Map<String,Object> constants = new HashMap<>();
        constants.put(CENTERBOTTOM, GraphicImage3DAlignmentMode.CENTERBOTTOM.value());
        constants.put(CENTERCENTER, GraphicImage3DAlignmentMode.CENTERCENTER.value());
        constants.put(CENTERTOP, GraphicImage3DAlignmentMode.CENTERTOP.value());
        constants.put(LEFTBOTTOM, GraphicImage3DAlignmentMode.LEFTBOTTOM.value());
        constants.put(LEFTCENTER, GraphicImage3DAlignmentMode.LEFTCENTER.value());
        constants.put(LEFTTOP, GraphicImage3DAlignmentMode.LEFTTOP.value());
        constants.put(RIGHTBOTTOM, GraphicImage3DAlignmentMode.RIGHTBOTTOM.value());
        constants.put(RIGHTCENTER, GraphicImage3DAlignmentMode.RIGHTCENTER.value());
        constants.put(RIGHTTOP, GraphicImage3DAlignmentMode.RIGHTTOP.value());

        for (Map.Entry entry : constants.entrySet()) {
            if (entry.getValue().equals(value)) {
                GraphicImage3DAlignmentMode graphicImage3DAlignmentMode = new GraphicImage3DAlignmentMode(value){};
                return graphicImage3DAlignmentMode;
            }
        }
        return null;
    }
}
