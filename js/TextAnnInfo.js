/**
 * @content 用于对多点的几何功能组件
 * @author  2019-09-09
 */
import { NativeModules } from 'react-native';

let TAI = NativeModules.JSTextAnnInfo;

import AnnInfo from './AnnInfo.js';

/**
 * @class TextAnnInfo
 */
export default class TextAnnInfo extends AnnInfo {
  constructor() {
    super();
    Object.defineProperty(this, '_MGTextAnnInfoId', {
      get: function() {
        return this._MGGeomInfoId;
      },
      set: function(_MGTextAnnInfoId) {
        this._MGGeomInfoId = _MGTextAnnInfoId;
      },
    });
  }

  /**
   * 构造一个新的 TextAnnInfo 对象
   * @memberOf TextAnnInfo
   * @return {Promise<TextAnnInfo>}
   */
  async createObj() {
    try {
      var { TextAnnInfoId } = await TAI.createObj();
      var textAnnInfo = new TextAnnInfo();
      textAnnInfo._MGTextAnnInfoId = TextAnnInfoId;
      return textAnnInfo;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取文本显示高度
   * @memberOf TextAnnInfo
   * @return {Promise} 高度值
   *
   */
  async getHeight() {
    try {
      return await TAI.getHeight(this._MGTextAnnInfoId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置文本显示高度
   * @memberOf TextAnnInfo
   * @param newVal 高度值
   * @return {Promise<void>}
   */
  async setHeight(newVal) {
    try {
      await TAI.setHeight(this._MGTextAnnInfoId, newVal);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取文本显示宽度
   * @memberOf TextAnnInfo
   * @return {Promise}宽度值
   */
  async getWidth() {
    try {
      return await TAI.getWidth(this._MGTextAnnInfoId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置文本显示宽度
   * @memberOf TextAnnInfo
   * @param newVal 宽度值
   * @return {Promise<void>}
   */
  async setWidth(newVal) {
    try {
      await TAI.setWidth(this._MGTextAnnInfoId, newVal);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取文本显示间隔
   * @memberOf TextAnnInfo
   * @return {Promise}间隔值
   */
  async getSpace() {
    try {
      return await TAI.getSpace(this._MGTextAnnInfoId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置文本显示间隔
   * @memberOf TextAnnInfo
   * @param newVal 间隔值
   * @return {Promise<void>}
   */
  async setSpace(newVal) {
    try {
      await TAI.setSpace(this._MGTextAnnInfoId, newVal);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取文本显示字角度
   * @memberOf TextAnnInfo
   * @return {Promise}字角度值
   */
  async getFontAngle() {
    try {
      return await TAI.getFontAngle(this._MGTextAnnInfoId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置文本显示字角度
   * @memberOf TextAnnInfo
   * @param newVal 字角度值
   * @return {Promise<void>}
   */
  async setFontAngle(newVal) {
    try {
      await TAI.setFontAngle(this._MGTextAnnInfoId, newVal);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取文本显示字串角度
   * @memberOf TextAnnInfo
   * @return {Promise}字串角度值
   */
  async getAngle() {
    try {
      return await TAI.getAngle(this._MGTextAnnInfoId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置文本显示字串角度
   * @memberOf TextAnnInfo
   * @param newVal 字串角度值
   * @return {Promise<void>}
   */
  async setAngle(newVal) {
    try {
      await TAI.setAngle(this._MGTextAnnInfoId, newVal);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取文本中文字体
   * @memberOf TextAnnInfo
   * @return {Promise}中文字体
   */
  async getIfnt() {
    try {
      return await TAI.getIfnt(this._MGTextAnnInfoId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置文本中文字体
   * @memberOf TextAnnInfo
   * @param newVal 中文字体
   * @return {Promise<void>}
   */
  async setIfnt(newVal) {
    try {
      await TAI.setIfnt(this._MGTextAnnInfoId, newVal);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取文本西文字体
   * @memberOf TextAnnInfo
   * @return {Promise}西文字体
   */
  async getChnt() {
    try {
      return await TAI.getChnt(this._MGTextAnnInfoId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置文本西文字体
   * @memberOf TextAnnInfo
   * @param newVal 西文字体
   * @return {Promise<void>}
   */
  async setChnt(newVal) {
    try {
      await TAI.setChnt(this._MGTextAnnInfoId, newVal);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取文本的字形
   * @memberOf TextAnnInfo
   * @return {Promise}字形
   */
  async getIfnx() {
    try {
      return await TAI.getIfnx(this._MGTextAnnInfoId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置文本的字形
   * @memberOf TextAnnInfo
   * @param newVal 字形
   * @return {Promise<void>}
   */
  async setIfnx(newVal) {
    try {
      await TAI.setIfnx(this._MGTextAnnInfoId, newVal);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取文本显示水平或垂直排列
   * @memberOf TextAnnInfo
   * @return {Promise}水平排列返回true，垂直排列返回false
   */
  async getIsHzpl() {
    try {
      return await TAI.getIsHzpl(this._MGTextAnnInfoId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置文本水平或垂直排列
   * @memberOf TextAnnInfo
   * @param newVal 水平排列传true，垂直排列传false
   * @return {Promise<void>}
   */
  async setIsHzpl(newVal) {
    try {
      await TAI.setIsHzpl(this._MGTextAnnInfoId, newVal);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取文本显示颜色
   * @memberOf TextAnnInfo
   * @return {Promise<Number>}颜色号
   */
  async getColor() {
    try {
      let color = await TAI.getColor(this._MGTextAnnInfoId);
      return color;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置文本显示颜色
   * @memberOf TextAnnInfo
   * @param {Number}  color 颜色号
   * @return {Promise<void>}
   */
  async setColor(color) {
    try {
      await TAI.setColor(this._MGTextAnnInfoId, color);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取文本覆盖方式,表示透明/覆盖
   * @memberOf TextAnnInfo
   * @return {Promise}透明/覆盖
   */
  async getIsOvprnt() {
    try {
      return await TAI.getIsOvprnt(this._MGTextAnnInfoId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置文本覆盖方式,表示透明/覆盖
   * @memberOf TextAnnInfo
   * @param newVal 透明/覆盖
   * @return {Promise<void>}
   */
  async setIsOvprnt(newVal) {
    try {
      await TAI.setIsOvprnt(this._MGTextAnnInfoId, newVal);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取文本自动压背景颜色标志
   * @memberOf TextAnnInfo
   * @return {Promise}自动压背景颜色返回true，否则返回false
   */
  async getIsFilled() {
    try {
      return await TAI.getIsFilled(this._MGTextAnnInfoId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置文本自动压背景颜色标志
   * @memberOf TextAnnInfo
   * @param newVal 自动压背景设置true，否则返回false
   * @return {Promise<void>}
   */
  async setIsFilled(newVal) {
    try {
      await TAI.setIsFilled(this._MGTextAnnInfoId, newVal);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取文本显示范围扩展
   * @memberOf TextAnnInfo
   * @return {Promise}扩展值
   */
  async getBackExp() {
    try {
      return await TAI.getBackExp(this._MGTextAnnInfoId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置文本显示范围扩展
   * @memberOf TextAnnInfo
   * @param newVal 扩展值
   * @return {Promise<void>}
   */
  async setBackExp(newVal) {
    try {
      await TAI.setBackExp(this._MGTextAnnInfoId, newVal);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取文本覆盖的背景颜色
   * @memberOf TextAnnInfo
   * @return {Promise<Number>}颜色号
   */
  async getBackClr() {
    try {
      let color = await TAI.getBackClr(this._MGTextAnnInfoId);
      return color;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置文本覆盖的背景颜色
   * @memberOf TextAnnInfo
   * @param {Number}  color 颜色号
   * @return {Promise<void>}
   */
  async setBackClr(color) {
    try {
      await TAI.setBackClr(this._MGTextAnnInfoId, color);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取文本显示x方向的偏移
   * @memberOf TextAnnInfo
   * @return {Promise}偏移值
   */
  async getOffsetX() {
    try {
      return await TAI.getOffsetX(this._MGTextAnnInfoId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置文本显示x方向的偏移
   * @memberOf TextAnnInfo
   * @param newVal 偏移值
   * @return {Promise<void>}
   */
  async setOffsetX(newVal) {
    try {
      await TAI.setOffsetX(this._MGTextAnnInfoId, newVal);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取文本显示y方向的偏移
   * @memberOf TextAnnInfo
   * @return {Promise}偏移值
   */
  async getOffsetY() {
    try {
      return await TAI.getOffsetY(this._MGTextAnnInfoId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置文本显示y方向的偏移
   * @memberOf TextAnnInfo
   * @param newVal 偏移值
   * @return {Promise<void>}
   */
  async setOffsetY(newVal) {
    try {
      await TAI.setOffsetY(this._MGTextAnnInfoId, newVal);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 几何注记类类型
   * @memberOf TextAnnInfo
   * @return {Promise}几何注记类类型
   */
  async getAnnType() {
    try {
      return await TAI.getAnnType(this._MGTextAnnInfoId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取几何类型
   * @memberOf TextAnnInfo
   * @return {Promise}  几何类型
   */
  async getGeomType() {
    try {
      return await TAI.getGeomType(this._MGTextAnnInfoId);
    } catch (e) {
      console.error(e);
    }
  }
}
