package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.core.attr.Fields;
import com.zondy.mapgis.core.featureservice.Feature;
import com.zondy.mapgis.core.featureservice.FeatureEdit;
import com.zondy.mapgis.core.geodatabase.IVectorCls;
import com.zondy.mapgis.core.geodatabase.XClsType;
import com.zondy.mapgis.core.geometry.GeomType;
import com.zondy.mapgis.core.map.VectorLayer;
import com.zondy.mapgis.core.object.Enumeration;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class JSFeatureEdit extends ReactContextBaseJavaModule {

    public static final String REACT_CLASS = "JSFeatureEdit";
    public static Map<String, FeatureEdit> mFeatureEditList = new HashMap<String, FeatureEdit>();

    public JSFeatureEdit(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public static FeatureEdit getObjFromList(String id) {
        return mFeatureEditList.get(id);
    }

    public static String registerId(FeatureEdit obj) {
        for (Map.Entry entry : mFeatureEditList.entrySet()) {
            if (obj.equals(entry.getValue())) {
                return (String) entry.getKey();
            }
        }
        Calendar calendar = Calendar.getInstance();
        String id = Long.toString(calendar.getTimeInMillis());
        mFeatureEditList.put(id, obj);
        return id;
    }

    @ReactMethod
    public void createObjByVectorLayer(String vectorLayerId, Promise promise) {
        try {
            VectorLayer vectorLayer = (VectorLayer)JSVectorLayer.getObjFromList(vectorLayerId);
            FeatureEdit featureEdit = new FeatureEdit(vectorLayer);
            String featureEditId = registerId(featureEdit);
            WritableMap map = Arguments.createMap();
            map.putString("FeatureEditId", featureEditId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void createObjByVectorCls(String vectorClsId, Promise promise) {
        try { ;
            IVectorCls cls = (IVectorCls)JSVectorCls.getObjFromList(vectorClsId);
            FeatureEdit featureEdit = new FeatureEdit(cls);
            String featureEditId = registerId(featureEdit);
            WritableMap map = Arguments.createMap();
            map.putString("FeatureEditId", featureEditId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void createObjByIGSDoc(String strIGServerBaseURL, String strDocName, int mapID, int layerID, Promise promise) {
        try { ;
            FeatureEdit featureEdit = new FeatureEdit(strIGServerBaseURL, strDocName, mapID, layerID);
            String featureEditId = registerId(featureEdit);
            WritableMap map = Arguments.createMap();
            map.putString("FeatureEditId", featureEditId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void createObjByIGSData(String strIGServerBaseURL, String strDataURL, Promise promise) {
        try { ;
            FeatureEdit featureEdit = new FeatureEdit(strIGServerBaseURL, strDataURL);
            String featureEditId = registerId(featureEdit);
            WritableMap map = Arguments.createMap();
            map.putString("FeatureEditId", featureEditId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void append(String featureEditId, String featureId, Promise promise)
    {
        try {
            FeatureEdit featureEdit = getObjFromList(featureEditId);
            Feature feature = JSFeature.getObjFromList(featureId);
            int iVal = (int)featureEdit.append(feature);
            promise.resolve(iVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

   @ReactMethod
    public void appendFeatures(String featureEditId, ReadableArray featureArray, Promise promise)
    {
        try {
            FeatureEdit featureEdit = getObjFromList(featureEditId);
            ArrayList<Feature> featureLst = new ArrayList();
            if (featureEdit != null) {
                for (int i = 0; i < featureArray.size(); i++) {
                    ReadableMap readable = featureArray.getMap(i);
                    String keyStr = readable.getString("FeatureId");
                    featureLst.add(JSFeature.getObjFromList(keyStr));
                }
            }
            int iVal = (int)featureEdit.append(featureLst);
            promise.resolve(iVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void delete(String featureEditId, int objID, Promise promise)
    {
        try {
            FeatureEdit featureEdit = getObjFromList(featureEditId);
            int iVal = (int)featureEdit.delete(objID);
            promise.resolve(iVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void deleteObjIDs(String featureEditId, ReadableArray objIDArray, Promise promise)
    {
        try {
            FeatureEdit featureEdit = getObjFromList(featureEditId);
            long[] objIDs = new long[objIDArray.size()];
            if (featureEdit != null) {
                for (int i = 0; i < objIDArray.size(); i++) {
                    objIDs[i] = objIDArray.getInt(i);
                }
            }
            int iVal = (int)featureEdit.delete(objIDs);
            promise.resolve(iVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void update(String featureEditId, int objID, String featureId, Promise promise)
    {
        try {
            FeatureEdit featureEdit = getObjFromList(featureEditId);
            Feature feature = JSFeature.getObjFromList(featureId);
            int iVal = (int)featureEdit.update(objID, feature);
            promise.resolve(iVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void updateFeatures(String featureEditId, ReadableArray featureArray, Promise promise)
    {
        try {
            FeatureEdit featureEdit = getObjFromList(featureEditId);
            ArrayList<Feature> featureLst = new ArrayList();
            if (featureEdit != null) {
                for (int i = 0; i < featureArray.size(); i++) {
                    ReadableMap readable = featureArray.getMap(i);
                    String keyStr = readable.getString("FeatureId");
                    featureLst.add(JSFeature.getObjFromList(keyStr));
                }
            }
            int iVal = (int)featureEdit.update(featureLst);
            promise.resolve(iVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void createClsBySRef(String featureEditId, int clsType, String name, int geomType, String srefName, String dsName, String fldsId, Promise promise)
    {
        try {
            FeatureEdit featureEdit = getObjFromList(featureEditId);
            XClsType xClsType = (XClsType) Enumeration.parse(XClsType.class, clsType);
            GeomType type = (GeomType) Enumeration.parse(GeomType.class, geomType);
            Fields flds = JSFields.getObjFromList(fldsId);
            String strUrl = featureEdit.createCls(xClsType, name, type, srefName, dsName, flds);
            promise.resolve(strUrl);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

   @ReactMethod
    public void createCls(String featureEditId, int clsType, String name, int geomType, String fldsId, Promise promise)
    {
        try {
            FeatureEdit featureEdit = getObjFromList(featureEditId);
            XClsType xClsType = (XClsType) Enumeration.parse(XClsType.class, clsType);
            GeomType type = (GeomType) Enumeration.parse(GeomType.class, geomType);
            Fields flds = JSFields.getObjFromList(fldsId);
            String strUrl = featureEdit.createCls(xClsType, name, type, flds);
            promise.resolve(strUrl);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void deleteCls(String featureEditId, int clsType, String name, Promise promise)
    {
        try {
            FeatureEdit featureEdit = getObjFromList(featureEditId);
            XClsType xClsType = (XClsType) Enumeration.parse(XClsType.class, clsType);
            int iVal = (int)featureEdit.deleteCls(xClsType, name);
            promise.resolve(iVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }
}
