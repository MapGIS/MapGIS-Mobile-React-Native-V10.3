package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.android.mapview.MapPosition;
import com.zondy.mapgis.core.geometry.Dot;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * @author fjl 2019-7-30 下午2:52:36
 * @content 地图位置组件
 */
public class JSMapPosition extends ReactContextBaseJavaModule {
    public static final String REACT_CLASS = "JSMapPosition";
    public static Map<String, MapPosition> mMapPositionList = new HashMap<String, MapPosition>();

    public JSMapPosition(ReactApplicationContext context) {
        super(context);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public static MapPosition getObjFromList(String id) {
        return mMapPositionList.get(id);
    }


    public static String registerId(MapPosition obj) {
        for (Map.Entry entry : mMapPositionList.entrySet()) {
            if (obj.equals(entry.getValue())) {
                return (String) entry.getKey();
            }
        }
        Calendar calendar = Calendar.getInstance();
        String id = Long.toString(calendar.getTimeInMillis());
        mMapPositionList.put(id, obj);
        return id;
    }

    @ReactMethod
    public void createObj(String centerID, Double resolution, String rotateCenterID,Float rotateAngle,Float slopeAngle,Promise promise) {
        try {
            Dot centerDot = JSDot.getObjFromList(centerID);
            Dot rotateCenterDot = JSDot.getObjFromList(rotateCenterID);
            MapPosition mapPosition = new MapPosition(centerDot,resolution,rotateCenterDot,rotateAngle,slopeAngle);
            String mapPositionId = registerId(mapPosition);

            WritableMap map = Arguments.createMap();
            map.putString("MapPositionId", mapPositionId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }


    @ReactMethod
    public void getCenter(String MapPositionId, Promise promise) {
        try {
            MapPosition mapPosition = getObjFromList(MapPositionId);

            Dot centerDot =  mapPosition.getCenter();
            String dotID = JSDot.registerId(centerDot);

            WritableMap map = Arguments.createMap();
            map.putString("point2DId", dotID);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setCenter(String MapPositionId,String centerDotID ,Promise promise) {
        try {
            MapPosition mapPosition = getObjFromList(MapPositionId);
            Dot centerDot = JSDot.getObjFromList(centerDotID);
            mapPosition.setCenter(centerDot);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }

    }

    @ReactMethod
    public void setCenter(String MapPositionId, double centerX, double centerY, Promise promise)
    {
        try {
            MapPosition mapPosition = getObjFromList(MapPositionId);
            mapPosition.setCenter(centerX,centerY);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getResolution(String MapPositionId, Promise promise) {
        try {
            MapPosition mapPosition = getObjFromList(MapPositionId);
            double resolution =  mapPosition.getResolution();

            WritableMap map = Arguments.createMap();
            map.putDouble("resolution", resolution);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setResolution(String MapPositionId,Double resolution ,Promise promise) {
        try {
            MapPosition mapPosition = getObjFromList(MapPositionId);
            mapPosition.setResolution(resolution);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }

    }

    @ReactMethod
    public void getRotateCenter(String MapPositionId, Promise promise) {
        try {
            MapPosition mapPosition = getObjFromList(MapPositionId);
            Dot centerDot =  mapPosition.getRotateCenter();
            String dotID = JSDot.registerId(centerDot);

            WritableMap map = Arguments.createMap();
            map.putString("point2DId", dotID);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setRotateCenter(String MapPositionId,String centerDotID ,Promise promise) {
        try {
            MapPosition mapPosition = getObjFromList(MapPositionId);
            Dot centerDot = JSDot.getObjFromList(centerDotID);
            mapPosition.setRotateCenter(centerDot);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setRotateCenter(String MapPositionId, double rotateCenterX, double rotateCenterY, Promise promise)
    {
        try {
            MapPosition mapPosition = getObjFromList(MapPositionId);
            mapPosition.setRotateCenter(rotateCenterX, rotateCenterY);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getRotateAngle(String MapPositionId, Promise promise) {
        try {
            MapPosition mapPosition = getObjFromList(MapPositionId);
            double rotateAngle =  mapPosition.getRotateAngle();

            WritableMap map = Arguments.createMap();
            map.putDouble("rotateAngle", rotateAngle);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setRotateAngle(String MapPositionId,Float rotateAngle ,Promise promise) {
        try {
            MapPosition mapPosition = getObjFromList(MapPositionId);
            mapPosition.setRotateAngle(rotateAngle);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getSlopeAngle(String MapPositionId, Promise promise) {
        try {
            MapPosition mapPosition = getObjFromList(MapPositionId);
            double slopeAngle =  mapPosition.getSlopeAngle();

            WritableMap map = Arguments.createMap();
            map.putDouble("slopeAngle", slopeAngle);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setSlopeAngle(String MapPositionId,Float slopeAngle ,Promise promise) {
        try {
            MapPosition mapPosition = getObjFromList(MapPositionId);
            mapPosition.setSlopeAngle(slopeAngle);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }
}
