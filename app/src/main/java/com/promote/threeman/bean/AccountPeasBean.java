package com.promote.threeman.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 账户消费信息。
 * <p/>
 * Created by ACER on 2015/4/7.
 */
public class AccountPeasBean implements Parcelable {

    private String titleStr;
    private String numStr;
    private String nameStr;
    private String timeStr;
    /**
     * 用户类型。1为普通用户,2位企业用户 *
     */
    private int usrType;
    /**
     * 蜕变豆的增减类型。1为减2为加 *
     */
    private int beanType;


    public String getTimeStr() {
        return timeStr;
    }

    public void setTimeStr(String timeStr) {
        this.timeStr = timeStr;
    }

    public String getNameStr() {
        return nameStr;
    }

    public void setNameStr(String nameStr) {
        this.nameStr = nameStr;
    }

    public String getNumStr() {
        return numStr;
    }

    public void setNumStr(String numStr) {
        this.numStr = numStr;
    }

    public String getTitleStr() {
        return titleStr;
    }

    public void setTitleStr(String titleStr) {
        this.titleStr = titleStr;
    }

    public int getBeanType() {
        return beanType;
    }

    public void setBeanType(int beanType) {
        this.beanType = beanType;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.titleStr);
        dest.writeString(this.numStr);
        dest.writeString(this.nameStr);
        dest.writeString(this.timeStr);
        dest.writeInt(this.beanType);
        dest.writeInt(this.usrType);
    }

    public AccountPeasBean() {
    }

    private AccountPeasBean(Parcel in) {
        this.titleStr = in.readString();
        this.numStr = in.readString();
        this.nameStr = in.readString();
        this.timeStr = in.readString();
        this.beanType = in.readInt();
        this.usrType = in.readInt();
    }

    public static final Parcelable.Creator<AccountPeasBean> CREATOR = new Parcelable.Creator<AccountPeasBean>() {
        public AccountPeasBean createFromParcel(Parcel source) {
            return new AccountPeasBean(source);
        }

        public AccountPeasBean[] newArray(int size) {
            return new AccountPeasBean[size];
        }
    };

    public int getUsrType() {
        return usrType;
    }

    public void setUsrType(int usrType) {
        this.usrType = usrType;
    }
}
