package com.promote.threeman.detailInfo;

import android.view.LayoutInflater;
import android.view.View;

import com.promote.threeman.R;
import com.promote.threeman.actionbar.HomeActionBarActivity;

/**
 * 按需求选择跳转而来的详情界面。
 */
public class NeedClassInfoActivity extends HomeActionBarActivity {


    @Override
    protected View addContentView() {

        View view = LayoutInflater.from(getBaseContext()).inflate(R.layout
                .activity_need_class_info, null);

        return view;
    }


}
