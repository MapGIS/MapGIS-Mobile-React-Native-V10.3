/*
 * @Description: 三维服务图层组件
 * @Version: 1.0
 * @Autor: liaoliang
 * @Date: 2020-07-16 17:06:26
 * @LastEditors: liaoliang
 * @LastEditTime: 2020-07-21 17:05:19
 */

import { NativeModules } from 'react-native';
import GroupLayer3D from './GroupLayer3D';

let SL3 = NativeModules.JSServerLayer3D;

export default class ServerLayer3D extends GroupLayer3D {
  constructor() {
    super();
    Object.defineProperty(this, '_MGServerLayer3DId', {
      get: function () {
        return this._MGLayer3DId;
      },
      set: function (_MGServerLayer3DId) {
        this._MGLayer3DId = _MGServerLayer3DId;
      },
    });
  }

  /**
   * @description: 构造一个新的 ServerLayer3D 对象
   * @param {type}
   * @return:
   */
  async createObj() {
    try {
      var { serverLayer3DId } = await SL3.createObj();
      var serverLayer3D = new ServerLayer3D();
      serverLayer3D._MGServerLayer3DId = serverLayer3DId;
      return serverLayer3D;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 清除m3d模型缓存
   * @param {type}
   * @return: 成功返回true,失败返回false
   */
  async clearCache() {
    try {
      let result = await SL3.clearCache(this._MGServerLayer3DId);

      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 连接数据(真实地连接数据源，可以获取服务返回相关信息 如HDF瓦片信息。)
   * @param {type}
   * @return: 1-成功；0-失败
   */
  async connectData() {
    try {
      let result = await SL3.connectData(this._MGServerLayer3DId);

      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 获取图层范围
   * @param {String} rectId
   * @return: 1-成功；0-失败
   */
  async getExtent(rectId) {
    try {
      let result = await SL3.getExtent(this._MGServerLayer3DId, rectId);

      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 获取图层三维范围
   * @param {String} rect3DId
   * @return: 1-成功；0-失败
   */
  async getExtentOf3D(rect3DId) {
    try {
      let result = SL3.getExtentOf3D(this._MGServerLayer3DId, rect3DId);

      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 获取图层数
   * @param {type}
   * @return:
   */
  async getLayerCount() {
    try {
      let layerCountNum = SL3.getLayerCount(this._MGServerLayer3DId);

      return layerCountNum;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 获取图层参考系
   * @param {String} SRefDataId
   * @return: 1-成功；0-失败
   */
  async getSRS(SRefDataId) {
    try {
      let result = SL3.getSRS(this._MGServerLayer3DId);

      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 获取图层显示模式透明度
   * @param {int} sAlpha
   * @return: 1-成功；0-失败
   */
  async getTransparency(sAlpha) {
    try {
      let result = SL3.getTransparency(this._MGServerLayer3DId, sAlpha);

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
      let typeValue = await SL3.getType(this._MGServerLayer3DId);

      return typeValue;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 获取服务地址URL
   * @param {type}
   * @return:
   */
  async getURL() {
    try {
      let url = await SL3.getURL(this._MGServerLayer3DId);

      return url;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 获取服务数据源缩放级范围
   * @param {String}  minZoomId IntUser对象的id
   * @param {String}  maxZoomId IntUser对象的id
   * @return:
   */
  async getZoomCapacity(minZoomId, maxZoomId) {
    try {
      let zoomCapacity = await SL3.getZoomCapacity(
        this._MGServerLayer3DId,
        minZoomId,
        maxZoomId
      );

      return zoomCapacity;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 图层数据是否有效
   * @param {type}
   * @return:
   */
  async isValid() {
    try {
      let result = await SL3.isValid(this._MGServerLayer3DId);

      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description 设置图层显示的透明度
   * @param {int} sAlpha 透明度，值为0-100，其中0为不透明
   * @return 1-成功；0-失败
   */
  async setTransparency(sAlpha) {
    try {
      let result = await SL3.setTransparency(this._MGServerLayer3DId, sAlpha);

      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 设置服务地址URL
   * @param {String} strURL
   * @return:
   */
  async setURL(strURL) {
    try {
      let result = await SL3.setURL(this._MGServerLayer3DId, strURL);

      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 设置服务数据源缩放级范围
   * @param {int}  minZoom
   * @param {int}  maxZoom
   * @return: 成功返回1,失败返回0
   */
  async setZoomCapacity(minZoom, maxZoom) {
    try {
      let result = await SL3.setZoomCapacity(
        this._MGServerLayer3DId,
        minZoom,
        maxZoom
      );

      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 根据类型创建地图服务
   * @param {String} type MapServer中的类型常量
   * @return:
   */
  async createMapServer(type) {
    try {
      let mapServerId = await SL3.createMapServer(
        this._MGServerLayer3DId,
        type
      );

      return mapServerId;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 获取地图服务对象
   * @param {type}
   * @return:
   */
  async getMapServer() {
    try {
      let mapServerId = await SL3.getMapServer(this._MGServerLayer3DId);

      return mapServerId;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 设置服务
   * @param {String} mapServerId
   * @return:
   */
  async setMapServer(mapServerId) {
    try {
      let result = await SL3.setMapServer(this._MGServerLayer3DId, mapServerId);

      return result;
    } catch (error) {
      console.error(error);
    }
  }
}
