package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.android.model.Model;
import com.zondy.mapgis.android.model.ModelsOverlay;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 模型层Native功能组件
 * Created by xiaoying on 2019/9/9.
 */
public class JSModelsOverlay extends ReactContextBaseJavaModule {
    private static final String REACT_CLASS = "JSModelsOverlay";
    private static Map<String, ModelsOverlay> mModelsOverlayList = new HashMap<>();

    public JSModelsOverlay(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public static ModelsOverlay getObjFromList(String id){
        return mModelsOverlayList.get(id);
    }

    public static String registerId(ModelsOverlay obj){
        for(Map.Entry entry : mModelsOverlayList.entrySet()){
            if(obj.equals(entry.getValue())){
                String id = (String) entry.getKey();
                return id;
            }
        }
        String id = UUID.randomUUID().toString().substring(24);
        mModelsOverlayList.put(id,obj);
        return id;
    }

    @ReactMethod
    public void createObj(Promise promise){
        try {
            ModelsOverlay modelsOverlay = new ModelsOverlay();
            String modelsOverlayId = registerId(modelsOverlay);

            WritableMap writableMap = Arguments.createMap();
            writableMap.putString("ModelsOverlayId", modelsOverlayId);
            promise.resolve(writableMap);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void addModel(String modelsOverlayId, String modelId, Promise promise){
        try {
            ModelsOverlay modelsOverlay = getObjFromList(modelsOverlayId);
            Model model = JSModel.getObjFromList(modelId);
            modelsOverlay.addModel(model);

            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void addModels(String modelsOverlayId, ReadableArray readableArray, Promise promise){
        try {
            ModelsOverlay modelsOverlay = getObjFromList(modelsOverlayId);
            List<Model> modelList = new ArrayList<>();
            if(readableArray != null){
                for (int i = 0; i < readableArray.size(); i++){
                    String modelId = readableArray.getString(i);
                    Model model = JSModel.getObjFromList(modelId);
                    modelList.add(model);
                }
                modelsOverlay.addModels(modelList);
                promise.resolve(true);
            }else {
                promise.resolve("添加的模型为空");
            }
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void removeModelByIndex(String modelsOverlayId, int index, Promise promise){
        try {
            ModelsOverlay modelsOverlay = getObjFromList(modelsOverlayId);
            modelsOverlay.removeModel(index);

            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void removeModel(String modelsOverlayId, String modelId, Promise promise){
        try {
            ModelsOverlay modelsOverlay = getObjFromList(modelsOverlayId);
            Model model = JSModel.getObjFromList(modelId);
            if(model != null){
                modelsOverlay.removeModel(model);
                promise.resolve(true);
            }else {
                promise.resolve(false);
            }

        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void removeModels(String modelsOverlayId, ReadableArray readableArray, Promise promise){
        try {
            ModelsOverlay modelsOverlay = getObjFromList(modelsOverlayId);
            List<Model> modelList = new ArrayList<>();
            if(readableArray != null){
                for (int i = 0; i < readableArray.size(); i++){
                    String modelId = readableArray.getString(i);
                    Model model = JSModel.getObjFromList(modelId);
                    if(model != null){
                        modelList.add(model);
                    }
                }

                modelsOverlay.removeModels(modelList);
                promise.resolve(true);
            }else {
                promise.resolve("移除的模型组为空");
            }
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void removeAllModels(String modelsOverlayId, Promise promise){
        try {
            ModelsOverlay modelsOverlay = getObjFromList(modelsOverlayId);
            modelsOverlay.removeAllModels();

            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getModelCount(String modelsOverlayId, Promise promise){
        try {
            ModelsOverlay modelsOverlay = getObjFromList(modelsOverlayId);
            int modelCount = modelsOverlay.getModelCount();

            promise.resolve(modelCount);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void indexOf(String modelsOverlayId, String modelId, Promise promise){
        try {
            ModelsOverlay modelsOverlay = getObjFromList(modelsOverlayId);
            Model model = JSModel.getObjFromList(modelId);
            int index = modelsOverlay.indexOf(model);

            promise.resolve(index);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getModel(String modelsOverlayId, int index, Promise promise){
        try {
            ModelsOverlay modelsOverlay = getObjFromList(modelsOverlayId);
            Model model = modelsOverlay.getModel(index);
            String modelId = null;
            if(model != null){
                modelId = JSModel.registerId(model);
            }

            WritableMap writableMap = Arguments.createMap();
            writableMap.putString("ModelId", modelId);
            promise.resolve(writableMap);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getAllModels(String modelsOverlayId, Promise promise){
        try {
            ModelsOverlay modelsOverlay = getObjFromList(modelsOverlayId);
            List<Model> modelList = modelsOverlay.getAllModels();
            WritableArray  writableArray = Arguments.createArray();
            if(modelList != null){
                for (int i = 0; i < modelList.size(); i++){
                    String modelId = JSModel.registerId(modelList.get(i));
                    writableArray.pushString(modelId);
                }
            }

            promise.resolve(writableArray);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void moveModel(String modelsOverlayId, int fromIndex, int toIndex, Promise promise){
        try {
            ModelsOverlay modelsOverlay = getObjFromList(modelsOverlayId);
            modelsOverlay.moveModel(fromIndex, toIndex);

            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void saveToFile(String modelsOverlayId, String strModelFile, boolean trunc, Promise promise){
        try {
            ModelsOverlay modelsOverlay = getObjFromList(modelsOverlayId);
            boolean result = modelsOverlay.saveToFile(strModelFile,trunc);

            promise.resolve(result);
        }catch (Exception e){
            promise.reject(e);
        }
    }

}
