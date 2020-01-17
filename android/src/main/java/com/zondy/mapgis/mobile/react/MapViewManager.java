package com.zondy.mapgis.mobile.react;

import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.zondy.mapgis.android.mapview.MapView;
import com.zondy.mapgis.mobile.react.utils.N_R_EventSender;

/**
 * @author fjl 2019-6-16 下午2:52:36
 * @content 原生MapView管理类
 */
public class MapViewManager extends SimpleViewManager<MapView> {

    private static final String RN_MAPVIEW_CLASS = "MapviewGetInstance";
    private ThemedReactContext mContext;
    private MapView mMapView;
    N_R_EventSender n_r_eventSender = new N_R_EventSender();

    @Override
    public String getName() {
        return RN_MAPVIEW_CLASS;
    }


    @Override
    protected MapView createViewInstance(ThemedReactContext reactContext) {
        mContext = reactContext;
        mMapView = new MapView(reactContext);


        String mapViewId = JSMapView.registerId(mMapView);
        n_r_eventSender.putString("mapViewId", mapViewId);
        return mMapView;
    }


    @ReactProp(name = "returnId")
    public void returnId(MapView view, boolean b) {
        //向JS返回MapView的ID
        mContext.getJSModule(RCTEventEmitter.class).receiveEvent(
                view.getId(),
                "topChange",
                n_r_eventSender.createSender()
        );
    }
}
