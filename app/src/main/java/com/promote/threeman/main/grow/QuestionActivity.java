package com.promote.threeman.main.grow;

import android.view.LayoutInflater;
import android.view.View;

import com.promote.threeman.R;
import com.promote.threeman.actionbar.HomeActionBarActivity;

/**
 * Created by ACER on 2015/4/13.
 */
public class QuestionActivity extends HomeActionBarActivity {


    @Override
    protected View addContentView() {
        setTitle(R.string.my_question);
        setActionType(COMM_ACTIONTYPE);

        View view = LayoutInflater.from(getBaseContext()).inflate(R.layout
                .activity_question_layout, null);

        return view;
    }
}
