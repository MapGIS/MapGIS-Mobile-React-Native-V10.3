/**
 * @content 标记功能组件
 * @author
 */
import { NativeModules } from 'react-native';
import Dot from './Dot.js';
import PointF from './PointF.js';

let AN = NativeModules.JSAnnotation;
/**
 * @class Annotation
 */
export default class Annotation {
  /**
	 * 构造一个新的 Annotation标记对象
	 * @memberOf Annotation
	 * @param title 标题
	 * @param description 描述
	 * @param point 地图坐标点
	 * @param image 图标 可以为null
   * @returns {Promise.<Annotation>}
	 */
  async createObj(title, description, point, image) {
    try {
      var { AnnotationId } = await AN.createObj(title, description, point._MGDotId, image._MGImageId);
      var annotation = new Annotation();
      annotation._MGAnnotationId = AnnotationId;
      return annotation;
    } catch (e) {
      console.error(e);
    }
  }

  /**
	 * 构造一个新的 Annotation标记对象
	 * @memberOf Annotation
	 * @param uid 唯一标识
	 * @param title 标题
	 * @param description 描述
	 * @param point 地图坐标点
	 * @param image 图标 可以为null
   * @returns {Promise.<Annotation>}
	 */
  async createObjByUID(uid, title, description, point, image) {
    try {
      var { AnnotationId } = await AN.createObjByUID(uid, title, description, point._MGDotId, image._MGImageId);
      var annotation = new Annotation();
      annotation._MGAnnotationId = AnnotationId;
      return annotation;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取唯一标识
   * @memberOf Annotation
   * @return {Promise}唯一标识
   */
  async getUid() {
    try {
      return await AN.getUid(this._MGAnnotationId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置标题
   * @memberOf Annotation
   * @param title 标题
   * @returns {Promise.<void>}
   */
  async setTitle(title) {
    try {
      await AN.setTitle(this._MGAnnotationId, title);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取标题
   * @memberOf Annotation
   * @return {Promise} 标题
   */
  async getTitle() {
    try {
      return await AN.getTitle(this._MGAnnotationId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置描述
   * @memberOf Annotation
   * @param description 描述
   * @returns {Promise.<void>}
   */
  async setDescription(description) {
    try {
      await AN.setDescription(this._MGAnnotationId, description);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取描述
   * @memberOf Annotation
   * @return {Promise}描述
   */
  async getDescription() {
    try {
      return await AN.getDescription(this._MGAnnotationId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置地图坐标点
   * @memberOf Annotation
   * @param point 地图坐标点
   * @returns {Promise.<void>}
   */
  async setPoint(point) {
    try {
      await AN.setPoint(this._MGAnnotationId, point._MGDotId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取地图坐标点
   * @memberOf Annotation
   * @return {Promise.<Dot>}地图坐标点
   */
  async getPoint() {
    try {
      let { point2DId } = await AN.getPoint(this._MGAnnotationId);
      var dot = new Dot();
      dot._MGDotId = point2DId;
      return dot;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置标记图标
   * @memberOf Annotation
   * @param bitmap 图标
   * @returns {Promise.<void>}
   */
  async setImage(bitmap) {
    try {
      await AN.setImage(this._MGAnnotationId, bitmap._MGImageId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置标记图标
   * @memberOf Annotation
   * @param filePath 图标路径
   * @returns {Promise.<void>}
   */
  async setImageByPath(filePath) {
    try {
      await AN.setImageByFilePath(this._MGAnnotationId, filePath);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 返回图标宽度
   * @memberOf Annotation
   * @returns {Promise} 图标宽度
   */
  async getImageWidth() {
    try {
      return await AN.getImageWidth(this._MGAnnotationId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 返回图标高度
   * @memberOf Annotation
   * @returns {Promise} 图标高度
   */
  async getImageHeight() {
    try {
      return await AN.getImageHeight(this._MGAnnotationId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 返回标记图标
   * @memberOf Annotation
   * @returns {Promise.<Bitmap>} 标记图标
   */
  // async getImage() {
  //   try {
  //     let { bitmapId } = await AN.getImage(this._MGAnnotationId);
  //   } catch (e) {
  //     console.error(e);
  //   }
  // }

  /**
   * 设置标记点与图标底边中心的偏移 offset.x 取正值 图标相对于底边中心向右偏移 取负值 图标相对于底边中心向左偏移 offset.y 取正值
   * 图标相对于底边中心向上移动 取负值 图标相对于底边中心向下移动
   * @memberOf Annotation
   * @param offset
   * @returns {Promise.<void>}
   */
  async setCenterOffset(offset) {
    try {
      await AN.setCenterOffset(this._MGAnnotationId, offset._MGPointFId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取标记点与图标底边中心的偏移 ,x方向和y方向 (默认偏移为(0,0))
   * @memberOf Annotation
   * @returns {Promise.<PointF>} 偏移值
   */
  async getCenterOffset() {
    try {
      let { PointFId } = await AN.getCenterOffset(this._MGAnnotationId);
      var pointF = new PointF();
      pointF._MGPointFId = PointFId;
      return pointF;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置点是否为像素单位(默认情况下为地图单位)
   * @memberOf Annotation
   * @param 点是否为像素单位
   * @returns {Promise.<void>}
   */
  async setPointByPixel(pixel) {
    try {
      await AN.setPointByPixel(this._MGAnnotationId, pixel);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取点是否为像素单位
   * @memberOf Annotation
   * @returns {Promise.<boolean>} 点是否为像素单位
   */
  async isPointByPixel() {
    try {
      return await AN.isPointByPixel(this._MGAnnotationId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置能否弹出标记视图
   * @memberOf Annotation
   * @param show 值为true时能弹出 ,反之,不能弹出
   * @returns {Promise.<void>}
   */
  async setCanShowAnnotationView(show) {
    try {
      await AN.setCanShowAnnotationView(this._MGAnnotationId, show);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取能否弹出标记视图的标志
   * @memberOf Annotation
   * @returns {Promise.<boolean>} 标记视图弹出标志
   */
  async isCanShowAnnotationView() {
    try {
      return await AN.isCanShowAnnotationView(this._MGAnnotationId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 显示标记视图
   * @memberOf Annotation
   * @returns {Promise.<void>}
   */
  async showAnnotationView() {
    try {
      await AN.showAnnotationView(this._MGAnnotationId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 隐藏标记视图
   * @memberOf Annotation
   * @returns {Promise.<void>}
   */
  async hideAnnotationView() {
    try {
      await AN.hideAnnotationView(this._MGAnnotationId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取对应的标记视图是否正在显示的标志
   * @memberOf Annotation
   * @returns {Promise.<boolean>} 对应的标记视图显示状态 值为true时正在显示 ,反之,不能显示
   */
  async isAnnotationViewShown() {
    try {
      return await AN.isAnnotationViewShown(this._MGAnnotationId);
    } catch (e) {
      console.error(e);
    }
  }
}
