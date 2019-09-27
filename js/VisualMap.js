/**
 * @content 视觉映射功能组件
 * @author
 */
import { NativeModules } from "react-native";

let VM = NativeModules.JSVisualMap;
/**
 * @class VisualMap
 */
export default class VisualMap {
    /**
   * 构造一个新的 VisualMap 对象。
   * @memberOf VisualMap
   * @returns {Promise.<VisualMap>}
   */
  async createObj() {
    try {
      var { VisualMapId } = await VM.createObj();
      var visualMap = new VisualMap();
      visualMap._MGVisualMapId = VisualMapId;
      return visualMap;
    } catch (e) {
      console.error(e);
    }
  }

   /**
   *  获取视觉映射的最小值,默认值为0
   *  @memberOf VisualMap
   * @returns {Promise<double>}
   */
  async getMinValue() {
    try {
      let value = await VM.getMinValue(this._MGVisualMapId);
      return value;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置视觉映射的最小值,默认值为0
   * 在不设置minValue的情况下,minValue等于0,当热力点的权重值设置小于0的时候,minValue依然为0.
   * @memberOf VisualMap
   * @param minValue
   * @returns {Promise<void>}
   */
  async setMinValue(minValue) {
    try {
      await VM.setMinValue(this._MGVisualMapId, minValue);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   *  获取视觉映射的最大值,默认值为1
   *  @memberOf VisualMap
   * @returns {Promise<double>}
   */
  async getMaxValue() {
    try {
      let value = await VM.getMaxValue(this._MGVisualMapId);
      return value;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置视觉映射的最大值,默认值为1
   * 在不设置maxValue的情况下,maxValue等于1;当热力点的权重值设置大于1的时候,maxValue依然为1
   * @memberOf VisualMap
   * @param maxValue
   * @returns {Promise<void>}
   */
  async setMaxValue(maxValue) {
    try {
      await VM.setMaxValue(this._MGVisualMapId, maxValue);
    } catch (e) {
      console.error(e);
    }
  }

   /**
   *  获取热力点的颜色组
   *  @memberOf VisualMap
   * @returns {Promise<string>}
   */
  async getColors() {
    try {
      let value = await VM.getColors(this._MGVisualMapId);
      return value;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置热力点的颜色组
   * @memberOf VisualMap
   * @param colors
   * @returns {Promise<void>}
   */
  async setColors(colors) {
    try {
      await VM.setColors(this._MGVisualMapId, colors);
    } catch (e) {
      console.error(e);
    }
  }
}