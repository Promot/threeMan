package com.promote.threeman.main;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.promote.threeman.R;
import com.promote.threeman.bean.CaseFragBean;
import com.promote.threeman.detailInfo.CaseAndThreeInfoActivity;
import com.promote.threeman.impl.CaseTestData;

import java.util.ArrayList;

/**
 * 标杆案例。
 */
public class CaseFragment extends Fragment implements AdapterView.OnItemClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ArrayList<CaseFragBean> caseFragBeans = new ArrayList<>();
    private MyAdapter adapter = null;

    private OnFragmentInteractionListener mListener;
    private ListView fragcaselv;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TeacherFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CaseFragment newInstance(String param1, String param2) {
        CaseFragment fragment = new CaseFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public CaseFragment() {
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
        View view = inflater.inflate(R.layout.fragment_case, container, false);

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
        fragcaselv = (ListView) view.findViewById(R.id.frag_case_lv);
        fragcaselv.setOnItemClickListener(this);
        View footView = LayoutInflater.from(getActivity().getApplicationContext()).inflate(R
                .layout.common_list_foot, null);
        fragcaselv.addFooterView(footView);

        adapter = new MyAdapter();
        fragcaselv.setAdapter(adapter);
        getTestData();

    }

    private void getTestData() {
        ArrayList<CaseFragBean> tempCaseBeans = CaseTestData.getData();
        if (tempCaseBeans != null) {
            caseFragBeans.clear();
            caseFragBeans.addAll(tempCaseBeans);
            adapter.notifyDataSetChanged();
        }
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(getActivity(), CaseAndThreeInfoActivity.class);
        startActivity(intent);
    }

    private class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return caseFragBeans.size();
        }

        @Override
        public Object getItem(int position) {
            return caseFragBeans.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            ViewHolder viewHolder = null;
            if (convertView == null) {
                convertView = LayoutInflater.from(getActivity().getApplicationContext()).inflate
                        (R.layout.frag_case_item_layout, null);
                viewHolder = new ViewHolder();
                viewHolder.img = (ImageView) convertView.findViewById(R.id.frag_case_item_img);
                viewHolder.clickNumTv = (TextView) convertView.findViewById(R.id.frag_case_item_click_num_tv);
                viewHolder.titleTv = (TextView) convertView.findViewById(R.id.frag_case_item_title_tv);

                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }

            CaseFragBean caseFragBean = caseFragBeans.get(position);
            viewHolder.titleTv.setText(caseFragBean.getName());
            viewHolder.clickNumTv.setText(String.valueOf(caseFragBean.getClickNum()));

            return convertView;
        }

    }

    private static class ViewHolder {

        ImageView img;
        TextView titleTv;
        TextView clickNumTv;
    }


}
