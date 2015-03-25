package com.promote.threeman.Dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TableRow;
import android.widget.TextView;

import com.promote.threeman.R;

/**
 * Created by ACER on 2015/3/20.
 */
public class HomePop extends PopupWindow implements View.OnClickListener {


    private ImageView homepopimg;
    private TextView pophomenametv;
    private TextView pophomeunrgttv;
    private TableRow pophometvtr;
    private TableRow pophomesettingtr;
    private TableRow pophomegoldtr;

    public void setCallBack(HomePopCallBack callBack) {
        this.callBack = callBack;
    }

    private HomePopCallBack callBack;

    public enum PopClickType {
        HOME, LOGIN, LOGOUT, TV_CENTER, SETTING, GOLD;
    }

    @Override
    public void onClick(View v) {

        int id = v.getId();
        switch (id) {
            case R.id.homepop_img: {
                callBack.callBack(PopClickType.HOME);
                break;
            }
            case R.id.pop_home_name_tv: {
                callBack.callBack(PopClickType.HOME);
                break;
            }
            case R.id.pop_home_unrgt_tv: {
                callBack.callBack(PopClickType.LOGOUT);
                break;
            }
            case R.id.pop_home_tv_tr: {
                callBack.callBack(PopClickType.HOME);
                break;
            }
            case R.id.pop_home_setting_tr: {
                callBack.callBack(PopClickType.SETTING);
                break;
            }
            case R.id.pop_home_gold_tr: {
                callBack.callBack(PopClickType.GOLD);
                break;
            }

        }
        dismiss();
    }


    private void initialize(View view) {
        homepopimg = (ImageView) view.findViewById(R.id.homepop_img);
        pophomenametv = (TextView) view.findViewById(R.id.pop_home_name_tv);
        pophomeunrgttv = (TextView) view.findViewById(R.id.pop_home_unrgt_tv);
        pophometvtr = (TableRow) view.findViewById(R.id.pop_home_tv_tr);
        pophomesettingtr = (TableRow) view.findViewById(R.id.pop_home_setting_tr);
        pophomegoldtr = (TableRow) view.findViewById(R.id.pop_home_gold_tr);

        homepopimg.setOnClickListener(this);
        pophomenametv.setOnClickListener(this);
        pophomeunrgttv.setOnClickListener(this);
        pophometvtr.setOnClickListener(this);
        pophomesettingtr.setOnClickListener(this);
        pophomegoldtr.setOnClickListener(this);
    }

    /**
     *
     */
    public interface HomePopCallBack {

        public void callBack(PopClickType type);
    }

    public HomePop(Context context) {
        super(context);
        setWindowLayoutMode(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        View view = LayoutInflater.from(context).inflate(R.layout.home_pop_layout, null);
        initialize(view);
        setContentView(view);
        setOutsideTouchable(true);
        setAnimationStyle(android.R.style.Animation_Dialog);
        setBackgroundDrawable(context.getResources().getDrawable(android.R.drawable.editbox_dropdown_light_frame));
        update();
    }


}
