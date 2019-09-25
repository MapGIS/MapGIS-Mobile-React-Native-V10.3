/**
 * @content 覆盖物对象功能组件
 * @author fjl 2019-6-21 下午2:52:36
 */
import { NativeModules } from "react-native";

let X = NativeModules.JSGraphicsOverlays;
import Graphic from "./Graphic.js";
import GraphicsOverlay from "./GraphicsOverlay.js";

/**
 * @class GraphicsOverlays
 */
export default class GraphicsOverlays {
  /**
   * 构造一个新的 GraphicsOverlays 对象。
   * @memberOf GraphicsOverlays
   * @returns {Promise.<GraphicsOverlays>}
   */
  async createObj() {
    try {
      var { GraphicsOverlaysId } = await X.createObj();
      var graphicsOverlays = new GraphicsOverlays();
      graphicsOverlays._MGGraphicsOverlaysId = GraphicsOverlaysId;
      return graphicsOverlays;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 添加图形覆盖物
   * @memberOf GraphicsOverlays
   * @param graphicsOverlay
   * @returns {Promise<void>}
   */
  async add(graphicsOverlay) {
    try {
      await X.add(
        this._MGGraphicsOverlaysId,
        graphicsOverlay._MGGraphicsOverlayId
      );
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取图形覆盖物的数目
   * @memberOf GraphicsOverlays
   * @returns {Promise<*>}
   */
  async getCount() {
    try {
      let name = await X.getCount(this._MGGraphicsOverlaysId);

      return name;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取图形覆盖物的索引
   * @memberOf GraphicsOverlays
   * @param graphicsOverlay
   * @returns {Promise<*|NavigationPreloadState>}
   */
  async indexOf(graphicsOverlay) {
    try {
      let index = await X.indexOf(
        this._MGGraphicsOverlaysId,
        graphicsOverlay._MGGraphicsOverlayId
      );
      return index;
    } catch (e) {
      console.error(e);
    }
  }


   /**
   * 获取图形覆盖物的索引
   * @memberOf GraphicsOverlays
   * @param {String} graphicLayerName
   * @returns {Promise<*|NavigationPreloadState>}
   */
  async indexOfByName(graphicLayerName) {
    try {
      let index = await X.indexOfByName(
        this._MGGraphicsOverlaysId,
        graphicLayerName
      );
      return index;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取图形覆盖物
   * @memberOf GraphicsOverlays
   * @returns {Promise<*>}
   */
  async getGraphicsOverlay(index) {
    try {
      let { GraphicsOverlayID } = await X.getGraphicsOverlay(
        this._MGGraphicsOverlaysId,
        index
      );
      var graphicsOverlay = new GraphicsOverlay();
      graphicsOverlay._MGGraphicsOverlayId = GraphicsOverlayID;

      return graphicsOverlay;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 返回所有图形
   * @memberOf GraphicsOverlays
   */
  async getAllGraphicsOverlays() {
    try {
      var objArr = [];
      var { graphicArray } = await X.getAllGraphicsOverlays(
        this._MGGraphicsOverlaysId
      );

      for (var i = 0; i < graphicArray.length - 1; i++) {
        var graphicsOverlay = new GraphicsOverlay();
        graphicsOverlay._MGGraphicsOverlayId = graphicArray[i];
        objArr.push(graphicsOverlay);
      }
      return objArr;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 插入图形覆盖物
   * @memberOf GraphicsOverlays
   * @param graphicsOverlay 图形覆盖物
   * @returns {Promise<*|NavigationPreloadState>}
   */
  async insert(index, graphicsOverlay) {
    try {
      let result = await X.insert(
        this._MGGraphicsOverlaysId,
        index,
        graphicsOverlay._MGGraphicsOverlayId
      );

      return result;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 移动图形覆盖物
   * @memberOf GraphicsOverlays
   * @param fromIndex
   * @param toIndex
   * @returns {Promise<*>}
   */
  async move(fromIndex, toIndex) {
    try {
      await X.move(this._MGGraphicsOverlaysId, fromIndex, toIndex);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 移除图形覆盖物
   * @memberOf GraphicsOverlays
   * @param index
   * @returns {Promise<void>}
   */
  async removeByIndex(index) {
    try {
      await X.remove(this._MGGraphicsOverlaysId, index);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 移除图形覆盖物
   * @memberOf GraphicsOverlays
   * @param graphicsOverlay
   * @returns {Promise<void>}
   */
  async remove(graphicsOverlay) {
    try {
      await X.move(
        this._MGGraphicsOverlaysId,
        graphicsOverlay._MGGraphicsOverlayId
      );
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 移除所有图形覆盖物
   * @memberOf GraphicsOverlays
   * @param index
   * @returns {Promise<void>}
   */
  async removeAll() {
    try {
      await X.removeAll(this._MGGraphicsOverlaysId);
    } catch (e) {
      console.error(e);
    }
  }
}
