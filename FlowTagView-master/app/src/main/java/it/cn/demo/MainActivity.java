package it.cn.demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import it.cn.flowtagview.Tag;
import it.cn.flowtagview.TagAdapter;
import it.cn.flowtagview.TagLayoutView;

public class MainActivity extends Activity {

    private TagLayoutView mTagLayoutView;
    private List<Tag> mTags = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_tag_activity);
        mTagLayoutView = (TagLayoutView) findViewById(R.id.tagview);
        setUpData();
        TagAdapter<Tag> adapter = new TagAdapter<>(mTags);
        mTagLayoutView.setTagAdapter(adapter);
        mTagLayoutView.setOnTagClickListener(new TagLayoutView.OnTagClickListener() {
            @Override
            public void onTagClick(View view, Tag tag) {
                Toast.makeText(MainActivity.this, "点击了", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setUpData() {
        String[] titles = {
                "蒋222介", "QQ2", "输22入", "微信", "加2勒比", "妹子22", "哇2222哦"
                , "嘿嘿", "村上222", "必备", "音乐", "父母", "必2备", "QQ"};
        for (int i = 0; i < titles.length; i++) {
            Tag tag = new Tag();
            tag.setId(i);
            tag.setChecked(true);
            tag.setTitle(titles[i]);
            mTags.add(tag);
        }
    }

    public void itemClick(View view) {
        Tag tag = new Tag();
        tag.setId(mTags.size() + 1);
        tag.setTitle("view");
        mTagLayoutView.addTag(tag);
    }
}



