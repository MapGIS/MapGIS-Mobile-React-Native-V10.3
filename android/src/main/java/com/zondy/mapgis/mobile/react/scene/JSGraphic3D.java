package com.zondy.mapgis.mobile.react.scene;

import android.util.Log;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.android.graphic.AltitudeMode;
import com.zondy.mapgis.android.graphic.Graphic3D;
import com.zondy.mapgis.android.graphic.GraphicState;
import com.zondy.mapgis.core.geometry.Dot;
import com.zondy.mapgis.core.geometry.Dot3D;
import com.zondy.mapgis.core.geometry.Geometry;
import com.zondy.mapgis.core.geometry.Rect;
import com.zondy.mapgis.core.geometry.Rect3D;
import com.zondy.mapgis.mobile.react.JSDot;
import com.zondy.mapgis.mobile.react.JSDot3D;
import com.zondy.mapgis.mobile.react.JSGeometry;
import com.zondy.mapgis.mobile.react.JSRect;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @auther LiaoLiang on 20-8-12
 * @content 场景图形基类
 */
public class JSGraphic3D extends ReactContextBaseJavaModule {
    private static final String REACT_CLASS = "JSGraphic3D";
    private static String Tag = "JSGraphic3D";
    private static Map<String, Graphic3D> graphic3DList = new HashMap<>();

    @NonNull
    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public JSGraphic3D(@NonNull ReactApplicationContext reactContext) {
        super(reactContext);
    }

    /**
     * 在native层注册一个Graphic3D的id,并返回该id供JS层调用。
     * 注册前先判断该Graphic3D是否已经存在，如果存在，返回已经存在的ID，如果不存在，创建新的ID以返回。
     * @param graphic3D
     * @return
     */
    public static String registerId(Graphic3D graphic3D) {
        for (Map.Entry entry : graphic3DList.entrySet()) {
            if (graphic3D.equals(entry.getValue())) {
                return (String) entry.getKey();
            }
        }
        String id = UUID.randomUUID().toString().substring(24);
        graphic3DList.put(id,graphic3D);
        Log.i(Tag,"id:"+id);
        return id;
    }

    /**
     * 根据id获取Graphic3D实例
     * @param id
     * @return
     */
    public static Graphic3D getObjById(String id) {
        return graphic3DList.get(id);
    }

