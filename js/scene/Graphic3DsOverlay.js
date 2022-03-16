/*
 * @Description: 场景覆盖物
 * @Version: 1.0
 * @Autor: liaoliang
 * @Date: 2020-08-14 23:57:47
 * @LastEditors: liaoliang
 * @LastEditTime: 2020-08-17 08:07:02
 */

import { NativeModules } from 'react-native';

let G3O = NativeModules.JSGraphic3DsOverlay;

export default class Graphic3DsOverlay {
  /**
   * @description: 构造一个新的 Graphic3DsOverlay 对象
   * @param {type}
   * @return:
   */
  async createObj() {
    try {
      var { graphic3DsOverlayId } = await G3O.createObj();
      var graphic3DsOverlay = new Graphic3DsOverlay();
      graphic3DsOverlay._MGGraphic3DsOverlayId = graphic3DsOverlayId;
      return graphic3DsOverlay;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 添加一个图形
   * @param {String} graphic3DId 图形id
   * @return {type}
   */
  async addGraphic(graphic3DId) {
    try {
      let result = await G3O.addGraphic(
        this._MGGraphic3DsOverlayId,
        graphic3DId
      );

      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description:
   * @param {String} graphicHandle
   * @return {type}
   */
  async createGraphic(graphicHandle) {
    try {
      let graphic3DId = await G3O.createGraphic(
        this._MGGraphic3DsOverlayId,
        graphicHandle
      );

      return graphic3DId;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 返回所有图形的id
   * @param {type}
   * @return {WritableArray}
   */
  async getAllGraphics3D() {
    try {
      let graphic3DIds = await G3O.getAllGraphics3D(
        this._MGGraphic3DsOverlayId
      );

      return graphic3DIds;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 获取指定索引的图形id
   * @param {int} index
   * @return {type}
   */
  async getGraphic(index) {
    try {
      let graphic3DId = await G3O.getGraphic(
        this._MGGraphic3DsOverlayId,
        index
      );

      return graphic3DId;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 返回所有图形的数目
   * @param {type}
   * @return {type}
   */
  async getGraphicCount() {
    try {
      let graphicCount = await G3O.getGraphicCount(this._MGGraphic3DsOverlayId);

      return graphicCount;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 获取指定属性的图形的id
   * @param {String} name
   * @param {String} value
   * @return {WritableArray}
   */
  async getGraphicsByAttribute(name, value) {
    try {
      let graphic3DIds = await G3O.getGraphicsByAttribute(
        this._MGGraphic3DsOverlayId,
        name,
        value
      );

      return graphic3DIds;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 获取层名称
   * @param {type}
   * @return {type}
   */
  async getName() {
    try {
      let name = await G3O.getName(this._MGGraphic3DsOverlayId);

      return name;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 获取图形层的可见状态,返回层的状态 STATE_VISIBLE STATE_UNVISIBLE
   * @param {type}
   * @return {type}
   */
  async getState() {
    try {
      let state = await G3O.getState(this._MGGraphic3DsOverlayId);

      return state;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 获取指定图形的索引
   * @param {String} graphic3DId 指定图形的id
   * @return {type}
   */
  async indexOf(graphic3DId) {
    try {
      let index = await G3O.indexOf(this._MGGraphic3DsOverlayId, graphic3DId);

      return index;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 插入一个图形
   * @param {int} index 图形索引
   * @param {String} graphic3DId 图形id
   * @return {type}
   */
  async insertGraphic(index, graphic3DId) {
    try {
      let result = await G3O.insertGraphic(
        this._MGGraphic3DsOverlayId,
        index,
        graphic3DId
      );

      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 移动一个图形
   * @param {type}
   * @return {type}
   */
  async moveGraphic(fromIndex, toIndex) {
    try {
      let result = await G3O.moveGraphic(
        this._MGGraphic3DsOverlayId,
        fromIndex,
        toIndex
      );

      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 删除一组图形
   * @param {type}
   * @return {type}
   */
  async removeAllGraphics() {
    try {
      let result = await G3O.removeAllGraphics(this._MGGraphic3DsOverlayId);

      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 移除一个图形
   * @param {String} graphic3DId
   * @return {type}
   */
  async removeGraphic(graphic3DId) {
    try {
      let result = await G3O.removeGraphic(
        this._MGGraphic3DsOverlayId,
        graphic3DId
      );

      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 移除指定索引的图形
   * @param {int} index
   * @return {type}
   */
  async removeGraphicByIndex(index) {
    try {
      let result = await G3O.removeGraphicByIndex(
        this._MGGraphic3DsOverlayId,
        index
      );

      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 删除指定属性的图形
   * @param {string} name
   * @param {string} value
   * @return {type}
   */
  async removeGraphicByAttribute(name, value) {
    try {
      let result = await G3O.removeGraphicByAttribute(
        this._MGGraphic3DsOverlayId,
        name,
        value
      );

      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 设置层名称
   * @param {String} name
   * @return {type}
   */
  async setName(name) {
    try {
      let result = await G3O.setName(this._MGGraphic3DsOverlayId, name);

      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 设置图形层的可见状态
   * @param {int} state
   * @return {type}
   */
  async setState(state) {
    try {
      let result = await G3O.setState(this._MGGraphic3DsOverlayId, state);

      return result;
    } catch (error) {
      console.error(error);
    }
  }
}
