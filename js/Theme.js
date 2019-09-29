/*
 * @Description: In User Settings Edit
 * @Author: xiaoying
 * @Date: 2019-09-04 15:29:03
 * @LastEditTime: 2019-09-04 15:42:59
 * @LastEditors: Please set LastEditors
 */

import { NativeModules } from 'react-native';
let T = NativeModules.JSTheme;

/**
 * @class Theme
 * @description 专题图
 */
export default class Theme {
  /**
   * 获取专题图类型
   *
   * @memberof Theme
   * @returns {int} 专题图类型 例：1--ThemeType.SimpleTheme
   */
  async getType() {
    try {
      let type = await T.getType(this._MGThemeId);
      return type;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置专题图的名称
   *
   * @memberof Theme
   * @param {String} name 专题图的名称
   * @returns {int} 1-成功 ；0-失败
   */
  async setName() {
    try {
      let result = await T.setName(this._MGThemeId);
      return result;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取专题图的名称
   *
   * @memberof Theme
   * @returns {String} 专题图的名称
   */
  async getName() {
    try {
      let name = await T.getName(this._MGThemeId);
      return name;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取专题图的可见性
   *
   * @memberof Theme
   * @returns {boolean} 专题图的可见性
   */
  async getVisible() {
    try {
      let result = await T.getVisible(this._MGThemeId);
      return result;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置专题图的可见性
   *
   * @memberof Theme
   * @param {boolean} bVisible 专题图的可见性
   * @returns {int} 1-成功；0-失败
   */
  async setVisible(bVisible) {
    try {
      let result = await T.setVisible(this._MGThemeId, bVisible);
      return result;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 是否是单值或者分段专题图
   *
   * @memberof Theme
   * @returns {boolean}
   */
  async getIsBaseTheme() {
    try {
      return await T.getIsBaseTheme(this._MGThemeId);
    } catch (e) {
      console.error(e);
    }
  }
}
