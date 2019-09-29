/*
 * @Description: In User Settings Edit
 * @Author: xiaoying
 * @Date: 2019-09-03 19:17:49
 * @LastEditTime: 2019-09-09 14:13:16
 * @LastEditors: Please set LastEditors
 */
import { NativeModules } from 'react-native';
import LabelInfo from './LabelInfo.js';
import GeneralVectorLabel from './GeneralVectorLabel.js';
let SL = NativeModules.JSSimpleLabel;

/**
 * @class SimpleLabel
 * @description 简单标注
 */
export default class SimpleLabel extends GeneralVectorLabel {
  constructor() {
    super();
    Object.defineProperty(this, '_MGSimpleLabelId', {
      get: function() {
        return this._MGGeneralVectorLabelId;
      },
      set: function(_MGSimpleLabelId) {
        this._MGGeneralVectorLabelId = _MGSimpleLabelId;
      },
    });
  }

  /**
   * 创建一个新的SimpleLabel对象
   *
   * @memberof SimpleLabel
   * @returns {Promise<SimpleLabel>}
   */
  async createObj() {
    try {
      var { SimpleLabelId } = await SL.createObj();
      var simpleLabel = new SimpleLabel();
      simpleLabel._MGSimpleLabelId = SimpleLabelId;
      return simpleLabel;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取缺省的标注信息
   *
   * @memberof SimpleLabel
   * @returns {Promise<LabelInfo>}
   */
  async getInfo() {
    try {
      var { LabelInfoId } = await SL.getInfo(this._MGSimpleLabelId);
      var labelInfo = new LabelInfo();
      labelInfo._MGLabelInfoId = LabelInfoId;

      return labelInfo;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   *  设置缺省的标注信息
   *
   * @memberof SimpleLabel
   * @param {Object} labelInfo 标注信息
   * @returns {Promise<Void>}
   */
  async setInfo(labelInfo) {
    try {
      await SL.getInfo(this._MGSimpleLabelId, labelInfo._MGLabelInfoId);
    } catch (e) {
      console.error(e);
    }
  }
}
