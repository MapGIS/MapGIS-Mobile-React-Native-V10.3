package com.zondy.mapgis.mobile.react;

import android.graphics.Bitmap;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.android.annotation.Annotation;
import com.zondy.mapgis.android.annotation.AnnotationsOverlay;
import com.zondy.mapgis.android.graphic.HeatmapPoint;
import com.zondy.mapgis.core.geometry.Dot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class JSAnnotationsOverlay extends ReactContextBaseJavaModule {
    private static final String REACT_CLASS = "JSAnnotationsOverlay";
    private static Map<String, AnnotationsOverlay> mAnnotationsOverlayList = new HashMap<String, AnnotationsOverlay>();

    public JSAnnotationsOverlay(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public static AnnotationsOverlay getObjFromList(String id) {
        return mAnnotationsOverlayList.get(id);
    }

    public static String registerId(AnnotationsOverlay obj) {
        for (Map.Entry entry : mAnnotationsOverlayList.entrySet()) {
            if (obj.equals(entry.getValue())) {
                return (String) entry.getKey();
            }
        }
        String id = UUID.randomUUID().toString().substring(24);
        mAnnotationsOverlayList.put(id, obj);
        return id;
    }

    @ReactMethod
    public void createObj(Promise promise) {
        try {
            AnnotationsOverlay annotationsOverlay = new AnnotationsOverlay();
            String annotationsOverlayId = registerId(annotationsOverlay);
            WritableMap map = Arguments.createMap();
            map.putString("AnnotationsOverlayId", annotationsOverlayId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void addAnnotation(String annotationsOverlayId, String annotationId, Promise promise)
    {
        try {
            AnnotationsOverlay annotationsOverlay = getObjFromList(annotationsOverlayId);
            Annotation annotation = JSAnnotation.getObjFromList(annotationId);
            annotationsOverlay.addAnnotation(annotation);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void addAnnotations(String annotationsOverlayId, ReadableArray annArray, Promise promise)
    {
        try {
            AnnotationsOverlay annotationsOverlay = getObjFromList(annotationsOverlayId);
            List<Annotation> annotationList = new ArrayList();
            if (annotationsOverlay != null) {
                for (int i = 0; i < annArray.size(); i++) {
                    ReadableMap readable = annArray.getMap(i);
                    String keyStr = readable.getString("_MGAnnotationId");
                    annotationList.add(JSAnnotation.getObjFromList(keyStr));
                }
            }
            annotationsOverlay.addAnnotations(annotationList);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void removeAnnotation(String annotationsOverlayId, int index, Promise promise)
    {
        try {
            AnnotationsOverlay annotationsOverlay = getObjFromList(annotationsOverlayId);
            annotationsOverlay.removeAnnotation(index);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void removeAnnotation(String annotationsOverlayId, String annotationId, Promise promise)
    {
        try {
            AnnotationsOverlay annotationsOverlay = getObjFromList(annotationsOverlayId);
            Annotation annotation = JSAnnotation.getObjFromList(annotationId);
            annotationsOverlay.removeAnnotation(annotation);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void removeAnnotations(String annotationsOverlayId, ReadableArray annArray, Promise promise)
    {
        try {
            AnnotationsOverlay annotationsOverlay = getObjFromList(annotationsOverlayId);
            List<Annotation> annotationList = new ArrayList();
            if (annotationsOverlay != null) {
                for (int i = 0; i < annArray.size(); i++) {
                    ReadableMap readable = annArray.getMap(i);
                    String keyStr = readable.getString("_MGAnnotationId");
                    annotationList.add(JSAnnotation.getObjFromList(keyStr));
                }
            }
            annotationsOverlay.removeAnnotations(annotationList);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void removeAllAnnotations(String annotationsOverlayId, Promise promise)
    {
        try {
            AnnotationsOverlay annotationsOverlay = getObjFromList(annotationsOverlayId);
            annotationsOverlay.removeAllAnnotations();
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getAnnotationCount(String annotationsOverlayId, Promise promise)
    {
        try {
            AnnotationsOverlay annotationsOverlay = getObjFromList(annotationsOverlayId);
            int count = annotationsOverlay.getAnnotationCount();
            promise.resolve(count);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void indexOf(String annotationsOverlayId, String annotationId, Promise promise)
    {
        try {
            AnnotationsOverlay annotationsOverlay = getObjFromList(annotationsOverlayId);
            Annotation annotation = JSAnnotation.getObjFromList(annotationId);
            int index = annotationsOverlay.indexOf(annotation);
            promise.resolve(index);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getAnnotation(String annotationsOverlayId, int index, Promise promise)
    {
        try {
            AnnotationsOverlay annotationsOverlay = getObjFromList(annotationsOverlayId);
            Annotation annotation = annotationsOverlay.getAnnotation(index);
            String annotationId = JSAnnotation.registerId(annotation);
            WritableMap map = Arguments.createMap();
            map.putString("AnnotationId", annotationId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getAllAnnotations(String annotationsOverlayId, Promise promise)
    {
        try {
            AnnotationsOverlay annotationsOverlay = getObjFromList(annotationsOverlayId);
            List<Annotation> AnnotationList = annotationsOverlay.getAllAnnotations();
            String annotationId = "";
            WritableArray arr = Arguments.createArray();
            if (AnnotationList.size() > 0) {
                for (int i = 0; i < AnnotationList.size(); i++) {
                    annotationId = JSAnnotation.registerId(AnnotationList.get(i));
                    arr.pushString(annotationId);
                }
            }
            WritableMap map = Arguments.createMap();
            map.putArray("AnnotationArr", arr);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void moveAnnotation(String annotationsOverlayId, int fromIndex, int toIndex, Promise promise)
    {
        try {
            AnnotationsOverlay annotationsOverlay = getObjFromList(annotationsOverlayId);
            annotationsOverlay.moveAnnotation(fromIndex, toIndex);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }
}
