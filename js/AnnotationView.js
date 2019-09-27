/**
 * @content 标记功能组件
 * @author
 */
import { NativeModules } from "react-native";

let ANV = NativeModules.JSAnnotationView;

import Annotation from "./Annotation.js"
/**
 * @class AnnotationView
 */
export default class AnnotationView {
    /**
   * 构造一个新的 AnnotationView 对象。
   * @memberOf AnnotationView
   * @returns {Promise.<AnnotationView>}
   */
  async createObj(mapView, annotation) {
    try {
      var { AnnotationViewId } = await ANV.createObj(mapView._MGMapViewId, annotation._MGAnnotationId);
      var annotationView = new AnnotationView();
      annotationView._MGAnnotationViewId = AnnotationViewId;
      return annotationView;
    } catch (e) {
      console.error(e);
    }
  }

  /**
	 * 设置标记
	 * @memberOf AnnotationView
	 * @param annotation
   * @returns {Promise.<void>}
	 */
	async setAnnotation(annotation)
	{
		try {
            await ANV.setAnnotation(this._MGAnnotationViewId, annotation._MGAnnotationId);
        } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 获取标记
	 * @memberOf AnnotationView
	 * @return {Promise.<Annotation>}标记
	 */
	async getAnnotation()
	{
		try {
            let {AnnotationId} = await ANV.getAnnotation(this._MGAnnotationViewId);
            var annotation = new Annotation();
            annotation._MGAnnotationId = AnnotationId;
            return annotation;
        } catch (e) {
            console.error(e);
        }
	}
}