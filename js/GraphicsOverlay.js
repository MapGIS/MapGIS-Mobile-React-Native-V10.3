/**
 * @content 覆盖物对象功能组件
 * @author fjl 2019-6-21 下午2:52:36
 */
import { NativeModules } from 'react-native';

let X = NativeModules.JSGraphicsOverlay;
import Graphic from './Graphic.js';
import ObjectUtils from './components/ObjectUtils.js';

/**
 * @class GraphicsOverlay
 */
export default class GraphicsOverlay {
  /**
   * 构造一个新的 GraphicsOverlay 对象。
   * @memberOf GraphicsOverlay
   * @returns {Promise.<GraphicsOverlay>}
   */
  async createObj() {
    try {
      var { GraphicsOverlayId } = await X.createObj();
      var graphicsOverlay = new GraphicsOverlay();
      graphicsOverlay._MGGraphicsOverlayId = GraphicsOverlayId;
      return graphicsOverlay;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置层名称
   * @memberOf GraphicsOverlay
   * @param {String} name 
   * @returns {Promise<void>}
   */
  async setName(name) {
    try {
      if(this.isValid()){
        await X.setName(this._MGGraphicsOverlayId, name);
      } else {
        console.log('GraphicsOverlay is invalid !')
      }
      
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取层名称
   * @memberOf GraphicsOverlay
   * @returns {Promise<String>}
   */
  async getName() {
    try {
      if(this.isValid()){
        let name = await X.getName(this._MGGraphicsOverlayId);

        return name;
      } else {
        console.log('GraphicsOverlay is invalid');
      }
      
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取图形层的可见状态
   *@memberOf GraphicsOverlay
   *@returns {Number} 返回层的状态 0--不可见; 1--可见
   */
  async getState() {
    try {
      if(this.isValid()){
        let state = await X.getState(this._MGGraphicsOverlayId);

        return state;
      } else {
        console.log('GraphicsOverlay is invalid');
      }
      
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置图形层的可见状态
   * @memberOf GraphicsOverlay
   * @param {Number} state 层的状态 0--不可见; 1--可见
   * @returns {Promise<Void>}
   */
  async setState(state) {
    try {
      if(this.isValid()){
        await X.setState(this._MGGraphicsOverlayId, state);

      } else {
        console.log('GraphicsOverlay is invalid');
      }
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 添加一个图形
   * @memberOf GraphicsOverlay
   * @param {Graphic} graphic
   * @returns {Number} 成功返回 1 ,失败返回0
   */
  async addGraphic(graphic) {
    try {
      let result = 0 ;
      if(this.isValid() && ObjectUtils.isValidObject(graphic) && graphic.isValid()){
        result = await X.addGraphic(this._MGGraphicsOverlayId, graphic._MGGraphicId);
      } else {
        console.log('GraphicsOverlay or graphic is invalid');
      }
      return result;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 添加一组图形
   * @memberOf GraphicsOverlay
   * @param {Array<Graphic>} graphicArray
   * @returns {Promise<void>}
   */
  async addGraphics(graphicArray) {
    try {
      if(this.isValid()){
        await X.addGraphics(this._MGGraphicsOverlayId, graphicArray);
      } else {
        console.log('GraphicsOverlay is invalid');
      }
     
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 删除一个图形
   * @memberOf GraphicsOverlay
   * @param {Graphic} graphic
   * @returns {Promise<void>}
   */
  async removeGraphic(graphic) {
    try {
      if(this.isValid() && ObjectUtils.isValidObject(graphic) && graphic.isValid()){
        await X.removeGraphic(this._MGGraphicsOverlayId, graphic._MGGraphicId);
      } else {
        console.log('GraphicsOverlay or graphic is invalid');
      }
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 删除一组图形
   * @memberOf GraphicsOverlay
   * @param {Array<Graphic>} graphicArray
   * @returns {Promise<void>}
   */
  async removeGraphics(graphicArray) {
    try {
      if(this.isValid()){
        await X.removeGraphics(this._MGGraphicsOverlayId, graphicArray);
      } else {
        console.log('GraphicsOverlay is invalid');
      }
      
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 删除所有图形
   * @memberOf GraphicsOverlay
   */
  async removeAllGraphics() {
    try {
      if(this.isValid()){
        await X.removeAllGraphics(this._MGGraphicsOverlayId);
      } else {
        console.log('GraphicsOverlay is invalid');
      }
      
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 返回所有图形
   * @memberOf GraphicsOverlay
   * @returns {Promise.<Array<Graphic>>}
   */
  async getAllGraphics() {
    try {
      if(this.isValid()){
        var objArr = [];
        let graphicArrs = await X.getAllGraphics(this._MGGraphicsOverlayId);
        for (var i = 0; i < graphicArrs.length; i++) {
          var graphic = new Graphic();
          graphic._MGGraphicId = graphicArrs[i];
          objArr.push(graphic);
        }
        return objArr;
       }
      else {
        console.log('GraphicsOverlay is invalid');
      }
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 返回所有图形的数目
   * @memberOf GraphicsOverlay
   * @returns {Promise<Number>}
   */
  async getGraphicCount() {
    try {
      if(this.isValid()){
        let count = await X.getGraphicCount(this._MGGraphicsOverlayId);

        return count;
      } else {
        console.log('GraphicsOverlay is invalid');
      }
      
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取指定图形的索引
   * @memberOf GraphicsOverlay
   * @param {Graphic} graphic 图形对象
   * @returns {Promise<Number>} 图形索引
   */
  async indexOf(graphic) {
    try {
      if(this.isValid() && ObjectUtils.isValidObject(graphic) && graphic.isValid()){
        let index = await X.indexOf(
          this._MGGraphicsOverlayId,
          graphic._MGGraphicId
        );
  
        return index;
      }else{
        console.log('GraphicsOverlay or Graphic is invalid');
        return -1;
      }
    
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取指定索引的图形
   * @memberOf GraphicsOverlay
   * @param {Number} index 索引
   * @returns {Promise<Graphic>}
   */
  async getGraphic(index) {
    try {
      if(this.isValid()){
        let { _MGGraphicId } = await X.getGraphic(this._MGGraphicsOverlayId, index);
        var graphic = new Graphic();
        graphic._MGGraphicId = _MGGraphicId;
        return graphic;
      } else {
        console.log('GraphicsOverlay is invalid');
      }
      
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 插入图形
   * @memberOf GraphicsOverlay
   * @param {Number} index 要插入的位置
   * @param {Graphic} graphic 要插入的图形
   * @returns {Promise<Number>} returnID > 0 插入成功，returnID < 0 插入失败
   */
  async insertGraphic(index, graphic) {
    try {
      if(this.isValid() && ObjectUtils.isValidObject(graphic) && graphic.isValid()){
        let returnID = await X.insertGraphic(
          this._MGGraphicsOverlayId,
          index,
          graphic._MGGraphicId
        );
  
        return returnID;
      }else{
        console.log('GraphicsOverlay or Graphic is invalid');
        return -1;
      } 
     
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 删除指定索引的图形
   * @memberOf GraphicsOverlay
   * @param {Number} index 索引
   * @returns {Promise<Void>}
   */
  async removeGraphicByIndex(index) {
    try {
      if(this.isValid()){
        await X.removeGraphicByIndex(this._MGGraphicsOverlayId, index);
      } else {
        console.log('GraphicsOverlay is invalid !');
      }
      
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 移动图形的叠放次序
   * @memberOf GraphicsOverlay
   * @param {Number} fromIndex 移动源索引 (int范围的Number)
   * @param {Number} toIndex 移动目的索引 (int范围的Number)
   * @returns {Promise<Void>}
   */
  async moveGraphic(fromIndex, toIndex) {
    try {
      if(this.isValid()){
        await X.moveGraphic(this._MGGraphicsOverlayId, fromIndex, toIndex);
      } else {
        console.log('GraphicsOverlay is invalid !');
      }
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 删除指定属性的图形
   * @memberOf GraphicsOverlay
   * @param {String} name 属性名
   * @param {String} value 属性值
   * @returns {Promise<Void>}
   */
  async removeGraphicByAttribute(name, value) {
    try {
      if(this.isValid()){
        await X.removeGraphicByAttribute(this._MGGraphicsOverlayId, name, value);
        
      } else {
        console.log('GraphicsOverlay is invalid !');
      }
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取指定属性的图形
   * @memberOf GraphicsOverlay
   * @param {String} name 属性名
   * @param {String} value 属性值
   * @returns {Promise.<Array<Graphic>>}
   */
  async getGraphicsByAttribute(name, value) {
    try {
      if(this.isValid()){
        let objArr = [];
        let graphicArray = await X.getGraphicsByAttribute(
          this._MGGraphicsOverlayId,
          name,
          value
        );
        for (let i = 0; i < graphicArray.length; i++) {
          let graphic = new Graphic();
          graphic._MGGraphicId = graphicArray[i];
          objArr.push(graphic);
        }
        return objArr;
      } else {
        console.log('GraphicsOverlay is invalid !');
      }
      
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 判断graphicsOverlay是否有效
   * 
   * @memberof GraphicsOverlay
   * @returns {Boolean} true - 有效；false - 无效
   */
  isValid() {
    try {
      if(this._MGGraphicsOverlayId === undefined || this._MGGraphicsOverlayId === null){
        return false;
      } else {
        return true;
      }
    } catch (e) {
      console.error(e);
    }
  }
}
