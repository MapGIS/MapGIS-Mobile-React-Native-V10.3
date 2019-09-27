package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.ReactApplicationContext;
import com.zondy.mapgis.core.map.VectorTileMapServer;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

/**
 * 矢量瓦片地图服务Native功能组件
 * Created by xiaoying on 2019/9/4.
 */
public class JSVectorTileMapServer extends JSTileMapServer {
    private static final String REACT_CLASS = "JSVectorTileMapServer";
//    public static Map<String, VectorTileMapServer> mVectorTileMapServerList = new HashMap<>();

    public JSVectorTileMapServer(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

//    public static VectorTileMapServer getObjFromList(String id){
//        return mVectorTileMapServerList.get(id);
//    }
//
//    public static String registerId(VectorTileMapServer obj){
//        for(Map.Entry entry : mVectorTileMapServerList.entrySet()){
//            if(obj.equals(entry.getValue())){
//                String id = (String) entry.getKey();
//                return id;
//            }
//        }
//        Calendar calendar = Calendar.getInstance();
//        String id = Long.toString(calendar.getTimeInMillis());
//        mVectorTileMapServerList.put(id,obj);
//        return id;
//    }

    public static String createObjByHandle(long handle){
        VectorTileMapServer vectorTileMapServer = new VectorTileMapServer(handle);
        return registerId(vectorTileMapServer);
    }

}
