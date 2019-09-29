/*
 * @Description: In User Settings Edit
 * @Author: xiaoying
 * @Date: 2019-09-02 16:43:53
 * @LastEditTime: 2019-09-09 17:50:39
 * @LastEditors: Please set LastEditors
 */
import { NativeModules } from 'react-native';
let L = NativeModules.JSLabel;

/**
 * @class Label
 * @description 标注
 */
export default class Label {
  /**
   * 获取标注类型
   *
   * @memberof Label
   * @returns {Number} 标注类型（int范围的Number；例：256-LabelType.SimpleLabel）
   */
  async getType() {
    try {
      let type = await L.getType(this._MGLabelId);
      return type;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取可见性
   *
   * @memberof Label
   * @returns {boolean}
   */
  async getVisible() {
    try {
      let result = await L.getVisible(this._MGLabelId);
      return result;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置可见性
   *
   * @memberof Label
   * @param {boolean} visible 可见性
   * @returns {Promise<Void>}
   */
  async setVisible(visible) {
    try {
      await L.setVisible(this._MGLabelId, visible);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取名称
   *
   * @memberof Label
   * @returns {String}
   */
  async getName() {
    try {
      let name = await L.getName(this._MGLabelId);
      return name;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置标注名称
   * @memberof Label
   * @param {String} name 名称
   * @returns {Promise<Void>}
   */
  async setName(name) {
    try {
      await L.setName(this._MGLabelId, name);
    } catch (e) {
      console.error(e);
    }
  }
}
