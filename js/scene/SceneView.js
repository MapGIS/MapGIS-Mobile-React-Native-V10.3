/*
 * @Description:三维视图组件
 * @Version: 1.0
 * @Autor: liaoliang
 * @Date: 2020-06-29 16:17:20
 * @LastEditors: liaoliang
 * @LastEditTime: 2020-08-16 23:29:15
 */

import { NativeModules } from 'react-native';
import FlyManager from './FlyManager';
import Graphic3DsOverlay from './Graphic3DsOverlay';

let SV = NativeModules.JSSceneview;

/**
 * @class SceneView
 * @Description 三维视图组件容器类
 */
export default class SceneView {
  /**
   * @Description: 构造一个新的SceneView对象
   * @param {type}
   * @return:
   */
  async createObj() {
    try {
      var { sceneViewId } = await SV.createObj();
      var sceneView = new SceneView();
      sceneView._MGSceneViewId = sceneViewId;
      return sceneView;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @Description:
   * @param {type}
   * @return:
   */
  async reset() {
    try {
      return await SV.reset(this._MGSceneViewId);
    } catch (error) {
      console.error(error);
    }
  }

  async getFlyManager() {
    try {
      let fly = new FlyManager();
      let obj = await SV.getFlyManager(this._MGSceneViewId);
      fly._MGFlyManagerId =obj.flyManagerId;
      return fly;
    } catch (error) {
      console.error(error)
    }
  }


  /**
   * @Description:设置光照模式
   * @param {type}
   * @return:成功返回1,失败返回0
   */
  async setSunLightingMode(sunLightingMode) {
    try {
      return await SV.setSunLightingMode(this._MGSceneViewId, sunLightingMode);
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @Description:获取光照模式
   * @param {type}
   * @return: 光照模式
   */
  async getSunLightingMode() {
    try {
      let sunLightingMode = await SV.getSunLightingMode(this._MGSceneViewId);
      return sunLightingMode;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @Description: 设置场景 ，异步方法
   * @param {type} sceneId 需要设置加载场景的ID
   * @return:
   */
  async setSceneAsync(sceneId) {
    try {
      await SV.setSceneAsync(this._MGSceneViewId, sceneId);
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 设置是否开启自动裁剪
   * @param {boolean} enableAutoClipPlane
   * @return:
   */
  async setAutoClipPlaneEnabled(enableAutoClipPlane) {
    try {
      let result = await SV.setAutoClipPlaneEnabled(
        this._MGSceneViewId,
        enableAutoClipPlane
      );

      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 跳转到指定视点
   * @param {String} viewPointId 要跳转到的视点id
   * @param {double} durationSec 持续时间，单位秒
   * @return: 成功返回1,失败返回0
   */
  async jumptoViewPoint(viewPointId, durationSec) {
    try {
      let result = SV.jumptoViewPoint(
        this._MGSceneViewId,
        viewPointId,
        durationSec
      );

      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 返回拾取结果的id
   * @param {String} layer3DId 需要拾取的图层的id
   * @param {String} screenPointId 屏幕坐标
   * @param {double} tolerance 容差
   * @param {int} maxResult 最大结果返回数
   * @return:
   */
  async identifyLayer(layer3DId, screenPointId, tolerance, maxResult) {
    try {
      let identifyLayerResultId = await SV.identifyLayer(
        this._MGSceneViewId,
        layer3DId,
        screenPointId,
        tolerance,
        maxResult
      );

      return identifyLayerResultId;
    } catch (error) {
      console.error(error);
    }
  }
  /**
   * 获取grphicsOverlay
   */
  async getDefaultGraphics3DOverlay() {
    try {
      let result = await SV.getDefaultGraphics3DOverlay(this._MGSceneViewId);
      let graphicOverlay = new Graphic3DsOverlay();
      graphicOverlay._MGGraphic3DsOverlayId = result;
      return graphicOverlay;
    } catch (e) {
      console.error(e)
    }
  }

  async registerTapListener() {
    try {
      let result = await SV.registerTapListener(this._MGSceneViewId);

      return result;
    } catch (error) {
      console.error(error);
    }
  }

  async unregisterTapListener() {
    try {
      let result = await SV.unregisterTapListener(this._MGSceneViewId);

      return result;
    } catch (error) {
      console.error(error);
    }
  }
}
