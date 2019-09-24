/**
 * @content 注记类对象功能组件
 * @author  2019-09-18
 */
import { NativeModules } from "react-native";

import VectorCls from "./VectorCls.js"
import DataBase from "./DataBase.js"
import Rect from "./Rect.js"
import Record from "./Record.js";
import AnnClsInfo from "./AnnClsInfo.js"
import Fields from "./Fields.js"
import RecordSet from "./RecordSet.js"
import GeomInfo from "./GeomInfo.js"
import Geometry from "./Geometry.js"

let ANNCLS = NativeModules.JSAnnotationCls;

/**
 * @class AnnotationCls
 * @description 注记类对象
 */
export default class AnnotationCls extends VectorCls{

	constructor(){
        super()
        Object.defineProperty(this,"_MGAnnotationClsId", {
            get:function(){
                return this. _MGVectorClsId
            },
            set:function(_MGAnnotationClsId){
                this. _MGVectorClsId = _MGAnnotationClsId
            },
        })
	}
	
    /**
   * 构造一个新的 AnnotationCls 对象。
   * @memberOf AnnotationCls
   * @returns {Promise.<AnnotationCls>}注记类对象
   */
  async createObj(db) {
    try{
        var {AnnotationClsId} = await ANNCLS.createObj(db._MGDataBaseId);
        var annotationCls = new AnnotationCls();
        annotationCls._MGAnnotationClsId = AnnotationClsId;
        return annotationCls;
    }catch(e){
        console.error(e);
    }
  }

  /**
	 * 创建注记类
	 * @memberOf AnnotationCls
	 * @param gdb 地理数据库对象
	 * @param name 类对象名称
	 * @param annType 几何形态约束类型
	 * @param dsID 数据集ID
	 * @param srID 空间参考系ID
	 * @param flds 属性结构
	 * @return {Promise}创建类对象ID
	 */			  
	async create(name, annType, dsID, srID, flds)
	{
		try {
            return await ANNCLS.create(this._MGAnnotationClsId, name, annType, dsID, srID, flds._MGFieldsId); 
        } catch (error) {
            console.error(e);
        }
	}

	/**
	 * 打开注记要素类图层
	 * @memberOf AnnotationCls
	 * @param id 图层ID
	 * @return {Promise} 成功：>0;失败：<=0
	 */
	async openByID(id)
	{
		try {
            return await ANNCLS.open(this._MGAnnotationClsId, id); 
        } catch (error) {
            console.error(e);
        }
	}

	/**
	 * 打开注记要素类
	 * @memberOf AnnotationCls
	 * @param name 注记要素类名称
	 * @return {Promise} 成功：类对象ID;失败：<=0
	 */
	async openByName(name)
	{
		try {
            return await ANNCLS.open(this._MGAnnotationClsId, name); 
        } catch (error) {
            console.error(e);
        }
	}

	/**
	 * 是否已经打开
	 * @memberOf AnnotationCls
	 * @return {Promise}  是否打开
	 */
	async hasOpen()
	{
		try {
            return await ANNCLS.hasOpen(this._MGAnnotationClsId); 
        } catch (error) {
            console.error(e);
        }
	}

	/**
	 * 清空类
	 * @memberOf AnnotationCls
	 * @return {Promise} 成功：>0;失败：<=0
	 */
	async clear()
	{
		try {
            return await ANNCLS.clear(this._MGAnnotationClsId); 
        } catch (error) {
            console.error(e);
        }
	}

	/**
	 * 关闭类
     * @memberOf AnnotationCls
     * @return {Promise} 成功：>0;失败：<=0
	 */
	async close()
	{
		try {
            return await ANNCLS.close(this._MGAnnotationClsId); 
        } catch (error) {
            console.error(e);
        }
	}

	/**
	 * 获取地理数据库
     * @memberOf AnnotationCls
     * @return {Promise<DataBase>} 地理数据库对象
	 */
	async getGDataBase()
	{
		try {
            let {dbId} = await ANNCLS.getGDataBase(this._MGAnnotationClsId); 
            var db = new DataBase();
            db._MGDataBaseId = dbId;
            return db;
        } catch (error) {
            console.error(e);
        }
	}
	
	/**
	 * 获取注记类要素数目
     * @memberOf AnnotationCls
     * @return {Promise} 要素数目
	 */
	async getCount()
	{
		try {
            return await ANNCLS.getCount(this._MGAnnotationClsId); 
        } catch (error) {
            console.error(e);
        }
	}

	/**
	 * 获取注记类的矩形范围
     * @memberOf AnnotationCls
     * @return {Promise<Rect>} 矩形范围
	 */
	async getRange()
	{
		try {
            let {rcId} = await ANNCLS.getRange(this._MGAnnotationClsId); 
            var rc = new Rect();
            rc._MGRectId = rcId;
            return rc;
        } catch (error) {
            console.error(e);
        }
	}

