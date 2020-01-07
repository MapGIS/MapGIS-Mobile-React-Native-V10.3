/**
 * @content 图片功能组件
 * @author fjl 2019-6-20 下午2:52:36
 */
import { NativeModules } from 'react-native';
let X = NativeModules.JSImage;

/**
 * @class Image
 */
export default class Image {
  /**
   * 构造一个新的 Image 对象。
   * @memberOf Image
   * @returns {Promise.<Image>}
   */
  async createObj() {
    try {
      if (typeof arguments[0] === 'string') {
        let { imageId } = await X.createObjByProperty(arguments[0]);
        let image = new Image();
        image._MGImageId = imageId;
        return image;
      } else {
        let { imageId } = await X.createObj();
        let image = new Image();
        image._MGImageId = imageId;
        return image;
      }
    } catch (e) {
      console.error(e);
    }
  }

   /**
   * 构造一个新的 Image 对象。
   * @memberOf Image
   * @returns {Promise.<Image>}
   */
  async createObjByLocalPath(path) {
    try {
        let { imageId } = await X.createObjByLocalPath(path);
        let image = new Image();
        image._MGImageId = imageId;
        return image;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置图片Base64Url
   * @memberOf Image
   * @returns {Promise<void>}
   */
  async setBase64Url(base64Url) {
    try {
      await X.setBase64Url(this._MGImageId, base64Url);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取图片宽度
   * @memberOf Image
   * @returns {Promise<*>}
   */
  async getWidth() {
    try {
      let width = await X.getWidth(this._MGImageId);
      return width;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取图片高度
   * @memberOf Image
   * @returns {Promise<*>}
   */
  async getHeight() {
    try {
      let height = await X.getHeight(this._MGImageId);

      return height;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 判断Image对象是否有效
   * 
   * @memberof Image
   * @returns {Boolean} true：有效；false：无效
   */
   isValid(){
    try {
      if(this._MGImageId === undefined || this._MGImageId === null){
        return false;
      } else {
        return true;
      }
    } catch (e) {
      console.error(e);
    }
  }
}
