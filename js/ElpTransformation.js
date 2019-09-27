/**
 * @content 椭球变换对象功能组件
 * @author
 */
import { NativeModules } from "react-native";

let ET = NativeModules.JSElpTransformation;

import ElpParam from "./ElpParam.js"
import ElpTransParam from "./ElpTransParam.js"
/**
 * @class ElpTransformation
 */
export default class ElpTransformation {

  /**
	 * 获取椭球个数
	 * @memberOf ElpTransformation
	 * @return {Promise.<Number>}  椭球个数
	 */
	static async getElpParamCount()
	{
		try {
            return await ET.getElpParamCount();
          } catch (e) {
            console.error(e);
          }
	}

	/**
	 * 根据椭球索引，获取椭球参数
	 * @memberOf ElpTransformation
	 * @param index 椭球索引
	 * @return {Promise.<ElpParam>} 成功返回椭球参数对象，失败返回空
	 */
	static async getElpParamByIndex(index)
	{
		try {
            let {ElpParamId} = await ET.getElpParam(index);
            var elpParam = new ElpParam();
            elpParam._MGElpParamId = ElpParamId;
      
            return elpParam;
          } catch (e) {
            console.error(e);
          }
	}

	/**
	 * 根据椭球名称，获取椭球参数
	 * @memberOf ElpTransformation
	 * @param name 椭球名称
	 * @return {Promise.<ElpParam>} 成功返回椭球参数对象，失败返回空
	 */
	static async getElpParamByName(name)
	{
		try {
            let {ElpParamId} = await ET.getElpParam(name);
            var elpParam = new ElpParam();
            elpParam._MGElpParamId = ElpParamId;
      
            return elpParam;
          } catch (e) {
            console.error(e);
          }
	}

	/**
	 * 根据椭球索引，设置或替换椭球参数（不永久保存）
	 * @memberOf ElpTransformation
	 * @param index 椭球索引
	 * @param param 椭球参数
     * @return {Promise.<void>}
	 */
	static async setElpParam(index, param)
	{
		try {
            await ET.setElpParam(index, param._MGElpParamId);
          } catch (e) {
            console.error(e);
          }
	}

	/**
	 * 椭球坐标系变换参数对象个数
	 * @memberOf ElpTransformation
	 * @return {Promise.<Number>} 椭球坐标系变换参数个数
	 */
	static async getElpTransParamCount()
	{
		try {
            return await ET.getElpTransParamCount();
          } catch (e) {
            console.error(e);
          }
	}

	/**
	 * 根据索引，获取椭球转换参数对象
	 * @memberOf ElpTransformation
	 * @param index 转换参数的索引值
	 * @return {Promise.<ElpTransParam>} 成功返回椭球转换参数对象，失败返回空
	 */
	static async getElpTransParamByIndex(index)
	{
		try {
            let {ElpTransParamId} = await ET.getElpTransParam(index);
            var elpTransParam = new ElpTransParam();
            elpTransParam._MGElpTransParamId = ElpTransParamId;
      
            return elpTransParam;
          } catch (e) {
            console.error(e);
          }
	}

	/**
	 * 根据名称，获取椭球转换参数
	 * @memberOf ElpTransformation
	 * @param name 椭球转换参数对象的名称
	 * @return {Promise.<ElpTransParam>} 成功返回椭球转换参数对象，失败返回空
	 */
	static async getElpTransParamByName(name)
	{
		try {
            let {ElpTransParamId} = await ET.getElpTransParam(name);
            var elpTransParam = new ElpTransParam();
            elpTransParam._MGElpTransParamId = ElpTransParamId;
      
            return elpTransParam;
          } catch (e) {
            console.error(e);
          }
	}

	/**
	 * 修改/设置椭球转换参数
	 * @memberOf ElpTransformation
	 * @param index 椭球转换参数对象索引
	 * @param param 椭球转换参数对象
	 * @return {Promise.<boolean>} 成功返回true，失败返回false
	 */
	static async setElpTransParamByIndex(index, param)
	{
		try {
            return await ET.setElpTransParam(index, param._MGElpTransParamId);
          } catch (e) {
            console.error(e);
          }
	}

	/**
	 * 修改/设置椭球转换参数
	 * @memberOf ElpTransformation
	 * @param name 椭球转换参数对象名称
	 * @param param 椭球转换参数对象
	 * @return {Promise.<boolean>} 成功返回true，失败返回false
	 */
	static async setElpTransParamByName(name, param)
	{
		try {
            return await ET.setElpTransParam(name, param._MGElpTransParamId);
          } catch (e) {
            console.error(e);
          }
	}

