/*
 * @Description: In User Settings Edit
 * @Author: xiaoying
 * @Date: 2019-09-10 19:43:30
 * @LastEditTime: 2019-09-19 16:21:44
 * @LastEditors: Please set LastEditors
 */
import React, { Component } from "react";
import { NativeModules, DeviceEventEmitter,NativeEventEmitter,} from "react-native";
import SketchStyle from "./SketchStyle";
import SnappingOption from "./SnappingOption";
import Dot from "./Dot";
import SRefData from "./SRefData";
import Geometry from "./Geometry";
let SE = NativeModules.JSSketchEditor;

/**
 * @class SketchEditor
 * @description 草图编辑器
 */
export default class SketchEditor {
    
    /**
     * 构造一个新的SketchEditor对象
     * 
     * @memberof SketchEditor
     * @param {Object} mapView 地图视图对象 
     * @returns {Promise<SketchEditor>}
     */
    async createObj(mapView){
        try {
            var {SketchEditorId} = await SE.createObj(mapView._MGMapViewId);
            var sketchEditor = null;
            if(SketchEditorId != null){
                sketchEditor = new SketchEditor();
                sketchEditor._MGSketchEditorId = SketchEditorId;
            }

            return sketchEditor;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 添加状态改变监听
     * 
     * @memberof SketchEditor
     * @returns {Promise<Void>}
     */
    async addStateChangedListener(){
        try {
            await SE.addStateChangedListener(this._MGSketchEditorId);

        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 移除状态改变监听
     * 
     * @memberof SketchEditor
     * @returns {Promise<Void>}
     */
    async removeStateChangedListener(){
        try {
            await SE.removeStateChangedListener(this._MGSketchEditorId);

        } catch (e) {
            console.error(e);
        }
    }

    /**
	 * 获取草图样式
     * @memberof SketchEditor
     * @returns {Promise<SketchStyle>} 
	 */
    async getSketchStyle(){
        try {
            var {SketchStyleId} = await SE.getSketchStyle(this._MGSketchEditorId);
            var sketchStyle = null;
            if(SketchStyleId != null){
                sketchStyle = new SketchStyle();
                sketchStyle._MGSketchStyleId = SketchStyleId;
            }

            return sketchStyle;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 设置草图样式
     * @memberof SketchEditor
     * @param {Object} sketchStyle 草图样式(SketchStyle类型的Object)
     * @returns {Promise<Void>} 
     */
    async setSketchStyle(sketchStyle){
        try {
            await SE.setSketchStyle(this._MGSketchEditorId, sketchStyle._MGSketchStyleId);

        } catch (e) {
            console.error(e);
        }
    }

     /**
	 * 获取捕捉选项
     * @memberof SketchEditor
     * @returns {Promise<SnappingOption>} 
	 */
    async getSnappingOption(){
        try {
            var {SnappingOptionId} = await SE.getSnappingOption(this._MGSketchEditorId);
            var snappingOption = null;
            if(SnappingOptionId != null){
                snappingOption = new SnappingOption();
                snappingOption._MGSnappingOptionId = SnappingOptionId;
            }
            return snappingOption;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 设置捕捉选项
     * @memberof SketchEditor
     * @param {Object} snappingOption 捕捉选项(SnappingOption类型的Object)
     * @returns {Promise<Void>} 
     */
    async setSnappingOption(snappingOption){
        try {
            await SE.setSnappingOption(this._MGSketchEditorId, snappingOption._MGSnappingOptionId);
            
        } catch (e) {
            console.error(e);
        }
    }

     /**
     * 依据指定的数据类型开始新的几何编辑
     * @memberof SketchEditor
     * @param {Number} sketchDataType 几何类型（int类型的Number，例:1--SketchDataType.POINT）
     * @returns {Promise<Void>} 
     */
    async startByType(sketchDataType){
        try {
            await SE.startByType(this._MGSketchEditorId, sketchDataType);
            
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 开始编辑已有的几何对象
     * @memberof SketchEditor
     * @param {Object} geometry 几何对象 
     * @returns {Promise<Void>} 
     */
    async start(geometry){
        try {
            await SE.start(this._MGSketchEditorId, geometry._MGGeometryId);
            
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 获取编辑的数据类型
     * @memberof SketchEditor
     * @returns {Number} 几何类型（int类型的Number，例:1--SketchDataType.POINT，-1表示获取失败）
     */
    async getSketchDataType(){
        try {
            let result = await SE.getSketchDataType(this._MGSketchEditorId);
            return result;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 替换当前的编辑几何对象
     * @memberof SketchEditor
     * @param {Object} geometry 几何对象 
     * @returns {Promise<Void>} 
     */
    async replaceGeometry(geometry){
        try {
            await SE.replaceGeometry(this._MGSketchEditorId, geometry._MGGeometryId);
            
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 获取当前的编辑几何
     * @memberof SketchEditor
     * @returns {Promise<Geometry>} 成功返回几何对象
     */
    async getGeometry(){
        try {
            let {GeometryId} = await SE.getGeometry(this._MGSketchEditorId);
            let geometry = null;
            if(GeometryId != null){
                geometry = new Geometry();
                geometry._MGGeometryId = GeometryId;
            }
            return geometry;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 清除当前的编辑几何
     * @memberof SketchEditor
     * @returns {Promise<Void>} 
     */
    async clearGeometry(){
        try {
            await SE.clearGeometry(this._MGSketchEditorId);
            
        } catch (e) {
            console.error(e);
        }
    }

     /**
     * 停止编辑
     * @memberof SketchEditor
     * @returns {Promise<Void>} 
     */
    async stop(){
        try {
            await SE.stop(this._MGSketchEditorId);
            
        } catch (e) {
            console.error(e);
        }
    }

     /**
     * 删除当前被选中的顶点
     * @memberof SketchEditor
     * @returns {boolean} 
     */
    async deleteSelectedVertex(){
        try {
            let result = await SE.deleteSelectedVertex(this._MGSketchEditorId);
            return result;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 移动当前被选中的顶点到指定的位置（地图坐标）
     * @memberof SketchEditor
     * @param {Number} x坐标的值
     * @param {Number} y坐标的值
     * @returns {boolean} 
     */
    async moveSelectedVertexTo(x, y){
        try {
            let result = await SE.moveSelectedVertexTo(this._MGSketchEditorId, x, y);
            return result;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 添加新的顶点（地图坐标）
     * @memberof SketchEditor
     * @param {Number} x坐标的值
     * @param {Number} y坐标的值
     * @returns {Promise<Void>} 
     */
    async addVertex(x, y){
        try {
            await SE.addVertex(this._MGSketchEditorId, x, y);
      
        } catch (e) {
            console.error(e);
        }
    }

     /**
     * 试图捕捉指定点（地图坐标，返回被捕捉到的点，返回null表示捕捉失败
     * @memberof SketchEditor
     * @param {Number} x坐标的值
     * @param {Number} y坐标的值
     * @returns {Promise<Dot>} 返回null表示捕捉失败
     */
    async snapping(x, y){
        try {
            var {point2DId} = await SE.snapping(this._MGSketchEditorId, x, y);
            var dot = null;
            if(point2DId != null){
                dot = new Dot();
                dot._MGDotId = point2DId;
            }

            return dot;
        } catch (e) {
            console.error(e);
        }
    }

     /**
     * 撤销
     * @memberof SketchEditor
     * @returns {boolean} true-成功；false-失败
     */
    async undo(){
        try {
            let result = await SE.undo(this._MGSketchEditorId);
           
            return result;
        } catch (e) {
            console.error(e);
        }
    }

     /**
     * 重做
     * @memberof SketchEditor
     * @returns {boolean} true-成功；false-失败
     */
    async redo(){
        try {
            let result = await SE.redo(this._MGSketchEditorId);
           
            return result;
        } catch (e) {
            console.error(e);
        }
    }

     
     /**
     * 草图几何是否有效（点几何必须有1个顶点、线必须有2个顶点、区必须有3个顶点）
     * @memberof SketchEditor
     * @returns {boolean} 
     */
    async isSketchValid(){
        try {
            let result = await SE.isSketchValid(this._MGSketchEditorId);
           
            return result;
        } catch (e) {
            console.error(e);
        }
    }

     /**
     * 设置地图位置组件
     * 
     * @memberof SketchEditor
     * @param {Object} magnifierOption 地图位置组件
     * @returns {Promise<Void>} 
     */
    async setMagnifierOption(magnifierOption){
        try {
            await SE.setMagnifierOption(this._MGSketchEditorId, magnifierOption._MGMagnifierOptionId);
           
        } catch (e) {
            console.error(e);
        }
    }

     /**
     * 设置编辑数据的空间参考系，用于计算实地距离和面积
     * @memberof SketchEditor
     * @param {sRefData} 空间参考系
     * @returns {Promise<Void>} 
     */
    async setSRS(sRefData){
        try {
            await SE.setSRS(this._MGSketchEditorId, sRefData._MGSRefDataId);
          
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 获取空间参考系
     * @memberof SketchEditor
     * @returns {Promise<SRefData>} 
     */
    async getSRS(){
        try {
            var {SRefDataId} = await SE.getSRS(this._MGSketchEditorId);
            var sRefData = null;
            if(SRefDataId != null){
                 sRefData = new SRefData();
                 sRefData._MGSRefDataId = SRefDataId;
            }

            return sRefData;
        } catch (e) {
            console.error(e);
        }
    }
}