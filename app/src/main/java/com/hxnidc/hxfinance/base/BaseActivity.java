package com.hxnidc.hxfinance.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.hxnidc.hxfinance.utils.StatusBarUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by on 2016/12/15 11:04
 * Author：yrg
 * Describe:
 */


public abstract class BaseActivity extends AppCompatActivity {
    /**
     * 记录处于前台的Activity
     */
    private static BaseActivity mForegroundActivity = null;
    /**
     * 记录所有活动的Activity
     */
    private static final List<BaseActivity> mActivities = new LinkedList<BaseActivity>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        StatusBarUtils.compat(this);
        initView();
        initData();
        initEvent();


        // initActionBar();
    }

    /**
     * 获取id
     * @return
     */
    abstract protected int getLayoutId();

    /**
     * 初始化view
     */
    abstract protected void initView();

    /**
     * 初始化数据
     */
    abstract protected void initData();

    /**
     * 初始化事件
     */
    protected void initEvent() {

    }


    @Override
    protected void onResume() {
        mForegroundActivity = this;
        super.onResume();
    }

    @Override
    protected void onPause() {
        mForegroundActivity = null;
        super.onPause();
    }



    protected void initActionBar() {

    }

    public void startOpenActivity(Class<?> clz){
        Intent intent = new Intent(this,clz);
        startActivity(intent);
    }

    /**
     * 关闭所有Activity
     */
    public static void finishAll() {
        List<BaseActivity> copy;
        synchronized (mActivities) {
            copy = new ArrayList<BaseActivity>(mActivities);
        }
        for (BaseActivity activity : copy) {
            activity.finish();
        }
    }

    /**
     * 关闭所有Activity，除了参数传递的Activity
     */
    public static void finishAll(BaseActivity except) {
        List<BaseActivity> copy;
        synchronized (mActivities) {
            copy = new ArrayList<BaseActivity>(mActivities);
        }
        for (BaseActivity activity : copy) {
            if (activity != except)
                activity.finish();
        }
    }

    /**
     * 是否有启动的Activity
     */
    public static boolean hasActivity() {
        return mActivities.size() > 0;
    }

    /**
     * 获取当前处于前台的activity
     */
    public static BaseActivity getForegroundActivity() {
        return mForegroundActivity;
    }

    /**
     * 获取当前处于栈顶的activity，无论其是否处于前台
     */
    public static BaseActivity getCurrentActivity() {
        List<BaseActivity> copy;
        synchronized (mActivities) {
            copy = new ArrayList<BaseActivity>(mActivities);
        }
        if (copy.size() > 0) {
            return copy.get(copy.size() - 1);
        }
        return null;
    }

    protected void initFindViewById() {

    }


    /**
     * 退出应用
     */
    public void exitApp() {
        finishAll();
        android.os.Process.killProcess(android.os.Process.myPid());
    }

}