	/**
	 * 添加椭球坐标系变换参数对象
	 * @memberOf ElpTransformation
	 * @param param 椭球坐标系变换参数对象
	 * @return {Promise.<Number>} 成功则返回椭球参数对象索引
	 */
	static async addElpTransParam(param)
	{
		try {
            return await ET.addElpTransParam(param._MGElpTransParamId);
          } catch (e) {
            console.error(e);
          }
	}

	/**
	 * 根据索引删除椭球坐标系变换参数对象
	 * @memberOf ElpTransformation
	 * @param index 椭球转换参数对象索引
	 * @return {Promise.<boolean>} 成功返回true，失败返回false
	 */
	static async delElpTransParamByIndex(index)
	{
		try {
            return await ET.delElpTransParam(index);
          } catch (e) {
            console.error(e);
          }
	}

	/**
	 * 根据索引删除椭球坐标系变换参数对象
	 * @memberOf ElpTransformation
	 * @param name 椭球转换参数对象名称
	 * @return {Promise.<boolean>} 成功返回true，失败返回false
	 */
	static async delElpTransParamByName(name)
	{
		try {
            return await ET.delElpTransParam(name);
          } catch (e) {
            console.error(e);
          }
	}

	/**
	 * 清空椭球坐标系变换参数对象
	 * @memberOf ElpTransformation
	 * @return {Promise.<boolean>} 成功返回true，失败返回false
	 */
	static async clearElpTransParam()
	{
		try {
            return await ET.clearElpTransParam();
          } catch (e) {
            console.error(e);
          }
	}

	/**
	 * 导入椭球变换参数
	 * @memberOf ElpTransformation
	 * @param strFile 文件URL
	 * @return {Promise.<boolean>} 成功返回true，失败返回false
	 */
	static async loadElpTransParam(strFile)
	{
		try {
            return await ET.loadElpTransParam(strFile);
          } catch (e) {
            console.error(e);
          }
	}

	/**
	 * 从文件导入椭球转换参数
	 * @memberOf ElpTransformation
	 * @param strFile 文件URL
	 * @return {Promise.<ElpTransParam>} 成功返回椭球转换对象列表，失败返回空
	 */
	static async loadElpTransParam0(strFile)
	{
          try {
            var objArr = [];
            let { elpTransParamArr } = await ET.loadElpTransParam0(strFile);
            for (var i = 0; i < elpTransParamArr.length; i++) {
              var elpTransParam = new ElpTransParam();
              elpTransParam._MGElpTransParamId = elpTransParamArr[i];
              objArr.push(elpTransParam);
            }
            return objArr;
          } catch (e) {
            console.error(e);
          }
	}

	/**
	 * 导出椭球变换参数
	 * @memberOf ElpTransformation
	 * @param strFile 文件URL
	 * @return {Promise.<boolean>}成功返回true，失败返回false
	 */
	static async saveElpTransParam(strFile)
	{
		try {
            return await ET.saveElpTransParam(strFile);
          } catch (e) {
            console.error(e);
          }
	}

	/**
	 * 根据控制点结构对象序列，计算椭球参数转换对象
	 * @memberOf ElpTransformation
	 * @param transType 转换类型(0/1:三参数直角平移/七参数)
	 * @param pnts 控制点结构对象序列
	 * @param sourceSpheroid 椭球体索引(1开始)
	 * @param sourceAngUnit 获取空间数据水平坐标单位：角度(4/7/3/5:度/分/秒/度分秒)
	 * @param spheroid 椭球体索引(1开始)
	 * @param angUnit 获取空间数据水平坐标单位：角度(4/7/3/5:度/分/秒/度分秒)
	 * @return {Promise.<ElpTransParam>} 椭球坐标系变换参数
	 */
	static async countCoeByPntList(transType, pnts, sourceSpheroid, sourceAngUnit, spheroid, angUnit)
	{
          try {
            let { ElpTransParamId } = await ET.countCoeByPntList(transType, pnts, sourceSpheroid, sourceAngUnit, spheroid, angUnit);
            var elpTransParam = new ElpTransParam();
            elpTransParam._MGElpTransParamId = ElpTransParamId;
            return elpTransParam;
          } catch (e) {
            console.error(e);
          }
	}

}