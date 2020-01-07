/*
 * @Description: In User Settings Edit
 * @Author: xiaoying
 * @Date: 2019-09-10 19:43:30
 * @LastEditTime: 2019-09-20 16:22:43
 * @LastEditors: mayuanye
 */
import { NativeModules } from 'react-native';
import SketchStyle from './SketchStyle';
import SnappingOption from './SnappingOption';
import Dot from './Dot';
import SRefData from './SRefData';
import Geometry from './Geometry.js';
// import GeoPoint from "./GeoPoint";
import GeoPoints from './GeoPoints';
// import GeoCir from "./GeoCir";
// import GeoCir3 from "./GeoCir3";
// import GeoEllipse from "./GeoEllipse";
// import GeoArc from "./GeoArc";
// import GeoArc3 from "./GeoArc3";
// import GeoRect from "./GeoRect";
// import GeoRect1 from "./GeoRect1";
// import GeoSpline from "./GeoSpline";
import GeoVarLine from './GeoVarLine';
import GeoLines from './GeoLines';
import GeoPolygon from './GeoPolygon';
import GeoPolygons from './GeoPolygons';
// import GeoGeometrys from "./GeoGeometrys";
import GeoAnno from './GeoAnno';

// import ArcAnno from "./ArcAnno";
// import CircleAnno from "./CircleAnno";
// import HtmlAnno from "./HtmlAnno";
// import ImageAnno from "./ImageAnno";
import TextAnno from './TextAnno';
import MeasureOption from './MeasureOption';
let SE = NativeModules.JSSketchEditor;

/**
 * @class SketchEditor
 * @description 草图编辑器
 */
