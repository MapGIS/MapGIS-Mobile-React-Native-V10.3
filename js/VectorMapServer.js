/*
 * @Description: In User Settings Edit
 * @Author: xiaoying
 * @Date: 2019-09-04 14:29:07
 * @LastEditTime: 2019-09-11 19:56:38
 * @LastEditors: mayuanye
 */
import { NativeModules } from 'react-native';
import MapServer from './MapServer.js';
let VMS = NativeModules.JSVectorMapServer;

/**
 * @class VectorMapServer
 * @description 矢量地图服务
 */
export default class VectorMapServer extends MapServer {
  constructor() {
    super();
    Object.defineProperty(this, '_MGVectorMapServerId', {
      get: function() {
        return this._MGMapServerId;
      },
      set: function(_MGVectorMapServerId) {
        this._MGMapServerId = _MGVectorMapServerId;
      },
    });
  }

  /**
   * 创建一个新的VectorMapServer对象
   *
   * @memberof VectorMapServer
   * @returns {Promise<VectorMapServer>}
   */
  async createObj() {
    try {
      var { VectorMapServerId } = await VMS.createObj();
      var vectorMapServer = new VectorMapServer();
      vectorMapServer._MGVectorMapServerId = VectorMapServerId;
      return vectorMapServer;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取动态参照系个数
   *
   * @memberof VectorMapServer
   * @returns {int} 照系个数
   */
  async getCRSCount() {
    try {
      let crsCount = await VMS.getCRSCount(this._MGVectorMapServerId);
      return crsCount;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取索引对应的动态参照系名称
   *
   * @memberof VectorMapServer
   * @param {int} index 参照系索引
   * @returns {String} 参照系名称
   */
  async getCRS(index) {
    try {
      let crs = await VMS.getCRS(this._MGVectorMapServerId, index);
      return crs;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置当前动态参照系名称
   *
   * @memberof VectorMapServer
   * @param {String} strCRS 参照系名称
   * @returns {int}  1-成功 ；0-失败
   */
  async setCurrentCRS(strCRS) {
    try {
      let result = await VMS.setCurrentCRS(this._MGVectorMapServerId, strCRS);
      return result;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取当前动态参照系名称
   *
   * @memberof VectorMapServer
   * @returns {String}  参照系名称
   */
  async getCurrentCRS() {
    try {
      let currentCRS = await VMS.getCurrentCRS(this._MGVectorMapServerId);
      return currentCRS;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取矢量图像
   *
   * @memberof VectorMapServer
   * @returns {Array}  矢量图像数据 (int类型的Array)
   */
  async getVectorImage(
    imgWidth,
    imgHeight,
    disPRectXMin,
    disPRectYMin,
    disPRectXMax,
    disPRectYMax
  ) {
    try {
      let buf = await VMS.getVectorImage(
        this._MGVectorMapServerId,
        imgWidth,
        imgHeight,
        disPRectXMin,
        disPRectYMin,
        disPRectXMax,
        disPRectYMax
      );
      return buf;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 释放矢量图像数据
   *
   * @memberof VectorMapServer
   * @param {Array} buf 矢量图像数据
   * @returns {int}  1-成功 ；0-失败
   */
  async freeVectorImage(buf) {
    try {
      let result = await VMS.freeVectorImage(this._MGVectorMapServerId, buf);
      return result;
    } catch (e) {
      console.error(e);
    }
  }
}
