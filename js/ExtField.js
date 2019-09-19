/**
 * @content 扩展字段头功能组件
 * @author  2019-09-16
 */
import { NativeModules } from "react-native";

let EF = NativeModules.JSExtField;

/**
 * @class ExtField
 * @description 扩展字段头
 */
export default class ExtField {

    /**
   * 构造一个新的 ExtField 对象。
   * @memberOf ExtField
   * @returns {Promise.<ExtField>}
   */
  async createObj() {
    try {
      if (
        typeof arguments[0] === "number" &&
        typeof arguments[1] === "number"
      ) {
        var { extFieldId } = await EF.createObj(arguments[0], arguments[1]);
        var extField = new ExtField();
        extField._MGExtFieldId = extFieldId;
        return extField;
      } 
    } catch (e) {
      console.error(e);
    }
  }

    /**
	 * 获取别名
	 * @memberOf ExtField
	 * @return {Promise<*>}别名
	 */
    async getAlias()
	{
		try {
            return await EF.getAlias(this._MGExtFieldId);
          } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 设置别名
	 * @memberOf ExtField
	 * @param alias 别名
     * @return {Promise<void>}
	 */
	async setAlias(alias)
	{
		try {
            await EF.setAlias(this._MGExtFieldId, alias);
          } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 获取是否允许为空
	 * @memberOf ExtField
	 * @return {Promise<*>}true/false
	 */
	async getIsNull()
	{
		try {
            return await EF.getIsNull(this._MGExtFieldId);
          } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 设置是否允许为空
	 * @memberOf ExtField
	 * @param value true/false
     * @return {Promise<void>}
	 */
	async setIsNull(value)
	{
		try {
            await EF.setIsNull(this._MGExtFieldId, value);
          } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 获取域ID
	 * @memberOf ExtField
	 * @return {Promise<*>}ID值
	 */
	async getDmnID()
	{
		try {
            return await EF.getDmnID(this._MGExtFieldId);
          } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 设置域ID
	 * @memberOf ExtField
	 * @param value ID值
     * @return {Promise<void>}
	 */
	async setDmnID(value)
	{
		try {
            await EF.setDmnID(this._MGExtFieldId, value);
          } catch (e) {
            console.error(e);
        }
    }

	/**
	 * 获取字段形态
	 * @memberOf ExtField
	 * @return {Promise<*>}字段形态
	 */
	async getShape()
	{
		try {
            return await EF.getShape(this._MGExtFieldId);
          } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 设置字段形态
	 * @memberOf ExtField
	 * @param shape 字段形态
     * @return {Promise<void>}
	 */
	async setShape(shape)
	{
		try {
            await EF.setShape(this._MGExtFieldId, shape);
          } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 获取取离散值数目
	 * @memberOf ExtField
	 * @return {Promise<*>}数目
	 */
	async getShapeInfoNum()
	{
		try {
            return await EF.getShapeInfoNum(this._MGExtFieldId);
          } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 获取字段类型
	 * @memberOf ExtField
	 * @return {Promise<*>}字段类型
	 */
	async getFieldType()
	{
		try {
            return await EF.getFieldType(this._MGExtFieldId);
          } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 是否设置缺省值
	 * @memberOf ExtField
	 * @return {Promise<*>}非0/0 ：是/否
	 */
	async hasDefVal()
	{
		try {
            return await EF.hasDefVal(this._MGExtFieldId);
          } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 是否设置最大值
	 * @memberOf ExtField
	 * @return {Promise<*>} 非0/0 ：是/否
	 */
	async hasMaxVal()
	{
		try {
            return await EF.hasMaxVal(this._MGExtFieldId);
          } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 是否设置最小值
	 * @memberOf ExtField
	 * @return {Promise<*>} 非0/0 ：是/否
	 */
	async hasMinVal()
	{
		try {
            return await EF.hasMinVal(this._MGExtFieldId);
          } catch (e) {
            console.error(e);
        }
	}
}