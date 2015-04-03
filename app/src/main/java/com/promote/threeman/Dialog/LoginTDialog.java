package com.promote.threeman.Dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.promote.threeman.R;

/**
 * Created by ACER on 2015/4/3.
 * <p/>
 * 登录对话框。
 */
public class LoginTDialog extends ThreeLoginDialog implements View.OnClickListener {

    public interface OnLoginClickListener {

        public void onLoginClick(View view);

        public void onForgetClick(View view);

    }

    Context context = null;
    private EditText loginphone;
    private EditText loginpwd;
    private Button dialoglogin;
    private TextView forgetPwdTv;

    private OnLoginClickListener onLoginClickListener;

    public LoginTDialog(Context context, int theme) {
        super(context, theme);
        this.context = context;
    }

    /**
     * 创建本类实例。
     *
     * @param context
     * @return
     */
    public static LoginTDialog create(Context context) {
        return new LoginTDialog(context, R.style.Theme_AppCompat_Dialog);
    }

    public OnLoginClickListener getOnLoginClickListener() {
        return onLoginClickListener;
    }

    public void setOnLoginClickListener(OnLoginClickListener onLoginClickListener) {
        this.onLoginClickListener = onLoginClickListener;
    }

    @Override
    protected View getThreeContentView() {
        View view = LayoutInflater.from(context).inflate(R.layout.login_dialog, null);

        initialize(view);

        return view;
    }

    private void initialize(View view) {
        loginphone = (EditText) view.findViewById(R.id.login_phone);
        loginpwd = (EditText) view.findViewById(R.id.login_pwd);
        dialoglogin = (Button) view.findViewById(R.id.dialog_login);
        forgetPwdTv = (TextView) view.findViewById(R.id.login_fogt_tv);

        loginphone.setOnClickListener(this);
        loginpwd.setOnClickListener(this);
        dialoglogin.setOnClickListener(this);
        forgetPwdTv.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.login_phone: {

                break;
            }

            case R.id.login_pwd: {

                break;
            }

            case R.id.dialog_login: {

                onLoginClickListener.onLoginClick(v);
                dismiss();
                break;
            }

            case R.id.login_fogt_tv: {
                onLoginClickListener.onForgetClick(v);
                dismiss();
                break;
            }
        }

    }
}
