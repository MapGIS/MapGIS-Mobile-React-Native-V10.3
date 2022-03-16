package com.zondy.mapgis.mobile.react.scene;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.core.geometry.IntUser;
import com.zondy.mapgis.core.geometry.Rect;
import com.zondy.mapgis.core.geometry.Rect3D;
import com.zondy.mapgis.core.map.MapServer;
import com.zondy.mapgis.core.scene.ServerLayer3D;
import com.zondy.mapgis.core.srs.SRefData;
import com.zondy.mapgis.mobile.react.JSIntUser;
import com.zondy.mapgis.mobile.react.JSMapServer;
import com.zondy.mapgis.mobile.react.JSRect;
import com.zondy.mapgis.mobile.react.JSSRefData;

import java.util.HashMap;
import java.util.Map;

/**
 * @auther LiaoLiang on 20-7-15
 * @content 三维服务图层类，支持 IGServer地图服务、三维服务、OGC标准服务（WFS、WMS）及TMS服务,天地图、Google地图等第三方公共地图服务
 */
public class JSServerLayer3D extends JSGroupLayer3D {
    private static final String REACT_CLASS = "JSServerLayer3D";
    private static String Tag = "JSServerLayer3D";
    private static Map<String, ServerLayer3D> ServerLayer3DList = new HashMap<>();

