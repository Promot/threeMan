package com.promote.threeman.Dialog;

import android.content.Context;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.promote.threeman.R;
import com.promote.threeman.util.LogCat;

/**
 * Created by ACER on 2015/4/3.
 * <p/>
 * 获取验证码。
 */
public class RegisterTDialog extends ThreeLoginDialog implements View.OnClickListener {
    /**
     * 回调。
     */
    public interface OnRigesterClickListener {

        public void onGetCheckNumClick(View view);

        public void onShowDealClick(View view);
    }

    private EditText registerphone;
    private EditText registerpwd;
    private EditText registername;
    private TextView registerdeal;
    private Button dialoggetcheckbtn;
    private Context context;

    private OnRigesterClickListener onRigesterClickListener;

    public RegisterTDialog(Context context, int theme) {
        super(context, theme);
        this.context = context;
    }

    public void setOnRigesterClickListener(OnRigesterClickListener onRigesterClickListener) {
        this.onRigesterClickListener = onRigesterClickListener;
    }

    public static RegisterTDialog create(Context context) {
        return new RegisterTDialog(context, R.style.Theme_AppCompat_Dialog);
    }

    @Override
    protected View getThreeContentView() {

        View view = LayoutInflater.from(context).inflate(R.layout.register_dialog_layout,
                null);
        initialize(view);

        return view;
    }


    private void initialize(View view) {

        registerphone = (EditText) view.findViewById(R.id.register_phone);
        registerpwd = (EditText) view.findViewById(R.id.register_pwd);
        registername = (EditText) view.findViewById(R.id.register_name);
        registerdeal = (TextView) view.findViewById(R.id.register_deal);
        dialoggetcheckbtn = (Button) view.findViewById(R.id.dialog_get_check_btn);

        setDealStyle();
        dialoggetcheckbtn.setOnClickListener(this);


    }

    private void setDealStyle() {

        String dealStr = context.getResources().getString(R.string.register_deal);
        SpannableString ss = new SpannableString(dealStr);
        ss.setSpan(new ReadProtocolMethod(), 8, dealStr.length() - 1,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        registerdeal.setText(ss);
        registerdeal.setMovementMethod(LinkMovementMethod.getInstance());

    }

    private class ReadProtocolMethod extends ClickableSpan {

        @Override
        public void onClick(View widget) {
            LogCat.d("-----阅读协议。-----");
        }

        @Override
        public void updateDrawState(TextPaint ds) {
            super.updateDrawState(ds);
            ds.setColor(getContext().getResources().getColor(R.color.title_blue));
            ds.setUnderlineText(true);
        }
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.dialog_get_check_btn: {

                break;
            }
        }
    }

}
