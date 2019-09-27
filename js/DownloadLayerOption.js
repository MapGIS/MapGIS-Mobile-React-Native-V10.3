/**
 * @content 图层下载选项功能组件
 * @author  2019-09-25
 */
import { NativeModules } from "react-native";

let DLO = NativeModules.JSDownloadLayerOption;

import DownloadLayerOption from "./DownloadLayerOption.js"

/**
 * @class DownloadLayerOption
 * @description 图层下载选项
 */
export default class DownloadLayerOption{

    /**
   * 构造一个新的 DownloadLayerOption 对象。
   * @memberOf DownloadLayerOption
   * @returns {Promise.<DownloadLayerOption>}
   */
  async createObj() {
    try{
        var {DownloadLayerOptionId} = await DLO.createObj();
        var downloadLayerOption = new DownloadLayerOption();
        downloadLayerOption._MGDownloadLayerOptionId = DownloadLayerOptionId;
        return downloadLayerOption;
    }catch(e){
        console.error(e);
    }
  }
 /**
   * 构造一个新的 DownloadLayerOption 对象。
   * @memberOf DownloadLayerOption
   * @returns {Promise.<DownloadLayerOption>}
   */
  async createObjByParmeters(strWhereClause, layerId, strLayerName, iLayerType) {
    try{
        var {DownloadLayerOptionId} = await DLO.createObj(strWhereClause, layerId, strLayerName, iLayerType);
        var downloadLayerOption = new DownloadLayerOption();
        downloadLayerOption._MGDownloadLayerOptionId = DownloadLayerOptionId;
        return downloadLayerOption;
    }catch(e){
        console.error(e);
    }
  }

  /**
	 * 获取图层下载选项的过滤条件
	 * @memberOf DownloadLayerOption
	 * @returns {Promise.<String>} 过滤条件
	 */
  async getWhereClause()
	{
		try {
            return await DLO.getWhereClause(this._MGDownloadLayerOptionId);
          } catch (e) {
            console.error(e);
        }
	}

  /**
	 * 设置图层下载选项的过滤条件
	 * @memberOf DownloadLayerOption
	 * @param {String} whereClause 过滤条件
	 * @returns {Promise.<void>} 
	 */
	async setWhereClause(whereClause)
	{
		try {
            await DLO.setWhereClause(this._MGDownloadLayerOptionId, whereClause);
          } catch (e) {
            console.error(e);
        }
	}

  /**
	 * 获取下载图层ID
	 * @memberOf DownloadLayerOption
	 * @returns {Promise.<int>} 图层ID
	 */
	async getLayerId()
	{
		try {
            return await DLO.getLayerId(this._MGDownloadLayerOptionId);
          } catch (e) {
            console.error(e);
        }
	}

  /**
	 * 设置下载图层ID
	 * @memberOf DownloadLayerOption
	 * @param {int} layerId 图层ID
	 * @returns {Promise.<void>} 
	 */
	async setLayerId(layerId)
	{
		try {
            await DLO.setLayerId(this._MGDownloadLayerOptionId, layerId);
          } catch (e) {
            console.error(e);
        }
	}

  /**
	 * 获取下载图层名称
	 * @memberOf DownloadLayerOption
	 * @returns {Promise.<String>} 图层名称
	 */
	async getName()
	{
		try {
            return await DLO.getName(this._MGDownloadLayerOptionId);
          } catch (e) {
            console.error(e);
        }
	}

  /**
	 * 设置下载图层名称
	 * @memberOf DownloadLayerOption
	 * @param {String} strLayerName 图层名称
	 * @returns {Promise.<void>} 
	 */
	async setName(strLayerName)
	{
		try {
            await DLO.setName(this._MGDownloadLayerOptionId, strLayerName);
          } catch (e) {
            console.error(e);
        }
	}

 /**
	 * 获取下载图层类型
	 * @memberOf DownloadLayerOption
	 * @returns {Promise.<int>} 图层类型
	 */
	async getType()
	{
		try {
            return await DLO.getType(this._MGDownloadLayerOptionId);
          } catch (e) {
            console.error(e);
        }
	}

  /**
	 * 设置下载图层类型
	 * @memberOf DownloadLayerOption
	 * @param {int} iLayerType 图层类型
	 * @returns {Promise.<void>} 
	 */
	async setType(iLayerType)
	{
		try {
            await DLO.setType(this._MGDownloadLayerOptionId, iLayerType);
          } catch (e) {
            console.error(e);
        }
	}
}