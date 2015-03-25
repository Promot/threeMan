package com.promote.threeman.search;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;

import com.promote.threeman.R;
import com.promote.threeman.actionbar.SearchActionBarActivity;

public class SearchActivity extends SearchActionBarActivity implements SearchActionBarActivity.SearchCallBack {

    private ImageButton actionbackib;
    private ImageButton actionsearchib;


    @Override
    protected View addContentView() {

        View view = LayoutInflater.from(getApplicationContext()).inflate(R.layout
                .activity_search, null);
        initialize(view);
        return view;
    }

    private void initialize(View view) {

        actionbackib = (ImageButton) view.findViewById(R.id.action_back_ib);
        actionsearchib = (ImageButton) view.findViewById(R.id.action_search_ib);

    }


    @Override
    public void onSearch(String key) {

    }

    @Override
    public void onSearchEditChange(String key) {

    }
}
