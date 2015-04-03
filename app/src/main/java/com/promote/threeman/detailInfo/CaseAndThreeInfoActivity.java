package com.promote.threeman.detailInfo;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.promote.threeman.R;
import com.promote.threeman.actionbar.HomeActionBarActivity;
import com.promote.threeman.bean.CaseFragBean;
import com.promote.threeman.bean.SourceBean;

/**
 * 标杆案例和三身形跳转到这儿的详情界面。
 * <p/>
 * 分为标杆案例，三身形，消息详情跳转而来的三种详情情况。
 */
public class CaseAndThreeInfoActivity extends HomeActionBarActivity {

    public static final int CASEINFO = 5;
    public static final int THREEINFO = 6;
    public static final int MSGINFO = 7;

    public static final String PARM_TYPEKEY = "info_type";
    public static final String PARM_OBJKEY = "obj_key";

    private int infoType = -1;
    private ImageView caseinfotopimg;
    private TextView caseinfotitletv;
    private TextView caseinfotimetime;
    private LinearLayout caseinfomidll;
    private TextView caseinfobtmTv;
    private SourceBean infoOjb;

    @Override
    protected View addContentView() {

        Intent intent = getIntent();

        infoType = intent.getIntExtra(PARM_TYPEKEY, -1);
        infoOjb = intent.getParcelableExtra(PARM_OBJKEY);

        View contentView = LayoutInflater.from(getApplicationContext()).inflate(R.layout
                .activity_case_and_three_info, null);
        setActionType(HomeActionBarActivity.COMM_ACTIONTYPE);

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
        caseinfobtmTv = (TextView) view.findViewById(R.id.case_info_btm_tv);

        displayType();

//        caseinfotopimg.setImageBitmap();
        caseinfobtmTv.setText(infoOjb.getContent());

    }

    /**
     * 根据详情的类型显示对应的不同内容。
     */
    private void displayType() {
        if (infoType == THREEINFO) {        //三身行详情
            setTitle(infoOjb.getName());
            caseinfomidll.setVisibility(View.GONE);

        } else if (infoType == MSGINFO) {        //消息详情，
            setTitle(R.string.info);
            caseinfomidll.setVisibility(View.VISIBLE);
            setMidViewData();
        } else {        //      标杆案例。
            setTitle(R.string.source_info);
            caseinfomidll.setVisibility(View.VISIBLE);
            setMidViewData();
        }
    }

    private void setMidViewData() {
        CaseFragBean caseFragBean = (CaseFragBean) infoOjb;
        caseinfotitletv.setText(caseFragBean.getName());
        caseinfotimetime.setText(String.valueOf(caseFragBean.getDate()));
    }
}
