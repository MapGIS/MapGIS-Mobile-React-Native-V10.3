/**
 * @content 交叉结构功能组件
 * @author  2019-09-25
 */
import { NativeModules } from 'react-native';

let CD = NativeModules.JSCrossData;

import Dot from './Dot.js';

/**
 * @class CrossData
 * @description 交叉结构
 */
export default class CrossData {
  /**
   * 构造一个新的 CrossData 对象。
   * @memberOf CrossData
   * @returns {Promise.<CrossData>}
   */
  async createObj() {
    try {
      var { CrossDataId } = await CD.createObj();
      var crossData = new CrossData();
      crossData._MGCrossDataId = CrossDataId;
      return crossData;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 交点坐标
   * @memberof CrossData
   * @returns {Promise.<Dot>} 交点坐标
   */
  async getCross() {
    try {
      let { point2DId } = await CD.getCross(this._MGCrossDataId);
      var dot = new Dot();
      dot._MGDotId = point2DId;
      return dot;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 线A编号
   * @memberof CrossData
   * @returns {Promise.<int>} 线A编号
   */
  async getDoteA() {
    try {
      return await CD.getDoteA(this._MGCrossDataId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 线B编号
   * @memberof CrossData
   * @returns {Promise.<int>}线B编号
   */
  async getDoteB() {
    try {
      return await CD.getDoteB(this._MGCrossDataId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 前一个点的坐标
   * @memberof CrossData
   * @returns {Promise.<Dot>} 前一个点的坐标
   */
  async getDotAxy() {
    try {
      let { point2DId } = await CD.getDotAxy(this._MGCrossDataId);
      var dot = new Dot();
      dot._MGDotId = point2DId;
      return dot;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 前一个点的坐标
   * @memberof CrossData
   * @returns {Promise.<Dot>} 前一个点的坐标
   */
  async getDotBxy() {
    try {
      let { point2DId } = await CD.getDotBxy(this._MGCrossDataId);
      var dot = new Dot();
      dot._MGDotId = point2DId;
      return dot;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 交点的idx
   * @memberof CrossData
   * @returns {Promise.<int>} 交点的idx
   */
  async getlineAno() {
    try {
      return await CD.getlineAno(this._MGCrossDataId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 交点在被插入时是否被访问
   * @memberof CrossData
   * @returns {Promise.<int>} 交点在被插入时是否被访问
   */
  async getlineBno() {
    try {
      return await CD.getlineBno(this._MGCrossDataId);
    } catch (e) {
      console.error(e);
    }
  }
}
