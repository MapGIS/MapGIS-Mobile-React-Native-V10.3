package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.core.map.GroupLayer;
import com.zondy.mapgis.core.map.LayerEnum;
import com.zondy.mapgis.core.map.MapLayer;
import com.zondy.mapgis.core.map.ServerLayer;
import com.zondy.mapgis.core.map.SimpleModelLayer;
import com.zondy.mapgis.core.map.VectorLayer;
import com.zondy.mapgis.jni.core.map.NativeMap;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * 组图层对象Native组件
 * Created by xiaoying on 2019/8/30.
 */
public class JSGroupLayer extends JSMapLayer {
    private static final String REACT_CLASS = "JSGroupLayer";
//    public static Map<String, GroupLayer> mGroupLayerList = new HashMap<>();

    public JSGroupLayer(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

//    public static GroupLayer getObjFromList(String groupLayerId){
//        return mGroupLayerList.get(groupLayerId);
//    }

//    public static String registerId(GroupLayer obj){
//        for(Map.Entry entry : mGroupLayerList.entrySet()){
//            if(obj.equals(entry.getValue())){
//                String id = (String) entry.getKey();
//                return id;
//            }
//        }
//        Calendar calendar = Calendar.getInstance();
//        String id = Long.toString(calendar.getTimeInMillis());
//        mGroupLayerList.put(id,obj);
//        return id;
//    }

    @ReactMethod
    public void createObj(Promise promise){
        try {
            GroupLayer groupLayer = new GroupLayer();
            String groupLayerId = registerId(groupLayer);

            WritableMap writableMap = Arguments.createMap();
            writableMap.putString("GroupLayerId",groupLayerId);
            promise.resolve(writableMap);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    /**
     * 根据handle创建一个GroupLayer对象
     * @param handle 对象句柄
     * @return groupLayer对象
     */
    public static GroupLayer createObjByHandle(long handle){
        if(handle == 0L){
            return null;
        }
        GroupLayer groupLayer = new GroupLayer(handle);
        return groupLayer;
    }

    @ReactMethod
    public void getCount(String groupLayerId, Promise promise){
        try {
            GroupLayer groupLayer = (GroupLayer) getObjFromList(groupLayerId);
            int count = groupLayer.getCount();
            promise.resolve(count);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getLayerEnum(String groupLayerId, Promise promise){
        try {
            GroupLayer groupLayer = (GroupLayer) getObjFromList(groupLayerId);
            LayerEnum layerEnum = groupLayer.getLayerEnum();

            String layerEnumId = JSLayerEnum.registerId(layerEnum);
            WritableMap writableMap = Arguments.createMap();
            writableMap.putString("LayerEnumId",layerEnumId);
            promise.resolve(writableMap);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void item(String groupLayerId, int i, Promise promise){
        try {
            GroupLayer groupLayer = (GroupLayer) getObjFromList(groupLayerId);
            MapLayer mapLayer = groupLayer.item(i);
            String MapLayerId = JSMapLayer.registerId(mapLayer);

            WritableMap map = Arguments.createMap();
            map.putString("MapLayerId", MapLayerId);
            promise.resolve(map);
        }catch (Exception e){
            promise.reject(e);
        }
    }


    @ReactMethod
    public void append(String groupLayerId, String mapLayerId, Promise promise){
        try {
            GroupLayer groupLayer = (GroupLayer) getObjFromList(groupLayerId);
            MapLayer mapLayer = JSMapLayer.getObjFromList(mapLayerId);
            int id = groupLayer.append(mapLayer);
            promise.resolve(id);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void insert(String groupLayerId, int index, String mapLayerId, Promise promise){
        try {
            GroupLayer groupLayer = (GroupLayer) getObjFromList(groupLayerId);
            MapLayer mapLayer = JSMapLayer.getObjFromList(mapLayerId);
            int id = groupLayer.insert(index,mapLayer);
            promise.resolve(id);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void removeByLayer(String groupLayerId, String mapLayerId, Promise promise){
        try {
            GroupLayer groupLayer = (GroupLayer) getObjFromList(groupLayerId);
            MapLayer mapLayer = JSMapLayer.getObjFromList(mapLayerId);
            boolean remove = groupLayer.remove(mapLayer);
            promise.resolve(remove);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void remove(String groupLayerId, int fromIndex, int nCount, Promise promise){
        try {
            GroupLayer groupLayer = (GroupLayer) getObjFromList(groupLayerId);
            boolean remove = groupLayer.remove(fromIndex, nCount);
            promise.resolve(remove);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void removeByLayerIndex(String groupLayerId, int layerIndex, Promise promise){
        try{
            GroupLayer groupLayer = (GroupLayer) getObjFromList(groupLayerId);
            boolean remove = groupLayer.remove(layerIndex);
            promise.resolve(remove);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    // 底层会崩溃，暂时无法使用
    @ReactMethod
    public void clear(String groupLayerId, Promise promise){
        try {
            GroupLayer groupLayer = (GroupLayer) getObjFromList(groupLayerId);
            boolean clear = groupLayer.clear();
            promise.resolve(clear);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void dragOut(String groupLayerId, String pLayerId, Promise promise){
        try{
            GroupLayer groupLayer = (GroupLayer) getObjFromList(groupLayerId);
            MapLayer pLayer = JSMapLayer.getObjFromList(pLayerId);
            boolean dragOut = groupLayer.dragOut(pLayer);
            promise.resolve(dragOut);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void dragIn(String groupLayerId, int index, String pLayerId, Promise promise){
        try {
            GroupLayer groupLayer = (GroupLayer) getObjFromList(groupLayerId);
            MapLayer pLayer = JSMapLayer.getObjFromList(pLayerId);
            boolean drageIn = groupLayer.dragIn(index, pLayer);
            promise.resolve(drageIn);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void indexOfByLayerName(String groupLayerId, String layerName, Promise promise){
        try {
            GroupLayer groupLayer = (GroupLayer) getObjFromList(groupLayerId);
            int index = groupLayer.indexOf(layerName);
            promise.resolve(index);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void indexOfByLayer(String groupLayerId, String pLayerId, Promise promise){
        try {
            GroupLayer groupLayer = (GroupLayer) getObjFromList(groupLayerId);
            MapLayer pLayer = getObjFromList(pLayerId);
            int index = -1;
            if(pLayer != null){
                index = groupLayer.indexOf(pLayer);
            }
            promise.resolve(index);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void moveToBottom(String groupLayerId, int index, Promise promise){
        try {
            GroupLayer groupLayer = (GroupLayer) getObjFromList(groupLayerId);
            boolean moveToBottom = groupLayer.moveToBottom(index);
            promise.resolve(moveToBottom);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void moveToTop(String groupLayerId, int index, Promise promise){
        try {
            GroupLayer groupLayer = (GroupLayer) getObjFromList(groupLayerId);
            boolean moveToTop = groupLayer.moveToTop(index);
            promise.resolve(moveToTop);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void moveToDown(String groupLayerId, int index, Promise promise){
        try {
            GroupLayer groupLayer = (GroupLayer) getObjFromList(groupLayerId);
            boolean moveToDown = groupLayer.moveToDown(index);
            promise.resolve(moveToDown);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void moveToUp(String groupLayerId, int index, Promise promise){
        try {
            GroupLayer groupLayer = (GroupLayer) getObjFromList(groupLayerId);
            boolean moveToUp = groupLayer.moveToUp(index);
            promise.resolve(moveToUp);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void move(String groupLayerId, int fromIndex, int toIndex, Promise promise){
        try {
            GroupLayer groupLayer = (GroupLayer) getObjFromList(groupLayerId);
            boolean move = groupLayer.move(fromIndex, toIndex);
            promise.resolve(move);
        }catch (Exception e){
            promise.reject(e);
        }
    }


}
