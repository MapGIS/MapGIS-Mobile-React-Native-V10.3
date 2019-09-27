package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.core.attr.ExtField;
import com.zondy.mapgis.core.attr.Field;
import com.zondy.mapgis.core.attr.FieldType;
import com.zondy.mapgis.core.attr.Fields;
import com.zondy.mapgis.core.geometry.DistanceType;
import com.zondy.mapgis.core.object.Enumeration;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class JSField extends ReactContextBaseJavaModule {
    public static final String REACT_CLASS = "JSField";
    public static Map<String, Field> mFieldList = new HashMap<String, Field>();

    public JSField(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public static Field getObjFromList(String id) {
        return mFieldList.get(id);
    }

    public static String registerId(Field obj) {
        for (Map.Entry entry : mFieldList.entrySet()) {
            if (obj.equals(entry.getValue())) {
                return (String) entry.getKey();
            }
        }
        Calendar calendar = Calendar.getInstance();
        String id = Long.toString(calendar.getTimeInMillis());
        mFieldList.put(id, obj);
        return id;
    }

    @ReactMethod
    public void createObj(Promise promise) {
        try {
            Field field = new Field();
            String fieldId = registerId(field);
            WritableMap map = Arguments.createMap();
            map.putString("FieldId", fieldId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }
   @ReactMethod
    public void getFieldName(String fieldId, Promise promise)
    {
        try {
            Field field = getObjFromList(fieldId);
            String  fieldName = field.getFieldName();
            promise.resolve(fieldName);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setFieldName(String fieldId, String name, Promise promise)
    {
        try {
            Field field = getObjFromList(fieldId);
            field.setFieldName(name);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getFieldType(String fieldId, Promise promise)
    {
        try {
            Field field = getObjFromList(fieldId);
            FieldType fieldType = field.getFieldType();
            int type = Enumeration.getValueByName(FieldType.class, fieldType.name());
            promise.resolve(type);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setFieldType(String fieldId, int fieldType, Promise promise)
    {
        try {
            Field field = getObjFromList(fieldId);
            FieldType type = (FieldType) Enumeration.parse(FieldType.class, fieldType);
            field.setFieldType(type);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getFieldOffset(String fieldId, Promise promise)
    {
        try {
            Field field = getObjFromList(fieldId);
            int offSet = field.getFieldOffset();
            promise.resolve(offSet);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

   @ReactMethod
    public void setFieldOffset(String fieldId, int offset, Promise promise)
    {
        try {
            Field field = getObjFromList(fieldId);
            field.setFieldOffset(offset);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

   @ReactMethod
    public void getFieldLength(String fieldId, Promise promise)
    {
        try {
            Field field = getObjFromList(fieldId);
            int fieldLength = field.getFieldLength();
            promise.resolve(fieldLength);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

   @ReactMethod
    public void setFieldLength(String fieldId, int length, Promise promise)
    {
        try {
            Field field = getObjFromList(fieldId);
            field.setFieldLength((short)length);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getMskLength(String fieldId, Promise promise)
    {
        try {
            Field field = getObjFromList(fieldId);
            int mskLength = field.getMskLength();
            promise.resolve(mskLength);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setMskLength(String fieldId, int length, Promise promise)
    {
        try {
            Field field = getObjFromList(fieldId);
            field.setMskLength((short)length);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getPointLength(String fieldId, Promise promise)
    {
        try {
            Field field = getObjFromList(fieldId);
            int pointLength = field.getPointLength();
            promise.resolve(pointLength);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setPointLength(String fieldId, int length, Promise promise)
    {
        try {
            Field field = getObjFromList(fieldId);
            field.setPointLength((short)length);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getEditable(String fieldId, Promise promise)
    {
        try {
            Field field = getObjFromList(fieldId);
            int editable = field.getEditable();
            promise.resolve(editable);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setEditable(String fieldId, int value, Promise promise)
    {
        try {
            Field field = getObjFromList(fieldId);
            field.setEditable((short)value);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

   @ReactMethod
    public void getPtFlag(String fieldId, Promise promise)
    {
        try {
            Field field = getObjFromList(fieldId);
            int ptFlag = field.getPtFlag();
            promise.resolve(ptFlag);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

   @ReactMethod
    public void setPtFlag(String fieldId, int flag, Promise promise)
    {
        try {
            Field field = getObjFromList(fieldId);
            field.setPtFlag((short)flag);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

   @ReactMethod
    public void getPtcPosition(String fieldId, Promise promise)
    {
        try {
            Field field = getObjFromList(fieldId);
            int ptcPosition = field.getPtcPosition();
            promise.resolve(ptcPosition);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setPtcPosition(String fieldId, int position, Promise promise)
    {
        try {
            Field field = getObjFromList(fieldId);
            field.setPtcPosition((short)position);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void CalculateSize(String fieldId, Promise promise)
    {
        try {
            Field field = getObjFromList(fieldId);
            int iSize = field.CalculateSize();
            promise.resolve(iSize);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getExtField(String fieldId, Promise promise)
    {
        try {
            Field field = getObjFromList(fieldId);
            ExtField extField = field.getExtField();
            String    extFieldId = JSExtField.registerId(extField);
            WritableMap map = Arguments.createMap();
            map.putString("ExtFieldId", extFieldId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setExtField(String fieldId, String fieldExId, Promise promise)
    {
        try {
            Field field = getObjFromList(fieldId);
            ExtField fieldEx = JSExtField.getObjFromList(fieldExId);
            field.setExtField(fieldEx);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void hasExtField(String fieldId, Promise promise)
    {
        try {
            Field field = getObjFromList(fieldId);
            int hasExtField = field.hasExtField();
            promise.resolve(hasExtField);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void deleteExtField(String fieldId, Promise promise)
    {
        try {
            Field field = getObjFromList(fieldId);
            int deleteExtField = field.deleteExtField();
            promise.resolve(deleteExtField);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    public void  clone(String fieldId, Promise promise)
    {
        try {
            Field field = getObjFromList(fieldId);
            Field barkField = field.clone();
            String barkFieldId = JSField.registerId(barkField);
            WritableMap map = Arguments.createMap();
            map.putString("FieldId", barkFieldId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }
}
