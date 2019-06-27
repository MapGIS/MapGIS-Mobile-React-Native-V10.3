package com.mapgis_mobile_reactnative;

import android.util.Log;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.android.internal.chart.json.GsonUtil;
import com.zondy.mapgis.core.featureservice.Feature;
import com.zondy.mapgis.core.featureservice.FeaturePagedResult;
import com.zondy.mapgis.core.featureservice.FeatureQuery;
import com.zondy.mapgis.core.geodatabase.IVectorCls;
import com.zondy.mapgis.core.geometry.Rect;
import com.zondy.mapgis.core.map.MapLayer;
import com.zondy.mapgis.core.map.VectorLayer;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * @content 要素对象Native组件
 * @author fjl 2019-6-25 下午2:52:36
 */
public class JSFeatureQuery extends ReactContextBaseJavaModule {
    public static final String REACT_CLASS = "JSFeatureQuery";
    public static Map<String, FeatureQuery> mFeatureQueryList = new HashMap<String, FeatureQuery>();


    public JSFeatureQuery(ReactApplicationContext context) {
        super(context);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public static FeatureQuery getObjFromList(String id){
        return mFeatureQueryList.get(id);
    }


    public static String registerId(FeatureQuery obj) {
        for (Map.Entry entry : mFeatureQueryList.entrySet()) {
            if (obj.equals(entry.getValue())) {
                String id = (String) entry.getKey();
                mFeatureQueryList.put(id, obj);
                return (String) entry.getKey();
            }
        }

        Calendar calendar = Calendar.getInstance();
        String id = Long.toString(calendar.getTimeInMillis());
        mFeatureQueryList.put(id, obj);
        return id;
    }

    @ReactMethod
    public void createObjByProperty(String layerID,Promise promise){
        try{
//            VectorLayer mapLayer = JSVectorLayer.mVectorLayerList.get(layerID);
            MapLayer mapLayer = JSMapLayer.mMapLayerList.get(layerID);
            FeatureQuery FeatureQuery = new FeatureQuery((VectorLayer) mapLayer);
            String FeatureQueryId = registerId(FeatureQuery);
            Log.e("FeatureQueryId:", FeatureQueryId);
            WritableMap map = Arguments.createMap();
            map.putString("FeatureQueryId",FeatureQueryId);
            promise.resolve(map);
        }catch (Exception e){
            promise.reject(e);
        }
    }



    @ReactMethod
    public void getWhereClause(String FeatureQueryId,Promise promise){
        try{
            FeatureQuery FeatureQuery = getObjFromList(FeatureQueryId);
            String whereClause = FeatureQuery.getWhereClause();

            WritableMap map= Arguments.createMap();
            map.putString("whereClause",whereClause);
            promise.resolve(map);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setWhereClause(String FeatureQueryId,String setWhereClause,Promise promise){
        try{
            FeatureQuery FeatureQuery = getObjFromList(FeatureQueryId);
            FeatureQuery.setWhereClause(setWhereClause);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setQueryBound(String FeatureQueryId,String queryBoundID,Promise promise){
        try{
            FeatureQuery FeatureQuery = getObjFromList(FeatureQueryId);
            com.zondy.mapgis.core.featureservice.FeatureQuery.QueryBound queryBound = JSQueryBound.mQueryBoundList.get(queryBoundID);
            FeatureQuery.setQueryBound(queryBound);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getQueryBound(String FeatureQueryId,Promise promise){
        try{
            FeatureQuery FeatureQuery = getObjFromList(FeatureQueryId);
            com.zondy.mapgis.core.featureservice.FeatureQuery.QueryBound queryBound = FeatureQuery.getQueryBound();
            String QueryBoundID = JSQueryBound.registerId(queryBound);

            WritableMap map= Arguments.createMap();
            map.putString("QueryBoundID",QueryBoundID);
            promise.resolve(map);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setSpatialFilterRelationship(String FeatureQueryId,int spatialRel,Promise promise){
        try{
            FeatureQuery FeatureQuery = getObjFromList(FeatureQueryId);
            FeatureQuery.setSpatialFilterRelationship(spatialRel);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getSpatialFilterRelationship(String FeatureQueryId,Promise promise){
        try{
            FeatureQuery FeatureQuery = getObjFromList(FeatureQueryId);
            int spatialFilterRelationship = FeatureQuery.getSpatialFilterRelationship();

            WritableMap map= Arguments.createMap();
            map.putInt("spatialFilterRelationship",spatialFilterRelationship);
            promise.resolve(map);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setReturnGeometry(String FeatureQueryId,boolean returnGeometry,Promise promise){
        try{
            FeatureQuery FeatureQuery = getObjFromList(FeatureQueryId);
            FeatureQuery.setReturnGeometry(returnGeometry);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void isReturnGeometry(String FeatureQueryId,Promise promise){
        try{
            FeatureQuery FeatureQuery = getObjFromList(FeatureQueryId);
            boolean isReturnGeometry = FeatureQuery.isReturnGeometry();

            WritableMap map= Arguments.createMap();
            map.putBoolean("isReturnGeometry",isReturnGeometry);
            promise.resolve(map);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setReturnAttribute(String FeatureQueryId,boolean returnAttribute,Promise promise){
        try{
            FeatureQuery FeatureQuery = getObjFromList(FeatureQueryId);
            FeatureQuery.setReturnAttribute(returnAttribute);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void isReturnAttribute(String FeatureQueryId,Promise promise){
        try{
            FeatureQuery FeatureQuery = getObjFromList(FeatureQueryId);
            boolean isReturnAttribute = FeatureQuery.isReturnAttribute();

            WritableMap map= Arguments.createMap();
            map.putBoolean("isReturnAttribute",isReturnAttribute);
            promise.resolve(map);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setReturnGeoInfo(String FeatureQueryId,boolean returnGeoInfo,Promise promise){
        try{
            FeatureQuery FeatureQuery = getObjFromList(FeatureQueryId);
            FeatureQuery.setReturnGeoInfo(returnGeoInfo);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void isReturnGeoInfo(String FeatureQueryId,Promise promise){
        try{
            FeatureQuery FeatureQuery = getObjFromList(FeatureQueryId);
            boolean isReturnGeoInfo = FeatureQuery.isReturnGeoInfo();

            WritableMap map= Arguments.createMap();
            map.putBoolean("isReturnGeoInfo",isReturnGeoInfo);
            promise.resolve(map);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setOutFields(String FeatureQueryId,String outFields,Promise promise){
        try{
            FeatureQuery FeatureQuery = getObjFromList(FeatureQueryId);
            FeatureQuery.setOutFields(outFields);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getOutFields(String FeatureQueryId,Promise promise){
        try{
            FeatureQuery FeatureQuery = getObjFromList(FeatureQueryId);
            String outFields = FeatureQuery.getOutFields();

            WritableMap map= Arguments.createMap();
            map.putString("outFields",outFields);
            promise.resolve(map);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setPageSize(String FeatureQueryId,int pageSize,Promise promise){
        try{
            FeatureQuery FeatureQuery = getObjFromList(FeatureQueryId);
            FeatureQuery.setPageSize(pageSize);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getPageSize(String FeatureQueryId,Promise promise){
        try{
            FeatureQuery FeatureQuery = getObjFromList(FeatureQueryId);
            int pageSize = FeatureQuery.getPageSize();

            WritableMap map= Arguments.createMap();
            map.putInt("pageSize",pageSize);
            promise.resolve(map);
        }catch (Exception e){
            promise.reject(e);
        }
    }
    @ReactMethod
    public void query(String FeatureQueryId,Promise promise)
    {
        try {
            FeatureQuery featureQuery = getObjFromList(FeatureQueryId);
            FeaturePagedResult featurePagedResult = featureQuery.query();


            String featurePageResultHandle = JSFeaturePagedResult.registerId(featurePagedResult);
            WritableMap map = Arguments.createMap();
            map.putString("featurePageResultHandle",featurePageResultHandle);
            promise.resolve(map);
        }
        catch (Exception e)
        {
            promise.reject(e);
        }
    }

//    @ReactMethod
//    public void query(String FeatureQueryId,String vectorLayerID,String strWhereClause,String queryBoundID,int spatialRel,boolean returnGeometry,boolean returnAttribute,boolean returnGeoInfo,String strOutFields,int pageSize,Promise promise)
//    {
//        try {
//            FeatureQuery featureQuery = getObjFromList(FeatureQueryId);
////            VectorLayer vectorLayer = JSVectorLayer.mVectorLayerList.get(vectorLayerID);
//            MapLayer mapLayer = JSMapLayer.mMapLayerList.get(vectorLayerID);
//            if(mapLayer instanceof VectorLayer )
//            {
//               return;
//            }
//            com.zondy.mapgis.core.featureservice.FeatureQuery.QueryBound queryBound = JSQueryBound.mQueryBoundList.get(queryBoundID);
//
//            FeaturePagedResult featurePagedResult =  FeatureQuery.query((VectorLayer) mapLayer,strWhereClause,queryBound,spatialRel,returnGeometry,returnAttribute,returnGeoInfo,strOutFields,pageSize);
//
//            String featurePageResultHandle = JSFeaturePagedResult.registerId(featurePagedResult);
//            WritableMap map = Arguments.createMap();
//            map.putString("featurePageResultHandle",featurePageResultHandle);
//            promise.resolve(map);
//        }
//        catch (Exception e)
//        {
//            promise.reject(e);
//        }
//    }

}
