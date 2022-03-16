/*
 * @Description: 场景图形基类组件
 * @Version: 1.0
 * @Autor: liaoliang
 * @Date: 2020-08-14 23:20:11
 * @LastEditors: liaoliang
 * @LastEditTime: 2020-08-17 08:41:32
 */

import { NativeModules } from 'react-native';

let G3 = NativeModules.JSGraphic3D;

export default class Graphic3D {
  /**
   * @description: 构造一个新的 Graphic3D 对象
   * @param {type}
   * @return:
   */
  async createObj() {
    try {
      var { graphic3DId } = await G3.createObj();
      var graphic3D = new Graphic3D();
      graphic3D._MGGraphic3DId = graphic3DId;
      return graphic3D;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 获取高程模式的值
   * @param {type}
   * @return {type}
   */
  async getAltitudeMode() {
    try {
      let altitudeModeValue = await G3.getAltitudeMode(this._MGGraphic3DId);

      return altitudeModeValue;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 根据索引获取图形属性名
   * @param {String} index 图形属性的索引，从0开始到属性数目减1
   * @return {type}
   */
  async getAttributeName(index) {
    try {
      let attributeName = await G3.getAttributeName(this._MGGraphic3DId, index);

      return attributeName;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 获取图形属性的数目
   * @param {type}
   * @return {type}
   */
  async getAttributeNum() {
    try {
      let attributeNum = await G3.getAttributeNum(this._MGGraphic3DId);

      return attributeNum;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 根据索引获取图形属性值
   * @param {String} index 图形属性的索引，从0开始到属性数目减1
   * @return {type}
   */
  async getAttributeValue(index) {
    try {
      let attributeValue = await G3.getAttributeValue(
        this._MGGraphic3DId,
        index
      );

      return attributeValue;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 根据属性名称获取图形属性值
   * @param {String} name 图形属性名
   * @return {type}
   */
  async getAttributeValueByName(name) {
    try {
      let attributeValue = await G3.getAttributeValueByName(
        this._MGGraphic3DId,
        name
      );

      return attributeValue;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 获取场景覆盖物矩形外包的ID
   * @param {type}
   * @return {type}
   */
  async getBoundingBox() {
    try {
      let rect3DId = await G3.getBoundingBox(this._MGGraphic3DId);

      return rect3DId;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 获取外包ID
   * @param {type}
   * @return {type}
   */
  async getBoundingRect() {
    try {
      let rectId = await G3.getBoundingRect(this._MGGraphic3DId);

      return rectId;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 获取中心点id
   * @param {type}
   * @return {type}
   */
  async getCenterPoint() {
    try {
      let dotId = await G3.getCenterPoint(this._MGGraphic3DId);

      return dotId;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 获取图形的地理坐标id
   * @param {type}
   * @return {type}
   */
  async getCenterPoint3D() {
    try {
      let dot3DId = await G3.getCenterPoint3D(this._MGGraphic3DId);

      return dot3DId;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 获取图形颜色
   * @param {type}
   * @return {type}
   */
  async getColor() {
    try {
      let color = await G3.getColor(this._MGGraphic3DId);

      return color;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 获取图形类型的值
   * @param {type}
   * @return {type}
   */
  async getGraphicType() {
    try {
      let graphicTypeValue = await G3.getGraphicType(this._MGGraphic3DId);

      return graphicTypeValue;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 获取图形的可见状态
   * @param {type}
   * @return {type}
   */
  async getState() {
    try {
      let state = await G3.getState(this._MGGraphic3DId);

      return state;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 获取点是否为像素单位
   * @param {type}
   * @return {type}
   */
  async isPointByPixel() {
    try {
      let isPointByPixelValue = await G3.isPointByPixel(this._MGGraphic3DId);

      return isPointByPixelValue;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 移除所有属性
   * @param {type}
   * @return {type}
   */
  async removeAllAttributes() {
    try {
      let result = await G3.removeAllAttributes(this._MGGraphic3DId);

      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 移除指定名称的属性
   * @param {String} name 将要移除的属性的名称
   * @return {type}
   */
  async removeAttribute(name) {
    try {
      let result = await G3.removeAttribute(this._MGGraphic3DId, name);

      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 设置高程模式
   * @param {int} altitudeModeValue 高程模式的值
   * @return {int} 成功返回1 ,失败返回0
   */
  async setAltitudeMode(altitudeModeValue) {
    try {
      let result = await G3.setAltitudeMode(
        this._MGGraphic3DId,
        altitudeModeValue
      );

      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 设置图形的属性
   * @param {String} name 属性名称
   * @param {String} value 属性值
   * @return {type}
   */
  async setAttributeValue(name, value) {
    try {
      let result = await G3.setAttributeValue(this._MGGraphic3DId, name, value);

      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 设置图形颜色
   * @param {int} color 将要设置的颜色,可通过android.graphics.Color提供的方法生成.如：int myColor = Color.argb(255, 255, 128, 128);
   * @return {type}
   */
  async setColor(color) {
    try {
      let result = await G3.setColor(this._MGGraphic3DId, color);

      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 设置点是否为像素单位(默认情况下为地图单位)
   * @param {boolean} pixel 点是否为像素单位
   * @return {type}
   */
  async setPointByPixel(pixel) {
    try {
      let result = await G3.setPointByPixel(this._MGGraphic3DId, pixel);

      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 控制图层可见性
   * @param {int} graphicStateValue
   * @return {type}
   */
  async setState(graphicStateValue) {
    try {
      let result = await G3.setState(this._MGGraphic3DId, graphicStateValue);

      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 覆盖物图层转几何对象
   * @param {String} toGeometryGraphic3DId 覆盖物图层id
   * @return {type}
   */
  async toGeometry(toGeometryGraphic3DId) {
    try {
      let geometryId = await G3.toGeometry(
        this._MGGraphic3DId,
        toGeometryGraphic3DId
      );

      return geometryId;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 将几何对象转换为图形对象
   * @param {String} geometryId
   * @return {type}
   */
  async toGraphicsFromGeometry(geometryId) {
    try {
      let graphic3DIdsArray = await G3.toGraphicsFromGeometry(
        this._MGGraphic3DId,
        geometryId
      );

      return graphic3DIdsArray;
    } catch (error) {
      console.error(error);
    }
  }
}
