package com.mapgis_mobile_reactnative;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.android.graphic.GraphicsOverlay;
import com.zondy.mapgis.core.geometry.Rect;
import com.zondy.mapgis.core.map.LayerState;
import com.zondy.mapgis.core.map.MapLayer;
import com.zondy.mapgis.core.object.Enumeration;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * @content 覆盖物对象Native组件
 * @author fjl 2019-6-24 下午2:52:36
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

    public static MapLayer getObjFromList(String id){
        return mMapLayerList.get(id);
    }

    public static String registerId(MapLayer obj) {
        for (Map.Entry entry : mMapLayerList.entrySet()) {
            if (obj.equals(entry.getValue())) {
                String id = (String) entry.getKey();
                mMapLayerList.put(id, obj);
                return (String) entry.getKey();
            }
        }

        Calendar calendar = Calendar.getInstance();
        String id = Long.toString(calendar.getTimeInMillis());
        mMapLayerList.put(id, obj);
        return id;
    }

    @ReactMethod
    public void createObj(Promise promise){
        try{
            MapLayer MapLayer = new MapLayer();
            String MapLayerId = registerId(MapLayer);

            WritableMap map = Arguments.createMap();
            map.putString("MapLayerId",MapLayerId);
            promise.resolve(map);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setName(String MapLayerId,String name,Promise promise){
        try{
            MapLayer mapLayer = getObjFromList(MapLayerId);
            mapLayer.setName(name);

        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getName(String MapLayerId,Promise promise){
        try{
            MapLayer mapLayer = getObjFromList(MapLayerId);
            String name = mapLayer.getName();

            promise.resolve(name);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getURL(String MapLayerId,Promise promise){
        try{
            MapLayer mapLayer = getObjFromList(MapLayerId);
            String url = mapLayer.getURL();

            promise.resolve(url);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setURL(String MapLayerId,String url,Promise promise){
        try{
            MapLayer mapLayer = getObjFromList(MapLayerId);
            mapLayer.setURL(url);

        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getState(String MapLayerId,Promise promise){
        try{
            MapLayer mapLayer = getObjFromList(MapLayerId);
            LayerState state = mapLayer.getState();
            int stateValue = state.value();

            promise.resolve(stateValue);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setState(String MapLayerId,int state,Promise promise){
        try{
            MapLayer mapLayer = getObjFromList(MapLayerId);
            mapLayer.setState((LayerState) Enumeration.parse(LayerState.class, state));

        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setVisible(String MapLayerId,boolean state,Promise promise){
        try{
            MapLayer mapLayer = getObjFromList(MapLayerId);
            mapLayer.setVisible(state);

        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getIsVisible(String MapLayerId,Promise promise){
        try{
            MapLayer mapLayer = getObjFromList(MapLayerId);
            boolean state = mapLayer.getIsVisible();
            promise.resolve(state);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getMinScale(String MapLayerId,Promise promise){
        try{
            MapLayer mapLayer = getObjFromList(MapLayerId);
            double minScale = mapLayer.getMinScale();
            promise.resolve(minScale);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setMinScale(String MapLayerId,double MinScale,Promise promise){
        try{
            MapLayer mapLayer = getObjFromList(MapLayerId);
            mapLayer.setMinScale(MinScale);

        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getMaxScale(String MapLayerId,Promise promise){
        try{
            MapLayer mapLayer = getObjFromList(MapLayerId);
            double maxScale = mapLayer.getMaxScale();
            promise.resolve(maxScale);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setMaxScale(String MapLayerId,double MaxScale,Promise promise){
        try{
            MapLayer mapLayer = getObjFromList(MapLayerId);
            mapLayer.setMaxScale(MaxScale);

        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getWeight(String MapLayerId,Promise promise){
        try{
            MapLayer mapLayer = getObjFromList(MapLayerId);
            int weight = mapLayer.getWeight();
            promise.resolve(weight);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setWeight(String MapLayerId,short Weight,Promise promise){
        try{
            MapLayer mapLayer = getObjFromList(MapLayerId);
            mapLayer.setWeight(Weight);

        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getIsValid(String MapLayerId,Promise promise){
        try{
            MapLayer mapLayer = getObjFromList(MapLayerId);
            boolean isValid = mapLayer.getIsValid();
            promise.resolve(isValid);

        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getViewRange(String MapLayerId,Promise promise)
    {
        try {
            MapLayer mapLayer = getObjFromList(MapLayerId);
            Rect rect = mapLayer.getRange();

            String rectId = JSRect.registerId(rect);
            WritableMap map = Arguments.createMap();
            map.putString("rectId",rectId);
            promise.resolve(map);
        }
        catch (Exception e)
        {
            promise.reject(e);
        }
    }
}
