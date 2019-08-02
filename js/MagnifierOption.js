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
                magnifierOption._MMagnifierOption = MagnifierOptionId;
                return magnifierOption;
            } else {
                var {MagnifierOptionId} = await MO.createObj();
                var magnifierOption = new MagnifierOption();
                magnifierOption._MMagnifierOption = MagnifierOptionId;
                return magnifierOption;
            }
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 获取缩放比例
     * @memberOf MagnifierOption
     * @returns {Promise<*>}
     */
    async getScale() {
        try {
            var { scale } = await MO.getScale(this._MMagnifierOption);
            return scale;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 设置缩放比例
     * @param scale
     * @returns {Promise<void>}
     */
    async setScale(scale) {
        try {
            await MO.setScale(this._MMagnifierOption,scale);
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 获取放大镜大小
     * @memberOf MagnifierOption
     * @returns {Promise<*>}
     */
    async getSize() {
        try {
            let {size} = await MO.getSize(this._MMagnifierOption);
            return size;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 设置放大镜大小
     * @param size
     * @returns {Promise<void>}
     */
    async setSize(size) {
        try {
            await MO.setSize(this._MMagnifierOption,size);
        } catch (e) {
            console.error(e);
        }
    }


    /**
     * 设置放大镜位置调整模式
     * @memberOf MagnifierOption
     * @param rotateAngle
     * @returns {Promise<void>}
     */
    async setPointAdjustMode(mode) {
        try {
            await MO.setPointAdjustMode(this._MMagnifierOption,mode);
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 获取放大镜位置调整模式
     * @memberOf MagnifierOption
     * @returns {Promise<*>}
     */
    async getPointAdjustMode() {
        try {
            let {mode} = await MO.getPointAdjustMode(this._MMagnifierOption);
            return mode;
        } catch (e) {
            console.error(e);
        }
    }


    /**
     * 获取放大镜位置
     * @memberOf MagnifierOption
     * @returns {Promise<*>}
     */
    async getPoint() {
        try {
            var { PointFID } = await MO.getPoint(this._MMagnifierOption);
            var pointFID = new PointF();
            pointFID._MGPointFId = PointFID;
            return pointFID;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 设设置放大镜位置
     * @memberOf MagnifierOption
     * @param pointF
     * @returns {Promise<void>}
     */
    async setPoint(pointF) {
        try {
            await MO.setPoint(this._MMagnifierOption,pointF._MGPointFId);
        } catch (e) {
            console.error(e);
        }
    }
}
