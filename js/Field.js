/**
 * @content 字段功能组件
 * @author  2019-09-16
 */
import { NativeModules } from "react-native";

let FLD = NativeModules.JSField;

/**
 * @class Field
 * @description 扩展字段头
 */
export default class Field {

    /**
   * 构造一个新的 Field 对象。
   * @memberOf Field
   * @returns {Promise.<Field>}
   */
  async createObj() {
    try{
        var {fieldId} = await FLD.createObj()
        var field = new Field()
        field._MGFieldId = fieldId
        return field
    } catch(e) {
        console.error(e)
    }
  }

  /**
	 * 获取字段名称
	 * 
	 * @return 字段名称
	 */
	async getFieldName()
	{
		try {
            return await FLD.getFieldName(this._MGFieldId);
          } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 设置字段名称
	 * 
	 * @param name 字段名称
	 */
	async setFieldName(name)
	{
		try {
            await FLD.setFieldName(this._MGFieldId, name);
          } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 获取字段类型
	 * 
	 * @return 字段类型
	 */
	async getFieldType()
	{
		try {
            return await FLD.getFieldType(this._MGFieldId);
          } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 设置字段类型
	 * 
	 * @param type 字段类型
	 */
	async setFieldType(type)
	{
		try {
            await FLD.setFieldType(this._MGFieldId, type);
          } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 获取字段偏移
	 * 
	 * @return 偏移值
	 */
	async getFieldOffset()
	{
		try {
            return await FLD.getFieldOffset(this._MGFieldId);
          } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 设置字段偏移
	 * 
	 * @param offset 偏移值
	 */
	async setFieldOffset(offset)
	{
		try {
            await FLD.setFieldOffset(this._MGFieldId, offset);
          } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 获取字段字节长度
	 * 
	 * @return 字节长度
	 */
	async getFieldLength()
	{
		try {
            return await FLD.getFieldLength(this._MGFieldId);
          } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 设置字段字节长度
	 * 
	 * @param length 字节长度
	 */
	async setFieldLength(length)
	{
		try {
            await FLD.setFieldLength(this._MGFieldId, length);
          } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 获取字段字符长度
	 * 
	 * @return 字段字符长度
	 */
	async getMskLength()
	{
		try {
            return await FLD.getMskLength(this._MGFieldId);
          } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 设置字段字符长度
	 * 
	 * @param length 字段字符长度
	 */
	async setMskLength(length)
	{
		try {
            await FLD.setMskLength(this._MGFieldId, length);
          } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 获取小数位数
	 * 
	 * @return 小数位数
	 */
	async getPointLength()
	{
		try {
            return await FLD.getPointLength(this._MGFieldId);
          } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 设置小数位数
	 * 
	 * @param length 小数位数
	 */
	async setPointLength(length)
	{
		try {
            await FLD.setPointLength(this._MGFieldId, length);
          } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 获取编辑使能标志
	 * 
	 * @return 使能标志
	 */
	async getEditable()
	{
		try {
            return await FLD.getEditable(this._MGFieldId);
          } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 设置编辑使能标志
	 * 
	 * @param value 使能标志
	 */
	async setEditable(value)
	{
		try {
            await FLD.setEditable(this._MGFieldId, value);
          } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 获取打印标志
	 * 
	 * @return 标志值
	 */
	async getPtFlag()
	{
		try {
            return await FLD.getPtFlag(this._MGFieldId);
          } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 设置打印标志
	 * 
	 * @param flag 标志值
	 */
	async setPtFlag(flag)
	{
		try {
            await FLD.setPtFlag(this._MGFieldId, flag);
          } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 获取字段序号
	 * 
	 * @return 字段序号值
	 */
	async getPtcPosition()
	{
		try {
            return await FLD.getPtcPosition(this._MGFieldId);
          } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 设置字段序号
	 * 
	 * @param position 字段序号值
	 */
	async setPtcPosition(position)
	{
		try {
            await FLD.setPtcPosition(this._MGFieldId, position);
          } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 获取字段是否继承标志
	 * 
	 * @return 继承标志值
	 */
	async getIsInherited()
	{
		try {
            return await FLD.getIsInherited(this._MGFieldId);
          } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 设置字段是否继承标志
	 * 
	 * @param value 继承标志值
	 */
	async setIsInherited(value)
	{
		try {
            await FLD.setIsInherited(this._MGFieldId, value);
          } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 计算字段头需要占用的存储空间
	 * 
	 * @return 占用空间值
	 */
	async CalculateSize()
	{
		try {
            return await FLD.CalculateSize(this._MGFieldId);
          } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 取扩展字段信息
	 * 
	 * @return 扩展字段对象
	 */
	async getExtField()
	{
		try {
            let {extFieldId} =  await FLD.getExtField(this._MGFieldId);
            var extField = new ExtField();
            extFieldId._MGExtFieldId = extFieldId;
            return extField;
          } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 设置扩展字段信息
	 * 
	 * @param fieldEx 扩展字段对象
	 */
	async setExtField(fieldEx)
	{
		try {
            await FLD.setExtField(this._MGFieldId, fieldEx._MGExtFieldId);
          } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 是否有扩展字段
	 * 
	 * @return 非0/0 ：是/否
	 */
	async hasExtField()
	{
		try {
            return await FLD.hasExtField(this._MGFieldId);
          } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 删除扩展字段
	 * 
	 * @return 大于0成功，否则失败
	 */
	async deleteExtField()
	{
		try {
            return await FLD.deleteExtField(this._MGFieldId);
          } catch (e) {
            console.error(e);
        }
	}
}