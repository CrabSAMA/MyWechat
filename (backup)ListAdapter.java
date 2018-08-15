package com.crabsama.mywechat;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class ListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private int HEAD = 0;
    private int BODY = 1;
    private int FOOT = 2;

    private List<ListItem> AddressList;
    protected List<View> headlist = new ArrayList<>();
    protected List<View> footlist = new ArrayList<>();

    public ListAdapter(List<ListItem> addressListIn) {
        AddressList = addressListIn;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == HEAD){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.head_layout,parent,false);
            headHolder headHolder = new headHolder(view);
            return headHolder;
        }else if (viewType == BODY){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
            ViewHolder holder = new ViewHolder(view);
            return holder;
        }else{
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.foot_layout,parent,false);
            footHolder footHolder = new footHolder(view);
            return footHolder;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ListItem listItem = AddressList.get(position);
        ((ViewHolder)holder).listName.setText(listItem.getListName());
        ((ViewHolder)holder).listImage.setImageResource(listItem.getImageId());
    }

    @Override
    public int getItemCount() {
        return AddressList.size() + headlist.size() + footlist.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        ImageView listImage;
        TextView listName;

        public ViewHolder( View view) {
            super(view);
            listImage = (ImageView)view.findViewById(R.id.list_image);
            listName = (TextView)view.findViewById(R.id.list_name);
        }
    }

    static class headHolder extends RecyclerView.ViewHolder{

        LinearLayout head;

        public headHolder(View view) {
            super(view);
            head = (LinearLayout)view.findViewById(R.id.head_layout);
        }
    }

    static class footHolder extends RecyclerView.ViewHolder{

        LinearLayout foot;

        public footHolder(View view){
            super(view);
            foot = (LinearLayout)view.findViewById(R.id.foot_layout);
        }
    }

    public void addheadView(View view){
        if(headlist != null){
            headlist.add(view);
        }
    }

    public void addfootView(View view){
        if(footlist != null){
            footlist.add(view);
        }
    }


    @Override
    public int getItemViewType(int position) {
        if(position < headlist.size()){
            return HEAD;
        }else if(position < headlist.size() + AddressList.size()){
            return BODY;
        }else {
            return FOOT;
        }
    }


}
