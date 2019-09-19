package com.zondy.mapgis.mobile.react;

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
    public void getFldVal(String recordId, short fldIndex, Promise promise)
    {
        try {
            Record record = getObjFromList(recordId);
            Object fldVal = record.getFldVal(fldIndex);
            WritableMap map = Arguments.createMap();
            map.putString("value", fldVal.toString());
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

   @ReactMethod
    public void getFldVal(String recordId, String fldName, Promise promise)
    {
        try {
            Record record = getObjFromList(recordId);
            Object val = record.getFldVal(fldName);
            WritableMap map = Arguments.createMap();
            map.putString("value",val.toString());
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
    public void setFldFromStr(String recordId, short fldIndex, String newVal, Promise promise)
    {
        try {
            Record record = getObjFromList(recordId);
            int iVal = record.setFldFromStr(fldIndex, newVal);
            promise.resolve(iVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setFldFromStr(String recordId, String fldName, String newVal, Promise promise)
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
    public void isFldNULL(String recordId, short fldIndex, Promise promise)
    {
        try {
            Record record = getObjFromList(recordId);
            int iVal = record.isFldNULL(fldIndex);
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
    public void setFldNULL(String recordId, short fldIndex, Promise promise)
    {
        try {
            Record record = getObjFromList(recordId);
            int iVal = record.setFldNULL(fldIndex);
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
    public void getFieldType(String recordId, short fldIndex, Promise promise)
    {
        try {
            Record record = getObjFromList(recordId);
            FieldType fieldType = record.getFieldType(fldIndex);
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
