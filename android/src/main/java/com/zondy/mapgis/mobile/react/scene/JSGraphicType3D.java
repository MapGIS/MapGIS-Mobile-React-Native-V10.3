package com.zondy.mapgis.mobile.react.scene;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.zondy.mapgis.android.graphic.GraphicType3D;

import java.util.HashMap;
import java.util.Map;

/**
 * @auther LiaoLiang on 20-8-13
 * @content
 */
public class JSGraphicType3D extends ReactContextBaseJavaModule {
    private static final String REACT_CLASS = "JSGraphicType3D";

    private static final String Circle3DType = "Circle3DType"; //CircleGraphic3D : 10
    private static final String Ellipse3DType = "Ellipse3DType"; //EllipseGraphic3D : 16
    private static final String Image3DType = "Image3DType"; //ImageGraphic3D : 13
    private static final String Model3DType = "Model3DType"; //ModelGraphic3D : 17
    private static final String MultiPoint3DType = "MultiPoint3DType"; //MultiPointGraphic3D : 15
    private static final String PlaceMarkerType = "PlaceMarkerType"; //PlaceMarkerGraphic3D : 18
    private static final String Point3DType = "Point3DType"; //PointGraphic3D : 9
    private static final String Polygon3DType = "Polygon3DType"; //PolygonGraphic3D : 12
    private static final String Polylin3DType = "Polylin3DType"; //PolylinGraphic3D : 11
    private static final String Text3DType = "Text3DType"; //TextGraphic3D : 14
    private static final String UnknownGraphicType = "UnknownGraphicType"; //UnknownGraphicType : 0

    @NonNull
    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public JSGraphicType3D(@NonNull ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Nullable
    @Override
    public Map<String, Object> getConstants() {
        Map<String,Object> constants = new HashMap<>();

        constants.put(Circle3DType, GraphicType3D.Circle3DType.value());
        constants.put(Ellipse3DType,GraphicType3D.Ellipse3DType.value());
        constants.put(Image3DType,GraphicType3D.Image3DType.value());
        constants.put(Model3DType,GraphicType3D.Model3DType.value());
        constants.put(MultiPoint3DType,GraphicType3D.MultiPoint3DType.value());
        constants.put(PlaceMarkerType,GraphicType3D.PlaceMarkerType.value());
        constants.put(Point3DType,GraphicType3D.Point3DType.value());
        constants.put(Polygon3DType,GraphicType3D.Polygon3DType.value());
        constants.put(Polylin3DType,GraphicType3D.Polylin3DType.value());
        constants.put(Text3DType,GraphicType3D.Text3DType.value());
        constants.put(UnknownGraphicType,GraphicType3D.UnknownGraphicType.value());

        return super.getConstants();
    }
}
