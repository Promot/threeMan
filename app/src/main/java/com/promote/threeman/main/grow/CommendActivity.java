package com.promote.threeman.main.grow;

import android.view.LayoutInflater;
import android.view.View;

import com.promote.threeman.R;
import com.promote.threeman.actionbar.HomeActionBarActivity;

/**
 * Created by ACER on 2015/4/13.
 * <p/>
 * 我要推荐。
 */
public class CommendActivity extends HomeActionBarActivity {


    @Override
    protected View addContentView() {

        setActionType(COMM_ACTIONTYPE);
        setTitle(R.string.my_commend);
        View view = LayoutInflater.from(getBaseContext()).inflate(R.layout
                .activity_commend_layout, null);


        return view;
    }
}
