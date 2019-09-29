/*
 * @Description: In User Settings Edit
 * @Author: xiaoying
 * @Date: 2019-08-27 09:47:14
 * @LastEditTime: 2019-08-31 16:53:02
 * @LastEditors: Please set LastEditors
 */

import { NativeModules } from 'react-native';
let CIV = NativeModules.JSClassItemValue;

/**
 * @class ClassItemValue
 * @description 分段类型对象功能组件
 */
export default class ClassItemValue {
  /**
   * 构造一个新的SRefData对象。
   * @memberof ClassItemValue
   * @returns {Promise.<ClassItemValue>}
   */
  async createObj() {
    try {
      var { ClassItemValueId } = await CIV.createObj();
      var classItemValue = new ClassItemValue();
      classItemValue._MGClassItemValueId = ClassItemValueId;
      return classItemValue;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 统计分段类型
   * @memberof ClassItemValue
   * @returns {int} ClassItemType的值
   */
  async getType() {
    try {
      let type = await CIV.getType(this._MGClassItemValueId);
      return type;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置分段类型
   * @memberof ClassItemValue
   * @param {int} type 分段类型 UniqueType | RangeType
   * @returns {Promise<Void>}
   */
  async setType(type) {
    try {
      await CIV.setType(this._MGClassItemValueId, type);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取开始值
   * @memberof ClassItemValue
   * @returns {String}
   */
  async getStartValue() {
    try {
      let startValue = await CIV.getStartValue(this._MGClassItemValueId);
      return startValue;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置开始值
   * @memberof ClassItemValue
   * @param {String} startValue 开始值
   * @returns {Promise<Void>}
   */
  async setStartValue(startValue) {
    try {
      await CIV.setStartValue(this._MGClassItemValueId, startValue);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取结束值
   * @memberof ClassItemValue
   * @returns {String}
   */
  async getEndValue() {
    try {
      let endValue = await CIV.getEndValue(this._MGClassItemValueId);
      return endValue;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置结束值
   * @memberof ClassItemValue
   * @param {String} endValue 结束值
   * @returns {Promise<Void>}
   */
  async setEndValue(endValue) {
    try {
      await CIV.setEndValue(this._MGClassItemValueId, endValue);
    } catch (e) {
      console.error(e);
    }
  }

