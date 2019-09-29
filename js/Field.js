/**
 * @content 字段功能组件
 * @author  2019-09-16
 */
import { NativeModules } from 'react-native';

let FLD = NativeModules.JSField;

import ExtField from './ExtField.js';

/**
 * @class Field
 * @description 字段
 */
export default class Field {
  /**
   * 构造一个新的 Field 对象。
   * @memberOf Field
   * @returns {Promise.<Field>}
   */
  async createObj() {
    try {
      var { FieldId } = await FLD.createObj();
      var field = new Field();
      field._MGFieldId = FieldId;
      return field;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取字段名称
   * @memberOf Field
   * @return {Promise}字段名称
   */
  async getFieldName() {
    try {
      return await FLD.getFieldName(this._MGFieldId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置字段名称
   * @memberOf Field
   * @param name 字段名称
   * @return {Promise<void>}
   */
  async setFieldName(name) {
    try {
      await FLD.setFieldName(this._MGFieldId, name);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取字段类型
   * @memberOf Field
   * @return {Promise}字段类型
   */
  async getFieldType() {
    try {
      return await FLD.getFieldType(this._MGFieldId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置字段类型
   * @memberOf Field
   * @param type 字段类型
   * @return {Promise<void>}
   */
  async setFieldType(type) {
    try {
      await FLD.setFieldType(this._MGFieldId, type);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取字段偏移
   * @memberOf Field
   * @return {Promise}偏移值
   */
  async getFieldOffset() {
    try {
      return await FLD.getFieldOffset(this._MGFieldId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置字段偏移
   * @memberOf Field
   * @param offset 偏移值
   * @return {Promise<void>}
   */
  async setFieldOffset(offset) {
    try {
      await FLD.setFieldOffset(this._MGFieldId, offset);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取字段字节长度
   * @memberOf Field
   * @return {Promise}字节长度
   */
  async getFieldLength() {
    try {
      return await FLD.getFieldLength(this._MGFieldId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置字段字节长度
   * @memberOf Field
   * @param length 字节长度
   * @return {Promise<void>}
   */
  async setFieldLength(length) {
    try {
      await FLD.setFieldLength(this._MGFieldId, length);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取字段字符长度
   * @memberOf Field
   * @return {Promise}字段字符长度
   */
  async getMskLength() {
    try {
      return await FLD.getMskLength(this._MGFieldId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置字段字符长度
   * @memberOf Field
   * @param length 字段字符长度
   * @return {Promise<void>}
   */
  async setMskLength(length) {
    try {
      await FLD.setMskLength(this._MGFieldId, length);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取小数位数
   * @memberOf Field
   * @return {Promise}小数位数
   */
  async getPointLength() {
    try {
      return await FLD.getPointLength(this._MGFieldId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置小数位数
   * @memberOf Field
   * @param length 小数位数
   * @return {Promise<void>}
   */
  async setPointLength(length) {
    try {
      await FLD.setPointLength(this._MGFieldId, length);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取编辑使能标志
   * @memberOf Field
   * @return {Promise}使能标志
   */
  async getEditable() {
    try {
      return await FLD.getEditable(this._MGFieldId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置编辑使能标志
   * @memberOf Field
   * @param value 使能标志
   * @return {Promise<void>}
   */
  async setEditable(value) {
    try {
      await FLD.setEditable(this._MGFieldId, value);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取打印标志
   * @memberOf Field
   * @return {Promise}标志值
   */
  async getPtFlag() {
    try {
      return await FLD.getPtFlag(this._MGFieldId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置打印标志
   * @memberOf Field
   * @param flag 标志值
   * @return {Promise<void>}
   */
  async setPtFlag(flag) {
    try {
      await FLD.setPtFlag(this._MGFieldId, flag);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取字段序号
   * @memberOf Field
   * @return {Promise}字段序号值
   */
  async getPtcPosition() {
    try {
      return await FLD.getPtcPosition(this._MGFieldId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置字段序号
   * @memberOf Field
   * @param position 字段序号值
   * @return {Promise<void>}
   */
  async setPtcPosition(position) {
    try {
      await FLD.setPtcPosition(this._MGFieldId, position);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取字段是否继承标志
   * @memberOf Field
   * @return {Promise}继承标志值
   */
  async getIsInherited() {
    try {
      return await FLD.getIsInherited(this._MGFieldId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置字段是否继承标志
   * @memberOf Field
   * @param value 继承标志值
   * @return {Promise<void>}
   */
  async setIsInherited(value) {
    try {
      await FLD.setIsInherited(this._MGFieldId, value);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 计算字段头需要占用的存储空间
   * @memberOf Field
   * @return {Promise}占用空间值
   */
  async CalculateSize() {
    try {
      return await FLD.CalculateSize(this._MGFieldId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 取扩展字段信息
   * @memberOf Field
   * @return {Promise<ExtField>}扩展字段对象
   */
  async getExtField() {
    try {
      let { ExtFieldId } = await FLD.getExtField(this._MGFieldId);
      var extField = new ExtField();
      extField._MGExtFieldId = ExtFieldId;
      return extField;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置扩展字段信息
   * @memberOf Field
   * @param fieldEx 扩展字段对象
   * @return {Promise<void>}
   */
  async setExtField(fieldEx) {
    try {
      await FLD.setExtField(this._MGFieldId, fieldEx._MGExtFieldId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 是否有扩展字段
   * @memberOf Field
   * @return {Promise}非0/0 ：是/否
   */
  async hasExtField() {
    try {
      return await FLD.hasExtField(this._MGFieldId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 删除扩展字段
   * @memberOf Field
   * @return {Promise}大于0成功，否则失败
   */
  async deleteExtField() {
    try {
      return await FLD.deleteExtField(this._MGFieldId);
    } catch (e) {
      console.error(e);
    }
  }
}
