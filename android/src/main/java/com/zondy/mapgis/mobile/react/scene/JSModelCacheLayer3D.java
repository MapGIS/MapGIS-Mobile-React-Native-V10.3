package com.zondy.mapgis.mobile.react.scene;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.core.geometry.Rect3D;
import com.zondy.mapgis.core.scene.ModelCacheLayer3D;
import com.zondy.mapgis.core.scene.SelectionProperties;
import com.zondy.mapgis.core.scene.SelectionStyle;


/**
 * @auther LiaoLiang on 20-7-20
 * @content 模型图层类，通过该类可以向场景中添加三维模型图层
 */
public class JSModelCacheLayer3D extends JSLayer3D {
    private static final String REACT_CLASS = "JSModelCacheLayer3D";

    @NonNull
    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public JSModelCacheLayer3D(@NonNull ReactApplicationContext reactContext) {
        super(reactContext);
    }

    /**
     * 构造一个新的 ModelCacheLayer3D 对象
     * @param promise
     */
    @ReactMethod
    public void createObj(Promise promise) {
        try {
            ModelCacheLayer3D modelCacheLayer3D = new ModelCacheLayer3D();
            String modelCacheLayer3DId = registerId(modelCacheLayer3D);

            WritableMap map = Arguments.createMap();
            map.putString("modelCacheLayer3DId", modelCacheLayer3DId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 清除m3d模型缓存
     * @param modelCacheLayer3DId
     * @param promise
     */
    @ReactMethod
    public void clearCache(String modelCacheLayer3DId, Promise promise) {
        try {
            ModelCacheLayer3D modelCacheLayer3D = (ModelCacheLayer3D) getObjById(modelCacheLayer3DId);
            boolean result = modelCacheLayer3D.clearCache();

            promise.resolve(result);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 清除选中
     * @param modelCacheLayer3DId
     * @param promise
     */
    @ReactMethod
    public void clearSelection(String modelCacheLayer3DId, Promise promise) {
        try {
            ModelCacheLayer3D modelCacheLayer3D = (ModelCacheLayer3D) getObjById(modelCacheLayer3DId);
            modelCacheLayer3D.clearSelection();

            promise.resolve(true);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     *获取图层三维范围
     * @param modelCacheLayer3DId
     * @param rect3DId 三维范围，Rect3D类型的id
     * @param promise
     */
    @ReactMethod
    public void getExtent(String modelCacheLayer3DId, String rect3DId, Promise promise) {
        try {
            ModelCacheLayer3D modelCacheLayer3D = (ModelCacheLayer3D) getObjById(modelCacheLayer3DId);
            Rect3D rect3D = JSRect3D.getObjById(rect3DId);
            int result = modelCacheLayer3D.getExtent(rect3D); //1-成功；0-失败

            promise.resolve(result);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取选中的要素id列表
     * @param modelCacheLayer3DId
     * @param promise
     */
    @ReactMethod
    public void getSelectingFeatureIDs(String modelCacheLayer3DId, Promise promise) {
        try {
            ModelCacheLayer3D modelCacheLayer3D = (ModelCacheLayer3D) getObjById(modelCacheLayer3DId);
            int[] selectingFeatureIDs = modelCacheLayer3D.getSelectingFeatureIDs();

            WritableArray array = Arguments.createArray();
            for (int i : selectingFeatureIDs) {
                array.pushInt(i);
            }

            promise.resolve(array);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取选中要素的数目
     * @param modelCacheLayer3DId
     * @param promise
     */
    @ReactMethod
    public void getSelectingFeatureIDsCount(String modelCacheLayer3DId, Promise promise) {
        try {
            ModelCacheLayer3D modelCacheLayer3D = (ModelCacheLayer3D) getObjById(modelCacheLayer3DId);
            int selectingFeatureIDsCountNum = modelCacheLayer3D.getSelectingFeatureIDsCount();

            promise.resolve(selectingFeatureIDsCountNum);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取选中要素的样式
     * @param modelCacheLayer3DId
     * @param featureID
     * @param promise
     */
    @ReactMethod
    public void getSelectingFeatureStyle(String modelCacheLayer3DId, int featureID, Promise promise) {
        try {
            ModelCacheLayer3D modelCacheLayer3D = (ModelCacheLayer3D) getObjById(modelCacheLayer3DId);
            SelectionStyle selectionStyle = modelCacheLayer3D.getSelectingFeatureStyle(featureID);
            String selectionStyleId = JSSelectionStyle.registerId(selectionStyle);

            promise.resolve(selectionStyleId);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取选择要素的样式
     * @param modelCacheLayer3DId
     * @param promise
     */
    @ReactMethod
    public void getSelectionProperties(String modelCacheLayer3DId, Promise promise) {
        try {
            ModelCacheLayer3D modelCacheLayer3D = (ModelCacheLayer3D) getObjById(modelCacheLayer3DId);
            SelectionProperties selectionProperties = modelCacheLayer3D.getSelectionProperties();
            String selectionPropertiesId = JSSelectionProperties.registerId(selectionProperties);

            promise.resolve(selectionPropertiesId);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取图层显示模式透明度
     * @param modelCacheLayer3DId
     * @param sAlpha  透明度,sAlpha值为0-100，100表示不透明
     * @param promise
     */
    @ReactMethod
    public void getTransparency(String modelCacheLayer3DId, int sAlpha, Promise promise) {
        try {
            ModelCacheLayer3D modelCacheLayer3D = (ModelCacheLayer3D) getObjById(modelCacheLayer3DId);
            int result = modelCacheLayer3D.getTransparency((short) sAlpha); //1-成功；0-失败

            promise.resolve(result);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取图层是否应用光照
     * @param modelCacheLayer3DId
     * @param promise
     */
    @ReactMethod
    public void isLightingEnabled(String modelCacheLayer3DId, Promise promise) {
        try {
            ModelCacheLayer3D modelCacheLayer3D = (ModelCacheLayer3D) getObjById(modelCacheLayer3DId);
            boolean isLightingEnabledValue = modelCacheLayer3D.isLightingEnabled();

            promise.resolve(isLightingEnabledValue);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 设置选择的要素id
     * @param modelCacheLayer3DId
     * @param featureID
     * @param promise
     */
    @ReactMethod
    public void selectFeature(String modelCacheLayer3DId, int featureID, Promise promise) {
        try {
            ModelCacheLayer3D modelCacheLayer3D = (ModelCacheLayer3D) getObjById(modelCacheLayer3DId);
            modelCacheLayer3D.selectFeature(featureID);

            promise.resolve(true);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 设置选择要素的id及对应的样式
     * @param modelCacheLayer3DId
     * @param featureID
     * @param selectionStyleId
     * @param promise
     */
    @ReactMethod
    public void selectFeatureIdAndStyle(String modelCacheLayer3DId, int featureID, String selectionStyleId, Promise promise) {
        try {
            ModelCacheLayer3D modelCacheLayer3D = (ModelCacheLayer3D) getObjById(modelCacheLayer3DId);
            SelectionStyle selectionStyle = JSSelectionStyle.getObjById(selectionStyleId);
            modelCacheLayer3D.selectFeature(featureID, selectionStyle);

            promise.resolve(true);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 设置选择的要素id列表
     * @param modelCacheLayer3DId
     * @param featureIDs id列表
     * @param idsCount 要素样式
     * @param promise
     */
    @ReactMethod
    public void selectFeatures(String modelCacheLayer3DId, ReadableArray featureIDs, int idsCount, Promise promise) {
        try {
            ModelCacheLayer3D modelCacheLayer3D = (ModelCacheLayer3D) getObjById(modelCacheLayer3DId);
            int[] ids = new int[featureIDs.size()];
            for (int i = 0; i < featureIDs.size(); i++) {
                ids[i] = featureIDs.getInt(i);
            }
            modelCacheLayer3D.selectFeatures(ids, idsCount);

            promise.resolve(true);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 设置选择的要素id列表及对应的样式列表
     * @param modelCacheLayer3DId
     * @param featureIDs id列表
     * @param idsCount id数目
     * @param styleIds 样式id列表
     * @param stylesCount 样式数目
     * @param promise
     */
    @ReactMethod
    public void selectFeaturesIdsAndStyles(String modelCacheLayer3DId, ReadableArray featureIDs, int idsCount, ReadableArray styleIds, int stylesCount, Promise promise) {
        try {
            ModelCacheLayer3D modelCacheLayer3D = (ModelCacheLayer3D) getObjById(modelCacheLayer3DId);
            int[] ids = new int[featureIDs.size()];
            for (int i = 0; i < featureIDs.size(); i++) {
                ids[i] = featureIDs.getInt(i);
            }
            SelectionStyle[] styleArr = new SelectionStyle[styleIds.size()];
            for (int i = 0; i < styleIds.size(); i++) {
                styleArr[i] = JSSelectionStyle.getObjById(styleIds.getString(i));
            }
            modelCacheLayer3D.selectFeatures(ids,idsCount,styleArr,stylesCount);

            promise.resolve(true);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 设置图层是否应用光照(该图层的光照开启与否将不再受SetSunLightingMode函数的影响)
     * @param modelCacheLayer3DId
     * @param value
     * @param promise
     */
    @ReactMethod
    public void setLightingEnabled(String modelCacheLayer3DId, boolean value, Promise promise) {
        try {
            ModelCacheLayer3D modelCacheLayer3D = (ModelCacheLayer3D) getObjById(modelCacheLayer3DId);
            modelCacheLayer3D.setLightingEnabled(value);

            promise.resolve(true);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 设置选择要素的样式
     * @param modelCacheLayer3DId
     * @param selectionPropertiesId
     * @param promise
     */
    @ReactMethod
    public void setSelectionProperties(String modelCacheLayer3DId, String selectionPropertiesId, Promise promise) {
        try {
            ModelCacheLayer3D modelCacheLayer3D = (ModelCacheLayer3D) getObjById(modelCacheLayer3DId);
            SelectionProperties selectionProperties = JSSelectionProperties.getObjById(selectionPropertiesId);
            modelCacheLayer3D.setSelectionProperties(selectionProperties);

            promise.resolve(true);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 设置图层显示模式透明度
     * @param modelCacheLayer3DId
     * @param sAlpha
     * @param promise
     */
    @ReactMethod
    public void setTransparency(String modelCacheLayer3DId, int sAlpha, Promise promise) {
        try {
            ModelCacheLayer3D modelCacheLayer3D = (ModelCacheLayer3D) getObjById(modelCacheLayer3DId);
            modelCacheLayer3D.setTransparency((short) sAlpha);

            promise.resolve(true);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 设置取消选中要素的id
     * @param modelCacheLayer3DId
     * @param featureID
     * @param promise
     */
    @ReactMethod
    public void setUnSelectFeature(String modelCacheLayer3DId, int featureID, Promise promise) {
        try {
            ModelCacheLayer3D modelCacheLayer3D = (ModelCacheLayer3D) getObjById(modelCacheLayer3DId);
            modelCacheLayer3D.setUnSelectFeature(featureID);

            promise.resolve(true);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 设置取消选中要素的id列表
     * @param modelCacheLayer3DId
     * @param featureIDs
     * @param idsCount
     * @param promise
     */
    @ReactMethod
    public void setUnSelectFeatures(String modelCacheLayer3DId, ReadableArray featureIDs, int idsCount, Promise promise) {
        try {
            ModelCacheLayer3D modelCacheLayer3D = (ModelCacheLayer3D) getObjById(modelCacheLayer3DId);
            int[] ids = new int[featureIDs.size()];
            for (int i = 0; i < featureIDs.size(); i++) {
                ids[i] = featureIDs.getInt(i);
            }
            modelCacheLayer3D.setUnSelectFeatures(ids,idsCount);

            promise.resolve(true);
        }catch (Exception e) {
            promise.reject(e);
        }
    }
}
