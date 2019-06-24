package com.mapgis_mobile_reactnative;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PointF;
import android.os.Environment;
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
import com.mapgis_mobile_reactnative.utils.ConvertUtil;
import com.zondy.mapgis.android.mapview.MapView;
import com.zondy.mapgis.core.geometry.Dot;
import com.zondy.mapgis.core.geometry.Rect;

import java.io.File;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * @content 地图视图组件
 * @author fjl 2019-6-16 下午2:52:36
 */
public class JSMapView extends ReactContextBaseJavaModule {
    private static MapView curMapView=null;
    private static Map<String,MapView> mapViewList=new HashMap<String,MapView>();
    Context m_Context = null;
    MapView m_mapView;
    ReactContext mReactContext;
    /**手机sdcard路径**/
    public static final String PHONE_SDCARD_PATH = Environment.getExternalStorageDirectory().getPath();


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

    public void setBackGroundColor(String mapViewId,String color,Promise promise)
    {
        try {
            MapView mapView = mapViewList.get(mapViewId);
            mapView.setBackGroundColor(ConvertUtil.ColorRGBAToInt(color));
        }
        catch (Exception e)
        {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getBackGroundColor(String mapViewId,Promise promise) {
        try{
            m_mapView = mapViewList.get(mapViewId);
            int color = m_mapView.getBackGroundColor();
            String strColor = ConvertUtil.ColorIntToRGBA(color);

            WritableMap map= Arguments.createMap();
            map.putString("color",strColor);
            promise.resolve(map);
        }catch (Exception e){
            promise.reject(e);
        }
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
            com.zondy.mapgis.android.environment.Environment.requestAuthorization(m_mapView.getContext(),new com.zondy.mapgis.android.environment.Environment.AuthorizeCallback()
            {
                @Override
                public void onComplete() {
                }
            });
            String strRootPath = PHONE_SDCARD_PATH + File.separator;
            m_mapView.loadFromFile(strRootPath + strMapPath);
            Log.d("loadFromFile:",strRootPath + strMapPath);
            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getMap(String mapViewId,Promise promise) {
        try{
            m_mapView = mapViewList.get(mapViewId);
            int color = m_mapView.getBackGroundColor();
            String strColor = ConvertUtil.ColorIntToRGBA(color);

            com.zondy.mapgis.core.map.Map Map = m_mapView.getMap();

            String mapID = JSMap.registerId(Map);
            WritableMap map= Arguments.createMap();

            map.putString("mapID",mapID);
            promise.resolve(map);
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
    public void forceRefresh(String mapViewId,Promise promise){
        try{
            m_mapView = mapViewList.get(mapViewId);
            m_mapView.forceRefresh();
            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void mapPointToViewPoint(String mapViewId,String dotID,Promise promise) {
        try{
            m_mapView = mapViewList.get(mapViewId);
            Dot dot = JSDot.m_Point2DList.get(dotID);
           PointF pointf =  m_mapView.mapPointToViewPoint(dot);

            String pointFId = JSPointF.registerId(pointf);
            WritableMap map= Arguments.createMap();
            map.putString("pointFId",pointFId);
            map.putDouble("x",pointf.x);
            map.putDouble("y",pointf.y);
            promise.resolve(map);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void viewPointToMapPoint(String mapViewId,String pointFID,Promise promise) {
        try{
            m_mapView = mapViewList.get(mapViewId);
            PointF pointf = JSPointF.mPointfList.get(pointFID);
            Dot dot =  m_mapView.viewPointToMapPoint(pointf);

            String dotID = JSDot.registerId(dot);
            WritableMap map= Arguments.createMap();
            map.putString("dotID",dotID);
            map.putDouble("x",dot.getX());
            map.putDouble("y",dot.getY());
            promise.resolve(map);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getResolution(String mapViewId,Promise promise) {
        try{
            m_mapView = mapViewList.get(mapViewId);
            double resolution = m_mapView.getResolution();

            WritableMap map= Arguments.createMap();
            map.putDouble("resolution",resolution);
            promise.resolve(map);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getMaxResolution(String mapViewId,Promise promise) {
        try{
            m_mapView = mapViewList.get(mapViewId);
            double maxResolution = m_mapView.getMaxResolution();

            WritableMap map= Arguments.createMap();
            map.putDouble("maxResolution",maxResolution);
            promise.resolve(map);
        }catch (Exception e){
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

    @ReactMethod
    public void getDispRange(String mapViewId,Promise promise)
    {
        try {
            MapView mapView = mapViewList.get(mapViewId);
            Rect rect = mapView.getDispRange();

            String rectId = JSRect.registerId(rect);
            WritableMap map = Arguments.createMap();
            map.putString("rectId",rectId);
            promise.resolve(map);
        }
        catch (Exception e)
        {
            promise.reject(e);
        }
    }
    @ReactMethod
    public void moveMap(String mapViewId,float mx, float my, boolean animated,Promise promise)
    {
        try {
            MapView mapView = mapViewList.get(mapViewId);
            mapView.moveMap(mx,my,animated);
        }
        catch (Exception e)
        {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void zoomToCenter(String mapViewId,String centerPoint, double resolution, boolean animated,Promise promise)
    {
        try {
            MapView mapView = mapViewList.get(mapViewId);
            Dot dot = JSDot.m_Point2DList.get(centerPoint);
            mapView.zoomToCenter(dot,resolution,animated);
        }
        catch (Exception e)
        {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void zoomToRange(String mapViewId,String dispRange, boolean animated,Promise promise)
    {
        try {
            MapView mapView = mapViewList.get(mapViewId);
            Rect rect = JSRect.mRectList.get(dispRange);
            mapView.zoomToRange(rect,animated);
        }
        catch (Exception e)
        {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void zoomIn(String mapViewId, boolean animated,Promise promise)
    {
        try {
            MapView mapView = mapViewList.get(mapViewId);
            mapView.zoomIn(animated);
        }
        catch (Exception e)
        {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void zoomOut(String mapViewId, boolean animated,Promise promise)
    {
        try {
            MapView mapView = mapViewList.get(mapViewId);
            mapView.zoomOut(animated);
        }
        catch (Exception e)
        {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void restore(String mapViewId, boolean animated,Promise promise)
    {
        try {
            MapView mapView = mapViewList.get(mapViewId);
            mapView.restore(animated);
        }
        catch (Exception e)
        {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setRotateCenterAndAngle(String mapViewId,String rotateCenter,float rotateAngle, boolean animated,Promise promise)
    {
        try {
            MapView mapView = mapViewList.get(mapViewId);
            Dot dot = JSDot.m_Point2DList.get(rotateCenter);
            mapView.setRotateCenterAndAngle(dot,rotateAngle,animated);
        }
        catch (Exception e)
        {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setRotateAngle(String mapViewId,float rotateAngle,boolean animated,Promise promise)
    {
        try {
            MapView mapView = mapViewList.get(mapViewId);
            mapView.setRotateAngle(rotateAngle,animated);
        }
        catch (Exception e)
        {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void rotate(String mapViewId,float rotation, float pivotX, float pivotY,boolean animated,Promise promise)
    {
        try {
            MapView mapView = mapViewList.get(mapViewId);
            mapView.rotate(rotation,pivotX,pivotY,animated);
        }
        catch (Exception e)
        {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getRotateCenter(String mapViewId,Promise promise)
    {
        try {
            MapView mapView = mapViewList.get(mapViewId);
            Dot centerDot = mapView.getRotateCenter();

            String dotId=JSDot.registerId(centerDot);
            WritableMap map= Arguments.createMap();
            map.putString("dotID",dotId);
            map.putDouble("x",centerDot.getX());
            map.putDouble("y",centerDot.getY());
            promise.resolve(map);
        }
        catch (Exception e)
        {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getRotateAngle(String mapViewId,Promise promise) {
        try{
            m_mapView = mapViewList.get(mapViewId);
            double rotateAngle = m_mapView.getRotateAngle();

            WritableMap map= Arguments.createMap();
            map.putDouble("rotateAngle",rotateAngle);
            promise.resolve(map);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setSlopeAngle(String mapViewId,float slopeAngle,boolean animated,Promise promise)
    {
        try {
            MapView mapView = mapViewList.get(mapViewId);
            mapView.setSlopeAngle(slopeAngle,animated);
        }
        catch (Exception e)
        {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getSlopeAngle(String mapViewId,Promise promise) {
        try{
            m_mapView = mapViewList.get(mapViewId);
            double slopeAngle = m_mapView.getSlopeAngle();

            WritableMap map= Arguments.createMap();
            map.putDouble("slopeAngle",slopeAngle);
            promise.resolve(map);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void stopAnimation(String mapViewId,Promise promise){
        try{
            m_mapView = mapViewList.get(mapViewId);
            m_mapView.stopAnimation();
            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setMaxTextureCacheSize(String mapViewId,int size,Promise promise)
    {
        try {
            MapView mapView = mapViewList.get(mapViewId);
            mapView.setMaxTextureCacheSize(size);
        }
        catch (Exception e)
        {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getMaxTextureCacheSize(String mapViewId,Promise promise) {
        try{
            m_mapView = mapViewList.get(mapViewId);
            int MaxTextureCacheSize = m_mapView.getMaxTextureCacheSize();

            WritableMap map= Arguments.createMap();
            map.putInt("MaxTextureCacheSize",MaxTextureCacheSize);
            promise.resolve(map);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void clearTextureCache(String mapViewId,Promise promise){
        try{
            m_mapView = mapViewList.get(mapViewId);
            m_mapView.clearTextureCache();

        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setSupportTransparency(String mapViewId,boolean support,Promise promise)
    {
        try {
            MapView mapView = mapViewList.get(mapViewId);
            mapView.setSupportTransparency(support);
        }
        catch (Exception e)
        {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void isSupportTransparency(String mapViewId,Promise promise) {
        try{
            m_mapView = mapViewList.get(mapViewId);
            boolean isSupportTransparency = m_mapView.isSupportTransparency();

            WritableMap map= Arguments.createMap();
            map.putBoolean("isSupportTransparency",isSupportTransparency);

            promise.resolve(map);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setShowNorthArrow(String mapViewId,boolean show,Promise promise)
    {
        try {
            MapView mapView = mapViewList.get(mapViewId);
            mapView.setShowNorthArrow(show);
        }
        catch (Exception e)
        {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void isShowNorthArrow(String mapViewId,Promise promise) {
        try{
            m_mapView = mapViewList.get(mapViewId);
            boolean isShowNorthArrow = m_mapView.isShowNorthArrow();

            WritableMap map= Arguments.createMap();
            map.putBoolean("isShowNorthArrow",isShowNorthArrow);

            promise.resolve(map);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setNorthArrowPosition(String mapViewId,String pointFID,Promise promise) {
        try{
            m_mapView = mapViewList.get(mapViewId);
            PointF pointf = JSPointF.mPointfList.get(pointFID);
            m_mapView.setNorthArrowPosition(pointf);

        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getNorthArrowPosition(String mapViewId,Promise promise) {
        try{
            m_mapView = mapViewList.get(mapViewId);

            PointF pointf =  m_mapView.getNorthArrowPosition();

            String pointFId = JSPointF.registerId(pointf);
            WritableMap map= Arguments.createMap();
            map.putString("pointFId",pointFId);
            map.putDouble("x",pointf.x);
            map.putDouble("y",pointf.y);
            promise.resolve(map);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setNorthArrowImage(String mapViewId,String bitmapID,Promise promise) {
        try{
            m_mapView = mapViewList.get(mapViewId);
            Bitmap bitmap = JSImage.mBitmapList.get(bitmapID);
            m_mapView.setNorthArrowImage(bitmap);
//            Bitmap mBitmap = BitmapFactory.decodeResource(mReactContext.getResources(), android.R.drawable.alert_dark_frame);
//            m_mapView.setNorthArrowImage(mBitmap);
            Log.e("setNorthArrowImage","setNorthArrowImage() run!!!");
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setShowLogo(String mapViewId,boolean show,Promise promise)
    {
        try {
            MapView mapView = mapViewList.get(mapViewId);
            mapView.setShowLogo(show);
        }
        catch (Exception e)
        {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void isShowLogo(String mapViewId,Promise promise) {
        try{
            m_mapView = mapViewList.get(mapViewId);
            boolean isShowLogo = m_mapView.isShowLogo();

            WritableMap map= Arguments.createMap();
            map.putBoolean("isShowLogo",isShowLogo);

            promise.resolve(map);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setLogoPoistion(String mapViewId,int position,Promise promise)
    {
        try {
            MapView mapView = mapViewList.get(mapViewId);
            mapView.setLogoPoistion(position);
        }
        catch (Exception e)
        {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getLogoPoistion(String mapViewId,Promise promise) {
        try{
            m_mapView = mapViewList.get(mapViewId);
            int LogoPoistion = m_mapView.getLogoPoistion();

            WritableMap map= Arguments.createMap();
            map.putInt("LogoPoistion",LogoPoistion);

            promise.resolve(map);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    public void setShowScaleBar(String mapViewId,boolean show,Promise promise)
    {
        try {
            MapView mapView = mapViewList.get(mapViewId);
            mapView.setShowScaleBar(show);
        }
        catch (Exception e)
        {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void isShowScaleBar(String mapViewId,Promise promise) {
        try{
            m_mapView = mapViewList.get(mapViewId);
            boolean isShowScaleBar = m_mapView.isShowScaleBar();

            WritableMap map= Arguments.createMap();
            map.putBoolean("isShowScaleBar",isShowScaleBar);

            promise.resolve(map);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setScaleBarPoistion(String mapViewId,String pointFID,Promise promise) {
        try{
            m_mapView = mapViewList.get(mapViewId);
            PointF pointf = JSPointF.mPointfList.get(pointFID);
            m_mapView.setScaleBarPoistion(pointf);

        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getScaleBarPoistion(String mapViewId,Promise promise) {
        try{
            m_mapView = mapViewList.get(mapViewId);

            PointF pointf =  m_mapView.getScaleBarPoistion();

            String pointFId = JSPointF.registerId(pointf);
            WritableMap map= Arguments.createMap();
            map.putString("pointFId",pointFId);
            map.putDouble("x",pointf.x);
            map.putDouble("y",pointf.y);
            promise.resolve(map);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setSkyImage(String mapViewId,String bitmapID,Promise promise) {
        try{
            m_mapView = mapViewList.get(mapViewId);
            Bitmap bitmap = JSImage.mBitmapList.get(bitmapID);
            m_mapView.setSkyImage(bitmap);

        }catch (Exception e){
            promise.reject(e);
        }
    }

    public void setSkySceneEnabled(String mapViewId,boolean enabled,Promise promise)
    {
        try {
            MapView mapView = mapViewList.get(mapViewId);
            mapView.setSkySceneEnabled(enabled);
        }
        catch (Exception e)
        {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void isSkySceneEnabled(String mapViewId,Promise promise) {
        try{
            m_mapView = mapViewList.get(mapViewId);
            boolean isSkySceneEnabled = m_mapView.isSkySceneEnabled();

            WritableMap map= Arguments.createMap();
            map.putBoolean("isSkySceneEnabled",isSkySceneEnabled);

            promise.resolve(map);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    public void setZoomControlsEnabled(String mapViewId,boolean enabled,Promise promise)
    {
        try {
            MapView mapView = mapViewList.get(mapViewId);
            mapView.setZoomControlsEnabled(enabled);
        }
        catch (Exception e)
        {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void isZoomControlsEnabled(String mapViewId,Promise promise) {
        try{
            m_mapView = mapViewList.get(mapViewId);
            boolean isZoomControlsEnabled = m_mapView.isZoomControlsEnabled();

            WritableMap map= Arguments.createMap();
            map.putBoolean("isZoomControlsEnabled",isZoomControlsEnabled);

            promise.resolve(map);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    public void setMapPanGesturesEnabled(String mapViewId,boolean enabled,Promise promise)
    {
        try {
            MapView mapView = mapViewList.get(mapViewId);
            mapView.setMapPanGesturesEnabled(enabled);
        }
        catch (Exception e)
        {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void isMapPanGesturesEnabled(String mapViewId,Promise promise) {
        try{
            m_mapView = mapViewList.get(mapViewId);
            boolean isMapPanGesturesEnabled = m_mapView.isMapPanGesturesEnabled();

            WritableMap map= Arguments.createMap();
            map.putBoolean("isMapPanGesturesEnabled",isMapPanGesturesEnabled);

            promise.resolve(map);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    public void setMapZoomGesturesEnabled(String mapViewId,boolean enabled,Promise promise)
    {
        try {
            MapView mapView = mapViewList.get(mapViewId);
            mapView.setMapZoomGesturesEnabled(enabled);
        }
        catch (Exception e)
        {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void isMapZoomGesturesEnabled(String mapViewId,Promise promise) {
        try{
            m_mapView = mapViewList.get(mapViewId);
            boolean isMapZoomGesturesEnabled = m_mapView.isMapZoomGesturesEnabled();

            WritableMap map= Arguments.createMap();
            map.putBoolean("isMapZoomGesturesEnabled",isMapZoomGesturesEnabled);

            promise.resolve(map);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    public void setMapRotateGesturesEnabled(String mapViewId,boolean enabled,Promise promise)
    {
        try {
            MapView mapView = mapViewList.get(mapViewId);
            mapView.setMapRotateGesturesEnabled(enabled);
        }
        catch (Exception e)
        {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void isMapRotateGesturesEnabled(String mapViewId,Promise promise) {
        try{
            m_mapView = mapViewList.get(mapViewId);
            boolean isMapRotateGesturesEnabled = m_mapView.isMapRotateGesturesEnabled();

            WritableMap map= Arguments.createMap();
            map.putBoolean("isMapRotateGesturesEnabled",isMapRotateGesturesEnabled);

            promise.resolve(map);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    public void setMapSlopeGesturesEnabled(String mapViewId,boolean enabled,Promise promise)
    {
        try {
            MapView mapView = mapViewList.get(mapViewId);
            mapView.setMapSlopeGesturesEnabled(enabled);
        }
        catch (Exception e)
        {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void isMapSlopeGesturesEnabled(String mapViewId,Promise promise) {
        try{
            m_mapView = mapViewList.get(mapViewId);
            boolean isMapSlopeGesturesEnabled = m_mapView.isMapSlopeGesturesEnabled();

            WritableMap map= Arguments.createMap();
            map.putBoolean("isMapSlopeGesturesEnabled",isMapSlopeGesturesEnabled);

            promise.resolve(map);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    public void setDoubleTapZooming(String mapViewId,boolean enabled,Promise promise)
    {
        try {
            MapView mapView = mapViewList.get(mapViewId);
            mapView.setDoubleTapZooming(enabled);
        }
        catch (Exception e)
        {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void isDoubleTapZooming(String mapViewId,Promise promise) {
        try{
            m_mapView = mapViewList.get(mapViewId);
            boolean isDoubleTapZooming = m_mapView.isDoubleTapZooming();

            WritableMap map= Arguments.createMap();
            map.putBoolean("isDoubleTapZooming",isDoubleTapZooming);

            promise.resolve(map);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    public void setTwoFingerTapZooming(String mapViewId,boolean enabled,Promise promise)
    {
        try {
            MapView mapView = mapViewList.get(mapViewId);
            mapView.setTwoFingerTapZooming(enabled);
        }
        catch (Exception e)
        {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void isTwoFingerTapZooming(String mapViewId,Promise promise) {
        try{
            m_mapView = mapViewList.get(mapViewId);
            boolean isTwoFingerTapZooming = m_mapView.isTwoFingerTapZooming();

            WritableMap map= Arguments.createMap();
            map.putBoolean("isTwoFingerTapZooming",isTwoFingerTapZooming);

            promise.resolve(map);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    public void setPanEndAnimating(String mapViewId,boolean enabled,Promise promise)
    {
        try {
            MapView mapView = mapViewList.get(mapViewId);
            mapView.setPanEndAnimating(enabled);
        }
        catch (Exception e)
        {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void isPanEndAnimating(String mapViewId,Promise promise) {
        try{
            m_mapView = mapViewList.get(mapViewId);
            boolean isPanEndAnimating = m_mapView.isPanEndAnimating();

            WritableMap map= Arguments.createMap();
            map.putBoolean("isPanEndAnimating",isPanEndAnimating);

            promise.resolve(map);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    public void setLabelRenderAnimating(String mapViewId,boolean enabled,Promise promise)
    {
        try {
            MapView mapView = mapViewList.get(mapViewId);
            mapView.setLabelRenderAnimating(enabled);
        }
        catch (Exception e)
        {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void isLabelRenderAnimating(String mapViewId,Promise promise) {
        try{
            m_mapView = mapViewList.get(mapViewId);
            boolean isLabelRenderAnimating = m_mapView.isLabelRenderAnimating();

            WritableMap map= Arguments.createMap();
            map.putBoolean("isLabelRenderAnimating",isLabelRenderAnimating);

            promise.resolve(map);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setTapListener(String mapViewId,Promise promise) {
        try {
            m_mapView = mapViewList.get(mapViewId);
            MapListener mapListener = new MapListener(m_mapView,mReactContext);
            m_mapView.setTapListener(mapListener);
            promise.resolve(true);

            Log.d("setTapListener:",""+true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setLongTapListener(String mapViewId,Promise promise) {
        try {
            m_mapView = mapViewList.get(mapViewId);
            MapListener mapListener = new MapListener(m_mapView,mReactContext);
            m_mapView.setLongTapListener(mapListener);
            promise.resolve(true);

            Log.d("setLongTapListener:",""+true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setDoubleTapListener(String mapViewId,Promise promise) {
        try {
            m_mapView = mapViewList.get(mapViewId);
            MapListener mapListener = new MapListener(m_mapView,mReactContext);
            m_mapView.setDoubleTapListener(mapListener);
            promise.resolve(true);

            Log.d("setDoubleTapListener:",""+true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }


    @ReactMethod
    public void setTouchListener(String mapViewId,Promise promise) {
        try {
            m_mapView = mapViewList.get(mapViewId);
            MapListener mapListener = new MapListener(m_mapView,mReactContext);
            m_mapView.setTouchListener(mapListener);
            promise.resolve(true);

            Log.d("setTouchListener:",""+true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setZoomChangedListener(String mapViewId,Promise promise) {
        try {
            m_mapView = mapViewList.get(mapViewId);
            MapListener mapListener = new MapListener(m_mapView,mReactContext);
            m_mapView.setZoomChangedListener(mapListener);
            promise.resolve(true);

            Log.d("setZoomChangedListener:",""+true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setCenterChangedListener(String mapViewId,Promise promise) {
        try {
            m_mapView = mapViewList.get(mapViewId);
            MapListener mapListener = new MapListener(m_mapView,mReactContext);
            m_mapView.setCenterChangedListener(mapListener);
            promise.resolve(true);

        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setRotateChangedListener(String mapViewId,Promise promise) {
        try {
            m_mapView = mapViewList.get(mapViewId);
            MapListener mapListener = new MapListener(m_mapView,mReactContext);
            m_mapView.setRotateChangedListener(mapListener);
            promise.resolve(true);

        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setAnimationListener(String mapViewId,Promise promise) {
        try {
            m_mapView = mapViewList.get(mapViewId);
            MapListener mapListener = new MapListener(m_mapView,mReactContext);
            m_mapView.setAnimationListener(mapListener);
            promise.resolve(true);

        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setRefreshListener(String mapViewId,Promise promise) {
        try {
            m_mapView = mapViewList.get(mapViewId);
            MapListener mapListener = new MapListener(m_mapView,mReactContext);
            m_mapView.setRefreshListener(mapListener);
            promise.resolve(true);

        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setMapLoadListener(String mapViewId,Promise promise) {
        try {
            m_mapView = mapViewList.get(mapViewId);
            MapListener mapListener = new MapListener(m_mapView,mReactContext);
            m_mapView.setMapLoadListener(mapListener);
            promise.resolve(true);

        } catch (Exception e) {
            promise.reject(e);
        }
    }

}
