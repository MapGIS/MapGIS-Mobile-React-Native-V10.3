/**
 * @content 空间分析功能组件
 * @author  2019-09-25
 */
import { NativeModules } from "react-native";

let SPA = NativeModules.JSSpaAnalysis;                  

import GeoPolygons from "./GeoPolygons.js"
import Geometry from "./Geometry.js"
import GeoPolygon from "./GeoPolygon.js"

/**
 * @class SpaAnalysis
 * @description 空间分析
 */
export default class SpaAnalysis{

 /**
   * 构造一个新的 SpaAnalysis 对象。
   * @memberOf SpaAnalysis
   * @returns {Promise.<SpaAnalysis>}
   */
  async createObj() {
    try{
        var {SpaAnalysisId} = await SPA.createObj();
        var spaAnalysis = new SpaAnalysis();
        spaAnalysis._MGSpaAnalysisId = SpaAnalysisId;
        return spaAnalysis;
    }catch(e){
        console.error(e);
    }
  }

  /**
	 * 获取容差
	 * @memberOf SpaAnalysis
	 * @return {Promise.<double>}容差
	 */
    async getTolerance()
	{
		try {
            return await SPA.getTolerance(this._MGSpaAnalysisId);
          } catch (e) {
            console.error(e);
        }
	}

