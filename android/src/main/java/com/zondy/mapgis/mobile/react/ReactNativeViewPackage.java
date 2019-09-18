package com.zondy.mapgis.mobile.react;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;

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
		
		modules.add(new JSCoordinateConvertParameter(reactContext));
        modules.add(new JSCoordinateType(reactContext));

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
        return viewManagerLst;
    }
}
