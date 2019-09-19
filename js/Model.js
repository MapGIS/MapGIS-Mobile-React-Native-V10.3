/*
 * @Description: In User Settings Edit
 * @Author: xiaoying
 * @Date: 2019-09-04 17:03:54
 * @LastEditTime: 2019-09-04 17:52:27
 * @LastEditors: Please set LastEditors
 */
import {NativeModules} from "react-native";
let MD = NativeModules.JSModel;

/**
 * @class Model 
 * @description 模型对象，此类中包含了模型可见(STATE_UNVISIBLE)与不可见(STATE_VISIBLE)两种常量
 * 
 * @property {int} State.STATE_UNVISIBLE  0 - 模型可见性：不可见
 * @property {int} State.STATE_VISIBLE    1 - 模型可见性：可见
 */
export default class Model{
    
    /**
     * 创建一个新的Model对象
     * 
     * @memberof Model
     * @returns {Promise<Model>}
     */
    async createObj(){
        try {
            var {ModelId} = await MD.createObj();
            var model = new Model();
            model._MGModelId = ModelId;
            return model;
        } catch (e) {
            console.error(e);
        }
    } 

    /**
     * 设置图形的可见状态.
     * 
     * @memberof Model
     * @param {int} state 模型的可见状态 ,取值为STATE_UNVISIBLE和STATE_VISIBLE两种.
     * @returns {Promise<Void>}
     */
    async setState(state){
        try {
            await MD.setState(this._MGModelId, state);
        } catch (e) {
            console.error(e);
        }
    } 

    /**
     * 获取图形的可见状态.
     * 
     * @memberof Model
     * @returns {int}  模型的可见状态 ,取值为STATE_UNVISIBLE和STATE_VISIBLE两种.
     */
    async getState(){
        try {
            let state = await MD.getState(this._MGModelId);
            return state;
        } catch (e) {
            console.error(e);
        }
    } 

    /**
     * 设置名称
     * 
     * @memberof Model
     * @param {String} name 名称
     * @returns {Promise<Void>}
     */
    async setName(name){
        try {
            await MD.setName(this._MGModelId, name);

        } catch (e) {
            console.error(e);
        }
    } 

     /**
      * 获取名称
      * @memberof Model
      * @returns {String} 名称
     */
    async getName(){
        try {
            let name = await MD.getName(this._MGModelId);
            return name;
        } catch (e) {
            console.error(e);
        }
    } 

    /**
     * 设置模型位置
     * 
     * @memberof Model
     * @param {Object} position 位置 (Object-Dot3D)
     * @returns {Promise<Void>}
     */
    async setPosition(){
        try {
            
        } catch (e) {
            console.error(e);
        }
    } 

     /**
      * 获取模型位置
      * 
     * @memberof Model
     * @returns {Promise<Dot3D>} 模型位置
     */
    async getPosition(){
        try {
            
        } catch (e) {
            console.error(e);
        }
    } 


    /**
     * 设置模型在x轴方向上的缩放比
     * 
     * @memberof Model
     * @param {double} scale 缩放比
     * @returns {Promise<Void>}
     */
    async setScaleX(scale){
        try {
            await MD.setScaleX(this._MGModelId, scale);
        } catch (e) {
            console.error(e);
        }
    } 

     /**
      * 获取模型在x轴方向上的缩放比
      * 
      * @memberof Model 
      * @returns {double} 缩放比
     */
    async getScaleX(){
        try {
            let scale = await MD.getScaleX(this._MGModelId);
            return scale;
        } catch (e) {
            console.error(e);
        }
    } 

    /**
     * 设置模型在y轴方向上的缩放比
     * 
     * @memberof Model
     * @param {double} scale 缩放比
     * @returns {Promise<Void>}
     */
    async setScaleY(scale){
        try {
            await MD.setScaleY(this._MGModelId, scale);

        } catch (e) {
            console.error(e);
        }
    } 

     /**
      * 获取模型在y轴方向上的缩放比
      * 
      * @memberof Model
      * @returns {double} 缩放比
     */
    async getScaleY(){
        try {
            let scale = await MD.getScaleY(this._MGModelId);
            return scale;
        } catch (e) {
            console.error(e);
        }
    } 

