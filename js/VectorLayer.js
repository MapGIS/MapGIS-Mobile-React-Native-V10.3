/*
 * @Description: In User Settings Edit
 * @Author: fjl
 * @Date: 2019-09-06 16:27:38
 * @LastEditTime: 2019-09-19 15:00:25
 * @LastEditors: Please set LastEditors
 */
/**
 * @content android视图点对象功能组件
 * @author fjl 2019-6-24 下午2:52:36
 */
import { NativeModules } from "react-native";
import MapLayer from "./MapLayer";
import LinInfo from "./LinInfo.js";
import Fields from "./Fields.js";
let VL = NativeModules.JSVectorLayer;

/**
 * @class VectorLayer
 */
export default class VectorLayer extends MapLayer {
  constructor() {
    super();
    Object.defineProperty(this, "_MGVectorLayerId", {
      get: function() {
        return this._MGMapLayerId;
      },
      set: function(_MGVectorLayerId) {
        this._MGMapLayerId = _MGVectorLayerId;
      }
    });
  }

  /**
   * 通过int类型的VectorLayreType构造一个新的 VectorLayer 对象。
   * @memberOf VectorLayer
   * @returns {Promise.<VectorLayer>}
   */
  async createObj() {
    try {

      var { VectorLayerId } = await VL.createObj(arguments[0]);
          var graphic = new VectorLayer();
          graphic._MGVectorLayerId = VectorLayerId;
          return graphic;

    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取符号比
   * 
   * @memberOf VectorLayer
   * @returns {Number} 符号比 -- double类型
   * 
   */
  async getSymbolScale(){
    try {
      let symbolScale = await VL.getSymbolScale(this._MGVectorLayerId);
      return symbolScale;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置符号比
   * 
   * @memberOf VectorLayer
   * @param {Number} symbolScale 符号比 -- double类型
   * @returns {Promise<Void>}
   */
  async setSymbolScale(symbolScale){
    try {
      await VL.setSymbolScale(this._MGVectorLayerId, symbolScale);
    } catch (e) {
      console.error(e);
    }
  }

   /**
    * 获取系统库
    * 
    * @memberOf VectorLayer
    * @returns {String} 系统库 -- UUID转换后的String
   */
  async getSystemLib(){
    try {
      let systemLib = await VL.getSystemLib(this._MGVectorLayerId);
      return systemLib;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置系统库
   * 
   * @memberOf VectorLayer
   * @param {String} lib 系统库 -- UUID转换后的String
   * @returns {Promise<Void>}
   */
  async setSystemLib(lib){
    try {
      await VL.setSystemLib(this._MGVectorLayerId, lib);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取是否符号化显示
   * @memberOf VectorLayer
   * @returns {Promise<*>}
   */
  async isSymbolShow() {
    try {
      let isSymbolShow = await VL.isSymbolShow(this._MGVectorLayerId);
      return isSymbolShow;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置符号化显示
   * @memberOf VectorLayer
   * @param symbolShow
   * @returns {Promise<void>}
   */
  async setSymbolShow(symbolShow) {
    try {
      await VL.setSymbolShow(this._MGVectorLayerId, symbolShow);
    } catch (e) {
      console.error(e);
    }
  }

   /**
    * 是否跟随缩放
    * 
    * @memberOf VectorLayer
    * @returns {boolean}
   */
  async isFollowZoom(){
    try {
      let followZoom = await VL.isFollowZoom(this._MGVectorLayerId);
      return followZoom;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置是否跟随缩放
   * @memberOf VectorLayer
   * @param {boolean} followZoom 跟随缩放
   * @returns {Promise<Void>}
   * 
   */
  async setFollowZoom(followZoom){
    try {
      await VL.setFollowZoom(this._MGVectorLayerId, followZoom);
    } catch (e) {
      console.error(e);
    }
  }

   /**
    * 获取最小可见图形大小
    * @memberOf VectorLayer
    * @returns {Number} 最小可见图形大小 -- double类型
   */
  async getMinVisibleGeomSize(){
    try {
      let minVisibleGeomSize = await VL.getMinVisibleGeomSize(this._MGVectorLayerId);
      return minVisibleGeomSize;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置最小可见图形大小
   * 
   * @memberOf VectorLayer
   * @param {Number} minVisibleGeomSize 最小可见图形大小 -- double类型
   * @returns {}
   * 
   */
  async setMinVisibleGeomSize(minVisibleGeomSize){
    try {
      await VL.setMinVisibleGeomSize(this._MGVectorLayerId, minVisibleGeomSize);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取透明度
   * @memberOf VectorLayer
   *
   * @return  透明度,0-100 默认为0,表示不透明。
   */
  async getTransparency() {
    try {
      let transparency = await VL.getTransparency(this._MGVectorLayerId);
      return transparency;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置透明度,0-100 默认为0,表示不透明
   * @memberOf VectorLayer
   * @param {Number} transparency 透明度 -- 处于short数值范围的int类型的Number
   * @returns {Promise<void>} 1：成功，0：失败。
   */
  async setTransparency(transparency) {
    try {
      await VL.setTransparency(this._MGVectorLayerId, transparency);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取字段集合
   * 
   * @memberOf VectorLayer
   * @returns {Promise<Fields>} 返回Fields对象
   */
  async getFields(){
    try {
       var {FieldsId} = await VL.getFields(this._MGVectorLayerId);
       var fields = null;
       if(FieldsId != null){
         fields = new Fields();
         fields._MGFieldsId = FieldsId;
       }
       return fields;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置区域边界线图形信息
   * 
   * @memberOf VectorLayer
   * @param {LinInfo} linInfo 线图形信息
   * @returns {Promise<Void>}
   */
  async setRegBorderLinInfo(linInfo){
    try {
      await VL.setRegBorderLinInfo(this._MGVectorLayerId, linInfo._MGLinInfoId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取区域边界线图形信息
   * 
   * @memberOf VectorLayer
   * @returns {Promise<LinInfo>} 成功返回线图形信息
   */
  async getRegBorderLinInfo(){
    try {
       var {LinInfoId} = await VL.getRegBorderLinInfo(this._MGVectorLayerId);
       var linInfo = null;
       if(LinInfoId != null){
         linInfo = new LinInfo();
         linInfo._MGLinInfoId - LinInfoId;
       }
       return linInfo;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 生成一个UUID字符串
   * @memberOf VectorLayer
   * @returns {String} UUID对应的字符串
   */
  async generateUUID(){
    try {
      let uuid = await VL.generateUUID();
      return uuid;
    } catch (e) {
      console.error(e);
    }
  }
}
