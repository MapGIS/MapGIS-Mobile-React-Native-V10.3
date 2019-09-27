/**
 * @content 查询条件定义功能组件
 * @author  2019-09-16
 */
import { NativeModules } from "react-native";

let QD = NativeModules.JSQueryDef;

/**
 * @class QueryDef
 * @description 扩展字段头
 */
export default class QueryDef{

    /**
   * 构造一个新的 QueryDef 对象。
   * @memberOf QueryDef
   * @returns {Promise.<QueryDef>} QueryDef 对象。
   */
  async createObj() {
    try{
        var {QueryDefId} = await QD.createObj();
        var queryDef = new QueryDef();
        queryDef._MGQueryDefId = QueryDefId;
        return queryDef;
    }catch(e){
        console.error(e);
    }
  }

  /**
	 * 设置属性查询条件
	 * @memberOf QueryDef
	 * @param whereClause 属性查询条件
	 * @return {Promise} 成功:>0;失败：<=0
	 */
	async setFilter(whereClause)
	{
		try {
            return await QD.setFilter(this._MGQueryDefId, whereClause); 
        } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 属性相关选项设置,设置查询结果字段集
	 * @memberOf QueryDef
	 * @param flds 查询结果字段集
	 * @return {Promise} 成功:>0;失败：<=0
	 */
	async setSubFields(flds)
	{
		try {
            return await QD.setSubFields(this._MGQueryDefId, flds._MGFieldsId); 
        } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 矩形范围查询条件
	 * @memberOf QueryDef
	 * @param rect 矩形范围
	 * @param queryMode 空间查询模式
	 * @return {Promise} 成功:>0;失败：<=0
	 */
	async setRect(rect, queryMode)
	{
		try {
            return await QD.setRect(this._MGQueryDefId, rect._MGRectId, queryMode); 
        } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 设置空间查询条件
	 * @memberOf QueryDef
	 * @param geom 空间查询条件
	 * @param queryMode 空间查询模式
	 * @return {Promise} 成功:>0;失败：<=0
	 */
	async setSpatial(polygon, queryMode)
	{
		try {
            return await QD.setSpatial(this._MGQueryDefId, polygon._MGGeoPolygonId, queryMode); 
        } catch (e) {
            console.error(e);
        }
	}

	/**
	 * Near点查询
	 * @memberOf QueryDef
	 * @param dot 点坐标
	 * @param xmax x最大值
	 * @param xmin x最小值
	 * @return {Promise} 成功:>0;失败：<=0
	 */
	async setNear(dot, xmax, xmin)
	{
		try {
            return await QD.setNear(this._MGQueryDefId, dot._MGDotId, xmax, xmin); 
        } catch (e) {
            console.error(e);
        }
	}
}