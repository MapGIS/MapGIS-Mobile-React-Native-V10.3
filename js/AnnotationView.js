/**
 * @content 标记功能组件
 * @author
 */
import { NativeModules } from "react-native";

let ANV = NativeModules.JSAnnotationView;
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
      var { annotationViewId } = await ANV.createObj(mapView._MGMapViewId, annotation._MGAnnotationId);
      var annotationView = new AnnotationView();
      annotationView._MGAnnotationViewId = annotationViewId;
      return annotationView;
    } catch (e) {
      console.error(e);
    }
  }

  /**
	 * 设置标记
	 * 
	 * @param annotation
	 */
	async setAnnotation(annotation)
	{
		try {
            await ANV.setTitle(this._MGAnnotationViewId, annotation._MGAnnotationId);
        } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 获取标记
	 * 
	 * @return 标记
	 */
	async getAnnotation()
	{
		try {
            let {annotationId} = await AN.getAnnotation(this._MGAnnotationViewId);
            var annotation = new Annotation();
            annotation._MGAnnotationId = annotationId;
            return annotation;
        } catch (e) {
            console.error(e);
        }
	}
}