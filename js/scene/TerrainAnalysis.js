/*
 * @Description: 地形分析类组件,可以实现地形表面距离量算
 * @Version: 1.0
 * @Autor: liaoliang
 * @Date: 2020-08-19 22:11:26
 * @LastEditors: liaoliang
 * @LastEditTime: 2020-08-19 22:40:58
 */

import { NativeModules } from 'react-native';

let TA = NativeModules.JSTerrainAnalysis;

export default class TerrainAnalysis {
  /**
   * @description: 构造一个新的 TerrainAnalysis 对象
   * @param {type}
   * @return:
   */
  async createObj() {
    try {
      var { terrainAnalysisId } = await TA.createObj();
      var terrainAnalysis = new TerrainAnalysis();
      terrainAnalysis._MGTerrainAnalysisId = terrainAnalysisId;

      return terrainAnalysis;
    } catch (error) {
      console.error(error);
    }
  }
  /**
   * @description: 地形表面距离量算
   * @param {String} sceneId 三维场景的id
   * @param {String} geoVarLineId 待量算的路线的id
   * @return {double} surfaceDistance
   */
  async calculateSurfaceDistance(sceneId, geoVarLineId) {
    try {
      let surfaceDistance = await TA.calculateSurfaceDistance(
        this._MGTerrainAnalysisId,
        sceneId,
        geoVarLineId
      );

      return surfaceDistance;
    } catch (error) {
      console.error(error);
    }
  }
}
