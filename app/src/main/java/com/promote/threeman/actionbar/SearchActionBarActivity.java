package com.promote.threeman.actionbar;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.promote.threeman.R;
import com.promote.threeman.base.BaseActivity;

/**
 * 搜索actionBar.
 * <p/>
 * Created by ACER on 2015/3/25.
 */
public abstract class SearchActionBarActivity extends BaseActivity {

    protected View searchActionBar;
    private ImageButton actionbackib;
    private ImageButton actionsearchib;
    private EditText searchEt;

    @Override
    protected View addActionBarView() {

        searchActionBar = LayoutInflater.from(getApplicationContext()).inflate(R.layout
                .search_actionbar, null);

        initialize(searchActionBar);
        return searchActionBar;
    }

    private void initialize(View view) {
        actionbackib = (ImageButton) findViewById(R.id.action_back_ib);
        actionsearchib = (ImageButton) findViewById(R.id.action_search_ib);
        searchEt = (EditText) findViewById(R.id.search_et);

        MyOnclickListener onclickListener = new MyOnclickListener();
        actionbackib.setOnClickListener(onclickListener);
        actionsearchib.setOnClickListener(onclickListener);
    }

    private class MyOnclickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {

            int id = v.getId();
            switch (id) {
                case R.id.action_back_ib: {


                    break;
                }

                case R.id.action_search_ib: {

                    break;
                }

                case R.id.search_et: {

                    break;
                }


            }
        }
    }
}
