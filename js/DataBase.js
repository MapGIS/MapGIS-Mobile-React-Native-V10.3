/**
 * @content 数据库对象功能组件
 * @author  2019-09-18
 */
import { NativeModules } from "react-native";

let DB = NativeModules.JSDataBase;

import XClsInfo from "./XClsInfo.js"
import FClsInfo from "./FClsInfo.js"
import AnnClsInfo from "./AnnClsInfo.js"

/**
 * @class DataBase
 * @description 数据库对象
 */
export default class DataBase {

    /**
   * 构造一个新的 DataBase 对象。
   * @memberOf DataBase
   * @returns {Promise.<DataBase>}数据库对象
   */
  async createObj() {
    try{
		alert("DataBase: createObj()" );
        var {DataBaseId} = await DB.createObj();
        var db = new DataBase();
        db._MGDataBaseId = DataBaseId;
        return db;
    }catch(e){
        console.error(e);
    }
  }

  /**
	 * 获取数据库名称
	 * @memberOf DataBase
	 * @return {Promise}数据库名称
	 */
	async getName()
	{
		try {
            return await DB.getName(this._MGDataBaseId); 
        } catch (error) {
            console.error(e);
        }
	}

	/**
	 * 获取数据库全路径
	 * @memberOf DataBase
	 * @return {Promise}数据库名称
	 */
	async getFullName()
	{
		try {
            return await DB.getFullName(this._MGDataBaseId); 
        } catch (error) {
            console.error(e);
        }
	}

	/**
	 * 返回数据库的打开标志
	 * @memberOf DataBase
	 * @return {Promise} 是否打开
	 */
	async hasOpened()
	{
		try {
            return await DB.hasOpened(this._MGDataBaseId); 
        } catch (error) {
            console.error(e);
        }
	}

	/**
	 * 创建数据库
	 * @memberOf DataBase
	 * @param strDatabasePath 数据库文件路径
	 * @return  {Promise} 成功：>0;失败：<=0
	 */
	async create(strDatabasePath)
	{
		try {
            return await DB.create(this._MGDataBaseId, strDatabasePath); 
        } catch (error) {
            console.error(e);
        }
	}

	/**
	 * 关闭数据库
	 * @memberOf DataBase
	 * @return {Promise} 成功：>0;失败：<=0
	 */
	async close()
	{
		try {
            return await DB.close(this._MGDataBaseId); 
        } catch (error) {
            console.error(e);
        }
	}

	/**
	 * 获取数据库内指定类类型的所有类ID
	 * @memberOf DataBase
	 * @param type 类类型
     * @param dsID 要素集ID
	 * @return {Promise<Array>} 所有类ID
	 */
	async getXclseIDs(type, dsID)
	{
		try {
            let clsIDArray = await DB.getXclseIDs(this._MGDataBaseId, type, dsID); 
            return clsIDArray;
        } catch (error) {
            console.error(e);
        }
	}

	/**
	 * 获取类信息
	 * @memberOf DataBase
	 * @param type 类类型
	 * @param clsID 类ID
	 * @return {Promise<XClsInfo>} 类信息
	 */
	async getXclsInfo(type, clsID)
	{
		try {
			let xClsInfo;
			var { XClsInfoId, XClsInfoType} = await DB.getXclsInfo(this._MGDataBaseId, type, clsID); // 获取到要素类信息id，要素类类型		
			switch(XClsInfoType){
				case 1:     // 矢量图层
				xClsInfo = new FClsInfo();
				xClsInfo._MGXClsInfoId = XClsInfoId;
				break;
				case 2:    // 组图层
				xClsInfo = new AnnClsInfo();
				xClsInfo._MGXClsInfoId = XClsInfoId;
				break;
				default:
				break;
        	}     
	    	return xClsInfo;
        } catch (error) {
            console.error(e);
        }
	}

	/**
	 * 获取类名称
	 * @memberOf DataBase
	 * @param type 类类型
	 * @param xclsID 类ID
	 * @return {Promise} 类名称
	 */
	async getXclsName(type, xclsID)
	{
		try {
            return await DB.getXclsName(this._MGDataBaseId, type, xclsID); 
        } catch (error) {
            console.error(e);
        }
	}

	/**
	 * 获取指定类类型的类的数目
	 * @memberOf DataBase
	 * @param type 类类型
	 * @return {Promise} 类的数目
	 */
	async getXclsNum(type, dsID)
	{
		try {
            return await DB.getXclsNum(this._MGDataBaseId, type, dsID); 
        } catch (error) {
            console.error(e);
        }
	}

	/**
	 * 打开数据库
	 * @memberOf DataBase
	 * @param 数据库文件路径
	 * @return {Promise} 成功：>0;失败：<=0
	 */
	async open(strDatabasePath)
	{
		try {
            return await DB.open(this._MGDataBaseId, strDatabasePath); 
        } catch (error) {
            console.error(e);
        }
	}

	/**
	 * 查看指定类类型和类名称的类在数据库中是否存在,如果存在,返回其ID
	 * @memberOf DataBase
	 * @param {number} type 类类型
	 * @param {String} name 类名称
	 * @return {Promise} 成功：类ID;失败：<=0
	 */
	async xClsIsExist(type, name)
	{
		try {
            return await DB.xClsIsExist(this._MGDataBaseId, type, name); 
        } catch (error) {
            console.error(e);
        }
	}
    
    /**
	 * 导入更新包进行数据更新(目前仅支持桌面编辑后的全量图层更新)
	 * @memberOf DataBase
	 * @param strUpdateDatabasePath 更新包全路径
	 * @param name 类名称
	 * @return {Promise<void>}
	 */
	async updateAsync(strUpdateDatabasePath)
	{
		try {
            await DB.updateAsync(this._MGDataBaseId, strUpdateDatabasePath); 
        } catch (error) {
            console.error(e);
        }
	}
}