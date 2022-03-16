/*
 * @Description: 三维矩形对象
 * @Version: 1.0
 * @Autor: liaoliang
 * @Date: 2020-07-07 17:26:23
 * @LastEditors: liaoliang
 * @LastEditTime: 2020-07-07 18:20:30
 */

import { NativeModules } from 'react-native';

let R3 = NativeModules.JSRect3D;

export default class Rect3D {
  /**
   * @Description: 构造一个新的Rect3D对象
   * @param {type}
   * @return:
   */
  async createObj() {
    try {
      var { rect3DId } = await R3.createObj();
      var rect3D = new Rect3D();
      rect3D._MGRect3DId = rect3DId;
      return rect3D;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @Description: 带参构造一个新的Rect3D对象
   * @param {type}
   * @return:
   */
  async createObjByXYZ(xMin, yMin, zMin, xMax, yMax, zMax) {
    try {
      var { rect3DId } = await R3.createObjByXYZ(
        xMin,
        yMin,
        zMin,
        xMax,
        yMax,
        zMax
      );
      var rect3D = new Rect3D();
      rect3D._MGRect3DId = rect3DId;
      return rect3D;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @Description: 拷贝三维包围盒
   * @param {type}
   * @return:
   */
  async clone() {
    try {
      var { rect3DId } = await R3.clone(this._MGRect3DId);
      return rect3DId;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @Description: 获取x最大值
   * @param {type}
   * @return:
   */
  async getXMax() {
    try {
      let xMax = await R3.getXMax(this._MGRect3DId);
      return xMax;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @Description: 获取y最大值
   * @param {type}
   * @return:
   */
  async getYMax() {
    try {
      let yMax = await R3.getYMax(this._MGRect3DId);
      return yMax;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @Description: 获取z最大值
   * @param {type}
   * @return:
   */
  async getZMax() {
    try {
      let zMax = await R3.getZMax(this._MGRect3DId);
      return zMax;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @Description: 获取x最小值
   * @param {type}
   * @return:
   */
  async getXMin() {
    try {
      let xMin = await R3.getXMin(this._MGRect3DId);
      return xMin;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @Description: 获取y最小值
   * @param {type}
   * @return:
   */
  async getYMin() {
    try {
      let yMin = await R3.getYMin(this._MGRect3DId);
      return yMin;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @Description: 获取z最小值
   * @param {type}
   * @return:
   */
  async getZMin() {
    try {
      let zMin = await R3.getZMin(this._MGRect3DId);
      return zMin;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @Description: 设置x最大值
   * @param {type}
   * @return:
   */
  async setXMax(xMax) {
    try {
      let result = await R3.setXMax(this._MGRect3DId, xMax);
      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @Description: 设置y最大值
   * @param {type}
   * @return:
   */
  async setYMax(yMax) {
    try {
      let result = await R3.setYMax(this._MGRect3DId, yMax);
      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @Description: 设置z最大值
   * @param {type}
   * @return:
   */
  async setZMax(zMax) {
    try {
      let result = await R3.setZMax(this._MGRect3DId, zMax);
      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @Description: 设置x最小值
   * @param {type}
   * @return:
   */
  async setXMin(xMin) {
    try {
      let result = await R3.setXMin(this._MGRect3DId, xMin);
      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @Description: 设置y最小值
   * @param {type}
   * @return:
   */
  async setYMin(yMin) {
    try {
      let result = await R3.setYMin(this._MGRect3DId, yMin);
      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @Description: 设置z最小值
   * @param {type}
   * @return:
   */
  async setZMin(zMin) {
    try {
      let result = await R3.setZMin(this._MGRect3DId, zMin);
      return result;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * @Description: 将三维包围盒转换为字符串
   * @param {type}
   * @return:
   */
  async toString() {
    try {
      let str = await R3.toString(this._MGRect3DId);
      return str;
    } catch (error) {
      console.error(error);
    }
  }
}
