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
