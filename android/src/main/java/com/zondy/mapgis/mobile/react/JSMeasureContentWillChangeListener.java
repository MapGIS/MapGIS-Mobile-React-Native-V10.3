package com.zondy.mapgis.mobile.react;

import android.util.Log;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.zondy.mapgis.android.internal.tool.sketcheditor.MeasureResultContentWillChangeListenerDefault;
import com.zondy.mapgis.android.tool.sketcheditor.MeasureOption;
import com.zondy.mapgis.android.tool.sketcheditor.MeasureResultContentWillChangeListener;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nullable;

/**
 * Created by xiaoying on 2020/1/13.
 */
public class JSMeasureContentWillChangeListener extends ReactContextBaseJavaModule {
    private static final String REACT_NAME = "JSMeasureContentWillChangeListener";
    private static HashMap<String, JSMeasureContentWillChangeListener> mJSMeasureContentWillChangeListenerList = new HashMap<>();
    private String mFormatDigit = "###0.00";

    private boolean mIsShowDistanceUnit = true;         // 是否显示距离单位
    private boolean mIsShowAreaUnit = true;             // 是否显示面积单位
    private boolean mIsAutoChangeDistanceUnit = true;   // 是否自动改变距离单位
    private boolean mIsAutoChangeAreaUnit = true;       // 是否自动改变面积单位
    private String mDistanceUnitAndScale = "米*1";      // 距离单位名称_单位进制（相对于米）
    private String mAreaUnitAndScale = "平方米*1";      // 面积单位名称_单位进制（相对于平方米）

    public JSMeasureContentWillChangeListener(ReactApplicationContext reactContext) {
        super(reactContext);

    }

    @Override
    public String getName() {
        return REACT_NAME;
    }

    public static String registerId(JSMeasureContentWillChangeListener obj) {
        for (java.util.Map.Entry entry : mJSMeasureContentWillChangeListenerList.entrySet()) {
            if (obj.equals(entry.getValue())) {
                String id = (String) entry.getKey();
                return id;
            }
        }

        Calendar calendar = Calendar.getInstance();
        String id = Long.toString(calendar.getTimeInMillis());
        mJSMeasureContentWillChangeListenerList.put(id, obj);
        return id;
    }

    public static JSMeasureContentWillChangeListener getObjFromList(String id) {
        return mJSMeasureContentWillChangeListenerList.get(id);
    }

