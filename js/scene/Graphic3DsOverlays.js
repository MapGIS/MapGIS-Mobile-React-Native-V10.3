/*
 * @Description: 图形覆盖物层列表组件
 * @Version: 1.0
 * @Autor: liaoliang
 * @Date: 2020-08-16 08:05:59
 * @LastEditors: liaoliang
 * @LastEditTime: 2020-08-17 08:30:01
 */

import { NativeModules } from 'react-native';

let G3OS = NativeModules.JSGraphic3DsOverlays;

export default class Graphic3DsOverlays {
  /**
   * @description: 构造一个新的 Graphic3DsOverlays 对象
   * @param {type}
   * @return:
   */
  async createObj() {
    try {
      var { graphic3DsOverlaysId } = await G3OS.createObj();
      var graphic3DsOverlays = new Graphic3DsOverlays();
      graphic3DsOverlays._MGGraphic3DsOverlaysId = graphic3DsOverlaysId;
      return graphic3DsOverlays;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 添加一个覆盖物图层
   * @param {String} graphic3DsOverlayId 覆盖物图层id
   * @return {type}
   */
  async add(graphic3DsOverlayId) {
    try {
      let result = await G3OS.add(
        this._MGGraphic3DsOverlaysId,
        graphic3DsOverlayId
      );
      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 获取图层覆盖物id列表
   * @param {type}
   * @return {WritableArray}
   */
  async getAllGraphicsOverlays() {
    try {
      let graphic3DsOverlayIds = await G3OS.getAllGraphicsOverlays(
        this._MGGraphic3DsOverlaysId
      );
      return graphic3DsOverlayIds;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 获取覆盖物图层的个数
   * @param {type}
   * @return {type}
   */
  async getCount() {
    try {
      let countNum = await G3OS.getCount(this._MGGraphic3DsOverlaysId);
      return countNum;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 获取覆盖物图形id
   * @param {int} index 覆盖物图形索引
   * @return {type}
   */
  async getGraphicsOverlay(index) {
    try {
      let graphic3DsOverlayId = await G3OS.getGraphicsOverlay(
        this._MGGraphic3DsOverlaysId,
        index
      );
      return graphic3DsOverlayId;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 覆盖物图层的索引
   * @param {String} graphic3DsOverlayId
   * @return {type}
   */
  async indexOf(graphic3DsOverlayId) {
    try {
      let index = await G3OS.indexOf(
        this._MGGraphic3DsOverlaysId,
        graphic3DsOverlayId
      );
      return index;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 通过名称获取覆盖物图层的索引
   * @param {String} graphicLayerName
   * @return {type}
   */
  async indexOfByName(graphicLayerName) {
    try {
      let index = await G3OS.indexOfByName(
        this._MGGraphic3DsOverlaysId,
        graphicLayerName
      );
      return index;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 插入一个覆盖物图层
   * @param {int} index 图层索引
   * @param {String} graphic3DsOverlayId 覆盖物图层id
   * @return {type}
   */
  async insert(index, graphic3DsOverlayId) {
    try {
      let result = await G3OS.insert(
        this._MGGraphic3DsOverlaysId,
        index,
        graphic3DsOverlayId
      );
      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 移除覆盖物图层
   * @param {String} graphic3DsOverlayId
   * @return {type}
   */
  async remove(graphic3DsOverlayId) {
    try {
      let result = await G3OS.remove(
        this._MGGraphic3DsOverlaysId,
        graphic3DsOverlayId
      );

      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 移动覆盖物图层
   * @param {int} fromIndex
   * @param {int} toIndex
   * @return {type}
   */
  async move(fromIndex, toIndex) {
    try {
      let result = await G3OS.move(
        this._MGGraphic3DsOverlaysId,
        fromIndex,
        toIndex
      );

      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 通过索引移除覆盖物图层
   * @param {int} index 覆盖物图层列表索引
   * @return {type}
   */
  async removeByIndex(index) {
    try {
      let result = await G3OS.removeByIndex(
        this._MGGraphic3DsOverlaysId,
        index
      );

      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 移除所有覆盖物图层
   * @param {type}
   * @return {type}
   */
  async removeAll() {
    try {
      let result = await G3OS.removeAll(this._MGGraphic3DsOverlaysId);

      return result;
    } catch (error) {
      console.error(error);
    }
  }
}
