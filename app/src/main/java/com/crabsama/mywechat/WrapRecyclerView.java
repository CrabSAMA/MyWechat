package com.crabsama.mywechat;

import androidx.recyclerview.widget.RecyclerView;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;

/**
 * 百度回来的为RecyclerView添加头尾布局的一个RecyclerView包装类，但是用不了，无法正常添加头尾布局，先搁置了
 */
public class WrapRecyclerView extends RecyclerView {

    private ArrayList<View> mHeaderViews = new ArrayList<>() ;

    private ArrayList<View> mFootViews = new ArrayList<>() ;

    private Adapter mAdapter ;

    public WrapRecyclerView(Context context) {
        super(context);
    }

    public WrapRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public WrapRecyclerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void addHeaderView(View view){
        mHeaderViews.clear();
        mHeaderViews.add(view);
        if (mAdapter != null){
            if (!(mAdapter instanceof RecyclerWrapAdapter)){
                mAdapter = new RecyclerWrapAdapter(mHeaderViews,mFootViews,mAdapter) ;
//                mAdapter.notifyDataSetChanged();
            }
        }
    }

    public void addFootView(View view){
        mFootViews.clear();
        mFootViews.add(view);
        if (mAdapter != null){
            if (!(mAdapter instanceof RecyclerWrapAdapter)){
                mAdapter = new RecyclerWrapAdapter(mHeaderViews,mFootViews,mAdapter) ;
//                mAdapter.notifyDataSetChanged();
            }
        }
    }

    @Override
    public void setAdapter(Adapter adapter) {

        if (mHeaderViews.isEmpty()&&mFootViews.isEmpty()){
            super.setAdapter(adapter);
        }else {
            adapter = new RecyclerWrapAdapter(mHeaderViews,mFootViews,adapter) ;
            super.setAdapter(adapter);
        }
        mAdapter = adapter ;
    }

}
