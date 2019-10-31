/**
 * @content 虚线线对象功能组件
 * @author fjl 2019-6-24 下午2:52:36
 */
import { NativeModules } from 'react-native';
import Graphic from './Graphic';
import Dot from './Dot';
let GS = NativeModules.JSGraphicStippleLine;

/**
 * @class GraphicStippleLine
 */
export default class GraphicStippleLine extends Graphic {
  constructor() {
    super();
    Object.defineProperty(this, '_MGGraphicStippleLineId', {
      get: function() {
        return this._MGGraphicId;
      },
      set: function(_MGGraphicStippleLineId) {
        this._MGGraphicId = _MGGraphicStippleLineId;
      },
    });
  }

  /**
   * 构造一个新的 GraphicStippleLine 对象。
   * @memberOf GraphicStippleLine
   * @param {Dot} startPoint 起点
   * @param {Dot} endPoint 终点
   * @returns {Promise.<GraphicStippleLine>}
   */
  async createObj(startPoint, endPoint) {
    try {
      var { GraphicStippleLineId } = await GS.createObj(startPoint._MGDotId, endPoint._MGDotId);
      var graphicStippleLine = new GraphicStippleLine();
      graphicStippleLine._MGGraphicStippleLineId = GraphicStippleLineId;
      return graphicStippleLine;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置起点
   * @memberOf GraphicStippleLine
   * @param {Dot} point 起点
   * @returns {Promise<void>}
   */
  async setStartPoint(point) {
    try {
      await GS.setStartPoint(this._MGGraphicStippleLineId, point._MGDotId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置终点
   * @memberOf GraphicStippleLine
   * @param {Dot} point 终点
   * @returns {Promise<void>}
   */
  async setEndPoint(point) {
    try {
      await GS.setEndPoint(this._MGGraphicStippleLineId, point._MGDotId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置线宽
   * @memberOf GraphicStippleLine
   * @param {number} width 线宽 (Double类型的number)
   * @returns {Promise<void>}
   */
  async setLineWidth(width) {
    try {
      await GS.setLineWidth(this._MGGraphicStippleLineId, width);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置虚线段长度
   * @memberOf GraphicStippleLine
   * @param {Number} len 虚线段长度 (int类型的Number)
   * @returns {Promise<void>}
   */
  async setSegLength(len) {
    try {
      await GS.setSegLength(this._MGGraphicStippleLineId, len);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置虚线间隔长度
   * @memberOf GraphicStippleLine
   * @param {Number} len 虚线间隔长度 (int类型的Number)
   * @returns {Promise<void>}
   */
  async setIntervalLength(len) {
    try {
      await GS.setIntervalLength(this._MGGraphicStippleLineId, len);
    } catch (e) {
      console.error(e);
    }
  }
  /**
   *获取起点的坐标点
   * @memberOf GraphicStippleLine
   * @returns {Promise<Dot>} 起点的坐标点
   */
  async getStartPoint() {
    try {
      let { DotId } = await GS.getStartPoint(this._MGGraphicStippleLineId);
      var dot = new Dot();
      dot._MGDotId = DotId;
      return dot;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   *获取终点的坐标点
   * @memberOf GraphicStippleLine
   * @returns {Promise<Dot>} 终点的坐标点
   */
  async getEndPoint() {
    try {
      let { DotId } = await GS.getEndPoint(this._MGGraphicStippleLineId);
      var dot = new Dot();
      dot._MGDotId = DotId;
      return dot;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取线的宽度
   * @memberOf GraphicStippleLine
   * @returns {Number} 线的宽度 (Double类型的number)
   */
  async getLineWidth() {
    try {
      let lineWidth = await GS.getLineWidth(this._MGGraphicStippleLineId);
      return lineWidth;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取虚线长度
   * @memberOf GraphicStippleLine
   * @returns {Number} 虚线长度 (int类型的number)
   */
  async getSegLength() {
    try {
      let SegLength = await GS.getSegLength(this._MGGraphicStippleLineId);
      return SegLength;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取虚线间隔长度
   * @memberOf GraphicStippleLine
   * @returns {Number} 虚线间隔长度 (int类型的number)
   */
  async getIntervalLength() {
    try {
      let intervalLength = await GS.getIntervalLength(
        this._MGGraphicStippleLineId
      );
      return intervalLength;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取线长度
   * @memberOf GraphicStippleLine
   * @returns {Number} 线长度 (Double类型的number)
   */
  async getLength() {
    try {
      let length = await GS.getLength(this._MGGraphicStippleLineId);
      return length;
    } catch (e) {
      console.error(e);
    }
  }
}
