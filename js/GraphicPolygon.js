/**
 * @content 区对象功能组件
 * @author fjl 2019-6-24 下午2:52:36
 */
import { NativeModules } from 'react-native';
import GraphicMultiPoint from './GraphicMultiPoint';
import Graphic from './Graphic';
import ObjectUtils from './components/ObjectUtils';
let GP = NativeModules.JSGraphicPolygon;

/**
 * @class GraphicPolygon
 */
export default class GraphicPolygon extends GraphicMultiPoint {
  constructor() {
    super();
    Object.defineProperty(this, '_MGGraphicPolygonId', {
      get: function() {
        return this._MGGraphicMultiPointId;
      },
      set: function(_MGGraphicPolygonId) {
        this._MGGraphicMultiPointId = _MGGraphicPolygonId;
      },
    });
  }

  /**
   * 构造一个新的 GraphicPolygon 对象。
   * @memberOf GraphicPolygon
   * @returns {Promise.<GraphicPolygon>}
   */
  async createObj() {
    try {
      var { GraphicPolygonId } = await GP.createObj();
      var graphicPolygon = new GraphicPolygon();
      graphicPolygon._MGGraphicPolygonId = GraphicPolygonId;
      return graphicPolygon;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取面积
   * @memberOf GraphicPolygon
   * @returns {Promise<Number>}
   */
  async getArea() {
    try {
      if(this.isValid()){
        let area = await GP.getArea(this._MGGraphicPolygonId);

        return area;
      } else {
        console.log('GraphicPolygon is invalid !');
      }
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置一组坐标点
   * @memberOf GraphicPolygon
   * @param {Array<Dot>} pointArray 点数组
   * @param {Array<Number>} circlesArray  圈序列数组 (int类型的Number)
   * @returns {Promise<void>}
   */
  async setPoints(pointArray, circlesArray) {
    try {
      if(this.isValid()){
        let pointArrayJson = JSON.stringify(pointArray);

        let objArray = [];
        let objArrayJson = null;
        if(circlesArray !== null && circlesArray.length > 0){
          for(let i = 0; i < circlesArray.length; i++){
            let obj = {};
            obj.c = circlesArray[i];
            objArray.push(obj);
          }
          objArrayJson = JSON.stringify(objArray);
  
        }
        
        await GP.setPoints(this._MGGraphicPolygonId, pointArrayJson, objArrayJson);
      } else {
        console.log('GraphicPolygon is invalid !');
      }
     
    } catch (e) {
      console.error(e);
    }
  }

/**
   * 通过点序列设置一组坐标点
   * @memberOf GraphicPolygon
   * @param {Dots} dots 点序列
   * @param {Array<Number>} circlesArray 圈序列数组 （int类型的Number）
   * @returns {Promise<void>}
   * @example
       let dotArr = [];
       dotArr.push({x: 114.4, y: 30.4});
       dotArr.push({x: 114.44, y: 30.41});
       dotArr.push({x: 114.5, y: 30.5});

       let dotsModule = new Dots();
       let dots = await dotsModule.createObj();
       let circles = [1, 2, 3]; // let circles = null;
       await dots.fromObjectArray(dotArr);
       await this.graphicPolygon.setPointsByDots(dots, null);

   */
  async setPointsByDots(dots, circlesArray) {
    try {
      if(this.isValid() && ObjectUtils.isValidObject(dots) && dots.isValid()){
        let objArray = [];
        let objArrayJson = null;
        if(circlesArray !== null && circlesArray.length > 0){
          for(let i = 0; i < circlesArray.length; i++){
            let obj = {};
            obj.c = circlesArray[i];
            objArray.push(obj);
          }
          objArrayJson = JSON.stringify(objArray);
        }
        await GP.setPointsByDots(this._MGGraphicPolygonId, dots._MGDotsId, objArrayJson);
      } else {
        console.log('GraphicPolygon or dots is invalid !');
      }
     
    } catch (e) {
      console.error(e);
    }
  }


  /**
   * 获取圈序列
   * @memberOf GraphicPolygon
   * @returns {Promise<Array>}
   */
  async getCirclesToList() {
    try {
      if(this.isValid()){
        let circlesArray = await GP.getCirclesToList(
          this._MGGraphicPolygonId
        );
        return circlesArray;
      } else {
        console.log('GraphicPolygon is invalid !');
      }
     
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置边界线的宽度
   * @memberOf GraphicPolygon
   * @param {Number} width
   * @returns {Promise<void>}
   */
  async setBorderlineWidth(width) {
    try {
      if(this.isValid()){
        await GP.setBorderlineWidth(this._MGGraphicPolygonId, width);
      } else {
        console.log('GraphicPolygon is invalid !');
      }
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取边界线的宽度
   * @memberOf GraphicPolygon
   * @returns {Promise<Number>}
   */
  async getBorderlineWidth() {
    try {
      if(this.isValid()){
        let borderlineWidth = await GP.getBorderlineWidth(this._MGGraphicPolygonId);
        return borderlineWidth;
      } else {
        console.log('GraphicPolygon is invalid !');
      }
     
    } catch (e) {
      console.error(e);
    }
  }

  /**
   *  获取边界线的颜色
   * @memberOf GraphicPolygon
   * @returns {Promise<String>} 颜色。eg:'rgba(128, 128, 128, 128)'
   */
  async getBorderlineColor() {
    try {
      if(this.isValid()){
        let { borderlineColor } = await GP.getBorderlineColor(
          this._MGGraphicPolygonId
        );
  
        return borderlineColor;
      } else {
        console.log('GraphicPolygon is invalid !');
      }
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置边界线的颜色
   * @memberOf GraphicPolygon
   * @param {String} color eg:'rgba(128, 128, 128, 128)'
   * @returns {Promise<void>}
   */
  async setBorderlineColor(color) {
    try {
      if(this.isValid()){
        await GP.setBorderlineColor(this._MGGraphicPolygonId, color);
      } else {
        console.log('GraphicPolygon is invalid !');
      }
    } catch (e) {
      console.error(e);
    }
  }
}
