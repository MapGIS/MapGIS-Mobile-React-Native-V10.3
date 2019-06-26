/**
 * @content 要素查询结果功能组件
 * @author fjl 2019-6-25下午2:52:36
 */
import {NativeModules} from 'react-native';

let FP = NativeModules.JSFeaturePagedResult;
import Rect from './Rect.js';
import Feature from './Feature.js';

export default class FeaturePagedResult {
    /**
     * 构造一个新的 FeaturePagedResult 对象。
     * @memberOf FeaturePagedResult
     * @returns {Promise.<FeaturePagedResult>}
     */
    async createObj() {
        try {
            var {FeaturePagedResultId} = await FP.createObj();
            var featurePagedResult = new FeaturePagedResult();
            featurePagedResult._MGFeaturePagedResultId = FeaturePagedResultId;
            return featurePagedResult;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     *  获取要素总数
     * @returns {Promise<*|*>}
     */
    async getTotalFeatureCount() {
        try {
            let totalFeatureCount = await FP.getTotalFeatureCount(this._MGFeaturePagedResultId);
            return totalFeatureCount;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 获取页数
     *
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
     * 返回页码对应的结果，页码从一开始计数
     * @param pageNumber 页码
     * @return 返回页码pageNumber对应的结果
     */
    async getPage(pageNumber) {
        try {
            var objArr = [];
            var {values} = await FP.getPage(this._MGFeaturePagedResultId, pageNumber);
            for (var i = 0; i < values.length - 1; i++) {
                var feature = new Feature();
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
     * @returns {Promise<void>}
     */
    async getFields() {
        try {
            let {FieldsJson} = await FP.getFields(this._MGFeaturePagedResultId);
            return FieldsJson;
        } catch (e) {
            console.error(e);
        }
    }

}
