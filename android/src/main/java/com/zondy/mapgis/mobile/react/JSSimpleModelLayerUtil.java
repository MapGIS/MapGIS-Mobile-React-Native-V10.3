package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.zondy.mapgis.android.model.Model;
import com.zondy.mapgis.android.model.SimpleModelLayerUtil;
import com.zondy.mapgis.core.map.SimpleModelLayer;

/**
 * 模型层工具类Native功能组件
 * Created by xiaoying on 2019/9/10.
 */
public class JSSimpleModelLayerUtil extends ReactContextBaseJavaModule {
    private static final String REACT_CLASS = "JSSimpleModelLayerUtil";
    public JSSimpleModelLayerUtil(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @ReactMethod
    public void createModelStorageFileIfNotExists(String strURL, Promise promise){
        try {
            boolean result = SimpleModelLayerUtil.createModelStorageFileIfNotExists(strURL);
            promise.resolve(result);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void addModel(String modelLayerId, String modelId, Promise promise){
        try {
            SimpleModelLayer simpleModelLayer = (SimpleModelLayer) JSSimpleModelLayer.getObjFromList(modelLayerId);
            Model model = JSModel.getObjFromList(modelId);

            int id = SimpleModelLayerUtil.addModel(simpleModelLayer, model);
            promise.resolve(id);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void updateModel(String modelLayerId, int id, String modelId, Promise promise)
    {
        try {
            SimpleModelLayer simpleModelLayer = (SimpleModelLayer) JSSimpleModelLayer.getObjFromList(modelLayerId);
            Model model = JSModel.getObjFromList(modelId);

            int result = SimpleModelLayerUtil.updateModel(simpleModelLayer, id, model);
            promise.resolve(result);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void removeModel(String modelLayerId, int id, Promise promise){
        try {
            SimpleModelLayer simpleModelLayer = (SimpleModelLayer) JSSimpleModelLayer.getObjFromList(modelLayerId);
            int result = SimpleModelLayerUtil.removeModel(simpleModelLayer, id);

            promise.resolve(result);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void clearModels(String modelLayerId, Promise promise){
        try {
            SimpleModelLayer simpleModelLayer = (SimpleModelLayer) JSSimpleModelLayer.getObjFromList(modelLayerId);
            int result = SimpleModelLayerUtil.clearModels(simpleModelLayer);

            promise.resolve(result);
        }catch (Exception e){
            promise.reject(e);
        }
    }
}