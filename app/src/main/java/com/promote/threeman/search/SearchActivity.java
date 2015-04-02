package com.promote.threeman.search;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.promote.threeman.R;
import com.promote.threeman.actionbar.SearchActionBarActivity;
import com.promote.threeman.impl.SearchTestData;

/**
 * search activity.
 */
public class SearchActivity extends SearchActionBarActivity implements SearchActionBarActivity
        .SearchCallBack {

    private GridView searchkeygv;
    private ListView searchkeylv;
    private LinearLayout searchkeyll;
    private ArrayAdapter<String> hoteSearchAdapter;
    private ArrayAdapter<String> searchHistoryAdapter;

    @Override
    protected View addContentView() {

        View view = LayoutInflater.from(getApplicationContext()).inflate(R.layout
                .activity_search, null);
        initialize(view);
        return view;
    }

    @Override
    public void onSearch(String key) {


    }

    @Override
    public void onSearchEditChange(String key) {

    }

    private void initialize(View view) {

        searchkeygv = (GridView) view.findViewById(R.id.search_key_gv);
        searchkeylv = (ListView) view.findViewById(R.id.search_key_lv);
        searchkeyll = (LinearLayout) view.findViewById(R.id.search_key_ll);

        hoteSearchAdapter = new ArrayAdapter<String>(getApplicationContext(),
                R.layout.hotsearch_item);
        searchHistoryAdapter = new ArrayAdapter<String>(getApplicationContext(),
                R.layout.search_history_item);
        searchkeygv.setAdapter(hoteSearchAdapter);
        searchkeylv.setAdapter(searchHistoryAdapter);
        searchkeygv.setOnItemClickListener(new HotSearchCLS());
        searchkeylv.setOnItemClickListener(new HistorySearchCLS());

        hoteSearchAdapter.addAll(SearchTestData.hotSearch());
        searchHistoryAdapter.addAll(SearchTestData.hotSearch());

    }

    private class HotSearchCLS implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


        }
    }

    private class HistorySearchCLS implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


        }
    }


}
