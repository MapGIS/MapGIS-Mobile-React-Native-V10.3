/*
 * @Description: 三维组图层组件
 * @Version: 1.0
 * @Autor: liaoliang
 * @Date: 2020-07-21 11:09:51
 * @LastEditors: liaoliang
 * @LastEditTime: 2020-07-21 17:02:34
 */

import { NativeModules } from 'react-native';
import Layer3D from './Layer3D';

let GL3 = NativeModules.JSGroupLayer3D;

export default class GroupLayer3D extends Layer3D {
  constructor() {
    super();
    Object.defineProperty(this, '_MGGroupLayer3DId', {
      get: function () {
        return this._MGLayer3DId;
      },
      set: function (_MGGroupLayer3DId) {
        this._MGLayer3DId = _MGGroupLayer3DId;
      },
    });
  }

  /**
   * @description: 构造一个新的 GroupLayer3D 对象
   * @param {type}
   * @return:
   */
  async createObj() {
    try {
      var { groupLayer3DId } = await GL3.createObj();
      var groupLayer3D = new GroupLayer3D();
      groupLayer3D._MGGroupLayer3DId = groupLayer3DId;
      return groupLayer3D;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 添加三维图层
   * @param {String} layer3DId
   * @return: 成功返回图层添加的位置索引（从0开始）；失败返回-1
   */
  async addLayer(layer3DId) {
    try {
      let result = await GL3.addLayer(this._MGGroupLayer3DId, layer3DId);
      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 移除所有三维图层
   * @param {type}
   * @return: 1-成功；0-失败
   */
  async clearLayers() {
    try {
      let result = await GL3.clearLayers(this._MGGroupLayer3DId);
      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 获取图层三维范围
   * @param {String} rect3DId
   * @return: 1-成功；0-失败
   */
  async getExtent(rect3DId) {
    try {
      let result = await GL3.getExtent(this._MGGroupLayer3DId, rect3DId);
      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 根据索引获取三维图层
   * @param {int} index
   * @return:
   */
  async getLayer(index) {
    try {
      let layer3DId = await GL3.getLayer(this._MGGroupLayer3DId, index);
      return layer3DId;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 获取当前组下的图层数目
   * @param {type}
   * @return:
   */
  async getLayerCount() {
    try {
      let layerCountNum = await GL3.getLayerCount(this._MGGroupLayer3DId);
      return layerCountNum;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 获取图层枚举
   * @param {String} layer3DEnumId
   * @return: 1-成功；0-失败
   */
  async getLayerEnum(layer3DEnumId) {
    try {
      let result = await GL3.getLayerEnum(
        this._MGGroupLayer3DId,
        layer3DEnumId
      );
      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 获取动态投影参照系
   * @param {String} SRefDataId
   * @return: 1-成功；0-失败
   */
  async getProjTransSRS(SRefDataId) {
    try {
      let result = await GL3.getProjTransSRS(
        this._MGGroupLayer3DId,
        SRefDataId
      );

      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 获取图层类型的值
   * @param {type}
   * @return:
   */
  async getType() {
    try {
      let typeValue = await GL3.getType(this._MGGroupLayer3DId);

      return typeValue;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 根据三维图层对象获取图层位置索引
   * @param {String} layer3DId
   * @return:
   */
  async indexOfLayer(layer3DId) {
    try {
      let index = await GL3.indexOfLayer(this._MGGroupLayer3DId, layer3DId);
      return index;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 根据图层名称查找三维图层,返回图层位置索引
   * @param {String} strLayerName
   * @return:
   */
  async indexOfLayerByName(strLayerName) {
    try {
      let index = await GL3.indexOfLayerByName(
        this._MGGroupLayer3DId,
        strLayerName
      );

      return index;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description:  插入三维图层，根据指定索引位置插入三维图层
   * @param {int} index
   * @param {String} layer3DId
   * @return:
   */
  async insertLayer(index, layer3DId) {
    try {
      let result = await GL3.insertLayer(
        this._MGGroupLayer3DId,
        index,
        layer3DId
      );
      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 获取动态投影标志
   * @param {type}
   * @return:
   */
  async isProjTrans() {
    try {
      let isProjTransValue = await GL3.isProjTrans(this._MGGroupLayer3DId);
      return isProjTransValue;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: isValidValue
   * @param {type}
   * @return:
   */
  async isValid() {
    try {
      let isValidValue = await GL3.isValid(this._MGGroupLayer3DId);

      return isValidValue;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 移除三维图层，从fromIndex开始移除nCount个图层
   * @param {int} fromIndex
   * @param {int} nCount
   * @return:
   */
  async removeLayer(fromIndex, nCount) {
    try {
      let result = await GL3.removeLayer(
        this._MGGroupLayer3DId,
        fromIndex,
        nCount
      );
      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 移除三维图层
   * @param {String} layer3DId
   * @return:
   */
  async removeLayerByObj(layer3DId) {
    try {
      let result = await GL3.removeLayerByObj(
        this._MGGroupLayer3DId,
        layer3DId
      );
      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 移除指定索引的三维图层（移除索引为layerIndex的图层）
   * @param {int} layerIndex
   * @return: 成功返回大于0；失败返回-1
   */
  async removeLayerAt(layerIndex) {
    try {
      let result = await GL3.removeLayerAt(this._MGGroupLayer3DId, layerIndex);
      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 设置动态投影标识
   * @param {boolean} bProjTrans 动态投影标识
   * @return: 1-成功；0-失败
   */
  async setProjTrans(bProjTrans) {
    try {
      let result = await GL3.setProjTrans(this._MGGroupLayer3DId, bProjTrans);
      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 设置动态投影参照系
   * @param {String} SRefDataId
   * @return: 1-成功；0-失败
   */
  async setProjTransSRS(SRefDataId) {
    try {
      let result = await GL3.setProjTransSRS(
        this._MGGroupLayer3DId,
        SRefDataId
      );
      return result;
    } catch (error) {
      console.error(error);
    }
  }
}
