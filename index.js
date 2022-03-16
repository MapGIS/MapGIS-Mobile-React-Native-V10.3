/*
 * @Description: In User Settings Edit
 * @author: lidafeng 
 * @Date: 2019-09-05 18:06:47
 * @LastEditTime: 2019-09-10 10:20:03
 * @LastEditors: mayuanye
 */
import { NativeModules } from "react-native";
let ClassItemType = NativeModules.JSClassItemType;
let AllOtherDataItemInfoSource = NativeModules.JSAllOtherDataItemInfoSource;
let DuplicateType = NativeModules.JSDuplicateType;
let DocItemType = NativeModules.JSDocItemType;
let LabelBackType = NativeModules.JSLabelBackType;
let LabelType = NativeModules.JSLabelType;
let LabelGeomType = NativeModules.JSLabelGeomType;
let LayerState = NativeModules.JSLayerState;
let LinePlaceType = NativeModules.JSLinePlaceType;
let LineRepeatType = NativeModules.JSLineRepeatType;
let LineRestrictType = NativeModules.JSLineRestrictType;
let LineSpreadType = NativeModules.JSLineSpreadType;
let MapServerAccessMode = NativeModules.JSMapServerAccessMode;
let MapServerBrowseType = NativeModules.JSMapServerBrowseType;
let PointEightLocationPriority = NativeModules.JSPointEightLocationPriority;
let PointPlaceType = NativeModules.JSPointPlaceType;
let RegPlaceType = NativeModules.JSRegPlaceType;
let ThemeType = NativeModules.JSThemeType;
let TileSliceType = NativeModules.JSTileSliceType;
let VectorLayerType = NativeModules.JSVectorLayerType;
let MeasureType = NativeModules.JSMeasureType;
let SketchDataType = NativeModules.JSSketchDataType;
let CoordinateType = NativeModules.JSCoordinateType;
let SketchMeasureUnitType = NativeModules.JSSketchMeasureUnitType;

let CoordType = NativeModules.JSCoordType;
let LevelType = NativeModules.JSLevelType;
let ProjType = NativeModules.JSProjType;
let SpheroidType = NativeModules.JSSpheroidType;
let VDatumType = NativeModules.JSVDatumType;
let ZoneType = NativeModules.JSZoneType;
let AnnType = NativeModules.JSAnnType;
let DistanceType = NativeModules.JSDistanceType;
let GeometryDimension = NativeModules.JSGeometryDimension;
let GeometryType = NativeModules.JSGeometryType;
let GeomType = NativeModules.JSGeomType;

let FieldType = NativeModules.JSFieldType;
let SpaQueryMode = NativeModules.JSSpaQueryMode;
let XClsType = NativeModules.JSXClsType;

let SunLightingMode = NativeModules.JSSunLightingMode;
let DriverType = NativeModules.JSDriverType;
let SRSType = NativeModules.JSSRSType;
let Layer3DType = NativeModules.JSLayer3DType;
let FlyStatus = NativeModules.JSFlyStatus;
let AltitudeMode = NativeModules.JSAltitudeMode;
let GraphicState = NativeModules.JSGraphicState;
let GraphicType3D = NativeModules.JSGraphicType3D;
let GraphicImage3DAlignmentMode = NativeModules.JSGraphicImage3DAlignmentMode;
let GraphicText3DAlignmentMode = NativeModules.JSGraphicText3DAlignmentMode;

import MGMapView from "./js/components/MGSMapViewUI";
import MGSSceneView from "./js/components/MGSSceneViewUI"
import MapPosition from "./js/MapPosition";
import Environment from "./js/Environment";
import Dot from "./js/Dot";
import Dot3D from "./js/Dot3D";
import Feature from "./js/Feature";
import FeaturePagedResult from "./js/FeaturePagedResult";
import FeatureQuery from "./js/FeatureQuery";
import Graphic from "./js/Graphic";
import GraphicCircle from "./js/GraphicCircle";
import GraphicImage from "./js/GraphicImage";
import GraphicMultiPoint from "./js/GraphicMultiPoint";
import GraphicPoint from "./js/GraphicPoint";
import GraphicPolygon from "./js/GraphicPolygon";
import GraphicPolylin from "./js/GraphicPolylin";
import GraphicsOverlay from "./js/GraphicsOverlay";
import GraphicsOverlays from "./js/GraphicsOverlays";
import GraphicStippleLine from "./js/GraphicStippleLine";
import GraphicText from "./js/GraphicText";
import GraphicHeatmap from "./js/GraphicHeatmap";
import HeatmapPoint from "./js/HeatmapPoint";
import VisualMap from "./js/VisualMap";

