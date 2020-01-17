package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.core.attr.Fields;
import com.zondy.mapgis.core.featureservice.Feature;
import com.zondy.mapgis.core.featureservice.FeaturePagedResult;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author fjl 2019-6-18 下午2:52:36
 * @content 要素查询结果Native组件
 */
public class JSFeaturePagedResult extends ReactContextBaseJavaModule {
    private static final String REACT_CLASS = "JSFeaturePagedResult";
    private static Map<String, FeaturePagedResult> mFeaturePagedResultList = new HashMap<String, FeaturePagedResult>();

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
                return (String) entry.getKey();
            }
        }

        String id = UUID.randomUUID().toString().substring(24);
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
            String fieldsId = JSFields.registerId(fields);
            WritableMap map = Arguments.createMap();
            map.putString("FieldsId", fieldsId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }
}
