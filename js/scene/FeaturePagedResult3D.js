/*
 * @Description:
 * @Version: 1.0
 * @Autor: liaoliang
 * @Date: 2020-08-06 15:44:46
 * @LastEditors: liaoliang
 * @LastEditTime: 2020-08-06 17:51:58
 */

import { NativeModules } from 'react-native';

let FPR3 = NativeModules.JSFeaturePagedResult3D;

export default class FeaturePagedResult3D {
  /**
   * @description: 构造一个新的FeaturePagedResult3D对象
   * @param {type}
   * @return:
   */
  async createObj() {
    try {
      var { featurePagedResult3DId } = await FPR3.createObj();
      var featurePagedResult3D = new FeaturePagedResult3D();
      featurePagedResult3D._MGFeaturePagedResult3DId = featurePagedResult3DId;
      return featurePagedResult3D;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 返回页码对应的结果，页码从1开始计数
   * @param {Int} pageNumber 页码
   * @return {WritableArray} features feature的id集合
   */
  async getPage(pageNumber) {
    try {
      let features = await FPR3.getPage(
        this._MGFeaturePagedResult3DId,
        pageNumber
      );

      return features;
    } catch (error) {
      console.error(error);
    }
  }
}
