package com.promote.threeman.main.grow;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

import com.promote.threeman.R;
import com.promote.threeman.bean.DownloadBean;
import com.promote.threeman.impl.DownloadTest;

import java.util.ArrayList;

/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 * Use the {@link com.promote.threeman.main.grow.DownloadFrag#newInstance} factory method to
 * create an instance of this fragment.
 * <p/>
 * 下载观看。
 */
public class DownloadFrag extends VideoBaseFragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    //等待。
    public static final int DOWNLOAD_WAIT = 1;
    //下载中。
    public static final int DOWNLOAD_LOADING = 2;
    //暂停。
    public static final int DOWNLOAD_PAUS = 3;
    //播放。
    public static final int DOWNLOAD_PALY = 4;

    private String[] downloadGroups = null;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ExpandableListView downloadelv;

    private MyAdapter adapter;
    /**
     * 下载完成的data.
     */
    private ArrayList<DownloadBean> downloadedBeans;
    /**
     * 正在下载data.
     */
    private ArrayList<DownloadBean> downloadingBeans;


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DownloadFrag.
     */
    // TODO: Rename and change types and number of parameters
    public static DownloadFrag newInstance(String param1, String param2) {
        DownloadFrag fragment = new DownloadFrag();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public DownloadFrag() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_download, container, false);

        initialize(view);

        return view;
    }


    private void initialize(View view) {
        testData();
        downloadGroups = getResources().getStringArray(R.array.download_tab);
        downloadelv = (ExpandableListView) view.findViewById(R.id.download_elv);

        adapter = new MyAdapter();
        downloadelv.setAdapter(adapter);
        downloadelv.expandGroup(0);
        downloadelv.expandGroup(1);

    }

    private void testData() {

        downloadedBeans = DownloadTest.getDownloadedBean();
        downloadingBeans = DownloadTest.getDownloadingBean();
    }

    @Override
    public void delCheck() {

    }

    /**
     * adapter.
     */
    private class MyAdapter extends BaseExpandableListAdapter {

        private OnCommandClickListener commandClickListener = null;
        private OnInfoClickListener infoClickListener = null;
        private OnRequestClickListener requestClickListener = null;
        private OnPlayClickListener playClickListener = null;

        public MyAdapter() {
            commandClickListener = new OnCommandClickListener();
            infoClickListener = new OnInfoClickListener();
            requestClickListener = new OnRequestClickListener();
            playClickListener = new OnPlayClickListener();
        }

        @Override
        public int getGroupCount() {
            return 2;
        }

        @Override
        public int getChildrenCount(int groupPosition) {

            if (groupPosition == 0)
                return downloadedBeans.size();
            else
                return downloadingBeans.size();
        }

        @Override
        public Object getGroup(int groupPosition) {

            return downloadGroups[groupPosition];
        }

        @Override
        public Object getChild(int groupPosition, int childPosition) {

            if (groupPosition == 0)
                return downloadedBeans.get(childPosition);
            else
                return downloadedBeans.get(childPosition);
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
                convertView = View.inflate(getActivity().getApplicationContext(),
                        R.layout.frag_download_group_item, null);
            }
            ImageView img = (ImageView) convertView.findViewById(R.id.download_group_img);
            TextView tv = (TextView) convertView.findViewById(R.id.download_group_tv);

            if (groupPosition == 0)
                img.setImageDrawable(getResources().getDrawable(R.mipmap.download_group_over));
            else
                img.setImageDrawable(getResources().getDrawable(R.mipmap.download_group_unover));
            tv.setText((String) getGroup(groupPosition));
            return convertView;
        }

        @Override
        public View getChildView(int groupPosition, int childPosition,
                                 boolean isLastChild, View convertView, ViewGroup parent) {

            ViewHolder viewHolder = null;
            if (convertView == null) {
                convertView = View.inflate(getActivity().getApplicationContext(),
                        R.layout.frag_download_nomal_item, null);
                viewHolder = new ViewHolder();
                viewHolder.delCb = (CheckBox) convertView.findViewById(R.id.download_nomal_cb);
                viewHolder.img = (ImageView) convertView.findViewById(R.id.download_nomal_img);
                viewHolder.nameTv = (TextView) convertView.findViewById(R.id.down_nomal_title_tv);
                viewHolder.commandCB = (CheckBox) convertView.findViewById(R.id.download_item_commend);
                viewHolder.questionCB = (CheckBox) convertView.findViewById(R.id.download_item_qestion);
                viewHolder.playerImg = (ImageView) convertView.findViewById(R.id.download_play_img);
                viewHolder.loadingImg = (ImageView) convertView.findViewById(R.id.download_downloading_img);
                viewHolder.pauseImg = (ImageView) convertView.findViewById(R.id.download_pause_img);
                viewHolder.waitImg = (ImageView) convertView.findViewById(R.id.download_wait_img);

                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();

            }

            DownloadBean downloadBean = null;
            if (groupPosition == 0) {       //下载完成。
                downloadBean = downloadedBeans.get(childPosition);
            } else {                //未下载完成。
                downloadBean = downloadingBeans.get(childPosition);

            }

            viewHolder.nameTv.setText(downloadBean.getTitle());
            viewHolder.commandCB.setTag(downloadBean.getId());
            viewHolder.questionCB.setTag(downloadBean.getId());
            viewHolder.playerImg.setTag(downloadBean.getId());
            viewHolder.commandCB.setOnClickListener(commandClickListener);
            viewHolder.questionCB.setOnClickListener(requestClickListener);
            viewHolder.playerImg.setOnClickListener(playClickListener);


            if (downloadBean.getState() == DOWNLOAD_PALY) {
                onPlayUi(viewHolder);
            } else if (downloadBean.getState() == DOWNLOAD_WAIT) {
                onWaitUi(viewHolder);
            } else if (downloadBean.getState() == DOWNLOAD_LOADING) {
                onLoadingUi(viewHolder);
            } else {
                onPauseUi(viewHolder);
            }

            return convertView;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return true;
        }

    }

    /**
     * 信息详情按钮点击事件。
     */
    private class OnInfoClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            int id = (int) v.getTag();      //


        }
    }

    private class OnPlayClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {

        }
    }

    /**
     * 推荐点击事件。
     */
    private class OnCommandClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getActivity(), CommendActivity.class);
            intent.putExtra("id", (int) v.getTag());
            startActivity(intent);
        }
    }

    /**
     * 提问点击事件。
     */
    private class OnRequestClickListener implements View.OnClickListener {


        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getActivity(), QuestionActivity.class);
            intent.putExtra("id", (int) v.getTag());
            startActivity(intent);
        }
    }

    /**
     * 下载完成itemUi.
     *
     * @param viewHolder
     */
    private void onPlayUi(ViewHolder viewHolder) {
        viewHolder.pauseImg.setVisibility(View.GONE);
        viewHolder.playerImg.setVisibility(View.VISIBLE);
        viewHolder.waitImg.setVisibility(View.GONE);
        viewHolder.loadingImg.setVisibility(View.GONE);

    }

    /**
     * 下载等待itemUi.
     *
     * @param viewHolder
     */
    private void onWaitUi(ViewHolder viewHolder) {
        viewHolder.pauseImg.setVisibility(View.GONE);
        viewHolder.waitImg.setVisibility(View.VISIBLE);
        viewHolder.playerImg.setVisibility(View.GONE);
        viewHolder.loadingImg.setVisibility(View.GONE);

    }

    /**
     * 下载中itemUi.
     *
     * @param viewHolder
     */
    private void onLoadingUi(ViewHolder viewHolder) {
        viewHolder.pauseImg.setVisibility(View.GONE);
        viewHolder.loadingImg.setVisibility(View.VISIBLE);
        viewHolder.waitImg.setVisibility(View.GONE);
        viewHolder.playerImg.setVisibility(View.GONE);

    }

    /**
     * 下载暂停itemUi.
     *
     * @param viewHolder
     */
    private void onPauseUi(ViewHolder viewHolder) {
        viewHolder.playerImg.setVisibility(View.GONE);
        viewHolder.pauseImg.setVisibility(View.VISIBLE);
        viewHolder.waitImg.setVisibility(View.GONE);
        viewHolder.loadingImg.setVisibility(View.GONE);

    }

    private static class ViewHolder {
        CheckBox delCb;
        ImageView img;
        TextView nameTv;
        CheckBox commandCB;
        CheckBox questionCB;
        ImageView pauseImg;
        ImageView playerImg;
        ImageView loadingImg;
        ImageView waitImg;
    }
}
