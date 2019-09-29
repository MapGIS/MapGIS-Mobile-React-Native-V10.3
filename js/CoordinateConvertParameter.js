/*
 * @Description: In User Settings Edit
 * @Author: xiaoying
 * @Date: 2019-09-11 11:50:35
 * @LastEditTime: 2019-09-11 12:00:38
 * @LastEditors: Please set LastEditors
 */
import { NativeModules } from 'react-native';
let CCP = NativeModules.JSCoordinateConvertParameter;

/**
 * @class CoordinateConvertParameter
 * @description 坐标转换参数
 */
export default class CoordinateConvertParameter {
  /**
   * 构造一个新的CoordinateConvertParameter对象
   * @memberof CoordinateConvertParameter
   * @returns {Promise<CoordinateConvertParameter>}
   */
  async createObj() {
    try {
      var { CoordinateConvertParameterId } = await CCP.createObj();
      var coordinateConvertParameter = new CoordinateConvertParameter();
      coordinateConvertParameter._MGCoordinateConvertParameterId = CoordinateConvertParameterId;
      return coordinateConvertParameter;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取目标坐标类型
   *
   * @memberof CoordinateConvertParameter
   * @returns {Number} 目标坐标类型（int类型的Number，例：0--CoordinateType.BAIDU_LngLat）
   */
  async getDestCoordinateType() {
    try {
      let destCoordinateType = await CCP.getDestCoordinateType(
        this._MGCoordinateConvertParameterId
      );
      return destCoordinateType;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置转换的目标坐标类型 必设参数
   *
   * @memberof CoordinateConvertParameter
   * @param {Number} destCoordinateType 目标坐标类型（int类型的Number，例：0--CoordinateType.BAIDU_LngLat）
   * @returns {Promise<CoordinateConvertParameter>}
   */
  async setDestCoordinateType(destCoordinateType) {
    try {
      var { CoordinateConvertParameterId } = await CCP.setDestCoordinateType(
        this._MGCoordinateConvertParameterId,
        destCoordinateType
      );
      var coordinateConvertParameter = new CoordinateConvertParameter();
      coordinateConvertParameter._MGCoordinateConvertParameterId = CoordinateConvertParameterId;
      return coordinateConvertParameter;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取源坐标类型
   *
   * @memberof CoordinateConvertParameter
   * @returns {Number} 源坐标类型（int类型的Number，例：0--CoordinateType.BAIDU_LngLat）
   */
  async getSrcCoordinateType() {
    try {
      let srcCoordinateType = await CCP.getSrcCoordinateType(
        this._MGCoordinateConvertParameterId
      );
      return srcCoordinateType;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置转换的源坐标类型 必设参数
   *
   * @memberof CoordinateConvertParameter
   * @param {Number} srcCoordinateType 源坐标类型（int类型的Number，例：0--CoordinateType.BAIDU_LngLat）
   * @returns {Promise<CoordinateConvertParameter>}
   */
  async setSrcCoordinateType(srcCoordinateType) {
    try {
      var { CoordinateConvertParameterId } = await CCP.setSrcCoordinateType(
        this._MGCoordinateConvertParameterId,
        srcCoordinateType
      );
      var coordinateConvertParameter = new CoordinateConvertParameter();
      coordinateConvertParameter._MGCoordinateConvertParameterId = CoordinateConvertParameterId;
      return coordinateConvertParameter;
    } catch (e) {
      console.error(e);
    }
  }
}
