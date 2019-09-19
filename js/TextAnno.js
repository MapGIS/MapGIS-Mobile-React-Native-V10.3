/**
 * @content 用于对多边形的几何功能组件
 * @author  2019-09-09 
 */
import { NativeModules } from "react-native";

let TA = NativeModules.JSTextAnno;

/**
 * @class TextAnno
 */
export default class TextAnno extends GeoAnno {
    constructor(){
        super()
        Object.defineProperty(this,"_MGTextAnnoId", {
            get:function(){
                return this._MGGeoAnnoId
            },
            set:function(_MGTextAnnoId){
                this._MGGeoAnnoId = _MGTextAnnoId
            },
        })
    }
    
    /**
	 * 构造一个新的 GeoVarLine 对象
	 * @memberOf GeoVarLine
	 * @return {Promise<GeoVarLine>}
	 */
    async createObj(){
        try{
            var {geoAnnoId} = await TA.createObj()
            var textAnno = new TextAnno()
            textAnno._MGTextAnnoId = geoAnnoId
            return textAnno
        } catch(e) {
            console.error(e)
        }
    }

    /**
	 * 获取几何对象类型
	 * 
	 * @return 几何对象类型
	 */
	async getType()
	{
		try{
            return await TA.getType(this._MGTextAnnoId)
        } catch(e) {
            console.error(e)
        }
	}

	/**
	 * 获取注记类型
	 * 
	 * @return 注记类型
	 */
	async getAnnType()
	{
		try{
            return await TA.getAnnType(this._MGTextAnnoId)
        } catch(e) {
            console.error(e)
        }
	}

	/**
	 * 判断几何注记是否为空
	 * 
	 * @return 为空返回true，不为空返回false
	 */
	async isEmpty()
	{
		try{
            return await TA.isEmpty(this._MGTextAnnoId)
        } catch(e) {
            console.error(e)
        }
	}
	
	/**
	 * 获取文本注记文本内容
	 * 
	 * @return 文本内容
	 */
	async getText()
	{
		try{
            return await TA.getText(this._MGTextAnnoId)
        } catch(e) {
            console.error(e)
        }
	}

	/**
	 * 设置文本注记文本内容
	 * 
	 * @param text 文本内容
	 */
	async setText(text)
	{
		try{
            return await TA.setText(this._MGTextAnnoId, text)
        } catch(e) {
            console.error(e)
        }
	}

	/**
	 * 获取文本注记文本格式化信息
	 * 
	 * @return 文本格式化信息
	 */
	async getTextAnnInfo()
	{
		try{
            let {textAnnInfoId} = await TA.getTextAnnInfo(this._MGTextAnnoId)
            var annInfo = new TextAnnInfo();
            annInfo._MGTextAnnInfoId = textAnnInfoId;
            return annInfo;
        } catch(e) {
            console.error(e)
        }
	}

	/**
	 * 设置文本注记文本格式化信息
	 * 
	 * @param textFmt 文本格式化信息
	 */
	async setTextAnnInfo(textInfo)
	{
		try{
            await TA.setTextAnnInfo(this._MGTextAnnoId, textInfo._MGTextAnnInfoId)
        } catch(e) {
            console.error(e)
        }
	}
}