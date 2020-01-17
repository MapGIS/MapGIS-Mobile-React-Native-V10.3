/**
 * @content 要素类功能组件
 * @author fjl 2019-6-25下午2:52:36
 */
import { NativeModules } from 'react-native';

let F = NativeModules.JSFeature;
import GeoPoints from './GeoPoints.js'
import GeoVarLine from './GeoVarLine.js'
import GeoPolygon from './GeoPolygon.js'
import GeoPolygons from './GeoPolygons.js'
import GeoAnno from './GeoAnno.js'
import PntInfo from './PntInfo.js'
import LinInfo from './LinInfo.js'
import RegInfo from './RegInfo.js'
import TextAnnInfo from './TextAnnInfo.js'
import Geometry from './Geometry.js';
import Map from './Map.js';


/**
 * @class Feature
 */
export default class Feature {
  /**
   * 无参构造。构造一个新的 Feature 对象。
   * 
   * @memberOf Feature
   * @returns {Promise.<Feature>}
   */
  async createObj() {
    try {
      let { FeatureId } = await F.createObj();
      let feature = new Feature();
      feature._MGFeatureId = FeatureId;
      return feature;
    } catch (e) {
      console.error(e);
    }
  }


  /**
   * 有参构造。通过attribute、geometry、geomInfo构造一个新的 Feature 对象。
   * 
   * @memberOf Feature
   * @param {Array} attribute 存有属性字段及对应值的数组，不可为null。例：let array = []; array.push("name", "张三");
   * @param {Geometry} geometry 几何对象
   * @param {GeomInfo} geomInfo 图形对象
   * @returns {Promise.<Feature>}
   * 
   */
  async createObjByParam(attribute, geometry, geomInfo) {
    try {
        let attributeJson = null;
        if(attribute !== null){
          attributeJson = JSON.stringify(attribute);
        }
        let { FeatureId } = await F.createObjByParam(attributeJson, geometry._MGGeometryId, geomInfo._MGGeomInfoId);
        let feature = new Feature();
        feature._MGFeatureId = FeatureId;
        return feature;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   *  获取要素ID
   *  @memberOf Feature
   * @returns {Promise<*|*>}
   */
  async getID() {
    try {
      let ID = await F.getID(this._MGFeatureId);
      return ID;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取要素属性
   * @memberOf Feature
   */
  async getAttributes() {
    try {
      let { jsonAttributes } = await F.getAttributes(this._MGFeatureId);
      return jsonAttributes;
    } catch (e) {
      console.error(e);
    }
  }

  /**
	 * 获取几何数据
	 * @memberOf Feature
	 * @return {Promise<Geometry>}几何数据
	 */
	async getGeometry()
	{
    try {
      let { GeometryId,GeometryType } = await F.getGeometry(this._MGFeatureId);
      let geometry = null;
      switch(GeometryType)
      {
        case 2:
            geometry = new GeoPoints();
            geometry._MGGeometryId = GeometryId;
          break;
          case 12:
            geometry = new GeoVarLine();
            geometry._MGGeometryId = GeometryId;
          break;
          case 14:
            geometry = new GeoPolygon();
            geometry._MGGeometryId = GeometryId;
          break;
          case 15:
            geometry = new GeoPolygons();
            geometry._MGGeometryId = GeometryId;
          break;
          case 17:
            geometry = new GeoAnno();
            geometry._MGGeometryId = GeometryId;
            break;
          default:
            break;
      }
      return geometry;
    } catch (e) {
      console.error(e);
    }
	}

	/**
	 * 获取几何信息
	 * @memberOf Feature
	 * @return {Promise<GeomInfo>}几何信息
	 */
	async getInfo()
	{
    try {
      let { GeomInfoId,GeometryType} = await F.getInfo(this._MGFeatureId);
      let geomInfo = null;
      switch(GeometryType)
      {
        case 2:
            geomInfo = new PntInfo();
            geomInfo._MGGeomInfoId = GeomInfoId;
          break;
          case 12:
            geomInfo = new LinInfo();
            geomInfo._MGGeomInfoId = GeomInfoId;
          break;
          case 14:
            geomInfo = new RegInfo();
            geomInfo._MGGeomInfoId = GeomInfoId;
          break;
          case 15:
            geomInfo = new RegInfo();
            geomInfo._MGGeomInfoId = GeomInfoId;
          break;
          case 17:
            geomInfo = new TextAnnInfo();
            geomInfo._MGGeomInfoId = GeomInfoId;
            break;
          default:
            break;
      }
      return geomInfo;
    } catch (e) {
      console.error(e);
    }
	}


  /**
   * 要素转Graphic
   *  @memberOf Feature
   * @returns {Promise<Array>}
   */
  async toGraphics() {
    try {
      let { values } = await F.toGraphics(this._MGFeatureId);
      let objArr = Map.getGraphics(values);
      return objArr;
    } catch (e) {
      console.error(e);
    }
  }

  	/**
	 * 清空
	 * @memberOf Feature
	 * @return {Promise<long>}大于0成功，否则失败
	 */
  async reSet()
	{
		try {
      return await F.reSet(this._MGFeatureId);
    } catch (e) {
      console.error(e);
    }
  }
  
  /**
   * 修改要素值（包括属性信息，图形信息，几何信息）
   * 
   * @memberof Feature
   * @param {String} attribute 属性信息，JSON格式的字符串，暂不支持null。例{"LayerID":"0","ID":"1"}
   * @param {Geometry} geometry 图形信息
   * @param {GeomInfo} geomInfo 几何信息
   * @returns {Promise<Number>} 大于0成功，否则失败
   */
  async modifyFeatureValue(attribute, geometry, geomInfo){
    try {
      let attributeJson = null;
        if(attribute !== null){
          attributeJson = JSON.stringify(attribute);
        }
      return await F.modifyFeatureValue(this._MGFeatureId,  attributeJson, geometry._MGGeometryId, geomInfo._MGGeomInfoId);
    } catch (e) {
      console.error(e);
    }
  }


}
