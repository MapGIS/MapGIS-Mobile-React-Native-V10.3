/*
 * @Description:
 * @Version: 1.0
 * @Autor: liaoliang
 * @Date: 2020-07-21 20:26:53
 * @LastEditors: liaoliang
 * @LastEditTime: 2020-07-21 20:38:07
 */

import { NativeModules } from 'react-native';

let SS = NativeModules.JSSelectionStyle;

export default class SelectionStyle {
  /**
   * @description: 构造一个新的 SelectionStyle 对象
   * @param {type}
   * @return:
   */
  async createObj() {
    try {
      var { selectionStyleId } = await SS.createObj();
      var selectionStyle = new SelectionStyle();
      selectionStyle._MGSelectionStyleId = selectionStyleId;
      return selectionStyle;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 获取填充色
   * @param {type}
   * @return {int}
   */
  async getFillColor() {
    try {
      let fillColor = await SS.getFillColor(this._MGSelectionStyleId);
      return fillColor;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 设置填充色
   * @param {int} color
   * @return:
   */
  async setFillColor(color) {
    try {
      let result = await SS.setFillColor(this._MGSelectionStyleId, color);
      return result;
    } catch (error) {
      console.error(error);
    }
  }
}
