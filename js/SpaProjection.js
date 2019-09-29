/**
 * @content 空间投影功能组件
 * @author  2019-09-25
 */
import { NativeModules } from 'react-native';

let SPP = NativeModules.JSSpaProjection;

import SRefData from './SRefData.js';

/**
 * @class SpaProjection
 * @description 空间投影
 */
export default class SpaProjection {
  /**
   * 构造一个新的 SpaProjection 对象。
   * @memberOf SpaProjection
   * @returns {Promise.<SpaProjection>}
   */
  async createObj() {
    try {
      var { SpaProjectionId } = await SPP.createObj();
      var spaProjection = new SpaProjection();
      spaProjection._MGSpaProjectionId = SpaProjectionId;
      return spaProjection;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置源投影参数
   * @memberOf SpaProjection
   * @param {SRefData} sRef 源投影参数
   * @return {Promise.<int>} >0成功； <=0-失败
   */
  async setSourcePara(sRef) {
    try {
      return await SPP.setSourcePara(
        this._MGSpaProjectionId,
        sRef._MGSRefDataId
      );
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 取源投影参数
   * @memberOf SpaProjection
   * @return {Promise.<SRefData>} 源投影参数
   */
  async getSourcePara() {
    try {
      let { SRefDataId } = await SPP.getSourcePara(this._MGSpaProjectionId);
      var sRefData = new SRefData();
      sRefData._MGSRefDataId = SRefDataId;
      return sRefData;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置目标投影参数
   * @memberOf SpaProjection
   * @param {SRefData} sRef 目标投影参数
   * @return {Promise.<int>} >0成功； <=0-失败
   */
  async setDestinationPara(sRef) {
    try {
      return await SPP.setDestinationPara(
        this._MGSpaProjectionId,
        sRef._MGSRefDataId
      );
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 取目标投影参数
   * @memberOf SpaProjection
   * @return {Promise.<SRefData>} 目标投影参数
   */
  async getDestinationPara() {
    try {
      let { SRefDataId } = await SPP.getDestinationPara(
        this._MGSpaProjectionId
      );
      var sRefData = new SRefData();
      sRefData._MGSRefDataId = SRefDataId;
      return sRefData;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置椭球坐标系变换参数的索引，当投影前后椭球体不一样时，必须设置椭球坐标系变换参数
   * @memberOf SpaProjection
   * @param {int} transID 椭球坐标系变换参数的索引,从0开始
   * @see ElpTransformation
   * @return {Promise.<int>} >0成功； <=0-失败
   */
  async setEllipTransId(transID) {
    try {
      return await SPP.setEllipTransId(this._MGSpaProjectionId, transID);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置椭球坐标系变换参数，当投影前后椭球体不一样时，必须设置椭球坐标系变换参数
   * @memberOf SpaProjection
   * @param {ElpTransParam} param 椭球坐标系变换参数
   * @return {Promise.<int>} >0成功； <=0-失败
   */
  async setEllipTransParam(param) {
    try {
      return await SPP.setEllipTransParam(
        this._MGSpaProjectionId,
        param._MGElpTransParamId
      );
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获得椭球坐标系变换参数的索引
   * @memberOf SpaProjection
   * @return {Promise.<int>} 椭球坐标系变换参数的索引
   * @see ElpTransformation
   */
  async getEllipTransId() {
    try {
      return await SPP.getEllipTransId(this._MGSpaProjectionId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 单点投影
   * @memberOf SpaProjection
   * @param {Dot} xy 点坐标
   * @return {Promise.<int>} >0成功； <=0-失败
   */
  async projTrans(xy) {
    try {
      return await SPP.projTrans(this._MGSpaProjectionId, xy._MGDotId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * WGS84 （度）到 web墨卡托投影（米）
   * @memberOf SpaProjection
   * @param {Dot} dot 点坐标
   * @return {Promise.<void>}
   */
  static async lonLat2Mercator(dot) {
    try {
      await SPP.lonLat2Mercator(dot._MGDotId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * web墨卡托投影（米）到 WGS84（度）
   * @memberOf SpaProjection
   * @param {Dot} dot 点坐标
   * @return {Promise.<void>}
   */
  static async mercator2LonLat(dot) {
    try {
      await SPP.mercator2LonLat(dot._MGDotId);
    } catch (e) {
      console.error(e);
    }
  }
}
