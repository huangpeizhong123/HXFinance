package com.hxnidc.hxfinance.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.hxnidc.hxfinance.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by on 2016/12/20 17:56
 * Author：yrg
 * Describe:登录页面
 */


public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.text)
    TextView text;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        text.setText("kebi");
    }
}
