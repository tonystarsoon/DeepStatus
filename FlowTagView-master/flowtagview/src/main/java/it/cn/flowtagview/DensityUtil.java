package it.cn.flowtagview;

import android.content.Context;

/**
 * Created by tony on 2017/4/3.
 */

public class DensityUtil {
    public static int px2dp(Context context, int px) {
        float density = context.getResources().getDisplayMetrics().density;
        return (int) (px / density);
    }

    public static int dp2px(Context context, int dp) {
        float density = context.getResources().getDisplayMetrics().density;
        return (int) (density * dp + 0.5f);
    }
}
