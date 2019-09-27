/**
 * @content 热力点功能组件
 * @author
 */
import { NativeModules } from "react-native";

let HP = NativeModules.JSHeatmapPoint;

import Dot from "./Dot.js"
/**
 * @class HeatmapPoint
 */
export default class HeatmapPoint {
    /**
   * 构造一个新的 HeatmapPoint 对象。
   * @memberOf HeatmapPoint
   * @returns {Promise.<HeatmapPoint>}
   */
  async createObj() {
    try {
      var { HeatmapPointId } = await HP.createObj();
      var heatmapPoint = new HeatmapPoint();
      heatmapPoint._MGHeatmapPointId = HeatmapPointId;
      return heatmapPoint;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   *  获取热力点坐标
   *  @memberOf HeatmapPoint
   * @returns {Promise<Dot>}
   */
  async getPoint() {
    try {
        let { point2DId } = await HP.getPoint(this._MGHeatmapPointId);
        var dot = new Dot();
        dot._MGDotId = point2DId;
  
        return dot;
      } catch (e) {
        console.error(e);
      }
  }

   /**
   * 设置热力点坐标
   * @memberOf HeatmapPoint
   * @param {Object} point
   * @returns {Promise<void>}
   */
  async setPoint(point) {
    try {
      await HP.setPoint(this._MGHeatmapPointId, point._MGDotId);
    } catch (e) {
      console.error(e);
    }
  }

   /**
   *  获取热力点权重
   *  @memberOf HeatmapPoint
   * @returns {Promise<*>}
   */
  async getValue() {
    try {
      let value = await HP.getValue(this._MGHeatmapPointId);
      return value;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置热力点权重
   * @memberOf HeatmapPoint
   * @param {Number} value
   * @returns {Promise<void>}
   */
  async setValue(value) {
    try {
      await HP.setValue(this._MGHeatmapPointId, value);
    } catch (e) {
      console.error(e);
    }
  }
}