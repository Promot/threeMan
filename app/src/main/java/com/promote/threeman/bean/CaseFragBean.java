package com.promote.threeman.bean;

import android.os.Parcel;

/**
 * Created by ACER on 2015/4/1.
 */
public class CaseFragBean extends SourceBean implements android.os.Parcelable {

    private int clickNum;

    public int getClickNum() {
        return clickNum;
    }

    public void setClickNum(int clickNum) {
        this.clickNum = clickNum;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.clickNum);
        dest.writeString(this.imgUrl);
        dest.writeString(this.name);
        dest.writeString(this.date);
        dest.writeString(this.content);
        dest.writeString(this.subTitle);
    }

    public CaseFragBean() {
    }

    private CaseFragBean(Parcel in) {
        this.clickNum = in.readInt();
        this.imgUrl = in.readString();
        this.name = in.readString();
        this.date = in.readString();
        this.content = in.readString();
        this.subTitle = in.readString();
    }

    public static final Creator<CaseFragBean> CREATOR = new Creator<CaseFragBean>() {
        public CaseFragBean createFromParcel(Parcel source) {
            return new CaseFragBean(source);
        }

        public CaseFragBean[] newArray(int size) {
            return new CaseFragBean[size];
        }
    };
}
