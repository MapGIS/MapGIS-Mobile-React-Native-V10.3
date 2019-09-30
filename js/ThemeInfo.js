/*
 * @Description: In User Settings Edit
 * @Author: xiaoying
 * @Date: 2019-09-03 14:26:49
 * @LastEditTime: 2019-09-19 14:38:21
 * @LastEditors: mayuanye
 */
import { NativeModules } from 'react-native';
import PntInfo from './PntInfo.js';
import LinInfo from './LinInfo.js';
import RegInfo from './RegInfo.js';
import TextAnnInfo from './TextAnnInfo.js';
let GeomType = NativeModules.JSGeomType;
let TI = NativeModules.JSThemeInfo;

/**
 * @class ThemeInfo
 * @description 专题绘制信息
 */
export default class ThemeInfo {
  /**
   * 构造一个新的ThemeInfo对象
   *
   * @class ThemeInfo
   * @returns {Promise<ThemeInfo>}
   */
  async createObj() {
    try {
      var { ThemeInfoId } = await TI.createObj();
      var themeInfo = new ThemeInfo();
      themeInfo._MGThemeInfoId = ThemeInfoId;
      return themeInfo;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取标题
   *
   * @memberof ThemeInfo
   * @returns {String} 标题
   */
  async getCaption() {
    try {
      let caption = await TI.getCaption(this._MGThemeInfoId);
      return caption;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置标题
   *
   * @memberof ThemeInfo
   * @param {String} caption 标题
   * @returns {Promise<Void>}
   */
  async setCaption(caption) {
    try {
      await TI.setCaption(this._MGThemeInfoId, caption);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取是否可见
   *
   * @memberof ThemeInfo
   * @returns {boolean}
   */
  async getIsVisible() {
    try {
      let isVisible = await TI.getIsVisible(this._MGThemeInfoId);
      return isVisible;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置是否可见
   *
   * @memberof ThemeInfo
   * @param {boolean} isVisible 是否可见
   * @returns {Promise<Void>}
   */
  async setIsVisible(isVisible) {
    try {
      await TI.setIsVisible(this._MGThemeInfoId, isVisible);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取最小显示比
   *
   * @memberof ThemeInfo
   * @returns {double}
   */
  async getMinScale() {
    try {
      let minScale = await TI.getMinScale(this._MGThemeInfoId);
      return minScale;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置最小显示比
   *
   * @memberof ThemeInfo
   * @param {double} minScale 最小显示比
   * @returns {Promise<Void>}
   */
  async setMinScale(minScale) {
    try {
      await TI.setMinScale(this._MGThemeInfoId, minScale);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取最大显示比
   *
   * @memberof ThemeInfo
   * @returns {double}
   */
  async getMaxScale() {
    try {
      let maxScale = await TI.getMaxScale(this._MGThemeInfoId);
      return maxScale;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置最大显示比
   *
   * @memberof ThemeInfo
   * @param {double} maxScale 最大显示比
   * @returns {Promise<Void>}
   */
  async setMaxScale(maxScale) {
    try {
      await TI.setMaxScale(this._MGThemeInfoId, maxScale);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 根据图形类型设置图形信息
   *
   * @memberof ThemeInfo
   * @param {Number} geomType 图形信息类型（int类型的Number），例：0-GeomType.GeomUnknown
   * @returns {Promise<GeomInfo>} 成功返回图形信息
   */
  async getGeoInfo(geomType) {
    try {
      var { GeomInfoId } = await TI.getGeoInfo(this._MGThemeInfoId, geomType);
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
   * 设置图形信息
   *
   * @memberof ThemeInfo
   * @param {Object} geomInfo 图形信息
   * @returns {Promise<Void>}
   */
  async setGeoInfo(geomInfo) {
    try {
      await TI.setGeoInfo(this._MGThemeInfoId, geomInfo._MGGeomInfoId);
    } catch (e) {
      console.error(e);
    }
  }
}
