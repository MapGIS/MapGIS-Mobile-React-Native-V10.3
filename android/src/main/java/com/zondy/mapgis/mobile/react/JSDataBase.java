package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.core.geodatabase.DataBase;
import com.zondy.mapgis.core.geodatabase.IXClsInfo;
import com.zondy.mapgis.core.geodatabase.XClsType;
import com.zondy.mapgis.core.object.Enumeration;
import com.zondy.mapgis.core.object.IntList;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class JSDataBase extends ReactContextBaseJavaModule {
    public static final String REACT_CLASS = "JSDataBase";
    public static Map<String, DataBase> mDataBaseList = new HashMap<String, DataBase>();

    public JSDataBase(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public static DataBase getObjFromList(String id) {
        return mDataBaseList.get(id);
    }

    public static String registerId(DataBase obj) {
        for (Map.Entry entry : mDataBaseList.entrySet()) {
            if (obj.equals(entry.getValue())) {
                return (String) entry.getKey();
            }
        }
        Calendar calendar = Calendar.getInstance();
        String id = Long.toString(calendar.getTimeInMillis());
        mDataBaseList.put(id, obj);
        return id;
    }

    @ReactMethod
    public void createObj(Promise promise) {
        try { ;
            DataBase dataBase = new DataBase();
            String dataBaseId = registerId(dataBase);
            WritableMap map = Arguments.createMap();
            map.putString("DataBaseId", dataBaseId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getDbName(String dataBaseId, Promise promise)
    {
        try {
            DataBase dataBase = getObjFromList(dataBaseId);
            String strDbName = dataBase.getName();
            promise.resolve(strDbName);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getFullName(String dataBaseId, Promise promise)
    {
        try {
            DataBase dataBase = getObjFromList(dataBaseId);
            String strFullName = dataBase.getFullName();
            promise.resolve(strFullName);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void hasOpened(String dataBaseId, Promise promise)
    {
        try {
            DataBase dataBase = getObjFromList(dataBaseId);
            boolean isOpened = dataBase.hasOpened();
            promise.resolve(isOpened);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

   @ReactMethod
    public void create(String dataBaseId, String strDatabasePath, Promise promise)
    {
        try {
            DataBase dataBase = getObjFromList(dataBaseId);
            int iVal = (int)dataBase.create(strDatabasePath);
            promise.resolve(iVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void close(String dataBaseId, Promise promise)
    {
        try {
            DataBase dataBase = getObjFromList(dataBaseId);
            int iVal = (int)dataBase.close();
            promise.resolve(iVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getXclseIDs(String dataBaseId, int xClsType, int dsID, Promise promise)
    {
        try {
            DataBase dataBase = getObjFromList(dataBaseId);
            XClsType type = (XClsType) Enumeration.parse(XClsType.class, xClsType);
            IntList intLst = dataBase.getXclseIDs(type, dsID);
            WritableArray xclseIDsArray = Arguments.createArray();
            for (int i = 0; i < intLst.size(); i++) {
                xclseIDsArray.pushInt(intLst.get(i));
            }
            WritableMap map = Arguments.createMap();
            map.putArray("XclseIDsArray", xclseIDsArray);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getXclsInfo(String dataBaseId, int xClsType, int clsID, Promise promise)
    {
        try {
            DataBase dataBase = getObjFromList(dataBaseId);
            XClsType type = (XClsType) Enumeration.parse(XClsType.class, xClsType);
            IXClsInfo xClsInfo = dataBase.getXclsInfo(type, clsID);
            String xClsInfoId = JSXClsInfo.registerId(xClsInfo);
            WritableMap map = Arguments.createMap();
            map.putString("XClsInfoId", xClsInfoId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getXclsName(String dataBaseId, int xClsType, int xclsID, Promise promise)
    {
        try {
            DataBase dataBase = getObjFromList(dataBaseId);
            XClsType type = (XClsType) Enumeration.parse(XClsType.class, xClsType);
            String strXclsName = dataBase.getXclsName(type, xclsID);
            promise.resolve(strXclsName);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getXclsNum(String dataBaseId, int xClsType, int dsID, Promise promise)
    {
        try {
            DataBase dataBase = getObjFromList(dataBaseId);
            XClsType type = (XClsType) Enumeration.parse(XClsType.class, xClsType);
            int iNum = (int)dataBase.getXclsNum(type, dsID);
            promise.resolve(iNum);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void open(String dataBaseId, String strDatabasePath, Promise promise)
    {
        try {
            DataBase dataBase = getObjFromList(dataBaseId);
            int iVal = (int)dataBase.open(strDatabasePath);
            promise.resolve(iVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void xClsIsExist(String dataBaseId, int xClsType, String name, Promise promise)
    {
        try {
            DataBase dataBase = getObjFromList(dataBaseId);
            XClsType type = (XClsType) Enumeration.parse(XClsType.class, xClsType);
            int iVal = (int)dataBase.xClsIsExist(type, name);
            promise.resolve(iVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    public void updateAsync(String dataBaseId, final String strUpdateDatabasePath, final Promise promise)
    {
        try {
            DataBase dataBase = getObjFromList(dataBaseId);
            dataBase.updateAsync(strUpdateDatabasePath, new DataBase.DataBaseUpdateCallback()
            {
                @Override
                public void onUpdating(long totalClsCount, long curClsIndex, double curClsUpdateProgress) {

                    WritableMap map = Arguments.createMap();
                    map.putInt("TotalClsCount", (int)totalClsCount);
                    map.putInt("CurClsIndex", (int)curClsIndex);
                    map.putDouble("CurClsUpdateProgress", curClsUpdateProgress);
                    promise.resolve(map);
                }

                @Override
                public void onUpdateFinish(boolean normalFinish) {
                    promise.resolve(normalFinish);
                }
            });
        } catch (Exception e) {
            promise.reject(e);
        }
    }
}