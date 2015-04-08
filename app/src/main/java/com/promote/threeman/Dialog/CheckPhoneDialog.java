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
 * 获取验证码。
 */
public class CheckPhoneDialog extends ThreeLoginDialog implements View.OnClickListener {

    private Context context;
    private EditText checkphonetv;
    private EditText checkphoneet;
    private Button sendcheck;
    //倒计时。
    private TextView checkdctv;
    private Button checkokbtn;

    public void setCheckPhoneIf(CheckPhoneIf checkPhoneIf) {
        this.checkPhoneIf = checkPhoneIf;
    }

    private CheckPhoneIf checkPhoneIf;

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.check_ok_btn: {
                if (checkPhoneIf != null)
                    checkPhoneIf.onOkClick(v);

                break;
            }
        }
    }

    public interface CheckPhoneIf {
        /**
         * 确定按钮点击。
         *
         * @param view
         */
        public void onOkClick(View view);

    }


    public CheckPhoneDialog(Context context, int theme) {
        super(context, theme);
        this.context = context;
    }

    @Override
    protected View getThreeContentView() {

        View view = LayoutInflater.from(context).inflate(R.layout.login_checkphone_dialog, null);

        initialize(view);

        return view;

    }

    /**
     * 创建自身实力。
     *
     * @param context
     * @return
     */
    public static CheckPhoneDialog create(Context context) {

        return new CheckPhoneDialog(context, R.style.Theme_AppCompat_Dialog);

    }

    /**
     * 初始化验证码。
     *
     * @param view
     */
    private void initialize(View view) {

        checkphonetv = (EditText) view.findViewById(R.id.check_phone_tv);
        checkphoneet = (EditText) view.findViewById(R.id.check_phone_et);
        sendcheck = (Button) view.findViewById(R.id.send_check);
        checkdctv = (TextView) view.findViewById(R.id.check_dc_tv);
        checkokbtn = (Button) view.findViewById(R.id.check_ok_btn);
    }
}
