/**
 * @content 虚线线对象功能组件
 * @author fjl 2019-6-24 下午2:52:36
 */
import { NativeModules } from 'react-native';
import Graphic from "./Graphic";
import Dot from "./Dot";
let GS = NativeModules.JSGraphicStippleLine;

/**
 * @class GraphicStippleLine
 */
export default class GraphicStippleLine extends Graphic{

  constructor(){
    super();
    Object.defineProperty(this,"_MGGraphicStippleLineId",{
      get:function () {
        return this._MGGraphicId
      },
      set:function (_MGGraphicStippleLineId) {
        this._MGGraphicId = _MGGraphicStippleLineId;
      }
    })
  }

  /**
   * 构造一个新的 GraphicStippleLine 对象。
   * @memberOf GraphicStippleLine
   * @returns {Promise.<GraphicStippleLine>}
   */
  async createObj() {
    try {
      var { GraphicStippleLineId } = await GS.createObj();
      var graphicCircle = new GraphicStippleLine();
      graphicCircle._MGGraphicStippleLineId = GraphicStippleLineId;
      return graphicCircle;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置起点
   * @memberOf GraphicStippleLine
   * @param point
   * @returns {Promise<void>}
   */
  async setStartPoint(point) {
    try {
      await GS.setStartPoint(this._MGGraphicMultiPointId, point._MGDotId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置起点
   * @memberOf GraphicStippleLine
   * @param point
   * @returns {Promise<void>}
   */
  async setEndPoint(point) {
    try {
      await GS.setEndPoint(this._MGGraphicMultiPointId, point._MGDotId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置线宽
   * @memberOf GraphicStippleLine
   * @param width
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
   * @param width
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
   * @param len
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
   * @returns {Promise<Dot>}
   */
  async getStartPoint() {
    try {
      let {dotID} = await GS.getStartPoint(this._MGGraphicStippleLineId);
      var dot = new Dot();
      dot._MGDotId = dotID;
      return dot;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   *获取起点的坐标点
   * @memberOf GraphicStippleLine
   * @returns {Promise<Dot>}
   */
  async GetEndPoint() {
    try {
      let {dotID} = await GS.GetEndPoint(this._MGGraphicStippleLineId);
      var dot = new Dot();
      dot._MGDotId = dotID;
      return dot;
    } catch (e) {
      console.error(e);
    }
  }



  /**
   * 获取线的宽度
   * @memberOf GraphicStippleLine
   * @returns {Promise<*>}
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
   * @returns {Promise<*>}
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
   * @returns {Promise<*>}
   */
  async getIntervalLength() {
    try {
      let intervalLength = await GS.getIntervalLength(this._MGGraphicStippleLineId);
      return intervalLength;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取线长度
   * @memberOf GraphicStippleLine
   * @returns {Promise<*|*>}
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
