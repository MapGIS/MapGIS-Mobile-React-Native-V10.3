package com.zondy.mapgis.mobile.react.scene;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.core.geometry.Rect3D;
import com.zondy.mapgis.core.scene.GroupLayer3D;
import com.zondy.mapgis.core.scene.Layer3D;
import com.zondy.mapgis.core.scene.Layer3DEnum;
import com.zondy.mapgis.core.srs.SRefData;
import com.zondy.mapgis.mobile.react.JSSRefData;

/**
 * @auther LiaoLiang on 20-7-20
 * @content 三维组图层类，实现图层的分组管理
 */
public class JSGroupLayer3D extends JSLayer3D {
    private static final String REACT_CLASS = "JSGroupLayer3D";

    @NonNull
    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public JSGroupLayer3D(@NonNull ReactApplicationContext reactContext) {
        super(reactContext);
    }

    /**
     * 构造一个新的 GroupLayer3D 对象
     * @param promise
     */
    @ReactMethod
    public void createObj(Promise promise) {
        try {
            GroupLayer3D groupLayer3D = new GroupLayer3D();
            String groupLayer3DId = registerId(groupLayer3D);

            WritableMap map = Arguments.createMap();
            map.putString("groupLayer3DId", groupLayer3DId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 添加三维图层
     * @param groupLayer3DId
     * @param layer3DId
     * @param promise
     */
    @ReactMethod
    public void addLayer(String groupLayer3DId, String layer3DId, Promise promise) {
        try {
            GroupLayer3D groupLayer3D = (GroupLayer3D) getObjById(groupLayer3DId);
            Layer3D layer3D = getObjById(layer3DId);
            int result = groupLayer3D.addLayer(layer3D); //成功返回图层添加的位置索引（从0开始）；失败返回-1

            promise.resolve(result);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 移除所有三维图层
     * @param groupLayer3DId
     * @param promise
     */
    @ReactMethod
    public void clearLayers(String groupLayer3DId, Promise promise) {
        try {
            GroupLayer3D groupLayer3D = (GroupLayer3D) getObjById(groupLayer3DId);
            int result = groupLayer3D.clearLayers(); //1-成功；0-失败

            promise.resolve(result);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取图层三维范围
     * @param groupLayer3DId
     * @param rect3DId
     * @param promise
     */
    @ReactMethod
    public void getExtent(String groupLayer3DId, String rect3DId, Promise promise) {
        try {
            GroupLayer3D groupLayer3D = (GroupLayer3D) getObjById(groupLayer3DId);
            Rect3D rect3D = JSRect3D.getObjById(rect3DId);
            int result = groupLayer3D.getExtent(rect3D); //1-成功；0-失败

            promise.resolve(result);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 根据索引获取三维图层
     * @param groupLayer3DId
     * @param index
     * @param promise
     */
    @ReactMethod
    public void getLayer(String groupLayer3DId, int index, Promise promise) {
        try {
            GroupLayer3D groupLayer3D = (GroupLayer3D) getObjById(groupLayer3DId);
            Layer3D layer3D = groupLayer3D.getLayer(index);
            String layer3DId = JSLayer3D.registerId(layer3D);

            promise.resolve(layer3DId);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取当前组下的图层数目
     * @param groupLayer3DId
     * @param promise
     */
    @ReactMethod
    public void getLayerCount(String groupLayer3DId, Promise promise) {
        try {
            GroupLayer3D groupLayer3D = (GroupLayer3D) getObjById(groupLayer3DId);
            int layerCountNum = groupLayer3D.getLayerCount();

            promise.resolve(layerCountNum);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取图层枚举
     * @param groupLayer3DId
     * @param layer3DEnumId
     * @param promise
     */
    @ReactMethod
    public void getLayerEnum(String groupLayer3DId, String layer3DEnumId, Promise promise) {
        try {
            GroupLayer3D groupLayer3D = (GroupLayer3D) getObjById(groupLayer3DId);
            Layer3DEnum layer3DEnum = JSLayer3DEnum.getObjById(layer3DEnumId);
            int result = groupLayer3D.getLayerEnum(layer3DEnum); //1-成功；0-失败

            promise.resolve(result);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取动态投影参照系
     * @param groupLayer3DId
     * @param SRefDataId
     * @param promise
     */
    @ReactMethod
    public void getProjTransSRS(String groupLayer3DId, String SRefDataId, Promise promise) {
        try {
            GroupLayer3D groupLayer3D = (GroupLayer3D) getObjById(groupLayer3DId);
            SRefData sRefData = JSSRefData.getObjFromList(SRefDataId);
            int result = groupLayer3D.getProjTransSRS(sRefData); //1-成功；0-失败

            promise.resolve(result);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取图层类型的值
     * @param groupLayer3DId
     * @param promise
     */
    @ReactMethod
    public void getType(String groupLayer3DId, Promise promise) {
        try {
            GroupLayer3D groupLayer3D = (GroupLayer3D) getObjById(groupLayer3DId);
            int typeValue = groupLayer3D.getType().value();

            promise.resolve(typeValue);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 根据三维图层对象获取图层位置索引
     * @param groupLayer3DId
     * @param layer3DId
     * @param promise
     */
    @ReactMethod
    private void indexOfLayer(String groupLayer3DId, String layer3DId, Promise promise) {
        try {
            GroupLayer3D groupLayer3D = (GroupLayer3D) getObjById(groupLayer3DId);
            Layer3D layer3D = JSLayer3D.getObjById(layer3DId);
            int index = groupLayer3D.indexOfLayer(layer3D);

            promise.resolve(index);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 根据图层名称查找三维图层,返回图层位置索引
     * @param groupLayer3DId
     * @param strLayerName
     * @param promise
     */
    @ReactMethod
    public void indexOfLayerByName(String groupLayer3DId, String strLayerName, Promise promise) {
        try {
            GroupLayer3D groupLayer3D = (GroupLayer3D) getObjById(groupLayer3DId);
            int index = groupLayer3D.indexOfLayer(strLayerName);

            promise.resolve(index);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 插入三维图层，根据指定索引位置插入三维图层
     * @param groupLayer3DId
     * @param index
     * @param layer3DId
     * @param promise
     */
    @ReactMethod
    public  void insertLayer(String groupLayer3DId, int index, String layer3DId, Promise promise) {
        try {
            GroupLayer3D groupLayer3D = (GroupLayer3D) getObjById(groupLayer3DId);
            Layer3D layer3D = JSLayer3D.getObjById(layer3DId);
            int result = groupLayer3D.insertLayer(index, layer3D);

            promise.resolve(result);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取动态投影标志
     * @param groupLayer3DId
     * @param promise
     */
    @ReactMethod
    public void isProjTrans(String groupLayer3DId,  Promise promise) {
        try {
            GroupLayer3D groupLayer3D = (GroupLayer3D) getObjById(groupLayer3DId);
            boolean isProjTransValue = groupLayer3D.isProjTrans();

            promise.resolve(isProjTransValue);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * c
     * @param groupLayer3DId
     * @param promise
     */
    @ReactMethod
    public void isValid(String groupLayer3DId,  Promise promise) {
        try {
            GroupLayer3D groupLayer3D = (GroupLayer3D) getObjById(groupLayer3DId);
            boolean isValidValue = groupLayer3D.isValid();

            promise.resolve(isValidValue);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 移除三维图层，从fromIndex开始移除nCount个图层
     * @param groupLayer3DId
     * @param fromIndex 移除图层的起始位置
     * @param nCount 移除图层的个数
     * @param promise
     */
    @ReactMethod
    public void removeLayer(String groupLayer3DId, int fromIndex, int nCount, Promise promise){
        try {
            GroupLayer3D groupLayer3D = (GroupLayer3D) getObjById(groupLayer3DId);
            int result = groupLayer3D.removeLayer(fromIndex, nCount); //成功返回大于0；失败返回0

            promise.resolve(result);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 移除三维图层
     * @param groupLayer3DId
     * @param layer3DId
     * @param promise
     */
    @ReactMethod
    public void removeLayerByObj(String groupLayer3DId, String layer3DId, Promise promise) {
        try {
            GroupLayer3D groupLayer3D = (GroupLayer3D) getObjById(groupLayer3DId);
            Layer3D layer3D = getObjById(layer3DId);
            int result = groupLayer3D.removeLayer(layer3D); //成功返回移除的位置; 失败返回-1

            promise.resolve(result);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 移除指定索引的三维图层（移除索引为layerIndex的图层）
     * @param groupLayer3DId
     * @param layerIndex 移除的图层索引
     * @param promise
     */
    @ReactMethod
    public void removeLayerAt (String groupLayer3DId, int layerIndex, Promise promise) {
        try {
            GroupLayer3D groupLayer3D = (GroupLayer3D) getObjById(groupLayer3DId);
            int result = groupLayer3D.removeLayerAt(layerIndex); //成功返回大于0；失败返回-1

            promise.resolve(result);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 设置动态投影标识
     * @param groupLayer3DId
     * @param bProjTrans 动态投影标识
     * @param promise
     */
    @ReactMethod
    public void setProjTrans(String groupLayer3DId, boolean bProjTrans, Promise promise) {
        try {
            GroupLayer3D groupLayer3D = (GroupLayer3D) getObjById(groupLayer3DId);
            int result = groupLayer3D.setProjTrans(bProjTrans); //1-成功；0-失败

            promise.resolve(result);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 设置动态投影参照系
     * @param groupLayer3DId
     * @param SRefDataId
     * @param promise
     */
    @ReactMethod
    public void setProjTransSRS(String groupLayer3DId, String SRefDataId, Promise promise) {
        try {
            GroupLayer3D groupLayer3D = (GroupLayer3D) getObjById(groupLayer3DId);
            SRefData sRefData = JSSRefData.getObjFromList(SRefDataId);
            int result = groupLayer3D.setProjTransSRS(sRefData); //1-成功；0-失败

            promise.resolve(result);
        }catch (Exception e) {
            promise.reject(e);
        }
    }
}
