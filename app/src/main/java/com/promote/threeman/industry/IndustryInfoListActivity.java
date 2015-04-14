package com.promote.threeman.industry;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.promote.threeman.R;
import com.promote.threeman.util.LogCat;

/**
 * Created by ACER on 2015/4/13.
 * <p/>
 * 行业详情列表。
 */
public class IndustryInfoListActivity extends Activity implements View.OnClickListener {

    private ImageView indusutryinfoheadback;
    private ImageView industryinfoheadimg;
    private ImageButton industryinfoheadconvbtn;
    private TextView industryinfoheadtitletv;
    private TextView industryinfoheaddestv;
    private RelativeLayout industryinfoheadlayout;
    private ListView industryinfolist;
    private LinearLayout industryContentLl;
    private View industryHeadImgTempView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_indus_info_list_layout);

        initialize();
    }

    private void initialize() {

        indusutryinfoheadback = (ImageView) findViewById(R.id.indusutry_info_head_back);
        industryinfoheadimg = (ImageView) findViewById(R.id.industry_info_head_img);
        industryinfoheadconvbtn = (ImageButton) findViewById(R.id.industry_info_head_conv_btn);
        industryinfoheadtitletv = (TextView) findViewById(R.id.industry_info_head_title_tv);
        industryinfoheaddestv = (TextView) findViewById(R.id.industry_info_head_des_tv);
        industryinfoheadlayout = (RelativeLayout) findViewById(R.id.industry_info_head_layout);
        industryinfolist = (ListView) findViewById(R.id.industry_info_list);
        industryContentLl = (LinearLayout) findViewById(R.id.industry_info_content_ll);
        industryHeadImgTempView = (View) findViewById(R.id.industry_info_head_view);

        industryinfoheadconvbtn.setOnClickListener(this);
        indusutryinfoheadback.setOnClickListener(this);
        industryinfoheadconvbtn.setTag(true);       //动画状态标示。
    }

    @Override
    public void onClick(View v) {

        int id = v.getId();
        switch (id) {

            case R.id.indusutry_info_head_back: {
                onBackPressed();
                this.finish();
                break;
            }
            case R.id.industry_info_head_img: {
                break;
            }
            case R.id.industry_info_head_conv_btn: {
                runHeadAnim();
                break;
            }
            case R.id.industry_info_head_title_tv: {

                break;

            }
            case R.id.industry_info_head_des_tv: {

                break;

            }
            case R.id.industry_info_head_layout: {

                break;

            }
            case R.id.industry_info_list: {

                break;

            }

        }
    }

    /**
     * 运行头部的动画。
     */
    private void runHeadAnim() {
        boolean transFlag = (boolean) industryinfoheadconvbtn.getTag();
        if (transFlag) {
            hidImgAnimation();
        } else {
            showImgAnimation();
        }
        runRotate();

    }

    /**
     * 点击按钮旋转动画。
     */
    private void runRotate() {

        final float degressDet = 180f;      //动画每次旋转180度。

        final float fromDegrees = industryinfoheadconvbtn.getRotation();        //获得view本次动画前的角度。
        final float toDegrees = fromDegrees + degressDet;         //计算view本次旋转后得到的角度
        //动画每次旋转180度。
        final Animation rotationAnimation = new RotateAnimation(0, degressDet,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotationAnimation.setDuration(1500);

        rotationAnimation.setFillEnabled(true);
        rotationAnimation.setFillBefore(false);
        rotationAnimation.setFillAfter(true);     //view在动画结束时不会回到原来状态，

        rotationAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                boolean animFlag = (boolean) industryinfoheadconvbtn.getTag();
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                boolean animFlag = (boolean) industryinfoheadconvbtn.getTag();
                industryinfoheadconvbtn.setRotation(toDegrees);     //跟新view的角度。使view的角度与旋转后的动画一致
                industryinfoheadconvbtn.clearAnimation();
                industryinfoheadconvbtn.setTag(!animFlag);        //改变动画状态。
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        industryinfoheadconvbtn.startAnimation(rotationAnimation);
    }

    /**
     * img 隐藏动画。
     */
    private void hidImgAnimation() {

        ObjectAnimator rotationAnimator = ObjectAnimator.ofFloat(industryinfoheadimg, "rotation",
                720f);
        rotationAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        rotationAnimator.setDuration(1500);
        rotationAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {

            }
        });

        //添加状态监听事件
//        rotationAnimator.addListener(new Animator.AnimatorListener() {
//        });

        ObjectAnimator transAnimation = ObjectAnimator.ofFloat(industryinfoheadimg,
                "translationY", 0, -industryinfoheadimg.getX());
        transAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        transAnimation.setDuration(1500);
        transAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {

            }
        });
        //文字改变。
        ValueAnimator waitAnimator = ValueAnimator.ofInt(0, 0);
        waitAnimator.setDuration(300);

        final ValueAnimator valueAnimator = ValueAnimator.ofFloat(industryinfoheadimg.getHeight()
                , 0);
        valueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        valueAnimator.setDuration(1200);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                ViewGroup.LayoutParams params = industryHeadImgTempView.getLayoutParams();
                params.height = (int) (float) animation.getAnimatedValue();
                industryHeadImgTempView.setLayoutParams(params);
                LogCat.d("params.height: hide" + params.height);
            }
        });

        AnimatorSet tvAnimSet = new AnimatorSet();
        tvAnimSet.playSequentially(waitAnimator, valueAnimator);


        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(rotationAnimator, transAnimation, tvAnimSet);
        animatorSet.start();

    }

    private void showImgAnimation() {

        ObjectAnimator rotationAnim = ObjectAnimator.ofFloat(industryinfoheadimg, "rotation", 0);
        rotationAnim.setInterpolator(new AccelerateDecelerateInterpolator());
        rotationAnim.setDuration(1500);
        rotationAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
            }
        });

        ObjectAnimator transAnimation = ObjectAnimator.ofFloat(industryinfoheadimg,
                "translationY", -industryinfoheadimg.getX(), 0);
        transAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        transAnimation.setDuration(1500);
        transAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {

            }
        });
        //文字改变。

        final ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, industryinfoheadimg.getHeight());
        valueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        valueAnimator.setDuration(1200);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                LogCat.d("industryinfoheadimg.getHeight() + " + industryinfoheadimg.getHeight());

                ViewGroup.LayoutParams params = industryHeadImgTempView.getLayoutParams();
                params.height = (int) ((float) animation.getAnimatedValue());
                industryHeadImgTempView.setLayoutParams(params);
                LogCat.d("params.height show:" + params.height);
            }
        });

        ValueAnimator waitAnimator = ValueAnimator.ofInt(0, 0);
        waitAnimator.setDuration(300);

        AnimatorSet tvAnimSet = new AnimatorSet();
        tvAnimSet.playSequentially(valueAnimator, waitAnimator);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(rotationAnim, transAnimation, valueAnimator);
        animatorSet.start();
    }

}
