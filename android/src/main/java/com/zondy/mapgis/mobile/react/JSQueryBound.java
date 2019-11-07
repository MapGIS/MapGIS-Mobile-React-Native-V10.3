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
import com.zondy.mapgis.core.featureservice.FeatureQuery;
import com.zondy.mapgis.core.geometry.Dot;
import com.zondy.mapgis.core.geometry.Rect;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;


/**
 * @author fjl 2019-6-25 下午2:52:36
 * @content 要素查询空间范围Native组件
 */
public class JSQueryBound extends ReactContextBaseJavaModule {
    public static final String REACT_CLASS = "JSQueryBound";
    public static Map<String, FeatureQuery.QueryBound> mQueryBoundList = new HashMap<String, FeatureQuery.QueryBound>();


    public JSQueryBound(ReactApplicationContext context) {
        super(context);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public static FeatureQuery.QueryBound getObjFromList(String id) {
        return mQueryBoundList.get(id);
    }


    public static String registerId(FeatureQuery.QueryBound obj) {
        for (Map.Entry entry : mQueryBoundList.entrySet()) {
            if (obj.equals(entry.getValue())) {
                return (String) entry.getKey();
            }
        }
        Calendar calendar = Calendar.getInstance();
        String id = Long.toString(calendar.getTimeInMillis());
        mQueryBoundList.put(id, obj);
        return id;
    }

//    @ReactMethod
//    public void createObj(Promise promise) {
//        try {
//            FeatureQuery.QueryBound QueryBound = new FeatureQuery.QueryBound(new Dot(0.0, 0.0));
//            String queryBoundId = registerId(QueryBound);
//
//            WritableMap map = Arguments.createMap();
//            map.putString("QueryBoundId", queryBoundId);
//            promise.resolve(map);
//        } catch (Exception e) {
//            promise.reject(e);
//        }
//    }

   @ReactMethod
    public void createObjByPoint(String pointId, Promise promise)
    {
        try {
            Dot  point = JSDot.getObjFromList(pointId);
            FeatureQuery.QueryBound QueryBound = new FeatureQuery.QueryBound(point);
            String queryBoundId = registerId(QueryBound);

            WritableMap map = Arguments.createMap();
            map.putString("QueryBoundId", queryBoundId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void createObjByPointAndOff(String pointId, double dx, double dy, Promise promise)
    {
        try {
            Dot  point = JSDot.getObjFromList(pointId);
            FeatureQuery.QueryBound QueryBound = new FeatureQuery.QueryBound(point, dx, dy);
            String queryBoundId = registerId(QueryBound);

            WritableMap map = Arguments.createMap();
            map.putString("QueryBoundId", queryBoundId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void createObjByRect(String rectId, Promise promise)
    {
        try {
            Rect  rect = JSRect.getObjFromList(rectId);
            FeatureQuery.QueryBound QueryBound = new FeatureQuery.QueryBound(rect);
            String queryBoundId = registerId(QueryBound);

            WritableMap map = Arguments.createMap();
            map.putString("QueryBoundId", queryBoundId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void createObjByPoints(ReadableArray dotArr, Promise promise)
    {
        try {
            Dot[] dots = new Dot[dotArr.size()];
            for (int i = 0; i < dotArr.size(); i++) {
                ReadableMap innerMap = dotArr.getMap(i);
                String dotID = innerMap.getString("_MGDotId");
                Dot dot = JSDot.getObjFromList(dotID);
                dots[i] = dot;
            }
            FeatureQuery.QueryBound queryBound = new FeatureQuery.QueryBound(dots);
            String queryBoundId = registerId(queryBound);

            WritableMap map = Arguments.createMap();
            map.putString("QueryBoundId", queryBoundId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getBoundType(String QueryBoundId, Promise promise)
    {
        try {
            FeatureQuery.QueryBound queryBound = getObjFromList(QueryBoundId);
            int type = queryBound.getBoundType();
            promise.resolve(type);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getBoundPoints(String QueryBoundId, Promise promise)
    {
        try {
            FeatureQuery.QueryBound queryBound = getObjFromList(QueryBoundId);
            Dot[] dots = queryBound.getBoundPoins();
            String strPointId = "";
            WritableArray arr = Arguments.createArray();
            if (dots.length > 0) {
                for (int i = 0; i < dots.length; i++) {
                    strPointId = JSDot.registerId(dots[i]);
                    arr.pushString(strPointId);
                }
            }
            WritableMap map = Arguments.createMap();
            map.putArray("BoundPointArr", arr);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getDotOffDx(String QueryBoundId, Promise promise)
    {
        try {
            FeatureQuery.QueryBound queryBound = getObjFromList(QueryBoundId);
            double dx = queryBound.getDotOffDx();
            promise.resolve(dx);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getDotOffDy(String QueryBoundId, Promise promise)
    {
        try {
            FeatureQuery.QueryBound queryBound = getObjFromList(QueryBoundId);
            double dy = queryBound.getDotOffDy();
            promise.resolve(dy);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

//    @ReactMethod
//    public void setRect(String QueryBoundId, String rectID, Promise promise) {
//        try {
//            Rect rect = JSRect.mRectList.get(rectID);
//            FeatureQuery.QueryBound queryBoundNew = new FeatureQuery.QueryBound(rect);
//            mQueryBoundList.put(QueryBoundId, queryBoundNew);
//
//            Log.e("rect:", "" + rect.getXMin() + rect.getYMax());
//            for (String key : mQueryBoundList.keySet()) {
//                Log.e("Attributes:", "" + "Key: " + key + " Value: " + mQueryBoundList.get(key));
//            }
//            promise.resolve(true);
//        } catch (Exception e) {
//            promise.reject(e);
//        }
//    }
//
//    @ReactMethod
//    public void setPoint(String QueryBoundId, String dotID, double dx, double dy, Promise promise) {
//        try {
//            FeatureQuery.QueryBound queryBound = getObjFromList(QueryBoundId);
//            Dot dot = JSDot.m_Point2DList.get(dotID);
//            FeatureQuery.QueryBound queryBoundNew = new FeatureQuery.QueryBound(dot, dx, dy);
//            mQueryBoundList.put(QueryBoundId, queryBoundNew);
//            promise.resolve(true);
//        } catch (Exception e) {
//            promise.reject(e);
//        }
//    }
//
//    @ReactMethod
//    public void setPoints(String QueryBoundId, ReadableArray dotArr, double dx, double dy, Promise promise) {
//        try {
//            FeatureQuery.QueryBound queryBound = getObjFromList(QueryBoundId);
//            Dot[] dots = new Dot[dotArr.size()];
//            for (int i = 0; i < dotArr.size(); i++) {
//                ReadableMap innerMap = dotArr.getMap(i);
//                String dotID = innerMap.getString("_MGDotId");
//                Dot dot = JSDot.m_Point2DList.get(dotID);
//                dots[i] = dot;
//            }
//            FeatureQuery.QueryBound queryBoundNew = new FeatureQuery.QueryBound(dots);
//            mQueryBoundList.put(QueryBoundId, queryBoundNew);
//            promise.resolve(true);
//        } catch (Exception e) {
//            promise.reject(e);
//        }
//    }
}
