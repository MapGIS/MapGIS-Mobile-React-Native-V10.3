package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.android.tool.sketcheditor.GeometryParams;
import com.zondy.mapgis.core.geometry.Geometry;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 几何对象参数Native功能组件
 * Created by xiaoying on 2019/9/10.
 */
public class JSGeometryParams extends ReactContextBaseJavaModule {
    private static final String REACT_CLASS = "JSGeometryParams";
    private static Map<String, GeometryParams> mGeometryParamsList = new HashMap<>();

    public JSGeometryParams(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public static GeometryParams getObjFromList(String id){
        return mGeometryParamsList.get(id);
    }

    public static String registerId(GeometryParams obj){
        for(Map.Entry entry : mGeometryParamsList.entrySet()){
            if(obj.equals(entry.getValue())){
                String id = (String) entry.getKey();
                return id;
            }
        }
        String id = UUID.randomUUID().toString().substring(24);
        mGeometryParamsList.put(id,obj);
        return id;
    }

    @ReactMethod
    public void createObj(Promise promise){
        try {
            GeometryParams geometryParams = new GeometryParams();
            String geometryParamsId = registerId(geometryParams);

            WritableMap writableMap = Arguments.createMap();
            writableMap.putString("GeometryParamsId", geometryParamsId);
            promise.resolve(writableMap);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getGeometry(String geometryParamsId, Promise promise){
        try {
            GeometryParams geometryParams = getObjFromList(geometryParamsId);
            Geometry geometry = geometryParams.getGeometry();
            WritableMap writableMap = JSSketchEditor.getGeometryWritableMap(geometry);

            promise.resolve(writableMap);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setGeometry(String geometryParamsId, String geometryId, Promise promise){
        try {
            GeometryParams geometryParams = getObjFromList(geometryParamsId);
            Geometry geometry = JSGeometry.getObjFromList(geometryId);
            geometryParams.setGeometry(geometry);

            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getCurrentIndex(String geometryParamsId, Promise promise){
        try {
            GeometryParams geometryParams = getObjFromList(geometryParamsId);
            int currentIndex = geometryParams.getCurrentIndex();

            promise.resolve(currentIndex);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setCurrentIndex(String geometryParamsId, int mCurrentIndex, Promise promise){
        try {
            GeometryParams geometryParams = getObjFromList(geometryParamsId);
            geometryParams.setCurrentIndex(mCurrentIndex);

            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getPreCurrentTotalVertex(String geometryParamsId, Promise promise){
        try {
            GeometryParams geometryParams = getObjFromList(geometryParamsId);
            int preCurrentTotalVertex = geometryParams.getPreCurrentTotalVertex();

            promise.resolve(preCurrentTotalVertex);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setPreCurrentTotalVertex(String geometryParamsId, int preCurrentTotalVertex, Promise promise){
        try {
            GeometryParams geometryParams = getObjFromList(geometryParamsId);
            geometryParams.setPreCurrentTotalVertex(preCurrentTotalVertex);

            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getCurrentVertexIndex(String geometryParamsId, Promise promise){
        try {
            GeometryParams geometryParams = getObjFromList(geometryParamsId);
            int currentVertexIndex = geometryParams.getCurrentVertexIndex();

            promise.resolve(currentVertexIndex);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setCurrentVertexIndex(String geometryParamsId, int currentVertexIndex, Promise promise){
        try {
            GeometryParams geometryParams = getObjFromList(geometryParamsId);
            geometryParams.setCurrentVertexIndex(currentVertexIndex);

            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }
}
