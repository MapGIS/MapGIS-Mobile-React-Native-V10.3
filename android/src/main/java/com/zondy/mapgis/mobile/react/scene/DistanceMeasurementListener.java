package com.zondy.mapgis.mobile.react.scene;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.zondy.mapgis.core.spatial.DistanceMeasurement;
import com.zondy.mapgis.core.spatial.MeasurementChangedEvent;

/**
 * @auther LiaoLiang on 20-8-18
 * @content
 */
public class DistanceMeasurementListener implements DistanceMeasurement.DistanceMeasureChangedListener {
    private ReactContext reactContext;
    private DistanceMeasurement distanceMeasurement;

    private static final String MeasurementChanged_Event  = "com.mapgis.RN.FlyManager.measurementChanged_event";


    public DistanceMeasurementListener(DistanceMeasurement distanceMeasurement, ReactContext reactContext) {
        this.distanceMeasurement = distanceMeasurement;
        this.reactContext = reactContext;
    }

    private void sendEvent(DistanceMeasurement distanceMeasurement, String eventName, WritableMap params) {

        reactContext
                .getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
                .emit(eventName, params);

    }
    @Override
    public void onMeasurementChanged(MeasurementChangedEvent measurementChangedEvent) {
        WritableMap writableMap = Arguments.createMap();
        writableMap.putDouble("DirectDistance",measurementChangedEvent.getDirectDistance());
        writableMap.putDouble("HorizontalDistance",measurementChangedEvent.getHorizontalDistance());
        writableMap.putDouble("VerticalDistance",measurementChangedEvent.getVerticalDistance());
        writableMap.putString("Source",JSDistanceMeasurement.registerId(measurementChangedEvent.getSource()));
        sendEvent(distanceMeasurement,MeasurementChanged_Event,writableMap);
    }
}
