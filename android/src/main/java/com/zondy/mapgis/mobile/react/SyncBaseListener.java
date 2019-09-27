package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.zondy.mapgis.core.featureservice.SyncBase;

public class SyncBaseListener implements SyncBase.FinishedListener, SyncBase.ProgressListener
{
    private ReactContext mReactContext;
    private static final String SYNC_PROGRESSING = "com.mapgis.RN.SyncBase.progressing";
    private static final String SYNC_FINISH = "com.mapgis.RN.SyncBase.finish";

    public SyncBaseListener(ReactContext reactContext){
        super();
        this.mReactContext = reactContext;
    }

    @Override
    public void onFinished(long lSyncCode, boolean normalSuccessed) {
        WritableMap writableMap = Arguments.createMap();
        writableMap.putInt("SyncCode", (int)lSyncCode);
        writableMap.putBoolean("NormalSuccessed", normalSuccessed);

        sendEvent(SYNC_FINISH , writableMap);
    }

    @Override
    public void onProgress(long lSyncCode, long lTotalClsCount,long lCurClsIndex,double dCurClsUpdateProgress) {

        WritableMap writableMap = Arguments.createMap();
        writableMap.putInt("SyncCode", (int)lSyncCode);
        writableMap.putInt("TotalClsCount", (int)lTotalClsCount);
        writableMap.putInt("CurClsIndex", (int)lCurClsIndex);
        writableMap.putDouble("CurClsUpdateProgress", dCurClsUpdateProgress);

        sendEvent(SYNC_PROGRESSING , writableMap);
    }

    private void sendEvent(String eventName, WritableMap params) {

        mReactContext
                .getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
                .emit(eventName, params);

    }
}
