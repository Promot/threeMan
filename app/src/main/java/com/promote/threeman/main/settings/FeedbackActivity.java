package com.promote.threeman.main.settings;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.promote.threeman.R;
import com.promote.threeman.actionbar.HomeActionBarActivity;

public class FeedbackActivity extends HomeActionBarActivity {


    private EditText feedbacket;
    private Button feedbacksubbtn;

    @Override
    protected View addContentView() {

        setActionType(COMM_ACTIONTYPE);
        setTitle(R.string.set_feed);

        View view = View.inflate(getBaseContext(), R.layout.activity_feedback, null);
        initialize(view);

        return view;
    }


    private void initialize(View view) {

        feedbacket = (EditText) view.findViewById(R.id.feedback_et);
        feedbacksubbtn = (Button) view.findViewById(R.id.feedback_sub_btn);
    }
}
