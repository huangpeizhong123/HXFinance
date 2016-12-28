package com.hxnidc.hxfinance.frament;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.hxnidc.hxfinance.R;
import com.hxnidc.hxfinance.base.BaseFragment;

import butterknife.BindView;

/**
 * Created by on 2016/12/20 14:32
 * Author：yrg
 * Describe:
 */


public class MarketFragment extends BaseFragment {
    @BindView(R.id.tv_title)
    TextView tvTitle;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_market;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {

    }

    @Override
    protected void initData() {

    }

}
