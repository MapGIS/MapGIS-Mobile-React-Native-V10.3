/**
 * @content 字段功能组件
 * @author  2019-09-16
 */
import { NativeModules } from "react-native";

let FLDS = NativeModules.JSFields;

import Field from "./Field.js"

/**
 * @class Fields
 * @description 扩展字段头
 */
export default class Fields {

    /**
   * 构造一个新的 Fields 对象。
   * @memberOf Fields
   * @returns {Promise.<Fields>}
   */
  async createObj() {
    try{
        var {fieldsId} = await FLDS.createObj()
        var fields = new Fields()
        fields._MGFieldsId = fieldsId
        return fields
    } catch(e) {
        console.error(e)
    }
  }

  /**
	 * 根据索引取字段
	 * @memberOf Fields
	 * @param index 索引
	 * @return {Promise.<Field>}字段对象
	 */
	async getField(index)
	{
		try {
            let {FieldsId} =  await FLDS.getField(this._MGFieldsId, index);
            var  field = new Field();
            field._MGFieldId = FieldsId;
            return field;            
          } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 设置索引处的字段
	 * @memberOf Fields
	 * @param index 索引
	 * @param field 字段对象
	 * @return {Promise.<void>}大于0成功，否则失败
	 */
	async setField(index, field)
	{
		try {
            await FLDS.setField(this._MGFieldsId, index, field._MGFieldId);
          } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 追加字段
	 * @memberOf Fields
	 * @param field 字段对象
	 * @return {Promise}大于0成功，否则失败
	 */
	async appendField(field)
	{
		try {
            return await FLDS.appendField(this._MGFieldsId, field._MGFieldId);
          } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 插入字段
	 * @memberOf Fields
	 * @param position 位置
	 * @param field 字段对象
	 * @return {Promise}大于0成功，否则失败
	 */
	async insertField(position, field)
	{
		try {
            return await FLDS.insertField(this._MGFieldsId, position, field._MGFieldId);
          } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 根据字段名删除字段
	 * @memberOf Fields
	 * @param fldName 字段名
	 * @return {Promise}大于0成功，否则失败
	 */
	async deleteField(fldName)
	{
		try {
            return await FLDS.deleteField(this._MGFieldsId, fldName);
          } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 根据字段序号删除字段
	 * @memberOf Fields
	 * @param index 字段序号
	 * @return {Promise}大于0成功，否则失败
	 */
	async deleteField(index)
	{
		try {
            return await FLDS.deleteField(this._MGFieldsId, index);
          } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 取字段数目
	 * @memberOf Fields
	 * @return {Promise}字段数目
	 */
	async getFieldCount()
	{
		try {
            return await FLDS.getFieldCount(this._MGFieldsId);
          } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 计算各字段的二进制长度,字段偏移
	 * @memberOf Fields
	 * @return {Promise}长度偏移值
	 */
	async calLengthOffset()
	{
		try {
            return await FLDS.calLengthOffset(this._MGFieldsId);
          } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 计算属性结构占用存储空间大小
	 * @memberOf Fields
	 * @return {Promise}占用存储空间大小
	 */
	async calSize()
	{
		try {
            return await FLDS.calSize(this._MGFieldsId);
          } catch (e) {
            console.error(e);
        }
	}
}