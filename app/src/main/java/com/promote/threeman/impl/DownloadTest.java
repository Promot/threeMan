package com.promote.threeman.impl;

import com.promote.threeman.bean.DownloadBean;
import com.promote.threeman.main.grow.DownloadFrag;

import java.util.ArrayList;

/**
 * Created by ACER on 2015/4/9.
 */
public class DownloadTest {

    /**
     * @return
     */
    public static ArrayList<DownloadBean> getDownloadBean() {

        ArrayList<DownloadBean> downloadBeans = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            DownloadBean downloadBean = new DownloadBean();
            if (i < 10)
                downloadBean.setState(i % 4 + 1);
            else
                downloadBean.setState(DownloadFrag.DOWNLOAD_PAUS);
            downloadBean.setImg("img url" + i);
            downloadBean.setTitle("现在下载的东西" + i);
            downloadBeans.add(downloadBean);
        }

        return downloadBeans;
    }

    /**
     * 获取已经下载的数据
     *
     * @return
     */
    public static ArrayList<DownloadBean> getDownloadedBean() {

        ArrayList<DownloadBean> datas = new ArrayList<>();
        for (DownloadBean downloadBean : getDownloadBean()) {

            if (downloadBean.getState() == DownloadFrag.DOWNLOAD_PALY) {
                datas.add(downloadBean);
            }

        }
        return datas;
    }

    /**
     * 获取正在下载的数据。
     *
     * @return
     */
    public static ArrayList<DownloadBean> getDownloadingBean() {

        ArrayList<DownloadBean> downloadBeans = new ArrayList<>();

        for (DownloadBean downloadBean : getDownloadBean()) {

            if (downloadBean.getState() != DownloadFrag.DOWNLOAD_PALY) {
                downloadBeans.add(downloadBean);
            }
        }

        return downloadBeans;
    }

}
