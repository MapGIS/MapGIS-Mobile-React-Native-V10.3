package com.zondy.mapgis.mobile.react;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import com.zondy.mapgis.mobile.react.scene.JSAltitudeMode;
import com.zondy.mapgis.mobile.react.scene.JSDistanceMeasurement;
import com.zondy.mapgis.mobile.react.scene.JSDriverType;
import com.zondy.mapgis.mobile.react.scene.JSFeature3D;
import com.zondy.mapgis.mobile.react.scene.JSFeaturePagedResult3D;
import com.zondy.mapgis.mobile.react.scene.JSFeatureQuery3D;
import com.zondy.mapgis.mobile.react.scene.JSFlyManager;
import com.zondy.mapgis.mobile.react.scene.JSFlyStatus;
import com.zondy.mapgis.mobile.react.scene.JSGeoElement;
import com.zondy.mapgis.mobile.react.scene.JSGeometry3D;
import com.zondy.mapgis.mobile.react.scene.JSGraphic3D;
import com.zondy.mapgis.mobile.react.scene.JSGraphic3DsOverlay;
import com.zondy.mapgis.mobile.react.scene.JSGraphic3DsOverlays;
import com.zondy.mapgis.mobile.react.scene.JSGraphicImage3DAlignmentMode;
import com.zondy.mapgis.mobile.react.scene.JSGraphicMultiPoint3D;
import com.zondy.mapgis.mobile.react.scene.JSGraphicPlaceMarker;
import com.zondy.mapgis.mobile.react.scene.JSGraphicPoint3D;
import com.zondy.mapgis.mobile.react.scene.JSGraphicPolygon3D;
import com.zondy.mapgis.mobile.react.scene.JSGraphicPolyline3D;
import com.zondy.mapgis.mobile.react.scene.JSGraphicState;
import com.zondy.mapgis.mobile.react.scene.JSGraphicText3DAlignmentMode;
import com.zondy.mapgis.mobile.react.scene.JSGraphicType3D;
import com.zondy.mapgis.mobile.react.scene.JSGroupLayer3D;
import com.zondy.mapgis.mobile.react.scene.JSIdentifyLayerResult;
import com.zondy.mapgis.mobile.react.scene.JSLayer3D;
import com.zondy.mapgis.mobile.react.scene.JSLayer3DEnum;
import com.zondy.mapgis.mobile.react.scene.JSLayer3DType;
import com.zondy.mapgis.mobile.react.scene.JSMeasurementChangedEvent;
import com.zondy.mapgis.mobile.react.scene.JSModelCacheLayer3D;
import com.zondy.mapgis.mobile.react.scene.JSQueryBound3D;
import com.zondy.mapgis.mobile.react.scene.JSRect3D;
import com.zondy.mapgis.mobile.react.scene.JSSRSType;
import com.zondy.mapgis.mobile.react.scene.JSScene;
import com.zondy.mapgis.mobile.react.scene.JSSceneview;
import com.zondy.mapgis.mobile.react.scene.JSSelectionProperties;
import com.zondy.mapgis.mobile.react.scene.JSSelectionStyle;
import com.zondy.mapgis.mobile.react.scene.JSServerLayer3D;
import com.zondy.mapgis.mobile.react.scene.JSSunLightingMode;
import com.zondy.mapgis.mobile.react.scene.JSTerrainAnalysis;
import com.zondy.mapgis.mobile.react.scene.JSTerrainLayer3D;
import com.zondy.mapgis.mobile.react.scene.JSVectorLayer3D;
import com.zondy.mapgis.mobile.react.scene.JSViewpoint;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nonnull;


/**
 * @author fjl 2019-6-16 下午2:52:36
 * @content ReactNative调用原生MapView类
 */
public class ReactNativeViewPackage implements ReactPackage {

    private List<Class<? extends JavaScriptModule>> emptyList;

