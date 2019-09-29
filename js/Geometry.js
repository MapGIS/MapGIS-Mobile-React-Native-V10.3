/**
 * @content 抽象基类，用于定义所有的几何对象基类功能组件
 * @author  2019-09-09
 */
import { NativeModules } from 'react-native';
import Rect from './Rect.js';

let G = NativeModules.JSGeometry;

/**
 * @class Geometry
 */
export default class Geometry {
  /**
   * 清空几何数据
   * @memberOf Geometry
   * @returns {Promise} 清空数据成功返回1，失败返回0
   */
  async empty() {
    try {
      return await G.empty(this._MGGeometryId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 计算外包围盒
   * @memberOf Geometry
   * @returns {Promise.<Rect>} 包围盒信息
   */
  async calRect() {
    try {
      let { RectId } = await G.calRect(this._MGGeometryId);
      var rect = new Rect();
      rect._MGRectId = RectId;
      return rect;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 是否在矩形内
   * @memberOf Geometry
   * @param rect 待比较的包围盒对象
   * @returns {Promise} 在包围盒内返回1，不在返回0
   */
  async isInRect(rect) {
    try {
      return await G.isInRect(this._MGGeometryId, rect._MGRectId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 是否和矩形相交
   * @memberOf Geometry
   * @param rect 待比较的包围盒对象
   * @returns {Promise} 和包围盒相交返回1，不相交返回0
   */
  async isInterRect(rect) {
    try {
      return await G.isInterRect(this._MGGeometryId, rect._MGRectId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 取几何维数
   * @memberOf Geometry
   * @return {Promise}几何维数
   */
  async getDimension() {
    try {
      return await G.getDimension(this._MGGeometryId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取存储内容长度
   * @memberOf Geometry
   * @return {Promise}存储长度
   */
  async length() {
    try {
      return await G.length(this._MGGeometryId);
    } catch (e) {
      console.error(e);
    }
  }
}
