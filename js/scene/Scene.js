/*
 * @Description:三维场景类，用于管理场景中的图层
 * @Version: 1.0
 * @Autor: liaoliang
 * @Date: 2020-07-03 15:10:35
 * @LastEditors: liaoliang
 * @LastEditTime: 2020-07-21 22:01:31
 */

import { NativeModules } from 'react-native';
import VectorLayer3D from './VectorLayer3D.js';
import ModelCacheLayer3D from './ModelCacheLayer3D.js';
import TerrainLayer3D from './TerrainLayer3D.js';
import GroupLayer3D from './GroupLayer3D';
import ServerLayer3D from './ServerLayer3D';

let S = NativeModules.JSScene;

export default class Scene {
  /**
   * @Description:通过id生成Layer3D
   * @param {type}
   * @return:
   */
  async creatLayer3DInstanceByID(layer3DId) {
    try {
      let layer3D;
      var { Layer3DType } = await S.getLayer3DTypeByID(layer3DId);

      switch (Layer3DType) {
        case 0: //None 未知类型
          break;
        case 1: //Vector 矢量图层
          layer3D = new VectorLayer3D();
          layer3D._MGLayer3DId = layer3DId;
          break;
        case 2:
          layer3D = new ModelCacheLayer3D();
          layer3D._MGLayer3DId = layer3DId;
          break;
        case 3:
          layer3D = new TerrainLayer3D();
          layer3D._MGLayer3DId = layer3DId;
          break;
        case 4:
          break;
        case 5:
          break;
        case 6:
          break;
        case 7:
          break;
        case 8:
          layer3D = new ServerLayer3D();
          layer3D._MGLayer3DId = layer3DId;
          break;
        case 9:
          layer3D = new GroupLayer3D();
          layer3D._MGLayer3DId = layer3DId;
          break;
        case 10:
          break;
        default:
          break;
      }

      return layer3D;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @Description: 构造一个新的Scene对象
   * @param {type}
   * @return:
   */
  async createObj() {
    try {
      var { sceneId } = await S.createObj();
      var scene = new Scene();
      scene._MGSceneId = sceneId;
      return scene;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @Description:获取场景描述信息
   * @param {type}
   * @return:
   */
  async getDescription() {
    try {
      let description = await S.getDescription(this._MGSceneId);
      return description;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @Description:获取图层总数
   * @param {type}
   * @return:
   */
  async getLayerCount() {
    try {
      let layerCount = await S.getLayerCount(this._MGSceneId);
      return layerCount;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @Description:获取场景名称
   * @param {type}
   * @return:
   */
  async getNameOfScene() {
    try {
      let name = await S.getNameOfScene(this._MGSceneId);
      return name;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @Description:获取地形的高程偏移
   * @param {type}
   * @return:
   */
  async getVerticalOffset() {
    try {
      let verticalOffset = S.getVerticalOffset(this._MGSceneId);
      return verticalOffset;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @Description: 移除三维图层
   * @param {type} 从fromIndex开始,移除nCount个图层
   * @return: 成功返回大于0；失败返回0
   */
  async removeLayer(fromIndex, nCount) {
    try {
      let result = await S.removeLayer(this._MGSceneId, fromIndex, nCount);

      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @Description: 移除指定索引的三维图层
   * @param {type}
   * @return: 成功返回大于0；失败返回-1
   */
  async removeLayerAt(layerIndex) {
    try {
      let result = await S.removeLayerAt(this._MGSceneId, layerIndex);
      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @Description: 设置场景描述信息
   * @param {type}
   * @return: 成功返回1，失败返回0
   */
  async setDescription(description) {
    try {
      let result = await S.setDescription(this._MGSceneId, description);
      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @Description: 设置场景名称
   * @param {type}
   * @return: //成功返回1，失败返回0
   */
  async setNameOfScene(name) {
    try {
      let result = await S.setNameOfScene(this._MGSceneId, name);
      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @Description: 设置地形的高程偏移
   * @param {type}
   * @return:
   */
  async setVerticalOffset(dVerticalOff) {
    try {
      let result = await S.setVerticalOffset(this._MGSceneId, dVerticalOff);
      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @Description: 在场景中添加三维图层
   * @param {type}
   * @return: 成功返回图层索引（从0开始）；失败返回<0
   */
  async addLayer(layer3DId) {
    try {
      let result = await S.addLayer(this._MGSceneId, layer3DId);
      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @Description: 获取加载的图层数据类型
   * @param {type}
   * @return:
   */
  async getDocItemType() {
    try {
      let docItemTypeValue = await S.getDocItemType(this._MGSceneId);
      return docItemTypeValue;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @Description: 根据索引获取图层，从0开始
   * @param {type}
   * @return:
   */
  async getLayer(index) {
    try {
      let layer3D = null;
      let { layer3DId } = await S.getLayer(this._MGSceneId, index);
      if (layer3DId !== null) {
        layer3D = await this.creatLayer3DInstanceByID(layer3DId);
      }
      return layer3D;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @Description: 图层枚举
   * @param {type}
   * @return: 1-成功；0-失败
   */
  async getLayerEnum(layer3DEnumId) {
    try {
      let result = await S.getLayerEnum(this._MGSceneId, layer3DEnumId);
      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @Description: 获取三维图层的图层索引
   * @param {type}
   * @return:
   */
  async indexOfLayer(layer3DId) {
    try {
      let index = await S.indexOfLayer(layer3DId);
      return index;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @Description: 在场景中根据指定索引插入三维图层
   * @param {type}
   * @return:
   */
  async insertLayer(layer3DId, index) {
    try {
      let result = await S.insertLayer(layer3DId, index);
      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @Description: 从场景中移除三维图层
   * @param {String} layer3DId 移除图层的id
   * @return:
   */
  async removeLayerById(layer3DId) {
    try {
      let result = await S.removeLayerById(this._MGSceneId, layer3DId);
      return result;
    } catch (error) {
      console.error(error);
    }
  }
}
