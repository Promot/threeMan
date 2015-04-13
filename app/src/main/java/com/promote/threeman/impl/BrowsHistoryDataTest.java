package com.promote.threeman.impl;

import android.text.format.Time;

import com.promote.threeman.bean.BrowsHistoryBean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by ACER on 2015/4/10.
 */
public class BrowsHistoryDataTest {


    private static final String TIME_FORMATE = "%Y年%m月%d日%H时%M分%S秒";

    private static final String TIME_FROMATEDATA = "yyyy年MM月dd日hh时mm分ss秒";

    private static ArrayList<BrowsHistoryBean> historyBeans = new ArrayList<>();

    static {
        for (int i = 0; i < 20; i++) {

            BrowsHistoryBean historyBean = new BrowsHistoryBean();
            historyBean.setAuthor("作者 " + i);
            historyBean.setImgUrl("图片 " + i);
            historyBean.setLoodedFlag(i % 2);
            historyBean.setName("资料 我们的资料" + i);
            if (i < 6) {
                historyBean.setTimeStr(getTimeStr(true));
            } else {
                historyBean.setTimeStr(getTimeStr(false));
            }
            historyBeans.add(historyBean);
        }
    }

    public static ArrayList<BrowsHistoryBean> getHistoryBeans() {
        return historyBeans;
    }


    /**
     * 获取以前的浏览记录。
     *
     * @return
     */
    public static ArrayList<BrowsHistoryBean> getBrowedHistory() {

        ArrayList<BrowsHistoryBean> beans = new ArrayList<>();
        for (BrowsHistoryBean historyBean : historyBeans) {
            try {
                if (isDataBefore(historyBean.getTimeStr())) {
                    beans.add(historyBean);
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }

        }

        return beans;
    }


    /**
     * 获取昨天的浏览记录。
     *
     * @return
     */
    public static ArrayList<BrowsHistoryBean> getTodayBrowHistory() {

        ArrayList<BrowsHistoryBean> beans = new ArrayList<>();
        for (BrowsHistoryBean historyBean : historyBeans) {

            try {
                if (!isDataBefore(historyBean.getTimeStr())) {
                    beans.add(historyBean);
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }

        }
        return beans;
    }

    /**
     * 是否是昨天之前的时间。
     *
     * @param dateStr
     * @return
     * @throws ParseException
     */
    private static boolean isDataBefore(String dateStr) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat(TIME_FROMATEDATA);
        Time time = new Time();
        time.set(sdf.parse(dateStr).getTime());
        time.normalize(true);
        return getYestoryTime().after(time);
    }

    /**
     * 获取昨天开始的正点时间。
     *
     * @return
     */
    private static Time getYestoryTime() {
        Time time = new Time();
        time.setToNow();
        time.set(time.toMillis(true) - 24 * 60 * 60 * 1000);        //得到昨天的时间。
        time.normalize(true);
        time.set(time.monthDay, time.month, time.year);
        time.normalize(true);
        return time;
    }

    /**
     * @param isToday 是否在今天的时间内。
     * @return
     */
    private static String getTimeStr(boolean isToday) {

        Time time = new Time();
        time.setToNow();
        if (!isToday) {     //将时间换成以前的时间。
            time.set(new Random().nextInt(time.monthDay), time.month, time.year);
            time.normalize(true);
        }
        String timeStr = time.format(TIME_FORMATE);
        return timeStr;
    }


}
