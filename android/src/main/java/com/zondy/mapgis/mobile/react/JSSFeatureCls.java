package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.core.attr.Fields;
import com.zondy.mapgis.core.attr.Record;
import com.zondy.mapgis.core.geodatabase.DataBase;
import com.zondy.mapgis.core.geodatabase.FClsInfo;
import com.zondy.mapgis.core.geodatabase.QueryDef;
import com.zondy.mapgis.core.geodatabase.RecordSet;
import com.zondy.mapgis.core.geodatabase.SFeatureCls;
import com.zondy.mapgis.core.geodatabase.XClsType;
import com.zondy.mapgis.core.geometry.AnnType;
import com.zondy.mapgis.core.geometry.GeomType;
import com.zondy.mapgis.core.geometry.Geometry;
import com.zondy.mapgis.core.geometry.GeometryType;
import com.zondy.mapgis.core.geometry.Rect;
import com.zondy.mapgis.core.info.GeomInfo;
import com.zondy.mapgis.core.object.Enumeration;

import java.util.Calendar;
import java.util.Map;

public class JSSFeatureCls extends JSVectorCls{

    public static final String REACT_CLASS = "JSSFeatureCls";

    public JSSFeatureCls(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @ReactMethod
    public void createObj(String dataBaseId, Promise promise) {
        try {
            DataBase dataBase = JSDataBase.getObjFromList(dataBaseId);
            SFeatureCls sFeatureCls= new SFeatureCls(dataBase);
            String sFeatureClsId = registerId(sFeatureCls);
            WritableMap map = Arguments.createMap();
            map.putString("SFeatureClsId", sFeatureClsId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void create(String sFeatureClsId, String name, int geomType, int dsID, int srsID, String fldsId, Promise promise)
    {
        try {
            SFeatureCls sFeatureCls = (SFeatureCls)getObjFromList(sFeatureClsId);
            GeomType type = (GeomType) Enumeration.parse(GeomType.class, geomType);
            Fields flds = JSFields.getObjFromList(fldsId);
            int id = sFeatureCls.create(name, type, dsID, srsID, flds);
            promise.resolve(id);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void open(String sFeatureClsId, int id, Promise promise)
    {
        try {
            SFeatureCls sFeatureCls = (SFeatureCls)getObjFromList(sFeatureClsId);
            long lVal = sFeatureCls.open(id);
            promise.resolve(lVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void open(String sFeatureClsId, String name, Promise promise)
    {
        try {
            SFeatureCls sFeatureCls = (SFeatureCls)getObjFromList(sFeatureClsId);
            long lVal = sFeatureCls.open(name);
            promise.resolve(lVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void hasOpen(String sFeatureClsId, Promise promise)
    {
        try {
            SFeatureCls sFeatureCls = (SFeatureCls)getObjFromList(sFeatureClsId);
            boolean isOpen = sFeatureCls.hasOpen();
            promise.resolve(isOpen);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void clear(String sFeatureClsId, Promise promise)
    {
        try {
            SFeatureCls sFeatureCls = (SFeatureCls)getObjFromList(sFeatureClsId);
            long lVal = sFeatureCls.clear();
            promise.resolve(lVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void close(String sFeatureClsId, Promise promise)
    {
        try {
            SFeatureCls sFeatureCls = (SFeatureCls)getObjFromList(sFeatureClsId);
            long lVal = sFeatureCls.close();
            promise.resolve(lVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getGDataBase(String sFeatureClsId, Promise promise)
    {
        try {
            SFeatureCls sFeatureCls = (SFeatureCls)getObjFromList(sFeatureClsId);
            DataBase dataBase = sFeatureCls.getGDataBase();
            String dataBaseId = JSDataBase.registerId(dataBase);
            WritableMap map = Arguments.createMap();
            map.putString("DataBaseId", dataBaseId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getCount(String sFeatureClsId, Promise promise)
    {
        try {
            SFeatureCls sFeatureCls = (SFeatureCls)getObjFromList(sFeatureClsId);
            long lCount = sFeatureCls.getCount();
            promise.resolve(lCount);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getRange(String sFeatureClsId, Promise promise)
    {
        try {
            SFeatureCls sFeatureCls = (SFeatureCls)getObjFromList(sFeatureClsId);
            Rect rect = sFeatureCls.getRange();
            String rectId = JSRect.registerId(rect);
            WritableMap map = Arguments.createMap();
            map.putString("RectId", rectId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void calRange(String sFeatureClsId, Promise promise)
    {
        try {
            SFeatureCls sFeatureCls = (SFeatureCls)getObjFromList(sFeatureClsId);
            long lVal = sFeatureCls.calRange();
            promise.resolve(lVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getClsType(String sFeatureClsId, Promise promise)
    {
        try {
            SFeatureCls sFeatureCls = (SFeatureCls)getObjFromList(sFeatureClsId);
            XClsType xClsType = sFeatureCls.getClsType();
            int type = Enumeration.getValueByName(XClsType.class, xClsType.name());
            promise.resolve(type);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getGeomType(String sFeatureClsId, Promise promise)
    {
        try {
            SFeatureCls sFeatureCls = (SFeatureCls)getObjFromList(sFeatureClsId);
            GeomType geomType = sFeatureCls.getGeomType();
            int type = Enumeration.getValueByName(GeomType.class, geomType.name());
            promise.resolve(type);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getClsID(String sFeatureClsId, Promise promise)
    {
        try {
            SFeatureCls sFeatureCls = (SFeatureCls)getObjFromList(sFeatureClsId);
            int clsID = sFeatureCls.getClsID();
            promise.resolve(clsID);
        } catch (Exception e) {
            promise.reject(e);
        }
    }


    @ReactMethod
    public void getClsInfo(String sFeatureClsId, Promise promise)
    {
        try {
            SFeatureCls sFeatureCls = (SFeatureCls)getObjFromList(sFeatureClsId);
            FClsInfo fClsInfo= sFeatureCls.getClsInfo();
            String fClsInfoId = JSFClsInfo.registerId(fClsInfo);
            WritableMap map = Arguments.createMap();
            map.putString("FClsInfoId", fClsInfoId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getFields(String sFeatureClsId, Promise promise)
    {
        try {
            SFeatureCls sFeatureCls = (SFeatureCls)getObjFromList(sFeatureClsId);
            Fields fields = sFeatureCls.getFields();
            String fieldsId = JSFields.registerId(fields);
            WritableMap map = Arguments.createMap();
            map.putString("FieldsId", fieldsId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void append(String sFeatureClsId, String geomId, String rcdId, String infoId, Promise promise)
    {
        try {
            SFeatureCls sFeatureCls = (SFeatureCls)getObjFromList(sFeatureClsId);
            Geometry geom = JSGeometry.getObjFromList(geomId);
            Record rcd = JSRecord.getObjFromList(rcdId);
            GeomInfo info = JSGeomInfo.getObjFromList(infoId);
            long lVal = sFeatureCls.append(geom, rcd, info);
            promise.resolve(lVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void selectAllFeature(String sFeatureClsId, Promise promise)
    {
        try {
            SFeatureCls sFeatureCls = (SFeatureCls)getObjFromList(sFeatureClsId);
            RecordSet recordSet = sFeatureCls.selectAllFeature();
            String recordSetId = JSRecordSet.registerId(recordSet);
            WritableMap map = Arguments.createMap();
            map.putString("RecordSetId", recordSetId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void select(String sFeatureClsId, String queryDefId, Promise promise)
    {
        try {
            SFeatureCls sFeatureCls = (SFeatureCls)getObjFromList(sFeatureClsId);
            QueryDef def = JSQueryDef.getObjFromList(queryDefId);
            RecordSet recordSet = sFeatureCls.select(def);
            String recordSetId = JSRecordSet.registerId(recordSet);
            WritableMap map = Arguments.createMap();
            map.putString("RecordSetId", recordSetId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getRect(String sFeatureClsId, long objID, Promise promise)
    {
        try {
            SFeatureCls sFeatureCls = (SFeatureCls)getObjFromList(sFeatureClsId);
            Rect rect = sFeatureCls.getRect(objID);
            String rectId = JSRect.registerId(rect);
            WritableMap map = Arguments.createMap();
            map.putString("RectId", rectId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void get(String sFeatureClsId, long objID, String geomId, String rcdId, String infoId, Promise promise)
    {
        try {
            SFeatureCls sFeatureCls = (SFeatureCls)getObjFromList(sFeatureClsId);
            Geometry geom = JSGeometry.getObjFromList(geomId);
            Record rcd = JSRecord.getObjFromList(rcdId);
            GeomInfo info = JSGeomInfo.getObjFromList(infoId);
            long lVal = sFeatureCls.get(objID, geom, rcd, info);
            promise.resolve(lVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getAtt(String sFeatureClsId, long objID, Promise promise)
    {
        try {
            SFeatureCls sFeatureCls = (SFeatureCls)getObjFromList(sFeatureClsId);
            Record rcd = sFeatureCls.getAtt(objID);
            String rcdId = JSRecord.registerId(rcd);
            WritableMap map = Arguments.createMap();
            map.putString("RecordId", rcdId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getGeometry(String sFeatureClsId, long objID, Promise promise)
    {
        try {
            SFeatureCls sFeatureCls = (SFeatureCls)getObjFromList(sFeatureClsId);
            Geometry geom = sFeatureCls.getGeometry(objID);
            String geomId = JSGeometry.registerId(geom);
            WritableMap map = Arguments.createMap();
            map.putString("GeometryId", geomId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getGeometryType(String sFeatureClsId, long objID, Promise promise)
    {
        try {
            SFeatureCls sFeatureCls = (SFeatureCls)getObjFromList(sFeatureClsId);
            GeometryType geometryType = sFeatureCls.getGeometryType(objID);
            int type = Enumeration.getValueByName(GeometryType.class, geometryType.name());
            promise.resolve(type);
        } catch (Exception e) {
            promise.reject(e);
        }
    }


    @ReactMethod
    public void getInfo(String sFeatureClsId, long objID, Promise promise)
    {
        try {
            SFeatureCls sFeatureCls = (SFeatureCls)getObjFromList(sFeatureClsId);
            GeomInfo info = sFeatureCls.getInfo(objID);
            String infoId = JSGeomInfo.registerId(info);
            WritableMap map = Arguments.createMap();
            map.putString("GeomInfoId", infoId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getClsName(String sFeatureClsId, Promise promise)
    {
        try {
            SFeatureCls sFeatureCls = (SFeatureCls)getObjFromList(sFeatureClsId);
            String clsName = sFeatureCls.getClsName();
            promise.resolve(clsName);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setClsName(String sFeatureClsId, String newVal, Promise promise)
    {
        try {
            SFeatureCls sFeatureCls = (SFeatureCls)getObjFromList(sFeatureClsId);
            sFeatureCls.setClsName(newVal);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getURL(String sFeatureClsId, Promise promise)
    {
        try {
            SFeatureCls sFeatureCls = (SFeatureCls)getObjFromList(sFeatureClsId);
            String strUrl = sFeatureCls.getURL();
            promise.resolve(strUrl);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getAliasName(String sFeatureClsId, Promise promise)
    {
        try {
            SFeatureCls sFeatureCls = (SFeatureCls)getObjFromList(sFeatureClsId);
            String aliasName = sFeatureCls.getAliasName();
            promise.resolve(aliasName);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setAliasName(String sFeatureClsId, String newVal, Promise promise)
    {
        try {
            SFeatureCls sFeatureCls = (SFeatureCls)getObjFromList(sFeatureClsId);
            long lVal = sFeatureCls.setAliasName(newVal);
            promise.resolve(lVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getSrID(String sFeatureClsId, Promise promise)
    {
        try {
            SFeatureCls sFeatureCls = (SFeatureCls)getObjFromList(sFeatureClsId);
            int srID = sFeatureCls.getSrID();
            promise.resolve(srID);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setSrID(String sFeatureClsId, int newVal, Promise promise)
    {
        try {
            SFeatureCls sFeatureCls = (SFeatureCls)getObjFromList(sFeatureClsId);
            long lVal = sFeatureCls.setSrID(newVal);
            promise.resolve(lVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getScaleX(String sFeatureClsId, Promise promise)
    {
        try {
            SFeatureCls sFeatureCls = (SFeatureCls)getObjFromList(sFeatureClsId);
            double dScaleX = sFeatureCls.getScaleX();
            promise.resolve(dScaleX);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getScaleY(String sFeatureClsId, Promise promise)
    {
        try {
            SFeatureCls sFeatureCls = (SFeatureCls)getObjFromList(sFeatureClsId);
            double dScaleY = sFeatureCls.getScaleY();
            promise.resolve(dScaleY);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setScaleXY(String sFeatureClsId, double scaleX, double scaleY, Promise promise)
    {
        try {
            SFeatureCls sFeatureCls = (SFeatureCls)getObjFromList(sFeatureClsId);
            long lVal = sFeatureCls.setScaleXY(scaleX, scaleY);
            promise.resolve(lVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void delete(String sFeatureClsId, long objID, Promise promise)
    {
        try {
            SFeatureCls sFeatureCls = (SFeatureCls)getObjFromList(sFeatureClsId);
            long lVal = sFeatureCls.delete(objID);
            promise.resolve(lVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void delete(String sFeatureClsId, ReadableArray objIDArray, Promise promise)
    {
        try {
            long[]      objIDs = null;
            int         size = 0;
            long        lVal = 0;

            SFeatureCls sFeatureCls = (SFeatureCls)getObjFromList(sFeatureClsId);
            if (objIDArray != null) {
                size = objIDArray.size();
                if(size > 0)
                {
                    objIDs = new long[size];
                    for (int i = 0; i < objIDArray.size(); i++) {
                        objIDs[i] = objIDArray.getInt(i);
                    }
                    lVal = sFeatureCls.delete(objIDs);
                }
            }
            promise.resolve(lVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void update(String sFeatureClsId, long objID, String geomId, String rcdId, String infoId, Promise promise)
    {
        try {
            SFeatureCls sFeatureCls = (SFeatureCls)getObjFromList(sFeatureClsId);
            Geometry geom = JSGeometry.getObjFromList(geomId);
            Record rcd = JSRecord.getObjFromList(rcdId);
            GeomInfo info = JSGeomInfo.getObjFromList(infoId);
            long lVal = sFeatureCls.update(objID, geom, rcd, info);
            promise.resolve(lVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void updateAtt(String sFeatureClsId, long objID, String rcdId, Promise promise)
    {
        try {
            SFeatureCls sFeatureCls = (SFeatureCls)getObjFromList(sFeatureClsId);
            Record rcd = JSRecord.getObjFromList(rcdId);
            long lVal = sFeatureCls.updateAtt(objID, rcd);
            promise.resolve(lVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void updateGeometry(String sFeatureClsId, long objID, String geomId, Promise promise)
    {
        try {
            SFeatureCls sFeatureCls = (SFeatureCls)getObjFromList(sFeatureClsId);
            Geometry geom = JSGeometry.getObjFromList(geomId);
            long lVal = sFeatureCls.updateGeometry(objID, geom);
            promise.resolve(lVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void updateInfo(String sFeatureClsId, long objID, String infoId, Promise promise)
    {
        try {
            SFeatureCls sFeatureCls = (SFeatureCls)getObjFromList(sFeatureClsId);
            GeomInfo info = JSGeomInfo.getObjFromList(infoId);
            long lVal = sFeatureCls.updateInfo(objID, info);
            promise.resolve(lVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void remove(String sFeatureClsId, String dbId, String clsName, Promise promise)
    {
        try {
            SFeatureCls sFeatureCls = (SFeatureCls)getObjFromList(sFeatureClsId);
            DataBase db = JSDataBase.getObjFromList(dbId);
            long lVal = sFeatureCls.remove(db, clsName);
            promise.resolve(lVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void remove(String sFeatureClsId, String dbId, int clsID, Promise promise)
    {
        try {
            SFeatureCls sFeatureCls = (SFeatureCls)getObjFromList(sFeatureClsId);
            DataBase db = JSDataBase.getObjFromList(dbId);
            long lVal = sFeatureCls.remove(db, clsID);
            promise.resolve(lVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void calTotalArea(String sFeatureClsId, boolean bRealArea, Promise promise)
    {
        try {
            SFeatureCls sFeatureCls = (SFeatureCls)getObjFromList(sFeatureClsId);
            double dVal = sFeatureCls.calTotalArea(bRealArea);
            promise.resolve(dVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void calTotalLength(String sFeatureClsId, boolean bRealLen, Promise promise)
    {
        try {
            SFeatureCls sFeatureCls = (SFeatureCls)getObjFromList(sFeatureClsId);
            sFeatureCls.calTotalLength(bRealLen);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void areaToField(String sFeatureClsId, boolean bRealArea, short fldIndex, Promise promise)
    {
        try {
            SFeatureCls sFeatureCls = (SFeatureCls)getObjFromList(sFeatureClsId);
            int lVal = sFeatureCls.areaToField(bRealArea, fldIndex);
            promise.resolve(lVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void lengthToField(String sFeatureClsId, boolean bRealLen, short fldIndex, Promise promise)
    {
        try {
            SFeatureCls sFeatureCls = (SFeatureCls)getObjFromList(sFeatureClsId);
            int lVal = sFeatureCls.lengthToField(bRealLen, fldIndex);
            promise.resolve(lVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

   @ReactMethod
    public void registerSyncEnabled(String sFeatureClsId, Promise promise)
    {
        try {
            SFeatureCls sFeatureCls = (SFeatureCls)getObjFromList(sFeatureClsId);
            long lVal = sFeatureCls.registerSyncEnabled();
            promise.resolve(lVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void isSyncEnabled(String sFeatureClsId, Promise promise)
    {
        try {
            SFeatureCls sFeatureCls = (SFeatureCls)getObjFromList(sFeatureClsId);
            boolean isSyncEnabled = sFeatureCls.isSyncEnabled();
            promise.resolve(isSyncEnabled);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void updateFields(String sFeatureClsId, String fieldsId, Promise promise) {
        try {
            SFeatureCls sFeatureCls = (SFeatureCls)getObjFromList(sFeatureClsId);
            Fields fields = JSFields.getObjFromList(fieldsId);
            long lVal = sFeatureCls.updateFields(fields);
            promise.resolve(lVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }
}
