package com.promote.threeman.main;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.promote.threeman.R;
import com.promote.threeman.bean.ThreeFragBean;
import com.promote.threeman.impl.ThreeTestData;

import java.util.ArrayList;

/**
 * 三身行fragment.
 */
public class ThreeFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    private ListView threefraglv;
    private MyAdapter adapter = null;
    private ArrayList<ThreeFragBean> threeFragBeans = null;


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SubjectFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ThreeFragment newInstance(String param1, String param2) {
        ThreeFragment fragment = new ThreeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * 三身形item类型。
     */
    public enum ThreeType {
        SERVER_SHOW(1), SOURCE_STYLE(2), YOUR_NEED(3), ABOUT_TEAM(4), ABOUT_PRO(5), ABOUT_LEADER(6),
        ABOUT_COMP(0);

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public static ThreeType getThreeTypeByValue(int value) {


            switch (value) {
                case 1: {
                    return SERVER_SHOW;

                }
                case 2: {

                    return SOURCE_STYLE;
                }
                case 3: {

                    return YOUR_NEED;
                }
                case 4: {

                    return ABOUT_TEAM;
                }
                case 5: {

                    return ABOUT_PRO;
                }
                case 6: {

                    return ABOUT_LEADER;
                }
                case 7: {
                    return ABOUT_COMP;
                }
                default: {
                    throw new IndexOutOfBoundsException("Three type value is out fo bound");
                }


            }
        }

        int value;

        private ThreeType(int value) {
            this.value = value;
        }
    }

    public ThreeFragment() {
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

        View view = inflater.inflate(R.layout.fragment_three, container, false);

        initialize(view);

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    private void initialize(View view) {
        threeFragBeans = new ArrayList<>();
        threefraglv = (ListView) view.findViewById(R.id.three_frag_lv);

        adapter = new MyAdapter();
        threefraglv.setAdapter(adapter);

        testDatas();
    }

    /**
     * 填充测试数据。
     */
    private void testDatas() {
        threeFragBeans.clear();
        if (ThreeTestData.getTest() != null)
            threeFragBeans.addAll(ThreeTestData.getTest());
        adapter.notifyDataSetChanged();

    }

    private class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return threeFragBeans.size();
        }

        @Override
        public Object getItem(int position) {
            return threeFragBeans.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            Viewholder viewholder = null;
            if (convertView == null) {
                viewholder = new Viewholder();
                convertView = LayoutInflater.from(getActivity().getApplicationContext()).inflate
                        (R.layout.frag_three_item, null);
                viewholder.img = (ImageView) convertView.findViewById(R.id.frag_case_item_img);
                viewholder.titleTv = (TextView) convertView.findViewById(R.id.frag_case_title_tv);
                viewholder.contentTv = (TextView) convertView.findViewById(R.id.frag_case_intro_tv);

                convertView.setTag(viewholder);
            } else {
                viewholder = (Viewholder) convertView.getTag();
            }

            ThreeFragBean threeFragBean = threeFragBeans.get(position);
            viewholder.img.setImageDrawable(getResources().getDrawable(getImage(threeFragBean
                    .getType())));
            viewholder.titleTv.setText(threeFragBean.getName());
            viewholder.contentTv.setText(threeFragBean.getSubTitle());

            return convertView;
        }

        private int getImage(ThreeType type) {

            switch (type) {
                case SERVER_SHOW: {
                    return R.mipmap.three_server_show;

                }
                case SOURCE_STYLE: {

                    return R.mipmap.three_source_style;
                }
                case YOUR_NEED: {

                    return R.mipmap.three_your_need;
                }
                case ABOUT_TEAM: {

                    return R.mipmap.three_about_team;
                }
                case ABOUT_PRO: {

                    return R.mipmap.three_about_pro;
                }
                case ABOUT_COMP: {

                    return R.mipmap.three_about_comp;
                }
                case ABOUT_LEADER: {
                    return R.mipmap.three_about_leader;
                }
                default: {
                    throw new IndexOutOfBoundsException("image type is out fo bound");
                }


            }

        }
    }

    private static class Viewholder {
        ImageView img;
        TextView titleTv;
        TextView contentTv;
    }
}
