package com.mapgis_mobile_reactnative;

import android.graphics.PointF;
import android.support.annotation.Nullable;
import android.util.Log;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.mapgis_mobile_reactnative.utils.N_R_EventSender;
import com.zondy.mapgis.android.environment.Environment;
import com.zondy.mapgis.android.mapview.MapView;
import com.zondy.mapgis.core.geometry.Dot;

import java.io.File;

/**
 * @content 原生MapView管理类
 * @author fjl 2019-6-16 下午2:52:36
 */
public class MapviewManager extends SimpleViewManager<MapView> {

    public static final String RN_MAPVIEW_CLASS = "MapviewGetInstance";
    private ThemedReactContext mContext;
    private MapView mMapView;
    N_R_EventSender n_r_eventSender = new N_R_EventSender();
    @Override
    public String getName() {
        return RN_MAPVIEW_CLASS;
    }


    @Override
    protected MapView createViewInstance( ThemedReactContext reactContext) {
        mContext = reactContext;
        mMapView = new MapView(reactContext);


        String mapViewId = JSMapView.registerId(mMapView);
        n_r_eventSender.putString("mapViewId",mapViewId);
        return mMapView;
    }


    @ReactProp(name="returnId")
    public void returnId(MapView view, boolean b){
        Log.e("returnId:",""+b);
        //向JS返回MapView的ID
        mContext.getJSModule(RCTEventEmitter.class).receiveEvent(
                view.getId(),
                "topChange",
                n_r_eventSender.createSender()
        );
    }

    @ReactProp(name = "strMapPath")
    public void loadMap(final MapView mapView, final  String strMapPath) {

        final String strRootPath = android.os.Environment.getExternalStorageDirectory().getPath() + File.separator + "MapGIS Mobile 2D Sample" + File.separator;
        Environment.initialize(strRootPath, mContext);
        Environment.requestAuthorization(mContext,new Environment.AuthorizeCallback()
        {
            @Override
            public void onComplete() {
                Log.d(RN_MAPVIEW_CLASS,"请求授权成功");
                mapView.loadFromFile(strRootPath + strMapPath);
            }
        });
    }


}
