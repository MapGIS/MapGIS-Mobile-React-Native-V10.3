/*
 * @Description: In User Settings Edit
 * @Author: xiaoying
 * @Date: 2019-09-02 16:44:04
 * @LastEditTime: 2019-09-02 17:31:47
 * @LastEditors: Please set LastEditors
 */
import {NativeModules} from "react-native";
let LI = NativeModules.JSLabelInfo;

/**
 * @class LabelInfo
 * @description 标注对象
 */
export default class LabelInfo{
    
    /**
     * 构造一个新的LabelInfo对象
     * 
     * @memberof LabelInfo
     * @returns {Promise<LabelInfo>}
     */
    async createObj(){
        try {
            var {LabelInfoId} = await LI.createObj();
            var labelInfo = new LabelInfo();
            labelInfo._MGLabelInfoId = LabelInfoId;
            return labelInfo;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 获取名称
     * 
     * @memberof LabelInfo
     * @returns {String} 名称
     */
    async getCaption(){
        try {
            let caption = await LI.getCaption(this._MGLabelInfoId);
            return caption;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 设置名称
     * 
     * @memberof LabelInfo
     * @param {String} caption 名称
     * @returns {Promise<Void>}
     */
    async setCaption(caption){
        try {
            await LI.setCaption(this._MGLabelInfoId, caption);
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 获取是否可见
     * 
     * @memberof LabelInfo
     * @returns {boolean} 
     */
    async getIsVisible(){
        try {
            let isVisible = await LI.getIsVisible(this._MGLabelInfoId);
            return isVisible;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 设置是否可见
     * 
     * @memberof LabelInfo
     * @param {boolean} isVisible 
     * @returns {Promise<Void>}
     */
    async setIsVisible(isVisible){
        try {
            await LI.setIsVisible(this._MGLabelInfoId, isVisible);
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 获取最小显示比
     * 
     * @memberof LabelInfo
     * @returns {double} 
     */
    async getMinScale(){
        try {
            let minScale = await LI.getMinScale(this._MGLabelInfoId);
            return minScale;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 设置最小显示比
     * 
     * @memberof LabelInfo
     * @param {double} minScale 
     * @returns {Promise<Void>}
     */
    async setMinScale(minScale){
        try {
            await LI.setMinScale(this._MGLabelInfoId, minScale);
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 获取最大显示比
     * 
     * @memberof LabelInfo
     * @returns {double} 
     */
    async getMaxScale(){
        try {
            let maxScale = await LI.getMaxScale(this._MGLabelInfoId);
            return maxScale;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 设置最大显示比
     * 
     * @memberof LabelInfo
     * @param {double} maxScale 
     * @returns {Promise<Void>}
     */
    async setMaxScale(maxScale){
        try {
            await LI.setMaxScale(this._MGLabelInfoId, maxScale);
        } catch (e) {
            console.error(e);
        }
    }


    /**
     * 获取注记信息
     * 
     * @memberof LabelInfo
     * @returns {Object} 注记信息(TextAnnInfo)
     */
    async getAnnInfo(){
        try {
            
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 设置注记信息
     * 
     * @memberof LabelInfo
     * @param {Object} textAnnInfo 注记信息 
     * @returns {Promise<Void>}
     */
    async setAnnInfo(textAnnInfo){
        try {
            
        } catch (e) {
            console.error(e);
        }
    }


}
