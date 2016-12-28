package com.hxnidc.hxfinance.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hxnidc.hxfinance.R;

/**
 * Created by on 2016/12/21 11:58
 * Author：yrg
 * Describe:
 */


public class MainTabItemView extends RelativeLayout implements Checkable {
    private CheckBox mRadioButton;
    private TextView mBadgeTextView;
    private ImageView mRedHotView;
    private boolean isChecked;

    public MainTabItemView(Context context) {
        super(context);
    }

    public MainTabItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MainTabItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mRadioButton = (CheckBox) findViewById(R.id.view_main_tab_icon);
        mBadgeTextView = (TextView) findViewById(R.id.view_main_tab_badge);
        mRedHotView = (ImageView) findViewById(R.id.view_main_tab_red_dot);
    }

    public void initTab(String tabText, int iconRes, boolean isCheck) {
        mRadioButton.setChecked(isCheck);
        mRadioButton.setText(tabText);
        mRadioButton.setCompoundDrawablesWithIntrinsicBounds(0, iconRes, 0, 0);
    }

    public void setBadgeNum(int badgeNum) {
        if (badgeNum > 0) {
            mBadgeTextView.setVisibility(VISIBLE);
            mBadgeTextView.setText(String.valueOf(badgeNum));
        } else {
            mBadgeTextView.setVisibility(GONE);
        }
    }

    public void setNeedHotDot(boolean needHotDot) {
        mRedHotView.setVisibility(needHotDot ? VISIBLE : GONE);
    }

    @Override
    public void setChecked(boolean checked) {
        mRadioButton.setChecked(checked);
        isChecked = checked;
    }

    @Override
    public boolean isChecked() {
        return isChecked;
    }

    @Override
    public void toggle() {
        setChecked(!isChecked);
    }
}
