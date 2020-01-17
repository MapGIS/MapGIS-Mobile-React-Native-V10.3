package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.android.graphic.GraphicCircle;
import com.zondy.mapgis.core.geometry.Dot;
import com.zondy.mapgis.mobile.react.utils.ConvertUtil;


/**
 * @author fjl 2019-6-30 下午2:52:36
 * @content 圆图形对象Native组件
 */
public class JSGraphicCircle extends JSGraphic {
    private static final String REACT_CLASS = "JSGraphicCircle";

    public JSGraphicCircle(ReactApplicationContext context) {
        super(context);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @ReactMethod
    public void createObj(Promise promise) {
        try {
            GraphicCircle GraphicCircle = new GraphicCircle();
            String GraphicCircleId = registerId(GraphicCircle);

            WritableMap map = Arguments.createMap();
            map.putString("GraphicCircleId", GraphicCircleId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setCenterAndRadius(String GraphicCircleId, String dotID, double radius, Promise promise) {
        try {
            GraphicCircle GraphicCircle = (GraphicCircle) getObjFromList(GraphicCircleId);
            Dot dot = JSDot.getObjFromList(dotID);
            GraphicCircle.setCenterAndRadius(dot, radius);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setCenterPoint(String GraphicCircleId, String dotID, Promise promise) {
        try {
            GraphicCircle GraphicCircle = (GraphicCircle) getObjFromList(GraphicCircleId);
            Dot dot = JSDot.getObjFromList(dotID);
            GraphicCircle.setCenterPoint(dot);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setRadius(String GraphicCircleId, double radius, Promise promise) {
        try {
            GraphicCircle GraphicCircle = (GraphicCircle) getObjFromList(GraphicCircleId);
            GraphicCircle.setRadius(radius);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getRadius(String GraphicCircleId, Promise promise) {
        try {
            GraphicCircle GraphicCircle = (GraphicCircle) getObjFromList(GraphicCircleId);
            double radius = GraphicCircle.getRadius();

            promise.resolve(radius);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setBorderlineWidth(String GraphicCircleId, Float width, Promise promise) {
        try {
            GraphicCircle GraphicCircle = (GraphicCircle) getObjFromList(GraphicCircleId);
            GraphicCircle.setBorderlineWidth(width);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getBorderlineWidth(String GraphicCircleId, Promise promise) {
        try {
            GraphicCircle GraphicCircle = (GraphicCircle) getObjFromList(GraphicCircleId);
            double borderlineWidth = GraphicCircle.getBorderlineWidth();

            promise.resolve(borderlineWidth);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setBorderlineColor(String GraphicCircleId, String color, Promise promise) {
        try {
            GraphicCircle GraphicCircle = (GraphicCircle) getObjFromList(GraphicCircleId);
            GraphicCircle.setBorderlineColor(ConvertUtil.ColorRGBAToInt(color));
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getBorderlineColor(String GraphicCircleId, Promise promise) {
        try {
            GraphicCircle GraphicCircle = (GraphicCircle) getObjFromList(GraphicCircleId);
            int color = GraphicCircle.getBorderlineColor();
            String strColor = ConvertUtil.ColorIntToRGBA(color);

            WritableMap map = Arguments.createMap();
            map.putString("color", strColor);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setRadiusByPixel(String GraphicCircleId, boolean pixel, Promise promise) {
        try {
            GraphicCircle GraphicCircle = (GraphicCircle) getObjFromList(GraphicCircleId);
            GraphicCircle.setRadiusByPixel(pixel);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void isRadiusByPixel(String GraphicCircleId, Promise promise) {
        try {
            GraphicCircle GraphicCircle = (GraphicCircle) getObjFromList(GraphicCircleId);
            boolean isRadiusByPixel = GraphicCircle.isRadiusByPixel();

            promise.resolve(isRadiusByPixel);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

}
