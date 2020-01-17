package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.android.graphic.Graphic;
import com.zondy.mapgis.android.graphic.GraphicsOverlay;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author fjl 2019-6-18 下午2:52:36
 * @content 覆盖物对象Native组件
 */
public class JSGraphicsOverlay extends ReactContextBaseJavaModule {
    private static final String REACT_CLASS = "JSGraphicsOverlay";
    private static Map<String, GraphicsOverlay> mGraphicsOverlayList = new HashMap<String, GraphicsOverlay>();


    public JSGraphicsOverlay(ReactApplicationContext context) {
        super(context);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public static GraphicsOverlay getObjFromList(String id) {
        return mGraphicsOverlayList.get(id);
    }


    public static String registerId(GraphicsOverlay obj) {
        for (Map.Entry entry : mGraphicsOverlayList.entrySet()) {
            if (obj.equals(entry.getValue())) {
                return (String) entry.getKey();
            }
        }
        String id = UUID.randomUUID().toString().substring(24);
        mGraphicsOverlayList.put(id, obj);
        return id;
    }

    @ReactMethod
    public void createObj(Promise promise) {
        try {
            GraphicsOverlay GraphicsOverlay = new GraphicsOverlay();
            String GraphicsOverlayId = registerId(GraphicsOverlay);
            WritableMap map = Arguments.createMap();
            map.putString("GraphicsOverlayId", GraphicsOverlayId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }


    @ReactMethod
    public void setName(String GraphicsOverlayId, String name, Promise promise) {
        try {
            GraphicsOverlay graphicsOverlay = getObjFromList(GraphicsOverlayId);
            graphicsOverlay.setName(name);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }


    @ReactMethod
    public void getName(String GraphicsOverlayId, Promise promise) {
        try {
            GraphicsOverlay graphicsOverlay = getObjFromList(GraphicsOverlayId);
            String name = graphicsOverlay.getName();

            promise.resolve(name);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getState(String GraphicsOverlayId, Promise promise) {
        try {
            GraphicsOverlay graphicsOverlay = getObjFromList(GraphicsOverlayId);
            int state = graphicsOverlay.getState();

            promise.resolve(state);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setState(String GraphicsOverlayId, int state, Promise promise) {
        try {
            GraphicsOverlay graphicsOverlay = getObjFromList(GraphicsOverlayId);
            graphicsOverlay.setState(state);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void addGraphic(String GraphicsOverlayId, String graphicID, Promise promise) {
        try {
            GraphicsOverlay graphicsOverlay = getObjFromList(GraphicsOverlayId);
            Graphic graphic = JSGraphic.getObjFromList(graphicID);
            int result = 0;
            if(graphic != null){
                result = graphicsOverlay.addGraphic(graphic);
            }
            promise.resolve(result);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void addGraphics(String GraphicsOverlayId, ReadableArray graphiceArray, Promise promise) {
        try {
            GraphicsOverlay graphicsOverlay = getObjFromList(GraphicsOverlayId);
            ArrayList<Graphic> graphicLst = new ArrayList();
            if (graphicsOverlay != null) {
                for (int i = 0; i < graphiceArray.size(); i++) {
                    ReadableMap innerMap = graphiceArray.getMap(i);
                    String keyStr = innerMap.getString("_MGGraphicId");
                    Graphic graphic = JSGraphic.getObjFromList(keyStr);
                    graphicLst.add(graphic);
                }
            }

            graphicsOverlay.addGraphics(graphicLst);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void removeGraphic(String GraphicsOverlayId, String graphicID, Promise promise) {
        try {
            GraphicsOverlay graphicsOverlay = getObjFromList(GraphicsOverlayId);
            Graphic graphic = JSGraphic.getObjFromList(graphicID);
            if(graphic != null){
                graphicsOverlay.removeGraphic(graphic);
            }
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void removeGraphics(String GraphicsOverlayId, ReadableArray graphiceArray, Promise promise) {
        try {
            GraphicsOverlay graphicsOverlay = getObjFromList(GraphicsOverlayId);
            ArrayList<Graphic> graphicLst = new ArrayList();
            if (graphicsOverlay != null) {
                for (int i = 0; i < graphiceArray.size(); i++) {
                    ReadableMap innerMap = graphiceArray.getMap(i);
                    String keyStr = innerMap.getString("_MGGraphicId");
                    Graphic graphic = JSGraphic.getObjFromList(keyStr);
                    if (graphic != null) {
                        graphicLst.add(graphic);
                    }
                }
            }
            graphicsOverlay.removeGraphics(graphicLst);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void removeAllGraphics(String GraphicsOverlayId, Promise promise)
    {
        try {
            GraphicsOverlay graphicsOverlay = getObjFromList(GraphicsOverlayId);
            graphicsOverlay.removeAllGraphics();
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getAllGraphics(String GraphicsOverlayId, Promise promise)
    {
        try {
            GraphicsOverlay graphicsOverlay = getObjFromList(GraphicsOverlayId);
            List<Graphic> graphicList = graphicsOverlay.getAllGraphics();
            String strGraphicID = "";
            WritableArray arr = Arguments.createArray();
            if (graphicsOverlay != null) {
                for (int i = 0; i < graphicList.size(); i++) {
                    strGraphicID = JSGraphic.registerId(graphicList.get(i));
                    arr.pushString(strGraphicID);
                }
            }
            //WritableMap map = Arguments.createMap();
           // map.putArray("AllGraphicArr", arr);
            promise.resolve(arr);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getGraphicCount(String GraphicsOverlayId, Promise promise)
    {
        try {
            GraphicsOverlay graphicsOverlay = getObjFromList(GraphicsOverlayId);
            int count = graphicsOverlay.getGraphicCount();
            promise.resolve(count);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void indexOf(String GraphicsOverlayId, String graphicID, Promise promise)
    {
        try {
            GraphicsOverlay graphicsOverlay = getObjFromList(GraphicsOverlayId);
            Graphic graphic = JSGraphic.getObjFromList(graphicID);
            int   index = -1;
            if (graphic != null) {
                index = graphicsOverlay.indexOf(graphic);
            }
            promise.resolve(index);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getGraphic(String GraphicsOverlayId, int index, Promise promise)
    {
        try {
            GraphicsOverlay graphicsOverlay = getObjFromList(GraphicsOverlayId);
            Graphic  graphic = graphicsOverlay.getGraphic(index);
            String   strGraphicID = JSGraphic.registerId(graphic);
            WritableMap map = Arguments.createMap();
            map.putString("_MGGraphicId", strGraphicID);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void insertGraphic(String GraphicsOverlayId, int index, String graphicID, Promise promise)
    {
        try {
            GraphicsOverlay graphicsOverlay = getObjFromList(GraphicsOverlayId);
            Graphic graphic = JSGraphic.getObjFromList(graphicID);
            int  iRes  = -1;
            if (graphic != null) {
                iRes = graphicsOverlay.insertGraphic(index,graphic);
            }
            promise.resolve(iRes);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void removeGraphicByIndex(String GraphicsOverlayId, int index, Promise promise)
    {
        try {
            GraphicsOverlay graphicsOverlay = getObjFromList(GraphicsOverlayId);
            graphicsOverlay.removeGraphic(index);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void moveGraphic(String GraphicsOverlayId, int fromIndex, int toIndex, Promise promise)
    {
        try {
            GraphicsOverlay graphicsOverlay = getObjFromList(GraphicsOverlayId);
            graphicsOverlay.moveGraphic(fromIndex, toIndex);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void removeGraphicByAttribute(String GraphicsOverlayId, String name, String value, Promise promise)
    {
        try {
            GraphicsOverlay graphicsOverlay = getObjFromList(GraphicsOverlayId);
            graphicsOverlay.removeGraphicByAttribute(name, value);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getGraphicsByAttribute(String GraphicsOverlayId, String name, String value, Promise promise)
    {
        try {
            GraphicsOverlay graphicsOverlay = getObjFromList(GraphicsOverlayId);
            List<Graphic> graphicList = graphicsOverlay.getGraphicsByAttribute(name, value);
            String strGraphicID = "";
            WritableArray graphicArr = Arguments.createArray();
            if (graphicsOverlay != null) {
                for (int i = 0; i < graphicList.size(); i++) {
                    strGraphicID = JSGraphic.registerId(graphicList.get(i));
                    graphicArr.pushString(strGraphicID);
                }
            }
            promise.resolve(graphicArr);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

}
