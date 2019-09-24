package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.core.geometry.Rect;
import com.zondy.mapgis.core.map.MapServer;
import com.zondy.mapgis.core.map.MapServerAccessMode;
import com.zondy.mapgis.core.map.ServerLayer;
import com.zondy.mapgis.core.map.TilePreFetchListener;
import com.zondy.mapgis.core.object.Enumeration;

/**
 * 服务图层Native对象功能组件
 * Created by xiaoying on 2019/9/10.
 */
public class JSServerLayer extends JSGroupLayer {
    private static final String REACT_CLASS = "JSServerLayer";
    private ReactApplicationContext mReactContext;
    public JSServerLayer(ReactApplicationContext reactContext) {
        super(reactContext);
        this.mReactContext = reactContext;
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @ReactMethod
    public void createObj(Promise promise){
        try {
            ServerLayer serverLayer = new ServerLayer();
            String serverLayerId = registerId(serverLayer);

            WritableMap writableMap = Arguments.createMap();
            writableMap.putString("ServerLayerId", serverLayerId);
            promise.resolve(writableMap);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setMapServer(String serverLayerId, String mapServerId, Promise promise){
        try {
            ServerLayer serverLayer = (ServerLayer) getObjFromList(serverLayerId);
            MapServer mapServer = JSMapServer.getObjFromList(mapServerId);
            serverLayer.setMapServer(mapServer);

           promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setAccessMode(String serverLayerId, int accessMode, Promise promise){
        try {
            ServerLayer serverLayer = (ServerLayer) getObjFromList(serverLayerId);
            MapServerAccessMode mapServerAccessMode = (MapServerAccessMode) Enumeration.parse(MapServerAccessMode.class, accessMode);
            serverLayer.setAccessMode(mapServerAccessMode);

            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getMapServer(String serverLayerId, Promise promise){
        try {
            ServerLayer serverLayer = (ServerLayer) getObjFromList(serverLayerId);
            MapServer mapServer = serverLayer.getMapServer();

            String mapServerId = null;
            int mapServerBrowseType = -1;
            String mapServerType = "";
            WritableMap writableMap = Arguments.createMap();

            if(mapServer != null){
                mapServerId = JSMapServer.registerId(mapServer);
                mapServerBrowseType = mapServer.getMapBrowseType().value();
                mapServerType = mapServer.getType();

            }
            writableMap.putString("MapServerId", mapServerId);
            writableMap.putInt("MapServerBrowseType", mapServerBrowseType);
            writableMap.putString("Type", mapServerType);
            promise.resolve(writableMap);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getAccessMode(String serverLayerId, Promise promise){
        try {
            ServerLayer serverLayer = (ServerLayer) getObjFromList(serverLayerId);
            MapServerAccessMode mapServerAccessMode = serverLayer.getAccessMode();
            int value = mapServerAccessMode.value();

            promise.resolve(value);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setURL(String serverLayerId, String strURL, Promise promise){
        try {
            ServerLayer serverLayer = (ServerLayer) getObjFromList(serverLayerId);
            boolean result = serverLayer.setURL(strURL);

            promise.resolve(result);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void createMapServer(String type, Promise promise){
        try {
            //ServerLayer serverLayer = (ServerLayer) getObjFromList(serverLayerId);
            MapServer mapServer = ServerLayer.createMapServer(type);
            String mapServerId = "";
            int mapServerBrowseType = -1;
            String mapServerType = "";
            WritableMap writableMap = Arguments.createMap();

            if(mapServer != null){
                mapServerId = JSMapServer.registerId(mapServer);
                mapServerBrowseType = mapServer.getMapBrowseType().value();
                mapServerType = mapServer.getType();
            }
            writableMap.putString("MapServerId", mapServerId);
            writableMap.putInt("MapServerBrowseType", mapServerBrowseType);
            writableMap.putString("Type", mapServerType);

            promise.resolve(writableMap);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void clearCache(String serverLayerId, Promise promise){
        try {
            ServerLayer serverLayer = (ServerLayer) getObjFromList(serverLayerId);
            serverLayer.clearCache();

            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setAutoScaleFlag(String serverLayerId, boolean flag, Promise promise){
        try {
            ServerLayer serverLayer = (ServerLayer) getObjFromList(serverLayerId);
            serverLayer.setAutoScaleFlag(flag);

            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getAutoScaleFlag(String serverLayerId, Promise promise){
        try {
            ServerLayer serverLayer = (ServerLayer) getObjFromList(serverLayerId);
            boolean result = serverLayer.getAutoScaleFlag();

            promise.resolve(result);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setCacheLocation(String serverLayerId, String strCacheLocation, Promise promise){
        try {
            ServerLayer serverLayer = (ServerLayer) getObjFromList(serverLayerId);
            int result = serverLayer.setCacheLocation(strCacheLocation);

            promise.resolve(result);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getCacheLocation(String serverLayerId, Promise promise){
        try {
            ServerLayer serverLayer = (ServerLayer) getObjFromList(serverLayerId);
            String cacheLocation = serverLayer.getCacheLocation();

            promise.resolve(cacheLocation);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void preFetch(String serverLayerId, int lMinZoom, int lMaxZoom, String rectId, Promise promise){
        try {
            ServerLayer serverLayer = (ServerLayer) getObjFromList(serverLayerId);
            Rect rect = JSRect.getObjFromList(rectId);
            int result = serverLayer.preFetch(lMinZoom, lMaxZoom, rect);

            promise.resolve(result);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void stopFetch(String serverLayerId, int taskID, Promise promise){
        try {
            ServerLayer serverLayer = (ServerLayer) getObjFromList(serverLayerId);
            int result = serverLayer.stopFetch(taskID);

            promise.resolve(result);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void registerTilePreFetchListener(String serverLayerId, Promise promise){
        try {
            ServerLayer serverLayer = (ServerLayer) getObjFromList(serverLayerId);
            LayerTilePreFetchListener layerTilePreFetchListener = new LayerTilePreFetchListener(mReactContext);
            int result = serverLayer.setTilePreFetchListener(layerTilePreFetchListener);

            promise.resolve(result);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void removeTilePreFetchListener(String serverLayerId, Promise promise){
        try {
            ServerLayer serverLayer = (ServerLayer) getObjFromList(serverLayerId);
            serverLayer.setTilePreFetchListener(null);

            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setTransparency(String serverLayerId, int trans, Promise promise){
        try {
            ServerLayer serverLayer = (ServerLayer) getObjFromList(serverLayerId);
            int result = serverLayer.setTransparency((short) trans);

            promise.resolve(result);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getTransparency(String serverLayerId, Promise promise){
        try {
            ServerLayer serverLayer = (ServerLayer) getObjFromList(serverLayerId);
            int transparency = serverLayer.getTransparency();

            promise.resolve(transparency);
        }catch (Exception e){
            promise.reject(e);
        }
    }
}
