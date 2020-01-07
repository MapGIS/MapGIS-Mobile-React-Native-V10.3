/**
 * @content 矩形对象功能组件
 * @author fjl 2019-6-18 下午2:52:36
 */
import { NativeModules } from 'react-native';
let X = NativeModules.JSRect;

/**
 * @class Rect
 */
export default class Rect {
  /**
   * 构造一个新的 Rect 对象。
   * @memberOf Rect
   * @returns {Promise.<Rect>}
   */
  async createObj() {
    try {
      if (
        typeof arguments[0] === 'number' &&
        typeof arguments[1] === 'number' &&
        typeof arguments[2] === 'number' &&
        typeof arguments[3] === 'number'
      ) {
        var { RectId } = await X.createObjByXY(
          arguments[0],
          arguments[1],
          arguments[2],
          arguments[3]
        );
        var rect = new Rect();
        rect._MGRectId = RectId;
        return rect;
      } else {
        var { RectId } = await X.createObj();
        var rect = new Rect();
        rect._MGRectId = RectId;
        return rect;
      }
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取x最小值
   * @memberOf Rect
   * @returns {Promise<*>}
   */
  async getXMin() {
    try {
      let xMin = await X.getXMin(this._MGRectId);
      return xMin;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取y最小值
   * @memberOf Rect
   * @returns {Promise<*>}
   */
  async getYMin() {
    try {
      let yMin = await X.getYMin(this._MGRectId);
      return yMin;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取x最大值
   * @memberOf Rect
   * @returns {Promise<*>}
   */
  async getXMax() {
    try {
      let xMax = await X.getXMax(this._MGRectId);
      return xMax;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取y最大值
   * @memberOf Rect
   * @returns {Promise<*>}
   */
  async getYMax() {
    try {
      let yMax = await X.getYMax(this._MGRectId);
      return yMax;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 判断Rect对象是否有效或是否有用
   * 
   * @memberof Rect
   * @static
   * @param {Rect} rect
   * @returns {boolean} true：有效；false：无效
   */
  static isValid(rect){
    try {
      if(rect === undefined || rect === null || rect._MGRectId === undefined || rect._MGRectId === null){
        return false;
      } else {
        return true;
      }
    } catch (e) {
      console.error(e);
    }
  }
}
