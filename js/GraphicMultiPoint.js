/**
 * @content 点对象功能组件
 * @author fjl 2019-6-24 下午2:52:36
 */
import { NativeModules } from 'react-native';
import Graphic from "./Graphic";
import Dot from "./Dot";
let GM = NativeModules.JSGraphicMultiPoint;

/**
 * @constructor GraphicMultiPoint
 */
export default class GraphicMultiPoint extends Graphic{

  constructor(){
    super();
    Object.defineProperty(this,"_MGGraphicMultiPointId",{
      get:function () {
        return this._MGGraphicId
      },
      set:function (_MGGraphicMultiPointId) {
        this._MGGraphicId = _MGGraphicMultiPointId;
      }
    })
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
   * @param {Object} point
   * @param {Number} radius
   * @returns {Promise<void>}
   */
  async setPoints(pointArray) {
    try {
      await GM.setPoints(this._MGGraphicMultiPointId, pointArray);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取是否符号化显示
   * @memberOf GraphicMultiPoint
   * @returns {Promise<*>}
   */
  async getPoints() {
    try {
      var objArr = [];
      let {dotsArr} = await GM.getPoints(this._MGGraphicMultiPointId);
      for(var i = 0; i < dotsArr.length;i++)
      {
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
   * 获取圆边界线的宽度
   * @memberOf GraphicMultiPoint
   * @returns {Promise<*>}
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
   *获取指定索引的坐标点
   * @memberOf GraphicMultiPoint
   * @returns {Promise<Dot>}
   */
  async getPoint(index) {
    try {
      let {dotID} = await GM.getPoint(this._MGGraphicMultiPointId,index);
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
  async updatePoint(index,point) {
    try {
      await GM.updatePoint(this._MGGraphicMultiPointId, index,point._MGDotId);
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
  async insertPoint(index,point) {
    try {
      await GM.insertPoint(this._MGGraphicMultiPointId, index,point._MGDotId);
    } catch (e) {
      console.error(e);
    }
  }

}
