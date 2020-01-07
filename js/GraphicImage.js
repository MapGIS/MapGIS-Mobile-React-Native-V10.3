/**
 * @content 图片对象功能组件
 * @author fjl 2019-6-24 下午2:52:36
 */
import { NativeModules } from 'react-native';
import Graphic from './Graphic';
import Image from './Image';
import PointF from './PointF';
import Dot from './Dot';
import ObjectUtils from './components/ObjectUtils';
let GI = NativeModules.JSGraphicImage;

/**
 * @constructor GraphicImage
 */
export default class GraphicImage extends Graphic {
  constructor() {
    super();
    Object.defineProperty(this, '_MGGraphicImageId', {
      get: function() {
        return this._MGGraphicId;
      },
      set: function(_MGGraphicImageId) {
        this._MGGraphicId = _MGGraphicImageId;
      },
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
   * 通过文件路径设置图片
   * @memberOf GraphicImage
   * @param {String} filePath
   * @returns {Promise<void>}
   */
  async setImageByFilePath(filePath) {
    try {
      if(this.isValid()){
        await GI.setImageFromPath(this._MGGraphicImageId, filePath);
      } else {
        console.log('GraphicImage is invalid !');
      }
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置图片
   * @memberOf GraphicImage
   * @param {Image} image
   * @returns {Promise<void>}
   */
  async setImage(image) {
    try {
      if(this.isValid() && ObjectUtils.isValidObject(image) && image.isValid()){
        await GI.setImage(this._MGGraphicImageId, image._MGImageId);
      } else {
        console.log('GraphicImage or image is invalid !');
      }
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置位置
   * @memberOf GraphicImage
   * @param {Dot} point
   * @returns {Promise<void>}
   */
  async setPoint(point) {
    try {
      if(this.isValid() && ObjectUtils.isValidObject(point) && point.isValid()){
        await GI.setPoint(this._MGGraphicImageId, point._MGDotId);
      } else {
        console.log('GraphicImage or point is invalid !');
      }
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置锚点
   * @memberOf GraphicImage
   * @param {PointF} anchorPoint 图片锚点的位置：左下角为(0,0),右上角为(1,1)
   * @returns {Promise<void>}
   */
  async setAnchorPoint(anchorPoint) {
    try {
      if(this.isValid() && ObjectUtils.isValidObject(anchorPoint) && anchorPoint.isValid()){
        await GI.setAnchorPoint(this._MGGraphicImageId, anchorPoint._MGPointFId);
      } else {
        console.log('GraphicImage or anchorPoint is invalid !');
      }
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取锚点
   * @memberOf GraphicImage
   * @returns {Promise<PointF>}
   */
  async getAnchorPoint() {
    try {
      if(this.isValid()){
        let { PointFID } = await GI.getAnchorPoint(this._MGGraphicImageId);
        var pointF = new PointF();
        pointF._MGPointFId = PointFID;
        return pointF;
      } else {
        console.log('GraphicImage is invalid !');
      }
     
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置透明度
   * @memberOf GraphicImage
   * @param {Number} alpha 透明度：0(透明)-255(不透明)
   * @returns {Promise<void>}
   */
  async setAlpha(alpha) {
    try {
      if(this.isValid()){
        await GI.setAlpha(this._MGGraphicImageId, alpha);
      } else {
        console.log('GraphicImage is invalid !');
      }
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
      if(this.isValid()){
        await GI.setRotateAngle(this._MGGraphicImageId, rotateAngle);
      } else {
        console.log('GraphicImage is invalid !');
      }
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
      if(this.isValid()){
        await GI.setSlope(this._MGGraphicImageId, IsSlope);
      } else {
        console.log('GraphicImage is invalid !');
      }
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取图片
   * @memberOf GraphicImage
   * @returns {Promise<Image>}
   */
  async getImage() {
    try {
      if(this.isValid()){
        let { ImageID } = await GI.getImage(this._MGGraphicImageId);
        var image = new Image();
        image._MGImageId = ImageID;
        return image;
      } else {
        console.log('GraphicImage is invalid !');
      }
      
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
      if(this.isValid()){
        var { dotID } = await GI.getPoint(this._MGGraphicImageId);
        var dot = new Dot();
        dot._MGDotId = dotID;
        return dot;
      } else {
        console.log('GraphicImage is invalid !');
      }
     
    } catch (e) {
      console.error(e);
    }
  }
  /**
   * 获取旋转角度
   * @memberOf GraphicImage
   * @returns {Promise<Number>}
   */
  async getRotateAngle() {
    try {
      if(this.isValid()){
        let rotateAngle = await GI.getRotateAngle(this._MGGraphicImageId);
 
        return rotateAngle;
      } else {
        console.log('GraphicImage is invalid !');
      }
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取透明度
   * @memberOf GraphicImage
   * @returns {Promise<Number>}
   */
  async getAlpha() {
    try {
      if(this.isValid()){
        let alpha = await GI.getAlpha(this._MGGraphicImageId);

        return alpha;
      } else {
        console.log('GraphicImage is invalid !');
      }
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取是否随地图倾斜
   * @memberOf GraphicImage
   * @returns {Promise<boolean>}
   */
  async isSlope() {
    try {
      if(this.isValid()){
        let isSlope = await GI.isSlope(this._MGGraphicImageId);
        return isSlope;
      } else {
        console.log('GraphicImage is invalid !');
      }
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取图片宽度
   * @memberOf GraphicImage
   * @returns {Promise<Number>}
   */
  async getImageWidth() {
    try {
      if(this.isValid()){
        let imageWidth = await GI.getImageWidth(this._MGGraphicImageId);
        return imageWidth;
      } else {
        console.log('GraphicImage is invalid !');
      }
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取图片高度
   * @memberOf GraphicImage
   * @returns {Promise<Number>}
   */
  async getImageHeight() {
    try {
      if(this.isValid()){
        let imageHeight = await GI.getImageHeight(this._MGGraphicImageId);
        
        return imageHeight;
      } else {
        console.log('GraphicImage is invalid !');
      }
    } catch (e) {
      console.error(e);
    }
  }
}
