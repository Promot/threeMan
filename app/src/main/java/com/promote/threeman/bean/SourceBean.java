package com.promote.threeman.bean;

import android.os.Parcelable;

/**
 * Created by ACER on 2015/4/2.
 * <p/>
 * 课程实体类， 基类。
 */
public abstract class SourceBean implements Parcelable {

    protected int id;
    /**
     * 图片url *
     */
    protected String imgUrl;
    /**
     * 标题 *
     */
    protected String name;
    /**
     * 时间 *
     */
    protected String date;
    /**
     * 内容 *
     */
    protected String content;

    protected String subTitle;


    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
