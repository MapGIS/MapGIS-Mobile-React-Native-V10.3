/*
 * @Description: In User Settings Edit
 * @Author: xiaoying
 * @Date: 2019-09-04 11:08:14
 * @LastEditTime: 2019-09-09 15:10:24
 * @LastEditors: mayuanye
 */
import { NativeModules } from 'react-native';
import ThemeInfo from './ThemeInfo.js';
let UTI = NativeModules.JSUniqueThemeInfo;

/**
 * @class UniqueThemeInfo
 * @description 唯一值专题图项
 */
export default class UniqueThemeInfo extends ThemeInfo {
  constructor() {
    super();
    Object.defineProperty(this, '_MGUniqueThemeInfoId', {
      get: function() {
        return this._MGThemeInfoId;
      },
      set: function(_MGUniqueThemeInfoId) {
        this._MGThemeInfoId = _MGUniqueThemeInfoId;
      },
    });
  }

  /**
   * 创建一个新的UniqueThemeInfo对象
   *
   * @memberof UniqueThemeInfo
   * @returns {Promise<UniqueThemeInfo>}
   */
  async createObj() {
    try {
      var { UniqueThemeInfoId } = await UTI.createObj();
      var uniqueThemeInfo = new UniqueThemeInfo();
      uniqueThemeInfo._MGUniqueThemeInfoId = UniqueThemeInfoId;
      return uniqueThemeInfo;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取唯一值
   *
   * @memberof UniqueThemeInfo
   * @returns {String} 值
   */
  async getValue() {
    try {
      let value = await UTI.getValue(this._MGUniqueThemeInfoId);
      return value;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * @memberof UniqueThemeInfo
   * @param {String} value 值
   * @returns {Promise<Void>}
   */
  async setValue(value) {
    try {
      await UTI.setValue(this._MGUniqueThemeInfoId, value);
    } catch (e) {
      console.error(e);
    }
  }
}
