/*
 * @Description: In User Settings Edit
 * @author: lidafeng
 * @Date: 2019-09-10 17:06:11
 * @LastEditTime: 2019-09-17 14:56:28
 * @LastEditors: mayuanye
 */
import { NativeModules } from 'react-native';
import PointStyle from './PointStyle';
import LineStyle from './LineStyle';
import FillStyle from './FillStyle';
import TextStyle from './TextStyle';
let SS = NativeModules.JSSketchStyle;

/**
 * @class SketchStyle
 * @description 草图显示样式（进行编辑的几何或新采集的几何的外观表现）
 */
export default class SketchStyle {
  /**
   * 构造一个新的SketchStyle对象
   *
   * @memberof SketchStyle
   * @returns {Promise<SketchStyle>}
   */
  async createObj() {
    try {
      var { SketchStyleId } = await SS.createObj();
      var sketchStyle = new SketchStyle();
      sketchStyle._MGSketchStyleId = SketchStyleId;
      return sketchStyle;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取顶点样式
   *
   * @memberof SketchStyle
   * @returns {Promise<PointStyle>}
   */
  async getVertexStyle() {
    try {
      let pointStyleId = await SS.getVertexStyle(this._MGSketchStyleId);
      var pointStyle = new PointStyle();
      pointStyle._MGPointStyleId = pointStyleId;
      return pointStyle;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置顶点样式
   *
   * @memberof SketchStyle
   * @param {Object} vertexPointStyle 顶点样式（PointStyle类型的Object）
   * @returns {Promise<Void>}
   */
  async setVertexStyle(vertexPointStyle) {
    try {
      await SS.setVertexStyle(
        this._MGSketchStyleId,
        vertexPointStyle._MGPointStyleId
      );
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取中点样式
   *
   * @memberof SketchStyle
   * @returns {Promise<PointStyle>}
   */
  async getMidVertexStyle() {
    try {
      let pointStyleId = await SS.getMidVertexStyle(this._MGSketchStyleId);
      var pointStyle = new PointStyle();
      pointStyle._MGPointStyleId = pointStyleId;
      return pointStyle;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置中点样式
   *
   * @memberof SketchStyle
   * @param {Object} midVertexPointStyle 中点样式（PointStyle类型的Object）
   * @returns {Promise<Void>}
   */
  async setMidVertexStyle(midVertexPointStyle) {
    try {
      await SS.setMidVertexStyle(
        this._MGSketchStyleId,
        midVertexPointStyle._MGPointStyleId
      );
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取参考点样式（放大镜内的点，标识手势点，也可用于捕捉）
   *
   * @memberof SketchStyle
   * @returns {Promise<PointStyle>}
   */
  async getReferenceVertexStyle() {
    try {
      let pointStyleId = await SS.getReferenceVertexStyle(
        this._MGSketchStyleId
      );
      var pointStyle = new PointStyle();
      pointStyle._MGPointStyleId = pointStyleId;
      return pointStyle;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置参考点样式（放大镜内的点，标识手势点，也可用于捕捉）
   *
   * @memberof SketchStyle
   * @param {Object} referenceVertexPointStyle 参考点样式（PointStyle类型的Object）
   * @returns {Promise<Void>}
   */
  async setReferenceVertexStyle(referenceVertexPointStyle) {
    try {
      await SS.setReferenceVertexStyle(
        this._MGSketchStyleId,
        referenceVertexPointStyle._MGPointStyleId
      );
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取线样式
   *
   * @memberof SketchStyle
   * @returns {Promise<LineStyle>}
   */
  async getLineStyle() {
    try {
      let lineStyleId = await SS.getLineStyle(this._MGSketchStyleId);
      var lineStyle = new LineStyle();
      lineStyle._MGLineStyleId = lineStyleId;
      return lineStyle;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置线样式
   *
   * @memberof SketchStyle
   * @param {Object} lineStyle 线样式 （LineStyle类型的Object）
   * @returns {Promise<Void>}
   */
  async setLineStyle(lineStyle) {
    try {
      await SS.setLineStyle(this._MGSketchStyleId, lineStyle._MGLineStyleId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取参考线样式（开启放大镜后的牵引线）
   *
   * @memberof SketchStyle
   * @returns {Promise<LineStyle>}
   */
  async getReferenceLineStyle() {
    try {
      let lineStyleId = await SS.getReferenceLineStyle(this._MGSketchStyleId);
      var lineStyle = new LineStyle();
      lineStyle._MGLineStyleId = lineStyleId;
      return lineStyle;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置参考线样式（开启放大镜后的牵引线）
   *
   * @memberof SketchStyle
   * @param {Object} lineStyle （LineStyle类型的Object）
   * @returns {Promise<Void>}
   */
  async setReferenceLineStyle(lineStyle) {
    try {
      await SS.setReferenceLineStyle(
        this._MGSketchStyleId,
        lineStyle._MGLineStyleId
      );
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取区样式
   *
   * @memberof SketchStyle
   * @returns {Promise<FillStyle>}
   */
  async getFillStyle() {
    try {
      let fillStyleId = await SS.getFillStyle(this._MGSketchStyleId);
      var fillStyle = new FillStyle();
      fillStyle._MGFillStyleId = fillStyleId;
      return fillStyle;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置区样式
   *
   * @memberof SketchStyle
   * @param {Object} fillStyle （FillStyle类型的Object）
   * @returns {Promise<Void>}
   */
  async setFillStyle(fillStyle) {
    try {
      await SS.setFillStyle(this._MGSketchStyleId, fillStyle._MGFillStyleId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取被选中的顶点样式
   *
   * @memberof SketchStyle
   * @returns {Promise<PointStyle>}
   */
  async getSelectedVertexStyle() {
    try {
      let pointStyleId = await SS.getSelectedVertexStyle(this._MGSketchStyleId);
      var pointStyle = new PointStyle();
      pointStyle._MGPointStyleId = pointStyleId;
      return pointStyle;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置被选中的顶点样式
   *
   * @memberof SketchStyle
   * @param {Object} selectedVertexPointStyle 被选中的顶点样式（PointStyle类型的Object）
   * @returns {Promise<Void>}
   */
  async setSelectedVertexStyle(selectedVertexPointStyle) {
    try {
      await SS.setSelectedVertexStyle(
        this._MGSketchStyleId,
        selectedVertexPointStyle._MGPointStyleId
      );
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取被选中的中点样式
   *
   * @memberof SketchStyle
   * @returns {Promise<PointStyle>}
   */
  async getSelectedMidVertexStyle() {
    try {
      let pointStyleId = await SS.getSelectedMidVertexStyle(
        this._MGSketchStyleId
      );
      var pointStyle = new PointStyle();
      pointStyle._MGPointStyleId = pointStyleId;
      return pointStyle;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置被选中的中点样式
   *
   * @memberof SketchStyle
   * @param {Object} selectedMidVertexPointStyle 被选中的中点样式（PointStyle类型的Object）
   * @returns {Promise<Void>}
   */
  async setSelectedMidVertexStyle(selectedMidVertexPointStyle) {
    try {
      await SS.setSelectedMidVertexStyle(
        this._MGSketchStyleId,
        selectedMidVertexPointStyle._MGPointStyleId
      );
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取文本样式（标记线段长度、顶点坐标、区面积）
   *
   * @memberof SketchStyle
   * @returns {Promise<TextStyle>}
   */
  async getTextStyle() {
    try {
      let textStyleId = await SS.getTextStyle(this._MGSketchStyleId);
      var textStyle = new TextStyle();
      textStyle._MGTextStyleId = textStyleId;
      return textStyle;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置文本样式
   *
   * @memberof SketchStyle
   * @param {Object} textStyle 文本样式（TextStyle类型的Object）
   * @returns {Promise<Void>}
   */
  async setTextStyle(textStyle) {
    try {
      await SS.setTextStyle(this._MGSketchStyleId, textStyle._MGTextStyleId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 是否显示顶点坐标
   *
   * @memberof SketchStyle
   * @returns {boolean}
   */
  async isShowVertexCoord() {
    try {
      let isShowVertexCoord = await SS.isShowVertexCoord(this._MGSketchStyleId);
      return isShowVertexCoord;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置是否显示顶点坐标
   *
   * @memberof SketchStyle
   * @param {boolean} isShowVertexCoord 是否显示顶点坐标
   * @returns {Promise<Void>}
   */
  async setShowVertexCoord(isShowVertexCoord) {
    try {
      await SS.setShowVertexCoord(this._MGSketchStyleId, isShowVertexCoord);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取是否显示距离
   *
   * @memberof SketchStyle
   * @returns {boolean}
   */
  async isShowSegmentLength() {
    try {
      let isShowSegmentLength = await SS.isShowSegmentLength(
        this._MGSketchStyleId
      );
      return isShowSegmentLength;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置是否显示距离
   * 可通过设置量算类型来控制显示的距离为图面距离还实地距离，显示实地距离时单位为米
   * 显示实地距离时，需要为SketchEditor设置空间参考系。
   * @memberof SketchStyle
   * @param {boolean} isShowSegmentLength 是否显示距离
   * @returns {Promise<Void>}
   */
  async setShowSegmentLength(isShowSegmentLength) {
    try {
      await SS.setShowSegmentLength(this._MGSketchStyleId, isShowSegmentLength);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取是否显示面积
   *
   * @memberof SketchStyle
   * @returns {boolean}
   */
  async isShowArea() {
    try {
      let isShowArea = await SS.isShowArea(this._MGSketchStyleId);
      return isShowArea;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置是否显示面积
   * 可通过设置量算类型来控制显示的面积为图面面积还实地面积，显示实地面积时单位为平方米
   * 显示实地面积时，需要为SketchEditor设置空间参考系。
   * @memberof SketchStyle
   * @param {boolean} isShowArea 是否显示面积
   * @returns {Promise<Void>}
   */
  async setShowArea(isShowArea) {
    try {
      await SS.setShowArea(this._MGSketchStyleId, isShowArea);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取是否开启震动
   *
   * @memberof SketchStyle
   * @returns {boolean}
   */
  async isVibrationEnabled() {
    try {
      let isVibrationEnabled = await SS.isVibrationEnabled(
        this._MGSketchStyleId
      );
      return isVibrationEnabled;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置是否开启震动
   *
   * @memberof SketchStyle
   * @param {boolean} isVibrationEnabled 是否开启震动,true:开启;false:不开启.默认开启.
   * @returns {Promise<Void>}
   */
  async setVibrationEnabled(isVibrationEnabled) {
    try {
      await SS.setVibrationEnabled(this._MGSketchStyleId, isVibrationEnabled);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取量算类型
   *
   * @memberof SketchStyle
   * @returns {Number} 量算类型（int类型的Number，例：1-MeasureType.PLANAR）
   */
  async getMeasureType() {
    try {
      let measureType = await SS.getMeasureType(this._MGSketchStyleId);
      return measureType;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置量算类型
   *
   * @memberof SketchStyle
   * @param {Number} measureType 量算类型（int类型的Number，例：1-MeasureType.PLANAR）
   * @returns {Promise<Void>}
   */
  async setMeasureType(measureType) {
    try {
      await SS.setMeasureType(this._MGSketchStyleId, measureType);
    } catch (e) {
      console.error(e);
    }
  }
}
