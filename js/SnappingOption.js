/*
 * @Description: In User Settings Edit
 * @Author: xiaoying
 * @Date: 2019-09-10 19:19:22
 * @LastEditTime: 2019-09-10 19:41:05
 * @LastEditors: Please set LastEditors
 */
import { NativeModules } from "react-native";
let SO = NativeModules.JSSnappingOption;

/**
 * @class SnappingOption
 * @description 捕捉选项
 */
export default class SnappingOption{
    /**
     * 构造一个新的SnappingOption对象
     * 
     * @memberof SnappingOption
     * @returns {Promise<SnappingOption>}
     */
    async createObj(){
        try {
            var {SnappingOptionId} = await SO.createObj();
            var snappingOption = new SnappingOption();
            snappingOption._MGSnappingOptionId = SnappingOptionId;
            return snappingOption;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 获取容差（像素单位）
     * @memberof SnappingOption
     * @returns {Number} 容差 （int类型的Number）
     */
    async getPixelsTolerance(){
        try {
            let result = await SO.getPixelsTolerance(this._MGSnappingOptionId);
            return result;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 设置容差（像素单位）
     * @memberof SnappingOption
     * @param {Number} pixelsTolerance 容差 （int类型的Number）
     * @returns {Promise<Void>}
     */
    async setPixelsTolerance(pixelsTolerance){
        try {
            await SO.setPixelsTolerance(this._MGSnappingOptionId, pixelsTolerance);
            
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 获取是否自动捕捉顶点
     * @memberof SnappingOption
     * @returns {boolean} 是否自动捕捉顶点
     */
    async isSnappingVertex(){
        try {
            let result = await SO.isSnappingVertex(this._MGSnappingOptionId);
            return result;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 设置是否自动捕捉顶点
     * @memberof SnappingOption
     * @param {boolean} isSnappingVertex 是否自动捕捉顶点
     * @returns {Promise<Void>}
     */
    async setSnappingVertex(isSnappingVertex){
        try {
            await SO.setSnappingVertex(this._MGSnappingOptionId, isSnappingVertex);
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 获取是否自动捕捉中点
     * @memberof SnappingOption
     * @returns {boolean}
     */
    async isSnappingMidVertex(){
        try {
            let result = await SO.isSnappingMidVertex(this._MGSnappingOptionId);
            return result;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 设置是否自动捕捉中点
     * @memberof SnappingOption
     * @param {boolean} isSnappingMidVertex
     * @returns {Promise<Void>} 
     */
    async setSnappingMidVertex(isSnappingMidVertex){
        try {
            await SO.setSnappingMidVertex(this._MGSnappingOptionId, isSnappingMidVertex);
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 获取是否自动捕捉垂点
     * @memberof SnappingOption
     * @returns {boolean}
     */
    async isSnappingPedal(){
        try {
            let result = await SO.isSnappingPedal(this._MGSnappingOptionId);
            return result;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 设置是否自动捕捉垂点
     * @memberof SnappingOption
     * @param {boolean} isSnappingPedal 是否自动捕捉垂点
     * @returns {Promise<Void>}
     */
    async setSnappingPedal(isSnappingPedal){
        try {
            await SO.setSnappingPedal(this._MGSnappingOptionId, isSnappingPedal);
            
        } catch (e) {
            console.error(e);
        }
    }


    /**
     * 获取是否自动捕捉普通交点
     * @memberof SnappingOption
     * @returns {boolean}
     */
    async isSnappingNormalIntersection(){
        try {
            let result = await SO.isSnappingNormalIntersection(this._MGSnappingOptionId);
            return result;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 设置是否自动捕捉普通交点
     * @memberof SnappingOption
     * @param {boolean} isSnappingNormalIntersection 是否自动捕捉普通交点
     * @returns {Promise<Void>} 
     */
    async setSnappingNormalIntersection(isSnappingNormalIntersection){
        try {
            await SO.setSnappingNormalIntersection(this._MGSnappingOptionId, isSnappingNormalIntersection);
            
        } catch (e) {
            console.error(e);
        }
    }

    /**
     *  获取是否自动捕捉水平交点
     * @memberof SnappingOption
     * @returns {boolean}
     */
    async isSnappingHorizontalIntersection(){
        try {
            let result = await SO.isSnappingHorizontalIntersection(this._MGSnappingOptionId);
            return result;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 设置是否自动捕捉水平交点
     * @memberof SnappingOption
     * @param {boolean} isSnappingHorizontalIntersection 是否自动捕捉水平交点
     * @returns {Promise<Void>}
     */
    async setSnappingHorizontalIntersection(isSnappingHorizontalIntersection){
        try {
            await SO.setSnappingHorizontalIntersection(this._MGSnappingOptionId, isSnappingHorizontalIntersection);
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 获取是否自动捕捉垂直交点
     * @memberof SnappingOption
     * @returns {boolean} 
     */
    async isSnappingVerticalIntersection(){
        try {
            let result = await SO.isSnappingVerticalIntersection(this._MGSnappingOptionId);
            return result;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 设置是否自动捕捉垂直交点
     * @memberof SnappingOption
     * @param {boolean} isSnappingVerticalIntersection 是否自动捕捉垂直交点
     * @returns {Promise<Void>}
     */
    async setSnappingVerticalIntersection(isSnappingVerticalIntersection){
        try {
            await SO.setSnappingVerticalIntersection(this._MGSnappingOptionId, isSnappingVerticalIntersection);
        } catch (e) {
            console.error(e);
        }
    }
}