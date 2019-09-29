/**
 * @content 地图服务图层信息功能组件
 * @author  2019-09-25
 */
import { NativeModules } from 'react-native';

let MSLI = NativeModules.JSMapServiceLayerInfo;

/**
 * @class MapServiceLayerInfo
 * @description 地图服务图层信息
 */
export default class MapServiceLayerInfo {
  /**
   * 构造一个新的 MapServiceLayerInfo 对象。
   * @memberOf MapServiceLayerInfo
   * @returns {Promise.<MapServiceLayerInfo>}
   */
  async createObj(strName, layerId, dMinScale, dMaxScale, strStyle) {
    try {
      var { MapServiceLayerInfoId } = await MSLI.createObj(
        strName,
        layerId,
        dMinScale,
        dMaxScale,
        strStyle
      );
      var mapServiceLayerInfo = new MapServiceLayerInfo();
      mapServiceLayerInfo._MGMapServiceLayerInfoId = MapServiceLayerInfoId;
      return mapServiceLayerInfo;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取地图服务图层ID
   * @memberOf MapServiceLayerInfo
   * @return {Promise.<int>} 地图服务图层ID
   */
  async getLayerId() {
    try {
      return await MSLI.getLayerId(this._MGMapServiceLayerInfoId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置地图服务图层ID
   * @memberOf MapServiceLayerInfo
   * @param {int} layerId 地图服务图层ID
   * @return {Promise.<void>}
   */
  async setLayerId(layerId) {
    try {
      await MSLI.setLayerId(this._MGMapServiceLayerInfoId, layerId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取地图服务图层名称
   * @memberOf MapServiceLayerInfo
   * @return {Promise.<String>} 地图服务图层名称
   */
  async getName() {
    try {
      return await MSLI.getName(this._MGMapServiceLayerInfoId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取地图服务图层名称
   * @memberOf MapServiceLayerInfo
   * @param {String} StrName 地图服务图层名称
   * @return {Promise.<void>}
   */
  async setName(StrName) {
    try {
      await MSLI.setName(this._MGMapServiceLayerInfoId, StrName);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取地图服务图层最大缩放比
   * @memberOf MapServiceLayerInfo
   * @return {Promise.<double>} 地图服务图层最大缩放比
   */
  async getMaxScale() {
    try {
      return await MSLI.getMaxScale(this._MGMapServiceLayerInfoId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置地图服务图层最大缩放比
   * @memberOf MapServiceLayerInfo
   * @param {double} maxScale 地图服务图层最大缩放比
   * @return {Promise.<void>}
   */
  async setMaxScale(maxScale) {
    try {
      await MSLI.setMaxScale(this._MGMapServiceLayerInfoId, maxScale);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取地图服务图层最小缩放比
   * @memberOf MapServiceLayerInfo
   * @return {Promise.<double>} 地图服务图层最小缩放比
   */
  async getMinScale() {
    try {
      return await MSLI.getMinScale(this._MGMapServiceLayerInfoId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置地图服务图层最小缩放比
   * @memberOf MapServiceLayerInfo
   * @param {double} minScale 地图服务图层最小缩放比
   * @return {Promise.<void>}
   */
  async setMinScale(minScale) {
    try {
      await MSLI.setMinScale(this._MGMapServiceLayerInfoId, minScale);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取地图服务图层样式
   * @memberOf MapServiceLayerInfo
   * @return {Promise.<String>} 地图服务图层样式
   */
  async getStyle() {
    try {
      return await MSLI.getStyle(this._MGMapServiceLayerInfoId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置地图服务图层样式
   * @memberOf MapServiceLayerInfo
   * @param {String} strStyle 地图服务图层样式
   * @return {Promise.<void>}
   */
  async setStyle(strStyle) {
    try {
      await MSLI.setStyle(this._MGMapServiceLayerInfoId, strStyle);
    } catch (e) {
      console.error(e);
    }
  }
}
