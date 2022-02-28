package com.zondy.mapgis.mobile.react;

import android.graphics.PointF;
import android.view.MotionEvent;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.zondy.mapgis.android.mapview.MapTool;
import com.zondy.mapgis.android.mapview.MapView;
import com.zondy.mapgis.core.geometry.Dot;

public class MapViewMapTool implements MapTool {

    private ReactContext reactContext;
    private MapView mMapView;
    private String mMapViewId;

    private static final String DOUBLE_TAP_EVENT = "com.mapgis.RN.Mapview.double_tap_event";
    private static final String SINGLE_TAP_EVENT = "com.mapgis.RN.Mapview.single_tap_event";
    private static final String LONG_TAP_EVENT = "com.mapgis.RN.Mapview.long_tap_event";
    private static final String PAN_BEGAN_EVENT = "com.mapgis.RN.Mapview.panStateBegan_event";
    private static final String PAN_CHANGED_EVENT = "com.mapgis.RN.Mapview.panStateChanged_event";
    private static final String PAN_END_EVENT = "com.mapgis.RN.Mapview.panStateEnded_event";
    private static final String ZOOM_ROTATE_BEGAM_EVENT = "com.mapgis.RN.Mapview.zoomAndRotateStateBegan_event";
    private static final String ZOOM_ROTATE_CHANGED_EVENT = "com.mapgis.RN.Mapview.zoomAndRotateStateChanged_event";
    private static final String ZOOM_ROTATE_END_EVENT = "com.mapgis.RN.Mapview.zoomAndRotateStateEnded_event";

    private void sendEvent(String eventName, WritableMap params) {
        params.putString("ObjId", mMapViewId);
        reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
                .emit(eventName, params);
    }

    public MapViewMapTool(String mapViewId, ReactContext reactContext) {
        this.mMapViewId = mapViewId;
        this.mMapView = JSMapView.getObjById(mapViewId);
        this.reactContext = reactContext;
    }

    @Override
    public boolean panStateBegan(MotionEvent motionEvent, MapView mapView) {
        Dot dot = mMapView.viewPointToMapPoint(new PointF(motionEvent.getX(), motionEvent.getY()));
        WritableMap writableMap = Arguments.createMap();
        writableMap.putDouble("x", dot.x);
        writableMap.putDouble("y", dot.y);
        sendEvent(PAN_BEGAN_EVENT, writableMap);
        return false;
    }

    @Override
    public boolean panStateChanged(MotionEvent motionEvent, MapView mapView) {
        Dot dot = mMapView.viewPointToMapPoint(new PointF(motionEvent.getX(), motionEvent.getY()));
        WritableMap writableMap = Arguments.createMap();
        writableMap.putDouble("x", dot.x);
        writableMap.putDouble("y", dot.y);
        sendEvent(PAN_CHANGED_EVENT, writableMap);
        return false;
    }

    @Override
    public boolean panStateEnded(MotionEvent motionEvent, MapView mapView, float velocityX, float velocityY) {
        Dot dot = mMapView.viewPointToMapPoint(new PointF(motionEvent.getX(), motionEvent.getY()));
        WritableMap writableMap = Arguments.createMap();
        writableMap.putDouble("x", dot.x);
        writableMap.putDouble("y", dot.y);
        writableMap.putDouble("scale", velocityX);
        writableMap.putDouble("angle", velocityY);
        sendEvent(PAN_END_EVENT, writableMap);
        return false;
    }

    @Override
    public boolean zoomAndRotateStateBegan(MotionEvent motionEvent, MapView mapView) {
        Dot dot = mMapView.viewPointToMapPoint(new PointF(motionEvent.getX(), motionEvent.getY()));
        WritableMap writableMap = Arguments.createMap();
        writableMap.putDouble("x", dot.x);
        writableMap.putDouble("y", dot.y);
        sendEvent(ZOOM_ROTATE_BEGAM_EVENT, writableMap);
        return false;
    }

    @Override
    public boolean zoomAndRotateStateChanged(MotionEvent motionEvent, MapView mapView, float scale, float angle) {
        Dot dot = mMapView.viewPointToMapPoint(new PointF(motionEvent.getX(), motionEvent.getY()));
        WritableMap writableMap = Arguments.createMap();
        writableMap.putDouble("x", dot.x);
        writableMap.putDouble("y", dot.y);
        writableMap.putDouble("scale", scale);
        writableMap.putDouble("angle", angle);
        sendEvent(ZOOM_ROTATE_CHANGED_EVENT, writableMap);
        return false;
    }

    @Override
    public boolean zoomAndRotateStateEnded(MotionEvent motionEvent, MapView mapView, float scale, float angle) {
        Dot dot = mMapView.viewPointToMapPoint(new PointF(motionEvent.getX(), motionEvent.getY()));
        WritableMap writableMap = Arguments.createMap();
        writableMap.putDouble("x", dot.x);
        writableMap.putDouble("y", dot.y);
        writableMap.putDouble("scale", scale);
        writableMap.putDouble("angle", angle);
        sendEvent(ZOOM_ROTATE_END_EVENT, writableMap);
        return false;
    }

    @Override
    public boolean longTap(MotionEvent motionEvent, MapView mapView) {
        Dot dot = mMapView.viewPointToMapPoint(new PointF(motionEvent.getX(), motionEvent.getY()));
        WritableMap writableMap = Arguments.createMap();
        writableMap.putDouble("x", dot.x);
        writableMap.putDouble("y", dot.y);
        sendEvent(LONG_TAP_EVENT, writableMap);
        return false;
    }

    @Override
    public void tap(MotionEvent motionEvent, MapView mapView) {
        Dot dot = mMapView.viewPointToMapPoint(new PointF(motionEvent.getX(), motionEvent.getY()));
        WritableMap writableMap = Arguments.createMap();
        writableMap.putDouble("x", dot.x);
        writableMap.putDouble("y", dot.y);
        sendEvent(SINGLE_TAP_EVENT, writableMap);
    }

    @Override
    public boolean doubleTap(MotionEvent motionEvent, MapView mapView) {
        Dot tapDot = mMapView.viewPointToMapPoint(new PointF(motionEvent.getX(), motionEvent.getY()));
        WritableMap writableMap = Arguments.createMap();
        writableMap.putDouble("x", tapDot.x);
        writableMap.putDouble("y", tapDot.y);
        sendEvent(DOUBLE_TAP_EVENT, writableMap);
        return false;
    }
}
