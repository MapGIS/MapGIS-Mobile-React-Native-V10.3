/**
 * @content 虚线线对象功能组件
 * @author fjl 2019-6-24 下午2:52:36
 */
import { NativeModules } from 'react-native';
import Graphic from './Graphic';
import Dot from './Dot';
import PointF from './PointF';
import ObjectUtils from './components/ObjectUtils';

let GT = NativeModules.JSGraphicText;

/**
 * @class GraphicText
 */
export default class GraphicText extends Graphic {
  constructor() {
    super();
    Object.defineProperty(this, '_MGGraphicTextId', {
      get: function() {
        return this._MGGraphicId;
      },
      set: function(_MGGraphicTextId) {
        this._MGGraphicId = _MGGraphicTextId;
      },
    });
  }

  /**
   * 构造一个新的 GraphicText 对象。
   * @memberOf GraphicText
   * @returns {Promise.<GraphicText>}
   */
  async createObj() {
    try {
      var { GraphicTextId } = await GT.createObj();
      var graphicText = new GraphicText();
      graphicText._MGGraphicTextId = GraphicTextId;
      return graphicText;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置位置
   * @memberOf GraphicText
   * @param {Dot} point 定位点相对于文字的位置
   * @returns {Promise<void>}
   */
  async setPoint(point) {
    try {
      if(this.isValid() && ObjectUtils.isValidObject(point) && point.isValid()){
        await GT.setPoint(this._MGGraphicTextId, point._MGDotId);
      } else {
        console.log('GraphicText or Dot is invalid !');
      }
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置文本
   * @memberOf GraphicText
   * @param {String} text
   * @returns {Promise<void>}
   */
  async setText(text) {
    try {
      if(this.isValid()){
        await GT.setText(this._MGGraphicTextId, text);
      } else {
        console.log('GraphicText is invalid !');
      }
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置字体大小
   * @memberOf GraphicText
   * @param {Number} fontSize  字体大小
   * @returns {Promise<void>}
   */
  async setFontSize(fontSize) {
    try {
      if(this.isValid()){
        await GT.setFontSize(this._MGGraphicTextId, fontSize);
      } else {
        console.log('GraphicText is invalid !');
      }
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置是否随地图倾斜
   * @memberOf GraphicText
   * @param {boolean} isSlope
   * @returns {Promise<void>}
   */
  async setSlope(isSlope) {
    try {
      if(this.isValid()){
        await GT.setSlope(this._MGGraphicTextId, isSlope);
      } else {
        console.log('GraphicText is invalid !');
      }
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取文本的位置
   * @memberOf GraphicText
   * @returns {Promise<Dot>}
   */
  async getPoint() {
    try {
      if(this.isValid()){
        let { point2DId } = await GT.getPoint(this._MGGraphicTextId);
        let dot = new Dot();
        dot._MGDotId = point2DId;
        return dot;
      } else {
        console.log('GraphicText is invalid !');
      }
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取文本
   * @memberOf GraphicText
   * @returns {Promise<String>}
   */
  async getText() {
    try {
      if(this.isValid()){

        let text = await GT.getText(this._MGGraphicTextId);
        return text;
      } else {
        console.log('GraphicText is invalid !');
      }
      
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取字体大小
   * @memberOf GraphicText
   * @returns {Promise<Number>}
   */
  async getFontSize() {
    try {
      if(this.isValid()){

        let fontSize = await GT.getFontSize(this._MGGraphicTextId);
        return fontSize;
      } else {
        console.log('GraphicText is invalid !');
      }

    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取是否随地图倾斜
   * @memberOf GraphicText
   * @returns {Promise<Boolean>}
   */
  async isSlope() {
    try {
      if(this.isValid()){

        let isSlope = await GT.isSlope(this._MGGraphicTextId);
        return isSlope;
      } else {
        console.log('GraphicText is invalid !');
      }
      
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取文本宽度
   * @memberOf GraphicText
   * @returns {Promise<Number>}
   */
  async getTextWidth() {
    try {
      if(this.isValid()){

        let textWidth = await GT.getTextWidth(this._MGGraphicTextId);
        return textWidth;
      } else {
        console.log('GraphicText is invalid !');
      }
      
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取文本高度
   * @memberOf GraphicText
   * @returns {Promise<Number>}
   */
  async getTextHeight() {
    try {
      if(this.isValid()){

        let textHeight = await GT.getTextHeight(this._MGGraphicTextId);
        return textHeight;
      } else {
        console.log('GraphicText is invalid !');
      }

    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置锚点
   * @memberOf GraphicText
   * @param {PointF} anchorPoint 文本锚点的位置：左下角为(0,0),右上角为(1,1)
   * @returns {Promise<void>}
   */
  async setAnchorPointByPoint(anchorPoint) {
    try {
      if(this.isValid() && ObjectUtils.isValidObject(anchorPoint) && anchorPoint.isValid()){

        await GT.setAnchorPoint(this._MGGraphicTextId, anchorPoint._MGPointFId);

      } else {
        console.log('GraphicText or anchorPoint is invalid !');
      }

    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取锚点
   * @memberOf GraphicText
   * @returns {Promise<PointF>} 文本锚点的位置：左下角为(0,0),右上角为(1,1)
   */
  async getAnchorPoint() {
    try {
      if(this.isValid()){

        let { PointFID } = await GT.getAnchorPoint(this._MGGraphicTextId);
        let pointF = new PointF();
        pointF._MGPointFId = PointFID;
        return pointF;

      } else {
        console.log('GraphicText is invalid !');
      }
      
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置锚点
   * @memberOf GraphicText
   * @param {Number} referenceWidth    参考宽度
   * @param {Number} referenceHeight   参考高度
   * @param {Number} referenceInterval 参考间隔
   * @param {PointF} anchorPoint       文本锚点的位置：左下角为(0,0),右上角为(1,1)
   * @returns {Promise<void>}
   */
  async setReferenceInfo(
    referenceWidth,
    referenceHeight,
    referenceInterval,
    anchorPoint
  ) {
    try {
      if(this.isValid() && ObjectUtils.isValidObject(anchorPoint) && anchorPoint.isValid()){
        await GT.setReferenceInfo(
          this._MGGraphicTextId,
          referenceWidth,
          referenceHeight,
          referenceInterval,
          anchorPoint._MGPointFId
        );
      } else {
        console.log('GraphicText or anchorPoint is invalid !');
      }
      
    } catch (e) {
      console.error(e);
    }
  }
}
