package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.core.map.DocItemType;
import com.zondy.mapgis.core.map.DocumentItem;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaoying on 2019/8/28.
 * @content 文档项对象Native组件,DocumentItem因不能直接构造对象，所以此类不会实现createObj()方法
 */
public class JSDocumentItem extends ReactContextBaseJavaModule {
    private static final String REACT_CLASS = "JSDocumentItem";
    public static Map<String, DocumentItem> mDocumentItemList = new HashMap<>();

    public JSDocumentItem(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public static DocumentItem getObjFromList(String documentItemId){
        return mDocumentItemList.get(documentItemId);
    }

    public static String registerId(DocumentItem obj){
       for(Map.Entry<String, DocumentItem> entry : mDocumentItemList.entrySet()){
           if (obj.equals(entry.getValue())){
               String id = (String) entry.getKey();
               return id;
           }
       }

       Calendar calendar =  Calendar.getInstance();
       String id = Long.toString(calendar.getTimeInMillis());
       mDocumentItemList.put(id,obj);
       return id;
    }

    @ReactMethod
    public void getDocItemType(String documentItemId, Promise promise){
        try {
            DocumentItem documentItem = getObjFromList(documentItemId);
            DocItemType docItemType = documentItem.getDocItemType();
            int docItemTypeValue = docItemType.value();
            promise.resolve(docItemTypeValue);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getParent(String documentItemId, Promise promise){
        try {
            DocumentItem documentItem = getObjFromList(documentItemId);
            DocumentItem parentDocumentItem = documentItem.getParent();
            String parentDocumentItemId = registerId(parentDocumentItem); // 获取到parentDocumentItem的id

            WritableMap map = Arguments.createMap();
            map.putString("DocumentItemId",parentDocumentItemId);
            promise.resolve(map);
        }catch (Exception e){
            promise.reject(e);
        }
    }

}
