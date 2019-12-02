/**
 * @content 热力点功能组件
 * @author lidafeng
 */
import { NativeModules } from 'react-native';

let GH = NativeModules.JSGraphicHeatmap;

import HeatmapPoint from './HeatmapPoint.js';
import VisualMap from './VisualMap.js';

/**
 * @class GraphicHeatmap
 */
export default class GraphicHeatmap {
  /**
   * 构造一个新的 GraphicHeatmap 对象。
   * @memberOf GraphicHeatmap
   * @returns {Promise.<GraphicHeatmap>}
   */
  async createObj() {
    try {
      var { GraphicHeatmapId } = await GH.createObj();
      var graphicHeatmap = new GraphicHeatmap();
      graphicHeatmap._MGGraphicHeatmapId = GraphicHeatmapId;
      return graphicHeatmap;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置热力点。
   * @memberOf {Array} HeatmapPoints
   * @returns {Promise.<GraphicHeatmap>}
   */
  async setHeatmapPoints(pointArray) {
    try {
      await GH.setHeatmapPoints(this._MGGraphicHeatmapId, pointArray);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置热力点。
   * @memberOf GraphicHeatmap
   * @returns {Promise.<HeatmapPoint>}
   */
  async getHeatmapPoints() {
    try {
      var objArr = [];
      let { HeatmapPointArr } = await GH.getHeatmapPoints(
        this._MGGraphicHeatmapId
      );
      for (var i = 0; i < HeatmapPointArr.length; i++) {
        var heatmapPoint = new HeatmapPoint();
        heatmapPoint._MGHeatmapPointId = HeatmapPointArr[i];
        objArr.push(heatmapPoint);
      }
      return objArr;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置视觉映射
   * @memberOf GraphicHeatmap
   * @param {Object} visualMap
   * @returns {Promise<void>}
   */
  async setVisualMap(visualMap) {
    try {
      await GH.setVisualMap(this._MGGraphicHeatmapId, visualMap._MGVisualMapId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   *  获取视觉映射
   * @memberOf GraphicHeatmap
   * @returns {Promise<*>}
   */
  async getVisualMap() {
    try {
      let VisualMapId = await GH.getVisualMap(this._MGGraphicHeatmapId);
      var visualMap = new VisualMap();
      visualMap._MGVisualMapId = VisualMapId;

      return visualMap;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置热力点大小
   * @memberOf GraphicHeatmap
   * @param {Number} size
   * @returns {Promise<void>}
   */
  async setPointSize(size) {
    try {
      await GH.setPointSize(this._MGGraphicHeatmapId, size);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   *  获取热力点大小
   * @memberOf GraphicHeatmap
   * @returns {Promise<*>}
   */
  async getPointSize() {
    try {
      let pointSize = await GH.getPointSize(this._MGGraphicHeatmapId);
      return pointSize;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置热力点透明度的最小值,默认为0:不透明
   * @memberOf GraphicHeatmap
   * @param {Number} minAlpha
   * @returns {Promise<void>}
   */
  async setMinAlpha(minAlpha) {
    try {
      await GH.setMinAlpha(this._MGGraphicHeatmapId, minAlpha);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取热力点最小透明度,默认值为0:不透明
   * @memberOf GraphicHeatmap
   * @returns {Promise<*>}
   */
  async getMinAlpha() {
    try {
      let minAlpha = await GH.getMinAlpha(this._MGGraphicHeatmapId);
      return minAlpha;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置热力点透明度的最大值,默认为100:全透明
   * @memberOf GraphicHeatmap
   * @param {Number} maxAlpha
   * @returns {Promise<void>}
   */
  async setMaxAlpha(maxAlpha) {
    try {
      await GH.setMaxAlpha(this._MGGraphicHeatmapId, maxAlpha);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取热力点最大透明度,默认值为100:全透明
   * @memberOf GraphicHeatmap
   * @returns {Promise<*>}
   */
  async getMaxAlpha() {
    try {
      let maxAlpha = await GH.getMaxAlpha(this._MGGraphicHeatmapId);
      return maxAlpha;
    } catch (e) {
      console.error(e);
    }
  }
}