	/**
	 * 获取注记类的要素类类型
     * @memberOf AnnotationCls
     * @return {Promise} 要素类类型
	 */
	async getClsType()
	{
		try {
            return await ANNCLS.getClsType(this._MGAnnotationClsId); 
        } catch (error) {
            console.error(e);
        }
	}

	/**
	 * 取当前注记类对应的要素类ID
     * @memberOf AnnotationCls
     * @return {Promise} 要素类ID
	 */
	async getClsID()
	{
		try {
            return await ANNCLS.getClsID(this._MGAnnotationClsId); 
        } catch (error) {
            console.error(e);
        }
	}

	/**
	 * 获取当前注记类的信息
     * @memberOf AnnotationCls
     * @return {Promise<AnnClsInfo>} 注记类的信息
	 */
	async getClsInfo()
	{
		try {
            let {annClsInfoId} =  await ANNCLS.getClsInfo(this._MGAnnotationClsId); 
            var annClsInfo = new AnnClsInfo();
            annClsInfo._MGAnnClsInfoId = annClsInfoId;
            return annClsInfo;
        } catch (error) {
            console.error(e);
        }
	}

	/**
	 * 获取当前注记类的属性结构
     * @memberOf AnnotationCls
     * @return {Promise<Fields>} 属性结构
	 */
	async getFields()
	{
		try {
            let {fieldsId} =  await ANNCLS.getClsInfo(this._MGAnnotationClsId); 
            var fields = new Fields();
            fields._MGFieldsId = fieldsId;
            return fields;
        } catch (error) {
            console.error(e);
        }
	}
	

	/**
	 * 添加对象
	 * @memberOf AnnotationCls
	 * @param geom 对象几何信息
	 * @param rcd 对象属性信息
	 * @param inf 对象的图形信息
	 * @return {Promise} 成功：添加的对象ID；失败:<=0
	 */
	async append(geom, rcd, info) {
		try {
            return await ANNCLS.append(this._MGAnnotationClsId, geom._MGGeometryId, rcd._MGRecordId, info._MGGeomInfoId); 
        } catch (error) {
            console.error(e);
        }
	}
	
	/**
	 * 查询
	 * @memberOf AnnotationCls
	 * @param def 查询条件
	 * @return {Promise<RecordSet>}记录集对象
	 */
	async select(def)
	{
		try {
            let {recordSetId} = await ANNCLS.select(this._MGAnnotationClsId, def._MGQueryDefId); 
            var recordSet = new RecordSet();
            recordSet._MGRecordSetId = recordSetId;
            return recordSet;
        } catch (error) {
            console.error(e);
        }
	}
	
	/**
	 * 取要素矩形范围
	 * @memberOf AnnotationCls
	 * @param objID 对象记录ID
	 * @return {Promise<Rect>}矩形范围
	 */
	async getRect(objID) {
		try {
            let {rectId} = await ANNCLS.getRect(this._MGAnnotationClsId, objID); 
            var rect = new Rect();
            rect._MGRectId = rectId;
            return rect;
        } catch (error) {
            console.error(e);
        }
	}

	/**
	 * 取对象信息
	 * @memberOf AnnotationCls
	 * @param objID 对象记录ID
	 * @param ptGeom 对象几何信息
	 * @param ptRcd 对象属性信息
	 * @param ptInf 对象的图形信息
	 * @return {Promise}成功：>0;失败：<=0
	 */
	async get(objID, geom, rcd, info) {
		try {
            return await ANNCLS.get(this._MGAnnotationClsId, objID, geom._MGGeometryId, rcd._MGRecordId, info._MGGeomInfoId); 
        } catch (error) {
            console.error(e);
        }
	}

	/**
	 * 取对象的属性信息
	 * @memberOf AnnotationCls
	 * @param objID 对象记录ID
	 * @return {Promise<Record>}对象的属性信息
	 */
	async getAtt(objID)
	{
		try {
            let {rcId} = await ANNCLS.getAtt(this._MGAnnotationClsId, objID); 
            var record = new Record();
            record._MGRecordId = rcId;
            return record;
        } catch (error) {
            console.error(e);
        }
	}
	
	/**
	 * 取对象几何信息
	 * @memberOf AnnotationCls
	 * @param objID 对象记录ID
	 * @return {Promise<Geometry>}对象几何信息
	 */
	async getGeometry(objID) {
		try {
            let {geometryId} = await ANNCLS.getGeometry(this._MGAnnotationClsId, objID); 
            var geometry = new Geometry();
            geometry._MGGeometryId = geometryId;
            return geometry;
        } catch (error) {
            console.error(e);
        }
	}

