/**
 * @content 地球椭球参数功能组件
 * @author  lidafeng
 */
import { NativeModules } from 'react-native';

let EP = NativeModules.JSElpParam;

/**
 * @class ElpParam
 * @description 地球椭球参数
 */
export default class ElpParam {

    /**
   * 构造一个新的 ElpParam 对象。
   * @memberOf ElpParam
   * @returns {Promise.<ElpParam>}
   */
  async createObj() {
    try {
      let { ElpParamId } = await EP.createObj();
      let elpParam = new ElpParam();
      elpParam._MGElpParamId = ElpParamId;
      return elpParam;
    } catch (e) {
      console.error(e);
    }
  }


  /**
   * 通过成员变量的名称设置值 <br> 
   * 成员变量的名称 --- 注释: <br>
   *   'a' --- 地球椭球长轴，double <br>
   *   'b' --- 地球椭球短轴，double <br>
   *   'af' --- 地球椭球扁率，double <br>
   *   'r' --- 等面积球体半径，double <br>
   *   'name' --- 地球椭球体名称，String <br>
   * 
   * @memberOf ElpParam
   * @param {String} key 成员变量的名称
   * @param {String| Number} value 成员变量的值
   * @returns {Promise.<void>} 
   * @example  
        let eleParam = new ElpParam();
        let eleParamObj = await eleParam.createObj();
        await eleParamObj.set('name', '王五');
        await eleParamObj.set('a', 20.4);
        

   */
  async set(key, value){
      try {
        let obj = {[key]: value};
        await EP.set(this._MGElpParamId, key, obj);
      } catch (e) {
          console.error(e);
      }
  }

  /**
   * 通过成员变量的名称获取值 <br>
   * 成员变量的名称包括: <br>
   *   'a' --- 地球椭球长轴 <br>
   *   'b' --- 地球椭球短轴 <br>
   *   'af' --- 地球椭球扁率 <br>
   *   'r' --- 等面积球体半径 <br>
   *   'name' --- 地球椭球体名称 <br>
   * 
   * @memberOf ElpParam
   * @param {String} key 成员变量的名称
   * @returns {String|Number} 成员变量值
   */
  async get(key){
      try {
          let {value} = await EP.get(this._MGElpParamId, key);
          return value;
      } catch (e) {
          console.error(e);
      }
  }

  /**
   * 设置所有成员变量值，字符串中的键请与示例的键保持一致
   * 
   * @memberOf ElpParam
   * @param {String} stringValue 键值对格式字符串
   * @returns {Promise.<Void>}
   * @example 
        // 设置全部变量
        let obj = { a: 5.0, b: 7.0, af: 9.0, r: 10.0, name: '张三' } 
        
        // JSON对象设置全部变量
        // let obj = {"a": 2.0, "b": 3.0, "af": 4.0, "r": 6.0, "name": "李四"};
        
        // 字符串
        let stringValue = JSON.stringify(obj);
        let eleParam = new ElpParam();
        let eleParamObj = await eleParam.createObj();
        await eleParamObj.fromString(stringValue);
   

   */
    async fromString(stringValue){
        try {
            if(stringValue === undefined || stringValue === null || stringValue.length === 0){
                return;
            }
            let objValue = JSON.parse(stringValue);
            await EP.fromString(this._MGElpParamId, objValue);
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 获取所有的成员变量名称和值
     * @memberOf ElpParam
     * @returns {String} json字符串
     */
    async toString(){
        try {
            let stringValue = await EP.toString(this._MGElpParamId);
            return stringValue;
        } catch (e) {
            console.error(e);
        }
    }

}
