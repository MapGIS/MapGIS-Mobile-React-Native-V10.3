/**
 * @content 用于对多边形的几何功能组件
 * @author  2019-09-09
 */
import { NativeModules } from 'react-native';

let GPG = NativeModules.JSGeoPolygon;

import GeometryExp from './GeometryExp.js';
import GeoLines from './GeoLines.js';
import Dots from './Dots.js';

/**
 * @class GeoPolygon
 */
export default class GeoPolygon extends GeometryExp {
  constructor() {
    super();
    Object.defineProperty(this, '_MGGeoPolygonId', {
      get: function() {
        return this._MGGeometryId;
      },
      set: function(_MGGeoPolygonId) {
        this._MGGeometryId = _MGGeoPolygonId;
      },
    });
  }

  /**
   * 构造一个新的 GeoPolygon 对象
   * @memberOf GeoPolygon
   * @return {Promise<GeoPolygon>}
   */
  async createObj() {
    try {
      var { GeoPolygonId } = await GPG.createObj();
      var geoPolygon = new GeoPolygon();
      geoPolygon._MGGeoPolygonId = GeoPolygonId;
      return geoPolygon;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取几何对象的类型
   * @memberOf GeoPolygon
   * @return {Promise} 几何对象类型
   */
  async getType() {
    try {
      return await GPG.getType(this._MGGeoPolygonId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 取几何维数
   * @memberOf GeoPolygon
   * @return {Promise}几何维数
   */
  async getDimension() {
    try {
      return await GPG.getDimension(this._MGGeoPolygonId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 计算两个几何对象间的距离
   * @memberOf GeoPolygon
   * @param type 距离计算方法
   * @param destGeom 第二个几何对象
   * @return {Promise} 距离长度
   */
  async distance(type, destGeom) {
    try {
      return await GPG.distance(
        this._MGGeoPolygonId,
        type,
        destGeom._MGGeometryId
      );
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 删除多边形
   * @memberOf GeoPolygon
   * @param index 待删除多边形序号
   * @return {Promise} 删除成功返回1，失败返回0
   */
  async del(index) {
    try {
      return await GPG.del(this._MGGeoPolygonId, index);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 取圆线数目
   * @memberOf GeoPolygon
   * @return {Promise} 圆线的总个数
   */
  async getCircleNum() {
    try {
      return await GPG.getCircleNum(this._MGGeoPolygonId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 添加多线
   * @memberOf GeoPolygon
   * @param ptLines 待添加的多线对象
   * @return {Promise} 添加成功返回1，失败返回0
   */
  async append(geoLines) {
    try {
      return await GPG.append(this._MGGeoPolygonId, geoLines._MGGeoLinesId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 取多线
   * @memberOf GeoPolygon
   * @param index 待取的多线的序号
   * @return {Promise<GeoLines>} 获取的多线对象
   */
  async get(index) {
    try {
      let { GeoLinesId } = await GPG.get(this._MGGeoPolygonId, index);
      var geoLines = new GeoLines();
      geoLines._MGGeoLinesId = GeoLinesId;
      return geoLines;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 由点构造多边形
   * @memberOf GeoPolygon
   * @param dots 待设置的所有点序列
   * @param {Array}numArray 每条线的点个数列表
   * @return {Promise} 构造成功返回1，失败返回0
   */
  async setDots(dots, numArray) {
    try {
      return await GPG.setDots(this._MGGeoPolygonId, dots._MGDotsId, numArray);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取一圈的点序列
   * @memberOf GeoPolygon
   * @param index 待取的点序列的序号
   * @return {Promise<Dots>} 获取的点序列
   */
  async getDots(index) {
    try {
      let { DotsId } = await GPG.getDots(this._MGGeoPolygonId, index);
      var dots = new Dots();
      dots._MGDotsId = DotsId;
      return dots;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 求多边形面积
   * @memberOf GeoPolygon
   * @param sRef 投影系
   * @return {Promise} 面积
   */
  async calAreaOfSRef(sRef) {
    try {
      return await GPG.calAreaOfSRef(this._MGGeoPolygonId, sRef._MGSRefDataId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 求多边形面积
   * @memberOf GeoPolygon
   * @return {Promise} 面积
   */
  async calArea() {
    try {
      return await GPG.calArea(this._MGGeoPolygonId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 求周长
   * @memberOf GeoPolygon
   * @param sRef 投影系
   * @return {Promise}周长
   */
  async calPerimeterOfSRef(sRef) {
    try {
      return await GPG.calPerimeter(this._MGGeoPolygonId, sRef._MGSRefDataId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 求周长
   * @memberOf GeoPolygon
   * @return {Promise}周长
   */
  async calPerimeter() {
    try {
      return await GPG.calPerimeter(this._MGGeoPolygonId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 求label点
   * @memberOf GeoPolygon
   * @return {Promise}周长
   */
  async calLabel(label) {
    try {
      return await GPG.calLabel(this._MGGeoPolygonId, label._MGDotId);
    } catch (e) {
      console.error(e);
    }
  }
}
