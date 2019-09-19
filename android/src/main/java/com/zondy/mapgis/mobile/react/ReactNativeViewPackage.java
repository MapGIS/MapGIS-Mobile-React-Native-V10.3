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
        modules.add(new JSGroupLayer(reactContext));
        modules.add(new JSLabelType(reactContext));
        modules.add(new JSLabelBackType(reactContext));
        modules.add(new JSLabelGeomType(reactContext));
        modules.add(new JSLayerState(reactContext));
        modules.add(new JSLinePlaceType(reactContext));
        modules.add(new JSLineRepeatType(reactContext));
        modules.add(new JSLineRestrictType(reactContext));
        modules.add(new JSLineSpreadType(reactContext));
        modules.add(new JSMapServerAccessMode(reactContext));
        modules.add(new JSMapServerBrowseType(reactContext));
        modules.add(new JSPointEightLocationPriority(reactContext));
        modules.add(new JSPointPlaceType(reactContext));
        modules.add(new JSRegPlaceType(reactContext));
        modules.add(new JSThemeType(reactContext));
        modules.add(new JSTileSliceType(reactContext));
        modules.add(new JSVectorLayerType(reactContext));
        modules.add(new JSVisualMap(reactContext));
        modules.add(new JSHeatmapPoint(reactContext));
        modules.add(new JSGraphicHeatmap(reactContext));
        modules.add(new JSMagnifierOption(reactContext));
        modules.add(new JSAnnotation(reactContext));
        modules.add(new JSAnnotationsOverlay(reactContext));
        modules.add(new JSElpTransParam(reactContext));
        modules.add(new JSElpTransformation(reactContext));
        modules.add(new JSElpParam(reactContext));

        modules.add(new JSDots(reactContext));
        modules.add(new JSGeoAnno(reactContext));
        modules.add(new JSGeometry(reactContext));
        modules.add(new JSGeoLine(reactContext));
        modules.add(new JSGeoLines(reactContext));
        modules.add(new JSGeometryExp(reactContext));
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
