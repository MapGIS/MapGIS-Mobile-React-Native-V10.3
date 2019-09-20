/**
 * @content 要素类信息功能组件
 * @author  2019-09-16
 */
import { NativeModules } from "react-native";

let FI = NativeModules.JSFClsInfo;

import XClsInfo from "./XClsInfo.js"
/**
 * @class FClsInfo
 * @description 要素类信息
 */
export default class FClsInfo extends XClsInfo{

    constructor(){
        super()
        Object.defineProperty(this,"_MGFClsInfoId", {
            get:function(){
                return this. _MGXClsInfoId
            },
            set:function(_MGFClsInfoId){
                this. _MGXClsInfoId = _MGFClsInfoId
            },
        })
    }

    /**
   * 构造一个新的 FClsInfo 对象。
   * @memberOf FClsInfo
   * @returns {Promise.<FClsInfo>}
   */
  async createObj() {
    try{
        var {FClsInfoId} = await FI.createObj();
        var fClsInfo = new FClsInfo();
        fClsInfo._MGFClsInfoId = FClsInfoId;
        return fClsInfo;
    }catch(e){
        console.error(e);
    }
  }

  /**
   * 获取简单要素类ID
   * @memberOf FClsInfo
   * @return {Promise}要素类ID
   */
	async getID() {
		try {
            return await FI.getID(this._MGFClsInfoId); 
        } catch (error) {
            console.error(e);
        }
	}

	/**
   * 获取简单要素类类型
   * @memberOf FClsInfo
   * @return {Promise}简单要素类类型
   */
	async getType() {
		try {
            return await FI.getType(this._MGFClsInfoId); 
        } catch (error) {
            console.error(e);
        }
	}
	

	/**
   * 获取简单要素类URL地址
   * @memberOf FClsInfo
   * @return {Promise}简单要素类URL地址
   */
	async getURL() {
		try {
            return await FI.getURL(this._MGFClsInfoId); 
        } catch (error) {
            console.error(e);
        }
	}
	
	/**
   * 获取简单要素类名称
   * @memberOf FClsInfo
   * @return {Promise} 类名称
   */
	async getName() {
		try {
            return await FI.getName(this._MGFClsInfoId); 
        } catch (error) {
            console.error(e);
        }
	}

	/**
   * 设置简单要素类名
   * @memberOf FClsInfo
   * @param newVal简单要素类名
   * @return {Promise}
   */
	async setName(newVal) {
		try {
            return await FI.setName(this._MGFClsInfoId, newVal);
          } catch (e) {
            console.error(e);
        }
	}
	
	/**
	 * 获取类几何约束类型
	 * @memberOf FClsInfo
	 * @return {Promise}几何约束类型
	 */
	async getGeomType()
	{
		try {
            return await FI.getGeomType(this._MGFClsInfoId); 
        } catch (error) {
            console.error(e);
        }
	}

	/**
	 * 获取显示因子X
	 * @memberOf FClsInfo
	 * @return {Promise} 显示因子X
	 */
	async getScalex()
	{
		try {
            return await FI.getScalex(this._MGFClsInfoId); 
        } catch (error) {
            console.error(e);
        }
	}

	/**
	 * 获取显示因子Y
	 * @memberOf FClsInfo
	 * @return {Promise} 显示因子Y
	 */
	async getScaley()
	{
		try {
            return await FI.getScaley(this._MGFClsInfoId); 
        } catch (error) {
            console.error(e);
        }
	}

	/**
	 * 设置显示因子XY
	 * @memberOf FClsInfo
	 * @param newVal
	 * @return {Promise} 是否设置成功
	 */
	async setScaleXY(newXVal, newYVal)
	{
		try {
            return await FI.setScaleXY(this._MGFClsInfoId, newXVal, newYVal);
          } catch (e) {
            console.error(e);
        }
	}
}