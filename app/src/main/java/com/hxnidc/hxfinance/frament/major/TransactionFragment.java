package com.hxnidc.hxfinance.frament.major;

import android.os.Bundle;
import android.view.View;

import com.hxnidc.hxfinance.base.BaseFragment;

/**
 * Created by on 2016/12/20 14:30
 * Author：yrg
 * Describe:交易
 */


public class TransactionFragment extends BaseFragment{

    public static TransactionFragment newInstance() {
        Bundle args = new Bundle();
        TransactionFragment fragment = new TransactionFragment();
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
