/**
 * @content 图片功能组件
 * @author fjl 2019-6-20 下午2:52:36
 */
import { NativeModules } from "react-native";
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
      if (typeof arguments[0] === "string") {
        var { imageId } = await X.createObjByProperty(arguments[0]);
        var image = new Image();
        image._MGImageId = imageId;
        return image;
      } else {
        var { imageId } = await X.createObj();
        var image = new Image();
        image._MGImageId = imageId;
        return image;
      }
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
}