    /**
	 * 设置容差
	 * @memberOf SpaAnalysis
	 * @param {double} tolerance 容差
	 * @return {Promise.<void>}计算得出的缓冲区
	 */
	async setTolerance(tolerance)
	{
		try {
            await SPA.setTolerance(this._MGSpaAnalysisId, tolerance);
          } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 计算左右缓冲区
	 * <p>
	 * 详细说明:<br>
	 * 特别说明:<br>
	 * 参数geom几何与左右缓冲半径的单位不一致的情况(sRefSrc必须赋值)，如：缓冲半径是米，geom几何单位不是米，源投影坐标系sRefSrc是geom几何数据的空间参考系;
	 * 缓冲分析返回的结果坐标单位与参数geom几何单位一致<br>
	 * 参数geom几何与左右缓冲半径的单位一致的情况(sRefSrc赋值null)<br>
	 * 示例代码:<br>
	 * 无<br>
	 * </p>
	 * @memberOf SpaAnalysis
	 * @param {Geometry} geom
	 * @param {double} leftDis   左半径
	 * @param {double} rightDis  右半径
	 * @param {int} endCapStyle 缓冲区边界类型 0/1/2-圆角/垂直/平角
	 * @param {SRefData} sRefSrc   数据的源投影坐标系
	 * @return {Promise.<GeoPolygons>}计算得出的缓冲区
	 */
	async bufferWithEndCapStyle(geom, leftDis, rightDis, endCapStyle, sRefSrc)
	{
		try {
			var geoPolygons = null
			if(geom != null){
				let {GeoPolygonsId} =  await SPA.buffer(this._MGSpaAnalysisId, geom._MGGeometryId, leftDis, rightDis, endCapStyle, sRefSrc != null?sRefSrc._MGSRefDataId:null);
				var geoPolygons = new GeoPolygons();
				geoPolygons._MGGeoPolygonsId = GeoPolygonsId;
			}           
            return geoPolygons;
          } catch (e) {
            console.error(e);
        }
	}

	/**
	 * * <p>
	 * 详细说明:<br>
	 * 特别说明:<br>
	 * 参数geom几何与左右缓冲半径的单位不一致的情况(sRefSrc必须赋值)，如：缓冲半径是米，geom几何单位不是米，源投影坐标系sRefSrc是geom几何数据的投影坐标系;
	 * 缓冲分析返回的结果坐标单位与参数geom几何单位一致<br>
	 * 参数geom几何与左右缓冲半径的单位一致的情况(sRefSrc赋值null)<br>
	 * 示例代码:<br>
	 * 无<br>
	 * </p>
	 *  
	 * 计算左右缓冲区(圆角边界)
     * @memberOf SpaAnalysis
	 * @param {Geometry} geom
	 * @param {double} leftDis   左半径
	 * @param {double} rightDis  右半径
	 * @param {SRefData} sRefSrc   数据的源投影坐标系
	 * @return {Promise.<GeoPolygons>}计算得出的缓冲区
	 */ 
	async buffer(geom, leftDis, rightDis, sRefSrc)
	{
		try {
            let {GeoPolygonsId} =  await SPA.buffer(this._MGSpaAnalysisId, geom._MGGeometryId, leftDis, rightDis, sRefSrc != null?sRefSrc._MGSRefDataId:null);
            var geoPolygons = new GeoPolygons();
            geoPolygons._MGGeoPolygonsId = GeoPolygonsId;
            return geoPolygons;
          } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 裁剪
	 * @memberOf SpaAnalysis
	 * @param {Geometry} geom 被裁剪几何
	 * @param {GeoPolygon} clipPoly 裁剪区
	 * @param {int} flag 裁剪类型 0/1-内裁/外裁
	 * @return {Promise.<Geometry>}计算得出的缓冲区
	 * @see    裁剪设置的容差默认值为0.0001,
	 *         对于经纬度数据，需要传入合适的容差值，对于经纬度数据建议先调用setTolerance()接口使用0.000000001作为容差值
	 */
	async clipWithType(geom, clipPoly, flag)
	{
		try {
            let {GeometryId} =  await SPA.clip(this._MGSpaAnalysisId, geom._MGGeometryId, clipPoly._MGGeoPolygonId, flag);
            var geometry = new Geometry();
            geometry._MGGeometryId = GeometryId;
            return geometry;
          } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 裁剪(内裁)
	 * @memberOf SpaAnalysis
	 * @param {Geometry} geom 被裁剪几何
	 * @param {GeoPolygon} clipPoly 裁剪区                
	 * @return {Promise.<Geometry>}计算得出的缓冲区
	 * @see    裁剪设置的容差默认值为0.0001,
	 *         对于经纬度数据，需要传入合适的容差值，对于经纬度数据建议先调用setTolerance()接口使用0.000000001作为容差值
	 */
	async clip(geom, clipPoly)
	{
		try {
            let {GeometryId} =  await SPA.clip(this._MGSpaAnalysisId, geom._MGGeometryId, clipPoly._MGGeoPolygonId);
            var geometry = new Geometry();
            geometry._MGGeometryId = GeometryId;
            return geometry;
          } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 计算几何对象的凸闭包
	 * @memberOf SpaAnalysis
	 * @param {Geometry} geom  几何对象
	 * @return {Promise.<GeoPolygon>}计算得出的凸闭包区
	 */
	async convexHull(geom)
	{
		try {
            let {GeoPolygonId} =  await SPA.convexHull(this._MGSpaAnalysisId, geom._MGGeometryId);
            var geoPolygon = new GeoPolygon();
            geoPolygon._MGGeoPolygonId = GeoPolygonId;
            return geoPolygon;
          } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 计算两个几何对象的差集
	 * @memberOf SpaAnalysis
	 * @param {Geometry} inputGeom 输入几何对象
	 * @param {Geometry} differenceGeom 求差几何对象
	 * @return {Promise.<Geometry>}得出的两个几何对象的差集
	 * @see    裁剪设置的容差默认值为0.0001,
	 *         对于经纬度数据，需要传入合适的容差值，对于经纬度数据建议先调用setTolerance()接口使用0.000000001作为容差值
	 */
	async difference(inputGeom, differenceGeom)
	{
		try {
            let {GeometryId} =  await SPA.difference(this._MGSpaAnalysisId, inputGeom._MGGeometryId, differenceGeom._MGGeometryId);
            var geometry = new Geometry();
            geometry._MGGeometryId = GeometryId;
            return geometry;
          } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 计算两个几何对象的交集
	 * @memberOf SpaAnalysis
	 * @param {Geometry} inputGeom 输入几何对象
	 * @param {Geometry} intersectGeom 求交几何对象
	 * @return {Promise.<Geometry>}得出的两个几何对象的交集
	 * @see    裁剪设置的容差默认值为0.0001,
	 *         对于经纬度数据，需要传入合适的容差值，对于经纬度数据建议先调用setTolerance()接口使用0.000000001作为容差值
	 */
	async intersection(inputGeom, intersectGeom)
	{
		try {
            let {GeometryId} =  await SPA.intersection(this._MGSpaAnalysisId, inputGeom._MGGeometryId, intersectGeom._MGGeometryId);
            var geometry = new Geometry();
            geometry._MGGeometryId = GeometryId;
            return geometry;
          } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 计算两个几何对象的对称差
	 * @memberOf SpaAnalysis
	 * @param {Geometry} inputGeom 输入几何对象
	 * @param {Geometry} intersectGeom 求对称差几何对象
	 * @return {Promise.<Geometry>}得出的两个几何对象的对称差
	 * @see    裁剪设置的容差默认值为0.0001,
	 *         对于经纬度数据，需要传入合适的容差值，对于经纬度数据建议先调用setTolerance()接口使用0.000000001作为容差值
	 */
	async symmetricDifference(inputGeom, intersectGeom)
	{
		try {
            let {GeometryId} =  await SPA.symmetricDifference(this._MGSpaAnalysisId, inputGeom._MGGeometryId, intersectGeom._MGGeometryId);
            var geometry = new Geometry();
            geometry._MGGeometryId = GeometryId;
            return geometry;
          } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 合并两个几何对象
	 * @memberOf SpaAnalysis
	 * @param  {Array<GeoPolygon>} GeoPolygonArry 需要合并的几何对象
	 * @return {Promise.<Geometry>}返回合并后的几何对象
	 * @see    裁剪设置的容差默认值为0.0001,
	 *         对于经纬度数据，需要传入合适的容差值，对于经纬度数据建议先调用setTolerance()接口使用0.000000001作为容差值
	 */
	async mergeGeoPolygons(GeoPolygonArry)
	{
		try {
            let {GeometryId} =  await SPA.merge(this._MGSpaAnalysisId, GeoPolygonArry);
            var geometry = new Geometry();
            geometry._MGGeometryId = GeometryId;
            return geometry;
          } catch (e) {
            console.error(e);
        }
	}
	/**
	 * 合并两个几何对象
	 * @memberOf SpaAnalysis
	 * @param {Geometry} inputGeom 输入几何对象
	 * @param {Geometry} mergeGeom 合并的几何对象
	 * @return {Promise.<Geometry>}返回合并后的几何对象
	 * @see    裁剪设置的容差默认值为0.0001,
	 *         对于经纬度数据，需要传入合适的容差值，对于经纬度数据建议先调用setTolerance()接口使用0.000000001作为容差值
	 */
	async merge(inputGeom, mergeGeom)
	{
		try {
            let {GeometryId} =  await SPA.merge(this._MGSpaAnalysisId, inputGeom._MGGeometryId, mergeGeom._MGGeometryId);
            var geometry = new Geometry();
            geometry._MGGeometryId = GeometryId;
            return geometry;
          } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 计算两个几何对象的并集
	 * @memberOf SpaAnalysis
	 * @param {Geometry} inputGeom 输入几何对象
	 * @param {Geometry} unionGeom 求并几何对象
	 * @return {Promise.<Geometry>}得出的两个几何对象的并集
	 * @see    裁剪设置的容差默认值为0.0001,
	 *         对于经纬度数据，需要传入合适的容差值，对于经纬度数据建议先调用setTolerance()接口使用0.000000001作为容差值
	 */
	async union(inputGeom, unionGeom)
	{
		try {
            let {GeometryId} =  await SPA.union(this._MGSpaAnalysisId, inputGeom._MGGeometryId, unionGeom._MGGeometryId);
            var geometry = new Geometry();
            geometry._MGGeometryId = GeometryId;
            return geometry;
          } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 指定线分割折线或多边形
	 * @memberOf SpaAnalysis
	 * @param {Geometry} geom 输入几何对象
	 * @param {GeoLine} line 分割线
	 * @return {Promise.<Geometry>} 返回分割后的结果。分割失败返回null，分割成功返回多线或多区。
	 * @see    裁剪设置的容差默认值为0.0001,
	 *         对于经纬度数据，需要传入合适的容差值，对于经纬度数据建议先调用setTolerance()接口使用0.000000001作为容差值
	 */
	async split(geom, line)
	{
        try {
            let {GeometryId} =  await SPA.split(this._MGSpaAnalysisId, geom._MGGeometryId, line._MGGeoLineId);
            var geometry = new Geometry();
            geometry._MGGeometryId = GeometryId;
            return geometry;
          } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 提取几何的边界
	 * @memberOf SpaAnalysis
	 * @param {Geometry} geom 几何对象
	 * @return {Promise.<Geometry>}提取的几何边界对象
	 */
	async boundary(geom)
	{
		try {
            let {GeometryId} =  await SPA.boundary(this._MGSpaAnalysisId, geom._MGGeometryId);
            var geometry = new Geometry();
            geometry._MGGeometryId = GeometryId;
            return geometry;
          } catch (e) {
            console.error(e);
        }
	}
}
