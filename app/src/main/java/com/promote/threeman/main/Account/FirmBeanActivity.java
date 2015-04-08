package com.promote.threeman.main.Account;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.promote.threeman.R;
import com.promote.threeman.actionbar.HomeActionBarActivity;
import com.promote.threeman.bean.AccountPeasBean;
import com.promote.threeman.impl.BeansTestData;

import java.util.ArrayList;

/**
 * 企业会员, 普通用户,蜕变豆
 * <p/>
 * Created by ACER on 2015/4/7.
 */
public class FirmBeanActivity extends HomeActionBarActivity {
    /**
     * 普通用户.
     */
    public static final int NOMAL_URSER = 1;
    /**
     * 企业用户.
     */
    public static final int FIRM_URSER = 2;

    public static final String URSERTYPE_KEY = "usr_type_key";

    private int usrType = -1;

    private TextView accountcurbeanstv;
    private Button accountdepositbtn;
    private ListView accountlist;

    private MyAdapter adapter;

    private ArrayList<AccountPeasBean> accountPeasBeans = new ArrayList<>();

    @Override

    protected View addContentView() {

        setActionType(HomeActionBarActivity.COMM_ACTIONTYPE);
        setTitle(R.string.account_beans);
        View view = LayoutInflater.from(getApplicationContext()).inflate(R.layout
                .activity_firm_bean_layout, null);

        initialize(view);

        return view;
    }


    private void initialize(View view) {

        Intent intent = getIntent();
        usrType = intent.getIntExtra(URSERTYPE_KEY, -1);

        accountcurbeanstv = (TextView) view.findViewById(R.id.account_cur_beans_tv);
        accountdepositbtn = (Button) view.findViewById(R.id.account_deposit_btn);
        accountlist = (ListView) view.findViewById(R.id.account_list);

        adapter = new MyAdapter();
        accountlist.setAdapter(adapter);

        testData();
        adapter.notifyDataSetChanged();

        initUsrByType();

        accountdepositbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(FirmBeanActivity.this, DepositActivity.class);
                intent.putExtra(URSERTYPE_KEY, usrType);
                startActivity(intent);
            }
        });
    }

    /**
     * 根据不同的用户类型调整对应的ui.
     */
    private void initUsrByType() {

        if (usrType == NOMAL_URSER) {   //普通用户
            accountdepositbtn.setText(getResources().getString(R.string.account_charge));
        } else if (usrType == FIRM_URSER) {     //企业用户
            accountdepositbtn.setText(getResources().getString(R.string.account_deposit));
        }

    }

    private void testData() {

        accountPeasBeans.addAll(BeansTestData.getData());

    }

    private class MyAdapter extends BaseAdapter {


        @Override
        public int getCount() {
            return accountPeasBeans.size();
        }

        @Override
        public Object getItem(int position) {
            return accountPeasBeans.get(position);
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
                        R.layout.account_list_item_layout, null);

                viewHolder.titleTv = (TextView) convertView.findViewById(R.id
                        .account_list_item_title_tv);
                viewHolder.numTv = (TextView) convertView.findViewById(R.id.account_num_tv);
                viewHolder.nameTv = (TextView) convertView.findViewById(R.id.account_name_tv);
                viewHolder.timeTv = (TextView) convertView.findViewById(R.id.account_time_tv);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }

            AccountPeasBean beans = accountPeasBeans.get(position);

            viewHolder.titleTv.setText(beans.getTitleStr());
            viewHolder.timeTv.setText(beans.getTimeStr());
            viewHolder.nameTv.setText(beans.getNameStr());
            viewHolder.numTv.setText(beans.getNumStr());

            return convertView;
        }

    }

    /**
     * 数据viewHolder.
     */
    private static class ViewHolder {

        TextView titleTv;
        TextView numTv;
        TextView nameTv;
        TextView timeTv;
    }


}
