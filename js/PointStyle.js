/*
 * @Description: In User Settings Edit
 * @Author: xiaoying
 * @Date: 2019-09-10 16:52:51
 * @LastEditTime: 2019-09-11 09:30:17
 * @LastEditors: Please set LastEditors
 */
import { NativeModules } from "react-native";
let PS = NativeModules.JSPointStyle;

/**
 * @class PointStyle
 * @description  点样式（实心圆点）
 */
export default class PointStyle{
    /**
     * 构造一个新的PointStyle对象，可通过无参或有参构造。
     * 有参构造的参数为：颜色（int类型的Number），大小（float类型的Number）
     * 
     * @memberof PointStyle
     * @returns {Promise<PointStyle>}
     */
    async createObj(){
        try {
            if(typeof arguments[0] === "number" && typeof arguments[1] === "number"){
                var {PointStyleId} = await PS.createObjByCS(arguments[0], arguments[1]);
                var pointStyle = new PointStyle();
                pointStyle._MGPointStyleId = PointStyleId;
                return pointStyle;
            }else{
                var {PointStyleId} = await PS.createObj();
                var pointStyle = new PointStyle();
                pointStyle._MGPointStyleId = PointStyleId;
                return pointStyle;
            }
        } catch (e) {
            console.error(e);
        }
    }

    // /**
    //  * 通过颜色、大小构造一个新的FillStyle对象
    //  * 
    //  * @memberof PointStyle
    //  * @param {Number} color 颜色 （int类型的Number）
    //  * @param {Number} size 大小  （float类型的Number）
    //  * @returns {Promise<PointStyle>}
    //  */
    // async createObjByCS(color, size){
    //     try {
    //         var {PointStyleId} = await PS.createObjByCS(color, size);
    //         var pointStyle = new PointStyle();
    //         pointStyle._MGPointStyleId = PointStyleId;
    //         return pointStyle;
    //     } catch (e) {
    //         console.error(e);
    //     }
    // }

    /**
     * 获取点样式的颜色
     * 
     * @memberof PointStyle
     * @returns {Number} 颜色 （int类型的Number）
     */
    async getColor(){
        try {
            let color = await PS.getColor(this._MGPointStyleId);
            return color;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 设置点样式的颜色
     * 
     * @memberof PointStyle
     * @param {Number} color 颜色 （int类型的Number）
     * @returns {Promise<Void>}
     */
    async setColor(color){
        try {
            await PS.setColor(this._MGPointStyleId, color);

        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 获取点的大小
     * 
     * @memberof PointStyle
     * @returns {Number} 点的大小 （float类型的Number）
     */
    async getSize(){
        try {
            let size = await PS.getSize(this._MGPointStyleId);
            return size;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 设置点的大小
     * 
     * @memberof PointStyle
     * @param {Number} size 点的大小 （float类型的Number)
     * @returns {Promise<Void>}
     */
    async setSize(size){
        try {
            await PS.setSize(this._MGPointStyleId, size);
            
        } catch (e) {
            console.error(e);
        }
    }
}