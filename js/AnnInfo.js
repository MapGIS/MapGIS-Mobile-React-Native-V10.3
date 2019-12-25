import GeomInfo from "./GeomInfo";

/**
 * @content 抽象基类，注记图形信息功能组件
 * @author  2019-09-11
 */

/**
 * @class AnnInfo
 * @description 几何图形信息类。(虚类)
 */
export default class AnnInfo extends GeomInfo{
    constructor() {
        super();
        Object.defineProperty(this, '_MGAnnInfoId', {
          get: function() {
            return this._MGGeomInfoId;
          },
          set: function(_MGAnnInfoId) {
            this._MGGeomInfoId = _MGAnnInfoId;
          },
        });
      }
}
