package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.zondy.mapgis.android.mapview.MagnifierOption;
import com.zondy.mapgis.android.mapview.MapView;
import com.zondy.mapgis.android.tool.sketcheditor.SketchDataType;
import com.zondy.mapgis.android.tool.sketcheditor.SketchEditor;
import com.zondy.mapgis.android.tool.sketcheditor.SketchStyle;
import com.zondy.mapgis.android.tool.sketcheditor.SnappingOption;
import com.zondy.mapgis.core.geometry.Dot;
import com.zondy.mapgis.core.geometry.Geometry;
import com.zondy.mapgis.core.object.Enumeration;
import com.zondy.mapgis.core.srs.SRefData;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * 草图编辑器Native功能组件
 * Created by xiaoying on 2019/9/10.
 */
public class JSSketchEditor extends ReactContextBaseJavaModule {
    private static final String REACT_CLASS = "JSSketchEditor";
    public static Map<String, SketchEditor> mSketchEditorList = new HashMap<>();
    private SketchEditor.SketchStateChangedListener mSketchStateChangedListener = null;
    private static final String GEOMETRYCHANGED = "com.mapgis.RN.SketchEditor.geometry_changed";
    private static final String VERTEXSELECTED = "com.mapgis.RN.SketchEditor.vertex_selected";
    private static final String UNDOSTATECHANGED = "com.mapgis.RN.SketchEditor.undo_state_changed";
    private static final String REDOSTATECHANGED = "com.mapgis.RN.SketchEditor.redo_state_changed";

    private ReactApplicationContext mReactContext;

