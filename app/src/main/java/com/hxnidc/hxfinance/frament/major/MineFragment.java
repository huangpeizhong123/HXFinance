package com.hxnidc.hxfinance.frament.major;

import android.os.Bundle;
import android.view.View;

import com.hxnidc.hxfinance.base.BaseFragment;

/**
 * Created by on 2016/12/20 14:30
 * Author：yrg
 * Describe:我的
 */


public class MineFragment extends BaseFragment{

    public static MineFragment newInstance() {
        Bundle args = new Bundle();
        MineFragment fragment = new MineFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    protected int getLayoutId() {
        return 0;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {

    }

    @Override
    protected void initData() {

    }
}
