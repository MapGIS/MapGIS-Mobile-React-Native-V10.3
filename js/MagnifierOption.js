/**
 * @content 地图位置组件
 * @author fjl 2019-7-31 下午2:52:36
 */
import {NativeModules} from "react-native";
import Dot from "./Dot.js";
import PointF from "./PointF";

let MO = NativeModules.JSMagnifierOption;

/**
 * 放大镜功能组件
 * @class MagnifierOption
 */
export default class MagnifierOption {
    /**
     * 构造一个新的 MagnifierOption 对象。
     * @memberOf MagnifierOption
     * @returns {Promise.<MagnifierOption>}
     */
    async createObj() {
        try {
            if (
                typeof arguments[0] === "number" &&
                typeof arguments[1] === "number"&&
                typeof arguments[2] === "number"&&
                typeof arguments[3] === "String"
            ) {
                var { MagnifierOptionId } = await MO.createObj(arguments[0], arguments[1], arguments[2], arguments[3]);
                var magnifierOption = new MagnifierOption();
                magnifierOption._MGMagnifierOptionId = MagnifierOptionId;
                return magnifierOption;
            } else {
                var {MagnifierOptionId} = await MO.createObj();
                var magnifierOption = new MagnifierOption();
                magnifierOption._MGMagnifierOptionId = MagnifierOptionId;
                return magnifierOption;
            }
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 获取缩放比例
     * @memberOf MagnifierOption
     * @returns {Promise<Number>} 缩放比例
     */
    async getScale() {
        try {
            var { scale } = await MO.getScale(this._MGMagnifierOptionId);
            return scale;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 设置缩放比例
     * @param scale scale > 1 放大 < 1 缩小
     * @returns {Promise<Object>}
     */
    async setScale(scale) {
        try {
            var { MagnifierOptionId } = await MO.setScale(this._MGMagnifierOptionId,scale);
            var magnifierOption = new MagnifierOption();
            magnifierOption._MGMagnifierOptionId = MagnifierOptionId;
      
            return magnifierOption;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 获取放大镜大小
     * @memberOf MagnifierOption 
     * @returns {Promise<Number>} 放大镜大小
     */
    async getSize() {
        try {
            let {size} = await MO.getSize(this._MGMagnifierOptionId);
            return size;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 设置放大镜大小
     * @param size 放大镜大小
     * @returns {Promise<object>}
     */
    async setSize(size) {
        try {
            let {MagnifierOptionId} = await MO.setSize(this._MGMagnifierOptionId,size);
            var magnifierOption = new MagnifierOption();
            magnifierOption._MGMagnifierOptionId = MagnifierOptionId;
      
            return magnifierOption;
        } catch (e) {
            console.error(e);
        }
    }


    /**
     * 设置放大镜位置调整模式
     * @memberOf MagnifierOption
     * @param mode 放大镜位置调整模式 AUTO_ADJUST_POINT 自动调整 USER_CUSTOM_POINT 自定义位置
     * @returns {Promise<object>}
     */
    async setPointAdjustMode(mode) {
        try {
            let {MagnifierOptionId} = await MO.setPointAdjustMode(this._MGMagnifierOptionId,mode);
            var magnifierOption = new MagnifierOption();
            magnifierOption._MGMagnifierOptionId = MagnifierOptionId;
      
            return magnifierOption;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 获取放大镜位置调整模式
     * @memberOf MagnifierOption
     * @returns {Promise<Number>} 放大镜位置调整模式
     */
    async getPointAdjustMode() {
        try {
            let {mode} = await MO.getPointAdjustMode(this._MGMagnifierOptionId);
            return mode;
        } catch (e) {
            console.error(e);
        }
    }


    /**
     * 获取放大镜位置
     * @memberOf MagnifierOption
     * @returns {Promise<object>} 获取放大镜位置
     */
    async getPoint() {
        try {
            var { PointFId } = await MO.getPoint(this._MGMagnifierOptionId);
            var pointF = new PointF();
            pointF._MGPointFId = PointFId;
            return pointF;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 设设置放大镜位置
     * @memberOf MagnifierOption
     * @param pointF 放大镜左上角位置
     * @returns {Promise<object>}
     */
    async setPoint(pointF) {
        try {
            let {MagnifierOptionId} = await MO.setPoint(this._MGMagnifierOptionId,pointF._MGPointFId);
            var magnifierOption = new MagnifierOption();
            magnifierOption._MGMagnifierOptionId = MagnifierOptionId;
      
            return magnifierOption;
        } catch (e) {
            console.error(e);
        }
    }
}
