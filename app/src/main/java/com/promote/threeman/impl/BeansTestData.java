package com.promote.threeman.impl;

import com.promote.threeman.bean.AccountPeasBean;
import com.promote.threeman.main.Account.FirmBeanActivity;

import java.util.ArrayList;

/**
 * Created by ACER on 2015/4/7.
 */
public class BeansTestData {


    public static int accountType = FirmBeanActivity.FIRM_URSER;

    public static ArrayList<AccountPeasBean> getData() {

        ArrayList<AccountPeasBean> datas = new ArrayList<>();
        for (int i = 0; i < 8; i++) {

            AccountPeasBean accountPeasBean = new AccountPeasBean();
            accountPeasBean.setNameStr("蜕变豆" + i);
            accountPeasBean.setNumStr(String.valueOf(i * 4));
            accountPeasBean.setBeanType(i % 2 + 1);
            accountPeasBean.setTimeStr("2015.3.23");
            accountPeasBean.setTitleStr("定俩费迪南里欧理发打对方咯发多少里欧阿发啦");

            datas.add(accountPeasBean);
        }

        return datas;
    }

}
