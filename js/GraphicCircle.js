/**
 * @content 圆对象功能组件
 * @author fjl 2019-6-24 下午2:52:36
 */
import { NativeModules } from 'react-native';
import Graphic from './Graphic';
import Dot from './Dot';
import ObjectUtils from './components/ObjectUtils';
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
   * @param {Dot} point 圆心位置
   * @param {Number} radius 半径
   * @returns {Promise<void>}
   */
  async setCenterAndRadius(point, radius) {
    try {
      if(this.isValid() && ObjectUtils.isValidObject(point) && point.isValid()){
        await GC.setCenterAndRadius(
          this._MGGraphicCircleId,
          point._MGDotId,
          radius
        );
      } else {
        console.log('GraphicCircle or point is invalid !');
      }
      
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置圆心位置
   * @memberOf GraphicCircle
   * @param {Dot} point 圆心位置
   * @returns {Promise<void>}
   */
  async setCenterPoint(point) {
    try {
      if(this.isValid() && ObjectUtils.isValidObject(point) && point.isValid()){

        await GC.setCenterPoint(this._MGGraphicCircleId, point._MGDotId);

      } else {
        console.log('GraphicCircle or point is invalid !');
      }
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置半径
   * @memberOf GraphicCircle
   * @param {Number} radius 半径
   * @returns {Promise<void>}
   */
  async setRadius(radius) {
    try {
      if(this.isValid()){

        await GC.setRadius(this._MGGraphicCircleId, radius);

      } else {
        console.log('GraphicCircle is invalid !');
      }
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取半径
   * @memberOf GraphicCircle
   * @returns {Promise<Number>}
   */
  async getRadius() {
    try {
      if(this.isValid()){
        let radius = await GC.getRadius(this._MGGraphicCircleId);

        return radius;
      } else {
        console.log('GraphicCircle is invalid !');
      }
      
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置圆边界线的宽度
   * @memberOf GraphicCircle
   * @param {Number} width 宽度
   * @returns {Promise<void>}
   */
  async setBorderlineWidth(width) {
    try {
      if(this.isValid()){
        await GC.setBorderlineWidth(this._MGGraphicCircleId, width);
      } else {
        console.log('GraphicCircle is invalid !');
      }
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取圆边界线的宽度
   * @memberOf GraphicCircle
   * @returns {Promise<Number>}
   */
  async getBorderlineWidth() {
    try {
      if(this.isValid()){
        let borderlineWidth = await GC.getBorderlineWidth(
          this._MGGraphicCircleId
        );
        return borderlineWidth;
      } else {
        console.log('GraphicCircle is invalid !');
      }
     
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置圆边界线的颜色
   * @memberOf GraphicCircle
   * @param {String} color 颜色 eg:'rgba(128, 128, 128, 128)'
   * @returns {Promise<void>}
   */
  async setBorderlineColor(color) {
    try {
      if(this.isValid()){
        await GC.setBorderlineColor(this._MGGraphicCircleId, color);
      } else {
        console.log('GraphicCircle is invalid !');
      }
    } catch (e) {
      console.error(e);
    }
  }
  /**
   * 获取圆边界线的颜色
   * @memberOf GraphicCircle
   * @returns {Promise<String>} 颜色 eg:'rgba(128, 128, 128, 128)'
   */
  async getBorderlineColor() {
    try {
      if(this.isValid()){
        let { color } = await GC.getBorderlineColor(
          this._MGGraphicCircleId
        );
        return color;
      } else {
        console.log('GraphicCircle is invalid !');
      }
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置半径是否为像素单位(默认情况下为地图单位)
   * @memberOf GraphicCircle
   * @param {boolean} pixel 半径是否为像素单位
   * @returns {Promise<void>}
   */
  async setRadiusByPixel(pixel) {
    try {
      if(this.isValid()){
        await GC.setRadiusByPixel(this._MGGraphicCircleId, pixel);
      } else {
        console.log('GraphicCircle is invalid !');
      }
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取半径是否为像素单位
   * @memberOf GraphicCircle
   * @returns {Promise<boolean>}
   */
  async isRadiusByPixel() {
    try {
      if(this.isValid()){
        let isRadiusByPixel = await GC.isRadiusByPixel(this._MGGraphicCircleId);
        return isRadiusByPixel;
      } else {
        console.log('GraphicCircle is invalid !');
      }
    } catch (e) {
      console.error(e);
    }
  }
}
