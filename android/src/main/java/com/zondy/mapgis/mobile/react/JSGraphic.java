package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.mobile.react.utils.ConvertUtil;
import com.zondy.mapgis.android.graphic.Graphic;
import com.zondy.mapgis.android.graphic.GraphicType;
import com.zondy.mapgis.core.geometry.Dot;
import com.zondy.mapgis.core.geometry.Rect;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author fjl 2019-6-18 下午2:52:36
 * @content 图形对象Native组件
 */
public class JSGraphic extends ReactContextBaseJavaModule {
    public static final String REACT_CLASS = "JSGraphic";
    public static Map<String, Graphic> mGraphicList = new HashMap<String, Graphic>();

    public JSGraphic(ReactApplicationContext context) {
        super(context);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public static Graphic getObjFromList(String id) {
        return mGraphicList.get(id);
    }

    public static String registerId(Graphic obj) {
        for (Map.Entry entry : mGraphicList.entrySet()) {
            if (obj.equals(entry.getValue())) {
                return (String) entry.getKey();
            }
        }

        Calendar calendar = Calendar.getInstance();
        String id = Long.toString(calendar.getTimeInMillis());
        mGraphicList.put(id, obj);
        return id;
    }

    @ReactMethod
    public void getState(String GraphicId, Promise promise) {
        try {
            Graphic graphic = getObjFromList(GraphicId);
            int state = graphic.getState();

            promise.resolve(state);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setState(String GraphicId, int state, Promise promise) {
        try {
            Graphic Graphic = getObjFromList(GraphicId);
            Graphic.setState(state);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setColor(String GraphicId, String color, Promise promise) {
        try {
            Graphic graphic = getObjFromList(GraphicId);
            graphic.setColor(ConvertUtil.ColorRGBAToInt(color));
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getColor(String GraphicId, Promise promise) {
        try {
            Graphic graphic = getObjFromList(GraphicId);
            int color = graphic.getColor();
            String strColor = ConvertUtil.ColorIntToRGBA(color);
            WritableMap map = Arguments.createMap();
            map.putString("color", strColor);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }


    @ReactMethod
    public void getCenterPoint(String GraphicId, Promise promise) {
        try {
            Graphic Graphic = getObjFromList(GraphicId);
            Dot centerDot = Graphic.getCenterPoint();

            String point2DId = JSDot.registerId(centerDot);
            WritableMap map = Arguments.createMap();
            map.putString("point2DId", point2DId);
            map.putDouble("x", centerDot.getX());
            map.putDouble("y", centerDot.getY());
            promise.resolve(map);

        } catch (Exception e) {
            promise.reject(e);
        }
    }


    @ReactMethod
    public void getBoundingRect(String GraphicId, Promise promise) {
        try {
            Graphic Graphic = getObjFromList(GraphicId);
            Rect rect = Graphic.getBoundingRect();

            String rectId = JSRect.registerId(rect);
            WritableMap map = Arguments.createMap();
            map.putString("RectId", rectId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getGraphicType(String GraphicId, Promise promise) {
        try {
            Graphic graphic = getObjFromList(GraphicId);
            GraphicType graphicType = graphic.getGraphicType();
            int type = graphicType.value();

            promise.resolve(type);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setPointByPixel(String GraphicId, boolean pixel, Promise promise) {
        try {
            Graphic Graphic = getObjFromList(GraphicId);
            Graphic.setPointByPixel(pixel);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void isPointByPixel(String GraphicId, Promise promise) {
        try {
            Graphic graphic = getObjFromList(GraphicId);
            boolean isPointByPixel = graphic.isPointByPixel();

            promise.resolve(isPointByPixel);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setAttributeValue(String GraphicId, String name, String value, Promise promise) {
        try {
            Graphic Graphic = getObjFromList(GraphicId);
            Graphic.setAttributeValue(name, value);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getAttributeNum(String GraphicId, Promise promise) {
        try {
            Graphic graphic = getObjFromList(GraphicId);
            int attributeNum = (int)graphic.getAttributeNum();

            promise.resolve(attributeNum);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getAttributeName(String GraphicId, int index, Promise promise) {
        try {
            Graphic graphic = getObjFromList(GraphicId);
            String attributeName = graphic.getAttributeName(index);

            promise.resolve(attributeName);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getAttributeValue(String GraphicId, int index, Promise promise)
    {
        try {
            Graphic graphic = getObjFromList(GraphicId);
            String attributeValue = graphic.getAttributeValue(index);

            promise.resolve(attributeValue);
        } catch (Exception e) {
            promise.reject(e);
        }
    }
    @ReactMethod
    public void getAttributeValueByName(String GraphicId, String name, Promise promise) {
        try {
            Graphic graphic = getObjFromList(GraphicId);
            String attributeValue = graphic.getAttributeValue(name);

            promise.resolve(attributeValue);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void removeAttribute(String GraphicId, String name, Promise promise) {
        try {
            Graphic graphic = getObjFromList(GraphicId);
            graphic.removeAttribute(name);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void removeAllAttributes(String GraphicId, Promise promise) {
        try {
            Graphic graphic = getObjFromList(GraphicId);
            graphic.removeAllAttributes();
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void toGraphicsFromGeometry(String geometryID, Promise promise)
    {
//        try {
//            //GraphicHeatmap graphicHeatmap = getObjFromList(geometryID);
//           // Geometry   geometry = JSGeometry.getObjFromList(geometryID);
//            List<Graphic> graphicList = Graphic.toGraphicsFromGeometry();
//            String strGraphicID = "";
//            WritableArray arr = Arguments.createArray();
//            if (graphicList.size() > 0) {
//                for (int i = 0; i < graphicList.size(); i++) {
//                    strGraphicID = registerId(graphicList.get(i));
//                    arr.pushString(strGraphicID);
//                }
//            }
//            WritableMap map = Arguments.createMap();
//            map.putArray("GraphicArr", arr);
//            promise.resolve(map);
//        } catch (Exception e) {
//            promise.reject(e);
//        }
    }

    @ReactMethod
    public void toGeometry(String graphicID, Promise promise)
    {
        try {
            Graphic graphic = getObjFromList(graphicID);
            //Geometry geometry = Graphic.toGeometry(graphic);
           // String geometryID = JSGeometry.registerId(geometry);
            WritableMap map = Arguments.createMap();
            //map.putString("GeometryID", geometryID);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void toGeometry(ReadableArray graphicIDArray, Promise promise)
    {
        try {
            if(graphicIDArray.size() > 0)
            {
                ArrayList<Graphic> graphicLst = new ArrayList();
                for (int i = 0; i < graphicIDArray.size(); i++) {
                    ReadableMap readable = graphicIDArray.getMap(i);
                    String keyStr = readable.getString("_GraphicId");
                    graphicLst.add(JSGraphic.getObjFromList(keyStr));
                }
               // Geometry geometry = Graphic.toGeometry(graphicLst);
                // String geometryID = JSGeometry.registerId(geometry);
                WritableMap map = Arguments.createMap();
                //map.putString("GeometryID", geometryID);
                promise.resolve(map);
            }
        } catch (Exception e) {
            promise.reject(e);
        }
    }

}