    @Nonnull
    @Override
    public List<NativeModule> createNativeModules(@Nonnull ReactApplicationContext reactContext) {
        List<NativeModule> modules = new ArrayList<>();
        modules.add(new JSMapView(reactContext));
        modules.add(new JSEnvironment(reactContext));
        modules.add(new JSDot(reactContext));
        modules.add(new JSImage(reactContext));
        modules.add(new JSPointF(reactContext));
        modules.add(new JSRect(reactContext));
        modules.add(new JSMap(reactContext));
        modules.add(new JSMapLayer(reactContext));
        modules.add(new JSVectorLayer(reactContext));
        modules.add(new JSQueryBound(reactContext));
        modules.add(new JSFeaturePagedResult(reactContext));
        modules.add(new JSFeature(reactContext));
        modules.add(new JSFeatureQuery(reactContext));
        modules.add(new JSGraphic(reactContext));
        modules.add(new JSGraphicsOverlay(reactContext));
        modules.add(new JSGraphicsOverlays(reactContext));
        modules.add(new JSGraphicCircle(reactContext));
        modules.add(new JSGraphicImage(reactContext));
        modules.add(new JSGraphicMultiPoint(reactContext));
        modules.add(new JSGraphicPoint(reactContext));
        modules.add(new JSGraphicPolygon(reactContext));
        modules.add(new JSGraphicPolylin(reactContext));
        modules.add(new JSGraphicStippleLine(reactContext));
        modules.add(new JSGraphicText(reactContext));
        modules.add(new JSMapPosition(reactContext));
        modules.add(new JSSRefData(reactContext));
        modules.add(new JSLayerEnum(reactContext));
        modules.add(new JSClassItemValue(reactContext));
        modules.add(new JSClassItemType(reactContext));
        modules.add(new JSAllOtherDataItemInfoSource(reactContext));
        modules.add(new JSDocItemType(reactContext));
        modules.add(new JSDocumentItem(reactContext));
        modules.add(new JSDocument(reactContext));
        modules.add(new JSDuplicateType(reactContext));
        modules.add(new JSMaps(reactContext));
        modules.add(new JSGeneralVectorLabel(reactContext));
        modules.add(new JSGroupLayer(reactContext));
        modules.add(new JSLabel(reactContext));
        modules.add(new JSLabelType(reactContext));
        modules.add(new JSLabelBackType(reactContext));
        modules.add(new JSLabelGeomType(reactContext));
        modules.add(new JSLabelInfo(reactContext));
        modules.add(new JSLayerState(reactContext));
        modules.add(new JSLinePlaceType(reactContext));
        modules.add(new JSLineRepeatType(reactContext));
        modules.add(new JSLineRestrictType(reactContext));
        modules.add(new JSLineSpreadType(reactContext));
        modules.add(new JSLinePlaceInfo(reactContext));
        modules.add(new JSMapServer(reactContext));
        modules.add(new JSMapServerAccessMode(reactContext));
        modules.add(new JSMapServerBrowseType(reactContext));
        modules.add(new JSMultiClassThemeInfo(reactContext));
        modules.add(new JSMultiClassTheme(reactContext));
        modules.add(new JSThemeInfo(reactContext));
        modules.add(new JSPointEightLocationPriority(reactContext));
        modules.add(new JSPointPlaceType(reactContext));
        modules.add(new JSPointPlaceInfo(reactContext));
        modules.add(new JSRangeThemeInfo(reactContext));
        modules.add(new JSRangeTheme(reactContext));
        modules.add(new JSRegPlaceType(reactContext));
        modules.add(new JSRegionPlaceInfo(reactContext));
        modules.add(new JSSimpleLabel(reactContext));
        modules.add(new JSSimpleModelLayer(reactContext));
        modules.add(new JSSimpleTheme(reactContext));
        modules.add(new JSThemeType(reactContext));
        modules.add(new JSTheme(reactContext));
        modules.add(new JSThemes(reactContext));
        modules.add(new JSTileSliceType(reactContext));
        modules.add(new JSTileMapServer(reactContext));
        modules.add(new JSIntUser(reactContext));
        modules.add(new JSUniqueThemeInfo(reactContext));
        modules.add(new JSUniqueTheme(reactContext));
        modules.add(new JSVectorLabel(reactContext));
        modules.add(new JSVectorLayerType(reactContext));
        modules.add(new JSVisualMap(reactContext));
        modules.add(new JSHeatmapPoint(reactContext));
        modules.add(new JSGraphicHeatmap(reactContext));
        modules.add(new JSMagnifierOption(reactContext));
        modules.add(new JSAnnotation(reactContext));
        modules.add(new JSAnnotationsOverlay(reactContext));
        modules.add(new JSAnnotationView(reactContext));
        modules.add(new JSElpTransParam(reactContext));
        modules.add(new JSElpTransformation(reactContext));
        modules.add(new JSElpParam(reactContext));

        modules.add(new JSDot3D(reactContext));
        modules.add(new JSDots(reactContext));
        modules.add(new JSDots3D(reactContext));
        modules.add(new JSAnnType(reactContext));
        modules.add(new JSGeoAnno(reactContext));
        modules.add(new JSDistanceType(reactContext));
        modules.add(new JSGeometry(reactContext));
        modules.add(new JSGeometryDimension(reactContext));
        modules.add(new JSGeoLine(reactContext));
        modules.add(new JSGeoLines(reactContext));
        modules.add(new JSGeometryExp(reactContext));
        modules.add(new JSGeometryType(reactContext));
        modules.add(new JSGeomType(reactContext));
        modules.add(new JSGeoPoints(reactContext));
        modules.add(new JSGeoPolygon(reactContext));
        modules.add(new JSGeoPolygons(reactContext));
        modules.add(new JSGeoVarLine(reactContext));
        modules.add(new JSTextAnno(reactContext));

        modules.add(new JSGeomInfo(reactContext));
        modules.add(new JSAnnInfo(reactContext));
        modules.add(new JSPntInfo(reactContext));
        modules.add(new JSLinInfo(reactContext));
        modules.add(new JSRegInfo(reactContext));
        modules.add(new JSTextAnnInfo(reactContext));
		
        modules.add(new JSVectorMapServer(reactContext));
        modules.add(new JSVectorTheme(reactContext));
        modules.add(new JSVectorTileMapServer(reactContext));
        modules.add(new JSOGCWMTSMapServer(reactContext));
        modules.add(new JSServerLayer(reactContext));

        modules.add(new JSModel(reactContext));
        modules.add(new JSModelsOverlay(reactContext));
		modules.add(new JSSimpleModelLayerUtil(reactContext));

	    modules.add(new JSFillStyle(reactContext));
        modules.add(new JSGeometryParams(reactContext));
        modules.add(new JSLineStyle(reactContext));
        modules.add(new JSMeasureType(reactContext));
        modules.add(new JSPointStyle(reactContext));
        modules.add(new JSSketchDataType(reactContext));
        modules.add(new JSSketchEditor(reactContext));
        modules.add(new JSSketchStyle(reactContext));
        modules.add(new JSSnappingOption(reactContext));
        modules.add(new JSTextStyle(reactContext));
        modules.add(new JSMeasureOption(reactContext));
        modules.add(new JSSketchMeasureUnitType(reactContext));
        modules.add(new JSMeasureContentWillChangeListener(reactContext));

		modules.add(new JSCoordinateConvertParameter(reactContext));
        modules.add(new JSCoordinateType(reactContext));
        modules.add(new JSCoordinateConvert(reactContext));

        modules.add(new JSXClsType(reactContext));

        modules.add(new JSExtField(reactContext));
        modules.add(new JSField(reactContext));
        modules.add(new JSFields(reactContext));
        modules.add(new JSFieldShape(reactContext));
        modules.add(new JSFieldType(reactContext));
        modules.add(new JSRecord(reactContext));

        modules.add(new JSAnnClsInfo(reactContext));
        modules.add(new JSAnnotationCls(reactContext));
        modules.add(new JSDataBase(reactContext));
        modules.add(new JSFClsInfo(reactContext));
        modules.add(new JSQueryDef(reactContext));
        modules.add(new JSRecordSet(reactContext));
        modules.add(new JSSFeatureCls(reactContext));

        modules.add(new JSSpaAnalysis(reactContext));
        modules.add(new JSCrossData(reactContext));
        modules.add(new JSSpaCalculator(reactContext));
        modules.add(new JSSpaProjection(reactContext));
        modules.add(new JSSpaRelation(reactContext));

        modules.add(new JSDataBaseSync(reactContext));
        modules.add(new JSDownloadDataBaseParmeters(reactContext));
        modules.add(new JSDownloadLayerOption(reactContext));
        modules.add(new JSFeatureEdit(reactContext));
        modules.add(new JSFeatureSync(reactContext));
        modules.add(new JSMapServiceInfo(reactContext));
        modules.add(new JSMapServiceLayerInfo(reactContext));
        modules.add(new JSSyncBase(reactContext));
        modules.add(new JSSyncDataBaseParmeters(reactContext));
        modules.add(new JSSyncLayerOption(reactContext));

        modules.add(new JSSceneview(reactContext));
        modules.add(new JSSunLightingMode(reactContext));
        modules.add(new JSScene(reactContext));
        modules.add(new JSLayer3DEnum(reactContext));
        modules.add(new JSDriverType(reactContext));
        modules.add(new JSSRSType(reactContext));
        modules.add(new JSLayer3D(reactContext));
        modules.add(new JSRect3D(reactContext));
        modules.add(new JSLayer3DType(reactContext));
        modules.add(new JSVectorLayer3D(reactContext));
        modules.add(new JSServerLayer3D(reactContext));
        modules.add(new JSTerrainLayer3D(reactContext));
        modules.add(new JSGroupLayer3D(reactContext));
        modules.add(new JSModelCacheLayer3D(reactContext));
        modules.add(new JSSelectionStyle(reactContext));
        modules.add(new JSSelectionProperties(reactContext));
        modules.add(new JSViewpoint(reactContext));
        modules.add(new JSFlyStatus(reactContext));
        modules.add(new JSFlyManager(reactContext));
        modules.add(new JSGeoElement(reactContext));
        modules.add(new JSIdentifyLayerResult(reactContext));
        modules.add(new JSGeometry3D(reactContext));
        modules.add(new JSFeature3D(reactContext));
        modules.add(new JSFeaturePagedResult3D(reactContext));
        modules.add(new JSFeatureQuery3D(reactContext));
        modules.add(new JSQueryBound3D(reactContext));
        modules.add(new JSAltitudeMode(reactContext));
        modules.add(new JSGraphic3D(reactContext));
        modules.add(new JSGraphicType3D(reactContext));
        modules.add(new JSGraphicState(reactContext));
        modules.add(new JSGraphic3DsOverlay(reactContext));
        modules.add(new JSGraphic3DsOverlays(reactContext));
        modules.add(new JSGraphicMultiPoint3D(reactContext));
        modules.add(new JSGraphicPoint3D(reactContext));
        modules.add(new JSGraphicPolygon3D(reactContext));
        modules.add(new JSGraphicPolyline3D(reactContext));
        modules.add(new JSGraphicPlaceMarker(reactContext));
        modules.add(new JSGraphicImage3DAlignmentMode(reactContext));
        modules.add(new JSGraphicText3DAlignmentMode(reactContext));
        modules.add(new JSTerrainAnalysis(reactContext));
        modules.add(new JSMeasurementChangedEvent(reactContext));
        modules.add(new JSDistanceMeasurement(reactContext));

		return modules;
    }

    public List<Class<? extends JavaScriptModule>> createJSModules() {
        return emptyList;
    }

    @Nonnull
    @Override
    public List<ViewManager> createViewManagers(@Nonnull ReactApplicationContext reactContext) {

        List<ViewManager> viewManagerLst = new ArrayList<>();
        viewManagerLst.add(new MapViewManager());
        viewManagerLst.add(new SceneViewManager());
        return viewManagerLst;
    }
}
