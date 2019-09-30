/*
 * @Description: In User Settings Edit
 * @author: lidafeng 
 * @Date: 2019-09-19 15:48:58
 * @LastEditTime: 2019-09-20 10:14:15
 * @LastEditors: mayuanye
 */
import { NativeModules } from 'react-native';
let D3D = NativeModules.JSDot3D;

/**
 * @class Dot3D
 * @description 实现对三维坐标点的类型定义
 */
export default class Dot3D {
  /**
   * 构造一个新的Dot3D对象。有两种构造方法：
   * （1）无参构造
   * （2）通过createObj(x,y,z)构造，x,y,z均为double范围的Number
   * @memberof Dot3D
   * @returns {Promise<Dot3D>}
   */
  async createObj() {
    try {
      if (
        typeof arguments[0] === 'number' &&
        typeof arguments[1] === 'number' &&
        typeof arguments[2] === 'number'
      ) {
        let { Dot3DId } = await D3D.createObjByXYZ(
          arguments[0],
          arguments[1],
          arguments[2]
        );
        let dot3D = new Dot3D();
        dot3D._MGDot3DId = Dot3DId;
        return dot3D;
      } else {
        let { Dot3DId } = await D3D.createObj();
        let dot3D = new Dot3D();
        dot3D._MGDot3DId = Dot3DId;
        return dot3D;
      }
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 返回X值
   *
   * @memberof Dot3D
   * @returns {Number} X值（double范围的Number）
   */
  async getX() {
    try {
      let x = await D3D.getX(this._MGDot3DId);
      return x;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 返回y值
   *
   * @memberof Dot3D
   * @returns {Number} y值（double范围的Number）
   */
  async getY() {
    try {
      let y = await D3D.getY(this._MGDot3DId);
      return y;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 返回z值
   *
   * @memberof Dot3D
   * @returns {Number} z值（double范围的Number）
   */
  async getZ() {
    try {
      let z = await D3D.getZ(this._MGDot3DId);
      return z;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置X值
   *
   * @memberof Dot3D
   * @param {Number} x x坐标 （double范围的Number）
   * @returns {Promise<Void>}
   */
  async setX(x) {
    try {
      await D3D.setX(this._MGDot3DId, x);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置y值
   *
   * @memberof Dot3D
   * @param {Number} y x坐标 （double范围的Number）
   * @returns {Promise<Void>}
   */
  async setY(y) {
    try {
      await D3D.setY(this._MGDot3DId, y);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置z值
   *
   * @memberof Dot3D
   * @param {Number} z z坐标 （double范围的Number）
   * @returns {Promise<Void>}
   */
  async setZ(z) {
    try {
      await D3D.setZ(this._MGDot3DId, z);
    } catch (e) {
      console.error(e);
    }
  }
}
