/*
 * @Description:
 * @Version: 1.0
 * @Autor: liaoliang
 * @Date: 2020-08-06 14:27:08
 * @LastEditors: liaoliang
 * @LastEditTime: 2020-08-06 17:39:41
 */

import { NativeModules } from 'react-native';

let G3 = NativeModules.JSGeometry3D;

export default class Geometry3D {
  /**
   * @description: 构造一个新的Geometry3D对象
   * @param {type}
   * @return:
   */
  async createObj() {
    try {
      var { geometry3DId } = await G3.createObj();
      var geometry3D = new Geometry3D();
      geometry3D._MGGeometry3DId = geometry3DId;
      return geometry3D;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 计算外包围盒
   * @param {type}
   * @return:
   */
  async calRect3D() {
    try {
      let rect3DId = await G3.calRect3D(this._MGGeometry3DId);

      return rect3DId;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 获取几何对象的类型的值
   * @param {type}
   * @return {Int} typeValue
   */
  async getType() {
    try {
      let typeValue = await G3.getType(this._MGGeometry3DId);

      return typeValue;
    } catch (error) {
      console.error(error);
    }
  }
}
