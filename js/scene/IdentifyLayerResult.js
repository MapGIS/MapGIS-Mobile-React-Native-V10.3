/*
 * @Description:
 * @Version: 1.0
 * @Autor: liaoliang
 * @Date: 2020-08-06 10:06:42
 * @LastEditors: liaoliang
 * @LastEditTime: 2020-08-06 17:14:15
 */

import { NativeModules } from 'react-native';

let ILR = NativeModules.JSIdentifyLayerResult;

export default class IdentifyLayerResult {
  /**
   * @description: 构造一个新的IdentifyLayerResult对象
   * @param {type}
   * @return:
   */
  async createObj() {
    try {
      var { identifyLayerResultId } = await ILR.createObj();
      var identifyLayerResult = new IdentifyLayerResult();
      identifyLayerResult._MGIdentifyLayerResultId = identifyLayerResultId;
      return identifyLayerResult;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 获取拾取到的要素
   * @param {type}
   * @return {WritableArray} geoElements
   */
  async getElements() {
    try {
      let geoElements = await ILR.getElements(this._MGIdentifyLayerResultId);

      return geoElements;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 返回错误信息
   * @param {type}
   * @return {String} geoElements
   */
  async getError() {
    try {
      let error = await ILR.getError(this._MGIdentifyLayerResultId);

      return error;
    } catch (error) {
      console.error(error);
    }
  }
}
