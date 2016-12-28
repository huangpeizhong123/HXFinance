package com.hxnidc.hxfinance.base;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;


/**
 * Created by on 2016/12/15 12:30
 * Author：yrg
 * Describe:BaseFragment
 */


public abstract class BaseFragment extends Fragment {

    public Activity mActivity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mActivity = (Activity) context;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        ButterKnife.bind(this, view);
        initView(view, savedInstanceState);
        initData();
        return view;
    }

    protected abstract int getLayoutId();
    protected abstract void initView(View view, Bundle savedInstanceState);
    protected abstract void initData();
}
