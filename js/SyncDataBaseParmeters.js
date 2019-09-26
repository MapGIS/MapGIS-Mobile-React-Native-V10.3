/**
 * @content 同步数据库参数功能组件
 * @author  2019-09-25
 */
import { NativeModules } from "react-native";

let SDBP = NativeModules.JSSyncDataBaseParmeters;

import SyncLayerOption from "./SyncLayerOption.js"

/**
 * @class SyncDataBaseParmeters
 * @description 同步数据库参数
 */
export default class SyncDataBaseParmeters{

    /**
   * 构造一个新的 SyncDataBaseParmeters 对象。
   * @memberOf SyncDataBaseParmeters
   * @returns {Promise.<SyncDataBaseParmeters>}
   */
  async createObj() {
    try{
        var {SyncDataBaseParmetersId} = await SDBP.createObj();
        var syncDataBaseParmeters = new SyncDataBaseParmeters();
        syncDataBaseParmeters._MGSyncDataBaseParmetersId = SyncDataBaseParmetersId;
        return syncDataBaseParmeters;
    }catch(e){
        console.error(e);
    }
  }

  /**
	 * 移除图层
	 * @memberOf SyncDataBaseParmeters
	 * @param {int} layerID 图层ID
   * @returns {Promise.<void>}
	 */
	async removeLayer(strLayerID)
	{
		try {
            await SDBP.removeLayer(this._MGSyncDataBaseParmetersId, strLayerID);
          } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 获取同步图层参数
	 * @memberOf SyncDataBaseParmeters
	 * @return {Promise.List<SyncLayerOption>} 同步图层选项
	 */
	async getLayerOptions()
	{
		try {
            var objArr = [];
            let { SyncLayerOptionArr } = await SDBP.getLayerOptions(this._MGSyncDataBaseParmetersId);
            for (var i = 0; i < SyncLayerOptionArr.length; i++) {
              var syncLayerOption = new SyncLayerOption();
              syncLayerOption._MGSyncLayerOptionId = SyncLayerOptionArr[i];
              objArr.push(syncLayerOption);
            }
            return objArr;
          } catch (e) {
            console.error(e);
        }
	}
}