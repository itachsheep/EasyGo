package com.java.easygo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by SDT14324 on 2018/1/31.
 */

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {
    private List<?> mFragments;
    /**
     * 普通，主页使用
     */
    public MyFragmentPagerAdapter(FragmentManager fm, List<?> mFragment) {
        super(fm);
        this.mFragments = mFragment;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments != null ? (Fragment) mFragments.get(position) : null;
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }
}
