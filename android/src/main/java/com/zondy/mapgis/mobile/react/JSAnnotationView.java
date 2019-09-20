package com.zondy.mapgis.mobile.react;

import android.content.Context;
import android.graphics.PointF;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.ThemedReactContext;
import com.zondy.mapgis.android.annotation.Annotation;
import com.zondy.mapgis.android.annotation.AnnotationView;
import com.zondy.mapgis.android.mapview.MapView;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class JSAnnotationView extends ReactContextBaseJavaModule {
    public static final String REACT_CLASS = "JSAnnotationView";
    public static Map<String, AnnotationView> mAnnotationViewList = new HashMap<String, AnnotationView>();
    AnnotationView                            m_AnnotationView;
    ViewGroup                                 m_rootView;
    View                                      m_leftView;
    View                                      m_rightView;

    public JSAnnotationView(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public static AnnotationView getObjFromList(String id) {
        return mAnnotationViewList.get(id);
    }

    public static String registerId(AnnotationView obj) {
        for (Map.Entry entry : mAnnotationViewList.entrySet()) {
            if (obj.equals(entry.getValue())) {
                return (String) entry.getKey();
            }
        }
        Calendar calendar = Calendar.getInstance();
        String id = Long.toString(calendar.getTimeInMillis());
        mAnnotationViewList.put(id, obj);
        return id;
    }

    @ReactMethod
    public void createObj(String mapViewId, String annotationId, Promise promise){
        try{
            Context context = JSMapView.getObjById(mapViewId).getContext();
            Annotation annotation = JSAnnotation.getObjFromList(annotationId);
            AnnotationView annotationView = new AnnotationView(annotation, context);
            String annotationViewId = registerId(annotationView);

            WritableMap map = Arguments.createMap();
            map.putString("AnnotationViewId",annotationViewId);
            promise.resolve(map);
        }catch(Exception e){
            promise.reject(e);
        }
    }

   @ReactMethod
    public void setAnnotation(String annotationViewId, String annotationId, Promise promise)
    {
        try {
            AnnotationView annotationView = getObjFromList(annotationViewId);
            Annotation annotation = JSAnnotation.getObjFromList(annotationId);
            if (annotationView != null) {
                annotationView.setAnnotation(annotation);
            }
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getAnnotation(String annotationViewId, Promise promise)
    {
        try {
            AnnotationView annotationView = getObjFromList(annotationViewId);
            Annotation annotation =annotationView.getAnnotation();
            String annotationId = JSAnnotation.registerId(annotation);
            WritableMap map = Arguments.createMap();
            map.putString("AnnotationId", annotationId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setCalloutDirection(String annotationViewId, int direction, Promise promise)
    {
        try {
            AnnotationView annotationView = getObjFromList(annotationViewId);
            if (annotationView != null) {
                annotationView.setCalloutDirection(direction);
            }
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

   @ReactMethod
    public void getCalloutDirection(String annotationViewId, Promise promise)
    {
        try {
            AnnotationView annotationView = getObjFromList(annotationViewId);
            int direction = annotationView.getCalloutDirection();
            promise.resolve(direction);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setCalloutLocation(String annotationViewId, float location, Promise promise)
    {
        try {
            AnnotationView annotationView = getObjFromList(annotationViewId);
            if (annotationView != null) {
                annotationView.setCalloutLocation(location);
            }
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getCalloutLocation(String annotationViewId, Promise promise)
    {
        try {
            AnnotationView annotationView = getObjFromList(annotationViewId);
            float location = annotationView.getCalloutLocation();
            promise.resolve(location);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setCalloutOffset(String annotationViewId, String calloutOffsetId, Promise promise)
    {
        try {
            AnnotationView annotationView = getObjFromList(annotationViewId);
            PointF pointF = JSPointF.getObjFromList(calloutOffsetId);
            if (annotationView != null) {
                annotationView.setCalloutOffset(pointF);
            }
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getCalloutOffset(String annotationViewId, Promise promise)
    {
        try {
            AnnotationView annotationView = getObjFromList(annotationViewId);
            PointF pointF = annotationView.getCalloutOffset();
            String pointFId = JSPointF.registerId(pointF);
            WritableMap map = Arguments.createMap();
            map.putString("PointFId", pointFId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setPanToMapViewCenter(String annotationViewId, boolean moveToCenter, Promise promise)
    {
        try {
            AnnotationView annotationView = getObjFromList(annotationViewId);
            annotationView.setPanToMapViewCenter(moveToCenter);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void isPanToMapViewCenter(String annotationViewId, Promise promise)
    {
        try {
            AnnotationView annotationView = getObjFromList(annotationViewId);
            boolean isPan = annotationView.isPanToMapViewCenter();
            promise.resolve(isPan);
        } catch (Exception e) {
            promise.reject(e);
        }
    }
}
