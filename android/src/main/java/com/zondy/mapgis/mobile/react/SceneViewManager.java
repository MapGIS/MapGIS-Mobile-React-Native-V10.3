package com.zondy.mapgis.mobile.react;

import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.zondy.mapgis.android.sceneview.SceneView;
import com.zondy.mapgis.mobile.react.scene.JSSceneview;
import com.zondy.mapgis.mobile.react.utils.N_R_EventSender;

/**
 * @author cgf 2020-7-16
 * @content 原生SceneView管理类
 */
public class SceneViewManager extends SimpleViewManager<SceneView> {

    private static final String SCENE_VIEW_MANAGER = "SceneViewManager";
    private ThemedReactContext mContext;
    private SceneView sceneView;
    N_R_EventSender n_r_eventSender = new N_R_EventSender();

    @Override
    public String getName() {
        return SCENE_VIEW_MANAGER;
    }


    @Override
    protected SceneView createViewInstance(ThemedReactContext reactContext) {
        mContext = reactContext;
        sceneView = new SceneView(reactContext);


        String sceneViewID = JSSceneview.registerId(sceneView);
        n_r_eventSender.putString("sceneViewId", sceneViewID);
        return sceneView;
    }


    @ReactProp(name = "returnId")
    public void returnId(SceneView view, boolean b) {
        //向JS返回SceneView的ID
        mContext.getJSModule(RCTEventEmitter.class).receiveEvent(
                view.getId(),
                "topChange",
                n_r_eventSender.createSender()
        );
    }
}