    @ReactMethod
    public void createObj(Promise promise) {
        try {
            String measureListenerId = registerId(this);

            promise.resolve(measureListenerId);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setIsShowDistanceUnit(String measureOptionListenerId, boolean isShowDistanceUnit, Promise promise) {
        try {
            this.mIsShowDistanceUnit = isShowDistanceUnit;
            promise.resolve(true);

        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getIsShowDistanceUnit(String measureOptionListenerId, Promise promise) {
        try {
            promise.resolve(mIsShowDistanceUnit);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @ReactMethod
    public void setIsShowAreaUnit(String measureOptionListenerId, boolean isShowAreaUnit, Promise promise) {
        try {
            this.mIsShowAreaUnit = isShowAreaUnit;
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getIsShowAreaUnit(String measureOptionListenerId, Promise promise) {
        try {
            promise.resolve(mIsShowAreaUnit);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @ReactMethod
    public void setIsAutoChangeDistanceUnit(String measureOptionListenerId, boolean isAutoChangeDistanceUnit, Promise promise) {
        try {
            this.mIsAutoChangeDistanceUnit = isAutoChangeDistanceUnit;
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getIsAutoChangeDistanceUnit(String measureOptionListenerId, Promise promise) {
        try {
            promise.resolve(mIsAutoChangeDistanceUnit);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @ReactMethod
    public void setIsAutoChangeAreaUnit(String measureOptionListenerId, boolean isAutoChangeAreaUnit, Promise promise) {
        try {
            this.mIsAutoChangeAreaUnit = isAutoChangeAreaUnit;
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getIsAutoChangeAreaUnit(String measureOptionListenerId, Promise promise) {
        try {
            promise.resolve(mIsAutoChangeAreaUnit);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @ReactMethod
    public void setDistanceUnitAndScale(String measureOptionListenerId, String distanceUnitAndScale, Promise promise) {
        try {
            this.mDistanceUnitAndScale = distanceUnitAndScale;
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getDistanceUnitAndScale(String measureOptionListenerId, Promise promise) {
        try {
            promise.resolve(mDistanceUnitAndScale);
        } catch (Exception e) {
            promise.reject(e);
        }
    }


    @ReactMethod
    public void setAreaUnitAndScale(String measureOptionListenerId, String areaUnitAndScale, Promise promise) {
        try {
            this.mAreaUnitAndScale = areaUnitAndScale;
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getAreaUnitAndScale(String measureOptionListenerId, Promise promise) {
        try {
            promise.resolve(mAreaUnitAndScale);
        } catch (Exception e) {
            promise.reject(e);
        }
    }


    public MeasureResultContentWillChangeListener getMeasureResultContentWillChangeListener() {
        return mContentWillChangeListener;
    }

    MeasureResultContentWillChangeListener mContentWillChangeListener = new MeasureResultContentWillChangeListener() {
        @Override
        public String onDistanceContentWillChange(double distance) {
            if (mIsAutoChangeDistanceUnit) {
                MeasureResultContentWillChangeListenerDefault measureResultContentWillChangeListenerDefault = new MeasureResultContentWillChangeListenerDefault();
                return measureResultContentWillChangeListenerDefault.onDistanceContentWillChange(distance);
            } else {
                return formatMeasureDistance(distance);
            }
        }

        @Override
        public String onAreaContentWillChange(double area) {
            if (mIsAutoChangeAreaUnit) {
                MeasureResultContentWillChangeListenerDefault measureResultContentWillChangeListenerDefault = new MeasureResultContentWillChangeListenerDefault();
                return  measureResultContentWillChangeListenerDefault.onAreaContentWillChange(area);
            } else {
                return formatMeasureArea(area);
            }
        }
    };

    /**
     * 转换原始的距离
     *
     * @param distance
     * @return
     */
    private String formatMeasureDistance(double distance) {
        String desValue = String.valueOf(distance);
        String unitName = "米";
        double unitScale = 1;

        if (isValidUnitNameAndScale(mDistanceUnitAndScale)) {
            String[] str = mDistanceUnitAndScale.split("\\*");
            if (str.length > 1) {
                unitName = str[0].trim();
                unitScale = Double.parseDouble(str[1].trim());
            }
        }

        desValue = decimalFormatValue(distance * unitScale);

        // 显示单位
        if (mIsShowDistanceUnit) {
            desValue = desValue + unitName;
        }

        return desValue;

    }

    /**
     * 转换原始的面积
     *
     * @param area
     * @return
     */
    private String formatMeasureArea(double area) {
        String desValue = String.valueOf(area);
        double unitScale = 1;
        String unitName = "平方米";

        if (isValidUnitNameAndScale(mAreaUnitAndScale)) {
            String[] str = mAreaUnitAndScale.split("\\*");
            if (str.length > 1) {
                unitName = str[0].trim();
                unitScale = Double.parseDouble(str[1].trim());
            }
        }

        desValue = decimalFormatValue(area * unitScale);

        // 显示单位
        if (mIsShowAreaUnit) {
            desValue = desValue + unitName;
        }

        return desValue;
    }

    /**
     * 判断单位及进制字符串是否有效
     *
     * @param unitNameAndScale 单位及进制
     * @return {Boolean}
     */
    private boolean isValidUnitNameAndScale(String unitNameAndScale) {
        boolean isValid = false;

        if (unitNameAndScale != null && !unitNameAndScale.isEmpty() && unitNameAndScale.contains("*")) {
            isValid = true;
        }

        return isValid;
    }

    /**
     * 格式化数值，只保留小数点后两位
     *
     * @param value
     * @return
     */
    private String decimalFormatValue(double value) {
        DecimalFormat decimalFormat = new DecimalFormat(mFormatDigit);
        return decimalFormat.format(value);
    }
}
