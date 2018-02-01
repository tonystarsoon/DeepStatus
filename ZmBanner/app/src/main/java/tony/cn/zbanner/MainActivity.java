package tony.cn.zbanner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import tony.cn.zbanner.loader.GlideImageLoader;
import tony.cn.zbanner.zmbanner.ZmBanner;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private ZmBanner zmBanner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] urls = getResources().getStringArray(R.array.url);
        List list = Arrays.asList(urls);
        List<String> images = new ArrayList(list);

        zmBanner = (ZmBanner) findViewById(R.id.zmbanner);
        zmBanner.setImages(images)
                .setImageLoader(new GlideImageLoader())
                .start();
    }
}
