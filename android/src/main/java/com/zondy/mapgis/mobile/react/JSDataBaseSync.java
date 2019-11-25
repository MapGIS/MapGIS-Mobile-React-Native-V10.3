package com.zondy.mapgis.mobile.react;

import android.os.Environment;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.core.featureservice.DataBaseSync;
import com.zondy.mapgis.core.featureservice.DownloadDataBaseParmeters;
import com.zondy.mapgis.core.featureservice.MapServiceInfo;
import com.zondy.mapgis.core.featureservice.SyncDataBaseParmeters;
import com.zondy.mapgis.core.geodatabase.DataBase;
import com.zondy.mapgis.core.geometry.Rect;

import java.io.File;

public class JSDataBaseSync extends JSSyncBase{

    private static final String REACT_CLASS = "JSDataBaseSync";
    private ReactApplicationContext mReactContext;

    public JSDataBaseSync(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

//    @ReactMethod
//    public void createObj(Promise promise) {
//        try {
//            DataBaseSync dataBaseSync = new DataBaseSync();
//            String dataBaseSyncId = registerId(dataBaseSync);
//
//            WritableMap map = Arguments.createMap();
//            map.putString("DataBaseSyncId", dataBaseSyncId);
//            promise.resolve(map);
//        } catch (Exception e) {
//            promise.reject(e);
//        }
//    }

    @ReactMethod
    public static void createDefaultDownloadDataBaseParmeters(String strIGServerBaseURL, String strDocName, int mapID, String extentId, Promise promise)
    {
        try {
            Rect extent = JSRect.getObjFromList(extentId);
            DownloadDataBaseParmeters parmeters = DataBaseSync.createDefaultDownloadDataBaseParmeters(strIGServerBaseURL, strDocName, mapID, extent);
            String parmetersId = JSDownloadDataBaseParmeters.registerId(parmeters);
            WritableMap map = Arguments.createMap();
            map.putString("DownloadDataBaseParmetersId", parmetersId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public static void  createDefaultSyncDataBaseParmeters(String databaseId, Promise promise)
    {
        try {
            DataBase dataBase = JSDataBase.getObjFromList(databaseId);
            SyncDataBaseParmeters parmeters = DataBaseSync.createDefaultSyncDataBaseParmeters(dataBase);
            String parmetersId = JSSyncDataBaseParmeters.registerId(parmeters);
            WritableMap map = Arguments.createMap();
            map.putString("SyncDataBaseParmetersId", parmetersId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public static void getMapServiceInfo(String strIGServerBaseURL, String strDocName, int mapID, Promise promise)
    {
        try {
            MapServiceInfo mapServiceInfo = DataBaseSync.getMapServiceInfo(strIGServerBaseURL, strDocName, mapID);
            String mapServiceInfoId = JSMapServiceInfo.registerId(mapServiceInfo);
            WritableMap map = Arguments.createMap();
            map.putString("MapServiceInfoId", mapServiceInfoId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public static void downloadASync(final String strIGServerBaseURL, final String strDocName, final int mapID, final String paramsId, final String strPath, Promise promise)
    {
        try {
            DownloadDataBaseParmeters params = JSDownloadDataBaseParmeters.getObjFromList(paramsId);
            int iVal = (int)DataBaseSync.downloadASync(strIGServerBaseURL, strDocName, mapID, params, strPath);
            promise.resolve(iVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

   @ReactMethod
    public static void updateASync(final String paramsId, final String databaseId, Promise promise)
    {
        try {
            SyncDataBaseParmeters params = JSSyncDataBaseParmeters.getObjFromList(paramsId);
            DataBase database = JSDataBase.getObjFromList(databaseId);
            int iVal = (int)DataBaseSync.updateASync(params, database);
            promise.resolve(iVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public static void commitASync(String paramsId, String databaseId, Promise promise)
    {
        try {
            SyncDataBaseParmeters params = JSSyncDataBaseParmeters.getObjFromList(paramsId);
            DataBase database = JSDataBase.getObjFromList(databaseId);
            int iVal = (int)DataBaseSync.commitASync(params, database);
            promise.resolve(iVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public static void stopASync(int lSyncCode, Promise promise)
    {
        try {
            int iVal = (int)DataBaseSync.stopASync(lSyncCode);
            promise.resolve(iVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }
}
