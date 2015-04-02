package com.promote.threeman.detailInfo;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.promote.threeman.R;
import com.promote.threeman.actionbar.HomeActionBarActivity;

/**
 * 标杆案例和三身形跳转到这儿的详情界面。
 * <p/>
 * 分为标杆案例，三身形，消息详情跳转而来的三种详情情况。
 */
public class CaseAndThreeInfoActivity extends HomeActionBarActivity {

    public static final int CASEINFO = 5;
    public static final int THREEINFO = 6;
    public static final int MSGINFO = 7;

    public static final String TYPEKEY = "info_type";

    private int infoType = -1;
    private ImageView caseinfotopimg;
    private TextView caseinfotitletv;
    private TextView caseinfotimetime;
    private LinearLayout caseinfomidll;
    private TextView caseinfobtmll;

    @Override
    protected View addContentView() {

        Intent intent = getIntent();

        infoType = intent.getIntExtra(TYPEKEY, -1);

        View contentView = LayoutInflater.from(getApplicationContext()).inflate(R.layout
                .activity_case_and_three_info, null);
        setActionType(HomeActionBarActivity.COMM_ACTIONTYPE);
        setTitle(R.string.source_info);

        initialize(contentView);

        return contentView;
    }

    /**
     * 初始化课程。
     *
     * @param view
     */
    private void initialize(View view) {

        caseinfotopimg = (ImageView) view.findViewById(R.id.case_info_top_img);
        caseinfotitletv = (TextView) view.findViewById(R.id.case_info_title_tv);
        caseinfotimetime = (TextView) view.findViewById(R.id.case_info_time_time);
        caseinfomidll = (LinearLayout) view.findViewById(R.id.case_info_mid_ll);
        caseinfobtmll = (TextView) view.findViewById(R.id.case_info_btm_ll);

        displayType();


    }

    private void displayType() {
        if (infoType == THREEINFO) {
            caseinfomidll.setVisibility(View.GONE);
        } else {
            caseinfomidll.setVisibility(View.VISIBLE);
        }
    }
}
