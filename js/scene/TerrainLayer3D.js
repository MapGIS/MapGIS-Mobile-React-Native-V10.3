/*
 * @Description: 三维地形图层组件
 * @Version: 1.0
 * @Autor: liaoliang
 * @Date: 2020-07-20 10:11:24
 * @LastEditors: liaoliang
 * @LastEditTime: 2020-07-20 10:29:21
 */

import { NativeModules } from 'react-native';
import Layer3D from './Layer3D';

let TL3 = NativeModules.JSTerrainLayer3D;

export default class TerrainLayer3D extends Layer3D {
  constructor() {
    super();
    Object.defineProperty(this, '_MGTerrainLayer3DId', {
      get: function () {
        return this._MGLayer3DId;
      },
      set: function (_MGTerrainLayer3DId) {
        this._MGLayer3DId = _MGTerrainLayer3DId;
      },
    });
  }

  /**
   * @description: 构造一个新的 TerrainLayer3D 对象
   * @param {type}
   * @return:
   */
  async createObj() {
    try {
      var { terrainLayer3DId } = await TL3.createObj();
      var terrainLayer3D = new TerrainLayer3D();
      terrainLayer3D._MGTerrainLayer3DId = terrainLayer3DId;
      return terrainLayer3D;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 获取图层范围
   * @param {String} rectId 二维范围，Rect类型的id
   * @return: 1-成功；0-失败
   */
  async getExtent(rectId) {
    try {
      let result = await TL3.getExtent(this._MGTerrainLayer3DId, rectId);

      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 获取图层类型的值
   * @param {type}
   * @return:
   */
  async getType() {
    try {
      let typeValue = await TL3.getType(this._MGTerrainLayer3DId);

      return typeValue;
    } catch (error) {
      console.error(error);
    }
  }
}
