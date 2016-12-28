package com.hxnidc.hxfinance.frament.major;

import android.os.Bundle;
import android.view.View;

import com.hxnidc.hxfinance.R;
import com.hxnidc.hxfinance.base.BaseFragment;

/**
 * Created by on 2016/12/15 15:59
 * Author：yrg
 * Describe:首页
 */


public class HomeFragment extends BaseFragment {


    public static HomeFragment newInstance() {
        Bundle args = new Bundle();
        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragmen_home;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
    }

    @Override
    protected void initData() {

    }
}















