package com.promote.threeman.main.msg;

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
import com.promote.threeman.bean.CaseFragBean;
import com.promote.threeman.detailInfo.CaseAndThreeInfoActivity;
import com.promote.threeman.impl.CaseTestData;
import com.promote.threeman.impl.MsgTestData;

import java.util.ArrayList;

/**
 * 消息列表。
 * <p/>
 * Created by ACER on 2015/4/7.
 */
public class MsgListActivity extends HomeActionBarActivity implements AdapterView.OnItemClickListener {

    private ArrayList<CaseFragBean> datas = new ArrayList<CaseFragBean>();
    private ListView msglistlv;
    private MyAdapter adapter;


    @Override
    protected View addContentView() {

        setActionType(HomeActionBarActivity.COMM_ACTIONTYPE);
        setTitle(R.string.msg);

        View view = LayoutInflater.from(getApplicationContext()).inflate(R.layout
                .activity_msg_list_layout, null);

        initialize(view);

        return view;
    }

    private void initialize(View view) {

        msglistlv = (ListView) view.findViewById(R.id.msg_list_lv);
        adapter = new MyAdapter();
        msglistlv.setAdapter(adapter);
        msglistlv.setOnItemClickListener(this);
        msglistlv.addFooterView(View.inflate(getApplicationContext(), R.layout.common_list_foot,
                null));
        msglistlv.setFooterDividersEnabled(true);

        TestData();
        adapter.notifyDataSetChanged();

    }

    private void TestData() {

        ArrayList<CaseFragBean> testDatas = CaseTestData.getData();
        if (testDatas != null && testDatas.size() != 0)
            datas.addAll(testDatas);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        if (position == datas.size())       //点击最后一个。
            return;
        Intent intent = new Intent(MsgListActivity.this,
                CaseAndThreeInfoActivity.class);
        intent.putExtra(CaseAndThreeInfoActivity.PARM_TYPEKEY, CaseAndThreeInfoActivity.MSGINFO);
        intent.putExtra(CaseAndThreeInfoActivity.PARM_OBJKEY, MsgTestData.getMsgTestData());
        startActivity(intent);
    }


    /**
     * base adapter.
     */
    private class MyAdapter extends BaseAdapter {


        @Override
        public int getCount() {
            return datas.size();
        }

        @Override
        public Object getItem(int position) {
            return datas.get(position);
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
                convertView = View.inflate(getApplicationContext(),
                        R.layout.msg_list_item_layout, null);

                viewHolder.imgView = (ImageView) convertView.findViewById(R.id.msg_list_item_img);
                viewHolder.titleTv = (TextView) convertView.findViewById(R.id
                        .list_item_title_tv);
                viewHolder.timeTv = (TextView) convertView.findViewById(R.id.list_item_time_tv);
                viewHolder.contentTv = (TextView) convertView.findViewById(R.id
                        .list_item_content_tv);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }

            CaseFragBean caseFragBean = datas.get(position);


//            viewHolder.imgView.se
            viewHolder.timeTv.setText(caseFragBean.getName());
            viewHolder.timeTv.setText(caseFragBean.getDate());
            viewHolder.contentTv.setText(caseFragBean.getContent());

            return convertView;
        }

    }

    private static class ViewHolder {

        ImageView imgView;
        TextView titleTv;
        TextView timeTv;
        TextView contentTv;
    }


}
