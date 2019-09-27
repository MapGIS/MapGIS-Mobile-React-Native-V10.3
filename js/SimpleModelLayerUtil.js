/*
 * @Description: In User Settings Edit
 * @Author: xiaoying
 * @Date: 2019-09-10 09:21:36
 * @LastEditTime: 2019-09-16 19:07:01
 * @LastEditors: Please set LastEditors
 */
import { NativeModules } from "react-native";
let SmlUtils = NativeModules.JSSimpleModelLayerUtil;

/**
 * @class SimpleModelLayerUtil
 * @description 简单模型图层工具类
 */
export default class SimpleModelLayerUtil{
    
    /**
     * 创建模型存储文件，然后通过该存储文件构建SimpleModelLayer，可往其中添加模型
     * 
     * @memberof SimpleModelLayerUtil
     * @param {String} strURL 型存储文件
     * @returns {boolean} true-成功 ；false-失败
     */
    static async createModelStorageFileIfNotExists(strURL){
        try {
            let result =  await SmlUtils.createModelStorageFileIfNotExists(strURL);
            return result;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     *  添加模型，返回Id
     * 
     * @memberof SimpleModelLayerUtil
     * @param {Object} simpleModelLayer  模型层 （SimpleModelLayer类型的Object）
     * @param {Object} model 要添加的模型  （Model类型的Object）
     * @returns {Number} 返回Id （int类型的Number）
    */
    static async addModel(simpleModelLayer, model){
        try {
            let id = await SmlUtils.addModel(simpleModelLayer._MGSimpleModelLayerId, model._MGModelId);
            return id;
        } catch (e) {
            console.error(e);
        }
    }

     /**
     *  更新模型
     * 
     * @memberof SimpleModelLayerUtil
     * @param {Object} simpleModelLayer  模型层 （SimpleModelLayer类型的Object）
     * @param {Number} id 模型ID （int类型的Number）
     * @param {Object} model 要更新的模型  （Model类型的Object）
     * @returns {Number} 成功标志 （int类型的Number）
    */
    static async updateModel(simpleModelLayer, id, model){
        try {
            let result = await SmlUtils.updateModel(simpleModelLayer._MGSimpleModelLayerId, id, model._MGModelId);
            return result;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     *  删除模型
     * 
     * @memberof SimpleModelLayerUtil
     * @param {Object} simpleModelLayer  模型层 （SimpleModelLayer类型的Object）
     * @param {Number} id 模型ID （int类型的Number）
     * @returns {Number} 成功标志（int类型的Number）
    */
    static async removeModel(simpleModelLayer, id){
        try {
            let result = await SmlUtils.removeModel(simpleModelLayer._MGSimpleModelLayerId, id);
            return result;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     *  清空数据
     * 
     * @memberof SimpleModelLayerUtil
     * @param {Object} simpleModelLayer  模型层 （SimpleModelLayer类型的Object）
     * @returns {Number} 成功标志 （int类型的Number）
     */
    static async clearModels(simpleModelLayer){
        try {
            let result = await SmlUtils.clearModels(simpleModelLayer._MGSimpleModelLayerId);
            return result;
        } catch (e) {
            console.error(e);
        }
    }
}
