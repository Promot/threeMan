package com.promote.threeman.main.grow;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import com.promote.jchlib.util.view.PagerSlidingTabStrip;
import com.promote.threeman.R;
import com.promote.threeman.actionbar.HomeActionBarActivity;

/**
 * Created by ACER on 2015/4/8.
 * <p/>
 * 视频中心。
 */
public class VedioCenterActivity extends HomeActionBarActivity {

    private CheckBox delCb;
    private PagerSlidingTabStrip vediocenterstrip;
    private ViewPager vediocenterpager;

    private String[] centerTabs = null;

    private MyAdapter adapter;

    private Fragment curFrag;

    @Override
    protected View addContentView() {

        setActionType(COMM_ACTIONTYPE);
        setTitle(R.string.vedio_center);
        addDelBtn();
        View view = View.inflate(getBaseContext(), R.layout.activity_vedio_center, null);

        initialize(view);

        return view;
    }

    private void addDelBtn() {
        delCb = new CheckBox(getApplicationContext());
        delCb.setId(R.id.del_btn);
        delCb.setButtonDrawable(R.drawable.del_icon_sel);
        addRightBtn(delCb);
    }

    private void initialize(View view) {

        vediocenterstrip = (PagerSlidingTabStrip) view.findViewById(R.id.vediocenter_strip);
        vediocenterpager = (ViewPager) view.findViewById(R.id.vediocenter_pager);

        centerTabs = getResources().getStringArray(R.array.vedio_center_tabs);
        adapter = new MyAdapter(getSupportFragmentManager());
        vediocenterpager.setAdapter(adapter);
        vediocenterstrip.setViewPager(vediocenterpager);

    }

    /**
     * adapter.
     */
    private class MyAdapter extends FragmentPagerAdapter {


        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return centerTabs.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return centerTabs[position];
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            super.destroyItem(container, position, object);
        }

        @Override
        public Fragment getItem(int position) {

            if (position == 0) {
                curFrag = DownloadFrag.newInstance(null, null);
            } else if (position == 1) {
                curFrag = MyCollectionFrag.newInstance(null, null);
            } else {
                curFrag = BrowsFrag.newInstance(null, null);
            }

            return curFrag;
        }
    }


}
