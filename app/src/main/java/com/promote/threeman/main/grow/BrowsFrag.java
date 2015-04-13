package com.promote.threeman.main.grow;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.promote.threeman.R;
import com.promote.threeman.bean.BrowsHistoryBean;
import com.promote.threeman.impl.BrowsHistoryDataTest;

import java.util.ArrayList;

/**
 * 浏览记录.
 */
public class BrowsFrag extends VideoBaseFragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ExpandableListView browselv;
    private TextView downloadfreedisktv;
    private ProgressBar downdiskprogress;
    private TextView downdiskusedtv;
    private TextView downloaddelseltv;
    private TextView downloaddeltv;
    private LinearLayout downloaddelll;
    private FrameLayout downloadbtmfl;

    //今天以前的浏览记录。
    private ArrayList<BrowsHistoryBean> beforeHistorys = new ArrayList<>();
    //今天的浏览记录。
    private ArrayList<BrowsHistoryBean> todayHistorys = new ArrayList<>();

    private MyAdapter adapter = null;

    private String[] browGroupStr;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BrowsFrag.
     */
    // TODO: Rename and change types and number of parameters
    public static BrowsFrag newInstance(String param1, String param2) {
        BrowsFrag fragment = new BrowsFrag();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public BrowsFrag() {
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_brows, container, false);
        initialize(view);
        return view;
    }

    /**
     * 测试数据。
     */
    public void testData() {
        beforeHistorys.addAll(BrowsHistoryDataTest.getBrowedHistory());
        todayHistorys.addAll(BrowsHistoryDataTest.getTodayBrowHistory());

    }


    private void initialize(View view) {

        browselv = (ExpandableListView) view.findViewById(R.id.brows_elv);
        downloadfreedisktv = (TextView) view.findViewById(R.id.download_free_disk_tv);
        downdiskprogress = (ProgressBar) view.findViewById(R.id.down_disk_progress);
        downdiskusedtv = (TextView) view.findViewById(R.id.down_disk_used_tv);
        downloaddelseltv = (TextView) view.findViewById(R.id.download_del_sel_tv);
        downloaddeltv = (TextView) view.findViewById(R.id.download_del_tv);
        downloaddelll = (LinearLayout) view.findViewById(R.id.download_del_ll);
        downloadbtmfl = (FrameLayout) view.findViewById(R.id.download_btm_fl);

        browGroupStr = getResources().getStringArray(R.array.brows_vedio_group);

        adapter = new MyAdapter();
        browselv.setAdapter(adapter);

    }

    @Override
    public void delCheck() {

    }


    /**
     * listView adapter.
     */
    private class MyAdapter extends BaseExpandableListAdapter {

        private ImageView downloadgroupimg;
        private TextView downloadgrouptv;
        private CheckBox videocentercb;
        private ImageView videocenteritemimg;
        private TextView videocentertitletv;
        private TextView videocenterauthortv;

        @Override
        public int getGroupCount() {
            return 2;
        }

        @Override
        public int getChildrenCount(int groupPosition) {
            if (groupPosition == 0)
                return todayHistorys.size();
            else
                return beforeHistorys.size();

        }

        @Override
        public Object getGroup(int groupPosition) {
            return browGroupStr[groupPosition];
        }

        @Override
        public Object getChild(int groupPosition, int childPosition) {

            if (groupPosition == 0) {
                return todayHistorys.get(childPosition);
            } else {
                return beforeHistorys.get(childPosition);
            }

        }

        @Override
        public long getGroupId(int groupPosition) {
            return groupPosition;
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return childPosition;
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }

        @Override
        public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

            if (convertView == null) {
                convertView = LayoutInflater.from(getActivity().getApplicationContext()).inflate
                        (R.layout.frag_download_group_item, null);
            }

            ImageView img = (ImageView) convertView.findViewById(R.id
                    .download_group_img);
            TextView tv = (TextView) convertView.findViewById(R.id.download_group_tv);

            if (groupPosition == 0) {
                img.setImageDrawable(getResources().getDrawable(R.mipmap.yesterdy));
            } else
                img.setImageDrawable(getResources().getDrawable(R.mipmap.earlier));
            tv.setText(browGroupStr[groupPosition]);

            return convertView;
        }

        @Override
        public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

            ViewHolder viewHolder;

            if (convertView == null) {
                viewHolder = new ViewHolder();
                convertView = View.inflate(getActivity().getApplicationContext(),
                        R.layout.frag_vedio_center_item, null);

                viewHolder.delCb = (CheckBox) convertView.findViewById(R.id.video_center_cb);
                viewHolder.img = (ImageView) convertView.findViewById(R.id
                        .video_center_item_img);
                viewHolder.nameTv = (TextView) convertView.findViewById(R.id
                        .video_center_title_tv);
                viewHolder.authorTv = (TextView) convertView.findViewById(R.id
                        .video_center_author_tv);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }

            BrowsHistoryBean bean = null;
            if (groupPosition == 0) {       //昨天。
                bean = todayHistorys.get(childPosition);
            } else {        //更早。
                bean = beforeHistorys.get(childPosition);
            }
//                viewHolder.img.setImageBitmap();
            viewHolder.nameTv.setText(bean.getName());
            viewHolder.authorTv.setText(bean.getTimeStr());

            return convertView;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return true;
        }

    }

    /**
     * view holder.
     */
    private static class ViewHolder {

        CheckBox delCb;
        ImageView img;
        TextView nameTv;
        TextView authorTv;

    }


}
