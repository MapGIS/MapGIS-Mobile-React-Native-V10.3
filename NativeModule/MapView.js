/**
 * @content 地图视图功能组件
 * @author fjl 2019-6-14 下午2:52:36
 */
import { NativeModules, Platform } from 'react-native';
let MV = NativeModules.JSMapView;
import Dot from './Dot.js';
import PointF from './PointF.js';
import Rect from './Rect.js';
/**
 * @class MapView
 * @description 地图显示控件容器类。
 */
export default class JSMapView {

  /**
   * 设置视图背景色
   * @param color  eg:'rgba(128, 128, 128, 0.5)'
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
   * 获取当前显示地图的显示范围
   * @returns {Promise<Dot>}
   */
  async getDispRange() {
    try {
      var { rectId} = await MV.getDispRange(this._MGMapViewId);
      var rect = new Rect();
      rect._MGRectId = rectId;
      return rect;
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
      await MV.zoomToCenter(this._MGMapViewId, centerPoint._MGDotId,resolution,animated);
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
      await MV.zoomToCenter(this._MGMapViewId, centerPoint._MGDotId,viewCenterPoint._MGPointFId,resolution,animated);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 放缩地图到指定范围
   * @param dispRange 新的视图范围
   * @param animated 是否开启动画模式
   * @returns {Promise<void>}
   */
  async zoomToRange(dispRange,animated) {
    try {
      await MV.zoomToCenter(this._MGMapViewId,dispRange._MGRectId,animated);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 地图放大一级
   * @param animated 是否开启动画模式
   * @returns {Promise<void>}
   */
  async zoomIn(animated) {
    try {
      await MV.zoomIn(this._MGMapViewIdanimated);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 地图缩小一级
   * @param animated 是否开启动画模式
   * @returns {Promise<void>}
   */
  async zoomOut(animated) {
    try {
      await MV.zoomOut(this._MGMapViewIdanimated);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 地图复位
   * @param animated
   * @returns {Promise<void>}
   */
  async restore(animated) {
    try {
      await MV.restore(this._MGMapViewId,animated);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   *设置当前地图的旋转中心和旋转角
   * @param rotateCenter 旋转中心点坐标
   * @param rotateAngle 旋转角度（单位为角度制，逆时针为正）
   * @param animated 是否开启动画模式
   * @returns {Promise<void>}
   */
  async setRotateCenterAndAngle(rotateCenter,rotateAngle,animated) {
    try {
      await MV.setRotateCenterAndAngle(this._MGMapViewId,rotateCenter._MGDotId,rotateAngle,animated);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   *设置地图的旋转角
   * @param rotateAngle 旋转角（单位为角度制，逆时针为正）
   * @param animated 是否启用动画
   * @returns {Promise<void>}
   */
  async setRotateAngle(rotateAngle,animated) {
    try {
      await MV.setRotateAngle(this._MGMapViewId,rotateAngle,animated);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   *绕视图坐标旋转
   * @param rotation 旋转增量（单位为角度制，逆时针为正）
   * @param pivotX 视图旋转中心X坐标
   * @param pivotY 视图旋转中心Y坐标
   * @param animated 是否启用动画
   * @returns {Promise<void>}
   */
  async rotate(rotation,pivotX,pivotY,animated) {
    try {
      await MV.rotate(this._MGMapViewId,rotation,pivotX,pivotY,animated);
    } catch (e) {
      console.error(e);
    }
  }


  /**
   * 获取地图的旋转中心
   * @returns {Promise<Dot>}
   */
  async getRotateCenter() {
    try {
      var { point2DId, x, y } = await MV.getRotateCenter(this._MGMapViewId);
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
   * 获取当前地图的旋转角
   * @returns {Promise<Dot.rotateAngle>}
   */
  async getRotateAngle() {
    try {
      var { rotateAngle } = await MV.getRotateAngle(this._MGMapViewId);
      return rotateAngle;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置当前地图的倾斜角,并将地图按该角度进行倾斜
   * @param slopeAngle 倾斜角度(单位为角度制,0到45度,当天空场景启用后,角度范围为0到65度）
   * @param animated 是否开启动画
   * @returns {Promise<void>}
   */
  async setSlopeAngle(slopeAngle,animated) {
    try {
      await MV.setSlopeAngle(this._MGMapViewId,slopeAngle,animated);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取当前地图的倾斜角
   * @returns {Promise<void>}
   */
  async getSlopeAngle() {
    try {
      var {slopeAngle} = await MV.getSlopeAngle(this._MGMapViewId);
      return slopeAngle;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 停止动画效果
   * @returns {Promise<void>}
   */
  async stopAnimation() {
    try {
      await MV.stopAnimation(this._MGMapViewId);
    } catch (e) {
      console.error(e);
    }
  }
  /**
   * 获取缺省的图形覆盖物列表
   *
   * @return 缺省的图形覆盖物列表
   */
  async getGraphicsOverlay() {
    try {
      // var { point2DId, x, y } = await MV.getGraphicsOverlay(this._MGMapViewId);
      // var dot = new Dot();
      // dot._MGDotId = point2DId;
      // dot.x = x;
      // dot.y = y;
      // return dot;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取图形覆盖物列表的集合
   *
   * @return 图形覆盖物列表的集合
   */
  async getGraphicsOverlays() {
    try {
      // var { point2DId, x, y } = await MV.getGraphicsOverlays(this._MGMapViewId);
      // var dot = new Dot();
      // dot._MGDotId = point2DId;
      // dot.x = x;
      // dot.y = y;
      // return dot;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置纹理缓存的最大限额（单位为字节）
   */
  async setMaxTextureCacheSize(size) {
    try {
      await MV.setMaxTextureCacheSize(this._MGMapViewId,size);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取纹理缓存的最大限额（单位为字节）
   *
   * @return 设定的纹理缓存的最大限额
   */
  async getMaxTextureCacheSize() {
    try {
      var {MaxTextureCacheSize} = await MV.getMaxTextureCacheSize(this._MGMapViewId);
      return MaxTextureCacheSize;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 清除纹理缓存
   */
  async clearTextureCache() {
    try {
      await MV.clearTextureCache(this._MGMapViewId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置支持任意透明度
   *
   * @param support true(支持矢量数据或者瓦片数据中的任意透明度值) false(仅支持全透)
   */
  async setSupportTransparency(support) {
    try {
      await MV.setSupportTransparency(this._MGMapViewId,support);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 是否支持任意透明度
   */
  async isSupportTransparency() {
    try {
      var {isSupportTransparency} =  await MV.isSupportTransparency(this._MGMapViewId);
      return isSupportTransparency;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置是否显示指北针图标
   *
   * @param show show的值为true时显示指北针图标，反正不显示指北针图标
   */
  async setShowNorthArrow(show) {
    try {
      await MV.setShowNorthArrow(this._MGMapViewId,show);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取是否显示指北针图标
   *
   * @return 返回值为true时，显示指北针图标。反之，没有显示指北针图标
   */
  async isShowNorthArrow() {
    try {
      var {isShowNorthArrow} = await MV.isShowNorthArrow(this._MGMapViewId);
      return isShowNorthArrow;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置指北针图标在地图视图中的显示位置
   *
   * @param point 指北针图标的中心在地图视图中的坐标
   */
  async setNorthArrowPosition(point) {
    try {
      await MV.setNorthArrowPosition(this._MGMapViewId,point._MGPointFId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取指北针图标中心点在地图视图中的显示位置
   *
   * @return PointF 中心点在地图视图中的显示位置
   */
  async getNorthArrowPosition() {
    try {
      var { pointFId, x, y } = await MV.getRotateCenter(this._MGMapViewId);
      var pointf = new PointF();
      pointf._MGDotId = pointFId;
      pointf.x = x;
      pointf.y = y;
      return pointf;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置指北针图标
   * @param bitmap 指北针图标位图
   */
  async setNorthArrowImage(bitmap) {
    try {
      // await MV.setNorthArrowImage(this._MGMapViewId,show);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置是否显示中地公司logo
   *
   * @param show 值为true时显示，反之，不显示
   */
  async setShowLogo(show) {
    try {
      await MV.setShowLogo(this._MGMapViewId,show);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取是否显示中地公司logo
   *
   * @return 值为true时显示，反之，没显示
   */
  async isShowLogo() {
    try {
      var {isShowLogo} = await MV.isShowLogo(this._MGMapViewId);
      return isShowLogo;

    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置中地公司logo在地图视图中显示的位置
   * @param position logo的方位
   * @see LOGO_POSITION_BOTTOM_LEFT等
   */
  async setLogoPoistion(position) {
    try {
      await MV.setShowLogo(this._MGMapViewId,position);
    } catch (e) {
      console.error(e);
    }
  }
  /**
   * 获取中地公司logo在地图视图中的显示位置
   * @return int 中地公司logo在地图视图中的显示位置
   * @see LOGO_POSITION_BOTTOM_LEFT等
   */
  async getLogoPoistion() {
    try {
      var {LogoPoistion} = await MV.getLogoPoistion(this._MGMapViewId);
      return LogoPoistion;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置是否显示比例尺
   * @param show 值为true时显示，反之，不显示
   */
  async setShowScaleBar(show) {
    try {
      await MV.setShowScaleBar(this._MGMapViewId,show);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取是否显示比例尺
   * @return 值为true时显示，反之，没显示
   */
  async isShowScaleBar() {
    try {
      var {isShowScaleBar} = await MV.isShowScaleBar(this._MGMapViewId);
      return isShowScaleBar;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置比例尺在地图视图中显示的位置
   * @param point 视图坐标
   */
  async setScaleBarPoistion(pointf) {
    try {
      await MV.setShowScaleBar(this._MGMapViewId,pointf._MGPointFId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取比例尺在地图视图中的显示位置
   * @return PointF 比例尺在地图视图中的显示位置
   */
  async getScaleBarPoistion() {
    try {
      var { pointFId, x, y } = await MV.getScaleBarPoistion(this._MGMapViewId);
      var pointf = new PointF();
      pointf._MGDotId = pointFId;
      pointf.x = x;
      pointf.y = y;
      return pointf;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置天空图片
   * @param bitmap 天空图片
   */
  async setSkyImage(bitmap) {
    try {
      await MV.setSkyImage(this._MGMapViewId,bitmap);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置天空场景是否启用,天空场景启用后,倾斜角可以加大到65度,默认情况下,天空场景处于启用状态
   * @param enabled 天空场景是否启用
   */
  async setSkySceneEnabled(enabled) {
    try {
      await MV.setSkySceneEnabled(this._MGMapViewId,enabled);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取天空场景是否启用的标志
   * @return 天空场景是否启用的标志
   */
  async isSkySceneEnabled() {
    try {
      var {isSkySceneEnabled} = await MV.isSkySceneEnabled(this._MGMapViewId);
      return isSkySceneEnabled;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置是否启用MapView内置的地图放大、缩小按钮。通过内置的缩放按钮，可实现对地图的放大和缩小
   * @param enabled 值为true时启用，反之，不启用
   */
  async setZoomControlsEnabled(enabled) {
    try {
      await MV.setZoomControlsEnabled(this._MGMapViewId,enabled);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取是否启用了内置的缩放按钮
   * @return 缩放按钮是否启用
   */
  async isZoomControlsEnabled() {
    try {
      var {isZoomControlsEnabled} = await MV.isZoomControlsEnabled(this._MGMapViewId);
      return isZoomControlsEnabled;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置是否启用地图平移手势
   * @param enabled 值为true时启用，反之，不启用
   */
  async setMapPanGesturesEnabled(enabled) {
    try {
      await MV.setMapPanGesturesEnabled(this._MGMapViewId,enabled);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取是否启用了平移手势
   */
  async isMapPanGesturesEnabled() {
    try {
      var {isMapPanGesturesEnabled} = await MV.isMapPanGesturesEnabled(this._MGMapViewId);
      return isMapPanGesturesEnabled;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置是否启用地图缩放手势
   * @param enabled 值为true时启用，反之，不启用
   */
  async setMapZoomGesturesEnabled(enabled) {
    try {
      await MV.setMapZoomGesturesEnabled(this._MGMapViewId,enabled);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取是否启用了地图缩放手势
   */
  async isMapZoomGesturesEnabled() {
    try {
      var {isMapZoomGesturesEnabled} = await MV.isMapZoomGesturesEnabled(this._MGMapViewId);
      return isMapZoomGesturesEnabled;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置是否启用地图旋转手势
   *
   * @param enabled 值为true时启用，反之，不启用
   */
  async setMapRotateGesturesEnabled(enabled) {
    try {
      await MV.setMapRotateGesturesEnabled(this._MGMapViewId,enabled);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取是否启用了地图旋转手势
   */
  async isMapRotateGesturesEnabled() {
    try {
      var {isMapRotateGesturesEnabled} = await MV.isMapRotateGesturesEnabled(this._MGMapViewId);
      return isMapRotateGesturesEnabled;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置是否启用地图倾斜手势
   * @param enabled 值为true时启用，反之，不启用
   */
  async setMapSlopeGesturesEnabled(enabled) {
    try {
      await MV.setMapSlopeGesturesEnabled(this._MGMapViewId,enabled);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取是否启用了地图倾斜手势
   * @return
   */
  async isMapSlopeGesturesEnabled() {
    try {
      var {isMapSlopeGesturesEnabled} = await MV.isMapSlopeGesturesEnabled(this._MGMapViewId);
      return isMapSlopeGesturesEnabled;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置是否双击放大地图
   * @param enabled 值为true时启用，反之，不启用
   */
  async setDoubleTapZooming(enabled) {
    try {
      await MV.setDoubleTapZooming(this._MGMapViewId,enabled);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取是否双击放大地图
   * @return
   */
  async isDoubleTapZooming() {
    try {
      var {isDoubleTapZooming} = await MV.isDoubleTapZooming(this._MGMapViewId);
      return isDoubleTapZooming;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置是否双指单击缩小地图
   * @param enabled 值为true时启用，反之，不启用
   */
  async setTwoFingerTapZooming(enabled) {
    try {
      await MV.setTwoFingerTapZooming(this._MGMapViewId,enabled);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取是否双指单击缩小地图
   * @return
   */
  async isTwoFingerTapZooming() {
    try {
      var {isTwoFingerTapZooming} = await MV.isTwoFingerTapZooming(this._MGMapViewId);
      return isTwoFingerTapZooming;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置是否启用平移结束后的动画
   * @param enabled 值为true时启用，反之，不启用
   */
  async setPanEndAnimating(enabled) {
    try {
      await MV.setPanEndAnimating(this._MGMapViewId,enabled);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取是否启用平移结束后的动画
   */
  async isPanEndAnimating() {
    try {
      var {isPanEndAnimating} = await MV.isPanEndAnimating(this._MGMapViewId);
      return isPanEndAnimating;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置是否启用标记渲染的动画
   * @param enabled 值为true时启用，反之，不启用
   */
  async setLabelRenderAnimating(enabled) {
    try {
      await MV.setLabelRenderAnimating(this._MGMapViewId,enabled);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取是否启用标记渲染的动画
   * @return 是否启用标记渲染的动画
   */
  async isLabelRenderAnimating() {
    try {
      var {isLabelRenderAnimating} = await MV.isLabelRenderAnimating(this._MGMapViewId);
      return isLabelRenderAnimating;
    } catch (e) {
      console.error(e);
    }
  }
  }


