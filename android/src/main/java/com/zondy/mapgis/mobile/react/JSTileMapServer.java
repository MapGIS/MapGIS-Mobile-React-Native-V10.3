package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.core.geometry.Dot;
import com.zondy.mapgis.core.geometry.IntUser;
import com.zondy.mapgis.core.map.TileMapServer;
import com.zondy.mapgis.core.map.TileSliceType;

/**
 * 瓦片地图服务Native功能组件
 * Created by xiaoying on 2019/9/4.
 */
public class JSTileMapServer extends JSMapServer {
    private static final String REACT_CLASS = "JSTileMapServer";

    public JSTileMapServer(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @ReactMethod
    public void createObj(Promise promise){
        try {
            TileMapServer tileMapServer = new TileMapServer();
            String tileMapServerId = registerId(tileMapServer);

            WritableMap writableMap = Arguments.createMap();
            writableMap.putString("TileMapServerId", tileMapServerId);
            promise.resolve(writableMap);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    // 底层有误，暂时不可用
    @ReactMethod
    public void getTileSliceType(String tileMapServerId, Promise promise){
        try {
            TileMapServer tileMapServer = (TileMapServer) getObjFromList(tileMapServerId);
            TileSliceType tileSliceType = tileMapServer.getTileSliceType();

            promise.resolve(tileSliceType.value());
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setMinZoom(String tileMapServerId, int minZoom, Promise promise){
        try {
            TileMapServer tileMapServer = (TileMapServer) getObjFromList(tileMapServerId);
            tileMapServer.setMinZoom(minZoom);

            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getMinZoom(String tileMapServerId, Promise promise){
        try {
            TileMapServer tileMapServer = (TileMapServer) getObjFromList(tileMapServerId);
            int minZoom = tileMapServer.getMinZoom();

            promise.resolve(minZoom);
        }catch (Exception e){
            promise.reject(e);
        }
    }


    @ReactMethod
    public void setMaxZoom(String tileMapServerId, int maxZoom, Promise promise){
        try {
            TileMapServer tileMapServer = (TileMapServer) getObjFromList(tileMapServerId);
            tileMapServer.setMaxZoom(maxZoom);

            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getMaxZoom(String tileMapServerId, Promise promise){
        try {
            TileMapServer tileMapServer = (TileMapServer) getObjFromList(tileMapServerId);
            int maxZoom = tileMapServer.getMaxZoom();

            promise.resolve(maxZoom);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getZoomCapacity(String tileMapServerId, String minZoomIntUserId, String maxZoomIntUserId, Promise promise){
        try {
            TileMapServer tileMapServer = (TileMapServer) getObjFromList(tileMapServerId);
            IntUser minZoom = JSIntUser.getObjFromList(minZoomIntUserId);
            IntUser maxZoom = JSIntUser.getObjFromList(maxZoomIntUserId);
            boolean result = tileMapServer.getZoomCapacity(minZoom, maxZoom);

            promise.resolve(result);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getTileOriginXY(String tileMapServerId, Promise promise){
        try {
            TileMapServer tileMapServer = (TileMapServer) getObjFromList(tileMapServerId);
            Dot dot = tileMapServer.getTileOriginXY();

            String point2DId = JSDot.registerId(dot);
            WritableMap writableMap = Arguments.createMap();
            writableMap.putString("point2DId", point2DId);

            promise.resolve(writableMap);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getTileSize(String tileMapServerId, String widthIntUserId, String heightIntUserId, Promise promise){
        try {
            TileMapServer tileMapServer = (TileMapServer) getObjFromList(tileMapServerId);
            IntUser width = JSIntUser.getObjFromList(widthIntUserId);   // 瓦片宽
            IntUser height = JSIntUser.getObjFromList(heightIntUserId); // 瓦片高
            boolean result = tileMapServer.getTileSize(width, height);

            promise.resolve(result);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setTileResolution(String tileMapServerId, int zoom, double dResolution, Promise promise){
        try {
            TileMapServer tileMapServer = (TileMapServer) getObjFromList(tileMapServerId);
            int result = (int) tileMapServer.setTileResolution(zoom, dResolution);

            promise.resolve(result);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getTileResolution(String tileMapServerId, int zoom, Promise promise){
        try {
            TileMapServer tileMapServer = (TileMapServer) getObjFromList(tileMapServerId);
            double resolution = tileMapServer.getTileResolution(zoom);

            promise.resolve(resolution);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getGroundResolution(String tileMapServerId, int zoom, double dLogY, Promise promise){
        try {
            TileMapServer tileMapServer = (TileMapServer) getObjFromList(tileMapServerId);
            double resolution = tileMapServer.getGroundResolution(zoom, dLogY);

            promise.resolve(resolution);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getScale(String tileMapServerId, int zoom, double dLogY, Promise promise){
        try {
            TileMapServer tileMapServer = (TileMapServer) getObjFromList(tileMapServerId);
            double scale = tileMapServer.getScale(zoom, dLogY);

            promise.resolve(scale);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    // 底层有误，暂时不可用
    @ReactMethod
    public void getTileMatrix(String tileMapServerId, int zoom, String topRowIntUserId, String leftColUserId, String bottomRowIntUserId, String rightColIntUserId, Promise promise){
        try {
            TileMapServer tileMapServer = (TileMapServer) getObjFromList(tileMapServerId);
            IntUser topRow = JSIntUser.getObjFromList(topRowIntUserId);
            IntUser leftCol = JSIntUser.getObjFromList(leftColUserId);
            IntUser bottomRow = JSIntUser.getObjFromList(bottomRowIntUserId);
            IntUser rightCol = JSIntUser.getObjFromList(rightColIntUserId);
            boolean result = tileMapServer.getTileMatrix(zoom, topRow, leftCol, bottomRow, rightCol);

            promise.resolve(result);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getTileImageByURL(String tileMapServerId, String strURL, Promise promise){
        try {
            TileMapServer tileMapServer = (TileMapServer) getObjFromList(tileMapServerId);
           byte[] results = tileMapServer.getTileImage(strURL);

            WritableArray writableArray = Arguments.createArray();
            if(results != null){
                for (int i = 0; i < results.length; i++){
                    writableArray.pushInt(results[i]);
                }
            }
            promise.resolve(writableArray);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getTileImage(String tileMapServerId, int row, int col, int zoom, Promise promise){
        try {
            TileMapServer tileMapServer = (TileMapServer) getObjFromList(tileMapServerId);
            byte[] results = tileMapServer.getTileImage(row, col, zoom);

            WritableArray writableArray = Arguments.createArray();
            if(results != null){
                for (int i = 0; i < results.length; i++){
                    writableArray.pushInt(results[i]);
                }
            }
            promise.resolve(writableArray);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void freeTileImage(String tileMapServerId, ReadableArray readableArray, Promise promise){
        try {
            TileMapServer tileMapServer = (TileMapServer) getObjFromList(tileMapServerId);
            byte[] buf = null;
            boolean result = false;

            if(readableArray != null && readableArray.size() > 0){
                buf = new byte[readableArray.size()];

                for (int i = 0; i < readableArray.size(); i++){
                    buf[i] = (byte) readableArray.getInt(i);
                }

                result = tileMapServer.freeTileImage(buf);
            }


            promise.resolve(result);
        }catch (Exception e){
            promise.reject(e);
        }
    }

}
