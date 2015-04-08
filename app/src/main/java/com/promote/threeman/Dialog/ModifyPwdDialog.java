package com.promote.threeman.Dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.promote.threeman.R;

/**
 * Created by ACER on 2015/4/8.
 */
public class ModifyPwdDialog extends ThreeLoginDialog implements View.OnClickListener {

    private Context context;
    private EditText setpwdphone;
    private EditText setpwdold;
    private EditText setpwdnew;
    private Button modifyBtn;

    public ModifyPwdDialog(Context context, int theme) {
        super(context, theme);
        this.context = context;
    }

    @Override
    protected View getThreeContentView() {

        View view = LayoutInflater.from(context).inflate(R.layout.dialog_modity_layout, null);

        initialize(view);

        return view;
    }

    /**
     * 实例化自身。
     *
     * @param context
     * @return
     */
    public static ModifyPwdDialog create(Context context) {

        return new ModifyPwdDialog(context, R.style.Theme_AppCompat_Dialog);
    }

    private void initialize(View view) {

        setpwdphone = (EditText) view.findViewById(R.id.set_pwd_phone);
        setpwdold = (EditText) view.findViewById(R.id.set_pwd_old);
        setpwdnew = (EditText) view.findViewById(R.id.set_pwd_new);
        modifyBtn = (Button) view.findViewById(R.id.set_modify_btn);

        modifyBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.set_modify_btn: {

                break;
            }

            default: {

            }
        }
    }
}
