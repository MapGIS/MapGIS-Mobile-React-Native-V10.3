package com.zondy.mapgis.mobile.react.scene;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.zondy.mapgis.core.scene.DriverType;

import java.util.HashMap;
import java.util.Map;

/**
 * @auther LiaoLiang on 20-7-3
 * @content 驱动类型
 */
public class JSDriverType extends ReactContextBaseJavaModule {
    private static final String REACT_CLASS = "JSDriverType";

    private static final String Driver_Type_GDAL = "Driver_Type_GDAL"; //GDAL数据驱动.用于离线栅格数据的读取
    private static final String Driver_Type_MapGIS_3D = "Driver_Type_MapGIS_3D"; //MapGIS三维服务驱动
    private static final String Driver_Type_MapGIS_Map = "Driver_Type_MapGIS_Map"; //MapGIS地图服务驱动
    private static final String Driver_Type_Model_MapGIS_M3D = "Driver_Type_Model_MapGIS_M3D"; //MapGIS M3D模型缓存驱动
    private static final String Driver_Type_Model_MapGIS_OP = "Driver_Type_Model_MapGIS_OP"; //MapGIS倾斜摄影数据驱动
    private static final String Driver_Type_OGR = "Driver_Type_OGR"; //OGR数据驱动.用于离线矢量数据的读取
    private static final String Driver_Type_TMS = "Driver_Type_TMS"; //TMS服务驱动
    private static final String Driver_Type_WFS = "Driver_Type_WFS"; //OGC WFS服务驱动
    private static final String Driver_Type_WMS = "Driver_Type_WMS"; //OGC WMS服务驱动
    private static final String Driver_Type_XYZ = "Driver_Type_XYZ"; //标准Web墨卡托地图服务驱动.如google、百度等

    public JSDriverType(@NonNull ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @NonNull
    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Nullable
    @Override
    public Map<String, Object> getConstants() {
        Map<String,Object> constants = new HashMap<>();
        constants.put(Driver_Type_GDAL, DriverType.Driver_Type_GDAL);
        constants.put(Driver_Type_MapGIS_3D, DriverType.Driver_Type_MapGIS_3D);
        constants.put(Driver_Type_MapGIS_Map, DriverType.Driver_Type_MapGIS_Map);
        constants.put(Driver_Type_Model_MapGIS_M3D, DriverType.Driver_Type_Model_MapGIS_M3D);
        constants.put(Driver_Type_Model_MapGIS_OP, DriverType.Driver_Type_Model_MapGIS_OP);
        constants.put(Driver_Type_OGR, DriverType.Driver_Type_OGR);
        constants.put(Driver_Type_TMS, DriverType.Driver_Type_TMS);
        constants.put(Driver_Type_WFS, DriverType.Driver_Type_WFS);
        constants.put(Driver_Type_WMS, DriverType.Driver_Type_WMS);
        constants.put(Driver_Type_XYZ, DriverType.Driver_Type_XYZ);

        return constants;
    }
}
