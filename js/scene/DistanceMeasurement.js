/*
 * @Description: 三维距离量算组件。用于量算三维空间中两个点之间的直接距离、水平距离、垂直距离。
 * @Version: 1.0
 * @Autor: liaoliang
 * @Date: 2020-08-19 22:38:56
 * @LastEditors: liaoliang
 * @LastEditTime: 2020-08-19 22:52:03
 */
import { NativeModules } from 'react-native';

let DM = NativeModules.JSDistanceMeasurement;

export default class DistanceMeasurement {
  /**
   * @description: 构造一个新的 DistanceMeasurement 对象
   * @param {type}
   * @return:
   */
  async createObj() {
    try {
      var { distanceMeasurementId } = await DM.createObj();
      var distanceMeasurement = new DistanceMeasurement();
      distanceMeasurement._MGDistanceMeasurementId = distanceMeasurementId;

      return distanceMeasurement;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 获取直接距离，即起点和终点之间的直线距离
   * @param {type}
   * @return {double} directDistance
   */
  async getDirectDistance() {
    try {
      let directDistance = await DM.getDirectDistance(
        this._MGDistanceMeasurementId
      );

      return directDistance;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 获取算量终点位置Dot3D的id
   * @param {type}
   * @return {type}
   */
  async getEndLocation() {
    try {
      let endLocationId = await DM.getEndLocation(
        this._MGDistanceMeasurementId
      );

      return endLocationId;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 获取水平距离，即将起点和终点投影到地表之后，两点之间的距离。
   * @param {type}
   * @return {double} horizontalDistance
   */
  async getHorizontalDistance() {
    try {
      let horizontalDistance = await DM.getHorizontalDistance(
        this._MGDistanceMeasurementId
      );

      return horizontalDistance;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 获取算量起点位置Dot3D的id
   * @param {type}
   * @return {type}
   */
  async getStartLocation() {
    try {
      let startLocationId = await DM.getStartLocation(
        this._MGDistanceMeasurementId
      );

      return startLocationId;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 获取垂直距离，即起点和终点在高度（z）上的差值。
   * @param {type}
   * @return {double} verticalDistance
   */
  async getVerticalDistance() {
    try {
      let verticalDistance = await DM.getVerticalDistance(
        this._MGDistanceMeasurementId
      );

      return verticalDistance;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 设置算量终点位置，坐标类型为经纬度。
   * @param {String} endLocationId
   * @return {type}
   */
  async setEndLocation(endLocationId) {
    try {
      let result = await DM.setEndLocation(
        this._MGDistanceMeasurementId,
        endLocationId
      );

      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 设置算量起点位置，坐标类型为经纬度。
   * @param {String} startLocationId
   * @return {type}
   */
  async setStartLocation(startLocationId) {
    try {
      let result = await DM.setStartLocation(
        this._MGDistanceMeasurementId,
        startLocationId
      );

      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description:
   * @param {type}
   * @return {type}
   */
  async registerMeasurementChangedListener() {
    try {
      let result = await DM.registerMeasurementChangedListener(
        this._MGDistanceMeasurementId
      );

      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description:
   * @param {type}
   * @return {type}
   */
  async unregisterMeasurementChangedListener() {
    try {
      let result = await DM.unregisterMeasurementChangedListener(
        this._MGDistanceMeasurementId
      );

      return result;
    } catch (error) {
      console.error(error);
    }
  }
}
