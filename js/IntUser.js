/*
 * @Description: In User Settings Edit
 * @Author: xiaoying
 * @Date: 2019-09-04 10:36:03
 * @LastEditTime: 2019-09-11 09:51:23
 * @LastEditors: Please set LastEditors
 */
import {NativeModules} from "react-native";
let IU = NativeModules.JSIntUser;

/**
 * @class IntUser
 * @description 整数对象
 */
export default class IntUser{

    /**
     * 构造一个新的IntUser对象，可通过无参或有参构造。
     * 有参构造的参数为：整数值（int类型的Number）
     * 
     * @memberof IntUser
     * @returns {Promise<IntUser>}
     */
    async createObj(){
        try {
            if(typeof arguments[0] === "number"){
                let {IntUserId} = await IU.createObj(arguments[0]);
                let intUser = new IntUser();
                intUser._MGIntUserId = IntUserId;
                return intUser;
            }else{
                let {IntUserId} = await IU.createObj();
                let intUser = new IntUser();
                intUser._MGIntUserId = IntUserId;
                return intUser;
            }
        } catch (e) {
            console.error(e);
        }
    }

    // /**
    //  * 通过value构造一个新的IntUser对象
    //  * 
    //  * @memberof IntUser
    //  * @param {int} value 整数值 
    //  * @returns {Promise<IntUser>}
    //  */
    // async createObj(value){
    //     try {
    //         var {IntUserId} = await IU.createObj(value);
    //         var intUser = new IntUser();
    //         intUser._MGIntUserId = IntUserId;
    //         return intUser;
    //     } catch (e) {
    //         console.error(e);
    //     }
    // }

    /**
     * 设置整数值
     * 
     * @memberof IntUser
     * @param {int} value 整数值
     * @returns {Promise<Void>}
     */
    async setValue(value){
        try {
            await IU.setValue(this._MGIntUserId, value);
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 获取整数值
     * 
     * @memberof IntUser
     * @returns {int} 
     */
    async getValue(){
        try {
            let value = await IU.getValue(this._MGIntUserId);
            return value;
        } catch (e) {
            console.error(e);
        }
    }
}