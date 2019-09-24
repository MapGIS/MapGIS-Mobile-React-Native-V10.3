/**
 * @content 抽象基类，用于定义所有的几何注记对象基类功能组件
 * @author  2019-09-09 
 */
import { NativeModules } from "react-native";
import Rect from "./Rect.js";
import Geometry from "./Geometry.js";
import Dot from "./Dot.js";

let GA = NativeModules.JSGeoAnno;

/**
 * @class GeoAnno
 */
export default class GeoAnno extends Geometry {


    /**
	 * 拷贝几何信息
	 * @memberOf GeoAnno
	 * @param geometry 被拷贝的几何对象
	 * @returns {Promise} 成功克隆返回1，失败返回0
	 */
	async clone(geometry)
	{
		try {
            return await GA.clone(this._MGGeoAnnoId, geometry._MGGeometryId);
        }
        catch (e) {
            console.error(e);
        }
	}

	/**
	 * 清空几何数据
	 * @memberOf GeoAnno
	 * @returns {Promise} 清空数据成功返回1，失败返回0
	 */
	async empty()
	{
		try {
            return await GA.empty(this._MGGeoAnnoId);
        }
        catch (e) {
            console.error(e);
        }
	}

	/**
	 * 计算几何注记的外包围盒
	 * @memberOf GeoAnno
	 * @returns {Promise.<Rect>} 包围盒信息
	 */
	async calRect()
	{
		try {
            let {RectId}  = await GA.calRect(this._MGGeoAnnoId);
            var rect = new Rect();
            rect._MGRectId = RectId;
            return rect;
        }
        catch (e) {
            console.error(e);
        }
	}

	/**
	 * 是否在矩形内
	 * @memberOf GeoAnno
	 * @param rect 待比较的包围盒对象
	 * @returns {Promise}在包围盒内返回1，不在返回0
	 */
	async isInRect(rect)
	{
		try {
            return await GA.isInRect(this._MGGeoAnnoId, rect._MGRectId);
        }
        catch (e) {
            console.error(e);
        }
	}

	/**
	 * 是否和矩形相交
	 * @memberOf GeoAnno
	 * @param rect 待比较的包围盒对象
	 * @returns {Promise} 和包围盒相交返回1，不相交返回0
	 */
	async isInterRect(rect)
	{
		try {
            return await GA.isInterRect(this._MGGeoAnnoId, rect._MGRectId);
        }
        catch (e) {
            console.error(e);
        }
	}

	/**
	 * 取注记维数
	 * @memberOf GeoAnno
	 * @returns {Promise} 注记维数
	 */
	async getDimension()
	{
		try {
            return await GA.getDimension(this._MGGeoAnnoId);
        }
        catch (e) {
            console.error(e);
        }
	}

	/**
	 * 投影变换
	 * @memberOf GeoAnno
	 * @param ptOrigSRef 原始投影系
	 * @param ptDestSRef 目标投影系
	 * @returns {Promise<Geometry>} 投影后的几何对象
	 */
	async transSRS(origSRef, destSRef)
	{
		try {
            let {GeometryId} = await GA.transSRS(this._MGGeoAnnoId, origSRef._MGSRefDataId, destSRef._MGSRefDataId);
            var geometry = new Geometry();
            geometry._MGGeometryId = GeometryId;
            return geometry;
        }
        catch (e) {
            console.error(e);
        }
	}

	/**
	 * 投影变换
	 * @memberOf GeoAnno
	 * @param ptOrigSRef 原始投影系
	 * @param ptDestSRef 目标投影系
	 * @param param 椭球坐标系变换参数
	 * @returns {Promise<Geometry>}投影后的几何对象
	 */
	async transSRSOfParam(origSRef, destSRef, param)
	{
		try {
            let {GeometryId} = await GA.transSRS(this._MGGeoAnnoId, origSRef._MGSRefDataId, destSRef._MGSRefDataId, param._MGElpTransParamId);
            var geometry = new Geometry();
            geometry._MGGeometryId = GeometryId;
            return geometry;
        }
        catch (e) {
            console.error(e);
        }
	}

	/**
	 * 获取定位点
	 * @memberOf GeoAnno
	 * @returns {Promise<Dot>} 定位点
	 */
	async getAnchorDot()
	{
		try {
            let {point2DId} = await GA.getAnchorDot(this._MGGeoAnnoId);
            var point2DDot = new Dot();
            point2DDot._MGGeometryId = point2DId;
            return point2DDot;
        }
        catch (e) {
            console.error(e);
        }
	}

	/**
	 * 设置定位点
	 * @memberOf GeoAnno
	 * @param  dot 定位点坐标
     * @returns {Promise<void>}
	 */
	async setAnchorDot(dot)
	{
		try {
            await GA.setAnchorDot(this._MGGeoAnnoId, dot._MGDotId);
        }
        catch (e) {
            console.error(e);
        }
    }
}