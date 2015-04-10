package com.promote.threeman.actionbar;

import android.content.Intent;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.promote.threeman.Dialog.CheckPhoneDialog;
import com.promote.threeman.Dialog.FindPwdDialog;
import com.promote.threeman.Dialog.HomePop;
import com.promote.threeman.Dialog.LoginTDialog;
import com.promote.threeman.Dialog.RegisterTDialog;
import com.promote.threeman.Dialog.ThreeLoginDialog;
import com.promote.threeman.R;
import com.promote.threeman.base.BaseActivity;
import com.promote.threeman.impl.BeansTestData;
import com.promote.threeman.main.Account.FirmBeanActivity;
import com.promote.threeman.main.grow.VedioCenterActivity;
import com.promote.threeman.main.msg.MsgListActivity;
import com.promote.threeman.main.settings.SettingsActivity;
import com.promote.threeman.search.SearchActivity;
import com.promote.threeman.util.LogCat;

/**
 * Created by ACER on 2015/3/25.
 * <p/>
 * 首页的actionBar.
 */
public abstract class HomeActionBarActivity extends BaseActivity implements HomePop.HomePopCallBack {

    public static int HOME_ACTIONTYPE = 1;
    public static int COMM_ACTIONTYPE = 2;


    private ImageButton homeactionicon;
    private TextView homeactiontitletv;
    private ImageView homeactionmenu;
    private ImageView homeactionsearch;
    private ImageButton homeBackBtn;
    private LinearLayout homeLeftLl;
    private RelativeLayout homeRightRl;
    //if is menu btn touched.
    private boolean PopTouchflag = false;
    //默认首页actionBAr。
    private int actionType = HOME_ACTIONTYPE;

    private HomePop homePop;

    private View actioinBarView;


    @Override
    protected View addActionBarView() {

        actioinBarView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.home_actionbar,
                null);
        initialize(actioinBarView);

