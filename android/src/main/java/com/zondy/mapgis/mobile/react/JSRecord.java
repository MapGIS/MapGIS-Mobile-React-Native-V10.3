package com.zondy.mapgis.mobile.react;

import android.util.Log;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.ReadableNativeMap;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.core.attr.FieldType;
import com.zondy.mapgis.core.attr.Fields;
import com.zondy.mapgis.core.attr.Record;
import com.zondy.mapgis.core.object.Enumeration;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class JSRecord extends ReactContextBaseJavaModule {
    public static final String REACT_CLASS = "JSRecord";
    public static Map<String, Record> mRecordList = new HashMap<String, Record>();

    public JSRecord(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public static Record getObjFromList(String id) {
        return mRecordList.get(id);
    }

    public static String registerId(Record obj) {
        for (Map.Entry entry : mRecordList.entrySet()) {
            if (obj.equals(entry.getValue())) {
                return (String) entry.getKey();
            }
        }
        Calendar calendar = Calendar.getInstance();
        String id = Long.toString(calendar.getTimeInMillis());
        mRecordList.put(id, obj);
        return id;
    }

    @ReactMethod
    public void createObj(Promise promise) {
        try {
            Record record = new Record();
            String recordId = registerId(record);
            WritableMap map = Arguments.createMap();
            map.putString("RecordId", recordId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getFldValByIndex(String recordId, int fldIndex, Promise promise)
    {
        try {
            Record record = getObjFromList(recordId);
            Object fldVal = record.getFldVal((short)fldIndex);
            FieldType type = record.getFieldType((short)fldIndex);
            WritableMap map = Arguments.createMap();
            if (type.equals(FieldType.fldStr))
            {
                map.putString("value", (String) fldVal);
            }
            else  if(type.equals(FieldType.fldShort) || type.equals(FieldType.fldLong) || type.equals(FieldType.fldInt64))
            {
                map.putInt("value", (Integer) fldVal);
            }
            else  if(type.equals(FieldType.fldDouble) || type.equals(FieldType.fldFloat))
            {
                map.putDouble("value", (Double) fldVal);
            }
            else  if(type.equals(FieldType.fldBlob))
            {
                map.putBoolean("value", (Boolean) fldVal);
            }
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

   @ReactMethod
    public void getFldValByName(String recordId, String fldName, Promise promise)
    {
        try {
            Record record = getObjFromList(recordId);
            Object fldVal = record.getFldVal(fldName);
            FieldType type = record.getFieldType(fldName);
            WritableMap map = Arguments.createMap();
            if (type.equals(FieldType.fldStr))
            {
                map.putString("value", (String) fldVal);
            }
            else  if(type.equals(FieldType.fldShort) || type.equals(FieldType.fldLong) || type.equals(FieldType.fldInt64))
            {
                map.putInt("value", (Integer) fldVal);
            }
            else  if(type.equals(FieldType.fldDouble) || type.equals(FieldType.fldFloat))
            {
                 map.putDouble("value", (Double) fldVal);
            }
            else  if(type.equals(FieldType.fldBlob))
            {
                map.putBoolean("value", (Boolean) fldVal);
            }
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

   @ReactMethod
    public void setFldValByIndex(String recordId, ReadableMap newValinfo, Promise promise)
    {
        try {
            Record record = getObjFromList(recordId);
            int result = 0;
            ReadableMapKeySetIterator iter = newValinfo.keySetIterator();
            while (iter.hasNextKey()) {
                String index = iter.nextKey();
                String value = newValinfo.getString(index);
                if (value == null) {
                    result = record.setFldNULL(index);
                } else {
                    result = record.setFldVal(index, value);
                }
            }
            promise.resolve(result);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setFldValByName(String recordId, ReadableMap newValinfo, Promise promise)
    {
        try {
            Record record = getObjFromList(recordId);
            int result = 0;
            ReadableMapKeySetIterator iter = newValinfo.keySetIterator();
            while (iter.hasNextKey()) {
                String name = iter.nextKey();
                String value = newValinfo.getString(name);
                if (value == null) {
                    result = record.setFldNULL(name);
                } else {
                    result = record.setFldVal(name, value);
                }
            }
            promise.resolve(result);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setFldFromStrOfIndex(String recordId, int fldIndex, String newVal, Promise promise)
    {
        try {
            Record record = getObjFromList(recordId);
            int iVal = record.setFldFromStr((short)fldIndex, newVal);
            promise.resolve(iVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setFldFromStrOfName(String recordId, String fldName, String newVal, Promise promise)
    {
        try {
            Record record = getObjFromList(recordId);
            int iVal = record.setFldFromStr(fldName, newVal);
            promise.resolve(iVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void isFldNULL(String recordId, int fldIndex, Promise promise)
    {
        try {
            Record record = getObjFromList(recordId);
            int iVal = record.isFldNULL((short)fldIndex);
            promise.resolve(iVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void isFldNULL(String recordId, String fldName, Promise promise)
    {
        try {
            Record record = getObjFromList(recordId);
            int iVal = record.isFldNULL(fldName);
            promise.resolve(iVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setFldNULL(String recordId, int fldIndex, Promise promise)
    {
        try {
            Record record = getObjFromList(recordId);
            int iVal = record.setFldNULL((short)fldIndex);
            promise.resolve(iVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setFldNULL(String recordId, String fldName, Promise promise)
    {
        try {
            Record record = getObjFromList(recordId);
            int iVal = record.setFldNULL(fldName);
            promise.resolve(iVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setAllFldNULL(String recordId, Promise promise)
    {
        try {
            Record record = getObjFromList(recordId);
            int iVal = record.setAllFldNULL();
            promise.resolve(iVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getFieldType(String recordId, int fldIndex, Promise promise)
    {
        try {
            Record record = getObjFromList(recordId);
            FieldType fieldType = record.getFieldType((short)fldIndex);
            int type = Enumeration.getValueByName(FieldType.class, fieldType.name());
            promise.resolve(type);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getFieldType(String recordId, String fldName, Promise promise)
    {
        try {
            Record record = getObjFromList(recordId);
            FieldType fieldType = record.getFieldType(fldName);
            int type = Enumeration.getValueByName(FieldType.class, fieldType.name());
            promise.resolve(type);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getFields(String recordId, Promise promise)
    {
        try {
            Record record = getObjFromList(recordId);
            Fields fields = record.getFields();
            String  fieldsId = JSFields.registerId(fields);
            WritableMap map = Arguments.createMap();
            map.putString("FieldsId", fieldsId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setFields(String recordId, String fieldsId, Promise promise)
    {
        try {
            Record record = getObjFromList(recordId);
            Fields fields = JSFields.getObjFromList(fieldsId);
            int iVal = record.setFields(fields);
            promise.resolve(iVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void releaseBuffer(String recordId, Promise promise)
    {
        try {
            Record record = getObjFromList(recordId);
            record.releaseBuffer();
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }
}
