/**
 * @content 用于对多点的几何功能组件
 * @author  2019-09-09 
 */
import { NativeModules } from "react-native";

let GP = NativeModules.JSGeoPoints;

import GeometryExp from "./GeometryExp.js"
import Dot3D from "./Dot3D.js"

/**
 * @class GeoPoints
 */
export default class GeoPoints extends GeometryExp {
    constructor(){
        super()
        Object.defineProperty(this,"_MGGeoPointsId", {
            get:function(){
                return this._MGGeometryId
            },
            set:function(_MGGeoPointsId){
                this._MGGeometryId = _MGGeoPointsId
            },
        })
    }
    
    /**
	 * 构造一个新的 GeoPoints 对象
	 * @memberOf GeoPoints
	 * @return {Promise<GeoPoints>}
	 */
    async createObj(){
        try{
            var {geoPointsId} = await GP.createObj()
            var geoPoints = new GeoPoints()
            geoPoints._MGGeoPointsId = geoPointsId
            return geoPoints
        } catch(e) {
            console.error(e)
        }
    }

    /**
	 * 获取几何对象的类型
	 * @memberOf GeoPoints
	 * @return {Promise} 几何对象类型
	 */
	async getType()
	{
		try{
            return await GP.getType(this._MGGeoPointsId)
        } catch(e) {
            console.error(e)
        }
	}

	/**
	 * 取几何维数
	 * @memberOf GeoPoints
	 * @return {Promise}几何维数
	 */
	async getDimension()
	{
		try{
            return await GP.getDimension(this._MGGeoPointsId)
        } catch(e) {
            console.error(e)
        }
	}

	/**
	 * 计算两个几何对象间的距离
	 * @memberOf GeoPoints
	 * @param type 距离计算方法
	 * @param destGeom 第二个几何对象
	 * @return {Promise} 距离长度
	 */
	async distance(type, destGeom)
	{
		try{
            return await GP.getDimension(this._MGGeoPointsId, type, destGeom._MGGeometryId)
        } catch(e) {
            console.error(e)
        }
	}

	/**
	 * 添加3维点
	 * @memberOf GeoPoints
	 * @param dot 三维点坐标
	 * @return {Promise} 添加成功返回1，失败返回0
	 */
	async append(dot3D)
	{
		try{
            return await GP.append(this._MGGeoPointsId, dot3D._MGDot3DId)
        } catch(e) {
            console.error(e)
        }
	}

	/**
	 * 删除指定的某个3维点
	 * @memberOf GeoPoints
	 * @param index 指定的点序列
	 * @return {Promise} 删除成功返回1，失败返回0
	 */
	async del(index)
	{
		try{
            return await GP.del(this._MGGeoPointsId, index)
        } catch(e) {
            console.error(e)
        }
	}

	/**
	 * 取指定的3维点
	 * @memberOf GeoPoints
	 * @param index 指定的点序列
	 * @return {Promise<Dot3D>}获取到的三维点坐标
	 */
	async get(index)
	{
		try{
            let {dot3DId} = await GP.get(this._MGGeoPointsId, index)
            var dot3D = new Dot3D();
            dot3D._MGDot3DId = dot3DId;
            return dot3D;
        } catch(e) {
            console.error(e)
        }
	}

	/**
	 * 取点的总个数
	 * @memberOf GeoPoints
	 * @return {Promise} 点的总个数
	 */
	async getDotNum()
	{
		try{
            return await GP.getDotNum(this._MGGeoPointsId)
        } catch(e) {
            console.error(e)
        }
	}

	/**
	 * 取3维点序列
	 * @memberOf GeoPoints
	 * @return {Promise<Dots3D>}整个三维点序列
	 */
	async getDots()
	{
		try{
            let {dots3DId} = await GP.get(this._MGGeoPointsId)
            var dots3D = new Dots3D();
            dots3D._MGDots3DId = dots3DId;
            return dots3D;
        } catch(e) {
            console.error(e)
        }
	}

	/**
	 * 设置3维点序列
	 * @memberOf GeoPoints
	 * @param dots 待设置的三维点序列
	 * @return {Promise} 设置成功返回1，失败返回0
	 */
	async setDots(dots3D)
	{
		try{
            return await GP.setDots(this._MGGeoPointsId, dots3D._MGDots3DId)
        } catch(e) {
            console.error(e)
        }
	}

}