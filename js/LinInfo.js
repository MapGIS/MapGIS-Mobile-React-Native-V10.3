/**
 * @content 线图形信息功能组件
 * @author  2019-09-12 
 */
import { NativeModules } from "react-native";

let LI = NativeModules.JSLinInfo;

import GeomInfo from "./GeomInfo.js"

/**
 * @class LinInfo
 */
export default class LinInfo extends GeomInfo {
    constructor(){
        super()
        Object.defineProperty(this,"_MGLinInfoId", {
            get:function(){
                return this._MGGeomInfoId
            },
            set:function(_MGLinInfoId){
                this._MGGeomInfoId = _MGLinInfoId
            },
        })
    }
    
    /**
	 * 构造一个新的 LinInfo 对象
	 * @memberOf LinInfo
	 * @return {Promise<LinInfo>}
	 */
    async createObj(){
        try{
            var {LinInfoId} = await LI.createObj()
            var linInfo = new LinInfo()
            linInfo._MGLinInfoId = LinInfoId
            return linInfo
        } catch(e) {
            console.error(e)
        }
    }

    /**
	 * 获取库编号
	 * @memberOf LinInfo
	 * @return {Promise}库编号
	 */
	async getLibID()
	{
		try {
            return await LI.getLibID(this._MGLinInfoId);
        } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 设置库编号
	 * @memberOf LinInfo
	 * @param newVal 库编号
	 * @return {Promise<void>}
	 */
	async setLibID(newVal)
	{
		try {
            await LI.setLibID(this._MGLinInfoId, newVal);
        } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 获取覆盖方式
	 * @memberOf LinInfo
	 * @return {Promise}覆盖方式
	 */
	async getOvprnt()
	{
		try {
            return await LI.getOvprnt(this._MGLinInfoId);
        } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 获取线型号
	 * @memberOf LinInfo
	 * @return {Promise}线型号
	 */
	async getLinStyID()
	{
		try {
            return await LI.getLinStyID(this._MGLinInfoId);
        } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 设置线型号
	 * @memberOf LinInfo
	 * @param newVal 线型号
	 * @return {Promise<void>}
	 */
	async setLinStyID(newVal)
	{
		try {
            await LI.setLinStyID(this._MGLinInfoId, newVal);
        } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 获取外部笔宽1
	 * @memberOf LinInfo
	 * @return {Promise}外部笔宽1
	 */
	async getOutPenW1()
	{
		try {
            return await LI.getOutPenW1(this._MGLinInfoId);
        } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 设置外部笔宽1
	 * @memberOf LinInfo
	 * @param newVal 外部笔宽1
	 * @return {Promise<void>}
	 */
	async setOutPenW1(newVal)
	{
		try {
            await LI.setOutPenW1(this._MGLinInfoId, newVal);
        } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 获取外部笔宽2
	 * @memberOf LinInfo
	 * @return {Promise}外部笔宽2
	 */
	async getOutPenW2()
	{
		try {
            return await LI.getOutPenW2(this._MGLinInfoId);
        } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 设置外部笔宽2
	 * @memberOf LinInfo
	 * @param newVal 外部笔宽2
	 * @return {Promise<void>}
	 */
	async setOutPenW2(newVal)
	{
		try {
            await LI.setOutPenW2(this._MGLinInfoId, newVal);
        } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 获取外部笔宽3
	 * @memberOf LinInfo
	 * @return {Promise}外部笔宽3
	 */
	async getOutPenW3()
	{
		try {
            return await LI.getOutPenW3(this._MGLinInfoId);
        } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 设置外部笔宽3
	 * @memberOf LinInfo
	 * @param newVal 外部笔宽3
	 * @return {Promise<void>}
	 */
	async setOutPenW3(newVal)
	{
		try {
            await LI.setOutPenW3(this._MGLinInfoId, newVal);
        } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 获取可变颜色1
	 * @memberOf LinInfo
	 * @return {Promise}可变颜色1
	 */
	async getOutClr1()
	{
		try {
            return await LI.getOutClr1(this._MGLinInfoId);
        } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 设置可变颜色1
	 * @memberOf LinInfo
	 * @param newVal 可变颜色1
	 * @return {Promise<void>}
	 */
	async setOutClr1(newVal)
	{
		try {
            await LI.setOutClr1(this._MGLinInfoId, newVal);
        } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 获取可变颜色2
	 * @memberOf LinInfo
	 * @return {Promise}可变颜色2
	 */
	async getOutClr2()
	{
		try {
            return await LI.getOutClr2(this._MGLinInfoId);
        } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 设置可变颜色2
	 * @memberOf LinInfo
	 * @param newVal 可变颜色2
	 * @return {Promise<void>}
	 */
	async setOutClr2(newVal)
	{
		try {
            await LI.setOutClr2(this._MGLinInfoId, newVal);
        } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 获取可变颜色3
	 * @memberOf LinInfo
	 * @return {Promise}可变颜色3
	 */
	async getOutClr3()
	{
		try {
            return await LI.getOutClr3(this._MGLinInfoId);
        } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 设置可变颜色3
	 * @memberOf LinInfo
	 * @param newVal 可变颜色3
	 * @return {Promise<void>}
	 */
	async setOutClr3(newVal)
	{
		try {
            await LI.setOutClr3(this._MGLinInfoId, newVal);
        } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 获取线头类型
	 * @memberOf LinInfo
	 * @return {Promise}线头类型
	 */
	async getHeadType()
	{
		try {
            return await LI.getHeadType(this._MGLinInfoId);
        } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 设置线头类型
	 * @memberOf LinInfo
	 * @param newVal 线头类型
	 * @return {Promise<void>}
	 */
	async setHeadType(newVal)
	{
		try {
            await LI.setHeadType(this._MGLinInfoId, newVal);
        } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 获取拐角类型
	 * @memberOf LinInfo
	 * @return {Promise}拐角类型
	 */
	async getJoinType()
	{
		try {
            return await LI.getJoinType(this._MGLinInfoId);
        } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 设置拐角类型
	 * @memberOf LinInfo
	 * @param newVal 拐角类型
	 * @return {Promise<void>}
	 */
	async setJoinType(newVal)
	{
		try {
            await LI.setJoinType(this._MGLinInfoId, newVal);
        } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 获取线型调整方法
	 * @memberOf LinInfo
	 * @return {Promise}线型调整方法
	 */
	async getAdjustFlg()
	{
		try {
            return await LI.getAdjustFlg(this._MGLinInfoId);
        } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 设置线型调整方法
	 * @memberOf LinInfo
	 * @param newVal 线型调整方法
	 * @return {Promise<void>}
	 */
	async setAdjustFlg(newVal)
	{
		try {
            await LI.setAdjustFlg(this._MGLinInfoId, newVal);
        } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 获取线型生成方法
	 * @memberOf LinInfo
	 * @return {Promise}线型生成方法
	 */
	async getMakeMethod()
	{
		try {
            return await LI.getMakeMethod(this._MGLinInfoId);
        } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 设置线型生成方法
	 * @memberOf LinInfo
	 * @param newVal 线型生成方法
	 * @return {Promise<void>}
	 */
	async setMakeMethod(newVal)
	{
		try {
            await LI.setMakeMethod(this._MGLinInfoId, newVal);
        } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 获取X系数
	 * @memberOf LinInfo
	 * @return {Promise}X系数
	 */
	async getXScale()
	{
		try {
            return await LI.getXScale(this._MGLinInfoId);
        } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 设置X系数
	 * @memberOf LinInfo
	 * @param newVal X系数
	 * @return {Promise<void>}
	 */
	async setXScale(newVal)
	{
		try {
            await LI.setXScale(this._MGLinInfoId, newVal);
        } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 获取Y系数
	 * @memberOf LinInfo
	 * @return {Promise}Y系数
	 */
	async getYScale()
	{
		try {
            return await LI.getYScale(this._MGLinInfoId);
        } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 设置Y系数
	 * @memberOf LinInfo
	 * @param newVal Y系数
	 * @return {Promise<void>}
	 */
	async setYScale(newVal)
	{
		try {
            await LI.setYScale(this._MGLinInfoId, newVal);
        } catch (e) {
            console.error(e);
        }
	}

    /**
	 * 获取几何类型
	 * @memberOf LinInfo
	 * @return {Promise} 几何类型
	 */
	async getGeomType() {
		try {
            return await LI.getGeomType(this._MGLinInfoId);
        } catch (e) {
            console.error(e);
        }
	}

    /**
	 * 设置Y系数
	 * @memberOf LinInfo
	 * @param newVal Y系数
	 * @return {Promise<void>}
	 */
	async setOvprnt(newVal) {
		try {
            await LI.setOvprnt(this._MGLinInfoId, newVal);
        } catch (e) {
            console.error(e);
        }
	}

    /**
	 * 克隆几何图形信息
	 * @memberOf LinInfo
	 * @return {Promise<GeomInfo>} 几何图形信息
	 */
	async Clone() {
		try {
            let {GeomInfoId} = await LI.Clone(this._MGLinInfoId);
            var geomInfo = new GeomInfo();
            geomInfo._MGGeomInfoId = GeomInfoId;
            return geomInfo;
        } catch (e) {
            console.error(e);
        }
	}
}