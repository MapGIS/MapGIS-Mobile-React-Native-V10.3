/*
 * @Description: In User Settings Edit
 * @Author: xiaoying
 * @Date: 2019-09-04 16:02:23
 * @LastEditTime: 2019-09-04 16:25:15
 * @LastEditors: Please set LastEditors
 */
import {NativeModules} from "react-native";
import Theme from "./Theme";
let TS = NativeModules.JSThemes;

/**
 * @class Themes
 * @description 专题图集合
 */
export default class Themes{
    
    /**
     * 创建一个新的Themes对象
     * 
     * @memberof Themes
     * @returns {Promise<Themes>}
     */
    async createObj(){
        try {
            var {ThemesId} = await TS.createObj();
            var themes = new Themes();
            themes._MGThemesId = ThemesId;
            return themes;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 获得专题图个数
     * 
     * @memberof Themes
     * @returns {int} 专题图个数
     */
    async getCount(){
        try {
            let count = await TS.getCount(this._MGThemesId);
            return count;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 获得可见的单值或统计专题图
     * 
     * @memberof Themes
     * @returns {Promise<Theme>}
     */
    async getVisibleBaseTheme(){
        try {
            try {
                var {ThemeId} = await TS.getVisibleBaseTheme(this._MGThemesId);
                var theme = null;
                if(ThemeId != null){
                    theme = new Theme();
                    theme._MGThemeId = ThemeId;
                }
                return theme;
            } catch (e) {
                console.error(e);
            }
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 获得可见的专题图
     * 
     * @memberof Themes
     * @returns {Promise<Theme>}
     */
    async getVisibleSurfaceTheme(){
        try {
            try {
                var {ThemeId} = await TS.getVisibleSurfaceTheme(this._MGThemesId);
                var theme = null;
                if(ThemeId != null){
                  theme = new Theme();
                  theme._MGThemeId = ThemeId;
                }
                return theme;
            } catch (e) {
                console.error(e);
            }
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 向集合中添加专题图
     * 
     * @memberof Themes
     * @param {Object} theme 专题图 (Object--Theme)
     * @returns {boolean} true-成功 ；false-失败
     */
    async append(theme){
        try {
            let result = await TS.append(this._MGThemesId, theme._MGThemeId);
            return result;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 移除指定位置处的专题图
     * 
     * @memberof Themes
     * @param {int} index 专题图位置
     * @returns {boolean} true-成功 ；false-失败
     */
    async remove(index){
        try {
            let result = await TS.remove(this._MGThemesId, index);
            return result;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 清空集合中所有的专题图
     * 
     * @memberof Themes
     * @returns {boolean} true-成功 ；false-失败
     */
    async clear(){
        try {
            let result = await TS.clear(this._MGThemesId);
            return result;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 获得指定位置的专题图
     * 
     * @memberof Themes
     * @param {int} index 专题图索引
     * @returns {Promise<Theme>} 成功返回指定位置的专题图
     */
    async getThemeByIndex(index){
        try {
            var {ThemeId} = await TS.getThemeByIndex(this._MGThemesId, index);
            var theme = null;
            if(ThemeId != null){
                theme = new Theme();
                theme._MGThemeId = ThemeId;
            }
            return theme;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 根据名称和索引获得专题图
     * 
     * @memberof Themes
     * @param {String} name 专题图名称
     * @param {int} index 专题图索引
     * @returns {Promise<Theme>} 成功返回指定位置的专题图
     */
    async getThemeByName(name, index){
        try {
            var {ThemeId} = await TS.getThemeByName(this._MGThemesId, name, index);
            var theme = null;
            if(ThemeId != null){
                theme = new Theme();
                theme._MGThemeId = ThemeId;
            }
            return theme;
        } catch (e) {
            console.error(e);
        }
    }
}