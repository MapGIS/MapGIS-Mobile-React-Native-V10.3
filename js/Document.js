/*
 * @Description: In User Settings Edit
 * @Author: xiaoying
 * @Date: 2019-08-28 15:07:17
 * @LastEditTime: 2019-09-02 16:47:18
 * @LastEditors: Please set LastEditors
 */
import {NativeModules} from "react-native";
import Maps from "./Maps.js";
let DC = NativeModules.JSDocument;

/**
 * @class Document
 * @description 文档类
 */
export default class Document{

    /**
     * 构造一个新的Document对象
     * @memberof Document
     * @returns {Promise<Document>}
     */
    async createObj(){
        try {
            var {DocumentId} = await DC.createObj();
            var document = new Document();
            document._MGDocumentId = DocumentId;
            return document;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 获取文档标题
     * @memberof Document
     * @returns {String} 文档的标题
     */
    async getTitle(){
        try {
            let title = await DC.getTitle(this._MGDocumentId);
            return title; 
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 获取文档主题
     * @memberof Document
     * @returns {String} 文档主题
     */
    async getSubject(){
        try {
            let subject = await DC.getSubject(this._MGDocumentId);
            return subject;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 获取文档作者
     * @memberof Document
     * @returns {String} 文档作者
     */
    async getAuthor(){
        try {
            let author = await DC.getAuthor(this._MGDocumentId);
            return author;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 获取文档类别
     * @memberof Document
     * @returns {String} 文档类别
     */
    async getCategory(){
        try {
            let category = await DC.getCategory(this._MGDocumentId);
            return category;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 获取文档关键词
     * @memberof Document
     * @returns {String} 关键词
     */
    async getKeywords(){
        try {
            let keywords = await DC.getKeywords(this._MGDocumentId);
            return keywords;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 获取文档注释
     * @memberof Document
     * @returns {String} 文档注释
     */
    async getComments(){
        try {
            let comments = await DC.getComments(this._MGDocumentId);
            return comments;
        } catch (e) {
            console.error(e);
        }
    }

     /**
     * 获取文档是否是新建的
     * @memberof Document
     * @returns {boolean} 是否是新建的 
     */
    async getIsNew(){
        try {
            let isNew = await DC.getIsNew(this._MGDocumentId);
            return isNew;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 获取文档项的类型
     * @memberof Document
     * @returns {int} 文档项类型（DocItemType中的类型） 
     */
    async getDocItemType(){
        try {
            let docItemType = await DC.getDocItemType(this._MGDocumentId);
            return docItemType;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 获取文档是否被编辑过
     * @memberof Document
     * @returns {boolean}  
     */
    async getIsDirty(){
        try {
            let isDirty = await DC.getIsDirty(this._MGDocumentId);
            return isDirty;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 设置文档标题
     * @memberof Document
     * @param {String} title 文档标题
     * @return {Promise<Void>} 
     */
    async setTitle(title){
        try {
            await DC.setTitle(this._MGDocumentId,title);
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 设置文档主题
     * @memberof Document
     * @param {String} subject 文档主题
     * @return {Promise<Void>} 
     */
    async setSubject(subject){
        try {
            await DC.setSubject(this._MGDocumentId,subject);
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 设置文档作者
     * @memberof Document
     * @param {String} author 文档作者
     * @return {Promise<Void>} 
     */
    async setAuthor(author){
        try {
            await DC.setAuthor(this._MGDocumentId,author);
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 设置文档类别
     * @memberof Document
     * @param {String} category 文档类别
     * @return {Promise<Void>} 
     */
    async setCategory(category){
        try {
            await DC.setCategory(this._MGDocumentId,category);
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 设置文档关键词
     * @memberof Document
     * @param {String} keywords 文档关键词
     * @return {Promise<Void>} 
     */
    async setKeywords(keywords){
        try {
            await DC.setKeywords(this._MGDocumentId,keywords);
        } catch (e) {
            console.error(e);
        }
    }

     /**
     * 设置文档注释
     * @memberof Document
     * @param {String} comments 文档注释
     * @return {Promise<Void>} 
     */
    async setComments(comments){
        try {
            await DC.setComments(this._MGDocumentId,comments);
        } catch (e) {
            console.error(e);
        }
    }
    
    /**
     * 新建
     * @memberof Document
     * @return {int} 1/0:成功/失败 
     */
    async jNew(){
        try {
            let jNew = await DC.jNew(this._MGDocumentId);
            return jNew;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 打开文件
     * @memberof Document
     * @param {String} filePath 文件路径
     * @returns {int}  1/0 : 成功/失败
     */
    async open(filePath){
        try {
            let open = await DC.open(this._MGDocumentId,filePath);
            return open;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 关闭
     * @memberof Document
     * @param {boolean} save 是否保存
     * @returns {boolean} true/false：成功/失败
     */
    async close(save){
        try {
            let close = await DC.close(this._MGDocumentId,save);
            return close;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 保存
     * @memberof Document
     * @returns {boolean} true/false：成功/失败
     */
    async save(){
        try {
            let save = await DC.save(this._MGDocumentId);
            return save;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 另存为
     * @memberof Document
     * @param {String} filePath 文件保存路径
     * @returns {boolean}  true/false : 成功/失败
     */
    async saveAs(filePath){
        try {
            let saveAs = await DC.saveAs(this._MGDocumentId,filePath);
            return saveAs;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 获取文件路径
     * @memberof Document
     * @returns {String}  文件路径
     */
    async getFilePath()
    {
        try {
            let filePath = await DC.getFilePath(this._MGDocumentId);
            return filePath;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 获取文件版本
     * @memberof Document
     * @returns {String}  获取文件版本
     */
    async getVersion()
    {
        try {
            let version = await DC.getVersion(this._MGDocumentId);
            return version;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 获取地图列表
     * @memberof Document
     * @returns {Object}  获取地图列表对象 (Maps)
     */
    async getMaps()
    {
        try {
            var {MapsId} = await DC.getMaps(this._MGDocumentId);
            var maps = new Maps();
            maps._MGMapsId = MapsId;
            return maps;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 保存为XML
     * @memberof Document
     * @returns {String}  成功：返回XML
     */
    async toXML()
    {
        try {
            let toXml = await DC.toXML(this._MGDocumentId);
            return toXml;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 从XML导入
     * @memberof Document
     * @param {String} strXML XML
     * @returns {int}  成功：返回1
     */
    async fromXML(strXML)
    {
        try {
            let fromXml = await DC.fromXML(this._MGDocumentId,strXML);
            return fromXml;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 清除编辑
     * @memberof Document
     * @returns {boolean} true/false:成功/失败
     */
    async clearDirty()
    {
        try {
            let clearDirty = await DC.clearDirty(this._MGDocumentId);
            return clearDirty;
        } catch (e) {
            console.error(e);
        }
    }
}
