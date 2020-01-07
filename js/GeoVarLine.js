/**
 * @content 用于对多边形的几何功能组件
 * @author  2019-09-09
 */
import { NativeModules } from 'react-native';

let GVL = NativeModules.JSGeoVarLine;

import GeoLine from './GeoLine.js';
import Dot from './Dot.js';
import Dot3D from './Dot3D.js';

/**
 * @class GeoVarLine
 */
export default class GeoVarLine extends GeoLine {
  constructor() {
    super();
    Object.defineProperty(this, '_MGGeoVarLineId', {
      get: function() {
        return this._MGGeometryId;
      },
      set: function(_MGGeoVarLineId) {
        this._MGGeometryId = _MGGeoVarLineId;
      },
    });
  }

  /**
   * 构造一个新的 GeoVarLine 对象
   * @memberOf GeoVarLine
   * @return {Promise<GeoVarLine>}
   */
  async createObj() {
    try {
      var { GeoVarLineId } = await GVL.createObj();
      var geoVarLine = new GeoVarLine();
      geoVarLine._MGGeoVarLineId = GeoVarLineId;
      return geoVarLine;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取几何对象的类型
   * @memberOf GeoVarLine
   * @return {Promise} 几何对象类型
   */
  async getType() {
    try {
      return await GVL.getType(this._MGGeoVarLineId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 添加2维点
   * @memberOf GeoVarLine
   * @param dot 待添加的二维点坐标
   * @return {Promise}添加成功返回1，失败返回0
   */
  async append2D(dot) {
    try {
      return await GVL.append2D(this._MGGeoVarLineId, dot._MGDotId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 添加3维点
   * @memberOf GeoVarLine
   * @param dot 待添加的三维点坐标
   * @return {Promise}添加成功返回1，失败返回0
   */
  async append3D(dot3D) {
    try {
      return await GVL.append3D(this._MGGeoVarLineId, dot3D._MGDot3DId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 删除坐标点
   * @memberOf GeoVarLine
   * @param index 待删除的点序号
   * @return {Promise}删除成功返回1，失败返回0
   */
  async del(index) {
    try {
      return await GVL.del(this._MGGeoVarLineId, index);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 取2维点
   * @memberOf GeoVarLine
   * @param index 待获取的点序号
   * @return {Promise<Dot>}获取成功返回1，失败返回0
   */
  async get2D(index) {
    try {
      let { point2DId } = await GVL.get2D(this._MGGeoVarLineId, index);
      var dot = new Dot();
      dot._MGDotId = point2DId;
      return dot;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 取3维点
   * @memberOf GeoVarLine
   * @param index 待获取的点序号
   * @return {Promise<Dot3D>}获取成功返回1，失败返回0
   */
  async get3D(index) {
    try {
      let { Dot3DId } = await GVL.get3D(this._MGGeoVarLineId, index);
      var dot3D = new Dot3D();
      dot3D._MGDot3DId = Dot3DId;
      return dot3D;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 取维数
   * @memberOf GeoVarLine
   * @return {Promise}维数
   */
  async getDim() {
    try {
      return await GVL.getDim(this._MGGeoVarLineId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 取点数目
   * @memberOf GeoVarLine
   * @return {Promise}点的数目
   */
  async getDotNum() {
    try {
      return await GVL.getDotNum(this._MGGeoVarLineId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 取X坐标值
   * @memberOf GeoVarLine
   * @param index 待获取的点序号
   * @return {Promise}获取该点的X坐标值
   */
  async getX(index) {
    try {
      return await GVL.getX(this._MGGeoVarLineId, index);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 取Y坐标值
   * @memberOf GeoVarLine
   * @param index 待获取的点序号
   * @return {Promise}获取该点的Y坐标值
   */
  async getY(index) {
    try {
      return await GVL.getY(this._MGGeoVarLineId, index);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 取Z坐标值
   * @memberOf GeoVarLine
   * @param index 待获取的点序号
   * @return {Promise}获取该点的Z坐标值
   */
  async getZ(index) {
    try {
      return await GVL.getZ(this._MGGeoVarLineId, index);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 更新2维坐标点
   * @memberOf GeoVarLine
   * @param index 待更新的点序号
   * @param dot 待更新的点坐标
   * @return {Promise}更新成功返回1，失败返回0
   */
  async update2D(index, dot) {
    try {
      return await GVL.update2D(this._MGGeoVarLineId, index, dot._MGDotId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 更新3维坐标点
   * @memberOf GeoVarLine
   * @param index 待更新的点序号
   * @param dot 待更新的点坐标
   * @return {Promise}更新成功返回1，失败返回0
   */
  async update3D(index, dot) {
    try {
      return await GVL.update3D(this._MGGeoVarLineId, index, dot._MGDot3DId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 由三维点集合构建折线
   * @memberOf GeoVarLine
   * @param dots 用来构建线的三维点集合
   * @return {Promise}构建成功返回1，失败返回0
   */
  async setDots3D(dots) {
    try {
      return await GVL.setDots3D(this._MGGeoVarLineId, dots._MGDots3DId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 由二维点集合构建折线
   * @memberOf GeoVarLine
   * @param dots 用来构建线的二维维点集合
   * @return {Promise}构建成功返回1，失败返回0
   */
  async setDots2D(dots) {
    try {
      return await GVL.setDots2D(this._MGGeoVarLineId, dots._MGDotsId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 判断线段是否封闭
   * @memberOf GeoVarLine
   * @return {Promise}线段封闭返回true，不封闭返回false
   */
  async isClosed() {
    try {
      return await GVL.isClosed(this._MGGeoVarLineId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 清空数据
   * @memberOf GeoVarLine
   * @return {Promise}清空数据成功返回1，失败返回0
   */
  async empty() {
    try {
      return await GVL.empty(this._MGGeoVarLineId);
    } catch (e) {
      console.error(e);
    }
  }
}
