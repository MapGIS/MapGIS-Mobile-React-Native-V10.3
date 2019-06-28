/**
 * @content 区对象功能组件
 * @author fjl 2019-6-24 下午2:52:36
 */
import { NativeModules } from 'react-native';
import Graphic from "./Graphic";
import Dot from "./Dot";
let GP = NativeModules.JSGraphicPolygon;

export default class GraphicPolygon extends Graphic{

  constructor(){
    super();
    Object.defineProperty(this,"_MGGraphicPolygonId",{
      get:function () {
        return this._MGGraphicId
      },
      set:function (_MGGraphicPolygonId) {
        this._MGGraphicId = _MGGraphicPolygonId;
      }
    })
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
   * @param point
   * @param radius
   * @returns {Promise<void>}
   */
  async setPoints(pointArray,circlesArray) {
    try {
      await GP.setPoints(this._MGGraphicMultiPointId, pointArray,circlesArray);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取圈序列
   * @returns {Promise<*>}
   */
  async getCirclesToList() {
    try {
      let {circlesArray} = await GP.getCirclesToList(this._MGGraphicPolygonId);
      return circlesArray;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置点的位置
   * @param point
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
   * @returns {Promise<void>}
   */
  async getBorderlineWidth() {
    try {
      let {borderlineWidth} = await GP.getBorderlineWidth(this._MGGraphicPolygonId);
      return borderlineWidth;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取点的位置
   * @returns {Promise<*>}
   */
  async getBorderlineColor() {
    try {
      let {borderlineColor} = await GP.getBorderlineColor(this._MGGraphicPolygonId);

      return borderlineColor;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置圆边界线的颜色
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
