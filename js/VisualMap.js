/**
 * @content 视觉映射功能组件
 * @author
 */
import { NativeModules } from 'react-native';

let VM = NativeModules.JSVisualMap;
/**
 * @class VisualMap
 */
export default class VisualMap {

  /**
   * 构造一个新的 VisualMap 对象。
   * @memberOf VisualMap
   * @param minValue 视觉映射最小值,默认值为0
	 * @param maxValue 视觉映射最大值,默认值为1
	 * @param {Array} colors颜色数组 string类型的Array
   * @returns {Promise.<VisualMap>}
   */
  async createObjByParam(minValue,maxValue,colors) {
    try {
      var { VisualMapId } = await VM.createObjByParam(minValue,maxValue,colors);
      var visualMap = new VisualMap();
      visualMap._MGVisualMapId = VisualMapId;
      return visualMap;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 构造一个新的 VisualMap 对象。
   * @memberOf VisualMap
   * @returns {Promise.<VisualMap>}
   */
  async createObj() {
    try {
      var { VisualMapId } = await VM.createObj();
      var visualMap = new VisualMap();
      visualMap._MGVisualMapId = VisualMapId;
      return visualMap;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   *  获取视觉映射的最小值,默认值为0
   *  @memberOf VisualMap
   * @returns {Promise<double>}
   */
  async getMinValue() {
    try {
      let value = await VM.getMinValue(this._MGVisualMapId);
      return value;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置视觉映射的最小值,默认值为0
   * 在不设置minValue的情况下,minValue等于0,当热力点的权重值设置小于0的时候,minValue依然为0.
   * @memberOf VisualMap
   * @param minValue
   * @returns {Promise<void>}
   */
  async setMinValue(minValue) {
    try {
      await VM.setMinValue(this._MGVisualMapId, minValue);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   *  获取视觉映射的最大值,默认值为1
   *  @memberOf VisualMap
   * @returns {Promise<double>}
   */
  async getMaxValue() {
    try {
      let value = await VM.getMaxValue(this._MGVisualMapId);
      return value;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置视觉映射的最大值,默认值为1
   * 在不设置maxValue的情况下,maxValue等于1;当热力点的权重值设置大于1的时候,maxValue依然为1
   * @memberOf VisualMap
   * @param maxValue
   * @returns {Promise<void>}
   */
  async setMaxValue(maxValue) {
    try {
      await VM.setMaxValue(this._MGVisualMapId, maxValue);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   *  获取热力点的颜色组
   *  @memberOf VisualMap
   * @returns {Promise<Array>} string类型的Array
   */
  async getColors() {
    try {
      let ColorArr = await VM.getColors(this._MGVisualMapId);
      return ColorArr;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置热力点的颜色组
   * @memberOf VisualMap
   * @param {Array} colors string类型的Array
   * @returns {Promise<void>}
   */
  async setColors(colors) {
    try {
      await VM.setColors(this._MGVisualMapId, colors);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 判断VisualMap对象是否有效
   * 
   * @memberof VisualMap
   * @returns {Boolean} true：有效；false：无效
   */
  isValid(){
    try {
      if(this._MGVisualMapId === undefined || this._MGVisualMapId === null){
        return false;
      }else{
        return true;
      }
    } catch (e) {
      console.error(e);
    }

  }
}
