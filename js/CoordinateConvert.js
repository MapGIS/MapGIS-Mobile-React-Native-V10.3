/*
 * @Description: In User Settings Edit
 * @Author: xiaoying
 * @Date: 2019-09-18 10:27:06
 * @LastEditTime: 2019-09-18 15:10:51
 * @LastEditors: Please set LastEditors
 */
import {NativeModules} from "react-native";
import CoordinateConvertParameter from "./CoordinateConvertParameter";
import Dot from "./Dot";
let CC = NativeModules.JSCoordinateConvert;

/**
 * @class CoordinateConvert
 * @description 坐标转换类
 */
export default class CoordinateConvert{
      
    /**
     * 构造一个新的CoordinateConvert对象
     * 
     * @memberof CoordinateConvert
     * @returns {CoordinateConvert}
     */
    async createObj(){
        try {
            var {CoordinateConvertId} = await CC.createObj();
            var coordinateConvert = new CoordinateConvert();
            coordinateConvert._MGCoordinateConvertId = CoordinateConvertId;
            return coordinateConvert;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 设置坐标转换参数
     * 
     * @memberof CoordinateConvert
     * @param {Object} coordinateConvertParameter 坐标转换参数 （CoordinateConvertParameter类型的Object）
     * @returns {CoordinateConvert} 
     */
    async setConvertParams(coordinateConvertParameter){
        try {
            
            var {CoordinateConvertId} = await CC.setConvertParams(this._MGCoordinateConvertId, coordinateConvertParameter._MGCoordinateConvertParameterId);
            var coordinateConvert = new CoordinateConvert();
            coordinateConvert._MGCoordinateConvertId = CoordinateConvertId;
            return coordinateConvert;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 获取坐标转换参数
     * 
     * @memberof CoordinateConvert
     * @returns {Promise<CoordinateConvert>} 
     */
    async getConvertParams(){
        try {
            var {CoordinateConvertParameterId} = await CC.getConvertParams(this._MGCoordinateConvertId);
            var coordinateConvertParameter = new CoordinateConvertParameter();
            coordinateConvertParameter._MGCoordinateConvertParameterId = CoordinateConvertParameterId;
            return coordinateConvertParameter;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 坐标转换
     * 
     * @memberof CoordinateConvert
     * @param {Object} dot 转换前的点 （Dot类型的Object）
     * @returns {Promise<Dot>} 转换后的点
     */
    async convert(dot){
        try {
            var {point2DId} = await CC.convert(this._MGCoordinateConvertId, dot._MGDotId);
            let convertDot = null;
            if(point2DId != null){
                convertDot = new Dot();
                convertDot._MGDotId = point2DId;
            }
            return convertDot;
        } catch (e) {
            console.error(e);
        }
    }

    /**
    * 异步坐标转换
    *
    * @memberof CoordinateConvert
    * @param {Object} dot 转换前的点 （Dot类型的Object）
    * @returns {Promise<Dot|String>} 成功--返回转换后的点，失败--返回String
    */
   async convertAsync(dot){
       try {
          let {isSuccess, result} = await CC.convertAsync(this._MGCoordinateConvertId, dot._MGDotId);
          if(isSuccess){
             let dot = new Dot();
             dot._MGDotId = result;
             return dot;
          }else{
               return result;
          }
       } catch (e) {
           console.error(e);
       }
   }

}