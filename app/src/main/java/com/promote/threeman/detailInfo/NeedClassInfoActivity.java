package com.promote.threeman.detailInfo;

import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.promote.jchlib.util.view.PagerSlidingTabStrip;
import com.promote.threeman.R;
import com.promote.threeman.actionbar.HomeActionBarActivity;

/**
 * 按需求选择跳转而来的详情界面。
 */
public class NeedClassInfoActivity extends HomeActionBarActivity {


    private ImageView ncinfoimg;
    private PagerSlidingTabStrip ncinfotab;
    private ViewPager ncinfolv;
    private TextView cninfodownloadnum;
    private Button ncbtnbuybtn;
    private CheckBox cncollectcb;
    private LinearLayout ncinfobtnll;

    @Override
    protected View addContentView() {

        setActionType(COMM_ACTIONTYPE);
        setTitle(R.string.source_info);
        View view = LayoutInflater.from(getBaseContext()).inflate(R.layout
                .activity_need_class_info, null);

        initialize(view);

        return view;
    }


    private void initialize(View view) {

        ncinfoimg = (ImageView) findViewById(R.id.nc_info_img);
        ncinfotab = (PagerSlidingTabStrip) findViewById(R.id.nc_info_tab);
        ncinfolv = (ViewPager) findViewById(R.id.nc_info_lv);
        cninfodownloadnum = (TextView) findViewById(R.id.cn_info_download_num);
        ncbtnbuybtn = (Button) findViewById(R.id.nc_btn_buy_btn);
        cncollectcb = (CheckBox) findViewById(R.id.cn_collect_cb);
        ncinfobtnll = (LinearLayout) findViewById(R.id.nc_info_btn_ll);
    }


}
