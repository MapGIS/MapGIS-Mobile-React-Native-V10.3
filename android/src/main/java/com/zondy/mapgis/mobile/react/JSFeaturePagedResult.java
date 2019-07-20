package com.zondy.mapgis.mobile.react;

import android.util.Log;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.android.internal.chart.json.GsonUtil;
import com.zondy.mapgis.core.attr.Field;
import com.zondy.mapgis.core.attr.Fields;
import com.zondy.mapgis.core.featureservice.Feature;
import com.zondy.mapgis.core.featureservice.FeaturePagedResult;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author fjl 2019-6-18 下午2:52:36
 * @content 要素查询结果Native组件
 */
public class JSFeaturePagedResult extends ReactContextBaseJavaModule {
    public static final String REACT_CLASS = "JSFeaturePagedResult";
    public static Map<String, FeaturePagedResult> mFeaturePagedResultList = new HashMap<String, FeaturePagedResult>();


    public JSFeaturePagedResult(ReactApplicationContext context) {
        super(context);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public static FeaturePagedResult getObjFromList(String id) {
        return mFeaturePagedResultList.get(id);
    }


    public static String registerId(FeaturePagedResult obj) {
        for (Map.Entry entry : mFeaturePagedResultList.entrySet()) {
            if (obj.equals(entry.getValue())) {
                String id = (String) entry.getKey();
                mFeaturePagedResultList.put(id, obj);
                return (String) entry.getKey();
            }
        }

        Calendar calendar = Calendar.getInstance();
        String id = Long.toString(calendar.getTimeInMillis());
        mFeaturePagedResultList.put(id, obj);
        return id;
    }

    @ReactMethod
    public void createObj(Promise promise) {
        try {
            FeaturePagedResult FeaturePagedResult = new FeaturePagedResult(0);
            String FeaturePagedResultId = registerId(FeaturePagedResult);

            WritableMap map = Arguments.createMap();
            map.putString("FeaturePagedResultId", FeaturePagedResultId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }


    @ReactMethod
    public void getTotalFeatureCount(String FeaturePagedResultId, Promise promise) {
        try {
            FeaturePagedResult FeaturePagedResult = getObjFromList(FeaturePagedResultId);
            int totalFeatureCount = FeaturePagedResult.getTotalFeatureCount();

            promise.resolve(totalFeatureCount);
        } catch (Exception e) {
            promise.reject(e);
        }
    }


    @ReactMethod
    public void getPageCount(String FeaturePagedResultId, Promise promise) {
        try {
            FeaturePagedResult FeaturePagedResult = getObjFromList(FeaturePagedResultId);
            int pageCount = FeaturePagedResult.getPageCount();

            promise.resolve(pageCount);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getPage(String FeaturePagedResultId, int pageNum, Promise promise) {
        try {
            FeaturePagedResult FeaturePagedResult = getObjFromList(FeaturePagedResultId);
            List<Feature> featureList = FeaturePagedResult.getPage(pageNum);

            Log.d("FeaturePagedResult:", "" + FeaturePagedResult);
            Log.d("FeaturePagedResult:", "" + featureList.size());

            String featureID = "";
            WritableArray arr = Arguments.createArray();
            for (int i = 0; i < featureList.size(); i++) {
                Feature feature = featureList.get(i);
                featureID = JSFeature.registerId(feature);
                arr.pushString(featureID);
            }
            WritableMap map = Arguments.createMap();
            map.putArray("values", arr);
            promise.resolve(map);

        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getFields(String FeaturePagedResultId, Promise promise) {
        try {
            FeaturePagedResult FeaturePagedResult = getObjFromList(FeaturePagedResultId);
            Fields fields = FeaturePagedResult.getFields();
            Field filed = fields.getField((short) 1);
            if (filed != null) {
                Log.e("f:", "filed:" + filed);
                Log.e("f:", "Fields:" + filed.getFieldName());
            }

            String FieldsJson = GsonUtil.format(fields);
            WritableMap map = Arguments.createMap();
            map.putString("FieldsJson", FieldsJson);
            promise.resolve(map);

        } catch (Exception e) {
            promise.reject(e);
        }
    }
}
