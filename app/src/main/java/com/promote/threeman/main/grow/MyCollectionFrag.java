package com.promote.threeman.main.grow;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.promote.threeman.R;
import com.promote.threeman.bean.BrowsHistoryBean;
import com.promote.threeman.detailInfo.NeedClassInfoActivity;
import com.promote.threeman.impl.BrowsHistoryDataTest;

import java.util.ArrayList;

/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 * Use the {@link com.promote.threeman.main.grow.MyCollectionFrag#newInstance} factory method to
 * create an instance of this fragment.
 * 我的收集界面。
 */
public class MyCollectionFrag extends VideoBaseFragment implements AdapterView.OnItemClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private ArrayList<BrowsHistoryBean> collectiontDatas = new ArrayList<>();
    private ListView videocollectlv;
    private TextView downloaddelseltv;
    private TextView downloaddeltv;
    private LinearLayout downloaddelll;

    private MyAdapter adapter;


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MyCollectionFrag.
     */
    // TODO: Rename and change types and number of parameters
    public static MyCollectionFrag newInstance(String param1, String param2) {
        MyCollectionFrag fragment = new MyCollectionFrag();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public MyCollectionFrag() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        testData();
    }

    private void testData() {
        collectiontDatas.addAll(BrowsHistoryDataTest.getBrowedHistory());

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_collection, container, false);

        initialize(view);

        return view;
    }


    @Override
    public void delCheck() {

    }

    private void initialize(View view) {

        videocollectlv = (ListView) view.findViewById(R.id.video_collect_lv);
        downloaddelseltv = (TextView) view.findViewById(R.id.download_del_sel_tv);
        downloaddeltv = (TextView) view.findViewById(R.id.download_del_tv);
        downloaddelll = (LinearLayout) view.findViewById(R.id.download_del_ll);

        adapter = new MyAdapter();
        videocollectlv.setAdapter(adapter);
        videocollectlv.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(MyCollectionFrag.this.getActivity(), NeedClassInfoActivity.class);
        startActivity(intent);
    }

    private class MyAdapter extends BaseAdapter {


        @Override
        public int getCount() {
            return collectiontDatas.size();
        }

        @Override
        public Object getItem(int position) {
            return collectiontDatas.get(position);
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
                convertView = View.inflate(getActivity().getApplicationContext(),
                        R.layout.frag_vedio_center_item, null);
                viewHolder.delCb = (CheckBox) convertView.findViewById(R.id.video_center_cb);
                viewHolder.img = (ImageView) convertView.findViewById(R.id.video_center_item_img);
                viewHolder.nameTv = (TextView) convertView.findViewById(R.id.video_center_title_tv);
                viewHolder.authorTv = (TextView) convertView.findViewById(R.id.video_center_author_tv);

                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }

            BrowsHistoryBean historyBean = collectiontDatas.get(position);
//            viewHolder.img
            viewHolder.nameTv.setText(historyBean.getName());
            viewHolder.authorTv.setText(historyBean.getAuthor());

            return convertView;
        }

    }

    private static class ViewHolder {
        CheckBox delCb;
        ImageView img;
        TextView nameTv;
        TextView authorTv;
    }

}
