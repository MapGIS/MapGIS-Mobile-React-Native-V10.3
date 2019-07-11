/**
 * @content 覆盖物对象功能组件
 * @author fjl 2019-6-21 下午2:52:36
 */
import {NativeModules} from 'react-native';

let X = NativeModules.JSGraphicsOverlay;
import Graphic from './Graphic.js';
import Feature from "./Feature";

/**
 * @class GraphicsOverlay
 */
export default class GraphicsOverlay {
    /**
     * 构造一个新的 GraphicsOverlay 对象。
     * @memberOf GraphicsOverlay
     * @returns {Promise.<GraphicsOverlay>}
     */
    async createObj() {
        try {
            var {GraphicsOverlayId} = await X.createObj();
            var graphicsOverlay = new GraphicsOverlay();
            graphicsOverlay._MGGraphicsOverlayId = GraphicsOverlayId;
            return graphicsOverlay;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 设置层名称
     * @memberOf GraphicsOverlay
     * @param name
     * @returns {Promise<void>}
     */
    async setName(name) {
        try {
            await X.setName(this._MGGraphicsOverlayId, name);
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 获取层名称
     * @memberOf GraphicsOverlay
     * @returns {Promise<*>}
     */
    async getName() {
        try {
            let name = await X.getName(this._MGGraphicsOverlayId);

            return name;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 获取图形层的可见状态
     *@memberOf GraphicsOverlay
     * @return 返回层的状态 0 不可见 1 可见
     */
    async getState() {
        try {
            let state = await X.getState(this._MGGraphicsOverlayId);

            return state;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 设置图形层的可见状态
     * @memberOf GraphicsOverlay
     * @param state
     */
    async setState(state) {
        try {
            await X.setState(this._MGGraphicsOverlayId, state);
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 添加一个图形
     * @memberOf GraphicsOverlay
     * @param graphic
     */
    async addGraphic(graphic) {
        try {
            await X.addGraphic(this._MGGraphicsOverlayId, graphic._MGGraphicId);
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 添加一组图形
     * @memberOf GraphicsOverlay
     * @param graphicArray
     * @returns {Promise<void>}
     */
    async addGraphics(graphicArray) {
        try {
            await X.addGraphics(this._MGGraphicsOverlayId, graphicArray);
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 删除一个图形
     *  @memberOf GraphicsOverlay
     * @param graphic
     * @returns {Promise<void>}
     */
    async removeGraphic(graphic) {
        try {
            await X.removeGraphic(this._MGGraphicsOverlayId, graphic._MGGraphicId);
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 删除一组图形
     * @memberOf GraphicsOverlay
     * @param graphicArray
     * @returns {Promise<void>}
     */
    async removeGraphics(graphicArray) {
        try {

            await X.removeGraphic(this._MGGraphicsOverlayId, graphicArray);
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 删除所有图形
     * @memberOf GraphicsOverlay
     */
    async removeAllGraphics() {
        try {
            await X.removeAllGraphics(this._MGGraphicsOverlayId);
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 返回所有图形
     * @memberOf GraphicsOverlay
     */
    async getAllGraphics() {
        try {
            var objArr = [];
            let graphicArray = await X.getAllGraphics(this._MGGraphicsOverlayId);
            for (var i = 0; i < graphicArray.length - 1; i++) {
                var graphic = new Graphic();
                graphic._MGGraphicId = values[i];
                objArr.push(graphic);
            }
            return objArr;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 返回所有图形的数目
     * @memberOf GraphicsOverlay
     */
    async getGraphicCount() {
        try {
            let count = await X.getGraphicCount(this._MGGraphicsOverlayId);

            return count;
        } catch (e) {
            console.error(e);
        }
    }


    /**
     * 获取指定图形的索引
     * @memberOf GraphicsOverlay
     * @param graphic
     * @returns {Promise<*>}
     */
    async indexOf(graphic) {
        try {
            let index = await X.indexOf(this._MGGraphicsOverlayId);

            return index;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 获取指定索引的图形
     * @memberOf GraphicsOverlay
     * @param index
     */
    async getGraphic(index) {
        try {
            let {GraphicId} = await X.getGraphic(this._MGGraphicsOverlayId, index);
            var graphic = new Graphic();
            graphic._MGGraphicId = GraphicId;
            return graphic;
            return graphic;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 插入图形
     * @memberOf GraphicsOverlay
     * @param index
     * @param graphic
     * @returns {Promise<*>} returnID > 0 插入成功，returnID < 0 插入失败
     */
    async insertGraphic(index, graphic) {
        try {
            let returnID = await X.insertGraphic(this._MGGraphicsOverlayId, index, graphic);

            return returnID;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 删除指定索引的图形
     *@memberOf GraphicsOverlay
     * @param index
     */
    async removeGraphic(index) {
        try {
            await X.removeGraphic(this._MGGraphicsOverlayId, index);
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 移动图形的叠放次序
     *@memberOf GraphicsOverlay
     * @param fromIndex
     * @param toIndex
     */
    async moveGraphic(fromIndex, toIndex) {
        try {
            await X.moveGraphic(this._MGGraphicsOverlayId, fromIndex, toIndex);
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 删除指定属性的图形
     * @memberOf GraphicsOverlay
     * @param 属性名
     * @param 属性值
     */
    async removeGraphicByAttribute(name, value) {
        try {
            await X.removeGraphicByAttribute(this._MGGraphicsOverlayId, name, value);
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 获取指定属性的图形
     *@memberOf GraphicsOverlay
     * @param 属性名
     * @param 属性值
     */
    async getGraphicsByAttribute(name, value) {
        try {
            let graphicArray = await X.getGraphicsByAttribute(this._MGGraphicsOverlayId, name, value);
            return graphicArray;
        } catch (e) {
            console.error(e);
        }
    }
}
