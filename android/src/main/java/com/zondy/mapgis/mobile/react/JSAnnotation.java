package com.zondy.mapgis.mobile.react;

import android.graphics.Bitmap;
import android.graphics.PointF;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.android.annotation.Annotation;
import com.zondy.mapgis.android.mapview.MagnifierOption;
import com.zondy.mapgis.android.mapview.MapPosition;
import com.zondy.mapgis.core.geometry.Dot;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class JSAnnotation extends ReactContextBaseJavaModule {
    public static final String REACT_CLASS = "JSAnnotation";
    public static Map<String, Annotation> mAnnotationList = new HashMap<String, Annotation>();
    public JSAnnotation(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public static Annotation getObjFromList(String id) {
        return mAnnotationList.get(id);
    }

    public static String registerId(Annotation obj) {
        for (Map.Entry entry : mAnnotationList.entrySet()) {
            if (obj.equals(entry.getValue())) {
                return (String) entry.getKey();
            }
        }
        Calendar calendar = Calendar.getInstance();
        String id = Long.toString(calendar.getTimeInMillis());
        mAnnotationList.put(id, obj);
        return id;
    }

    @ReactMethod
    public void createObj(String title, String description, String pointId, String imageId, Promise promise) {
        try {
            Dot point = JSDot.getObjFromList(pointId);
            Bitmap image = JSImage.getObjFromList(imageId);
            Annotation annotation = new Annotation(title, description, point, image);
            String annotationId = registerId(annotation);
            WritableMap map = Arguments.createMap();
            map.putString("annotationId", annotationId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void createObj(String uid, String title, String description, String pointId, String imageId, Promise promise) {
        try {
            Dot point = JSDot.getObjFromList(pointId);
            Bitmap image = JSImage.getObjFromList(imageId);
            Annotation annotation = new Annotation(uid, title, description, point, image);
            String annotationId = registerId(annotation);
            WritableMap map = Arguments.createMap();
            map.putString("annotationId", annotationId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getUid(String annotationId, Promise promise)
    {
        try {
            Annotation annotation = getObjFromList(annotationId);
            String strUid = annotation.getUid();
            promise.resolve(strUid);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setTitle(String annotationId, String title, Promise promise)
    {
        try {
            Annotation annotation = getObjFromList(annotationId);
            annotation.setTitle(title);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

   @ReactMethod
    public void getTitle(String annotationId, Promise promise)
    {
        try {
            Annotation annotation = getObjFromList(annotationId);
            String strTitle = annotation.getTitle();
            promise.resolve(strTitle);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setDescription(String annotationId, String description, Promise promise)
    {
        try {
            Annotation annotation = getObjFromList(annotationId);
            annotation.setDescription(description);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getDescription(String annotationId, Promise promise)
    {
        try {
            Annotation annotation = getObjFromList(annotationId);
            String strDescription = annotation.getDescription();
            promise.resolve(strDescription);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setPoint(String annotationId, String pointId, Promise promise)
    {
        try {
            Annotation annotation = getObjFromList(annotationId);
            Dot point = JSDot.getObjFromList(pointId);
            annotation.setPoint(point);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getPoint(String annotationId, Promise promise)
    {
        try {
            Annotation annotation = getObjFromList(annotationId);
            Dot dot = annotation.getPoint();
            String dotID = JSDot.registerId(dot);
            WritableMap map = Arguments.createMap();
            map.putString("dotID", dotID);
            map.putDouble("x", dot.getX());
            map.putDouble("y", dot.getY());
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setImage(String annotationId, String bitmapId, Promise promise)
    {
        try {
            Annotation annotation = getObjFromList(annotationId);
            Bitmap bitmap = JSImage.getObjFromList(bitmapId);
            annotation.setImage(bitmap);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setImageByFilePath(String annotationId, String filePath, Promise promise)
    {
        try {
            Annotation annotation = getObjFromList(annotationId);
            annotation.setImage(filePath);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getImageWidth(String annotationId, Promise promise)
    {
        try {
            Annotation annotation = getObjFromList(annotationId);
            long width = annotation.getImageWidth();
            promise.resolve(width);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getImageHeight(String annotationId, Promise promise)
    {
        try {
            Annotation annotation = getObjFromList(annotationId);
            long height = annotation.getImageHeight();
            promise.resolve(height);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getImage(String annotationId, Promise promise)
    {
        try {
            Annotation annotation = getObjFromList(annotationId);
            Bitmap bitmap = annotation.getImage();
            String bitmapId = JSImage.registerId(bitmap);
            WritableMap map = Arguments.createMap();
            map.putString("bitmapId", bitmapId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

   @ReactMethod
    public void setCenterOffset(String annotationId, String offsetId, Promise promise)
    {
        try {
            Annotation annotation = getObjFromList(annotationId);
            PointF offset = JSPointF.getObjFromList(offsetId);
            annotation.setCenterOffset(offset);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getCenterOffset(String annotationId, Promise promise)
    {
        try {
            Annotation annotation = getObjFromList(annotationId);
            PointF pointf = annotation.getCenterOffset();
            String pointFId = JSPointF.registerId(pointf);
            WritableMap map = Arguments.createMap();
            map.putString("pointFId", pointFId);
            map.putDouble("x", pointf.x);
            map.putDouble("y", pointf.y);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setPointByPixel(String annotationId, boolean pixel, Promise promise)
    {
        try {
            Annotation annotation = getObjFromList(annotationId);
            annotation.setPointByPixel(pixel);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

   @ReactMethod
    public void isPointByPixel(String annotationId, Promise promise)
    {
        try {
            Annotation annotation = getObjFromList(annotationId);
            boolean isPixel = annotation.isPointByPixel();
            promise.resolve(isPixel);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setCanShowAnnotationView(String annotationId, boolean show, Promise promise)
    {
        try {
            Annotation annotation = getObjFromList(annotationId);
            annotation.setCanShowAnnotationView(show);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void isCanShowAnnotationView(String annotationId, Promise promise)
    {
        try {
            Annotation annotation = getObjFromList(annotationId);
            boolean isCanShow = annotation.isCanShowAnnotationView();
            promise.resolve(isCanShow);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void showAnnotationView(String annotationId, Promise promise)
    {
        try {
            Annotation annotation = getObjFromList(annotationId);
            annotation.showAnnotationView();
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void hideAnnotationView(String annotationId, Promise promise)
    {
        try {
            Annotation annotation = getObjFromList(annotationId);
            annotation.hideAnnotationView();
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void isAnnotationViewShown(String annotationId, Promise promise)
    {
        try {
            Annotation annotation = getObjFromList(annotationId);
            boolean isShow = annotation.isAnnotationViewShown();
            promise.resolve(isShow);
        } catch (Exception e) {
            promise.reject(e);
        }
    }
}
