/**
 * @content 椭球坐标系变换参数功能组件
 * @author lidafeng
 */
import { NativeModules } from 'react-native';

let ETP = NativeModules.JSElpTransParam;
/**
 * @class ElpTransParam
 * @description 椭球坐标系变换参数
 */
export default class ElpTransParam {
 /**
   * 构造一个新的 ElpTransParam 对象。
   * @memberOf ElpTransParam
   * @returns {Promise.<ElpTransParam>}
   */
  async createObj() {
    try {
      let { ElpTransParamId } = await ETP.createObj();
      let elpTransParam = new ElpTransParam();
      elpTransParam._MGElpTransParamId = ElpTransParamId;
      return elpTransParam;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 通过成员变量的名称设置值 <br> 
   * 成员变量的名称 --- 注释: <br>
   *   'name'  --- 转换名称，String <br>
   *   'inCord' --- 源坐标系椭球体编号（从1开始），int <br>
   *   'inUnit' --- 输入数据单位，int <br>
   *   'outCord' --- 目的坐标系椭球体编号（从1开始），int <br>
   *   'outUnit' --- 输出数据单位，int <br>
   *   'type' --- 转换类型（0/1：三参数直角平移/七参数），int <br>
   *   'dx' --- （三参数/七参数）x方向的平移值（单位：m），double <br>
   *   'dy' --- （三参数/七参数）y方向的平移值（单位：m），double <br>
   *   'dz' --- （三参数/七参数）z方向的平移值（单位：m），double <br>
   *   'wx' --- （七参数）绕x轴的旋转角（单位：弧度），double <br>
   *   'wy' --- （七参数）绕y轴的旋转角（单位：弧度），double <br>
   *   'wz' --- （七参数）绕z轴的旋转角（单位：弧度），double <br>
   *   'dm' --- 七参数尺度比例因子，double <br>
   * 
   * @memberOf ElpTransParam
   * @param {String} key 成员变量的名称
   * @param {String| Number} value 成员变量的值
   * @returns {Promise.<void>} 
   * @example 
        let elpTransParam = new ElpTransParam();
        let elpTransParamObj = await elpTransParam.createObj();

        await elpTransParamObj.set('name', '王五');
        await elpTransParamObj.set('inCord', 1);
        await elpTransParamObj.set('dx', 12.9);


   */
  async set(key, value){
      try {
          let obj = {[key]: value};
          await ETP.set(this._MGElpTransParamId, key, obj);
      } catch (e) {
          console.error(e);
      }
  }

  /**
   * 通过成员变量的名称获取值 <br>
   * 成员变量的名称包括: <br>
   *   'name'  --- 转换名称 <br>
   *   'inCord' --- 源坐标系椭球体编号（从1开始） <br>
   *   'inUnit' --- 输入数据单位 <br>
   *   'outCord' --- 目的坐标系椭球体编号（从1开始） <br>
   *   'outUnit' --- 输出数据单位 <br>
   *   'type' --- 转换类型（0/1：三参数直角平移/七参数）<br>
   *   'dx' --- （三参数/七参数）x方向的平移值（单位：m） <br>
   *   'dy' --- （三参数/七参数）y方向的平移值（单位：m） <br>
   *   'dz' --- （三参数/七参数）z方向的平移值（单位：m）<br>
   *   'wx' --- （七参数）绕x轴的旋转角（单位：弧度）<br>
   *   'wy' --- （七参数）绕y轴的旋转角（单位：弧度） <br>
   *   'wz' --- （七参数）绕z轴的旋转角（单位：弧度） <br>
   *   'dm' --- 七参数尺度比例因子 <br>
   * 
   * @memberOf ElpTransParam
   * @param {String} key 成员变量的名称
   * @returns {String|Number} 成员变量值
   */
  async get(key){
      try {
          let {value} = await ETP.get(this._MGElpTransParamId, key);
          return value;
      } catch (e) {
        console.error(e);
      }
  }

  /**
   * 获取所有的成员变量名称和值
   * @memberOf ElpTransParam
   * @returns {String} json字符串
   */
  async toString(){
      try {
          let variable = await ETP.toString(this._MGElpTransParamId);
          return variable;
      } catch (e) {
          console.error(e);
      }
  }

  /**
   * 设置所有成员变量值，字符串中的键请与示例的键保持一致
   * 
   * @memberOf ElpTransParam
   * @param {String} stringValue  键值对形式的字符串
   * @returns {Promise.<Void>}
   * @example 
        // 设置全部变量
        let obj = {name: '张三', inCord: 1, inUnit: 5, outCord: 1, outUnit: 7,  type: 0,
         dx: 8.0, dy: 9.0, dz: 10.0, wx: 11.0, wy: 12.0, wz: 1.2, dm: 1.0 };

        // JSON对象设置全部变量
        // let obj = {"name": "李四", "inCord": 1, "inUnit": 5, "outCord": 1, "outUnit": 7,  "type": 0,
        // "dx": 8.0, "dy": 9.0, "dz": 10.0, "wx": 11.0, "wy": 12.0, "wz": 1.2, "dm": 1.0 };

        // 将对象转换成字符串
        let stringValue = JSON.stringify(obj);

        let elpTransParam = new ElpTransParam();
        let elpTransParamObj = await elpTransParam.createObj();
        await elpTransParamObj.fromString(stringValue);


   */
  async fromString(stringValue){
      try {
        if(stringValue === undefined || stringValue === null || stringValue.length === 0){
            return;
        }
        let objValue = JSON.parse(stringValue);
        await ETP.fromString(this._MGElpTransParamId, objValue);
      } catch (e) {
          console.error(e);
      }
  }
}
