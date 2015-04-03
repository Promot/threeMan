package com.promote.threeman.bean;

import android.os.Parcel;

import com.promote.threeman.main.ThreeFragment;

/**
 * Created by ACER on 2015/4/1.
 * <p/>
 * 首界面三身形实体类。
 */
public class ThreeFragBean extends SourceBean {

    private String title;
    private int type = ThreeFragment.ThreeType.ABOUT_PRO.getValue();      //默认值

    public ThreeFragment.ThreeType getType() {
        return ThreeFragment.ThreeType.getThreeTypeByValue(type);
    }

    public void setType(ThreeFragment.ThreeType type) {
        this.type = type.getValue();
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeInt(this.type);
        dest.writeString(this.imgUrl);
        dest.writeString(this.name);
        dest.writeString(this.date);
        dest.writeString(this.content);
        dest.writeString(this.subTitle);
    }

    public ThreeFragBean() {
    }

    private ThreeFragBean(Parcel in) {
        this.title = in.readString();
        this.type = in.readInt();
        this.imgUrl = in.readString();
        this.name = in.readString();
        this.date = in.readString();
        this.content = in.readString();
        this.subTitle = in.readString();
    }

    public static final Creator<ThreeFragBean> CREATOR = new Creator<ThreeFragBean>() {
        public ThreeFragBean createFromParcel(Parcel source) {
            return new ThreeFragBean(source);
        }

        public ThreeFragBean[] newArray(int size) {
            return new ThreeFragBean[size];
        }
    };
}
