/**
 * @content 用于对多边形的几何功能组件
 * @author  2019-09-09
 */
import { NativeModules } from 'react-native';

let TA = NativeModules.JSTextAnno;

import TextAnnInfo from './TextAnnInfo.js';
import GeoAnno from './GeoAnno.js';

/**
 * @class TextAnno
 */
export default class TextAnno extends GeoAnno {
  constructor() {
    super();
    Object.defineProperty(this, '_MGTextAnnoId', {
      get: function() {
        return this._MGGeoAnnoId;
      },
      set: function(_MGTextAnnoId) {
        this._MGGeoAnnoId = _MGTextAnnoId;
      },
    });
  }

  /**
   * 构造一个新的 TextAnno 对象
   * @memberOf TextAnno
   * @return {Promise<TextAnno>}
   */
  async createObj() {
    try {
      var { TextAnnoId } = await TA.createObj();
      var textAnno = new TextAnno();
      textAnno._MGTextAnnoId = TextAnnoId;
      return textAnno;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取几何对象类型
   * @memberOf TextAnno
   * @return {Promise}几何对象类型
   */
  async getType() {
    try {
      return await TA.getType(this._MGTextAnnoId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取注记类型
   * @memberOf TextAnno
   * @return {Promise}注记类型
   */
  async getAnnType() {
    try {
      return await TA.getAnnType(this._MGTextAnnoId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 判断几何注记是否为空
   * @memberOf TextAnno
   * @return {Promise}为空返回true，不为空返回false
   */
  async isEmpty() {
    try {
      return await TA.isEmpty(this._MGTextAnnoId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取文本注记文本内容
   * @memberOf TextAnno
   * @return {Promise}文本内容
   */
  async getText() {
    try {
      return await TA.getText(this._MGTextAnnoId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置文本注记文本内容
   * @memberOf TextAnno
   * @param text 文本内容
   * @return {Promise<void>}
   */
  async setText(text) {
    try {
      await TA.setText(this._MGTextAnnoId, text);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取文本注记文本格式化信息
   * @memberOf TextAnno
   * @return {Promise<TextAnnInfo>} 文本格式化信息
   */
  async getTextAnnInfo() {
    try {
      let { TextAnnInfoId } = await TA.getTextAnnInfo(this._MGTextAnnoId);
      var annInfo = new TextAnnInfo();
      annInfo._MGTextAnnInfoId = TextAnnInfoId;
      return annInfo;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置文本注记文本格式化信息
   * @memberOf TextAnno
   * @param textInfo 文本格式化信息
   * @return {Promise<void>}
   */
  async setTextAnnInfo(textInfo) {
    try {
      await TA.setTextAnnInfo(this._MGTextAnnoId, textInfo._MGTextAnnInfoId);
    } catch (e) {
      console.error(e);
    }
  }
}
