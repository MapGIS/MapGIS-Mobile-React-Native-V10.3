/**
 * @content 线对象功能组件
 * @author fjl 2019-6-24 下午2:52:36
 */
import { NativeModules } from 'react-native';
import GraphicMultiPoint from './GraphicMultiPoint';
import Graphic from './Graphic';
import Image from './Image';
import ObjectUtils from './components/ObjectUtils';
let GP = NativeModules.JSGraphicPolylin;

/**
 * @class GraphicPolylin
 */
export default class GraphicPolylin extends GraphicMultiPoint {
  constructor() {
    super();
    Object.defineProperty(this, '_MGGraphicPolylinId', {
      get: function() {
        return this._MGGraphicMultiPointId;
      },
      set: function(_MGGraphicPolylinId) {
        this._MGGraphicMultiPointId = _MGGraphicPolylinId;
      },
    });
  }

  /**
   * 构造一个新的 GraphicPolylin 对象。
   * @memberOf GraphicPolylin
   * @returns {Promise.<GraphicPolylin>}
   */
  async createObj() {
    try {
      var { GraphicPolylinId } = await GP.createObj();
      var graphicPolylin = new GraphicPolylin();
      graphicPolylin._MGGraphicPolylinId = GraphicPolylinId;
      return graphicPolylin;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置线宽
   * @memberOf GraphicPolylin
   * @param {Number} width
   * @returns {Promise<void>}
   */
  async setLineWidth(width) {
    try {
      if(this.isValid()){
        await GP.setLineWidth(this._MGGraphicPolylinId, width);
      } else {
        console.log('GraphicPolylin is invalid !');
      }
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取线的宽度
   * @memberOf GraphicPolylin
   * @returns {Promise<Number>}
   */
  async getLineWidth() {
    try {
      if(this.isValid()){
        let lineWidth = await GP.getLineWidth(this._MGGraphicPolylinId);
        return lineWidth;
      } else {
        console.log('GraphicPolylin is invalid !');
      }
     
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取线的长度
   * @memberOf GraphicPolylin
   * @returns {Promise<Number>}
   */
  async getLength() {
    try {
      if(this.isValid()){
        let length = await GP.getLength(this._MGGraphicPolylinId);
        return length;
      } else {
        console.log('GraphicPolylin is invalid !');
      }
      
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置线的填充纹理 要求纹理的宽高为2的幂。
   * @memberOf GraphicPolylin
   * @param {Image} image 填充图片
   * @returns {Promise<void>}
   */
  async setFillTexture(image) {
    try {
      if(this.isValid() && ObjectUtils.isValidObject(image) && image.isValid()){
        await GP.setFillTexture(this._MGGraphicPolylinId, image._MGImageId);
      } else {
        console.log('GraphicPolylin or image is invalid !');
      }
    } catch (e) {
      console.error(e);
    }
  }
}
