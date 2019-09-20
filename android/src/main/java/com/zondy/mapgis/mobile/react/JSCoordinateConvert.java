package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.zondy.mapgis.android.utils.CoordinateConvert;
import com.zondy.mapgis.android.utils.CoordinateConvertParameter;
import com.zondy.mapgis.core.geometry.Dot;
import com.zondy.mapgis.core.map.ServerLayer;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * 坐标转换类Native功能组件
 * Created by xiaoying on 2019/9/11.
 */
public class JSCoordinateConvert extends ReactContextBaseJavaModule {
    private static final String REACT_CLASS = "JSCoordinateConvert";
    public static Map<String, CoordinateConvert> mCoordinateConvertList = new HashMap<>();
    private static final String CONVERT_FAILED = "com.mapgis.RN.CoordinateConvert.convert_failed";
    private static final String CONVERT_SUCCESS = "com.mapgis.RN.CoordinateConvert.convert_success";
    private ReactApplicationContext mReactContext;
    private CoordinateConvert coordinateConvert = null;

    public JSCoordinateConvert(ReactApplicationContext reactContext) {
        super(reactContext);
        this.mReactContext = reactContext;
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public static CoordinateConvert getObjFromList(String id){
        return mCoordinateConvertList.get(id);
    }

    public static String registerId(CoordinateConvert obj){
        for (Map.Entry entry : mCoordinateConvertList.entrySet()) {
            if (obj.equals(entry.getValue())) {
                String id = (String) entry.getKey();
                return id;
            }
        }

        Calendar calendar = Calendar.getInstance();
        String id = Long.toString(calendar.getTimeInMillis());
        mCoordinateConvertList.put(id, obj);
        return id;
    }

    @ReactMethod
    public void createObj(Promise promise){
        try {
            CoordinateConvert coordinateConvert = new CoordinateConvert();
            String coordinateConvertId = registerId(coordinateConvert);

            WritableMap writableMap = Arguments.createMap();
            writableMap.putString("CoordinateConvertId", coordinateConvertId);
            promise.resolve(writableMap);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setConvertParams(String coordinateConvertId, String coordinateConvertParameterId, Promise promise){
        try {
            CoordinateConvert coordinateConvert = getObjFromList(coordinateConvertId);
            CoordinateConvertParameter coordinateConvertParameter = JSCoordinateConvertParameter.getObjFromList(coordinateConvertParameterId);

            CoordinateConvert coordinateConvert1 = coordinateConvert.setConvertParams(coordinateConvertParameter);
            String coordinateConvertId1 = registerId(coordinateConvert1);

            WritableMap writableMap = Arguments.createMap();
            writableMap.putString("CoordinateConvertId", coordinateConvertId1);
            promise.resolve(writableMap);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getConvertParams(String coordinateConvertId, Promise promise){
        try {
            CoordinateConvert coordinateConvert = getObjFromList(coordinateConvertId);
            CoordinateConvertParameter coordinateConvertParameter = coordinateConvert.getConvertParams();
            String coordinateConvertParameterId = null;
            if(coordinateConvertParameter != null){
                coordinateConvertParameterId = JSCoordinateConvertParameter.registerId(coordinateConvertParameter);
            }

            WritableMap writableMap = Arguments.createMap();
            writableMap.putString("CoordinateConvertParameterId", coordinateConvertParameterId);
            promise.resolve(writableMap);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void convert(String coordinateConvertId, String dotId, Promise promise){
        try {
            CoordinateConvert coordinateConvert = getObjFromList(coordinateConvertId);
            Dot dot = JSDot.getObjFromList(dotId);
            WritableMap writableMap = Arguments.createMap();
            String convertDotId = null;
            if(dot != null){
                Dot convertDot = coordinateConvert.convert(dot);
                convertDotId = JSDot.registerId(convertDot);
            }
            writableMap.putString("point2DId", convertDotId);
            promise.resolve(writableMap);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void convertAsync(String coordinateConvertId, String dotId, final Promise promise){
        try {
            CoordinateConvert coordinateConvert = getObjFromList(coordinateConvertId);
            CoordinateConvert.ConvertCallback callback = new CoordinateConvert.ConvertCallback() {
                @Override
                public void convertFailed(String s) {
                    WritableMap writableMap = Arguments.createMap();
                    writableMap.putBoolean("isSuccess", false);
                    writableMap.putString("result", s);
//                  mReactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
//                          .emit(CONVERT_FAILED, writableMap);
                    promise.resolve(writableMap);
                }

                @Override
                public void convertSuccesss(Dot dot) {
                    WritableMap writableMap = Arguments.createMap();
                    String point2DId = null;
                    if(dot != null){
                        point2DId = JSDot.registerId(dot);
                    }
                    writableMap.putBoolean("isSuccess", true);
                    writableMap.putString("result", point2DId);
//                  mReactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
//                           .emit(CONVERT_SUCCESS, writableMap);
                    promise.resolve(writableMap);

                }
            };

            Dot dot = JSDot.getObjFromList(dotId);
            coordinateConvert.convertAsync(dot, callback);
        }catch (Exception e){
            promise.reject(e);
        }
    }

}
