/**
 * @content 图形对象功能组件
 * @author fjl 2019-6-17 下午2:52:36
 */
import { NativeModules } from 'react-native';
import Dot from './Dot.js';
import Rect from './Rect.js';

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
      let { GraphicId } = await G.createObj();
      let graphic = new Graphic();
      graphic._MGGraphicId = GraphicId;
      return graphic;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取覆盖物的可见状态
   * @memberOf Graphic
   * @returns {Number} 返回层的状态 0 不可见 1 可见
   */
  async getState() {
    try {
      if(this.isValid()){
        let state = await G.getState(this._MGGraphicId);

        return state;
      } else {
        console.log('Graphic is invalid !');
      }
      
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置覆盖物的可见状态
   * @memberOf Graphic
   * @param {Number} state 覆盖物的可见状态。0 不可见；1 可见
   * @returns {Promise<Void>}
   */
  async setState(state) {
    try {
      if(this.isValid()){
        await G.setState(this._MGGraphicId, state);
      } else {
        console.log('Graphic is invalid !');
      }
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置图形颜色
   * @memberOf Graphic
   * @param {String} color 图形颜色 eg:'rgba(128, 128, 128, 255)'
   * @returns {Promise<Void>}
   */
  async setColor(color) {
    try {
      if(this.isValid()){
        await G.setColor(this._MGGraphicId, color);
      } else {
        console.log('Graphic is invalid !');
      }
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取图形的颜色
   * @memberOf Graphic
   * @returns {Promise<String>} 图形颜色 eg:'rgba(128, 128, 128, 255)'
   */
  async getColor() {
    try {
      if(this.isValid()){
        let { color } = await G.getColor(this._MGGraphicId);
        return color;
      } else {
        console.log('Graphic is invalid !');
      }
     
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
      if(this.isValid()){
        let { point2DId, x, y } = await G.getCenterPoint(this._MGGraphicId);
        let dot = new Dot();
        dot._MGDotId = point2DId;
        dot.x = x;
        dot.y = y;
        return dot;
      } else {
        console.log('Graphic is invalid !');
      }
      
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
      if(this.isValid()){
        let { RectId } = await G.getBoundingRect(this._MGGraphicId);
        let rect = new Rect();
        rect._MGRectId = RectId;
        
        return rect;
      } else {
        console.log('Graphic is invalid !');
      }
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取图形类型
   * @memberOf Graphic
   * @returns {Promise<Number>} 图形类型。例：1---GraphicType.PointType
   */
  async getGraphicType() {
    try {
      if(this.isValid()){
        let GraphicType = await G.getGraphicType(this._MGGraphicId);

        return GraphicType;
      } else {
        console.log('Graphic is invalid !');
      }
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置点是否为像素单位(默认情况下为地图单位)
   * @memberOf Graphic
   * @param {boolean} pixel 点是否为像素单位
   * @returns {Promise<void>}
   */
  async setPointByPixel(pixel) {
    try {
      if(this.isValid()){
        
        await G.setPointByPixel(this._MGGraphicId, pixel);

      } else {
        console.log('Graphic is invalid !');
      }
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取点是否为像素单位
   * @memberOf Graphic
   * @returns {Promise<boolean>}
   */
  async isPointByPixel() {
    try {
      if(this.isValid()){
        let isPointByPixel = await G.isPointByPixel(this._MGGraphicId);

        return isPointByPixel;
      } else {
        console.log('Graphic is invalid !');
      }
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置图形的属性
   * @memberOf Graphic
   * @param {String} name 属性名称
   * @param {String} value 属性值
   * @returns {Promise<void>}
   */
  async setAttributeValue(name, value) {
    try {
      if(this.isValid()){
        await G.setAttributeValue(this._MGGraphicId, name, value);

      } else {
        console.log('Graphic is invalid !');
      }
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取图形属性的数目
   * @memberOf Graphic
   * @returns {Promise<Number>}
   */
  async getAttributeNum() {
    try {
      if(this.isValid()){
        let attributeNum = await G.getAttributeNum(this._MGGraphicId);

        return attributeNum;
      } else {
        console.log('Graphic is invalid !');
      }
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 根据索引获取图形属性名
   * @memberOf Graphic
   * @param {Number} index 索引
   * @returns {Promise<String>}
   */
  async getAttributeName(index) {
    try {
      if(this.isValid()){
        let attributeName = await G.getAttributeName(this._MGGraphicId, index);
        
        return attributeName;
      } else {
        console.log('Graphic is invalid !');
      }
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 根据索引获取图形属性值
   * @memberOf Graphic
   * @param {Number} index 图形属性的索引，从0开始到属性数目减1
   * @returns {Promise<String>}
   */
  async getAttributeValueByIndex(index) {
    try {
      if(this.isValid()){
        let attributeValue = await G.getAttributeValue(this._MGGraphicId, index);

        return attributeValue;
      } else {
        console.log('Graphic is invalid !');
      }
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 根据属性名称获取图形属性值
   * @memberOf Graphic
   * @param {String} name 属性名称
   * @returns {Promise<String>}
   */
  async getAttributeValueByName(name) {
    try {
      if(this.isValid()){
        let attributeValue = await G.getAttributeValueByName(this._MGGraphicId, name);
        return attributeValue;
      } else {
        console.log('Graphic is invalid !');
      }
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 移除指定名称的属性
   * @memberOf Graphic
   * @param {String} name 属性名称
   * @returns {Promise<void>}
   */
  async removeAttribute(name) {
    try {
      if(this.isValid()){
        await G.removeAttribute(this._MGGraphicId, name);
      } else {
        console.log('Graphic is invalid !');
      }
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
      if(this.isValid()){
        await G.removeAllAttributes(this._MGGraphicId);
      } else {
        console.log('Graphic is invalid !');
      }
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 判断Graphic对象是否有效
   * 
   * @memberOf Graphic
   * @returns {boolean} 是否有效。true: 有效；false：无效
   */
  isValid(){
    try {
      if(this._MGGraphicId === undefined || this._MGGraphicId === null){
        return false;
      }else{
        return true;
      }
    } catch (e) {
      console.error(e);
    }
  }
}