import Image from "./js/Image";
import Map from "./js/Map";
import MapLayer from "./js/MapLayer";
import MapView from "./js/MapView";
import PointF from "./js/PointF";
import QueryBound from "./js/QueryBound";
import Rect from "./js/Rect";
import VectorLayer from "./js/VectorLayer";
import SRefData from "./js/SRefData";
import LayerEnum from "./js/LayerEnum";
import ClassItemValue from "./js/ClassItemValue";
import DocumentItem from "./js/DocumentItem";
import Document from "./js/Document";
import Maps from "./js/Maps";
import GeneralVectorLabel from "./js/GeneralVectorLabel";
import GroupLayer from "./js/GroupLayer";
import Label from "./js/Label";
import LabelInfo from "./js/LabelInfo";
import LinePlaceInfo from "./js/LinePlaceInfo";
import MapServer from "./js/MapServer";
import MultiClassThemeInfo from "./js/MultiClassThemeInfo.js";
import MultiClassTheme from "./js/MultiClassTheme.js";
import ThemeInfo from "./js/ThemeInfo.js";
import PointPlaceInfo from "./js/PointPlaceInfo.js";
import RangeThemeInfo from "./js/RangeThemeInfo.js";
import RangeTheme from "./js/RangeTheme.js";
import RegionPlaceInfo from "./js/RegionPlaceInfo.js";
import SimpleLabel from "./js/SimpleLabel.js";
import SimpleModelLayer from "./js/SimpleModelLayer";
import SimpleTheme from "./js/SimpleTheme";
import Theme from "./js/Theme";
import Themes from "./js/Themes";
import TileMapServer from "./js/TileMapServer";
import IntUser from "./js/IntUser";
import UniqueThemeInfo from "./js/UniqueThemeInfo";
import UniqueTheme from "./js/UniqueTheme";
import VectorLabel from "./js/VectorLabel";
import VectorMapServer from "./js/VectorMapServer";
import VectorTileMapServer from "./js/VectorTileMapServer";
import VectorTheme from "./js/VectorTheme";
import OGCWMTSMapServer from "./js/OGCWMTSMapServer";
import ServerLayer from "./js/ServerLayer";

import Model from './js/Model';
import ModelsOverlay from "./js/ModelsOverlay";
import SimpleModelLayerUtil from "./js/SimpleModelLayerUtil";

import FillStyle from "./js/FillStyle";
import GeometryParams from "./js/GeometryParams";
import LineStyle from "./js/LineStyle";
import PointStyle from "./js/PointStyle";
import SketchEditor from "./js/SketchEditor";
import SketchStyle from "./js/SketchStyle";
import SnappingOption from "./js/SnappingOption";
import TextStyle from "./js/TextStyle";
import MeasureOption from './js/MeasureOption';
import MeasureContentWillChangeListener from './js/MeasureContentWillChangeListener';

import CoordinateConvert from "./js/CoordinateConvert";
import CoordinateConvertParameter from "./js/CoordinateConvertParameter";

import ElpParam from "./js/ElpParam";
import ElpTransParam from "./js/ElpTransParam";
import ElpTransformation from "./js/ElpTransformation";

import Dots from "./js/Dots";
import Dots3D from "./js/Dots3D"
import Geometry from "./js/Geometry";
import GeometryExp from "./js/GeometryExp";
import GeoAnno from "./js/GeoAnno";
import GeoLine from "./js/GeoLine";
import GeoLines from "./js/GeoLines";
import GeoPoints from "./js/GeoPoints";
import GeoPolygon from "./js/GeoPolygon";
import GeoPolygons from "./js/GeoPolygons";
import GeoVarLine from "./js/GeoVarLine";
import TextAnno from "./js/TextAnno";

import GeomInfo from "./js/GeomInfo"
import AnnInfo from "./js/AnnInfo"
import LinInfo from "./js/LinInfo"
import PntInfo from "./js/PntInfo"
import RegInfo from "./js/RegInfo"
import TextAnnInfo from "./js/TextAnnInfo"

import ExtField from "./js/ExtField"
import Field from "./js/Field"
import Fields from "./js/Fields"
import Record from "./js/Record"

