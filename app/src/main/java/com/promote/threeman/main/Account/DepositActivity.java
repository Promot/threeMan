package com.promote.threeman.main.Account;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.promote.threeman.R;
import com.promote.threeman.actionbar.HomeActionBarActivity;

/**
 * 提现。
 * <p/>
 * Created by ACER on 2015/4/7.
 */
public class DepositActivity extends HomeActionBarActivity implements View.OnClickListener {


    private TextView accountnametv;
    private TextView accountnotv;
    private TextView accontbeansnum;
    private EditText accountinputzfbet;
    private EditText accountinputnumet;
    private TextView accountdepositnumtv;
    private Button accountdepositbtn;

    private int usrType = -1;

    @Override
    protected View addContentView() {

        setActionType(HomeActionBarActivity.COMM_ACTIONTYPE);
        setTitle(R.string.account_deposit);
        View view = LayoutInflater.from(getBaseContext()).inflate(R.layout
                .activity_deposit_layout, null);

        initialize(view);

        return view;
    }

    /**
     * 初始化。
     *
     * @param view
     */
    private void initialize(View view) {

        usrType = getIntent().getIntExtra(FirmBeanActivity.URSERTYPE_KEY, -1);

        accountnametv = (TextView) view.findViewById(R.id.account_name_tv);
        accountnotv = (TextView) view.findViewById(R.id.account_no_tv);
        accontbeansnum = (TextView) view.findViewById(R.id.accont_beans_num);
        accountinputzfbet = (EditText) view.findViewById(R.id.account_input_zfb_et);
        accountinputnumet = (EditText) view.findViewById(R.id.account_input_num_et);
        accountdepositnumtv = (TextView) view.findViewById(R.id.account_deposit_num_tv);
        accountdepositbtn = (Button) view.findViewById(R.id.account_deposit_btn);
        accountdepositbtn.setOnClickListener(this);

        updateUiByUsr();

    }

    /**
     * 根据用户类型跟新Ui.
     */
    private void updateUiByUsr() {

        if (usrType == FirmBeanActivity.NOMAL_URSER) {      //普通用户。
            setTitle(getResources().getString(R.string.account_charge));
            accountinputzfbet.setVisibility(View.GONE);
            accountinputnumet.setHint(R.string.account_input_recharge);
            accountdepositbtn.setText(getResources().getString(R.string.account_afb_charge));

        } else if (usrType == FirmBeanActivity.FIRM_URSER) {        //企业用户。
            setTitle(getResources().getString(R.string.account_deposit));
            accountinputzfbet.setVisibility(View.VISIBLE);
            accountinputnumet.setHint(R.string.account_input_deposit);
            accountdepositbtn.setText(getResources().getString(R.string.account_zfb_deposit_btn));

        } else {
            throw new IllegalStateException("There isn't any usr type.");
        }
    }


    @Override
    public void onClick(View v) {

        if (usrType == FirmBeanActivity.FIRM_URSER) {


        } else if (usrType == FirmBeanActivity.NOMAL_URSER) {


        } else {
            throw new IllegalStateException("There isn't any usr type.");
        }

    }
}
