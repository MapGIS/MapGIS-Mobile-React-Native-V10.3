/**
 * @content 记录功能组件
 * @author  2019-09-16
 */
import { NativeModules } from 'react-native';

let RD = NativeModules.JSRecord;

import Fields from './Fields.js';

/**
 * @class Record
 * @description 记录
 */
export default class Record {
  /**
   * 构造一个新的 Record 对象。
   * @memberOf Record
   * @returns {Promise.<Record>}
   */
  async createObj() {
    try {
      var { RecordId } = await RD.createObj();
      var record = new Record();
      record._MGRecordId = RecordId;
      return record;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 根据字段索引取字段值
   * @memberOf Record
   * @param fldIndex 字段索引
   * @return {Promise<Field>}字段值
   */
  async getFldValByIndex(fldIndex) {
    try {
      let { value } = await RD.getFldValByIndex(this._MGRecordId, fldIndex);
      return value;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 根据字段名取字段值
   * @memberOf Record
   * @param fldName 字段名
   * @return {Promise<string>}字段值
   */
  async getFldValByName(fldName) {
    try {
      var { value } = await RD.getFldValByName(this._MGRecordId, fldName);
      return value;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 根据字段索引设置字段值
   * @memberOf Record
   * @param fldIndex 字段索引
   * @param newVal 字段值
   * @return {Promise<Number>}大于0成功，否则失败
   */
  async setFldValByIndex(fldIndex, newVal) {
    try {
      return await RD.setFldVal(this._MGRecordId, fldIndex, newVal);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 根据字段名设置字段值
   * @memberOf Record
   * @param fldName 字段名
   * @param newVal 字段值
   * @return {Promise<Number>}大于0成功，否则失败
   */
  async setFldValByName(fldName, newVal) {
    try {
      return await RD.setFldVal(this._MGRecordId, fldName, newVal);
    } catch (e) {
      console.error(e);
    }
  }
	/**
	 * 将字符串设置为字段值
	 * @memberOf Record
	 * @param fldIndex 字段索引
	 * @param newVal 字符串值
	 * @return {Promise<Number>}大于0成功，否则失败
	 */
	async setFldFromStrOfIndex(fldIndex, newVal)
	{
		try {
            return await RD.setFldFromStrOfIndex(this._MGRecordId, fldIndex, newVal);
          } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 将字符串设置为字段值
	 * @memberOf Record
	 * @param fldName 字段名
	 * @param newVal 字符串值
	 * @return {Promise<Number>}大于0成功，否则失败
	 */
	async setFldFromStrOfName(fldName, newVal)
	{
		try {
            return await RD.setFldFromStrOfName(this._MGRecordId, fldName, newVal);
          } catch (e) {
            console.error(e);
        }
	}

  /**
   * 判断字段值是否为NULL
   * @memberOf Record
   * @param fldIndex 字段索引
   * @return {Promise<Number>}非0/0 ：是/否
   */
  async isFldNULLOfFldIndex(fldIndex) {
    try {
      return await RD.isFldNULL(this._MGRecordId, fldIndex);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 判断字段值是否为NULL
   * @memberOf Record
   * @param fldName 字段名
   * @return {Promise<Number>}非0/0 ：是/否
   */
  async isFldNULLOfFldName(fldName) {
    try {
      return await RD.isFldNULL(this._MGRecordId, fldName);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置字段值为NULL
   * @memberOf Record
   * @param fldIndex 字段索引
   * @return {Promise<Number>}大于0成功，否则失败
   */
  async setFldNULLByIndex(fldIndex) {
    try {
      return await RD.setFldNULL(this._MGRecordId, fldIndex);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置字段值为NULL
   * @memberOf Record
   * @param fldName 字段名
   * @return {Promise<Number>}大于0成功，否则失败
   */
  async setFldNULLByName(fldName) {
    try {
      return await RD.setFldNULL(this._MGRecordId, fldName);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置所有字段值为NULL
   * @memberOf Record
   * @return {Promise<Number>}大于0成功，否则失败
   */
  async setAllFldNULL() {
    try {
      return await RD.setAllFldNULL(this._MGRecordId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取字段类型
   * @memberOf Record
   * @param fldIndex 字段索引
   * @return {Promise<Number>}字段类型
   */
  async getFieldTypeByIndex(fldIndex) {
    try {
      return await RD.getFieldType(this._MGRecordId, fldIndex);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取字段类型
   * @memberOf Record
   * @param fldName 字段名
   * @return {Promise<Number>}字段类型
   */
  async getFieldTypeByName(fldName) {
    try {
      return await RD.getFieldType(this._MGRecordId, fldName);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取属性结构
   * @memberOf Record
   * @return {Promise<Fields>}Fields对象
   */
  async getFields() {
    try {
      let { FieldsId } = await RD.getFields(this._MGRecordId);
      var fields = new Fields();
      fields._MGFieldsId = FieldsId;
      return fields;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置属性结构
   * @memberOf Record
   * @param Flds Fields对象
   * @return {Promise<Number>}大于0成功，否则失败
   */
  async setFields(Flds) {
    try {
      return await RD.setFields(this._MGRecordId, Flds._MGFieldsId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 释放缓冲区 如果调用SetFldValue设置Blob或者Binary类型的字段值，则必须调用该函数释放内存空间
   * @memberOf Record
   * @return  {Promise<void>}
   */
  async releaseBuffer() {
    try {
      await RD.releaseBuffer(this._MGRecordId);
    } catch (e) {
      console.error(e);
    }
  }
}
