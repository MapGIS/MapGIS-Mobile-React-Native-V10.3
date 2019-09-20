/**
 * @content 用于对多条线段的几何功能组件
 * @author  2019-09-09 
 */
import { NativeModules } from "react-native";

let GLS = NativeModules.JSGeoLines;

import GeometryExp from "./GeometryExp.js"
import GeoLine from "./GeoLine.js"

/**
 * @class GeoLines
 */
export default class GeoLines extends GeometryExp {
    constructor(){
        super()
        Object.defineProperty(this,"_MGGeoLinesId", {
            get:function(){
                return this._MGGeometryId
            },
            set:function(_MGGeoLinesId){
                this._MGGeometryId = _MGGeoLinesId
            },
        })
    }
    
    /**
	 * 构造一个新的 GeoLines 对象
	 * @memberOf GeoLines
	 * @return {Promise<GeoLines>}
	 */
    async createObj(){
        try{
            var {GeoLinesId} = await GLS.createObj()
            var geoLines = new GeoLines()
            geoLines._MGGeoLinesId = GeoLinesId
            return geoLines
        } catch(e) {
            console.error(e)
        }
    }

    /**
	 * 获取几何对象的类型
	 * @memberOf GeoLines
	 * @return {Promise}几何对象类型
	 */
	async getType()
	{
		try{
            return await GLS.getType(this._MGGeoLinesId)
        } catch(e) {
            console.error(e)
        }
	}

	/**
	 * 获取几何对象的维数
	 * @memberOf GeoLines 
	 * @return {Promise}维数
	 */
	async getDimension()
	{
		try{
            return await GLS.getDimension(this._MGGeoLinesId)
        } catch(e) {
            console.error(e)
        }
	}

	/**
	 * 计算两个几何对象间的距离
	 * @memberOf GeoLines 
	 * @param type 距离类型
	 * @param destGeom 第二个几何对象
	 * @return {Promise}距离长度
	 */
	async distance(type, destGeom)
	{
		try{
            return await GLS.distance(this._MGGeoLinesId, type, destGeom._MGGeometryId)
        } catch(e) {
            console.error(e)
        }
	}

	/**
	 * 删除线
	 * @memberOf GeoLines 
	 * @param index 待删除线序号
	 * @return {Promise}删除成功返回1，失败返回0
	 */
	async del(index)
	{
		try{
            return await GLS.del(this._MGGeoLinesId, index)
        } catch(e) {
            console.error(e)
        }
	}

	/**
	 * 取线数目
	 * @memberOf GeoLines 
	 * @return {Promise}线的条数
	 */
	async getNum()
	{
		try{
            return await GLS.getNum(this._MGGeoLinesId)
        } catch(e) {
            console.error(e)
        }
	}

	/**
	 * 添加一条线操作
	 * @memberOf GeoLines 
	 * @param line 待添加的线对象
	 * @return {Promise}添加成功返回1，失败返回0
	 */
	async append(line)
	{
		try{
            return await GLS.append(this._MGGeoLinesId, line._MGGeoLineId);
        } catch(e) {
            console.error(e)
        }
	}

	/**
	 * 更新线
	 * @memberOf GeoLines 
	 * @param index 待更新线的序号
	 * @param line 要更新的线对象
	 * @return {Promise}更新成功返回1，失败返回0
	 */
	async update(index, line)
	{
		try{
            return await GLS.update(this._MGGeoLinesId, index, line._MGGeoLineId);
        } catch(e) {
            console.error(e)
        }
	}

	/**
	 * 取线类型
	 * @memberOf GeoLines 
	 * @param index 待取线的类型
	 * @return {Promise}线类型
	 */
	async getLineType(index)
	{
		try{
            return await GLS.getLineType(this._MGGeoLinesId, index);            
        } catch(e) {
            console.error(e)
        }
	}

	/**
	 * 按序号取一条线
	 * @memberOf GeoLines 
	 * @param index 待取线的序号
	 * @return {Promise<GeoLine>}获取的线对象
	 */
	async getLine(index)
	{
		try{
            var {geoLineId} = await GLS.getLine(this._MGGeoLinesId, index)
            var geoLine = new GeoLine()
            geoLine._MGGeoLineId = geoLineId
            return geoLine
        } catch(e) {
            console.error(e)
        }
	}

	/**
	 * 计算线实地长度
	 * @memberOf GeoLines 
	 * @param sRef 投影系参数
	 * @return {Promise}实地长度
	 */
	async calLength(sRef)
	{
		try{
            return await GLS.calLength(this._MGGeoLinesId, sRef._MGSRefDataId);
        } catch(e) {
            console.error(e)
        }
	}

	/**
	 * 计算线平面长度
	 * @memberOf GeoLines
	 * @return {Promise}平面长度
	 */
	async calLength()
	{
		try{
            return await GLS.calLength(this._MGGeoLinesId);
        } catch(e) {
            console.error(e)
        }
	}
    
}