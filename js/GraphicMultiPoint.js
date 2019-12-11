/**
 * @content 点对象功能组件
 * @author fjl 2019-6-24 下午2:52:36
 */
import { NativeModules } from 'react-native';
import Graphic from './Graphic';
import Dot from './Dot';
import Dots from './Dots';
let GM = NativeModules.JSGraphicMultiPoint;

/**
 * @constructor GraphicMultiPoint
 */
export default class GraphicMultiPoint extends Graphic {
  constructor() {
    super();
    Object.defineProperty(this, '_MGGraphicMultiPointId', {
      get: function() {
        return this._MGGraphicId;
      },
      set: function(_MGGraphicMultiPointId) {
        this._MGGraphicId = _MGGraphicMultiPointId;
      },
    });
  }

  /**
   * 构造一个新的 GraphicMultiPoint 对象。
   * @memberOf GraphicMultiPoint
   * @returns {Promise.<GraphicMultiPoint>}
   */
  async createObj() {
    try {
      var { GraphicMultiPointId } = await GM.createObj();
      var graphicMultiPoint = new GraphicMultiPoint();
      graphicMultiPoint._MGGraphicMultiPointId = GraphicMultiPointId;
      return graphicMultiPoint;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置一组坐标点
   * @memberOf GraphicMultiPoint
   * @param {Array} pointArray dot数组
   * @returns {Promise<void>}
   */
  async setPoints(pointArray) {
    try {
      let json = JSON.stringify(pointArray);

      await GM.setPoints(this._MGGraphicMultiPointId, json);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 通过点序列Dots设置坐标点
   * @memberOf GraphicMultiPoint
   * @param {Dots} dots dots点序列
   * @returns {Promise<void>}
   * @example
       let dotArr = [];
       dotArr.push({x: 114.4, y: 30.4});
       dotArr.push({x: 114.44, y: 30.41});
       dotArr.push({x: 114.5, y: 30.5});

       let dotsModule = new Dots();
       let dots = await dotsModule.createObj();
       await dots.fromObjectArray(dotArr);
       await this.graphicMultiPoint.setPointsByDots(dots);


   */
  async setPointsByDots(dots) {
    try {
      await GM.setPointsByDots(this._MGGraphicMultiPointId, dots._MGDotsId);
    } catch (e) {
      console.error(e);
    }
  }


  /**
   * 获取一组坐标点
   * @memberOf GraphicMultiPoint
   * @returns {Promise<Array>} dot数组
   */
  async getPoints() {
    try {
      let objArr = [];
      let dotsArr = await GM.getPoints(this._MGGraphicMultiPointId);
      for (let i = 0; i < dotsArr.length; i++) {
        let dot = new Dot();
        dot._MGDotId = dotsArr[i];
        objArr.push(dot);
      }
      return objArr;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取坐标点序列Dots
   * 
   * @memberOf GraphicMultiPoint
   * @returns {Promise<Dots>} 点序列Dots
   */
  async getPointsToDots(){
    try {
      let dotsId = await GM.getPointsToDots(this._MGGraphicMultiPointId);
      let dots = null;
      if(dotsId !== null){
        dots = new Dots();
        dots._MGDotsId = dotsId;
      }

      return dots;
    } catch (e) {
      console.error(e);
    }
  }
  /**
   * 获取坐标点数目
   * @memberOf GraphicMultiPoint
   * @returns {Promise<Number>} 坐标点数目
   */
  async getPointCount() {
    try {
      let pointCount = await GM.getPointCount(this._MGGraphicMultiPointId);
      return pointCount;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取指定索引的坐标点
   * @memberOf GraphicMultiPoint
   * @returns {Promise<Dot>}
   */
  async getPoint(index) {
    try {
      let { dotID } = await GM.getPoint(this._MGGraphicMultiPointId, index);
      var dot = new Dot();
      dot._MGDotId = dotID;
      return dot;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   *设置点的大小
   * @memberOf GraphicMultiPoint
   * @param {Number} size
   * @returns {Promise<void>}
   */
  async setPointSize(size) {
    try {
      await GM.setPointSize(this._MGGraphicMultiPointId, size);
    } catch (e) {
      console.error(e);
    }
  }
  /**
   * 获取圆边界线的颜色
   * @memberOf GraphicMultiPoint
   * @returns {Promise<*>}
   */
  async getPointSize() {
    try {
      let pointSize = await GM.getPointSize(this._MGGraphicMultiPointId);
      return pointSize;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 追加一个点
   * @memberOf GraphicMultiPoint
   * @param {Object} point
   * @returns {Promise<void>}
   */
  async appendPoint(point) {
    try {
      await GM.appendPoint(this._MGGraphicMultiPointId, point._MGDotId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 追加一组点
   * @memberOf GraphicMultiPoint
   * @param {Object} pointArr
   * @returns {Promise<void>}
   */
  async appendPoints(pointArr) {
    try {
      await GM.appendPoints(this._MGGraphicMultiPointId, pointArr);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 更新指定索引处的点
   * @memberOf GraphicMultiPoint
   * @param index
   * @param point
   * @returns {Promise<void>}
   */
  async updatePoint(index, point) {
    try {
      await GM.updatePoint(this._MGGraphicMultiPointId, index, point._MGDotId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 移除指定索引的点
   * @memberOf GraphicMultiPoint
   * @param index
   * @returns {Promise<void>}
   */
  async removePoint(index) {
    try {
      await GM.removePoint(this._MGGraphicMultiPointId, index);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 移除所有点
   * @memberOf GraphicMultiPoint
   * @returns {Promise<void>}
   */
  async removeAllPoints() {
    try {
      await GM.removeAllPoints(this._MGGraphicMultiPointId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 在指定索引处插入点
   * @memberOf GraphicMultiPoint
   * @param index
   * @param point
   * @returns {Promise<void>}
   */
  async insertPoint(index, point) {
    try {
      await GM.insertPoint(this._MGGraphicMultiPointId, index, point._MGDotId);
    } catch (e) {
      console.error(e);
    }
  }
}
