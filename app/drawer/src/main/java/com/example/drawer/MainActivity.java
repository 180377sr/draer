package com.example.drawer;


import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mImgmore,left;
    /**
     * 快讯
     */
    private DrawerLayout mDrawerlayout;
    private TextView mTvTitle;
    private ViewPager mViewpager;
    private BottomNavigationView mNavigation;
    private FrameLayout mV4DrawerlayoutFrame;
    private LinearLayout mV4Listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();


    }

    private void initView() {
        left=(ImageView) findViewById(R.id.left);
        mImgmore = (ImageView) findViewById(R.id.imgmore);
        mTvTitle = (TextView) findViewById(R.id.tvTitle);
        mViewpager = (ViewPager) findViewById(R.id.viewpager);
        mNavigation = (BottomNavigationView) findViewById(R.id.navigation);
        mV4DrawerlayoutFrame = (FrameLayout) findViewById(R.id.v4_drawerlayout_frame);
        mV4Listview = (LinearLayout) findViewById(R.id.v4_listview);
        mDrawerlayout = (DrawerLayout) findViewById(R.id.drawerlayout);
        setDate();
        mImgmore.setOnClickListener(this);

    }
    List<String> datas=new ArrayList<>();
    private void setDate() {
        mDrawerlayout.openDrawer(Gravity.LEFT);

    }

    private void hideOrShow() {
        //判断当前侧滑是不是在左侧已经打开
        if(mDrawerlayout.isDrawerOpen(Gravity.LEFT)){
            mDrawerlayout.closeDrawer(Gravity.LEFT);

        }else{
            mDrawerlayout.openDrawer(Gravity.LEFT);
    }

    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.imgmore){
            mDrawerlayout.openDrawer(Gravity.LEFT);
        }
        if (v.getId()==R.id.left){

        }
    }
}




