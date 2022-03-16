/*
 * @Description: 模型图层组件
 * @Version: 1.0
 * @Autor: liaoliang
 * @Date: 2020-07-21 17:13:28
 * @LastEditors: liaoliang
 * @LastEditTime: 2020-07-21 20:28:04
 */

import { NativeModules } from 'react-native';
import Layer3D from './Layer3D';

let ML3 = NativeModules.JSModelCacheLayer3D;

export default class ModelCacheLayer3D extends Layer3D {
  constructor() {
    super();
    Object.defineProperty(this, '_MGModelCacheLayer3DId', {
      get: function () {
        return this._MGLayer3DId;
      },
      set: function (_MGModelCacheLayer3DId) {
        this._MGLayer3DId = _MGModelCacheLayer3DId;
      },
    });
  }

  /**
   * @description: 构造一个新的 ModelCacheLayer3D 对象
   * @param {type}
   * @return:
   */
  async createObj() {
    try {
      var { modelCacheLayer3DId } = await ML3.createObj();
      var modelCacheLayer3D = new ModelCacheLayer3D();
      modelCacheLayer3D._MGModelCacheLayer3DId = modelCacheLayer3DId;
      return modelCacheLayer3D;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 清除m3d模型缓存
   * @param {type}
   * @return:
   */
  async clearCache() {
    try {
      let result = await ML3.clearCache(this._MGModelCacheLayer3DId);
      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 清除选中
   * @param {type}
   * @return:
   */
  async clearSelection() {
    try {
      let result = await ML3.clearSelection(this._MGModelCacheLayer3DId);
      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 获取图层三维范围
   * @param {String} rect3DId 三维范围，Rect3D类型的id
   * @return:
   */
  async getExtent(rect3DId) {
    try {
      let result = await ML3.getExtent(this._MGModelCacheLayer3DId, rect3DId);
      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 获取选中的要素id列表
   * @param {type}
   * @return {Array}
   */
  async getSelectingFeatureIDs() {
    try {
      let selectingFeatureIDs = await ML3.getSelectingFeatureIDs(
        this._MGModelCacheLayer3DId
      );
      return selectingFeatureIDs;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 获取选中要素的数目
   * @param {type}
   * @return:
   */
  async getSelectingFeatureIDsCount() {
    try {
      let selectingFeatureIDsCountNum = await ML3.getSelectingFeatureIDsCount(
        this._MGModelCacheLayer3DId
      );
      return selectingFeatureIDsCountNum;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 获取选中要素的样式
   * @param {type}
   * @return:
   */
  async getSelectingFeatureStyle(modelCacheLayer3DId, featureID) {
    try {
      let selectionStyleId = await ML3.getSelectingFeatureStyle(
        this._MGModelCacheLayer3DId,
        modelCacheLayer3DId,
        featureID
      );
      return selectionStyleId;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 获取选择要素的样式
   * @param {type}
   * @return:
   */
  async getSelectionProperties() {
    try {
      let selectionPropertiesId = await ML3.getSelectionProperties(
        this._MGModelCacheLayer3DId
      );
      return selectionPropertiesId;
    } catch (error) {
      console.rect3DId(error);
    }
  }

  /**
   * @description: 获取图层显示模式透明度
   * @param {int} sAlpha 透明度,sAlpha值为0-100，100表示不透明
   * @return: 1-成功；0-失败
   */
  async getTransparency(sAlpha) {
    try {
      let result = await ML3.getTransparency(
        this._MGModelCacheLayer3DId,
        sAlpha
      );
      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 获取图层是否应用光照
   * @param {type}
   * @return {boolean}
   */
  async isLightingEnabled() {
    try {
      let isLightingEnabledValue = await ML3.isLightingEnabled(
        this._MGModelCacheLayer3DId
      );
      return isLightingEnabledValue;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 设置选择的要素id
   * @param {int} featureID
   * @return:
   */
  async selectFeature(featureID) {
    try {
      let result = await ML3.selectFeature(
        this._MGModelCacheLayer3DId,
        featureID
      );

      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 设置选择要素的id及对应的样式
   * @param {int} featureID
   * @param {String} selectionStyleId
   * @return:
   */
  async selectFeatureIdAndStyle(featureID, selectionStyleId) {
    try {
      let result = await ML3.selectFeatureIdAndStyle(
        this._MGModelCacheLayer3DId,
        featureID,
        selectionStyleId
      );
      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 设置选择的要素id列表
   * @param {ReadableArray} featureIDs
   * @param {int} idsCount
   * @return:
   */
  async selectFeatures(featureIDs, idsCount) {
    try {
      let result = await ML3.selectFeatures(
        this._MGModelCacheLayer3DId,
        featureIDs,
        idsCount
      );
      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 设置选择的要素id列表及对应的样式列表
   * @param modelCacheLayer3DId
   * @param {ReadableArray} featureIDs id列表
   * @param {int} idsCount id数目
   * @param {ReadableArray} styleIds 样式id列表
   * @param {int} stylesCount 样式数目
   * @return:
   */
  async selectFeaturesIdsAndStyles(
    featureIDs,
    idsCount,
    styleIds,
    stylesCount
  ) {
    try {
      let result = await ML3.selectFeaturesIdsAndStyles(
        this._MGModelCacheLayer3DId,
        featureIDs,
        idsCount,
        styleIds,
        stylesCount
      );
      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 设置图层是否应用光照(该图层的光照开启与否将不再受SetSunLightingMode函数的影响)
   * @param {boolean} value
   * @return:
   */
  async setLightingEnabled(value) {
    try {
      let result = await ML3.setLightingEnabled(
        this._MGModelCacheLayer3DId,
        value
      );
      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 设置选择要素的样式
   * @param {String} selectionPropertiesId
   * @return:
   */
  async setSelectionProperties(selectionPropertiesId) {
    try {
      let result = await ML3.setSelectionProperties(
        this._MGModelCacheLayer3DId,
        selectionPropertiesId
      );
      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 设置图层显示模式透明度
   * @param {int} sAlpha
   * @return:
   */
  async setTransparency(sAlpha) {
    try {
      let result = await ML3.setTransparency(
        this._MGModelCacheLayer3DId,
        sAlpha
      );
      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 设置取消选中要素的id
   * @param {int} featureID
   * @return:
   */
  async setUnSelectFeature(featureID) {
    try {
      let result = await ML3.setUnSelectFeature(
        this._MGModelCacheLayer3DId,
        featureID
      );
      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 设置取消选中要素的id列表
   * @param {ReadableArray} featureIDs
   * @param {int} idsCount
   * @return:
   */
  async setUnSelectFeatures(featureIDs, idsCount) {
    try {
      let result = await ML3.setUnSelectFeatures(
        this._MGModelCacheLayer3DId,
        featureIDs,
        idsCount
      );
      return result;
    } catch (error) {
      console.error(error);
    }
  }
}
