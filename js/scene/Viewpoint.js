/*
 * @Description:
 * @Version: 1.0
 * @Autor: liaoliang
 * @Date: 2020-07-27 18:13:08
 * @LastEditors: liaoliang
 * @LastEditTime: 2020-07-27 18:43:44
 */

import { NativeModules } from 'react-native';

let VP = NativeModules.JSViewpoint;

export default class Viewpoint {
  /**
   * @Description: 构造一个新的Viewpoint对象
   * @param {type}
   * @return:
   */
  async createObj() {
    try {
      var { viewpointId } = await VP.createObj();
      var viewpoint = new Viewpoint();
      viewpoint._MGViewpointId = viewpointId;
      return viewpoint;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 获取相机的焦点,返回焦点Dot3D的id
   * @param {type}
   * @return:
   */
  async getFocalPoint() {
    try {
      let focalPointId = await VP.getFocalPoint(this._MGViewpointId);

      return focalPointId;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 获取相机的航向角，单位为度，顺时针为正
   * @param {type}
   * @return:
   */
  async getHeadingDeg() {
    try {
      let headingDeg = await VP.getHeadingDeg(this._MGViewpointId);

      return headingDeg;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 获取相机的俯仰角，范围（-90 ~ -10）单位为度
   * @param {type}
   * @return:
   */
  async getPitchDeg() {
    try {
      let pitchDeg = await VP.getPitchDeg(this._MGViewpointId);

      return pitchDeg;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 获取相机到相机焦点的距离
   * @param {type}
   * @return:
   */
  async getRange() {
    try {
      let range = await VP.getRange(this._MGViewpointId);

      return range;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 设置相机的焦点
   * @param {String} focalPointId Dot3D的id
   * @return:
   */
  async setFocalPoint(focalPointId) {
    try {
      let result = await VP.setFocalPoint(this._MGViewpointId, focalPointId);

      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 设置相机的俯仰角，范围（-90 ~ -10）单位为度
   * @param {double} pitchDeg
   * @return:
   */
  async setPitchDeg(pitchDeg) {
    try {
      let result = await VP.setPitchDeg(this._MGViewpointId, pitchDeg);

      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 设置相机的航向角，单位为度，顺时针为正
   * @param {double} headingDeg
   * @return:
   */
  async setHeadingDeg(headingDeg) {
    try {
      let result = await VP.setHeadingDeg(this._MGViewpointId, headingDeg);

      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 设置相机到相机焦点的距离
   * @param {double} range
   * @return:
   */
  async setRange(range) {
    try {
      let result = await VP.setRange(this._MGViewpointId, range);

      return result;
    } catch (error) {
      console.error(error);
    }
  }
}
