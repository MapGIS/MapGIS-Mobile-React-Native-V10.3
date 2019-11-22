package com.zondy.mapgis.mobile.react;

import android.app.Activity;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.android.environment.Environment;

import java.io.File;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * @author fjl 2019-6-20 下午2:52:36
 * @content 图片对象Native组件
 */
public class JSEnvironment extends ReactContextBaseJavaModule {
    public static final String REACT_CLASS = "JSEnvironment";
    public static Map<String, Environment> mEnvironmentList = new HashMap<String, Environment>();
    private ReactContext mContext;

    public JSEnvironment(ReactApplicationContext context) {
        super(context);
        mContext = context;
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public static Environment getObjFromList(String id) {
        return mEnvironmentList.get(id);
    }


    public static String registerId(Environment obj) {
        for (Map.Entry entry : mEnvironmentList.entrySet()) {
            if (obj.equals(entry.getValue())) {
                return (String) entry.getKey();
            }
        }

        Calendar calendar = Calendar.getInstance();
        String id = Long.toString(calendar.getTimeInMillis());
        mEnvironmentList.put(id, obj);
        return id;
    }

    @ReactMethod
    public void createObj(Promise promise) {
        try {
            Environment environment = new Environment();
            String EnvironmentId = registerId(environment);

            WritableMap map = Arguments.createMap();
            map.putString("EnvironmentId", EnvironmentId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void initialize(String environmentID, String strRootPath, Promise promise) {
        try {
            Environment.initialize(strRootPath, mContext);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void requestAuthorization(String environmentID, final Promise promise) {
        final Activity activity = getCurrentActivity();

        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                try {
                    com.zondy.mapgis.android.environment.Environment.requestAuthorization(activity, new com.zondy.mapgis.android.environment.Environment.AuthorizeCallback() {
                        @Override
                        public void onComplete() {
                            promise.resolve(true);
                        }
                    });
                } catch (Exception e) {
                    promise.reject(e);
                }
            }
        });
    }

    @ReactMethod
    public void setSystemLibraryPath(String environmentID, String strPath, Promise promise) {
        try {
            Environment.setSystemLibraryPath(strPath);
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public double getRootPath(String environmentID, Promise promise) {
        try {
            String rootPath = Environment.getRootPath();
            promise.resolve(rootPath);
        } catch (Exception e) {
            promise.reject(e);
        }
        return 0.0;
    }

    @ReactMethod
    public double getSystemLibraryPath(String environmentID, Promise promise) {
        try {
            String systemLibraryPath = Environment.getSystemLibraryPath();
            promise.resolve(systemLibraryPath);
        } catch (Exception e) {
            promise.reject(e);
        }
        return 0.0;
    }

}
