/**
 * @content 抽象基类，用于定义所有的几何对象基类功能组件
 * @author  2019-09-09
 */
import { NativeModules } from 'react-native';
import Geometry from './Geometry.js';

let GE = NativeModules.JSGeometryExp;

/**
 * @class GeometryExp
 */
export default class GeometryExp extends Geometry {
  /**
   * 投影变换
   * @memberOf Geometry
   * @param ptOrigSRef 原始投影系
   * @param ptDestSRef 目标投影系
   * @returns {Promise.<Geometry>} 投影后的几何对象
   */
  async transSRS(origSRef, destSRef) {
    try {
      let { GeometryId } = await GE.transSRS(
        this._MGGeometryId,
        origSRef._MGSRefDataId,
        destSRef._MGSRefDataId
      );
      var geometry = new Geometry();
      geometry._MGGeometryId = GeometryId;
      return geometry;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 投影变换
   * @memberOf Geometry
   * @param ptOrigSRef 原始投影系
   * @param ptDestSRef 目标投影系
   * @param param 椭球坐标系变换参数
   * @returns {Promise.<Geometry>} 投影后的几何对象
   */
  async transSRSOfParam(origSRef, destSRef, param) {
    try {
      let { GeometryId } = await GE.transSRS(
        this._MGGeometryId,
        origSRef._MGSRefDataId,
        destSRef._MGSRefDataId,
        param._MGElpTransParamId
      );
      var geometry = new Geometry();
      geometry._MGGeometryId = GeometryId;
      return geometry;
    } catch (e) {
      console.error(e);
    }
  }
}
