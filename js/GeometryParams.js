/*
 * @Description: In User Settings Edit
 * @Author: xiaoying
 * @Date: 2019-09-10 16:52:12
 * @LastEditTime: 2019-09-20 17:23:26
 * @LastEditors: Please set LastEditors
 */
import { NativeModules } from 'react-native';
import Geometry from './Geometry.js';
import SketchEditor from './SketchEditor.js';

let GP = NativeModules.JSGeometryParams;

/**
 * @class GeometryParams
 * @description 几何对象参数
 */
export default class GeometryParams {
  /**
   * 构造一个新得GeometryParams对象
   *
   * @memberof GeometryParams
   * @returns {Promise<GeometryParams>}
   */
  async createObj() {
    try {
      var { GeometryParamsId } = await GP.createObj();
      var geometryParams = new GeometryParams();
      geometryParams._MGGeometryParamsId = GeometryParamsId;
      return geometryParams;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取几何对象
   *
   * @memberof GeometryParams
   * @returns {Promise<Geometry>} 成功：返回几何对象
   */
  async getGeometry() {
    try {
      let { GeometryId, GeometryType, GeometryAnnoType } = await GP.getGeometry(
        this._MGGeometryParamsId
      );
      let geometry = SketchEditor.getGeometryByType(
        GeometryId,
        GeometryType,
        GeometryAnnoType

      return geometry;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置几何对象
   *
   * @memberof GeometryParams
   * @param {Object} geometry 几何对象（Geometry类型的对象）
   * @returns {Promise<Void>}
   */
  async setGeometry(geometry) {
    try {
      await GP.setGeometry(this._MGGeometryParamsId, geometry._MGGeometryId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取当前索引
   * @memberof GeometryParams
   * @returns {Number} 索引（int类型的Number）
   */
  async getCurrentIndex() {
    try {
      let index = await GP.getCurrentIndex(this._MGGeometryParamsId);
      return index;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置当前索引
   *
   * @memberof GeometryParams
   * @param {Number} currentIndex 索引（int类型的Number）
   * @returns {Promise<Void>}
   */
  async setCurrentIndex(currentIndex) {
    try {
      await GP.setCurrentIndex(this._MGGeometryParamsId, currentIndex);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取当前区之前的线所构成的顶点的数目
   *
   * @memberof GeometryParams
   * @returns {Number} 索引（int类型的Number）
   */
  async getPreCurrentTotalVertex() {
    try {
      let result = await GP.getPreCurrentTotalVertex(this._MGGeometryParamsId);
      return result;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置当前区之前的线所构成的顶点的数目
   *
   * @memberof GeometryParams
   * @param {Number} preCurrentTotalVertex 当前区之前的线所构成的顶点的数目（int类型的Number）
   * @returns {Promise<Void>}
   */
  async setPreCurrentTotalVertex(preCurrentTotalVertex) {
    try {
      await GP.setPreCurrentTotalVertex(
        this._MGGeometryParamsId,
        preCurrentTotalVertex

    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取当前顶点索引
   * @memberof GeometryParams
   * @returns {Number} 顶点索引（int类型的Number）
   */
  async getCurrentVertexIndex() {
    try {
      let result = await GP.getCurrentVertexIndex(this._MGGeometryParamsId);
      return result;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置当前顶点索引
   *
   * @memberof GeometryParams
   * @param {Number} currentVertexIndex 当前顶点索引（int类型的Number）
   * @returns {Promise<Void>}
   */
  async setCurrentVertexIndex(currentVertexIndex) {
    try {
      await GP.setCurrentVertexIndex(
        this._MGGeometryParamsId,
        currentVertexIndex

    } catch (e) {
      console.error(e);
    }
  }
}
