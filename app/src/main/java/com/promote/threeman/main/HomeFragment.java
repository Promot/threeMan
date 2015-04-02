package com.promote.threeman.main;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.promote.jchlib.util.view.PagerIndicator;
import com.promote.jchlib.util.view.ScrollGridView;
import com.promote.threeman.R;
import com.promote.threeman.impl.HomeTestData;

import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment implements ViewPager.OnPageChangeListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    private ViewPager homePager;
    private MyPagerAdapter adapter;
    private ScheduledExecutorService executorService = null;
    private ScrollGridView gridView;
    //pager 改变时间间隔。秒
    private static final int PAGE_UNIT = 5;
    private PagerIndicator homeindicator;
    private ScrollGridView hometypegv;
    private ImageView homenine1img;
    private ImageView homenine2img;
    private ImageView homenine3img;
    private ImageView homenine4img;
    private ImageView homenine5img;
    private ImageView homenine6img;
    private ScrollGridView home6type;

    private String[] eightTypes;

    private ArrayList<String> sixTypes;

    private EightTypeAdapter eightTypeAdapter;
    private SixTypeAdapter sixTypeAdapter;


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        executorService = Executors.newSingleThreadScheduledExecutor();
    }


    private void initialize(View view) {

        homeindicator = (PagerIndicator) view.findViewById(R.id.home_indicator);
        homePager = (ViewPager) view.findViewById(R.id.home_pager);

        hometypegv = (ScrollGridView) view.findViewById(R.id.home_type_gv);
        homenine1img = (ImageView) view.findViewById(R.id.home_nine_1_img);
        homenine2img = (ImageView) view.findViewById(R.id.home_nine_2_img);
        homenine3img = (ImageView) view.findViewById(R.id.home_nine_3_img);
        homenine4img = (ImageView) view.findViewById(R.id.home_nine_4_img);
        homenine5img = (ImageView) view.findViewById(R.id.home_nine_5_img);
        homenine6img = (ImageView) view.findViewById(R.id.home_nine_6_img);
        home6type = (ScrollGridView) view.findViewById(R.id.home_6_type);

        eightTypes = getResources().getStringArray(R.array.home_eight_type);

        adapter = new MyPagerAdapter();

        homePager.setAdapter(adapter);
        homePager.setOnPageChangeListener(this);
        homePager.setCurrentItem(adapter.getStartpoiont());

        eightTypeAdapter = new EightTypeAdapter();
        hometypegv.setAdapter(eightTypeAdapter);

        sixTypeAdapter = new SixTypeAdapter();
        home6type.setAdapter(sixTypeAdapter);

        initTestData();
    }

    /**
     * 本地填充测试数据。
     */
    private void initTestData() {
        sixTypes = HomeTestData.getSixTypeData();
        sixTypeAdapter.notifyDataSetChanged(sixTypes);
    }

    private class MySchedule implements Runnable {
        @Override
        public void run() {
            new Handler(Looper.getMainLooper()) {
                @Override
                public void handleMessage(Message msg) {
                    super.handleMessage(msg);
                    if (msg.what == 0)
                        homePager.setCurrentItem(homePager.getCurrentItem() + 1, true);
                }
            }.sendEmptyMessage(0);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        initialize(view);

        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
        if (executorService != null) {
            executorService.shutdown();
            executorService = null;
        }

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

        homeindicator.setCurrentPage(adapter.getCurPosition(position));
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }


    /**
     * 滚动viewpager adapter.
     */
    private class MyPagerAdapter extends PagerAdapter {

        /**
         * 循环滚动的基本起始项。 *
         */
        private static final int STARTPOIONT = 300;

        public MyPagerAdapter() {
            homeindicator.setTotalPage(HomeTestData.getPagerData().length);
            homeindicator.setGravity(PagerIndicator.PagerGravity.RIGHT);
            homeindicator.setCurrentPage(0);
            executorService.scheduleAtFixedRate(new MySchedule(), PAGE_UNIT, PAGE_UNIT,
                    TimeUnit.SECONDS);        //启动循环。
        }

        public int getStartpoiont() {
            return STARTPOIONT;
        }

        @Override
        public int getCount() {
            if (HomeTestData.getPagerData().length == 1 || HomeTestData.getPagerData().length == 0) {
                return 1;
            }
            return Integer.MAX_VALUE;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {

            return view == object;
        }

        private ImageView[] getImageViews() {

            ImageView[] imageViews = new ImageView[3];
            for (int i = 0; i < 3; i++) {
                ImageView img = new ImageView(getActivity());
                img.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
                img.setScaleType(ImageView.ScaleType.CENTER_CROP);
                if (i == 0)
                    img.setBackgroundColor(getResources().getColor(R.color.red));
                if (i == 1)
                    img.setBackgroundColor(getResources().getColor(android.R.color.darker_gray));
                if (i == 2)
                    img.setBackgroundColor(getResources().getColor(R.color.sel_blue));
                imageViews[i] = img;
            }

            return imageViews;

        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            int loopPosition = getCurPosition(position);
            ImageView imageView = getImageViews()[loopPosition];
            ViewGroup parentView = (ViewGroup) imageView.getParent();
            if (parentView != null)
                parentView.removeView(imageView);

            container.addView(imageView);

            return imageView;
        }

        /**
         * 獲得循環中第幾項。
         *
         * @param position 循环中总的下标.
         * @return
         */
        public int getCurPosition(int position) {

            int imgsize = HomeTestData.getPagerData().length;
            if (imgsize == 0) {
                return 0;
            }
            int loopPosition = position % imgsize;
            return loopPosition;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
        }
    }

    /**
     * 第二项八个分类的adapter.
     */
    private class EightTypeAdapter extends BaseAdapter {


        @Override
        public int getCount() {
            return eightTypes.length;
        }

        @Override
        public Object getItem(int position) {
            return eightTypes[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = LayoutInflater.from(getActivity().getApplicationContext()).inflate(R
                    .layout.home_eight_item_layout, null);
            ImageView imageView = (ImageView) convertView.findViewById(R.id.home_eight_item_img);
            TextView tv = (TextView) convertView.findViewById(R.id.home_eight_item_tv);

            imageView.setImageResource(getResource(position));
            tv.setText(eightTypes[position]);

            return convertView;
        }

        private int getResource(int position) {

            switch (position) {

                case 0: {
                    return R.mipmap.three_about_comp;
                }
                case 1: {
                    return R.mipmap.three_about_comp;
                }
                case 2: {
                    return R.mipmap.three_about_comp;
                }
                case 3: {
                    return R.mipmap.three_about_comp;
                }
                case 4: {
                    return R.mipmap.three_about_comp;
                }
                case 5: {
                    return R.mipmap.three_about_comp;
                }
                case 6: {
                    return R.mipmap.three_about_comp;
                }
                case 7: {
                    return R.mipmap.three_about_comp;
                }
                case 8: {
                    return R.mipmap.three_about_comp;
                }
                default: {
                    throw new IndexOutOfBoundsException("the index of eight type is out of bound");
                }


            }

        }

    }

    /**
     * 按行业分类，六行业adapter.
     */
    private class SixTypeAdapter extends BaseAdapter {

        private ArrayList<String> types = new ArrayList<>();

        public void notifyDataSetChanged(ArrayList<String> types) {

            if (types != null) {
                this.types.clear();
                this.types.addAll(types);
            }
            super.notifyDataSetChanged();
        }

        @Override
        public int getCount() {
            return types.size();
        }

        @Override
        public Object getItem(int position) {
            return types.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            convertView = LayoutInflater.from(getActivity().getApplicationContext()).inflate(R
                    .layout.home_6_type_gv_item, null);
            ImageView img = (ImageView) convertView.findViewById(R.id.home_6_type_item_img);
            // set img resource
            //img.setR...       position

            ViewGroup.LayoutParams params = img.getLayoutParams();
            params.height = 100;
            img.setLayoutParams(params);


            return convertView;
        }
    }

}
