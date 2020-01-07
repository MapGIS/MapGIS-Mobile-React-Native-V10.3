/**
 * @content android视图点对象功能组件
 * @author fjl 2019-6-17 下午2:52:36
 */
import { NativeModules } from 'react-native';
let X = NativeModules.JSPointF;

/**
 * @class PointF
 */
export default class PointF {
  /**
   * 构造一个新的 PointF 对象。
   * @memberOf PointF
   * @returns {Promise.<PointF>}
   */
  async createObj() {
    try {
      if (
        typeof arguments[0] === 'number' &&
        typeof arguments[1] === 'number'
      ) {
        let { PointFId } = await X.createObjByXY(arguments[0], arguments[1]);
        let point2D = new PointF();
        point2D._MGPointFId = PointFId;
        return point2D;
      } else {
        let { PointFId } = await X.createObj();
        let point2D = new PointF();
        point2D._MGPointFId = PointFId;
        return point2D;
      }
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取X坐标
   * @memberOf PointF
   * @returns {Promise<*>}
   */
  async getX() {
    try {
      let x = await X.getX(this._MGPointFId);
      return x;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取Y坐标
   * @memberOf PointF
   * @returns {Promise<*>}
   */
  async getY() {
    try {
      let y = await X.getY(this._MGPointFId);

      return y;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 判断PointF对象是否有效
   * 
   * @memberof PointF
   * @returns {Boolean} true：有效；false：无效
   */
   isValid(){
    try {
      if(this._MGPointFId === undefined || this._MGPointFId === null){
        return false;
      }else{
        return true;
      }
    } catch (e) {
      console.error(e);
    }
  }
}
