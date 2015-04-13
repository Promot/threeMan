package com.promote.threeman.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by ACER on 2015/4/9.
 */
public class DownloadBean implements Parcelable {

    private int id;

    /**
     * 现在状态。
     */
    private int state;

    private String img;

    /**
     * 标题 *
     */
    private String title;

    /**
     * 下载路径 *
     */
    private String url;
    /**
     * 本地存放路径。 *
     */
    private String uri;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }


    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.state);
        dest.writeString(this.img);
        dest.writeString(this.title);
        dest.writeString(this.url);
        dest.writeString(this.uri);
        dest.writeInt(this.id);
    }

    public DownloadBean() {
    }

    private DownloadBean(Parcel in) {
        this.state = in.readInt();
        this.img = in.readString();
        this.title = in.readString();
        this.url = in.readString();
        this.uri = in.readString();
        this.id = in.readInt();
    }

    public static final Parcelable.Creator<DownloadBean> CREATOR = new Parcelable.Creator<DownloadBean>() {
        public DownloadBean createFromParcel(Parcel source) {
            return new DownloadBean(source);
        }

        public DownloadBean[] newArray(int size) {
            return new DownloadBean[size];
        }
    };
}
