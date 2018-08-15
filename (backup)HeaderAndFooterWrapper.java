package com.crabsama.mywechat;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;


import androidx.recyclerview.widget.RecyclerView;

public class HeaderAndFooterWrapper<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int BASE_ITEM_TYPE_HEADER = 100000;
    private static final int BASE_ITEM_TYPE_FOOTER = 200000;

    private SparseArray<View> mHeaderViews = new SparseArray<>();
    private SparseArray<View> mFooterViews = new SparseArray<>();

    private RecyclerView.Adapter mInnerAdapter;

    public HeaderAndFooterWrapper(RecyclerView.Adapter adapter) {
        mInnerAdapter = adapter;
    }

    public int getHeadersCount(){
        return mHeaderViews.size();
    }

    public int getFootersCount(){
        return mFooterViews.size();
    }

    public void addHeaderView(View view){
        mHeaderViews.put(mHeaderViews.size() + BASE_ITEM_TYPE_HEADER,view);
    }

    public void addFooterView(View view){
        mFooterViews.put(mFooterViews.size() + BASE_ITEM_TYPE_FOOTER,view);
    }

    public boolean isHeaderView(int position){
        return position<getHeadersCount();
    }

    public boolean isFooterView(int position){
        return position>= getHeadersCount() + getRealItemCount();
    }

    private int getRealItemCount(){
        return mInnerAdapter.getItemCount();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(mHeaderViews.get(viewType) != null){
            ViewHolder holder = ViewHolder.createViewHolder(parent.getContext(),mHeaderViews.get(viewType));
            return holder;
        }else if (mFooterViews.get(viewType) != null){
            ViewHolder holder = ViewHolder.createViewHolder(parent.getContext(),mFooterViews.get(viewType));
            return holder;
        }
        return mInnerAdapter.onCreateViewHolder(parent,viewType);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(isHeaderView(position)){
            return;
        }
        if(isFooterView(position)){
            return;
        }
        mInnerAdapter.onBindViewHolder(holder,position - getHeadersCount());
    }

    @Override
    public int getItemViewType(int position) {
        if(isHeaderView(position)){
            return mHeaderViews.keyAt(position);
        }else if(isFooterView(position)){
            return mFooterViews.keyAt(position - getHeadersCount() - getRealItemCount());
        }
        return mInnerAdapter.getItemViewType(position - getHeadersCount());
    }

    @Override
    public int getItemCount() {
        return getHeadersCount() + getFootersCount() + getRealItemCount();
    }
}


class ViewHolder extends RecyclerView.ViewHolder{

    private SparseArray<View> mViews;
    private View mView;
    private Context mContext;

    public ViewHolder(Context context,View itemView) {
        super(itemView);
        mContext = context;
        mView = itemView;
        mViews = new SparseArray<View>();
    }

    public static ViewHolder createViewHolder(Context context, View itemView)
    {
        ViewHolder holder = new ViewHolder(context, itemView);
        return holder;
    }


}