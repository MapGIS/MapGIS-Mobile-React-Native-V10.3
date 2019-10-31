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
  // /**
  //  * 构造一个新的 QueryBound 对象。
  //  * @memberOf QueryBound
  //  * @returns {Promise.<QueryBound>}
  //  */
  // async createObj() {
  //   try {
  //     var { QueryBoundId } = await QB.createObj();
  //     var queryBound = new QueryBound();
  //     queryBound._MGQueryBoundId = QueryBoundId;
  //     return queryBound;
  //   } catch (e) {
  //     console.error(e);
  //   }
  // }

    /**
   * 构造一个新的 QueryBound 对象。
   * @memberOf QueryBound
   * @param point {Dot}点
   * @returns {Promise.<QueryBound>}
   */
  async createObjByPoint(point)
	{
			try {
        var { QueryBoundId } = await QB.createObjByPoint(point._MGDotId);
        var queryBound = new QueryBound();
        queryBound._MGQueryBoundId = QueryBoundId;
        return queryBound;
      } catch (e) {
        console.error(e);
      }
	}

  /**
   * 构造一个新的 QueryBound 对象。
   * @memberOf QueryBound
   * @param point {Dot}点
   * @param dx  X方向最大范围偏移量
   * @param dy  Y方向最大范围偏移量
   * @returns {Promise.<QueryBound>}
   */
  async createObjByPointAndOff(point,dx,dy)
	{
			try {
        var { QueryBoundId } = await QB.createObjByPointAndOff(point._MGDotId,dx,dy);
        var queryBound = new QueryBound();
        queryBound._MGQueryBoundId = QueryBoundId;
        return queryBound;
      } catch (e) {
        console.error(e);
      }
  }

    /**
   * 构造一个新的 QueryBound 对象。
   * @memberOf QueryBound
   * @param rect {Rect}矩形范围
   * @returns {Promise.<QueryBound>}
   */
  async createObjByRect(rect)
	{
			try {
        var { QueryBoundId } = await QB.createObjByRect(rect._MGRectId);
        var queryBound = new QueryBound();
        queryBound._MGQueryBoundId = QueryBoundId;
        return queryBound;
      } catch (e) {
        console.error(e);
      }
  }

  /**
   * 构造一个新的 QueryBound 对象。
   * @memberOf QueryBound
   * @param points {Dot[]}多点
   * @returns {Promise.<QueryBound>}
   */
  async createObjByPoints(pointArray)
	{
			try {
        var { QueryBoundId } = await QB.createObjByPoints(pointArray);
        var queryBound = new QueryBound();
        queryBound._MGQueryBoundId = QueryBoundId;
        return queryBound;
      } catch (e) {
        console.error(e);
      }
  }

  /**
   * 获取查询范围类型
   * @memberOf QueryBound
   * @returns {Number} 查询范围类型（int类型的Number）
   */
		async getBoundType()
		{
      try {
        return await QB.getBoundType(this._MGQueryBoundId);
      } catch (e) {
        console.error(e);
      }
		}

		/**
		 * 获取查询范围外包点序列
		 * @memberOf QueryBound
		 * @return {Promise.<Array<Dot>>}外包点序列
		 */
		async getBoundPoints()
		{
			try {
        var objArr = [];
        let { dotsArr } = await QB.getBoundPoints(this._MGQueryBoundId);
        for (var i = 0; i < dotsArr.length; i++) {
          var dot = new Dot();
          dot._MGDotId = dotsArr[i];
          objArr.push(dot);
        }
        return objArr;
      } catch (e) {
        console.error(e);
      }
		}
    
    /**
		 * 获取X方向最大范围偏移量
		 * @memberOf QueryBound
		 * @return {Number}X方向最大范围偏移量 （double类型的Number）
		 */
		async getDotOffDx()
		{
			try {
        return await QB.getDotOffDx(this._MGQueryBoundId);
      } catch (e) {
        console.error(e);
      }
		}
    
    /**
		 * 获取Y方向最大范围偏移量
		 * @memberOf QueryBound
		 * @return {Number}Y方向最大范围偏移量 （double类型的Number）
		 */
		async getDotOffDy()
		{
			try {
        return await QB.getDotOffDy(this._MGQueryBoundId);
      } catch (e) {
        console.error(e);
      }
		}

//   /**
//    * 设置矩形查询范围
//    * @memberOf QueryBound
//    * @param rect
//    * @returns {Promise<void>}
//    */
//   async setRect(rect) {
//     try {
//       await QB.setRect(this._MGQueryBoundId, rect._MGRectId);
//     } catch (e) {
//       console.error(e);
//     }
//   }

//   /**
//    * 点查询
//    * @memberOf QueryBound
//    * @param point
//    * @param dx X方向最大范围偏移量
//    * @param dy Y方向最大范围偏移量
//    * @param dy Y方向最大范围偏移量
//    * @returns {Promise<void>}
//    */
//   async setPoint(point, dx, dy) {
//     try {
//       await QB.setPoint(this._MGQueryBoundId, point._MGDotId, dx, dy);
//     } catch (e) {
//       console.error(e);
//     }
//   }

//   /**
//    * 设置一组点（多边形查询）
//    * @memberOf QueryBound
//    * @param pointArray
//    * @returns {Promise<void>}
//    */
//   async setPoints(pointArray) {
//     try {
//       var idArr = [];
//       for (var i = 0; i <= pointArray.length - 1; i++) {
//         var id = pointArray[i]._MGDotId;
//         idArr.push(id);
//       }
//       await QB.setPoints(this._MGQueryBoundId, idArr);
//     } catch (e) {
//       console.error(e);
//     }
//   }
 }
