package it.com.dragmenu.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import it.com.dragmenu.model.Item;

/**
 *
 */
public class AnswersAdapter extends RecyclerView.Adapter<AnswersAdapter.ViewHolder> {
    private List<Item> mItems;
    private Context mContext;
    private PostItemListener mItemListener;


    public AnswersAdapter(Context context, List<Item> posts) {
        mItems = posts;
        mContext = context;
    }

    public AnswersAdapter(Context context, List<Item> posts, PostItemListener itemListener) {
        mItems = posts;
        mContext = context;
        mItemListener = itemListener;
    }

    @Override
    public AnswersAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View postView = inflater.inflate(android.R.layout.simple_list_item_1, parent, false);
        return new ViewHolder(postView);
    }

    @Override
    public void onBindViewHolder(AnswersAdapter.ViewHolder holder, int position) {
        Item item = mItems.get(position);
        TextView textView = holder.titleTv;
        textView.setText(item.getOwner().getDisplayName());
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public void updateAnswers(List<Item> items) {
        mItems = items;
        notifyDataSetChanged();
    }

    private Item getItem(int adapterPosition) {
        return mItems.get(adapterPosition);
    }

    /**
     * 设置条目的点击事件
     * @param itemListener
     */
    public void setOnItemClickListener(PostItemListener itemListener) {
        mItemListener = itemListener;
    }

    /**
     * 条目的点击事件回调接口.
     */
    public interface PostItemListener {
        void onPostClick(long id);
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView titleTv;

        ViewHolder(View itemView) {
            super(itemView);
            titleTv = (TextView) itemView.findViewById(android.R.id.text1);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mItemListener != null) {
                Item item = getItem(getAdapterPosition());
                mItemListener.onPostClick(item.getAnswerId());
                notifyDataSetChanged();
            }
        }
    }
}

