package it.com.dragmenu.util;

import android.os.Build;

/**
 * Created by admin on 2017/7/3.
 */

public class ConstantUtil {
    private static int mStatusHeight = 0;

    public static int getStatusHeight() {
        //只有版本在>=19并且<21的情况下,才需要拿到状态栏的真实高度后做适配
        if (false&&Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP && Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            return mStatusHeight;
        }
        return 0;
    }

    public static void setStatusHeight(int statusHeight) {
        mStatusHeight = statusHeight;
    }
}
