package com.hxnidc.hxfinance.frament.major;

import android.os.Bundle;
import android.view.View;

import com.hxnidc.hxfinance.base.BaseFragment;

/**
 * Created by on 2016/12/20 14:27
 * Author：yrg
 * Describe:发现
 */


public class FoundFragment extends BaseFragment{

    public static FoundFragment newInstance() {
        Bundle args = new Bundle();
        FoundFragment fragment = new FoundFragment();
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
