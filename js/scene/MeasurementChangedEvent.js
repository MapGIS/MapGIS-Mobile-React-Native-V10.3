/*
 * @Description:
 * @Version: 1.0
 * @Autor: liaoliang
 * @Date: 2020-08-19 22:22:38
 * @LastEditors: liaoliang
 * @LastEditTime: 2020-08-19 22:39:42
 */

import { NativeModules } from 'react-native';

let MCE = NativeModules.JSMeasurementChangedEvent;

export default class MeasurementChangedEvent {
  /**
   * @description: 构造一个新的 MeasurementChangedEvent 对象
   * @param {type}
   * @return:
   */
  async createObj() {
    try {
      var { measurementChangedEventId } = await MCE.createObj();
      var measurementChangedEvent = new MeasurementChangedEvent();
      measurementChangedEvent._MGMeasurementChangedEventId = measurementChangedEventId;

      return measurementChangedEvent;
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
      let directDistance = await MCE.getDirectDistance(
        this._MGMeasurementChangedEventId
      );

      return directDistance;
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
      let horizontalDistance = await MCE.getHorizontalDistance(
        this._MGMeasurementChangedEventId
      );

      return horizontalDistance;
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
      let verticalDistance = await MCE.getVerticalDistance(
        this._MGMeasurementChangedEventId
      );

      return verticalDistance;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description:
   * @param {type}
   * @return {type}
   */
  async getSource() {
    try {
      let distanceMeasurementId = await MCE.getSource(
        this._MGMeasurementChangedEventId
      );

      return distanceMeasurementId;
    } catch (error) {
      console.error(error);
    }
  }
}
