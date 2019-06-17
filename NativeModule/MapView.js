/**
 * @content 地图视图功能组件
 * @author fjl 2019-6-14 下午2:52:36
 */
import { NativeModules, Platform } from 'react-native';
let MV = NativeModules.JSMapView;
import Dot from './Dot.js';

/**
 * @class MapView
 * @description 地图显示控件容器类。
 */
export default class JSMapView {


  /**
   * 获取地图控件。
   * @memberOf MapView
   * @returns {Promise.<MapControl>}
   */
  async getCenter() {
    try {
      var { point2DId, x, y } = await MV.getMapCenter(this._SMMapViewId);
      var point2D = new Dot();
      point2D._SMDotId = point2DId;
      point2D.x = x;
      point2D.y = y;

      // debugger;
      return point2D;
    } catch (e) {
      console.error(e);
    }
  }


  async setCenter(point2D) {
    try {
      await MV.setMapCenter(this._SMMapViewId, point2D._SMDotId);
    } catch (e) {
      console.error(e);
    }
  }

  async loadFromFile(strMapPath) {
    try {
      await MV.loadFromFile(this._SMMapViewId, strMapPath);
    } catch (e) {
      console.error(e);
    }
  }
}
