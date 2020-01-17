package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.ReactApplicationContext;
import com.zondy.mapgis.core.map.VectorTileMapServer;

/**
 * 矢量瓦片地图服务Native功能组件
 * Created by xiaoying on 2019/9/4.
 */
public class JSVectorTileMapServer extends JSTileMapServer {
    private static final String REACT_CLASS = "JSVectorTileMapServer";

    public JSVectorTileMapServer(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public static String createObjByHandle(long handle){
        VectorTileMapServer vectorTileMapServer = new VectorTileMapServer(handle);
        return registerId(vectorTileMapServer);
    }
}
