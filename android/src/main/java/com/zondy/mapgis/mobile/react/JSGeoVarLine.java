package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.core.geometry.Dot;
import com.zondy.mapgis.core.geometry.Dot3D;
import com.zondy.mapgis.core.geometry.Dots;
import com.zondy.mapgis.core.geometry.Dots3D;
import com.zondy.mapgis.core.geometry.GeoPolygons;
import com.zondy.mapgis.core.geometry.GeoVarLine;
import com.zondy.mapgis.core.geometry.GeometryType;
import com.zondy.mapgis.core.object.Enumeration;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class JSGeoVarLine extends JSGeoLine{

    public static final String REACT_CLASS = "JSGeoVarLine";
    //public static Map<String, GeoVarLine> mGeoVarLineList = new HashMap<String, GeoVarLine>();

    public JSGeoVarLine(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public static GeoVarLine getObjFromList(String id) {
        return (GeoVarLine)mGeometryList.get(id);
    }

    public static String registerId(GeoVarLine obj) {
        for (Map.Entry entry : mGeometryList.entrySet()) {
            if (obj.equals(entry.getValue())) {
                return (String) entry.getKey();
            }
        }
        Calendar calendar = Calendar.getInstance();
        String id = Long.toString(calendar.getTimeInMillis());
        mGeometryList.put(id, obj);
        return id;
    }

    @ReactMethod
    public void createObj(Promise promise) {
        try {
            GeoVarLine geoVarLine = new GeoVarLine();
            String geoVarLineId = registerId(geoVarLine);

            WritableMap map = Arguments.createMap();
            map.putString("GeoVarLinesId", geoVarLineId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getType(String geoVarLineId, Promise promise)
    {
        try {
            GeoVarLine geoVarLine = getObjFromList(geoVarLineId);
            GeometryType geometryType = geoVarLine.getType();
            int type = Enumeration.getValueByName(GeometryType.class, geometryType.name());
            promise.resolve(type);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void append2D(String geoVarLineId, String dotId, Promise promise)
    {
        try {
            GeoVarLine geoVarLine = getObjFromList(geoVarLineId);
            Dot dot = JSDot.getObjFromList(dotId);
            long lVal = geoVarLine.append2D(dot);
            promise.resolve(lVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void append3D(String geoVarLineId, String dot3DId, Promise promise)
    {
        try {
            GeoVarLine geoVarLine = getObjFromList(geoVarLineId);
            Dot3D dot3D = JSDot3D.getObjFromList(dot3DId);
            long lVal = geoVarLine.append3D(dot3D);
            promise.resolve(lVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void del(String geoVarLineId, long index, Promise promise)
    {
        try {
            GeoVarLine geoVarLine = getObjFromList(geoVarLineId);
            long lVal = geoVarLine.del(index);
            promise.resolve(lVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void get2D(String geoVarLineId, long index, Promise promise)
    {
        try {
            GeoVarLine geoVarLine = getObjFromList(geoVarLineId);
            Dot dot = geoVarLine.get2D(index);
            String dotId = JSDot.registerId(dot);
            WritableMap map = Arguments.createMap();
            map.putString("DotId",dotId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void get3D(String geoVarLineId, long index, Promise promise)
    {
        try {
            GeoVarLine geoVarLine = getObjFromList(geoVarLineId);
            Dot3D dot3D = geoVarLine.get3D(index);
            String dot3DId = JSDot3D.registerId(dot3D);
            WritableMap map = Arguments.createMap();
            map.putString("Dot3DId",dot3DId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getDim(String geoVarLineId, Promise promise)
    {
        try {
            GeoVarLine geoVarLine = getObjFromList(geoVarLineId);
            short dim = geoVarLine.getDim();
            promise.resolve(dim);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getDotNum(String geoVarLineId, Promise promise)
    {
        try {
            GeoVarLine geoVarLine = getObjFromList(geoVarLineId);
            long lNum = geoVarLine.getDotNum();
            promise.resolve(lNum);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getX(String geoVarLineId, long index, Promise promise)
    {
        try {
            GeoVarLine geoVarLine = getObjFromList(geoVarLineId);
            double dX = geoVarLine.getX(index);
            promise.resolve(dX);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getY(String geoVarLineId, long index, Promise promise)
    {
        try {
            GeoVarLine geoVarLine = getObjFromList(geoVarLineId);
            double dY = geoVarLine.getY(index);
            promise.resolve(dY);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getZ(String geoVarLineId, long index, Promise promise)
    {
        try {
            GeoVarLine geoVarLine = getObjFromList(geoVarLineId);
            double dZ = geoVarLine.getZ(index);
            promise.resolve(dZ);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void update2D(String geoVarLineId, long index, String dotId, Promise promise)
    {
        try {
            GeoVarLine geoVarLine = getObjFromList(geoVarLineId);
            Dot dot = JSDot.getObjFromList(dotId);
            long lVal = geoVarLine.update2D(index, dot);
            promise.resolve(lVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void update3D(String geoVarLineId, long index, String dot3DId, Promise promise)
    {
        try {
            GeoVarLine geoVarLine = getObjFromList(geoVarLineId);
            Dot3D dot3D = JSDot3D.getObjFromList(dot3DId);
            long lVal = geoVarLine.update3D(index, dot3D);
            promise.resolve(lVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setDots3D(String geoVarLineId, String dots3DId, Promise promise)
    {
        try {
            GeoVarLine geoVarLine = getObjFromList(geoVarLineId);
            Dots3D dots3D = JSDots3D.getObjFromList(dots3DId);
            long lVal = geoVarLine.setDots3D(dots3D);
            promise.resolve(lVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setDots2D(String geoVarLineId, String dotsId, Promise promise)
    {
        try {
            GeoVarLine geoVarLine = getObjFromList(geoVarLineId);
            Dots dots = JSDots.getObjFromList(dotsId);
            long lVal = geoVarLine.setDots2D(dots);
            promise.resolve(lVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void isClosed(String geoVarLineId, Promise promise)
    {
        try {
            GeoVarLine geoVarLine = getObjFromList(geoVarLineId);
            boolean bIsClose = geoVarLine.isClosed();
            promise.resolve(bIsClose);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

   @ReactMethod
    public void empty(String geoVarLineId, Promise promise)
    {
        try {
            GeoVarLine geoVarLine = getObjFromList(geoVarLineId);
            long lVal = geoVarLine.empty();
            promise.resolve(lVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }
}
