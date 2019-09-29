/*
 * @Description: In User Settings Edit
 * @Author: xiaoying
 * @Date: 2019-08-28 14:40:14
 * @LastEditTime: 2019-08-31 16:44:36
 * @LastEditors: Please set LastEditors
 */
import { NativeModules } from 'react-native';
let MS = NativeModules.JSMaps;
import Map from './Map.js';

/**
 * @class Maps
 * @description 地图列表类
 */
export default class Maps {

    /**
   * 构造一个新的 Maps 对象
   *
   * @memberof Maps
   * @returns {Promise<Maps>}
   */
  async createObj() {
    try {
      var { MapsId } = await MS.createObj();
      var maps = new Maps();
      maps._MGMapsId = MapsId;
      return maps;
    } catch (e) {
      console.error(e);
      alert(e);
    }
  }

  /**
   * 获取地图数量
   *
   * @memberof Maps
   * @returns {int} 地图数量
   */
  async getCount() {
    try {
      let count = await MS.getCount(this._MGMapsId);
      return count;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 添加地图
   *
   * @memberof Maps
   * @param {Object} map 地图对象
   * @returns {int} index 添加地图后的索引
   */
  async append(map) {
    try {
      let index = await MS.append(this._MGMapsId, map._MGMapId);
      return index;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 插入地图
   *
   * @memberof Maps
   * @param {int} index 地图索引：
   * @param {Object} map  地图对象
   * @returns {int} 插入后的ID
   */
  async insert(index, map) {
    try {
      let id = await MS.insert(this._MGMapsId, index, map._MGMapId);
      return id;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 移除地图
   *
   * @memberof Maps
   * @param {int} index 地图索引：
   * @returns {boolean} 成功/失败
   */
  async remove(index) {
    try {
      let remove = await MS.remove(this._MGMapsId, index);
      return remove;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 移除所有地图
   *
   * @memberof Maps
   * @returns {boolean} true/false：成功/失败
   */
  async removeAll() {
    try {
      let removeAll = await MS.removeAll(this._MGMapsId);
      return removeAll;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 得到索引
   *
   * @memberof Maps
   * @param {Object} map 地图对象
   * @returns {int} 成功返回地图的索引
   */
  async indexOf(map) {
    try {
      let index = await MS.indexOf(this._MGMapsId, map._MGMapId);
      return index;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 得到指定索引的地图
   *
   * @memberof Maps
   * @param {int} index 地图索引
   * @returns Map 成功返回地图
   */
  async getMap(index) {
    try {
      var { MapId } = await MS.getMap(this._MGMapsId, index);
      var map = null;
      if (MapId != null) {
        map = new Map();
        map._MGMapId = MapId;
      }
      return map;
    } catch (e) {
      console.error(e);
    }
  }

