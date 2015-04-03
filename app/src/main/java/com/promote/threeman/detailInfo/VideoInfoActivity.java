package com.promote.threeman.detailInfo;

import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebView;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.promote.threeman.R;
import com.promote.threeman.actionbar.HomeActionBarActivity;

/**
 * 播放视频的详情界面。
 */
public class VideoInfoActivity extends HomeActionBarActivity {

    private CheckBox collectBtn;
    private WebView videoinfotopimg;
    private TextView videoinfotitletv;
    private TextView videoinfotimetime;
    private LinearLayout videoinfomidll;
    private TextView videoinfobtmtv;

    @Override
    protected View addContentView() {

        View view = LayoutInflater.from(getApplicationContext()).inflate(R.layout
                .activity_video_info, null);

        initialize(view);

        setActionType(HomeActionBarActivity.COMM_ACTIONTYPE);
        addCollectBtn();

        return view;
    }

    private void addCollectBtn() {
        collectBtn = new CheckBox(getApplicationContext());
        collectBtn.setId(R.id.collect_btn);
        collectBtn.setButtonDrawable(R.drawable.collect_btn_bg_sel);
        collectBtn.setBackgroundResource(R.drawable.collect_btn_bg_sel);
        addRightBtn(collectBtn);
    }

    private void initialize(View view) {

        videoinfotopimg = (WebView) view.findViewById(R.id.video_info_top_img);
        videoinfotitletv = (TextView) view.findViewById(R.id.video_info_title_tv);
        videoinfotimetime = (TextView) view.findViewById(R.id.video_info_time_time);
        videoinfomidll = (LinearLayout) view.findViewById(R.id.video_info_mid_ll);
        videoinfobtmtv = (TextView) view.findViewById(R.id.video_info_btm_tv);
    }
}
