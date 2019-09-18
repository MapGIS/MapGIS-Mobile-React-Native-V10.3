/*
 * @Description: In User Settings Edit
 * @Author: xiaoying
 * @Date: 2019-09-04 11:33:00
 * @LastEditTime: 2019-09-09 15:15:31
 * @LastEditors: Please set LastEditors
 */
import {NativeModules} from "react-native";
import ThemeInfo from "./ThemeInfo.js";
import UniqueThemeInfo from "./UniqueThemeInfo.js";
import VectorTheme from "./VectorTheme.js";
let UT = NativeModules.JSUniqueTheme;

/**
 * @class UniqueTheme
 * @description 唯一值专题图
 */
export default class UniqueTheme extends VectorTheme{
    constructor(){
        super();
        Object.defineProperty(this, "_MGUniqueThemeId",{
            get:function(){
                return this._MGVectorThemeId;
            },
            set:function(_MGUniqueThemeId){
                this._MGVectorThemeId = _MGUniqueThemeId;
            }
        })
    }

    /**
     * 创建一个新的UniqueTheme对象
     * 
     * @memberof UniqueTheme
     * @returns {Promise<UniqueTheme>}
     */
    async createObj(){
        try {
            var {UniqueThemeId} = await UT.createObj();
            var uniqueTheme = new UniqueTheme();
            uniqueTheme._MGUniqueThemeId = UniqueThemeId;
            return uniqueTheme;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 获取缺省专题绘制信息
     * 
     * @memberof UniqueTheme
     * @returns {Object} 专题绘制信息 (Object---ThemeInfo)
     */
    async getDefaultInfo(){
        try {
            var {ThemeInfoId} = await UT.getDefaultInfo(this._MGUniqueThemeId);
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
     * 设置缺省专题绘制信息
     * 
     * @memberof UniqueTheme
     * @param {Object} themeInfo 专题绘制信息 (Object---ThemeInfo)
     * @returns {Promise<Void>}
     */
    async setDefaultInfo(themeInfo){
        try {
            await UT.setDefaultInfo(this._MGUniqueThemeId, themeInfo._MGThemeInfoId);
        } catch (e) {
            console.error(e);
        }
    }

     /**
      * 获取唯一字段表达式
      * 
     * @memberof UniqueTheme
     * @returns {String}
     */
    async getExpression(){
        try {
            let expression = await UT.getExpression(this._MGUniqueThemeId);
            return expression;
        } catch (e) {
            console.error(e);
        }
    }

    
    /**
     * 设置唯一字段表达式
     * 
     * @memberof UniqueTheme
     * @param {String} expression 唯一字段表达式
     * @returns {Promise<Void>}
     */
    async setExpression(expression){
        try {
            await UT.setExpression(this._MGUniqueThemeId, expression);
        } catch (e) {
            console.error(e);
        }
    }

     /**
      * 获取单值专题图项数目
      * 
     * @memberof UniqueTheme
     * @returns {int} 单值专题图项数目
     */
    async getCount(){
        try {
            let count = await UT.getCount(this._MGUniqueThemeId);
            return count;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 获取专题图类型
     * 
     * @memberof UniqueTheme
     * @returns {int} 专题图类型 例: 1--AllOtherDataItemInfoSource.DefaultThemeInfo
     */
    async getAllOtherDataItemInfoSource(){
        try {
            let allOtherDataItemInfoSource = await UT.getAllOtherDataItemInfoSource(this._MGUniqueThemeId);
            return allOtherDataItemInfoSource;
        } catch (e) {
            console.error(e);
        }
    }
    
    /**
     * 设置专题图类型
     * 
     * @memberof UniqueTheme
     * @param {int} allOtherDataItemInfoSource 专题图类型 例: 1--AllOtherDataItemInfoSource.DefaultThemeInfo
     * @returns {Promise<Void>}
     */
    async setAllOtherDataItemInfoSource(allOtherDataItemInfoSource){
        try {
            await UT.setAllOtherDataItemInfoSource(this._MGUniqueThemeId, allOtherDataItemInfoSource);
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 添加项
     * 
     * @memberof UniqueTheme
     * @param {Object} uniqueThemeInfo 单值专题图信息 (Object---UniqueThemeInfo)
     * @returns {int} 成功返回添加后专题图项索引
     */
    async append(uniqueThemeInfo){
        try {
            let index = await UT.append(this._MGUniqueThemeId, uniqueThemeInfo._MGUniqueThemeInfoId);
            return index;
        } catch (e) {
            console.error(e);
        }
    }

    
    /**
     * 删除项（删除之后的语义是图元用未分类字段的颜色）
     * 
     * @memberof UniqueTheme
     * @param {int} index 单值专题图项索引
     * @returns {boolean} true-成功 ；false-失败
     */
    async removeByIndex(index){
        try {
            let result = await UT.removeByIndex(this._MGUniqueThemeId, index);
            return result;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 移除值为value的项
     * 
     * @memberof UniqueTheme
     * @param {String} value 单值专题图项的值
     * @returns {boolean} true-成功 ；false-失败
     */
    async removeByValue(value){
        try {
            let result = await UT.removeByValue(this._MGUniqueThemeId, value);
            return result;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 寻找值为value的项索引
     * 
     * @memberof UniqueTheme
     * @param {String} value 单值专题图项的值
     * @returns {int} 成功返回索引
     */
    async indexOf(value){
        try {
            let index = await UT.indexOf(this._MGUniqueThemeId, value);
            return index;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 清空所有的项
     * 
     * @memberof UniqueTheme
     * @returns {boolean} true-成功 ；false-失败
     */
    async clear(){
        try {
            let result = await UT.clear(this._MGUniqueThemeId);
            return result;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 设置项信息
     * 
     * @memberof UniqueTheme
     * @param {int} index 单值专题图项索引
     * @param {Object} uniqueThemeInfo 单值专题图项信息 （Object -- UniqueThemeInfo ）
     * @returns {boolean} true-成功 ；false-失败
     */
    async setItem(index, uniqueThemeInfo){
        try {
            let result = await UT.setItem(this._MGUniqueThemeId, index, uniqueThemeInfo._MGUniqueThemeInfoId);
            return result;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 获取项信息
     * 
     * @memberof UniqueTheme
     * @param {int} index 单值专题图项索引
     * @returns {promise<UniqueThemeInfo>} 成功返回项的信息
     */
    async getItem(index){
        try {
            var {UniqueThemeInfoId} = await UT.getItem(this._MGUniqueThemeId, index);
            var uniqueThemeInfo = null;
            if(UniqueThemeInfoId != null){
                uniqueThemeInfo = new UniqueThemeInfo();
                uniqueThemeInfo._MGUniqueThemeInfoId = UniqueThemeInfoId;
            }
            return uniqueThemeInfo;
        } catch (e) {
            console.error(e);
        }
    }

}