package com.zondy.mapgis.mobile.react;

import android.util.Log;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.android.graphic.Graphic;
import com.zondy.mapgis.android.graphic.GraphicMultiPoint;
import com.zondy.mapgis.android.internal.chart.json.GsonUtil;
import com.zondy.mapgis.core.featureservice.Feature;
import com.zondy.mapgis.core.geometry.Dot;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author fjl 2019-6-18 下午2:52:36
 * @content 要素对象Native组件
 */
public class JSFeature extends ReactContextBaseJavaModule {
    public static final String REACT_CLASS = "JSFeature";
    public static Map<String, Feature> mFeatureList = new HashMap<String, Feature>();


    public JSFeature(ReactApplicationContext context) {
        super(context);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public static Feature getObjFromList(String id) {
        return mFeatureList.get(id);
    }


    public static String registerId(Feature obj) {
        for (Map.Entry entry : mFeatureList.entrySet()) {
            if (obj.equals(entry.getValue())) {
                String id = (String) entry.getKey();
                mFeatureList.put(id, obj);
                return (String) entry.getKey();
            }
        }

        Calendar calendar = Calendar.getInstance();
        String id = Long.toString(calendar.getTimeInMillis());
        mFeatureList.put(id, obj);
        return id;
    }

    @ReactMethod
    public void createObj(Promise promise) {
        try {
            Feature Feature = new Feature(0);
            String FeatureId = registerId(Feature);

            WritableMap map = Arguments.createMap();
            map.putString("FeatureId", FeatureId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }


    @ReactMethod
    public void getID(String FeatureId, Promise promise) {
        try {
            Feature feature = getObjFromList(FeatureId);
            long ID = feature.getID();

            promise.resolve(ID);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getAttributes(String FeatureId, Promise promise) {
        try {
            Feature feature = getObjFromList(FeatureId);
            HashMap<String, String> Attributes = feature.getAttributes();

            for (String key : Attributes.keySet()) {
                Log.e("Attributes:", "" + "Key: " + key + " Value: " + Attributes.get(key));
            }

            String jsonAttributes = GsonUtil.format(Attributes);
            WritableMap map = Arguments.createMap();
            map.putString("jsonAttributes", jsonAttributes);
            promise.resolve(map);

        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void toGraphics(String FeatureId, Promise promise) {
        try {
            Feature feature = getObjFromList(FeatureId);

            List<Graphic> graphicLst = feature.toGraphics(true);
            String graphicID = "";
            WritableArray values = Arguments.createArray();
            if (graphicLst.size() > 0) {
                for (int i = 0; i < graphicLst.size(); i++) {
                    graphicID = JSGraphic.registerId(graphicLst.get(i));
                    values.pushString(graphicID);
                    Log.e("graphicID:", "" + graphicID);
                }
            }
            Log.e("values:", "" + values);
            WritableMap map = Arguments.createMap();
            map.putArray("values", values);
            promise.resolve(map);

        } catch (Exception e) {
            promise.reject(e);
        }
    }
}
