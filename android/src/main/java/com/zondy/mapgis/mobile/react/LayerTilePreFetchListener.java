package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.zondy.mapgis.core.map.TilePreFetchListener;

/**
 * 预缓存监听
 * Created by xiaoying on 2019/9/20.
 */
public class LayerTilePreFetchListener extends TilePreFetchListener {
    private ReactContext mReactContext;
    private static final String PROGRESSING = "com.mapgis.RN.ServerLayer.LayerTilePreFetchListener.progressing";
    private static final String TILE_FETCHED = "com.mapgis.RN.ServerLayer.LayerTilePreFetchListener.tile_fetched";
    private static final String FETCH_FINISH = "com.mapgis.RN.ServerLayer.LayerTilePreFetchListener.fetch_finish";

    public LayerTilePreFetchListener(ReactContext reactContext){
        super();
        this.mReactContext = reactContext;
    }

    /**
     * 预缓存进度监听
     *
     * @param lTaskID 					任务ID,参见：ServerLayer.preFetch()
     * @param lTotalTileCount 			待预缓存的瓦片总数
     * @param lCurTileIndex 			当前缓存的瓦片索引,从0开始
     * @param dCurTileFetchProgress 	当前缓存进度[0,100]
     */
    public void             onProgressing(int lTaskID,int lTotalTileCount,int lCurTileIndex,double dCurTileFetchProgress){
        WritableMap writableMap = Arguments.createMap();
        writableMap.putInt("TaskID", lTaskID);
        writableMap.putInt("TotalTileCount", lTotalTileCount);
        writableMap.putInt("CurTileIndex", lCurTileIndex);
        writableMap.putDouble("CurTileFetchProgress", dCurTileFetchProgress);

        sendEvent(PROGRESSING , writableMap);
    }

    /**
     * 缓存状态监听
     *
     * @param lTaskID 		任务ID,参见：ServerLayer.preFetch()
     * @param lZoom 		当前缓存瓦片的级别
     * @param lRow 			当前缓存瓦片的行号
     * @param lCol 			当前缓存瓦片的列号
     * @param iStatus 		当前缓存瓦片的状态:0:成功,1:获取瓦片失败,2:写入失败.
     */
    public void             onTileFetched(int lTaskID,int lZoom,int lRow,int lCol,short iStatus)
    {
        WritableMap writableMap = Arguments.createMap();
        writableMap.putInt("TaskID", lTaskID);
        writableMap.putInt("Zoom", lZoom);
        writableMap.putInt("Row", lRow);
        writableMap.putInt("Col", lCol);
        writableMap.putInt("Status", iStatus);

        sendEvent(TILE_FETCHED , writableMap);
    }

    /**
     * 预缓存结束监听
     *
     * @param lTaskID 				任务ID,参见：ServerLayer.preFetch()
     * @param iFinishStatus 		0:正常结束,1:非正常结束
     */
    public void             onFetchFinish(int lTaskID,short iFinishStatus)
    {
        WritableMap writableMap = Arguments.createMap();
        writableMap.putInt("TaskID", lTaskID);
        writableMap.putInt("FinishStatus", iFinishStatus);

        sendEvent(FETCH_FINISH , writableMap);
    }

    private void sendEvent(String eventName, WritableMap params){
        mReactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
                .emit(eventName, params);
    }
}
