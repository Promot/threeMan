package com.promote.threeman.bean;

import android.os.Parcel;

/**
 * Created by ACER on 2015/4/13.
 * <p/>
 * 行业。
 */
public class IndustryBean extends SourceBean implements android.os.Parcelable {

    private String needLevel;

    public String getNeedLevel() {
        return needLevel;
    }

    public void setNeedLevel(String needLevel) {
        this.needLevel = needLevel;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.needLevel);
        dest.writeInt(this.id);
        dest.writeString(this.imgUrl);
        dest.writeString(this.name);
        dest.writeString(this.date);
        dest.writeString(this.content);
        dest.writeString(this.subTitle);
    }

    public IndustryBean() {
    }

    private IndustryBean(Parcel in) {
        this.needLevel = in.readString();
        this.id = in.readInt();
        this.imgUrl = in.readString();
        this.name = in.readString();
        this.date = in.readString();
        this.content = in.readString();
        this.subTitle = in.readString();
    }

    public static final Creator<IndustryBean> CREATOR = new Creator<IndustryBean>() {
        public IndustryBean createFromParcel(Parcel source) {
            return new IndustryBean(source);
        }

        public IndustryBean[] newArray(int size) {
            return new IndustryBean[size];
        }
    };
}
