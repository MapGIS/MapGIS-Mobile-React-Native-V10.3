/*
 * @Description: In User Settings Edit
 * @Author: xiaoying
 * @Date: 2019-08-28 17:11:23
 * @LastEditTime: 2019-09-19 14:23:31
 * @LastEditors: Please set LastEditors
 */
import { NativeModules } from 'react-native';
import VectorLabel from './VectorLabel.js';
import LinInfo from './LinInfo.js';
let GVL = NativeModules.JSGeneralVectorLabel;

/**
 * @class GeneralVectorLabel
 * @description 矢量标注
 */
export default class GeneralVectorLabel extends VectorLabel {
  constructor() {
    super();
    Object.defineProperty(this, '_MGGeneralVectorLabelId', {
      get: function() {
        return this._MGVectorLabelId;
      },
      set: function(_MGGeneralVectorLabelId) {
        this._MGVectorLabelId = _MGGeneralVectorLabelId;
      },
    });
  }

  /**
   * 获取标注表达式
   * @memberof GeneralVectorLabel
   * @returns {String} 标注表达式
   */
  async getLabelExpression() {
    try {
      let labelExpression = await GVL.getLabelExpression(
        this._MGGeneralVectorLabelId
      );
      return labelExpression;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置标注表达式
   * @memberof GeneralVectorLabel
   * @param {String} labelExpression 标注表达式
   * @returns {Promise<Void>}
   */
  async setLabelExpression(labelExpression) {
    try {
      await GVL.setLabelExpression(
        this._MGGeneralVectorLabelId,
        labelExpression
      );
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取标注背景类型
   * @memberof GeneralVectorLabel
   * @returns {Number} 标注背景类型（int类型，例如 1--LabelBackType.Rect）
   */
  async getLabelBackType() {
    try {
      let labelBackType = await GVL.getLabelBackType(
        this._MGGeneralVectorLabelId
      );
      return labelBackType;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置标注背景类型
   * @memberof GeneralVectorLabel
   * @param {Number} labelBackType 标注背景类型（int类型，例如 1--LabelBackType.Rect）
   * @returns {Promise<Void>}
   */
  async setLabelBackType(labelBackType) {
    try {
      await GVL.setLabelBackType(this._MGGeneralVectorLabelId, labelBackType);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取背景图形信息,可同时设置点,线,面以及注记
   * @memberof GeneralVectorLabel
   * @returns {Object} geomInfo 背景图形信息
   */
  async getBackGeoInfo() {
    try {
      var { geomInfoId } = await GVL.getBackGeoInfo(
        this._MGGeneralVectorLabelId
      );
      var linInfo = null;
      if (geomInfoId != null) {
        linInfo = new LinInfo();
        linInfo._MGGeomInfoId = geomInfoId;
      }

      return linInfo;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置背景图形信息,可同时设置点,线,面以及注记
   * @memberof GeneralVectorLabel
   * @param {Object} geomInfo 背景图形信息
   * @returns {Promise<Void>}
   */
  async setBackGeoInfo(geomInfo) {
    try {
      await GVL.setBackGeoInfo(
        this._MGGeneralVectorLabelId,
        geomInfo._MGGeomInfoId
      );
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 精度,小数点后有效位数,eg.精度为1时,那么123.456表示为123.5
   * @memberof GeneralVectorLabel
   * @returns {Number} 精度（int范围的Number)
   */
  async getNumericPrecision() {
    try {
      let numericPrecision = await GVL.getNumericPrecision(
        this._MGGeneralVectorLabelId
      );
      return numericPrecision;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置精度
   * @memberof GeneralVectorLabel
   * @param {Number} numericPrecision 精度（int范围的Number)
   * @returns {Promise<Void>}
   */
  async setNumericPrecision(numericPrecision) {
    try {
      await GVL.setNumericPrecision(
        this._MGGeneralVectorLabelId,
        numericPrecision
      );
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 是否换行去标注超过单行字符限制的注记 (线可能支持可能不支持)
   * @memberof GeneralVectorLabel
   * @returns {boolean}
   */
  async getNewLineToLabel() {
    try {
      let newLineToLabel = await GVL.getNewLineToLabel(
        this._MGGeneralVectorLabelId
      );
      return newLineToLabel;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置是否换行去标注超过单行字符限制的注记 (线可能支持可能不支持)
   * @memberof GeneralVectorLabel
   * @param {boolean} newLineToLabel 是否换行去标注超过单行字符限制的注记
   * @returns {Promise<Void>}
   */
  async setNewLineToLabel(newLineToLabel) {
    try {
      await GVL.setNewLineToLabel(this._MGGeneralVectorLabelId, newLineToLabel);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取当行的最大长度
   * @memberof GeneralVectorLabel
   * @returns {Number} 当行的最大长度 （int范围的Number）
   */
  async getMaxLengthPreLine() {
    try {
      let maxLengthPreLine = await GVL.getMaxLengthPreLine(
        this._MGGeneralVectorLabelId
      );
      return maxLengthPreLine;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置当行的最大长度
   * @memberof GeneralVectorLabel
   * @param {Number} maxLengthPreLine （int范围的Number）
   * @returns {Promise<Void>}
   */
  async setMaxLengthPreLine(maxLengthPreLine) {
    try {
      await GVL.setMaxLengthPreLine(
        this._MGGeneralVectorLabelId,
        maxLengthPreLine
      );
    } catch (e) {
      console.error(e);
    }
  }
}
