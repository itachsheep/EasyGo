package com.java.easygo.activity;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.java.easygo.R;
import com.java.easygo.adapter.MyFragmentPagerAdapter;
import com.java.easygo.databinding.ActivityMainBinding;
import com.java.easygo.fragment.BookFragment;
import com.java.easygo.fragment.GankFragment;
import com.java.easygo.fragment.OneFragment;

import java.util.ArrayList;

/**
 * Created by SDT14324 on 2017/12/5.
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ViewPager.OnPageChangeListener {

    private ActivityMainBinding mBinding;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ImageView ivTitleMenu;

    private FloatingActionButton fab;
    private ViewPager mViewPager;

    private ImageView ivGank;
    private ImageView ivOne;
    private ImageView ivDou;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding =  DataBindingUtil.setContentView(MainActivity.this, R.layout.activity_main);
        initView();
        initDrawerLayout();
        initListener();
        initContentFragment();
        initDrawerLayout();
    }

    private void initContentFragment() {
        ArrayList<Fragment> list = new ArrayList<Fragment>();
        list.add(new GankFragment());
        list.add(new OneFragment());
        list.add(new BookFragment());
        // 注意使用的是：getSupportFragmentManager
        MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(getSupportFragmentManager(),list);
        mViewPager.setAdapter(adapter);
        mViewPager.setOffscreenPageLimit(2);
        mViewPager.addOnPageChangeListener(this);
        ivGank.setSelected(true);
        mViewPager.setCurrentItem(0);

    }

    private void initListener() {
        ivTitleMenu.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void initView() {
        navigationView = mBinding.navView;
        ivTitleMenu = mBinding.include.ivTitleMenu;
        drawerLayout = mBinding.drawerLayout;

        mViewPager = mBinding.include.vpContent;
        ivGank = mBinding.include.ivTitleFavor;
        ivOne = mBinding.include.ivTitleMusic;
        ivDou = mBinding.include.ivTitleZone;
        fab = mBinding.include.fab;
        fab.setVisibility(View.GONE);
    }

    private void initDrawerLayout() {
        navigationView.inflateHeaderView(R.layout.nav_header_main);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_title_menu:
                drawerLayout.openDrawer(GravityCompat.START);
                break;

            default:
                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        switch (position) {
            case 0:
                ivGank.setSelected(true);
                ivOne.setSelected(false);
                ivDou.setSelected(false);
                break;
            case 1:
                ivOne.setSelected(true);
                ivGank.setSelected(false);
                ivDou.setSelected(false);
                break;
            case 2:
                ivDou.setSelected(true);
                ivOne.setSelected(false);
                ivGank.setSelected(false);
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    public void onNightModeClick(View view) {

    }
    /**
     * 夜间模式待完善
     */
    public boolean getNightMode() {
        return false;
    }


}