    public JSSketchEditor(ReactApplicationContext reactContext) {
        super(reactContext);
        mReactContext = reactContext;
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public static SketchEditor getObjFromList(String id){
        return mSketchEditorList.get(id);
    }

    public static String registerId(SketchEditor obj){
        for(Map.Entry entry : mSketchEditorList.entrySet()){
            if(obj.equals(entry.getValue())){
                String id = (String) entry.getKey();
                return id;
            }
        }
        Calendar calendar = Calendar.getInstance();
        String id = Long.toString(calendar.getTimeInMillis());
        mSketchEditorList.put(id,obj);
        return id;
    }

    @ReactMethod
    public void createObj(String mapViewId, Promise promise){
        try {
            MapView mapView = JSMapView.getObjById(mapViewId);
            String sketchEditorId = null;
            if(mapView != null){
                SketchEditor sketchEditor = new SketchEditor(mapView);
                sketchEditorId = registerId(sketchEditor);
            }
            WritableMap writableMap = Arguments.createMap();
            writableMap.putString("SketchEditorId", sketchEditorId);
            promise.resolve(writableMap);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    private void sendEvent(String eventName, WritableMap writableMap){
        mReactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
                .emit(eventName, writableMap);
    }

    @ReactMethod
    public void addStateChangedListener(final String sketchEditorId, Promise promise){
        try {
            mSketchStateChangedListener = new SketchEditor.SketchStateChangedListener() {
                @Override
                public void onGeometryChanged(SketchEditor.SketchGeometryChangedEvent sketchGeometryChangedEvent) {
                    WritableMap writableMap = Arguments.createMap();
                    if(sketchGeometryChangedEvent != null){
                        Geometry geometry = sketchGeometryChangedEvent.getGeometry();        // 获取sketchGeometryChangedEvent返回的Geometry
                        SketchEditor sketchEditor = sketchGeometryChangedEvent.getSource();  // 获取sketchGeometryChangedEvent返回的SketchEditor
                        String geometryId = null;
                        String sketchEditorId = null;
                        if(geometry != null){
                            geometryId = JSGeometry.registerId(geometry);
                        }
                        if(sketchEditor != null){
                            sketchEditorId = registerId(sketchEditor);
                        }
                        writableMap.putString("GeometryId", geometryId);
                        writableMap.putString("SketchEditorId", sketchEditorId);
                    }
                    sendEvent(GEOMETRYCHANGED, writableMap);
                }

                @Override
                public void onVertexSelected(Dot dot, Dot dot1, Dot dot2) {
                    WritableMap writableMap = Arguments.createMap();
                    String dotId = null;
                    String dotId1 = null;
                    String dotId2 = null;
                    if(dot != null){
                        dotId = JSDot.registerId(dot);
                    }
                    if(dot1 != null){
                        dotId1 = JSDot.registerId(dot1);
                    }
                    if(dot2 != null){
                        dotId2 = JSDot.registerId(dot2);
                    }

                    writableMap.putString("point2DId",dotId);
                    writableMap.putString("point2DId1", dotId1);
                    writableMap.putString("point2DId2", dotId2);
                    sendEvent(VERTEXSELECTED, writableMap);
                }

                @Override
                public void onUndoStateChanged(boolean b) {
                    WritableMap writableMap = Arguments.createMap();
                    writableMap.putBoolean("undoResult", b);
                    sendEvent(UNDOSTATECHANGED, writableMap);
                }

                @Override
                public void onRedoStateChanged(boolean b) {
                    WritableMap writableMap = Arguments.createMap();
                    writableMap.putBoolean("redoResult", b);
                    sendEvent(REDOSTATECHANGED, writableMap);
                }
            };
            SketchEditor sketchEditor = getObjFromList(sketchEditorId);
            sketchEditor.addStateChangedListener(mSketchStateChangedListener);
            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void removeStateChangedListener(String sketchEditorId, Promise promise){
        try {
            SketchEditor sketchEditor = getObjFromList(sketchEditorId);
            sketchEditor.removeStateChangedListener(mSketchStateChangedListener);
            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);

        }
    }
    @ReactMethod
    public void getSketchStyle(String sketchEditorId, Promise promise){
        try {
            SketchEditor sketchEditor = getObjFromList(sketchEditorId);
            SketchStyle sketchStyle = sketchEditor.getSketchStyle();
            String sketchStyleId = null;
            if(sketchStyle != null){
                sketchStyleId = JSSketchStyle.registerId(sketchStyle);
            }

            WritableMap writableMap = Arguments.createMap();
            writableMap.putString("SketchStyleId", sketchStyleId);
            promise.resolve(writableMap);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setSketchStyle(String sketchEditorId, String sketchStyleId, Promise promise){
        try {
            SketchEditor sketchEditor = getObjFromList(sketchEditorId);
            SketchStyle sketchStyle1 = JSSketchStyle.getObjFromList(sketchStyleId);
            sketchEditor.setSketchStyle(sketchStyle1);

            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getSnappingOption(String sketchEditorId, Promise promise){
        try {
            SketchEditor sketchEditor = getObjFromList(sketchEditorId);
            SnappingOption snappingOption = sketchEditor.getSnappingOption();
            String snappingOptionId = null;
            if(snappingOption != null){
                snappingOptionId = JSSnappingOption.registerId(snappingOption);
            }

            WritableMap writableMap = Arguments.createMap();
            writableMap.putString("SnappingOptionId", snappingOptionId);
            promise.resolve(writableMap);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setSnappingOption(String sketchEditorId, String snappingOptionId, Promise promise){
        try {
            SketchEditor sketchEditor = getObjFromList(sketchEditorId);
            SnappingOption snappingOption = JSSnappingOption.getObjFromList(snappingOptionId);
            sketchEditor.setSnappingOption(snappingOption);

            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void startByType(String sketchEditorId, int sketchDataType, Promise promise){
        try {
            SketchEditor sketchEditor = getObjFromList(sketchEditorId);
            SketchDataType sketchDataType1 = (SketchDataType) Enumeration.parse(SketchDataType.class, sketchDataType);
            sketchEditor.start(sketchDataType1);

            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void start(String sketchEditorId, String geometryId, Promise promise){
        try {
            SketchEditor sketchEditor = getObjFromList(sketchEditorId);
            Geometry geometry = JSGeometry.getObjFromList(geometryId);
            sketchEditor.start(geometry);

            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getSketchDataType(String sketchEditorId, Promise promise)
    {
        try {
            SketchEditor sketchEditor = getObjFromList(sketchEditorId);
            SketchDataType sketchDataType = sketchEditor.getSketchDataType();
            if(sketchDataType != null){
                promise.resolve(sketchDataType.value());
            }else{
                promise.resolve(-1);
            }
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void replaceGeometry(String sketchEditorId, String geometryId, Promise promise){
        try {
            SketchEditor sketchEditor = getObjFromList(sketchEditorId);
            Geometry geometry = JSGeometry.getObjFromList(geometryId);
            sketchEditor.replaceGeometry(geometry);

            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getGeometry(String sketchEditorId, Promise promise){
        try {
            SketchEditor sketchEditor = getObjFromList(sketchEditorId);
            Geometry geometry = sketchEditor.getGeometry();
            String geometryId = null;
            if(geometry != null){
                geometryId = JSGeometry.registerId(geometry);
            }

            WritableMap writableMap = Arguments.createMap();
            writableMap.putString("GeometryId", geometryId);
            promise.resolve(writableMap);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void clearGeometry(String sketchEditorId, Promise promise){
        try {
            SketchEditor sketchEditor = getObjFromList(sketchEditorId);
            sketchEditor.clearGeometry();

            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void stop(String sketchEditorId, Promise promise){
        try {
            SketchEditor sketchEditor = getObjFromList(sketchEditorId);
            sketchEditor.stop();

            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void deleteSelectedVertex(String sketchEditorId, Promise promise){
        try {
            SketchEditor sketchEditor = getObjFromList(sketchEditorId);
            sketchEditor.deleteSelectedVertex();

            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void moveSelectedVertexTo(String sketchEditorId, double x, double y, Promise promise){
        try {
            SketchEditor sketchEditor = getObjFromList(sketchEditorId);
            boolean result = sketchEditor.moveSelectedVertexTo(x, y);

            promise.resolve(result);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void addVertex(String sketchEditorId, double x, double y, Promise promise){
        try {
            SketchEditor sketchEditor = getObjFromList(sketchEditorId);
            sketchEditor.addVertex(x, y);

            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void snapping(String sketchEditorId, double x, double y, Promise promise){
        try {
            SketchEditor sketchEditor = getObjFromList(sketchEditorId);
            Dot dot = sketchEditor.snapping(x, y);
            String point2DId = null;
            if(dot != null){
                point2DId = JSDot.registerId(dot);
            }

            WritableMap writableMap = Arguments.createMap();
            writableMap.putString("point2DId", point2DId);
            promise.resolve(writableMap);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void undo(String sketchEditorId, Promise promise){
        try {
            SketchEditor sketchEditor = getObjFromList(sketchEditorId);
            boolean result = sketchEditor.undo();

            promise.resolve(result);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void redo(String sketchEditorId, Promise promise){
        try {
            SketchEditor sketchEditor = getObjFromList(sketchEditorId);
            boolean result = sketchEditor.redo();

            promise.resolve(result);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void isSketchValid(String sketchEditorId, Promise promise){
        try {
            SketchEditor sketchEditor = getObjFromList(sketchEditorId);
            boolean result = sketchEditor.isSketchValid();

            promise.resolve(result);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setMagnifierOption(String sketchEditorId, String magnifierOptionId, Promise promise){
        try {
            SketchEditor sketchEditor = getObjFromList(sketchEditorId);
            MagnifierOption magnifierOption = JSMagnifierOption.getObjFromList(magnifierOptionId);
            sketchEditor.setMagnifierOption(magnifierOption);

            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setSRS(String sketchEditorId, String srefDataId, Promise promise){
        try {
            SketchEditor sketchEditor = getObjFromList(sketchEditorId);
            SRefData sRefData = JSSRefData.getObjFromList(srefDataId);
            sketchEditor.setSRS(sRefData);

            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getSRS(String sketchEditorId, Promise promise){
        try {
            SketchEditor sketchEditor = getObjFromList(sketchEditorId);
            SRefData sRefData = sketchEditor.getSRS();
            String srefDataId = null;
            if(sRefData != null){
                srefDataId =  JSSRefData.registerId(sRefData);
            }

            WritableMap writableMap = Arguments.createMap();
            writableMap.putString("SRefDataId", srefDataId);
            promise.resolve(writableMap);
        }catch (Exception e){
            promise.reject(e);
        }
    }
}
