/*
 * @Description: In User Settings Edit
 * @Author: xiaoying
 * @Date: 2019-09-04 10:01:04
 * @LastEditTime: 2019-09-12 15:24:12
 * @LastEditors: mayuanye
 */
import { NativeModules } from 'react-native';
import MapServer from './MapServer.js';
import Dot from './Dot.js';
let TMS = NativeModules.JSTileMapServer;

/**
 * @class TileMapServer
 * @description 瓦片地图服务
 */
export default class TileMapServer extends MapServer {
  constructor() {
    super();
    Object.defineProperty(this, '_MGTileMapServerId', {
      get: function() {
        return this._MGMapServerId;
      },
      set: function(_MGTileMapServerId) {
        this._MGMapServerId = _MGTileMapServerId;
      },
    });
  }
  /**
   * 创建一个新的TileMapServer对象
   *
   * @memberof TileMapServer
   * @returns {Promise<TileMapServer>}
   */
  async createObj() {
    try {
      var { TileMapServerId } = await TMS.createObj();
      var tileMapServer = new TileMapServer();
      tileMapServer._MGTileMapServerId = TileMapServerId;
      return tileMapServer;
    } catch (e) {
      console.error(e);
    }
  }

  //    /**
  //     * 获取瓦片的切片方式
  //     *
  //     * @memberof TileMapServer
  //     * @return {int} 返回瓦片的切片方式 ，例：1-TileSliceType.SliceWMTS
  //     * @description 默认为OGC_WMTS切片方式
  //     */
  //    async getTileSliceType(){
  //        try {
  //            let tileSliceType = await TMS.getTileSliceType(this._MGTileMapServerId);
  //            return tileSliceType;
  //        } catch (e) {
  //            console.error(e);
  //        }
  //    }

