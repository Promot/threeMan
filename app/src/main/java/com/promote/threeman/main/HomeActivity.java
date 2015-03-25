package com.promote.threeman.main;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.promote.jchlib.util.view.PagerSlidingTabStrip;
import com.promote.threeman.R;
import com.promote.threeman.actionbar.HomeActionBarActivity;

/**
 * Error:Execution failed for task ':app:processDebugResources'.
 * > com.android.ide.common.process.ProcessException: org.gradle.process.internal.ExecException: Process 'command 'F:\android\AppData\sdk\build-tools\android-4.4W\aapt.exe'' finished with non-zero exit value 1
 */
public class HomeActivity extends HomeActionBarActivity implements ViewPager.OnPageChangeListener,
        OnFragmentInteractionListener {

    private PagerSlidingTabStrip hometab;
    private ViewPager homepager;
    private MyPagerFragAdapter fragAdapter;
    private Fragment[] frags;
    private String[] tabs;

    @Override
    protected View addContentView() {
        View view = LayoutInflater.from(getApplicationContext()).inflate(R.layout.activity_main, null);
        view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        initialize(view);
        return view;
    }

    private void initialize(View view) {

        hometab = (PagerSlidingTabStrip) view.findViewById(R.id.home_tab);
        homepager = (ViewPager) view.findViewById(R.id.home_pager);
        tabs = getResources().getStringArray(R.array.home_tabs);

        frags = new Fragment[3];
        HomeFragment homeFragment = HomeFragment.newInstance(null, null);
        SubjectFragment subjectFragment = SubjectFragment.newInstance(null, null);
        TeacherFragment teacherFragment = TeacherFragment.newInstance(null, null);
        frags[0] = homeFragment;
        frags[1] = subjectFragment;
        frags[2] = teacherFragment;

        fragAdapter = new MyPagerFragAdapter(getSupportFragmentManager());
        homepager.setAdapter(fragAdapter);
        hometab.setViewPager(homepager);
        hometab.setOnPageChangeListener(this);

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    private class MyPagerFragAdapter extends FragmentPagerAdapter {

        public MyPagerFragAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return frags.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabs[position];
        }

        @Override
        public Fragment getItem(int position) {
            return frags[position];
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            super.destroyItem(container, position, object);
        }
    }
}
