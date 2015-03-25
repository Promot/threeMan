package com.promote.threeman.actionbar;

import android.content.Intent;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.promote.threeman.Dialog.HomePop;
import com.promote.threeman.R;
import com.promote.threeman.base.BaseActivity;
import com.promote.threeman.search.SearchActivity;
import com.promote.threeman.util.LogCat;

/**
 * Created by ACER on 2015/3/25.
 */
public abstract class HomeActionBarActivity extends BaseActivity implements HomePop.HomePopCallBack {


    private ImageButton homeactionicon;
    private TextView homeactiontitletv;
    private ImageButton homeactionmenu;
    private ImageButton homeactionsearch;
    //if is menu btn touched.
    private boolean PopTouchflag = false;

    private HomePop homePop;

    private View titleView;


    @Override
    protected View addActionBarView() {

        titleView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.home_actionbar,
                null);
        initialize(titleView);

        return titleView;
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
        homeactionmenu = (ImageButton) view.findViewById(R.id.home_action_menu);
        homeactionsearch = (ImageButton) view.findViewById(R.id.home_action_search);

        MyOnclickListener onclickListener = new MyOnclickListener();

        homeactionicon.setOnClickListener(onclickListener);
        homeactiontitletv.setOnClickListener(onclickListener);
        homeactionmenu.setOnClickListener(onclickListener);
        homeactionsearch.setOnClickListener(onclickListener);

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
                break;
            }
            case LOGOUT: {

                LogCat.d("logout ");
                break;
            }
            case TV_CENTER: {
                LogCat.d("tv center ");
                break;
            }
            case SETTING: {
                LogCat.d("setting ");
                break;
            }
            case GOLD: {
                LogCat.d("gold ");
                break;
            }

        }

    }


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
            titleView.getLocationOnScreen(location);
            homePop.showAtLocation(contentLayout, Gravity.RIGHT | Gravity.TOP, 0,
                    location[1] + titleView.getHeight());
        }

        homePop.setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

//                LogCat.d("event.getRawX()--: " + event.getRawX() + "homeActionMenu left--:" +
//                        homeactionmenu
//                                .getLeft() + " homeactionmenu.getRight():--" + homeactionmenu
//                        .getRight() + "event.getRawX()--:" + event.getRawY() + "homeactionmenu--:" +
//                        "                        .getTop()--:" + homeactionmenu
//                        .getTop() + "homeactionmenu.getBottom()--:" + homeactionmenu.getBottom());

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


}