  /**
   * 设置最小显示缩放级
   *
   * @memberof TileMapServer
   * @param minZoom 最小显示缩放级
   * @return {Promise<Void>}
   */
  async setMinZoom(minZoom) {
    try {
      await TMS.setMinZoom(this._MGTileMapServerId, minZoom);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取最小显示缩放级
   *
   * @memberof TileMapServer
   * @return {int} 最小显示缩放级
   */
  async getMinZoom() {
    try {
      let minZoom = await TMS.getMinZoom(this._MGTileMapServerId);
      return minZoom;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置最大显示缩放级
   *
   * @memberof TileMapServer
   * @param maxZoom 最大显示缩放级
   * @return {Promise<Void>}
   */
  async setMaxZoom(maxZoom) {
    try {
      await TMS.setMaxZoom(this._MGTileMapServerId, maxZoom);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取最大显示缩放级
   *
   * @memberof TileMapServer
   * @return {int} 最大显示缩放级
   */
  async getMaxZoom() {
    try {
      let maxZoom = await TMS.getMaxZoom(this._MGTileMapServerId);
      return maxZoom;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取服务数据源缩放级范围
   *
   * @memberof TileMapServer
   * @param {Object} minZoom 数据源最小缩放级（Object--IntUser）
   * @param {Object} maxZoom 数据源最大缩放级（Object--IntUser）
   * @returns {boolean} 成功返回true
   */
  async getZoomCapacity(minZoom, maxZoom) {
    try {
      let result = await TMS.getZoomCapacity(
        this._MGTileMapServerId,
        minZoom._MGIntUserId,
        maxZoom._MGIntUserId
      );
      return result;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取瓦片裁剪原点
   *
   * @memberof TileMapServer
   * @returns {Promise<Dot>} 瓦片裁剪原点
   */
  async getTileOriginXY() {
    try {
      var { point2DId } = await TMS.getTileOriginXY(this._MGTileMapServerId);
      var dot = new Dot();
      dot._MGDotId = point2DId;
      return dot;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获得瓦片的高宽大小
   *
   * @memberof TileMapServer
   * @param {Object} width 瓦片宽（像素） （Object--IntUser）
   * @param {Object} height 瓦片高（像素）（Object--IntUser）
   * @returns {boolean} 成功返回true
   */
  async getTileSize(width, height) {
    try {
      let result = await TMS.getTileSize(
        this._MGTileMapServerId,
        width._MGIntUserId,
        height._MGIntUserId
      );
      return result;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置缩放级对应的瓦片分辨率（logic/pixel）
   *
   * @memberof TileMapServer
   * @param {int} zoom 瓦片缩放级
   * @param {double} dResolution dResolution 瓦片分辨率
   * @returns {int} 1-成功；0-失败
   */
  async setTileResolution(zoom, dResolution) {
    try {
      let result = await TMS.setTileResolution(
        this._MGTileMapServerId,
        zoom,
        dResolution
      );
      return result;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获得缩放级对应的瓦片分辨率(logic/pixel)
   *
   * @memberof TileMapServer
   * @param {int} zoom 瓦片缩放级
   * @returns {double} 瓦片分辨率
   */
  async getTileResolution(zoom) {
    try {
      let tileResolution = await TMS.getTileResolution(
        this._MGTileMapServerId,
        zoom
      );
      return tileResolution;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获得缩放级别对应的地面分辨率,与Y值有关（dLogY纬度）
   *
   * @memberof TileMapServer
   * @param {int} zoom 瓦片缩放级
   * @param {double} dLogY 纬度
   * @returns {double} 地面分辨率
   */
  async getGroundResolution(zoom, dLogY) {
    try {
      let groundResolution = await TMS.getGroundResolution(
        this._MGTileMapServerId,
        zoom,
        dLogY
      );
      return groundResolution;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取缩放级对应的比例尺
   *
   * @memberof TileMapServer
   * @param {int} zoom 瓦片缩放级
   * @param {double} dLogY 纬度
   * @returns {double} 返回比例尺
   * @description 获取比例尺=图上距离/实地距离，图上距离通过瓦片像素反算成米，实地距离通过地球半径与纬度计算
   */
  async getScale(zoom, dLogY) {
    try {
      let scale = await TMS.getScale(this._MGTileMapServerId, zoom, dLogY);
      return scale;
    } catch (e) {
      console.error(e);
    }
  }

  //    /**
  //     * 获得缩放级别对应的有效瓦片矩阵行列值
  //     *
  //     * @memberof TileMapServer
  //     * @param {int} zoom 缩放级
  //     * @param {Object} topRow 上（起始）行号
  //     * @param {Object} leftCol 左（起始）列号
  //     * @param {Object} bottomRow 下（终止）行号
  //     * @param {Object} rightCol 右（终止）列号
  //     * @returns {boolean} 成功返回true
  //     */
  //    async getTileMatrix(zoom, topRow, leftCol, bottomRow, rightCol){
  //        try {
  //            let result = await TMS.getTileMatrix(this._MGTileMapServerId, zoom, topRow._MGIntUserId, leftCol._MGIntUserId, bottomRow._MGIntUserId, rightCol._MGIntUserId);
  //            return result ;
  //        } catch (e) {
  //            console.error(e);
  //        }
  //    }

  /**
   * 根据URL获取瓦片图像
   *
   * @memberof TileMapServer
   * @param {String} strURL 瓦片图像的URL
   * @returns {Array} 瓦片图像数据 （int类型的数组）
   */
  async getTileImageByURL(strURL) {
    try {
      let array = await TMS.getTileImageByURL(this._MGTileMapServerId, strURL);
      return array;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 根据行列号、缩放级获取瓦片图像
   *
   * @memberof TileMapServer
   * @param {int} row 瓦片行索引
   * @param {int} col 瓦片列索引
   * @param {int} zoom 瓦片缩放级
   * @returns {Array} 瓦片图像数据 （int类型的数组）
   */
  async getTileImage(row, col, zoom) {
    try {
      let array = await TMS.getTileImage(
        this._MGTileMapServerId,
        row,
        col,
        zoom
      );
      return array;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 释放瓦片图像数据
   *
   * @memberof TileMapServer
   * @param {Array} buf 瓦片图像数据
   * @returns {boolean} 成功返回true
   */
  async freeTileImage(buf) {
    try {
      let result = await TMS.freeTileImage(this._MGTileMapServerId, buf);
      return result;
    } catch (e) {
      console.error(e);
    }
  }
}
