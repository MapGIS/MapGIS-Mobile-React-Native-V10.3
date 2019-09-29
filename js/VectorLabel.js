/*
 * @Description: In User Settings Edit
 * @Author: xiaoying
 * @Date: 2019-09-04 19:28:14
 * @LastEditTime: 2019-09-09 14:01:31
 * @LastEditors: Please set LastEditors
 */
import { NativeModules } from 'react-native';
import Label from './Label.js';
import RegionPlaceInfo from './RegionPlaceInfo.js';
import LinePlaceInfo from './LinePlaceInfo.js';
import PointPlaceInfo from './PointPlaceInfo.js';
let VL = NativeModules.JSVectorLabel;

/**
 * @class VectorLabel
 * @description 矢量标注
 */
export default class VectorLabel extends Label {
  constructor() {
    super();
    Object.defineProperty(this, '_MGVectorLabelId', {
      get: function() {
        return this._MGLabelId;
      },
      set: function(_MGVectorLabelId) {
        this._MGLabelId = _MGVectorLabelId;
      },
    });
  }

  /**
   * 获取最小显示比
   *
   * @memberof VectorLabel
   * @returns {double} 最小显示比
   */
  async getMinScale() {
    try {
      let minScale = await VL.getMinScale(this._MGVectorLabelId);
      return minScale;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置最小显示比
   *
   * @memberof VectorLabel
   * @param {double} minScale 最小显示比
   * @returns {Promise<Void>}
   */
  async setMinScale(minScale) {
    try {
      await VL.setMinScale(this._MGVectorLabelId, minScale);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取最大显示比
   *
   * @memberof VectorLabel
   * @returns {double} 最大显示比
   */
  async getMaxScale() {
    try {
      let maxScale = await VL.getMaxScale(this._MGVectorLabelId);
      return maxScale;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置最大显示比
   *
   * @memberof VectorLabel
   * @param {double} maxScale 最大显示比
   * @returns {Promise<Void>}
   */
  async setMaxScale(maxScale) {
    try {
      await VL.setMaxScale(this._MGVectorLabelId, maxScale);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取标注类型
   *
   * @memberof VectorLabel
   * @returns {int} 标注类型，例：1-LabelGeomType.PointGeom
   */
  async getLabelGeomType() {
    try {
      let type = await VL.getLabelGeomType(this._MGVectorLabelId);
      return type;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置标注类型
   *
   * @memberof VectorLabel
   * @param {int} labelGeomType 标注类型，例：1-LabelGeomType.PointGeom
   * @returns {Promise<Void>}
   */
  async setLabelGeomType(labelGeomType) {
    try {
      await VL.setLabelGeomType(this._MGVectorLabelId, labelGeomType);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取点放置样式
   *
   * @memberof VectorLabel
   * @returns {Promise<PointPlaceInfo>}
   */
  async getPntPlaceInfo() {
    try {
      var { PointPlaceInfoId } = await VL.getPntPlaceInfo(
        this._MGVectorLabelId
      );
      var pointPlaceInfo = new PointPlaceInfo();
      pointPlaceInfo._MGPointPlaceInfoId = PointPlaceInfoId;
      return pointPlaceInfo;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置点放置样式
   *
   * @memberof VectorLabel
   * @param {Object} pointPlaceInfo 点放置样式 (object--PointPlaceInfo)
   * @returns {Promise<Void>}
   */
  async setPntPlaceInfo(pointPlaceInfo) {
    try {
      await VL.setPntPlaceInfo(
        this._MGVectorLabelId,
        pointPlaceInfo._MGPointPlaceInfoId
      );
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取线放置样式
   *
   * @memberof VectorLabel
   * @returns {Promise<LinePlaceInfo>}
   */
  async getLinPlaceInfo() {
    try {
      var { LinePlaceInfoId } = await VL.getLinPlaceInfo(this._MGVectorLabelId);
      var linPlaceInfo = new LinePlaceInfo();
      linPlaceInfo._MGLinePlaceInfoId = LinePlaceInfoId;
      return linPlaceInfo;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置线放置样式
   *
   * @memberof VectorLabel
   * @param {Object} linPlaceInfo 线放置样式 (Object--LinePlaceInfo)
   * @returns {Promise<Void>}
   */
  async setLinPlaceInfo(linPlaceInfo) {
    try {
      await VL.setLinPlaceInfo(
        this._MGVectorLabelId,
        linPlaceInfo._MGLinePlaceInfoId
      );
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取区放置样式
   *
   * @memberof VectorLabel
   * @returns {Promise<RegionPlaceInfo>}
   */
  async getRegPlaceInfo() {
    try {
      var { RegPlaceInfoId } = await VL.getRegPlaceInfo(this._MGVectorLabelId);
      var regPlaceInfo = new RegionPlaceInfo();
      regPlaceInfo._MGRegionPlaceInfoId = RegPlaceInfoId;
      return regPlaceInfo;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置区放置样式
   *
   * @memberof VectorLabel
   * @param {Object} regPlaceInfo 区放置样式 （Object--RegionPlaceInfo）
   * @returns {Promise<Void>}
   */
  async setRegPlaceInfo(regPlaceInfo) {
    try {
      await VL.setRegPlaceInfo(
        this._MGVectorLabelId,
        regPlaceInfo._MGRegionPlaceInfoId
      );
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取是否屏幕外标注,允许存在不完整的标注
   *
   * @memberof VectorLabel
   * @returns {boolean}
   */
  async getLabelClientOutSide() {
    try {
      let result = await VL.getLabelClientOutSide(this._MGVectorLabelId);
      return result;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置是否屏幕外标注,允许存在不完整的标注
   *
   * @memberof VectorLabel
   * @param {boolean} labelClientOutSide 是否屏幕外标注
   * @returns {Promise<Void>}
   */
  async setLabelClientOutSide(labelClientOutSide) {
    try {
      await VL.setLabelClientOutSide(this._MGVectorLabelId, labelClientOutSide);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 保存为XML
   *
   * @memberof VectorLabel
   * @returns {String} 成功返回XML
   */
  async toXML() {
    try {
      let xml = await VL.toXML(this._MGVectorLabelId);
      return xml;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 从XML导入
   *
   * @memberof VectorLabel
   * @param strXML XML串
   * @returns {boolean} 成功/失败 true/false
   */
  async fromXML(strXML) {
    try {
      let result = await VL.fromXML(this._MGVectorLabelId, strXML);
      return result;
    } catch (e) {
      console.error(e);
    }
  }
}
