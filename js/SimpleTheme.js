/*
 * @Description: In User Settings Edit
 * @Author: xiaoying
 * @Date: 2019-09-03 19:52:38
 * @LastEditTime: 2019-09-09 15:16:02
 * @LastEditors: Please set LastEditors
 */

import {NativeModules} from "react-native";
import ThemeInfo from "./ThemeInfo.js";
import VectorTheme from "./VectorTheme.js";
let ST = NativeModules.JSSimpleTheme;

/**
 * @class SimpleTheme
 * @description 简单专题图
 */
export default class SimpleTheme extends VectorTheme{
    constructor(){
        super();
        Object.defineProperty(this, "_MGSimpleThemeId",{
            get:function(){
                return this._MGVectorThemeId;
            },
            set:function(_MGSimpleThemeId){
                this._MGVectorThemeId = _MGSimpleThemeId;
            }
        })
    }

    /**
     * 创建一个新的SimpleTheme对象
     * 
     * @memberof SimpleTheme
     * @returns {Promise<SimpleTheme>}
     */
    async createObj(){
        try {
            var {SimpleThemeId} = await ST.createObj();
            var simpleTheme = new SimpleTheme();
            simpleTheme._MGSimpleThemeId = SimpleThemeId;
            return simpleTheme;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 获取统一专题图的绘制信息
     * 
     * @memberof SimpleTheme
     * @returns {Promise<ThemeInfo>}
     */
    async getThemeInfo(){
        try {
            var {ThemeInfoId} = await ST.getThemeInfo(this._MGSimpleThemeId);
            var themeInfo = null;
            if(ThemeInfoId != null){
                themeInfo = new ThemeInfo();
                themeInfo._MGThemeInfoId = ThemeInfoId;
            }
            return themeInfo;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 设置统一专题图的绘制信息
     * 
     * @memberof SimpleTheme
     * @param {Object} themeInfo 统一专题图的绘制信息
     * @returns {Promise<Void>}
     */
    async setThemeInfo(themeInfo){
        try {
            await ST.setThemeInfo(this._MGSimpleThemeId, themeInfo._MGThemeInfoId);
        } catch (e) {
            console.error(e);
        }
    }
}
