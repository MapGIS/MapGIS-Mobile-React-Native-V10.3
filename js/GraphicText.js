/**
 * @content 虚线线对象功能组件
 * @author fjl 2019-6-24 下午2:52:36
 */
import { NativeModules } from "react-native";
import Graphic from "./Graphic";
import Dot from "./Dot";
import PointF from "./PointF";

let GT = NativeModules.JSGraphicText;

/**
 * @class GraphicText
 */
export default class GraphicText extends Graphic {
  constructor() {
    super();
    Object.defineProperty(this, "_MGGraphicTextId", {
      get: function() {
        return this._MGGraphicId;
      },
      set: function(_MGGraphicTextId) {
        this._MGGraphicId = _MGGraphicTextId;
      }
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
   * @param point 定位点相对于文字的位置
   * @returns {Promise<void>}
   */
  async setPoint(point) {
    try {
      await GT.setPoint(this._MGGraphicTextId, point._MGDotId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置文本
   * @memberOf GraphicText
   * @param text
   * @returns {Promise<void>}
   */
  async setText(text) {
    try {
      await GT.setText(this._MGGraphicTextId, text);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置线宽
   * @memberOf GraphicText
   * @param fontSize
   * @returns {Promise<void>}
   */
  async setFontSize(fontSize) {
    try {
      await GT.setFontSize(this._MGGraphicTextId, fontSize);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置是否随地图倾斜
   * @memberOf GraphicText
   * @param isSlope
   * @returns {Promise<void>}
   */
  async setSlope(isSlope) {
    try {
      await GT.setSlope(this._MGGraphicTextId, isSlope);
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
      let { dotID } = await GT.getPoint(this._MGGraphicTextId);
      var dot = new Dot();
      dot._MGDotId = dotID;
      return dot;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取文本
   * @memberOf GraphicText
   * @returns {Promise<*>}
   */
  async getText() {
    try {
      let text = await GT.getText(this._MGGraphicTextId);
      return text;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取字体大小
   * @memberOf GraphicText
   * @returns {Promise<*>}
   */
  async getFontSize() {
    try {
      let fontSize = await GT.getFontSize(this._MGGraphicTextId);
      return fontSize;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取是否随地图倾斜
   * @memberOf GraphicText
   * @returns {Promise<*>}
   */
  async isSlope() {
    try {
      let isSlope = await GT.isSlope(this._MGGraphicTextId);
      return isSlope;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取文本宽度
   * @memberOf GraphicText
   * @returns {Promise<*|*>}
   */
  async getTextWidth() {
    try {
      let textWidth = await GT.getTextWidth(this._MGGraphicTextId);
      return textWidth;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取文本高度
   * @memberOf GraphicText
   * @returns {Promise<*>}
   */
  async getTextHeight() {
    try {
      let textHeight = await GT.getTextHeight(this._MGGraphicTextId);
      return textHeight;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置锚点
   * @memberOf GraphicText
   * @param anchorPoint 图片锚点的位置：左下角为(0,0),右上角为(1,1)
   * @returns {Promise<void>}
   */
  async setAnchorPoint(anchorPoint) {
    try {
      await GI.setAnchorPoint(this._MGGraphicTextId, anchorPoint._MGPointFId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取锚点
   * @memberOf GraphicText
   * @returns {Promise<*>}
   */
  async getAnchorPoint() {
    try {
      let { PointFID } = await GT.getAnchorPoint(this._MGGraphicTextId);
      var pointF = new PointF();
      pointF._MGPointFId = PointFID;
      return pointF;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置锚点
   * @memberOf GraphicText
   * @param referenceWidth
   * @param referenceHeight
   * @param referenceInterval
   * @param anchorPoint
   * @returns {Promise<void>}
   */
  async setAnchorPoint(
    referenceWidth,
    referenceHeight,
    referenceInterval,
    anchorPoint
  ) {
    try {
      await GT.setAnchorPoint(
        this._MGGraphicTextId,
        referenceWidth,
        referenceHeight,
        referenceInterval,
        anchorPoint._MGPointFId
      );
    } catch (e) {
      console.error(e);
    }
  }
}
