package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.core.attr.ExtField;
import com.zondy.mapgis.core.attr.FieldShape;
import com.zondy.mapgis.core.attr.FieldType;
import com.zondy.mapgis.core.object.Enumeration;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class JSExtField extends ReactContextBaseJavaModule {
    public static final String REACT_CLASS = "JSExtField";
    public static Map<String, ExtField> mExtFieldList = new HashMap<String, ExtField>();

    public JSExtField(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public static ExtField getObjFromList(String id) {
        return mExtFieldList.get(id);
    }

    public static String registerId(ExtField obj) {
        for (Map.Entry entry : mExtFieldList.entrySet()) {
            if (obj.equals(entry.getValue())) {
                return (String) entry.getKey();
            }
        }
        Calendar calendar = Calendar.getInstance();
        String id = Long.toString(calendar.getTimeInMillis());
        mExtFieldList.put(id, obj);
        return id;
    }

    @ReactMethod
    public void createObj(int fieldType, short shapeInfoNum, Promise promise) {
        try {
            FieldType type = (FieldType) Enumeration.parse(FieldType.class, fieldType);
            ExtField extField = new ExtField(type, shapeInfoNum);
            String extFieldId = registerId(extField);
            WritableMap map = Arguments.createMap();
            map.putString("ExtFieldId", extFieldId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

   @ReactMethod
    public void getAlias(String extFieldId, Promise promise)
    {
        try {
            ExtField extField = getObjFromList(extFieldId);
            String alias = extField.getAlias();
            promise.resolve(alias);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setAlias(String extFieldId, String alias, Promise promise)
    {
        try {
            ExtField extField = getObjFromList(extFieldId);
            extField.setAlias(alias);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getIsNull(String extFieldId, Promise promise)
    {
        try {
            ExtField extField = getObjFromList(extFieldId);
            boolean isNull = extField.getIsNull();
            promise.resolve(isNull);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

   @ReactMethod
    public void setIsNull(String extFieldId, boolean value, Promise promise)
    {
        try {
            ExtField extField = getObjFromList(extFieldId);
            extField.setIsNull(value);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getDmnID(String extFieldId, Promise promise)
    {
        try {
            ExtField extField = getObjFromList(extFieldId);
            int dmnID = extField.getDmnID();
            promise.resolve(dmnID);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setDmnID(String extFieldId, int value, Promise promise)
    {
        try {
            ExtField extField = getObjFromList(extFieldId);
            extField.setDmnID(value);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getShape(String extFieldId, Promise promise)
    {
        try {
            ExtField extField = getObjFromList(extFieldId);
            FieldShape fieldShape = extField.getShape();
            int shape = Enumeration.getValueByName(FieldShape.class, fieldShape.name());
            promise.resolve(shape);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setShape(String extFieldId, int fieldShape, Promise promise)
    {
        try {
            ExtField extField = getObjFromList(extFieldId);
            FieldShape shape = (FieldShape) Enumeration.parse(FieldShape.class, fieldShape);
            extField.setShape(shape);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

   @ReactMethod
    public void getShapeInfoNum(String extFieldId, Promise promise)
    {
        try {
            ExtField extField = getObjFromList(extFieldId);
            short iNum = extField.getShapeInfoNum();
            promise.resolve(iNum);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getFieldType(String extFieldId, Promise promise)
    {
        try {
            ExtField extField = getObjFromList(extFieldId);
            FieldType fieldType = extField.getFieldType();
            int type = Enumeration.getValueByName(FieldType.class, fieldType.name());
            promise.resolve(type);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void hasDefVal(String extFieldId, Promise promise)
    {
        try {
            ExtField extField = getObjFromList(extFieldId);
            int iDefVal = extField.hasDefVal();
            promise.resolve(iDefVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void hasMaxVal(String extFieldId, Promise promise)
    {
        try {
            ExtField extField = getObjFromList(extFieldId);
            int iMaxVal = extField.hasMaxVal();
            promise.resolve(iMaxVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void hasMinVal(String extFieldId, Promise promise)
    {
        try {
            ExtField extField = getObjFromList(extFieldId);
            int iMinVal = extField.hasMinVal();
            promise.resolve(iMinVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }
}
