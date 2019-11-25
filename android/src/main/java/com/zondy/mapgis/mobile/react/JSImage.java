package com.zondy.mapgis.mobile.react;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.PixelFormat;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.net.Uri;
import android.os.Environment;
import android.os.StrictMode;
import android.text.TextUtils;

import com.facebook.common.util.UriUtil;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nullable;

import sun.misc.BASE64Decoder;

/**
 * @author fjl 2019-6-20 下午2:52:36
 * @content 图片对象Native组件
 */
public class JSImage extends ReactContextBaseJavaModule {
    public static final String REACT_CLASS = "JSImage";
    public static Map<String, Bitmap> mBitmapList = new HashMap<String, Bitmap>();
    private static final String FILE_SCHEME = "file";
    Context m_Context = null;
    private Map<String, Integer> mResourceDrawableIdMap;

    public JSImage(ReactApplicationContext context) {
        super(context);
        m_Context = context.getApplicationContext();
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
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void createObjByLocalPath(String path, Promise promise) {
        try {
            File f = new File(path);
            Bitmap bitmap = null;
            String imageId = null;
            if (f.exists()) {
                bitmap = BitmapFactory.decodeFile(path);
                if(bitmap != null)
                {
                    imageId = registerId(bitmap);
                }
            }

            WritableMap map = Arguments.createMap();
            map.putString("imageId", imageId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    public Bitmap loadImage(String iconUri, boolean isDebug){
        if (TextUtils.isEmpty(iconUri)) {
            return null;
        }
        if (isDebug) {
            return loadIcon(iconUri);
        } else {
            Uri uri = Uri.parse(iconUri);
            if (isLocalFile(uri)) {
                // 本地文件
                return loadFile(uri);
            } else {
                return loadResource(iconUri);
            }
        }
    }

    public Bitmap loadIcon(String iconDevUri) {
        try {
            StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitNetwork().build());

            Bitmap drawable = tryLoadIcon(iconDevUri);

            StrictMode.setThreadPolicy(threadPolicy);
            return drawable;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 因为是开发者模式，图片资源的uri都是从package server加载的图片，所以uri是以http://开头
     * 所以我们需要用URL获取流，继而转成bitmap
     * @param iconDevUri
     * iconDevUri: http://10.0.3.2:8081/assets/Images/icon.jpg?platform=android&hash=c951e2c8cf473f91811ea292c6cd364c
     * @return
     * @throws IOException
     */
    private Bitmap tryLoadIcon(String iconDevUri) throws IOException {
        URL url = new URL(iconDevUri);
        Bitmap bitmap = BitmapFactory.decodeStream(url.openStream());
//        BitmapDrawable bitmapDrawable = new BitmapDrawable(MainApplication.instance.getResources(), bitmap);
//        Log.e("JsDevImageLoader", "bitmap drawable width：" + bitmapDrawable.getIntrinsicWidth());
        return bitmap;
    }

    /**
     * 判断图片是否存在手机本地目录
     * @param uri
     * @return
     */
    private boolean isLocalFile(Uri uri) {
        return FILE_SCHEME.equals(uri.getScheme());
    }

    /**
     * 加载手机本地目录图片
     * @param uri
     * @return
     */
    private Bitmap loadFile(Uri uri) {
        Bitmap bitmap = BitmapFactory.decodeFile(uri.getPath());
       // return new BitmapDrawable(MainApplication.instance.getResources(), bitmap);
        return bitmap;
    }

    /**
     * 加载drawable目录下的图片
     * @param iconUri
     * @return
     */
    private Bitmap loadResource(String iconUri) {
        return getResourceDrawable(m_Context, iconUri);
    }


    /**
     * 获取 drawable资源 id
     * @param context
     * @param name
     * @return
     */
    public int getResourceDrawableId(Context context, @Nullable String name) {
        if (name == null || name.isEmpty()) {
            return 0;
        }
        name = name.toLowerCase().replace("-", "_");
        if (mResourceDrawableIdMap.containsKey(name)) {
            return mResourceDrawableIdMap.get(name);
        }
        int id = context.getResources().getIdentifier(
                name,
                "drawable",
                context.getPackageName());
        mResourceDrawableIdMap.put(name, id);
        return id;
    }

    /**
     * 根据 drawable 资源 id 获取 Drawable
     * @param context
     * @param name
     * @return
     */
    @Nullable
    public Bitmap getResourceDrawable(Context context, @Nullable String name) {
        int resId = getResourceDrawableId(context, name);
        if(resId > 0)
        {
           Drawable drawable = context.getResources().getDrawable(resId);
          if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
          } else if (drawable instanceof NinePatchDrawable) {
            Bitmap bitmap = Bitmap
                    .createBitmap(
                            drawable.getIntrinsicWidth(),
                            drawable.getIntrinsicHeight(),
                            drawable.getOpacity() != PixelFormat.OPAQUE ? Bitmap.Config.ARGB_8888
                                    : Bitmap.Config.RGB_565);
            Canvas canvas = new Canvas(bitmap);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(),
                    drawable.getIntrinsicHeight());
            drawable.draw(canvas);
            return bitmap;
          } else {
            return null;
          }
        }
       return  null;
    }

    /**
     * 获取drawable资源Uri
     * @param context
     * @param name
     * @return
     */
    public Uri getResourceDrawableUri(Context context, @Nullable String name) {
        int resId = getResourceDrawableId(context, name);
        return resId > 0 ? new Uri.Builder()
                .scheme(UriUtil.LOCAL_RESOURCE_SCHEME)
                .path(String.valueOf(resId))
                .build() : Uri.EMPTY;
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
