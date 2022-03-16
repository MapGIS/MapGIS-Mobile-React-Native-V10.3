/*
 * @Description: 场景点图形组件
 * @Version: 1.0
 * @Autor: liaoliang
 * @Date: 2020-08-16 15:00:44
 * @LastEditors: liaoliang
 * @LastEditTime: 2020-08-19 21:58:49
 */

import { NativeModules } from 'react-native';
import Graphic3D from './Graphic3D';

let GP3 = NativeModules.JSGraphicPoint3D;

export default class GraphicPoint3D extends Graphic3D {
  constructor() {
    super();
    Object.defineProperty(this, '_MGGraphicPoint3DId', {
      get: function () {
        return this._MGGraphic3DId;
      },
      set: function (_MGGraphicPoint3DId) {
        this._MGGraphic3DId = _MGGraphicPoint3DId;
      },
    });
  }

  /**
   * @description: 构造一个新的 GraphicPoint3D 对象
   * @param {type}
   * @return:
   */
  async createObj() {
    try {
      var { graphicPoint3DId } = await GMP3.createObj();
      var graphicPoint3D = new GraphicPoint3D();
      graphicPoint3D._MGGraphicPoint3DId = graphicPoint3DId;
      return graphicPoint3D;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 获取点的位置的id
   * @param {type}
   * @return {type}
   */
  async getPoint() {
    try {
      let pointId = await GP3.getPoint(this._MGGraphicPoint3DId);

      return pointId;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 获取点的大小
   * @param {type}
   * @return {type}
   */
  async getSize() {
    try {
      let size = await GP3.getSize(this._MGGraphicPoint3DId);

      return size;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 设置点的位置
   * @param {String} pointId
   * @return {type}
   */
  async setPoint(pointId) {
    try {
      let result = await GP3.setPoint(this._MGGraphicPoint3DId, pointId);

      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 设置点的位置及大小
   * @param {String} pointId
   * @param {double} size
   * @return {type}
   */
  async setPointAndSize(pointId, size) {
    try {
      let result = await GP3.setPointAndSize(
        this._MGGraphicPoint3DId,
        pointId,
        size
      );

      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 设置点的大小
   * @param {double} size
   * @return {type}
   */
  async setSize(size) {
    try {
      let result = await GP3.setSize(this._MGGraphicPoint3DId, size);

      return result;
    } catch (error) {
      console.error(error);
    }
  }
}
