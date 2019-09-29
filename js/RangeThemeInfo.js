/*
 * @Description: In User Settings Edit
 * @Author: xiaoying
 * @Date: 2019-09-03 16:12:56
 * @LastEditTime: 2019-09-09 15:12:07
 * @LastEditors: Please set LastEditors
 */
import { NativeModules } from 'react-native';
import ThemeInfo from './ThemeInfo.js';
let RTI = NativeModules.JSRangeThemeInfo;

/**
 * @class RangeThemeInfo
 * @description 范围专题图项信息
 */
export default class RangeThemeInfo extends ThemeInfo {
  constructor() {
    super();
    Object.defineProperty(this, '_MGRangeThemeInfoId', {
      get: function() {
        return this._MGThemeInfoId;
      },
      set: function(_MGRangeThemeInfoId) {
        this._MGThemeInfoId = _MGRangeThemeInfoId;
      },
    });
  }

  /**
   *  创建一个新的RangeThemeInfo对象
   *
   * @memberof RangeThemeInfo
   * @returns {Promise<RangeThemeInfo>}
   */
  async createObj() {
    try {
      var { RangeThemeInfoId } = await RTI.createObj();
      var rangeThemeInfo = new RangeThemeInfo();
      rangeThemeInfo._MGRangeThemeInfoId = RangeThemeInfoId;
      return rangeThemeInfo;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取开始值
   *
   * @memberof RangeThemeInfo
   * @returns {String}
   */
  async getStartValue() {
    try {
      let startValue = await RTI.getStartValue(this._MGRangeThemeInfoId);
      return startValue;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置开始值
   *
   * @memberof RangeThemeInfo
   * @param {String} startValue 开始值
   * @returns {Promise<Void>}
   */
  async setStartValue(startValue) {
    try {
      await RTI.setStartValue(this._MGRangeThemeInfoId, startValue);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取结束值
   *
   * @memberof RangeThemeInfo
   * @returns {String}
   */
  async getEndValue() {
    try {
      let endValue = await RTI.getEndValue(this._MGRangeThemeInfoId);
      return endValue;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置结束值
   *
   * @memberof RangeThemeInfo
   * @param {String} endValue 结束值
   * @returns {Promise<Void>}
   */
  async setEndValue(endValue) {
    try {
      await RTI.setEndValue(this._MGRangeThemeInfoId, endValue);
    } catch (e) {
      console.error(e);
    }
  }
}
