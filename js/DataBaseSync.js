/**
 * @content 数据库同步编辑功能组件
 * @author  2019-09-25
 */
import { NativeModules } from 'react-native';

let DBSC = NativeModules.JSDataBaseSync;

import SyncBase from './SyncBase.js';
import DownloadDataBaseParmeters from './DownloadDataBaseParmeters.js';
import SyncDataBaseParmeters from './SyncDataBaseParmeters.js';
import MapServiceInfo from './MapServiceInfo.js';

/**
 * @class DataBaseSync
 * @description 数据库同步编辑
 */
export default class DataBaseSync extends SyncBase {
  // constructor(){
  //     super()
  //     Object.defineProperty(this,"_MGDataBaseSyncId", {
  //         get:function(){
  //             return this._MGSyncBaseId
  //         },
  //         set:function(_MGDataBaseSyncId){
  //             this._MGSyncBaseId = _MGDataBaseSyncId
  //         },
  //     })
  // }

  /**
   * 构造一个新的 DataBaseSync 对象。
   * @memberOf DataBaseSync
   * @returns {Promise.<DataBaseSync>}
   */
  //   async createObj() {
  //     try{
  //         var {DataBaseSyncId} = await DBSC.createObj();
  //         var dataBaseSync = new DataBaseSync();
  //         dataBaseSync._MGDataBaseSyncId = DataBaseSyncId;
  //         return dataBaseSync;
  //     }catch(e){
  //         console.error(e);
  //     }
  //   }

  /**
   * 创建默认的下载数据参数
   * @memberOf DataBaseSync
   * @param {String} strIGServerBaseURL 地图服务基地址
   * @param {String} strDocName 地图文档名称
   * @param {int} mapID 地图ID
   * @param {Rect} extents 范围
   * @returns {Promise.<DownloadDataBaseParmeters>} 下载数据参数
   */
  static async createDefaultDownloadDataBaseParmeters(
    strIGServerBaseURL,
    strDocName,
    mapID,
    extent
  ) {
    try {
      let {
        DownloadDataBaseParmetersId,
      } = await DBSC.createDefaultDownloadDataBaseParmeters(
        strIGServerBaseURL,
        strDocName,
        mapID,
        extent._MGRectId
      );
      var parmeters = new DownloadDataBaseParmeters();
      parmeters._MGDownloadDataBaseParmetersId = DownloadDataBaseParmetersId;
      return parmeters;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 创建同步的下载数据参数
   * @memberOf DataBaseSync
   * @param {DataBase} database 数据库对象
   * @returns {Promise.<SyncDataBaseParmeters>} 同步的下载数据参数
   */
  static async createDefaultSyncDataBaseParmeters(database) {
    try {
      let {
        SyncDataBaseParmetersId,
      } = await DBSC.createDefaultSyncDataBaseParmeters(database._MGDataBaseId);
      var parmeters = new SyncDataBaseParmeters();
      parmeters._MGSyncDataBaseParmetersId = SyncDataBaseParmetersId;
      return parmeters;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取地图服务信息
   * @memberOf DataBaseSync
   * @param {String} strIGServerBaseURL 地图服务基地址
   * @param {String} strDocName 地图文档名称
   * @param {int} mapIDs 地图ID
   * @returns {Promise.<MapServiceInfo>} 地图服务信息
   */
  static async getMapServiceInfo(strIGServerBaseURL, strDocName, mapID) {
    try {
      let { MapServiceInfoId } = await DBSC.getMapServiceInfo(
        strIGServerBaseURL,
        strDocName,
        mapID
      );
      var mapServiceInfo = new MapServiceInfo();
      mapServiceInfo._MGMapServiceInfoId = MapServiceInfoId;
      return mapServiceInfo;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 地图下载
   * @memberOf DataBaseSync
   * @param {String} strIGServerBaseURL 地图服务基地址
   * @param {String} strDocName 地图文档名称
   * @param {int} mapID 地图ID
   * @param {DownloadDataBaseParmeters} params 异步参数
   * @param {String} strPath 全名
   * @returns {Promise.<int>} 下载同步编号
   */
  static async downloadASync(
    strIGServerBaseURL,
    strDocName,
    mapID,
    params,
    strPath
  ) {
    try {
      return await DBSC.downloadASync(
        strIGServerBaseURL,
        strDocName,
        mapID,
        params._MGDownloadDataBaseParmetersId,
        strPath
      );
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 更新数据库
   * @memberOf DataBaseSync
   * @param {SyncDataBaseParmeters} params 异步参数
   * @param {DataBase} database 数据库
   * @returns {Promise.<int>} 更新同步编号
   */
  static async updateASync(params, database) {
    try {
      return await DBSC.updateASync(
        params._MGSyncDataBaseParmetersId,
        database._MGDataBaseId
      );
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 提交更新(异步执行)
   * @memberOf DataBaseSync
   * @param {SyncDataBaseParmeters} params 异步参数
   * @param {DataBase} database 数据库
   * @returns {Promise.<int>} 提交同步编号
   */
  static async commitASync(params, database) {
    try {
      return await DBSC.commitASync(
        params._MGSyncDataBaseParmetersId,
        database._MGDataBaseId
      );
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 停止同步
   * @memberOf DataBaseSync
   * @param {int} lSyncCode  同步编号
   * @return  {Promise.<int>} >0 成功; <=0 失败
   */
  static async stopASync(lSyncCode) {
    try {
      return await DBSC.stopASync(lSyncCode);
    } catch (e) {
      console.error(e);
    }
  }
}
