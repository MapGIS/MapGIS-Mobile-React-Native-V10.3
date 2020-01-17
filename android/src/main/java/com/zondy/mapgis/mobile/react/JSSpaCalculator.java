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

import java.util.List;

public class JSSpaCalculator extends ReactContextBaseJavaModule {

    private static final String REACT_CLASS = "JSSpaCalculator";

    public JSSpaCalculator(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @ReactMethod
    public static void anglePIOfDot(String xy0Id, String xy1Id, Promise promise)
    {
        try {
            Dot xy0 = JSDot.getObjFromList(xy0Id);
            Dot xy1 = JSDot.getObjFromList(xy1Id);
            double anglePI = SpaCalculator.anglePI(xy0, xy1);
            promise.resolve(anglePI);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public static void anglePIOfXY(double x0, double y0, double x1, double y1, Promise promise)
    {
        try {
            double anglePI = SpaCalculator.anglePI(x0, y0, x1, y1);
            promise.resolve(anglePI);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public static void angle2PIOfDot(String xy0Id, String xy1Id, Promise promise)
    {
        try {
            Dot xy0 = JSDot.getObjFromList(xy0Id);
            Dot xy1 = JSDot.getObjFromList(xy1Id);
            double angle2PI = SpaCalculator.angle2PI(xy0, xy1);
            promise.resolve(angle2PI);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public static void angle2PIOfXY(double x0, double y0, double x1, double y1, Promise promise)
    {
        try {
            double angle2PI = SpaCalculator.angle2PI(x0, y0, x1, y1);
            promise.resolve(angle2PI);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

   @ReactMethod
    public static void distanceOfDot(String xy0Id, String xy1Id, Promise promise)
    {
        try {
            Dot xy0 = JSDot.getObjFromList(xy0Id);
            Dot xy1 = JSDot.getObjFromList(xy1Id);
            double distance = SpaCalculator.distance(xy0, xy1);
            promise.resolve(distance);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public static void distanceOfXY(double x0, double y0, double x1, double y1, Promise promise)
    {
        try {
            double distance = SpaCalculator.distance(x0, y0, x1, y1);
            promise.resolve(distance);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public static void distanceOfGeometry(String geom1Id, String geom2Id, int distanceType, Promise promise)
    {
        try {
            Geometry geom1 = JSGeometry.getObjFromList(geom1Id);
            Geometry geom2 = JSGeometry.getObjFromList(geom2Id);
            DistanceType type = (DistanceType) Enumeration.parse(DistanceType.class, distanceType);
            double distance = SpaCalculator.distance(geom1, geom2, type);
            promise.resolve(distance);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public static void calLinesInters(String line1Id, String line2Id, Promise promise)
    {
        try {
            GeoVarLine line1 = JSGeoVarLine.getObjFromList(line1Id);
            GeoVarLine line2 = JSGeoVarLine.getObjFromList(line2Id);
            Dot[]  linesInters = SpaCalculator.calLinesInters(line1, line2);
            if(linesInters == null)
            {
                return;
            }
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
