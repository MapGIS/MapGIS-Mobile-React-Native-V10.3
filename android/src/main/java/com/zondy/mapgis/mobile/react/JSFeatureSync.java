package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.zondy.mapgis.core.featureservice.FeatureSync;
import com.zondy.mapgis.core.geodatabase.DataBase;
import com.zondy.mapgis.core.geodatabase.IVectorCls;
import com.zondy.mapgis.core.geodatabase.XClsType;
import com.zondy.mapgis.core.geometry.Rect;
import com.zondy.mapgis.core.object.Enumeration;

public class JSFeatureSync extends JSSyncBase{
    private static final String REACT_CLASS = "JSFeatureSync";

    public JSFeatureSync(ReactApplicationContext reactContext) {
        super(reactContext);
    }
    @Override
    public String getName() {
        return REACT_CLASS;
    }

   @ReactMethod
    public static void downloadASync(final String strIGServerBaseURL, final String strDataURL, final String extentId, final String whereClause, final String databaseId, final int clsType, final String clsName, Promise promise)
    {
        try {
            Rect extent = JSRect.getObjFromList(extentId);
            DataBase database = JSDataBase.getObjFromList(databaseId);
            XClsType type = (XClsType) Enumeration.parse(XClsType.class, clsType);
            int iVal = (int)FeatureSync.downloadASync(strIGServerBaseURL, strDataURL, extent, whereClause, database, type, clsName);
            promise.resolve(iVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public static void downloadASync(final String strIGServerBaseURL, final String strDocName, final int mapID, final int layerID, final String extentId, final String whereClause, final String databaseId,
                                     final String clsType, final String clsName, Promise promise)
    {
        try {
            Rect extent = JSRect.getObjFromList(extentId);
            DataBase database = JSDataBase.getObjFromList(databaseId);
            XClsType type = (XClsType) Enumeration.parse(XClsType.class, clsType);
            int iVal = (int)FeatureSync.downloadASync(strIGServerBaseURL, strDocName, mapID, layerID, extent, whereClause, database, type, clsName);
            promise.resolve(iVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public static void downloadAllASync(final String strIGServerBaseURL, final String strDataURL, final String databaseId, final String clsType, final String clsName, Promise promise)
    {
        try {
            DataBase database = JSDataBase.getObjFromList(databaseId);
            XClsType type = (XClsType) Enumeration.parse(XClsType.class, clsType);
            int iVal = (int)FeatureSync.downloadAllASync(strIGServerBaseURL, strDataURL, database, type, clsName);
            promise.resolve(iVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public static void downloadAllASync(final String strIGServerBaseURL, final String strDocName, final int mapID, final int layerID, final String databaseId, final String clsType, final String clsName, Promise promise)
    {
        try {
            DataBase database = JSDataBase.getObjFromList(databaseId);
            XClsType type = (XClsType) Enumeration.parse(XClsType.class, clsType);
            int iVal = (int)FeatureSync.downloadAllASync(strIGServerBaseURL, strDocName, mapID, layerID, database, type, clsName);
            promise.resolve(iVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

   @ReactMethod
    public static void updateASync(final String clsId, Promise promise)
    {
        try {
            IVectorCls cls = (IVectorCls)JSVectorCls.getObjFromList(clsId);
            int iVal = (int)FeatureSync.updateASync(cls);
            promise.resolve(iVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

   @ReactMethod
    public static void commitASync(final String clsId, Promise promise)
    {
        try {
            IVectorCls cls = (IVectorCls)JSVectorCls.getObjFromList(clsId);
            int iVal = (int)FeatureSync.commitASync(cls);
            promise.resolve(iVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public static void bind(String clsId, String strIGServerBaseURL, String strDocName, int mapID, int layerID, Promise promise)
    {
        try {
            IVectorCls cls = (IVectorCls)JSVectorCls.getObjFromList(clsId);
            int iVal = (int)FeatureSync.bind(cls, strIGServerBaseURL, strDocName, mapID, layerID);
            promise.resolve(iVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public static void bind(String clsId, String strIGServerBaseURL, String strDataURL, Promise promise)
    {
        try {
            IVectorCls cls = (IVectorCls)JSVectorCls.getObjFromList(clsId);
            int iVal = (int)FeatureSync.bind(cls, strIGServerBaseURL, strDataURL);
            promise.resolve(iVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public static void stopASync(int lSyncCode, Promise promise)
    {
        try {
            int iVal = (int)FeatureSync.stopASync(lSyncCode);
            promise.resolve(iVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }
}
