/**
 * @content 经纬度结构功能组件
 * @author  2019-09-25
 */
import { NativeModules } from 'react-native';

let LL = NativeModules.JSLatLng;

/**
 * @class LatLng
 * @description 经纬度
 */
export default class LatLng {
  /**
   * 构造一个新的 LatLng 对象。
   * @memberOf LatLng
   * @returns {Promise.<LatLng>}
   */
  async createObj(longitude, latitude) {
    try {
      var { LatLngId } = await LL.createObj(longitude, latitude);
      var latLng = new LatLng();
      latLng._MGLatLngId = LatLngId;
      return latLng;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取纬度
   * @memberof LatLng
   * @returns {Promise.<double>} 纬度
   */
  async getLatitude() {
    try {
      return await LL.getLatitude(this._MGLatLngId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取经度
   * @memberof LatLng
   * @returns {Promise.<double>} 经度
   */
  async getLongitude() {
    try {
      return await LL.getLongitude(this._MGLatLngId);
    } catch (e) {
      console.error(e);
    }
  }
}
