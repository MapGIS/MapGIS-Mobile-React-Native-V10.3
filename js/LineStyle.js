/*
 * @Description: In User Settings Edit
 * @Author: xiaoying
 * @Date: 2019-09-10 16:19:14
 * @LastEditTime: 2019-09-11 09:23:47
 * @LastEditors: mayuanye
 */
import { NativeModules } from 'react-native';
let LS = NativeModules.JSLineStyle;

/**
 * @class LineStyle
 * @description 线样式（实线）
 */
export default class LineStyle {
  /**
   * 构造一个新的LineStyle对象，可通过无参或有参构造。
   * 有参构造的参数为：颜色（int类型的Number）、线宽（float类型的Number）
   *
   * @memberof LineStyle
   * @returns {Promise<LineStyle>}
   */
  async createObj() {
    try {
      if (
        typeof arguments[0] === 'number' &&
        typeof arguments[1] === 'number'
      ) {
        let { LineStyleId } = await LS.createObjByCW(
          arguments[0],
          arguments[1]
        );
        let lineStyle = new LineStyle();
        lineStyle._MGLineStyleId = LineStyleId;
        return lineStyle;
      } else {
        let { LineStyleId } = await LS.createObj();
        let lineStyle = new LineStyle();
        lineStyle._MGLineStyleId = LineStyleId;
        return lineStyle;
      }
    } catch (e) {
      console.error(e);
    }
  }

  // /**
  //  * 通过颜色、线宽构造一个新的LineStyle对象
  //  *
  //  * @memberof LineStyle
  //  * @param {Number} color 颜色（int类型的Number）
  //  * @param {Number} width 线宽（float类型的Number）
  //  * @returns {Promise<LineStyle>}
  //  */
  // async createObjByCW(color, width){
  //     try {
  //         var {LineStyleId} = await LS.createObjByCW(color, width);
  //         var lineStyle = new LineStyle();
  //         lineStyle._MGLineStyleId = LineStyleId;
  //         return lineStyle;
  //     } catch (e) {
  //         console.error(e);
  //     }
  // }

  /**
   * 获取线的颜色
   *
   * @memberof LineStyle
   * @returns {Number} 线颜色 （int类型的Number）
   */
  async getColor() {
    try {
      let color = await LS.getColor(this._MGLineStyleId);
      return color;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置线颜色
   *
   * @memberof LineStyle
   * @param {Number} color 线颜色 （int类型的Number）
   * @returns {Promise<Void>}
   */
  async setColor(color) {
    try {
      await LS.setColor(this._MGLineStyleId, color);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取线宽
   *
   * @memberof LineStyle
   * @returns {Number} 线宽 （float类型的Number）
   */
  async getWidth() {
    try {
      let width = await LS.getWidth(this._MGLineStyleId);
      return width;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置线宽
   *
   * @memberof LineStyle
   * @param {Number} width 线宽(dp) （float类型的Number）
   * @returns {Promise<Void>}
   */
  async setWidth(width) {
    try {
      await LS.setWidth(this._MGLineStyleId, width);
    } catch (e) {
      console.error(e);
    }
  }
}
