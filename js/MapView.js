/**
 * @content 地图视图功能组件
 * @author fjl 2019-6-14 下午2:52:36
 */
import {NativeModules, Platform} from "react-native";

let MV = NativeModules.JSMapView;
import Dot from "./Dot.js";
import PointF from "./PointF.js";
import Rect from "./Rect.js";
import Map from "./Map.js";
import GraphicsOverlay from "./GraphicsOverlay.js";
import GraphicsOverlays from "./GraphicsOverlays.js";
import MapPosition from "./MapPosition";

/**
 * @class MapView
 * @description 地图显示控件容器类。
 */
export default class JSMapView {
    /**
     * 设置视图背景色
     *  @memberOf JSMapView
     * @param {String} color 地图视图的背景颜色  eg:'rgba(128, 128, 128, 0.5)'
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
     * @memberOf JSMapView
     * @returns {Promise<Number>} 获取到的地图视图背景色。
     */
    async getBackGroundColor() {
        try {
            var {color} = await MV.getBackGroundColor(this._MGMapViewId);
            return color;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 设置背景图像,传null将取消背景图片显示
     * @params params      Object
     * width      int
     * height     int
     * quality    int      0 - 100
     * type       string   png, jpg/jpeg, webp
     * @returns {Promise.<{result: Promise.result, uri: Promise.uri}>}
     */
   async setBackGroundImage(params = {}) {

    try {
        let paramss = {width: 2000, height: 2000, quality: 60, type: 'png'}
        Object.assign(paramss, params)
        let { result, uri } = await MV.setBackGroundImage(this._MGMapViewId, paramss.width, paramss.height, paramss.quality, paramss.type);
        return { result, uri }
      } catch (e) {
        console.error(e);
      }
   }
    
    /**
     * 加载地图
     * @memberOf JSMapView
     * @param {String} strMapPath docPath 地图文档全路径
     * @returns {Promise<Number>} 加载成功，返回值>0，失败，返回<=0
     */
    async loadFromFile(strMapPath) {
        try {
            let {result} = await MV.loadFromFile(this._MGMapViewId, strMapPath);
            return result;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 加载地图，异步方法，可通过MapViewMapLoadListener来监听加载状态
     * @memberOf JSMapView
     * @param {String} strMapPath 地图文档全路径
     * @returns {Promise<void>}
     */
    async loadFromFileAsync(strMapPath)
	{
        try {
            await MV.loadFromFileAsync(this._MGMapViewId, strMapPath);
        } catch (e) {
            console.error(e);
        }
	}

     /**
     * 加载文档中对应索引的地图，同步方法
     * @memberOf JSMapView
     * @param {object} doc 地图文档对象
     * @param {number} indexOfMap 文档中map序号
     * @returns {Promise<Number>} 加载成功，返回值>0，失败，返回<=0
     */
	async loadFromDocument(doc,indexOfMap)
	{
		try {
            let {result} = await MV.loadFromDocument(this._MGMapViewId, doc._MGDocumentId, indexOfMap);
            return result;
        } catch (e) {
            console.error(e);
        }
	}

     /**
     * 加载文档中对应索引的地图，异步方法
     * @memberOf JSMapView
     * @param {object} doc  地图文档对象
     * @param {number} indexOfMap indexOfMap 文档中map序号
     * @returns {Promise<void>}
     */
	async loadFromDocumentAsync(doc, indexOfMap)
	{
        try {
            await MV.loadFromDocumentAsync(this._MGMapViewId, doc._MGDocumentId, indexOfMap);
        } catch (e) {
            console.error(e);
        }
	}

    /**
     * 设置地图对象，同步方法
     * @memberOf JSMapView
     * @param {object} map 地图对象
     * @returns {Promise<Number>} 设置成功，返回值>0，设置失败，返回值<=0
     */
	async setMap(map)
	{
        try {
            let {result} = await MV.setMap(this._MGMapViewId, map._MGMapId);
            return result;
        } catch (e) {
            console.error(e);
        }
	}

    /**
     * 设置地图对象，异步方法
     * @memberOf JSMapView
     * @param {object} map 地图对象
     * @returns {Promise<void>}
     */
	async setMapAsync(map)
	{
        try {
            await MV.setMapAsync(this._MGMapViewId, map._MGMapId);
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 获取地图对象
     * @memberOf JSMapView
     * @returns {Promise<Map>} 成功返回地图对象,失败返回空
     */
    async getMap() {
        try {
            var {mapID} = await MV.getMap(this._MGMapViewId);
            var map = new Map();
            map._MGMapId = mapID;
            return map;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 地图刷新
     * @memberOf JSMapView
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
     * @memberOf JSMapView
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
     * 停止当前的获取数据的请求(从服务器请求或从本地请求)
     * @memberOf JSMapView
     * @returns {Promise<void>}
     */
    async stopCurRequest()
	{
		try {
            await MV.stopCurRequest(this._MGMapViewId);
        } catch (e) {
            console.error(e);
        }
    }
    
    /**
     * 地图坐标转视图坐标
     * @memberOf JSMapView
     * @param {object} dot 地图坐标
     * @returns {Promise<PointF>} 视图坐标
     */
    async mapPointToViewPoint(dot) {
        try {
            var {pointFId, x, y} = await MV.mapPointToViewPoint(
                this._MGMapViewId,
                dot._MGDotId
            );
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
     * @memberOf JSMapView
     * @param {object} pointF  视图坐标
     * @returns {Promise<Dot>} 地图坐标
     */
    async viewPointToMapPoint(pointF) {
        try {
            var {dotID, x, y} = await MV.viewPointToMapPoint(
                this._MGMapViewId,
                pointF._MGPointFId
            );
            var dot = new Dot();
            dot._MGDotId = dotID;
            dot.x = x;
            dot.y = y;
            return dot;
        } catch (e) {
            console.error(e);
        }
    }

    async mapPointToGLPoint(point)
    {
        try {
            var {dotID, x, y} = await MV.mapPointToGLPoint(
                this._MGMapViewId,
                point._MGDotId
            );
            var dot = new Dot();
            dot._MGDotId = dotID;
            dot.x = x;
            dot.y = y;
            return dot;
        } catch (e) {
            console.error(e);
        }
    }
    /**
     *获取地图分辨率
     * @memberOf JSMapView
     * @returns {Promise<double>} 分辨率信息
     */
    async getResolution() {
        try {
            var {resolution} = await MV.getResolution(this._MGMapViewId);
            return resolution;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 获取最大分辨率
     * @memberOf JSMapView
     * @returns {Promise<Dot.resolution>}
     */
    async getMaxResolution() {
        try {
            var {maxResolution} = await MV.getMaxResolution(this._MGMapViewId);
            return maxResolution;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 获取最小分辨率
     * @memberOf JSMapView
     * @returns {Promise<Dot.resolution>} 分辨率信息
     */
    async getMinResolution() {
        try {
            var {minResolution} = await MV.getMinResolution(this._MGMapViewId);
            return minResolution;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 获取地图中心点
     * @memberOf JSMapView
     * @returns {Promise<Dot>} 中心点的坐标
     */
    async getCenterPoint() {
        try {
            var {dotID, x, y} = await MV.getCenterPoint(this._MGMapViewId);
            var dot = new Dot();
            dot._MGDotId = dotID;
            dot.x = x;
            dot.y = y;
            return dot;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 获取当前显示地图的显示范围
     * @memberOf JSMapView
     * @returns {Promise<Rect>} 地图范围
     */
    async getDispRange() {
        try {
            var {rectId} = await MV.getDispRange(this._MGMapViewId);
            var rect = new Rect();
            rect._MGRectId = rectId;
            return rect;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 平移地图到视图中心(视图高宽1/2处，绝对中心)
     * @memberOf JSMapView
     * @param mapCenterPoint  中心坐标
     * @param animated        是否开启动画模式
     * @returns {Promise<void>}
     */
    async panToCenter(mapCenterPoint, animated) {
        try {
            await MV.panToCenter(
                this._MGMapViewId,
                mapCenterPoint._MGDotId,
                animated
            );
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 平移地图到自定义视图中心(视图高宽1/2处，绝对中心)
     * @memberOf JSMapView
     * @param mapCenterPoint   中心坐标
     * @param viewCenterPoint  自定义视图中心
     * @param animated         是否开启动画模式
     * @returns {Promise<void>}
     */
    async panToCenterWithView(mapCenterPoint, viewCenterPoint, animated) {
        try {
            await MV.panToCenterWithView(
                this._MGMapViewId,
                mapCenterPoint._MGDotId,
                viewCenterPoint._MGPointFId,
                animated
            );
        } catch (e) {
            console.error(e);
        }
    }

    /**
     *   * 移动地图（单位像素） 如果传入的mx = 5 、 my = 0，则系统将可视区域向右移动，所以地图将显示为向左移动5 个像素。 如果传入的mx =
     * 0 、 my = 5，则系统将可视区域向下移动，所以地图显示为向上移动了5 个像素。
     * @memberOf JSMapView
     * @param mx 水平方向移动的像素大小，正值代表可视区域向右移动，负值代表可视区域向左移动
     * @param my 垂直方向移动的像素大小，正值代表可视区域向下移动，负值代表可视区域向上移动
     * @param animated 是否开启动画模式
     * @returns {Promise<void>}
     */
    async moveMap(mx, my, animated) {
        try {
            await MV.moveMap(this._MGMapViewId, mx, my, animated);
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 缩放地图到指定分辨率并将指定坐标点移动到视图中心(视图高宽1/2处，绝对中心)
     * @memberOf JSMapView
     * @param mapCenterPoint 中心坐标
     * @param resolution 分辨率
     * @param animated 是否启用动画
     * @returns {Promise<void>}
     */
    async zoomToCenter(mapCenterPoint, resolution, animated) {
        try {
            await MV.zoomToCenter(
                this._MGMapViewId,
                mapCenterPoint._MGDotId,
                resolution,
                animated
            );
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 缩放地图到指定级别并将指定坐标点移动到自定义视图中心
     * @memberOf JSMapView
     *
     * @param mapCenterPoint 中心坐标
     * @param viewCenterPoint 自定义视图中心
     * @param resolution 分辨率
     * @param animated 是否启用动画
     */
    async zoomToCenterWithView(
        mapCenterPoint,
        viewCenterPoint,
        resolution,
        animated
    ) {
        try {
            await MV.zoomToCenterWithView(
                this._MGMapViewId,
                mapCenterPoint._MGDotId,
                viewCenterPoint._MGPointFId,
                resolution,
                animated
            );
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 放缩地图到指定范围
     * @memberOf JSMapView
     * @param dispRange 新的视图范围
     * @param animated 是否开启动画模式
     * @returns {Promise<void>}
     */
    async zoomToRange(dispRange, animated) {
        try {
            await MV.zoomToRange(this._MGMapViewId, dispRange._MGRectId, animated);
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 地图放大一级
     * @memberOf JSMapView
     * @param animated 是否开启动画模式
     * @returns {Promise<void>}
     */
    async zoomIn(animated) {
        try {
            await MV.zoomIn(this._MGMapViewId, animated);
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 地图缩小一级
     * @memberOf JSMapView
     * @param animated 是否开启动画模式
     * @returns {Promise<void>}
     */
    async zoomOut(animated) {
        try {
            await MV.zoomOut(this._MGMapViewId, animated);
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 地图复位
     * @memberOf JSMapView
     * @param animated   是否开启动画模式
     * @returns {Promise<void>}
     */
    async restore(animated) {
        try {
            await MV.restore(this._MGMapViewId, animated);
        } catch (e) {
            console.error(e);
        }
    }

    /**
     *设置当前地图的旋转中心和旋转角
     * @memberOf JSMapView
     * @param rotateCenter 旋转中心点坐标
     * @param rotateAngle 旋转角度（单位为角度制，逆时针为正）
     * @param animated 是否开启动画模式
     * @returns {Promise<void>}
     */
    async setRotateCenterAndAngle(rotateCenter, rotateAngle, animated) {
        try {
            await MV.setRotateCenterAndAngle(
                this._MGMapViewId,
                rotateCenter._MGDotId,
                rotateAngle,
                animated
            );
        } catch (e) {
            console.error(e);
        }
    }

     /**
     *设置地图的旋转中心
     * @memberOf JSMapView
     * @param rotateCenter 地图的旋转中心
     * @returns {Promise<void>}
     */
	async setRotateCenter(rotateCenter)
	{
		try {
            await MV.setRotateCenter(this._MGMapViewId, rotateCenter);
        } catch (e) {
            console.error(e);
        }
	}

    /**
     *设置地图的旋转角
     * @memberOf JSMapView
     * @param rotateAngle 旋转角（单位为角度制，逆时针为正）
     * @param animated 是否启用动画
     * @returns {Promise<void>}
     */
    async setRotateAngle(rotateAngle, animated) {
        try {
            await MV.setRotateAngle(this._MGMapViewId, rotateAngle, animated);
        } catch (e) {
            console.error(e);
        }
    }

    /**
     *绕视图坐标旋转
     * @memberOf JSMapView
     * @param rotation 旋转增量（单位为角度制，逆时针为正）
     * @param pivotX 视图旋转中心X坐标
     * @param pivotY 视图旋转中心Y坐标
     * @param animated 是否启用动画
     * @returns {Promise<void>}
     */
    async rotate(rotation, pivotX, pivotY, animated) {
        try {
            await MV.rotate(this._MGMapViewId, rotation, pivotX, pivotY, animated);
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 获取地图的旋转中心
     * @memberOf JSMapView
     * @returns {Promise<Dot>} 旋转中心的坐标
     */
    async getRotateCenter() {
        try {
            var {dotID, x, y} = await MV.getRotateCenter(this._MGMapViewId);
            var dot = new Dot();
            dot._MGDotId = dotID;
            dot.x = x;
            dot.y = y;
            return dot;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 获取当前地图的旋转角
     * @memberOf JSMapView
     * @returns {Promise<Dot.rotateAngle>} 旋转角
     */
    async getRotateAngle() {
        try {
            var {rotateAngle} = await MV.getRotateAngle(this._MGMapViewId);
            return rotateAngle;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 设置当前地图的倾斜角,并将地图按该角度进行倾斜
     * @memberOf JSMapView
     * @param slopeAngle 倾斜角度(单位为角度制,0到45度,当天空场景启用后,角度范围为0到65度）
     * @param animated 是否开启动画
     * @returns {Promise<void>}
     */
    async setSlopeAngle(slopeAngle, animated) {
        try {
            await MV.setSlopeAngle(this._MGMapViewId, slopeAngle, animated);
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 获取当前地图的倾斜角
     * @memberOf JSMapView
     * @returns {Promise<float>} 当前地图的倾斜角
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
     * 更新位置(中心点为视图的绝对中心)
     * @memberOf JSMapView
     * @param postion 要更新到的位置
     * @param animated 是否开启动画
     * @returns {Promise<void>}
     */
    async updatePosition(postion, animated) {
        try {
            await MV.updatePosition(this._MGMapViewId, postion._MMapPosition, animated);
        } catch (e) {
            console.error(e);
        }
    }

    /**
	 * 更新位置(中心点为视图的指定中心)
	 * 
	 * @param postion 要更新到的位置
	 * @param viewCenterPoint 自定义视图中心
	 * @param animated 是否开启动画
     * @returns {Promise<void>}
	 */
	async updatePosition(postion, viewCenterPoint, animated)
	{
        try {
            await MV.updatePosition(this._MGMapViewId, postion._MMapPosition, viewCenterPoint._MGPointFId, animated);
        } catch (e) {
            console.error(e);
        }
	}


    /**
	 * 动画到指定位置(中心点为视图的绝对中心)
	 * 
	 * @param postion 要动画到的位置
	 * @param duration 持续时间(单位毫秒)
     * @returns {Promise<void>}
	 */
	async animatePosition(postion, duration)
	{
        try {
            await MV.animatePosition(this._MGMapViewId, postion._MMapPosition, duration);
        } catch (e) {
            console.error(e);
        }
    }

    /**
	 * 动画到指定位置(中心点为视图的指定中心)
     * @memberOf JSMapView
	 * @param postion 要动画到的位置
	 * @param viewCenterPoint 自定义视图中心
	 * @param duration 持续时间(单位毫秒)
     * @returns {Promise<void>}
	 */
    async animatePosition(postion, viewCenterPoint, duration)
	{
        try {
            await MV.animatePosition(this._MGMapViewId, postion._MMapPosition, viewCenterPoint._MGPointFId, duration);
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 停止动画效果
     * @memberOf JSMapView
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
     * 获取当前位置
     * @memberOf JSMapView
     * @returns {Promise<MapPosition>} 当前地图的位置
     */
    async getPosition() {
        try {
            var {mapPositionID} = await MV.getPosition(this._MGMapViewId);
            var mapPosition = new MapPosition();
            mapPosition._MMapPosition = mapPositionID;
            return mapPosition;
        } catch (e) {
            console.error(e);
        }
    }

     /**
     * 获取地图标记层
     * @memberOf JSMapView
     * @returns {Promise<AnnotationsOverlay>} 标记层
     */
    // async getAnnotationsOverlay()
    // {
    //     try {
    //         var {AnnotationsOverlayID} = await MV.getAnnotationsOverlay(
    //             this._MGMapViewId
    //         );
    //         var annotationsOverlay = new AnnotationsOverlay();
    //         annotationsOverlay._MGAnnotationsOverlayId = AnnotationsOverlayID;

    //         return annotationsOverlay;
    //     } catch (e) {
    //         console.error(e);
    //     }
    // }
    /**
     * 获取缺省的图形覆盖物列表
     * @memberOf JSMapView
     * @returns {Promise<GraphicsOverlay>} 缺省的图形覆盖物列表
     */
    async getGraphicsOverlay() {
        try {
            var {GraphicsOverlayID} = await MV.getGraphicsOverlay(
                this._MGMapViewId
            );
            var graphicsOverlay = new GraphicsOverlay();
            graphicsOverlay._MGGraphicsOverlayId = GraphicsOverlayID;

            return graphicsOverlay;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 获取图形覆盖物列表的集合
     * @memberOf JSMapView
     * @returns {Promise<GraphicsOverlays>} 图形覆盖物列表的集合
     */
    async getGraphicsOverlays() {
        try {
            var {GraphicsOverlaysID} = await MV.getGraphicsOverlays(
                this._MGMapViewId
            );
            var graphicsOverlays = new GraphicsOverlays();
            graphicsOverlays._MGGraphicsOverlaysId = GraphicsOverlaysID;
            return graphicsOverlays;
        } catch (e) {
            console.error(e);
        }
    }
    
    /**
     * 图形覆盖物点击测试
     * @memberOf JSMapView
     * @param graphicsOverlay
     * @param viewPoint 
     * @returns {Promise<Graphic>} 被选中的图形覆盖物
     */
    async graphicsOverlayHitTest(graphicsOverlay, viewPoint)
    {
        try {
            var {GraphicID} = await MV.graphicsOverlayHitTest(
                this._MGMapViewId,
                graphicsOverlay._MGGraphicsOverlayId,viewPoint._MGPointFId);
            var graphic = new Graphic();
            graphic._MGGraphicId = GraphicID;
            return graphic;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     *  图形点击测试
     * @memberOf JSMapView
     * @param graphic
     * @param viewPoint 
     * @returns {Promise<Boolean>} 是否被选中
     */
    async graphicHitTest(graphic, viewPoint)
    {
        try {
            var {bHit} = await MV.graphicHitTest(
                this._MGMapViewId, graphic._MGGraphicId, viewPoint._MGPointFId);
                
            return bHit;
        } catch (e) {
            console.error(e);
        }
    }
    
    /**
     *  获取模型覆盖物列表
     * @memberOf JSMapView
     * @returns {Promise<ModelsOverlay>} 模型覆盖物列表
     */
    async getModelsOverlay()
    {
        try {
            var {ModelsOverlayID} = await MV.getModelsOverlay(
                this._MGMapViewId);
            //     var modelsOverlay = new ModelsOverlay();
                
            // return modelsOverlay;
        } catch (e) {
            console.error(e);
        }
    }

     /**
     * 模型覆盖物点击测试
     * @memberOf JSMapView
     * @param viewPoint 
     * @returns {Promise<Model>} 被选中的模型覆盖物
     */
    async modelsOverlayHitTest(viewPoint)
    {
        try {
            var {ModelID} = await MV.modelsOverlayHitTest(
                this._MGMapViewId,viewPoint._MGPointFId);
            //     var model = new ModelID();
                
            // return model;
        } catch (e) {
            console.error(e);
        }
    }
    
    /**
     * 模型层点击测试
     * @summary 点击选中的模型可以将其添加到ModelsOverlay中,然后进行参数的修改,最后再通过SimpleModelLayerUtil更新回modelLayer
     * @memberOf JSMapView
     * @param modelLayer
     * @param viewPoint 
     * @returns {Promise<Model>}
     */
    async modelLayerHitTest(modelLayer, viewPoint)
    {
        try {
            var {ModelID} = await MV.modelLayerHitTest(
                this._MGMapViewId,
                modelLayer._MGSimpleModelLayerId,viewPoint._MGPointFId);
            //     var model = new ModelID();
                
            // return model;
        } catch (e) {
            console.error(e);
        }
    }
    /**
     * 设置纹理缓存的最大限额（单位为字节）
     * @memberOf JSMapView
     * @returns {Promise<void>}
     */
    async setMaxTextureCacheSize(size) {
        try {
            await MV.setMaxTextureCacheSize(this._MGMapViewId, size);
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 获取纹理缓存的最大限额（单位为字节）
     * @memberOf JSMapView
     * @returns {Promise<Number>} 设定的纹理缓存的最大限额
     */
    async getMaxTextureCacheSize() {
        try {
            var {MaxTextureCacheSize} = await MV.getMaxTextureCacheSize(
                this._MGMapViewId
            );
            return MaxTextureCacheSize;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 清除纹理缓存
     * @memberOf JSMapView
     * @returns {Promise<void>}
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
     * @memberOf JSMapView
     *
     * @param support true(支持矢量数据或者瓦片数据中的任意透明度值) false(仅支持全透)
     * @returns {Promise<void>}
     */
    async setSupportTransparency(support) {
        try {
            await MV.setSupportTransparency(this._MGMapViewId, support);
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 是否支持任意透明度
     * @memberOf JSMapView
     * @returns {Promise<boolean>}
     */
    async isSupportTransparency() {
        try {
            var {isSupportTransparency} = await MV.isSupportTransparency(
                this._MGMapViewId
            );
            return isSupportTransparency;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 设置自定义的地图工具
     * @memberOf JSMapView
     * @returns {Promise<void>}
     */
	async setMapTool()
	{
		try {
            await MV.setMapTool(this._MGMapViewId);
        } catch (e) {
            console.error(e);
        }
    }
    
    /**
	 * 获取当前地图视图的快照（截图）
	 * @memberOf JSMapView
	 * @returns {Promise<void>}
	 */
	async getScreenSnapshot()
	{
		try {
            await MV.getScreenSnapshot(this._MGMapViewId);
        } catch (e) {
            console.error(e);
        }
	}

	/**
	 * 获取当前地图视图指定区域的快照（截图）,视图区域的指定采用视图坐标系,通过左上角点的坐标和区域的宽高来确定,视图左上角坐标为(0, 0)<br>
	 * 如果指定区域超出视图范围,则超出部分以透明色填充
	 * @memberOf JSMapView
	 * @param left 指定视图区域的左上角点的x坐标
	 * @param top 指定视图区域的左上角点的y坐标
	 * @param width 指定视图区域的宽度
	 * @param height 指定视图区域的高度
     * @returns {Promise<void>}
	 */
	async getScreenSnapshot(left, top, width, height)
	{
		try {
            await MV.getScreenSnapshot(this._MGMapViewId, left, top, width, height);
        } catch (e) {
            console.error(e);
        }
	}

     /**
     * 根据指定的地图范围绘制地图.
     * <p>
	 * 详细说明:<br>
	 * 地图范围的指定采用地图坐标,成生的图像的宽高由用户在构造Bitmap对象时指定.<br>
	 * 生成的图像不包含地图视图的背景色.<br>
	 * 生成的图像含有透明通道,在视图上显示时,需要设置视图的背景颜色.如:可以设为地图视图的背景色.<br>
	 * 特别说明:<br>
	 * 用户构造的Bitmap像素格式必须为ARGB_8888<br>
	 * 示例代码:<br>
	 * 无<br>
	 * </p>
     * @memberOf JSMapView
     * @param  dispRange 指定的出图范围
     * @params params      Object
     * width      int
     * height     int
     * quality    int      0 - 100
     * type       string   png, jpg/jpeg, webp
     * @returns {Promise.<{result: Promise.result, uri: Promise.uri}>}
     */
	async getBitmap(dispRange, params = {})
	{
		try {
            let paramss = {width: 2000, height: 2000, quality: 60, type: 'png', dispRange: dispRange}
            Object.assign(paramss, params)
            let { result, uri } = await MV.getBitmap(this._MGMapViewId, paramss.dispRange, paramss.width, paramss.height, paramss.quality, paramss.type);
            return { result, uri }
          } catch (e) {
            console.error(e);
          }
	}

	/**
	 * 根据传入的参数生成，对应路口的放大图<br>
	 * 用户构造的Bitmap像素格式必须为ARGB_8888
	 * @memberOf JSMapView
	 * @param seg1 路口前一段路的地图坐标
	 * @param seg2 路口后一段路的地图坐标
	 * @param seg3 如果路口是环岛，则需要传入环岛下一段路的地图坐标
	 * @params params      Object
     * width      int
     * height     int
     * quality    int      0 - 100
     * type       string   png, jpg/jpeg, webp
     * @returns {Promise.<{result: Promise.result, uri: Promise.uri}>}
	 */
	async getCrossBitmap(seg1, seg2, seg3, params = {})
	{
		try {
            let paramss = {width: 2000, height: 2000, quality: 60, type: 'png', seg1: seg1, seg2: seg2, seg3: seg3}
            Object.assign(paramss, params)
            let { result, uri } = await MV.getCrossBitmap(this._MGMapViewId, paramss.seg1, paramss.seg2, paramss.seg3, paramss.width, paramss.height, paramss.quality, paramss.type);
            return { result, uri }
          } catch (e) {
            console.error(e);
          }
	}

	/**
	 * 显示放大镜.放大地图视图上指定区域的内容
	 * @memberOf JSMapView
	 * @param viewPointF 放大区域的中心点
	 * @param option 放大镜选项
     * @returns {Promise<void>}
	 */
	async showMagnifier(viewPointF, option)
	{
        try {
            await MV.showMagnifier(this._MGMapViewId, viewPointF._MGPointFId, option._MGMagnifierOptionId);
        } catch (e) {
            console.error(e);
        }
	}

    /**
     * 隐藏放大镜
     * @memberOf JSMapView
     * @returns {Promise<void>}
     */
	async hideMagnifier()
	{
		try {
            await MV.hideMagnifier(this._MGMapViewId);
        } catch (e) {
            console.error(e);
        }
	}

    /**
     * 打开放大镜功能 .当手指在屏幕上移动时，可自动放大手指所在位置的内容
     * @memberOf JSMapView
     * @param magnifierOption 放大镜选项
     * @returns {Promise<void>}
     */
	async turnOnMagnifier(magnifierOption)
	{
		try {
          await MV.turnOnMagnifier(this._MGMapViewId, magnifierOption._MGMagnifierOptionId);
        } catch (e) {
            console.error(e);
        }
	}

    /**
     * 关闭放大镜功能
     * @memberOf JSMapView
     * @returns {Promise<void>}
     */
	async turnOffMagnifier()
	{
		try {
            await MV.turnOffMagnifier(this._MGMapViewId);
        } catch (e) {
            console.error(e);
        }
	}


    /**
     * 设置是否显示指北针图标
     * @memberOf JSMapView
     *
     * @param {Boolean} show的值为true时显示指北针图标，反正不显示指北针图标
     * @returns {Promise<void>}
     */
    async setShowNorthArrow(show) {
        try {
            await MV.setShowNorthArrow(this._MGMapViewId, show);
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 获取是否显示指北针图标
     * @memberOf JSMapView
     * @returns {Promise<Boolean>} 返回值为true时，显示指北针图标。反之，没有显示指北针图标
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
     * @memberOf JSMapView     *
     * @param point 指北针图标的中心在地图视图中的坐标
     * @returns {Promise<void>}
     */
    async setNorthArrowPosition(point) {
        try {
            await MV.setNorthArrowPosition(this._MGMapViewId, point._MGPointFId);
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 获取指北针图标中心点在地图视图中的显示位置
     * @memberOf JSMapView
     * @returns {Promise<PointF>}
     */
    async getNorthArrowPosition() {
        try {
            var {pointFId, x, y} = await MV.getRotateCenter(this._MGMapViewId);
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
     * @memberOf JSMapView
     * @param image 指北针图标位图
     * @returns {Promise<void>}
     */
    async setNorthArrowImage(image) {
        try {
            await MV.setNorthArrowImage(this._MGMapViewId, image._MGImageId);
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 设置是否显示中地公司logo
     * @memberOf JSMapView     *
     * @param show 值为true时显示，反之，不显示
     * @returns {Promise<void>}
     */
    async setShowLogo(show) {
        try {
            await MV.setShowLogo(this._MGMapViewId, show);
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 获取是否显示中地公司logo
     * @memberOf JSMapView
     * @returns {Promise<Boolean>} 值为true时显示，反之，没显示
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
     * @memberOf JSMapView
     * @param position logo的方位
     * @see LOGO_POSITION_BOTTOM_LEFT等
     * @returns {Promise<void>}
     */
    async setLogoPoistion(position) {
        try {
            await MV.setShowLogo(this._MGMapViewId, position);
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 获取中地公司logo在地图视图中的显示位置
     * @memberOf JSMapView
     * @returns {Promise<int>} 中地公司logo在地图视图中的显示位置
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
     * @memberOf JSMapView
     * @param show 值为true时显示，反之，不显示
     * @returns {Promise<void>}
     */
    async setShowScaleBar(show) {
        try {
            await MV.setShowScaleBar(this._MGMapViewId, show);
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 获取是否显示比例尺
     * @memberOf JSMapView
     * @returns {Promise<boolean>} 值为true时显示，反之，没显示
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
     * @memberOf JSMapView
     * @param point 视图坐标
     * @returns {Promise<void>}
     */
    async setScaleBarPoistion(pointf) {
        try {
            await MV.setShowScaleBar(this._MGMapViewId, pointf._MGPointFId);
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 获取比例尺在地图视图中的显示位置
     * @memberOf JSMapView
     * @returns {Promise<PointF>} 比例尺在地图视图中的显示位置
     */
    async getScaleBarPoistion() {
        try {
            var {pointFId, x, y} = await MV.getScaleBarPoistion(this._MGMapViewId);
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
     * @memberOf JSMapView
     * @param image 天空图片
     * @returns {Promise<void>}
     */
    async setSkyImage(image) {
        try {
            await MV.setSkyImage(this._MGMapViewId, image._MGImageId);
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 设置天空场景是否启用,天空场景启用后,倾斜角可以加大到65度,默认情况下,天空场景处于启用状态
     * @memberOf JSMapView
     * @param enabled 天空场景是否启用
     * @returns {Promise<void>}
     */
    async setSkySceneEnabled(enabled) {
        try {
            await MV.setSkySceneEnabled(this._MGMapViewId, enabled);
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 获取天空场景是否启用的标志
     * @memberOf JSMapView
     * @returns {Promise<boolean>} 天空场景是否启用的标志
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
     * @memberOf JSMapView
     * @param enabled 值为true时启用，反之，不启用
     * @returns {Promise<void>}
     */
    async setZoomControlsEnabled(enabled) {
        try {
            await MV.setZoomControlsEnabled(this._MGMapViewId, enabled);
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 获取是否启用了内置的缩放按钮
     * @memberOf JSMapView
     * @returns {Promise<boolean>} 缩放按钮是否启用
     */
    async isZoomControlsEnabled() {
        try {
            var {isZoomControlsEnabled} = await MV.isZoomControlsEnabled(
                this._MGMapViewId
            );
            return isZoomControlsEnabled;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 设置是否启用地图平移手势
     * @memberOf JSMapView
     * @param enabled 值为true时启用，反之，不启用
     * @returns {Promise<void>}
     */
    async setMapPanGesturesEnabled(enabled) {
        try {
            await MV.setMapPanGesturesEnabled(this._MGMapViewId, enabled);
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 获取是否启用了平移手势
     * @memberOf JSMapView
     * @returns {Promise<boolean>} 是否启用了平移手势
     */
    async isMapPanGesturesEnabled() {
        try {
            var {isMapPanGesturesEnabled} = await MV.isMapPanGesturesEnabled(
                this._MGMapViewId
            );
            return isMapPanGesturesEnabled;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 设置是否启用地图缩放手势
     * @memberOf JSMapView
     * @param enabled 值为true时启用，反之，不启用
     * @returns {Promise<void>}
     */
    async setMapZoomGesturesEnabled(enabled) {
        try {
            await MV.setMapZoomGesturesEnabled(this._MGMapViewId, enabled);
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 获取是否启用了地图缩放手势
     * @memberOf JSMapView
     * @returns {Promise<boolean>} 值为true时启用，反之，不启用
     */
    async isMapZoomGesturesEnabled() {
        try {
            var {isMapZoomGesturesEnabled} = await MV.isMapZoomGesturesEnabled(
                this._MGMapViewId
            );
            return isMapZoomGesturesEnabled;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 设置是否启用地图旋转手势
     * @memberOf JSMapView     *
     * @param enabled 值为true时启用，反之，不启用
     * @returns {Promise<void>}
     */
    async setMapRotateGesturesEnabled(enabled) {
        try {
            await MV.setMapRotateGesturesEnabled(this._MGMapViewId, enabled);
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 获取是否启用了地图旋转手势
     * @memberOf JSMapView
     * @returns {Promise<boolean>} 值为true时启用，反之，不启用
     */
    async isMapRotateGesturesEnabled() {
        try {
            var {isMapRotateGesturesEnabled} = await MV.isMapRotateGesturesEnabled(
                this._MGMapViewId
            );
            return isMapRotateGesturesEnabled;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 设置是否启用地图倾斜手势
     * @memberOf JSMapView
     * @param enabled 值为true时启用，反之，不启用
     * @returns {Promise<void>}
     */
    async setMapSlopeGesturesEnabled(enabled) {
        try {
            await MV.setMapSlopeGesturesEnabled(this._MGMapViewId, enabled);
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 获取是否启用了地图倾斜手势
     * @memberOf JSMapView
     * @returns {Promise<boolean>} 值为true时启用，反之，不启用
     */
    async isMapSlopeGesturesEnabled() {
        try {
            var {isMapSlopeGesturesEnabled} = await MV.isMapSlopeGesturesEnabled(
                this._MGMapViewId
            );
            return isMapSlopeGesturesEnabled;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 设置是否双击放大地图
     * @memberOf JSMapView
     * @param {Boolean} enabled 值为true时启用，反之，不启用
     * @returns {Promise<void>}
     */
    async setDoubleTapZooming(enabled) {
        try {
            await MV.setDoubleTapZooming(this._MGMapViewId, enabled);
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 获取是否双击放大地图
     * @memberOf JSMapView
     * @returns {Promise<boolean>} 值为true时启用，反之，不启用
     */
    async isDoubleTapZooming() {
        try {
            var {isDoubleTapZooming} = await MV.isDoubleTapZooming(
                this._MGMapViewId
            );
            return isDoubleTapZooming;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 设置是否双指单击缩小地图
     * @memberOf JSMapView
     * @param {Boolean} enabled 值为true时启用，反之，不启用
     * @returns {Promise<void>}
     */
    async setTwoFingerTapZooming(enabled) {
        try {
            await MV.setTwoFingerTapZooming(this._MGMapViewId, enabled);
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 获取是否双指单击缩小地图
     * @memberOf JSMapView
     * @returns {Promise<boolean>} 值为true时启用，反之，不启用
     */
    async isTwoFingerTapZooming() {
        try {
            var {isTwoFingerTapZooming} = await MV.isTwoFingerTapZooming(
                this._MGMapViewId
            );
            return isTwoFingerTapZooming;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 设置是否启用平移结束后的动画
     * @memberOf JSMapView
     * @param enabled 值为true时启用，反之，不启用
     * @returns {Promise<void>}
     */
    async setPanEndAnimating(enabled) {
        try {
            await MV.setPanEndAnimating(this._MGMapViewId, enabled);
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 获取是否启用平移结束后的动画
     * @memberOf JSMapView
     * @returns {Promise<boolean>} 值为true时启用，反之，不启用
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
     * @memberOf JSMapView
     * @param enabled 值为true时启用，反之，不启用
     * @returns {Promise<void>}
     */
    async setLabelRenderAnimating(enabled) {
        try {
            await MV.setLabelRenderAnimating(this._MGMapViewId, enabled);
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 获取是否启用标记渲染的动画
     * @memberOf JSMapView
     * @returns {Promise<boolean>} 值为true时启用，反之，不启用
     */
    async isLabelRenderAnimating() {
        try {
            var {isLabelRenderAnimating} = await MV.isLabelRenderAnimating(
                this._MGMapViewId
            );
            return isLabelRenderAnimating;
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 添加单击事件监听
     * @memberOf JSMapView
     * @returns {Promise<void>}
     */
    async registerTapListener() {
        try {
            await MV.registerTapListener(this._MGMapViewId);
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 移除单击事件监听
     * @memberOf JSMapView
     * @returns {Promise<void>}
     */
    async unregisterTapListener() {
        try {
            await MV.unregisterTapListener(this._MGMapViewId);
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 添加长按事件监听
     * @memberOf JSMapView
     * @returns {Promise<void>}
     */
    async registerLongTapListener() {
        try {
            await MV.registerLongTapListener(this._MGMapViewId);
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 移除长按事件监听
     * @memberOf JSMapView
     * @returns {Promise<void>}
     */
    async unregisterLongTapListener() {
        try {
            await MV.unregisterLongTapListener(this._MGMapViewId);
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 添加双击事件监听
     * @memberOf JSMapView
     * @returns {Promise<void>}
     */
    async registerDoubleTapListener() {
        try {
            await MV.registerDoubleTapListener(this._MGMapViewId);
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 移除双击事件监听
     * @memberOf JSMapView
     * @returns {Promise<void>}
     */
    async unregisterDoubleTapListener() {
        try {
            await MV.unregisterDoubleTapListener(this._MGMapViewId);
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 添加触摸事件监听
     * @memberOf JSMapView
     * @returns {Promise<void>}
     */
    async registerTouchListener() {
        try {
            await MV.registerTouchListener(this._MGMapViewId);
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 移除触摸事件监听
     * @memberOf JSMapView
     * @returns {Promise<void>}
     */
    async unregisterTouchListener() {
        try {
            await MV.unregisterTouchListener(this._MGMapViewId);
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 添加地图视图级别改变的监听
     * @memberOf JSMapView
     * @returns {Promise<void>}
     */
    async registerZoomChangedListener() {
        try {
            await MV.registerZoomChangedListener(this._MGMapViewId);
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 移除地图视图级别改变的监听
     * @memberOf JSMapView
     * @returns {Promise<void>}
     */
    async unregisterZoomChangedListener() {
        try {
            await MV.unregisterZoomChangedListener(this._MGMapViewId);
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 添加地图视图中心点变化的监听
     * @memberOf JSMapView
     * @returns {Promise<void>}
     */
    async registerCenterChangedListener() {
        try {
            await MV.registerCenterChangedListener(this._MGMapViewId);
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 移除地图视图中心点变化的监听
     * @memberOf JSMapView
     * @returns {Promise<void>}
     */
    async unregisterCenterChangedListener() {
        try {
            await MV.unregisterCenterChangedListener(this._MGMapViewId);
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 添加地图视图旋转角度变化的监听
     * @memberOf JSMapView
     * @returns {Promise<void>}
     */
    async registerRotateChangedListener() {
        try {
            await MV.registerRotateChangedListener(this._MGMapViewId);
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 移除地图视图旋转角度变化的监听
     * @memberOf JSMapView
     * @returns {Promise<void>}
     */
    async unregisterRotateChangedListener() {
        try {
            await MV.unregisterRotateChangedListener(this._MGMapViewId);
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 地图视图地图位置变化的监听
     * @memberOf JSMapView
     * @returns {Promise<void>}
     */
    async registerPositionChangedListener()
    {
        try {
            await MV.registerPositionChangedListener(this._MGMapViewId);
        } catch (e) {
            console.error(e);
        }
    }

     /**
     * 移除地图视图地图位置变化的监听
     * @memberOf JSMapView
     * @returns {Promise<void>}
     */
    async unregisterPositionChangedListener() {
        try {
            await MV.unregisterPositionChangedListener(this._MGMapViewId);
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 地图视图动画的监听
     * @memberOf JSMapView
     * @returns {Promise<void>}
     */
    async registerAnimationListener() {
        try {
            await MV.registerAnimationListener(this._MGMapViewId);
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 移除地图视图动画的监听
     * @memberOf JSMapView
     * @returns {Promise<void>}
     */
    async unregisterAnimationListener() {
        try {
            await MV.unregisterAnimationListener(this._MGMapViewId);
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 地图视图刷新的监听
     * @memberOf JSMapView
     * @returns {Promise<void>}
     */
    async registerRefreshListener() {
        try {
            await MV.registerRefreshListener(this._MGMapViewId);
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 移除地图视图刷新的监听
     * @memberOf JSMapView
     * @returns {Promise<void>}
     */
    async unregisterRefreshListener() {
        try {
            await MV.unregisterRefreshListener(this._MGMapViewId);
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 地图视图地图加载的监听
     * @memberOf JSMapView
     * @returns {Promise<void>}
     */
    async registerMapLoadListener() {
        try {
            await MV.registerMapLoadListener(this._MGMapViewId);
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 移除地图加载监听
     * @memberOf JSMapView
     * @returns {Promise<void>}
     */
    async unregisterMapLoadListener() {
        try {
            await MV.unregisterMapLoadListener(this._MGMapViewId);
        } catch (e) {
            console.error(e);
        }
    }

    /**
     * 地图视图标记的监听
     * @memberOf JSMapView
     * @returns {Promise<void>}
     */
    async registerAnnotationListener()
	{
        try {
            await MV.registerAnnotationListener(this._MGMapViewId);
        } catch (e) {
            console.error(e);
        }
    }
    
     /**
     * 移除地图视图标记的监听
     * @memberOf JSMapView
     * @returns {Promise<void>}
     */
    async unregisterAnnotationListener() {
        try {
            await MV.unregisterAnnotationListener(this._MGMapViewId);
        } catch (e) {
            console.error(e);
        }
    }

     /**
     * 对当前地图中指定图层应用卷帘效果
     * 特别说明:由于移动端相邻的离线矢量图层是由同一个层渲染器渲染，所以对其中的任一离线矢量图层应用卷帘，会对相邻的所有离线矢量图层都起作用。
     * @memberOf JSMapView
     * @param swipeLayer 应用卷帘的图层,传null关闭卷帘效果
     * @param {object}swipeRegionDots 卷帘区域(应用卷帘的图层被擦除的区域),为视图坐标,原点在视图的左上角,区域必须为闭合区（首尾点应重合）
     * @returns {Promise<Number>} 0:失败,1:成功
     */    
    async swipe(swipeLayer, swipeRegionDots)
	{
        try {
           let {iResVal} = await MV.swipe(swipeLayer._MGMapLayerId, swipeRegionDots._MGDotsId);
           return  iResVal;
        } catch (e) {
            console.error(e);
        }
	}
}
