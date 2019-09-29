/**
 * @content 同步图层选项功能组件
 * @author  2019-09-25
 */
import { NativeModules } from 'react-native';

let SLO = NativeModules.JSSyncLayerOption;

/**
 * @class SyncLayerOption
 * @description 同步图层选项
 */
export default class SyncLayerOption {
  /**
   * 构造一个新的 SyncLayerOption 对象。
   * @memberOf SyncLayerOption
   * @returns {Promise.<SyncLayerOption>}
   */
  async createObjByParmeters(strLayerId) {
    try {
      var { SyncLayerOptionId } = await SLO.createObj(strLayerId);
      var syncLayerOption = new SyncLayerOption();
      syncLayerOption._MGSyncLayerOptionId = SyncLayerOptionId;
      return syncLayerOption;
    } catch (e){
      console.error(e);
    }
  }

  /**
   * 获取同步图层ID
   * @memberOf SyncLayerOption
   * @returns {Promise.<String>} 同步图层ID
   */
  async getLayerId() {
    try {
      return await SLO.getLayerId(this._MGSyncLayerOptionId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取同步图层ID
   * @memberOf SyncLayerOption
   * @param {String} strLayerId 同步图层ID
   * @returns {Promise.<void>}
   */
  async setLayerId(strLayerId) {
    try {
      await SLO.setLayerId(this._MGSyncLayerOptionId, strLayerId);
    } catch (e) {
      console.error(e);
    }
  }