export default class SketchEditor {
  /**
   * 构造一个新的SketchEditor对象
   *
   * @memberof SketchEditor
   * @param {Object} mapView 地图视图对象
   * @returns {Promise<SketchEditor>}
   */
  async createObj(mapView) {
    try {
      var { SketchEditorId } = await SE.createObj(mapView._MGMapViewId);
      var sketchEditor = null;
      if (SketchEditorId != null) {
        sketchEditor = new SketchEditor();
        sketchEditor._MGSketchEditorId = SketchEditorId;
      }

      return sketchEditor;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 添加状态改变监听
   *
   * @memberof SketchEditor
   * @returns {Promise<Void>}
   */
  async addStateChangedListener() {
    try {
      await SE.addStateChangedListener(this._MGSketchEditorId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 移除状态改变监听
   *
   * @memberof SketchEditor
   * @returns {Promise<Void>}
   */
  async removeStateChangedListener() {
    try {
      await SE.removeStateChangedListener(this._MGSketchEditorId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取草图样式
   * @memberof SketchEditor
   * @returns {Promise<SketchStyle>}
   */
  async getSketchStyle() {
    try {
      var { SketchStyleId } = await SE.getSketchStyle(this._MGSketchEditorId);
      var sketchStyle = null;
      if (SketchStyleId != null) {
        sketchStyle = new SketchStyle();
        sketchStyle._MGSketchStyleId = SketchStyleId;
      }

      return sketchStyle;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置草图样式
   * @memberof SketchEditor
   * @param {Object} sketchStyle 草图样式(SketchStyle类型的Object)
   * @returns {Promise<Void>}
   */
  async setSketchStyle(sketchStyle) {
    try {
      await SE.setSketchStyle(
        this._MGSketchEditorId,
        sketchStyle._MGSketchStyleId
      );
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取捕捉选项
   * @memberof SketchEditor
   * @returns {Promise<SnappingOption>}
   */
  async getSnappingOption() {
    try {
      var { SnappingOptionId } = await SE.getSnappingOption(
        this._MGSketchEditorId
      );
      var snappingOption = null;
      if (SnappingOptionId != null) {
        snappingOption = new SnappingOption();
        snappingOption._MGSnappingOptionId = SnappingOptionId;
      }
      return snappingOption;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置捕捉选项
   * @memberof SketchEditor
   * @param {Object} snappingOption 捕捉选项(SnappingOption类型的Object)
   * @returns {Promise<Void>}
   */
  async setSnappingOption(snappingOption) {
    try {
      await SE.setSnappingOption(
        this._MGSketchEditorId,
        snappingOption._MGSnappingOptionId
      );
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 依据指定的数据类型开始新的几何编辑
   * @memberof SketchEditor
   * @param {Number} sketchDataType 几何类型（int类型的Number，例:1--SketchDataType.POINT）
   * @returns {Promise<Void>}
   */
  async startByType(sketchDataType) {
    try {
      await SE.startByType(this._MGSketchEditorId, sketchDataType);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 开始编辑已有的几何对象
   * @memberof SketchEditor
   * @param {Object} geometry 几何对象
   * @returns {Promise<Void>}
   */
  async start(geometry) {
    try {
      await SE.start(this._MGSketchEditorId, geometry._MGGeometryId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取编辑的数据类型
   * @memberof SketchEditor
   * @returns {Number} 几何类型（int类型的Number，例:1--SketchDataType.POINT，-1表示获取失败）
   */
  async getSketchDataType() {
    try {
      let result = await SE.getSketchDataType(this._MGSketchEditorId);
      return result;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 替换当前的编辑几何对象
   * @memberof SketchEditor
   * @param {Object} geometry 几何对象
   * @returns {Promise<Void>}
   */
  async replaceGeometry(geometry) {
    try {
      await SE.replaceGeometry(this._MGSketchEditorId, geometry._MGGeometryId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取当前的编辑几何
   * @memberof SketchEditor
   * @returns {Promise<Geometry>} 成功返回几何对象
   */
  async getGeometry() {
    try {
      let { GeometryId, GeometryType, GeometryAnnoType } = await SE.getGeometry(
        this._MGSketchEditorId
      );
      let geometry = SketchEditor.getGeometryByType(
        GeometryId,
        GeometryType,
        GeometryAnnoType
      );
      return geometry;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 清除当前的编辑几何
   * @memberof SketchEditor
   * @returns {Promise<Void>}
   */
  async clearGeometry() {
    try {
      await SE.clearGeometry(this._MGSketchEditorId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 停止编辑
   * @memberof SketchEditor
   * @returns {Promise<Void>}
   */
  async stop() {
    try {
      await SE.stop(this._MGSketchEditorId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 删除当前被选中的顶点
   * @memberof SketchEditor
   * @returns {boolean}
   */
  async deleteSelectedVertex() {
    try {
      let result = await SE.deleteSelectedVertex(this._MGSketchEditorId);
      return result;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 移动当前被选中的顶点到指定的位置（地图坐标）
   * @memberof SketchEditor
   * @param {Number} x坐标的值
   * @param {Number} y坐标的值
   * @returns {boolean}
   */
  async moveSelectedVertexTo(x, y) {
    try {
      let result = await SE.moveSelectedVertexTo(this._MGSketchEditorId, x, y);
      return result;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 添加新的顶点（地图坐标）
   * @memberof SketchEditor
   * @param {Number} x坐标的值
   * @param {Number} y坐标的值
   * @returns {Promise<Void>}
   */
  async addVertex(x, y) {
    try {
      await SE.addVertex(this._MGSketchEditorId, x, y);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 试图捕捉指定点（地图坐标，返回被捕捉到的点，返回null表示捕捉失败
   * @memberof SketchEditor
   * @param {Number} x坐标的值
   * @param {Number} y坐标的值
   * @returns {Promise<Dot>} 返回null表示捕捉失败
   */
  async snapping(x, y) {
    try {
      var { point2DId } = await SE.snapping(this._MGSketchEditorId, x, y);
      var dot = null;
      if (point2DId != null) {
        dot = new Dot();
        dot._MGDotId = point2DId;
      }

      return dot;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 撤销
   * @memberof SketchEditor
   * @returns {boolean} true-成功；false-失败
   */
  async undo() {
    try {
      let result = await SE.undo(this._MGSketchEditorId);

      return result;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 重做
   * @memberof SketchEditor
   * @returns {boolean} true-成功；false-失败
   */
  async redo() {
    try {
      let result = await SE.redo(this._MGSketchEditorId);

      return result;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 草图几何是否有效（点几何必须有1个顶点、线必须有2个顶点、区必须有3个顶点）
   * @memberof SketchEditor
   * @returns {boolean}
   */
  async isSketchValid() {
    try {
      let result = await SE.isSketchValid(this._MGSketchEditorId);

      return result;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置地图位置组件
   *
   * @memberof SketchEditor
   * @param {Object} magnifierOption 地图位置组件
   * @returns {Promise<Void>}
   */
  async setMagnifierOption(magnifierOption) {
    try {
      await SE.setMagnifierOption(
        this._MGSketchEditorId,
        magnifierOption._MGMagnifierOptionId
      );
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置编辑数据的空间参考系，用于计算实地距离和面积
   * @memberof SketchEditor
   * @param {SRefData} 空间参考系
   * @returns {Promise<Void>}
   */
  async setSRS(sRefData) {
    try {
      await SE.setSRS(this._MGSketchEditorId, sRefData._MGSRefDataId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取空间参考系
   * @memberof SketchEditor
   * @returns {Promise<SRefData>}
   */
  async getSRS() {
    try {
      var { SRefDataId } = await SE.getSRS(this._MGSketchEditorId);
      var sRefData = null;
      if (SRefDataId != null) {
        sRefData = new SRefData();
        sRefData._MGSRefDataId = SRefDataId;
      }

      return sRefData;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置量算参数选项
   * 
   * @memberof SketchEditor
   * @param {MeasureOption} measureOption 量算参数选项
   * @returns {Promise<Void>}
   */
  async setMeasureOption(measureOption){
    try {
      if(measureOption === undefined || measureOption === null){
        console.error('measureOption is undefined or null');
        return;
      }

      await SE.setMeasureOption(this._MGSketchEditorId, measureOption._MGMeasureOptionId);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取量算参数选项
   * 
   * @memberof SketchEditor
   * @returns {Promise<MeasureOption>}
   */
  async getMeasureOption(){
    try {
      let {MeasureOptionId} = await SE.getMeasureOption(this._MGSketchEditorId);
      let measureOption = null;
      if(MeasureOptionId !== null){
        measureOption = new MeasureOption();
        measureOption._MGMeasureOptionId = MeasureOptionId;
      }

      return measureOption;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 根据返回的geometryId,geometryType，geometryAnnType构造geometry对象
   *
   * @param {String} geometryId 几何对象对应的Id
   * @param {int} geometryType  几何对象类型
   * @param {int} geometryAnnType 几何对象为GeoAnno类型时候的AnnType
   * @returns {Geometry} geometry或子类对象
   */
  static async getGeometryByType(GeometryId, geometryType, geometryAnnType) {
    try {
      let geometry = null;

      if (GeometryId != null) {
        switch (geometryType) {
          case -1: // GeoUnknown_Type : -1
            geometry = new Geometry();
            geometry._MGGeometryId = GeometryId;
            break;

          case 1: // GeoPoint_Type : 1
            // geometry = new GeoPoint();
            // geometry._MGGeometryId = GeometryId;
            break;

          case 2: // GeoPoints_Type : 2
            geometry = new GeoPoints();
            geometry._MGGeometryId = GeometryId;
            break;

          case 3: // GeoCir_Type : 3
            // geometry = new GeoCir();
            // geometry._MGGeometryId = GeometryId;
            break;

          case 4: // GeoCir3_Type : 4
            // geometry = new GeoCir3();
            // geometry._MGGeometryId = GeometryId;
            break;

          case 5: // GeoEllipse_Type : 5
            // geometry = new GeoEllipse();
            // geometry._MGGeometryId = GeometryId;
            break;

          case 6: // GeoArc_Type: 6
            // geometry = new GeoArc();
            // geometry._MGGeometryId = GeometryId;
            break;

          case 7: // GeoArc3_Type : 7
            // geometry = new GeoArc3();
            // geometry._MGGeometryId = GeometryId;
            break;

          case 8: // GeoRect_Type : 8
            // geometry = new GeoRect();
            // geometry._MGGeometryId = GeometryId;
            break;

          case 9: // GeoRect1_Type : 9
            // geometry = new GeoRect1();
            // geometry._MGGeometryId = GeometryId;
            break;

          case 10: // GeoSpline_Type : 10
            // geometry = new GeoSpline();
            // geometry._MGGeometryId = GeometryId;
            break;

          case 11: // GeoBezier_Type : 11
            // geometry = new GeoBezier();
            // geometry._MGGeometryId = GeometryId;
            break;

          case 12: // GeoVarLine_Type : 12
            geometry = new GeoVarLine();
            geometry._MGGeometryId = GeometryId;
            break;

          case 13: // GeoLines_Type : 13
            geometry = new GeoLines();
            geometry._MGGeometryId = GeometryId;
            break;

          case 14: // GeoPolygon_Type : 14
            geometry = new GeoPolygon();
            geometry._MGGeometryId = GeometryId;
            break;

          case 15: // GeoPolygons_Type : 15
            geometry = new GeoPolygons();
            geometry._MGGeometryId = GeometryId;
            break;

          case 16: // GeoGeometrys_Type : 16
            // geometry = new GeoGeometrys();
            // geometry._MGGeometryId = GeometryId;
            break;

          case 17: // GeoAnno_Type : 17
            switch (geometryAnnType) {
              case -1: // 未知类型:-1-AnnType.AnnUnknown，直接返回GeoAnno
                geometry = new GeoAnno();
                geometry._MGGeometryId = GeometryId;
                break;
              case 0: //字符串注记类型标志:0-AnnType.AnnText
                geometry = new TextAnno();
                geometry._MGGeometryId = GeometryId;
                break;
              case 1: // html版面注记类型标志:1-AnnType.AnnHTML
                // geometry = new HtmlAnno();
                // geometry._MGGeometryId = GeometryId;
                break;
              case 2: // 2-AnnType.AnnAtt
                break;
              case 3: // 2-AnnType.AnnDim
                break;
              case 4: // 弧注记类型标志:4-AnnType.AnnDim
                // geometry = new ArcAnno();
                // geometry._MGGeometryId = GeometryId;
                break;
              case 5: // 圆注记类型标志:5-AnnType.AnnCirCle
                // geometry = new CircleAnno();
                // geometry._MGGeometryId = GeometryId;
                break;
              case 6: // 图像注记类型标志:6-AnnType.AnnImage
                // geometry = new ImageAnno();
                // geometry._MGGeometryId = GeometryId;
                break;
            }
            break;
        }
      }

      return geometry;
    } catch (e) {
      console.error(e);
    }
  }
}
