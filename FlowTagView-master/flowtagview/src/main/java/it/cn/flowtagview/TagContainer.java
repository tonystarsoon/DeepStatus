package it.cn.flowtagview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.RelativeLayout;

/**
 * Created by tony on 2017/6/10.
 */
public class TagContainer extends RelativeLayout {
    private Context mContext;
    private int mMeasuredHeight;
    private int mMeasuredWidth;

    public TagContainer(@NonNull Context context) {
        super(context);
        this.mContext = context;
        setClickable(false);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mMeasuredHeight = getMeasuredHeight();
        mMeasuredWidth = getMeasuredWidth();
    }

    public int getContainerHeight() {
        return mMeasuredHeight;
    }

    public int getContainerWidth() {
        return mMeasuredWidth;
    }
}



