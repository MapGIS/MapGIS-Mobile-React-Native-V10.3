package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.zondy.mapgis.core.featureservice.SyncBase;

public class JSSyncBase extends ReactContextBaseJavaModule {
    public static final String REACT_CLASS = "JSSyncBase";
    private static ReactApplicationContext mReactContext;

//    public static Map<String, SyncBase> mSyncBaseList = new HashMap<String, SyncBase>();

    public JSSyncBase(ReactApplicationContext reactContext) {
        super(reactContext);
        this.mReactContext = reactContext;
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

//    public static SyncBase getObjFromList(String id) {
//        return mSyncBaseList.get(id);
//    }
//
//    public static String registerId(SyncBase obj) {
//        for (Map.Entry entry : mSyncBaseList.entrySet()) {
//            if (obj.equals(entry.getValue())) {
//                return (String) entry.getKey();
//            }
//        }
//        Calendar calendar = Calendar.getInstance();
//        String id = Long.toString(calendar.getTimeInMillis());
//        mSyncBaseList.put(id, obj);
//        return id;
//    }

    @ReactMethod
    public static void setFinishedListener(Promise promise)
    {
        try {
            SyncBaseListener syncBaseListener = new SyncBaseListener(mReactContext);
            SyncBase.setFinishedListener(syncBaseListener);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public static void setProgressListener(Promise promise)
    {
        try {
            SyncBaseListener syncBaseListener = new SyncBaseListener(mReactContext);
            SyncBase.setProgressListener(syncBaseListener);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public static void removeProgressListener(Promise promise)
    {
        try {
            int iVal = (int)SyncBase.removeProgressListener();
            promise.resolve(iVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public static void removeFinishedListener(Promise promise)
    {
        try {
            int iVal = (int)SyncBase.removeFinishedListener();
            promise.resolve(iVal);
        } catch (Exception e) {
            promise.reject(e);
        }
    }
}
