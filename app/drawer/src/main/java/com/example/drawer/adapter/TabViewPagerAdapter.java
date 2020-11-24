package com.example.drawer.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

public class TabViewPagerAdapter extends FragmentPagerAdapter {
    private List<String> titles;
    private List<Fragment> fragments;

    public TabViewPagerAdapter(@NonNull FragmentManager fm,List<String> titles,List<Fragment> fragments) {
        super(fm);
        this.titles=titles;
        this.fragments=fragments;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
    //重写一个新方法 ,获取当前tablayout页签的标题内容

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position%titles.size());
    }
}
