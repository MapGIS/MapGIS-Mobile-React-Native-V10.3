/*
 * @Description: In User Settings Edit
 * @Author: your name
 * @Date: 2019-08-30 17:44:32
 * @LastEditTime: 2019-09-23 15:31:13
 * @LastEditors: Please set LastEditors
 */

/**
 * @content 组图层
 * @author xiaoying 2019-08-30 17:44:32
 */
import {NativeModules} from "react-native";
import  LayerEnum  from "./LayerEnum.js";
import MapLayer from "./MapLayer.js";
import Map from "./Map.js";

let GL = NativeModules.JSGroupLayer;

/**
 * @class GroupLayer
 * @description 组图层对象功能组件
 */
export default class GroupLayer extends MapLayer{
    
    constructor(){
        super();
        Object.defineProperty(this,"_MGGroupLayerId",{
            get:function(){
                return this._MGMapLayerId;
            },
            set:function(_MGGroupLayerId){
                this._MGMapLayerId = _MGGroupLayerId;
            },
        })
    }
    /**
     * 构造一个新GroupLayer对象
     * 
     * @memberof GroupLayer
     * @returns {Promise<GroupLayer>}
     */
    async createObj(){
        try {
            var {GroupLayerId} = await GL.createObj();
            var groupLayer = new GroupLayer();
            groupLayer._MGGroupLayerId = GroupLayerId;
            return groupLayer;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 获取组图层个数
     * 
     * @memberof GroupLayer
     * @returns {int}
     */
    async getCount(){
        try {
            let count = await GL.getCount(this._MGGroupLayerId);
            return count;
        } catch (e) {
            console.error(e);
        }
    }

   /**
    * 获取图层枚举对象
    *
    * @memberof GroupLayer
    * @returns {LayerEnum}
    */
   async getLayerEnum(){
       try {
           var {LayerEnumId} = await GL.getLayerEnum(this._MGGroupLayerId);
           var layerEnum = new LayerEnum();
           layerEnum._MGLayerEnumId = LayerEnumId;
           return layerEnum;
       } catch (e) {
           console.error(e);
       }
   }


    /**
     * 通过 索引 获取GroupLayer中的图层
     * @memberof GroupLayer
     * @param {int} i  索引
     * @returns {Promise<MapLayer>}
     */
    async item(i){
        try {
            let mapLayer;
            var { MapLayerId} = await GL.item(this._MGGroupLayerId, i); // 获取到图层id，图层类型
            mapLayer = await Map.creatMapLayerInstanceByID(MapLayerId);
            return mapLayer;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 添加图层
     * 
     * @memberof GroupLayer
     * @param {Object} mapLayer 添加的MapLayer 
     * @returns {int} 图层ID
     */
    async append(mapLayer){
        try {
            return await GL.append(this._MGGroupLayerId,mapLayer._MGMapLayerId);
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 插入图层
     * 
     * @memberof GroupLayer
     * @param {int} index  插入的索引
     * @param {Object} mapLayer 插入的图层对象 
     * @returns {int} 图层ID
     */
    async insert(index, mapLayer){
        try {
            return await GL.insert(this._MGGroupLayerId, index, mapLayer._MGMapLayerId);

        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 移除图层
     * 
     * @memberof GroupLayer
     * @param {Object} mapLayer 移除的图层对象 
     * @returns {boolean} true/false ：成功/失败
     */
    async removeByLayer(mapLayer){
        try {
            return await GL.removeByLayer(this._MGGroupLayerId, mapLayer._MGMapLayerId);

        } catch (e) {
            console.error(e);
        }
    }
   
    /**
     * 移除多个图层
     * 
     * @memberof GroupLayer
     * @param {int} fromIndex 移除开始的索引 
     * @param {int} nCount 移除的个数
     * @returns {boolean} true/false : 成功/失败
     */
    async remove(fromIndex, nCount){
        try {
            return await GL.remove(this._MGGroupLayerId, fromIndex, nCount);
            
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 移除图层
     * 
     * @memberof GroupLayer
     * @param {int} layerIndex 移除的图层ID
     * @returns {boolean} true/false : 成功/失败
     */
    async removeByLayerIndex(layerIndex){
        try {
            return await GL.removeByLayerIndex(this._MGGroupLayerId, layerIndex);     
        } catch (e) {
            console.error(e);
        }
    }

//    /**
//     * 清空图层
//     *
//     * @memberof GroupLayer
//     * @returns {boolean} true/false : 成功/失败
//     */
//    async clear(){
//        try {
//            return await GL.clear(this._MGGroupLayerId);
//
//        } catch (e) {
//            console.error(e);
//        }
//    }

    /**
     * 移除图层
     * 
     * @memberof GroupLayer
     * @param {Object} mapLayer 图层对象
     * @returns {boolean} true/false : 成功/失败
     */
    async dragOut(mapLayer){
        try {
            return await GL.dragOut(this._MGGroupLayerId, mapLayer._MGMapLayerId);

        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 移入图层
     * 
     * @memberof GroupLayer
     * @param {int} index 移入的索引
     * @param {Object} mapLayer 图层对象
     * @returns {boolean} true/false : 成功/失败
     */
    async dragIn(index, mapLayer){
        try {
            return await GL.dragIn(this._MGGroupLayerId, index, mapLayer._MGMapLayerId);
            
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 图层索引
     * 
     * @memberof GroupLayer
     * @param {String} layerName 图层名称
     * @returns {int} 成功：返回图层索引
     */
    async indexOfByLayerName(layerName){
        try {
            return await GL.indexOfByLayerName(this._MGGroupLayerId, layerName);

        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 图层索引
     * 
     * @memberof GroupLayer
     * @param {Object} mapLayer 图层对象
     * @returns {int} 成功：返回图层索引 
     */
    async indexOfByLayer(mapLayer){
        try {
            return await GL.indexOfByLayer(this._MGGroupLayerId, mapLayer._MGMapLayerId);
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 移动图层到最下面（最后绘制）
     * 
     * @memberof GroupLayer
     * @param {int} index 图层ID 
     * @returns {boolean} true/false : 成功/失败
     */
    async moveToBottom(index){
        try {
            return await GL.moveToBottom(this._MGGroupLayerId, index);

        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 移动图层到最上面（最先绘制）
     * 
     * @memberof GroupLayer
     * @param {int} index 图层ID 
     * @returns {boolean} true/false : 成功/失败
     */
    async moveToTop(index){
        try {
            return await GL.moveToBottom(this._MGGroupLayerId, index);
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 下移图层
     * 
     * @memberof GroupLayer
     * @param {int} index 图层ID 
     * @returns {boolean} true/false : 成功/失败
     */
    async moveToDown(index){
        try {
            return await GL.moveToDown(this._MGGroupLayerId, index);
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 上移图层
     * 
     * @memberof GroupLayer
     * @param {int} index 图层ID 
     * @returns {boolean} true/false : 成功/失败
     */
    async moveToUp(index){
        try {
            return await GL.moveToUp(this._MGGroupLayerId, index);
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 移动图层
     * 
     * @memberof GroupLayer
     * @param {String} fromIndex 
     * @param {String} toIndex 
     * @returns {boolean} true/false : 成功/失败
     */
    async move(fromIndex, toIndex){
        try {
            return await GL.move(this._MGGroupLayerId, fromIndex, toIndex);

        } catch (e) {
            console.error(e);
        }
    }
    
}