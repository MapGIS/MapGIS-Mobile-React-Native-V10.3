/*
 * @Description: In User Settings Edit
 * @Author: xiaoying
 * @Date: 2019-09-09 19:59:19
 * @LastEditTime: 2019-09-16 17:41:33
 * @LastEditors: Please set LastEditors
 */
import { NativeModules } from 'react-native';
import Model from './Model';
let MO = NativeModules.JSModelsOverlay;

/**
 * @class ModelsOverlay
 * @description 模型层
 */
export default class ModelsOverlay {
  /**
   * 构造一个新的ModelsOverlay对象
   *
   * @memberof ModelsOverlay
   * @returns {Promise<ModelsOverlay>}
   */
  async createObj() {
    try {
      var { ModelsOverlayId } = await MO.createObj();
      var modelsOverlay = new ModelsOverlay();
      modelsOverlay._MGModelsOverlayId = ModelsOverlayId;
      return modelsOverlay;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 添加一个模型
   *
   * @memberof ModelsOverlay
   * @param {Object} model 模型（Model类型的Object）
   * @returns {Promise<Void>}
   */
  async addModel(model) {
    try {
      await MO.addModel(this._MGModelsOverlayId, model._MGModelId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 添加一组模型
   *
   * @memberof ModelsOverlay
   * @param {Array} models  一组模型 （存有Model对象的Id的数组）
   * @returns {Promise<Void>}
   */
  async addModels(models) {
    try {
      // 将存有Model对象的数组转换成包含model对象Id的数组
      var modelIds = new Array();
      if (models != null) {
        for (let i = 0; i < models.length; i++) {
          let modelId = models[i]._MGModelId;
          modelIds.push(modelId);
        }
        await MO.addModels(this._MGModelsOverlayId, modelIds);
      }
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 删除指定索引的模型
   *
   * @memberof ModelsOverlay
   * @param {Number} index 索引 （int类型的Number）
   * @returns {Promise<Void>}
   */
  async removeModelByIndex(index) {
    try {
      await MO.removeModelByIndex(this._MGModelsOverlayId, index);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 删除一个模型
   *
   * @memberof ModelsOverlay
   * @param {Object} model 模型 （Model类型的Object）
   * @returns {Promise<Void>}
   */
  async removeModel(model) {
    try {
      await MO.removeModel(this._MGModelsOverlayId, model._MGModelId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 删除一组模型
   *
   * @memberof ModelsOverlay
   * @param {Array} models 一组模型 （包含Model对象的数组）
   * @returns {Promise<Void>}
   */
  async removeModels(models) {
    try {
      var modelIds = new Array();
      if (models != null) {
        for (let i = 0; i < models.length; i++) {
          modelIds.push(models[i]._MGModelId);
        }
        await MO.removeModels(this._MGModelsOverlayId, modelIds);
      }
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 删除所有模型
   *
   * @memberof ModelsOverlay
   * @returns {Promise<Void>}
   */
  async removeAllModels() {
    try {
      await MO.removeAllModels(this._MGModelsOverlayId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取模型数目
   *
   * @memberof ModelsOverlay
   * @returns {Number} 模型数目 （int类型的Number）
   */
  async getModelCount() {
    try {
      let count = await MO.getModelCount(this._MGModelsOverlayId);
      return count;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取模型的索引
   *
   * @memberof ModelsOverlay
   * @param {Object} model 模型 （Model类型的Object）
   * @returns {Number} 模型索引 -1表示没有找到该模型 （int类型的Number）
   */
  async indexOf(model) {
    try {
      let index = await MO.indexOf(this._MGModelsOverlayId, model._MGModelId);
      return index;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取指定索引的模型
   *
   * @memberof ModelsOverlay
   * @param {Number} index 模型索引 从0开始 （int类型的Number）
   * @returns {Promise<Model>} 索引对应的模型
   */
  async getModel(index) {
    try {
      var { ModelId } = await MO.getModel(this._MGModelsOverlayId, index);
      var model = null;
      if (ModelId != null) {
        model = new Model();
        model._MGModelId = ModelId;
      }

      return model;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取所有模型
   *
   * @memberof ModelsOverlay
   * @returns {Array} 模型列表 （包含一组Model对象的数组）
   */
  async getAllModels() {
    try {
      var models = await MO.getAllModels(this._MGModelsOverlayId);
      let modelArray = new Array();
      for (let i = 0; i < models.length; i++) {
        let model = new Model();
        model._MGModelId = models[i];
        modelArray.push(model);
      }
      return modelArray;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   *  移动模型,改变模型的层次序列
   *
   * @memberof ModelsOverlay
   * @param {Number} fromIndex 被移动的模型的索引  （int类型的Number）
   * @param {Number} toIndex 移动模型到toIndex处,如果toIndex为-1 表示移动到最上面  （int类型的Number）
   * @returns {Promise<Void>}
   */
  async moveModel(fromIndex, toIndex) {
    try {
      await MO.moveModel(this._MGModelsOverlayId, fromIndex, toIndex);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   *  保存所有的模型覆盖物到文件中,可以通过该文件构建模型层
   * <p>
   * 示例代码:<br>
   * String strModelFile = ""; modelsOverlay.saveToFile(strModelFile,false);
   * SimpleModelLayer modelLayer = new SimpleModelLayer();
   * modelLayer.setURL(strModelFile); mapView.stopCurRequest(new
   * MapViewStopCurRequestCallback() {
   *
   * public void onDidStopCurRequest() {
   *           mapView.getMap().append(modelLayer); mapView.forceRefresh(); }
   *           });
   *           </p>
   *
   * @memberof ModelsOverlay
   * @param {String} strModelFile 模型文件
   * @param {boolean} trunc 如果文件存在true表示截断,false表示追加
   * @returns {boolean} true-成功 ； false-失败
   */
  async saveToFile(strModelFile, toIndex) {
    try {
      let result = await MO.saveToFile(
        this._MGModelsOverlayId,
        strModelFile,
        toIndex
      );
      return result;
    } catch (e) {
      console.error(e);
    }
  }
}
