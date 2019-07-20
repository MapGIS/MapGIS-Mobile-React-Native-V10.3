package com.zondy.mapgis.mobile.react;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;

import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import sun.misc.BASE64Decoder;

/**
 * @author fjl 2019-6-20 下午2:52:36
 * @content 图片对象Native组件
 */
public class JSImage extends ReactContextBaseJavaModule {
    public static final String REACT_CLASS = "JSImage";
    public static Map<String, Bitmap> mBitmapList = new HashMap<String, Bitmap>();

    public JSImage(ReactApplicationContext context) {
        super(context);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public static Bitmap getObjFromList(String id) {
        return mBitmapList.get(id);
    }


    public static String registerId(Bitmap obj) {
        for (Map.Entry entry : mBitmapList.entrySet()) {
            if (obj.equals(entry.getValue())) {
                String id = (String) entry.getKey();
                mBitmapList.put(id, obj);
                return (String) entry.getKey();
            }
        }

        Calendar calendar = Calendar.getInstance();
        String id = Long.toString(calendar.getTimeInMillis());
        mBitmapList.put(id, obj);
        return id;
    }

    @ReactMethod
    public void createObj(Promise promise) {
        try {
            Bitmap bitmap = getBitmapFromByte("temp".getBytes());
            String imageId = registerId(bitmap);

            WritableMap map = Arguments.createMap();
            map.putString("imageId", imageId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void createObjByProperty(String base64Url, Promise promise) {
        try {
            Bitmap bitmap = getBitmapFromByte(base64UrlToImage(base64Url));
            String imageId = registerId(bitmap);

            WritableMap map = Arguments.createMap();
            map.putString("imageId", imageId);
            Log.d("createObjByProperty", "createObjByProperty() run!!!");
            Log.d("imageId", imageId);

            promise.resolve(map);

        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setBase64Url(String imageId, String base64Url, Promise promise) {
        try {
            Bitmap bitmap = getObjFromList(imageId);
            bitmap = getBitmapFromByte(base64UrlToImage(base64Url));
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getWidth(String imageId, Promise promise) {
        try {
            Bitmap bitmap = getObjFromList(imageId);
            double width = bitmap.getWidth();
            promise.resolve(width);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public double getHeight(String imageId, Promise promise) {
        try {
            Bitmap bitmap = getObjFromList(imageId);
            double height = bitmap.getHeight();
            promise.resolve(height);

        } catch (Exception e) {
            promise.reject(e);
        }
        return 0.0;
    }

    /**
     * 根据图片base64url返回图片二进制
     *
     * @param base64Url 图片base64url
     * @return
     */
    public static byte[] base64UrlToImage(String base64Url) {

        byte[] imageBytes = null;

        if (base64Url == null || base64Url.equalsIgnoreCase("")) {
            return null;
        }

        // 数据中的 "+"会因为传递变为 " "空格
        base64Url = base64Url.replaceAll(" ", "+");
        String[] strs = base64Url.split(",");
        if (strs.length == 2) {
            base64Url = strs[1];
        }

        BASE64Decoder decoder = new BASE64Decoder();

        try {
            imageBytes = decoder.decodeBuffer(base64Url);

            return imageBytes;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imageBytes;
    }


    public static Bitmap getBitmapFromByte(byte[] temp) {
        if (temp != null) {
            Bitmap bitmap = BitmapFactory.decodeByteArray(temp, 0, temp.length);
            return bitmap;
        } else {
            return null;
        }
    }
}
