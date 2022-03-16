/*
 * @Description: 三维图层类的基类
 * @Version: 1.0
 * @Autor: liaoliang
 * @Date: 2020-07-08 09:44:59
 * @LastEditors: liaoliang
 * @LastEditTime: 2020-07-08 11:16:04
 */

import { NativeModules } from 'react-native';

let L3 = NativeModules.JSLayer3D;

export default class Layer3D {
  /**
   * @Description: 构造一个新的Rect3D对象
   * @param {type}
   * @return:
   */
  async createObj() {
    try {
      var { layer3DId } = await L3.createObj();
      var layer3D = new Layer3D();
      layer3D._MGLayer3DId = layer3DId;
      return layer3D;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @Description: 获取图层驱动类型
   * @param {type}
   * @return: {String}
   */
  async getDriverType() {
    try {
      let driverType = await L3.getDriverType(this._MGLayer3DId);
      return driverType;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @Description: 获得图层标识（整型数字）
   * @param {type}
   * @return:
   */
  async getLayerRenderIndex() {
    try {
      let layerRenderIndex = await L3.getLayerRenderIndex(this._MGLayer3DId);
      return layerRenderIndex;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @Description: 获取起止LOD级别,成功返回1，失败返回0
   * @param {int} lBeginLevel 起始级别
   * @param {int} lEndLevel 终止级别
   * @return: 成功返回1，失败返回0
   */
  async getLODLevel(lBeginLevel, lEndLevel) {
    try {
      let result = await L3.getLODLevel(
        this._MGLayer3DId,
        lBeginLevel,
        lEndLevel
      );
      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @Description: 获取图层参考系
   * @param {type}
   * @return:
   */
  async getSRSString() {
    try {
      let SRSString = await L3.getSRSString(this._MGLayer3DId);
      return SRSString;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @Description: 设置图层驱动类型
   * @param {String} strDriverType
   * @return: 成功返回1，失败返回0
   */
  async setDriverType(strDriverType) {
    try {
      let result = await L3.setDriverType(this._MGLayer3DId, strDriverType);
      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @Description: 设置图层标识
   * @param {int} renderIndex
   * @return: 成功返回1，失败返回0
   */
  async setLayerRenderIndex(renderIndex) {
    try {
      let result = await L3.setLayerRenderIndex(this._MGLayer3DId, renderIndex);
      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @Description: 设置起止LOD级别,成功返回1，失败返回0
   * @param {int} lBeginLevel 起始级别
   * @param {int} lEndLevel 终止级别
   * @return: 成功返回1，失败返回0
   */
  async setLODLevel(lBeginLevel, lEndLevel) {
    try {
      let result = await L3.setLODLevel(
        this._MGLayer3DId,
        lBeginLevel,
        lEndLevel
      );
      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @Description: 通过字符串设置图层参考系
   * @param {String} strSRSType
   * @return: 成功返回1，失败返回0
   */
  async setSRSByString(strSRSType) {
    try {
      let result = await L3.L3.setSRSByString(this._MGLayer3DId, strSRSType);
      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @Description: 获取图层三维范围
   * @param {String} rect3DId
   * @return: 1-成功；0-失败
   */
  async getExtent(rect3DId) {
    try {
      let result = await L3.getExtent(this._MGLayer3DId, rect3DId);
      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @Description: 获取三维显示比
   * @param {String} dot3DId
   * @return: 1-成功；0-失败
   */
  async getScale(dot3DId) {
    try {
      let result = await L3.getScale(this._MGLayer3DId, dot3DId);
      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @Description: 获取图层类型的值
   * @param {type}
   * @return:
   */
  async getType() {
    try {
      let typeValue = await L3.getType(this._MGLayer3DId);
      return typeValue;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @Description: 设置图层三维范围
   * @param {String} rect3DId
   * @return: 1-成功；0-失败
   */
  async setExtent(rect3DId) {
    try {
      let result = await L3.setExtent(this._MGLayer3DId, rect3DId);
      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @Description: 设置三维显示比
   * @param {String} dot3DId
   * @return: 1-成功；0-失败
   */
  async setScale(dot3DId) {
    try {
      let result = await L3.setScale(this._MGLayer3DId, dot3DId);
      return result;
    } catch (error) {
      console.error(error);
    }
  }
}
