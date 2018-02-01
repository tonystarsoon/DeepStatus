package it.cn.flowtagview;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.TypedValue;

/**
 * 自定义属性的相关的工具类
 * 通过TypedArray和指定的属性类获取到自定义属性的值.
 * Created by admin on 2017/7/24.
 */
public class AttrUtils {
    public static float dp2px(float dp) {
        Resources r = Resources.getSystem();
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics());
    }

    public static int dp2pxInt(float dp) {
        return (int) dp2px(dp);
    }

    public static int optInt(TypedArray typedArray,
                             int index,
                             int def) {
        if (typedArray == null) {
            return def;
        }
        return typedArray.getInt(index, def);
    }

    public static float optPixelSize(TypedArray typedArray,
                                     int index,
                                     float def) {
        if (typedArray == null) {
            return def;
        }
        return typedArray.getDimension(index, def);
    }

    public static int optPixelSize(TypedArray typedArray,
                                   int index,
                                   int def) {
        if (typedArray == null) {
            return def;
        }
        return typedArray.getDimensionPixelOffset(index, def);
    }

    public static int optColor(TypedArray typedArray,
                               int index,
                               int def) {
        if (typedArray == null) {
            return def;
        }
        return typedArray.getColor(index, def);
    }

    public static boolean optBoolean(TypedArray typedArray,
                                     int index,
                                     boolean def) {
        if (typedArray == null) {
            return def;
        }
        return typedArray.getBoolean(index, def);
    }

    public static int optResource(TypedArray typedArray,
                                  int index,
                                  int def) {
        if (typedArray == null) {
            return def;
        }
        return typedArray.getResourceId(index, def);
    }

    public static String optString(TypedArray typedArray,
                                   int index) {
        if (typedArray == null) {
            return null;
        }
        return typedArray.getString(index);
    }

    public static boolean hasValue(TypedArray typedArray,
                                   int index) {
        if (typedArray == null) {
            return false;
        }
        return typedArray.hasValue(index);
    }
}
