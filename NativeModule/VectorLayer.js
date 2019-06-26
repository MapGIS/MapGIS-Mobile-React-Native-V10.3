/**
 * @content android视图点对象功能组件
 * @author fjl 2019-6-24 下午2:52:36
 */
import { NativeModules } from 'react-native';
import MapLayer from "./MapLayer";
let VL = NativeModules.JSVectorLayer;

export default class VectorLayer extends MapLayer{

  constructor(){
    super();
    Object.defineProperty(this,"_MGVectorLayerId",{
      get:function () {
        return this._MGMapLayerId
      },
      set:function (_MGVectorLayerId) {
        this._MGMapLayerId = _MGVectorLayerId;
      }
    })
  }

  /**
   * 构造一个新的 VectorLayer 对象。
   * @memberOf VectorLayer
   * @returns {Promise.<VectorLayer>}
   */
  async createObj() {
    try {
      var { VectorLayerId } = await VL.createObj();
      var graphic = new VectorLayer();
      graphic._MGVectorLayerId = VectorLayerId;
      return graphic;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取是否符号化显示
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
   * @param symbolShow
   * @returns {Promise<void>}
   */
  async setSymbolShow(symbolShow) {
    try {
      await ML.setSymbolShow(this._MGVectorLayerId, symbolShow);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取透明度
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
   *
   * @return  1：成功，0：失败。
   */
  async setTransparency(transparency) {
    try {
      await VL.setTransparency(this._MGVectorLayerId, transparency);
    } catch (e) {
      console.error(e);
    }
  }
}