import XClsInfo from "./js/XClsInfo"
import AnnClsInfo from "./js/AnnClsInfo"
import FClsInfo from "./js/FClsInfo"
import BasCls from "./js/BasCls"
import VectorCls from "./js/VectorCls"
import AnnotationCls from "./js/AnnotationCls"
import SFeatureCls from "./js/SFeatureCls"
import DataBase from "./js/DataBase"
import QueryDef from "./js/QueryDef"
import RecordSet from "./js/RecordSet"

import CrossData from "./js/CrossData"
import SpaAnalysis from "./js/SpaAnalysis"
import SpaCalculator from "./js/SpaCalculator"
import SpaProjection from "./js/SpaProjection"
import SpaRelation from "./js/SpaRelation"

import DataBaseSync from "./js/DataBaseSync"
import DownloadDataBaseParmeters from "./js/DownloadDataBaseParmeters"
import DownloadLayerOption from "./js/DownloadLayerOption"
import FeatureEdit from "./js/FeatureEdit"
import FeatureSync from "./js/FeatureSync"
import MapServiceInfo from "./js/MapServiceInfo"
import MapServiceLayerInfo from "./js/MapServiceLayerInfo"
import SyncBase from "./js/SyncBase"
import SyncDataBaseParmeters from "./js/SyncDataBaseParmeters"
import SyncLayerOption from "./js/SyncLayerOption"

import Annotation from "./js/Annotation"
import AnnotationsOverlay from "./js/AnnotationsOverlay"
import AnnotationView from "./js/AnnotationView"

import Layer3D from "./js/scene/Layer3D"
import Layer3DEnum from "./js/scene/Layer3DEnum"
import Rect3D from "./js/scene/Rect3D"
import Scene from "./js/scene/Scene"
import SceneView from "./js/scene/SceneView"
import VectorLayer3D from "./js/scene/VectorLayer3D"
import ServerLayer3D from "./js/scene/ServerLayer3D"
import TerrainLayer3D from "./js/scene/TerrainLayer3D"
import GroupLayer3D from "./js/scene/GroupLayer3D"
import ModelCacheLayer3D from "./js/scene/ModelCacheLayer3D"
import SelectionStyle from "./js/scene/SelectionStyle"
import SelectionProperties from "./js/scene/SelectionProperties"
import Viewpoint from "./js/scene/Viewpoint"
import FlyManager from "./js/scene/FlyManager"
import GeoElement from "./js/scene/GeoElement"
import IdentifyLayerResult from "./js/scene/IdentifyLayerResult"
import Feature3D from "./js/scene/Feature3D"
import Geometry3D from "./js/scene/Geometry3D"
import FeaturePagedResult3D from "./js/scene/FeaturePagedResult3D"
import FeatureQuery3D from "./js/scene/FeatureQuery3D"
import QueryBound3D from "./js/scene/QueryBound3D"
import Graphic3D from "./js/scene/Graphic3D"
import Graphic3DsOverlay from "./js/scene/Graphic3DsOverlay"
import Graphic3DsOverlays from "./js/scene/Graphic3DsOverlays"
import GraphicMultiPoint3D from "./js/scene/GraphicMultiPoint3D"
import GraphicPoint3D from "./js/scene/GraphicPoint3D"
import GraphicPolygon3D from "./js/scene/GraphicPolygon3D" 
import GraphicPolyline3D from "./js/scene/GraphicPolyline3D"
import GraphicPlaceMarker from "./js/scene/GraphicPlaceMarker"
import TerrainAnalysis from "./js/scene/TerrainAnalysis"
import MeasurementChangedEvent from "./js/scene/MeasurementChangedEvent"

