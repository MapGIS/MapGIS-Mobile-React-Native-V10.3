package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.android.utils.CoordinateConvertParameter;
import com.zondy.mapgis.android.utils.CoordinateType;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * 坐标转换参数的Native功能组件
 * Created by xiaoying on 2019/9/11.
 */
public class JSCoordinateConvertParameter extends ReactContextBaseJavaModule {
    private static final String REACT_CLASS = "JSCoordinateConvertParameter";
    public static Map<String, CoordinateConvertParameter> mCoordinateConvertParameterList = new HashMap<>();

    public JSCoordinateConvertParameter(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public static CoordinateConvertParameter getObjFromList(String id){
        return mCoordinateConvertParameterList.get(id);
    }

    public static String registerId(CoordinateConvertParameter obj){
        for (Map.Entry entry : mCoordinateConvertParameterList.entrySet()) {
            if (obj.equals(entry.getValue())) {
                String id = (String) entry.getKey();
                mCoordinateConvertParameterList.put(id, obj);
                return (String) entry.getKey();
            }
        }

        Calendar calendar = Calendar.getInstance();
        String id = Long.toString(calendar.getTimeInMillis());
        mCoordinateConvertParameterList.put(id, obj);
        return id;
    }

    @ReactMethod
    public void createObj(Promise promise){
        try {
            CoordinateConvertParameter coordinateConvertParameter = new CoordinateConvertParameter();
            String coordinateConvertParameterId = registerId(coordinateConvertParameter);

            WritableMap writableMap = Arguments.createMap();
            writableMap.putString("CoordinateConvertParameterId", coordinateConvertParameterId);
            promise.resolve(writableMap);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getDestCoordinateType(String coordinateConvertParameterId, Promise promise){
        try {
            CoordinateConvertParameter coordinateConvertParameter = getObjFromList(coordinateConvertParameterId);
            CoordinateType coordinateType = coordinateConvertParameter.getDestCoordinateType();
            int destCoordinateType = coordinateType.getValue();

            promise.resolve(destCoordinateType);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setDestCoordinateType(String coordinateConvertParameterId, int coordinateType, Promise promise){
        try {
            CoordinateConvertParameter coordinateConvertParameter = getObjFromList(coordinateConvertParameterId);
            CoordinateType destCoordinateType = convertValueToCoordinateType(coordinateType); // 将value转换成CoordinateType
            CoordinateConvertParameter destCoordinateConvertParameter = coordinateConvertParameter.setDestCoordinateType(destCoordinateType);
            String destCoordinateConvertParameterId = registerId(destCoordinateConvertParameter);

            WritableMap writableMap = Arguments.createMap();
            writableMap.putString("CoordinateConvertParameterId", destCoordinateConvertParameterId);
            promise.resolve(writableMap);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getSrcCoordinateType(String coordinateConvertParameterId, Promise promise){
        try {
            CoordinateConvertParameter coordinateConvertParameter = getObjFromList(coordinateConvertParameterId);
            CoordinateType coordinateType = coordinateConvertParameter.getSrcCoordinateType();
            int srcCoordinateType = coordinateType.getValue();

            promise.resolve(srcCoordinateType);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setSrcCoordinateType(String coordinateConvertParameterId, int coordinateType, Promise promise){
        try {
            CoordinateConvertParameter coordinateConvertParameter = getObjFromList(coordinateConvertParameterId);
            CoordinateType srcCoordinateType = convertValueToCoordinateType(coordinateType); // 将value转换成CoordinateType
            CoordinateConvertParameter srcCoordinateConvertParamter = coordinateConvertParameter.setSrcCoordinateType(srcCoordinateType);
            String srcCoordinateConvertParameterId = registerId(srcCoordinateConvertParamter);

            WritableMap writableMap = Arguments.createMap();
            writableMap.putString("CoordinateConvertParameterId", srcCoordinateConvertParameterId);
            promise.resolve(writableMap);
        }catch (Exception e){
            promise.reject(e);
        }

    }

    /**
     * 将value转换成对应的CoordinateType
     * @param value CoordinateType对应的value值
     * @return CoordinateType枚举
     */
    private CoordinateType convertValueToCoordinateType(int value){
        CoordinateType coordinateType = CoordinateType.GPS_LngLat;
        switch (value){
            case 0:
                coordinateType = CoordinateType.BAIDU_LngLat;
                break;
            case  1:
                coordinateType = CoordinateType.GPS_LngLat;
                break;
            case 2:
                coordinateType = CoordinateType.AMAP_LngLat;
                break;
            case 3:
                coordinateType = CoordinateType.NAVINFO_LngLat;
                break;
            case 4:
                coordinateType = CoordinateType.GCJ02_LngLat;
                break;
            default:
                break;
        }
        return coordinateType;
    }
}
