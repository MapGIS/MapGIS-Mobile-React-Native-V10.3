/*
 * @Description: 场景区图形组件
 * @Version: 1.0
 * @Autor: liaoliang
 * @Date: 2020-08-17 09:52:27
 * @LastEditors: liaoliang
 * @LastEditTime: 2020-08-17 11:04:27
 */

import { NativeModules } from 'react-native';
import GraphicMultiPoint3D from './GraphicMultiPoint3D';

let GPG3 = NativeModules.JSGraphicPolygon3D;

export default class GraphicPolygon3D extends GraphicMultiPoint3D {
  constructor() {
    super();
    Object.defineProperty(this, '_MGGraphicPolygon3DId', {
      get: function () {
        return this._MGGraphicMultiPoint3DId;
      },
      set: function (_MGGraphicPolygon3DId) {
        this._MGGraphicMultiPoint3DId = _MGGraphicPolygon3DId;
      },
    });
  }

  /**
   * @description: 构造一个新的 GraphicPolygon3D 对象
   * @param {type}
   * @return:
   */
  async createObj() {
    try {
      var { graphicPolygon3DId } = await GPG3.createObj();
      var graphicPolygon3D = new GraphicPolygon3D();
      graphicPolygon3D._MGGraphicPolygon3DId = graphicPolygon3DId;
      return graphicPolygon3D;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 追加点(只针对第一圈操作)
   * @param {String} dot3DId
   * @return {type}
   */
  async appendPoint(dot3DId) {
    try {
      let result = await GPG3.appendPoint(this._MGGraphicPolygon3DId, dot3DId);

      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 追加一组点(只针对第一圈操作)
   * @param {ReadableArray} dot3DIds
   * @return {type}
   */
  async appendPoints(dot3DIds) {
    try {
      let result = await GPG3.appendPoints(
        this._MGGraphicPolygon3DId,
        dot3DIds
      );

      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 获取面积
   * @param {type}
   * @return {type}
   */
  async getArea() {
    try {
      let area = await GPG3.getArea(this._MGGraphicPolygon3DId);

      return area;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 获取边界线的宽度
   * @param {type}
   * @return {type}
   */
  async getBorderlineWidth() {
    try {
      let borderlineWidth = await GPG3.getBorderlineWidth(
        this._MGGraphicPolygon3DId
      );

      return borderlineWidth;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 获取圈序列长度
   * @param {type}
   * @return {type}
   */
  async getCirclesSize() {
    try {
      let circlesSize = await GPG3.getCirclesSize(this._MGGraphicPolygon3DId);

      return circlesSize;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 获取图形伸出的高度
   * @param {type}
   * @return {type}
   */
  async getExtrusionHeight() {
    try {
      let extrusionHeight = await GPG3.getExtrusionHeight(
        this._MGGraphicPolygon3DId
      );

      return extrusionHeight;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 在指定索引处插入点
   * @param {int} index 索引
   * @param {String} dot3DId 场景地理坐标的id
   * @return {type}
   */
  async insertPoint(index, dot3DId) {
    try {
      let result = await GPG3.insertPoint(
        this._MGGraphicPolygon3DId,
        index,
        dot3DId
      );

      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 移除指定索引的点
   * @param {int} index
   * @return {type}
   */
  async removePoint(index) {
    try {
      let result = await GPG3.removePoint(this._MGGraphicPolygon3DId, index);

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
      let result = await GPG3.removeAllPoints(this._MGGraphicPolygon3DId);

      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 设置边界线的颜色
   * @param {int} color
   * @return {type}
   */
  async setBorderlineColor(color) {
    try {
      let result = await GPG3.setBorderlineColor(
        this._MGGraphicPolygon3DId,
        color
      );

      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 设置边界线的宽度
   * @param {type}
   * @return {type}
   */
  async setBorderlineWidth(width) {
    try {
      let result = await GPG3.setBorderlineWidth(
        this._MGGraphicPolygon3DId,
        width
      );

      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 设置覆盖物伸出的高度
   * @param {double} extrusionHeight
   * @return {type}
   */
  async setExtrusionHeight(extrusionHeight) {
    try {
      let result = await GPG3.setExtrusionHeight(
        this._MGGraphicPolygon3DId,
        extrusionHeight
      );

      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 设置坐标点
   * @param {ReadableArray} dot3DIds
   * @return {type}
   */
  async setPoints(dot3DIds) {
    try {
      let result = await GPG3.setPoints(this._MGGraphicPolygon3DId, dot3DIds);

      return result;
    } catch (error) {
      console.error(error);
    }
  }
}