export {
  MGMapView,
  MGSSceneView,
  MapPosition,
  Environment,
  Dot,
  Dot3D,
  Feature,
  FeaturePagedResult,
  FeatureQuery,
  Graphic,
  GraphicCircle,
  GraphicHeatmap,
  GraphicImage,
  GraphicMultiPoint,
  GraphicPoint,
  GraphicPolygon,
  GraphicPolylin,
  GraphicsOverlay,
  GraphicsOverlays,
  GraphicStippleLine,
  GraphicText,
  HeatmapPoint,
  VisualMap,
  Image,
  Map,
  MapLayer,
  MapView,
  PointF,
  QueryBound,
  Rect,
  VectorLayer,
  SRefData,
  LayerEnum,
  ClassItemValue,
  ClassItemType,
  AllOtherDataItemInfoSource,
  DuplicateType,
  DocItemType,
  DocumentItem,
  Document,
  Maps,
  GeneralVectorLabel,
  GroupLayer,
  Label,
  LabelType,
  LabelBackType,
  LabelGeomType,
  LabelInfo,
  LayerState,
  LinePlaceType,
  LineRepeatType,
  LineRestrictType, 
  LineSpreadType,
  LinePlaceInfo,
  MapServer,
  MapServerAccessMode,
  MapServerBrowseType,
  MultiClassThemeInfo,
  MultiClassTheme,
  ThemeInfo,
  PointEightLocationPriority,
  PointPlaceType,
  PointPlaceInfo,
  RangeThemeInfo,
  RangeTheme,
  RegPlaceType,
  RegionPlaceInfo,
  SimpleLabel,
  SimpleModelLayer,
  SimpleTheme,
  ThemeType,
  Theme,
  Themes,
  TileSliceType,
  TileMapServer,
  IntUser,
  UniqueThemeInfo,
  UniqueTheme,
  VectorLayerType,
  VectorLabel,
  VectorMapServer,
  VectorTileMapServer,
  VectorTheme,
  ServerLayer,
  OGCWMTSMapServer,

  Model,
  ModelsOverlay,
  SimpleModelLayerUtil,

  FillStyle,
  GeometryParams,
  LineStyle,
  MeasureType,
  PointStyle,
  SketchDataType,
  SketchEditor,
  SketchStyle,
  SnappingOption,
  TextStyle,
  MeasureOption,
  MeasureContentWillChangeListener,
  SketchMeasureUnitType,


  CoordinateConvert,
  CoordinateConvertParameter,
  CoordinateType,

  ElpParam,
  ElpTransParam,
  ElpTransformation,
  CoordType,
  LevelType,
  ProjType,
  SpheroidType,
  VDatumType,
  ZoneType,
  Dots,
  Dots3D,
  Geometry,
  GeometryExp,
  GeoAnno,
  GeoLine,
  GeoLines,
  GeoPoints,
  GeoPolygon,
  GeoPolygons,
  GeoVarLine,
  TextAnno,
  AnnType,
  DistanceType,
  GeometryDimension,
  GeometryType,
  GeomType,

  GeomInfo,
  AnnInfo,
  LinInfo,
  PntInfo,
  RegInfo,
  TextAnnInfo,

  ExtField,
  Field,
  Fields,
  Record,
  FieldType,

  XClsInfo,
  AnnClsInfo,
  FClsInfo,
  BasCls,
  VectorCls,
  AnnotationCls,
  SFeatureCls,
  DataBase,
  QueryDef,
  RecordSet,
  SpaQueryMode,
  XClsType,

  CrossData,
  SpaAnalysis,
  SpaCalculator,
  SpaProjection,
  SpaRelation,

  DataBaseSync,
  DownloadDataBaseParmeters,
  DownloadLayerOption,
  FeatureEdit,
  FeatureSync,
  MapServiceInfo,
  MapServiceLayerInfo,
  SyncBase,
  SyncDataBaseParmeters,
  SyncLayerOption,

  Annotation,
  AnnotationsOverlay,
  AnnotationView,

  DriverType,
  Layer3DType,
  SRSType,
  SunLightingMode,
  FlyStatus,
  Layer3D,
  Layer3DEnum,
  Rect3D,
  Scene,
  SceneView,
  VectorLayer3D,
  ServerLayer3D,
  TerrainLayer3D,
  GroupLayer3D,
  ModelCacheLayer3D,
  SelectionStyle,
  SelectionProperties,
  Viewpoint,
  FlyManager,
  GeoElement,
  IdentifyLayerResult,
  Feature3D,
  Geometry3D,
  FeaturePagedResult3D,
  FeatureQuery3D,
  QueryBound3D,
  AltitudeMode,
  GraphicState,
  GraphicType3D,
  Graphic3D,
  Graphic3DsOverlay,
  Graphic3DsOverlays,
  GraphicMultiPoint3D,
  GraphicPoint3D,
  GraphicPolygon3D,
  GraphicPolyline3D,
  GraphicImage3DAlignmentMode,
  GraphicText3DAlignmentMode,
  GraphicPlaceMarker,
  TerrainAnalysis,
  MeasurementChangedEvent,
};
