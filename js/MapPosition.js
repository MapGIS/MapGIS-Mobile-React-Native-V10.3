/**
 * @content 地图位置组件
 * @author fjl 2019-7-30 下午2:52:36
 */
import { NativeModules } from 'react-native';
import Dot from './Dot.js';

let MP = NativeModules.JSMapPosition;

/**
 * @class MapPosition
 */
export default class MapPosition {
  /**
   * 构造一个新的 MapPosition 对象。
   * @memberOf MapPosition
   * @returns {Promise.<MapPosition>}
   */
  async createObj() {
    try {
      if (
        typeof arguments[0] === 'String' &&
        typeof arguments[1] === 'number' &&
        typeof arguments[2] === 'String' &&
        typeof arguments[3] === 'number' &&
        typeof arguments[4] === 'number'
      ) {
        var { mapPositionId } = await MP.createObj(
          arguments[0],
          arguments[1],
          arguments[2],
          arguments[3],
          arguments[4]
        );
        var mapPosition = new MapPosition();
        mapPosition._MMapPosition = mapPositionId;
        return mapPosition;
      } else {
        var { mapPositionId } = await MP.createObj();
        var mapPosition = new MapPosition();
        mapPosition._MMapPosition = mapPositionId;
        return mapPosition;
      }
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取地图中心点
   * @memberOf MapPosition
   * @returns {Promise<*>}
   */
  async getCenter() {
    try {
      var { point2DId } = await MP.getCenter(this._MMapPosition);
      var dot = new Dot();
      dot._MGDotId = point2DId;
      return dot;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置地图中心点
   * @memberOf MapPosition
   * @param center
   * @returns {Promise<void>}
   */
  async setCenter(center) {
    try {
      await MP.setCenter(this._MMapPosition, center._MGDotId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置地图中心点
   * @memberOf MapPosition
   * @param centerX
   * @param centerY
   * @returns {Promise<void>}
   */
  async setCenterByXY(centerX, centerY) {
    try {
      await MP.setCenter(this._MMapPosition, centerX, centerY);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取地图分辨率
   * @memberOf MapPosition
   * @returns {Promise<*>}
   */
  async getResolution() {
    try {
      var { resolution } = await MP.getResolution(this._MMapPosition);
      return resolution;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置地图分辨率
   * @param resolution
   * @returns {Promise<void>}
   */
  async setResolution(resolution) {
    try {
      await MP.setResolution(this._MMapPosition, resolution);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取地图旋转中心点
   * @memberOf MapPosition
   * @returns {Promise<*>}
   */
  async getRotateCenter() {
    try {
      var { point2DId } = await MP.getRotateCenter(this._MMapPosition);
      var dot = new Dot();
      dot._MGDotId = point2DId;
      return dot;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置地图旋转中心
   * @memberOf MapPosition
   * @param center
   * @returns {Promise<void>}
   */
  async setRotateCenter(center) {
    try {
      await MP.setRotateCenter(this._MMapPosition, center._MGDotId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置地图旋转中心
   * @memberOf MapPosition
   * @param rotateCenterX
   * @param rotateCenterY
   * @returns {Promise<void>}
   */
  async setRotateCenterByXY(rotateCenterX, rotateCenterY) {
    try {
      await MP.setRotateCenter(
        this._MMapPosition,
        rotateCenterX,
        rotateCenterY
      );
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取旋转角
   * @memberOf MapPosition
   * @returns {Promise<*>}
   */
  async getRotateAngle() {
    try {
      let rotateAngle = await MP.getRotateAngle(this._MMapPosition);
      return rotateAngle;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置旋转角
   * @memberOf MapPosition
   * @param rotateAngle
   * @returns {Promise<void>}
   */
  async setRotateAngle(rotateAngle) {
    try {
      await MP.setRotateAngle(this._MMapPosition, rotateAngle);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取倾斜角
   * @memberOf MapPosition
   * @returns {Promise<*>}
   */
  async getSlopeAngle() {
    try {
      let slopeAngle = await MP.getSlopeAngle(this._MMapPosition);
      return slopeAngle;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置倾斜角
   * @memberOf MapPosition
   * @param slopeAngle
   * @returns {Promise<void>}
   */
  async setSlopeAngle(slopeAngle) {
    try {
      await MP.setSlopeAngle(this._MMapPosition, slopeAngle);
    } catch (e) {
      console.error(e);
    }
  }
}
