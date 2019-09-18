package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.android.tool.sketcheditor.GeometryParams;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * 几何对象参数Native功能组件
 * Created by xiaoying on 2019/9/10.
 */
public class JSGeometryParams extends ReactContextBaseJavaModule {
    private static final String REACT_CLASS = "JSGeometryParams";
    public static Map<String, GeometryParams> mGeometryParamsList = new HashMap<>();

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
        Calendar calendar = Calendar.getInstance();
        String id = Long.toString(calendar.getTimeInMillis());
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

        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setGeometry(String geometryParamsId, String geometryId, Promise promise){
        try {
            GeometryParams geometryParams = getObjFromList(geometryParamsId);

        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getCurrentIndex(String geometryParamsId, Promise promise){
        try {
            GeometryParams geometryParams = getObjFromList(geometryParamsId);
            int currentIndex = geometryParams.getmCurrentIndex();

            promise.resolve(currentIndex);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setCurrentIndex(String geometryParamsId, int mCurrentIndex, Promise promise){
        try {
            GeometryParams geometryParams = getObjFromList(geometryParamsId);
            geometryParams.setmCurrentIndex(mCurrentIndex);

            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getPreCurrentTotalVertex(String geometryParamsId, Promise promise){
        try {
            GeometryParams geometryParams = getObjFromList(geometryParamsId);
            int preCurrentTotalVertex = geometryParams.getmPreCurrentTotalVertex();

            promise.resolve(preCurrentTotalVertex);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setPreCurrentTotalVertex(String geometryParamsId, int preCurrentTotalVertex, Promise promise){
        try {
            GeometryParams geometryParams = getObjFromList(geometryParamsId);
            geometryParams.setmPreCurrentTotalVertex(preCurrentTotalVertex);

            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getCurrentVertexIndex(String geometryParamsId, Promise promise){
        try {
            GeometryParams geometryParams = getObjFromList(geometryParamsId);
            int currentVertexIndex = geometryParams.getmCurrentVertexIndex();

            promise.resolve(currentVertexIndex);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setCurrentVertexIndex(String geometryParamsId, int currentVertexIndex, Promise promise){
        try {
            GeometryParams geometryParams = getObjFromList(geometryParamsId);
            geometryParams.setmCurrentVertexIndex(currentVertexIndex);

            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }
}
