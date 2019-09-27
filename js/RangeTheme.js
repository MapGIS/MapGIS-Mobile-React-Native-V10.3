/*
 * @Description: In User Settings Edit
 * @Author: xiaoying
 * @Date: 2019-09-03 16:44:08
 * @LastEditTime: 2019-09-23 10:21:17
 * @LastEditors: Please set LastEditors
 */
import {NativeModules} from "react-native";
import ThemeInfo from "./ThemeInfo.js";
import RangeThemeInfo from "./RangeThemeInfo.js";
import VectorTheme from "./VectorTheme.js";
let RT = NativeModules.JSRangeTheme;

/**
 * @class RangeTheme
 * @description 范围专题图
 */
export default class RangeTheme extends VectorTheme{
    constructor(){
        super();
        Object.defineProperty(this, "_MGRangeThemeId",{
            get:function(){
                return this._MGVectorThemeId;
            },
            set:function(_MGRangeThemeId){
                this._MGVectorThemeId = _MGRangeThemeId;
            }
        })
    }

    /**
     * 创建一个新的RangeTheme对象
     * 
     * @memberof RangeTheme
     * @returns {Promise<RangeTheme>}
     */
    async createObj(){
        try {
            var {RangeThemeId} = await RT.createObj();
            var rangeTheme = new RangeTheme();
            rangeTheme._MGRangeThemeId = RangeThemeId;
            return rangeTheme;
        } catch (e) {
            console.error(e);
        }
    }
    
