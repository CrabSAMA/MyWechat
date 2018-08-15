package com.crabsama.mywechat;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * 通讯录中ListView的Adapter适配器
 */
public class ListAdapter extends ArrayAdapter<ListItem>{

    private int resourceId;

    public ListAdapter(Context context, int resource, List<ListItem> objects) {
        super(context, resource, objects);
        resourceId = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ListItem listItem = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        ImageView listImage = view.findViewById(R.id.list_image);
        TextView listName = view.findViewById(R.id.list_name);
        listImage.setImageResource(listItem.getImageId());
        listName.setText(listItem.getListName());
        return view;
    }
}