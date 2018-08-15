package com.crabsama.mywechat;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

/**
 * 微信信息的适配器
 */

public class WechatAdapter extends RecyclerView.Adapter<WechatAdapter.ViewHolder> {

    private List<WechatMessage> wechatList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView wechatImage;
        TextView wechatName;
        TextView wechatMessage;
        TextView messageTime;

        public ViewHolder( View view) {
            super(view);
            wechatImage = (ImageView)view.findViewById(R.id.wechat_image);
            wechatName = (TextView) view.findViewById(R.id.wechat_name);
            wechatMessage = (TextView) view.findViewById(R.id.wechat_message);
            messageTime = (TextView) view.findViewById(R.id.message_time);
        }
    }

    public WechatAdapter(List<WechatMessage> wechatListIn) {
        wechatList = wechatListIn;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.wechat_item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder( ViewHolder holder, int position) {
        WechatMessage wechatMessage = wechatList.get(position);
        holder.wechatImage.setImageResource(wechatMessage.getImageID());
        holder.wechatName.setText(wechatMessage.getWechatName());
        holder.wechatMessage.setText(wechatMessage.getWechatMessage());
        holder.messageTime.setText(wechatMessage.getMessageTime());
    }

    @Override
    public int getItemCount() {
        return wechatList.size();
    }


}
