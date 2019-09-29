/*
 * @Description: In User Settings Edit
 * @Author: xiaoying
 * @Date: 2019-09-03 10:21:27
 * @LastEditTime: 2019-09-19 14:34:57
 * @LastEditors: Please set LastEditors
 */

import { NativeModules } from 'react-native';
import ClassItemValue from './ClassItemValue.js';
import PntInfo from './PntInfo.js';
import LinInfo from './LinInfo.js';
import RegInfo from './RegInfo.js';
import TextAnnInfo from './TextAnnInfo.js';

let GeomType = NativeModules.JSGeomType;
let MTI = NativeModules.JSMultiClassThemeInfo;

/**
 * @class MultiClassThemeInfo
 * @description 多表达式分段专题图项
 */
export default class MultiClassThemeInfo {
  /**
   * 构造一个新的MultiClassThemeInfo对象
   *
   * @memberof MultiClassThemeInfo
   * @returns {Promise<MultiClassThemeInfo>}
   */
  async createObj() {
    try {
      var { MultiClassThemeInfoId } = await MTI.createObj();
      var multiClassThemeInfo = new MultiClassThemeInfo();
      multiClassThemeInfo._MGMultiClassThemeInfoId = MultiClassThemeInfoId;
      return multiClassThemeInfo;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取专题图信息项的数目（和表达式的数目相同）
   *
   * @memberof MultiClassThemeInfo
   * @returns {int} 专题图信息项的数目
   */
  async getCount() {
    try {
      let count = await MTI.getCount(this._MGMultiClassThemeInfoId);
      return count;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   *
   * 取各个项的值（该列表长度与表达式的个数同）
   *
   * @memberof MultiClassThemeInfo
   * @returns {Array} 各个项的值组成的数组 - ClassItemValue[]
   */
  async getValues() {
    try {
      var classItemValues = await MTI.getValues(this._MGMultiClassThemeInfoId);
      var classItemValueArray = new Array();
      for (let i = 0; i < classItemValues.length; i++) {
        let classItemValueId = classItemValues[i];
        var classItemValue = new ClassItemValue(); // 通过classItemValueId构造JS端的ClassItemValue
        classItemValue._MGClassItemValueId = classItemValueId;
        classItemValueArray.push(classItemValue);
      }
      return classItemValueArray;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取项标题
   *
   * @memberof MultiClassThemeInfo
   * @returns {String} 项标题
   */
  async getCaption() {
    try {
      let caption = await MTI.getCaption(this._MGMultiClassThemeInfoId);
      return caption;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置项标题
   *
   * @memberof MultiClassThemeInfo
   * @param {String} caption 项标题
   * @returns {Promise<Void>}
   */
  async setCaption(caption) {
    try {
      await MTI.setCaption(this._MGMultiClassThemeInfoId, caption);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取是否可见
   *
   * @memberof MultiClassThemeInfo
   * @returns {boolean} 是否可见
   */
  async getVisible() {
    try {
      let visible = await MTI.getVisible(this._MGMultiClassThemeInfoId);
      return visible;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置是否可见
   *
   * @memberof MultiClassThemeInfo
   * @param {boolean} visible 是否可见
   * @returns {Promise<Void>}
   */
  async setVisible(visible) {
    try {
      await MTI.setVisible(this._MGMultiClassThemeInfoId, visible);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取最小显示比
   *
   * @memberof MultiClassThemeInfo
   * @returns {double} 最小显示比
   */
  async getMinScale() {
    try {
      let minScale = await MTI.getMinScale(this._MGMultiClassThemeInfoId);
      return minScale;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置最小显示比
   *
   * @memberof MultiClassThemeInfo
   * @param {double} minScale 最小显示比
   * @returns {Promise<Void>}
   */
  async setMinScale(minScale) {
    try {
      await MTI.setMinScale(this._MGMultiClassThemeInfoId, minScale);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取最大显示比
   *
   * @memberof MultiClassThemeInfo
   * @returns {double} 最大显示比
   */
  async getMaxScale() {
    try {
      let maxScale = await MTI.getMaxScale(this._MGMultiClassThemeInfoId);
      return maxScale;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置最大显示比
   *
   * @memberof MultiClassThemeInfo
   * @param {double} maxScale 最大显示比
   * @returns {Promise<Void>}
   */
  async setMaxScale(maxScale) {
    try {
      await MTI.setMaxScale(this._MGMultiClassThemeInfoId, maxScale);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 复制信息到当前专题图对象
   *
   * @memberof MultiClassThemeInfo
   * @param {Object} multiClassThemeInfo 专题图对象
   * @returns {boolean} true-成功  ： false-失败
   */
  async copy(multiClassThemeInfo) {
    try {
      let result = await MTI.copy(
        this._MGMultiClassThemeInfoId,
        multiClassThemeInfo._MGMultiClassThemeInfoId
      );
      return result;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置专题图项的信息
   *
   * @memberof MultiClassThemeInfo
   * @param {int} index 专题图项的索引
   * @param {Object} classItemValue  专题图项的信息
   * @returns {boolean} true-成功  ： false-失败
   */
  async setValue(index, classItemValue) {
    try {
      let result = await MTI.setValue(
        this._MGMultiClassThemeInfoId,
        index,
        classItemValue._MGClassItemValueId
      );
      return result;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获得专题图项的信息
   *
   * @memberof MultiClassThemeInfo
   * @param {int} index 专题图项的索引
   * @returns {Promise<ClassItemValue>}  成功返回专题图项的信息
   */
  async getValue(index) {
    try {
      var { ClassItemValueId } = await MTI.getValue(
        this._MGMultiClassThemeInfoId,
        index
      );
      var classItemValue = new ClassItemValue();
      classItemValue._MGClassItemValueId = ClassItemValueId;
      return classItemValue;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获得专题图项的图形信息
   *
   * @memberof MultiClassThemeInfo
   * @param {int} geomType 图形信息类型（int类型的Number），例：0-GeomType.GeomUnknown
   * @returns {Promise<GeomInfo>} 成功返回专题图项的图形信息
   */
  async getGeoInfo(geomType) {
    try {
      var { GeomInfoId } = await MTI.getGeoInfo(
        this._MGMultiClassThemeInfoId,
        geomType
      );
      var geomInfo = null;
      if (GeomInfoId != null) {
        switch (geomType) {
          case GeomType.GeomPnt:
            geomInfo = new PntInfo();
            geomInfo._MGGeomInfoId = GeomInfoId;
            break;
          case GeomType.GeomLin:
            geomInfo = new LinInfo();
            geomInfo._MGGeomInfoId = GeomInfoId;
            break;
          case GeomType.GeomReg:
            geomInfo = new RegInfo();
            geomInfo._MGGeomInfoId = GeomInfoId;
            break;
          case GeomType.GeomAnno:
            geomInfo = new TextAnnInfo();
            geomInfo._MGGeomInfoId = GeomInfoId;
            break;
        }
      }
      return geomInfo;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置专题图项的图形信息
   *
   * @memberof MultiClassThemeInfo
   * @param {Object} geomInfo  专题图图形信息 （GeomInfo类型的Object）
   * @param {Number} geomType 图形类型，（int类型的Number）例：0-GeomType.GeomUnknown
   * @returns {boolean}
   */
  async setGeoInfo(geomInfo, geomType) {
    try {
      let result = await MTI.setGeoInfo(
        this._MGMultiClassThemeInfoId,
        geomInfo._MGGeomInfoId,
        geomType
      );
      return result;
    } catch (e) {
      console.error(e);
    }
  }
}
