/*
 * @Description:
 * @Version: 1.0
 * @Autor: liaoliang
 * @Date: 2020-07-21 20:38:34
 * @LastEditors: liaoliang
 * @LastEditTime: 2020-07-21 20:48:05
 */

import { NativeModules } from 'react-native';

let SP = NativeModules.JSSelectionProperties;

export default class SelectionProperties {
  /**
   * @description: 构造一个新的 SelectionProperties 对象
   * @param {type}
   * @return:
   */
  async createObj() {
    try {
      var { selectionPropertiesId } = await SP.createObj();
      var selectionProperties = new SelectionProperties();
      selectionProperties._MGSelectionPropertiesId = selectionPropertiesId;
      return selectionProperties;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 获取选中要素的样式
   * @param {type}
   * @return:
   */
  async getSelectionStyle() {
    try {
      let selectionStyleId = await SP.getSelectionStyle(
        this._MGSelectionPropertiesId
      );
      return selectionStyleId;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 获取没有选中要素的样式
   * @param {type}
   * @return:
   */
  async getUnSelectionStyle() {
    try {
      let selectionStyleId = await SP.getUnSelectionStyle(
        this._MGSelectionPropertiesId
      );
      return selectionStyleId;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 设置选中要素的样式
   * @param {String} selectionStyleId
   * @return:
   */
  async setSelectionStyle(selectionStyleId) {
    try {
      let result = await SP.setSelectionStyle(
        this._MGSelectionPropertiesId,
        selectionStyleId
      );
      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 设置没有选中要素的样式
   * @param {String} selectionStyleId
   * @return:
   */
  async setUnSelectionStyle(selectionStyleId) {
    try {
      let result = await SP.setUnSelectionStyle(
        this._MGSelectionPropertiesId,
        selectionStyleId
      );
      return result;
    } catch (error) {
      console.error(error);
    }
  }
}
