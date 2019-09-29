package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.android.graphic.VisualMap;
import com.zondy.mapgis.mobile.react.utils.ConvertUtil;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class JSVisualMap extends ReactContextBaseJavaModule {

    public static final String REACT_CLASS = "JSVisualMap";
    public static Map<String, VisualMap> mVisualMapPointList = new HashMap<String, VisualMap>();

    public JSVisualMap(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public static VisualMap getObjFromList(String id) {
        return mVisualMapPointList.get(id);
    }

    public static String registerId(VisualMap obj) {
        for (Map.Entry entry : mVisualMapPointList.entrySet()) {
            if (obj.equals(entry.getValue())) {
                return (String) entry.getKey();
            }
        }
        Calendar calendar = Calendar.getInstance();
        String id = Long.toString(calendar.getTimeInMillis());
        mVisualMapPointList.put(id, obj);
        return id;
    }

    @ReactMethod
    public void createObj(Promise promise) {
        try {
            VisualMap visualMap = new VisualMap();
            String strVisualMapId = registerId(visualMap);

            WritableMap map = Arguments.createMap();
            map.putString("VisualMapId", strVisualMapId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void createObj(double minValue, double maxValue, String[] colors, int colorCount, Promise promise) {
        try {
            int[] colorLst = null;
            if(colors.length > 0)
            {
                colorLst = new int[colors.length];
                for(int i = 0;i <colors.length;i++) {
                    colorLst[i] = ConvertUtil.ColorRGBAToInt(colors[i]);
                }
            }
            VisualMap visualMap = new VisualMap(minValue, maxValue, colorLst, colorCount);
            String strVisualMapId = registerId(visualMap);

            WritableMap map = Arguments.createMap();
            map.putString("VisualMapId", strVisualMapId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setMinValue(String visualMapId, double minValue, Promise promise)
    {
        try {
            VisualMap visualMap = getObjFromList(visualMapId);
            visualMap.setMinValue(minValue);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getMinValue(String visualMapId, Promise promise)
    {
        try {
            VisualMap visualMap = getObjFromList(visualMapId);
            double minValue = visualMap.getMinValue();
            promise.resolve(minValue);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public  void  setMaxValue(String visualMapId, double maxValue, Promise promise)
    {
        try {
            VisualMap visualMap = getObjFromList(visualMapId);
            visualMap.setMaxValue(maxValue);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getMaxValue(String visualMapId, Promise promise)
    {
        try {
            VisualMap visualMap = getObjFromList(visualMapId);
            double maxValue = visualMap.getMaxValue();
            promise.resolve(maxValue);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setColors(String visualMapId, String[] colors,Promise promise)
    {
        try {
            VisualMap visualMap = getObjFromList(visualMapId);
            if(colors.length > 0)
            {
                int[] colorLst = new int[colors.length];
                for(int i = 0;i <colors.length;i++)
                {
                    colorLst[i] = ConvertUtil.ColorRGBAToInt(colors[i]);
                }
                visualMap.setColors(colorLst,colors.length);
            }
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getColors(String visualMapId, Promise promise)
    {
        try {
            VisualMap visualMap = getObjFromList(visualMapId);
            int[] colors = visualMap.getColors();

            String strColor = "";
            WritableArray arr = Arguments.createArray();
            for(int i = 0;i <colors.length;i++)
            {
                strColor = ConvertUtil.ColorIntToRGBA(colors[i]);
                arr.pushString(strColor);
            }
            WritableMap map = Arguments.createMap();
            map.putArray("ColorArr", arr);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }
}
