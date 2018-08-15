package com.crabsama.mywechat;

import android.os.Bundle;

import androidx.annotation.NonNull;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {


    //获取对象的实例
    private Fragment WechatFragment = new WechatFragment();
    private Fragment ListFragment = new ListFragment();
    private Fragment FindFragment = new FindFragment();
    private Fragment MeFragment = new MeFragment();

    private List<WechatMessage> wechatMessageList = new ArrayList<>();

    private List<ListItem> listItemList = new ArrayList<>();

    private List<ListItem> headListItemList = new ArrayList<>();

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener     //为下方的BottomNavigationView设定监听器方法
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(MenuItem item) {      //重写select方法

            ActionBar actionBar = getSupportActionBar();     //获取到ActionBar的实例，对标题进行更改

            switch (item.getItemId()) {    //通过MenuItem的ID判断选中的是哪一项，然后进行操作
                case R.id.navigation_wechat:
                    replaceFragment(WechatFragment);
                    actionBar.setTitle("微信");
                    return true;
                case R.id.navigation_List:
                    replaceFragment(ListFragment);
                    actionBar.setTitle("通讯录");
                    return true;
                case R.id.navigation_find:
                    replaceFragment(FindFragment);
                    actionBar.setTitle("发现");
                    return true;
                case R.id.navigation_me:
                    replaceFragment(MeFragment);
                    actionBar.setTitle("我");
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();    //获取ActionBar实例更改标题，初始化操作（默认进来就是微信主界面）
        actionBar.setTitle("微信");
        replaceFragment(WechatFragment);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);   //通过ID找到navigation，并实例化
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);     //通过上方定义的方法建立监听器
        initMessage();
        initListItem();
    }



    private void replaceFragment(Fragment fragment){    //替换Fragment的方法（Fragment是由fragmentManager来管理的）
        FragmentManager fragmentManager = getSupportFragmentManager();     //通过get方法获取到fragmentManager的实例
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();     //通过fragmentManager的实例的方法获取到fragmentTransaction
        fragmentTransaction.replace(R.id.main_layout,fragment);       //通过fragmentTransaction的replace方法，参数分别是位于activity_main的FrameLayout作为父框、方法传入的fragment作为要替换的fragment
        fragmentTransaction.commit();     //注意！最后一定要进行commit();—提交！

    }

    //初始化消息数据
    private void initMessage(){
        WechatMessage one = new WechatMessage("CrabSAMA","Hello WeChat!","早上 5:20",R.drawable.ic_launcher);
        WechatMessage two = new WechatMessage("Welcome","Hello CrabSAMA!","下午 15:15",R.drawable.ic_launcher);
        WechatMessage three = new WechatMessage("我是酱油","打酱油，凑字数。","晚上 21:45",R.drawable.ic_launcher);
        wechatMessageList.add(one);
        wechatMessageList.add(two);
        wechatMessageList.add(three);
    }


    public List<WechatMessage> getWechatMessageList() {
        return wechatMessageList;
    }

    //初始化通讯录数据
    private void initListItem(){
        ListItem add = new ListItem("新的朋友",R.drawable.plugins_friendnotify);
        ListItem group = new ListItem("群聊",R.drawable.add_friend_icon_addgroup);
        ListItem tag = new ListItem("标签",R.drawable.contact_icon_contacttag);
        ListItem offical = new ListItem("公众号",R.drawable.add_friend_icon_offical);
        ListItem one = new ListItem("白鸿华",R.drawable.bhh);
        ListItem two = new ListItem("CrabSAMA",R.drawable.hxc);
        ListItem three = new ListItem("林梓浩",R.drawable.lzh);
        ListItem four = new ListItem("叶青青大佬",R.drawable.yqq);
        ListItem five = new ListItem("郑磊",R.drawable.zl);
        listItemList.add(add);
        listItemList.add(group);
        listItemList.add(tag);
        listItemList.add(offical);
        listItemList.add(one);
        listItemList.add(two);
        listItemList.add(three);
        listItemList.add(four);
        listItemList.add(five);
    }

    public List<ListItem> getListItemList(){
        return listItemList;
    }

    //初始化头部布局中listview数据，本次用不上，有bug
    private void initHeadListItem(){
        ListItem add = new ListItem("新的朋友",R.drawable.plugins_friendnotify);
        ListItem group = new ListItem("群聊",R.drawable.add_friend_icon_addgroup);
        ListItem tag = new ListItem("标签",R.drawable.contact_icon_contacttag);
        ListItem offical = new ListItem("公众号",R.drawable.add_friend_icon_offical);
        headListItemList.add(add);
        headListItemList.add(group);
        headListItemList.add(tag);
        headListItemList.add(offical);
    }

    public List<ListItem> getHeadListItemList(){
        return headListItemList;
    }

}
