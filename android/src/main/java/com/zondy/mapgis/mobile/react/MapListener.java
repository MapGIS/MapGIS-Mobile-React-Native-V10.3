package com.zondy.mapgis.mobile.react;

import android.graphics.PointF;
import android.view.MotionEvent;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.zondy.mapgis.android.annotation.Annotation;
import com.zondy.mapgis.android.annotation.AnnotationView;
import com.zondy.mapgis.android.mapview.MapPosition;
import com.zondy.mapgis.android.mapview.MapView;
import com.zondy.mapgis.core.geometry.Dot;

/**
 * @author fjl 2019-6-19 下午2:52:36
 * @content 地图监听
 */
public class MapListener implements MapView.MapViewDoubleTapListener, MapView.MapViewLongTapListener, MapView.MapViewTapListener, MapView.MapViewTouchListener,
        MapView.MapViewZoomChangedListener, MapView.MapViewAnimationListener, MapView.MapViewCenterChangedListener,
        MapView.MapViewRotateChangedListener, MapView.MapViewRefreshListener, MapView.MapViewMapLoadListener, MapView.MapViewPositionChangedListener, MapView.MapViewAnnotationListener {

    private ReactContext reactContext;
    private MapView mMapView;

    private static final String DOUBLE_TAP_EVENT = "com.mapgis.RN.Mapview.double_tap_event";
    private static final String SINGLE_TAP_EVENT = "com.mapgis.RN.Mapview.single_tap_event";
    private static final String LONG_TAP_EVENT = "com.mapgis.RN.Mapview.long_tap_event";
    private static final String TOUCH_EVENT = "com.mapgis.RN.Mapview.touch_event";
    private static final String ZOOMCHANGED_EVENT = "com.mapgis.RN.Mapview.zoomchanged_event";
    private static final String ROTATECHANGED_EVENT = "com.mapgis.RN.Mapview.rotatechanged_event";
    private static final String CENTERCHANGED_EVENT = "com.mapgis.RN.Mapview.centerchanged_event";
    private static final String ANIMATION_LISTENER = "com.mapgis.RN.Mapview.AnimationListener";
    private static final String REFRESH_LISTENER = "com.mapgis.RN.Mapview.RefreshListener";
    private static final String LOADINGMAP_LISTENER = "com.mapgis.RN.Mapview.LoadMapListener";
    private static final String POSITIONCHANGED_LISTENER = "com.mapgis.RN.Mapview.PositionChangedListener";
    private static final String ANNOTATION_LISTENER = "com.mapgis.RN.Mapview.AnnotationListener";


    public MapListener(MapView mapView, ReactContext reactContext) {
        this.mMapView = mapView;
        this.reactContext = reactContext;

    }

    @Override
    public void mapViewTap(PointF pointF) {
        Dot dot = mMapView.viewPointToMapPoint(pointF);
        WritableMap writableMap = Arguments.createMap();
        writableMap.putDouble("x", dot.x);
        writableMap.putDouble("y", dot.y);
        sendEvent(mMapView, SINGLE_TAP_EVENT, writableMap);
    }

    @Override
    public boolean mapViewDoubleTap(PointF pointF) {
        Dot tapDot = mMapView.viewPointToMapPoint(pointF);
        WritableMap writableMap = Arguments.createMap();
        writableMap.putDouble("x", tapDot.x);
        writableMap.putDouble("y", tapDot.y);
        sendEvent(mMapView, DOUBLE_TAP_EVENT, writableMap);
        return false;
    }


    private void sendEvent(MapView mapView, String eventName, WritableMap params) {

        reactContext
                .getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
                .emit(eventName, params);

    }

    @Override
    public boolean mapViewLongTap(PointF pointF) {
        Dot dot = mMapView.viewPointToMapPoint(pointF);
        WritableMap writableMap = Arguments.createMap();
        writableMap.putDouble("x", dot.x);
        writableMap.putDouble("y", dot.y);
        sendEvent(mMapView, LONG_TAP_EVENT, writableMap);
        return false;
    }

    @Override
    public void mapViewZoomChanged(MapView mapView, double oldResolution, double newResolution) {
        WritableMap writableMap = Arguments.createMap();
        writableMap.putDouble("oldResolution", oldResolution);
        writableMap.putDouble("newResolution", newResolution);
        sendEvent(mMapView, ZOOMCHANGED_EVENT, writableMap);
    }

    @Override
    public void mapViewRotateChanged(MapView mapView, float oldAngle, float newAngle) {
        WritableMap writableMap = Arguments.createMap();
        writableMap.putDouble("oldAngle", oldAngle);
        writableMap.putDouble("newAngle", newAngle);
        sendEvent(mMapView, ROTATECHANGED_EVENT, writableMap);
    }


    @Override
    public void mapViewCenterChanged(MapView mapView, Dot oldCenter, Dot newCenter) {
        WritableMap writableMap = Arguments.createMap();
        writableMap.putDouble("oldCenterX", oldCenter.getX());
        writableMap.putDouble("oldCenterY", oldCenter.getY());
        writableMap.putDouble("newCenterX", newCenter.getX());
        writableMap.putDouble("newCenterY", newCenter.getY());
        sendEvent(mMapView, CENTERCHANGED_EVENT, writableMap);
    }

    @Override
    public void mapViewWillStartLoadingMap(MapView mapView, String strDocPath) {
        WritableMap writableMap = Arguments.createMap();
        writableMap.putBoolean("StartLoadingMap", true);
        sendEvent(mMapView, LOADINGMAP_LISTENER, writableMap);
    }

    @Override
    public void mapViewDidFinishLoadingMap(MapView mapView, String strDocPath) {
        WritableMap writableMap = Arguments.createMap();
        writableMap.putBoolean("DidFinishLoadingMap", true);
        writableMap.putString("strDocPath", strDocPath);
        sendEvent(mMapView, LOADINGMAP_LISTENER, writableMap);
    }

    @Override
    public void mapViewDidFailLoadingMap(MapView mapView, String strDocPath) {

        WritableMap writableMap = Arguments.createMap();
        writableMap.putBoolean("DidFailLoadingMap", true);
        sendEvent(mMapView, LOADINGMAP_LISTENER, writableMap);
    }

    @Override
    public void mapViewWillStartRefresh(MapView mapView) {
        WritableMap writableMap = Arguments.createMap();
        writableMap.putBoolean("StartRefresh", true);
        sendEvent(mMapView, REFRESH_LISTENER, writableMap);
    }

    @Override
    public void mapViewDidFinishRefresh(MapView mapView) {
        WritableMap writableMap = Arguments.createMap();
        writableMap.putBoolean("DidFinishRefresh", true);
        sendEvent(mMapView, REFRESH_LISTENER, writableMap);
    }


    @Override
    public void mapViewAnimationStart(MapView mapView, int animationType) {
        WritableMap writableMap = Arguments.createMap();
        writableMap.putDouble("animationType", animationType);
        sendEvent(mMapView, ANIMATION_LISTENER, writableMap);
    }

    @Override
    public void mapViewAnimationFinish(MapView mapView, int animationType, boolean normalFinish) {
        WritableMap writableMap = Arguments.createMap();
        writableMap.putDouble("animationType", animationType);
        writableMap.putBoolean("normalFinish", normalFinish);
        sendEvent(mMapView, ANIMATION_LISTENER, writableMap);
    }

    @Override
    public boolean mapViewTouch(MotionEvent motionEvent) {
        WritableMap writableMap = Arguments.createMap();
        writableMap.putDouble("x", motionEvent.getX());
        writableMap.putDouble("y", motionEvent.getY());
        sendEvent(mMapView, TOUCH_EVENT, writableMap);
        return false;
    }

    @Override
    public void mapViewPositionChanged(MapPosition oldMapPosition, MapPosition newMapPosition) {
        WritableMap writableMap = Arguments.createMap();
        String oldMapPositionId = JSMapPosition.registerId(oldMapPosition);
        String newMapPositionId = JSMapPosition.registerId(newMapPosition);
        WritableMap map = Arguments.createMap();
        map.putString("oldMapPositionId", oldMapPositionId);
        map.putString("newMapPositionId", newMapPositionId);
        sendEvent(mMapView, POSITIONCHANGED_LISTENER, writableMap);
    }

    @Override
    public void mapViewClickAnnotation(MapView mapView, Annotation annotation) {
        WritableMap writableMap = Arguments.createMap();
        String annotationId = JSAnnotation.registerId(annotation);
        WritableMap map = Arguments.createMap();
        map.putString("AnnotationId", annotationId);
        sendEvent(mMapView, ANNOTATION_LISTENER, writableMap);
    }

    @Override
    public boolean mapViewWillShowAnnotationView(MapView mapView, AnnotationView annotationView) {
        WritableMap writableMap = Arguments.createMap();
        String annotationViewId = JSAnnotationView.registerId(annotationView);
        WritableMap map = Arguments.createMap();
        map.putString("AnnotationViewId", annotationViewId);
        sendEvent(mMapView, ANNOTATION_LISTENER, writableMap);
        return false;
    }

    @Override
    public boolean mapViewWillHideAnnotationView(MapView mapView, AnnotationView annotationView) {
        WritableMap writableMap = Arguments.createMap();
        String annotationViewId = JSAnnotationView.registerId(annotationView);
        WritableMap map = Arguments.createMap();
        map.putString("AnnotationViewId", annotationViewId);
        sendEvent(mMapView, ANNOTATION_LISTENER, writableMap);
        return false;
    }

    @Override
    public AnnotationView mapViewViewForAnnotation(MapView mapView, Annotation annotation) {
        WritableMap writableMap = Arguments.createMap();
        String annotationId = JSAnnotation.registerId(annotation);
        WritableMap map = Arguments.createMap();
         map.putString("AnnotationId", annotationId);
        sendEvent(mMapView, ANNOTATION_LISTENER, writableMap);
        return null;
    }

    @Override
    public void mapViewClickAnnotationView(MapView mapView, AnnotationView annotationView) {
        WritableMap writableMap = Arguments.createMap();
        String annotationViewId = JSAnnotationView.registerId(annotationView);
        WritableMap map = Arguments.createMap();
        map.putString("AnnotationViewId", annotationViewId);
        sendEvent(mMapView, ANNOTATION_LISTENER, writableMap);
    }
}
