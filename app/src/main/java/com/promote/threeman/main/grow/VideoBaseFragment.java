package com.promote.threeman.main.grow;

import android.support.v4.app.Fragment;

/**
 * Created by ACER on 2015/4/10.
 * <p/>
 * 视频中心共通碎片，提供一些共通方法。
 */
public abstract class VideoBaseFragment extends Fragment {

    public abstract void delCheck();

    /**
     * 获取总共磁盘空间。
     *
     * @return
     */
    protected double getTotalDisk() {

        return 0;
    }

    /**
     * 获取磁盘剩余空间。
     *
     * @return
     */
    protected double getFreeDisk() {

        return 0;
    }

    /**
     * 获取已占用磁盘空间。
     *
     * @return
     */
    protected double getUsedDisk() {

        return 0;
    }

    /**
     * 获取磁盘使用率。
     *
     * @return
     */
    protected double getUrsedProgress() {

        return 0;
    }
}