    public JSServerLayer3D(@NonNull ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @NonNull
    @Override
    public String getName() {
        return REACT_CLASS;
    }

    /**
     * 构造一个新的ServerLayer3D对象
     * @param promise
     */
    @ReactMethod
    public void createObj(Promise promise) {
        try {
            ServerLayer3D serverLayer3D = new ServerLayer3D();
            String serverLayer3DId = registerId(serverLayer3D);

            WritableMap map = Arguments.createMap();
            map.putString("serverLayer3DId", serverLayer3DId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 清除m3d模型缓存
     * @param serverLayer3DId
     * @param promise
     */
    @ReactMethod
    public void clearCache(String serverLayer3DId, Promise promise) {
        try {
            ServerLayer3D serverLayer3D = (ServerLayer3D) getObjById(serverLayer3DId);
            boolean result = serverLayer3D.clearCache(); //成功返回true,失败返回false

            promise.resolve(result);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 连接数据(真实地连接数据源，可以获取服务返回相关信息 如HDF瓦片信息。)
     * @param serverLayer3DId
     * @param promise
     */
    @ReactMethod
    public void connectData(String serverLayer3DId, Promise promise) {
        try {
            ServerLayer3D serverLayer3D = (ServerLayer3D) getObjById(serverLayer3DId);
            int result = serverLayer3D.connectData(); //1-成功；0-失败

            promise.resolve(result);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取图层范围
     * @param serverLayer3DId
     * @param rectId
     * @param promise
     */
    @ReactMethod
    public void getExtent(String serverLayer3DId, String rectId, Promise promise) {
        try {
            ServerLayer3D serverLayer3D = (ServerLayer3D) getObjById(serverLayer3DId);
            Rect rect = JSRect.getObjFromList(rectId);
            int result = serverLayer3D.getExtent(rect); //1-成功；0-失败

            promise.resolve(result);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取图层三维范围
     * @param serverLayer3DId
     * @param rect3DId
     * @param promise
     */
    @ReactMethod
    public void getExtentOf3D(String serverLayer3DId, String rect3DId, Promise promise) {
        try {
            ServerLayer3D serverLayer3D = (ServerLayer3D) getObjById(serverLayer3DId);
            Rect3D rect3D = JSRect3D.getObjById(rect3DId);
            int result = serverLayer3D.getExtent(rect3D); //1-成功；0-失败

            promise.resolve(result);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取图层数
     * @param serverLayer3DId
     * @param promise
     */
    @ReactMethod
    public void getLayerCount(String serverLayer3DId, Promise promise) {
        try {
            ServerLayer3D serverLayer3D = (ServerLayer3D) getObjById(serverLayer3DId);
            int layerCountNum = serverLayer3D.getLayerCount();

            promise.resolve(layerCountNum);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取图层参考系
     * @param serverLayer3DId
     * @param SRefDataId
     * @param promise
     */
    @ReactMethod
    public void getSRS(String serverLayer3DId, String SRefDataId, Promise promise) {
        try {
            ServerLayer3D serverLayer3D = (ServerLayer3D) getObjById(serverLayer3DId);
            SRefData sRefData = JSSRefData.getObjFromList(SRefDataId);
            int result = serverLayer3D.getSRS(sRefData); //1-成功；0-失败

            promise.resolve(result);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     *获取图层显示模式透明度
     * @param serverLayer3DId
     * @param sAlpha 透明度，值为0-100，其中0为不透明
     * @param promise
     */
    @ReactMethod
    public void getTransparency(String serverLayer3DId, int sAlpha, Promise promise) {
        try {
            ServerLayer3D serverLayer3D = (ServerLayer3D) getObjById(serverLayer3DId);
            int result = serverLayer3D.getTransparency((short) sAlpha); //1-成功；0-失败

            promise.resolve(result);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取图层类型的值
     * @param serverLayer3DId
     * @param promise
     */
    @ReactMethod
    public void getType(String serverLayer3DId, Promise promise) {
        try {
            ServerLayer3D serverLayer3D = (ServerLayer3D) getObjById(serverLayer3DId);
            int typeValue = serverLayer3D.getType().value();

            promise.resolve(typeValue);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取服务地址URL
     * @param serverLayer3DId
     * @param promise
     */
    @ReactMethod
    public void getURL(String serverLayer3DId, Promise promise) {
        try {
            ServerLayer3D serverLayer3D = (ServerLayer3D) getObjById(serverLayer3DId);
            String url = serverLayer3D.getURL();

            promise.resolve(url);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取服务数据源缩放级范围
     * @param serverLayer3DId
     * @param minZoomId
     * @param maxZoomId
     * @param promise
     */
    @ReactMethod
    public void getZoomCapacity(String serverLayer3DId, String minZoomId, String maxZoomId, Promise promise) {
        try {
            ServerLayer3D serverLayer3D = (ServerLayer3D) getObjById(serverLayer3DId);
            IntUser minZoom = JSIntUser.getObjFromList(minZoomId);
            IntUser maxZoom = JSIntUser.getObjFromList(maxZoomId);
            String zoomCapacity = String.valueOf(serverLayer3D.getZoomCapacity(minZoom, maxZoom));

            promise.resolve(zoomCapacity);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 图层数据是否有效
     * @param serverLayer3DId
     * @param promise
     */
    @ReactMethod
    public void isValid(String serverLayer3DId, Promise promise) {
        try {
            ServerLayer3D serverLayer3D = (ServerLayer3D) getObjById(serverLayer3DId);
            boolean result = serverLayer3D.isValid();

            promise.resolve(result);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 设置图层显示的透明度
     * @param serverLayer3DId
     * @param sAlpha
     * @param promise
     */
    @ReactMethod
    public void setTransparency(String serverLayer3DId, int sAlpha, Promise promise) {
        try {
            ServerLayer3D serverLayer3D = (ServerLayer3D) getObjById(serverLayer3DId);
            int result = serverLayer3D.setTransparency((short) sAlpha); //1-成功；0-失败

            promise.resolve(result);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 设置服务地址URL
     * @param serverLayer3DId
     * @param strURL
     * @param promise
     */
    @ReactMethod
    public void setURL(String serverLayer3DId, String strURL, Promise promise) {
        try {
            ServerLayer3D serverLayer3D = (ServerLayer3D) getObjById(serverLayer3DId);
            boolean result = serverLayer3D.setURL(strURL);

            promise.resolve(result);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 设置服务数据源缩放级范围
     * @param serverLayer3DId
     * @param minZoom
     * @param maxZoom
     * @param promise
     */
    @ReactMethod
    public void setZoomCapacity(String serverLayer3DId, int minZoom, int maxZoom, Promise promise) {
        try {
            ServerLayer3D serverLayer3D = (ServerLayer3D) getObjById(serverLayer3DId);
            int result = (int) serverLayer3D.setZoomCapacity(minZoom, maxZoom); //成功返回1,失败返回0

            promise.resolve(result);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 根据类型创建地图服务
     * @param serverLayer3DId
     * @param type MapServer中的类型常量
     * @param promise
     */
    @ReactMethod
    public void createMapServer(String serverLayer3DId, String type, Promise promise) {
        try {
            ServerLayer3D serverLayer3D = (ServerLayer3D) getObjById(serverLayer3DId);
            MapServer mapServer = ServerLayer3D.createMapServer(type);
            String mapServerId = JSMapServer.registerId(mapServer);

            promise.resolve(mapServerId);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取地图服务对象
     * @param serverLayer3DId
     * @param promise
     */@ReactMethod
    public void getMapServer(String serverLayer3DId, Promise promise) {
        try {
            ServerLayer3D serverLayer3D = (ServerLayer3D) getObjById(serverLayer3DId);
            MapServer mapServer = serverLayer3D.getMapServer();
            String mapServerId = JSMapServer.registerId(mapServer);

            promise.resolve(mapServerId);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 设置服务
     * @param serverLayer3DId
     * @param mapServerId
     * @param promise
     */
    @ReactMethod
    public void setMapServer(String serverLayer3DId, String mapServerId, Promise promise) {
         try {
             ServerLayer3D serverLayer3D = (ServerLayer3D) getObjById(serverLayer3DId);
             MapServer mapServer = JSMapServer.getObjFromList(mapServerId);
             int result = serverLayer3D.setMapServer(mapServer); //1-成功；0-失败

             promise.resolve(result);
         }catch (Exception e) {
             promise.reject(e);
         }
    }
}
