package com.zondy.mapgis.mobile.react.utils;

import android.graphics.Color;

/**
 * @author fjl 2019-6-18 下午2:52:36
 * @content 转换工具类
 */
public class ConvertUtil {
    /**
     * Android中int颜色值转js rgba颜色值
     *
     * @param color Android中int颜色值
     * @return
     */
    public static String ColorIntToRGBA(int color) {
        int alpha = (color & 0xff000000) >>> 24;
        int red = (color & 0x00ff0000) >> 16;
        int green = (color & 0x0000ff00) >> 8;
        int blue = (color & 0x000000ff);
        // 'rgba(128, 128, 128, 0.5)'
        String rgbaStr = "rgba(" + red + "," + green + "," + blue + "," + alpha + ")";
        return rgbaStr;
    }

    /**
     * js rgba颜色值转Android中int颜色值
     *
     * @param color js rgba , eg:'rgba(128, 128, 128, 0.5)'
     * @return
     */
    public static int ColorRGBAToInt(String color) {
        int alpha = 0;
        int red = 0;
        int green = 0;
        int blue = 0;

        if (!color.equalsIgnoreCase("") && !color.isEmpty()) {
            String strs1 = color.substring(color.indexOf("(") + 1, color.indexOf(")"));
            if (!color.equalsIgnoreCase("") && !strs1.isEmpty()) {
                String strs[] = strs1.split(",");
                if (strs != null && strs.length == 4) {
                    red = (int) Double.parseDouble(strs[0]);
                    green = (int) Double.parseDouble(strs[1]);
                    blue = (int) Double.parseDouble(strs[2]);
                    alpha = (int) Double.parseDouble(strs[3]);
                }
            }
        }


        return Color.argb(alpha, red, green, blue);
    }

}
