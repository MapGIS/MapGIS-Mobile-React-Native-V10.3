/*
 * @Description: In User Settings Edit
 * @Author: xiaoying
 * @Date: 2019-09-04 15:07:27
 * @LastEditTime: 2019-09-09 11:05:48
 * @LastEditors: Please set LastEditors
 */
import {NativeModules} from "react-native";
import TileMapServer from "./TileMapServer.js";
let VT = NativeModules.JSVectorTileMapServer;

/**
 * @class VectorTileMapServer
 * @description 矢量瓦片地图服务
 */
export default class VectorTileMapServer extends TileMapServer{
    constructor(){
        super();
        Object.defineProperty(this, "_MGVectorTileMapServerId", {
            get:function(){
                return this._MGTileMapServerId;
            },
            set:function(_MGVectorTileMapServerId){
                this._MGTileMapServerId = _MGVectorTileMapServerId;
            }
        })
    }

}