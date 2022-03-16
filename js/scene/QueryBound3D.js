/*
 * @Description:
 * @Version: 1.0
 * @Autor: liaoliang
 * @Date: 2020-08-06 19:28:48
 * @LastEditors: liaoliang
 * @LastEditTime: 2020-08-06 20:06:02
 */

import { NativeModules } from 'react-native';

let QB3 = NativeModules.JSQueryBound3D;

export default class QueryBound3D {
  /**
   * @description: 构造一个新的QueryBound3D对象
   * @param {String} pointId
   * @return:
   */
  async createObj(pointId) {
    try {
      var { queryBound3DId } = await QB3.createObj(pointId);
      var queryBound3D = new QueryBound3D();
      queryBound3D._MGQueryBound3DId = queryBound3DId;
      return queryBound3D;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 获取查询范围外包点序列
   * @param {type}
   * @return:
   */
  async getBoundPoints() {
    try {
      let dot3DIdS = await QB3.getBoundPoints(this._MGQueryBound3DId);

      return dot3DIdS;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 获取查询范围类型
   * @param {type}
   * @return {int} boundType
   */
  async getBoundType() {
    try {
      let boundType = await QB3.getBoundType(this._MGQueryBound3DId);

      return boundType;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description:
   * @param {type}
   * @return {double}
   */
  async getDotOffDx() {
    try {
      let dotOffDx = await QB3.getDotOffDx(this._MGQueryBound3DId);

      return dotOffDx;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description:
   * @param {type}
   * @return {double}
   */
  async getDotOffDy() {
    try {
      let dotOffDy = await QB3.getDotOffDy(this._MGQueryBound3DId);

      return dotOffDy;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description:
   * @param {type}
   * @return {double}
   */
  async getDotOffDz() {
    try {
      let dotOffDz = await QB3.getDotOffDz(this._MGQueryBound3DId);

      return dotOffDz;
    } catch (error) {
      console.error(error);
    }
  }
}
