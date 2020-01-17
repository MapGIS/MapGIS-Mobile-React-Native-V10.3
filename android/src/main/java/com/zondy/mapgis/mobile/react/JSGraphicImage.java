package com.zondy.mapgis.mobile.react;

import android.graphics.Bitmap;
import android.graphics.PointF;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.android.graphic.GraphicImage;
import com.zondy.mapgis.core.geometry.Dot;

/**
 * @author fjl 2019-6-30 下午2:52:36
 * @content 圆图形对象Native组件
 */
public class JSGraphicImage extends JSGraphic {
    private static final String REACT_CLASS = "JSGraphicImage";
    ReactContext mReactContext;

    public JSGraphicImage(ReactApplicationContext context) {
        super(context);
        mReactContext = context;
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @ReactMethod
    public void createObj(Promise promise) {
        try {
            GraphicImage GraphicImage = new GraphicImage();
            String GraphicImageId = registerId(GraphicImage);

            WritableMap map = Arguments.createMap();
            map.putString("GraphicImageId", GraphicImageId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setImageFromPath(String GraphicImageId, String filePath, Promise promise)
    {
        try {
            GraphicImage GraphicImage = (GraphicImage) getObjFromList(GraphicImageId);
            GraphicImage.setImage(filePath);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setImage(String GraphicImageId, String imageID, Promise promise) {
        try {
            GraphicImage GraphicImage = (GraphicImage) getObjFromList(GraphicImageId);
            Bitmap bitmap = JSImage.getObjFromList(imageID);
            GraphicImage.setImage(bitmap);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setPoint(String GraphicImageId, String dotID, Promise promise) {
        try {
            GraphicImage GraphicImage = (GraphicImage) getObjFromList(GraphicImageId);
            Dot dot = JSDot.getObjFromList(dotID);

            GraphicImage.setPoint(dot);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setAnchorPoint(String GraphicImageId, String pointfID, Promise promise) {
        try {
            GraphicImage GraphicImage = (GraphicImage) getObjFromList(GraphicImageId);
            PointF pointf = JSPointF.getObjFromList(pointfID);
            GraphicImage.setAnchorPoint(pointf);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getAnchorPoint(String GraphicImageId, Promise promise) {
        try {
            GraphicImage GraphicImage = (GraphicImage) getObjFromList(GraphicImageId);
            PointF pointf = GraphicImage.getAnchorPoint();

            String PointFID = JSPointF.registerId(pointf);

            WritableMap map = Arguments.createMap();
            map.putString("PointFID", PointFID);
            promise.resolve(map);

        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setAlpha(String GraphicImageId, int alpha, Promise promise) {
        try {
            GraphicImage GraphicImage = (GraphicImage) getObjFromList(GraphicImageId);
            GraphicImage.setAlpha(alpha);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setRotateAngle(String GraphicImageId, float rotateAngle, Promise promise) {
        try {
            GraphicImage GraphicImage = (GraphicImage) getObjFromList(GraphicImageId);
            GraphicImage.setRotateAngle(rotateAngle);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setSlope(String GraphicImageId, boolean IsSlope, Promise promise) {
        try {
            GraphicImage GraphicImage = (GraphicImage) getObjFromList(GraphicImageId);
            GraphicImage.setSlope(IsSlope);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getImage(String GraphicImageId, Promise promise) {
        try {
            GraphicImage GraphicImage = (GraphicImage) getObjFromList(GraphicImageId);
            Bitmap bitmap = GraphicImage.getImage();
            String ImageID = JSImage.registerId(bitmap);

            WritableMap map = Arguments.createMap();
            map.putString("ImageID", ImageID);
            promise.resolve(map);

        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getPoint(String GraphicImageId, Promise promise) {
        try {
            GraphicImage GraphicImage = (GraphicImage) getObjFromList(GraphicImageId);
            Dot dot = GraphicImage.getPoint();
            String dotID = JSDot.registerId(dot);

            WritableMap map = Arguments.createMap();
            map.putString("dotID", dotID);
            promise.resolve(map);

        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getRotateAngle(String GraphicImageId, Promise promise) {
        try {
            GraphicImage GraphicImage = (GraphicImage) getObjFromList(GraphicImageId);
            float rotateAngle = GraphicImage.getRotateAngle();

            promise.resolve(rotateAngle);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getAlpha(String GraphicImageId, Promise promise) {
        try {
            GraphicImage GraphicImage = (GraphicImage) getObjFromList(GraphicImageId);
            float alpha = GraphicImage.getAlpha();

            promise.resolve(alpha);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void isSlope(String GraphicImageId, Promise promise) {
        try {
            GraphicImage GraphicImage = (GraphicImage) getObjFromList(GraphicImageId);
            boolean isSlope = GraphicImage.isSlope();

            promise.resolve(isSlope);

        } catch (Exception e) {
            promise.reject(e);
        }
    }


    @ReactMethod
    public void getImageWidth(String GraphicImageId, Promise promise) {
        try {
            GraphicImage GraphicImage = (GraphicImage) getObjFromList(GraphicImageId);
            double imageWidth = GraphicImage.getImageWidth();

            promise.resolve(imageWidth);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getImageHeight(String GraphicImageId, Promise promise) {
        try {
            GraphicImage GraphicImage = (GraphicImage) getObjFromList(GraphicImageId);
            double imageHeight = GraphicImage.getImageHeight();

            promise.resolve(imageHeight);
        } catch (Exception e) {
            promise.reject(e);
        }
    }
}
