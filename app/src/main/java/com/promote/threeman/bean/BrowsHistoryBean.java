package com.promote.threeman.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by ACER on 2015/4/10.
 */
public class BrowsHistoryBean implements Parcelable {

    private String name;
    private String author;
    private String imgUrl;
    //是否已经浏览过，0位没有浏览过，1位已浏览过。
    private int loodedFlag;

    private String timeStr;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.author);
        dest.writeString(this.imgUrl);
        dest.writeInt(this.loodedFlag);
        dest.writeString(this.timeStr);
    }

    public BrowsHistoryBean() {
    }

    private BrowsHistoryBean(Parcel in) {
        this.name = in.readString();
        this.author = in.readString();
        this.imgUrl = in.readString();
        this.loodedFlag = in.readInt();
        this.timeStr = in.readString();
    }

    public static final Creator<BrowsHistoryBean> CREATOR = new Creator<BrowsHistoryBean>() {
        public BrowsHistoryBean createFromParcel(Parcel source) {
            return new BrowsHistoryBean(source);
        }

        public BrowsHistoryBean[] newArray(int size) {
            return new BrowsHistoryBean[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public int getLoodedFlag() {
        return loodedFlag;
    }

    public void setLoodedFlag(int loodedFlag) {
        this.loodedFlag = loodedFlag;
    }

    public String getTimeStr() {
        return timeStr;
    }

    public void setTimeStr(String timeStr) {
        this.timeStr = timeStr;
    }
}
