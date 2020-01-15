/**
 * @content 要素编辑功能组件
 * @author  2019-09-25
 */
import { NativeModules } from 'react-native';

let FE = NativeModules.JSFeatureEdit;

/**
 * @class FeatureEdit
 * @description 要素编辑
 */
export default class FeatureEdit {
  /**
   * 构造一个新的 FeatureEdit 对象。
   * @memberOf FeatureEdit
   * @param {VectorLayer} vectorLayer 矢量图层
   * @returns {Promise.<FeatureEdit>} eatureEdit 对象。
   */
  async createObjByVectorLayer(vectorLayer) {
    try {
      var { FeatureEditId } = await FE.createObjByVectorLayer(vectorLayer._MGVectorLayerId);
      var featureEdit = new FeatureEdit();
      featureEdit._MGFeatureEditId = FeatureEditId;
      return featureEdit;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 构造一个新的 FeatureEdit 对象。
   * @memberOf FeatureEdit
   * @param {IVectorCls} cls 矢量类对象基类
   * @returns {Promise.<FeatureEdit>} eatureEdit 对象。
   */
  async createObjByVectorCls(cls) {
    try {
      var { FeatureEditId } = await FE.createObjByVectorCls(cls._MGVectorClsId);
      var featureEdit = new FeatureEdit();
      featureEdit._MGFeatureEditId = FeatureEditId;
      return featureEdit;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 构造一个新的 FeatureEdit 对象。
   * @memberOf FeatureEdit
   * @param {String} strIGServerBaseURL 基地址
   * @param {String} strDocName 地图文档名
   * @param {int} mapID 地图ID
   * @param {int} layerID 图层 ID
   * @returns {Promise.<FeatureEdit>} eatureEdit 对象。
   */
  async createObjByIGSDoc(strIGServerBaseURL, strDocName, mapID, layerID) {
    try {
      var { FeatureEditId } = await FE.createObjByIGSDoc(
        strIGServerBaseURL,
        strDocName,
        mapID,
        layerID
      );
      var featureEdit = new FeatureEdit();
      featureEdit._MGFeatureEditId = FeatureEditId;
      return featureEdit;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 构造一个新的 FeatureEdit 对象。
   * @memberOf FeatureEdit
   * @param {String} strIGServerBaseURL 服务基地址
   * @param {String} strDataURL 数据地址
   * @returns {Promise.<FeatureEdit>} eatureEdit 对象。
   */
  async createObjByIGSData(strIGServerBaseURL, strDataURL) {
    try {
      var { FeatureEditId } = await FE.createObjByIGSData(
        strIGServerBaseURL,
        strDataURL
      );
      var featureEdit = new FeatureEdit();
      featureEdit._MGFeatureEditId = FeatureEditId;
      return featureEdit;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 添加要素
   * @memberOf FeatureEdit
   * @param {Feature} feature 简单要素对象
   * @return {Promise.<int>}添加成功后返回 要素ID
   */
  async append(feature) {
    try {
      return await FE.append(this._MGFeatureEditId, feature._MGFeatureId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 添加要素
   * @memberOf FeatureEdit
   * @param {List<Feature>} featureArray 简单要素对象
   * @return {Promise.<int>} 成功:>0;失败：<=0
   */
  async appendFeatures(featureArray) {
    try {
      return await FE.appendFeatures(this._MGFeatureEditId, featureArray);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 删除要素
   * @memberOf FeatureEdit
   * @param {int} objID 要素ID
   * @return {Promise.<int>} 成功:>0;失败：<=0
   */
  async delete(objID) {
    try {
      return await FE.delete(this._MGFeatureEditId, objID);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 删除一组简单要素
   * @memberOf FeatureEdit
   * @param {long[]} objIDArray 简单要素ID数组
   * @return {Promise.<int>} 成功:>0;失败：<=0
   */
  async deleteobjIDs(objIDArray) {
    try {
      return await FE.deleteObjIDs(this._MGFeatureEditId, objIDArray);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 更新要素
   * @memberOf FeatureEdit
   * @param {int} objID 要素ID
   * @param {Feature} feature 要素对象
   * @return {Promise.<int>} 成功:>0;失败：<=0
   */
  async update(objID, feature) {
    try {
      return await FE.update(
        this._MGFeatureEditId,
        objID,
        feature._MGFeatureId
      );
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 更新要素
   * @memberOf FeatureEdit
   * @param {List<Feature>} features 要素数据集
   * @return {Promise.<int>} 成功:>0;失败：<=0
   */
  async updateFeatures(featureArray) {
    try {
      return await FE.updateFeatures(this._MGFeatureEditId, featureArray);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 创建地理数据类
   * @memberOf FeatureEdit
   * @param {XClsType} clsType 地理类型
   * @param {String} name 名称
   * @param {GeomType} geomType 几何类型
   * @param {String} srefName 空间参考系名称
   * @param {String} dsName 数据集名称
   * @param {Fields} flds 字段属性
   * @return {Promise.<String>} 成功:返回参数返回创建的要素类的GDBP地址;失败：String等于null
   */
  async createClsBySRef(clsType, name, geomType, srefName, dsName, flds) {
    try {
      return await FE.createClsBySRef(
        this._MGFeatureEditId,
        clsType,
        name,
        geomType,
        srefName,
        dsName,
        flds._MGFieldsId
      );
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 创建地理数据类
   * @memberOf FeatureEdit
   * @param {XClsType} clsType 地理类型
   * @param {String} name 名称
   * @param {GeomType} geomType 几何类型
   * @param {Fields} flds 字段属性
   * @return {Promise.<String>} 成功:返回参数返回创建的要素类的GDBP地址;失败：String等于null
   */
  async createCls(clsType, name, geomType, flds) {
    try {
      return await FE.createCls(
        this._MGFeatureEditId,
        clsType,
        name,
        geomType,
        flds._MGFieldsId
      );
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 删除地理数据类
   * @memberOf FeatureEdit
   * @param {XClsType} clsType 地理类型
   * @param {String} name 名称
   * @return {Promise.<int>} 成功:>0;失败：<=0
   */
  async deleteCls(clsType, name) {
    try {
      return await FE.deleteCls(this._MGFeatureEditId, clsType, name);
    } catch (e) {
      console.error(e);
    }
  }
}
