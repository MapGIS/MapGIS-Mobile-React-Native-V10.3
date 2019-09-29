/*
 * @Description: In User Settings Edit
 * @Author: xiaoying
 * @Date: 2019-09-09 11:00:03
 * @LastEditTime: 2019-09-09 11:23:27
 * @LastEditors: Please set LastEditors
 */
import { NativeModules } from 'react-native';
import TileMapServer from './TileMapServer.js';
let OGCWMTSM = NativeModules.JSOGCWMTSMapServer;

/**
 * @class OGCWMTSMapServer
 * @description OGCWMTS地图服务
 */
export default class OGCWMTSMapServer extends TileMapServer {
  constructor() {
    super();
    Object.defineProperty(this, '_MGOGCWMTSMapServerId', {
      get: function() {
        return this._MGTileMapServerId;
      },
      set: function(_MGOGCWMTSMapServerId) {
        this._MGTileMapServerId = _MGOGCWMTSMapServerId;
      },
    });
  }

  /**
   * 获取所有图层的名称
   *
   * @memberof OGCWMTSMapServer
   * @returns {Array} 图层名称列表
   */
  async getLayerNames() {
    try {
      let layerNames = await OGCWMTSM.getLayerNames(this._MGOGCWMTSMapServerId);
      return layerNames;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取某一图层下所有瓦片集的名称
   *
   * @memberof OGCWMTSMapServer
   * @param {Number} layerIndex int类型的图层索引
   * @returns {Array} 瓦片集名称列表
   */
  async getLayerMatrixSetNames(layerIndex) {
    try {
      let layerMatrixSetNames = await OGCWMTSM.getLayerMatrixSetNames(
        this._MGOGCWMTSMapServerId,
        layerIndex
      );
      return layerMatrixSetNames;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取当前图层名称
   *
   * @memberof OGCWMTSMapServer
   * @returns {String} 当前图层名称
   */
  async getCurLayerName() {
    try {
      let curLayerName = await OGCWMTSM.getCurLayerName(
        this._MGOGCWMTSMapServerId
      );
      return curLayerName;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取当前瓦片集名称
   *
   * @memberof OGCWMTSMapServer
   * @returns {String} 当前瓦片集名称
   */
  async getCurTileMatrixSetName() {
    try {
      let curTileMatrixSetName = await OGCWMTSM.getCurTileMatrixSetName(
        this._MGOGCWMTSMapServerId
      );
      return curTileMatrixSetName;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取当前风格名称
   *
   * @memberof OGCWMTSMapServer
   * @returns {String} 当前风格名称
   */
  async getCurStyleName() {
    try {
      let curStyleName = await OGCWMTSM.getCurStyleName(
        this._MGOGCWMTSMapServerId
      );
      return curStyleName;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置当前图层信息
   *
   * @memberof OGCWMTSMapServer
   * @param {String} layerName        图层名称
   * @param {String} matrixSetName    瓦片集名称，该瓦片集必须在layerName图层下
   * @param {String} styleName        扩展接口，暂时无需设置
   * @returns {Promise<Void>}
   */
  async setCurLayerInfo(layerName, matrixSetName, styleName) {
    try {
      await OGCWMTSM.setCurLayerInfo(
        this._MGOGCWMTSMapServerId,
        layerName,
        matrixSetName,
        styleName
      );
    } catch (e) {
      console.error(e);
    }
  }
}
