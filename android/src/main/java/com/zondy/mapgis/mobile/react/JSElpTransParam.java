package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.android.internal.chart.json.GsonUtil;
import com.zondy.mapgis.core.srs.ElpTransParam;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class JSElpTransParam extends ReactContextBaseJavaModule {
    private static final String REACT_CLASS = "JSElpTransParam";
    private static Map<String, ElpTransParam> mElpTransParamList = new HashMap<String, ElpTransParam>();

    public JSElpTransParam(ReactApplicationContext context) {
        super(context);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public static ElpTransParam getObjFromList(String id) {
        return mElpTransParamList.get(id);
    }


    public static String registerId(ElpTransParam obj) {
        for (Map.Entry entry : mElpTransParamList.entrySet()) {
            if (obj.equals(entry.getValue())) {
                return (String) entry.getKey();
            }
        }
        String id = UUID.randomUUID().toString().substring(24);
        mElpTransParamList.put(id, obj);
        return id;
    }

    @ReactMethod
    public void createObj(Promise promise) {
        try {
            ElpTransParam elpTransParam = new ElpTransParam();
            String strElpTransParamId = registerId(elpTransParam);

            WritableMap map = Arguments.createMap();
            map.putString("ElpTransParamId", strElpTransParamId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void get(String elpTransParamId, String key, Promise promise){
        try {
            ElpTransParam elpTransParam = getObjFromList(elpTransParamId);
            WritableMap writableMap = Arguments.createMap();

            switch (key){
                case "name":
                    writableMap.putString("value", elpTransParam.name);
                    break;

                case "inCord":
                    writableMap.putInt("value", elpTransParam.inCord);
                    break;

                case "inUnit":
                    writableMap.putInt("value", elpTransParam.inUnit);
                    break;

                case "outCord":
                    writableMap.putInt("value", elpTransParam.outCord);
                    break;

                case "outUnit":
                    writableMap.putInt("value", elpTransParam.outUnit);
                    break;

                case "type":
                    writableMap.putInt("value", elpTransParam.type);
                    break;

                case "dx":
                    writableMap.putDouble("value", elpTransParam.dx);
                    break;

                case "dy":
                    writableMap.putDouble("value", elpTransParam.dy);
                    break;

                case "dz":
                    writableMap.putDouble("value", elpTransParam.dz);
                    break;

                case "wx":
                    writableMap.putDouble("value", elpTransParam.wx);
                    break;

                case "wy":
                    writableMap.putDouble("value", elpTransParam.wy);
                    break;

                case "wz":
                    writableMap.putDouble("value", elpTransParam.wz);
                    break;

                case "dm":
                    writableMap.putDouble("value", elpTransParam.dm);
                    break;

                default:
                    break;
            }

            promise.resolve(writableMap);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void set(String elpTransParamId, String key, ReadableMap readableMap, Promise promise){
        try {
            ElpTransParam elpTransParam = getObjFromList(elpTransParamId);
            setMemberValueByKey(key, readableMap, elpTransParam);

            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }
    @ReactMethod
    public void toString(String elpTransParamId, Promise promise){
        try {
            ElpTransParam elpTransParam = getObjFromList(elpTransParamId);
            if (elpTransParam.name == null){
                elpTransParam.name = "";
            }
            String memberVariableJson = GsonUtil.format(elpTransParam);
            promise.resolve(memberVariableJson);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void fromString(String elpTransParamId, ReadableMap readableMap, Promise promise){
        try {
            ElpTransParam elpTransParam  = getObjFromList(elpTransParamId);
            ReadableMapKeySetIterator iterator = readableMap.keySetIterator();
            while (iterator.hasNextKey()){
                String index = iterator.nextKey();
                setMemberValueByKey(index, readableMap, elpTransParam);
            }

            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    private void setMemberValueByKey(String key, ReadableMap readableMap, ElpTransParam elpTransParam){
        switch (key){
            case "name":
                String name = readableMap.getString("name");
                elpTransParam.name = name;
                break;

            case "inCord":
                int inCord = readableMap.getInt("inCord");
                elpTransParam.inCord = inCord;
                break;

            case "inUnit":
                int inUnit = readableMap.getInt("inUnit");
                elpTransParam.inUnit = inUnit;
                break;

            case "outCord":
                int outCord = readableMap.getInt("outCord");
                elpTransParam.outCord = outCord;
                break;

            case "outUnit":
                int outUnit = readableMap.getInt("outUnit");
                elpTransParam.outUnit = outUnit;
                break;

            case "type":
                int type = readableMap.getInt("type");
                elpTransParam.type = type;
                break;

            case "dx":
                double dx = readableMap.getDouble("dx");
                elpTransParam.dx = dx;
                break;

            case "dy":
                double dy = readableMap.getDouble("dy");
                elpTransParam.dy = dy;
                break;

            case "dz":
                double dz = readableMap.getDouble("dz");
                elpTransParam.dz = dz;
                break;

            case "wx":
                double wx = readableMap.getDouble("wx");
                elpTransParam.wx = wx;
                break;

            case "wy":
                double wy = readableMap.getDouble("wy");
                elpTransParam.wy = wy;
                break;

            case "wz":
                double wz = readableMap.getDouble("wz");
                elpTransParam.wz = wz;
                break;

            case "dm":
                double dm = readableMap.getDouble("dm");
                elpTransParam.dm = dm;
                break;

            default:
                break;
        }
    }

}
