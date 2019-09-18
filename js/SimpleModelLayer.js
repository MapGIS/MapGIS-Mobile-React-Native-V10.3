/*
 * @Description: In User Settings Edit
 * @Author: xiaoying
 * @Date: 2019-09-03 19:37:23
 * @LastEditTime: 2019-09-09 09:34:15
 * @LastEditors: Please set LastEditors
 */
import {NativeModules} from "react-native";
import MapLayer from "./MapLayer.js";
let SML = NativeModules.JSSimpleModelLayer;

/**
 * @class SimpleModelLayer
 * @description 简单模型图层
 */
export default class SimpleModelLayer extends MapLayer{
    constructor(){
        super();
        Object.defineProperty(this, "_MGSimpleModelLayerId", {
            get:function(){
                return this._MGMapLayerId;
            },
            set:function(_MGSimpleModelLayerId){
                this._MGMapLayerId = _MGSimpleModelLayerId;
            }
        });
    }
    /**
     * 创建一个新的SimpleModelLayer对象
     * 
     * @class SimpleModelLayer
     * @returns {Promise<SimpleModelLayer>}
     */
    async createObj(){
        try {
            var {SimpleModelLayerId} = await SML.createObj();
            var simpleModelLayer = new SimpleModelLayer();
            simpleModelLayer._MGSimpleModelLayerId = SimpleModelLayerId;
            return simpleModelLayer;
        } catch (e) {
            console.error(e);
        }
    }

}