	/**
	 * 获取对象图形信息
	 * @memberOf AnnotationCls
	 * @param objID 对象记录ID
	 * @return {Promise<GeomInfo>}对象图形信息
	 */
	async getInfo(objID) {
		try {
            let {geomInfoId} = await ANNCLS.getInfo(this._MGAnnotationClsId, objID); 
            var geomInfo = new GeomInfo();
            geomInfo._MGGeomInfoId = geomInfoId;
            return geomInfo;
        } catch (error) {
            console.error(e);
        }
	}
	
	/**
	 * 获取要素几何类型
	 * @memberOf AnnotationCls
	 * @param objID 要素ID
	 * @return{Promise}几何类型
	 */
	async getAnnType(objID)
	{
		try {
            return await ANNCLS.getAnnType(this._MGAnnotationClsId, objID); 
        } catch (error) {
            console.error(e);
        }
	}
	
	/**
	 * 获取注记要素类名称
	 * @memberOf AnnotationCls
	 * @return{Promise}类名称
	 */
	async getClsName()
	{
		try {
            return await ANNCLS.getClsName(this._MGAnnotationClsId); 
        } catch (error) {
            console.error(e);
        }
	}

	/**
	 * 设置注记要素类名称
	 * @memberOf AnnotationCls
	 * @param newVal 类名称
	 * @return {Promise<void>}
	 */
	async setClsName(newVal)
	{
		try {
            await ANNCLS.setClsName(this._MGAnnotationClsId, newVal); 
        } catch (error) {
            console.error(e);
        }
	}

	/**
	 * 取类URL
	 * @memberOf AnnotationCls
	 * @return {Promise} URL串
	 */
	async getURL()
	{
		try {
            return await ANNCLS.getURL(this._MGAnnotationClsId); 
        } catch (error) {
            console.error(e);
        }
	}
	
	/**
	 * 取类别名
	 * @memberOf AnnotationCls
	 * @return {Promise}类别名
	 */
	async getAliasName()
	{
		try {
            return await ANNCLS.getAliasName(this._MGAnnotationClsId); 
        } catch (error) {
            console.error(e);
        }
	}

	/**
	 * 设置类别名
	 * @memberOf AnnotationCls
	 * @param newVal 类别名
	 * @return {Promise}成功：>0;失败：<=0
	 */
	async setAliasName(newVal)
	{
		try {
            return await ANNCLS.setAliasName(this._MGAnnotationClsId, newVal); 
        } catch (error) {
            console.error(e);
        }
	}

	/**
	 * 取空间参考系ID
	 * @memberOf AnnotationCls
	 * @return {Promise}空间参考系ID
	 */
	async getSrID()
	{
		try {
            return await ANNCLS.getSrID(this._MGAnnotationClsId); 
        } catch (error) {
            console.error(e);
        }
	}

	/**
	 * 设置要素数据集ID
	 * @memberOf AnnotationCls
	 * @param newVal 要素数据集ID
	 * @return {Promise}成功：>0;失败：<=0
	 */
	async setSrID(newVal)
	{
		try {
            return await ANNCLS.setSrID(this._MGAnnotationClsId, newVal); 
        } catch (error) {
            console.error(e);
        }
	}

	/**
	 * 获取X方向符号比 
	 * @memberOf AnnotationCls
	 * @return {Promise} X方向符号比 
	 */
	async getScaleX()
	{
		try {
            return await ANNCLS.getScaleX(this._MGAnnotationClsId); 
        } catch (error) {
            console.error(e);
        }
	}

	/**
	 * 获取Y方向符号比
	 * @memberOf AnnotationCls
	 * @return {Promise} Y方向符号比
	 */
	async getScaleY()
	{
		try {
            return await ANNCLS.getScaleY(this._MGAnnotationClsId); 
        } catch (error) {
            console.error(e);
        }
	}

	/**
	 * 设置X,Y方向符号比
	 * @memberOf AnnotationCls
	 * @param scale 符号比
	 * @return {Promise} 成功：>0;失败：<=0
	 */
	async setScaleXY(scaleX, scaleY) {
		try {
            return await ANNCLS.setScaleXY(this._MGAnnotationClsId, scaleX, scaleY); 
        } catch (error) {
            console.error(e);
        }
	}
	
	/**
	 * 删除一个注记要素类
	 * @memberOf AnnotationCls
	 * @param objID 注记要素类ID
	 * @return {Promise} 成功：>0;失败：<=0
	 */
	async deleteByID(objID)
	{
		try {
            return await ANNCLS.delete(this._MGAnnotationClsId, objID); 
        } catch (error) {
            console.error(e);
        }
	}

