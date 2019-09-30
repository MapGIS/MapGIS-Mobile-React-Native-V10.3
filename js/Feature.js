/**
 * @content 要素类功能组件
 * @author fjl 2019-6-25下午2:52:36
 */
import { NativeModules } from 'react-native';

let F = NativeModules.JSFeature;
import Graphic from './Graphic';

/**
 * @class Feature
 */
export default class Feature {
  /**
   * 构造一个新的 Feature 对象。
   * @memberOf Feature
   * @returns {Promise.<Feature>}
   */
  async createObj() {
    try {
      var { FeatureId } = await F.createObj();
      var featurePagedResult = new Feature();
      featurePagedResult._MGFeatureId = FeatureId;
      return featurePagedResult;
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
      let { GeometryId } = await F.getGeometry(this._MGFeatureId);
      var geometry = new Geometry();
      geometry._MGGeometryId = GeometryId;
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
      let { GeomInfoId } = await F.getInfo(this._MGFeatureId);
      var geomInfo = new GeomInfo();
      geomInfo._MGGeometryId = GeomInfoId;
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
      var { values } = await F.toGraphics(this._MGFeatureId);
      var objArr = [];
      for (var i = 0; i < values.length; i++) {
        var graphic = new Graphic();
        graphic._MGGraphicId = values[i];
        console.log('values[i]:' + values[i]);
        objArr.push(graphic);
      }
      console.log('values[i]:' + objArr.length);
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

}
