/*
 * @Description:
 * @Version: 1.0
 * @Autor: liaoliang
 * @Date: 2020-08-06 17:55:54
 * @LastEditors: liaoliang
 * @LastEditTime: 2020-08-06 19:33:05
 */

import { NativeModules } from 'react-native';

let FQ3 = NativeModules.JSFeatureQuery3D;

export default class FeatureQuery3D {
  /**
   * @description: 构造一个新的FeatureQuery3D对象
   * @param {String} strIGServerBaseURL
   * @param {String} strDataURL
   * @return:
   */
  async createObj(strIGServerBaseURL, strDataURL) {
    try {
      var { featureQuery3DId } = await FQ3.createObj(
        strIGServerBaseURL,
        strDataURL
      );
      var featureQuery3D = new FeatureQuery3D();
      featureQuery3D._MGFeatureQuery3DId = featureQuery3DId;
      return featureQuery3D;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 查询
   * @param {type}
   * @return:
   */
  async query() {
    try {
      let featurePagedResult3DId = await FQ3.query(this._MGFeatureQuery3DId);

      return featurePagedResult3DId;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 获取查询范围
   * @param {type}
   * @return:
   */
  async getQueryBound3D() {
    try {
      let queryBound3DId = await FQ3.getQueryBound3D(this._MGFeatureQuery3DId);

      return queryBound3DId;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 设置查询范围
   * @param {String} queryBoundId
   * @return:
   */
  async setQueryBound3D(queryBoundId) {
    try {
      let resultFeatureQuery3DId = await FQ3.setQueryBound3D(
        this._MGFeatureQuery3DId,
        queryBoundId
      );

      return resultFeatureQuery3DId;
    } catch (error) {
      console.error(error);
    }
  }
}
