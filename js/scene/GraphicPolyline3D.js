/*
 * @Description: 场景线图形组件
 * @Version: 1.0
 * @Autor: liaoliang
 * @Date: 2020-08-17 10:02:20
 * @LastEditors: liaoliang
 * @LastEditTime: 2020-08-19 09:00:41
 */

import { NativeModules } from 'react-native';
import GraphicMultiPoint3D from './GraphicMultiPoint3D';

let GPL3 = NativeModules.JSGraphicPolyline3D;

export default class GraphicPolyline3D extends GraphicMultiPoint3D {
  constructor() {
    super();
    Object.defineProperty(this, '_MGGraphicPolyline3DId', {
      get: function () {
        return this._MGGraphicMultiPoint3DId;
      },
      set: function (_MGGraphicPolyline3DId) {
        this._MGGraphicMultiPoint3DId = _MGGraphicPolyline3DId;
      },
    });
  }

  /**
   * @description: 构造一个新的 GraphicPolyline3D 对象
   * @param {type}
   * @return:
   */
  async createObj() {
    try {
      var { graphicPolyline3DId } = await GPL3.createObj();
      var graphicPolyline3D = new GraphicPolyline3D();
      graphicPolyline3D._MGGraphicPolyline3DId = graphicPolyline3DId;
      return graphicPolyline3D;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 获取线的长度
   * @param {type}
   * @return {type}
   */
  async getLength() {
    try {
      let length = await GPL3.getLength(this._MGGraphicPolyline3DId);

      return length;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 获取线宽
   * @param {type}
   * @return {type}
   */
  async getLineWidth() {
    try {
      let lineWidth = await GPL3.getLineWidth(this._MGGraphicPolyline3DId);

      return lineWidth;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 设置线宽
   * @param {type}
   * @return {type}
   */
  async setLineWidth(lineWidth) {
    try {
      let result = await GPL3.setLineWidth(
        this._MGGraphicPolyline3DId,
        lineWidth
      );

      return result;
    } catch (error) {
      console.error(error);
    }
  }
}
