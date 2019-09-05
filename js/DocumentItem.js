/*
 * @Description: 文档项对象组件
 * @Author: xiaoying
 * @Date: 2019-08-28 10:54:42
 * @LastEditTime: 2019-08-31 13:30:53
 * @LastEditors: Please set LastEditors
 */

import {NativeModules} from "react-native";
let DI = NativeModules.JSDocumentItem;

/**
 * @class DocumentItem
 * @description 文档项对象组件
 */
export default class DocumentItem{
   
   /**
    * 获取文档项类型
    * @memberof DocumentItem
    * @returns {int} 返回DocItemType中文档项类型
    */
    async getDocItemType(){
        try {
            let docItemType = await DI.getDocItemType(this._MGDocumentId);
            return docItemType;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 获取父文档项
     * @memberof DocumentItem
     * @returns {Promise<DocumentItem>} 返回父文档项
     */
    async getParent(){
        try {
            var {DocumentId} = await DI.getParent(this._MGDocumentId);
            var documentItem = new DocumentItem();
            documentItem._MGDocumentId = DocumentId;
            return documentItem;
        } catch (e) {
            console.error(e);
        }
    }

}