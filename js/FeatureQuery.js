/**
 * @content 要素类功能组件
 * @author fjl 2019-6-25下午2:52:36
 */
import { NativeModules } from "react-native";

let F = NativeModules.JSFeatureQuery;
import FeaturePagedResult from "./FeaturePagedResult.js";
import QueryBound from "./QueryBound.js";
import Graphic from "./Graphic";

/**
 * @class FeatureQuery
 */
export default class FeatureQuery {
  /**
   * 构造一个新的 FeatureQuery 对象。
   * @memberOf FeatureQuery
   * @param layer
   * @returns {Promise<FeatureQuery>}
   */
  async createObjByProperty(layer) {
    try {
      var { FeatureQueryId } = await F.createObjByProperty(layer._MGMapLayerId);
      var featureQuery = new FeatureQuery();
      featureQuery._MGFeatureQueryId = FeatureQueryId;
      return featureQuery;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置属性查询条件
   * @memberOf FeatureQuery
   * @param whereClause 属性查询条件
   */
  async setWhereClause(whereClause) {
    try {
      await F.setWhereClause(this._MGFeatureQueryId, whereClause);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取要素属性
   * @memberOf FeatureQuery
   */
  async getWhereClause() {
    try {
      let { whereClause } = await F.getWhereClause(this._MGFeatureQueryId);
      return whereClause;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置查询范围
   * @memberOf FeatureQuery
   * @param queryBound 查询范围
   */
  async setQueryBound(queryBound) {
    try {
      await F.setQueryBound(this._MGFeatureQueryId, queryBound._MGQueryBoundId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取查询范围
   *@memberOf FeatureQuery
   * @return 查询范围
   */
  async getQueryBound() {
    try {
      let { QueryBoundID } = await F.getQueryBound(this._MGFeatureQueryId);
      var queryBound = new QueryBound();
      queryBound._MGQueryBoundId = QueryBoundID;
      return queryBound;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置空间过滤条件,缺省是SPATIAL_REL_MBROVERLAP
   * @memberOf FeatureQuery
   * @param spatialRel 空间过滤条件
   */
  async setSpatialFilterRelationship(spatialRel) {
    try {
      await F.setQueryBound(this._MGFeatureQueryId, spatialRel);
    } catch (e) {
      console.error(e);
    }
  }
  /**
   * 获取空间过滤条件
   * @memberOf FeatureQuery
   */
  async getSpatialFilterRelationship() {
    try {
      let { spatialFilterRelationship } = await F.getSpatialFilterRelationship(
        this._MGFeatureQueryId
      );
      return spatialFilterRelationship;
    } catch (e) {
      console.error(e);
    }
  }
  /**
   * 设置是否返回几何数据标志,缺省为true
   * @memberOf FeatureQuery
   * @param returnGeometry 返回几何数据
   */
  async setReturnGeometry(returnGeometry) {
    try {
      await F.setReturnGeometry(this._MGFeatureQueryId, returnGeometry);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取是否返回几何数据标志
   * @memberOf FeatureQuery
   */
  async isReturnGeometry() {
    try {
      let { isReturnGeometry } = await F.isReturnGeometry(
        this._MGFeatureQueryId
      );
      return isReturnGeometry;
    } catch (e) {
      console.error(e);
    }
  }
  /**
   * 设置是否返回属性数据标志,缺省为true
   * @memberOf FeatureQuery
   * @param returnAttribute 返回属性数据
   */
  async setReturnAttribute(returnAttribute) {
    try {
      await F.setReturnAttribute(this._MGFeatureQueryId, returnGeometry);
    } catch (e) {
      console.error(e);
    }
  }
  /**
   * 获取是否返回属性数据标志
   * @memberOf FeatureQuery
   */
  async isReturnAttribute() {
    try {
      let { isReturnAttribute } = await F.isReturnAttribute(
        this._MGFeatureQueryId
      );
      return isReturnAttribute;
    } catch (e) {
      console.error(e);
    }
  }
  /**
   * 设置是否返回属性数据标志,缺省为true
   * @memberOf FeatureQuery
   * @param returnAttribute 返回属性数据
   */
  async setReturnGeoInfo(returnGeoInfo) {
    try {
      await F.setReturnGeoInfo(this._MGFeatureQueryId, returnGeoInfo);
    } catch (e) {
      console.error(e);
    }
  }
  /**
   * 获取是否返回属性数据标志
   * @memberOf FeatureQuery
   */
  async isReturnGeoInfo() {
    try {
      let { isReturnGeoInfo } = await F.isReturnGeoInfo(this._MGFeatureQueryId);
      return isReturnGeoInfo;
    } catch (e) {
      console.error(e);
    }
  }
  /**
   * 设置返回的属性字段信息,字段名间使用','分割
   * @memberOf FeatureQuery
   * @param outFields 字段名间使用','分割
   */
  async setOutFields(outFields) {
    try {
      await F.setOutFields(this._MGFeatureQueryId, outFields);
    } catch (e) {
      console.error(e);
    }
  }
  /**
   * 获取返回的属性字段信息
   * @memberOf FeatureQuery
   */
  async getOutFields() {
    try {
      let { outFields } = await F.getOutFields(this._MGFeatureQueryId);
      return outFields;
    } catch (e) {
      console.error(e);
    }
  }
  /**
   * 设置每页结果数目,缺省为10条
   *  @memberOf FeatureQuery
   * @param pageSize 每页结果数目
   */
  async setPageSize(pageSize) {
    try {
      await F.setPageSize(this._MGFeatureQueryId, pageSize);
    } catch (e) {
      console.error(e);
    }
  }
  /**
   * 获取每页结果数目
   * @memberOf FeatureQuery
   */
  async getPageSize() {
    try {
      let { pageSize } = await F.getPageSize(this._MGFeatureQueryId);
      return pageSize;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 要素查询
   * @memberOf FeatureQuery
   * @returns {Promise<FeaturePagedResult>}
   */
  async query() {
    try {
      let { featurePageResultHandle } = await F.query(this._MGFeatureQueryId);
      var featurePagedResult = new FeaturePagedResult();
      featurePagedResult._MGFeaturePagedResultId = featurePageResultHandle;
      return featurePagedResult;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 要素查询
   *
   * @param vectorLayer 矢量图层
   * @param strWhereClause 属性条件
   * @param queryBound 空间范围
   * @param spatialRel 空间过滤条件
   * @param returnGeometry 是否返回几何数据标志
   * @param returnAttribute 是否返回属性数据标志
   * @param strOutFields 返回的属性字段信息
   * @param pageSize 每页结果数目
   */
  // async query(Layer,strWhereClause,queryBound,spatialRel,returnGeometry,returnAttribute,returnGeoInfo,strOutFields,pageSize)
  // {
  //     try {
  //         let {featurePageResultHandle} = await F.query(this._MGFeatureQueryId,Layer._MGMapLayerId,strWhereClause,queryBound._MGQueryBoundId,spatialRel,returnGeometry,
  //             returnAttribute,returnGeoInfo,strOutFields,pageSize);
  //         var featurePagedResult = new FeaturePagedResult();
  //         featurePagedResult._MGFeaturePagedResultId = featurePageResultHandle;
  //         return featurePagedResult;
  //     } catch (e) {
  //         console.error(e);
  //     }
  // }
}
