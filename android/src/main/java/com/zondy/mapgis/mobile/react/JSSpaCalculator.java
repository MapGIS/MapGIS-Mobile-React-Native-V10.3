package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.core.geometry.DistanceType;
import com.zondy.mapgis.core.geometry.Dot;
import com.zondy.mapgis.core.geometry.GeoVarLine;
import com.zondy.mapgis.core.geometry.Geometry;
import com.zondy.mapgis.core.object.Enumeration;
import com.zondy.mapgis.core.spatial.CrossData;
import com.zondy.mapgis.core.spatial.SpaCalculator;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JSSpaCalculator extends ReactContextBaseJavaModule {

    public static final String REACT_CLASS = "JSSpaCalculator";
//    public static Map<String, SpaCalculator> mSpaCalculatorList = new HashMap<String, SpaCalculator>();

    public JSSpaCalculator(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

//    public static SpaCalculator getObjFromList(String id) {
//        return mSpaCalculatorList.get(id);
//    }

//    public static String registerId(SpaCalculator obj) {
//        for (Map.Entry entry : mSpaCalculatorList.entrySet()) {
//            if (obj.equals(entry.getValue())) {
//                return (String) entry.getKey();
//            }
//        }
//        Calendar calendar = Calendar.getInstance();
//        String id = Long.toString(calendar.getTimeInMillis());
//        mSpaCalculatorList.put(id, obj);
//        return id;
//    }

//    @ReactMethod
//    public void createObj(Promise promise) {
//        try {
//            SpaCalculator spaCalculator = new SpaCalculator();
//            String spaCalculatorId = registerId(spaCalculator);
//            WritableMap map = Arguments.createMap();
//            map.putString("SpaCalculatorId", spaCalculatorId);
//            promise.resolve(map);
//        } catch (Exception e) {
//            promise.reject(e);
//        }
//    }

    @ReactMethod
    public static void anglePI(String xy0Id, String xy1Id, Promise promise)
    {
        try {
            Dot xy0 = JSDot.getObjFromList(xy0Id);
            Dot xy1 = JSDot.getObjFromList(xy1Id);
            double anglePI = (int)SpaCalculator.anglePI(xy0, xy1);
            promise.resolve(anglePI);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public static void anglePI(double x0, double y0, double x1, double y1, Promise promise)
    {
        try {
            double anglePI = (int)SpaCalculator.anglePI(x0, y0, x1, y1);
            promise.resolve(anglePI);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public static void angle2PI(String xy0Id, String xy1Id, Promise promise)
    {
        try {
            Dot xy0 = JSDot.getObjFromList(xy0Id);
            Dot xy1 = JSDot.getObjFromList(xy1Id);
            double angle2PI = (int)SpaCalculator.angle2PI(xy0, xy1);
            promise.resolve(angle2PI);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public static void angle2PI(double x0, double y0, double x1, double y1, Promise promise)
    {
        try {
            double angle2PI = (int)SpaCalculator.angle2PI(x0, y0, x1, y1);
            promise.resolve(angle2PI);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

   @ReactMethod
    public static void distance(String xy0Id, String xy1Id, Promise promise)
    {
        try {
            Dot xy0 = JSDot.getObjFromList(xy0Id);
            Dot xy1 = JSDot.getObjFromList(xy1Id);
            double distance = (int)SpaCalculator.distance(xy0, xy1);
            promise.resolve(distance);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public static void distance(double x0, double y0, double x1, double y1, Promise promise)
    {
        try {
            double distance = (int)SpaCalculator.distance(x0, y0, x1, y1);
            promise.resolve(distance);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public static void distance(String geom1Id, String geom2Id, int distanceType, Promise promise)
    {
        try {
            Geometry geom1 = JSGeometry.getObjFromList(geom1Id);
            Geometry geom2 = JSGeometry.getObjFromList(geom2Id);
            DistanceType type = (DistanceType) Enumeration.parse(DistanceType.class, distanceType);
            double distance = (int)SpaCalculator.distance(geom1, geom2, type);
            promise.resolve(distance);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 计算两条线的交点
     */
    public static void calLinesInters(String line1Id, String line2Id, Promise promise)
    {
        try {
            GeoVarLine line1 = JSGeoVarLine.getObjFromList(line1Id);
            GeoVarLine line2 = JSGeoVarLine.getObjFromList(line2Id);
            Dot[]  linesInters = SpaCalculator.calLinesInters(line1, line2);
            String point2DId = "";
            WritableArray linesIntersArray = Arguments.createArray();
            for (int i = 0; i < linesInters.length; i++) {
                point2DId = JSDot.registerId(linesInters[i]);
                linesIntersArray.pushString(point2DId);
            }
            WritableMap map = Arguments.createMap();
            map.putArray("LinesIntersArray", linesIntersArray);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

   @ReactMethod
    public static void  arcSelfCross(ReadableArray pointArray, Promise promise)
    {
        try {
            if(pointArray.size() > 0)
            {
                Dot[] points = new Dot[pointArray.size()];
                for (int i = 0; i < pointArray.size(); i++) {
                    ReadableMap readable = pointArray.getMap(i);
                    String keyStr = readable.getString("point2DId");
                    points[i] = JSDot.getObjFromList(keyStr);
                }
                List<CrossData>  crossDataList = SpaCalculator.arcSelfCross(points);
                String crossDataId = "";
                WritableArray crossDataArray = Arguments.createArray();
                for (int i = 0; i < crossDataList.size(); i++) {
                    crossDataId = JSCrossData.registerId(crossDataList.get(i));
                    crossDataArray.pushString(crossDataId);
                }
                WritableMap map = Arguments.createMap();
                map.putArray("CrossDataArray", crossDataArray);
                promise.resolve(map);
            }
        } catch (Exception e) {
            promise.reject(e);
        }
    }
}
