/**
 * @content 对象工具类
 * @author  2020-01-04
 */
import { NativeModules } from 'react-native';

/**
 * @class ObjectUtils
 * @description 用于对JS层对象进行相关合法性判断等操作
 */
export default class ObjectUtils {
    /**
     * 判断对象是否有效、是否为null
     * 
     * @static
     * @memberOf ObjectUtils
     * @param {Object} obj 对象
     * @returns {Boolean} true：有效； false：无效
     */
    static isValidObject(obj){
        try {
            if(obj === undefined || obj === null)
            {
                return false;
            } else {
                return true;
            }
        } catch (e) {
            console.error(e);
        }
    }
}