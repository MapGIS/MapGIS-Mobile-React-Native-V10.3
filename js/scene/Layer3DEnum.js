/*
 * @Description: 三维组图层的图层枚举
 * @Version: 1.0
 * @Autor: liaoliang
 * @Date: 2020-07-03 10:42:31
 * @LastEditors: liaoliang
 * @LastEditTime: 2020-07-08 10:26:51
 */

import { NativeModules } from 'react-native';
import Scene from './Scene.js';

let L3E = NativeModules.JSLayer3DEnum;

/**
 * @class Layer3DEnum
 * @Description 三维组图层的图层枚举
 */
export default class Layer3DEnum {
  /**
   * @Description:构造一个新的Layer3DEnum对象
   * @param {type}
   * @return:
   */
  async createObj() {
    try {
      var { Layer3DEnumId } = await L3E.createObj();
      var layer3DEnum = new Layer3DEnum();
      layer3DEnum._MGLayer3DEnumId = Layer3DEnumId;
      return layer3DEnum;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @Description:初始化
   * @param {Array} layer3Ds 3D图层列表
   * @return:
   */
  async init(layer3Ds) {
    try {
      let result = await L3E.init(this._MGLayer3DEnumId, layer3Ds);

      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @Description:光标置前
   * @param {type}
   * @return {boolean}
   */
  async moveToFirst() {
    try {
      let result = await L3E.moveToFirst(this._MGLayer3DEnumId);

      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @Description:光标置后
   * @param {type}
   * @return {boolean}
   */
  async moveToLast() {
    try {
      let result = await L3E.moveToLast(this._MGLayer3DEnumId);
      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @Description: 获取下一个图层
   * @param {type}
   * @return:
   */
  async next() {
    try {
      let layer3D = null;
      var { Layer3DId } = await L3E.next(this._MGLayer3DEnumId);
      if (Layer3DId !== null) {
        layer3D = await Scene.creatLayer3DInstanceByID(Layer3DId);
      }

      return layer3D;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @Description: 获取上一个图层
   * @param {type}
   * @return:
   */
  async prev() {
    try {
      let layer3D = null;
      var { Layer3DId } = await L3E.prev(this._MGLayer3DEnumId);
      if (Layer3DId !== null) {
        layer3D = await Scene.creatLayer3DInstanceByID(Layer3DId);
      }

      return layer3D;
    } catch (error) {
      console.error(error);
    }
  }
}
