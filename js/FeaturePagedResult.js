/**
 * @content 要素查询结果功能组件
 * @author fjl 2019-6-25下午2:52:36
 */
import { NativeModules } from 'react-native';

let FP = NativeModules.JSFeaturePagedResult;
import Feature from './Feature.js';
import Fields from './Fields.js'

/**
 * @class FeaturePagedResult
 */
export default class FeaturePagedResult {
  /**
   * 构造一个新的 FeaturePagedResult 对象。
   * @memberOf FeaturePagedResult
   * @returns {Promise.<FeaturePagedResult>}
   */
  async createObj() {
    try {
      var { FeaturePagedResultId } = await FP.createObj();
      var featurePagedResult = new FeaturePagedResult();
      featurePagedResult._MGFeaturePagedResultId = FeaturePagedResultId;
      return featurePagedResult;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   *  获取要素总数
   *  @memberOf FeaturePagedResult
   * @returns {Promise<*|*>}
   */
  async getTotalFeatureCount() {
    try {
      let totalFeatureCount = await FP.getTotalFeatureCount(
        this._MGFeaturePagedResultId
      );
      return totalFeatureCount;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取页数
   *@memberOf FeaturePagedResult
   * @return 页数
   */
  async getPageCount() {
    try {
      let pageCount = await FP.getPageCount(this._MGFeaturePagedResultId);
      return pageCount;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 返回页码对应的结果，页码从“1”开始计数
   * @memberOf FeaturePagedResult
   * @param pageNumber 页码
   * @return 返回页码pageNumber对应的结果
   */
  async getPage(pageNumber) {
    try {
      let objArr = [];
      let { values } = await FP.getPage(
        this._MGFeaturePagedResultId,
        pageNumber
      );
      for (let i = 0; i < values.length; i++) {
        let feature = new Feature();
        feature._MGFeatureId = values[i];
        objArr.push(feature);
      }
      return objArr;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取属性结构
   * @memberOf FeaturePagedResult
   * @returns {Promise<void>}
   */
  async getFields() {
    try {
      let { FieldsId } = await FP.getFields(this._MGFeaturePagedResultId);
      let fields = new Fields();
      fields._MGFieldsId = FieldsId;
      return fields;
    } catch (e) {
      console.error(e);
    }
  }
}
