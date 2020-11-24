package com.example.drawable;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import java.util.ArrayList;
import java.util.List;

public class DrawerActivity extends AppCompatActivity {
    private FrameLayout mV4DrawerlayoutFrame;
    private TextView mV4Text;
    private ListView mV4Listview;
    private DrawerLayout mDrawerlayout;

    /**
     * 填充listview ，当点击lsitview 的item ，当前 item的内容 在 Activity_main.xml 的帧布局中显示
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);
        initView();
    }

    private void initView() {
        mV4DrawerlayoutFrame = (FrameLayout) findViewById(R.id.v4_drawerlayout_frame);
        mV4Text = (TextView) findViewById(R.id.v4_text);
        mV4Listview = (ListView) findViewById(R.id.v4_listview);
        mDrawerlayout = (DrawerLayout) findViewById(R.id.drawerlayout);
        setDate();
    }
        List<String> datas=new ArrayList<>();
    private void setDate() {
        //1.给listview填充数据
        datas.add("条目1");
        datas.add("条目2");
        datas.add("条目3");
        datas.add("条目4");
        ArrayAdapter<String> adapter=new ArrayAdapter<>
                (this,android.R.layout.simple_list_item_1,datas);
        mV4Listview.setAdapter(adapter);
        //3.给listview设置点击事件
        mV4Listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //将 textview内容显示出来 ， textview的内容就是listview的item中的文本。 实际开始时应该用fragment
                String result=datas.get(position);
                mV4Text.setText(result);

                //4.点击后要隐藏掉 侧滑。
                hideOrShow();
            }
        });

    }
    /**
     * 控制显示和隐藏
     */
    private void hideOrShow() {
        //判断当前侧滑是不是在左侧已经打开
        if(mDrawerlayout.isDrawerOpen(Gravity.LEFT)){
            mDrawerlayout.closeDrawer(Gravity.LEFT);

        }else{
            mDrawerlayout.openDrawer(Gravity.LEFT);
        }

    }
}
