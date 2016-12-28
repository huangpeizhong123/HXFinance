package com.hxnidc.hxfinance.activity;

import com.hxnidc.hxfinance.R;
import com.hxnidc.hxfinance.base.BaseActivity;
import com.hxnidc.hxfinance.widget.CountDownView;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by on 2016/12/15 16:24
 * Author：yrg
 * Describe:
 */


public class SplashActivty extends BaseActivity {
    @BindView(R.id.countDownView)
    CountDownView countDownView;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initView() {

        countDownView.setOnCountDownTimerListener(new CountDownView.OnCountDownTimerListener() {
            @Override
            public void onStartCount() {

            }

            @Override
            public void onFinishCount() {

            }
        });
        countDownView.start();

    }

    @Override
    protected void initData() {


    }

    @OnClick(R.id.countDownView)
    public void onClick() {
    }
}
