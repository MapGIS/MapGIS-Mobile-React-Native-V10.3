package com.mapgis_mobile_reactnative;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nonnull;


/**
 * @content ReactNative调用原生MapView类
 * @author fjl 2019-6-16 下午2:52:36
 */
public class ReactNativeViewPackage implements ReactPackage {

    @Nonnull
    @Override
    public List<NativeModule> createNativeModules(@Nonnull ReactApplicationContext reactContext) {
;
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
        return modules;
    }

    @Nonnull
    @Override
    public List<ViewManager> createViewManagers(@Nonnull ReactApplicationContext reactContext) {

        List<ViewManager> viewManagerLst = new ArrayList<>();
        viewManagerLst.add(new MapviewManager());
        return viewManagerLst;
    }
}