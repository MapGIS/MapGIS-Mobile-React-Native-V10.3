/**
 * @content 要素类功能组件
 * @author fjl 2019-6-25下午2:52:36
 */
import {NativeModules} from 'react-native';

let F = NativeModules.JSFeature;
import Rect from './Rect.js';
import Dot from './Dot.js';
import Graphic from "./Graphic";

export default class Feature {
    /**
     * 构造一个新的 Feature 对象。
     * @memberOf Feature
     * @returns {Promise.<Feature>}
     */
    async createObj() {
        try {
            var {FeatureId} = await F.createObj();
            var featurePagedResult = new Feature();
            featurePagedResult._MGFeatureId = FeatureId;
            return featurePagedResult;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     *  获取要素ID
     * @returns {Promise<*|*>}
     */
    async getID() {
        try {
            let ID = await F.getID(this._MGFeatureId);
            return ID;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 获取要素属性
     */
    async getAttributes() {
        try {
            let {jsonAttributes} = await F.getAttributes(this._MGFeatureId);
            return jsonAttributes;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 要素转Graphic
     * @returns {Promise<Array>}
     */
   async toGraphics(){
        try{
            var objArr = [];
            var {values} = await F.toGraphics(this._MGFeatureId);
            for(var i =0;i<values.length-1;i++){
                var graphic = new Graphic();
                graphic._MGGraphicId = values[i];
                objArr.push(graphic);
            }
            return objArr;
        }catch(e){
            console.error(e);
        }
    }

}
