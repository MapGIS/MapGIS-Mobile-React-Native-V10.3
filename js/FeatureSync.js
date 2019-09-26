/**
 * @content 要素同步编辑功能组件
 * @author  2019-09-25
 */
import { NativeModules } from "react-native";

let FSC = NativeModules.JSFeatureSync;

import SyncBase from "./SyncBase.js"

/**
 * @class FeatureSync
 * @description 要素同步编辑
 */
export default class FeatureSync extends SyncBase{

    // constructor(){
    //     super()
    //     Object.defineProperty(this,"_MGFeatureSyncId", {
    //         get:function(){
    //             return this._MGSyncBaseId
    //         },
    //         set:function(_MGFeatureSyncId){
    //             this._MGSyncBaseId = _MGFeatureSyncId
    //         },
    //     })
    // }

    /**
	 * 指定范围下载异步执行
	 * @memberOf FeatureSync
	 * @param {String} strIGServerBaseURL 地图服务基地址
	 * @param {String} strDataURL 数据地址
	 * @param {Rect} extent 范围
	 * @param {String} whereClause 属性条件
	 * @param {DataBase} database 数据库对象
	 * @param {XClsType} clsType 要素类类型
	 * @param {String} clsName 类名
	 * @return {Promise.<int>} 下载同步编号
	 */
	static async downloadASync(strIGServerBaseURL, strDataURL, extent, whereClause, database, clsType, clsName)
	{
		try {
            return await FSC.downloadASync(strIGServerBaseURL, strDataURL, extent._MGRectId, whereClause, database._MGDataBaseId, clsType, clsName); 
        } catch (error) {
            console.error(e);
        }
	}

	/**
	 * 指定范围下载异步执行
	 * @memberOf FeatureSync
	 * @param {String} strIGServerBaseURL 地图服务基地址
	 * @param {String} strDocName 地图文档名
	 * @param {int} mapID 地图ID
	 * @param {int} layerID 图层 ID
	 * @param {Rect} extent 范围
	 * @param {String} whereClause 属性条件
	 * @param {DataBase} database 数据库对象
	 * @param {XClsType} clsType 要素类类型
	 * @param {String} clsName 类名
	 * @return {Promise.<int>} 下载同步编号
	 */
	static async downloadASync(strIGServerBaseURL, strDocName, mapID, layerID, extent, whereClause, database, clsType, clsName)
	{
		try {
            return await FSC.downloadASync(strIGServerBaseURL, strDocName, mapID, layerID, extent._MGRectId, whereClause, database._MGDataBaseId, clsType, clsName); 
        } catch (error) {
            console.error(e);
        }
	}

	/**
	 * 全图下载异步执行
	 * @memberOf FeatureSync
	 * @param {String} strIGServerBaseURL 地图服务基地址
	 * @param {String} strDataURL 数据地址
	 * @param {DataBase} database 数据库对象
	 * @param {XClsType} clsType 要素类类型
	 * @param {String} clsName 类名
	 * @return {Promise.<int>} 下载同步编号
	 */
	static async downloadAllASync(strIGServerBaseURL, strDataURL, database, clsType, clsName)
	{
		try {
            return await FSC.downloadAllASync(strIGServerBaseURL, strDataURL, database._MGDataBaseId, clsType, clsName); 
        } catch (error) {
            console.error(e);
        }
	}

	/**
	 * 全图下载异步执行
	 * @memberOf FeatureSync
	 * @param {String} strIGServerBaseURL 地图服务基地址
	 * @param {String} strDocName 地图文档名
	 * @param {int} mapID 地图ID
	 * @param {int} layerID 图层 ID
	 * @param {DataBase} database 数据库对象
	 * @param {XClsType} clsType 要素类类型
	 * @param {String} clsName 类名
	 * @return {Promise.<int>} 下载同步编号
	 */
	static async downloadAllASync(strIGServerBaseURL, strDocName, mapID, layerID, database, clsType, clsName)
	{
		try {
            return await FSC.downloadAllASync(strIGServerBaseURL, strDocName, mapID, layerID, database._MGDataBaseId, clsType, clsName); 
        } catch (error) {
            console.error(e);
        }
	}

	/**
	 * 更新异步执行
	 * @memberOf FeatureSync
	 * @param {IVectorCls} cls 矢量类对象
	 * @return {Promise.<int>} 更新同步编号
	 */
	static async updateASync(cls)
	{
		try {
            return await FSC.updateASync(cls); 
        } catch (error) {
            console.error(e);
        }
	}

	/**
	 * 提交异步执行
	 * @memberOf FeatureSync
	 * @param {IVectorCls} cls 矢量类对象
	 * @return {Promise.<int>} 提交同步编号
	 */
	static async commitASync(cls)
	{
		try {
            return await FSC.commitASync(cls); 
        } catch (error) {
            console.error(e);
        }
	}

	/**
	 * 捆绑
	 * @memberOf FeatureSync
	 * @param {IVectorCls} cls 矢量类对象
	 * @param {String} strIGServerBaseURL 地图服务基地址
	 * @param {String} strDocName 地图文档名
	 * @param {int} mapID 地图ID
	 * @param {int} layerID 图层 ID
	 * @return {Promise.<int>} 成功:>0;失败：<=0
	 */
	static async bind(cls, strIGServerBaseURL, strDocName, mapID, layerID)
	{
		try {
            return await FSC.bind(cls, strIGServerBaseURL, strDocName, mapID, layerID); 
        } catch (error) {
            console.error(e);
        }
	}
	
	/**
	 * 捆绑
	 * @memberOf FeatureSync
	 * @param {IVectorCls} cls 矢量类对象
	 * @param {String} strIGServerBaseURL 地图服务基地址
	 * @param {String} strDataURL 数据地址
	 * @return {Promise.<int>} 成功:>0;失败：<=0
	 */
	static async bind(cls, strIGServerBaseURL, strDataURL)
	{
		try {
            return await FSC.bind(cls, strIGServerBaseURL, strDataURL); 
        } catch (error) {
            console.error(e);
        }
	}

	/**
	 * 停止同步
	 * @memberOf FeatureSync
	 * @param {int} lSyncCode  同步编号
	 * @return  {Promise.<int>} >0 成功; <=0 失败
	 */
	static async stopASync(lSyncCode)
	{
		try {
            return await FSC.stopASync(lSyncCode); 
        } catch (error) {
            console.error(e);
        }
	}
}