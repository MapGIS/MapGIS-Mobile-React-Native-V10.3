/**
 * @content 注记类信息功能组件
 * @author  2019-09-16
 */
import { NativeModules } from "react-native";

let ANNI = NativeModules.JSAnnClsInfo;

import XClsInfo from "./XClsInfo.js"

/**
 * @class AnnClsInfo
 * @description 注记类信息
 */
export default class AnnClsInfo extends XClsInfo{

    constructor(){
        super()
        Object.defineProperty(this,"_MGAnnClsInfoId", {
            get:function(){
                return this. _MGXClsInfoId
            },
            set:function(_MGAnnClsInfoId){
                this. _MGXClsInfoId = _MGAnnClsInfoId
            },
        })
    }

    /**
   * 构造一个新的 AnnClsInfo 对象。
   * @memberOf AnnClsInfo
   * @returns {Promise.<AnnClsInfo>}
   */
  async createObj() {
    try{
        var {annClsInfoId} = await ANNI.createObj();
        var annClsInfo = new AnnClsInfo();
        annClsInfo._MGAnnClsInfoId = annClsInfoId;
        return annClsInfo;
    }catch(e){
        console.error(e);
    }
  }

  /**
   * 获取注记要素类ID
   * @memberOf AnnClsInfo
   * @return {Promise} 类ID
   */
	async getID() {
		try {
            return await ANNI.getID(this._MGAnnClsInfoId); 
        } catch (error) {
            console.error(e);
        }
	}

    /**
	 * 取类类型
	 * @memberOf AnnClsInfo
	 * @return {Promise}类类型
	 */
	async getType() {
		try {
            return await ANNI.getType(this._MGAnnClsInfoId); 
        } catch (error) {
            console.error(e);
        }
	}
	

	/**
   * 获取注记要素类URL地址
   * @memberOf AnnClsInfo
   * @return {Promise}注记要素类URL地址
   */
	async getURL() {
		try {
            return await ANNI.getURL(this._MGAnnClsInfoId); 
        } catch (error) {
            console.error(e);
        }
	}
	
	/**
   * 获取注记要素类名称
   * @memberOf AnnClsInfo
   * @return {Promise} 类名称
   */
	async getName() {
		try {
            return await ANNI.getName(this._MGAnnClsInfoId); 
        } catch (error) {
            console.error(e);
        }
	}

	/**
   * 设置注记要素类名称
   * @memberOf AnnClsInfo
   * @param newVal 注记要素类名称
   * @return {Promise} >0:成功；<=0:失败
   */
	async setName(newVal) {
		try {
            return await ANNI.setName(this._MGAnnClsInfoId, newVal);
          } catch (e) {
            console.error(e);
        }
	}
	
	/**
	 * 获取类几何约束类型
	 * @memberOf AnnClsInfo
	 * @return {Promise}几何约束类型
	 */
	async getAnnType()
	{
		try {
            return await ANNI.getAnnType(this._MGAnnClsInfoId); 
        } catch (error) {
            console.error(e);
        }
	}

	/**
	 * 获取显示因子X
	 * @memberOf AnnClsInfo
	 * @return {Promise} 显示因子X
	 */
	async getScalex()
	{
		try {
            return await ANNI.getScalex(this._MGAnnClsInfoId); 
        } catch (error) {
            console.error(e);
        }
	}

	/**
	 * 获取显示因子Y
	 * @memberOf AnnClsInfo
	 * @return {Promise} 显示因子Y
	 */
	async getScaley()
	{
		try {
            return await ANNI.getScaley(this._MGAnnClsInfoId); 
        } catch (error) {
            console.error(e);
        }
	}

	/**
	 * 设置显示因子XY
	 * @memberOf AnnClsInfo
	 * @param newVal
	 * @return {Promise} 是否设置成功
	 */
	async setScaleXY(newXVal,newYVal)
	{
		try {
            return await ANNI.setScaleXY(this._MGAnnClsInfoId, newXVal, newYVal);
          } catch (e) {
            console.error(e);
        }
	}
}