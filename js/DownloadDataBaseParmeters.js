/**
 * @content 下载数据库参数功能组件
 * @author  2019-09-25
 */
import { NativeModules } from "react-native";

let DDBPS = NativeModules.JSDownloadDataBaseParmeters;

import DownloadLayerOption from "./DownloadLayerOption.js"

/**
 * @class DownloadDataBaseParmeters
 * @description 下载数据库参数
 */
export default class DownloadDataBaseParmeters{

    /**
   * 构造一个新的 DownloadDataBaseParmeters 对象。
   * @memberOf DownloadDataBaseParmeters
   * @returns {Promise.<DownloadDataBaseParmeters>}
   */
  async createObj() {
    try{
        var {DownloadDataBaseParmetersId} = await DDBPS.createObj();
        var downloadDataBaseParmeters = new DownloadDataBaseParmeters();
        downloadDataBaseParmeters._MGDownloadDataBaseParmetersId = DownloadDataBaseParmetersId;
        return downloadDataBaseParmeters;
    }catch(e){
        console.error(e);
    }
  }

  /**
	 * 设置范围
	 * @memberOf DownloadDataBaseParmeters
	 * @param {Rect} extent 范围
   * @returns {Promise.<void>} 下载数据参数
	 */
	async setExtent(extent)
	{
		try {
            await DDBPS.setExtent(this._MGDownloadDataBaseParmetersId, extent._MGRectId);
          } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 移除图层
	 * @memberOf DownloadDataBaseParmeters
	 * @param {int} layerID 图层ID
   * @returns {Promise.<void>} 下载数据参数
	 */
	async removeLayer(layerID)
	{
		try {
            await DDBPS.removeLayer(this._MGDownloadDataBaseParmetersId, layerID);
          } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 获取下载图层选项
	 * @memberOf DownloadDataBaseParmeters
	 * @return {Promise.List<DownloadLayerOption>}下载图层选项
	 */
	async getLayerOptions()
	{
        try {
            var objArr = [];
            let { DownloadLayerOptionArr } = await DDBPS.getLayerOptions(this._MGDownloadDataBaseParmetersId);
            for (var i = 0; i < DownloadLayerOptionArr.length; i++) {
              var downloadLayerOption = new DownloadLayerOption();
              downloadLayerOption._MGDownloadLayerOptionId = DownloadLayerOptionArr[i];
              objArr.push(downloadLayerOption);
            }
            return objArr;
          } catch (e) {
            console.error(e);
        }
	}
}