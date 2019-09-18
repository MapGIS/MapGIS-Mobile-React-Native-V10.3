/*
 * @Description: In User Settings Edit
 * @Author: xiaoying
 * @Date: 2019-09-03 14:26:49
 * @LastEditTime: 2019-09-03 16:50:17
 * @LastEditors: Please set LastEditors
 */
import {NativeModules} from "react-native";
let TI = NativeModules.JSThemeInfo;

/**
 * @class ThemeInfo
 * @description 专题绘制信息
 */
export default class ThemeInfo{
    
    /**
     * 构造一个新的ThemeInfo对象
     * 
     * @class ThemeInfo
     * @returns {Promise<ThemeInfo>}
     */
    async createObj(){
        try {
            var {ThemeInfoId} = await TI.createObj();
            var themeInfo = new ThemeInfo();
            themeInfo._MGThemeInfoId = ThemeInfoId;
            return themeInfo;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 获取标题
     * 
     * @memberof ThemeInfo
     * @returns {String} 标题
     */
    async getCaption(){
        try {
            let caption = await TI.getCaption(this._MGThemeInfoId);
            return caption;
        } catch (e) {
            console.error(e);
        }
    }
    
    /**
     * 设置标题
     * 
     * @memberof ThemeInfo
     * @param {String} caption 标题
     * @returns {Promise<Void>}
     */
    async setCaption(caption){
        try {
            await TI.setCaption(this._MGThemeInfoId, caption);
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 获取是否可见
     * 
     * @memberof ThemeInfo
     * @returns {boolean} 
     */
    async getIsVisible(){
        try {
            let isVisible = await TI.getIsVisible(this._MGThemeInfoId);
            return isVisible;
        } catch (e) {
            console.error(e);
        }
    }
    
    /**
     * 设置是否可见
     * 
     * @memberof ThemeInfo
     * @param {boolean} isVisible 是否可见
     * @returns {Promise<Void>}
     */
    async setIsVisible(isVisible){
        try {
            await TI.setIsVisible(this._MGThemeInfoId, isVisible);
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 获取最小显示比
     * 
     * @memberof ThemeInfo
     * @returns {double} 
     */
    async getMinScale(){
        try {
            let minScale = await TI.getMinScale(this._MGThemeInfoId);
            return minScale;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 设置最小显示比
     * 
     * @memberof ThemeInfo
     * @param {double} minScale 最小显示比
     * @returns {Promise<Void>}
     */
    async setMinScale(minScale){
        try {
            await TI.setMinScale(this._MGThemeInfoId, minScale);
        } catch (e) {
            console.error(e);
        }
    }
    
    /**
     * 获取最大显示比
     * 
     * @memberof ThemeInfo
     * @returns {double} 
     */
    async getMaxScale(){
        try {
            let maxScale = await TI.getMaxScale(this._MGThemeInfoId);
            return maxScale;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 设置最大显示比
     * 
     * @memberof ThemeInfo
     * @param {double} maxScale 最大显示比
     * @returns {Promise<Void>}
     */
    async setMaxScale(maxScale){
        try {
            await TI.setMaxScale(this._MGThemeInfoId, maxScale);
        } catch (e) {
            console.error(e);
        }
    }

    async getGeoInfo(){
        try {
            
        } catch (e) {
            console.error(e);
        }
    }

    async setGeoInfo(geomInfo){
        try {
            
        } catch (e) {
            console.error(e);
        }
    }


}