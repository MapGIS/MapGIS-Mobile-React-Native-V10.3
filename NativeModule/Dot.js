/**
 * @content 点对象功能组件
 * @author fjl 2019-6-14 下午2:52:36
 */
import { NativeModules } from 'react-native';
let X = NativeModules.JSDot;

export default class Dot {
  /**
   * 构造一个新的 Dot 对象。
   * @memberOf Dot
   * @returns {Promise.<Dot>}
   */
  async createObj() {
    try {
      if (typeof arguments[0] === 'number' && typeof arguments[1] === 'number') {
        var { DotId } = await X.createObjByXY(arguments[0], arguments[1]);
        var point2D = new Dot();
        point2D._SMDotId = point2DId;
        return point2D;
      } else {
        var { point2DId } = await X.createObj();
        var point2D = new Dot();
        point2D._SMDotId = point2DId;
        return point2D;
      }
    } catch (e) {
      console.error(e);
    }
  }
  
  
  async getX() {
    try {
      let x = await X.getX(this._SMDotId);
      return x;
    } catch (e) {
      console.error(e);
    }
  }
  
  async getY() {
    try {
      let y = await X.getY(this._SMDotId);
        console.log('Dot y: ' + y);
      return y;
    } catch (e) {
      console.error(e);
    }
  }
}
