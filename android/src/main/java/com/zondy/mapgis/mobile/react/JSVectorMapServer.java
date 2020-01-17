package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.core.map.VectorMapServer;

/**
 * 矢量地图服务Native功能组件
 * Created by xiaoying on 2019/9/4.
 */
public class JSVectorMapServer extends JSMapServer {
    private static final String REACT_CLASS = "JSVectorMapServer";

    public JSVectorMapServer(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @ReactMethod
    public void createObj(Promise promise){
        try {
            VectorMapServer vectorMapServer = new VectorMapServer();
            String vectorMapServerId = registerId(vectorMapServer);

            WritableMap writableMap = Arguments.createMap();
            writableMap.putString("VectorMapServerId", vectorMapServerId);
            promise.resolve(writableMap);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getCRSCount(String vectorMapServerId, Promise promise){
        try {
            VectorMapServer vectorMapServer = (VectorMapServer) getObjFromList(vectorMapServerId);
            int crsCount = vectorMapServer.getCRSCount();

            promise.resolve(crsCount);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getCRS(String vectorMapServerId, int index, Promise promise){
        try {
            VectorMapServer vectorMapServer = (VectorMapServer) getObjFromList(vectorMapServerId);
            String crs = vectorMapServer.getCRS(index);

            promise.resolve(crs);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setCurrentCRS(String vectorMapServerId, String strCRS, Promise promise){
        try {
            VectorMapServer vectorMapServer = (VectorMapServer) getObjFromList(vectorMapServerId);
            int result = (int) vectorMapServer.setCurrentCRS(strCRS);

            promise.resolve(result);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getCurrentCRS(String vectorMapServerId, Promise promise){
        try {
            VectorMapServer vectorMapServer = (VectorMapServer) getObjFromList(vectorMapServerId);
            String currentCRS = vectorMapServer.getCurrentCRS();

            promise.resolve(currentCRS);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getVectorImage(String vectorMapServerId, int imgWidth, int imgHeight, double dispRectXmin, double dispRectYmin, double dispRectXmax, double dispRectYmax, Promise promise){
        try {
            VectorMapServer vectorMapServer = (VectorMapServer) getObjFromList(vectorMapServerId);
            byte[] bytes = vectorMapServer.getVectorImage(imgWidth, imgHeight, dispRectXmin, dispRectYmin, dispRectXmax, dispRectYmax);

            WritableArray writableArray = Arguments.createArray();
            for (int i = 0; i < bytes.length; i++){
                writableArray.pushInt(bytes[i]);
            }
            promise.resolve(writableArray);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void freeVectorImage(String vectorMapServerId, ReadableArray readableArray, Promise promise){
        try {
            VectorMapServer vectorMapServer = (VectorMapServer) getObjFromList(vectorMapServerId);
            byte[] buf = new byte[readableArray.size()];
            for (int i = 0; i < readableArray.size(); i++){
                buf[i] = (byte) readableArray.getInt(i);
            }
            int result = (int) vectorMapServer.freeVectorImage(buf);
            promise.resolve(result);
        }catch (Exception e){
            promise.reject(e);
        }
    }

}
