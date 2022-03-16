/*
 * @Description: 三维矢量图层组件
 * @Version: 1.0
 * @Autor: liaoliang
 * @Date: 2020-07-08 15:17:31
 * @LastEditors: liaoliang
 * @LastEditTime: 2020-07-08 16:10:42
 */

import { NativeModules } from 'react-native';
import Layer3D from './Layer3D';

let VL3 = NativeModules.JSVectorLayer3D;

export default class VectorLayer3D extends Layer3D {
  constructor() {
    super();
    Object.defineProperty(this, '_MGVectorLayer3DId', {
      get: function () {
        return this._MGLayer3DId;
      },
      set: function (_MGVectorLayer3DId) {
        this._MGLayer3DId = _MGVectorLayer3DId;
      },
    });
  }

  /**
   * @description: 构造一个新的 VectorLayer3D 对象
   * @param {type}
   * @return:
   */
  async createObj() {
    try {
      var { vectorLayer3DId } = await VL3.createObj();
      var vectorLayer3D = new VectorLayer3D();
      vectorLayer3D._MGVectorLayer3DId = vectorLayer3DId;
      return vectorLayer3D;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 获取图层样式文档路径
   * @param {type}
   * @return:
   */
  async getConfigFile() {
    try {
      let configFilePath = await VL3.getConfigFile(this._MGVectorLayer3DId);
      return configFilePath;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 获取图层范围
   * @param {String} rectId
   * @return 1-成功；0-失败
   */
  async getExtent(rectId) {
    try {
      let result = await VL3.getExtent(this._MGVectorLayer3DId, rectId);
      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description 获取图层显示的透明度
   * @param {Integer} sAlpha 透明度，值为0-100，其中0为不透明
   * @return 1-成功；0-失败
   */
  async getTransparency(sAlpha) {
    try {
      let result = await VL3.getTransparency(this._MGVectorLayer3DId, sAlpha);
      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description 获取图层类型的值
   */
  async getType() {
    try {
      let typeValue = await VL3.getType(this._MGVectorLayer3DId);
      return typeValue;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description 获取图层是否应用光照
   * @return true: 开启光照，false：关闭光照
   */
  async isLightingEnabled() {
    try {
      let isLightingEnabledResult = await VL3.isLightingEnabled(
        this._MGVectorLayer3DId
      );

      return isLightingEnabledResult;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description 设置图层样式文档路径
   * @param {String} configFilePath 文档路径
   */
  async setConfigFile(configFilePath) {
    try {
      let result = await VL3.setConfigFile(
        this._MGVectorLayer3DId,
        configFilePath
      );

      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description 设置图层是否应用光照(该图层的光照开启与否将不再受SetSunLightingMode函数的影响)
   * @param {Boolean} value
   */
  async setLightingEnabled(value) {
    try {
      let result = await VL3.setLightingEnabled(this._MGVectorLayer3DId, value);
      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description 设置图层显示的透明度
   * @param {Integer} sAlpha 透明度，值为0-100，其中0为不透明
   * @return 1-成功；0-失败
   */
  async setTransparency(sAlpha) {
    try {
      let result = await VL3.setTransparency(this._MGVectorLayer3DId, sAlpha);
      return result;
    } catch (error) {
      console.error(error);
    }
  }
}
