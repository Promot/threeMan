package com.promote.threeman.impl;

import com.promote.threeman.bean.IndustryBean;

import java.util.ArrayList;

/**
 * Created by ACER on 2015/4/13.
 */
public class IndustryTestData {

    public static ArrayList<IndustryBean> getIndustryData() {

        ArrayList<IndustryBean> datas = new ArrayList<>();
        for (int i = 0; i <= 20; i++) {

            IndustryBean threeFrag = new IndustryBean();
            threeFrag.setName("标题企业 " + i);
            threeFrag.setDate("2015.4.3");
            threeFrag.setSubTitle("，副标题，副标题，副标题副标题，副标题，副标题，副，副标题，副标题，副标题副标题，副标题，副标题，副，副标题，副标题，副标题副标题，副标题，副标题，副");
            threeFrag.setContent("企业 " + i +
                    "内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容" +
                    "副标题，副标题，副标题，副标题，副标题，副标题副标题，副标题，副标题，副标题，副标题，副标题副标题，副标题，副标题，副标题，副标题，副标题副标题，副标题，副标题，副标题，副标题，副标题副标题，副标题，副标题，副标题，副标题，副标题");
            threeFrag.setNeedLevel("需求" + i);
            threeFrag.setImgUrl("标题企业 img" + i);

            datas.add(threeFrag);
        }

        return datas;

    }

}
