package com.mapgis_mobile_reactnative;
/**
 * @content 地图视图组件
 * @author fjl 2019-6-16 下午2:52:36
 */
import android.content.Context;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import android.util.Log;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.zondy.mapgis.android.mapview.MapView;
import com.zondy.mapgis.core.geometry.Dot;

import java.io.File;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by will on 2016/6/16.
 */
public class JSMapView extends ReactContextBaseJavaModule {
    private static MapView curMapView=null;
    private static Map<String,MapView> mapViewList=new HashMap<String,MapView>();
    Context m_Context = null;
    MapView m_mapView;
    ReactContext mReactContext;
    String m_PointName;


    private static final String DOUBLE_TAP_EVENT = "com.mapgis.RN.JSMapview.double_tap_event";
    private static final String SINGLE_TAP_EVENT = "com.mapgis.RN.JSMapview.single_tap_event";


    @Override
    public String getName(){return "JSMapView";}

    public JSMapView(ReactApplicationContext reactContext){
        super(reactContext);
        m_Context =reactContext.getApplicationContext();
        mReactContext = reactContext;
    }

    /**
     * 提供给MapView视图组件用于创建MapView实例的方法。
     * @param reactContext
     * @return
     */
    public static MapView createInstance(ThemedReactContext reactContext){
        curMapView=new MapView(reactContext.getBaseContext());
        return curMapView;
    }

    /**
     * 在native层注册一个MapView的Id，并返回该ID供JS层调用；
     * 注册前先判断该MapView是否已经存在，如果存在，返回已经存在的ID，如果不存在，创建新的ID以返回。
     * @param mapView
     * @return
     */
    public static String registerId(MapView mapView){
        for(Map.Entry entry:mapViewList.entrySet()){
            if(mapView.equals(entry.getValue())){
                return (String)entry.getKey();
            }
        }
        Calendar calendar=Calendar.getInstance();
        String id=Long.toString(calendar.getTimeInMillis());
        mapViewList.put(id,mapView);
        System.out.print(id);
        return id;
    }

    /**
     * 根据ID获得MapView实例
     * @param id
     * @return
     */
    public static MapView getObjById(String id){
        return mapViewList.get(id);
    }



    /**
     * 加载地图
     * @param mapViewId
     * @param strMapPath
     * @param promise
     */
    @ReactMethod
    public void loadFromFile(String mapViewId,String strMapPath,Promise promise){
        try{
            m_mapView = mapViewList.get(mapViewId);
            final String strRootPath = android.os.Environment.getExternalStorageDirectory().getPath() + File.separator + "MapGIS Mobile 2D Sample" + File.separator;
            m_mapView.loadFromFile(strRootPath + strMapPath);
            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void refresh(String mapViewId,Promise promise){
        try{
            m_mapView = mapViewList.get(mapViewId);
            m_mapView.refresh();
            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void mapPointToViewPoint(String mapViewId,String pointID,Promise promise) {
        try{
            m_mapView = mapViewList.get(mapViewId);

            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }


    /**
     * 设置地图中心点
     * @param mapViewId
     * @param centerID
     * @param promise
     */
    @ReactMethod
    public void setMapCenter(String mapViewId,String centerID,Promise promise)
    {
        try {
            MapView mapView = mapViewList.get(mapViewId);
            Dot point2D = JSDot.m_Point2DList.get(centerID);
            mapView.panToCenter(point2D,false);
            Log.d("setMapCenter:centerID",""+centerID);
            promise.resolve(true);
        }
        catch (Exception e)
        {
            promise.reject(e);
        }
    }

    /**
     * 获取地图的中心点
     * @param mapViewId
     * @param promise
     */
    @ReactMethod
    public void getMapCenter(String mapViewId,Promise promise)
    {
        try {
            MapView mapView = mapViewList.get(mapViewId);
            Dot centerDot = mapView.getCenterPoint();

            String dotId=JSDot.registerId(centerDot);
            WritableMap map= Arguments.createMap();
            map.putString("dotID",dotId);
            map.putDouble("x",centerDot.getX());
            map.putDouble("y",centerDot.getY());
            Log.d("getMapCenter:",""+centerDot.x+centerDot.y);
            Log.d("getMapCenter:centerID",""+dotId);
            promise.resolve(map);
        }
        catch (Exception e)
        {
            promise.reject(e);
        }
    }
}
