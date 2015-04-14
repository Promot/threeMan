package com.promote.threeman.industry;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.promote.threeman.R;
import com.promote.threeman.actionbar.HomeActionBarActivity;
import com.promote.threeman.bean.IndustryBean;
import com.promote.threeman.impl.IndustryTestData;

import java.util.ArrayList;

/**
 * Created by ACER on 2015/4/13.
 * <p/>
 * 行业服务列表。
 */
public class IndustryServerActivity extends HomeActionBarActivity implements AdapterView.OnItemClickListener {


    private ListView industrylv;

    private MyAdapter adapter;

    private ArrayList<IndustryBean> industryBeans = null;

    @Override
    protected View addContentView() {
        getTestData();
        setTitle(R.string.industry_server);
        setActionType(COMM_ACTIONTYPE);

        View view = LayoutInflater.from(getBaseContext()).inflate(R.layout
                .activity_industry_service_layout, null);

        initialize(view);

        return view;
    }

    public void getTestData() {
        industryBeans = IndustryTestData.getIndustryData();
    }

    private void initialize(View view) {

        industrylv = (ListView) view.findViewById(R.id.industry_lv);

        adapter = new MyAdapter();
        industrylv.setAdapter(adapter);
        industrylv.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(IndustryServerActivity.this, IndustryInfoListActivity.class);
        startActivity(intent);

    }

    private class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return industryBeans.size();
        }

        @Override
        public Object getItem(int position) {
            return industryBeans.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            ViewHolder viewHolder = null;
            if (convertView == null) {
                viewHolder = new ViewHolder();
                convertView = LayoutInflater.from(getBaseContext()).inflate(R.layout
                        .industry_item_layout, null);
                viewHolder.img = (ImageView) convertView.findViewById(R.id.industry_item_img);
                viewHolder.titleTv = (TextView) convertView.findViewById(R.id.industry_item_title_tv);
                viewHolder.needTv = (TextView) convertView.findViewById(R.id.industry_item_subtitle_tv);
                viewHolder.contentTv = (TextView) convertView.findViewById(R.id.industry_des_tv);

                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }

            IndustryBean industryBean = industryBeans.get(position);
//            viewHolder.img
            viewHolder.titleTv.setText(industryBean.getName());
            viewHolder.needTv.setText(industryBean.getSubTitle());
            viewHolder.contentTv.setText(industryBean.getContent());

            return convertView;
        }

    }

    private static class ViewHolder {

        ImageView img;
        TextView titleTv;
        TextView needTv;
        TextView contentTv;
    }


}
