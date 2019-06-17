/**
 * @content 地图视图功能组件
 * @author fjl 2019-6-14 下午2:52:36
 */
import { NativeModules, Platform } from 'react-native';
let MV = NativeModules.JSMapView;
import Dot from './Dot.js';
import PointF from './PointF.js';
/**
 * @class MapView
 * @description 地图显示控件容器类。
 */
export default class JSMapView {

  /**
   * 设置视图背景色
   * @param color
   * @returns {Promise<void>}
   */
  async setBackGroundColor(color) {
    try {
      await MV.setBackGroundColor(this._MGMapViewId, color);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取视图背景色
   * @returns {Promise<void>}
   */
  async getBackGroundColor() {
    try {
      var { color } =  await MV.getBackGroundColor(this._MGMapViewId);
      return color;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 加载地图
   * @param strMapPath
   * @returns {Promise<void>}
   */
  async loadFromFile(strMapPath) {
    try {
      await MV.loadFromFile(this._MGMapViewId, strMapPath);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 地图刷新
   * @returns {Promise<void>}
   */
  async refresh() {
    try {
      await MV.refresh(this._MGMapViewId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 地图强制刷新
   * @returns {Promise<void>}
   */
  async forceRefresh() {
    try {
      await MV.forceRefresh(this._MGMapViewId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 地图坐标转视图坐标
   * @param dot
   * @returns {Promise<void>}
   */
  async mapPointToViewPoint(dot) {
      try {
        var { pointFId, x, y } = await MV.mapPointToViewPoint(this._MGMapViewId,dot._MGDotId);
        var pointF = new PointF();
        pointF._MGPointFId = pointFId;
        pointF.x = x;
        pointF.y = y;
        return pointF;
      } catch (e) {
        console.error(e);
      }
    }

  /**
   * 视图坐标转地图坐标
   * @param pointF
   * @returns {Promise<Dot>}
   */
  async viewPointToMapPoint(pointF) {
    try {
      var { dotID, x, y } = await MV.viewPointToMapPoint(this._MGMapViewId,pointF._MGDotId);
      var dot = new Dot();
      dot._MGPointFId = dotID;
      dot.x = x;
      dot.y = y;
      return dot;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   *获取地图分辨率
   * @returns {Promise<Dot>}
   */
  async getResolution() {
    try {
      var { resolution } = await MV.getResolution(this._MGMapViewId);
      return resolution;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取最大分辨率
   * @returns {Promise<Dot.resolution>}
   */
  async getMaxResolution() {
    try {
      var { maxResolution } = await MV.getMaxResolution(this._MGMapViewId);
      return maxResolution;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取最小分辨率
   * @returns {Promise<void>}
   */
  async getMinResolution() {
    try {
      var { minResolution } = await MV.getMinResolution(this._MGMapViewId);
      return minResolution;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取地图中心点
   * @returns {Promise<Dot>}
   */
  async getCenter() {
    try {
      var { point2DId, x, y } = await MV.getMapCenter(this._MGMapViewId);
      var dot = new Dot();
      dot._MGDotId = point2DId;
      dot.x = x;
      dot.y = y;
      return dot;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置地图中心点
   * @param dot
   * @returns {Promise<void>}
   */
  async panToCenter(dot) {
    try {
      await MV.setMapCenter(this._MGMapViewId, dot._MGDotId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   *   * 移动地图（单位像素） 如果传入的mx = 5 、 my = 0，则系统将可视区域向右移动，所以地图将显示为向左移动5 个像素。 如果传入的mx =
   * 0 、 my = 5，则系统将可视区域向下移动，所以地图显示为向上移动了5 个像素。
   * @param mx 水平方向移动的像素大小，正值代表可视区域向右移动，负值代表可视区域向左移动
   * @param my 垂直方向移动的像素大小，正值代表可视区域向下移动，负值代表可视区域向上移动
   * @param animated 是否开启动画模式
   * @returns {Promise<void>}
   */
  async moveMap(mx,my,animated) {
    try {
      await MV.moveMap(this._MGMapViewId, mx,my,animated);
    } catch (e) {
      console.error(e);
    }
  }



  /**
   * 缩地图到指定分辨率并将指定坐标点移动到视图中心(视图高宽1/2处，绝对中心)
   * @param centerPoint 中心坐标
   * @param resolution 分辨率
   * @param animated 是否启用动画
   * @returns {Promise<void>}
   */
  async zoomToCenter(centerPoint,resolution,animated) {
    try {
      await MV.moveMap(this._MGMapViewId, mx,my,animated);
    } catch (e) {
      console.error(e);
    }
  }
  /**
   * 放缩地图到指定级别并将指定坐标点移动到自定义视图中心
   *
   * @param mapCenterPoint 中心坐标
   * @param viewCenterPoint 自定义视图中心
   * @param resolution 分辨率
   * @param animated 是否启用动画
   */
  async zoomToCenter(centerPoint,viewCenterPoint,resolution,animated) {
    try {
      await MV.moveMap(this._MGMapViewId, mx,my,animated);
    } catch (e) {
      console.error(e);
    }
  }


}
