package tony.cn.deepstatus;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import java.io.File;
import java.lang.reflect.Field;

public class MainActivity extends Activity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        File cacheDir = this.getCacheDir();
        Log.i(TAG, "onCreate: ------dir:" + cacheDir.getAbsolutePath());
    }

    /**
     * 完全沉浸式
     *
     * @param view
     */
    public void first(View view) {
        Intent intent = new Intent(this, FirstActivity.class);
        startActivity(intent);
    }

    /**
     * 透明
     *
     * @param view
     */
    public void second(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

    /**
     * 半透明
     *
     * @param view
     */
    public void third(View view) {
        Intent intent = new Intent(this, ThirdActivity.class);
        startActivity(intent);
    }
}

