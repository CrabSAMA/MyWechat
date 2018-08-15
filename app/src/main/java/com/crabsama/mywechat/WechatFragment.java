package com.crabsama.mywechat;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.view.menu.MenuBuilder;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


/**
 * 微信Fragment的代码
 */
public class WechatFragment extends Fragment {
    private static final int FIND = 17;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {    //重写onCreateView方法
        View view = inflater.inflate(R.layout.wechat_fragment,container,false);      //新建立一个View对象，通过inflater参数分别为fragment的布局，container容器


        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.wechat_view);    //通过id获取到recyclerview的实例
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());   //新建一个layoutManager，并设定recyclerview的LayoutManager为此
        recyclerView.setLayoutManager(layoutManager);
        WechatAdapter wechatAdapter = new WechatAdapter(((MainActivity)getActivity()).getWechatMessageList());       //建立一个适配器，并设定好
        recyclerView.setAdapter(wechatAdapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));   //添加分割线（具体可以百度一哈）

        return view;
    }

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);      //要在fragment建立Menu的关键
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.wechat_menu,menu);
        //下方为搜索按钮的生成
        MenuItem item = menu.add(0,FIND,0,"");   //新增一个MenuItem，参数可以参考OneNote
        item.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);     //将item对象的showAsAction参数改变一下，分别对应什么意思可以参考OneNote
        item.setIcon(R.drawable.find);    //设定Icon
        item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {      //设定监听器以监听按钮被按下时，并进行操作
                switch (menuItem.getItemId()){
                    case FIND :
                        Intent intent = new Intent(getActivity(),FindActivty.class);
                        startActivity(intent);
                        return true;
                    default:
                        return false;
                }
            }
        });
    }



}
