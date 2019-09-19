package com.zondy.mapgis.mobile.react;

import android.graphics.PointF;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.android.graphic.GraphicText;
import com.zondy.mapgis.core.geometry.Dot;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import android.util.Log;

/**
 * @author fjl 2019-6-30 下午2:52:36
 * @content 文本图形对象Native组件
 */
public class JSGraphicText extends JSGraphic {
    public static final String REACT_CLASS = "JSGraphicText";
    public static Map<String, GraphicText> mGraphicTextList = new HashMap<String, GraphicText>();


    public JSGraphicText(ReactApplicationContext context) {
        super(context);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public static GraphicText getObjFromList(String id) {
        return mGraphicTextList.get(id);
    }


    public static String registerId(GraphicText obj) {
        for (Map.Entry entry : mGraphicTextList.entrySet()) {
            if (obj.equals(entry.getValue())) {
                return (String) entry.getKey();
            }
        }
        Calendar calendar = Calendar.getInstance();
        String id = Long.toString(calendar.getTimeInMillis());
        mGraphicTextList.put(id, obj);
        return id;
    }

    @ReactMethod
    public void createObj(Promise promise) {
        try {
            GraphicText GraphicText = new GraphicText();
            String GraphicTextId = registerId(GraphicText);

            WritableMap map = Arguments.createMap();
            map.putString("GraphicTextId", GraphicTextId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setPoint(String GraphicTextId, String dotID, Promise promise) {
        try {
            GraphicText graphicText = getObjFromList(GraphicTextId);
            Dot dot = JSDot.getObjFromList(dotID);
            Log.d("GraphicTextId:", "--" + GraphicTextId);
            graphicText.setPoint(dot);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }


    @ReactMethod
    public void setText(String GraphicTextId, String text, Promise promise) {
        try {
            GraphicText graphicText = getObjFromList(GraphicTextId);
            Log.d("GraphicTextId:", "--" + text);
            graphicText.setText(text);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setFontSize(String GraphicTextId, int fontSize, Promise promise) {
        try {
            GraphicText graphicText = getObjFromList(GraphicTextId);
            graphicText.setFontSize(fontSize);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setSlope(String GraphicTextId, boolean isSlope, Promise promise) {
        try {
            GraphicText graphicText = getObjFromList(GraphicTextId);
            graphicText.setSlope(isSlope);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getPoint(String GraphicTextId, Promise promise) {
        try {
            GraphicText graphicText = getObjFromList(GraphicTextId);
            Dot dot = graphicText.getPoint();

            String dotID = JSDot.registerId(dot);
            WritableMap map = Arguments.createMap();
            map.putString("dotID", dotID);

            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }


    @ReactMethod
    public void getText(String GraphicTextId, Promise promise) {
        try {
            GraphicText graphicText = getObjFromList(GraphicTextId);
            String text = graphicText.getText();

            promise.resolve(text);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getFontSize(String GraphicTextId, Promise promise) {
        try {
            GraphicText graphicText = getObjFromList(GraphicTextId);
            int fontSize = graphicText.getFontSize();

            promise.resolve(fontSize);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void isSlope(String GraphicTextId, Promise promise) {
        try {
            GraphicText graphicText = getObjFromList(GraphicTextId);
            boolean isSlope = graphicText.isSlope();

            promise.resolve(isSlope);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getTextWidth(String GraphicTextId, Promise promise) {
        try {
            GraphicText graphicText = getObjFromList(GraphicTextId);
            double textWidth = graphicText.getTextWidth();

            promise.resolve(textWidth);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getTextHeight(String GraphicTextId, Promise promise) {
        try {
            GraphicText graphicText = getObjFromList(GraphicTextId);
            double textHeight = graphicText.getTextHeight();

            promise.resolve(textHeight);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setAnchorPoint(String GraphicTextId, String pointfID, Promise promise) {
        try {
            GraphicText graphicText = getObjFromList(GraphicTextId);
            PointF pointf = JSPointF.getObjFromList(pointfID);
            graphicText.setAnchorPoint(pointf);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getAnchorPoint(String GraphicTextId, Promise promise) {
        try {
            GraphicText graphicText = getObjFromList(GraphicTextId);
            PointF pointf = graphicText.getAnchorPoint();

            String PointFID = JSPointF.registerId(pointf);

            WritableMap map = Arguments.createMap();
            map.putString("PointFID", PointFID);
            promise.resolve(map);

        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setReferenceInfo(String GraphicTextId, int referenceWidth, int referenceHeight, int referenceInterval, String pointfID, Promise promise)
    {
        try {
            GraphicText graphicText = getObjFromList(GraphicTextId);
            PointF pointf = JSPointF.getObjFromList(pointfID);
            graphicText.setReferenceInfo(referenceWidth,referenceHeight,referenceInterval,pointf);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }
}
