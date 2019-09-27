/**
 * @content 图形对象功能组件
 * @author fjl 2019-6-17 下午2:52:36
 */
import { NativeModules } from "react-native";
import Dot from "./Dot.js";
import Rect from "./Rect.js";

let G = NativeModules.JSGraphic;
/**
 * @class Graphic
 */
export default class Graphic {
  /**
   * 构造一个新的 Graphic 对象。
   * @memberOf Graphic
   * @returns {Promise.<Graphic>}
   */
  async createObj() {
    try {
      var { GraphicId } = await G.createObj();
      var graphic = new Graphic();
      graphic._MGGraphicId = GraphicId;
      return graphic;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取覆盖物的可见状态
   * @memberOf Graphic
   * @return 返回层的状态 0 不可见 1 可见
   */
  async getState() {
    try {
      let state = await G.getState(this._MGGraphicId);

      return state;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置覆盖物的可见状态
   * @memberOf Graphic
   * @param state
   */
  async setState(state) {
    try {
      await G.setState(this._MGGraphicId, state);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置图形颜色
   * @memberOf Graphic
   * @param color eg:'rgba(128, 128, 128, 0.5)'
   */
  async setColor(color) {
    try {
      await G.setColor(this._MGGraphicId, color);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取图形的颜色
   * @memberOf Graphic
   * @memberOf Graphic
   * @returns {Promise<*>}
   */
  async getColor() {
    try {
      let color = await G.getColor(this._MGGraphicId);

      return color;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取图形中心点坐标
   * @memberOf Graphic
   * @returns {Promise<Dot>}
   */
  async getCenterPoint() {
    try {
      var { point2DId, x, y } = await G.getCenterPoint(this._MGGraphicId);
      var dot = new Dot();
      dot._MGDotId = point2DId;
      dot.x = x;
      dot.y = y;
      return dot;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取图形外包矩形
   * @memberOf Graphic
   * @returns {Promise<Rect>}
   */
  async getBoundingRect() {
    try {
      var { rectId } = await G.getBoundingRect(this._MGGraphicId);
      var rect = new Rect();
      rect._MGRectId = rectId;
      return rect;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取图形类型
   * @memberOf Graphic
   * @returns {Promise<*>}
   */
  async getGraphicType() {
    try {
      let GraphicType = await G.getGraphicType(this._MGGraphicId);
      return GraphicType;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置点是否为像素单位(默认情况下为地图单位)
   * @memberOf Graphic
   * @param pixel
   * @returns {Promise<void>}
   */
  async setPointByPixel(pixel) {
    try {
      await G.setPointByPixel(this._MGGraphicId, pixel);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取点是否为像素单位
   * @memberOf Graphic
   * @returns {Promise<*>}
   */
  async isPointByPixel() {
    try {
      let isPointByPixel = await G.isPointByPixel(this._MGGraphicId);
      return isPointByPixel;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置图形的属性
   * @memberOf Graphic
   * @param name
   * @param value
   * @returns {Promise<void>}
   */
  async setAttributeValue(name, value) {
    try {
      await G.setAttributeValue(this._MGGraphicId, name, value);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取图形属性的数目
   * @memberOf Graphic
   * @returns {Promise<*>}
   */
  async getAttributeNum() {
    try {
      let attributeNum = await G.getAttributeNum(this._MGGraphicId);
      return attributeNum;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 根据索引获取图形属性名
   * @memberOf Graphic
   * @returns {Promise<*>}
   */
  async getAttributeName(index) {
    try {
      let attributeName = await G.getAttributeName(this._MGGraphicId, index);
      return attributeName;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 根据索引获取图形属性值
   * @memberOf Graphic
   * @param index 图形属性的索引，从0开始到属性数目减1
   * @returns {Promise<*>}
   */
  async getAttributeValueByIndex(index) {
    try {
      let attributeValue = await G.getAttributeName(this._MGGraphicId, index);
      return attributeValue;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 根据属性名称获取图形属性值
   * @memberOf Graphic
   * @param name
   * @returns {Promise<*>}
   */
  async getAttributeValueByName(name) {
    try {
      let attributeValue = await G.getAttributeName(this._MGGraphicId, name);
      return attributeValue;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 移除指定名称的属性
   * @memberOf Graphic
   * @param name
   * @returns {Promise<void>}
   */
  async removeAttribute(name) {
    try {
      await G.removeAttribute(this._MGGraphicId, name);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 移除所有属性.
   * @memberOf Graphic
   * @returns {Promise<void>}
   */
  async removeAllAttributes() {
    try {
      await G.removeAllAttributes(this._MGGraphicId);
    } catch (e) {
      console.error(e);
    }
  }
}
