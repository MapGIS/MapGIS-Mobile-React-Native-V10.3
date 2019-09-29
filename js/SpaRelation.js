/**
 * @content 空间关系判断功能组件
 * @author  2019-09-25
 */
import { NativeModules } from 'react-native';

let SPR = NativeModules.JSSpaRelation;

/**
 * @class SpaRelation
 * @description 空间关系判断
 */
export default class SpaRelation {
  /**
   * 构造一个新的 SpaRelation 对象。
   * @memberOf SpaRelation
   * @returns {Promise.<SpaRelation>}
   */
  async createObj() {
    try {
      var { SpaRelationId } = await SPR.createObj();
      var spaRelation = new SpaRelation();
      spaRelation._MGSpaRelationId = SpaRelationId;
      return spaRelation;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取容差
   * @memberOf SpaRelation
   * @return {Promise.<double>}容差
   */
  async getTolerance() {
    try {
      return await SPR.getTolerance(this._MGSpaRelationId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置容差
   * @memberOf SpaRelation
   * @param {double} tolerance 容差
   * @return {Promise.<void>}计算得出的缓冲区
   */
  async setTolerance(tolerance) {
    try {
      return await SPR.setTolerance(this._MGSpaRelationId, tolerance);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 判断点是否在矩形内
   * @memberOf SpaRelation
   * @param {Dot} pnt 点坐标
   * @param {Rect} rc 矩形范围
   * @return {Promise.<int>} 2/1/0=内/边界/外
   */
  static async isDotInRect(pnt, rc) {
    try {
      return await SPR.isDotInRect(pnt._MGDotId, rc._MGRectId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 判断点是否在折线内
   * @memberOf SpaRelation
   * @param {Dot} pnt 点坐标
   * @param {GeoVarLine} lin 线
   * @return {Promise.<int>} 2/1/0=内/边界/外 折线的边界是折线的两个端点，折线的内部是折线除端点以外的部分
   */
  static async isDotInLin(pnt, lin) {
    try {
      return await SPR.isDotInLin(pnt._MGDotId, lin._MGGeoVarLineId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 判断点是否在区内,当pnt点落在dots为边线,esp为半径的BUF区内则认为pnt点落在边界上
   * @memberOf SpaRelation
   * @param {Dot} pnt 点坐标
   * @param {GeoPolygon} reg 区
   * @param {int} flg 1则严格套合，否则只检查第一圈
   * @param {double} esp 半径的BUF区
   * @return {Promise.<int>} 2/1/0=内/边界/外
   */
  static async isDotInReg(pnt, reg, flg, esp) {
    try {
      return await SPR.isDotInReg(pnt._MGDotId, reg._MGGeoPolygonId, flg, esp);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 判断矩形是否在区内
   * @memberOf SpaRelation
   * @param {Rect} rc 矩形范围
   * @param {GeoPolygon} reg 区
   * @param {double} esp 半径的BUF区
   * @return {Promise.<int>} 1-内部；2-外部；0 -相交 如果矩形和多边形有公共边，或者矩形的顶点落在多边形的边上或者多边形的顶点落在矩形的边上都算相交
   */
  static async isRectInReg(rc, reg, esp) {
    try {
      return await SPR.isRectInReg(rc._MGRectId, reg._MGGeoPolygonId, esp);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 判断线是否在区内
   * @memberOf SpaRelation
   * @param {GeoVarLine} lin 线
   * @param {GeoPolygon} reg 区
   * @param {double} esp 半径的BUF区
   * @return {Promise.<int>} 1/0:在内/相交或者在外
   */
  static async isLinInReg(lin, reg, esp) {
    try {
      return await SPR.isLinInReg(
        lin._MGGeoVarLineId,
        reg._MGGeoPolygonId,
        esp
      );
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 判断区reg0是否在区reg1内
   * @memberOf SpaRelation
   * @param {GeoPolygon} reg0 区
   * @param {GeoPolygon} reg1 区
   * @param {double} esp 半径的BUF区
   * @return {Promise.<int>} 1/0 = 内/其他情况
   */
  static async isRegInReg(reg0, reg1, esp) {
    try {
      return await SPR.isRegInReg(
        reg0._MGGeoPolygonId,
        reg1._MGGeoPolygonId,
        esp
      );
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 判断矩形是否和线相交
   * @memberOf SpaRelation
   * @param {Rect} rc 矩形范围
   * @param {GeoVarLine} lin 线
   * @return {Promise.<int>} 1/0 = 内/其他情况 矩形与线相交或者矩形包含线，返回1；否则返回0
   */
  static async isRectInterLin(rc, lin) {
    try {
      return await SPR.isRectInterLin(rc._MGRectId, lin._MGGeoVarLineId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 判断线是否和区相交
   * @memberOf SpaRelation
   * @param {GeoVarLine} lin 线
   * @param {GeoPolygon} reg 区
   * @return {Promise.<int>} 1/0：相交/不相交
   */
  static async isLinInterReg(lin, reg) {
    try {
      return await SPR.isLinInterReg(lin._MGGeoVarLineId, reg._MGGeoPolygonId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 判断区是否和区相交
   * @memberOf SpaRelation
   * @param {GeoPolygon} reg0 第一个区对象
   * @param {GeoPolygon} reg1 第二个区对象
   * @return {Promise.<int>} 1/0：相交/不相交
   */
  static async isRegInterReg(reg0, reg1) {
    try {
      return await SPR.isRegInterReg(
        reg0._MGGeoPolygonId,
        reg1._MGGeoPolygonId
      );
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 包含判断(geom0是否包含geom1)
   * @memberOf SpaRelation
   * @param {Geometry} geom0 第一个几何对象
   * @param {Geometry} geom1 第二个几何对象
   * @return {Promise.<boolean>}包含关系返回true，反之返回false
   */
  async isContains(geom0, geom1) {
    try {
      return await SPR.isContains(
        this._MGSpaRelationId,
        geom0._MGGeometryId,
        geom1._MGGeometryId
      );
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 相交判断(geom0是否和geom1相交)
   * @memberOf SpaRelation
   * @param {Geometry} geom0 第一个几何对象
   * @param {Geometry} geom1 第二个几何对象
   * @return {Promise.<boolean>}相交关系返回true，反之返回false
   */
  async isCrosses(geom0, geom1) {
    try {
      return await SPR.isCrosses(
        this._MGSpaRelationId,
        geom0._MGGeometryId,
        geom1._MGGeometryId
      );
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 相离判断(geom0是否和geom1相离)
   * @memberOf SpaRelation
   * @param {Geometry} geom0 第一个几何对象
   * @param {Geometry} geom1 第二个几何对象
   * @return {Promise.<boolean>}相离关系返回true，反之返回false
   */
  async isDisjoint(geom0, geom1) {
    try {
      return await SPR.isDisjoint(
        this._MGSpaRelationId,
        geom0._MGGeometryId,
        geom1._MGGeometryId
      );
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 相等判断
   * @memberOf SpaRelation
   * @param {Geometry} geom0 第一个几何对象
   * @param {Geometry} geom1 第二个几何对象
   * @return {Promise.<boolean>}相等关系返回true，反之返回false
   */
  async isEquals(geom0, geom1) {
    try {
      return await SPR.isEquals(
        this._MGSpaRelationId,
        geom0._MGGeometryId,
        geom1._MGGeometryId
      );
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 相覆盖 判断
   * @memberOf SpaRelation
   * @param {Geometry} geom0 第一个几何对象
   * @param {Geometry} geom1 第二个几何对象
   * @return {Promise.<boolean>}相覆盖 关系返回true，反之返回false
   */
  async isOverlaps(geom0, geom1) {
    try {
      return await SPR.isOverlaps(
        this._MGSpaRelationId,
        geom0._MGGeometryId,
        geom1._MGGeometryId
      );
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 相邻接 判断
   * @memberOf SpaRelation
   * @param {Geometry} geom0 第一个几何对象
   * @param {Geometry} geom1 第二个几何对象
   * @return {Promise.<boolean>}相邻接 关系返回true，反之返回false
   */
  async isTouches(geom0, geom1) {
    try {
      return await SPR.isTouches(
        this._MGSpaRelationId,
        geom0._MGGeometryId,
        geom1._MGGeometryId
      );
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 被包含 判断
   * @memberOf SpaRelation
   * @param {Geometry} geom0 第一个几何对象
   * @param {Geometry} geom1 第二个几何对象
   * @return {Promise.<boolean>}被包含 关系返回true，反之返回false
   */
  async isWithin(geom0, geom1) {
    try {
      return await SPR.isWithin(
        this._MGSpaRelationId,
        geom0._MGGeometryId,
        geom1._MGGeometryId
      );
    } catch (e) {
      console.error(e);
    }
  }
}
