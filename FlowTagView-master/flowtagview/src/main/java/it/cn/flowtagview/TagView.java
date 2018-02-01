package it.cn.flowtagview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

@SuppressLint("AppCompatCustomView")
public class TagView extends TextView {
    private float mPreRawX;
    private float mPreRawY;

    public TagView(Context context) {
        super(context);
        init();
    }

    public TagView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TagView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, 0);
        init();
    }

    private void init() {
        setText("");
    }
}
