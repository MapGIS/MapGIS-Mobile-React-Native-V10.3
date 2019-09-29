/**
 * @content 记录集功能组件
 * @author  2019-09-16
 */
import { NativeModules } from 'react-native';

let RS = NativeModules.JSRecordSet;

import Record from './Record.js';
import Fields from './Fields.js';
import Geometry from './Geometry.js';
import GeomInfo from './GeomInfo.js';

/**
 * @class RecordSet
 * @description 扩展字段头
 */
export default class RecordSet {
  /**
   * 构造一个新的 RecordSet 对象。
   * @memberOf RecordSet
   * @returns {Promise.<RecordSet>} RecordSet 对象
   */
  async createObj() {
    try {
      var { RecordSetId } = await RS.createObj();
      var recordSet = new RecordSet();
      recordSet._MGRecordSetId = RecordSetId;
      return recordSet;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 光标移到最前
   * @memberOf RecordSet
   * @return {Promise} 光标位置 成功:>0;失败：<=0
   */
  async moveFirst() {
    try {
      return await RS.moveFirst(this._MGRecordSetId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 光标移到下一条
   * @memberOf RecordSet
   * @return {Promise} 光标位置 成功:>0;失败：<=0
   */
  async moveNext() {
    try {
      return await RS.moveNext(this._MGRecordSetId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取属性
   * @memberOf RecordSet
   * @return {Promise.<Record>} 属性信息
   */
  async getAtt() {
    try {
      let { RecordId } = await RS.getAtt(this._MGRecordSetId);
      var record = new Record();
      record._MGRecordId = RecordId;
      return record;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取当前记录ID
   * @memberOf RecordSet
   * @return {Promise} 当前记录ID
   */
  async getCurrentID() {
    try {
      return await RS.getCurrentID(this._MGRecordSetId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取属性结构
   * @memberOf RecordSet
   * @return {Promise.<Fields>} 属性结构
   */
  async getFields() {
    try {
      let { FieldsId } = await RS.getFields(this._MGRecordSetId);
      var fields = new Fields();
      fields._MGFieldsId = FieldsId;
      return fields;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取几何
   * @memberOf RecordSet
   * @return {Promise.<Geometry>} 几何
   */
  async getGeometry() {
    try {
      let { GeometryId } = await RS.getGeometry(this._MGRecordSetId);
      var geometry = new Geometry();
      geometry._MGGeometryId = GeometryId;
      return geometry;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取几何图形参数
   * @memberOf RecordSet
   * @return {Promise.<GeomInfo>} 图形参数
   */
  async getInfo() {
    try {
      let { GeomInfoId } = await RS.getInfo(this._MGRecordSetId);
      var geomInfo = new GeomInfo();
      geomInfo._MGGeomInfoId = GeomInfoId;
      return geomInfo;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 判断当前记录的位置是否在记录集中第一条记录的前面（当然第一条记录的前面是没有数据的），如果是返回 true；否则返回 false。
   * @memberOf RecordSet
   * @return {Promise<Bool>} 当前记录是否在第一条记录的前面
   */
  async isBOF() {
    try {
      return await RS.isBOF(this._MGRecordSetId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 判断当前记录的位置是否在记录集中的最后一条记录的后面，如果是，返回 true；否则返回 false。
   * @memberOf RecordSet
   * @return {Promise<Bool>}当前记录是否在最后一条记录的后面
   */
  async isEOF() {
    try {
      return await RS.isEOF(this._MGRecordSetId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 取要素矩形范围
   * @memberOf RecordSet
   * @param rc 矩形范围对象
   * @return {Promise<void>}
   */
  async getRect(rc) {
    try {
      await RS.getRect(this._MGRecordSetId, rc._MGRectId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 取对象信息
   * @memberOf RecordSet
   * @param geom 对象几何信息
   * @param rcd 对象属性信息
   * @param info 对象的图形信息
   * @return {Promise}成功：>0;失败：<=0
   */
  async get(geom, rcd, info) {
    try {
      return await RS.get(
        this._MGRecordSetId,
        geom._MGGeometryId,
        rcd._MGRecordId,
        info._MGGeomInfoId
      );
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 取几何类型或注记类型
   * @memberOf RecordSet
   * @return 几何类型或注记类型
   */
  async getGeometryType() {
    try {
      return await RS.getGeometryType(this._MGRecordSetId);
    } catch (e) {
      console.error(e);
    }
  }
}
