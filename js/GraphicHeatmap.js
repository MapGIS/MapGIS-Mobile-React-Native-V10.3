/**
 * @content 热力点功能组件
 * @author lidafeng
 */
import { NativeModules } from 'react-native';

let GH = NativeModules.JSGraphicHeatmap;

import HeatmapPoint from './HeatmapPoint.js';
import VisualMap from './VisualMap.js';
import Graphic from './Graphic.js';
import ObjectUtils from './components/ObjectUtils.js';

/**
 * @class GraphicHeatmap
 */
export default class GraphicHeatmap extends Graphic{
  constructor() {
    super();
    Object.defineProperty(this, '_MGGraphicHeatmapId', {
      get: function() {
        return this._MGGraphicId;
      },
      set: function(_MGGraphicHeatmapId) {
        this._MGGraphicId = _MGGraphicHeatmapId;
      },
    });
  }

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
   * @memberOf GraphicHeatmap
   * @param {Array<HeatmapPoint>} pointArray
   * @returns {Promise.<GraphicHeatmap>}
   */
  async setHeatmapPoints(pointArray) {
    try {
      if(this.isValid()){
        await GH.setHeatmapPoints(this._MGGraphicHeatmapId, pointArray);
      } else {
        console.log('GraphicHeatmap is invalid !');
      }
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取热力点。
   * @memberOf GraphicHeatmap
   * @returns {Promise.<Array<HeatmapPoint>>}
   */
  async getHeatmapPoints() {
    try {
      if(this.isValid()){
        let objArr = [];
        let { HeatmapPointArr } = await GH.getHeatmapPoints(
          this._MGGraphicHeatmapId
        );
        for (let i = 0; i < HeatmapPointArr.length; i++) {
          let heatmapPoint = new HeatmapPoint();
          heatmapPoint._MGHeatmapPointId = HeatmapPointArr[i];
          objArr.push(heatmapPoint);
        }
        return objArr;
      } else {
        console.log('GraphicHeatmap is invalid !');
      }
      
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置视觉映射
   * @memberOf GraphicHeatmap
   * @param {VisualMap} visualMap
   * @returns {Promise<void>}
   */
  async setVisualMap(visualMap) {
    try {
      if(this.isValid() && ObjectUtils.isValidObject(visualMap) && visualMap.isValid()){
        await GH.setVisualMap(this._MGGraphicHeatmapId, visualMap._MGVisualMapId);
      } else {
        console.log('GraphicHeatmap or VisualMap is invalid !');
      }
    } catch (e) {
      console.error(e);
    }
  }

  /**
   *  获取视觉映射
   * @memberOf GraphicHeatmap
   * @returns {Promise<VisualMap>}
   */
  async getVisualMap() {
    try {
      if(this.isValid()){
        let {VisualMapId} = await GH.getVisualMap(this._MGGraphicHeatmapId);
        var visualMap = new VisualMap();
        visualMap._MGVisualMapId = VisualMapId;
  
        return visualMap;
      } else {
        console.log('GraphicHeatmap is invalid !');
      }
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
      if(this.isValid()){
        await GH.setPointSize(this._MGGraphicHeatmapId, size);
      } else {
        console.log('GraphicHeatmap is invalid !');
      }
    } catch (e) {
      console.error(e);
    }
  }

  /**
   *  获取热力点大小
   * @memberOf GraphicHeatmap
   * @returns {Promise<Number>}
   */
  async getPointSize() {
    try {
      if(this.isValid()){
        let pointSize = await GH.getPointSize(this._MGGraphicHeatmapId);

        return pointSize;
      } else {
        console.log('GraphicHeatmap is invalid !');
      }
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
      if(this.isValid()){
        await GH.setMinAlpha(this._MGGraphicHeatmapId, minAlpha);
      } else {
        console.log('GraphicHeatmap is invalid !');
      }
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取热力点最小透明度,默认值为0:不透明
   * @memberOf GraphicHeatmap
   * @returns {Promise<Number>}
   */
  async getMinAlpha() {
    try {
      if(this.isValid()){
        let minAlpha = await GH.getMinAlpha(this._MGGraphicHeatmapId);

        return minAlpha;
      } else {
        console.log('GraphicHeatmap is invalid !');
      }
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
      if(this.isValid()){
        await GH.setMaxAlpha(this._MGGraphicHeatmapId, maxAlpha);
      } else {
        console.log('GraphicHeatmap is invalid !');
      }
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取热力点最大透明度,默认值为100:全透明
   * @memberOf GraphicHeatmap
   * @returns {Promise<Number>}
   */
  async getMaxAlpha() {
    try {
      if(this.isValid()){
        let maxAlpha = await GH.getMaxAlpha(this._MGGraphicHeatmapId);
        return maxAlpha;

      } else {
        console.log('GraphicHeatmap is invalid !');
      }
    } catch (e) {
      console.error(e);
    }
  }
}