	/**
	 * 删除一组注记要素类
	 * @memberOf AnnotationCls
	 * @param objIDs 一组注记要素类ID
	 * @return {Promise} 成功：>0;失败：<=0
	 */
	async deleteByIDs(objIDArray)
	{
		try {
            return await ANNCLS.delete(this._MGAnnotationClsId, objIDArray); 
        } catch (error) {
            console.error(e);
        }
	}

	/**
	 * 更新对象
	 * @memberOf AnnotationCls
	 * @param objID 对象记录ID
	 * @param geom 对象几何信息
	 * @param rcd 对象属性信息
	 * @param inf 对象的图形信息
	 * @return {Promise} 成功：>0;失败：<=0
	 */
	async update(objID, geom, rcd, info) {
		try {
            return await ANNCLS.update(this._MGAnnotationClsId, objID, geom._MGGeometryId, rcd._MGRecordId, info._MGGeomInfoId); 
        } catch (error) {
            console.error(e);
        }
	}

	/**
	 * 更新对象的属性
	 * @memberOf AnnotationCls
	 * @param objID 对象记录ID
	 * @param rcd 对象属性信息
	 * @return {Promise} 成功：>0;失败：<=0
	 */
	async updateAtt(objID, rcd) {
		try {
            return await ANNCLS.updateAtt(this._MGAnnotationClsId, objID, rcd._MGRecordId); 
        } catch (error) {
            console.error(e);
        }
	}

	/**
	 * 更新几何图形信息
	 * @memberOf AnnotationCls
	 * @param objID 对象记录ID
	 * @param geom 几何对象
	 * @return {Promise} 成功：>0;失败：<=0
	 */
	async updateGeometry(objID, geom) {
		try {
            return await ANNCLS.updateAtt(this._MGAnnotationClsId, objID, geom._MGGeometryId); 
        } catch (error) {
            console.error(e);
        }
	}

	/**
	 * 更新对象图形信息
	 * @memberOf AnnotationCls
	 * @param objID 对象记录ID
	 * @param inf 对象的图形信息
	 * @return {Promise} 成功：>0;失败：<=0
	 */
	async updateInfo(objID, info) {
		try {
            return await ANNCLS.updateAtt(this._MGAnnotationClsId, objID, info._MGGeomInfoId); 
        } catch (error) {
            console.error(e);
        }
	}
	/**
	 * 保存注记文本到属性
	 * @memberOf AnnotationCls
	 * @param fldIndex 属性序号
	 * @param whereClause 注记文本
	 * @return {Promise} 成功：>0；失败:<=0
	 */
	async annToField(fldIndex, whereClause)
	{
		try {
            return await ANNCLS.annToField(this._MGAnnotationClsId, fldIndex, whereClause); 
        } catch (error) {
            console.error(e);
        }
	}

	/**
	 * 根据注记要素类名删除类
	 * @memberOf AnnotationCls
	 * @param db 地理数据库对象
	 * @param clsName 类名
	 * @return {Promise} 成功：>0;失败：<=0
	 */
	async removeByName(db, clsName)
	{
		try {
            return await ANNCLS.remove(this._MGAnnotationClsId, db._MGDataBaseId, clsName); 
        } catch (error) {
            console.error(e);
        }
	}

	/**
	 * 根据注记要素类ID删除类
	 * @memberOf AnnotationCls
	 * @param db 地理数据库对象
	 * @param clsID 类ID
	 * @return {Promise} 成功：>0;失败：<=0
	 */
	async removeByID(db, clsID)
	{
		try {
            return await ANNCLS.remove(this._MGAnnotationClsId, db._MGDataBaseId, clsID); 
        } catch (error) {
            console.error(e);
        }
	}
	
	/**
	 * 注册同步能力
	 * @memberOf AnnotationCls
	 * @return {Promise} 成功：>0;失败：<=0
	 */
	async registerSyncEnabled()
	{
		try {
            return await ANNCLS.registerSyncEnabled(this._MGAnnotationClsId); 
        } catch (error) {
            console.error(e);
        }
	}

	/**
	 * 是否具有同步能力
	 * @memberOf AnnotationCls
	 * @return {Promise} 是否具有同步能力
	 */
	async isSyncEnabled()
	{
		try {
            return await ANNCLS.isSyncEnabled(this._MGAnnotationClsId); 
        } catch (error) {
            console.error(e);
        }
	}

	/**
	 * 更新注记要素类类
	 * @memberOf AnnotationCls
	 * @param fields 属性信息
	 * @return {Promise} 成功：>0;失败：<=0
	 */
	async updateFields(fields) {
		
		try {
            return await ANNCLS.updateFields(this._MGAnnotationClsId, fields._MGFieldsId); 
        } catch (error) {
            console.error(e);
        }
	}
}