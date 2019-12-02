/**
 * @content 标记图层功能组件
 * @author lidafeng
 */
import { NativeModules } from 'react-native';
import Annotation from './Annotation.js';

let ANLY = NativeModules.JSAnnotationsOverlay;
/**
 * @class AnnotationsOverlay
 */
export default class AnnotationsOverlay {
  /**
   * 构造一个新的 AnnotationsOverlay 对象。
   * @memberOf AnnotationsOverlay
   * @returns {Promise.<AnnotationsOverlay>}
   */
  async createObj() {
    try {
      let { AnnotationsOverlayId } = await ANLY.createObj();
      let annotationsOverlay = new AnnotationsOverlay();
      annotationsOverlay._MGAnnotationsOverlayId = AnnotationsOverlayId;
      return annotationsOverlay;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 添加一个标记
   *
   * @param ann 标记
   */
  async addAnnotation(ann) {
    try {
      await ANLY.addAnnotation(
        this._MGAnnotationsOverlayId,
        ann._MGAnnotationId
      );
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 添加一组标记
   *
   * @param anns
   */
  async addAnnotations(annArray) {
    try {
      await ANLY.addAnnotations(this._MGAnnotationsOverlayId, annArray);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 删除指定索引的标记
   *
   * @param index 索引
   */
  async removeAnnotationByIndex(index) {
    try {
      await ANLY.removeAnnotation(this._MGAnnotationsOverlayId, index);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 删除一个标记
   *
   * @param ann
   */
  async removeAnnotation(ann) {
    try {
      await ANLY.removeAnnotation(
        this._MGAnnotationsOverlayId,
        ann._MGAnnotationId
      );
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 删除一组标记
   *
   * @param anns
   */
  async removeAnnotations(annArray) {
    try {
      await ANLY.removeAnnotations(this._MGAnnotationsOverlayId, annArray);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 删除所有标记
   */
  async removeAllAnnotations() {
    try {
      await ANLY.removeAllAnnotations(this._MGAnnotationsOverlayId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取标记数目
   *
   * @return 标记数目
   */
  async getAnnotationCount() {
    try {
      return await ANLY.getAnnotationCount(this._MGAnnotationsOverlayId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取标记的索引
   *
   * @param annotation
   * @return 标记索引 -1表示没有找到该标记
   */
  async indexOf(ann) {
    try {
      return await ANLY.indexOf(
        this._MGAnnotationsOverlayId,
        ann._MGAnnotationId
      );
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取指定索引的标记
   *
   * @param index 标记索引 从0开始
   * @return 索引对应的标记
   */
  async getAnnotation(index) {
    try {
      let { AnnotationId } = await ANLY.getAnnotation(
        this._MGAnnotationsOverlayId,
        index
      );
      var annotation = new Annotation();
      annotation._MGAnnotationId = AnnotationId;
      return annotation;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取所有标记
   *
   * @return 标记列表
   */
  async getAllAnnotations() {
    try {
      var objArr = [];
      let { AnnotationArr } = ANLY.getAllAnnotations(
        this._MGAnnotationsOverlayId
      );
      for (var i = 0; i < AnnotationArr.length; i++) {
        var annotation = new Annotation();
        annotation._MGAnnotationId = AnnotationArr[i];
        objArr.push(annotation);
      }
      return objArr;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 移动标记,改变标记的层次序列
   *
   * @param fromIndex 被移动的标记的索引
   * @param toIndex 移动标记到toIndex处,如果toIndex为-1 表示移动到最上面
   */
  async moveAnnotation(fromIndex, toIndex) {
    try {
      await ANLY.moveAnnotation(
        this._MGAnnotationsOverlayId,
        fromIndex,
        toIndex
      );
    } catch (e) {
      console.error(e);
    }
  }
}
