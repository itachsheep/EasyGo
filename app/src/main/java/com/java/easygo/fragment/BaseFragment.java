package com.java.easygo.fragment;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.java.easygo.R;
import com.java.easygo.util.LogUtils;

/**
 * Created by SDT14324 on 2018/1/31.
 */

public abstract class BaseFragment  extends Fragment{
    protected String TAG = getClass().getSimpleName();
    // 布局view
    protected ViewDataBinding mBinding;
    // 内容布局
    protected RelativeLayout mContainer;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        LogUtils.i(TAG,"onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtils.i(TAG,"onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        LogUtils.i(TAG,"onCreateView");
        View view = inflater.inflate(R.layout.fragment_base, null);
        mBinding = DataBindingUtil.inflate(inflater, setContent(), null, false);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        mBinding.getRoot().setLayoutParams(params);
        mContainer = (RelativeLayout) view.findViewById(R.id.container);
        mContainer.addView(mBinding.getRoot());
        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        LogUtils.i(TAG,"onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        LogUtils.i(TAG,"onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        LogUtils.i(TAG,"onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        LogUtils.i(TAG,"onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        LogUtils.i(TAG,"onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        LogUtils.i(TAG,"onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LogUtils.i(TAG,"onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        LogUtils.i(TAG,"onDetach");
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        LogUtils.i(TAG,"setUserVisibleHint  isVisibleToUser = "+isVisibleToUser);
    }

    /**
     * 布局
     */
    public abstract int setContent();
}
