/*
 * @Description: In User Settings Edit
 * @Author: xiaoying
 * @Date: 2019-09-03 15:41:51
 * @LastEditTime: 2019-09-23 15:35:12
 * @LastEditors: Please set LastEditors
 */
import {NativeModules} from "react-native";
let PPI = NativeModules.JSPointPlaceInfo;

/**
 * @class PointPlaceInfo
 * @description 点放置样式
 */
export default class PointPlaceInfo{

    /**
     * 构造一个新的PointPlaceInfo对象
     * 
     * @memberof PointPlaceInfo
     * @returns {Promise<PointPlaceInfo>}
     */
    async createObj(){
        try {
            var {PointPlaceInfoId}  = await PPI.createObj();
            var pointPlaceInfo = new PointPlaceInfo();
            pointPlaceInfo._MGPointPlaceInfoId = PointPlaceInfoId;
            return pointPlaceInfo;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 获取点标注类型
     * 
     * @memberof PointPlaceInfo
     * @returns {int} 点标注分布类型 例：PointPlaceType.EightLocationPlace
     */
    async getType(){
        try {
            let pointPlaceType = await PPI.getType(this._MGPointPlaceInfoId);
            return pointPlaceType;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 设置点标注类型
     * 
     * @memberof PointPlaceInfo
     * @param {int} pointPlaceType 点标注分布类型 例：PointPlaceType.EightLocationPlace
     * @returns {Promise<Void>}
     */
    async setType(pointPlaceType){
        try {
            await PPI.setType(this._MGPointPlaceInfoId, pointPlaceType);
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 获取标注与点的偏移距离(设备单位)
     * 
     * @memberof PointPlaceInfo
     * @returns {double} 标注与点的偏移距离(设备单位)
     */
    async getOffset(){
        try {
            let offset = await PPI.getOffset(this._MGPointPlaceInfoId);
            return offset;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 设置标注与点的偏移距离(设备单位)
     * 
     * @memberof PointPlaceInfo
     * @param {int} offset 标注与点的偏移距离(设备单位)
     * @returns {Promise<Void>}
     */
    async setOffset(offset){
        try {
            await PPI.setOffset(this._MGPointPlaceInfoId, offset);
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 获取八方位优先级,数组长度为8
     * 
     * @memberof PointPlaceInfo
     * @returns {Array} int类型的数组
     */
    async getEightLocationPrioritys(){
        try {
            let array = await PPI.getEightLocationPrioritys(this._MGPointPlaceInfoId);
            return array;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 设置八方位优先级
     * 
     * @memberof PointPlaceInfo
     * @param {Array} array 八方位优先级数组，int类型，数组长度为8
     * @returns {Promise<Void>}
     */
    async setEightLocationPrioritys(array){
        try {
            await PPI.setEightLocationPrioritys(this._MGPointPlaceInfoId, array);
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 获取任意方位优先级，度数，最大长度为20
     * 
     * @memberof PointPlaceInfo
     * @returns {Array} double类型的数组
     */
    async getLocationPrioritys(){
        try {
            let array = await PPI.getLocationPrioritys(this._MGPointPlaceInfoId);
            return array;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 设置任意方位优先级
     * 
     * @memberof PointPlaceInfo
     * @param {Array} array 任意方位优先级数组，double类型，最大长度为20
     * @returns {Promise<Void>}
     */
    async setLocationPrioritys(array){
        try {
            await PPI.setLocationPrioritys(this._MGPointPlaceInfoId, array);
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 获取是否避让点符号
     * 
     * @memberof PointPlaceInfo
     * @returns {boolean} 
     */
    async getAvoidPointSymbol(){
        try {
            let result = await PPI.getAvoidPointSymbol(this._MGPointPlaceInfoId);
            return result;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 设置是否避让点符号
     * 
     * @memberof PointPlaceInfo
     * @param {boolean} avoidPointSymbol 是否避让点符号 
     * @returns {Promise<Void>}
     */
    async setAvoidPointSymbol(avoidPointSymbol){
        try {
            await PPI.setAvoidPointSymbol(this._MGPointPlaceInfoId, avoidPointSymbol);
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 获取是否紧随点符号边界注记
     * 
     * @memberof PointPlaceInfo
     * @returns {boolean} 
     */
    async getFollowPointSymbolBorder(){
        try {
            let result = await PPI.getFollowPointSymbolBorder(this._MGPointPlaceInfoId);
            return result;
        } catch (e) {
            console.error(e);
        }
    }
    
    /**
     * 设置是否紧随点符号边界注记
     * 
     * @memberof PointPlaceInfo
     * @param {boolean} followPointSymbolBorder 是否紧随点符号边界注记 
     * @returns {Promise<Void>}
     */
    async setFollowPointSymbolBorder(followPointSymbolBorder){
        try {
            await PPI.setFollowPointSymbolBorder(this._MGPointPlaceInfoId, followPointSymbolBorder);
        } catch (e) {
            console.error(e);
        }
    }
}