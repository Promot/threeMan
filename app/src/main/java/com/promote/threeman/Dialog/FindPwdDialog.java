package com.promote.threeman.Dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.promote.threeman.R;

/**
 * Created by ACER on 2015/4/3.
 */
public class FindPwdDialog extends ThreeLoginDialog implements View.OnClickListener {

    public interface OnCheckNumClickListener {
        public void onCheckNumClick(View view);
    }

    private EditText findpwdphone;
    private EditText findpwdpwd;
    private Button findpwdlogin;
    private Context context;

    public void setOnCheckNumClickListener(OnCheckNumClickListener onCheckNumClickListener) {
        this.onCheckNumClickListener = onCheckNumClickListener;
    }

    private OnCheckNumClickListener onCheckNumClickListener;

    public FindPwdDialog(Context context, int theme) {
        super(context, theme);
        this.context = context;
    }

    @Override
    protected View getThreeContentView() {

        View view = LayoutInflater.from(context).inflate(R.layout.find_pwd_dialog_layout,
                null);
        initialize(view);

        return view;

    }

    /**
     * 创建本类实例。
     *
     * @param context
     * @return
     */
    public static FindPwdDialog create(Context context) {
        return new FindPwdDialog(context, R.style.Theme_AppCompat_Dialog);
    }

    private void initialize(View view) {

        findpwdphone = (EditText) view.findViewById(R.id.find_pwd_phone);
        findpwdpwd = (EditText) view.findViewById(R.id.find_pwd_pwd);
        findpwdlogin = (Button) view.findViewById(R.id.find_pwd_check);

        findpwdphone.setOnClickListener(this);
        findpwdpwd.setOnClickListener(this);
        findpwdlogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.find_pwd_check: {

                onCheckNumClickListener.onCheckNumClick(v);
                dismiss();
                break;
            }
            case R.id.find_pwd_pwd: {

                break;
            }
            case R.id.find_pwd_phone: {

                break;
            }

        }

    }
}
