/*
 * @Description: In User Settings Edit
 * @Author: xiaoying
 * @Date: 2019-09-04 14:45:37
 * @LastEditTime: 2019-09-09 16:03:10
 * @LastEditors: Please set LastEditors
 */
import {NativeModules} from "react-native";
import Theme from "./Theme";
let VT = NativeModules.JSVectorTheme;

/**
 * @class VectorTheme
 * @description 矢量专题图
 */
export default class VectorTheme extends Theme{
    constructor(){
        super();
        Object.defineProperty(this, "_MGVectorThemeId", {
            get:function(){
                return this._MGThemeId;
            },
            set:function(_MGVectorThemeId){
                this._MGThemeId = _MGVectorThemeId;
            }
        })
    }
    
    /**
     * 获取专题图类型
     * 
     * @memberof VectorTheme
     * @returns {int} 专题图类型，例 1-ThemeType.SimpleTheme
     */
    async getType(){
        try {
            let themeType = await VT.getType(this._MGVectorThemeId);
            return themeType;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 专题图可见性
     * 
     * @memberof VectorTheme
     * @returns {boolean}
     */
    async getVisible(){
        try {
            let result = await VT.getVisible(this._MGVectorThemeId);
            return result;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 设置专题图可见性
     * @memberof VectorTheme
     * @param {boolean} isVisible 专题图是否可见
     * @returns {int}  1-成功 ；0-失败
     */
    async setVisible(isVisible){
        try {
            let result = await VT.setVisible(this._MGVectorThemeId, isVisible);
            return result;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 获取专题图名称
     * 
     * @memberof VectorTheme
     * @returns {String} 专题图名称
     */
    async getName(){
        try {
            let name = await VT.getName(this._MGVectorThemeId);
            return name;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 设置专题图名称
     * @memberof VectorTheme
     * @param {String} name 专题图名称 
     * @returns {int} 1-成功 ；0-失败
     */
    async setName(name){
        try {
            let result = await VT.setName(this._MGVectorThemeId, name);
            return result;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 是否是单值或者分段专题图
     * 
     * @memberof VectorTheme
     * @returns {boolean}
     */
    async getIsBaseTheme(){
        try {
            let result = await VT.getIsBaseTheme(this._MGVectorThemeId);
            return result;
        } catch (e) {
            console.error(e);
        }
    }

    
    /**
     * 存为XML
     * 
     * @memberof VectorTheme
     * @param {boolean} onlyStyle 支持仅导出样式
     * @returns {String} XML字符串
     */
    async toXML(onlyStyle){
        try {
            let xml = await VT.toXML(this._MGVectorThemeId, onlyStyle);
            return xml;
        } catch (e) {
            console.error(e);
        }
    }

    
    /**
     * 从XML导入
     * 
     * @memberof VectorTheme
     * @param {String} strXML XML字符串
     * @param {boolean} onlyStyle 支持仅导出样式
     * @returns {boolean} 成功/失败 true/false
     */
    async fromXML(strXML, onlyStyle){
        try {
            let result = await VT.fromXML(this._MGVectorThemeId, strXML, onlyStyle);
            return result;
        } catch (e) {
            console.error(e);
        }
    }
}