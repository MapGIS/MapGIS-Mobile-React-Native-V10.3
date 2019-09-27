/**
 * @content 图片对象功能组件
 * @author fjl 2019-6-24 下午2:52:36
 */
import { NativeModules } from "react-native";
import Graphic from "./Graphic";
import Image from "./Image";
import PointF from "./PointF";
import Dot from "./Dot";
let GI = NativeModules.JSGraphicImage;

/**
 * @constructor GraphicImage
 */
export default class GraphicImage extends Graphic {
  constructor() {
    super();
    Object.defineProperty(this, "_MGGraphicImageId", {
      get: function() {
        return this._MGGraphicId;
      },
      set: function(_MGGraphicImageId) {
        this._MGGraphicId = _MGGraphicImageId;
      }
    });
  }

  /**
   * 构造一个新的 GraphicImage 对象。
   * @memberOf GraphicImage
   * @returns {Promise.<GraphicImage>}
   */
  async createObj() {
    try {
      var { GraphicImageId } = await GI.createObj();
      var graphicImage = new GraphicImage();
      graphicImage._MGGraphicImageId = GraphicImageId;
      return graphicImage;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置图片
   * @memberOf GraphicImage
   * @param {String} filePath
   * @returns {Promise<void>}
   */
  async setImageByFilePath(filePath) {
    try {
      await GI.setImage(this._MGGraphicImageId, filePath);
    } catch (e) {
      console.error(e);
    }
  }


  /**
   * 设置图片
   * @memberOf GraphicImage
   * @param {Object} image
   * @returns {Promise<void>}
   */
  async setImage(image) {
    try {
      await GI.setImage(this._MGGraphicImageId, image._MGImageId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置位置
   * @memberOf GraphicImage
   * @param {Object} point
   * @returns {Promise<void>}
   */
  async setPoint(point) {
    try {
      await GI.setPoint(this._MGGraphicImageId, point._MGDotId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置锚点
   * @memberOf GraphicImage
   * @param {Object} anchorPoint 图片锚点的位置：左下角为(0,0),右上角为(1,1)
   * @returns {Promise<void>}
   */
  async setAnchorPoint(anchorPoint) {
    try {
      await GI.setAnchorPoint(this._MGGraphicImageId, anchorPoint._MGPointFId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取锚点
   * @memberOf GraphicImage
   * @returns {Promise<*>}
   */
  async getAnchorPoint() {
    try {
      let { PointFID } = await GI.getAnchorPoint(this._MGGraphicImageId);
      var pointF = new PointF();
      pointF._MGPointFId = PointFID;
      return pointF;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置透明度
   * @memberOf GraphicImage
   * @param {number} alpha 透明度：0(透明)-255(不透明)
   * @returns {Promise<void>}
   */
  async setAlpha(alpha) {
    try {
      await GI.setAlpha(this._MGGraphicImageId, alpha);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置旋转角度
   * @memberOf GraphicImage
   * @param {Number} rotateAngle
   * @returns {Promise<void>}
   */
  async setRotateAngle(rotateAngle) {
    try {
      await GI.setRotateAngle(this._MGGraphicImageId, rotateAngle);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置是否随地图倾斜
   * @memberOf GraphicImage
   * @param {Boolean} IsSlope
   * @returns {Promise<void>}
   */
  async setSlope(IsSlope) {
    try {
      await GI.setSlope(this._MGGraphicImageId, IsSlope);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取图片
   * @memberOf GraphicImage
   * @returns {Promise<*>}
   */
  async getImage() {
    try {
      let { ImageID } = await GI.getImage(this._MGGraphicImageId);
      var image = new Image();
      image._MGImageId = ImageID;
      return image;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取位置
   * @memberOf GraphicImage
   * @returns {Promise<Dot>}
   */
  async getPoint() {
    try {
      var { dotID } = await GI.getPoint(this._MGGraphicImageId);
      var dot = new Dot();
      dot._MGDotId = dotID;
      return dot;
    } catch (e) {
      console.error(e);
    }
  }
  /**
   * 获取旋转角度
   * @memberOf GraphicImage
   * @returns {Promise<*>}
   */
  async getRotateAngle() {
    try {
      let rotateAngle = await GI.getRotateAngle(this._MGGraphicImageId);
      return rotateAngle;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取透明度
   * @memberOf GraphicImage
   * @returns {Promise<*>}
   */
  async getAlpha() {
    try {
      let alpha = await GI.getAlpha(this._MGGraphicImageId);
      return alpha;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取是否随地图倾斜
   * @memberOf GraphicImage
   * @returns {Promise<*>}
   */
  async isSlope() {
    try {
      let isSlope = await GI.isSlope(this._MGGraphicImageId);
      return isSlope;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取图片宽度
   * @memberOf GraphicImage
   * @returns {Promise<*>}
   */
  async getImageWidth() {
    try {
      let imageWidth = await GI.getImageWidth(this._MGGraphicImageId);
      return imageWidth;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取图片高度
   * @memberOf GraphicImage
   * @returns {Promise<*>}
   */
  async getImageHeight() {
    try {
      let imageHeight = await GI.getImageHeight(this._MGGraphicImageId);
      return imageHeight;
    } catch (e) {
      console.error(e);
    }
  }
}
