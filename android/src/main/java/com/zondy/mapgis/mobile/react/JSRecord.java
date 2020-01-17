package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.core.attr.FieldType;
import com.zondy.mapgis.core.attr.Fields;
import com.zondy.mapgis.core.attr.Record;
import com.zondy.mapgis.core.object.Enumeration;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class JSRecord extends ReactContextBaseJavaModule {
    private static final String REACT_CLASS = "JSRecord";
    private static Map<String, Record> mRecordList = new HashMap<String, Record>();

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
        String id = UUID.randomUUID().toString().substring(24);
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
    public void setFldValByIndex(String recordId, int recordIndex, ReadableMap newValinfo, Promise promise)
    {
        try {
            Record record = getObjFromList(recordId);
            int result = 0;

            Object value = null;
            FieldType fieldType = record.getFieldType((short) recordIndex);
            if(fieldType != null){
                int fieldTypeValue = fieldType.value();
                value = getValueFromMap(fieldTypeValue, newValinfo);

           }

            if (value == null) {
                result = record.setFldNULL((short)recordIndex);
            } else {
                result = record.setFldVal((short) recordIndex, value);
            }

            promise.resolve(result);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setFldValByName(String recordId, String recordName, ReadableMap newValinfo, Promise promise)
    {
        try {
            Record record = getObjFromList(recordId);
            int result = 0;

            Object value = null;
            FieldType fieldType = record.getFieldType(recordName);
            if(fieldType != null){
                int fieldTypeValue = fieldType.value();
                value = getValueFromMap(fieldTypeValue, newValinfo);
            }

            if (value == null) {
                result = record.setFldNULL(recordName);
            } else {
                result = record.setFldVal(recordName, value);
            }
            promise.resolve(result);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    // 从ReadableMap获取value
    private Object getValueFromMap(int fieldTypeValue, ReadableMap newValinfo){
        Object value = null;
        Calendar calendar = Calendar.getInstance();

        // Double、Float、Long、Int64(对于java的long)、short
        if(fieldTypeValue == FieldType.fldDouble.value() || fieldTypeValue == FieldType.fldFloat.value() || fieldTypeValue == FieldType.fldLong.value() || fieldTypeValue == FieldType.fldInt64.value()
                || fieldTypeValue == FieldType.fldShort.value())
        {

            double doubleValue = newValinfo.getDouble("value");

            if(fieldTypeValue == FieldType.fldFloat.value()) // float
            {
                value = (float) doubleValue;
            }else if (fieldTypeValue == FieldType.fldLong.value() || fieldTypeValue == FieldType.fldInt64.value()){ //long
                value = (long) doubleValue;

            }else if(fieldTypeValue == FieldType.fldShort.value() ){ // short
                value = (short) doubleValue;
            }
        }

        //  TimeStamp、fldDate、fldTime
        if(fieldTypeValue == FieldType.fldTimeStamp.value() || fieldTypeValue == FieldType.fldDate.value() || fieldTypeValue == FieldType.fldTime.value() ){
            long time = 0;
            if(fieldTypeValue == FieldType.fldTimeStamp.value()){
                time = (long) newValinfo.getDouble("value");
            }else{
                String timeValue = newValinfo.getString("value");
                time = Long.parseLong(timeValue);
            }
            calendar.setTimeInMillis(time);
            value = calendar;
        }

        // str
        if (fieldTypeValue == FieldType.fldStr.value() ){
            value = newValinfo.getString("value");
        }

        return value;
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
    public void isFldNULLOfFldIndex(String recordId, int fldIndex, Promise promise)
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
    public void isFldNULLOfFldName(String recordId, String fldName, Promise promise)
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
    public void setFldNULLByIndex(String recordId, int fldIndex, Promise promise)
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
    public void setFldNULLByName(String recordId, String fldName, Promise promise)
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
    public void getFieldTypeByIndex(String recordId, int fldIndex, Promise promise)
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
    public void getFieldTypeByName(String recordId, String fldName, Promise promise)
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
