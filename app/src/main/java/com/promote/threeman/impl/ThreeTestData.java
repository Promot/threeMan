package com.promote.threeman.impl;

import com.promote.threeman.bean.ThreeFragBean;

import java.util.ArrayList;

/**
 * Created by ACER on 2015/4/1.
 */
public class ThreeTestData {


    public static ArrayList<ThreeFragBean> getTest() {

        ArrayList<ThreeFragBean> datas = new ArrayList<>();
        for (int i = 0; i < 20; i++) {

            ThreeFragBean threeFrag = new ThreeFragBean();
            threeFrag.setName("标题企业 " + i);
            threeFrag.setDate("2015.4.3");
            threeFrag.setSubTitle("，副标题，副标题，副标题副标题，副标题，副标题，副，副标题，副标题，副标题副标题，副标题，副标题，副，副标题，副标题，副标题副标题，副标题，副标题，副");
            threeFrag.setContent("企业 " + i +
                    "内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容" +
                    "副标题，副标题，副标题，副标题，副标题，副标题副标题，副标题，副标题，副标题，副标题，副标题副标题，副标题，副标题，副标题，副标题，副标题副标题，副标题，副标题，副标题，副标题，副标题副标题，副标题，副标题，副标题，副标题，副标题");
            threeFrag.setType(i % 7);
            threeFrag.setImgUrl("标题企业 img" + i);

            datas.add(threeFrag);
        }

        return datas;
    }

    public ThreeFragBean getThreeTestData() {

        ThreeFragBean testData = new ThreeFragBean();
        testData.setName("标题企业 ");
        testData.setDate("2015.4.3");
        testData.setSubTitle("，副标题，副标题，副标题副标题，副标题，副标题，副，副标题，副标题，副标题副标题，副标题，副标题，副，副标题，副标题，副标题副标题，副标题，副标题，副");
        testData.setContent("企业 " +
                "内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容" +
                "副标题，副标题，副标题，副标题，副标题，副标题副标题，副标题，副标题，副标题，副标题，副标题副标题，副标题，副标题，副标题，副标题，副标题副标题，副标题，副标题，副标题，副标题，副标题副标题，副标题，副标题，副标题，副标题，副标题");
        testData.setType(2);
        testData.setImgUrl("标题企业 img");
        return testData;
    }
}
