/**
 * @content 点对象功能组件
 * @author fjl 2019-6-14 下午2:52:36
 */
import { NativeModules } from "react-native";
let X = NativeModules.JSDot;

/**
 * @class Dot
 */
export default class Dot {
  /**
   * 构造一个新的 Dot 对象。
   * @memberOf Dot
   * @returns {Promise.<Dot>}
   */
  async createObj() {
    try {
      if (
        typeof arguments[0] === "number" &&
        typeof arguments[1] === "number"
      ) {
        var { point2DId } = await X.createObjByXY(arguments[0], arguments[1]);
        var dot = new Dot();
        dot._MGDotId = point2DId;
        return dot;
      } else {
        var { point2DId } = await X.createObj();
        var dot = new Dot();
        dot._MGDotId = point2DId;
        return dot;
      }
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取X坐标
   * @memberOf Dot
   * @returns {Promise<*>}
   */
  async getX() {
    try {
      let x = await X.getX(this._MGDotId);
      return x;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取Y坐标
   * @memberOf Dot
   * @returns {Promise<*>}
   */
  async getY() {
    try {
      let y = await X.getY(this._MGDotId);
      return y;
    } catch (e) {
      console.error(e);
    }
  }
}
