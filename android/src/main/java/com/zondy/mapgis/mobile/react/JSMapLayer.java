package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.core.geometry.Rect;
import com.zondy.mapgis.core.map.GroupLayer;
import com.zondy.mapgis.core.map.LayerState;
import com.zondy.mapgis.core.map.MapLayer;
import com.zondy.mapgis.core.map.VectorLayer;
import com.zondy.mapgis.core.object.Enumeration;
import com.zondy.mapgis.core.srs.SRefData;
import com.zondy.mapgis.jni.core.map.NativeMap;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * @author fjl 2019-6-24 下午2:52:36
 * @content 覆盖物对象Native组件
 */
public class JSMapLayer extends ReactContextBaseJavaModule {
    public static final String REACT_CLASS = "JSMapLayer";
    public static Map<String, MapLayer> mMapLayerList = new HashMap<String, MapLayer>();

    public JSMapLayer(ReactApplicationContext context) {
        super(context);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public static MapLayer getObjFromList(String id) {
        return mMapLayerList.get(id);
    }

    public static String registerId(MapLayer obj) {
        for (Map.Entry entry : mMapLayerList.entrySet()) {
            if (obj.equals(entry.getValue())) {
                String id = (String) entry.getKey();
                return id;
            }
        }

        Calendar calendar = Calendar.getInstance();
        String id = Long.toString(calendar.getTimeInMillis());
        mMapLayerList.put(id, obj);
        return id;
    }

    @ReactMethod
    public void createObj(Promise promise) {
        try {
            MapLayer MapLayer = new MapLayer();
            String MapLayerId = registerId(MapLayer);

            WritableMap map = Arguments.createMap();
            map.putString("MapLayerId", MapLayerId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setName(String MapLayerId, String name, Promise promise) {
        try {
            MapLayer mapLayer = getObjFromList(MapLayerId);
            mapLayer.setName(name);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getName(String MapLayerId, Promise promise) {
        try {
            MapLayer mapLayer = getObjFromList(MapLayerId);
            String name = mapLayer.getName();

            promise.resolve(name);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getURL(String MapLayerId, Promise promise) {
        try {
            MapLayer mapLayer = getObjFromList(MapLayerId);
            String url = mapLayer.getURL();

            promise.resolve(url);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setURL(String MapLayerId, String url, Promise promise) {
        try {
            MapLayer mapLayer = getObjFromList(MapLayerId);
            mapLayer.setURL(url);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getState(String MapLayerId, Promise promise) {
        try {
            MapLayer mapLayer = getObjFromList(MapLayerId);
            LayerState state = mapLayer.getState();
            int stateValue = state.value();

            promise.resolve(stateValue);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setState(String MapLayerId, int state, Promise promise) {
        try {
            MapLayer mapLayer = getObjFromList(MapLayerId);
            mapLayer.setState((LayerState) Enumeration.parse(LayerState.class, state));
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setVisible(String MapLayerId, boolean state, Promise promise) {
        try {
            MapLayer mapLayer = getObjFromList(MapLayerId);
            mapLayer.setVisible(state);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getIsVisible(String MapLayerId, Promise promise) {
        try {
            MapLayer mapLayer = getObjFromList(MapLayerId);
            boolean state = mapLayer.getIsVisible();
            promise.resolve(state);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getMinScale(String MapLayerId, Promise promise) {
        try {
            MapLayer mapLayer = getObjFromList(MapLayerId);
            double minScale = mapLayer.getMinScale();
            promise.resolve(minScale);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setMinScale(String MapLayerId, double MinScale, Promise promise) {
        try {
            MapLayer mapLayer = getObjFromList(MapLayerId);
            mapLayer.setMinScale(MinScale);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getMaxScale(String MapLayerId, Promise promise) {
        try {
            MapLayer mapLayer = getObjFromList(MapLayerId);
            double maxScale = mapLayer.getMaxScale();
            promise.resolve(maxScale);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setMaxScale(String MapLayerId, double MaxScale, Promise promise) {
        try {
            MapLayer mapLayer = getObjFromList(MapLayerId);
            mapLayer.setMaxScale(MaxScale);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getWeight(String MapLayerId, Promise promise) {
        try {
            MapLayer mapLayer = getObjFromList(MapLayerId);
            int weight = mapLayer.getWeight();
            promise.resolve(weight);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setWeight(String MapLayerId, short Weight, Promise promise) {
        try {
            MapLayer mapLayer = getObjFromList(MapLayerId);
            mapLayer.setWeight(Weight);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getIsValid(String MapLayerId, Promise promise) {
        try {
            MapLayer mapLayer = getObjFromList(MapLayerId);
            boolean isValid = mapLayer.getIsValid();
            promise.resolve(isValid);

        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getViewRange(String MapLayerId, Promise promise) {
        try {
            MapLayer mapLayer = getObjFromList(MapLayerId);
            Rect rect = mapLayer.getRange();

            String rectId = JSRect.registerId(rect);
            WritableMap map = Arguments.createMap();
            map.putString("rectId", rectId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getSrefInfo(String MapLayerId, Promise promise){
        try {
            MapLayer mapLayer = getObjFromList(MapLayerId);
            SRefData sRefData = mapLayer.getSrefInfo();

            String sRefInfoId = JSSRefData.registerId(sRefData);
            WritableMap map = Arguments.createMap();
            map.putString("SRefDataId",sRefInfoId);
            promise.resolve(map);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    public static WritableMap getMapLayerByHandle(MapLayer mapLayer){
        if(mapLayer == null) return null;
        long handle = mapLayer.getHandle(); // 1、获取返回结果MapLayer的handle

        if(handle == 0L) return null; // 2、handle是0L时候，返回空Id


        String mapLayerId = "";
        int type = NativeMap.jni_GetLayerType(handle); // 2、根据handle获取MapLayer的类型
        switch (type){
            case 0: // 矢量图层 （VectorLayer）
                //VectorLayer vectorLayer = JSVectorLayer.createObjByHandle(handle); // 3、根据handle构造一个vectorLayer对象
                mapLayerId =  JSVectorLayer.registerId(mapLayer);  // 4、返回注册vectorLayer对象后的Id
                break;

            case 2: // 组图层 （GroupLayer）
                //GroupLayer groupLayer = JSGroupLayer.createObjByHandle(handle); // 3、根据handle构造一个groupLayer对象
                mapLayerId = JSGroupLayer.registerId(mapLayer); // 4、返回注册groupLayer对象后的Id
                break;

            case 9: // 服务图层 （ServerLayer）

                break;
            case 10: // 简单模型图层 （SimpleModelLayer）
                break;
            default:
                break;
        }
        WritableMap map = Arguments.createMap();
        map.putString("MapLayerId", mapLayerId);
        map.putString("MapLayerType", String.valueOf(type));
        return map;
    }
}
