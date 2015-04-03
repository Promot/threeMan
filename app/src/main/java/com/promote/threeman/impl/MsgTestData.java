package com.promote.threeman.impl;

import com.promote.threeman.bean.CaseFragBean;

/**
 * Created by ACER on 2015/4/2.
 */
public class MsgTestData {

    public static CaseFragBean getMsgTestData() {
        CaseFragBean caseFragBean = new CaseFragBean();
        caseFragBean.setImgUrl("茶色备案url");
        caseFragBean.setClickNum(25);
        caseFragBean.setDate("2015.4.3");
        caseFragBean.setSubTitle("msg副标题，副标题，副标题，副标题，副标题，副标题，副标题，副标题，副标题，副标题");
        caseFragBean.setContent
                ("msg内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容" +
                        "副标题，副标题，副标题，副标题，副标题，副标题副标题，副标题，副标题，副标题，副标题，副标题副标题，副标题，副标题，副标题，副标题，副标题副标题，副标题，副标题，副标题，副标题，副标题副标题，副标题，副标题，副标题，副标题，副标题");
        caseFragBean.setName("标杆案例，标杆案例");
        return caseFragBean;
    }
}
