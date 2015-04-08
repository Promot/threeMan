package com.promote.threeman.main.settings;

import android.view.View;
import android.widget.TextView;

import com.promote.threeman.R;
import com.promote.threeman.actionbar.HomeActionBarActivity;

/**
 * Created by ACER on 2015/4/8.
 * <p/>
 * 关于我们。
 */
public class AboutUsActivity extends HomeActionBarActivity {


    private TextView aboutnametv;
    private TextView aboutversiontv;
    private TextView aboutemailtv;
    private TextView aboutfax;

    @Override
    protected View addContentView() {

        setActionType(COMM_ACTIONTYPE);
        setTitle(R.string.about_us);

        View view = View.inflate(getBaseContext(), R.layout.activity_about_us_layout, null);

        initialize(view);

        return view;
    }

    private void initialize(View view) {

        aboutnametv = (TextView) findViewById(R.id.about_name_tv);
        aboutversiontv = (TextView) findViewById(R.id.about_version_tv);
        aboutemailtv = (TextView) findViewById(R.id.about_email_tv);
        aboutfax = (TextView) findViewById(R.id.about_fax);
    }
}
