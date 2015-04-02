package com.promote.threeman.base;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.widget.LinearLayout;

import com.promote.threeman.R;

public abstract class BaseActivity extends FragmentActivity {
    protected DisplayMetrics metrics;
    protected LinearLayout contentLayout;
    private View contentView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        metrics = new DisplayMetrics();
        Display display = getWindowManager().getDefaultDisplay();
        display.getMetrics(metrics);
        setContentView(R.layout.activity_base);
        contentLayout = (LinearLayout) findViewById(R.id.base_content_layout);

        View actionBar = addActionBarView();        //添加actionBar.
        if (actionBar == null)
            throw new NullPointerException("BaseActivity actionBarView is null");
        contentLayout.addView(actionBar);

        contentView = addContentView();             //添加contentView.
        if (contentView == null)
            throw new NullPointerException("BaseActivity contentview is null");
        contentLayout.addView(contentView);
    }

    protected void back() {
        onBackPressed();
        this.finish();
    }

    protected abstract View addActionBarView();

    /**
     * 添加內容。
     */
    protected abstract View addContentView();


}
