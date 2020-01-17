/**
 * @content 空间计算组件 仅包含简单的角度计算和两点距离计算 已包含在几何类内部的计算有：计算机长度、实地长度、计算机面积、实地面积、几何范围、label点等
 * @author  2019-09-25
 */
import { NativeModules } from 'react-native';

let SPC = NativeModules.JSSpaCalculator;

import Dot from './Dot.js';
import CrossData from './CrossData.js';

/**
 * @class SpaCalculator
 * @description 空间计算
 */
export default class SpaCalculator {
  /**
   * 计算直线角度(-PI到+PI)
   * @memberOf SpaCalculator
   * @param {Dot} xy0 点坐标
   * @param {Dot} xy1 点坐标
   * @return {Promise.<double>}直线角度(-PI到+PI)
   */
  static async anglePIOfDot(xy0, xy1) {
    try {
      return await SPC.anglePIOfDot(xy0._MGDotId, xy1._MGDotId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 计算直线角度(-PI到+PI)
   * @memberOf SpaCalculator
   * @param {double} x0 x0坐标
   * @param {double} y0 y0坐标
   * @param {double} x1 x1坐标
   * @param {double} y1 y1坐标
   * @return {Promise.<double>}直线角度(-PI到+PI)
   */
  static async anglePIOfXY(x0, y0, x1, y1) {
    try {
      return await SPC.anglePIOfXY(x0, y0, x1, y1);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 计算直线角度(0到2PI)
   * @memberOf SpaCalculator
   * @param {Dot} xy0 点坐标
   * @param {Dot} xy1 点坐标
   * @return {Promise.<double>} 直线角度(0到2PI)
   */
  static async angle2PIOfDot(xy0, xy1) {
    try {
      return await SPC.angle2PIOfDot(xy0._MGDotId, xy1._MGDotId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 计算直线角度(0到2PI)
   * @memberOf SpaCalculator
   * @param {double} x0 x0坐标
   * @param {double} y0 y0坐标
   * @param {double} x1 x1坐标
   * @param {double} y1 y1坐标
   * @return {Promise.<double>} 直线角度(0到2PI)
   */
  static async angle2PIOfXY(x0, y0, x1, y1) {
    try {
      return await SPC.angle2PIOfXY(x0, y0, x1, y1);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 计算两点距离
   * @memberOf SpaCalculator
   * @param {Dot} xy0 点坐标
   * @param {Dot} xy1 点坐标
   * @return {Promise.<double>} 两点距离
   */
  static async distanceOfDot(xy0, xy1) {
    try {
      return await SPC.distanceOfDot(xy0._MGDotId, xy1._MGDotId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 计算两点距离
   * @memberOf SpaCalculator
   * @param {double} x0 x0坐标
   * @param {double} y0 y0坐标
   * @param {double} x1 x1坐标
   * @param {double} y1 y1坐标
   * @return {Promise.<double>}两点距离
   */
  static async distanceOfXY(x0, y0, x1, y1) {
    try {
      return await SPC.distanceOfXY(x0, y0, x1, y1);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 计算两个几何对象间的距离
   *                 **********************************************************************************
   *                 *        	*     点    	 *     线     	  *  区(单圈) 	*   多线 		*     多区 		*
   *                 **********************************************************************************
   *                 *   点   		*   min|max  *    min     *  min|max  	*  不支持   	*  不支持   		*
   *                 *   线   		*     min    *  min|max   *  不支持  		*  不支持   	*  不支持   		*
   *                 *  区(单圈)  	*   min|max  *  不支持    	  *    min    	*  不支持   	*  不支持   		*
   *                 *   多线 		*     min    *  min|max   *  不支持  		*  不支持   	*  不支持   		*
   *                 *   多区 		*   min|max  *  不支持    	  *    min    	*  不支持   	*  不支持   		*
   *                 **********************************************************************************
   *
   * @param {Geometry} geom1 几何对象1
   * @param {Geometry} geom2 几何对象2
   * @param {int} type 计算距离方法
   * @return {Promise.<double>} 距离长度
   */
  static async distanceOfGeometry(geom1, geom2, type) {
    try {
      return await SPC.distanceOfGeometry(geom1._MGGeometryId, geom2._MGGeometryId, type);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 计算两条线的交点
   * @memberOf SpaCalculator
   * @param {GeoVarLine} line1 线1
   * @param {GeoVarLine} line2 线2
   * @return {Promise.<Dot[]>} 两条线的交点
   */
  static async calLinesInters(line1, line2) {
    try {
      var objArr = [];
      let { LinesIntersArray } = await SPC.calLinesInters(
        line1._MGGeoVarLineId,
        line2._MGGeoVarLineId
      );
      for (var i = 0; i < LinesIntersArray.length; i++) {
        var dot = new Dot();
        dot._MGDotId = LinesIntersArray[i];
        objArr.push(dot);
      }
      return objArr;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   *  找出自相交的交点,自相交检查
   * @memberOf SpaCalculator
   * @param {Dot[]} pointArry          线坐标
   * @return {Promise.List<CrossData>} 交点数组
   */
  static async arcSelfCross(pointArry) {
    try {
      var objArr = [];
      let { CrossDataArray } = await SPC.arcSelfCross(pointArry);
      for (var i = 0; i < CrossDataArray.length; i++) {
        var crossData = new CrossData();
        crossData._MGCrossDataId = CrossDataArray[i];
        objArr.push(crossData);
      }
      return objArr;
    } catch (e) {
      console.error(e);
    }
  }
}
