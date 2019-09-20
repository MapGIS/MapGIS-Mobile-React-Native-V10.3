/*
 * @Description: In User Settings Edit
 * @Author: your name
 * @Date: 2019-09-05 18:06:47
 * @LastEditTime: 2019-09-10 10:20:03
 * @LastEditors: Please set LastEditors
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

import MGMapView from "./js/components/MGSMapViewUI";
import Environment from "./js/Environment";
import Dot from "./js/Dot";
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

import CoordinateConvertParameter from "./js/CoordinateConvertParameter";

import ElpTransformation from "./js/ElpTransformation";

import Dots from "./js/Dots";
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
import DataBase from "./js/ExtField"
import QueryDef from "./js/QueryDef"
import RecordSet from "./js/RecordSet"


export {
  MGMapView,
  Environment,
  Dot,
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

  CoordinateConvertParameter,
  CoordinateType,

  ElpTransformation,
  CoordType,
  LevelType,
  ProjType,
  SpheroidType,
  VDatumType,
  ZoneType,
  Dots,
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
};
