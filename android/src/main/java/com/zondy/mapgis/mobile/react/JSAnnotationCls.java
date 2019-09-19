package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.core.attr.Fields;
import com.zondy.mapgis.core.attr.Record;
import com.zondy.mapgis.core.geodatabase.AnnotationCls;
import com.zondy.mapgis.core.geodatabase.DataBase;
import com.zondy.mapgis.core.geodatabase.IXClsInfo;
import com.zondy.mapgis.core.geodatabase.QueryDef;
import com.zondy.mapgis.core.geodatabase.RecordSet;
import com.zondy.mapgis.core.geodatabase.XClsType;
import com.zondy.mapgis.core.geometry.AnnType;
import com.zondy.mapgis.core.geometry.Geometry;
import com.zondy.mapgis.core.geometry.Rect;
import com.zondy.mapgis.core.info.GeomInfo;
import com.zondy.mapgis.core.object.Enumeration;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class JSAnnotationCls extends JSVectorCls {
    public static final String REACT_CLASS = "JSAnnotationCls";

    public JSAnnotationCls(ReactApplicationContext reactContext) {
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
            AnnotationCls annotationCls= new AnnotationCls(dataBase);
            String annotationClsId = registerId(annotationCls);
            WritableMap map = Arguments.createMap();
            map.putString("AnnotationClsId", annotationClsId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void create(String annotationClsId, String name, int annType, int dsID, int srID, String fldsId, Promise promise)
    {
        try {
            AnnotationCls annotationCls = (AnnotationCls)getObjFromList(annotationClsId);
            AnnType type = (AnnType) Enumeration.parse(AnnType.class, annType);
            Fields flds = JSFields.getObjFromList(fldsId);
            int id = annotationCls.create(name, type, dsID, srID, flds);
            promise.resolve(id);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void open(String annotationClsId, int id, Promise promise)
    {
        try {
            AnnotationCls annotationCls = (AnnotationCls)getObjFromList(annotationClsId);
            long lVal = annotationCls.open(id);
            promise.resolve(lVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

   @ReactMethod
    public void open(String annotationClsId, String name, Promise promise)
    {
        try {
            AnnotationCls annotationCls = (AnnotationCls)getObjFromList(annotationClsId);
            long lVal = annotationCls.open(name);
            promise.resolve(lVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void hasOpen(String annotationClsId, Promise promise)
    {
        try {
            AnnotationCls annotationCls = (AnnotationCls)getObjFromList(annotationClsId);
            boolean isOpen = annotationCls.hasOpen();
            promise.resolve(isOpen);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

   @ReactMethod
    public void clear(String annotationClsId, Promise promise)
    {
        try {
            AnnotationCls annotationCls = (AnnotationCls)getObjFromList(annotationClsId);
            long lVal = annotationCls.clear();
            promise.resolve(lVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void close(String annotationClsId, Promise promise)
    {
        try {
            AnnotationCls annotationCls = (AnnotationCls)getObjFromList(annotationClsId);
            long lVal = annotationCls.close();
            promise.resolve(lVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getGDataBase(String annotationClsId, Promise promise)
    {
        try {
            AnnotationCls annotationCls = (AnnotationCls)getObjFromList(annotationClsId);
            DataBase dataBase = annotationCls.getGDataBase();
            String dataBaseId = JSDataBase.registerId(dataBase);
            WritableMap map = Arguments.createMap();
            map.putString("DataBaseId", dataBaseId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getCount(String annotationClsId, Promise promise)
    {
        try {
            AnnotationCls annotationCls = (AnnotationCls)getObjFromList(annotationClsId);
            long lCount = annotationCls.getCount();
            promise.resolve(lCount);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getRange(String annotationClsId, Promise promise)
    {
        try {
            AnnotationCls annotationCls = (AnnotationCls)getObjFromList(annotationClsId);
            Rect rect = annotationCls.getRange();
            String rectId = JSRect.registerId(rect);
            WritableMap map = Arguments.createMap();
            map.putString("RectId", rectId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

   @ReactMethod
    public void getClsType(String annotationClsId, Promise promise)
    {
        try {
            AnnotationCls annotationCls = (AnnotationCls)getObjFromList(annotationClsId);
            XClsType xClsType = annotationCls.getClsType();
            int type = Enumeration.getValueByName(XClsType.class, xClsType.name());
            promise.resolve(type);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

  @ReactMethod
    public void getClsID(String annotationClsId, Promise promise)
    {
        try {
            AnnotationCls annotationCls = (AnnotationCls)getObjFromList(annotationClsId);
            int clsID = annotationCls.getClsID();
            promise.resolve(clsID);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getClsInfo(String annotationClsId, Promise promise)
    {
        try {
            AnnotationCls annotationCls = (AnnotationCls)getObjFromList(annotationClsId);
            IXClsInfo ixClsInfo = annotationCls.getClsInfo();
            String xClsInfoId = JSXClsInfo.registerId(ixClsInfo);
            WritableMap map = Arguments.createMap();
            map.putString("XClsInfoId", xClsInfoId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getFields(String annotationClsId, Promise promise)
    {
        try {
            AnnotationCls annotationCls = (AnnotationCls)getObjFromList(annotationClsId);
            Fields fields = annotationCls.getFields();
            String fieldsId = JSFields.registerId(fields);
            WritableMap map = Arguments.createMap();
            map.putString("FieldsId", fieldsId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void append(String annotationClsId, String geomId, String rcdId, String infoId, Promise promise) {
        try {
            AnnotationCls annotationCls = (AnnotationCls)getObjFromList(annotationClsId);
            Geometry geom = JSGeometry.getObjFromList(geomId);
            Record rcd = JSRecord.getObjFromList(rcdId);
            GeomInfo info = JSGeomInfo.getObjFromList(infoId);
            long lVal = annotationCls.append(geom, rcd, info);
            promise.resolve(lVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

   @ReactMethod
    public void select(String annotationClsId, String queryDefId, Promise promise)
    {
        try {
            AnnotationCls annotationCls = (AnnotationCls)getObjFromList(annotationClsId);
            QueryDef def = JSQueryDef.getObjFromList(queryDefId);
            RecordSet recordSet = annotationCls.select(def);
            String recordSetId = JSRecordSet.registerId(recordSet);
            WritableMap map = Arguments.createMap();
            map.putString("RecordSetId", recordSetId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getRect(String annotationClsId, long objID, Promise promise) {
        try {
            AnnotationCls annotationCls = (AnnotationCls)getObjFromList(annotationClsId);
            Rect rect = annotationCls.getRect(objID);
            String rectId = JSRect.registerId(rect);
            WritableMap map = Arguments.createMap();
            map.putString("RectId", rectId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void get(String annotationClsId, long objID, String geomId, String rcdId, String infoId, Promise promise) {
        try {
            AnnotationCls annotationCls = (AnnotationCls)getObjFromList(annotationClsId);
            Geometry geom = JSGeometry.getObjFromList(geomId);
            Record rcd = JSRecord.getObjFromList(rcdId);
            GeomInfo info = JSGeomInfo.getObjFromList(infoId);
            long lVal = annotationCls.get(objID, geom, rcd, info);
            promise.resolve(lVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getAtt(String annotationClsId, long objID, Promise promise)
    {
        try {
            AnnotationCls annotationCls = (AnnotationCls)getObjFromList(annotationClsId);
            Record rcd = annotationCls.getAtt(objID);
            String rcdId = JSRecord.registerId(rcd);
            WritableMap map = Arguments.createMap();
            map.putString("RecordId", rcdId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getGeometry(String annotationClsId, long objID, Promise promise) {
        try {
            AnnotationCls annotationCls = (AnnotationCls)getObjFromList(annotationClsId);
            Geometry geom = annotationCls.getGeometry(objID);
            String geomId = JSGeometry.registerId(geom);
            WritableMap map = Arguments.createMap();
            map.putString("GeometryId", geomId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getInfo(String annotationClsId, long objID, Promise promise) {
        try {
            AnnotationCls annotationCls = (AnnotationCls)getObjFromList(annotationClsId);
            GeomInfo info = annotationCls.getInfo(objID);
            String infoId = JSGeomInfo.registerId(info);
            WritableMap map = Arguments.createMap();
            map.putString("GeomInfoId", infoId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getAnnType(String annotationClsId, long objID, Promise promise)
    {
        try {
            AnnotationCls annotationCls = (AnnotationCls)getObjFromList(annotationClsId);
            AnnType annType = annotationCls.getAnnType(objID);
            int type = Enumeration.getValueByName(AnnType.class, annType.name());
            promise.resolve(type);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getClsName(String annotationClsId, Promise promise)
    {
        try {
            AnnotationCls annotationCls = (AnnotationCls)getObjFromList(annotationClsId);
            String clsName = annotationCls.getClsName();
            promise.resolve(clsName);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setClsName(String annotationClsId, String newVal, Promise promise)
    {
        try {
            AnnotationCls annotationCls = (AnnotationCls)getObjFromList(annotationClsId);
            annotationCls.setClsName(newVal);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getURL(String annotationClsId, Promise promise)
    {
        try {
            AnnotationCls annotationCls = (AnnotationCls)getObjFromList(annotationClsId);
            String strUrl = annotationCls.getURL();
            promise.resolve(strUrl);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getAliasName(String annotationClsId, Promise promise)
    {
        try {
            AnnotationCls annotationCls = (AnnotationCls)getObjFromList(annotationClsId);
            String aliasName = annotationCls.getAliasName();
            promise.resolve(aliasName);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setAliasName(String annotationClsId, String newVal, Promise promise)
    {
        try {
            AnnotationCls annotationCls = (AnnotationCls)getObjFromList(annotationClsId);
            long lVal = annotationCls.setAliasName(newVal);
            promise.resolve(lVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getSrID(String annotationClsId, Promise promise)
    {
        try {
            AnnotationCls annotationCls = (AnnotationCls)getObjFromList(annotationClsId);
            int srID = annotationCls.getSrID();
            promise.resolve(srID);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setSrID(String annotationClsId, int newVal, Promise promise)
    {
        try {
            AnnotationCls annotationCls = (AnnotationCls)getObjFromList(annotationClsId);
            long lVal = annotationCls.setSrID(newVal);
            promise.resolve(lVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getDsID(String annotationClsId, Promise promise)
    {
        try {
            AnnotationCls annotationCls = (AnnotationCls)getObjFromList(annotationClsId);
            int dsID = annotationCls.getDsID();
            promise.resolve(dsID);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getScaleX(String annotationClsId, Promise promise)
    {
        try {
            AnnotationCls annotationCls = (AnnotationCls)getObjFromList(annotationClsId);
            double dScaleX = annotationCls.getScaleX();
            promise.resolve(dScaleX);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getScaleY(String annotationClsId, Promise promise)
    {
        try {
            AnnotationCls annotationCls = (AnnotationCls)getObjFromList(annotationClsId);
            double dScaleY = annotationCls.getScaleY();
            promise.resolve(dScaleY);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setScaleXY(String annotationClsId, double scaleX, double scaleY, Promise promise) {
        try {
            AnnotationCls annotationCls = (AnnotationCls)getObjFromList(annotationClsId);
            long lVal = annotationCls.setScaleXY(scaleX, scaleY);
            promise.resolve(lVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void delete(String annotationClsId, long objID, Promise promise)
    {
        try {
            AnnotationCls annotationCls = (AnnotationCls)getObjFromList(annotationClsId);
            long lVal = annotationCls.delete(objID);
            promise.resolve(lVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void delete(String annotationClsId, ReadableArray objIDArray, Promise promise)
    {
        try {
            long[]      objIDs = null;
            int         size = 0;
            long        lVal = 0;

            AnnotationCls annotationCls = (AnnotationCls)getObjFromList(annotationClsId);
            if (objIDArray != null) {
                size = objIDArray.size();
                if(size > 0)
                {
                    objIDs = new long[size];
                    for (int i = 0; i < objIDArray.size(); i++) {
                        objIDs[i] = objIDArray.getInt(i);
                    }
                    lVal = annotationCls.delete(objIDs);
                }
            }
            promise.resolve(lVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

   @ReactMethod
    public void update(String annotationClsId, long objID, String geomId, String rcdId, String infoId, Promise promise) {
        try {
            AnnotationCls annotationCls = (AnnotationCls)getObjFromList(annotationClsId);
            Geometry geom = JSGeometry.getObjFromList(geomId);
            Record rcd = JSRecord.getObjFromList(rcdId);
            GeomInfo info = JSGeomInfo.getObjFromList(infoId);
            long lVal = annotationCls.update(objID, geom, rcd, info);
            promise.resolve(lVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void updateAtt(String annotationClsId, long objID, String rcdId, Promise promise) {
        try {
            AnnotationCls annotationCls = (AnnotationCls)getObjFromList(annotationClsId);
            Record rcd = JSRecord.getObjFromList(rcdId);
            long lVal = annotationCls.updateAtt(objID, rcd);
            promise.resolve(lVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void updateGeometry(String annotationClsId, long objID, String geomId, Promise promise) {
        try {
            AnnotationCls annotationCls = (AnnotationCls)getObjFromList(annotationClsId);
            Geometry geom = JSGeometry.getObjFromList(geomId);
            long lVal = annotationCls.updateGeometry(objID, geom);
            promise.resolve(lVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void updateInfo(String annotationClsId, long objID, String infoId, Promise promise) {
        try {
            AnnotationCls annotationCls = (AnnotationCls)getObjFromList(annotationClsId);
            GeomInfo info = JSGeomInfo.getObjFromList(infoId);
            long lVal = annotationCls.updateInfo(objID, info);
            promise.resolve(lVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void annToField(String annotationClsId, short fldIndex, String whereClause, Promise promise)
    {
        try {
            AnnotationCls annotationCls = (AnnotationCls)getObjFromList(annotationClsId);
            long lVal = annotationCls.annToField(fldIndex, whereClause);
            promise.resolve(lVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void remove(String annotationClsId, String dbId, String clsName, Promise promise)
    {
        try {
            AnnotationCls annotationCls = (AnnotationCls)getObjFromList(annotationClsId);
            DataBase db = JSDataBase.getObjFromList(dbId);
            long lVal = annotationCls.remove(db, clsName);
            promise.resolve(lVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void remove(String annotationClsId, String dbId, int clsID, Promise promise)
    {
        try {
            AnnotationCls annotationCls = (AnnotationCls)getObjFromList(annotationClsId);
            DataBase db = JSDataBase.getObjFromList(dbId);
            long lVal = annotationCls.remove(db, clsID);
            promise.resolve(lVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void registerSyncEnabled(String annotationClsId, Promise promise)
    {
        try {
            AnnotationCls annotationCls = (AnnotationCls)getObjFromList(annotationClsId);
            long lVal = annotationCls.registerSyncEnabled();
            promise.resolve(lVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void isSyncEnabled(String annotationClsId, Promise promise)
    {
        try {
            AnnotationCls annotationCls = (AnnotationCls)getObjFromList(annotationClsId);
            boolean isSyncEnabled = annotationCls.isSyncEnabled();
            promise.resolve(isSyncEnabled);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void updateFields(String annotationClsId, String fieldsId, Promise promise) {

        try {
            AnnotationCls annotationCls = (AnnotationCls)getObjFromList(annotationClsId);
            Fields fields = JSFields.getObjFromList(fieldsId);
            long lVal = annotationCls.updateFields(fields);
            promise.resolve(lVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }
}