    /**
     * 构造一个新的Graphic3D对象
     * @param promise
     */
    @ReactMethod
    public void createObj(Promise promise) {
        try {
            Graphic3D graphic3D = new Graphic3D(){};
            String graphic3DId = registerId(graphic3D);

            WritableMap writableMap = Arguments.createMap();
            writableMap.putString("graphic3DId",graphic3DId);
            promise.resolve(writableMap);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取高程模式的值
     * @param graphic3DId
     * @param promise
     */
    @ReactMethod
    public void getAltitudeMode(String graphic3DId, Promise promise) {
        try {
            Graphic3D graphic3D = getObjById(graphic3DId);
            int altitudeModeValue = graphic3D.getAltitudeMode().value();

            promise.resolve(altitudeModeValue);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 根据索引获取图形属性名
     * @param graphic3DId
     * @param index 图形属性的索引，从0开始到属性数目减1
     * @param promise
     */
    @ReactMethod
    public void getAttributeName(String graphic3DId, String index, Promise promise) {
        try {
            Graphic3D graphic3D = getObjById(graphic3DId);
            String attributeName = graphic3D.getAttributeName(Long.parseLong(index));

            promise.resolve(attributeName);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取图形属性的数目
     * @param graphic3DId
     * @param promise
     */
    @ReactMethod
    public void getAttributeNum(String graphic3DId, Promise promise) {
        try {
            Graphic3D graphic3D = getObjById(graphic3DId);
            String attributeNum = String.valueOf(graphic3D.getAttributeNum());

            promise.resolve(attributeNum);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 根据索引获取图形属性值
     * @param graphic3DId
     * @param index 图形属性的索引，从0开始到属性数目减1
     * @param promise
     */
    @ReactMethod
    public void getAttributeValue(String graphic3DId, String index, Promise promise) {
        try {
            Graphic3D graphic3D = getObjById(graphic3DId);
            String attributeValue = graphic3D.getAttributeValue(Long.parseLong(index));

            promise.resolve(attributeValue);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     *根据属性名称获取图形属性值
     * @param graphic3DId
     * @param name 图形属性名
     * @param promise
     */
    @ReactMethod
    public void getAttributeValueByName(String graphic3DId, String name, Promise promise) {
        try {
            Graphic3D graphic3D = getObjById(graphic3DId);
            String attributeValue = graphic3D.getAttributeValue(name);

            promise.resolve(attributeValue);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取场景覆盖物矩形外包的ID
     * @param graphic3DId
     * @param promise
     */
    @ReactMethod
    public void getBoundingBox(String graphic3DId, Promise promise) {
        try {
            Graphic3D graphic3D = getObjById(graphic3DId);
            Rect3D rect3D = graphic3D.getBoundingBox();
            String rect3DId = JSRect3D.registerId(rect3D);

            promise.resolve(rect3DId);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取外包ID
     * @param graphic3DId
     * @param promise
     */
    @ReactMethod
    public void getBoundingRect(String graphic3DId, Promise promise) {
        try {
            Graphic3D graphic3D = getObjById(graphic3DId);
            Rect rect = graphic3D.getBoundingRect();
            String rectId = JSRect.registerId(rect);

            promise.resolve(rectId);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取中心点id
     * @param graphic3DId
     * @param promise
     */
    @ReactMethod
    public void getCenterPoint(String graphic3DId, Promise promise) {
        try {
            Graphic3D graphic3D = getObjById(graphic3DId);
            Dot dot = graphic3D.getCenterPoint();
            String dotId = JSDot.registerId(dot);

            promise.resolve(dotId);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取图形的地理坐标id
     * @param graphic3DId
     * @param promise
     */
    @ReactMethod
    public void getCenterPoint3D(String graphic3DId, Promise promise) {
        try {
            Graphic3D graphic3D = getObjById(graphic3DId);
            Dot3D dot3D = graphic3D.getCenterPoint3D();
            String dot3DId = JSDot3D.registerId(dot3D);

            promise.resolve(dot3DId);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取图形颜色
     * @param graphic3DId
     * @param promise
     */
    @ReactMethod
    public void getColor(String graphic3DId, Promise promise) {
        try {
            Graphic3D graphic3D = getObjById(graphic3DId);
            int color = graphic3D.getColor();

            promise.resolve(color);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取图形类型的值
     * @param graphic3DId
     * @param promise
     */
    @ReactMethod
    public void getGraphicType(String graphic3DId, Promise promise) {
        try {
            Graphic3D graphic3D = getObjById(graphic3DId);
            int graphicTypeValue = graphic3D.getGraphicType().value();

            promise.resolve(graphicTypeValue);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取图形的可见状态
     * @param graphic3DId
     * @param promise
     */
    @ReactMethod
    public void getState(String graphic3DId, Promise promise) {
        try {
            Graphic3D graphic3D = getObjById(graphic3DId);
            int state = graphic3D.getState();

            promise.resolve(state);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取点是否为像素单位
     * @param graphic3DId
     * @param promise
     */
    @ReactMethod
    public void isPointByPixel(String graphic3DId, Promise promise) {
        try {
            Graphic3D graphic3D = getObjById(graphic3DId);
            boolean isPointByPixelValue = graphic3D.isPointByPixel();

            promise.resolve(isPointByPixelValue);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 移除所有属性
     * @param graphic3DId
     * @param promise
     */
    @ReactMethod
    public void removeAllAttributes(String graphic3DId, Promise promise) {
        try {
            Graphic3D graphic3D = getObjById(graphic3DId);
            graphic3D.removeAllAttributes();

            promise.resolve(true);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 移除指定名称的属性
     * @param graphic3DId
     * @param name 将要移除的属性的名称
     * @param promise
     */
    @ReactMethod
    public void removeAttribute(String graphic3DId, String name, Promise promise) {
        try {
            Graphic3D graphic3D = getObjById(graphic3DId);
            graphic3D.removeAttribute(name);

            promise.resolve(true);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     *设置高程模式
     * @param graphic3DId
     * @param altitudeModeValue 高程模式的值
     * @param promise
     */
    @ReactMethod
    public void setAltitudeMode(String graphic3DId, int altitudeModeValue, Promise promise) {
        try {
            Graphic3D graphic3D = getObjById(graphic3DId);
            JSAltitudeMode jsAltitudeMode = new JSAltitudeMode(getReactApplicationContext());
            AltitudeMode altitudeMode = jsAltitudeMode.getAltitudeModeByValue(altitudeModeValue);
            int result = graphic3D.setAltitudeMode(altitudeMode); //成功返回1 ,失败返回0

            promise.resolve(result);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     *设置图形的属性
     * @param graphic3DId
     * @param name 属性名称
     * @param value 属性值
     * @param promise
     */
    @ReactMethod
    public void setAttributeValue(String graphic3DId, String name, String value, Promise promise) {
        try {
            Graphic3D graphic3D = getObjById(graphic3DId);
            graphic3D.setAttributeValue(name,value);

            promise.resolve(true);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 设置图形颜色
     * @param graphic3DId
     * @param color 将要设置的颜色,可通过android.graphics.Color提供的方法生成.如：int myColor = Color.argb(255, 255, 128, 128);
     * @param promise
     */
    @ReactMethod
    public void setColor(String graphic3DId, int color, Promise promise) {
        try {
            Graphic3D graphic3D = getObjById(graphic3DId);
            graphic3D.setColor(color);

            promise.resolve(true);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 设置点是否为像素单位(默认情况下为地图单位)
     * @param graphic3DId
     * @param pixel 点是否为像素单位
     * @param promise
     */
    @ReactMethod
    public void setPointByPixel(String graphic3DId, boolean pixel, Promise promise) {
        try {
            Graphic3D graphic3D = getObjById(graphic3DId);
            graphic3D.setPointByPixel(pixel);

            promise.resolve(true);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 控制图层可见性
     * @param graphic3DId
     * @param graphicStateValue
     * @param promise
     */
    @ReactMethod
    public void setState(String graphic3DId, int graphicStateValue, Promise promise) {
        try {
            Graphic3D graphic3D = getObjById(graphic3DId);
            JSGraphicState jsGraphicState = new JSGraphicState(getReactApplicationContext());
            GraphicState graphicState = jsGraphicState.getGraphicStateByValue(graphicStateValue);
            graphic3D.setState(graphicState);

            promise.resolve(true);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 覆盖物图层转几何对象
     * @param graphic3DId
     * @param toGeometryGraphic3DId 覆盖物图层id
     * @param promise
     */
    @ReactMethod
    public void toGeometry(String graphic3DId, String toGeometryGraphic3DId, Promise promise) {
        try {
            Graphic3D graphic3D = getObjById(graphic3DId);
            Graphic3D toGeometryGraphic3D = getObjById(toGeometryGraphic3DId);
            Geometry geometry = graphic3D.toGeometry(toGeometryGraphic3D);
            String geometryId = JSGeometry.registerId(geometry);

            promise.resolve(geometryId);
        }catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 将几何对象转换为图形对象.
     * @param graphic3DId
     * @param geometryId
     * @param promise
     */
    @ReactMethod
    public void toGraphicsFromGeometry(String graphic3DId, String geometryId, Promise promise) {
        try {
            Graphic3D graphic3D = getObjById(graphic3DId);
            Geometry geometry = JSGeometry.getObjFromList(geometryId);
            List<Graphic3D> graphic3DS = graphic3D.toGraphicsFromGeometry(geometry);
            WritableArray array = Arguments.createArray();
            for (Graphic3D graphic3DFromGeometry : graphic3DS) {
                array.pushString(registerId(graphic3DFromGeometry));
            }

            promise.resolve(array);
        }catch (Exception e) {
            promise.reject(e);
        }
    }
}
