/*
 * @Description: In User Settings Edit
 * @Author: xiaoying
 * @Date: 2019-09-02 16:44:15
 * @LastEditTime: 2019-09-04 19:42:49
 * @LastEditors: Please set LastEditors
 */
import { NativeModules } from 'react-native';
let LPI = NativeModules.JSLinePlaceInfo;

/**
 * @class LinePlaceInfo
 * @description 线放置样式
 */
export default class LinePlaceInfo {
  /**
   * 构造一个新LinePlaceInfo对象
   *
   * @memberof LinePlaceInfo
   * @returns {Promise<LinePlaceInfo>} 线标注对象
   */
  async createObj() {
    try {
      var { LinePlaceInfoId } = await LPI.createObj();
      var linePlaceInfo = new LinePlaceInfo();
      linePlaceInfo._MGLinePlaceInfoId = LinePlaceInfoId;
      return linePlaceInfo;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取线标注类型
   *
   * @memberof LinePlaceInfo
   * @returns {int} 线标注类型 例：LinePlaceType.HorizationPlace
   */
  async getType() {
    try {
      let type = await LPI.getType(this._MGLinePlaceInfoId);
      return type;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置线标注类型
   *
   * @memberof LinePlaceInfo
   * @param {int} linePlaceType 线标注类型 例：LinePlaceType.HorizationPlace
   * @returns {Promise<Void>}
   */
  async setType(linePlaceType) {
    try {
      await LPI.setType(this._MGLinePlaceInfoId, linePlaceType);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取标注与线的偏移距离(设备单位)
   *
   * @memberof LinePlaceInfo
   * @returns {double}
   */
  async getOffset() {
    try {
      let offset = await LPI.getOffset(this._MGLinePlaceInfoId);
      return offset;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置标注与线的偏移距离（设备单位）
   *
   * @memberof LinePlaceInfo
   * @param {double} offset  标注与线的偏移距离
   * @returns {Promise<Void>}
   */
  async setOffset(offset) {
    try {
      await LPI.setOffset(this._MGLinePlaceInfoId, offset);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   *  获取偏移约束类型
   *
   * @memberof LinePlaceInfo
   * @returns {int} 偏移约束类型 例：LineRestrictType.OnLine
   */
  async getRestrictType() {
    try {
      let restrictType = await LPI.getRestrictType(this._MGLinePlaceInfoId);
      return restrictType;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置偏移约束类型
   *
   * @memberof LinePlaceInfo
   * @param {int} restrictType 偏移约束类型 例：LineRestrictType.OnLine
   * @returns {Promise<Void>}
   */
  async setRestrictType(restrictType) {
    try {
      await LPI.setRestrictType(this._MGLinePlaceInfoId, restrictType);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取分布类型
   *
   * @memberof LinePlaceInfo
   * @returns {int} 分布类型 例：LineSpreadType.AutoSpread
   */
  async getSpreadType() {
    try {
      let spreadType = await LPI.getSpreadType(this._MGLinePlaceInfoId);
      return spreadType;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置分布类型
   *
   * @memberof LinePlaceInfo
   * @param {int} spreadType 分布类型，例：LineSpreadType.AutoSpread
   * @returns {Promise<Void>}
   */
  async setSpreadType(spreadType) {
    try {
      await LPI.setSpreadType(this._MGLinePlaceInfoId, spreadType);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取重复类型
   *
   * @memberof LinePlaceInfo
   * @returns {int} 重复类型  例：LineRepeatType.AutoRepeat
   */
  async getRepeatType() {
    try {
      let repeatType = await LPI.getRepeatType(this._MGLinePlaceInfoId);
      return repeatType;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置重复类型
   *
   * @memberof LinePlaceInfo
   * @param {int} repeatType 重复类型  例：LineRepeatType.AutoRepeat
   * @returns {Promise<Void>}
   */
  async setRepeatType(repeatType) {
    try {
      await LPI.setRepeatType(this._MGLinePlaceInfoId, repeatType);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取步长
   *
   * @memberof LinePlaceInfo
   * @returns {double}
   */
  async getInterval() {
    try {
      let interval = await LPI.getInterval(this._MGLinePlaceInfoId);
      return interval;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置步长
   *
   * @memberof LinePlaceInfo
   * @param {double} interval 步长
   * @returns {Promise<Void>}
   */
  async setInterval(interval) {
    try {
      await LPI.setInterval(this._MGLinePlaceInfoId, interval);
    } catch (e) {
      console.error(e);
    }
  }
}
