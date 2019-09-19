package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.core.map.AllOtherDataItemInfoSource;
import com.zondy.mapgis.core.map.ClassItemType;
import com.zondy.mapgis.core.map.ClassItemValue;
import com.zondy.mapgis.core.map.MultiClassTheme;
import com.zondy.mapgis.core.map.MultiClassThemeInfo;
import com.zondy.mapgis.core.map.ThemeInfo;
import com.zondy.mapgis.core.object.Enumeration;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * 多表达式分段专题图Native功能组件
 * Created by xiaoying on 2019/9/3.
 */
public class JSMultiClassTheme extends JSVectorTheme {
    private static final String REACT_CLASS = "JSMultiClassTheme";
    public static Map<String, MultiClassTheme> mMultiClassThemeList = new HashMap<>();

    public JSMultiClassTheme(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @ReactMethod
    public void createObj(Promise promise){
        try {
            MultiClassTheme multiClassTheme = new MultiClassTheme();
            String mutiClassThemeId = registerId(multiClassTheme);

            WritableMap writableMap = Arguments.createMap();
            writableMap.putString("MultiClassThemeId", mutiClassThemeId);
            promise.resolve(writableMap);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getDefaultInfo(String multiClassThemeId, Promise promise){
        try {
            MultiClassTheme multiClassTheme = (MultiClassTheme) getObjFromList(multiClassThemeId);
            ThemeInfo themeInfo = multiClassTheme.getDefaultInfo();
            String themeInfoId = "";
            if(themeInfo != null){
                themeInfoId = JSThemeInfo.registerId(themeInfo);
            }

            WritableMap writableMap = Arguments.createMap();
            writableMap.putString("ThemeInfoId", themeInfoId);
            promise.resolve(writableMap);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setDefaultInfo(String multiClassThemeId, String themeInfoId, Promise promise){
        try {
            MultiClassTheme multiClassTheme = (MultiClassTheme) getObjFromList(multiClassThemeId);
            ThemeInfo themeInfo = JSThemeInfo.getObjFromList(themeInfoId);
            multiClassTheme.setDefaultInfo(themeInfo);
            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getExpCount(String multiClassThemeId, Promise promise){
        try {
            MultiClassTheme multiClassTheme = (MultiClassTheme) getObjFromList(multiClassThemeId);
            int count = (int) multiClassTheme.getExpCount();
            promise.resolve(count);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getItemCount(String multiClassThemeId, Promise promise){
        try {
            MultiClassTheme multiClassTheme = (MultiClassTheme) getObjFromList(multiClassThemeId);
            int itemCount = (int) multiClassTheme.getItemCount();
            promise.resolve(itemCount);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getAllOtherDataItemInfoSource(String multiClassThemeId, Promise promise){
        try {
            MultiClassTheme multiClassTheme = (MultiClassTheme) getObjFromList(multiClassThemeId);
            AllOtherDataItemInfoSource allOtherDataItemInfoSource = multiClassTheme.getAllOtherDataItemInfoSource();
            promise.resolve(allOtherDataItemInfoSource.value()); // 返回的是AllOtherDataItemInfoSource.value
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setAllOtherDataItemInfoSource(String multiClassThemeId, int allOtherDataItemInfoSource, Promise promise){
        try {
            MultiClassTheme multiClassTheme = (MultiClassTheme) getObjFromList(multiClassThemeId);
            AllOtherDataItemInfoSource allOtherDataItemInfoSource1 = (AllOtherDataItemInfoSource) Enumeration.parse(AllOtherDataItemInfoSource.class, allOtherDataItemInfoSource);
            multiClassTheme.setAllOtherDataItemInfoSource(allOtherDataItemInfoSource1);
            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void appendExpression(String multiClassThemeId, String exp, int classItemType, Promise promise){
        try {
            MultiClassTheme multiClassTheme = (MultiClassTheme) getObjFromList(multiClassThemeId);
            ClassItemType classItemType1 = (ClassItemType) Enumeration.parse(ClassItemType.class, classItemType);
            int result = (int) multiClassTheme.appendExpression(exp, classItemType1);
            promise.resolve(result);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void removeExpression(String multiClassThemeId, String exp, Promise promise){
        try {
            MultiClassTheme multiClassTheme = (MultiClassTheme) getObjFromList(multiClassThemeId);
            boolean result = multiClassTheme.removeExpression(exp);
            promise.resolve(result);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void indexOfExpression(String multiClassThemeId, String exp, Promise promise){
        try {
            MultiClassTheme multiClassTheme = (MultiClassTheme) getObjFromList(multiClassThemeId);
            int index = (int) multiClassTheme.indexOfExpression(exp);
            promise.resolve(index);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getExpression(String multiClassThemeId, int index, Promise promise){
        try {
            MultiClassTheme multiClassTheme = (MultiClassTheme) getObjFromList(multiClassThemeId);
            String result = multiClassTheme.getExpression(index);
            promise.resolve(result);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void exchangeExpressions(String multiClassThemeId, int index1, int index2, Promise promise){
        try {
            MultiClassTheme multiClassTheme = (MultiClassTheme) getObjFromList(multiClassThemeId);
            boolean result = multiClassTheme.exchangeExpressions(index1, index2);
            promise.resolve(result);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getExpressionClassItemType(String multiClassThemeId, String exp, Promise promise){
        try {
            MultiClassTheme multiClassTheme = (MultiClassTheme) getObjFromList(multiClassThemeId);
            ClassItemType classItemType = multiClassTheme.getExpressionClassItemType(exp);
            promise.resolve(classItemType.value());
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void appendSubItem(String multiClassThemeId, String exp, String classItemValueId, Promise promise){
        try {
            MultiClassTheme multiClassTheme = (MultiClassTheme) getObjFromList(multiClassThemeId);
            ClassItemValue classItemValue = JSClassItemValue.getObjFromList(classItemValueId);
            int index = (int) multiClassTheme.appendSubItem(exp, classItemValue);
            promise.resolve(index);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void removeSubItem(String multiClassThemeId, String exp, int index, Promise promise){
        try {
            MultiClassTheme multiClassTheme = (MultiClassTheme) getObjFromList(multiClassThemeId);
            boolean result = multiClassTheme.removeSubItem(exp, index);
            promise.resolve(result);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void mergeSubItem(String multiClassThemeId, String exp, int index, int count, Promise promise){
        try {
            MultiClassTheme multiClassTheme = (MultiClassTheme) getObjFromList(multiClassThemeId);
            boolean result = multiClassTheme.mergeSubItem(exp, index, count);
            promise.resolve(result);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void splitSubItem(String multiClassThemeId, String exp, int index, double splitValue, Promise promise){
        try {
            MultiClassTheme multiClassTheme = (MultiClassTheme) getObjFromList(multiClassThemeId);
            boolean result = multiClassTheme.splitSubItem(exp, index, splitValue);
            promise.resolve(result);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void indexOfSubItem(String multiClassThemeId, String exp, String itemValue, Promise promise){
        try {
            MultiClassTheme multiClassTheme = (MultiClassTheme) getObjFromList(multiClassThemeId);
            int index = (int) multiClassTheme.indexOfSubItem(exp, itemValue);
            promise.resolve(index);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void clearSubItems(String multiClassThemeId, String exp, Promise promise){
        try{
            MultiClassTheme multiClassTheme = (MultiClassTheme) getObjFromList(multiClassThemeId);
            boolean result = multiClassTheme.clearSubItems(exp);
            promise.resolve(result);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getSubItemCount(String multiClassThemeId, String exp, Promise promise){
        try{
            MultiClassTheme multiClassTheme = (MultiClassTheme) getObjFromList(multiClassThemeId);
            int count = (int) multiClassTheme.getSubItemCount(exp);
            promise.resolve(count);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setSubItemValue(String multiClassThemeId, String exp, int index, String classItemValueId, Promise promise){
        try{
            MultiClassTheme multiClassTheme = (MultiClassTheme) getObjFromList(multiClassThemeId);
            ClassItemValue classItemValue = JSClassItemValue.getObjFromList(classItemValueId);
            boolean result =  multiClassTheme.setSubItemValue(exp, index, classItemValue);
            promise.resolve(result);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getSubItemValue(String multiClassThemeId, String exp, int index, Promise promise){
        try{
            MultiClassTheme multiClassTheme = (MultiClassTheme) getObjFromList(multiClassThemeId);
            ClassItemValue classItemValue =  multiClassTheme.getSubItemValue(exp, index);

            String classItemValueId = "";
            if(classItemValue != null){
                classItemValueId = JSClassItemValue.registerId(classItemValue);
            }
            WritableMap writableMap = Arguments.createMap();
            writableMap.putString("ClassItemValueId", classItemValueId);
            promise.resolve(writableMap);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void make(String multiClassThemeId, boolean maintainExistentStyle, Promise promise){
        try{
            MultiClassTheme multiClassTheme = (MultiClassTheme) getObjFromList(multiClassThemeId);
            boolean result = multiClassTheme.make(maintainExistentStyle);
            promise.resolve(result);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getItem(String multiClassThemeId, int index, Promise promise){
        try{
            MultiClassTheme multiClassTheme = (MultiClassTheme) getObjFromList(multiClassThemeId);
            MultiClassThemeInfo multiClassThemeInfo = multiClassTheme.getItem(index);
            String multiClassThemeInfoId = "";

            if(multiClassThemeInfo != null){
                multiClassThemeInfoId = JSMultiClassThemeInfo.registerId(multiClassThemeInfo);

            }
            WritableMap writableMap = Arguments.createMap();
            writableMap.putString("MultiClassThemeInfoId", multiClassThemeInfoId);
            promise.resolve(writableMap);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setItem(String multiClassThemeId, int index, String multiClassThemeInfoId, Promise promise){
        try{
            MultiClassTheme multiClassTheme = (MultiClassTheme) getObjFromList(multiClassThemeId);
            MultiClassThemeInfo multiClassThemeInfo = JSMultiClassThemeInfo.getObjFromList(multiClassThemeInfoId);
            boolean result = multiClassTheme.setItem(index,multiClassThemeInfo);

            promise.resolve(result);
        }catch (Exception e){
            promise.reject(e);
        }
    }

}
