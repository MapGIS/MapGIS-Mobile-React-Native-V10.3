package com.zondy.mapgis.mobile.react;

import android.annotation.SuppressLint;
import android.os.Environment;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.core.map.Maps;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 地图列表对象Native组件
 * Created by xiaoying on 2019/8/28.
 */
public class JSMaps extends JSDocumentItem {
    private static final String REACT_CLASS = "JSMaps";
    public static Map<String, Maps> mMapsList = new HashMap<>();

    public JSMaps(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public static Maps getObjFromList(String mapsId){
        return mMapsList.get(mapsId);
    }

    public static String registerId(Maps obj){
        for(Map.Entry entry : mMapsList.entrySet()){
            if(obj.equals(entry.getValue())){
                String id = (String) entry.getKey();
                return id;
            }
        }
        Calendar calendar = Calendar.getInstance();
        String id = Long.toString(calendar.getTimeInMillis());
        mMapsList.put(id,obj);
        return id;
    }

    @ReactMethod
    public void createObj(Promise promise){
        try {
            Maps maps = new Maps();
            String mapsId = registerId(maps);

            WritableMap map = Arguments.createMap();
            map.putString("MapsId",mapsId);
            promise.resolve(map);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getCount(String mapsId, Promise promise){
        try {
            Maps maps = getObjFromList(mapsId);
            int count = maps.getCount();
            promise.resolve(count);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void append(String mapsId, String mapId, Promise promise){
        try {
            Maps maps = getObjFromList(mapsId);
            com.zondy.mapgis.core.map.Map map = JSMap.getObjFromList(mapId);
            int index = maps.append(map);
            promise.resolve(index);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void insert(String mapsId, int index, String mapId, Promise promise){
        try {
            Maps maps = getObjFromList(mapsId);
            com.zondy.mapgis.core.map.Map map = JSMap.getObjFromList(mapId);
            int insertId = maps.insert(index,map);
            promise.resolve(insertId);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void remove(String mapsId, int index, Promise promise){
        try {
            Maps maps = getObjFromList(mapsId);
            boolean remove = maps.remove(index);
            promise.resolve(remove);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void removeAll(String mapsId, Promise promise){
        try {
            Maps maps = getObjFromList(mapsId);
            boolean result = maps.removeAll();
            promise.resolve(result);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void indexOf(String mapsId, String mapId, Promise promise){
        try {
            Maps maps = getObjFromList(mapsId);
            com.zondy.mapgis.core.map.Map map = JSMap.getObjFromList(mapId);
            int index = maps.indexOf(map);
            promise.resolve(index);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getMap(String mapsId, int index, Promise promise){
        try {
            Maps maps = getObjFromList(mapsId);
            com.zondy.mapgis.core.map.Map map = maps.getMap(index);

            String mapId = null;
            if(map != null){
                mapId = JSMap.registerId(map);
            }
            WritableMap writableMap = Arguments.createMap();
            writableMap.putString("MapId",mapId);
            promise.resolve(writableMap);
        }catch (Exception e){
            promise.reject(e);
        }
    }

}