    /**
     * 获取缺省专题绘制信息
     * 
     * @memberof RangeTheme
     * @returns {Promise<ThemeInfo>} 缺省专题绘制信息
     */
    async getDefaultInfo(){
        try {
            var {ThemeInfoId} = await RT.getDefaultInfo(this._MGRangeThemeId);
            var themeInfo = null;
            if(ThemeInfoId != null){
                themeInfo = new ThemeInfo()
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
     * @memberof RangeTheme
     * @param {Object} themeInfo 专题绘制信息
     * @returns {Promise<Void>} 
     */
    async setDefaultInfo(themeInfo){
        try {
           await RT.setDefaultInfo(this._MGRangeThemeId, themeInfo._MGThemeInfoId);
        } catch (e) {
            console.error(e);
        }
    }


    /**
     * 获取字段表达式
     * 
     * @memberof RangeTheme
     * @returns {String} 
     */
    async getExpression(){
        try {
           let expression = await RT.getExpression(this._MGRangeThemeId);
           return expression;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 设置字段表达式
     * 
     * @memberof RangeTheme
     * @param {String} expression 字段表达式
     * @returns {Promise<Void>} 
     */
    async setExpression(expression){
        try {
           await RT.setExpression(this._MGRangeThemeId, expression);
        } catch (e) {
            console.error(e);
        }
    }

     /**
     * 获取项数目
     * 
     * @memberof RangeTheme
     * @returns {int} 
     */
    async getCount(){
        try {
           let count = await RT.getCount(this._MGRangeThemeId);
           return count;
        } catch (e) {
            console.error(e);
        }
    }

     /**
     * 获取专题图类型
     * 
     * @memberof RangeTheme
     * @returns {int} 返回专题图类型，例：AllOtherDataItemInfoSource.DefaultThemeInfo
     */
    async getAllOtherDataItemInfoSource(){
        try {
           let allOtherDataItemInfoSource = await RT.getAllOtherDataItemInfoSource(this._MGRangeThemeId);
           return allOtherDataItemInfoSource;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 设置专题图类型
     * 
     * @memberof RangeTheme
     * @param {int} allOtherDataItemInfoSource 专题图类型 例：AllOtherDataItemInfoSource.DefaultThemeInfo
     * @returns {Promise<Void>} 
     */
    async setAllOtherDataItemInfoSource(allOtherDataItemInfoSource){
        try {
           await RT.setAllOtherDataItemInfoSource(this._MGRangeThemeId, allOtherDataItemInfoSource);
        } catch (e) {
            console.error(e);
        }
    }

     /**
     * 添加项
     * 
     * @memberof RangeTheme
     * @param {Object} rangeThemeInfo 范围专题图项信息
     * @returns {int}                 成功返回项索引
     */
    async append(rangeThemeInfo){
        try {
           let index = await RT.append(this._MGRangeThemeId, rangeThemeInfo._MGRangeThemeInfoId);
           return index;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 删除项（删除之后的语义是图元用未分类字段的颜色）
     * 
     * @memberof RangeTheme
     * @param {int} index  范围专题图项索引
     * @returns {boolean}  true-成功 ；false-失败
     */
    async remove(index){
        try {
           let result = await RT.remove(this._MGRangeThemeId, index);
           return result;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 寻找值为value的项索引
     * 
     * @memberof RangeTheme
     * @param {String} value  属性值
     * @returns {int}         成功返回包含此值的项索引
     */
    async indexOf(value){
        try {
           let index = await RT.indexOf(this._MGRangeThemeId, value);
           return index;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 清空所有的项
     * 
     * @memberof RangeTheme
     * @returns {boolean}   true-成功 ；false-失败
     */
    async clear(){
        try {
           let result = await RT.clear(this._MGRangeThemeId);
           return result;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 设置项信息
     *
     * @memberof RangeTheme
     * @param {Number} index   范围专题图项索引（int类型的Number）
     * @param {Object) rangeThemeInfo   范围专题图项信息
     * @returns {boolean}   true-成功 ；false-失败
     */
    async setItem(index, rangeThemeInfo){
        try {
           let result = await RT.setItem(this._MGRangeThemeId, index, rangeThemeInfo._MGRangeThemeInfoId);
           return result;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 获取项信息
     *
     * @memberof RangeTheme
     * @param {Number} index                范围专题图项索引（int类型的Number）
     * @returns {Promise<RangeThemeInfo>}   成功返回项的信息
     */
    async getItem(index){
        try {
           var {RangeThemeInfoId} = await RT.getItem(this._MGRangeThemeId, index);
           var rangeThemeInfo = null;
           if(RangeThemeInfoId != null){
               rangeThemeInfo = new RangeThemeInfo();
               rangeThemeInfo._MGRangeThemeInfoId = RangeThemeInfoId;
           }

           return rangeThemeInfo;
        } catch (e) {
            console.error(e);
        }
    }

    // /**
    //  * 合并项,从index开始count个项合并
    //  * 
    //  * @memberof RangeTheme
    //  * @param {int} index        合并项开始位置
    //  * @param {int} count        合并项的数目
    //  * @param {Object} geomInfo  合并后的图形信息
    //  * @param {String} caption   合并后的标题
    //  * @returns {boolean}        true-成功 ； false-失败 
    //  */
    // async merge(index, count, geomInfo, caption){
    //     try {
    //         let result = await RT.merge(this._MGRangeThemeId, index, count, geomInfo._MGGeomInfoId, caption);
    //         return result;
    //     } catch (e) {
    //         console.error(e);
    //     }
    // }

    // /**
    //  * 拆分项（拆分为2个项）
    //  * 
    //  * @memberof RangeTheme
    //  * @param {int} index          拆分项开始位置
    //  * @param {double} splitValue  拆分值
    //  * @param {Object} geomInfo1   拆分后的图形信息1
    //  * @param {String} caption1    拆分后的标题1
    //  * @param {Object} geomInfo2   拆分后的图形信息2
    //  * @param {String} caption2    拆分后的标题2
    //  * @returns {boolean}          true-成功 ； false-失败
    //  */
    // async split(index, splitValue, geomInfo1, caption1, geomInfo2, caption2){
    //     try {
    //         let result = await RT.split(this._MGRangeThemeId, index, splitValue, geomInfo1._MGGeomInfoId, caption1, geomInfo2._MGGeomInfoId, caption2);
    //         return result;
            
    //     } catch (e) {
    //         console.error(e);
    //     }
    // }
}