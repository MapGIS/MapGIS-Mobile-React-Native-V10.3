package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.core.map.ClassItemValue;
import com.zondy.mapgis.core.map.Document;
import com.zondy.mapgis.core.map.Maps;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * 文档对象Native组件
 * Created by xiaoying on 2019/8/28.
 */
public class JSDocument extends JSDocumentItem {
    private static final String REACT_CLASS = "JSDocument";
    public static Map<String, Document> mDocumentList = new HashMap<>();

    public JSDocument(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public static Document getObjFromList(String id){
        return mDocumentList.get(id);
    }

    public static String registerId(Document obj){
        for(Map.Entry entry : mDocumentList.entrySet()){
            if(obj.equals(entry.getValue())){
                String id = (String) entry.getKey();
                return id;
            }
        }
        Calendar calendar = Calendar.getInstance();
        String id = Long.toString(calendar.getTimeInMillis());
        mDocumentList.put(id,obj);
        return id;
    }


    @ReactMethod
    public void createObj(Promise promise){
        try {
            Document document = new Document();
            String id = registerId(document);

            WritableMap map = Arguments.createMap();
            map.putString("DocumentId",id);
            promise.resolve(map);

        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getTitle(String documentId, Promise promise){
        try {
            Document document = getObjFromList(documentId);
            String title = document.getTitle();
            promise.resolve(title);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getSubject(String documentId, Promise promise){
        try {
            Document document = getObjFromList(documentId);
            String subject = document.getSubject();
            promise.resolve(subject);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getAuthor(String documentId, Promise promise){
        try {
            Document document = getObjFromList(documentId);
            String author = document.getAuthor();
            promise.resolve(author);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getCategory(String documentId, Promise promise){
        try {
            Document document = getObjFromList(documentId);
            String category = document.getCategory();
            promise.resolve(category);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getKeywords(String documentId, Promise promise){
        try {
            Document document = getObjFromList(documentId);
            String keywords = document.getKeywords();
            promise.resolve(keywords);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getComments(String documentId, Promise promise){
        try {
            Document document = getObjFromList(documentId);
            String comments = document.getComments();
            promise.resolve(comments);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getIsNew(String documentId, Promise promise){
        try {
            Document document = getObjFromList(documentId);
            boolean isNew = document.getIsNew();
            promise.resolve(isNew);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getDocItemType(String documentId, Promise promise){
        try {
            Document document = getObjFromList(documentId);
            int docItemType = document.getDocItemType().value();
            promise.resolve(docItemType);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getIsDirty(String documentId, Promise promise){
        try {
            Document document = getObjFromList(documentId);
            boolean isDirty = document.getIsDirty();
            promise.resolve(isDirty);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setTitle(String documentId, String title, Promise promise){
        try {
            Document document = getObjFromList(documentId);
            document.setTitle(title);
            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setSubject(String documentId, String subject, Promise promise){
        try {
            Document document = getObjFromList(documentId);
            document.setSubject(subject);
            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setAuthor(String documentId, String author, Promise promise){
        try {
            Document document = getObjFromList(documentId);
            document.setAuthor(author);
            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setCategory(String documentId, String category, Promise promise){
        try{
            Document document = getObjFromList(documentId);
            document.setCategory(category);
            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setKeywords(String documentId, String keywords, Promise promise){
        try {
            Document document = getObjFromList(documentId);
            document.setKeywords(keywords);
            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setComments(String documentId, String comments, Promise promise){
        try {
            Document document = getObjFromList(documentId);
            document.setComments(comments);
            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void jNew(String documentId, Promise promise){
        try {
            Document document = getObjFromList(documentId);
            int jNew = document.jNew();
            promise.resolve(jNew);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void open(String documentId, String filePath, Promise promise){
        try {
            Document document = getObjFromList(documentId);
            int open = document.open(filePath);
            promise.resolve(open);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void close(String documentId, boolean save, Promise promise){
        try {
            Document document = getObjFromList(documentId);
            boolean close = document.close(save);
            promise.resolve(close);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void save(String documentId, Promise promise){
        try {
            Document document = getObjFromList(documentId);
            boolean save = document.save();
            promise.resolve(save);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void saveAs(String documentId, String filePath, Promise promise){
        try {
            Document document = getObjFromList(documentId);
            boolean saveAs = document.saveAs(filePath);
            promise.resolve(saveAs);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getFilePath(String documentId, Promise promise){
        try {
            Document document = getObjFromList(documentId);
            String filePath = document.getFilePath();
            promise.resolve(filePath);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getVersion(String documentId, Promise promise){
        try {
            Document document = getObjFromList(documentId);
            String version = document.getVersion();
            promise.resolve(version);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getMaps(String documentId, Promise promise){
        try {
            Document document = getObjFromList(documentId);
            Maps maps = document.getMaps();
            String mapsId = JSMaps.registerId(maps);

            WritableMap map = Arguments.createMap();
            map.putString("MapsId",mapsId);
            promise.resolve(map);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void toXML(String documentId, Promise promise){
        try {
            Document document = getObjFromList(documentId);
            String toXML = document.toXML();
            promise.resolve(toXML);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void fromXML(String documentId, String strXML, Promise promise){
        try {
            Document document = getObjFromList(documentId);
            int fromXML = document.fromXML(strXML);
            promise.resolve(fromXML);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void clearDirty(String documentId, Promise promise){
        try {
            Document document = getObjFromList(documentId);
            boolean clearDirty = document.clearDirty();
            promise.resolve(clearDirty);
        }catch (Exception e){
            promise.reject(e);
        }
    }
}
