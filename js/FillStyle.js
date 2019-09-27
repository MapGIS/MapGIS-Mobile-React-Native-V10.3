/*
 * @Description: In User Settings Edit
 * @Author: xiaoying
 * @Date: 2019-09-10 16:19:14
 * @LastEditTime: 2019-09-17 14:46:40
 * @LastEditors: Please set LastEditors
 */
import { NativeModules } from "react-native";
import LineStyle from "./LineStyle";
let FS = NativeModules.JSFillStyle;

/**
 * @class FillStyle
 * @description 区样式（纯色填充）
 */
export default class FillStyle{

    /**
     * 构造一个新的FillStyle对象，包含无参构造和有参构造两种方式。
     * 有参构造参数为：颜色（int类型的）、线样式（LineStyle类型的Object）。
     * @memberof FillStyle
     * @returns {Promise<FillStyle>}
     */
    async createObj(){
        try {
            // 通过颜色、轮廓样式构造一个对象
            if(typeof arguments[0] === "number" && typeof arguments[1] === "object"){
                let {FillStyleId} = await FS.createObjCL(arguments[0], arguments[1]._MGLineStyleId);
                let fillStyle = new FillStyle();
                fillStyle._MGFillStyleId = FillStyleId;
                return fillStyle;
            }else{
                let {FillStyleId} = await FS.createObj();
                let fillStyle = new FillStyle();
                fillStyle._MGFillStyleId = FillStyleId;
                return fillStyle;
            }
           
        } catch (e) {
            console.error(e);
        }
    }

    // /**
    //  * 通过颜色、轮廓样式构造一个新的FillStyle对象
    //  * 
    //  * @memberof FillStyle
    //  * @param {Number} color 填充颜色 （int类型的Number）
    //  * @param {Object} lineStyle 轮廓样式 （LineStyle类型的Object）
    //  * @returns {Promise<FillStyle>}
    //  */
    // async createObjCL(color, lineStyle){
    //     try {
           
    //     } catch (e) {
    //         console.error(e);
    //     }
    // }

    /**
     * 获取区样式填充色
     * 
     * @memberof FillStyle
     * @returns {Number} 填充色（int类型的Number）
     */
    async getColor(){
        try {
            let color = await FS.getColor(this._MGFillStyleId);
            return color;
        } catch (e) {
            console.error(e);
        }
    }
    
    /**
     * 设置区样式的填充色
     * 
     * @memberof FillStyle
     * @param {Number} color 填充色（int类型的Number）
     * @returns {Promise<Void>}
     */
    async setColor(color){
        try {
            await FS.setColor(this._MGFillStyleId, color);
            
        } catch (e) {
            console.error(e);
        }
    }
    
    /**
     * 获取轮廓样式（实线含颜色和宽度）
     * 
     * @memberof FillStyle 轮廓样式
     * @returns {Promise<LineStyle>}
     */
    async getLineStyle(){
        try {
            var {LineStyleId} = await FS.getLineStyle(this._MGFillStyleId);
            var lineStyle = new LineStyle();
            lineStyle._MGLineStyleId = LineStyleId;
            return lineStyle;
        } catch (e) {
            console.error(e);
        }
    }
    
    /**
     * 设置轮廓样式
     * 
     * @memberof FillStyle
     * @param {Object} lineStyle 轮廓样式（实线含颜色和宽度）
     * @returns {Promise<Void>}
     */
    async setLineStyle(lineStyle){
        try {
            await FS.setLineStyle(this._MGFillStyleId, lineStyle._MGLineStyleId);

        } catch (e) {
            console.error(e);
        }
    }
}
