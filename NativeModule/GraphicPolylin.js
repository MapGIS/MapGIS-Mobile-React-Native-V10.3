/**
 * @content 线对象功能组件
 * @author fjl 2019-6-24 下午2:52:36
 */
import { NativeModules } from 'react-native';
import Graphic from "./Graphic";
import GraphicMultiPoint from "./GraphicMultiPoint";
let GP = NativeModules.JSGraphicPolylin;

export default class GraphicPolylin extends GraphicMultiPoint{

  constructor(){
    super();
    Object.defineProperty(this,"_MGGraphicPolylinId",{
      get:function () {
        return this._MGGraphicMultiPointId
      },
      set:function (_MGGraphicPolylinId) {
        this._MGGraphicMultiPointId = _MGGraphicPolylinId;
      }
    })
  }

  /**
   * 构造一个新的 GraphicPolylin 对象。
   * @memberOf GraphicPolylin
   * @returns {Promise.<GraphicPolylin>}
   */
  async createObj() {
    try {
      var { GraphicPolylinId } = await GP.createObj();
      var graphicPolylin = new GraphicPolylin();
      graphicPolylin._MGGraphicPolylinId = GraphicPolylinId;
      return graphicPolylin;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置线宽
   * @param width
   * @returns {Promise<void>}
   */
  async setLineWidth(width) {
    try {
      await GP.setLineWidth(this._MGGraphicPolylinId, width);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取圆边界线的宽度
   * @returns {Promise<*>}
   */
  async getLineWidth() {
    try {
      let lineWidth = await GP.getLineWidth(this._MGGraphicPolylinId);
      return lineWidth;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取长度
   * @returns {Promise<*>}
   */
  async getLength() {
    try {
      let length = await GP.getLength(this._MGGraphicPolylinId);
      return length;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置线纹理填充
   * @param point
   * @param radius
   * @returns {Promise<void>}
   */
  async setFillTexture(image) {
    try {
      await GP.setFillTexture(this._MGGraphicPolylinId, image._MGImageId);
    } catch (e) {
      console.error(e);
    }
  }
}
