/**
 * @content 要素查询空间范围功能组件
 * @author fjl 2019-6-25下午2:52:36
 */
import { NativeModules } from 'react-native';

let QB = NativeModules.JSQueryBound;

/**
 * @class QueryBound
 */
export default class QueryBound {
  /**
   * 构造一个新的 QueryBound 对象。
   * @memberOf QueryBound
   * @returns {Promise.<QueryBound>}
   */
  async createObj() {
    try {
      var { QueryBoundId } = await QB.createObj();
      var queryBound = new QueryBound();
      queryBound._MGQueryBoundId = QueryBoundId;
      return queryBound;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置矩形查询范围
   * @memberOf QueryBound
   * @param rect
   * @returns {Promise<void>}
   */
  async setRect(rect) {
    try {
      await QB.setRect(this._MGQueryBoundId, rect._MGRectId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 点查询
   * @memberOf QueryBound
   * @param point
   * @param dx X方向最大范围偏移量
   * @param dy Y方向最大范围偏移量
   * @param dy Y方向最大范围偏移量
   * @returns {Promise<void>}
   */
  async setPoint(point, dx, dy) {
    try {
      await QB.setPoint(this._MGQueryBoundId, point._MGDotId, dx, dy);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置一组点（多边形查询）
   * @memberOf QueryBound
   * @param pointArray
   * @returns {Promise<void>}
   */
  async setPoints(pointArray) {
    try {
      var idArr = [];
      for (var i = 0; i <= pointArray.length - 1; i++) {
        var id = pointArray[i]._MGDotId;
        idArr.push(id);
      }
      await QB.setPoints(this._MGQueryBoundId, idArr);
    } catch (e) {
      console.error(e);
    }
  }
}
