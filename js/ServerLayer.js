/*
 * @Description: In User Settings Edit
 * @Author: xiaoying
 * @Date: 2019-09-10 10:46:01
 * @LastEditTime: 2019-09-21 13:53:36
 * @LastEditors: Please set LastEditors
 */
import { NativeModules } from "react-native";
import GroupLayer from "./GroupLayer";
import VectorMapServer from "./VectorMapServer.js";
import VectorTileMapServer from "./VectorTileMapServer.js";
import OGCWMTSMapServer from "./OGCWMTSMapServer.js";
import TileMapServer from "./TileMapServer.js";
let SL = NativeModules.JSServerLayer;

/**
 * @class ServerLayer
 * @description 服务图层
 */
export default class ServerLayer extends GroupLayer{
    constructor(){
        super();
        Object.defineProperty(this, "_MGServerLayerId", {
            get:function(){
                return this._MGGroupLayerId;
            },
            set:function(_MGServerLayerId){
                this._MGGroupLayerId = _MGServerLayerId;
            }
        })
    }

    /**
     * 构造一个新的ServerLayer对象
     * 
     * @memberof ServerLayer
     * @returns {Promise<ServerLayer>}
     */
    async createObj(){
        try {
            var {ServerLayerId} = await SL.createObj();
            var serverLayer = new ServerLayer();
            serverLayer._MGServerLayerId = ServerLayerId;
            return serverLayer;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 设置地图服务
     * 
     * @memberof ServerLayer
     * @param {Object} mapServer 地图服务对象 （MapServer类型的Object）
     * @returns {Promise<Void>}
     */
    async setMapServer(mapServer){
        try {
            await SL.setMapServer(this._MGServerLayerId, mapServer._MGMapServerId);
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 设置服务图层的数据读取模式
     * 
     * @memberof ServerLayer
     * @param {Number} accessMode 地图服务访问模式（int类型的Number），例：1--MapServerAccessMode.ServerAndCache
     * @returns {Promise<void>}
     */
    async setAccessMode(accessMode){
        try {
            await SL.setAccessMode(this._MGServerLayerId, accessMode);
        } catch (e) {
            console.error(e);
        }
    }

     /**
     * 获取地图服务
     * 
     * @memberof ServerLayer
     * @returns {Promise<MapServer>}
     */
    async getMapServer(){
        try {
            var {MapServerId, MapBrowseType, Type}= await SL.getMapServer(this._MGServerLayerId);
            let mapServer = ServerLayer.createMapServerByIdAndType(MapServerId, MapBrowseType, Type);
            return mapServer;
        } catch (e) {
            console.error(e);
        }
    }
    
    // 通过地图服务类型、地图浏览类型创建MapServer对象
    static async createMapServerByIdAndType(mapServerId, mapBrowseType, type){
    
       let mapServer = null;
       if(mapServerId != null) {
        if(mapBrowseType == 1){                                   // 地图浏览类型 -- 矢量
            mapServer = new VectorMapServer();
            mapServer._MGMapServerId = mapServerId;

        }else if(mapBrowseType == 2){                            // 地图浏览类型 -- 矢量瓦片
            mapServer = new VectorTileMapServer();
            mapServer._MGMapServerId = mapServerId;

        }else{                                                  // 地图浏览类型 -- 任意
            if(type != null){
                if(type == "OGCWMTS"){                          // 服务类型 -- OGCWMTS地图服务 
                    mapServer = new OGCWMTSMapServer();
                    mapServer._MGMapServerId = mapServerId;
                }else{                                     
                    mapServer = new TileMapServer();   
                    mapServer._MGMapServerId = mapServerId;
                }
            }
        }
       }

       return mapServer;
    }
    /**
     * 获取服务图层的数据读取模式
     * 
     * @memberof ServerLayer
     * @returns {Number} 地图服务访问模式（int类型的Number），例：1--MapServerAccessMode.ServerAndCache
     */
    async getAccessMode(){
        try {
            let accessMode = await SL.getAccessMode(this._MGServerLayerId);
            return accessMode;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 设置服务URL
     * 
     * @memberof ServerLayer
     * @param {String} strURL 服务URL
     * @returns {boolean} 成功返回true
     */
    async setURL(strURL){
        try {
            let result = await SL.setURL(this._MGServerLayerId, strURL);
            return result;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 根据类型创建地图服务
     * 
     * @memberof ServerLayer
     * @param {String} type MapServer中的类型常量，如：MapServer.MapServerType.MAPSERVER_TYPE_OGC_WMS
     * @returns {Promise<MapServer>} 返回创建好的MapServer对象
     */
    static async createMapServer(type){
        try {
            var {MapServerId, MapServerBrowseType, Type} = await SL.createMapServer(type);
            let mapServer = null;
            if(MapServerId !="" && MapServerBrowseType != -1){
                if(MapServerBrowseType == 1){
                    mapServer = new VectorMapServer();
                    mapServer._MGMapServerId = MapServerId;

                }else if(MapServerBrowseType == 2){
                    mapServer = new VectorTileMapServer();
                    mapServer._MGMapServerId = MapServerId;

                }else{
                    if(Type == "OGCWMTS"){
                        mapServer = new OGCWMTSMapServer();
                        mapServer._MGMapServerId = MapServerId;
                    }else{
                        mapServer = new TileMapServer();
                        mapServer._MGMapServerId = MapServerId;
                    }
                }
            }
            return mapServer;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 清除缓存(内存缓存+本地文件缓存)
     * 
     * @memberof ServerLayer
     * @returns {Promise<Void>}
     */
    async clearCache(){
        try {
            await SL.clearCache(this._MGServerLayerId);
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 设置是否开启自适应显示
     * 
     * @memberof ServerLayer
     * @param {boolean} flag true为开启,false不开启。默认情况下不开启。
     * @returns {Promise<Void>}
     */
    async setAutoScaleFlag(flag){
        try {
            await SL.setAutoScaleFlag(this._MGServerLayerId, flag);
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 获取是否开启自适应显示。
     * 
     * @memberof ServerLayer
     * @returns {boolean}  true为开启,false不开启。默认情况下不开启。
     */
    async getAutoScaleFlag(){
        try {
            let result = await SL.getAutoScaleFlag(this._MGServerLayerId);
            return result;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 设置缓存路径
     * 
     * @memberof ServerLayer
     * @param {String} strCacheLocation 缓存路径.用户需要保证该目录存在，否则设置失败。
     * @returns {Number}  0:失败.1:成功（int类型的Number） 
     */
    async setCacheLocation(strCacheLocation){
        try {
            let result = await SL.setCacheLocation(this._MGServerLayerId, strCacheLocation);
            return result;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 获取缓存路径。
     * 
     * @memberof ServerLayer
     * @returns {String}  缓存路径
     */
    async getCacheLocation(){
        try {
            let result = await SL.getCacheLocation(this._MGServerLayerId);
            return result;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 预缓存(可根据级别或者范围进行缓存)
	 * 该方法为异步方法，用户可以通过ServerLayer上的TilePreFetchListener获取预缓存的任务状态
     * 
     * @memberof ServerLayer
	 * @param {Number} lMinZoom 预缓存的最小级别
	 * @param {Number} lMaxZoom 预缓存的最小级别
	 * @param {Object} rect 预缓存的空间范围  （Rect类型的Object）
     * @memberof ServerLayer
     * @returns {Number} （int类型的Number） >=0成功,返回任务ID,-1:没有设置MapServer,-2:MapServer类型不支持预缓存,-3:参数不合法.
	 * 任务ID,从0开始，用户可以通过该返回值区分不同的预缓存任务.
     */
    async preFetch(lMinZoom, lMaxZoom, rect){
        try {
            let result = await SL.preFetch(this._MGServerLayerId, lMinZoom, lMaxZoom, rect._MGRectId);
            return result;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 停止预缓存
     * 
     * @memberof ServerLayer
     * @param {Number} taskId 任务Id (int类型的Number)
     * @returns {Number} >0成功 （int类型的Number） 
     */
    async stopFetch(taskId){
        try {
            let result = await SL.stopFetch(this._MGServerLayerId, taskId);
            return result;
        } catch (e) {
            console.error(e);
        }

    }

    /**
     * 设置预缓存状态监听类
     * 
     * @memberof ServerLayer
     * @returns {Number} 1 ：成功，0：失败。
     */
    async registerTilePreFetchListener(){
        try {
            let result = await SL.registerTilePreFetchListener(this._MGServerLayerId);
            return result;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 移除预缓存状态监听类
     * 
     * @memberof ServerLayer
     * @returns {Object} 预缓存状态监听对象。
     */
    async removeTilePreFetchListener(){
        try {
            await SL.removeTilePreFetchListener(this._MGServerLayerId);

        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 设置透明度,0-100 默认为0,表示不透明
     * 
     * @memberof ServerLayer
     * @param {Number} trans 透明度，0-100的整数
     * @returns {Number} 1：成功，0：失败。(int类型的Number)
     */
    async setTransparency(trans){
        try {
            let result = await SL.setTransparency(this._MGServerLayerId, trans);
            return result;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 获取透明度
     * 
     * @memberof ServerLayer
     * @returns {Number} 透明度,0-100的整数。 默认为0,表示不透明
     */
    async getTransparency(){
        try {
            let result = await SL.getTransparency(this._MGServerLayerId);
            return result;
        } catch (e) {
            console.error(e);
        }
    }
}