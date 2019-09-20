/**
 * @content 点图形信息功能组件
 * @author  2019-09-09 
 */
import { NativeModules } from "react-native";

let PI = NativeModules.JSPntInfo;

import GeomInfo from "./GeomInfo.js"

/**
 * @class PntInfo
 */
export default class PntInfo extends GeomInfo {
    constructor(){
        super()
        Object.defineProperty(this,"_MGPntInfoId", {
            get:function(){
                return this._MGGeomInfoId
            },
            set:function(_MGPntInfoId){
                this._MGGeomInfoId = _MGPntInfoId
            },
        })
    }
    
    /**
	 * 构造一个新的 PntInfo 对象
	 * @memberOf PntInfo
	 * @return {Promise<PntInfo>}
	 */
    async createObj(){
        try{
            var {PntInfoId} = await PI.createObj()
            var pntInfo = new PntInfo()
            pntInfo._MGPntInfoId = PntInfoId
            return pntInfo
        } catch(e) {
            console.error(e)
        }
    }


    /**
	 * 获取库编号
	 * @memberOf PntInfo
	 * @return {Promise}库编号
	 */
	async getLibID()
	{
		try {
            return await PI.getLibID(this._MGPntInfoId);
        } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 获取覆盖方式
	 * @memberOf PntInfo
	 * @return {Promise}覆盖方式
	 */
	async getOvprnt()
	{
		try {
            return await PI.getOvprnt(this._MGPntInfoId);
        } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 设置覆盖方式
	 * @memberOf PntInfo
	 * @param newVal 覆盖方式
	 * @return {Promise<void>}
	 */
	async setOvprnt(newVal)
	{
		try {
            await PI.setOvprnt(this._MGPntInfoId, newVal);
        } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 获取符号编号
	 * @memberOf PntInfo
	 * @return {Promise}符号编号
	 */
	async getSymID()
	{
		try {
            return await PI.getSymID(this._MGPntInfoId);
        } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 设置符号编号
	 * @memberOf PntInfo
	 * @param newVal 符号编号
	 * @return {Promise<void>}
	 */
	async setSymID(newVal)
	{
		try {
            await PI.setSymID(this._MGPntInfoId, newVal);
        } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 获取高度
	 * @memberOf PntInfo
	 * @return {Promise}高度
	 */
	async getHeight()
	{
		try {
            return await PI.getHeight(this._MGPntInfoId);
        } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 设置高度
	 * @memberOf PntInfo
	 * @param newVal 高度
	 * @return {Promise<void>}
	 */
	async setHeight(newVal)
	{
		try {
            await PI.setHeight(this._MGPntInfoId, newVal);
        } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 获取宽度
	 * @memberOf PntInfo
	 * @return {Promise}宽度
	 */
	async getWidth()
	{
		try {
            return await PI.getWidth(this._MGPntInfoId);
        } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 设置宽度
	 * @memberOf PntInfo
	 * @param newVal 宽度
	 * @return {Promise<void>}
	 */
	async setWidth(newVal)
	{
		try {
            await PI.setWidth(this._MGPntInfoId, newVal);
        } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 获取角度
	 * @memberOf PntInfo
	 * @return {Promise}角度
	 */
	async getAngle()
	{
		try {
            return await PI.getAngle(this._MGPntInfoId);
        } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 设置角度
	 * @memberOf PntInfo
	 * @param newVal 角度
	 * @return {Promise<void>}
	 */
	async setAngle(newVal)
	{
		try {
            await PI.setAngle(this._MGPntInfoId, newVal);
        } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 获取外部笔宽1
	 * @memberOf PntInfo
	 * @return {Promise}外部笔宽1
	 */
	async getOutPenW1()
	{
		try {
            return await PI.getOutPenW1(this._MGPntInfoId);
        } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 设置外部笔宽1
	 * @memberOf PntInfo
	 * @param newVal 外部笔宽1
	 * @return {Promise<void>}
	 */
	async setOutPenW1(newVal)
	{
		try {
            await PI.setOutPenW1(this._MGPntInfoId, newVal);
        } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 获取外部笔宽2
	 * @memberOf PntInfo
	 * @return {Promise}外部笔宽2
	 */
	async getOutPenW2()
	{
		try {
            return await PI.getOutPenW2(this._MGPntInfoId);
        } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 设置外部笔宽2
	 * @memberOf PntInfo
	 * @param newVal 外部笔宽2
	 * @return {Promise<void>}
	 */
	async setOutPenW2(newVal)
	{
		try {
            await PI.setOutPenW2(this._MGPntInfoId, newVal);
        } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 获取外部笔宽3
	 * @memberOf PntInfo
	 * @return {Promise}外部笔宽3
	 */
	async getOutPenW3()
	{
		try {
            return await PI.getOutPenW3(this._MGPntInfoId);
        } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 设置外部笔宽3
	 * @memberOf PntInfo
	 * @param newVal 外部笔宽3
	 * @return {Promise<void>}
	 */
	async setOutPenW3(newVal)
	{
		try {
            await PI.setOutPenW3(this._MGPntInfoId, newVal);
        } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 获取可变颜色1
	 * @memberOf PntInfo
	 * @return {Promise}可变颜色1
	 */
	async getOutClr1()
	{
		try {
            return await PI.getOutClr1(this._MGPntInfoId);
        } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 设置可变颜色1
	 * @memberOf PntInfo
	 * @param newVal 可变颜色1
	 * @return {Promise<void>}
	 */
	async setOutClr1(newVal)
	{
		try {
            await PI.setOutClr1(this._MGPntInfoId, newVal);
        } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 获取可变颜色2
	 * @memberOf PntInfo
	 * @return {Promise}可变颜色2
	 */
	async getOutClr2()
	{
		try {
            return await PI.getOutClr2(this._MGPntInfoId);
        } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 设置可变颜色2
	 * @memberOf PntInfo
	 * @param newVal 可变颜色2
	 * @return {Promise<void>}
	 */
	async setOutClr2(newVal)
	{
		try {
            await PI.setOutClr2(this._MGPntInfoId, newVal);
        } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 获取可变颜色3
	 * @memberOf PntInfo
	 * @return {Promise}可变颜色3
	 */
	async getOutClr3()
	{
		try {
            return await PI.getOutClr3(this._MGPntInfoId);
        } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 设置可变颜色3
	 * @memberOf PntInfo
	 * @param newVal 可变颜色3
	 * @return {Promise<void>}
	 */
	async setOutClr3(newVal)
	{
		try {
            await PI.setOutClr3(this._MGPntInfoId, newVal);
        } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 获取自动压背景颜色标志
	 * @memberOf PntInfo
	 * @return {Promise}自动压背景颜色标志
	 */
	async getFillFlg()
	{
		try {
            return await PI.getFillFlg(this._MGPntInfoId);
        } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 设置自动压背景颜色标志
	 * @memberOf PntInfo
	 * @param newVal 自动压背景颜色标志
	 * @return {Promise<void>}
	 */
	async setFillFlg(newVal)
	{
		try {
            await PI.setFillFlg(this._MGPntInfoId, newVal);
        } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 获取范围扩展
	 * @memberOf PntInfo
	 * @return {Promise}范围扩展
	 */
	async getBackExp()
	{
		try {
            return await PI.getBackExp(this._MGPntInfoId);
        } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 设置范围扩展
	 * @memberOf PntInfo
	 * @param newVal 范围扩展
	 * @return {Promise<void>}
	 */
	async setBackExp(newVal)
	{
		try {
            await PI.setBackExp(this._MGPntInfoId, newVal);
        } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 获取覆盖的背景颜色
	 * @memberOf PntInfo
	 * @return {Promise}覆盖的背景颜色
	 */
	async getBackClr()
	{
		try {
            return await PI.getBackClr(this._MGPntInfoId);
        } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 设置覆盖的背景颜色
	 * @memberOf PntInfo
	 * @param newVal 覆盖的背景颜色
	 * @return {Promise<void>}
	 */
	async setBackClr(newVal)
	{
		try {
            await PI.setBackClr(this._MGPntInfoId, newVal);
        } catch (e) {
            console.error(e);
        }
	}

    /**
	 * 获取几何类型
	 * @memberOf PntInfo
	 * @return {Promise} 几何类型
	 */
	async getGeomType() {
		try {
            return await PI.getGeomType(this._MGPntInfoId);
        } catch (e) {
            console.error(e);
        }
	}

    /**
	 * 设置库编号
	 * @memberOf PntInfo
	 * @param newVal 库编号
	 * @return {Promise<void>}
	 */
	async setLibID(newVal) {
		try {
            await PI.setLibID(this._MGPntInfoId, newVal);
        } catch (e) {
            console.error(e);
        }
	}

    /**
	 * 克隆几何图形信息
	 * @memberOf PntInfo
	 * @return {Promise<GeomInfo>} 几何图形信息
	 */
	async Clone() {
		try {
            let {geomInfoId} = await PI.Clone(this._MGPntInfoId);
            var geomInfo = new GeomInfo()
            geomInfo._MGGeomInfoId = geomInfoId;
            return geomInfo;
        } catch (e) {
            console.error(e);
        }
	}
}