package com.promote.threeman.impl;

import com.promote.threeman.bean.CaseFragBean;

import java.util.ArrayList;

/**
 * Created by ACER on 2015/4/1.
 */
public class CaseTestData {

    public static ArrayList<CaseFragBean> getData() {

        ArrayList<CaseFragBean> caseFragBeans = new ArrayList<>();
        for (int i = 0; i < 19; i++) {

            CaseFragBean caseFragBean = new CaseFragBean();
            caseFragBean.setImgUrl("茶色备案url" + i);
            caseFragBean.setClickNum(i + 100);
            caseFragBean.setDate("2015.4.3");
            caseFragBean.setSubTitle("副标题，副标题，副标题，副标题，副标题，副标题，副标题，副标题，副标题，副标题");
            caseFragBean.setContent("内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容" +
                    "副标题，副标题，副标题，副标题，副标题，副标题副标题，副标题，副标题，副标题，副标题，副标题副标题，副标题，副标题，副标题，副标题，副标题副标题，副标题，副标题，副标题，副标题，副标题副标题，副标题，副标题，副标题，副标题，副标题");
            caseFragBean.setName("标杆案例，标杆案例");
            caseFragBeans.add(caseFragBean);
        }

        return caseFragBeans;
    }
}
