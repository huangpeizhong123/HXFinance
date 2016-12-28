package com.hxnidc.hxfinance.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TabHost;
import android.widget.TabWidget;

import com.hxnidc.hxfinance.R;
import com.hxnidc.hxfinance.base.BaseActivity;
import com.hxnidc.hxfinance.frament.MarketFragment;
import com.hxnidc.hxfinance.frament.major.FoundFragment;
import com.hxnidc.hxfinance.frament.major.HomeFragment;
import com.hxnidc.hxfinance.frament.major.MineFragment;
import com.hxnidc.hxfinance.frament.major.TransactionFragment;
import com.hxnidc.hxfinance.widget.MainTabItemView;
import com.zhy.http.okhttp.https.HttpsUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    public static final String TAG_NEARBY = "TAG_NEARBY";
    public static final String TAG_EVENT = "TAG_EVENT";
    public static final String TAG_MOMENT = "TAG_MOMENT";
    public static final String TAG_MESSAGE = "TAG_MESSAGE";
    public static final String TAG_ME = "TAG_ME";
    @BindView(android.R.id.tabcontent)
    FrameLayout tabcontent;
    @BindView(android.R.id.tabs)
    TabWidget tabs;
    //@BindView(android.R.id.tabhost)
    FragmentTabHost mTabHost;
    @BindView(R.id.fab)
    FloatingActionButton fab;

    private HomeFragment homeFragment;
    private FragmentManager manager;
    private MainTabItemView mMomentTabView, mEventTabView, mMessageTabView, mMineTabView;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

        // FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });



    }

    @Override
    protected void initData() {
//        manager = getSupportFragmentManager();
//        FragmentTransaction transaction = manager.beginTransaction();
//        homeFragment = HomeFragment.newInstance();
//        transaction.add(R.id.frl_content, homeFragment).commit();
        initTabHost();
    }

    private void initTabHost() {
        mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), android.R.id.tabcontent);
        //附近
        mTabHost.addTab(mTabHost.newTabSpec(TAG_NEARBY).setIndicator(getTabItemView(TAG_NEARBY, true)), HomeFragment.class, null);

        //活动
        mEventTabView = getTabItemView(TAG_EVENT, false);
        mTabHost.addTab(mTabHost.newTabSpec(TAG_EVENT).setIndicator(mEventTabView), TransactionFragment.class, null);

        //发现
        mMomentTabView = getTabItemView(TAG_MOMENT, false);
        mTabHost.addTab(mTabHost.newTabSpec(TAG_MOMENT).setIndicator(mMomentTabView), FoundFragment.class, null);

        //消息
        mMessageTabView = getTabItemView(TAG_MESSAGE, false);
        mTabHost.addTab(mTabHost.newTabSpec(TAG_MESSAGE).setIndicator(mMessageTabView), MarketFragment.class, null);

        //个人
        mMineTabView = getTabItemView(TAG_ME, false);
        mTabHost.addTab(mTabHost.newTabSpec(TAG_ME).setIndicator(mMineTabView), MineFragment.class, null);

        mTabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                for (int i = 0; i < mTabHost.getTabWidget().getChildCount(); i++) {
                    View childAt = mTabHost.getTabWidget().getChildAt(i);
                    if (childAt instanceof MainTabItemView) {
                        ((MainTabItemView) childAt).setChecked(false);
                    }
                }
                ((MainTabItemView) (mTabHost.findViewWithTag(tabId))).setChecked(true);
            }
        });


    }

    private MainTabItemView getTabItemView(String tag, boolean isCheck) {
        MainTabItemView view = ((MainTabItemView) LayoutInflater.from(this).inflate(R.layout.item_tab_host, null));
        view.setTag(tag);
        switch (tag) {
            case TAG_NEARBY:
                view.initTab(getString(R.string.str_tab_nearby), R.drawable.tab_nearby_selector, isCheck);
                break;
            case TAG_EVENT:
                view.initTab(getString(R.string.str_tab_event), R.drawable.tab_event_selector, isCheck);
                break;
            case TAG_MOMENT:
                view.initTab(getString(R.string.str_tab_discovery), R.drawable.tab_discovery_selector, isCheck);
                break;
            case TAG_MESSAGE:
                view.initTab(getString(R.string.str_tab_message), R.drawable.tab_message_selector, isCheck);
                break;
            case TAG_ME:
                view.initTab(getString(R.string.str_tab_mine), R.drawable.tab_mine_selector, isCheck);
                break;
        }
        return view;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
