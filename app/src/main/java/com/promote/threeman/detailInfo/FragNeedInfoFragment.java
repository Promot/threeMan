package com.promote.threeman.detailInfo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.promote.threeman.R;

/**
 * Created by ACER on 2015/4/13.
 */
public class FragNeedInfoFragment extends BaseNeedInfoFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = LayoutInflater.from(getActivity()).inflate(R.layout.frag_need_info_frag, null);

        return view;
    }
}
