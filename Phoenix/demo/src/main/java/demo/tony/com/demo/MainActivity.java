package demo.tony.com.demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import refresh.library.PullToRefreshView;

public class MainActivity extends Activity implements PullToRefreshView.OnRefreshListener {
    private ListView mListView;
    private List<String> mList = new ArrayList<>();
    private PullToRefreshView refreshView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = findViewById(R.id.list_view);
        refreshView = findViewById(R.id.refreshview);
        refreshView.setOnRefreshListener(this);
        initData();
        MyAdapter myAdapter = new MyAdapter();
        mListView.setAdapter(myAdapter);
    }

    private void initData() {
        for (int i = 0; i < 40; i++) {
            mList.add(" n i h a o " + i);
        }
    }

    private class MyAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return mList.size();
        }

        @Override
        public Object getItem(int i) {
            return i;
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup viewGroup) {
            TextView view = (TextView) convertView;
            if (view == null) {
                view = new TextView(MainActivity.this);
            }
            view.setText(mList.get(position));
            return view;
        }
    }

    @Override
    public void onRefresh() {
        mListView.postDelayed(new Runnable() {
            @Override
            public void run() {
                refreshView.setRefreshing(false);
                Toast.makeText(MainActivity.this, "refresh completed", Toast.LENGTH_SHORT).show();
            }
        }, 3000);
    }
}

