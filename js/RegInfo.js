/**
 * @content 线图形信息功能组件
 * @author  2019-09-12 
 */
import { NativeModules } from "react-native";

let RI = NativeModules.JSRegInfo;

import GeomInfo from "./GeomInfo.js"

/**
 * @class RegInfo
 */
export default class RegInfo extends GeomInfo {
    constructor(){
        super()
        Object.defineProperty(this,"_MGRegInfoId", {
            get:function(){
                return this._MGGeomInfoId
            },
            set:function(_MGRegInfoId){
                this._MGGeomInfoId = _MGRegInfoId
            },
        })
    }
    
    /**
	 * 构造一个新的 RegInfo 对象
	 * @memberOf RegInfo
	 * @return {Promise<RegInfo>}
	 */
    async createObj(){
        try{
            var {RegInfoId} = await RI.createObj()
            var regInfo = new RegInfo()
            regInfo._MGRegInfoId = RegInfoId
            return regInfo
        } catch(e) {
            console.error(e)
        }
    }

    /**
	 * 获取库编号
	 * @memberOf RegInfo
	 * @return {Promise}库编号
	 */
	async getLibID()
	{
		try {
            return await RI.getLibID(this._MGRegInfoId);
        } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 设置库编号
	 * @memberOf RegInfo
	 * @param newVal 库编号
	 * @return {Promise<void>}
	 */
	async setLibID(newVal)
	{
		try {
            await RI.setLibID(this._MGRegInfoId, newVal);
        } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 获取覆盖方式
	 * @memberOf RegInfo
	 * @return {Promise}覆盖方式
	 */
	async getOvprnt()
	{
		try {
            return await RI.getOvprnt(this._MGRegInfoId);
        } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 获取符号编号
	 * @memberOf RegInfo
	 * @return {Promise}符号编号
	 */
	async getPatID()
	{
		try {
            return await RI.getPatID(this._MGRegInfoId);
        } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 设置符号编号
	 * @memberOf RegInfo
	 * @param newVal 符号编号
	 * @return {Promise<void>}
	 */
	async setPatID(newVal)
	{
		try {
            await RI.setPatID(this._MGRegInfoId, newVal);
        } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 获取填充模式
	 * @memberOf RegInfo
	 * @return {Promise}填充模式
	 */
	async getFillMode()
	{
		try {
            return await RI.getFillMode(this._MGRegInfoId);
        } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 设置填充模式
	 * @memberOf RegInfo
	 * @param newVal 填充模式
	 * @return {Promise<void>}
	 */
	async setFillMode(newVal)
	{
		try {
            await RI.setFillMode(this._MGRegInfoId, newVal);
        } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 获取区域填充色
	 * @memberOf RegInfo
	 * @return {Promise}区域填充色
	 */
	async getFillClr()
	{
		try {
            return await RI.getFillClr(this._MGRegInfoId);
        } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 设置区域填充色
	 * @memberOf RegInfo
	 * @param newVal 区域填充色
	 * @return {Promise<void>}
	 */
	async setFillClr(newVal)
	{
		try {
            await RI.setFillClr(this._MGRegInfoId, newVal);
        } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 获取结束填充色
	 * @memberOf RegInfo
	 * @return {Promise}结束填充色
	 */
	async getEndClr()
	{
		try {
            return await RI.getEndClr(this._MGRegInfoId);
        } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 设置结束填充色
	 * @memberOf RegInfo
	 * @param newVal 结束填充色
	 * @return {Promise<void>}
	 */
	async setEndClr(newVal)
	{
		try {
            await RI.setEndClr(this._MGRegInfoId, newVal);
        } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 获取图案高
	 * @memberOf RegInfo
	 * @return {Promise}图案高
	 */
	async getPatHeight()
	{
		try {
            return await RI.getPatHeight(this._MGRegInfoId);
        } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 设置图案高
	 * @memberOf RegInfo
	 * @param newVal 图案高
	 * @return {Promise<void>}
	 */
	async setPatHeight(newVal)
	{
		try {
            await RI.setPatHeight(this._MGRegInfoId, newVal);
        } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 获取图案宽
	 * @memberOf RegInfo
	 * @return {Promise}图案宽
	 */
	async getPatWidth()
	{
		try {
            return await RI.getPatWidth(this._MGRegInfoId);
        } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 设置图案宽
	 * @memberOf RegInfo
	 * @param newVal 图案宽
	 * @return {Promise<void>}
	 */
	async setPatWidth(newVal)
	{
		try {
            await RI.setPatWidth(this._MGRegInfoId, newVal);
        } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 获取图案角度
	 * @memberOf RegInfo
	 * @return {Promise}图案角度
	 */
	async getAngle()
	{
		try {
            return await RI.getAngle(this._MGRegInfoId);
        } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 设置图案角度
	 * @memberOf RegInfo
	 * @param newVal 图案角度
	 * @return {Promise<void>}
	 */
	async setAngle(newVal)
	{
		try {
            await RI.setAngle(this._MGRegInfoId, newVal);
        } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 获取图案颜色
	 * @memberOf RegInfo
	 * @return {Promise}图案颜色
	 */
	async getPatClr()
	{
		try {
            return await RI.getPatClr(this._MGRegInfoId);
        } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 设置图案颜色
	 * @memberOf RegInfo
	 * @param newVal 图案颜色
	 * @return {Promise<void>}
	 */
	async setPatClr(newVal)
	{
		try {
            await RI.setPatClr(this._MGRegInfoId, newVal);
        } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 获取图案笔宽
	 * @memberOf RegInfo
	 * @return {Promise}图案笔宽
	 */
	async getOutPenW()
	{
		try {
            return await RI.getOutPenW(this._MGRegInfoId);
        } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 设置图案笔宽
	 * @memberOf RegInfo
	 * @param newVal 图案笔宽
	 * @returns {Promise<void>}
	 */
	async setOutPenW(newVal)
	{
		try {
            await RI.setOutPenW(this._MGRegInfoId, newVal);
        } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 获取是否需要完整图案填充
	 * @memberOf RegInfo
	 * @return {Promise}是否需要完整图案填充
	 */
	async getFullPatFlg()
	{
		try {
            return await RI.getFullPatFlg(this._MGRegInfoId);
        } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 设置是否需要完整图案填充
	 * @memberOf RegInfo
	 * @param newVal 是否需要完整图案填充
	 * @returns {Promise<void>}
	 */
	async setFullPatFlg(newVal)
	{
		try {
            await RI.setFullPatFlg(this._MGRegInfoId, newVal);
        } catch (e) {
            console.error(e);
        }
	}
	
	/**
	 * 设获取几何类型
	 * @memberOf RegInfo
	 * @return {Promise} 几何类型
	 */
	async getGeomType() {
		try {
            return await RI.getGeomType(this._MGRegInfoId);
        } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 设置是否需要完整图案填充
	 * @memberOf RegInfo
	 * @param newVal 是否需要完整图案填充
	 * @return {Promise<void>}
	 */
	async setOvprnt(newVal) {
		try {
            await RI.setOvprnt(this._MGRegInfoId, newVal);
        } catch (e) {
            console.error(e);
        }		
	}

	/**
	 * 克隆几何图形信息
	 * @memberOf RegInfo
	 * @return {Promise<GeomInfo>} 几何图形信息
	 */
	async Clone() {
		try {
            let {geomInfoId} = await RI.Clone(this._MGPntInfoId);
            var geomInfo = new GeomInfo()
            geomInfo._MGGeomInfoId = geomInfoId;
            return geomInfo;
        } catch (e) {
            console.error(e);
        }
	}
}