    /**
     * 设置模型在z轴方向上的缩放比
     * 
     * @memberof Model
     * @param {double} scale 缩放比
     * @returns {Promise<Void>}
     */
    async setScaleZ(scale){
        try {
            await MD.setScaleZ(this._MGModelId, scale);
        } catch (e) {
            console.error(e);
        }
    } 

     /**
      * 获取模型在z轴方向上的缩放比
      * 
      * @memberof Model
      * @returns {double} 缩放比
     */
    async getScaleZ(){
        try {
            let scale = await MD.getScaleZ(this._MGModelId);
            return scale;
        } catch (e) {
            console.error(e);
        }
    } 

    /**
     * 设置模型绕x轴旋转的角度
     * 
     * @memberof Model
     * @param {float} angle 角度
     * @returns {Promise<Void>}
     */
    async setAngleAroundX(angle){
        try {
            await MD.setAngleAroundX(this._MGModelId, angle);
        } catch (e) {
            console.error(e);
        }
    } 

     /**
      * 获取模型绕x轴旋转的角度
      * 
      * @memberof Model
      * @returns {float} 角度
     */
    async getAngleAroundX(){
        try {
            let angleAroundX = await MD.getAngleAroundX(this._MGModelId);
            return angleAroundX;
        } catch (e) {
            console.error(e);
        }
    } 

    /**
     * 设置模型绕y轴旋转的角度
     * 
     * @memberof Model
     * @param {float} angle 角度
     * @returns {Promise<Void>}
     */
    async setAngleAroundY(angle){
        try {
            await MD.setAngleAroundY(this._MGModelId, angle);
        } catch (e) {
            console.error(e);
        }
    } 

     /**
      * 获取模型绕y轴旋转的角度
      * 
      * @memberof Model
      * @returns {float} 角度
     */
    async getAngleAroundY(){
        try {
            let angleAroundY = await MD.getAngleAroundY(this._MGModelId);
            return angleAroundY;
        } catch (e) {
            console.error(e);
        }
    } 

    /**
     * 设置模型绕z轴旋转的角度
     * 
     * @memberof Model
     * @param {float} angle 角度
     * @returns {Promise<Void>}
     */
    async setAngleAroundZ(angle){
        try {
            await MD.setAngleAroundZ(this._MGModelId, angle);
        } catch (e) {
            console.error(e);
        }
    } 

     /**
      * 获取模型绕z轴旋转的角度
      * 
      * @memberof Model
      * @returns {float} 角度
     */
    async getAngleAroundZ(){
        try {
            let angleAroundZ = await MD.getAngleAroundZ(this._MGModelId);
            return angleAroundZ;
        } catch (e) {
            console.error(e);
        }
    } 

    /**
     * 设置是否显示包围盒
     * 
     * @memberof Model
     * @param {boolean} show 是否显示包围盒
     * @returns {Promise<Void>}
     */
    async setShowBoundingBox(show){
        try {
            await MD.setShowBoundingBox(this._MGModelId, show);
        } catch (e) {
            console.error(e);
        }
    } 

     /**
      * 是否显示包围盒
      * 
      * @memberof Model
      * @returns {boolean} 是否显示 
     */
    async isShowBoundingBox(){
        try {
            let result = await MD.isShowBoundingBox(this._MGModelId);
            return result;
        } catch (e) {
            console.error(e);
        }
    } 

    /**
     * 从单个模型文件中加载数据(默认格式为mm3d)
     * 
     * @memberof Model
     * @param {String} strModelFile 单个模型文件
     * @returns {boolean} true-成功 ； false-失败
     */
    async loadDataFromFile(strModelFile){
        try {
            let result = await MD.loadDataFromFile(this._MGModelId, strModelFile);
            return result;
        } catch (e) {
            console.error(e);
        }
    } 

     /**
      * 保存模型数据到指定的单个模型文件中(默认格式为mm3d)
      * 
      * @memberof Model
      * @param {String} strModelFile 单个模型文件
      * @returns {boolean} true-成功 ； false-失败
     */
    async saveDataToFile(strModelFile){
        try {
            let result = await MD.saveDataToFile(this._MGModelId, strModelFile);
            return result;
        } catch (e) {
            console.error(e);
        }
    } 
}

Model.State = {
    // 模型可见性：不可见
    STATE_UNVISIBLE: 0, 
    // 模型可见性：可见
    STATE_VISIBLE : 1
}