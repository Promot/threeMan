package com.promote.threeman.bean;

import java.util.ArrayList;

/**
 * Created by ACER on 2015/4/9.
 * <p/>
 * 下载实例。
 */
public class DownloadListBean {

    private ArrayList<DownloadBean> downloaded;
    private ArrayList<DownloadBean> unDownloaded;

    public ArrayList<DownloadBean> getUnDownloaded() {
        return unDownloaded;
    }

    public void setUnDownloaded(ArrayList<DownloadBean> unDownloaded) {
        this.unDownloaded = unDownloaded;
    }

    public ArrayList<DownloadBean> getDownloaded() {
        return downloaded;
    }

    public void setDownloaded(ArrayList<DownloadBean> downloaded) {
        this.downloaded = downloaded;
    }
}
