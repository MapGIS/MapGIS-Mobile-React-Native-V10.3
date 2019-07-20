/**
 * @content 区对象功能组件
 * @author fjl 2019-6-24 下午2:52:36
 */
import { NativeModules } from "react-native";
import Graphic from "./Graphic";
import Dot from "./Dot";
import GraphicMultiPoint from "./GraphicMultiPoint";
let GP = NativeModules.JSGraphicPolygon;

/**
 * @class GraphicPolygon
 */
export default class GraphicPolygon extends GraphicMultiPoint {
  constructor() {
    super();
    Object.defineProperty(this, "_MGGraphicPolygonId", {
      get: function() {
        return this._MGGraphicMultiPointId;
      },
      set: function(_MGGraphicPolygonId) {
        this._MGGraphicMultiPointId = _MGGraphicPolygonId;
      }
    });
  }

  /**
   * 构造一个新的 GraphicPolygon 对象。
   * @memberOf GraphicPolygon
   * @returns {Promise.<GraphicPolygon>}
   */
  async createObj() {
    try {
      var { GraphicPolygonId } = await GP.createObj();
      var graphicPolygon = new GraphicPolygon();
      graphicPolygon._MGGraphicPolygonId = GraphicPolygonId;
      return graphicPolygon;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取面积
   * @memberOf GraphicPolygon
   * @returns {Promise<*>}
   */
  async getArea() {
    try {
      let area = await GP.getArea(this._MGGraphicPolygonId);
      return area;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置一组坐标点
   * @memberOf GraphicPolygon
   * @param pointArray
   * @param circlesArray
   * @returns {Promise<void>}
   */
  async setPoints(pointArray, circlesArray) {
    try {
      await GP.setPoints(this._MGGraphicMultiPointId, pointArray, circlesArray);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取圈序列
   * @memberOf GraphicPolygon
   * @returns {Promise<*>}
   */
  async getCirclesToList() {
    try {
      let { circlesArray } = await GP.getCirclesToList(
        this._MGGraphicPolygonId
      );
      return circlesArray;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置点的位置
   * @memberOf GraphicPolygon
   * @param {Object} point
   * @returns {Promise<void>}
   */
  async setBorderlineWidth(width) {
    try {
      await GP.setBorderlineWidth(this._MGGraphicPolygonId, width);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取边界线的宽度
   * @memberOf GraphicPolygon
   * @returns {Promise<void>}
   */
  async getBorderlineWidth() {
    try {
      let { borderlineWidth } = await GP.getBorderlineWidth(
        this._MGGraphicPolygonId
      );
      return borderlineWidth;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取点的位置
   * @memberOf GraphicPolygon
   * @returns {Promise<*>}
   */
  async getBorderlineColor() {
    try {
      let { borderlineColor } = await GP.getBorderlineColor(
        this._MGGraphicPolygonId
      );

      return borderlineColor;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置圆边界线的颜色
   * @memberOf GraphicPolygon
   * @param color eg:'rgba(128, 128, 128, 0.5)'
   * @returns {Promise<void>}
   */
  async setBorderlineColor(color) {
    try {
      await GP.setBorderlineColor(this._MGGraphicCircleId, color);
    } catch (e) {
      console.error(e);
    }
  }
}