        return actioinBarView;
    }

    private class MyOnclickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            int id = v.getId();
            switch (id) {

                case R.id.home_action_icon: {


                    break;
                }
                case R.id.home_action_title_tv: {

                    break;
                }

                case R.id.action_back_ib: {
                    onBackPressed();
                    HomeActionBarActivity.this.finish();
                    break;
                }
                case R.id.home_action_menu: {

                    showMenu();
                    break;
                }
                case R.id.home_action_search: {
                    Intent intent = new Intent(HomeActionBarActivity.this, SearchActivity.class);
                    startActivity(intent);
                    break;
                }

            }

        }
    }

    /**
     * 初始化。
     *
     * @param view
     */
    private void initialize(View view) {

        homeactionicon = (ImageButton) view.findViewById(R.id.home_action_icon);
        homeactiontitletv = (TextView) view.findViewById(R.id.home_action_title_tv);
        homeactionmenu = (ImageView) view.findViewById(R.id.home_action_menu);
        homeactionsearch = (ImageView) view.findViewById(R.id.home_action_search);
        homeBackBtn = (ImageButton) view.findViewById(R.id.action_back_ib);
        homeLeftLl = (LinearLayout) view.findViewById(R.id.home_left_ll);
        homeRightRl = (RelativeLayout) view.findViewById(R.id.actionbar_r_rl);

        MyOnclickListener onclickListener = new MyOnclickListener();

        homeactionicon.setOnClickListener(onclickListener);
        homeactiontitletv.setOnClickListener(onclickListener);
        homeactionmenu.setOnClickListener(onclickListener);
        homeactionsearch.setOnClickListener(onclickListener);
        homeBackBtn.setOnClickListener(onclickListener);
    }

    /**
     * home action bar. 类型。
     */
    private void onActionBarType(int actionType) {

        if (actionType == HOME_ACTIONTYPE) {        //home 类型。
            homeBackBtn.setVisibility(View.GONE);
            homeactionicon.setVisibility(View.VISIBLE);
        } else {            //common 类型。
            homeactionicon.setVisibility(View.GONE);
            homeBackBtn.setVisibility(View.VISIBLE);
        }
    }

    /**
     * 设置actionbar 类型。默认是home类型。
     *
     * @param actionType
     */
    public void setActionType(int actionType) {
        this.actionType = actionType;
        onActionBarType(actionType);
    }

    /**
     * 设置标题。
     *
     * @param titleStr
     */
    public void setTitle(String titleStr) {
        homeactiontitletv.setText(titleStr);
    }

    /**
     * 设置标题。
     *
     * @param titleId
     */
    public void setTitle(int titleId) {
        homeactiontitletv.setText(titleId);
    }


    /**
     * 添加右边按钮。
     *
     * @param btn
     */
    public void addRightBtn(View btn) {

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams
                .WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        btn.setLayoutParams(params);
        params.addRule(RelativeLayout.LEFT_OF, R.id.home_action_search);       //居搜索按钮左。
        homeRightRl.addView(btn);

    }

    @Override

    public void callBack(HomePop.PopClickType type) {

        switch (type) {

            case HOME: {

                LogCat.d("home ");
                break;
            }
            case LOGIN: {
                LogCat.d("login");
                showLogin();
                break;
            }
            case REGISTER: {

                showRegister();
                break;
            }
            case GROW: {

                Intent intent = new Intent(HomeActionBarActivity.this, VedioCenterActivity.class);
                startActivity(intent);

                LogCat.d("grow ");
                break;
            }
            case SETTING: {
                LogCat.d("setting ");

                Intent intent = new Intent(HomeActionBarActivity.this, SettingsActivity.class);
                startActivity(intent);
                LogCat.d("account ");

                break;
            }
            case ACCOUNT: {

                Intent intent = new Intent(HomeActionBarActivity.this, FirmBeanActivity.class);
                intent.putExtra(FirmBeanActivity.URSERTYPE_KEY, BeansTestData.accountType);
                startActivity(intent);
                LogCat.d("account ");
                break;
            }
            case MSG: {
                LogCat.d("msg ");

                Intent intent = new Intent(HomeActionBarActivity.this,
                        MsgListActivity.class);
                startActivity(intent);

                break;
            }

        }

    }

    /**
     * 显示对话框。
     */
    private void showMenu() {

        if (homePop == null) {
            homePop = new HomePop(getApplicationContext());
            homePop.setCallBack(this);
            homePop.setOnDismissListener(new PopupWindow.OnDismissListener() {
                @Override
                public void onDismiss() {

                }
            });
        }
        if (homePop.isShowing()) {
            homePop.dismiss();
        } else {
            int location[] = new int[2];
            actioinBarView.getLocationOnScreen(location);
            homePop.showAtLocation(contentLayout, Gravity.RIGHT | Gravity.TOP, 0,
                    location[1] + actioinBarView.getHeight());
        }

        homePop.setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (event.getRawX() < homeactionmenu.getLeft() || event.getRawX() > homeactionmenu
                        .getRight() || event.getRawY() < homeactionmenu
                        .getTop() || event.getRawY() > homeactionmenu.getBottom()) {
                    LogCat.d("homePop out ouTouch");
                    return false;
                } else {
                    return true;
                }
            }
        });

    }

    /**
     * 登录对话框。
     */
    private void showLogin() {
        ThreeLoginDialog.Builder builder = new ThreeLoginDialog.Builder();
        LoginTDialog dialog = (LoginTDialog) builder.create(LoginTDialog.create(this));
        dialog.setOwnerActivity(this);
        dialog.show();
        dialog.setOnLoginClickListener(new LoginTDialog.OnLoginClickListener() {
            @Override
            public void onLoginClick(View view) {

            }

            @Override
            public void onForgetClick(View view) {
                showFindPwd();
            }
        });
    }

    /**
     * 找回密码。
     */
    private void showFindPwd() {

        ThreeLoginDialog.Builder builder = new ThreeLoginDialog.Builder();
        FindPwdDialog findPwdDialog = (FindPwdDialog) builder.create(FindPwdDialog.create(this));
        findPwdDialog.setOwnerActivity(this);
        findPwdDialog.show();
        findPwdDialog.setOnCheckNumClickListener(new FindPwdDialog.OnCheckNumClickListener() {
            @Override
            public void onCheckNumClick(View view) {

            }
        });


    }

    /**
     * 显示注册。
     */
    private void showRegister() {

        ThreeLoginDialog.Builder builder = new ThreeLoginDialog.Builder();
        RegisterTDialog dialog = (RegisterTDialog) builder.create(RegisterTDialog.create(this));
        dialog.setOwnerActivity(this);
        dialog.show();
        dialog.setOnRigesterClickListener(new RegisterTDialog.OnRigesterClickListener() {
            @Override
            public void onGetCheckNumClick(View view) {
                getCheckNum();
            }

            @Override
            public void onShowDealClick(View view) {

            }
        });

    }

    /**
     * 获取验证码。
     */
    private void getCheckNum() {

        CheckPhoneDialog.Builder builder = new CheckPhoneDialog.Builder();
        CheckPhoneDialog dialog = (CheckPhoneDialog) builder.create(CheckPhoneDialog.create(this));
        dialog.setOwnerActivity(this);
        dialog.show();
        dialog.setCheckPhoneIf(new CheckPhoneDialog.CheckPhoneIf() {
            @Override
            public void onOkClick(View view) {

            }
        });

    }


}
