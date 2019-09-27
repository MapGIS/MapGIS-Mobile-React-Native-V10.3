package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableArray;
import com.zondy.mapgis.core.map.OGCWMTSMapServer;

import java.util.List;

/**
 * OGCWMTS地图服务Native功能组件
 * Created by xiaoying on 2019/9/9.
 */
public class JSOGCWMTSMapServer extends JSTileMapServer {
    private static final String REACT_CLASS = "JSOGCWMTSMapServer";
    public JSOGCWMTSMapServer(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @ReactMethod
    public void getLayerNames(String ogcwmtsMapServerId, Promise promise){
        try {
            OGCWMTSMapServer ogcwmtsMapServer = (OGCWMTSMapServer) getObjFromList(ogcwmtsMapServerId);
            List<String> layerNameList = ogcwmtsMapServer.getLayerNames();

            WritableArray writableArray = Arguments.createArray();

            if(layerNameList != null){
                for (int i = 0; i < layerNameList.size(); i++){
                    writableArray.pushString(layerNameList.get(i));
                }
            }

            promise.resolve(writableArray);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getLayerMatrixSetNames(String ogcwmtsMapServerId, int layerIndex, Promise promise){
        try {
            OGCWMTSMapServer ogcwmtsMapServer = (OGCWMTSMapServer) getObjFromList(ogcwmtsMapServerId);
            List<String> layerMatrixSetNames = ogcwmtsMapServer.getLayerMatrixSetNames(layerIndex);
            WritableArray writableArray = Arguments.createArray();
            if (layerMatrixSetNames != null){
                for (int i = 0; i < layerMatrixSetNames.size(); i++){
                    writableArray.pushString(layerMatrixSetNames.get(i));
                }
            }

            promise.resolve(writableArray);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getCurLayerName(String ogcwmtsMapServerId, Promise promise){
        try {
            OGCWMTSMapServer ogcwmtsMapServer = (OGCWMTSMapServer) getObjFromList(ogcwmtsMapServerId);
            String curLayerName = ogcwmtsMapServer.getCurLayerName();

            promise.resolve(curLayerName);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getCurTileMatrixSetName(String ogcwmtsMapServerId, Promise promise){
        try {
            OGCWMTSMapServer ogcwmtsMapServer = (OGCWMTSMapServer) getObjFromList(ogcwmtsMapServerId);
            String curTileMatrixSetName = ogcwmtsMapServer.getCurTileMatrixSetName();

            promise.resolve(curTileMatrixSetName);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getCurStyleName(String ogcwmtsMapServerId, Promise promise){
        try{
            OGCWMTSMapServer ogcwmtsMapServer = (OGCWMTSMapServer) getObjFromList(ogcwmtsMapServerId);
            String curStyleName = ogcwmtsMapServer.getCurStyleName();

            promise.resolve(curStyleName);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setCurLayerInfo(String ogcwmtsMapServerId, String layerName, String matrixSetName, String styleName, Promise promise){
        try{
            OGCWMTSMapServer ogcwmtsMapServer = (OGCWMTSMapServer) getObjFromList(ogcwmtsMapServerId);
            ogcwmtsMapServer.setCurLayerInfo(layerName, matrixSetName, styleName);

            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

}
