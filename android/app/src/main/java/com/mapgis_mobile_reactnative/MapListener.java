package com.mapgis_mobile_reactnative;

import android.graphics.PointF;
import android.support.annotation.Nullable;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.zondy.mapgis.android.mapview.MapView;
import com.zondy.mapgis.core.geometry.Dot;

/**
 * @content 地图监听
 * @author fjl 2019-6-19 下午2:52:36
 */
public class MapListener implements MapView.MapViewDoubleTapListener,MapView.MapViewTapListener {

    private ReactContext reactContext;
    private MapView mMapView;

    private static final String DOUBLE_TAP_EVENT = "com.mapgis.RN.JSMapview.double_tap_event";
    private static final String SINGLE_TAP_EVENT = "com.mapgis.RN.JSMapview.single_tap_event";

    public MapListener(MapView mapView, ReactContext reactContext)
    {
        this.mMapView = mapView;
        this.reactContext = reactContext;

    }
    @Override
    public void mapViewTap(PointF pointF) {
        Dot tapDot = mMapView.viewPointToMapPoint(pointF);
        WritableMap writableMap = Arguments.createMap();
        writableMap.putDouble("x", tapDot.x);
        writableMap.putDouble("y", tapDot.y);
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



    private void sendEvent(MapView mapView, String eventName, @Nullable WritableMap params) {

        reactContext
                .getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
                .emit(eventName, params);

    }

}
