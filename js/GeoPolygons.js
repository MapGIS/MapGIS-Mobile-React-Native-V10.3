/**
 * @content 用于对多边形的几何功能组件
 * @author  2019-09-09
 */
import { NativeModules } from 'react-native';

let GPGS = NativeModules.JSGeoPolygons;

import GeometryExp from './GeometryExp.js';
import GeoPolygon from './GeoPolygon.js';

/**
 * @class GeoPolygons
 */
export default class GeoPolygons extends GeometryExp {
  constructor() {
    super();
    Object.defineProperty(this, '_MGGeoPolygonsId', {
      get: function() {
        return this._MGGeometryId;
      },
      set: function(_MGGeoPolygonsId) {
        this._MGGeometryId = _MGGeoPolygonsId;
      },
    });
  }

  /**
   * 构造一个新的 GeoPolygons 对象
   * @memberOf GeoPolygons
   * @return {Promise<GeoPolygons>}
   */
  async createObj() {
    try {
      var { GeoPolygonsId } = await GPGS.createObj();
      var geoPolygons = new GeoPolygons();
      geoPolygons._MGGeoPolygonsId = GeoPolygonsId;
      return geoPolygons;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取几何对象的类型
   * @memberOf GeoPolygons
   * @return {Promise} 几何对象类型
   */
  async getType() {
    try {
      return await GPGS.getType(this._MGGeoPolygonsId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 取几何维数
   * @memberOf GeoPolygons
   * @return {Promise}几何维数
   */
  async getDimension() {
    try {
      return await GPGS.getDimension(this._MGGeoPolygonsId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 计算两个几何对象间的距离
   * @memberOf GeoPolygons
   * @param type 距离计算方法
   * @param destGeom 第二个几何对象
   * @return {Promise} 距离长度
   */
  async distance(type, destGeom) {
    try {
      return await GPGS.distance(
        this._MGGeoPolygonsId,
        type,
        destGeom._MGGeometryId
      );
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 删除多边形
   * @memberOf GeoPolygons
   * @param index 待删除多边形序号
   * @return {Promise} 删除成功返回1，失败返回0
   */
  async del(index) {
    try {
      return await GPGS.del(this._MGGeoPolygonsId, index);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 取多边形数目
   * @memberOf GeoPolygons
   * @return {Promise} 多边形的总个数
   */
  async getNum() {
    try {
      return await GPGS.getNum(this._MGGeoPolygonsId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 添加多边形
   * @memberOf GeoPolygons
   * @param reg 待添加的多边形
   * @return {Promise} 添加成功返回1，失败返回0
   */
  async append(reg) {
    try {
      return await GPGS.append(this._MGGeoPolygonsId, reg.MGGeopolygonId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 取多边形
   * @memberOf GeoPolygons
   * @param index 待取的多边形的序号
   * @return {Promise<GeoPolygon>} 获取的多边形对象
   */
  async getPolygon(index) {
    try {
      let { GeoPolygonId } = GPGS.getPolygon(this._MGGeoPolygonsId, index);
      var geoPolygon = new GeoPolygon();
      geoPolygon._MGGeoPolygonId = GeoPolygonId;
      return geoPolygon;
    } catch (e) {
      console.error(e);
    }
  }
}
