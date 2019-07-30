package com.zondy.mapgis.mobile.react;

import android.util.Log;

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
                String id = (String) entry.getKey();
                mMapPositionList.put(id, obj);
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
            map.putString("mapPositionId", mapPositionId);
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

            String dotId = JSDot.registerId(centerDot);
            WritableMap map = Arguments.createMap();
            map.putString("dotID", dotId);

            Log.d("dotId", "" + dotId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public double setCenter(String MapPositionId,String centerDotID ,Promise promise) {
        try {
            MapPosition mapPosition = getObjFromList(MapPositionId);
            Dot centerDot = JSDot.getObjFromList(centerDotID);
            mapPosition.setCenter(centerDot);

        } catch (Exception e) {
            promise.reject(e);
        }
        return 0.0;
    }
}
