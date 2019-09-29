/*
 * @Description: In User Settings Edit
 * @Author:xiaoying
 * @Date: 2019-08-26 13:44:56
 * @LastEditTime: 2019-08-31 13:32:51
 * @LastEditors: Please set LastEditors
 */
import { NativeModules } from 'react-native';
import Map from './Map.js';
let LE = NativeModules.JSLayerEnum;

/**
 * @class LayerEnum
 * @description android图层枚举功能组件
 */
export default class LayerEnum {
  /**
   * 构造一个新的LayerEnum对象
   * @memberof LayerEnum
   * @returns {Promise.<LayerEnum>}
   */
  async createObj() {
    try {
      var { LayerEnumId } = await LE.createObj();
      var layerEnum = new LayerEnum();
      layerEnum._MGLayerEnumId = LayerEnumId;
      return layerEnum;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 初始化图层列表
   * @memberof LayerEnum
   * @param {Array} layers 图层列表
   * @returns {boolean}
   */
  async init(layers) {
    try {
      let result = await LE.init(this._MGLayerEnumId, layers);
      return result;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 移动至第一个
   * @memberof LayerEnum
   * @returns {boolean}
   */
  async moveToFirst() {
    try {
      let result = await LE.moveToFirst(this._MGLayerEnumId);
      return result;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 移动至最后
   * @memberof LayerEnum
   * @returns {boolean}
   */
  async moveToLast() {
    try {
      let result = await LE.moveToLast(this._MGLayerEnumId);
      return result;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取下一个MapLayer
   * @memberof LayerEnum
   * @returns {Promise<MapLayer>}
   */
  async next() {
    try {
      let mapLayer;
      var { MapLayerId } = await LE.next(this._MGLayerEnumId);
      mapLayer = await Map.creatMapLayerInstanceByID(MapLayerId);
      return mapLayer;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取前一个MapLayer
   * @memberof LayerEnum
   * @returns {Promise<MapLayer>}
   */
  async prev() {
    try {
      let mapLayer;
      var { MapLayerId } = await LE.prev(this._MGLayerEnumId);
      mapLayer = await Map.creatMapLayerInstanceByID(MapLayerId);
      return mapLayer;
    } catch (e) {
      console.error(e);
    }
  }
}
