/*
 * @Description: 场景地标图形组件
 * @Version: 1.0
 * @Autor: liaoliang
 * @Date: 2020-08-19 08:19:52
 * @LastEditors: liaoliang
 * @LastEditTime: 2020-08-19 22:37:19
 */

import { NativeModules } from 'react-native';
import Graphic3D from './Graphic3D';

let GPM = NativeModules.JSGraphicPlaceMarker;

export default class GraphicPlaceMarker extends Graphic3D {
  constructor() {
    super();
    Object.defineProperty(this, '_MGGraphicPlaceMarkerId', {
      get: function () {
        return this._MGGraphic3DId;
      },
      set: function (_MGGraphicPlaceMarkerId) {
        this._MGGraphic3DId = _MGGraphicPlaceMarkerId;
      },
    });
  }

  /**
   * @description: 构造一个新的 GraphicPlaceMarker 对象
   * @param {type}
   * @return:
   */
  async createObj() {
    try {
      var { graphicPlaceMarkerId } = await GPM.createObj();
      var graphicPlaceMarker = new GraphicPlaceMarker();
      graphicPlaceMarker._MGGraphicPlaceMarkerId = graphicPlaceMarkerId;
      return graphicPlaceMarker;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 获取边界线像素偏移
   * @param {type}
   * @return {float} borderlineOffset
   */
  async getBorderlineOffset() {
    try {
      let borderlineOffset = await GPM.getBorderlineOffset(
        this._MGGraphicPlaceMarkerId
      );

      return borderlineOffset;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 获取是否开启重叠检测
   * @param {type}
   * @return {boolean}
   */
  async getEnableDecluttering() {
    try {
      let isEnableDecluttering = await GPM.getEnableDecluttering(
        this._MGGraphicPlaceMarkerId
      );

      return isEnableDecluttering;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 获取地标的方向角
   * @param {type}
   * @return {float}
   */
  async getImageHeading() {
    try {
      let imageHeading = await GPM.getImageHeading(
        this._MGGraphicPlaceMarkerId
      );

      return imageHeading;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 获取地标图片的路径
   * @param {type}
   * @return {type}
   */
  async getImagePath() {
    try {
      let imagePath = await GPM.getImagePath(this._MGGraphicPlaceMarkerId);

      return imagePath;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 获取距离中心点像素偏移的id
   * @param {type}
   * @return {type}
   */
  async getLabelPixelOffset() {
    try {
      let labelPixelOffsetId = await GPM.getLabelPixelOffset(
        this._MGGraphicPlaceMarkerId
      );

      return labelPixelOffsetId;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 获取地标标签
   * @param {type}
   * @return {type}
   */
  async getLabelText() {
    try {
      let labelText = await GPM.getLabelText(this._MGGraphicPlaceMarkerId);

      return labelText;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 获取标签字体大小
   * @param {type}
   * @return {int}
   */
  async getLabelTextSize() {
    try {
      let labelTextSize = await GPM.getLabelTextSize(
        this._MGGraphicPlaceMarkerId
      );

      return labelTextSize;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 获取地标位置Dot3D的id
   * @param {type}
   * @return {type}
   */
  async getPostion() {
    try {
      let positionId = await GPM.getPostion(this._MGGraphicPlaceMarkerId);

      return positionId;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 设置边界线像素偏移
   * @param {float} offset 偏移像素
   * @return {type}
   */
  async setBorderlineOffset(offset) {
    try {
      let result = await GPM.setBorderlineOffset(
        this._MGGraphicPlaceMarkerId,
        offset
      );

      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 设置是否开启重叠检测
   * @param {boolean} enabled 是否开启重叠检测
   * @return {type}
   */
  async setEnableDecluttering(enabled) {
    try {
      let result = await GPM.setEnableDecluttering(
        this._MGGraphicPlaceMarkerId,
        enabled
      );

      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 设置地标的方向角
   * @param {float} headingAngle 方向角
   * @return {type}
   */
  async setImageHeading(headingAngle) {
    try {
      let result = await GPM.setImageHeading(
        this._MGGraphicPlaceMarkerId,
        headingAngle
      );

      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 设置地标图片位置
   * @param {String} imagePath 图片路径
   * @return {type}
   */
  async setImagePath(imagePath) {
    try {
      let result = await GPM.setImagePath(
        this._MGGraphicPlaceMarkerId,
        imagePath
      );

      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 设置距离中心点像素偏移
   * @param {String} pixelOffsetDotId 中心点像素偏移 (相对于(0,0)像素)dot的id
   * @return {type}
   */
  async setLabelPixelOffset(pixelOffsetDotId) {
    try {
      let result = await GPM.setLabelPixelOffset(
        this._MGGraphicPlaceMarkerId,
        pixelOffsetDotId
      );

      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 设置标签字体大小
   * @param {int} textSize
   * @return {type}
   */
  async setLabelTextSize(textSize) {
    try {
      let result = await GPM.setLabelTextSize(
        this._MGGraphicPlaceMarkerId,
        textSize
      );

      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 设置地标位置
   * @param {String} dot3DId 场景地理坐标 Dot3D 的 id
   * @return {type}
   */
  async setPosition(dot3DId) {
    try {
      let result = await GPM.setPosition(this._MGGraphicPlaceMarkerId, dot3DId);

      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 获取图片的对齐方式的值
   * @param {type}
   * @return {type}
   */
  async getImageAlignment() {
    try {
      let graphicImage3DAlignmentModeValue = await GPM.getImageAlignment(
        this._MGGraphicPlaceMarkerId
      );

      return graphicImage3DAlignmentModeValue;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 获取文本对齐方式的值
   * @param {type}
   * @return {type}
   */
  async getLabelAlignment() {
    try {
      let graphicText3DAlignmentModeValue = await GPM.getLabelAlignment(
        this._MGGraphicPlaceMarkerId
      );

      return graphicText3DAlignmentModeValue;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 设置图片对齐方式
   * @param {int} alignmentmodeValue
   * @return {type}
   */
  async setImageAlignment(alignmentmodeValue) {
    try {
      let result = await GPM.setImageAlignment(
        this._MGGraphicPlaceMarkerId,
        alignmentmodeValue
      );

      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 设置文本对齐方式
   * @param {int} alignmentmodeValue
   * @return {type}
   */
  async setLabelAlignment(alignmentmodeValue) {
    try {
      let result = await GPM.setLabelAlignment(
        this._MGGraphicPlaceMarkerId,
        alignmentmodeValue
      );

      return result;
    } catch (error) {
      console.error(error);
    }
  }
}
