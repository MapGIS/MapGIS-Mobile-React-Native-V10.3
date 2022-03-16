package com.zondy.mapgis.mobile.react.scene;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.android.graphic.GraphicImage3DAlignmentMode;
import com.zondy.mapgis.android.graphic.GraphicPlaceMarker;
import com.zondy.mapgis.android.graphic.GraphicText3DAlignmentMode;
import com.zondy.mapgis.core.geometry.Dot;
import com.zondy.mapgis.core.geometry.Dot3D;
import com.zondy.mapgis.mobile.react.JSDot;
import com.zondy.mapgis.mobile.react.JSDot3D;

/**
 * @auther LiaoLiang on 20-8-18
 * @content 场景地标图形
 */
public class JSGraphicPlaceMarker extends JSGraphic3D {
    private static final String REACT_CLASS = "JSGraphicPlaceMarker";

    @NonNull
    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public JSGraphicPlaceMarker(@NonNull ReactApplicationContext reactContext) {
        super(reactContext);
    }

    /**
     * 构造一个新的 GraphicPlaceMarker 对象
     * @param promise
     */
    @ReactMethod
    public void createObj(Promise promise) {
        try {
            GraphicPlaceMarker graphicPlaceMarker = new GraphicPlaceMarker();
            String graphicPlaceMarkerId = registerId(graphicPlaceMarker);

            WritableMap map = Arguments.createMap();
            map.putString("graphicPlaceMarkerId", graphicPlaceMarkerId);
            promise.resolve(map);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取边界线像素偏移
     * @param graphicPlaceMarkerId
     * @param promise
     */
    @ReactMethod
    public void getBorderlineOffset(String graphicPlaceMarkerId, Promise promise) {
        try {
            GraphicPlaceMarker graphicPlaceMarker = (GraphicPlaceMarker) getObjById(graphicPlaceMarkerId);
            float borderlineOffset = graphicPlaceMarker.getBorderlineOffset();

            promise.resolve(borderlineOffset);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取是否开启重叠检测
     * @param graphicPlaceMarkerId
     * @param promise
     */
    @ReactMethod
    public void getEnableDecluttering(String graphicPlaceMarkerId, Promise promise) {
        try {
            GraphicPlaceMarker graphicPlaceMarker = (GraphicPlaceMarker) getObjById(graphicPlaceMarkerId);
            boolean isEnableDecluttering = graphicPlaceMarker.getEnableDecluttering();

            promise.resolve(isEnableDecluttering);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取地标的方向角
     * @param graphicPlaceMarkerId
     * @param promise
     */
    @ReactMethod
    public void getImageHeading(String graphicPlaceMarkerId, Promise promise) {
        try {
            GraphicPlaceMarker graphicPlaceMarker = (GraphicPlaceMarker) getObjById(graphicPlaceMarkerId);
            float imageHeading = graphicPlaceMarker.getImageHeading();

            promise.resolve(imageHeading);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     *获取地标图片的路径
     * @param graphicPlaceMarkerId
     * @param promise
     */
    @ReactMethod
    public void getImagePath(String graphicPlaceMarkerId, Promise promise) {
        try {
            GraphicPlaceMarker graphicPlaceMarker = (GraphicPlaceMarker) getObjById(graphicPlaceMarkerId);
            String imagePath = graphicPlaceMarker.getImagePath();

            promise.resolve(imagePath);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取距离中心点像素偏移的id
     * @param graphicPlaceMarkerId
     * @param promise
     */
    @ReactMethod
    public void getLabelPixelOffset(String graphicPlaceMarkerId, Promise promise) {
        try {
            GraphicPlaceMarker graphicPlaceMarker = (GraphicPlaceMarker) getObjById(graphicPlaceMarkerId);
            Dot labelPixelOffset = graphicPlaceMarker.getLabelPixelOffset();
            String labelPixelOffsetId = JSDot.registerId(labelPixelOffset);

            promise.resolve(labelPixelOffsetId);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取地标标签
     * @param graphicPlaceMarkerId
     * @param promise
     */
    @ReactMethod
    public void getLabelText(String graphicPlaceMarkerId, Promise promise) {
        try {
            GraphicPlaceMarker graphicPlaceMarker = (GraphicPlaceMarker) getObjById(graphicPlaceMarkerId);
            String labelText = graphicPlaceMarker.getLabelText();

            promise.resolve(labelText);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取标签字体大小
     * @param graphicPlaceMarkerId
     * @param promise
     */
    @ReactMethod
    public void getLabelTextSize(String graphicPlaceMarkerId, Promise promise) {
        try {
            GraphicPlaceMarker graphicPlaceMarker = (GraphicPlaceMarker) getObjById(graphicPlaceMarkerId);
            int labelTextSize = graphicPlaceMarker.getLabelTextSize();

            promise.resolve(labelTextSize);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取地标位置Dot3D的id
     * @param graphicPlaceMarkerId
     * @param promise
     */
    @ReactMethod
    public void getPostion(String graphicPlaceMarkerId, Promise promise) {
        try {
            GraphicPlaceMarker graphicPlaceMarker = (GraphicPlaceMarker) getObjById(graphicPlaceMarkerId);
            Dot3D dot3D = graphicPlaceMarker.getPostion();
            String positionId = JSDot3D.registerId(dot3D);

            promise.resolve(positionId);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 设置边界线像素偏移
     * @param graphicPlaceMarkerId
     * @param offset 偏移像素
     * @param promise
     */
    @ReactMethod
    public void setBorderlineOffset(String graphicPlaceMarkerId, float offset, Promise promise) {
        try {
            GraphicPlaceMarker graphicPlaceMarker = (GraphicPlaceMarker) getObjById(graphicPlaceMarkerId);
            graphicPlaceMarker.setBorderlineOffset(offset);

            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     *设置是否开启重叠检测
     * @param graphicPlaceMarkerId
     * @param enabled 是否开启重叠检测
     * @param promise
     */
    @ReactMethod
    public void setEnableDecluttering(String graphicPlaceMarkerId, boolean enabled, Promise promise) {
        try {
            GraphicPlaceMarker graphicPlaceMarker = (GraphicPlaceMarker) getObjById(graphicPlaceMarkerId);
            graphicPlaceMarker.setEnableDecluttering(enabled);

            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 设置地标的方向角
     * @param graphicPlaceMarkerId
     * @param headingAngle 方向角
     * @param promise
     */
    @ReactMethod
    public void setImageHeading(String graphicPlaceMarkerId, float headingAngle, Promise promise) {
        try {
            GraphicPlaceMarker graphicPlaceMarker = (GraphicPlaceMarker) getObjById(graphicPlaceMarkerId);
            graphicPlaceMarker.setImageHeading(headingAngle);

            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 设置地标图片位置
     * @param graphicPlaceMarkerId
     * @param imagePath 图片路径
     * @param promise
     */
    @ReactMethod
    public void setImagePath(String graphicPlaceMarkerId, String imagePath, Promise promise) {
        try {
            GraphicPlaceMarker graphicPlaceMarker = (GraphicPlaceMarker) getObjById(graphicPlaceMarkerId);
            graphicPlaceMarker.setImagePath(imagePath);

            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 设置距离中心点像素偏移
     * @param graphicPlaceMarkerId
     * @param pixelOffsetDotId 中心点像素偏移 (相对于(0,0)像素)dot的id
     * @param promise
     */
    @ReactMethod
    public void setLabelPixelOffset(String graphicPlaceMarkerId, String pixelOffsetDotId, Promise promise) {
        try {
            GraphicPlaceMarker graphicPlaceMarker = (GraphicPlaceMarker) getObjById(graphicPlaceMarkerId);
            Dot pixelOffsetDot = JSDot.getObjFromList(pixelOffsetDotId);
            graphicPlaceMarker.setLabelPixelOffset(pixelOffsetDot);

            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 设置标签
     * @param graphicPlaceMarkerId
     * @param text
     * @param promise
     */
    @ReactMethod
    public void setLabelText(String graphicPlaceMarkerId, String text, Promise promise) {
        try {
            GraphicPlaceMarker graphicPlaceMarker = (GraphicPlaceMarker) getObjById(graphicPlaceMarkerId);
            graphicPlaceMarker.setLabelText(text);

            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 设置标签字体大小
     * @param graphicPlaceMarkerId
     * @param textSize
     * @param promise
     */
    @ReactMethod
    public void setLabelTextSize(String graphicPlaceMarkerId, int textSize, Promise promise) {
        try {
            GraphicPlaceMarker graphicPlaceMarker = (GraphicPlaceMarker) getObjById(graphicPlaceMarkerId);
            graphicPlaceMarker.setLabelTextSize(textSize);

            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 设置地标位置
     * @param graphicPlaceMarkerId
     * @param dot3DId 场景地理坐标 Dot3D 的 id
     * @param promise
     */
    @ReactMethod
    public void setPosition(String graphicPlaceMarkerId, String dot3DId, Promise promise) {
        try {
            GraphicPlaceMarker graphicPlaceMarker = (GraphicPlaceMarker) getObjById(graphicPlaceMarkerId);
            Dot3D dot3D = JSDot3D.getObjFromList(dot3DId);
            graphicPlaceMarker.setPosition(dot3D);

            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取图片的对齐方式的值
     * @param graphicPlaceMarkerId
     * @param promise
     */
    @ReactMethod
    public void getImageAlignment(String graphicPlaceMarkerId, Promise promise) {
        try {
            GraphicPlaceMarker graphicPlaceMarker = (GraphicPlaceMarker) getObjById(graphicPlaceMarkerId);
            GraphicImage3DAlignmentMode graphicImage3DAlignmentMode = graphicPlaceMarker.getImageAlignment();

            promise.resolve(graphicImage3DAlignmentMode.value());
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 获取文本对齐方式的值
     * @param graphicPlaceMarkerId
     * @param promise
     */
    @ReactMethod
    public void getLabelAlignment(String graphicPlaceMarkerId, Promise promise) {
        try {
            GraphicPlaceMarker graphicPlaceMarker = (GraphicPlaceMarker) getObjById(graphicPlaceMarkerId);
            GraphicText3DAlignmentMode graphicText3DAlignmentMode = graphicPlaceMarker.getLabelAlignment();

            promise.resolve(graphicText3DAlignmentMode.value());
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     * 设置图片对齐方式
     * @param graphicPlaceMarkerId
     * @param alignmentmodeValue
     * @param promise
     */
    @ReactMethod
    public void setImageAlignment(String graphicPlaceMarkerId, int alignmentmodeValue, Promise promise) {
        try {
            GraphicPlaceMarker graphicPlaceMarker = (GraphicPlaceMarker) getObjById(graphicPlaceMarkerId);
            GraphicImage3DAlignmentMode graphicImage3DAlignmentMode = JSGraphicImage3DAlignmentMode
                    .getGraphicImage3DAlignmentModeValue(alignmentmodeValue);
            graphicPlaceMarker.setImageAlignment(graphicImage3DAlignmentMode);

            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    /**
     *设置文本对齐方式
     * @param graphicPlaceMarkerId
     * @param alignmentmodeValue
     * @param promise
     */
    @ReactMethod
    public void setLabelAlignment(String graphicPlaceMarkerId, int alignmentmodeValue, Promise promise) {
        try {
            GraphicPlaceMarker graphicPlaceMarker = (GraphicPlaceMarker) getObjById(graphicPlaceMarkerId);
            GraphicText3DAlignmentMode graphicText3DAlignmentMode = JSGraphicText3DAlignmentMode
                    .getGraphicText3DAlignmentModeValue(alignmentmodeValue);
            graphicPlaceMarker.setLabelAlignment(graphicText3DAlignmentMode);

            promise.resolve(true);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

}
