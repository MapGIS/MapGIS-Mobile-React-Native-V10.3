package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.core.geodatabase.IBasCls;
import com.zondy.mapgis.core.geodatabase.XClsType;
import com.zondy.mapgis.core.geometry.GeomType;
import com.zondy.mapgis.core.geometry.Rect;
import com.zondy.mapgis.core.map.Label;
import com.zondy.mapgis.core.map.LayerState;
import com.zondy.mapgis.core.map.MapLayer;
import com.zondy.mapgis.core.map.Themes;
import com.zondy.mapgis.core.object.Enumeration;
import com.zondy.mapgis.core.srs.SRefData;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author fjl 2019-6-24 下午2:52:36
 * @content 覆盖物对象Native组件
 */
public class JSMapLayer extends ReactContextBaseJavaModule {
    private static final String REACT_CLASS = "JSMapLayer";
    private static Map<String, MapLayer> mMapLayerList = new HashMap<String, MapLayer>();

    public JSMapLayer(ReactApplicationContext context) {
        super(context);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public static MapLayer getObjFromList(String id) {
        return mMapLayerList.get(id);
    }

    public static String registerId(MapLayer obj) {
        for (Map.Entry entry : mMapLayerList.entrySet()) {
            if (obj.equals(entry.getValue())) {
                String id = (String) entry.getKey();
                return id;
            }
        }

        String id = UUID.randomUUID().toString().substring(24);
        mMapLayerList.put(id, obj);
        return id;
    }

    @ReactMethod
    public void createObj(Promise promise) {
        try {
            MapLayer MapLayer = new MapLayer();
            String MapLayerId = registerId(MapLayer);

            WritableMap map = Arguments.createMap();
            map.putString("MapLayerId", MapLayerId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setName(String MapLayerId, String name, Promise promise) {
        try {
            MapLayer mapLayer = getObjFromList(MapLayerId);
            mapLayer.setName(name);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getName(String MapLayerId, Promise promise) {
        try {
            MapLayer mapLayer = getObjFromList(MapLayerId);
            String name = mapLayer.getName();

            promise.resolve(name);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getURL(String MapLayerId, Promise promise) {
        try {
            MapLayer mapLayer = getObjFromList(MapLayerId);
            String url = mapLayer.getURL();

            promise.resolve(url);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setURL(String MapLayerId, String url, Promise promise) {
        try {
            MapLayer mapLayer = getObjFromList(MapLayerId);
            mapLayer.setURL(url);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getState(String MapLayerId, Promise promise) {
        try {
            MapLayer mapLayer = getObjFromList(MapLayerId);
            LayerState state = mapLayer.getState();
            int stateValue = state.value();

            promise.resolve(stateValue);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setState(String MapLayerId, int state, Promise promise) {
        try {
            MapLayer mapLayer = getObjFromList(MapLayerId);
            mapLayer.setState((LayerState) Enumeration.parse(LayerState.class, state));
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setVisible(String MapLayerId, boolean state, Promise promise) {
        try {
            MapLayer mapLayer = getObjFromList(MapLayerId);
            mapLayer.setVisible(state);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getIsVisible(String MapLayerId, Promise promise) {
        try {
            MapLayer mapLayer = getObjFromList(MapLayerId);
            boolean state = mapLayer.getIsVisible();
            promise.resolve(state);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getMinScale(String MapLayerId, Promise promise) {
        try {
            MapLayer mapLayer = getObjFromList(MapLayerId);
            double minScale = mapLayer.getMinScale();
            promise.resolve(minScale);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setMinScale(String MapLayerId, double MinScale, Promise promise) {
        try {
            MapLayer mapLayer = getObjFromList(MapLayerId);
            mapLayer.setMinScale(MinScale);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getMaxScale(String MapLayerId, Promise promise) {
        try {
            MapLayer mapLayer = getObjFromList(MapLayerId);
            double maxScale = mapLayer.getMaxScale();
            promise.resolve(maxScale);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setMaxScale(String MapLayerId, double MaxScale, Promise promise) {
        try {
            MapLayer mapLayer = getObjFromList(MapLayerId);
            mapLayer.setMaxScale(MaxScale);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getWeight(String MapLayerId, Promise promise) {
        try {
            MapLayer mapLayer = getObjFromList(MapLayerId);
            int weight = mapLayer.getWeight();
            promise.resolve(weight);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setWeight(String MapLayerId, int weight, Promise promise) {
        try {
            MapLayer mapLayer = getObjFromList(MapLayerId);
            mapLayer.setWeight((short) weight);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getIsValid(String MapLayerId, Promise promise) {
        try {
            MapLayer mapLayer = getObjFromList(MapLayerId);
            boolean isValid = mapLayer.getIsValid();
            promise.resolve(isValid);

        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getViewRange(String MapLayerId, Promise promise) {
        try {
            MapLayer mapLayer = getObjFromList(MapLayerId);
            Rect rect = mapLayer.getRange();
            String rectId = null;
            if (rect != null) {
                rectId = JSRect.registerId(rect);
            }
            WritableMap map = Arguments.createMap();
            map.putString("rectId", rectId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getSrefInfo(String MapLayerId, Promise promise) {
        try {
            MapLayer mapLayer = getObjFromList(MapLayerId);
            SRefData sRefData = mapLayer.getSrefInfo();
            String sRefInfoId = JSSRefData.registerId(sRefData);
            if (sRefData != null) {
                sRefInfoId = JSSRefData.registerId(sRefData);
            }

            WritableMap map = Arguments.createMap();
            map.putString("SRefDataId", sRefInfoId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getClsType(String MapLayerId, Promise promise) {
        try {
            MapLayer mapLayer = getObjFromList(MapLayerId);
            XClsType xClsType = mapLayer.getClsType();

            promise.resolve(xClsType.value());
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void GetGeometryType(String MapLayerId, Promise promise) {
        try {
            MapLayer mapLayer = getObjFromList(MapLayerId);
            GeomType geomType = mapLayer.GetGeometryType();

            promise.resolve(geomType.value());
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getLabel(String MapLayerId, Promise promise) {
        try {
            MapLayer mapLayer = getObjFromList(MapLayerId);
            Label label = mapLayer.getLabel();
            WritableMap writableMap = Arguments.createMap();
            String labelId = null;
            int type = -1;
            if (label != null) {
                labelId = JSLabel.registerId(label);
                type = label.getType().value();
            }
            writableMap.putString("LabelId", labelId);
            writableMap.putInt("LabelType", type);
            promise.resolve(writableMap);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getThemes(String MapLayerId, Promise promise) {
        try {
            MapLayer mapLayer = getObjFromList(MapLayerId);
            Themes themes = mapLayer.getThemes();
            String themesId = null;
            if (themes != null) {
                themesId = JSThemes.registerId(themes);
            }

            WritableMap writableMap = Arguments.createMap();
            writableMap.putString("ThemesId", themesId);
            promise.resolve(writableMap);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void clone(String MapLayerId, Promise promise) {
        try {
            MapLayer mapLayer = getObjFromList(MapLayerId);
            MapLayer cloneMapLayer = mapLayer.clone();
            String cloneMapLayerId = null;
            if (cloneMapLayer != null) {
                cloneMapLayerId = registerId(cloneMapLayer);
            }

            WritableMap writableMap = Arguments.createMap();
            writableMap.putString("MapLayerId", cloneMapLayerId);
            promise.resolve(writableMap);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void attachData(String MapLayerId, String iBasClsId, Promise promise) {
        try {
            MapLayer mapLayer = getObjFromList(MapLayerId);
            IBasCls iBasCls = JSBasCls.getObjFromList(iBasClsId);
            if (iBasCls == null) {
                iBasCls = JSVectorCls.getObjFromList(iBasClsId);
            }
            if (iBasCls == null) {
                iBasCls = JSSFeatureCls.getObjFromList(iBasClsId);
            }
            if (iBasCls == null) {
                iBasCls = JSAnnotationCls.getObjFromList(iBasClsId);
            }
            boolean result = mapLayer.attachData(iBasCls);

            promise.resolve(result);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void detachData(String MapLayerId, Promise promise) {
        try {
            MapLayer mapLayer = getObjFromList(MapLayerId);
            boolean result = mapLayer.detachData();

            promise.resolve(result);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getData(String MapLayerId, Promise promise) {
        try {
            MapLayer mapLayer = getObjFromList(MapLayerId);
            IBasCls iBasCls = mapLayer.getData();
            String iBasClsId = null;
            if (iBasCls != null) {
                iBasClsId = JSBasCls.registerId(iBasCls);
            }
            WritableMap writableMap = Arguments.createMap();
            writableMap.putString("IBasClsId", iBasClsId);
            promise.resolve(writableMap);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void toXML(String MapLayerId, boolean onlyStyle, Promise promise) {
        try {
            MapLayer mapLayer = getObjFromList(MapLayerId);
            String toXml = mapLayer.toXML(onlyStyle);

            promise.resolve(toXml);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void fromXML(String MapLayerId, String strXML, boolean onlyStyle, Promise promise) {
        try {
            MapLayer mapLayer = getObjFromList(MapLayerId);
            int result = (int) mapLayer.fromXML(strXML, onlyStyle);

            promise.resolve(result);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setLabel(String MapLayerId, String LabelId, Promise promise) {
        try {
            MapLayer mapLayer = getObjFromList(MapLayerId);
            Label label = JSLabel.getObjFromList(LabelId);
            String result = String.valueOf(mapLayer.setLabel(label));
            promise.resolve(result);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

}
