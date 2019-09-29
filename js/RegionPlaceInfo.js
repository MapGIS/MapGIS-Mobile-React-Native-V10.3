/*
 * @Description: In User Settings Edit
 * @Author: xiaoying
 * @Date: 2019-09-03 17:45:37
 * @LastEditTime: 2019-09-04 19:43:06
 * @LastEditors: Please set LastEditors
 */
import { NativeModules } from 'react-native';
let RPI = NativeModules.JSRegionPlaceInfo;

/**
 * @class RegionPlaceInfo
 * @description 区放置样式
 */
export default class RegionPlaceInfo {
  /**
   * 创建一个新的RegionPlaceInfo对象
   *
   * @memberof RegionPlaceInfo
   * @returns {Promise<RegionPlaceInfo>}
   */
  async createObj() {
    try {
      var { RegionPlaceInfoId } = await RPI.createObj();
      var regionPlaceInfo = new RegionPlaceInfo();
      regionPlaceInfo._MGRegionPlaceInfoId = RegionPlaceInfoId;
      return regionPlaceInfo;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取区标注类型
   *
   * @memberof RegionPlaceInfo
   * @returns {int} 区标注类型,例：RegPlaceType.HorizationPlace
   */
  async getType() {
    try {
      let type = await RPI.getType(this._MGRegionPlaceInfoId);
      return type;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置区标注类型
   *
   * @memberof RegionPlaceInfo
   * @param {int} regPlaceType 区标注类型,例：RegPlaceType.HorizationPlace
   * @returns {Promise<Void>}
   */
  async setType(regPlaceType) {
    try {
      await RPI.setType(this._MGRegionPlaceInfoId, regPlaceType);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 当区内部无法标注时，是否尝试水平标注在区的外面
   *
   * @memberof RegionPlaceInfo
   * @returns {boolean}
   */
  async getTryLabelOutside() {
    try {
      let tryLabelOutside = await RPI.getTryLabelOutside(
        this._MGRegionPlaceInfoId
      );
      return tryLabelOutside;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置是否尝试水平标注在区的外面
   *
   * @memberof RegionPlaceInfo
   * @param {boolean} tryLabelOutside 是否尝试水平标注在区的外面
   * @returns {Promise<Void>}
   */
  async setTryLabelOutside(tryLabelOutside) {
    try {
      await RPI.setTryLabelOutside(this._MGRegionPlaceInfoId, tryLabelOutside);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取是否限制小区标注
   *
   * @memberof RegionPlaceInfo
   * @returns {boolean}
   */
  async getLimitLabelSmallRegion() {
    try {
      let limitLabelSmallRegion = await RPI.getLimitLabelSmallRegion(
        this._MGRegionPlaceInfoId
      );
      return limitLabelSmallRegion;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置是否尝试水平标注在区的外面
   *
   * @memberof RegionPlaceInfo
   * @param {boolean} limitLabelSmallRegion 是否限制小区标注
   * @returns {Promise<Void>}
   */
  async setLimitLabelSmallRegion(limitLabelSmallRegion) {
    try {
      await RPI.setLimitLabelSmallRegion(
        this._MGRegionPlaceInfoId,
        limitLabelSmallRegion
      );
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取限制小区标注的最大面积(设备单位 * 设备单位,小于该面积则小区不标注)
   *
   * @memberof RegionPlaceInfo
   * @returns {double}
   */
  async getSmallRegionMaxArea() {
    try {
      let smallRegionMaxArea = await RPI.getSmallRegionMaxArea(
        this._MGRegionPlaceInfoId
      );
      return smallRegionMaxArea;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置限制小区标注的最大面积(设备单位 * 设备单位,小于该面积则小区不标注)
   *
   * @memberof RegionPlaceInfo
   * @param {double} smallRegionMaxArea 是限制小区标注的最大面积
   * @returns {Promise<Void>}
   */
  async setSmallRegionMaxArea(smallRegionMaxArea) {
    try {
      await RPI.setSmallRegionMaxArea(
        this._MGRegionPlaceInfoId,
        smallRegionMaxArea
      );
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取重复类型
   *
   * @memberof RegionPlaceInfo
   * @returns {int} 重复类型，例：DuplicateType.OneLabelPreFeaturePart的值0
   */
  async getDuplicateType() {
    try {
      let duplicateType = await RPI.getDuplicateType(this._MGRegionPlaceInfoId);
      return duplicateType;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置重复类型
   *
   * @memberof RegionPlaceInfo
   * @param {int} duplicateType 重复类型，例：DuplicateType.OneLabelPreFeaturePart
   * @returns {Promise<Void>}
   */
  async setDuplicateType(duplicateType) {
    try {
      await RPI.setDuplicateType(this._MGRegionPlaceInfoId, duplicateType);
    } catch (e) {
      console.error(e);
    }
  }
}
