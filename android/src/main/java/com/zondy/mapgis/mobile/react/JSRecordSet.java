package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.core.attr.Fields;
import com.zondy.mapgis.core.attr.Record;
import com.zondy.mapgis.core.geodatabase.RecordSet;
import com.zondy.mapgis.core.geometry.Geometry;
import com.zondy.mapgis.core.geometry.GeometryType;
import com.zondy.mapgis.core.geometry.Rect;
import com.zondy.mapgis.core.info.GeomInfo;
import com.zondy.mapgis.core.object.Enumeration;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class JSRecordSet extends ReactContextBaseJavaModule {
    public static final String REACT_CLASS = "JSRecordSet";
    public static Map<String, RecordSet> mRecordSetList = new HashMap<String, RecordSet>();

    public JSRecordSet(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public static RecordSet getObjFromList(String id) {
        return mRecordSetList.get(id);
    }


    public static String registerId(RecordSet obj) {
        for (Map.Entry entry : mRecordSetList.entrySet()) {
            if (obj.equals(entry.getValue())) {
                return (String) entry.getKey();
            }
        }
        Calendar calendar = Calendar.getInstance();
        String id = Long.toString(calendar.getTimeInMillis());
        mRecordSetList.put(id, obj);
        return id;
    }

    @ReactMethod
    public void createObj(Promise promise) {
        try {
            RecordSet recordSet = new RecordSet();
            String recordSetId = registerId(recordSet);

            WritableMap map = Arguments.createMap();
            map.putString("RecordSetId", recordSetId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void moveFirst(String recordSetId, Promise promise)
    {
        try {
            RecordSet recordSet = getObjFromList(recordSetId);
            int  iFirst = recordSet.moveFirst();
            promise.resolve(iFirst);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void moveNext(String recordSetId, Promise promise)
    {
        try {
            RecordSet recordSet = getObjFromList(recordSetId);
            int  iNext = recordSet.moveNext();
            promise.resolve(iNext);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getAtt(String recordSetId, Promise promise)
    {
        try {
            RecordSet recordSet = getObjFromList(recordSetId);
            Record rc = recordSet.getAtt();
            String rcId = JSRecord.registerId(rc);
            WritableMap map = Arguments.createMap();
            map.putString("RecordId", rcId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getCurrentID(String recordSetId, Promise promise)
    {
        try {
            RecordSet recordSet = getObjFromList(recordSetId);
            long  iCurrentID = recordSet.getCurrentID();
            promise.resolve(iCurrentID);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getFields(String recordSetId, Promise promise)
    {
        try {
            RecordSet recordSet = getObjFromList(recordSetId);
            Fields fields = recordSet.getFields();
            String fieldsId = JSFields.registerId(fields);
            WritableMap map = Arguments.createMap();
            map.putString("FieldsId", fieldsId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getGeometry(String recordSetId, Promise promise)
    {
        try {
            RecordSet recordSet = getObjFromList(recordSetId);
            Geometry geometry = recordSet.getGeometry();
            String geometryId = JSGeometry.registerId(geometry);
            WritableMap map = Arguments.createMap();
            map.putString("GeometryId", geometryId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getInfo(String recordSetId, Promise promise)
    {
        try {
            RecordSet recordSet = getObjFromList(recordSetId);
            GeomInfo info = recordSet.getInfo();
            String infoId = JSGeomInfo.registerId(info);
            WritableMap map = Arguments.createMap();
            map.putString("GeomInfoId", infoId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void isBOF(String recordSetId, Promise promise)
    {
        try {
            RecordSet recordSet = getObjFromList(recordSetId);
            boolean isBOF = recordSet.isBOF();
            promise.resolve(isBOF);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void isEOF(String recordSetId, Promise promise)
    {
        try {
            RecordSet recordSet = getObjFromList(recordSetId);
            boolean  isEOF = recordSet.isEOF();
            promise.resolve(isEOF);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    public void getRect(String recordSetId, String rectId, Promise promise)
    {
        try {
            RecordSet recordSet = getObjFromList(recordSetId);
            Rect rc = JSRect.getObjFromList(rectId);
            recordSet.getRect(rc);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void get(String recordSetId, String geomId, String rcdId, String infoId, Promise promise)
    {
        try {
            RecordSet recordSet = getObjFromList(recordSetId);
            Geometry geom = JSGeometry.getObjFromList(geomId);
            Record rcd = JSRecord.getObjFromList(rcdId);
            GeomInfo info = JSGeomInfo.getObjFromList(infoId);
            int  iVal = recordSet.get(geom, rcd, info);
            promise.resolve(iVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

   @ReactMethod
    public void getGeometryType(String recordSetId, Promise promise)
    {
        try {
            RecordSet recordSet = getObjFromList(recordSetId);
            GeometryType geometryType = recordSet.getGeometryType();
            int type = Enumeration.getValueByName(GeometryType.class, geometryType.name());
            promise.resolve(type);
        } catch (Exception e) {
            promise.reject(e);
        }
    }
}
