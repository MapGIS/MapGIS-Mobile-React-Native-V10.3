package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.android.graphic.Graphic;
import com.zondy.mapgis.android.internal.chart.json.GsonUtil;
import com.zondy.mapgis.core.featureservice.Feature;
import com.zondy.mapgis.core.geometry.Geometry;
import com.zondy.mapgis.core.geometry.GeometryType;
import com.zondy.mapgis.core.info.GeomInfo;
import com.zondy.mapgis.core.object.Enumeration;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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
                return (String) entry.getKey();
            }
        }
        String id = UUID.randomUUID().toString().substring(24);
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
            int ID = (int)feature.getID();

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
            String jsonAttributes = GsonUtil.format(Attributes);
            WritableMap map = Arguments.createMap();
            map.putString("jsonAttributes", jsonAttributes);
            promise.resolve(map);

        } catch (Exception e) {
            promise.reject(e);
        }
    }

   @ReactMethod
    public void getGeometry(String FeatureId, Promise promise)
    {
        try {
            Feature feature = getObjFromList(FeatureId);
            Geometry geometry = feature.getGeometry();
            String geometryId = JSGeometry.registerId(geometry);
            GeometryType geometryType = geometry.getType();
            int type = Enumeration.getValueByName(GeometryType.class, geometryType.name());
            WritableMap map = Arguments.createMap();
            map.putString("GeometryId", geometryId);
            map.putInt("GeometryType", type);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getInfo(String FeatureId, Promise promise)
    {
        try {
            Feature feature = getObjFromList(FeatureId);
            GeomInfo info = feature.getInfo();
            String infoId = JSGeomInfo.registerId(info);
            GeometryType geometryType = feature.getGeometry().getType();
            int type = Enumeration.getValueByName(GeometryType.class, geometryType.name());

            WritableMap map = Arguments.createMap();
            map.putString("GeomInfoId", infoId);
            map.putInt("GeometryType", type);
            promise.resolve(map);

        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void toGraphics(String FeatureId, Promise promise) {
        try {
            Feature feature = getObjFromList(FeatureId);
            if(feature != null)
            {
                List<Graphic> graphicLst = feature.toGraphics(true);
                String graphicID = "";
                WritableArray values = Arguments.createArray();
                if (graphicLst.size() > 0) {
                    for (int i = 0; i < graphicLst.size(); i++) {
                        graphicID = JSGraphic.registerId(graphicLst.get(i));
                        values.pushString(graphicID);
                    }
                }
                WritableMap map = Arguments.createMap();
                map.putArray("values", values);
                promise.resolve(map);
            }
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void reSet(String FeatureId, Promise promise)
    {
        try {
            Feature feature = getObjFromList(FeatureId);
            int iVal = (int)feature.reSet();
            promise.resolve(iVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void modifyFeatureValue(String FeatureId, String attributeJson, String geomId, String infoId, Promise promise)
    {
        try {
            Geometry geom = JSGeometry.getObjFromList(geomId);
            GeomInfo info = JSGeomInfo.getObjFromList(infoId);
            Feature feature = getObjFromList(FeatureId);
            HashMap<String, String> attributesMap = convertJsonToMap(attributeJson);

            int modifyResult = 0;
            if(feature != null){
                modifyResult = (int)feature.modifyFeatureValue(attributesMap, geom, info);
            }
            promise.resolve(modifyResult);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    // 将json格式的属性转换为HashMap
    private HashMap<String, String> convertJsonToMap(String json){
        HashMap<String, String> attributesMap = new HashMap<>();
        try {
            if(json != null && !json.isEmpty()){
                JSONObject jsonObject = new JSONObject(json);

                Iterator<String> it = jsonObject.keys();
                    while(it.hasNext()){
                        String key = it.next();
                        String value = (String) jsonObject.get(key);

                        attributesMap.put(key, value);
                    }
           }

        }catch (Exception e){
            e.printStackTrace();
        }

        return  attributesMap;
    }

}
