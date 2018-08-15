package com.crabsama.mywechat;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ListFragment extends Fragment {

    private static final int FIND = 11;
    private static final int ADD = 12;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //分别通过布局文件创建对应的view
        View view = inflater.inflate(R.layout.list_fragment,container,false);
        View headView = inflater.inflate(R.layout.head_layout,container,false);
        View footView = inflater.inflate(R.layout.foot_layout,container,false);

        //百度回来的一个方法，设定好Layoutparams，设定好头尾布局的长宽，就可以不报错了。
        AbsListView.LayoutParams lp = new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT,AbsListView.LayoutParams.MATCH_PARENT);
        headView.setLayoutParams(lp);
        footView.setLayoutParams(lp);

        ListAdapter listAdapter = new ListAdapter(getActivity(),R.layout.list_item,((MainActivity)getActivity()).getListItemList());
        ListView listView = (ListView)view.findViewById(R.id.list_view);
        listView.setAdapter(listAdapter);

        //添加头尾布局，要在设定adapter前，本次没用到头布局，因为有bug
        listView.addHeaderView(headView);
        listView.addFooterView(footView);

//        ListView headListView = (ListView)headView.findViewById(R.id.head_list);
//        ListAdapter headListAdapter = new ListAdapter(getActivity(),R.layout.list_item,((MainActivity)getActivity()).getHeadListItemList());
//        headListView.setAdapter(headListAdapter);


        TextView peopleNum = view.findViewById(R.id.peopleNum);     //获取到尾部局中的textview
        peopleNum.setText(((MainActivity)getActivity()).getListItemList().size()-4 + "位联系人");   //通过获取listItemList的size来得知联系人数量
        return view;
    }

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);      //要在fragment建立Menu的关键
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.list_menu,menu);
        //下方为搜索按钮的生成
        MenuItem find = menu.add(0,FIND,0,"");   //新增一个MenuItem，参数可以参考OneNote
        find.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);     //将item对象的showAsAction参数改变一下，分别对应什么意思可以参考OneNote
        find.setIcon(R.drawable.find);    //设定Icon

        MenuItem add = menu.add(1,ADD,0,"");   //新增一个MenuItem，参数可以参考OneNote
        add.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);     //将item对象的showAsAction参数改变一下，分别对应什么意思可以参考OneNote
        add.setIcon(R.drawable.icon_add);    //设定Icon

        find.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
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
