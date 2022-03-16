/*
 * @Description: 场景飞行管理组件
 * @Version: 1.0
 * @Autor: liaoliang
 * @Date: 2020-07-29 10:18:34
 * @LastEditors: liaoliang
 * @LastEditTime: 2020-07-29 16:46:45
 */

import { NativeModules } from 'react-native';

let FM = NativeModules.JSFlyManager;

export default class FlyManager {
  /**
   * @description: 构造一个新的FlyManager对象
   * @param {type}
   * @return:
   */
  async createObj() {
    try {
      var { flyManagerId } = await FM.createObj();
      var flyManager = new FlyManager();
      flyManager._MGFlyManagerId = flyManagerId;
      return flyManager;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 返回本次飞行（即当前整个路线）需要的总时间，单位为秒
   * @param {type}
   * @return:
   */
  async getDuration() {
    try {
      let duration = await FM.getDuration(this._MGFlyManagerId);

      return duration;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 获取对象是否被释放
   * @param {type}
   * @return:
   */
  async getIsLoop() {
    try {
      let isLoop = await FM.getIsLoop(this._MGFlyManagerId);

      return isLoop;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 返回本次飞行的当前进度，单位为秒
   * @param {type}
   * @return:
   */
  async getProgress() {
    try {
      let progress = await FM.getProgress(this._MGFlyManagerId);

      return progress;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 加载文件路径
   * @param {String} strPath
   * @return:
   */
  async loadAnimationsFromPat(strPath) {
    try {
      let result = await FM.loadAnimationsFromPat(
        this._MGFlyManagerId,
        strPath
      );

      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 暂停当前漫游，下次将从当前停止处漫游
   * @param {type}
   * @return:
   */
  async pause() {
    try {
      let result = await FM.pause(this._MGFlyManagerId);

      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 重新开始漫游
   * @param {type}
   * @return:
   */
  async reStart() {
    try {
      let result = await FM.reStart(this._MGFlyManagerId);

      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 继续漫游
   * @param {type}
   * @return:
   */
  async resume() {
    try {
      let result = await FM.resume(this._MGFlyManagerId);

      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 释放对象所占用的资源
   * @param {boolean} isLoop
   * @return:
   */
  async setIsLoop(isLoop) {
    try {
      let result = await FM.setIsLoop(this._MGFlyManagerId, isLoop);

      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 低速漫游
   * @param {type}
   * @return:
   */
  async slowDown() {
    try {
      let result = await FM.slowDown(this._MGFlyManagerId);

      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 高速漫游
   * @param {type}
   * @return:
   */
  async speedUp() {
    try {
      let result = await FM.speedUp(this._MGFlyManagerId);

      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 开始漫游，或继续进行中断的漫游
   * @param {type}
   * @return:
   */
  async start() {
    try {
      let result = await FM.start(this._MGFlyManagerId);

      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @description: 停止当前漫游，下次将从路线起始处漫游
   * @param {type}
   * @return:
   */
  async stop() {
    try {
      let result = await FM.stop(this._MGFlyManagerId);

      return result;
    } catch (error) {
      console.error(error);
    }
  }

  async registerStatusChangedListener() {
    try {
      let result = await FM.registerStatusChangedListener(this._MGFlyManagerId);

      return result;
    } catch (error) {
      console.error(error);
    }
  }

  async unregisterStatusChangedListener() {
    try {
      let result = await FM.unregisterStatusChangedListener(
        this._MGFlyManagerId
      );

      return result;
    } catch (error) {
      console.error(error);
    }
  }
}
