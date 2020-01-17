package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.core.attr.Fields;
import com.zondy.mapgis.core.info.LinInfo;
import com.zondy.mapgis.core.map.VectorLayer;
import com.zondy.mapgis.core.map.VectorLayerType;
import com.zondy.mapgis.core.object.Enumeration;

import java.util.UUID;

/**
 * @author fjl 2019-6-25 下午2:52:36
 * @content 覆盖物对象Native组件
 */
public class JSVectorLayer extends JSMapLayer {
    private static final String REACT_CLASS = "JSVectorLayer";

    public JSVectorLayer(ReactApplicationContext context) {
        super(context);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @ReactMethod
    public void createObj(int vectorLayerType, Promise promise) {
        try {
            VectorLayerType vectorLayerType1 = (VectorLayerType) Enumeration.parse(VectorLayerType.class, vectorLayerType);
            VectorLayer VectorLayer = new VectorLayer(vectorLayerType1);
            String VectorLayerId = registerId(VectorLayer);

            WritableMap map = Arguments.createMap();
            map.putString("VectorLayerId", VectorLayerId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getSymbolScale(String VectorLayerId, Promise promise){
        try {
            VectorLayer vectorLayer = (VectorLayer) getObjFromList(VectorLayerId);
            double symbolScale = vectorLayer.getSymbolScale();

            promise.resolve(symbolScale);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setSymbolScale(String VectorLayerId, double symbolScale, Promise promise){
        try {
            VectorLayer vectorLayer = (VectorLayer) getObjFromList(VectorLayerId);
            vectorLayer.setSymbolScale(symbolScale);

            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getSystemLib(String VectorLayerId, Promise promise){
        try {
            VectorLayer vectorLayer = (VectorLayer) getObjFromList(VectorLayerId);
            UUID uuid = vectorLayer.getSystemLib();
            String uuidString = "";
            if(uuid != null){
                uuidString = uuid.toString();
            }

            promise.resolve(uuidString);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setSystemLib(String VectorLayerId, String uuid, Promise promise){
        try {
            VectorLayer vectorLayer = (VectorLayer) getObjFromList(VectorLayerId);
            UUID uuid1 = UUID.fromString(uuid);
            vectorLayer.setSystemLib(uuid1);

            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void isSymbolShow(String VectorLayerId, Promise promise) {
        try {
            VectorLayer VectorLayer = (VectorLayer) getObjFromList(VectorLayerId);
            boolean isSymbolShow = VectorLayer.isSymbolShow();

            promise.resolve(isSymbolShow);
        } catch (Exception e) {
            promise.reject(e);
        }
    }


    @ReactMethod
    public void setSymbolShow(String VectorLayerId, boolean symbolShow, Promise promise) {
        try {
            VectorLayer VectorLayer = (VectorLayer) getObjFromList(VectorLayerId);
            VectorLayer.setSymbolShow(symbolShow);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void isFollowZoom(String VectorLayerId, Promise promise){
        try {
            VectorLayer VectorLayer = (VectorLayer) getObjFromList(VectorLayerId);
            boolean isFllowZoom = VectorLayer.isFollowZoom();

            promise.resolve(isFllowZoom);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setFollowZoom(String VectorLayerId, boolean followZoom, Promise promise){
        try {
            VectorLayer VectorLayer = (VectorLayer) getObjFromList(VectorLayerId);
            VectorLayer.setFollowZoom(followZoom);

            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getMinVisibleGeomSize(String VectorLayerId, Promise promise){
        try {
            VectorLayer VectorLayer = (VectorLayer) getObjFromList(VectorLayerId);
            double minVisibleGeomSize = VectorLayer.getMinVisibleGeomSize();

            promise.resolve(minVisibleGeomSize);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setMinVisibleGeomSize(String VectorLayerId, double minVisibleGeomSize, Promise promise){
        try {
            VectorLayer VectorLayer = (VectorLayer) getObjFromList(VectorLayerId);
            VectorLayer.setMinVisibleGeomSize(minVisibleGeomSize);

            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getTransparency(String VectorLayerId, Promise promise){
        try {
            VectorLayer VectorLayer = (VectorLayer) getObjFromList(VectorLayerId);
            int transparency = VectorLayer.getTransparency();

            promise.resolve(transparency);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setTransparency(String VectorLayerId, int transparency, Promise promise) {
        try {
            VectorLayer VectorLayer = (VectorLayer) getObjFromList(VectorLayerId);
            VectorLayer.setTransparency((short) transparency);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getFields(String VectorLayerId, Promise promise){
        try {
            VectorLayer VectorLayer = (VectorLayer) getObjFromList(VectorLayerId);
            Fields fields = VectorLayer.getFields();
            String fieldsId = null;
            if(fields != null){
                fieldsId = JSFields.registerId(fields);
            }
            WritableMap writableMap = Arguments.createMap();
            writableMap.putString("FieldsId", fieldsId);
            promise.resolve(writableMap);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setRegBorderLinInfo(String VectorLayerId, String linInfoId, Promise promise){
        try {
            VectorLayer VectorLayer = (VectorLayer) getObjFromList(VectorLayerId);
            LinInfo linInfo = (LinInfo) JSLinInfo.getObjFromList(linInfoId);
            VectorLayer.setRegBorderLinInfo(linInfo);

            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getRegBorderLinInfo(String VectorLayerId, Promise promise){
        try {
            VectorLayer VectorLayer = (VectorLayer) getObjFromList(VectorLayerId);
            LinInfo linInfo = VectorLayer.getRegBorderLinInfo();
            String linInfoId = null;
            if(linInfo != null){
                linInfoId = JSLinInfo.registerId(linInfo);
            }
            WritableMap writableMap = Arguments.createMap();
            writableMap.putString("LinInfoId", linInfoId);
            promise.resolve(writableMap);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void generateUUID(Promise promise){
        try {
            UUID uuid = UUID.randomUUID();
            promise.resolve(uuid.toString());
        }catch (Exception e){
            promise.reject(e);
        }
    }

}
