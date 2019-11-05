/**
 * @content 要素类功能组件
 * @author fjl 2019-6-25下午2:52:36
 */
import { NativeModules } from 'react-native';

let F = NativeModules.JSFeature;
import Graphic from './Graphic';
import GeoPoints from './GeoPoints.js'
import GeoVarLine from './GeoVarLine.js'
import GeoPolygon from './GeoPolygon.js'
import GeoPolygons from './GeoPolygons.js'
import GeoAnno from './GeoAnno.js'
import PntInfo from './PntInfo.js'
import LinInfo from './LinInfo.js'
import RegInfo from './RegInfo.js'
import TextAnnInfo from './TextAnnInfo.js'
import GraphicPoint from './GraphicPoint.js'
import GraphicCircle from './GraphicCircle.js'
import GraphicMultiPoint from './GraphicMultiPoint.js'
import GraphicPolylin from './GraphicPolylin.js'
import GraphicStippleLine from './GraphicStippleLine.js'
import GraphicText from './GraphicText.js'
import GraphicHeatmap from './GraphicHeatmap.js'
import GraphicPolygon from './GraphicPolygon.js'
import GraphicImage from './GraphicImage.js'


/**
 * @class Feature
 */
export default class Feature {
  /**
   * 构造一个新的 Feature 对象。
   * @memberOf Feature
   * @returns {Promise.<Feature>}
   */
  async createObj() {
    try {
      var { FeatureId } = await F.createObj();
      var feature = new Feature();
      feature._MGFeatureId = FeatureId;
      return feature;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   *  获取要素ID
   *  @memberOf Feature
   * @returns {Promise<*|*>}
   */
  async getID() {
    try {
      let ID = await F.getID(this._MGFeatureId);
      return ID;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取要素属性
   * @memberOf Feature
   */
  async getAttributes() {
    try {
      let { jsonAttributes } = await F.getAttributes(this._MGFeatureId);
      return jsonAttributes;
    } catch (e) {
      console.error(e);
    }
  }

  /**
	 * 获取几何数据
	 * @memberOf Feature
	 * @return {Promise<Geometry>}几何数据
	 */
	async getGeometry()
	{
    try {
      let { GeometryId,GeometryType } = await F.getGeometry(this._MGFeatureId);
      let geometry = null;
      switch(GeometryType)
      {
        case 2:
            geometry = new GeoPoints();
            geometry._MGGeometryId = GeometryId;
          break;
          case 12:
            geometry = new GeoVarLine();
            geometry._MGGeometryId = GeometryId;
          break;
          case 14:
            geometry = new GeoPolygon();
            geometry._MGGeometryId = GeometryId;
          break;
          case 15:
            geometry = new GeoPolygons();
            geometry._MGGeometryId = GeometryId;
          break;
          case 17:
            geometry = new GeoAnno();
            geometry._MGGeometryId = GeometryId;
            break;
          default:
            break;
      }
      return geometry;
    } catch (e) {
      console.error(e);
    }
	}

	/**
	 * 获取几何信息
	 * @memberOf Feature
	 * @return {Promise<GeomInfo>}几何信息
	 */
	async getInfo()
	{
    try {
      let { GeomInfoId,GeometryType} = await F.getInfo(this._MGFeatureId);
      let geomInfo = null;
      switch(GeometryType)
      {
        case 2:
            geomInfo = new PntInfo();
            geomInfo._MGGeomInfoId = GeomInfoId;
          break;
          case 12:
            geomInfo = new LinInfo();
            geomInfo._MGGeomInfoId = GeomInfoId;
          break;
          case 14:
            geomInfo = new RegInfo();
            geomInfo._MGGeomInfoId = GeomInfoId;
          break;
          case 15:
            geomInfo = new RegInfo();
            geomInfo._MGGeomInfoId = GeomInfoId;
          break;
          case 17:
            geomInfo = new TextAnnInfo();
            geomInfo._MGGeomInfoId = GeomInfoId;
            break;
          default:
            break;
      }
      return geomInfo;
    } catch (e) {
      console.error(e);
    }
	}


  /**
   * 要素转Graphic
   *  @memberOf Feature
   * @returns {Promise<Array>}
   */
  async toGraphics() {
    try {
      let { values } = await F.toGraphics(this._MGFeatureId);
      let objArr = [];
      for (let i = 0; i < values.length; i++) {
        let graphic = new Graphic();
        graphic._MGGraphicId = values[i];
        let type = await graphic.getGraphicType();
        let graphicBase = null;
        switch(type)
        {
          case 1:
            graphicBase = new GraphicPoint();
            graphicBase._MGGraphicId = values[i];
            break;
            case 2:
              graphicBase = new GraphicCircle();
              graphicBase._MGGraphicId = values[i];
            break;
            case 3:
              graphicBase = new GraphicPolylin();
              graphicBase._MGGraphicId = values[i];
            break;
            case 4:
              graphicBase = new GraphicPolygon();
              graphicBase._MGGraphicId = values[i];
            break;
            case 5:
              graphicBase = new GraphicImage();
              graphicBase._MGGraphicId = values[i];
              break;
            case 6:
              graphicBase = new GraphicText();
              graphicBase._MGGraphicId = values[i];
              break;
            case 7:
              graphicBase = new GraphicMultiPoint();
              graphicBase._MGGraphicId = values[i];
              break;
            case 8:
              graphicBase = new GraphicStippleLine();
              graphicBase._MGGraphicId = values[i];
              break;
            case 19:
              graphicBase = new GraphicHeatmap();
              graphicBase._MGGraphicId = values[i];
              break;
            default:
              break;
        }
        objArr.push(graphicBase);
      }
      return objArr;
    } catch (e) {
      console.error(e);
    }
  }

  	/**
	 * 清空
	 * @memberOf Feature
	 * @return {Promise<long>}大于0成功，否则失败
	 */
  async reSet()
	{
		try {
      return await F.reSet(this._MGFeatureId);
    } catch (e) {
      console.error(e);
    }
	}

}
