/*
 * @Description: In User Settings Edit
 * @Author: your name
 * @Date: 2019-09-05 18:06:47
 * @LastEditTime: 2019-09-05 19:50:14
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

import Image from "./js/Image";
import Map from "./js/Map";
import MapLayer from "./js/MapLayer";
import MapView from "./js/MapView";
import PointF from "./js/PointF";
import QueryBound from "./js/QueryBound";
import Rect from "./js/Rect";
import VectorLayer from "./js/VectorLayer";
import SRefData from "./js/SRefData";
import ClassItemValue from "./js/ClassItemValue";
import DocumentItem from "./js/DocumentItem";
import Document from "./js/Document";
import Maps from "./js/Maps";

import GroupLayer from "./js/GroupLayer";

export {
  MGMapView,
  Environment,
  Dot,
  Feature,
  FeaturePagedResult,
  FeatureQuery,
  Graphic,
  GraphicCircle,
  GraphicImage,
  GraphicMultiPoint,
  GraphicPoint,
  GraphicPolygon,
  GraphicPolylin,
  GraphicsOverlay,
  GraphicsOverlays,
  GraphicStippleLine,
  GraphicText,
  Image,
  Map,
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
  GroupLayer,
  LabelType,
  LabelBackType,
  LabelGeomType,
  LayerState,
  LinePlaceType,
  LineRepeatType,
  LineRestrictType, 
  LineSpreadType,
  MapServerAccessMode,
  MapServerBrowseType,
  PointEightLocationPriority,
  PointPlaceType,
  RegPlaceType,
  ThemeType,
  TileSliceType,
  VectorLayerType,
};
