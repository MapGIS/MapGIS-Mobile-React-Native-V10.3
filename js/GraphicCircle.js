/**
 * @content 圆对象功能组件
 * @author fjl 2019-6-24 下午2:52:36
 */
import { NativeModules } from 'react-native';
import Graphic from './Graphic';
let GC = NativeModules.JSGraphicCircle;

/**
 * @class GraphicCircle
 */
export default class GraphicCircle extends Graphic {
  constructor() {
    super();
    Object.defineProperty(this, '_MGGraphicCircleId', {
      get: function() {
        return this._MGGraphicId;
      },
      set: function(_MGGraphicCircleId) {
        this._MGGraphicId = _MGGraphicCircleId;
      },
    });
  }

  /**
   * 构造一个新的 GraphicCircle 对象。
   * @memberOf GraphicCircle
   * @returns {Promise.<GraphicCircle>}
   */
  async createObj() {
    try {
      var { GraphicCircleId } = await GC.createObj();
      var graphicCircle = new GraphicCircle();
      graphicCircle._MGGraphicCircleId = GraphicCircleId;
      return graphicCircle;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置圆心位置和半径
   * @memberOf GraphicCircle
   * @param point
   * @param radius
   * @returns {Promise<void>}
   */
  async setCenterAndRadius(point, radius) {
    try {
      await GC.setCenterAndRadius(
        this._MGGraphicCircleId,
        point._MGDotId,
        radius
      );
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置圆心位置
   * @memberOf GraphicCircle
   * @param point
   * @returns {Promise<void>}
   */
  async setCenterPoint(point) {
    try {
      await GC.setCenterPoint(this._MGGraphicCircleId, point._MGDotId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置半径
   * @memberOf GraphicCircle
   * @param radius
   * @returns {Promise<void>}
   */
  async setRadius(radius) {
    try {
      await GC.setRadius(this._MGGraphicCircleId, radius);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取是否符号化显示
   * @memberOf GraphicCircle
   * @returns {Promise<*>}
   */
  async getRadius() {
    try {
      let radius = await GC.getRadius(this._MGGraphicCircleId);
      return radius;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置圆边界线的宽度
   * @memberOf GraphicCircle
   * @param width
   * @returns {Promise<void>}
   */
  async setBorderlineWidth(width) {
    try {
      await GC.setBorderlineWidth(this._MGGraphicCircleId, width);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取圆边界线的宽度
   * @memberOf GraphicCircle
   * @returns {Promise<*>}
   */
  async getBorderlineWidth() {
    try {
      let borderlineWidth = await GC.getBorderlineWidth(
        this._MGGraphicCircleId
      );
      return borderlineWidth;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置圆边界线的颜色
   * @memberOf GraphicCircle
   * @param color eg:'rgba(128, 128, 128, 0.5)'
   * @returns {Promise<void>}
   */
  async setBorderlineColor(color) {
    try {
      await GC.setBorderlineColor(this._MGGraphicCircleId, color);
    } catch (e) {
      console.error(e);
    }
  }
  /**
   * 获取圆边界线的颜色
   * @memberOf GraphicCircle
   * @returns {Promise<*>}
   */
  async getBorderlineColor() {
    try {
      let borderlineColor = await GC.getBorderlineColor(
        this._MGGraphicCircleId
      );
      return borderlineColor;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置半径是否为像素单位(默认情况下为地图单位)
   * @memberOf GraphicCircle
   * @param pixel
   * @returns {Promise<void>}
   */
  async setRadiusByPixel(pixel) {
    try {
      await GC.setRadiusByPixel(this._MGGraphicCircleId, pixel);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取半径是否为像素单位
   * @memberOf GraphicCircle
   * @returns {Promise<*>}
   */
  async isRadiusByPixel() {
    try {
      let isRadiusByPixel = await GC.isRadiusByPixel(this._MGGraphicCircleId);
      return isRadiusByPixel;
    } catch (e) {
      console.error(e);
    }
  }
}
