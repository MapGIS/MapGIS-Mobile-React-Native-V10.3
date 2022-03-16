/*
 * @Description: 场景点图形组件
 * @Version: 1.0
 * @Autor: liaoliang
 * @Date: 2020-08-16 14:32:39
 * @LastEditors: liaoliang
 * @LastEditTime: 2020-08-19 21:58:21
 */

import { NativeModules } from 'react-native';
import Graphic3D from './Graphic3D';

let GMP3 = NativeModules.JSGraphicMultiPoint3D;

export default class GraphicMultiPoint3D extends Graphic3D {
  constructor() {
    super();
    Object.defineProperty(this, '_MGGraphicMultiPoint3DId', {
      get: function () {
        return this._MGGraphic3DId;
      },
      set: function (_MGGraphicMultiPoint3DId) {
        this._MGGraphic3DId = _MGGraphicMultiPoint3DId;
      },
    });
  }

  /**
   * @description: 构造一个新的 GraphicMultiPoint3D 对象
   * @param {type}
   * @return:
   */
  async createObj() {
    try {
      var { graphicMultiPoint3DId } = await GMP3.createObj();
      var graphicMultiPoint3D = new GraphicMultiPoint3D();
      graphicMultiPoint3D._MGGraphicMultiPoint3DId = graphicMultiPoint3DId;
      return graphicMultiPoint3D;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 追加点
   * @param {String} point3DId 场景地理坐标的id
   * @return {type}
   */
  async appendPoint(point3DId) {
    try {
      let result = await GMP3.appendPoint(
        this._MGGraphicMultiPoint3DId,
        point3DId
      );

      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 追加一组点
   * @param {ReadableArray} points3DId 一组场景地理坐标的id
   * @return {type}
   */
  async appendPoints(points3DId) {
    try {
      let result = await GMP3.appendPoints(
        this._MGGraphicMultiPoint3DId,
        points3DId
      );

      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 获取地理坐标点的id
   * @param {int} index
   * @return {type}
   */
  async getPoint(index) {
    try {
      let pointId = await GMP3.getPoint(this._MGGraphicMultiPoint3DId, index);

      return pointId;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 获取坐标点数目
   * @param {type}
   * @return {type}
   */
  async getPointCount() {
    try {
      let countNum = await GMP3.getPointCount(this._MGGraphicMultiPoint3DId);

      return countNum;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 获取一组坐标的id
   * @param {type}
   * @return {WritableArray}
   */
  async getPoints() {
    try {
      let dot3DIds = await GMP3.getPoints(this._MGGraphicMultiPoint3DId);

      return dot3DIds;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 获取点的大小
   * @param {type}
   * @return {type}
   */
  async getPointSize() {
    try {
      let pointSize = await GMP3.getPointSize(this._MGGraphicMultiPoint3DId);

      return pointSize;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 插入一个点
   * @param {int} index
   * @param {String} point3DId 场景地理坐标的id
   * @return {type}
   */
  async insertPoint(index, point3DId) {
    try {
      let result = await GMP3.insertPoint(
        this._MGGraphicMultiPoint3DId,
        index,
        point3DId
      );

      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 移除所有点
   * @param {type}
   * @return {type}
   */
  async removeAllPoints() {
    try {
      let result = await GMP3.removeAllPoints(this._MGGraphicMultiPoint3DId);

      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 移除一个点
   * @param {type}
   * @return {type}
   */
  async removePoint(index) {
    try {
      let result = await GMP3.removePoint(this._MGGraphicMultiPoint3DId, index);

      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 设置一组坐标
   * @param {ReadableArray} points3DId
   * @return {type}
   */
  async setPoints(points3DId) {
    try {
      let result = await GMP3.setPoints(
        this._MGGraphicMultiPoint3DId,
        points3DId
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
  async setPointSize(size) {
    try {
      let result = await GMP3.setPointSize(this._MGGraphicMultiPoint3DId, size);

      return result;
    } catch (error) {
      console.error(error);
    }
  }
}
