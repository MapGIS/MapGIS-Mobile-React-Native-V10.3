/*
 * @Description: In User Settings Edit
 * @Author: fjl
 * @Date: 2019-09-06 16:27:38
 * @LastEditTime: 2019-09-17 10:47:04
 * @LastEditors: Please set LastEditors
 */
/**
 * @content android视图点对象功能组件
 * @author fjl 2019-6-24 下午2:52:36
 */
import { NativeModules } from "react-native";
let ML = NativeModules.JSMapLayer;
import Rect from "./Rect.js";
import SRefData from "./SRefData.js";
import SimpleLabel from "./SimpleLabel.js";
import Themes from "./Themes.js";

/**
 * @class MapLayer
 */
export default class MapLayer {
  /**
   * 构造一个新的 MapLayer 对象。
   * @memberOf MapLayer
   * @returns {Promise.<MapLayer>}
   */
  async createObj() {
    try {
      var { MapLayerId } = await ML.createObj();
      var mapLayer = new MapLayer();
      mapLayer._MGMapLayerId = MapLayerId;
      return mapLayer;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取图层名称
   * @memberOf MapLayer
   * @returns {Promise<*>}
   */
  async getName() {
    try {
      let name = await ML.getName(this._MGMapLayerId);
      return name;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取图层名称
   * @memberOf MapLayer
   * @param {String} Name 图层名称
   * @returns {Promise<*>}
   */
  async setName(Name) {
    try {
      await ML.setName(this._MGMapLayerId,Name);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取图层的URL
   * @memberOf MapLayer
   * @returns {Promise<*>}
   */
  async getURL() {
    try {
      let url = await ML.getURL(this._MGMapLayerId);
      return url;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置图层URL地址
   * @memberOf MapLayer
   * @param {String} URL 图层URL地址
   * @returns {Promise<void>}
   */
  async setURL(URL) {
    try {
      await ML.setURL(this._MGMapLayerId, URL);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取图层状态
   * @memberOf MapLayer
   * @returns {Promise<*|NavigationPreloadState>}
   */
  async getState() {
    try {
      let state = await ML.getState(this._MGMapLayerId);
      return state;
    } catch (e) {
      console.error(e);
    }
  }
  /**
   * 设置图层状态
   *@memberOf MapLayer
   * @param {Boolean} State 图层状态
   */
  async setState(State) {
    try {
      await ML.setState(this._MGMapLayerId, State);
    } catch (e) {
      console.error(e);
    }
  }
  /**
   * 设置图层是否显示
   * @memberOf MapLayer
   * @param {Boolean} visible 图层是否显示
   */
  async setVisible(visible) {
    try {
      await ML.setVisible(this._MGMapLayerId, visible);
    } catch (e) {
      console.error(e);
    }
  }
  /**
   * 获取图层是否显示
   * @memberOf MapLayer
   */
  async getIsVisible() {
    try {
      let state = await ML.getIsVisible(this._MGMapLayerId);
      return state;
    } catch (e) {
      console.error(e);
    }
  }
  /**
   * 获取图层最小显示比率
   * @memberOf MapLayer
   *
   */
  async getMinScale() {
    try {
      let minScale = await ML.getMinScale(this._MGMapLayerId);
      return minScale;
    } catch (e) {
      console.error(e);
    }
  }
  /**
   * 设置图层最小显示比率
   * @memberOf MapLayer
   * @param MinScale 图层最小显示比率
   */
  async setMinScale(MinScale) {
    try {
      await ML.setMinScale(this._MGMapLayerId, MinScale);
    } catch (e) {
      console.error(e);
    }
  }
  /**
   * 获取图层最大显示比率
   * @memberOf MapLayer
   */
  async getMaxScale() {
    try {
      let maxScale = await ML.getMaxScale(this._MGMapLayerId);
      return maxScale;
    } catch (e) {
      console.error(e);
    }
  }
  /**
   * 设置图层最大显示比率
   *@memberOf MapLayer
   * @param MaxScale 图层最大显示比率
   */
  async setMaxScale(MaxScale) {
    try {
      await ML.setMaxScale(this._MGMapLayerId, MaxScale);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取图层的权重
   * @memberOf MapLayer
   * @returns {Promise<*>}
   */
  async getWeight() {
    try {
      let weight = await ML.getWeight(this._MGMapLayerId);
      return weight;
    } catch (e) {
      console.error(e);
    }
  }
  /**
   * 设置图层的权重
   * @memberOf MapLayer
   * @param {String} Weight 权重
   */
  async setWeight(Weight) {
    try {
      await ML.setWeight(this._MGMapLayerId, Weight);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 查看图层是否有效
   * @memberOf MapLayer
   * @returns {Promise<*>}
   */
  async getIsValid() {
    try {
      let IsValid = await ML.getIsValid(this._MGMapLayerId);
      return IsValid;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取地图范围
   * @memberOf MapLayer
   * @returns {Promise<Rect>}
   */
  async getRange() {
    try {
      var { rectId } = await ML.getViewRange(this._MGMapLayerId);
      var rect = null;
      if(rectId != null){
        rect = new Rect();
        rect._MGRectId = rectId;
      }
      return rect;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取空间参照系
   * @memberof MapLayer
   * @returns {Promise<SRefData>}
   */
  async getSrefInfo(){
    try {
      var { SRefDataId } = await ML.getSrefInfo(this._MGMapLayerId);
      var sRefInfo = null;
      if(SRefDataId != null){
         sRefInfo = new SRefData();
         sRefInfo._MGSRefDataId = SRefDataId;
      }

      return sRefInfo;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取类类型
   * @memberof MapLayer
   * @returns {Number} 类类型（int类型的数值；例如 30 -- XClsType.SFCls）
   */
  async getClsType(){
    try {
      let clsType = await ML.getClsType(this._MGMapLayerId);
      return clsType;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取要素几何类型
   * @memberof MapLayer
   * @returns {Number} 要素几何类型（int类型的数值；例如 1--GeomType.GeomPnt
   */
  async GetGeometryType(){
    try {
      let geometryType = await ML.GetGeometryType(this._MGMapLayerId);
      return geometryType;
    } catch (e) {
      console.error(e);
    }
  }

   /**
   * 获取当前的标注
   * @memberof MapLayer
   * @returns {Promise<Label>}} 成功返回当前的标注
   */
  async getLabel(){
    try {
      var {LabelId, LabelType} = await ML.getLabel(this._MGMapLayerId);
      let label = null;
      if(LabelId != null){
         switch(LabelType){
              case 0x0100:
                  label = new SimpleLabel();
                  label._MGLabelId = LabelId;
                break;
         }
      }

      return label;
    } catch (e) {
      console.error(e);
    }
  }

   /**
   * 获获取专题图列表
   * @memberof MapLayer
   * @returns {Promise<Themes>}} 成功返回专题图列表
   */
  async getThemes(){
    try {
      var {ThemesId} = await ML.getThemes(this._MGMapLayerId);
      var themes = null;
      if(ThemesId != null){
         themes = new Themes();
         themes._MGThemesId = ThemesId;
      }

      return themes;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 复制图层
   * @memberof MapLayer
   * @returns {Promise<MapLayer>}} 成功返回克隆之后的图层
   */
  async clone(){
    try {
      var {MapLayerId} = await ML.clone(this._MGMapLayerId);
      var mapLayer = null;
      if(MapLayerId != null){
          mapLayer = new MapLayer();
          mapLayer._MGMapLayerId = MapLayerId;
      }

      return mapLayer;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 附加外部数据
   * @memberof MapLayer
   * @param {Object} cls 地理类对象
   * @return {boolean} true/false 成功/失败
   */
  async attachData(cls){
    try {
      let result = await ML.attachData(this._MGMapLayerId);
      return result;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 附加解除
   * @memberof MapLayer
   * @return {boolean} true/false 成功/失败
   */
  async detachData(){
    try {
      let result = await ML.detachData(this._MGMapLayerId);
      return result;
    } catch (e) {
      console.error(e);
    }
  }

   /**
   * 获取图层要素数据类
   * @memberof MapLayer
   * @return {Promise<IBasCls>} 成功获得数据类
   */
  async getData(){
    try {
      
    } catch (e) {
      console.error(e);
    }
  }

   /**
   * 存为XML
   * @memberof MapLayer
   * @param {boolean} onlyStyle true:仅导出样式  false:除图层样式信息外还包括图层的name、geometryType、url、layerWeight、state信息
   * @return {String} xml
   */
  async toXML(onlyStyle){
    try {
      let xml = await ML.toXML(this._MGMapLayerId, onlyStyle);
      return xml;
    } catch (e) {
      console.error(e);
    }
  }

  /**
	 * 从XML导入
	 * @memberof MapLayer
	 * @param strXML 
	 * @param onlyStyle true:仅导入样式信息  false:除图层样式信息外还包括图层的name、geometryType、url、layerWeight、state信息
   * @return {int} 1-成功；0-失败
	 */
  async fromXML(strXMl, onlyStyle){
    try {
      let result = await ML.fromXML(this._MGMapLayerId, strXMl, onlyStyle);
      return result;
    } catch (e) {
      console.error(e);
    }
  }
}
