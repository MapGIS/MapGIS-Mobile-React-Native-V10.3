/*
 * @Description: In User Settings Edit
 * @Author: xiaoying
 * @Date: 2019-08-22 17:10:01
 * @LastEditTime: 2019-08-31 13:33:20
 * @LastEditors: Please set LastEditors
 */
import { NativeModules } from 'react-native';
let SR = NativeModules.JSSRefData;

/**
 * @class SRefData
 * @description android空间参考系对象功能组件
 */
export default class SRefData {
  /**
   * 构造一个新的SRefData对象。
   * @memberof SRefData
   * @returns {Promise.<SRefData>}
   */
  async createObj() {
    try {
      var { SRefDataId } = await SR.createObj();
      var sRefData = new SRefData();
      sRefData._MGSRefDataId = SRefDataId;
      return sRefData;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取空间坐标系在地理数据库中的唯一标识
   * @memberOf SRefData
   * @returns {Promise<*>}
   */
  async getSRSID() {
    try {
      let srsID = await SR.getSRSID(this._MGSRefDataId);
      return srsID;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置空间坐标系在地理数据库中的唯一标识
   * @memberOf SRefData
   * @param {int} srsID 空间坐标系在地理数据库中的唯一标识
   * @returns {Promise<*>}
   */
  async setSRSID(srsID) {
    try {
      await SR.setSRSID(this._MGSRefDataId, srsID);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取名称
   * @memberOf SRefData
   * @returns{String}
   */
  async getSRSName() {
    try {
      let srsName = await SR.getSRSName(this._MGSRefDataId);
      return srsName;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置名称
   * @memberOf SRefData
   * @param {String} name 名称
   * @returns {Promise<*>}
   */
  async setSRSName(name) {
    try {
      await SR.setSRSName(this._MGSRefDataId, name);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取别名
   * @memberof SRefData
   * @returns {String}
   */
  async getAlias() {
    try {
      let alias = await SR.getAlias(this._MGSRefDataId);
      return alias;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置别名
   * @memberof SRefData
   * @param {String} alias 别名
   * @returns {Promise<*>}
   */
  async setAlias(alias) {
    try {
      await SR.setAlias(this._MGSRefDataId, alias);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取缩写
   * @memberof SRefData
   * @returns {String}
   */
  async getAbbreviation() {
    try {
      let abbreviation = await SR.getAbbreviation(this._MGSRefDataId);
      return abbreviation;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置缩写
   * @memberof SRefData
   * @param {String} abbreviation 缩写
   * @returns {Promise<*>}
   */
  async setAbbreviation(abbreviation) {
    try {
      await SR.setAbbreviation(this._MGSRefDataId, abbreviation);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取备注
   * @memberof SRefData
   * @returns {String}
   */
  async getRemark() {
    try {
      let remark = await SR.getRemark(this._MGSRefDataId);
      return remark;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置备注
   * @memberof SRefData
   * @param {String} remark 备注
   * @returns {Promise<*>}
   */
  async setRemark(remark) {
    try {
      await SR.setRemark(this._MGSRefDataId, remark);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取类型
   * @memberof SRefData
   * @returns {int}
   */
  async getType() {
    try {
      let type = await SR.getType(this._MGSRefDataId);
      return type;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置空间参考系类型
   * @memberof SRefData
   * @param {int} type 类型
   * @returns {Promise<*>}
   */
  async setType(type) {
    try {
      await SR.setType(this._MGSRefDataId, type);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取地理坐标系名称
   * @memberof SRefData
   * @returns {String}
   */
  async getGCSName() {
    try {
      let gcsName = await SR.getGCSName(this._MGSRefDataId);
      return gcsName;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置地理坐标系名称
   * @param {String} gcsName 地理坐标系名称
   * @memberof SRefData
   * @returns {Promise<*>}
   */
  async setGCSName(gcsName) {
    try {
      await SR.setGCSName(this._MGSRefDataId, gcsName);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取椭球体索引
   * @memberof SRefData
   * @returns {int}
   */
  async getSpheroid() {
    try {
      let spheroid = await SR.getSpheroid(this._MGSRefDataId);
      return spheroid;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置椭球体索引
   * @memberof SRefData
   * @param {int} spheroid  椭球体索引
   * @returns {Promise<*>}
   */
  async setSpheroid(spheroid) {
    try {
      await SR.setSpheroid(this._MGSRefDataId, spheroid);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取地球椭球长轴
   * @memberof SRefData
   * @returns {double}
   */
  async getA() {
    try {
      let a = await SR.getA(this._MGSRefDataId);
      return a;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置地球椭球长轴
   * @memberof SRefData
   * @param {double} a 地球椭球长轴
   * @returns {Promise<*>}
   */
  async setA(a) {
    try {
      await SR.setA(this._MGSRefDataId, a);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取地球椭球短轴
   * @memberof SRefData
   * @returns {double}
   */
  async getB() {
    try {
      let b = await SR.getB(this._MGSRefDataId);
      return b;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置地球椭球短轴
   * @memberof SRefData
   * @param {double} b 地球椭球短轴
   * @returns {Promise<*>}
   */
  async setB(b) {
    try {
      await SR.setB(this._MGSRefDataId, b);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取地球椭球扁率
   * @memberof SRefData
   * @returns {double}
   */
  async getAf() {
    try {
      let af = await SR.getAf(this._MGSRefDataId);
      return af;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置地球椭球扁率
   * @memberof SRefData
   * @param {double} af 地球椭球扁率
   * @returns {Promise<*>
   */
  async setAf(af) {
    try {
      await SR.setAf(this._MGSRefDataId, af);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取本初子午线(Prime Meridian)名称
   * @memberof SRefData
   * @returns {String}
   */
  async getPMName() {
    try {
      let pmName = await SR.getPMName(this._MGSRefDataId);
      return pmName;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置本初子午线(Prime Meridian)名称
   * @memberof SRefData
   * @param {String} pmName 本初子午线(Prime Meridian)名称
   * @returns {Promise<*>}
   */
  async setPMName(pmName) {
    try {
      await SR.setPMName(this._MGSRefDataId, pmName);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取本初子午线与国标偏移量(DMS)
   * @memberof SRefData
   * @returns {double}
   */
  async getPMOffset() {
    try {
      let pmOffset = await SR.getPMOffset(this._MGSRefDataId);
      return pmOffset;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置本初子午线与国标偏移量(DMS)
   * @memberof SRefData
   * @param {double} pmOffset 本初子午线与国标偏移量(DMS)
   * @returns {Promise<*>}
   */
  async setPMOffset(pmOffset) {
    try {
      await SR.setPMOffset(this._MGSRefDataId, pmOffset);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取几何码
   * @memberof SRefData
   * @returns {String}
   */
  async getGeoCode() {
    try {
      let geoCode = await SR.getGeoCode(this._MGSRefDataId);
      return geoCode;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置几何码
   * @memberof SRefData
   * @param {String} geoCode 几何码
   * @returns {Promise<*>}
   */
  async setGeoCode(geoCode) {
    try {
      await SR.setGeoCode(this._MGSRefDataId, geoCode);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取投影坐标系名称
   * @memberof sRefData
   * @returns {String}
   */
  async getPCSName() {
    try {
      let pcsName = await SR.getPCSName(this._MGSRefDataId);
      return pcsName;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置投影坐标系名称
   * @memberof SRefData
   * @param {String} pcsName 投影坐标系名称
   * @returns {Promise<*>}
   */
  async setPCSName(pcsName) {
    try {
      await SR.setPCSName(this._MGSRefDataId, pcsName);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取投影名
   * @memberof SRefData
   * @returns {String}
   */
  async getProjName() {
    try {
      let projName = await SR.getProjName(this._MGSRefDataId);
      return projName;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置投影名
   * @memberof SRefData
   * @param {String} projName 投影名
   * @returns {Promise<*>}
   */
  async setProjName(projName) {
    try {
      await SR.setProjName(this._MGSRefDataId, projName);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取空间数据投影类型索引
   * @memberof SRefData
   * @returns {int}
   */
  async getProjTypeID() {
    try {
      let projTypeID = await SR.getProjTypeID(this._MGSRefDataId);
      return projTypeID;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置空间数据投影类型索引
   * @memberof SRefData
   * @param {int} projTypeID 空间数据投影类型索引
   * @returns {Promise<*>}
   */
  async setProjTypeID(projTypeID) {
    try {
      await SR.setProjTypeID(this._MGSRefDataId, projTypeID);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取投影分带类型
   * @memberof SRefData
   * @returns {int}
   */
  async getZoneType() {
    try {
      let zoneType = await SR.getZoneType(this._MGSRefDataId);
      return zoneType;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置投影分带类型
   * @memberof SRefData
   * @param {int} zoneType 投影分带类型
   * @returns {Promise<*>}
   */
  async setZoneType(zoneType) {
    try {
      await SR.setZoneType(this._MGSRefDataId, zoneType);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取投影带号
   * @memberof SRefData
   * @returns {int}
   */
  async getZone() {
    try {
      let zone = await SR.getZone(this._MGSRefDataId);
      return zone;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置投影带号
   * @memberof SRefData
   * @param {int} zone 投影带号
   * @returns {Promise<*>}
   */
  async setZone(zone) {
    try {
      await SR.setZone(this._MGSRefDataId, zone);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取空间数据中央经线经度
   * @memberof SRefData
   * @returns {double}
   */
  async getLon() {
    try {
      let lon = await SR.getLon(this._MGSRefDataId);
      return lon;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置空间数据中央经线经度
   * @memberof SRefData
   * @param {double} lon 设置空间数据中央经线经度
   * @returns {Promise<*>}
   */
  async setLon(lon) {
    try {
      await SR.setLon(this._MGSRefDataId, lon);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取空间数据双经线1 经度
   * @memberof SRefData
   * @returns {double}
   */
  async getLon1() {
    try {
      let lon1 = await SR.getLon1(this._MGSRefDataId);
      return lon1;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置空间数据双经线1经度
   * @memberof SRefData
   * @param {double} lon1 空间数据双经线1经度
   * @returns {Promise<*>}
   */
  async setLon1(lon1) {
    try {
      await SR.setLon1(this._MGSRefDataId, lon1);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取空间数据双经线2经度
   * @memberof SRefData
   * @returns {double}
   */
  async getLon2() {
    try {
      let lon2 = await SR.getLon2(this._MGSRefDataId);
      return lon2;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置空间数据双经线2 经度
   * @memberof SRefData
   * @param {double} lon2 空间数据双经线2 经度
   * @returns {Promise<*>}
   */
  async setLon2(lon2) {
    try {
      await SR.setLon2(this._MGSRefDataId, lon2);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取空间数据投影原点纬度
   * @memberof SRefData
   * @returns {double}
   */
  async getLat() {
    try {
      let lat = await SR.getLat(this._MGSRefDataId);
      return lat;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置空间数据投影原点纬度
   * @memberof SRefData
   * @param {double} lat 空间数据投影原点纬度
   * @returns {Promise<*>}
   */
  async setLat(lat) {
    try {
      await SR.setLat(lat);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取空间数据双纬线1 纬度
   * @memberof SRefData
   * @returns {double}
   */
  async getLat1() {
    try {
      let lat1 = await SR.getLat1(this._MGSRefDataId);
      return lat1;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置空间数据双纬线1 纬度
   * @memberof SRefData
   * @param {double} lat1 空间数据双纬线1 纬度
   * @returns {Promise<*>}
   */
  async setLat1(lat1) {
    try {
      await SR.setLat1(this._MGSRefDataId, lat1);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取空间数据双纬线2 纬度
   * @memberof SRefData
   * @returns {double}
   */
  async getLat2() {
    try {
      let lat2 = await SR.getLat2(this._MGSRefDataId);
      return lat2;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置空间数据双纬线2 纬度
   * @memberof SRefData
   * @param {double} lat2 空间数据双纬线2 纬度
   * @returns {Promise<*>}
   */
  async setLat2(lat2) {
    try {
      await SR.setLat2(this._MGSRefDataId, lat2);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取投影东偏
   * @memberof SRefData
   * @returns {double}
   */
  async getFalseE() {
    try {
      let falseE = await SR.getFalseE(this._MGSRefDataId);
      return falseE;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置投影东偏
   * @memberof SRefData
   * @param {double} falseE 投影东偏
   * @returns {Promise<*>}
   */
  async setFalseE(falseE) {
    try {
      await SR.setFalseE(this._MGSRefDataId, falseE);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取投影北偏
   * @memberof SRefData
   * @returns {double}
   */
  async getFalseN() {
    try {
      let falseN = await SR.getFalseN(this._MGSRefDataId);
      return falseN;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置投影北偏
   * @memberof SRefData
   * @param {double} falseN 投影北偏
   * @returns {Promise<*>}
   */
  async setFalseN(falseN) {
    try {
      await SR.setFalseN(this._MGSRefDataId, falseN);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取图纸坐标原点在投影坐标系中的x值
   * @memberof SRefData
   * @returns {double}
   */
  async getX() {
    try {
      let x = await SR.getX(this._MGSRefDataId);
      return x;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取图纸坐标原点在投影坐标系中的x值
   * @memberof SRefData
   * @param {double} x 图纸坐标原点在投影坐标系中的x值
   * @returns {Promise<*>}
   */
  async setX(x) {
    try {
      await SR.setX(this._MGSRefDataId, x);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取图纸坐标原点在投影坐标系中的y值
   * @memberof SRefData
   * @returns {double}
   */
  async getY() {
    try {
      let y = await SR.getY(this._MGSRefDataId);
      return y;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * 设置图纸坐标原点在投影坐标系中的y值
   * @memberof SRefData
   * @param {double} y 图纸坐标原点在投影坐标系中的y值
   * @returns {Promise<*>}
   */
  async setY(y) {
    try {
      await SR.setY(this._MGSRefDataId, y);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取数据维数
   * @memberof SRefData
   * @returns {int}
   */
  async getDimension() {
    try {
      let dimension = await SR.getDimension(this._MGSRefDataId);
      return dimension;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置数据维数
   * @memberof SRefData
   * @param {int} dimension 数据维数
   * @returns {Promise<*>}
   */
  async setDimension(dimension) {
    try {
      await SR.setDimension(this._MGSRefDataId, dimension);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取0轴名
   * @memberof SRefData
   * @returns {String}
   */
  async getAxisName0() {
    try {
      let axisName0 = await SR.getAxisName0(this._MGSRefDataId);
      return axisName0;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置0轴名
   * @memberof SRefData
   * @param {String} axisName0 0轴名
   * @returns {Promise<*>}
   */
  async setAxisName0(axisName0) {
    try {
      await SR.setAxisName0(this._MGSRefDataId, axisName0);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取0轴单位
   * @memberof SRefData
   * @returns {int}
   */
  async getAxisUnit0() {
    try {
      let axisUnit0 = await SR.getAxisUnit0(this._MGSRefDataId);
      return axisUnit0;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置0轴单位
   * @memberof SRefData
   * @param {int} axisUnit0 0轴单位
   * @returns {Promise<*>}
   */
  async setAxisUnit0(axisUnit0) {
    try {
      await SR.setAxisUnit0(this._MGSRefDataId, axisUnit0);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取0轴最小值
   * @memberof SRefData
   * @returns {double}
   */
  async getAxisMin0() {
    try {
      let axisMin0 = await SR.getAxisMin0(this._MGSRefDataId);
      return axisMin0;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置0轴最小值
   * @memberof SRefData
   * @param {double} axisMin0 0轴最小值
   * @returns {Promise<*>}
   */
  async setAxisMin0(axisMin0) {
    try {
      await SR.setAxisMin0(this._MGSRefDataId, axisMin0);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取0轴最大值
   * @memberof SRefData
   * @returns {double}
   */
  async getAxisMax0() {
    try {
      let axisMax0 = await SR.getAxisMax0(this._MGSRefDataId);
      return axisMax0;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置0轴最大值
   * @memberof SRefData
   * @param {double} axisMax0 0轴最大值
   * @returns {Promise<*>}
   */
  async setAxisMax0(axisMax0) {
    try {
      await SR.setAxisMax0(this._MGSRefDataId, axisMax0);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取0轴精度
   * @memberof SRefData
   * @returns {double}
   */
  async getPrecision0() {
    try {
      let precision0 = await SR.getPrecision0(this._MGSRefDataId);
      return precision0;
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * 设置0轴精度
   * @memberof SRefData
   * @param {double} precision0 0轴精度
   * @returns {Promise<*>}
   */
  async setPrecision0(precision0) {
    try {
      await SR.setPrecision0(this._MGSRefDataId, precision0);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取1轴名
   * @memberof SRefData
   * @returns {String}
   */
  async getAxisName1() {
    try {
      let axisName1 = await SR.getAxisName1(this._MGSRefDataId);
      return axisName1;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置1轴名
   * @memberof SRefData
   * @param {String} axisName1 1轴名
   * @returns {Promise<*>}
   */
  async setAxisName1(axisName1) {
    try {
      await SR.setAxisName1(this._MGSRefDataId, axisName1);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取1轴单位
   * @memberof SRefData
   * @returns {int}
   */
  async getAxisUnit1() {
    try {
      let axisUnit1 = await SR.getAxisUnit1(this._MGSRefDataId);
      return axisUnit1;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置1轴单位
   * @memberof SRefData
   * @param {int} axisUnit1 1轴单位
   * @returns {Promise<*>}
   */
  async setAxisUnit1(axisUnit1) {
    try {
      await SR.setAxisUnit1(this._MGSRefDataId, axisUnit1);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取1轴最小值
   * @memberof SRefData
   * @returns {double}
   */
  async getAxisMin1() {
    try {
      let axisMin1 = await SR.getAxisMin1(this._MGSRefDataId);
      return axisMin1;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置1轴最小值
   * @memberof SRefData
   * @param {double} axisMin1 1轴最小值
   * @returns {Promise<*>}
   */
  async setAxisMin1(axisMin1) {
    try {
      await SR.setAxisMin1(this._MGSRefDataId, axisMin1);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取1轴最大值
   * @memberof SRefData
   * @returns {double}
   */
  async getAxisMax1() {
    try {
      let axisMax1 = await SR.getAxisMax1(this._MGSRefDataId);
      return axisMax1;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置1轴最大值
   * @memberof SRefData
   * @param {double} axisMax1 1轴最大值
   * @returns {Promise<*>}
   */
  async setAxisMax1(axisMax1) {
    try {
      await SR.setAxisMax1(this._MGSRefDataId, axisMax1);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取1轴精度
   * @memberof SRefData
   * @returns {double}
   */
  async getPrecision1() {
    try {
      let precision1 = await SR.getPrecision1(this._MGSRefDataId);
      return precision1;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置1轴精度
   * @memberof SRefData
   * @param {double} precision1 1轴精度
   * @returns {Promise<*>}
   */
  async setPrecision1(precision1) {
    try {
      await SR.setPrecision1(this._MGSRefDataId, precision1);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取2轴名
   * @memberof SRefData
   * @returns {String}
   */
  async getAxisName2() {
    try {
      let axisName2 = await SR.getAxisName2(this._MGSRefDataId);
      return axisName2;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置2轴名
   * @memberof SRefData
   * @param {String} axisName2 2轴名
   * @returns {Promise<*>}
   */
  async setAxisName2(axisName2) {
    try {
      await SR.setAxisName2(this._MGSRefDataId, axisName2);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取2轴单位
   * @memberof SRefData
   * @returns {int}
   */
  async getAxisUnit2() {
    try {
      let axisUnit2 = await SR.getAxisUnit2(this._MGSRefDataId);
      return axisUnit2;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置2轴单位
   * @memberof SRefData
   * @param {int} axisUnit2 2轴单位
   * @returns {Promise<*>}
   */
  async setAxisUnit2(axisUnit2) {
    try {
      await SR.setAxisUnit2(axisUnit2);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取2轴最小值
   * @memberof SRefData
   * @returns {double}
   */
  async getAxisMin2() {
    try {
      let axisMin2 = await SR.getAxisMin2(this._MGSRefDataId);
      return axisMin2;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置2轴最小值
   * @memberof SRefData
   * @param {double} axisMin2 2轴最小值
   * @returns {Promise<*>}
   */
  async setAxisMin2(axisMin2) {
    try {
      await SR.setAxisMin2(this._MGSRefDataId, axisMin2);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取2轴最大值
   * @memberof SRefData
   * @returns {double}
   */
  async getAxisMax2() {
    try {
      let axisMax2 = await SR.getAxisMax2(this._MGSRefDataId);
      return axisMax2;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置2轴最大值
   * @memberof SRefData
   * @param {double} axisMax2 2轴最大值
   * @returns {Promise<*>}
   */
  async setAxisMax2(axisMax2) {
    try {
      await SR.setAxisMax2(this._MGSRefDataId, axisMax2);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取2轴精度
   * @memberof SRefData
   * @returns {double}
   */
  async getPrecision2() {
    try {
      let precision2 = await SR.getPrecision2(this._MGSRefDataId);
      return precision2;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置2轴精度
   * @memberof SRefData
   * @param {double} precision2 2轴精度
   * @returns {Promise<*>}
   */
  async setPrecision2(precision2) {
    try {
      await SR.setPrecision2(precision2);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取3轴名
   * @memberof SRefData
   * @returns {String}
   */
  async getAxisName3() {
    try {
      let axisName3 = await SR.getAxisName3(this._MGSRefDataId);
      return axisName3;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置3轴名
   * @memberof SRefData
   * @param {String} axisName3 3轴名
   * @returns {Promise<*>}
   */
  async setAxisName3(axisName3) {
    try {
      await SR.setAxisName3(this._MGSRefDataId, axisName3);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取3轴单位
   * @memberof SRefData
   * @returns {int}
   */
  async getAxisUnit3() {
    try {
      let axisUnit3 = await SR.getAxisUnit3(this._MGSRefDataId);
      return axisUnit3;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置3轴单位
   * @memberof SRefData
   * @param {int} axisUnit3 3轴单位
   * @returns {Promise<*>}
   */
  async setAxisUnit3(axisUnit3) {
    try {
      await SR.setAxisUnit3(this._MGSRefDataId, axisUnit3);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取3轴最小值
   * @memberof SRefData
   * @returns {double}
   */
  async getAxisMin3() {
    try {
      let axisMin3 = await SR.getAxisMin3(this._MGSRefDataId);
      return axisMin3;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置3轴最小值
   * @memberof SRefData
   * @param {double} axisMin3 3轴最小值
   * @returns {Promise<*>}
   */
  async setAxisMin3(axisMin3) {
    try {
      await SR.setAxisMin3(this._MGSRefDataId, axisMin3);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取3轴最大值
   * @memberof SRefData
   * @returns {double}
   */
  async getAxisMax3() {
    try {
      let axisMax3 = await SR.getAxisMax3(this._MGSRefDataId);
      return axisMax3;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置3轴最大值
   * @memberof SRefData
   * @param {double} axisMax3 3轴最大值
   * @returns {Promise<*>}
   */
  async setAxisMax3(axisMax3) {
    try {
      await SR.setAxisMax3(this._MGSRefDataId, axisMax3);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取3轴精度
   * @memberof SRefData
   * @returns {double}
   */
  async getPrecision3() {
    try {
      let precision3 = await SR.getPrecision3(this._MGSRefDataId);
      return precision3;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置3轴精度
   * @memberof SRefData
   * @param {double} precision3 3轴精度
   * @returns {Promise<*>}
   */
  async setPrecision3(precision3) {
    try {
      await SR.setPrecision3(this._MGSRefDataId, precision3);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取空间数据水平坐标单位：长度
   * @memberof SRefData
   * @returns {int}
   */
  async getUnit() {
    try {
      let unit = await SR.getUnit(this._MGSRefDataId);
      return unit;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置空间数据水平坐标单位：长度
   * @memberof SRefData
   * @param {int} unit 空间数据水平坐标单位：长度
   * @returns {Promise<*>}
   */
  async setUnit(unit) {
    try {
      await SR.setUnit(this._MGSRefDataId, unit);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取米/unit
   * @memberof SRefData
   * @returns {double}
   */
  async getUnitFactor() {
    try {
      let unitFactor = await SR.getUnitFactor(this._MGSRefDataId);
      return unitFactor;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置米/unit
   * @memberof SRefData
   * @param {double} unitFactor 米/unit
   * @returns {Promise<*>}
   */
  async setUnitFactor(unitFactor) {
    try {
      await SR.setUnitFactor(this._MGSRefDataId, unitFactor);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取空间数据水平坐标单位：角度
   * @memberof SRefData
   * @returns {int}
   */
  async getAngUnit() {
    try {
      let angUnit = await SR.getAngUnit(this._MGSRefDataId);
      return angUnit;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置空间数据水平坐标单位：角度
   * @memberof SRefData
   * @param {int} angUnit 空间数据水平坐标单位：角度
   * @returns {Promise<*>}
   */
  async setAngUnit(angUnit) {
    try {
      await SR.setAngUnit(this._MGSRefDataId, angUnit);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取弧度/unit
   * @memberof SRefData
   * @returns {double}
   */
  async getAngUnitFactor() {
    try {
      let angUnitFactor = await SR.getAngUnitFactor(this._MGSRefDataId);
      return angUnitFactor;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置弧度/unit
   * @memberof SRefData
   * @param {double} angUnitFactor 弧度/unit
   * @returns {Promise<*>}
   */
  async setAngUnitFactor(angUnitFactor) {
    try {
      await SR.setAngUnitFactor(this._MGSRefDataId, angUnitFactor);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取空间数据水平比例尺倒数
   * @memberof SRefData
   * @returns {double}
   */
  async getRate() {
    try {
      let rate = await SR.getRate(this._MGSRefDataId);
      return rate;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置空间数据水平比例尺倒数
   * @memberof SRefData
   * @param {double} rate 空间数据水平比例尺倒数
   * @returns {Promise<*>}
   */
  async setRate(rate) {
    try {
      await SR.setRate(this._MGSRefDataId, rate);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取空间数据大地水准面类型
   * @memberof SRefData
   * @returns {int}
   */
  async getLevelType() {
    try {
      let levelType = await SR.getLevelType(this._MGSRefDataId);
      return levelType;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置空间数据大地水准面类型
   * @memberof SRefData
   * @param {int} levelType 空间数据大地水准面类型
   * @returns {Promise<*>}
   */
  async setLevelType(levelType) {
    try {
      await SR.setLevelType(this._MGSRefDataId, levelType);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取空间数据大地水准面名称
   * @memberof SRefData
   * @returns {String}
   */
  async getLevelName() {
    try {
      let levelName = await SR.getLevelName(this._MGSRefDataId);
      return levelName;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置空间数据大地水准面名称
   * @memberof SRefData
   * @param {String} levelName 空间数据大地水准面名称
   * @returns {Promise<*>}
   */
  async setLevelName(levelName) {
    try {
      await SR.setLevelName(this._MGSRefDataId, levelName);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取当前高程的偏移量
   * @memberof SRefData
   * @returns {double}
   */
  async getLevelOffset() {
    try {
      let levelOffset = await SR.getLevelOffset(this._MGSRefDataId);
      return levelOffset;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置当前高程的偏移量
   * @memberof SRefData
   * @param {double} levelOffset 当前高程的偏移量
   * @returns {Promise<*>}
   */
  async setLevelOffset(levelOffset) {
    try {
      await SR.setLevelOffset(this._MGSRefDataId, levelOffset);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取空间数据大地水准面与参考椭球面之间的高差
   * @memberof SRefData
   * @returns {double}
   */
  async getN() {
    try {
      let n = await SR.getN(this._MGSRefDataId);
      return n;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置空间数据大地水准面与参考椭球面之间的高差
   * @memberof SRefData
   * @param {double} n 空间数据大地水准面与参考椭球面之间的高差
   * @returns {Promise<*>}
   */
  async setN(n) {
    try {
      await SR.setN(this._MGSRefDataId, n);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取空间数据投影平面与大地水准面的高差
   * @memberof SRefData
   * @returns {double}
   */
  async getH() {
    try {
      let h = await SR.getH(this._MGSRefDataId);
      return h;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置空间数据投影平面与大地水准面的高差
   * @memberof SRefData
   * @param {double} h 空间数据投影平面与大地水准面的高差
   * @returns {Promise<*>}
   */
  async setH(h) {
    try {
      await SR.setH(this._MGSRefDataId, h);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取空间数据垂向比例尺倒数
   * @memberof SRefData
   * @returns {double}
   */
  async getVRate() {
    try {
      let vRate = await SR.getVRate(this._MGSRefDataId);
      return vRate;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置空间数据垂向比例尺倒数
   * @memberof SRefData
   * @param {double} vRate 设置空间数据垂向比例尺倒数
   * @returns {Promise<*>}
   */
  async setVRate(vRate) {
    try {
      await SR.setVRate(this._MGSRefDataId, vRate);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取空间数据垂向数据单位
   * @memberof SRefData
   * @returns {int}
   */
  async getVUnit() {
    try {
      let vUnit = await SR.getVUnit(this._MGSRefDataId);
      return vUnit;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置空间数据垂向数据单位
   * @memberof SRefData
   * @param {int} vUnit 空间数据垂向数据单位
   * @returns {Promise<*>}
   */
  async setVUnit(vUnit) {
    try {
      await SR.setVUnit(this._MGSRefDataId, vUnit);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取垂直数据类型
   * @memberof SRefData
   * @returns {int}
   */
  async getVerticalDatumType() {
    try {
      let verticalDatumType = await SR.getVerticalDatumType(this._MGSRefDataId);
      return verticalDatumType;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置垂直数据类型
   * @memberof SRefData
   * @param {int} verticalDatumType 垂直数据类型
   * @returns {Promise<*>}
   */
  async setVerticalDatumType(verticalDatumType) {
    try {
      await SR.setVerticalDatumType(this._MGSRefDataId, verticalDatumType);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 克隆空间参考系对象
   * @memberof SRefData
   * @returns {Promise<SRefData>}
   */
  async clone() {
    try {
      var { SRefDataId } = await SR.clone(this._MGSRefDataId);
      var sRefData = new SRefData();
      sRefData._MGSRefDataId = SRefDataId;
      return sRefData;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 加载
   * @memberof SRefData
   * @param {Array} array int类型的Array
   * @returns {Boolean}
   */
  async load(array) {
    try {
      let loadResult = await SR.load(this._MGSRefDataId, array);
      return loadResult;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 保存
   * @memberof SRefData
   * @returns {Array} int类型的Array
   */
  async save() {
    try {
      let array = await SR.save(this._MGSRefDataId);
      return array;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取Web墨卡托空间参考
   * @memberof SRefData
   * @returns {Promise<SRefData>}
   */
  async getWebMercator() {
    try {
      var { SRefDataId } = await SR.getWebMercator(this._MGSRefDataId);
      var sRefData = new SRefData();
      sRefData._MGSRefDataId = SRefDataId;
      return sRefData;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取WGS 1984空间参考
   * @memberof SRefData
   * @returns {Promise<SRefData>}
   */
  async getWGS84() {
    try {
      var { SRefDataId } = await SR.getWGS84(this._MGSRefDataId);
      var sRefData = new SRefData();
      sRefData._MGSRefDataId = SRefDataId;
      return sRefData;
    } catch (e) {
      console.error(e);
    }
  }
}
