package it.cn.flowtagview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class TagLayoutView extends FlowLayout implements OnClickListener {
    private static final String TAG = "TagLayoutView";
    private OnTagCheckedChangedListener mOnTagCheckedChangedListener;
    private OnTagClickListener mOnTagClickListener;
    private final List<Tag> mTags = new ArrayList<Tag>();
    private Context mContext;
    private TagAdapter mTagAdapter;
    private List<TagContainer> mContainerList = new ArrayList<TagContainer>();

    public TagLayoutView(Context context) {
        super(context);
        init(context);
    }

    public TagLayoutView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public TagLayoutView(Context context, AttributeSet attributeSet, int defStyle) {
        super(context, attributeSet, defStyle);
        init(context);
    }

    private void init(Context context) {
        mContext = context;
    }

    @Override
    public void onClick(View v) {
        Tag tag = (Tag) v.getTag();
        if (mOnTagClickListener != null) {
            mOnTagClickListener.onTagClick(v, tag);
        }
    }

    //设置数据适配器
    public void setTagAdapter(TagAdapter adapter) {
        mTagAdapter = adapter;
        changeAdapter();
    }

    //更新数据集合
    private void changeAdapter() {
        removeAllViews();
        mContainerList.clear();
        TagAdapter<Tag> adapter = mTagAdapter;
        TagContainer tagViewContainer = null;

        for (int i = 0; i < adapter.getCount(); i++) {
            Tag itemTag = adapter.getItem(i);
            View view = View.inflate(mContext, ConvertSource.getLayoutId(mContext, "tag"), null);
            TagView tagView = (TagView) view.findViewById(ConvertSource.getId(mContext, "tagTextView"));
            tagView.setText(itemTag.getTitle());
            tagViewContainer = new TagContainer(mContext);
            @SuppressWarnings("ResourceType")
            MarginLayoutParams lp = new MarginLayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            tagViewContainer.setLayoutParams(lp);
            tagViewContainer.setPadding(
                    DensityUtil.dp2px(mContext, 3),
                    DensityUtil.dp2px(mContext, 3),
                    DensityUtil.dp2px(mContext, 3),
                    DensityUtil.dp2px(mContext, 3));
            tagViewContainer.addView(view);
            view.setTag(itemTag);
            view.setOnClickListener(this);
            mContainerList.add(tagViewContainer);
            addView(tagViewContainer);
        }
    }

    private void addViewTag(Tag tag, boolean b) {
        TagContainer tagViewContainer = null;
        Tag itemTag = tag;
        View view = View.inflate(mContext, ConvertSource.getLayoutId(mContext, "tag"), null);
        TagView tagView = (TagView) view.findViewById(ConvertSource.getId(mContext, "tagTextView"));
        tagView.setText(itemTag.getTitle());
        tagViewContainer = new TagContainer(getContext());
        @SuppressWarnings("ResourceType")
        MarginLayoutParams lp = new MarginLayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        tagViewContainer.setLayoutParams(lp);
        tagViewContainer.setPadding(
                DensityUtil.dp2px(mContext, 3),
                DensityUtil.dp2px(mContext, 3),
                DensityUtil.dp2px(mContext, 3),
                DensityUtil.dp2px(mContext, 3));
        tagViewContainer.addView(view);
        view.setTag(itemTag);
        view.setOnClickListener(this);
        addView(tagViewContainer, 1);
        mContainerList.add(tagViewContainer);
    }

    public void addTag(Tag tag) {
        addTag(tag, false);
    }

    public void addTag(Tag tag, boolean b) {
        mTagAdapter.addTag(tag);
        addViewTag(tag, b);
    }

    public View getViewByTag(Tag tag) {
        return findViewWithTag(tag);
    }

    public void removeTag(Tag tag) {
        mTags.remove(tag);
        removeView(getViewByTag(tag));
    }

    public void setOnTagClickListener(OnTagClickListener onTagClickListener) {
        mOnTagClickListener = onTagClickListener;
    }

    public interface OnTagCheckedChangedListener {
        void onTagCheckedChanged(TagView tagView, Tag tag);
    }

    public interface OnTagClickListener {
        void onTagClick(View view, Tag tag);
    }
}
