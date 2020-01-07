/**
 * @content 二维坐标点序列功能操作功能组件
 * @author  2019-09-09
 */
import { NativeModules } from 'react-native';
import Dot from './Dot.js';

let DS = NativeModules.JSDots;

/**
 * @class Dots
 */
export default class Dots {
  /**
   * 构造一个新的 Dots 对象。
   * @memberOf Dots
   * @returns {Promise.<Dots>}
   */
  async createObj() {
    try {
      var { DotsId } = await DS.createObj();
      var dots = new Dots();
      dots._MGDotsId = DotsId;
      return dots;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取X坐标
   * @memberOf Dots
   * @returns {Promise} 折线点数
   */
  async size() {
    try {
      return await DS.size(this._MGDotsId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 添加一个点
   * @memberOf Dots
   * @param dot 待添加的点对象
   * @returns {Promise} 新添加点的索引，小于0失败
   */
  async append(dot) {
    try {
      return await DS.append(this._MGDotsId, dot._MGDotId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 将另一个Dots的点添加到尾端
   * @memberOf Dots
   * @param dots 待添加的点序列对象
   * @returns {Promise} 大于0成功，否则失败
   */
  async appendDots(dots) {
    try {
      return await DS.appendDots(this._MGDotsId, dots._MGDotsId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 删除索引处的点
   * @memberOf Dots
   * @param index 待删除的点索引
   * @returns {Promise} 大于0成功，否则失败
   */
  async remove(index) {
    try {
      return await DS.remove(this._MGDotsId, index);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 清空
   * @memberOf Dots
   * @returns {Promise} 大于0成功，否则失败
   */
  async clear() {
    try {
      return await DS.clear(this._MGDotsId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 返回索引处的点
   * @memberOf Dots
   * @param index 待查找的索引号
   * @returns {Promise<Dot>} 索引处的点
   */
  async get(index) {
    try {
      let { point2DId } = await DS.get(this._MGDotsId, index);
      var dot = new Dot();
      dot._MGDotId = point2DId;
      return dot;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 通过包含多个对象的数组，给Dots设置点
   * 
   * @memberOf Dots
   * @param {Array} objArray 包含一系列对象的数组，对象形式{x: Number, y: Number}
   * @returns {Number} 大于0成功，否则失败
   * @example 
    let array = [];
    array.push({x: 114.63, y: 30.40});
    array.push({x: 114.33, y: 30.24});
    array.push({x: 114.22, y: 30.22});
    array.push({x: 114.15, y: 30.66});
    let dotsModule = new Dots();
    let dots = await dotsModule.createObj();
    await dots.fromObjectArray(array);
   * 
   */
  async fromObjectArray(objArray){
    try {
      let json = JSON.stringify(objArray);
      return await DS.fromObjectArray(this._MGDotsId, json);

    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 返回Dots的一系列点坐标构成的对象数组
   * 
   * @memberOf Dots
   * @returns {Array} 返回包含由点坐标构成的对象的数组，对象形式{x: Number， y: Number}
   */
  async toObjectArray(){
    try {
      let dotArray = await DS.toObjectArray(this._MGDotsId);
      return dotArray;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 判断Dots对象是否有效
   * 
   * @memberof Dots
   * @returns {Boolean} true：有效；false：无效 
   */
  isValid(){
    try {
      if(this._MGDotsId === undefined || this._MGDotsId === null){
        return false;
      }else{
        return true;
      }
    } catch (e) {
      console.error(e);
    }
  }
}
