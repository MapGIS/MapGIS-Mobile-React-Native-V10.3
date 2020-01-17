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
import com.zondy.mapgis.core.srs.ElpParam;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class JSElpParam extends ReactContextBaseJavaModule {
    private static final String REACT_CLASS = "JSElpParam";
    private static Map<String, ElpParam> mElpParamList = new HashMap<String, ElpParam>();

    public JSElpParam(ReactApplicationContext context) {
        super(context);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public static ElpParam getObjFromList(String id) {
        return mElpParamList.get(id);
    }


    public static String registerId(ElpParam obj) {
        for (Map.Entry entry : mElpParamList.entrySet()) {
            if (obj.equals(entry.getValue())) {
                return (String) entry.getKey();
            }
        }
        String id = UUID.randomUUID().toString().substring(24);
        mElpParamList.put(id, obj);
        return id;
    }

    @ReactMethod
    public void createObj(Promise promise) {
        try {
            ElpParam elpParam = new ElpParam();
            String strElpParamId = registerId(elpParam);

            WritableMap map = Arguments.createMap();
            map.putString("ElpParamId", strElpParamId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void set(String elpParamId, String key, ReadableMap readableMap, Promise promise){
        try {
            ElpParam elpParam = getObjFromList(elpParamId);
            setMemberValueByKey(key, readableMap, elpParam);

            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void get(String elpParamId, String key, Promise promise){
        try {
            ElpParam elpParam = getObjFromList(elpParamId);
            WritableMap writableMap = Arguments.createMap();
            switch (key){
                case "a":
                    writableMap.putDouble("value",  elpParam.a);
                    break;

                case "b":
                    writableMap.putDouble("value",  elpParam.b);
                    break;

                case "af":
                    writableMap.putDouble("value",  elpParam.af);
                    break;

                case "r":
                    writableMap.putDouble("value",  elpParam.r);
                    break;

                case "name":
                    writableMap.putString("value", elpParam.name);
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
    public void toString(String elpParamId, Promise promise){
        try {
            ElpParam elpParam = getObjFromList(elpParamId);
            if(elpParam.name == null){
                elpParam.name = "";
            }
            String memberVariableJson = GsonUtil.format(elpParam);
            promise.resolve(memberVariableJson);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void fromString(String elpParamId, ReadableMap readableMap, Promise promise){
        try {
            ElpParam elpParam = getObjFromList(elpParamId);
            ReadableMapKeySetIterator iterator = readableMap.keySetIterator();
            while (iterator.hasNextKey()){
                String index = iterator.nextKey();
                setMemberValueByKey(index, readableMap, elpParam);
            }

            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    private void setMemberValueByKey(String key, ReadableMap readableMap, ElpParam elpParam){
        switch (key){
            case "a":
                double a = readableMap.getDouble("a");
                elpParam.a = a;
                break;

            case "b":
                double b = readableMap.getDouble("b");
                elpParam.b = b;
                break;

            case "af":
                double af = readableMap.getDouble("af");
                elpParam.af = af;
                break;

            case "r":
                double r = readableMap.getDouble("r");
                elpParam.r = r;
                break;

            case "name":
                String name = readableMap.getString("name");
                elpParam.name = name;
                break;

            default:
                break;
        }
    }
}
