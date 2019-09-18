/*
 * @Description: In User Settings Edit
 * @Author: xiaoying
 * @Date: 2019-09-10 17:32:54
 * @LastEditTime: 2019-09-17 11:30:23
 * @LastEditors: Please set LastEditors
 */
import { NativeModules } from "react-native";
let TS = NativeModules.JSTextStyle;

/**
 * @class TextStyle
 * @description  文本样式
 */
export default class TextStyle{

    /**
     * 构造一个新的TextStyle对象，可通过无参或有参构造。
     * 有参构造的参数为文本颜色（int类型的Number）、文本大小（float类型的Number）
     * 
     * @memberof TextStyle
     * @returns {Promise<TextStyle>}
     */
    async createObj(){
        try {
            if(typeof arguments[0] === "number" && typeof arguments[1] === "number"){
                var {TextStyleId} = await TS.createObjByCS(arguments[0], arguments[1]);
               
                var textStyle = new TextStyle();
                textStyle._MGTextStyleId = TextStyleId;
                return textStyle;
            }else{
                var {TextStyleId} = await TS.createObj();
                var textStyle = new TextStyle();
                
                textStyle._MGTextStyleId = TextStyleId;
                return textStyle;
            }
          
        } catch (e) {
            console.error(e);
        }
    }

    // /**
    //  * 通过文本颜色、大小构造一个新的TextStyle对象
    //  * 
    //  * @memberof TextStyle
    //  * @param {Number} color 文本颜色（int类型的Number）
    //  * @param {Number} size  文本大小（float类型的Number）
    //  * @returns {Promise<TextStyle>}
    //  */
    // async createObjByCS(color, size){
    //     try {
    //         var {TextStyleId} = await TS.createObjByCS(color, size);
    //         var textStyle = new TextStyle();
    //         textStyle._MGTextStyleId = TextStyleId;
    //         return textStyle;
    //     } catch (e) {
    //         console.error(e);
    //     }
    // }

    /**
     * 获取颜色
     * 
     * @memberof TextStyle
     * @returns {Number} 颜色（int类型的Number）
     */
    async getColor(){
        try {
            let color = await TS.getColor(this._MGTextStyleId);
            return color;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * @memberof TextStyle
     * @param {Number} color 颜色（int类型的Number）
     * @returns {Promise<Void>}
     */
    async setColor(color){
        try {
            await TS.setColor(this._MGTextStyleId, color);
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 获取文本的大小
     * 
     * @memberof TextStyle
     * @returns {Number} 文本大小（单位：dp，float类型的Number）
     */
    async getSize(){
        try {
            let size = await TS.getSize(this._MGTextStyleId);
            return size;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 设置文本的大小
     * 
     * @memberof TextStyle
     * @param {Number} size 文本大小（单位：dp，float类型的Number）
     * @returns {Promise<Void>}
     */
    async setSize(size){
        try {
            await TS.setSize(this._MGTextStyleId, size);
            
        } catch (e) {
            console.error(e);
        }
    }
}
