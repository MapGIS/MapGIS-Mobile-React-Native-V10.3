/**
 * @content android视图点对象功能组件
 * @author fjl 2019-6-24 下午2:52:36
 */
import { NativeModules } from 'react-native';
let ML = NativeModules.JSMapLayer;
import Rect from './Rect.js';

export default class MapLayer {
    /**
     * 构造一个新的 MapLayer 对象。
     * @memberOf MapLayer
     * @returns {Promise.<MapLayer>}
     */
    async createObj() {
        try {
            var { MapLayerId } = await ML.createObj();
            var mapLayer = new MapLayer();
            mapLayer._MGMapLayerId = MapLayerId;
            return mapLayer;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 获取图层名称
     * @returns {Promise<*>}
     */
    async getName() {
        try {
            let name = await ML.getName(this._MGMapLayerId);
            return name;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 获取图层名称
     * @returns {Promise<*>}
     */
    async setName() {
        try {
           await ML.setName(this._MGMapLayerId);
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 获取图层的URL
     * @returns {Promise<*>}
     */
    async getURL() {
        try {
            let url = await ML.getURL(this._MGMapLayerId);
            return url;
        } catch (e) {
            console.error(e);
        }
    }
    /**
     * 设置图层URL地址
     * @param URL 图层URL地址
     * @return
     */
    async setURL(URL) {
        try {
            await ML.setURL(this._MGMapLayerId, URL);
        } catch (e) {
            console.error(e);
        }
    }
    /**
     * 获取图层状态
     *
     * @return
     */
    async getState() {
        try {
            let state = await ML.getState(this._MGMapLayerId);
            return state;
        } catch (e) {
            console.error(e);
        }
    }
    /**
     * 设置图层状态
     *
     * @param State 图层状态
     */
    async setState(State) {
        try {
            await ML.setURL(this._MGMapLayerId, State);
        } catch (e) {
            console.error(e);
        }
    }
    /**
     * 设置图层是否显示
     *
     * @param visible 图层是否显示
     */
    async setVisible(State) {
        try {
            await ML.setVisible(this._MGMapLayerId, visible);
        } catch (e) {
            console.error(e);
        }
    }
    /**
     * 获取图层是否显示
     */
    async getIsVisible() {
        try {
            let state = await ML.getIsVisible(this._MGMapLayerId);
            return state;
        } catch (e) {
            console.error(e);
        }
    }
    /**
     * 获取图层最小显示比率
     *
     */
    async getMinScale() {
        try {
            let minScale = await ML.getMinScale(this._MGMapLayerId);
            return minScale;
        } catch (e) {
            console.error(e);
        }
    }
    /**
     * 设置图层最小显示比率
     *
     * @param MinScale 图层最小显示比率
     */
    async setMinScale(MinScale) {
        try {
            await ML.setMinScale(this._MGMapLayerId, MinScale);
        } catch (e) {
            console.error(e);
        }
    }
    /**
     * 获取图层最大显示比率
     */
    async getMaxScale() {
        try {
            let maxScale = await ML.getMaxScale(this._MGMapLayerId);
            return maxScale;
        } catch (e) {
            console.error(e);
        }
    }
    /**
     * 设置图层最大显示比率
     *
     * @param MaxScale 图层最大显示比率
     */
    async setMaxScale(MaxScale) {
        try {
            await ML.setMaxScale(this._MGMapLayerId, MaxScale);
        } catch (e) {
            console.error(e);
        }
    }
    /**
     * 获取图层的权重
     *
     * @return 图层权重
     */
    async getWeight() {
        try {
            let weight = await ML.getWeight(this._MGMapLayerId);
            return weight;
        } catch (e) {
            console.error(e);
        }
    }
    /**
     * 设置图层的权重
     *
     * @param Weight 权重
     */
    async setWeight(Weight) {
        try {
            await ML.setWeight(this._MGMapLayerId, Weight);
        } catch (e) {
            console.error(e);
        }
    }
    /**
     * 查看图层是否有效
     *
     * @return 图层的有效状态
     */
    async getIsValid() {
        try {
            let IsValid = await ML.getIsValid(this._MGMapLayerId);
            return IsValid;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 获取地图范围
     * @returns {Promise<Rect>}
     */
    async getRange() {
        try {
            var { rectId} = await M.getRange(this._MGMapId);
            var rect = new Rect();
            rect._MGRectId = rectId;
            return rect;
        } catch (e) {
            console.error(e);
        }
    }
}
