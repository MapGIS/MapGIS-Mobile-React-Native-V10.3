/**
 * @content 抽象基类，用于定义所有的线段对象基类功能组件
 * @author  2019-09-09
 */
import { NativeModules } from 'react-native';

let GL = NativeModules.JSGeoLine;

import GeometryExp from './GeometryExp.js';
import Dots from './Dots.js';
import Dots3D from './Dots3D.js';

/**
 * @class GeoLine
 */
export default class GeoLine extends GeometryExp {
  /**
   * 获取线中的二维点序列
   * @memberOf GeoLine
   * @return {Promise<Dots>}获取的二维点序列
   */
  async get2Dots() {
    try {
      let { DotsId } = await GL.get2Dots(this._MGGeoLineId);
      var dots = new Dots();
      dots._MGDotsId = DotsId;
      return dots;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取线中的三维点序列
   * @memberOf GeoLine
   * @return {Promise<Dots3D>}获取的三维点序列
   */
  async get3Dots() {
    try {
      let { Dots3DId } = await GL.get3Dots(this._MGGeoLineId);
      var dots3D = new Dots3D();
      dots3D._MGDots3DId = Dots3DId;
      return dots3D;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 计算线实地或者平面长度
   * @memberOf GeoLine
   * @param ptSRef 投影参数
   * @return {Promise}平面长度
   */
  async calLengthOfSRef(sRef) {
    try {
      return GL.calLength(this._MGGeoLineId, sRef._MGSRefDataId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取线段长度
   * @memberOf GeoLine
   * @return {Promise}长度值
   */
  async calLength() {
    try {
      return GL.calLength(this._MGGeoLineId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 离散化解析线为折线点
   * @memberOf GeoLine
   * @param dStep 步长
   * @return {Promise}成功返回1，失败返回0
   */
  async disperseToDots(dStep) {
    try {
      return await GL.disperseToDots(this._MGGeometryId, dStep);
    } catch (e) {
      console.error(e);
    }
  }
}
