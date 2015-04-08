package com.promote.threeman.main.settings;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TableRow;
import android.widget.TextView;

import com.promote.threeman.Dialog.ModifyPwdDialog;
import com.promote.threeman.Dialog.ThreeLoginDialog;
import com.promote.threeman.R;
import com.promote.threeman.actionbar.HomeActionBarActivity;

/**
 * Created by ACER on 2015/4/8.
 * <p/>
 * 设置界面。
 */
public class SettingsActivity extends HomeActionBarActivity implements View.OnClickListener {


    private TableRow setpwdtr;
    private TableRow setfeedtr;
    private TableRow setabout;
    private TableRow setdes;
    private CheckBox setwificb;
    private TableRow setcheck;
    private ImageView setsavelocalimg;
    private TextView setsavelocaltv;
    private Button setlogoutbtn;

    @Override
    protected View addContentView() {

        setActionType(HomeActionBarActivity.COMM_ACTIONTYPE);
        setTitle(R.string.setting);
        View view = LayoutInflater.from(getBaseContext()).inflate(R.layout
                .activity_settings_layout, null);

        initialize(view);

        return view;
    }


    private void initialize(View view) {

        setpwdtr = (TableRow) view.findViewById(R.id.set_pwd_tr);
        setfeedtr = (TableRow) view.findViewById(R.id.set_feed_tr);
        setabout = (TableRow) view.findViewById(R.id.set_about);
        setdes = (TableRow) view.findViewById(R.id.set_des);
        setwificb = (CheckBox) view.findViewById(R.id.set_wifi_cb);
        setcheck = (TableRow) view.findViewById(R.id.set_check);
        setsavelocalimg = (ImageView) view.findViewById(R.id.set_save_local_img);
        setsavelocaltv = (TextView) view.findViewById(R.id.set_save_local_tv);
        setlogoutbtn = (Button) view.findViewById(R.id.set_logout_btn);

        setlogoutbtn.setOnClickListener(this);
        setpwdtr.setOnClickListener(this);
        setfeedtr.setOnClickListener(this);
        setabout.setOnClickListener(this);
        setdes.setOnClickListener(this);
        setcheck.setOnClickListener(this);
        setsavelocalimg.setOnClickListener(this);
        setsavelocaltv.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.set_about: {
                Intent intent = new Intent(SettingsActivity.this, AboutUsActivity.class);
                startActivity(intent);

                break;
            }
            case R.id.set_pwd_tr: {
                ThreeLoginDialog.Builder builder = new ThreeLoginDialog.Builder();
                ModifyPwdDialog dialog = (ModifyPwdDialog) builder.create(ModifyPwdDialog.create
                        (this));
                dialog.show();
                break;
            }
            case R.id.set_feed_tr: {

                Intent intent = new Intent(SettingsActivity.this, FeedbackActivity.class);
                startActivity(intent);

                break;
            }
            case R.id.set_des: {
                break;
            }
            case R.id.set_check: {
                break;
            }
            case R.id.set_save_local_img: {

                break;
            }

            case R.id.set_save_local_tv: {

                break;
            }
            case R.id.set_logout_btn: {

                break;
            }
        }

    }
}
