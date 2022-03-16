/*
 * @Description:
 * @Version: 1.0
 * @Autor: liaoliang
 * @Date: 2020-08-06 11:18:43
 * @LastEditors: liaoliang
 * @LastEditTime: 2020-08-06 17:26:00
 */

import { NativeModules } from 'react-native';

let F3 = NativeModules.JSFeature3D;

export default class Feature3D {
  /**
   * @description: 构造一个新的Feature3D对象
   * @param {String} handle
   * @return:
   */
  async createObj(handle) {
    try {
      var { feature3DId } = await F3.createObj(handle);
      var feature3D = new Feature3D();
      feature3D._MGFeature3DId = feature3DId;
      return feature3D;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 获取几何数据
   * @param {type}
   * @return geometry3DId
   */
  async getGeometry() {
    try {
      let geometry3DId = await F3.getGeometry(this._MGFeature3DId);

      return geometry3DId;
    } catch (error) {
      console.error(error);
    }
  }
}
