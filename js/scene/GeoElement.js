/*
 * @Description:
 * @Version: 1.0
 * @Autor: liaoliang
 * @Date: 2020-08-06 09:51:08
 * @LastEditors: liaoliang
 * @LastEditTime: 2020-08-06 17:05:11
 */

import { NativeModules } from 'react-native';

let GE = NativeModules.JSGeoElement;

export default class GeoElement {
  /**
   * @description: 构造一个新的GeoElement对象
   * @param {type}
   * @return:
   */
  async createObj() {
    try {
      var { geoElementId } = await GE.createObj();
      var geoElement = new GeoElement();
      geoElement._MGGeoElementId = geoElementId;
      return geoElement;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 获取属性
   * @param {type}
   * @return {WritableMap} attributes
   */
  async getAttributes() {
    try {
      let attributes = await GE.getAttributes(this._MGGeoElementId);

      return attributes;
    } catch (error) {
      console.error(error);
    }
  }
}
